package com.google.firebase.inappmessaging.internal;

import f.c.f.a.a.a.e.b;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class x0 implements n {

    public final com.google.firebase.inappmessaging.internal.InAppMessageStreamManager a;
    public final b b;
    public x0(com.google.firebase.inappmessaging.internal.InAppMessageStreamManager inAppMessageStreamManager, b b2) {
        super();
        this.a = inAppMessageStreamManager;
        this.b = b2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.o(this.b, (InstallationIdResult)object);
    }
}
