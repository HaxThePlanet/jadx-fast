package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum hb implements com.google.android.gms.internal.firebase-auth-api.zr {

    UNKNOWN_PREFIX(false),
    TINK(true),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    private final int zzi;
    public static com.google.android.gms.internal.firebase-auth-api.hb zzb(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return hb.zze;
                    }
                    return hb.zzd;
                }
                return hb.zzc;
            }
            return hb.zzb;
        }
        return hb.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        com.google.android.gms.internal.firebase-auth-api.hb zzf;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(hb.class.getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != hb.zzf) {
            stringBuilder.append(" number=");
            stringBuilder.append(zza());
        }
        stringBuilder.append(" name=");
        stringBuilder.append(name());
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    @Override // java.lang.Enum
    public final int zza() {
        if (this == hb.zzf) {
        } else {
            return this.zzi;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
