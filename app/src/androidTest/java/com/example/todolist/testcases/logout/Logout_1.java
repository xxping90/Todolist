package com.example.todolist.testcases.logout;

import com.example.todolist.LoginActivity;
import com.example.todolist.utils.BasicTestCaseWithLogin;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2017/1/4.
 */

public class Logout_1 extends BasicTestCaseWithLogin {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public  void testLogout_1(){
        //模拟按住菜单键
        uiHelper.getSolo().sendKey(Solo.MENU);
        uiHelper.getSolo().sleep(3000);
        uiHelper.getSolo().clickOnText("退出");
        uiHelper.getSolo().clickOnButton("确认");

        assertTrue(uiHelper.getSolo().waitForActivity(LoginActivity.class,3000));

        //断言账号文本框为空
        assertEquals("",uiHelper.getElementsLoginActivity().getNameEditText().getText().toString());

        //断言密码框为空
        assertEquals("",uiHelper.getElementsLoginActivity().getPasswordEditText().getText().toString());


    }
}
