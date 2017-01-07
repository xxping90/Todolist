#!/bin/sh
testautoRootPath=/sdcard/Robotium
junitReportPath=$testautoRootPath/report

echo "delete all screenshots in sdcard"
adb -s $1 shell rm -rf /sdcard/Robotium-Screenshots/*

echo “uninstall APK and TestAPK”
adb -s $1 uninstall com.example.todolist
adb -s $1 uninstall com.example.todolist.tests

echo “install APK and TestAPK”
adb -s $1 install app/build/outputs/apk/app-debug.apk
adb -s $1 install app/build/outputs/apk/app-debug-androidTest.apk

echo “start to run test”

adb -s $1 shell am instrument -w -e reportDir $junitReportPath  -e reportFile test-report.xml com.example.todolist.tests/com.example.todolist.test.runners.Runner

echo  “pull junit report”

adb -s $1 pull $junitReportPath/test-report.xml  $WORKSPACE

adb -s $1 pull /sdcard/Robotium-Screenshots/  $WORKSPACE/