package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import f.c.a.d.b.c.c;
import f.c.a.d.b.c.d;

/* loaded from: classes2.dex */
public abstract class r extends c implements com.google.android.gms.auth.api.signin.internal.s {
    public r() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    @Override // f.c.a.d.b.c.c
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        android.os.Parcelable obj1;
        switch (i) {
            case 101:
                I0((GoogleSignInAccount)d.a(parcel2, GoogleSignInAccount.CREATOR), (Status)d.a(parcel2, Status.CREATOR));
                throw 0;
            case 102:
                f1((Status)d.a(parcel2, Status.CREATOR));
                break;
            case 103:
                E0((Status)d.a(parcel2, Status.CREATOR));
                break;
            default:
                return 0;
        }
        parcel3.writeNoException();
        return 1;
    }
}
