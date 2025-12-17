package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzag extends MultiFactorSession {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzag> CREATOR;
    private String zza;
    private String zzb;
    private List<PhoneMultiFactorInfo> zzc;
    static {
        zzah zzah = new zzah();
        zzag.CREATOR = zzah;
    }

    zzag(String string, String string2, List<PhoneMultiFactorInfo> list3) {
        super();
        this.zza = string;
        this.zzb = string2;
        this.zzc = list3;
    }

    public static com.google.firebase.auth.internal.zzag zza(String string) {
        r.f(string);
        zzag zzag = new zzag();
        zzag.zza = string;
        return zzag;
    }

    public static com.google.firebase.auth.internal.zzag zzb(List<MultiFactorInfo> list, String string2) {
        ArrayList arrayList;
        boolean zzc;
        r.j(list);
        r.f(string2);
        zzag zzag = new zzag();
        arrayList = new ArrayList();
        zzag.zzc = arrayList;
        final Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            arrayList = obj3.next();
            if (arrayList instanceof PhoneMultiFactorInfo) {
            }
            zzag.zzc.add((PhoneMultiFactorInfo)(MultiFactorInfo)arrayList);
        }
        zzag.zzb = string2;
        return zzag;
    }

    @Override // com.google.firebase.auth.MultiFactorSession
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i5 = 0;
        b.o(parcel, 1, this.zza, i5);
        b.o(parcel, 2, this.zzb, i5);
        b.s(parcel, 3, this.zzc, i5);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.MultiFactorSession
    public final String zzc() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.MultiFactorSession
    public final String zzd() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.MultiFactorSession
    public final boolean zze() {
        if (this.zza != null) {
            return 1;
        }
        return 0;
    }
}
