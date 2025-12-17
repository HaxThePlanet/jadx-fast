package com.google.firebase.firestore.auth;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public final class a implements c {

    public static final com.google.firebase.firestore.auth.a a;
    static {
        a aVar = new a();
        a.a = aVar;
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        return FirebaseAppCheckTokenProvider.a(j);
    }
}
