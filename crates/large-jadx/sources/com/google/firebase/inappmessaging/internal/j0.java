package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.c;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class j0 implements n {

    public final c a;
    public j0(c c) {
        super();
        this.a = c;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        final c cVar = this.a;
        InAppMessageStreamManager.I(cVar, (Boolean)object);
        return cVar;
    }
}
