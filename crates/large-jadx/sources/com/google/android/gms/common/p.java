package com.google.android.gms.common;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import f.c.a.d.b.e.e;

/* loaded from: classes2.dex */
final class p extends e {

    private final Context a;
    final com.google.android.gms.common.e b;
    public p(com.google.android.gms.common.e e, Context context2) {
        Looper obj1;
        this.b = e;
        if (Looper.myLooper() == null) {
            obj1 = Looper.getMainLooper();
        } else {
            obj1 = Looper.myLooper();
        }
        super(obj1);
        this.a = context2.getApplicationContext();
    }

    @Override // f.c.a.d.b.e.e
    public final void handleMessage(Message message) {
        boolean z;
        Context context;
        int obj3 = message.what;
        if (obj3 != 1) {
            StringBuilder stringBuilder = new StringBuilder(50);
            stringBuilder.append("Don't know how to handle this message: ");
            stringBuilder.append(obj3);
            Log.w("GoogleApiAvailability", stringBuilder.toString());
        }
        obj3 = this.b.g(this.a);
        if (this.b.j(obj3)) {
            this.b.q(this.a, obj3);
        }
    }
}
