package com.google.android.gms.common.internal;

import android.os.Bundle;
import com.google.android.gms.common.b;

/* loaded from: classes2.dex */
abstract class u0 extends com.google.android.gms.common.internal.g1<Boolean> {

    public final int d;
    public final Bundle e;
    final com.google.android.gms.common.internal.c f;
    protected u0(com.google.android.gms.common.internal.c c, int i2, Bundle bundle3) {
        this.f = c;
        super(c, Boolean.TRUE);
        this.d = i2;
        this.e = bundle3;
    }

    @Override // com.google.android.gms.common.internal.g1
    protected final void a() {
    }

    @Override // com.google.android.gms.common.internal.g1
    protected final void b(Object object) {
        int str;
        int i;
        b obj3;
        str = 1;
        i = 0;
        if (this.d == 0) {
            if (!f()) {
                c.zzi(this.f, str, i);
                obj3 = new b(8, i);
                g(obj3);
            }
        } else {
        }
    }

    @Override // com.google.android.gms.common.internal.g1
    protected abstract boolean f();

    @Override // com.google.android.gms.common.internal.g1
    protected abstract void g(b b);
}
