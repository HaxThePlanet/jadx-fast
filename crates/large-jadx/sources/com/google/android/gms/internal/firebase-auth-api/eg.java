package com.google.android.gms.internal.firebase-auth-api;

import java.util.List;

/* loaded from: classes2.dex */
final class eg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.ko> {

    final com.google.android.gms.internal.firebase-auth-api.bn a;
    final com.google.android.gms.internal.firebase-auth-api.nl b;
    final com.google.android.gms.internal.firebase-auth-api.to c;
    final com.google.android.gms.internal.firebase-auth-api.kp d;
    final com.google.android.gms.internal.firebase-auth-api.sh e;
    eg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.bn bn2, com.google.android.gms.internal.firebase-auth-api.nl nl3, com.google.android.gms.internal.firebase-auth-api.to to4, com.google.android.gms.internal.firebase-auth-api.kp kp5) {
        this.e = sh;
        this.a = bn2;
        this.b = nl3;
        this.c = to4;
        this.d = kp5;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        boolean empty;
        List obj8 = (ko)object.j2();
        if (obj8 != null && obj8.isEmpty()) {
            if (obj8.isEmpty()) {
            }
            sh.v(this.e, this.b, this.c, (mo)obj8.get(0), this.d, this.a);
        }
        this.a.zza("No users");
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.a.zza(string);
    }
}
