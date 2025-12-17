package com.google.android.gms.internal.firebase-auth-api;

import com.google.firebase.auth.internal.zzai;
import java.util.List;

/* loaded from: classes2.dex */
final class ug implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.ko> {

    final com.google.android.gms.internal.firebase-auth-api.cn a;
    final com.google.android.gms.internal.firebase-auth-api.to b;
    final com.google.android.gms.internal.firebase-auth-api.vg c;
    ug(com.google.android.gms.internal.firebase-auth-api.vg vg, com.google.android.gms.internal.firebase-auth-api.cn cn2, com.google.android.gms.internal.firebase-auth-api.to to3) {
        this.c = vg;
        this.a = cn2;
        this.b = to3;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        boolean empty;
        List obj7 = (ko)object.j2();
        if (obj7 != null && obj7.isEmpty()) {
            if (obj7.isEmpty()) {
            }
            kp kpVar = new kp();
            kpVar.d(this.b.zze());
            kpVar.a(obj7.a);
            obj7 = this.c;
            sh.v(obj7.c, obj7.b, this.b, (mo)obj7.get(0), kpVar, this.a);
        }
        this.a.zza("No users.");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        vgVar.b.h(zzai.zza(string));
    }
}
