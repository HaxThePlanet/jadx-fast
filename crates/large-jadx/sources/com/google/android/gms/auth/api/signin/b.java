package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.a.a;
import com.google.android.gms.auth.api.signin.internal.n;
import com.google.android.gms.common.api.c;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.j;

/* loaded from: classes2.dex */
public class b extends c<com.google.android.gms.auth.api.signin.GoogleSignInOptions> {

    static int a = 1;
    static {
    }

    b(Context context, com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions2) {
        b bVar = new b();
        super(context, a.a, googleSignInOptions2, bVar);
    }

    private final int e() {
        int i2;
        Context applicationContext;
        int str;
        int i3;
        int i;
        synchronized (this) {
            try {
                applicationContext = getApplicationContext();
                str = e.o();
                i3 = str.h(applicationContext, 12451000);
                if (i3 == 0) {
                } else {
                }
                b.a = 4;
                if (str.b(applicationContext, i3, 0) == null && DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") != 0) {
                } else {
                }
                if (DynamiteModule.a(applicationContext, "com.google.android.gms.auth.api.fallback") != 0) {
                } else {
                }
                b.a = 3;
                b.a = 2;
                return b.a;
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.api.c
    public Intent b() {
        Context applicationContext = getApplicationContext();
        int i2 = e();
        final int i5 = i2 + -1;
        if (i2 == 0) {
        } else {
            if (i5 != 2 && i5 != 3) {
                if (i5 != 3) {
                    return n.b(applicationContext, (GoogleSignInOptions)getApiOptions());
                }
                return n.c(applicationContext, (GoogleSignInOptions)getApiOptions());
            }
            return n.a(applicationContext, (GoogleSignInOptions)getApiOptions());
        }
        throw 0;
    }

    public j<Void> c() {
        int i;
        i = e() == 3 ? 1 : 0;
        return q.c(n.e(asGoogleApiClient(), getApplicationContext(), i));
    }

    public j<Void> d() {
        int i;
        i = e() == 3 ? 1 : 0;
        return q.c(n.f(asGoogleApiClient(), getApplicationContext(), i));
    }
}
