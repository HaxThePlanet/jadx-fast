package com.google.firebase.inappmessaging.internal;

import i.b.l0.n;

/* loaded from: classes2.dex */
public final class g0 implements n {

    public final com.google.firebase.inappmessaging.internal.InAppMessageStreamManager a;
    public final String b;
    public g0(com.google.firebase.inappmessaging.internal.InAppMessageStreamManager inAppMessageStreamManager, String string2) {
        super();
        this.a = inAppMessageStreamManager;
        this.b = string2;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.i(this.b, (c)object);
    }
}
