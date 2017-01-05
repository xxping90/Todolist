package com.example.todolist.elements;

import android.view.View;

import com.example.todolist.R;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2016/12/31.
 */

public class ElementsMainActivity {

    private Solo solo;
    private View actionNewView;

    public ElementsMainActivity(Solo solo){
        this.solo = solo;
    }
    /**
     * 初始化时，找到所有登陆页面的控件
     */
    public  void initViews(){
        //通过控件id找出控件，赋值给变量
        actionNewView = (View) solo.getCurrentActivity().findViewById(R.id.action_new);
    }
    public  View getActionNewView(){
        return actionNewView;
    }
    public void clickOnActionNewView(){
        solo.clickOnView(actionNewView);
    }
}
