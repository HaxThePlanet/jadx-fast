package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum z9 implements com.google.android.gms.internal.firebase-auth-api.zr {

    UNKNOWN_KEYMATERIAL(false),
    SYMMETRIC(true),
    ASYMMETRIC_PRIVATE(2),
    ASYMMETRIC_PUBLIC(3),
    REMOTE(4),
    UNRECOGNIZED(-1);

    private final int zzi;
    public static com.google.android.gms.internal.firebase-auth-api.z9 zzb(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return null;
                        }
                        return z9.zze;
                    }
                    return z9.zzd;
                }
                return z9.zzc;
            }
            return z9.zzb;
        }
        return z9.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        com.google.android.gms.internal.firebase-auth-api.z9 zzf;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(z9.class.getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != z9.zzf) {
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
        if (this == z9.zzf) {
        } else {
            return this.zzi;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
