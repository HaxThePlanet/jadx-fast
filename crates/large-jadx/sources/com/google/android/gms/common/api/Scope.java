package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public final class Scope extends a implements ReflectedParcelable {

    public static final Parcelable.Creator<com.google.android.gms.common.api.Scope> CREATOR;
    final int a;
    private final String b;
    static {
        p pVar = new p();
        Scope.CREATOR = pVar;
    }

    Scope(int i, String string2) {
        super();
        r.g(string2, "scopeUri must not be null or empty");
        this.a = i;
        this.b = string2;
    }

    public Scope(String string) {
        super(1, string);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean equals(Object object) {
        if (this == object) {
            return 1;
        }
        if (!object instanceof Scope) {
            return 0;
        }
        return this.b.equals(object.b);
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public int hashCode() {
        return this.b.hashCode();
    }

    public String j2() {
        return this.b;
    }

    public String toString() {
        return this.b;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        b.j(parcel, 1, this.a);
        b.o(parcel, 2, j2(), false);
        b.b(parcel, b.a(parcel));
    }
}
