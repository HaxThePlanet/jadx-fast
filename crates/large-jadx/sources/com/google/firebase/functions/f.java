package com.google.firebase.functions;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class f implements c {

    public final com.google.firebase.functions.FirebaseFunctions a;
    public final String b;
    public final Object c;
    public final com.google.firebase.functions.HttpsCallOptions d;
    public f(com.google.firebase.functions.FirebaseFunctions firebaseFunctions, String string2, Object object3, com.google.firebase.functions.HttpsCallOptions httpsCallOptions4) {
        super();
        this.a = firebaseFunctions;
        this.b = string2;
        this.c = object3;
        this.d = httpsCallOptions4;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.d(this.b, this.c, this.d, j);
    }
}
