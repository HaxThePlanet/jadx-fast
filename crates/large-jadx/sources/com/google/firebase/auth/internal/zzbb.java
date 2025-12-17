package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzbb extends a {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzbb> CREATOR;
    private final List<PhoneMultiFactorInfo> zza;
    static {
        zzbc zzbc = new zzbc();
        zzbb.CREATOR = zzbc;
    }

    zzbb(List<PhoneMultiFactorInfo> list) {
        ArrayList obj1;
        super();
        if (list == null) {
            obj1 = new ArrayList();
        }
        this.zza = obj1;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        b.s(parcel, 1, this.zza, false);
        b.b(parcel, b.a(parcel));
    }

    public final List<MultiFactorInfo> zza() {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.zza.iterator();
        for (PhoneMultiFactorInfo next : iterator) {
            arrayList.add(next);
        }
        return arrayList;
    }
}
