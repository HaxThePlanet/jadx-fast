package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.i;
import com.google.android.play.core.internal.i2;
import com.google.android.play.core.internal.t;
import com.google.android.play.core.tasks.o;
import java.util.List;

/* loaded from: classes2.dex */
final class e extends i {

    final List b;
    final o c;
    final com.google.android.play.core.assetpacks.t v;
    e(com.google.android.play.core.assetpacks.t t, o o2, List list3, o o4) {
        this.v = t;
        this.b = list3;
        this.c = o4;
        super(o2);
    }

    @Override // com.google.android.play.core.internal.i
    protected final void a() {
        m mVar = new m(this.v, this.c);
        (i2)t.r(this.v).e().W0(t.t(this.v), t.u(this.b), t.n(), mVar);
    }
}
