package com.google.android.gms.internal.firebase-auth-api;

import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.c;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class fg implements com.google.android.gms.internal.firebase-auth-api.cn<com.google.android.gms.internal.firebase-auth-api.lp> {

    final com.google.android.gms.internal.firebase-auth-api.kp a;
    final com.google.android.gms.internal.firebase-auth-api.mo b;
    final com.google.android.gms.internal.firebase-auth-api.nl c;
    final com.google.android.gms.internal.firebase-auth-api.to d;
    final com.google.android.gms.internal.firebase-auth-api.bn e;
    fg(com.google.android.gms.internal.firebase-auth-api.sh sh, com.google.android.gms.internal.firebase-auth-api.kp kp2, com.google.android.gms.internal.firebase-auth-api.mo mo3, com.google.android.gms.internal.firebase-auth-api.nl nl4, com.google.android.gms.internal.firebase-auth-api.to to5, com.google.android.gms.internal.firebase-auth-api.bn bn6) {
        this.a = kp2;
        this.b = mo3;
        this.c = nl4;
        this.d = to5;
        this.e = bn6;
        super();
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void b(Object object) {
        Object moVar;
        Object str3;
        Object moVar2;
        boolean empty;
        Object arrayList;
        int i;
        com.google.android.gms.internal.firebase-auth-api.to toVar;
        String str;
        String str2;
        boolean valueOf;
        Object obj7;
        i = 0;
        if (this.a.m("EMAIL")) {
            this.b.p2(i);
        } else {
            if (this.a.j() != null) {
                this.b.p2(this.a.j());
            }
        }
        if (this.a.m("DISPLAY_NAME")) {
            this.b.o2(i);
        } else {
            if (this.a.i() != null) {
                this.b.o2(this.a.i());
            }
        }
        if (this.a.m("PHOTO_URL")) {
            this.b.s2(i);
        } else {
            if (this.a.l() != null) {
                this.b.s2(this.a.l());
            }
        }
        if (!TextUtils.isEmpty(this.a.k())) {
            this.b.r2(c.c("redacted".getBytes()));
        }
        if ((lp)object.e() == null) {
            arrayList = new ArrayList();
        }
        this.b.t2(arrayList);
        toVar = this.d;
        r.j(toVar);
        r.j(object);
        String str9 = object.c();
        final String str10 = object.d();
        if (!TextUtils.isEmpty(str9) && !TextUtils.isEmpty(str10)) {
            if (!TextUtils.isEmpty(str10)) {
                obj7 = new to(str10, str9, Long.valueOf(object.a()), toVar.zzg());
                toVar = obj7;
            }
        }
        this.c.i(toVar, this.b);
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.cn
    public final void zza(String string) {
        this.e.zza(string);
    }
}
