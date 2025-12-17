package com.google.firebase.inappmessaging.internal;

import i.b.l0.f;

/* loaded from: classes2.dex */
public final class q implements f {

    public static final com.google.firebase.inappmessaging.internal.q a;
    static {
        q qVar = new q();
        q.a = qVar;
    }

    @Override // i.b.l0.f
    public final void accept(Object object) {
        DisplayCallbacksImpl.i((Throwable)object);
    }
}
