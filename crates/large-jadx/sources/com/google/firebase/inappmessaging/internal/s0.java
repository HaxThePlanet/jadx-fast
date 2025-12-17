package com.google.firebase.inappmessaging.internal;

import i.b.l;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class s0 implements n {

    public final com.google.firebase.inappmessaging.internal.InAppMessageStreamManager a;
    public final l b;
    public s0(com.google.firebase.inappmessaging.internal.InAppMessageStreamManager inAppMessageStreamManager, l l2) {
        super();
        this.a = inAppMessageStreamManager;
        this.b = l2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.v(this.b, (b)object);
    }
}
