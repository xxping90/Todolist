package com.example.todolist.utils;

/**
 * Created by cc on 2016/12/31.
 */

public class BasicTestCaseWithLogin extends BasicTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //因为用户名时1，密码是1，所以构造账号密码字符串数组new String[]{"1","1"}
        uiHelper.getElementsLoginActivity().doLogWithAccount(new String[]{"1","1"});
    }
}
