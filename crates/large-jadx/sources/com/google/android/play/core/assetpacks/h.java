package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class h extends i {

    final int b;
    final String c;
    final o v;
    final int w;
    final com.google.android.play.core.assetpacks.t x;
    h(com.google.android.play.core.assetpacks.t t, o o2, int i3, String string4, o o5, int i6) {
        this.x = t;
        this.b = i3;
        this.c = string4;
        this.v = o5;
        this.w = i6;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            super(this.x, this.v, this.b, this.c, this.w);
            (i2)t.r(this.x).e().k2(t.t(this.x), t.m(this.b, this.c), t.n(), rVar2);
            int arr = 0;
            arr = new Object[arr];
            t.q().c(th, "notifyModuleCompleted", arr);
        }
    }
}
