package com.example.todolist.testsuites;

import com.example.todolist.testcases.todolist.ToDoList_1;
import com.example.todolist.testcases.todolist.ToDoList_2;

import junit.framework.TestSuite;

/**
 * Created by cc on 2017/1/4.
 */

public class ToDoListSuite {

    public static  TestSuite getTestSuite(){
        TestSuite suite = new TestSuite();
        suite.addTestSuite(ToDoList_1.class);
        suite.addTestSuite(ToDoList_2.class);
        return suite;
    }
}
