package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
public final class qb extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.qb, com.google.android.gms.internal.firebase-auth-api.pb> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.qb zzb;
    private int zze;
    static {
        qb qbVar = new qb();
        qb.zzb = qbVar;
        xr.h(qb.class, qbVar);
    }

    public static com.google.android.gms.internal.firebase-auth-api.qb A() {
        return qb.zzb;
    }

    public static com.google.android.gms.internal.firebase-auth-api.qb B(com.google.android.gms.internal.firebase-auth-api.wq wq, com.google.android.gms.internal.firebase-auth-api.lr lr2) {
        return (qb)xr.v(qb.zzb, wq, lr2);
    }

    static com.google.android.gms.internal.firebase-auth-api.qb z() {
        return qb.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj2 = 1;
        int obj3 = 0;
        if (obj1 != null && obj1 != 2 && obj1 != 3 && obj1 != 4 && obj1 != 5) {
            if (obj1 != 2) {
                if (obj1 != 3) {
                    obj3 = 0;
                    if (obj1 != 4) {
                        if (obj1 != 5) {
                            return obj3;
                        }
                        return qb.zzb;
                    }
                    pb obj1 = new pb(obj3);
                    return obj1;
                }
                obj1 = new qb();
                return obj1;
            }
            obj1 = new Object[obj2];
            obj1[0] = "zze";
            return xr.f(qb.zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", obj1);
        }
        return Byte.valueOf(obj2);
    }
}
