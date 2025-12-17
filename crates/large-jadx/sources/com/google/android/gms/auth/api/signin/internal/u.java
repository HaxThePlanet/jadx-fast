package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.a;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.common.util.o;

/* loaded from: classes2.dex */
public final class u extends com.google.android.gms.auth.api.signin.internal.p {

    private final Context a;
    public u(Context context) {
        super();
        this.a = context;
    }

    private final void m() {
        if (!o.a(this.a, Binder.getCallingUid())) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder(52);
        stringBuilder.append("Calling UID ");
        stringBuilder.append(Binder.getCallingUid());
        stringBuilder.append(" is not Google Play services.");
        SecurityException securityException = new SecurityException(stringBuilder.toString());
        throw securityException;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.p
    public final void B() {
        m();
        o.a(this.a).b();
    }

    @Override // com.google.android.gms.auth.api.signin.internal.p
    public final void T() {
        GoogleSignInOptions googleSignInOptions;
        m();
        com.google.android.gms.auth.api.signin.internal.c cVar = c.b(this.a);
        final com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount = cVar.c();
        googleSignInOptions = GoogleSignInOptions.D;
        if (googleSignInAccount != null) {
            googleSignInOptions = cVar.d();
        }
        b bVar = a.a(this.a, googleSignInOptions);
        if (googleSignInAccount != null) {
            bVar.c();
        }
        bVar.d();
    }
}
