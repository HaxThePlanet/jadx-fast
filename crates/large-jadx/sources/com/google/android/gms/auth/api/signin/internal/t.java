package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import f.c.a.d.b.c.a;
import f.c.a.d.b.c.d;

/* loaded from: classes2.dex */
public final class t extends a implements IInterface {
    t(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // f.c.a.d.b.c.a
    public final void n(com.google.android.gms.auth.api.signin.internal.s s, GoogleSignInOptions googleSignInOptions2) {
        final android.os.Parcel parcel = j();
        d.c(parcel, s);
        d.b(parcel, googleSignInOptions2);
        m(103, parcel);
    }

    @Override // f.c.a.d.b.c.a
    public final void p2(com.google.android.gms.auth.api.signin.internal.s s, GoogleSignInOptions googleSignInOptions2) {
        final android.os.Parcel parcel = j();
        d.c(parcel, s);
        d.b(parcel, googleSignInOptions2);
        m(102, parcel);
    }
}
