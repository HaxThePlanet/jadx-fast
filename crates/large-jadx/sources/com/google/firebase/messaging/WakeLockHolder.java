package com.google.firebase.messaging;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import f.c.a.d.f.a;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class WakeLockHolder {

    private static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS;
    private static final Object syncObject;
    private static a wakeLock;
    static {
        WakeLockHolder.WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
        Object object = new Object();
        WakeLockHolder.syncObject = object;
    }

    private static void checkAndInitWakeLock(Context context) {
        a wakeLock;
        int i;
        String str;
        if (WakeLockHolder.wakeLock == null) {
            i = 1;
            wakeLock = new a(context, i, "wake:com.google.firebase.iid.WakeLockHolder");
            WakeLockHolder.wakeLock = wakeLock;
            wakeLock.c(i);
        }
    }

    static void completeWakefulIntent(Intent intent) {
        a wakefulIntent;
        Object obj2;
        final Object syncObject = WakeLockHolder.syncObject;
        synchronized (syncObject) {
            if (WakeLockHolder.isWakefulIntent(intent)) {
                WakeLockHolder.setAsWakefulIntent(intent, false);
                WakeLockHolder.wakeLock.b();
            }
            try {
                throw intent;
            }
        }
    }

    static boolean isWakefulIntent(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    private static void setAsWakefulIntent(Intent intent, boolean z2) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z2);
    }

    static ComponentName startWakefulService(Context context, Intent intent2) {
        boolean wAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS;
        Object obj4;
        final Object syncObject = WakeLockHolder.syncObject;
        WakeLockHolder.checkAndInitWakeLock(context);
        final int i = 1;
        WakeLockHolder.setAsWakefulIntent(intent2, i);
        ComponentName obj3 = context.startService(intent2);
        synchronized (syncObject) {
            return null;
        }
    }
}
