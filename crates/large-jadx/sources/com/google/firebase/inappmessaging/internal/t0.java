package com.google.firebase.inappmessaging.internal;

import i.b.l0.n;

/* loaded from: classes2.dex */
public final class t0 implements n {

    public final com.google.firebase.inappmessaging.internal.InAppMessageStreamManager a;
    public t0(com.google.firebase.inappmessaging.internal.InAppMessageStreamManager inAppMessageStreamManager) {
        super();
        this.a = inAppMessageStreamManager;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.x((String)object);
    }
}
