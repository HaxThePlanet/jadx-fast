package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes2.dex */
class BatteryState {

    static final int VELOCITY_CHARGING = 2;
    static final int VELOCITY_FULL = 3;
    static final int VELOCITY_UNPLUGGED = 1;
    private final Float level;
    private final boolean powerConnected;
    private BatteryState(Float float, boolean z2) {
        super();
        this.powerConnected = z2;
        this.level = float;
    }

    public static com.google.firebase.crashlytics.internal.common.BatteryState get(Context context) {
        int i;
        int powerConnected;
        IntentFilter intentFilter;
        String str;
        Object obj4;
        powerConnected = 0;
        intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        obj4 = context.registerReceiver(0, intentFilter);
        if (obj4 != null) {
            powerConnected = BatteryState.isPowerConnected(obj4);
            i = obj4;
        }
        obj4 = new BatteryState(i, powerConnected);
        return obj4;
    }

    private static Float getLevel(Intent intent) {
        final int i2 = -1;
        int intExtra = intent.getIntExtra("level", i2);
        int obj3 = intent.getIntExtra("scale", i2);
        if (intExtra != i2 && obj3 == i2) {
            if (obj3 == i2) {
            }
            return Float.valueOf(f /= obj3);
        }
        return null;
    }

    private static boolean isPowerConnected(Intent intent) {
        int i;
        int i2;
        int i3 = -1;
        final int obj2 = intent.getIntExtra("status", i3);
        if (obj2 == i3) {
            return 0;
        }
        if (obj2 != 2) {
            if (obj2 == 5) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    public Float getBatteryLevel() {
        return this.level;
    }

    public int getBatteryVelocity() {
        boolean powerConnected;
        if (this.powerConnected) {
            powerConnected = this.level;
            if (powerConnected == null) {
            } else {
                if (Double.compare(d, l) < 0) {
                    return 2;
                }
            }
            return 3;
        }
        return 1;
    }

    boolean isPowerConnected() {
        return this.powerConnected;
    }
}
