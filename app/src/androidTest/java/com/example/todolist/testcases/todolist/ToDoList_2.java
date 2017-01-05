package com.example.todolist.testcases.todolist;

import com.example.todolist.utils.BasicTestCaseWithLogin;

/**
 * Created by cc on 2017/1/4.
 */

public class ToDoList_2 extends BasicTestCaseWithLogin {
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testToDoList_2(){
        //点击新建待办事项按钮
        uiHelper.getElementsMainActivity().clickOnActionNewView();

        //在文本框中输入测试方法2
        uiHelper.getElementsNewToDoActivity().enterTextToDoItemDetailET("测试方法2");
        uiHelper.getElementsNewToDoActivity().clickSaveButton();

        //验证添加成功
        assertTrue(uiHelper.getSolo().searchText("测试方法2",true));
        uiHelper.getSolo().clickLongOnText("测试方法2");
        //验证编辑／删除选项存在
        assertTrue(uiHelper.getSolo().searchText("编辑",true));
        assertTrue(uiHelper.getSolo().searchText("删除",true));
    }
}
