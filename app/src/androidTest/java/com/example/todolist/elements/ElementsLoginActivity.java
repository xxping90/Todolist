package com.example.todolist.elements;

import android.transition.Slide;
import android.widget.Button;
import android.widget.EditText;

import com.example.todolist.R;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2016/12/31.
 */

public class ElementsLoginActivity {

    private Solo solo;

    //声明两个变量来存储账号输入框和密码框
    private EditText nameEditText,passwordEditText;
    private Button loginButton;

    public  ElementsLoginActivity(Solo solo){
        this.solo = solo;
    }

    /**
     * 初始化时，找到所有登陆页面的控件
     */
    public  void  initViews(){
        //通过ID找出控件，赋值给变量
        nameEditText = (EditText) solo.getCurrentActivity().findViewById(R.id.nameET);

        passwordEditText = (EditText) solo.getCurrentActivity().findViewById(R.id.passwordET);

        loginButton = (Button) solo.getCurrentActivity().findViewById(R.id.loginBtn);
    }

    /**
     * 获得用户名输入框
     * @return
     */
    public  EditText getNameEditText(){
        return nameEditText;
    }

    /**
     * 获得密码输入框
     * @return
     */

    public EditText getPasswordEditText(){
        return  passwordEditText;
    }

    /**
     * 获得登陆按钮
     * @return
     */
    public  Button getLoginButton(){
        return  loginButton;
    }

    /**
     * 输入用户名
     * @param text
     */

    public  void enterName(String text){
        solo.enterText(nameEditText,text);
    }

    /**
     * 输入密码
     *
     * @param  text
     */

    public  void enterPasssword(String text){
        solo.enterText(passwordEditText,text);
    }

    /**
     * 单机登陆按钮
     *
     */
    public  void clickLoginButton(){
        //通过solo.clickOnView单击你要单击的View
        solo.clickOnView(loginButton);
    }

    /**
     * 调用这个方法只需要传入账号密码的字符串数字即可
     * account[0]存放的时账号信息
     * account[1]存放的时密码信息
     */

    public  void doLogWithAccount(String[] account){
        //调用这个控件类中的enterName方法，传入account[0]，也就是账号信息，实现输入账号动作
        enterName(account[0]);

        //调用这个控件类中的enterPassword方法，传入account[1]，也就是密码信息，实现输入密码动作
        enterPasssword(account[1]);

        clickLoginButton();

        //等待主页出现
        solo.sleep(1500);
    }
}
