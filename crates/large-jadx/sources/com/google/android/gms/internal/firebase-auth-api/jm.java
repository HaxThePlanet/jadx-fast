package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.a;
import com.google.android.gms.common.api.a.g;

/* loaded from: classes2.dex */
public final class jm {

    public static final a.g<com.google.android.gms.internal.firebase-auth-api.ol> a;
    private static final a.a<com.google.android.gms.internal.firebase-auth-api.ol, com.google.android.gms.internal.firebase-auth-api.im> b;
    public static final a<com.google.android.gms.internal.firebase-auth-api.im> c;
    static {
        a.g gVar = new a.g();
        jm.a = gVar;
        gm gmVar = new gm();
        jm.b = gmVar;
        a aVar = new a("InternalFirebaseAuth.FIREBASE_AUTH_API", gmVar, gVar);
        jm.c = aVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.kl a(Context context, com.google.android.gms.internal.firebase-auth-api.im im2) {
        kl klVar = new kl(context, im2);
        return klVar;
    }
}
