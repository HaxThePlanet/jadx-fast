package com.google.firebase.installations;

/* loaded from: classes2.dex */
public final class c implements Runnable {

    public final com.google.firebase.installations.FirebaseInstallations a;
    public final boolean b;
    public c(com.google.firebase.installations.FirebaseInstallations firebaseInstallations, boolean z2) {
        super();
        this.a = firebaseInstallations;
        this.b = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b);
    }
}
