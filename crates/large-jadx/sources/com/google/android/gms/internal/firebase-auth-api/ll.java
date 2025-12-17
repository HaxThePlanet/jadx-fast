package com.google.android.gms.internal.firebase-auth-api;

import android.content.Context;
import com.google.android.gms.common.api.c.a.a;
import com.google.android.gms.common.e;
import com.google.firebase.FirebaseExceptionMapper;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class ll implements Callable<com.google.android.gms.internal.firebase-auth-api.th<com.google.android.gms.internal.firebase-auth-api.im>> {

    private final com.google.android.gms.internal.firebase-auth-api.im a;
    private final Context b;
    public ll(com.google.android.gms.internal.firebase-auth-api.im im, Context context2) {
        super();
        this.a = im;
        this.b = context2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        int i2;
        int i;
        int i3 = e.o().h(this.b, 12451000);
        int i4 = 1;
        if (i3 != 0) {
            if (i3 == 2) {
                i2 = i4;
            } else {
                i2 = 0;
            }
        } else {
        }
        ml.a(i2);
        com.google.android.gms.internal.firebase-auth-api.im imVar2 = this.a.a();
        imVar2.a = i4;
        c.a.a aVar2 = new c.a.a();
        FirebaseExceptionMapper firebaseExceptionMapper = new FirebaseExceptionMapper();
        aVar2.c(firebaseExceptionMapper);
        vh vhVar = new vh(this.b, jm.c, imVar2, aVar2.a());
        th thVar = new th(vhVar);
        return thVar;
    }
}
