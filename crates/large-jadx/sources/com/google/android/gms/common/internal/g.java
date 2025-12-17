package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.d;
import com.google.android.gms.common.f;
import com.google.android.gms.common.internal.safeparcel.a;

/* loaded from: classes2.dex */
public class g extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.g> CREATOR;
    d[] A;
    d[] B;
    boolean C;
    int D;
    boolean E;
    private final String F;
    final int a;
    final int b;
    int c;
    String v;
    IBinder w;
    Scope[] x;
    Bundle y;
    Account z;
    static {
        o1 o1Var = new o1();
        g.CREATOR = o1Var;
    }

    g(int i, int i2, int i3, String string4, IBinder iBinder5, Scope[] scope6Arr6, Bundle bundle7, Account account8, d[] d9Arr9, d[] d10Arr10, boolean z11, int i12, boolean z13, String string14) {
        int obj1;
        super();
        this.a = i;
        this.b = i2;
        this.c = i3;
        String obj2 = "com.google.android.gms";
        if (obj2.equals(string4)) {
            this.v = obj2;
        } else {
            this.v = string4;
        }
        if (i < 2) {
            if (iBinder5 != null) {
                obj1 = a.n(k.a.m(iBinder5));
            } else {
                obj1 = 0;
            }
            this.z = obj1;
        } else {
            this.w = iBinder5;
            this.z = account8;
        }
        this.x = scope6Arr6;
        this.y = bundle7;
        this.A = d9Arr9;
        this.B = d10Arr10;
        this.C = z11;
        this.D = i12;
        this.E = z13;
        this.F = string14;
    }

    public g(int i, String string2) {
        super();
        this.a = 6;
        this.c = f.a;
        this.b = i;
        this.C = true;
        this.F = string2;
    }

    public Bundle j2() {
        return this.y;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        o1.a(this, parcel, i2);
    }

    public final String zza() {
        return this.F;
    }
}
