package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class q0 extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.q0> CREATOR;
    final int a;
    private final Account b;
    private final int c;
    private final GoogleSignInAccount v;
    static {
        r0 r0Var = new r0();
        q0.CREATOR = r0Var;
    }

    q0(int i, Account account2, int i3, GoogleSignInAccount googleSignInAccount4) {
        super();
        this.a = i;
        this.b = account2;
        this.c = i3;
        this.v = googleSignInAccount4;
    }

    public q0(Account account, int i2, GoogleSignInAccount googleSignInAccount3) {
        super(2, account, i2, googleSignInAccount3);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        final int i9 = 0;
        b.n(parcel, 2, this.b, i2, i9);
        b.j(parcel, 3, this.c);
        b.n(parcel, 4, this.v, i2, i9);
        b.b(parcel, b.a(parcel));
    }
}
