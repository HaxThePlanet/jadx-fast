package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class e2 {

    private final com.google.android.gms.internal.firebase-auth-api.fa a;
    private e2(com.google.android.gms.internal.firebase-auth-api.fa fa) {
        super();
        this.a = fa;
    }

    public static com.google.android.gms.internal.firebase-auth-api.e2 e(String string, byte[] b2Arr2, int i3) {
        com.google.android.gms.internal.firebase-auth-api.hb obj2;
        final com.google.android.gms.internal.firebase-auth-api.ea eaVar = fa.z();
        eaVar.m(string);
        eaVar.s(wq.v(b2Arr2));
        obj2 = hb.zza;
        i3--;
        if (obj4 != null) {
            if (obj4 != 1) {
                obj2 = obj4 != 2 ? hb.zze : hb.zzd;
            } else {
                obj2 = hb.zzc;
            }
        } else {
            obj2 = hb.zzb;
        }
        eaVar.j(obj2);
        e2 e2Var = new e2((fa)eaVar.e());
        return e2Var;
    }

    final com.google.android.gms.internal.firebase-auth-api.fa a() {
        return this.a;
    }

    public final String b() {
        return this.a.E();
    }

    public final byte[] c() {
        return this.a.D().B();
    }

    public final int d() {
        int i;
        com.google.android.gms.internal.firebase-auth-api.hb zza = hb.zza;
        int ordinal = this.a.C().ordinal();
        if (ordinal != 1 && ordinal != 2 && ordinal != 3) {
            if (ordinal != 2) {
                if (ordinal != 3) {
                    int i2 = 4;
                    if (ordinal != i2) {
                    } else {
                        return i2;
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown output prefix type");
                    throw illegalArgumentException;
                }
            }
        }
        return i;
    }
}
