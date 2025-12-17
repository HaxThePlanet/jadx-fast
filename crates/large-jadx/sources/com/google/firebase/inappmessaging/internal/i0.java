package com.google.firebase.inappmessaging.internal;

import i.b.l0.o;

/* loaded from: classes2.dex */
public final class i0 implements o {

    public static final com.google.firebase.inappmessaging.internal.i0 a;
    static {
        i0 i0Var = new i0();
        i0.a = i0Var;
    }

    @Override // i.b.l0.o
    public final boolean test(Object object) {
        return InAppMessageStreamManager.a((InstallationIdResult)object);
    }
}
