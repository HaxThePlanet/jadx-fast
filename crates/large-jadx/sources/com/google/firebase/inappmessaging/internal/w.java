package com.google.firebase.inappmessaging.internal;

import com.google.firebase.inappmessaging.model.Action;
import i.b.l0.a;

/* loaded from: classes2.dex */
public final class w implements a {

    public final com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl a;
    public final Action b;
    public w(com.google.firebase.inappmessaging.internal.DisplayCallbacksImpl displayCallbacksImpl, Action action2) {
        super();
        this.a = displayCallbacksImpl;
        this.b = action2;
    }

    @Override // i.b.l0.a
    public final void run() {
        this.a.f(this.b);
    }
}
