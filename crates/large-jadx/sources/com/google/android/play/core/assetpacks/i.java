package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class i extends i {

    final int b;
    final o c;
    final com.google.android.play.core.assetpacks.t v;
    i(com.google.android.play.core.assetpacks.t t, o o2, int i3, o o4) {
        this.v = t;
        this.b = i3;
        this.c = o4;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            s sVar = new s(this.v, this.c);
            (i2)t.r(this.v).e().P1(t.t(this.v), t.p(this.b), t.n(), sVar);
            int arr = 0;
            arr = new Object[arr];
            t.q().c(th, "notifySessionFailed", arr);
        }
    }
}
