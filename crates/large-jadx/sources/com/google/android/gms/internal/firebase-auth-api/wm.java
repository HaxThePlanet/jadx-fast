package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class wm implements Runnable {

    final com.google.android.gms.internal.firebase-auth-api.ym a;
    final com.google.android.gms.internal.firebase-auth-api.xm b;
    wm(com.google.android.gms.internal.firebase-auth-api.xm xm, com.google.android.gms.internal.firebase-auth-api.ym ym2) {
        this.b = xm;
        this.a = ym2;
        super();
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean empty;
        Object obj;
        Object[] arr;
        List list = anVar.g;
        synchronized (list) {
            int i = 0;
            this.a.a((PhoneAuthProvider.OnVerificationStateChangedCallbacks)anVar3.g.get(i), new Object[i]);
        }
    }
}
