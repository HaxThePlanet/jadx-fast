package com.google.android.gms.common.api.internal;

/* loaded from: classes2.dex */
final class u0 implements Runnable {

    private final com.google.android.gms.common.api.internal.l a;
    u0(com.google.android.gms.common.api.internal.l l) {
        super();
        this.a = l;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
