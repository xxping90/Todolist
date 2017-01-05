package com.example.todolist.elements;

import android.widget.Button;
import android.widget.EditText;

import com.example.todolist.R;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2017/1/4.
 */

public class ElementsEditToDoItemActivity {

    private Solo solo;
    //编辑文本框控件
    private EditText editText;
    //保存控件
    private Button  saveBtn;

    public  ElementsEditToDoItemActivity(Solo solo){
        this.solo = solo;
    }

    /**
     * 初始化时，找到所有编辑页面的控件
     */
    public  void  initViews(){
        //通过控件id找出控件，赋值给变量
        editText = (EditText)solo.getCurrentActivity().findViewById(R.id.toDoItemDetailET);
        saveBtn = (Button)solo.getCurrentActivity().findViewById(R.id.saveBtn);
    }

    /**
     * 获得文本框
     * @return
     */
    public EditText getToDoItemDetailET(){
        return  editText;
    }

    /**
     * 单击保存
     */
    public  void clickSaveButton(){
        solo.clickOnView(saveBtn);
    }
    /**
     * 在任务项文本框中输入值
     * @param text
     */
    public void enterTextToDoItemDetailET(String text){
        solo.enterText(editText,text);
    }
    /**
     * 清空文本框中的内容
     */
    public void clearToDoItemDetailET(){
        solo.clearEditText(editText);
    }
}
