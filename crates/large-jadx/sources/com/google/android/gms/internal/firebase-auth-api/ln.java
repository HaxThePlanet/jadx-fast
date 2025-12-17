package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class ln implements Runnable {

    public final com.google.android.gms.internal.firebase-auth-api.qn a;
    public final String b;
    public ln(com.google.android.gms.internal.firebase-auth-api.qn qn, String string2) {
        super();
        this.a = qn;
        this.b = string2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.h(this.b);
    }
}
