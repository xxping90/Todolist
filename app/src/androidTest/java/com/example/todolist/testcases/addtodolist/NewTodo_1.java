package com.example.todolist.testcases.addtodolist;

import com.example.todolist.MainActivity;
import com.example.todolist.utils.BasicTestCaseWithLogin;

/**
 * Created by cc on 2017/1/1.
 */

public class NewTodo_1 extends BasicTestCaseWithLogin {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    public void testNewToDo1(){
        //获得任务列表页面的控件类，调用控件类中已经封装好的单击"添加"按钮
        uiHelper.getElementsMainActivity().clickOnActionNewView();
        //验证字符串出现
        //Robotium waitForText方法的第一个参数是指等待出现的字符串
        //第二个参数是验证第几个字符串，因为页面上可能出现多个同样的字符串，所以要指定第几个
        //第三个参数是指等待最长时间，超过这个时间，如果字符串还是不出现，就不继续等待了
        //第四个参数是指是否要滚动
        //最后一个参数如果是true，则代表指搜索可见的字符串，为false时则包括隐藏字符串
        assertTrue(uiHelper.getSolo().waitForText("输入待办事项",1,5000,false,true));
        //获得新创建的页面的控件类，调用该控件类中已经封装好的单子保存按钮
        uiHelper.getElementsNewToDoActivity().clickSaveButton();
        //searchText用来搜索指定的字符串是否存在，第二个参数与上面提到waitForText的最后一个参数用法一致
        assertTrue(uiHelper.getSolo().searchText("待办事项不能为空！",true));

        uiHelper.getElementsNewToDoActivity().enterTextToDoItemDetailET("测试");
        uiHelper.getElementsNewToDoActivity().clickSaveButton();
        assertTrue(uiHelper.getSolo().waitForActivity(MainActivity.class,3000));
        assertTrue(uiHelper.getSolo().searchText("测试",true));
    }
}
