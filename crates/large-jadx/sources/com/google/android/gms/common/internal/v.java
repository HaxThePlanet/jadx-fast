package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class v extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.internal.v> CREATOR;
    private final int a;
    private List<com.google.android.gms.common.internal.o> b;
    static {
        a0 a0Var = new a0();
        v.CREATOR = a0Var;
    }

    public v(int i, List<com.google.android.gms.common.internal.o> list2) {
        super();
        this.a = i;
        this.b = list2;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final int j2() {
        return this.a;
    }

    public final List<com.google.android.gms.common.internal.o> k2() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void l2(com.google.android.gms.common.internal.o o) {
        Object arrayList;
        if (this.b == null) {
            arrayList = new ArrayList();
            this.b = arrayList;
        }
        this.b.add(o);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.s(parcel, 2, this.b, false);
        b.b(parcel, b.a(parcel));
    }
}
