package com.example.todolist.testcases.login;

import com.example.todolist.utils.BasicTestCase;
import com.example.todolist.utils.BasicTestCaseWithLogin;

/**
 * Created by cc on 2016/12/31.
 */

public class Login_2 extends BasicTestCaseWithLogin {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLogin2(){
        //验证待办的按钮是否存在，如果不存在，就给出错误提示"新建的待办事项不存在！"
        assertTrue("新建待办事项的按钮不存在！",uiHelper.getElementsMainActivity().getActionNewView().isShown());
    }
}
