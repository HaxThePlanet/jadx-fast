package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class b0 extends com.google.android.gms.common.api.internal.a {

    private final WeakReference<com.google.android.gms.common.api.internal.w> a;
    b0(com.google.android.gms.common.api.internal.w w) {
        super();
        WeakReference weakReference = new WeakReference(w);
        this.a = weakReference;
    }

    @Override // com.google.android.gms.common.api.internal.a
    public final com.google.android.gms.common.api.internal.a b(Runnable runnable) {
        Object obj = this.a.get();
        if ((w)obj == null) {
        } else {
            w.b((w)obj, runnable);
            return this;
        }
        IllegalStateException obj2 = new IllegalStateException("The target activity has already been GC'd");
        throw obj2;
    }
}
