package com.example.todolist.testcases.login;

import com.example.todolist.utils.BasicTestCase;

/**
 * Created by cc on 2016/12/31.
 */

public class Login extends BasicTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public  void testLogin(){
        //在用户输入框输入账号名
        uiHelper.getElementsLoginActivity().enterName("abcdef");
        //在密码框输入密码
        uiHelper.getElementsLoginActivity().enterPasssword("12345678");
        //单击登陆按钮
        uiHelper.getElementsLoginActivity().clickLoginButton();

        //第一个参数是在验证失败的情况下，要显示的提示字符串
        //第二个参数是要用来断言的表达式
        assertTrue("错误提示信息没有出现，可能出现bug。",uiHelper.getSolo().searchText("用户名或者密码错误！",true));
    }
}
