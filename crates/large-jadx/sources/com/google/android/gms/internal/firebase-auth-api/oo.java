package com.google.android.gms.internal.firebase-auth-api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class oo extends a {

    public static final Parcelable.Creator<com.google.android.gms.internal.firebase-auth-api.oo> CREATOR;
    private final List<com.google.android.gms.internal.firebase-auth-api.mo> a;
    static {
        po poVar = new po();
        oo.CREATOR = poVar;
    }

    public oo() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
    }

    oo(List<com.google.android.gms.internal.firebase-auth-api.mo> list) {
        List obj1;
        super();
        if (list == null) {
            obj1 = Collections.emptyList();
        } else {
            obj1 = Collections.unmodifiableList(list);
        }
        this.a = obj1;
    }

    public static com.google.android.gms.internal.firebase-auth-api.oo j2(com.google.android.gms.internal.firebase-auth-api.oo oo) {
        boolean empty;
        r.j(oo);
        final List obj2 = oo.a;
        oo ooVar = new oo();
        if (obj2 != null && !obj2.isEmpty()) {
            if (!obj2.isEmpty()) {
                ooVar.a.addAll(obj2);
            }
        }
        return ooVar;
    }

    public final List<com.google.android.gms.internal.firebase-auth-api.mo> k2() {
        return this.a;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.s(parcel, 2, this.a, false);
        b.b(parcel, b.a(parcel));
    }
}
