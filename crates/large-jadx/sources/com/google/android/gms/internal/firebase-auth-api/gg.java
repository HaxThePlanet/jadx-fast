package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.firebase.auth.zze;
import java.util.List;

/* loaded from: classes2.dex */
final class gg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.ko> {

    final com.google.android.gms.internal.firebase-auth-api.bn a;
    final String b;
    final String c;
    final Boolean d;
    final zze e;
    final com.google.android.gms.internal.firebase-auth-api.nl f;
    final com.google.android.gms.internal.firebase-auth-api.to g;
    gg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.bn bn2, String string3, String string4, Boolean boolean5, zze zze6, com.google.android.gms.internal.firebase-auth-api.nl nl7, com.google.android.gms.internal.firebase-auth-api.to to8) {
        this.a = bn2;
        this.b = string3;
        this.c = string4;
        this.d = boolean5;
        this.e = zze6;
        this.f = nl7;
        this.g = to8;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        int i;
        boolean empty;
        List list;
        boolean equals;
        String str;
        List obj5 = (ko)object.j2();
        if (obj5 != null) {
            if (obj5.isEmpty()) {
            } else {
                i = 0;
                obj5 = obj5.get(i);
                com.google.android.gms.internal.firebase-auth-api.bp bpVar = (mo)obj5.u2();
                if (bpVar != null) {
                    list = bpVar.l2();
                } else {
                    list = 0;
                }
                if (list != null && !list.isEmpty()) {
                    if (!list.isEmpty()) {
                        if (!TextUtils.isEmpty(this.b)) {
                        } else {
                            (zo)list.get(i).k2(this.c);
                        }
                    }
                }
            }
            obj5.q2(this.d.booleanValue());
            obj5.n2(this.e);
            this.f.i(this.g, obj5);
        }
        this.a.zza("No users.");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.zza(string);
    }
}
