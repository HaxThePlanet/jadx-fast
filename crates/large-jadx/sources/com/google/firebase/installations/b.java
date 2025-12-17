package com.google.firebase.installations;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    public final com.google.firebase.installations.FirebaseInstallations a;
    public b(com.google.firebase.installations.FirebaseInstallations firebaseInstallations) {
        super();
        this.a = firebaseInstallations;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.d();
    }
}
