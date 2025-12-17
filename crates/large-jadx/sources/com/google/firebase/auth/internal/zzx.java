package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.internal.firebase-auth-api.to;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zze;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzx extends FirebaseUser {

    public static final Parcelable.Creator<com.google.firebase.auth.internal.zzx> CREATOR;
    private to zza;
    private com.google.firebase.auth.internal.zzt zzb;
    private final String zzc;
    private String zzd;
    private List<com.google.firebase.auth.internal.zzt> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private com.google.firebase.auth.internal.zzz zzi;
    private boolean zzj;
    private zze zzk;
    private com.google.firebase.auth.internal.zzbb zzl;
    static {
        zzy zzy = new zzy();
        zzx.CREATOR = zzy;
    }

    zzx(to to, com.google.firebase.auth.internal.zzt zzt2, String string3, String string4, List<com.google.firebase.auth.internal.zzt> list5, List<String> list6, String string7, Boolean boolean8, com.google.firebase.auth.internal.zzz zzz9, boolean z10, zze zze11, com.google.firebase.auth.internal.zzbb zzbb12) {
        super();
        this.zza = to;
        this.zzb = zzt2;
        this.zzc = string3;
        this.zzd = string4;
        this.zze = list5;
        this.zzf = list6;
        this.zzg = string7;
        this.zzh = boolean8;
        this.zzi = zzz9;
        this.zzj = z10;
        this.zzk = zze11;
        this.zzl = zzbb12;
    }

    public zzx(FirebaseApp firebaseApp, List<? extends UserInfo> list2) {
        super();
        r.j(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zzc(list2);
    }

    public static FirebaseUser zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser2) {
        Object providerData;
        int obj2;
        zzx zzx = new zzx(firebaseApp, firebaseUser2.getProviderData());
        if (firebaseUser2 instanceof zzx) {
            obj2 = firebaseUser2;
            zzx.zzg = obj2.zzg;
            zzx.zzd = obj2.zzd;
            zzx.zzi = obj2.zzi;
        } else {
            zzx.zzi = 0;
        }
        if (firebaseUser2.zzd() != null) {
            zzx.zzh(firebaseUser2.zzd());
        }
        if (!firebaseUser2.isAnonymous()) {
            zzx.zzm();
        }
        return zzx;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final MultiFactor getMultiFactor() {
        zzac zzac = new zzac(this);
        return zzac;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    public final List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getTenantId() {
        Object zza;
        String str;
        zza = this.zza;
        zza = zzay.zza(this.zza.zze()).getClaims().get("firebase");
        if (zza != null && zza.zze() != null && (Map)zza != null) {
            if (zza.zze() != null) {
                zza = zzay.zza(this.zza.zze()).getClaims().get("firebase");
                if ((Map)(Map)zza != null) {
                    return (String)(Map)(Map)zza.get("tenant");
                }
            }
        }
        return null;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String getUid() {
        return this.zzb.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isAnonymous() {
        Boolean booleanValue;
        String signInProvider;
        int size;
        int i2;
        int i;
        booleanValue = this.zzh;
        if (booleanValue != null) {
            if (booleanValue.booleanValue()) {
                to zza = this.zza;
                if (zza != null) {
                    signInProvider = zzay.zza(zza.zze()).getSignInProvider();
                } else {
                    signInProvider = "";
                }
                i2 = 0;
                i = 1;
                if (this.zze.size() <= i) {
                    if (signInProvider != null) {
                        if (!signInProvider.equals("custom")) {
                            i2 = i;
                        }
                    } else {
                    }
                }
                this.zzh = Boolean.valueOf(i2);
            }
        } else {
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i15 = 0;
        b.n(parcel, 1, this.zza, i2, i15);
        b.n(parcel, 2, this.zzb, i2, i15);
        b.o(parcel, 3, this.zzc, i15);
        b.o(parcel, 4, this.zzd, i15);
        b.s(parcel, 5, this.zze, i15);
        b.q(parcel, 6, this.zzf, i15);
        b.o(parcel, 7, this.zzg, i15);
        b.d(parcel, 8, Boolean.valueOf(isAnonymous()), i15);
        b.n(parcel, 9, this.zzi, i2, i15);
        b.c(parcel, 10, this.zzj);
        b.n(parcel, 11, this.zzk, i2, i15);
        b.n(parcel, 12, this.zzl, i2, i15);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseUser zzb() {
        zzm();
        return this;
    }

    public final FirebaseUser zzc(List<? extends UserInfo> list) {
        int i;
        Object obj;
        List zze;
        Object zzf;
        String providerId;
        Object obj6;
        r.j(list);
        ArrayList arrayList = new ArrayList(list.size());
        this.zze = arrayList;
        ArrayList arrayList2 = new ArrayList(list.size());
        this.zzf = arrayList2;
        int i2 = 0;
        i = i2;
        while (i < list.size()) {
            obj = list.get(i);
            if ((UserInfo)obj.getProviderId().equals("firebase")) {
            } else {
            }
            this.zzf.add(obj.getProviderId());
            this.zze.add((zzt)obj);
            i++;
            this.zzb = (zzt)obj;
        }
        if (this.zzb == null) {
            this.zzb = (zzt)this.zze.get(i2);
        }
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final to zzd() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zze() {
        return this.zza.zze();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzf() {
        return this.zza.zzh();
    }

    public final List<String> zzg() {
        return this.zzf;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzh(to to) {
        r.j(to);
        this.zza = (to)to;
    }

    public final void zzi(List<MultiFactorInfo> list) {
        int i;
        boolean empty;
        boolean z;
        com.google.firebase.auth.internal.zzbb obj4;
        Parcelable.Creator cREATOR = zzbb.CREATOR;
        i = 0;
        if (list != null) {
            if (list.isEmpty()) {
            } else {
                ArrayList arrayList = new ArrayList();
                obj4 = list.iterator();
                while (obj4.hasNext()) {
                    empty = obj4.next();
                    if (empty instanceof PhoneMultiFactorInfo) {
                    }
                    arrayList.add((PhoneMultiFactorInfo)(MultiFactorInfo)empty);
                }
                obj4 = new zzbb(arrayList);
                i = obj4;
            }
        }
        this.zzl = i;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zze zzj() {
        return this.zzk;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final com.google.firebase.auth.internal.zzx zzl(String string) {
        this.zzg = string;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final com.google.firebase.auth.internal.zzx zzm() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    public final List<MultiFactorInfo> zzn() {
        Object arrayList;
        com.google.firebase.auth.internal.zzbb zzl = this.zzl;
        if (zzl != null) {
            arrayList = zzl.zza();
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public final List<com.google.firebase.auth.internal.zzt> zzo() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzp(zze zze) {
        this.zzk = zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzq(boolean z) {
        this.zzj = z;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzr(com.google.firebase.auth.internal.zzz zzz) {
        this.zzi = zzz;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final boolean zzs() {
        return this.zzj;
    }
}
