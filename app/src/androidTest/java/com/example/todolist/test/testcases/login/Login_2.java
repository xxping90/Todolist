package com.example.todolist.test.testcases.login;

import com.example.todolist.MainActivity;
import com.example.todolist.test.utils.BasicTestCase;
import com.example.todolist.test.utils.BasicTestCaseWithLogin;

/**
 * Created by cc on 2016/12/31.
 */

public class Login_2 extends BasicTestCaseWithLogin {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testLogin2(){
        //通过统一对象uiHelper得到登录页面的控制类
        //通过控制类调用单击登录按钮的方法
        //uiHelper.getElementsLoginActivity().clickLoginButton();
        //添加让这个用例crash
        //android.os.Process.killProcess(android.os.Process.myPid());

        //验证待办的按钮是否存在，如果不存在，就给出错误提示"新建的待办事项不存在！"
        //assertTrue("新建待办事项的按钮不存在！",uiHelper.getElementsMainActivity().getActionNewView().isShown());
        assertTrue(uiHelper.getSolo().waitForActivity(MainActivity.class,3000));
    }
}
