package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum l8 implements com.google.android.gms.internal.firebase-auth-api.zr {

    UNKNOWN_FORMAT(false),
    UNCOMPRESSED(true),
    COMPRESSED(2),
    DO_NOT_USE_CRUNCHY_UNCOMPRESSED(3),
    UNRECOGNIZED(-1);

    private final int zzh;
    public static com.google.android.gms.internal.firebase-auth-api.l8 zzb(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return l8.zzd;
                }
                return l8.zzc;
            }
            return l8.zzb;
        }
        return l8.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        com.google.android.gms.internal.firebase-auth-api.l8 zze;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(l8.class.getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != l8.zze) {
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
        if (this == l8.zze) {
        } else {
            return this.zzh;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
