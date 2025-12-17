package com.google.android.gms.tasks;

/* loaded from: classes2.dex */
final class n implements com.google.android.gms.tasks.g<Void> {

    final com.google.android.gms.tasks.h a;
    n(com.google.android.gms.tasks.r r, com.google.android.gms.tasks.h h2) {
        this.a = h2;
        super();
    }

    @Override // com.google.android.gms.tasks.g
    public final void onSuccess(Object object) {
        this.a.onCanceled();
    }
}
