package com.example.todolist;

import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

/**
 * Created by cc on 2016/12/30.
 */

public class TodolistTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public TodolistTest() {
        //LoginActivity是指指定启动Activity名称
        super(LoginActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //初始化solo
        solo = new Solo(getInstrumentation(),getActivity());
    }
    public void testTodolistTest(){
        //在用户名文本中输入abcdef
        solo.enterText(0,"abcdef");
        //在密码文本中输入123456
        solo.enterText(1,"123456");
        //单机登陆按钮
        solo.clickOnButton(0);
        //第一个参数是指如果失败，要显示的提示字符串
        //第二个参数是指要用来断言的表达式
        assertTrue("错误提示信息没有出现，可能出现bug",solo.searchText("用户名或者密码错误！",true));

    }
    @Override
    protected void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }


}
