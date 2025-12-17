package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class g extends i {

    final int b;
    final String c;
    final String v;
    final int w;
    final o x;
    final com.google.android.play.core.assetpacks.t y;
    g(com.google.android.play.core.assetpacks.t t, o o2, int i3, String string4, String string5, int i6, o o7) {
        this.y = t;
        this.b = i3;
        this.c = string4;
        this.v = string5;
        this.w = i6;
        this.x = o7;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            q qVar = new q(this.y, this.x);
            (i2)t.r(this.y).e().j1(t.t(this.y), t.l(this.b, this.c, this.v, this.w), t.n(), qVar);
            int arr = 0;
            arr = new Object[arr];
            t.q().c(th, "notifyChunkTransferred", arr);
        }
    }
}
