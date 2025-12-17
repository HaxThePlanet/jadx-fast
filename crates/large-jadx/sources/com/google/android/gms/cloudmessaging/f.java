package com.google.android.gms.cloudmessaging;

import android.os.Looper;
import android.os.Message;
import f.c.a.d.b.f.f;

/* loaded from: classes2.dex */
final class f extends f {

    final com.google.android.gms.cloudmessaging.d a;
    f(com.google.android.gms.cloudmessaging.d d, Looper looper2) {
        this.a = d;
        super(looper2);
    }

    @Override // f.c.a.d.b.f.f
    public final void handleMessage(Message message) {
        d.d(this.a, message);
    }
}
