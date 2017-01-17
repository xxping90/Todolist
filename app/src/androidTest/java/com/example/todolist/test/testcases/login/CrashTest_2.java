package com.example.todolist.test.testcases.login;

import com.example.todolist.test.utils.BasicTestCaseWithLogin;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2017/1/16.
 */

public class CrashTest_2 extends BasicTestCaseWithLogin {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    public  void testCrash_2(){
        uiHelper.getSolo().sendKey(Solo.MENU);
        uiHelper.getSolo().clickOnText("点击崩溃1");

        //assertTrue("新建待办事项的按钮不存在！",uiHelper.getElementsMainActivity().getActionNewView().isShown());
    }
}
