package com.example.todolist.test.runners;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.zutubi.android.junitreport.JUnitReportTestRunner;

import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cc on 2017/1/4.
 */

public class CommonRunner extends JUnitReportTestRunner {

    //命令行传来的键值
    private static final  String REGENERATE_TESTSUITE = "regenerateTestsuite";
    //供自定义的Runner调用，用于判断是否需要过滤部分的用例
    boolean isNeedRegenerate = false;

    @Override
    public void onCreate(Bundle arguments) {
        String regenerate = arguments.getString(REGENERATE_TESTSUITE);
        //如果命令行传过来的值为真，则表示发生了crash，需要过滤掉已经运行过的//用例集，所有的isNeedRegenerate赋值为true
        if ("true".equals(regenerate)){
            isNeedRegenerate = true;
        }else {
            //反之赋值为false
            isNeedRegenerate = false;
        }
        super.onCreate(arguments);
    }

    /**
     * 获得发生crash的用例名
     * @return
     */
    private String getCrashCaseName(){
        String caseName = "";
        FileReader crashFileReader = null;
        File logPath = new File(Environment.getExternalStorageDirectory()+"/"+"Robotium"+"/"+"crash.txt");
        try{
            crashFileReader = new FileReader(logPath);
            BufferedReader br = new BufferedReader(crashFileReader);
            caseName = br.readLine();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                crashFileReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        Log.e("获取崩溃名", caseName);
        return caseName;
    }

    /**
     * 用于获取当前Runner的所有用例名的方法
     * @param
     * @return
     */
    public  static List<String> getCaseNameList(TestSuite testSuite){
        List<String> caseNameList = new ArrayList<String>();
        for (int i=0;i<testSuite.testCount();i++){
            for (int j = 0;j<((TestSuite)testSuite.testAt(i)).testCount();j++){
                caseNameList.add(((TestSuite)testSuite.testAt(i)).testAt(j).toString());
            }
        }

        caseNameList.add("com.example.todolist.test.testcases.LatestTest");

        return caseNameList;
    }

    /**
     * 获取还未运行过的用例集
     * @param caseNameList
     * @return
     */
    public TestSuite reGenerateTestSuiteWhenCrash(List<String>caseNameList){
        TestSuite testSuite = new TestSuite();
        String crashCaseName = getCrashCaseName();
        boolean startAddCaseFlag = false;
        for (String name : caseNameList){
            if (name.contains(crashCaseName)){
                startAddCaseFlag = true;
                Log.e("崩溃存在", crashCaseName);
                continue;
            }
            if (startAddCaseFlag){
                try {
                    testSuite.addTestSuite((Class<?extends junit.framework.TestCase>)Class.forName(name));
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
            }
        }
        return testSuite;
    }
}
