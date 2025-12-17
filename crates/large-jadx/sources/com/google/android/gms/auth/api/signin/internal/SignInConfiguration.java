package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class SignInConfiguration extends a implements ReflectedParcelable {

    public static final Parcelable.Creator<com.google.android.gms.auth.api.signin.internal.SignInConfiguration> CREATOR;
    private final String a;
    private GoogleSignInOptions b;
    static {
        v vVar = new v();
        SignInConfiguration.CREATOR = vVar;
    }

    public SignInConfiguration(String string, GoogleSignInOptions googleSignInOptions2) {
        super();
        r.f(string);
        this.a = string;
        this.b = googleSignInOptions2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean equals(Object object) {
        boolean equals;
        boolean obj4;
        final int i = 0;
        if (!object instanceof SignInConfiguration) {
            return i;
        }
        if (this.a.equals(object.a)) {
            equals = this.b;
            obj4 = object.b;
            if (equals == null) {
                if (obj4 == null) {
                }
            } else {
                if (!equals.equals(obj4)) {
                }
            }
            return 1;
        }
        return i;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final int hashCode() {
        b bVar = new b();
        bVar.a(this.a);
        bVar.a(this.b);
        return bVar.b();
    }

    public final GoogleSignInOptions j2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.o(parcel, 2, this.a, i5);
        b.n(parcel, 5, this.b, i2, i5);
        b.b(parcel, b.a(parcel));
    }
}
