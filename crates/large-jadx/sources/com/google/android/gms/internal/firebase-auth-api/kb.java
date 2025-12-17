package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: classes2.dex */
@Deprecated
public final class kb extends com.google.android.gms.internal.firebase-auth-api.xr<com.google.android.gms.internal.firebase-auth-api.kb, com.google.android.gms.internal.firebase-auth-api.jb> implements com.google.android.gms.internal.firebase-auth-api.a0 {

    private static final com.google.android.gms.internal.firebase-auth-api.kb zzb;
    private String zze;
    private com.google.android.gms.internal.firebase-auth-api.d<com.google.android.gms.internal.firebase-auth-api.ia> zzf;
    static {
        kb kbVar = new kb();
        kb.zzb = kbVar;
        xr.h(kb.class, kbVar);
    }

    private kb() {
        super();
        this.zze = "";
        this.zzf = xr.y();
    }

    public static com.google.android.gms.internal.firebase-auth-api.kb A() {
        return kb.zzb;
    }

    static com.google.android.gms.internal.firebase-auth-api.kb z() {
        return kb.zzb;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.xr
    protected final Object q(int i, Object object2, Object object3) {
        i--;
        int obj4 = 1;
        int obj5 = 3;
        final int i2 = 2;
        obj5 = 0;
        if (obj3 != null && obj3 != i2 && obj3 != obj5 && obj3 != 4 && obj3 != 5) {
            obj5 = 3;
            i2 = 2;
            if (obj3 != i2) {
                if (obj3 != obj5) {
                    obj5 = 0;
                    if (obj3 != 4) {
                        if (obj3 != 5) {
                            return obj5;
                        }
                        return kb.zzb;
                    }
                    jb obj3 = new jb(obj5);
                    return obj3;
                }
                obj3 = new kb();
                return obj3;
            }
            obj3 = new Object[obj5];
            obj3[0] = "zze";
            obj3[obj4] = "zzf";
            obj3[i2] = ia.class;
            return xr.f(kb.zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", obj3);
        }
        return Byte.valueOf(obj4);
    }
}
