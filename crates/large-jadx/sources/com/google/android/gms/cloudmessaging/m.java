package com.google.android.gms.cloudmessaging;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class m implements Runnable {

    public final com.google.android.gms.cloudmessaging.r a;
    public m(com.google.android.gms.cloudmessaging.r r) {
        super();
        this.a = r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object th;
        int i;
        String str2;
        boolean loggable;
        Bundle bundle;
        int string;
        Message obtain;
        int stringBuilder;
        Object str;
        boolean z;
        final com.google.android.gms.cloudmessaging.r rVar = this.a;
        synchronized (rVar) {
        }
        String valueOf = String.valueOf(poll);
        stringBuilder = new StringBuilder(length += 8);
        stringBuilder.append("Sending ");
        stringBuilder.append(valueOf);
        Log.d("MessengerIpcClient", stringBuilder.toString());
        obtain = Message.obtain();
        obtain.what = poll.c;
        obtain.arg1 = poll.a;
        obtain.replyTo = rVar.b;
        bundle = new Bundle();
        bundle.putBoolean("oneWay", poll.b());
        bundle.putString("pkg", w.a(rVar.x).getPackageName());
        bundle.putBundle("data", poll.d);
        obtain.setData(bundle);
        rVar.c.a(obtain);
    }
}
