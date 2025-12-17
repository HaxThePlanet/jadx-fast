package com.google.firebase.functions;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class d implements i {

    public final com.google.firebase.functions.FirebaseContextProvider a;
    public d(com.google.firebase.functions.FirebaseContextProvider firebaseContextProvider) {
        super();
        this.a = firebaseContextProvider;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return this.a.b((AppCheckTokenResult)object);
    }
}
