package com.google.firebase.inappmessaging.internal;

import i.b.l0.o;

/* loaded from: classes2.dex */
public final class f0 implements o {

    public final com.google.firebase.inappmessaging.internal.InAppMessageStreamManager a;
    public f0(com.google.firebase.inappmessaging.internal.InAppMessageStreamManager inAppMessageStreamManager) {
        super();
        this.a = inAppMessageStreamManager;
    }

    @Override // i.b.l0.o
    public final boolean test(Object object) {
        return this.a.K((c)object);
    }
}
