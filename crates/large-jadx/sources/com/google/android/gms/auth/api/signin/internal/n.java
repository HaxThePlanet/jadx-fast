package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.c;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.l.a;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public final class n {

    private static final a a;
    static {
        a aVar = new a("GoogleSignInCommon", new String[0]);
        n.a = aVar;
    }

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions2) {
        n.a.a("getFallbackSignInIntent()", new Object[0]);
        final Intent obj3 = n.c(context, googleSignInOptions2);
        obj3.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        return obj3;
    }

    public static Intent b(Context context, GoogleSignInOptions googleSignInOptions2) {
        n.a.a("getNoImplementationSignInIntent()", new Object[0]);
        final Intent obj3 = n.c(context, googleSignInOptions2);
        obj3.setAction("com.google.android.gms.auth.NO_IMPL");
        return obj3;
    }

    public static Intent c(Context context, GoogleSignInOptions googleSignInOptions2) {
        n.a.a("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions2);
        Intent obj4 = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        obj4.setPackage(context.getPackageName());
        obj4.setClass(context, SignInHubActivity.class);
        Bundle obj3 = new Bundle();
        String str2 = "config";
        obj3.putParcelable(str2, signInConfiguration);
        obj4.putExtra(str2, obj3);
        return obj4;
    }

    public static c d(Intent intent) {
        android.os.Parcelable parcelableExtra;
        int i = 0;
        if (intent == null) {
            c obj3 = new c(i, Status.z);
            return obj3;
        }
        obj3 = intent.getParcelableExtra("googleSignInAccount");
        if ((GoogleSignInAccount)obj3 == null && (Status)intent.getParcelableExtra("googleSignInStatus") == null) {
            if ((Status)intent.getParcelableExtra("googleSignInStatus") == null) {
                parcelableExtra = Status.z;
            }
            obj3 = new c(i, parcelableExtra);
            return obj3;
        }
        c cVar = new c((GoogleSignInAccount)obj3, Status.x);
        return cVar;
    }

    public static e<Status> e(d d, Context context2, boolean z3) {
        n.a.a("Revoking access", new Object[0]);
        n.g(context2);
        if (z3) {
            return f.a(c.b(context2).e());
        }
        l obj4 = new l(d);
        return d.b(obj4);
    }

    public static e<Status> f(d d, Context context2, boolean z3) {
        n.a.a("Signing out", new Object[0]);
        n.g(context2);
        if (z3) {
            return f.b(Status.x, d);
        }
        j obj4 = new j(d);
        return d.b(obj4);
    }

    private static void g(Context context) {
        o.a(context).b();
        Iterator obj1 = d.c().iterator();
        if (obj1.hasNext()) {
        } else {
            g.a();
        }
        (d)obj1.next().f();
        throw 0;
    }
}
