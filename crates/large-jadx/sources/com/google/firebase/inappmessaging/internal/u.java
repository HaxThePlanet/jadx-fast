package com.google.firebase.inappmessaging.internal;

import i.b.l0.a;

/* loaded from: classes2.dex */
public final class u implements a {

    public final com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl a;
    public u(com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl displayCallbacksImpl) {
        super();
        this.a = displayCallbacksImpl;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.d();
    }
}
