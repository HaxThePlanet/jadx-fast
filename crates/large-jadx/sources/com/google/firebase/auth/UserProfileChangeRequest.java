package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class UserProfileChangeRequest extends a {

    public static final Parcelable.Creator<com.google.firebase.auth.UserProfileChangeRequest> CREATOR;
    private String zza;
    private String zzb;
    private boolean zzc;
    private boolean zzd;
    private Uri zze;

    public static class Builder {

        private String zza;
        private Uri zzb;
        private boolean zzc;
        private boolean zzd;
        public com.google.firebase.auth.UserProfileChangeRequest build() {
            int string;
            Uri zzb = this.zzb;
            if (zzb == null) {
                string = 0;
            } else {
                string = zzb.toString();
            }
            UserProfileChangeRequest userProfileChangeRequest = new UserProfileChangeRequest(this.zza, string, this.zzc, this.zzd);
            return userProfileChangeRequest;
        }

        public String getDisplayName() {
            return this.zza;
        }

        public Uri getPhotoUri() {
            return this.zzb;
        }

        public com.google.firebase.auth.UserProfileChangeRequest.Builder setDisplayName(String string) {
            int obj1;
            if (string == null) {
                this.zzc = true;
            } else {
                this.zza = string;
            }
            return this;
        }

        public com.google.firebase.auth.UserProfileChangeRequest.Builder setPhotoUri(Uri uri) {
            int obj1;
            if (uri == null) {
                this.zzd = true;
            } else {
                this.zzb = uri;
            }
            return this;
        }
    }
    static {
        zzah zzah = new zzah();
        UserProfileChangeRequest.CREATOR = zzah;
    }

    UserProfileChangeRequest(String string, String string2, boolean z3, boolean z4) {
        int obj1;
        super();
        this.zza = string;
        this.zzb = string2;
        this.zzc = z3;
        this.zzd = z4;
        if (TextUtils.isEmpty(string2)) {
            obj1 = 0;
        } else {
            obj1 = Uri.parse(string2);
        }
        this.zze = obj1;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getDisplayName() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public Uri getPhotoUri() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void writeToParcel(Parcel parcel, int i2) {
        final int i6 = 0;
        b.o(parcel, 2, getDisplayName(), i6);
        b.o(parcel, 3, this.zzb, i6);
        b.c(parcel, 4, this.zzc);
        b.c(parcel, 5, this.zzd);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final boolean zzc() {
        return this.zzd;
    }
}
