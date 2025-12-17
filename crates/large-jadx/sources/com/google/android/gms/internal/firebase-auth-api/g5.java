package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
final class g5 {
    public static String a(com.google.android.gms.internal.firebase-auth-api.l9 l9) {
        com.google.android.gms.internal.firebase-auth-api.l8 zza = l8.zza;
        com.google.android.gms.internal.firebase-auth-api.g9 zza2 = g9.zza;
        com.google.android.gms.internal.firebase-auth-api.l9 zza3 = l9.zza;
        int ordinal = l9.ordinal();
        if (ordinal != 1 && ordinal != 2 && ordinal != 3 && ordinal != 4) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    if (ordinal != 4) {
                        if (ordinal != 5) {
                        } else {
                            return "HmacSha224";
                        }
                        String obj3 = String.valueOf(l9);
                        StringBuilder stringBuilder = new StringBuilder(length += 27);
                        stringBuilder.append("hash unsupported for HMAC: ");
                        stringBuilder.append(obj3);
                        NoSuchAlgorithmException noSuchAlgorithmException = new NoSuchAlgorithmException(stringBuilder.toString());
                        throw noSuchAlgorithmException;
                    }
                    return "HmacSha512";
                }
                return "HmacSha256";
            }
            return "HmacSha384";
        }
        return "HmacSha1";
    }

    public static void b(com.google.android.gms.internal.firebase-auth-api.v8 v8) {
        kc.f(g5.c(v8.E().C()));
        g5.a(v8.E().D());
        if (v8.z() == l8.zza) {
        } else {
            c3.c(v8.A().C());
        }
        GeneralSecurityException obj2 = new GeneralSecurityException("unknown EC point format");
        throw obj2;
    }

    public static int c(com.google.android.gms.internal.firebase-auth-api.g9 g9) {
        int i;
        com.google.android.gms.internal.firebase-auth-api.l8 zza = l8.zza;
        com.google.android.gms.internal.firebase-auth-api.g9 zza2 = g9.zza;
        com.google.android.gms.internal.firebase-auth-api.l9 zza3 = l9.zza;
        int ordinal = g9.ordinal();
        if (ordinal != 1 && ordinal != 2) {
            if (ordinal != 2) {
                int i2 = 3;
                if (ordinal != i2) {
                } else {
                    return i2;
                }
                String obj3 = String.valueOf(g9);
                StringBuilder stringBuilder = new StringBuilder(length += 20);
                stringBuilder.append("unknown curve type: ");
                stringBuilder.append(obj3);
                GeneralSecurityException generalSecurityException = new GeneralSecurityException(stringBuilder.toString());
                throw generalSecurityException;
            }
        }
        return i;
    }

    public static int d(com.google.android.gms.internal.firebase-auth-api.l8 l8) {
        int i;
        com.google.android.gms.internal.firebase-auth-api.l8 zza = l8.zza;
        com.google.android.gms.internal.firebase-auth-api.g9 zza2 = g9.zza;
        com.google.android.gms.internal.firebase-auth-api.l9 zza3 = l9.zza;
        int ordinal = l8.ordinal();
        if (ordinal != 1 && ordinal != 2) {
            if (ordinal != 2) {
                int i2 = 3;
                if (ordinal != i2) {
                } else {
                    return i2;
                }
                String obj3 = String.valueOf(l8);
                StringBuilder stringBuilder = new StringBuilder(length += 22);
                stringBuilder.append("unknown point format: ");
                stringBuilder.append(obj3);
                GeneralSecurityException generalSecurityException = new GeneralSecurityException(stringBuilder.toString());
                throw generalSecurityException;
            }
        }
        return i;
    }
}
