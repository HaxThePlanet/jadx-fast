package com.google.firebase.inappmessaging.internal.injection.modules;

import f.c.a.b.e;

/* loaded from: classes2.dex */
public final class c implements e {

    public static final com.google.firebase.inappmessaging.internal.injection.modules.c a;
    static {
        c cVar = new c();
        c.a = cVar;
    }

    @Override // f.c.a.b.e
    public final Object apply(Object object) {
        TransportClientModule.a((byte[])object);
        return object;
    }
}
