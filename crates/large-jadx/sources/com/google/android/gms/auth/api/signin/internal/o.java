package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* loaded from: classes2.dex */
public final class o {

    private static com.google.android.gms.auth.api.signin.internal.o b;
    final com.google.android.gms.auth.api.signin.internal.c a;
    static {
    }

    private o(Context context) {
        super();
        final com.google.android.gms.auth.api.signin.internal.c obj1 = c.b(context);
        this.a = obj1;
        obj1.c();
        obj1.d();
    }

    public static com.google.android.gms.auth.api.signin.internal.o a(Context context) {
        final Class<com.google.android.gms.auth.api.signin.internal.o> obj = o.class;
        return o.d(context.getApplicationContext());
        synchronized (obj) {
            obj = o.class;
            return o.d(context.getApplicationContext());
        }
    }

    private static com.google.android.gms.auth.api.signin.internal.o d(Context context) {
        final Class<com.google.android.gms.auth.api.signin.internal.o> obj = o.class;
        com.google.android.gms.auth.api.signin.internal.o oVar = o.b;
        synchronized (obj) {
            return oVar;
        }
    }

    public final void b() {
        this.a.a();
        return;
        synchronized (this) {
            this.a.a();
        }
    }

    public final void c(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount2) {
        this.a.f(googleSignInAccount2, googleSignInOptions);
        return;
        synchronized (this) {
            this.a.f(googleSignInAccount2, googleSignInOptions);
        }
    }
}
