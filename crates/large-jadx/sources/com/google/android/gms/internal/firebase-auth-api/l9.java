package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum l9 implements com.google.android.gms.internal.firebase-auth-api.zr {

    UNKNOWN_HASH(false),
    SHA1(true),
    SHA384(2),
    SHA256(3),
    SHA512(4),
    SHA224(5),
    UNRECOGNIZED(-1);

    private final int zzj;
    public static com.google.android.gms.internal.firebase-auth-api.l9 zzb(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return null;
                            }
                            return l9.zzf;
                        }
                        return l9.zze;
                    }
                    return l9.zzd;
                }
                return l9.zzc;
            }
            return l9.zzb;
        }
        return l9.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        com.google.android.gms.internal.firebase-auth-api.l9 zzg;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(l9.class.getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != l9.zzg) {
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
        if (this == l9.zzg) {
        } else {
            return this.zzj;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
