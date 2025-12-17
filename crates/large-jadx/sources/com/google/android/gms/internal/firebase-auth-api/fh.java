package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class fh implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.ko> {

    final com.google.android.gms.internal.firebase-auth-api.cn a;
    final com.google.android.gms.internal.firebase-auth-api.to b;
    final com.google.android.gms.internal.firebase-auth-api.gh c;
    fh(com.google.android.gms.internal.firebase-auth-api.gh gh, com.google.android.gms.internal.firebase-auth-api.cn cn2, com.google.android.gms.internal.firebase-auth-api.to to3) {
        this.c = gh;
        this.a = cn2;
        this.b = to3;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        boolean empty;
        List obj4 = (ko)object.j2();
        if (obj4 != null && obj4.isEmpty()) {
            if (obj4.isEmpty()) {
            }
            ghVar.a.i(this.b, (mo)obj4.get(0));
        }
        this.a.zza("No users");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.zza(string);
    }
}
