package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class d extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.d> CREATOR;
    private final String a;
    @Deprecated
    private final int b;
    private final long c;
    static {
        r rVar = new r();
        d.CREATOR = rVar;
    }

    public d(String string, int i2, long l3) {
        super();
        this.a = string;
        this.b = i2;
        this.c = l3;
    }

    public d(String string, long l2) {
        super();
        this.a = string;
        this.c = l2;
        this.b = -1;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean equals(Object object) {
        boolean equals;
        String str;
        long l;
        Object obj7;
        if (object instanceof d) {
            if (j2() != null) {
                if (!j2().equals((d)object.j2())) {
                    if (j2() == null && object.j2() == null && Long.compare(str, l) == 0) {
                        if (object.j2() == null) {
                            if (Long.compare(str, l) == 0) {
                                return 1;
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final int hashCode() {
        Object[] arr = new Object[2];
        int i3 = 0;
        arr[i3] = j2();
        arr[1] = Long.valueOf(k2());
        return p.b(arr);
    }

    public String j2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public long k2() {
        long l;
        if (Long.compare(l, i2) == 0) {
            l = (long)i;
        }
        return l;
    }

    public final String toString() {
        p.a aVar = p.c(this);
        String str2 = "name";
        aVar.a(str2, j2());
        aVar.a("version", Long.valueOf(k2()));
        return aVar.toString();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.o(parcel, 1, j2(), false);
        int i4 = 2;
        b.j(parcel, i4, this.b);
        b.l(parcel, 3, k2());
        b.b(parcel, b.a(parcel));
    }
}
