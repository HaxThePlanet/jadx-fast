package com.google.firebase.inappmessaging.internal;

import i.b.l0.o;

/* loaded from: classes2.dex */
public final class p0 implements o {

    public final String a;
    public p0(String string) {
        super();
        this.a = string;
    }

    @Override // i.b.l0.o
    public final boolean test(Object object) {
        return InAppMessageStreamManager.L(this.a, (c)object);
    }
}
