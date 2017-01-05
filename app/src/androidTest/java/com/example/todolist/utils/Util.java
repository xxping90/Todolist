package com.example.todolist.utils;

import android.app.Instrumentation;
import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.test.InstrumentationTestCase;
import android.util.Log;

/**
 * Created by cc on 2016/12/31.
 */

public class Util {

    /**
     * 唤醒设备的方法
     * @param owner
     * @return
     */
    public  static WakeLock wakeScreen(InstrumentationTestCase owner){
        PowerManager pm = (PowerManager) owner.getInstrumentation().getTargetContext().getSystemService(Context.POWER_SERVICE);
        WakeLock wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK
        | PowerManager.FULL_WAKE_LOCK
        | PowerManager.ACQUIRE_CAUSES_WAKEUP,owner.getClass()
        .getSimpleName());
        wakeLock.acquire();
        return wakeLock;


    }
    /**
     * 解锁的方法
     * @param instr
     */
    public  static void unlock(Instrumentation instr){
        try{
            Context targetContext = instr.getTargetContext();
            KeyguardManager keyguardManager = (KeyguardManager) targetContext
                    .getSystemService(Context.KEYGUARD_SERVICE);
            KeyguardManager.KeyguardLock  mlock = keyguardManager.newKeyguardLock("");
            mlock.disableKeyguard();
        }catch (Throwable e){
            Log.e("Test","unlock fail",e);
        }

    }
}
