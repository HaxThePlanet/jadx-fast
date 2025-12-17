package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;

/* loaded from: classes2.dex */
final class k extends i {

    final o b;
    final com.google.android.play.core.assetpacks.t c;
    k(com.google.android.play.core.assetpacks.t t, o o2, o o3) {
        this.c = t;
        this.b = o3;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        try {
            p pVar = new p(this.c, this.b);
            (i2)t.s(this.c).e().L1(t.t(this.c), t.n(), pVar);
            int arr = 0;
            arr = new Object[arr];
            t.q().c(th, "keepAlive", arr);
        }
    }
}
