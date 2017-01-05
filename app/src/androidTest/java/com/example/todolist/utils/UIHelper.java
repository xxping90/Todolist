package com.example.todolist.utils;

import com.example.todolist.elements.ElementsEditToDoItemActivity;
import com.example.todolist.elements.ElementsLoginActivity;
import com.example.todolist.elements.ElementsMainActivity;
import com.example.todolist.elements.ElementsNewToDoActivity;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2016/12/31.
 */

public class UIHelper {
    private Solo solo = null;
    private ElementsLoginActivity elementsLoginActivity;
    private ElementsMainActivity elementsMainActivity;
    private ElementsNewToDoActivity elementsNewToDoActivity;
    private ElementsEditToDoItemActivity elementsEditToDoItemActivity;

    public UIHelper(Solo solo){
        this.solo = solo;
    }

    public Solo getSolo(){
        return  solo;
    }

    /**
     * 获取登陆页面控件的方法
     * @return
     */
    public  ElementsLoginActivity getElementsLoginActivity(){
        //控件类对象为空时实例化对象
        if (elementsLoginActivity == null){
            elementsLoginActivity = new ElementsLoginActivity(solo);
        }
        elementsLoginActivity.initViews();
        return  elementsLoginActivity;
    }
    /**
     * 获取任务列表控件类的方法
     * @return
     */
    public  ElementsMainActivity getElementsMainActivity(){
        //控件对象为空时再实例化
        if(elementsMainActivity == null){
            elementsMainActivity = new ElementsMainActivity(solo);
        }
        elementsMainActivity.initViews();
        return elementsMainActivity;
    }

    /**
     * 获取添加任务列表控件类方法
     * @return
     *
     */
    public  ElementsNewToDoActivity getElementsNewToDoActivity(){
        //控件对象为空时再实例化
        if(elementsNewToDoActivity == null){
            elementsNewToDoActivity = new ElementsNewToDoActivity(solo);
        }
        elementsNewToDoActivity.initViews();
        return  elementsNewToDoActivity;
    }

    /**
     * 获取编辑任务列表控件类的方法
     */
    public  ElementsEditToDoItemActivity getElementsEditToDoItemActivity(){
        //控件对象为空时再实例化
        if(elementsEditToDoItemActivity == null){
            elementsEditToDoItemActivity = new ElementsEditToDoItemActivity(solo);
        }
        elementsEditToDoItemActivity.initViews();
        return  elementsEditToDoItemActivity;
    }
}
