package com.example.todolist.testcases.login;

import com.example.todolist.utils.BasicTestCase;

/**
 * Created by cc on 2016/12/31.
 */

public class DebugTest extends BasicTestCase {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public  void testDebug(){
        //在用户输入框输入账号名
        uiHelper.getElementsLoginActivity().enterName("abcdef");
        //在密码框输入密码
        uiHelper.getElementsLoginActivity().enterPasssword("12345678");

        uiHelper.getSolo().clearEditText(uiHelper.getElementsLoginActivity().getNameEditText());
        String pwdValue = uiHelper.getElementsLoginActivity().getPasswordEditText().getText().toString();

        assertTrue("".equals(pwdValue));

        //
//        assertEquals("",pwdValue);
    }
}
