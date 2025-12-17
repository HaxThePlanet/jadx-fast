package com.google.firebase.inappmessaging.display.internal;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* loaded from: classes2.dex */
public class OnSwipeUpListener extends GestureDetector.SimpleOnGestureListener {

    private static final int SWIPE_MAX_OFF_PATH = 250;
    private static final int SWIPE_MIN_DISTANCE = 120;
    private static final int SWIPE_THRESHOLD_VELOCITY = 200;
    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f3, float f4) {
        int obj2;
        int obj3;
        int i2 = 0;
        if (Float.compare(obj4, i) > 0) {
            return i2;
        }
        if (Float.compare(obj2, obj3) > 0 && Float.compare(obj2, obj3) > 0) {
            if (Float.compare(obj2, obj3) > 0) {
                return onSwipeUp();
            }
        }
        return i2;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener
    public boolean onSwipeUp() {
        return 0;
    }
}
