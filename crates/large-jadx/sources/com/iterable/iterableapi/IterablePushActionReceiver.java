package com.iterable.iterableapi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public class IterablePushActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        p0.a(context, intent2);
        p0.b(context);
        if ("com.iterable.push.ACTION_PUSH_ACTION".equalsIgnoreCase(intent2.getAction())) {
            p0.e(context, intent2);
        }
    }
}
