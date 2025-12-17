package com.google.android.gms.internal.firebase-auth-api;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class mo extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.mo> CREATOR;
    private long A;
    private long B;
    private boolean C;
    private zze D;
    private List<com.google.android.gms.internal.firebase-auth-api.xo> E;
    private String a;
    private String b;
    private boolean c;
    private String v;
    private String w;
    private com.google.android.gms.internal.firebase-auth-api.bp x;
    private String y;
    private String z;
    static {
        no noVar = new no();
        mo.CREATOR = noVar;
    }

    public mo() {
        super();
        bp bpVar = new bp();
        this.x = bpVar;
    }

    public mo(String string, String string2, boolean z3, String string4, String string5, com.google.android.gms.internal.firebase-auth-api.bp bp6, String string7, String string8, long l9, long l10, boolean z11, zze zze12, List<com.google.android.gms.internal.firebase-auth-api.xo> list13) {
        com.google.android.gms.internal.firebase-auth-api.bp obj1;
        ArrayList obj15;
        super();
        this.a = string;
        this.b = string2;
        this.c = z3;
        this.v = string4;
        this.w = string5;
        if (bp6 == null) {
            obj1 = new bp();
        } else {
            obj1 = bp.k2(bp6);
        }
        this.x = obj1;
        this.y = string7;
        this.z = string8;
        this.A = l9;
        this.B = z11;
        this.C = list13;
        this.D = obj14;
        if (obj15 == null) {
            obj15 = new ArrayList();
        }
        this.E = obj15;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.zo> A2() {
        return this.x.l2();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean B2() {
        return this.C;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long j2() {
        return this.A;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final long k2() {
        return this.B;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final Uri l2() {
        if (!TextUtils.isEmpty(this.w)) {
            return Uri.parse(this.w);
        }
        return null;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final zze m2() {
        return this.D;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mo n2(zze zze) {
        this.D = zze;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mo o2(String string) {
        this.v = string;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mo p2(String string) {
        this.b = string;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mo q2(boolean z) {
        this.C = z;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mo r2(String string) {
        r.f(string);
        this.y = string;
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.mo s2(String string) {
        this.w = string;
        return this;
    }

    public final com.google.android.gms.internal.firebase-auth-api.mo t2(List<com.google.android.gms.internal.firebase-auth-api.zo> list) {
        r.j(list);
        bp bpVar = new bp();
        this.x = bpVar;
        bpVar.l2().addAll(list);
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final com.google.android.gms.internal.firebase-auth-api.bp u2() {
        return this.x;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String v2() {
        return this.v;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String w2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i14 = 0;
        b.o(parcel, 2, this.a, i14);
        b.o(parcel, 3, this.b, i14);
        b.c(parcel, 4, this.c);
        b.o(parcel, 5, this.v, i14);
        b.o(parcel, 6, this.w, i14);
        b.n(parcel, 7, this.x, i2, i14);
        b.o(parcel, 8, this.y, i14);
        int i11 = 9;
        b.o(parcel, i11, this.z, i14);
        b.l(parcel, 10, this.A);
        b.l(parcel, 11, this.B);
        b.c(parcel, 12, this.C);
        b.n(parcel, 13, this.D, i2, i14);
        b.s(parcel, 14, this.E, i14);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String x2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String y2() {
        return this.z;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.xo> z2() {
        return this.E;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzs() {
        return this.c;
    }
}
