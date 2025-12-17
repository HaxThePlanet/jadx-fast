package com.google.android.gms.auth.api.signin;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.internal.n;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;

/* loaded from: classes2.dex */
public final class a {
    public static com.google.android.gms.auth.api.signin.b a(Context context, com.google.android.gms.auth.api.signin.GoogleSignInOptions googleSignInOptions2) {
        r.j(googleSignInOptions2);
        b bVar = new b(context, (GoogleSignInOptions)googleSignInOptions2);
        return bVar;
    }

    public static j<com.google.android.gms.auth.api.signin.GoogleSignInAccount> b(Intent intent) {
        com.google.android.gms.auth.api.signin.c obj2 = n.d(intent);
        final com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount = obj2.a();
        if (obj2.m().n2() && googleSignInAccount == null) {
            if (googleSignInAccount == null) {
            }
            return m.e(googleSignInAccount);
        }
        return m.d(b.a(obj2.m()));
    }
}
