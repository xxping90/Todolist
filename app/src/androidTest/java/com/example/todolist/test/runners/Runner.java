package com.example.todolist.test.runners;

import android.util.Log;

import com.example.todolist.test.testcases.LatestTest;
import com.example.todolist.test.testsuites.LoginSuite;
import com.example.todolist.test.testsuites.ToDoListSuite;

import junit.framework.TestSuite;

/**
 * Created by cc on 2017/1/4.
 */

public class Runner extends CommonRunner {
    @Override
    public TestSuite getAllTests() {
        TestSuite suite = new TestSuite();

        suite.addTest(LoginSuite.getTestSuite());
        suite.addTest(ToDoListSuite.getTestSuite());
        suite.addTestSuite(LatestTest.class);
        if (isNeedRegenerate){
            suite = reGenerateTestSuiteWhenCrash(getCaseNameList(suite));
            Log.i("此处是否执行", "getAllTests: 是否需要重组用例");
        }
        Log.i("isNeedRegenerate",String.valueOf(isNeedRegenerate));
        return suite;
    }
}
