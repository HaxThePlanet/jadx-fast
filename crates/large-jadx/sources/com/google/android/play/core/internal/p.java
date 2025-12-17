package com.google.android.play.core.internal;

import android.os.IBinder;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class p extends com.google.android.play.core.internal.i {

    final IBinder b;
    final com.google.android.play.core.internal.s c;
    p(com.google.android.play.core.internal.s s, IBinder iBinder2) {
        this.c = s;
        this.b = iBinder2;
        super();
    }

    @Override // com.google.android.play.core.internal.i
    public final void a() {
        int next;
        com.google.android.play.core.internal.t tVar = sVar.a;
        t.l(tVar, (IInterface)t.g(tVar).a(this.b));
        t.o(sVar2.a);
        t.k(sVar3.a, false);
        Iterator iterator = t.h(sVar4.a).iterator();
        for (Runnable next : iterator) {
            next.run();
        }
        t.h(sVar5.a).clear();
    }
}
