package com.google.android.gms.cloudmessaging;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final com.google.android.gms.cloudmessaging.b a;
    public final Intent b;
    public final Context c;
    public final boolean v;
    public final BroadcastReceiver.PendingResult w;
    public j(com.google.android.gms.cloudmessaging.b b, Intent intent2, Context context3, boolean z4, BroadcastReceiver.PendingResult broadcastReceiver$PendingResult5) {
        super();
        this.a = b;
        this.b = intent2;
        this.c = context3;
        this.v = z4;
        this.w = pendingResult5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.zza(this.b, this.c, this.v, this.w);
    }
}
