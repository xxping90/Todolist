#!/bin/sh
testautoRootPath=/sdcard/Robotium
junitReportPath=$testautoRootPath/report


#删除sdcard 上错误截图、junit报告、记录crash的文件，避免对本次运行的干扰
echo "delete all screenshots in sdcard"
adb -s $1 shell rm -rf /sdcard/Robotium-Screenshots/*

#下面启动自动化测试用例时必须指定reportDir 为$junitReportPath
adb -s $1 shell rm -rf $junitReportPath/*

#在源码实现的crash.txt路径必须指定为/sdcard/Robotium/crash.txt
adb -s $1 shell rm -rf $testautoRootPath/crash.txt

#安装源码和测试APK
echo "uninstall APK and TestAPK"
adb -s $1 uninstall com.example.todolist
adb -s $1 uninstall com.example.todolist.tests

echo "install APK and TestAPK"
adb -s $1 install app/build/outputs/apk/app-debug.apk
adb -s $1 install app/build/outputs/apk/app-debug-androidTest.apk

#开始运行自动化测试用例
#在这里加入crash处理机制
#设置一个变量loop，初始值为true,每次结束循环体都会检测sdcard指定的目录下有无crash.txt,没有就把loop的值设置为false，终止循环
echo "start to run test"
loop=true
#设置一个变量用例表明是否需要重新组织测试用例集
#如果发生crash，就把这个值设置为true，重新组织测试用例集，去掉已经运行的case列表
regenerateTestsuite=false
#下面的变量用来统计crash发生的次数，并且用于命名crash报告，确保报告名唯一
crashCount=0
#开始循环体内容，因为loop的初始值为true，所以第一次肯定进入循环体
while [ $loop == "true" ]
do
#指定junit产生的路径为$junitReportPath ,并指定报告的名称为"junit-report_"+crashCount+".xml"
#通过-e 添加一个键为regenerateTestsuite,值为$regenerateTestsuite  ,标识是否重新组织测试用例集合
#第一次regenerateTestsuite的值为false，如果crash发生了，就需要把这个值赋值为true，下次循环时这个值就是true了。需要组织测试用例
    adb -s $1 shell am instrument -w -e reportDir $junitReportPath  -e reportFile junit-report_${crashCount}.xml  -e regenerateTestsuite $regenerateTestsuite com.example.todolist.tests/com.example.todolist.test.runners.Runner
#执行完一次之后。先把junit包报告pull到jenkins workspace之下
#同时把crash.txt文件pull到workplace之下
    echo  "pull junit report"

    adb -s $1 pull $junitReportPath/junit-report_${crashCount}.xml  $WORKSPACE/junit-report_${crashCount}.xml
    adb -s $1 pull $testautoRootPath/crash.txt    $WORKSPACE
#现在判断workspace地下是否有没有crash.txt文件
#有的话，说明发生了crash，需要把regenerateTestsuite的值赋值为true，重新组织用例，排除已经运行的用例
#并把crashCount的值加1，代表发生的crash数
#把crash.txt的内容追加到totalCrash.txt,便于统计所有的crash用例
#并删除workspace 下的crash.txt，避免干扰后面产生的文件
#如果进入else则没有crash发生，把loop值设置为false，终止循环体执行
    if [ -f $WORKSPACE/crash.txt ];then
        echo "crash happen"
        /bin/cat $WORKSPACE/crash.txt >> totalCrash.txt
        /bin/rm -f $WORKSPACE/crash.txt
        regenerateTestsuite=true
        ((crashCount=$crashCount+1))
    else
        loop=false
    fi
done

echo "pull Screenshots"
adb -s $1 pull /sdcard/Robotium-Screenshots/  $WORKSPACE/

echo "merge xml files"
#java -jar todolist/merger.jar

java -jar app/src/androidTest/merger.jar