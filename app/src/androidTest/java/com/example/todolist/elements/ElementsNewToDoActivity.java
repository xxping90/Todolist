package com.example.todolist.elements;

import android.widget.Button;
import android.widget.EditText;

import com.example.todolist.R;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2017/1/1.
 */

public class ElementsNewToDoActivity {

    private Solo solo;
    //待办事项文本框
    private EditText toDoItemDetailET;
    //保存按钮
    private Button saveBtn;

    public  ElementsNewToDoActivity(Solo solo){
        this.solo = solo;
    }
    /**
     * 初始化时，找到所有添加页面的控件
     *
     */
    public  void initViews(){
        solo.sleep(1500);
        //通过id找出控件，赋值给变量
        toDoItemDetailET = (EditText) solo.getCurrentActivity().findViewById(R.id.toDoItemDetailET);
        saveBtn = (Button) solo.getCurrentActivity().findViewById((R.id.saveBtn));
    }

    /**
     * 获得文本
     *
     * @return
     */
    public  EditText getToDoItemDetailET(){
        return toDoItemDetailET;
    }

    /**
     * 单击保存按钮
     */

    public  void clickSaveButton(){
        solo.clickOnView(saveBtn);
    }
    /**
     * 在任务项文本框中输入值
     * @param text
     */
    public  void enterTextToDoItemDetailET(String text){
        solo.enterText(toDoItemDetailET,text);
    }

}
