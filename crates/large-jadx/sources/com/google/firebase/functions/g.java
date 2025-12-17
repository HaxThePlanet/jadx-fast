package com.google.firebase.functions;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class g implements c {

    public final com.google.firebase.functions.FirebaseFunctions a;
    public g(com.google.firebase.functions.FirebaseFunctions firebaseFunctions) {
        super();
        this.a = firebaseFunctions;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return this.a.b(j);
    }
}
