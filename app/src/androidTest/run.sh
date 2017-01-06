#!/bin/sh
testautoRootPath=/sdcard/Robotium
junitReportPath=$testautoRootPath/report


echo “uninstall APK and TestAPK”
adb uninstall com.example.todolist
adb uninstall com.example.todolist.tests

echo “install APK and TestAPK”
adb install app/build/outputs/apk/app-release-unsigned.apk
adb install app/build/outputs/apk/app-debug-androidTest.apk

echo “start to run test”

adb shell am instrument -w -e reportDir $junitReportPath  -e reportFile test-report.xml com.example.todolist.tests/com.example.todolist.runners.Runner

echo  “pull junit report”

adb pull junitReportPath/test-report.xml  $WORKSPACE
