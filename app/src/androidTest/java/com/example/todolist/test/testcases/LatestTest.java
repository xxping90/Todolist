package com.example.todolist.test.testcases;

import android.util.Log;

import com.example.todolist.test.utils.BasicTestCase;

import java.io.File;

/**
 * Created by cc on 2017/1/7.
 */

public class LatestTest extends BasicTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        File file = new File("/sdcard/Robotium/crash.txt");
        if (file.exists())
            //file.delete();
            Log.i("last test", "setUp: 崩溃存在");
    }

    public void testNothing(){

    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
