package com.google.firebase.inappmessaging.internal;

import com.google.android.gms.tasks.k;
import i.b.l0.n;

/* loaded from: classes2.dex */
public final class p implements n {

    public final k a;
    public p(k k) {
        super();
        this.a = k;
    }

    @Override // i.b.l0.n
    public final Object apply(Object object) {
        return DisplayCallbacksImpl.k(this.a, (Throwable)object);
    }
}
