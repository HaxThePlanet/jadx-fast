package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.b;
import com.google.android.gms.common.l.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class nn extends com.google.android.gms.internal.firebase-auth-api.nl {

    private final String c;
    final com.google.android.gms.internal.firebase-auth-api.qn d;
    public nn(com.google.android.gms.internal.firebase-auth-api.qn qn, com.google.android.gms.internal.firebase-auth-api.nl nl2, String string3) {
        this.d = qn;
        super(nl2);
        this.c = string3;
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.nl
    public final void b(String string) {
        Object obj;
        String next;
        boolean obj6;
        qn.a().a("onCodeSent", new Object[0]);
        obj = qn.d(this.d).get(this.c);
        if ((pn)obj == null) {
        }
        Iterator iterator = obj.b.iterator();
        for (nl next : iterator) {
            next.b(string);
        }
        obj.g = true;
        obj.d = string;
        if (Long.compare(l, i3) <= 0) {
            qn.f(this.d, this.c);
        }
        if (!obj.c) {
            qn.g(this.d, this.c);
        }
        if (!t1.d(obj.e)) {
            qn.e(this.d, this.c);
        }
    }

    @Override // com.google.android.gms.internal.firebase-auth-api.nl
    public final void h(Status status) {
        String next;
        String str2 = b.a(status.k2());
        String str4 = status.l2();
        StringBuilder stringBuilder = new StringBuilder(i3 += length2);
        stringBuilder.append("SMS verification code request failed: ");
        stringBuilder.append(str2);
        stringBuilder.append(" ");
        stringBuilder.append(str4);
        qn.a().c(stringBuilder.toString(), new Object[0]);
        Object obj = qn.d(this.d).get(this.c);
        if ((pn)obj == null) {
        }
        Iterator iterator = obj.b.iterator();
        for (nl next : iterator) {
            next.h(status);
        }
        this.d.j(this.c);
    }
}
