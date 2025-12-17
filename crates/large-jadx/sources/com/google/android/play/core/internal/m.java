package com.google.android.play.core.internal;

import android.content.Context;

/* loaded from: classes2.dex */
final class m extends com.google.android.play.core.internal.i {

    final com.google.android.play.core.internal.t b;
    m(com.google.android.play.core.internal.t t) {
        this.b = t;
        super();
    }

    @Override // com.google.android.play.core.internal.i
    public final void a() {
        Object iInterface;
        int i;
        android.content.ServiceConnection service;
        String str;
        if (t.d(this.b) != null) {
            int i2 = 0;
            t.f(this.b).d("Unbind from service.", new Object[i2]);
            t.a(this.b).unbindService(t.b(this.b));
            t.k(this.b, i2);
            i = 0;
            t.l(this.b, i);
            t.j(this.b, i);
        }
        t.m(this.b);
    }
}
