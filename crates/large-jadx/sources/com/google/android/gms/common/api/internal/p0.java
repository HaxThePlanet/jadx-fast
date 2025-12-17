package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.internal.r;
import f.c.a.d.b.e.e;

/* loaded from: classes2.dex */
final class p0 extends e {

    final com.google.android.gms.common.api.internal.j a;
    public p0(com.google.android.gms.common.api.internal.j j, Looper looper2) {
        this.a = j;
        super(looper2);
    }

    @Override // f.c.a.d.b.e.e
    public final void handleMessage(Message message) {
        int i;
        if (message.what == 1) {
        } else {
            i = 0;
        }
        r.a(i);
        this.a.a((j.b)message.obj);
    }
}
