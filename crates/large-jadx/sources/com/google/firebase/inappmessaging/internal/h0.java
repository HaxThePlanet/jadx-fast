package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.c;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class h0 implements n {

    public final c a;
    public h0(c c) {
        super();
        this.a = c;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        final c cVar = this.a;
        InAppMessageStreamManager.e(cVar, (Boolean)object);
        return cVar;
    }
}
