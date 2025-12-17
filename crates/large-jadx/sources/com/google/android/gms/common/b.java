package com.google.android.gms.common;

import android.accounts.Account;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class b extends a {

    public static final Parcelable.Creator<com.google.android.gms.common.b> CREATOR;
    public static final com.google.android.gms.common.b w;
    final int a;
    private final int b;
    private final PendingIntent c;
    private final String v;
    static {
        b bVar = new b(0);
        b.w = bVar;
        q qVar = new q();
        b.CREATOR = qVar;
    }

    public b(int i) {
        final int i2 = 0;
        super(i, i2, i2);
    }

    b(int i, int i2, PendingIntent pendingIntent3, String string4) {
        super();
        this.a = i;
        this.b = i2;
        this.c = pendingIntent3;
        this.v = string4;
    }

    public b(int i, PendingIntent pendingIntent2) {
        super(i, pendingIntent2, 0);
    }

    public b(int i, PendingIntent pendingIntent2, String string3) {
        super(1, i, pendingIntent2, string3);
    }

    static String o2(int i) {
        if (i != 99 && i != 1500) {
            if (i != 1500) {
                switch (i) {
                    case -1:
                        return "UNKNOWN";
                    case 0:
                        return "SUCCESS";
                    case 1:
                        return "SERVICE_MISSING";
                    case 2:
                        return "SERVICE_VERSION_UPDATE_REQUIRED";
                    case 3:
                        return "SERVICE_DISABLED";
                    case 4:
                        return "SIGN_IN_REQUIRED";
                    case 5:
                        return "INVALID_ACCOUNT";
                    case 6:
                        return "RESOLUTION_REQUIRED";
                    case 7:
                        return "NETWORK_ERROR";
                    case 8:
                        return "INTERNAL_ERROR";
                    case 9:
                        return "SERVICE_INVALID";
                    case 10:
                        return "DEVELOPER_ERROR";
                    case 11:
                        return "LICENSE_CHECK_FAILED";
                    default:
                        return "API_DISABLED_FOR_CONNECTION";
                        return "API_DISABLED";
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                        return "API_VERSION_UPDATE_REQUIRED";
                        return "RESTRICTED_PROFILE";
                        return "SERVICE_MISSING_PERMISSION";
                        return "SERVICE_UPDATING";
                        return "SIGN_IN_FAILED";
                        return "API_UNAVAILABLE";
                        return "INTERRUPTED";
                        return "TIMEOUT";
                        return "CANCELED";
                }
                StringBuilder stringBuilder = new StringBuilder(31);
                stringBuilder.append("UNKNOWN_ERROR_CODE(");
                stringBuilder.append(i);
                stringBuilder.append(")");
                return stringBuilder.toString();
            }
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        return "UNFINISHED";
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean equals(Object object) {
        int i;
        int i2;
        Object obj5;
        final int i3 = 1;
        if (object == this) {
            return i3;
        }
        final int i4 = 0;
        if (!object instanceof b) {
            return i4;
        }
        if (this.b == object.b && p.a(this.c, object.c) && p.a(this.v, object.v)) {
            if (p.a(this.c, object.c)) {
                if (p.a(this.v, object.v)) {
                    return i3;
                }
            }
        }
        return i4;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int hashCode() {
        Object[] arr = new Object[3];
        return p.b(Integer.valueOf(this.b), this.c, this.v);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int j2() {
        return this.b;
    }

    public String k2() {
        return this.v;
    }

    public PendingIntent l2() {
        return this.c;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean m2() {
        int i;
        if (this.b != 0 && this.c != null) {
            if (this.c != null) {
                return 1;
            }
        }
        return 0;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean n2() {
        if (this.b == 0) {
            return 1;
        }
        return 0;
    }

    public String toString() {
        p.a aVar = p.c(this);
        aVar.a("statusCode", b.o2(this.b));
        aVar.a("resolution", this.c);
        aVar.a("message", this.v);
        return aVar.toString();
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.j(parcel, 2, j2());
        final int i9 = 0;
        b.n(parcel, 3, l2(), i2, i9);
        b.o(parcel, 4, k2(), i9);
        b.b(parcel, b.a(parcel));
    }
}
