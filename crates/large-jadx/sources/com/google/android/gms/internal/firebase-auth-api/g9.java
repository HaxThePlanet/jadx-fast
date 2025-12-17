package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum g9 implements com.google.android.gms.internal.firebase-auth-api.zr {

    UNKNOWN_CURVE(false),
    NIST_P256(2),
    NIST_P384(3),
    NIST_P521(4),
    CURVE25519(5),
    UNRECOGNIZED(-1);

    private final int zzi;
    public static com.google.android.gms.internal.firebase-auth-api.g9 zzb(int i) {
        if (i != 0 && i != 2 && i != 3 && i != 4 && i != 5) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return g9.zze;
                    }
                    return g9.zzd;
                }
                return g9.zzc;
            }
            return g9.zzb;
        }
        return g9.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        com.google.android.gms.internal.firebase-auth-api.g9 zzf;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(g9.class.getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != g9.zzf) {
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
        if (this == g9.zzf) {
        } else {
            return this.zzi;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
