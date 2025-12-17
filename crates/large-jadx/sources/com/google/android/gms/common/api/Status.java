package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class Status extends a implements com.google.android.gms.common.api.i, ReflectedParcelable {

    public static final com.google.android.gms.common.api.Status A;
    public static final com.google.android.gms.common.api.Status B;
    public static final Parcelable.Creator<com.google.android.gms.common.api.Status> CREATOR;
    public static final com.google.android.gms.common.api.Status x;
    public static final com.google.android.gms.common.api.Status y;
    public static final com.google.android.gms.common.api.Status z;
    final int a;
    private final int b;
    private final String c;
    private final PendingIntent v;
    private final b w;
    static {
        Status status = new Status(0);
        Status.x = status;
        Status status2 = new Status(14);
        Status.y = status2;
        Status status3 = new Status(8);
        Status.z = status3;
        Status status4 = new Status(15);
        Status.A = status4;
        Status status5 = new Status(16);
        Status.B = status5;
        Status status6 = new Status(17);
        Status status7 = new Status(18);
        q qVar = new q();
        Status.CREATOR = qVar;
    }

    public Status(int i) {
        super(i, 0);
    }

    Status(int i, int i2, String string3, PendingIntent pendingIntent4) {
        super(i, i2, string3, pendingIntent4, 0);
    }

    Status(int i, int i2, String string3, PendingIntent pendingIntent4, b b5) {
        super();
        this.a = i;
        this.b = i2;
        this.c = string3;
        this.v = pendingIntent4;
        this.w = b5;
    }

    public Status(int i, String string2) {
        super(1, i, string2, 0);
    }

    public Status(int i, String string2, PendingIntent pendingIntent3) {
        super(1, i, string2, pendingIntent3);
    }

    public Status(b b, String string2) {
        super(b, string2, 17);
    }

    @Deprecated
    public Status(b b, String string2, int i3) {
        super(1, i3, string2, b.l2(), b);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean equals(Object object) {
        int i2;
        int i;
        Object obj4;
        final int i3 = 0;
        if (!object instanceof Status) {
            return i3;
        }
        if (this.a == object.a && this.b == object.b && p.a(this.c, object.c) && p.a(this.v, object.v) && p.a(this.w, object.w)) {
            if (this.b == object.b) {
                if (p.a(this.c, object.c)) {
                    if (p.a(this.v, object.v)) {
                        if (p.a(this.w, object.w)) {
                            return 1;
                        }
                    }
                }
            }
        }
        return i3;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int hashCode() {
        Object[] arr = new Object[5];
        return p.b(Integer.valueOf(this.a), Integer.valueOf(this.b), this.c, this.v, this.w);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean isCanceled() {
        if (this.b == 16) {
            return 1;
        }
        return 0;
    }

    public b j2() {
        return this.w;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int k2() {
        return this.b;
    }

    public String l2() {
        return this.c;
    }

    public com.google.android.gms.common.api.Status m() {
        return this;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean m2() {
        if (this.v != null) {
            return 1;
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean n2() {
        if (this.b <= 0) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        p.a aVar = p.c(this);
        aVar.a("statusCode", zza());
        aVar.a("resolution", this.v);
        return aVar.toString();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, k2());
        final int i9 = 0;
        b.o(parcel, 2, l2(), i9);
        b.n(parcel, 3, this.v, i2, i9);
        b.n(parcel, 4, j2(), i2, i9);
        b.j(parcel, 1000, this.a);
        b.b(parcel, b.a(parcel));
    }

    public final String zza() {
        String str = this.c;
        if (str != null) {
            return str;
        }
        return b.a(this.b);
    }
}
