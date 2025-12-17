package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class b9 extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.b9, com.google.android.gms.internal.firebase-auth-api.a9> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.b9 zzb;
    private int zze;
    private com.google.android.gms.internal.firebase-auth-api.v8 zzf;
    private com.google.android.gms.internal.firebase-auth-api.wq zzg;
    private com.google.android.gms.internal.firebase-auth-api.wq zzh;
    static {
        b9 b9Var = new b9();
        b9.zzb = b9Var;
        xr.h(b9.class, b9Var);
    }

    private b9() {
        super();
        final com.google.android.gms.internal.firebase-auth-api.wq wqVar = wq.a;
        this.zzg = wqVar;
        this.zzh = wqVar;
    }

    public static com.google.android.gms.internal.firebase-auth-api.a9 B() {
        return (a9)b9.zzb.s();
    }

    static com.google.android.gms.internal.firebase-auth-api.b9 C() {
        return b9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.b9 D() {
        return b9.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.b9 E(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (b9)xr.v(b9.zzb, wq, lr2);
    }

    static void H(com.google.android.gms.internal.firebase-auth-api.b9 b9, int i2) {
        b9.zze = 0;
    }

    static void I(com.google.android.gms.internal.firebase-auth-api.b9 b9, com.google.android.gms.internal.firebase-auth-api.v8 v82) {
        v82.getClass();
        b9.zzf = v82;
    }

    static void J(com.google.android.gms.internal.firebase-auth-api.b9 b9, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        b9.zzg = wq2;
    }

    static void K(com.google.android.gms.internal.firebase-auth-api.b9 b9, com.google.android.gms.internal.firebase-auth-api.wq wq2) {
        b9.zzh = wq2;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.v8 A() {
        com.google.android.gms.internal.firebase-auth-api.v8 zzf;
        if (this.zzf == null) {
            zzf = v8.D();
        }
        return zzf;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq F() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final com.google.android.gms.internal.firebase-auth-api.wq G() {
        return this.zzh;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj5 = 1;
        int obj6 = 4;
        final int i2 = 3;
        final int i3 = 2;
        obj5 = 0;
        if (obj4 != null && obj4 != i3 && obj4 != i2 && obj4 != obj6 && obj4 != 5) {
            obj6 = 4;
            i2 = 3;
            i3 = 2;
            if (obj4 != i3) {
                if (obj4 != i2) {
                    obj5 = 0;
                    if (obj4 != obj6) {
                        if (obj4 != 5) {
                            return obj5;
                        }
                        return b9.zzb;
                    }
                    a9 obj4 = new a9(obj5);
                    return obj4;
                }
                obj4 = new b9();
                return obj4;
            }
            obj4 = new Object[obj6];
            obj4[0] = "zze";
            obj4[obj5] = "zzf";
            obj4[i3] = "zzg";
            obj4[i2] = "zzh";
            return xr.f(b9.zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", obj4);
        }
        return Byte.valueOf(obj5);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    public final int z() {
        return this.zze;
    }
}
