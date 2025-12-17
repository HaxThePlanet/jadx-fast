package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.k;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class n implements Callable {

    public final k a;
    public n(k k) {
        super();
        this.a = k;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return DisplayCallbacksImpl.l(this.a);
    }
}
