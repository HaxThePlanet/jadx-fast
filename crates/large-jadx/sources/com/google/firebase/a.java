package com.google.firebase;

import android.content.Context;
import com.google.firebase.inject.Provider;

/* loaded from: classes2.dex */
public final class a implements Provider {

    public final com.google.firebase.FirebaseApp a;
    public final Context b;
    public a(com.google.firebase.FirebaseApp firebaseApp, Context context2) {
        super();
        this.a = firebaseApp;
        this.b = context2;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        return this.a.b(this.b);
    }
}
