package com.example.todolist.testcases.edittodolist;

import com.example.todolist.EditToDoItemActivity;
import com.example.todolist.MainActivity;
import com.example.todolist.utils.BasicTestCaseWithLogin;

/**
 * Created by cc on 2017/1/4.
 */

public class EditDoListItem_1 extends BasicTestCaseWithLogin {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testEditDoListItem_1(){
        uiHelper.getElementsMainActivity().clickOnActionNewView();
        uiHelper.getElementsNewToDoActivity().enterTextToDoItemDetailET("测试编辑");
        uiHelper.getElementsNewToDoActivity().clickSaveButton();
        assertTrue(uiHelper.getSolo().waitForText("测试编辑",1,2000,false,true));
        uiHelper.getSolo().clickLongOnText("测试编辑");
        uiHelper.getSolo().clickOnText("编辑");
        //验证编辑页面打开
        assertTrue(uiHelper.getSolo().waitForActivity(EditToDoItemActivity.class,3000));
        assertEquals("测试编辑",uiHelper.getElementsEditToDoItemActivity().getToDoItemDetailET().getText().toString());
        //清空文本框中的数据
        uiHelper.getElementsEditToDoItemActivity().clearToDoItemDetailET();

        uiHelper.getElementsEditToDoItemActivity().enterTextToDoItemDetailET("更新内容");
        uiHelper.getElementsEditToDoItemActivity().clickSaveButton();

        //验证回到任务列表页面
        assertTrue(uiHelper.getSolo().waitForActivity(MainActivity.class,3000));
        //验证文本被成功更新
        assertTrue(uiHelper.getSolo().searchText("更新内容",true));
    }
}
