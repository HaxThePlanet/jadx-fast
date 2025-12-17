package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class i0 implements com.google.android.gms.tasks.h {

    final com.google.android.gms.tasks.k a;
    i0(com.google.android.gms.tasks.k k) {
        this.a = k;
        super();
    }

    @Override // com.google.android.gms.tasks.h
    public final void onCanceled() {
        k.f(this.a).e();
    }
}
