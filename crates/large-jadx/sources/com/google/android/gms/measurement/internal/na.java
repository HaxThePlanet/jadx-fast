package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.List;

/* loaded from: classes2.dex */
public final class na extends a {

    public static final Parcelable.Creator<com.google.android.gms.measurement.internal.na> CREATOR;
    public final boolean A;
    public final long B;
    public final String C;
    public final long D;
    public final long E;
    public final int F;
    public final boolean G;
    public final boolean H;
    public final String I;
    public final Boolean J;
    public final long K;
    public final List<String> L;
    public final String M;
    public final String N;
    public final String a;
    public final String b;
    public final String c;
    public final String v;
    public final long w;
    public final long x;
    public final String y;
    public final boolean z;
    static {
        oa oaVar = new oa();
        na.CREATOR = oaVar;
    }

    na(String string, String string2, String string3, long l4, String string5, long l6, long l7, String string8, boolean z9, boolean z10, String string11, long l12, long l13, int i14, boolean z15, boolean z16, String string17, Boolean boolean18, long l19, List<String> list20, String string21, String string22) {
        java.lang.CharSequence charSequence;
        final Object obj = this;
        super();
        r.f(string);
        obj.a = string;
        charSequence = 1 != TextUtils.isEmpty(string2) ? string2 : 0;
        obj.b = charSequence;
        obj.c = string3;
        obj.B = l4;
        obj.v = l6;
        obj.w = l7;
        obj.x = z9;
        obj.y = string11;
        obj.z = l12;
        obj.A = l13;
        obj.C = i14;
        obj.D = z15;
        obj.E = string17;
        obj.F = l19;
        obj.G = list20;
        obj.H = string21;
        obj.I = string22;
        obj.J = obj26;
        obj.K = obj27;
        obj.L = obj29;
        obj.M = obj30;
        obj.N = obj31;
    }

    na(String string, String string2, String string3, String string4, long l5, long l6, String string7, boolean z8, boolean z9, long l10, String string11, long l12, long l13, int i14, boolean z15, boolean z16, String string17, Boolean boolean18, long l19, List<String> list20, String string21, String string22) {
        final Object obj = this;
        super();
        obj.a = string;
        obj.b = string2;
        obj.c = string3;
        obj.B = l12;
        obj.v = string4;
        obj.w = l5;
        obj.x = string7;
        obj.y = z9;
        obj.z = l10;
        obj.A = string11;
        obj.C = i14;
        obj.D = z15;
        obj.E = string17;
        obj.F = l19;
        obj.G = list20;
        obj.H = string21;
        obj.I = string22;
        obj.J = obj26;
        obj.K = obj27;
        obj.L = obj29;
        obj.M = obj30;
        obj.N = obj31;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i19 = 0;
        b.o(parcel, 2, this.a, i19);
        b.o(parcel, 3, this.b, i19);
        b.o(parcel, 4, this.c, i19);
        int i6 = 5;
        b.o(parcel, i6, this.v, i19);
        b.l(parcel, 6, this.w);
        b.l(parcel, 7, this.x);
        b.o(parcel, 8, this.y, i19);
        b.c(parcel, 9, this.z);
        int i9 = 10;
        b.c(parcel, i9, this.A);
        b.l(parcel, 11, this.B);
        int i10 = 12;
        b.o(parcel, i10, this.C, i19);
        b.l(parcel, 13, this.D);
        b.l(parcel, 14, this.E);
        b.j(parcel, 15, this.F);
        b.c(parcel, 16, this.G);
        b.c(parcel, 18, this.H);
        b.o(parcel, 19, this.I, i19);
        int i15 = 21;
        b.d(parcel, i15, this.J, i19);
        b.l(parcel, 22, this.K);
        b.q(parcel, 23, this.L, i19);
        b.o(parcel, 24, this.M, i19);
        b.o(parcel, 25, this.N, i19);
        b.b(parcel, b.a(parcel));
    }
}
