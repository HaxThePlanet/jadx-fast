package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public enum ca implements com.google.android.gms.internal.firebase-auth-api.zr {

    UNKNOWN_STATUS(false),
    ENABLED(true),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);

    private final int zzh;
    public static com.google.android.gms.internal.firebase-auth-api.ca zzb(int i) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return ca.zzd;
                }
                return ca.zzc;
            }
            return ca.zzb;
        }
        return ca.zza;
    }

    @Override // java.lang.Enum
    public final String toString() {
        com.google.android.gms.internal.firebase-auth-api.ca zze;
        StringBuilder stringBuilder = new StringBuilder("<");
        stringBuilder.append(ca.class.getName());
        stringBuilder.append('@');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != ca.zze) {
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
        if (this == ca.zze) {
        } else {
            return this.zzh;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw illegalArgumentException;
    }
}
