package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.tasks.j;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.MultiFactorResolver;
import com.google.firebase.auth.MultiFactorSession;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzae extends MultiFactorResolver {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzae> CREATOR;
    private final List<PhoneMultiFactorInfo> zza;
    private final com.google.firebase.auth.internal.zzag zzb;
    private final String zzc;
    private final zze zzd;
    private final com.google.firebase.auth.internal.zzx zze;
    static {
        zzaf zzaf = new zzaf();
        zzae.CREATOR = zzaf;
    }

    public zzae(List<PhoneMultiFactorInfo> list, com.google.firebase.auth.internal.zzag zzag2, String string3, zze zze4, com.google.firebase.auth.internal.zzx zzx5) {
        ArrayList arrayList;
        boolean zza;
        super();
        arrayList = new ArrayList();
        this.zza = arrayList;
        final Iterator obj3 = list.iterator();
        while (obj3.hasNext()) {
            arrayList = obj3.next();
            if (arrayList instanceof PhoneMultiFactorInfo) {
            }
            this.zza.add((PhoneMultiFactorInfo)(MultiFactorInfo)arrayList);
        }
        r.j(zzag2);
        this.zzb = (zzag)zzag2;
        r.f(string3);
        this.zzc = string3;
        this.zzd = zze4;
        this.zze = zzx5;
    }

    static zze zza(com.google.firebase.auth.internal.zzae zzae) {
        return zzae.zzd;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final FirebaseAuth getFirebaseAuth() {
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc));
    }

    public final List<MultiFactorInfo> getHints() {
        Object next;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.zza.iterator();
        for (PhoneMultiFactorInfo next : iterator) {
            arrayList.add(next);
        }
        return arrayList;
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final MultiFactorSession getSession() {
        return this.zzb;
    }

    public final j<AuthResult> resolveSignIn(MultiFactorAssertion multiFactorAssertion) {
        zzad zzad = new zzad(this);
        return FirebaseAuth.getInstance(FirebaseApp.getInstance(this.zzc)).zzh(multiFactorAssertion, this.zzb, this.zze).continueWithTask(zzad);
    }

    @Override // com.google.firebase.auth.MultiFactorResolver
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i8 = 0;
        b.s(parcel, 1, this.zza, i8);
        b.n(parcel, 2, this.zzb, i2, i8);
        b.o(parcel, 3, this.zzc, i8);
        b.n(parcel, 4, this.zzd, i2, i8);
        b.n(parcel, 5, this.zze, i2, i8);
        b.b(parcel, b.a(parcel));
    }
}
