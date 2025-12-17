package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.b;

/* loaded from: classes2.dex */
public class ActionCodeSettings extends a {

    public static final Parcelable.Creator<com.google.firebase.auth.ActionCodeSettings> CREATOR;
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final boolean zze;
    private final String zzf;
    private final boolean zzg;
    private String zzh;
    private int zzi;
    private String zzj;

    public static class Builder {

        private String zza;
        private String zzb;
        private String zzc;
        private boolean zzd;
        private String zze;
        private boolean zzf = false;
        private String zzg;
        private Builder() {
            super();
            final int i = 0;
        }

        Builder(com.google.firebase.auth.zza zza) {
            super();
            final int obj1 = 0;
        }

        static String zza(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zza;
        }

        static String zzb(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zzb;
        }

        static String zzc(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zzc;
        }

        static String zzd(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zze;
        }

        static String zze(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zzg;
        }

        static boolean zzf(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zzd;
        }

        static boolean zzg(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
            return builder.zzf;
        }

        public com.google.firebase.auth.ActionCodeSettings build() {
            if (this.zza == null) {
            } else {
                ActionCodeSettings actionCodeSettings = new ActionCodeSettings(this, 0);
                return actionCodeSettings;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot build ActionCodeSettings with null URL. Call #setUrl(String) before calling build()");
            throw illegalArgumentException;
        }

        public String getDynamicLinkDomain() {
            return this.zzg;
        }

        public boolean getHandleCodeInApp() {
            return this.zzf;
        }

        public String getIOSBundleId() {
            return this.zzb;
        }

        public String getUrl() {
            return this.zza;
        }

        public com.google.firebase.auth.ActionCodeSettings.Builder setAndroidPackageName(String string, boolean z2, String string3) {
            this.zzc = string;
            this.zzd = z2;
            this.zze = string3;
            return this;
        }

        public com.google.firebase.auth.ActionCodeSettings.Builder setDynamicLinkDomain(String string) {
            this.zzg = string;
            return this;
        }

        public com.google.firebase.auth.ActionCodeSettings.Builder setHandleCodeInApp(boolean z) {
            this.zzf = z;
            return this;
        }

        public com.google.firebase.auth.ActionCodeSettings.Builder setIOSBundleId(String string) {
            this.zzb = string;
            return this;
        }

        public com.google.firebase.auth.ActionCodeSettings.Builder setUrl(String string) {
            this.zza = string;
            return this;
        }
    }
    static {
        zzb zzb = new zzb();
        ActionCodeSettings.CREATOR = zzb;
    }

    private ActionCodeSettings(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder) {
        super();
        this.zza = ActionCodeSettings.Builder.zza(builder);
        this.zzb = ActionCodeSettings.Builder.zzb(builder);
        this.zzc = 0;
        this.zzd = ActionCodeSettings.Builder.zzc(builder);
        this.zze = ActionCodeSettings.Builder.zzf(builder);
        this.zzf = ActionCodeSettings.Builder.zzd(builder);
        this.zzg = ActionCodeSettings.Builder.zzg(builder);
        this.zzj = ActionCodeSettings.Builder.zze(builder);
    }

    ActionCodeSettings(com.google.firebase.auth.ActionCodeSettings.Builder actionCodeSettings$Builder, com.google.firebase.auth.zza zza2) {
        super(builder);
    }

    ActionCodeSettings(String string, String string2, String string3, String string4, boolean z5, String string6, boolean z7, String string8, int i9, String string10) {
        super();
        this.zza = string;
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = string4;
        this.zze = z5;
        this.zzf = string6;
        this.zzg = z7;
        this.zzh = string8;
        this.zzi = i9;
        this.zzj = string10;
    }

    public static com.google.firebase.auth.ActionCodeSettings.Builder newBuilder() {
        ActionCodeSettings.Builder builder = new ActionCodeSettings.Builder(0);
        return builder;
    }

    public static com.google.firebase.auth.ActionCodeSettings zzb() {
        ActionCodeSettings.Builder builder = new ActionCodeSettings.Builder(0);
        ActionCodeSettings actionCodeSettings = new ActionCodeSettings(builder);
        return actionCodeSettings;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean canHandleCodeInApp() {
        return this.zzg;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public boolean getAndroidInstallApp() {
        return this.zze;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getAndroidMinimumVersion() {
        return this.zzf;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getAndroidPackageName() {
        return this.zzd;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getIOSBundle() {
        return this.zzb;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public String getUrl() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public void writeToParcel(Parcel parcel, int i2) {
        final int i12 = 0;
        b.o(parcel, 1, getUrl(), i12);
        b.o(parcel, 2, getIOSBundle(), i12);
        b.o(parcel, 3, this.zzc, i12);
        b.o(parcel, 4, getAndroidPackageName(), i12);
        b.c(parcel, 5, getAndroidInstallApp());
        b.o(parcel, 6, getAndroidMinimumVersion(), i12);
        b.c(parcel, 7, canHandleCodeInApp());
        b.o(parcel, 8, this.zzh, i12);
        b.j(parcel, 9, this.zzi);
        b.o(parcel, 10, this.zzj, i12);
        b.b(parcel, b.a(parcel));
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final int zza() {
        return this.zzi;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzc() {
        return this.zzj;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final String zze() {
        return this.zzh;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void zzf(String string) {
        this.zzh = string;
    }

    @Override // com.google.android.gms.common.internal.safeparcel.a
    public final void zzg(int i) {
        this.zzi = i;
    }
}
