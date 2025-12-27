package com.iterable.iterableapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* compiled from: IterablePushActionReceiver.java */
/* loaded from: classes2.dex */
public class IterablePushActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        p0.a(context, intent);
        p0.b(context);
        if ("com.iterable.push.ACTION_PUSH_ACTION".equalsIgnoreCase(intent.getAction())) {
            p0.e(context, intent);
        }
    }
}
