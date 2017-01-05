package com.example.todolist.runners;

import android.test.InstrumentationTestRunner;

import com.example.todolist.testsuites.LoginSuite;
import com.example.todolist.testsuites.ToDoListSuite;

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
        return suite;
    }
}
