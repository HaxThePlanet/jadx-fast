package com.google.firebase.inappmessaging.internal;

import i.b.l0.c;

/* loaded from: classes2.dex */
public final class g2 implements c {

    public static final com.google.firebase.inappmessaging.internal.g2 a;
    static {
        g2 g2Var = new g2();
        g2.a = g2Var;
    }

    @Override // i.b.l0.c
    public final Object apply(Object object, Object object2) {
        return InstallationIdResult.create((String)object, (InstallationTokenResult)object2);
    }
}
