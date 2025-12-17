package com.google.firebase.analytics;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class zza extends ThreadPoolExecutor {
    zza(com.google.firebase.analytics.FirebaseAnalytics firebaseAnalytics, int i2, int i3, long l4, TimeUnit timeUnit5, BlockingQueue blockingQueue6) {
        super(0, 1, 30, obj4, blockingQueue6, obj14);
    }
}
