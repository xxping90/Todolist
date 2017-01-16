package com.example.todolist.test.testsuites;

import com.example.todolist.test.testcases.login.CrashTest;
import com.example.todolist.test.testcases.login.Login;
import com.example.todolist.test.testcases.login.Login_2;

import junit.framework.TestSuite;

/**
 * Created by cc on 2017/1/4.
 */

public class LoginSuite {
    public  static TestSuite getTestSuite(){
        TestSuite suite = new TestSuite();

        suite.addTestSuite(Login.class);
        suite.addTestSuite(CrashTest.class);
        suite.addTestSuite(Login_2.class);
        return  suite;

    }
}
