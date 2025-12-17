package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class SignInAccount extends a implements ReflectedParcelable {

    public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.SignInAccount> CREATOR;
    @Deprecated
    String a;
    private com.google.android.gms.auth.api.signin.GoogleSignInAccount b;
    @Deprecated
    String c;
    static {
        h hVar = new h();
        SignInAccount.CREATOR = hVar;
    }

    SignInAccount(String string, com.google.android.gms.auth.api.signin.GoogleSignInAccount googleSignInAccount2, String string3) {
        super();
        this.b = googleSignInAccount2;
        r.g(string, "8.3 and 8.4 SDKs require non-null email");
        this.a = string;
        r.g(string3, "8.3 and 8.4 SDKs require non-null userId");
        this.c = string3;
    }

    public final com.google.android.gms.auth.api.signin.GoogleSignInAccount j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.o(parcel, 4, this.a, i6);
        b.n(parcel, 7, this.b, i2, i6);
        b.o(parcel, 8, this.c, i6);
        b.b(parcel, b.a(parcel));
    }
}
