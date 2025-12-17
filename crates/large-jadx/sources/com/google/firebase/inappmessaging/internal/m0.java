package com.google.firebase.inappmessaging.internal;

import i.b.l0.n;

/* loaded from: classes2.dex */
public final class m0 implements n {

    public final com.google.firebase.inappmessaging.internal.InAppMessageStreamManager a;
    public final String b;
    public final n c;
    public final n v;
    public final n w;
    public m0(com.google.firebase.inappmessaging.internal.InAppMessageStreamManager inAppMessageStreamManager, String string2, n n3, n n4, n n5) {
        super();
        this.a = inAppMessageStreamManager;
        this.b = string2;
        this.c = n3;
        this.v = n4;
        this.w = n5;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return this.a.l(this.b, this.c, this.v, this.w, (e)object);
    }
}
