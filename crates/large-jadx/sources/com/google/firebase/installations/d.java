package com.google.firebase.installations;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class d implements Callable {

    public final com.google.firebase.installations.FirebaseInstallations a;
    public d(com.google.firebase.installations.FirebaseInstallations firebaseInstallations) {
        super();
        this.a = firebaseInstallations;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return FirebaseInstallations.g(this.a);
    }
}
