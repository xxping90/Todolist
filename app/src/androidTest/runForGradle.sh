#!/bin/sh
echo “uninstall APK and TestAPK”
adb uninstall com.example.todolist
adb uninstall com.example.todolist.tests

echo “install APK and TestAPK”
adb install /Users/cc/wlp/git/android/todolist/app/build/outputs/apk/app-debug.apk
adb install /Users/cc/wlp/git/android/todolist/app/build/outputs/apk/app-debug-androidTest.apk

echo “start to run test”

adb shell am instrument -w -e reportDir /sdcard/Robotium/report/  -e reportFile test-report.xml com.example.todolist.tests/com.example.todolist.runners.Runner

echo  “pull junit report”

adb pull /sdcard/Robotium/report/test-report.xml  /Users/cc/wlp/report