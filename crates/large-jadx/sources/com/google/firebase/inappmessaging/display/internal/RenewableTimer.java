package com.google.firebase.inappmessaging.display.internal;

import android.os.CountDownTimer;

/* loaded from: classes2.dex */
public class RenewableTimer {

    private CountDownTimer mCountDownTimer;

    public interface Callback {
        public abstract void onFinish();
    }
    public void cancel() {
        CountDownTimer mCountDownTimer;
        mCountDownTimer = this.mCountDownTimer;
        if (mCountDownTimer != null) {
            mCountDownTimer.cancel();
            this.mCountDownTimer = 0;
        }
    }

    public void start(com.google.firebase.inappmessaging.display.internal.RenewableTimer.Callback renewableTimer$Callback, long l2, long l3) {
        super(this, l2, obj3, obj12, obj5, callback);
        this.mCountDownTimer = anon.start();
    }
}
