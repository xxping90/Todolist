package com.example.todolist.testcases.todolist;

import com.example.todolist.MainActivity;
import com.example.todolist.utils.BasicTestCaseWithLogin;

/**
 * Created by cc on 2017/1/4.
 */

public class ToDoList_1 extends BasicTestCaseWithLogin {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public  void testTodoList_1(){
        //获得任务列表页面的控件类，调用该控件类中已经封装好的"单击添加"按钮
        uiHelper.getElementsMainActivity().clickOnActionNewView();
        //获得任务列表页面的控件类，调用该控件类中已经封装好的输入任务项的方法和单击保存按钮方法
        uiHelper.getElementsNewToDoActivity().enterTextToDoItemDetailET("addTest");
        uiHelper.getElementsNewToDoActivity().clickSaveButton();
        //waitiForActivity,等待具体的activity出现，等到了就返回true，否则返回false
        assertTrue(uiHelper.getSolo().waitForActivity(MainActivity.class,3000));
        assertTrue(uiHelper.getSolo().searchText("addTest",true));
        /**
         * 删除测试数据
         */
        //clickLongText
        uiHelper.getSolo().clickLongOnText("addTest");
        //clickOnText单击文本
        uiHelper.getSolo().clickOnText("删除");
        //clickOnButton 单击指定文本按钮
        uiHelper.getSolo().clickOnButton("确认");

    }
}
