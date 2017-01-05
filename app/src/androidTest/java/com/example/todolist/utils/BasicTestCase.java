package com.example.todolist.utils;

import android.os.PowerManager;
import android.test.ActivityInstrumentationTestCase2;

import com.example.todolist.LoginActivity;
import com.robotium.solo.Solo;

/**
 * Created by cc on 2016/12/31.
 */

public class BasicTestCase extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    private PowerManager.WakeLock wakeScreenObject = null;

    //声明统一入口类的对象
    protected UIHelper uiHelper = null;
    public BasicTestCase(){
        super(LoginActivity.class);
    }

    /**
     * 复写setup，进行异常捕获，截图处理
     * @throws exception
     */
    @Override
    protected void setUp() throws Exception {
        try{
            super.setUp();
            init();
        }catch (Throwable tr){
            throw new SetUpException(tr);
        }

    }

    /**
     * 复写runTest,进行异常捕获，截图处理
     * @throws Throwable
     */
    @Override
    protected void runTest() throws Throwable {
        try{
            super.runTest();
        }catch (junit.framework.AssertionFailedError afe){
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw  afe;
        }catch (Throwable e){
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw new RunTestException(e);
        }

    }

    /**
     * 复写tearDown,进行异常捕获，截图处理
     * @throws Exception
     */
    @Override
    protected void tearDown() throws Exception {
        try {
            if(wakeScreenObject != null){
                wakeScreenObject.release();
                wakeScreenObject = null;
            }
            super.tearDown();
        }catch (Throwable th){
            solo.takeScreenshot(this.getClass().getSimpleName());
            throw new TearDownException(th);
        }finally {
            solo.finishOpenedActivities();
        }
    }

    @Override
    public void runBare() throws Throwable {
        try {
            super.runBare();
        }catch (SetUpException smte){
            solo.takeScreenshot(this.getClass().getSimpleName());
            this.tearDown();
            throw  smte;
        }
    }

    /**
     * 只有setUp没有包含在异常处理中，重写runBare,把异常加进去
     * @throws  Throwable
     */


    private void init(){
        solo = new Solo(getInstrumentation(),getActivity());
        //实例化uihelper
        uiHelper = new UIHelper(solo);
        //唤醒设备
        if(wakeScreenObject == null){
            wakeScreenObject = Util.wakeScreen(this);
        }
        //解锁
        Util.unlock(getInstrumentation());
        //连接网络
        NetworkUtil.setAirplaneModeOffAndNetworkOn(getInstrumentation().getTargetContext());
    }

}

/**
 * 3个自定义的异常类，分别对应setup时发生的异常，runTest发生时的异常和tearDown发生时的异常
 * @author xpp
 */

class  SetUpException extends Exception{
    private  static  final  long serialVersionUID = 1L;

    SetUpException(Throwable e){
        super("Error in BasicTestCase.setUp()!",e);
    }
}
class  RunTestException extends Exception{
    private  static  final  long serialVersionUID = 2L;

    RunTestException(Throwable e){
        super("Error in BasicTestCase.runTest()!",e);
    }
}

class TearDownException extends Exception{
    private  static  final  long serialVersionUID = 3L;

    TearDownException(Throwable e){
        super("Error in BasicTestCase.tearDown()",e);
    }
}