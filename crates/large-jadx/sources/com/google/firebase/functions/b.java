package com.google.firebase.functions;

import com.google.android.gms.tasks.i;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class b implements i {

    public final com.google.firebase.functions.FirebaseContextProvider a;
    public final j b;
    public final j c;
    public b(com.google.firebase.functions.FirebaseContextProvider firebaseContextProvider, j j2, j j3) {
        super();
        this.a = firebaseContextProvider;
        this.b = j2;
        this.c = j3;
    }

    @Override // com.google.android.gms.tasks.i
    public final j then(Object object) {
        return this.a.e(this.b, this.c, (Void)object);
    }
}
