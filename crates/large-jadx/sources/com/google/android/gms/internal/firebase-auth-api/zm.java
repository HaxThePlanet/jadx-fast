package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.k;
import com.google.firebase.auth.FirebaseAuth;

/* loaded from: classes2.dex */
public final class zm<ResultT, CallbackT>  {

    private final com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> a;
    private final k<ResultT> b;
    public zm(com.google.android.gms.internal.firebase-auth-api.an<ResultT, CallbackT> an, k<ResultT> k2) {
        super();
        this.a = an;
        this.b = k2;
    }

    public final void a(ResultT resultt, Status status2) {
        int i;
        boolean equals;
        String str;
        r.k(this.b, "completion source cannot be null");
        com.google.android.gms.internal.firebase-auth-api.an obj4 = this.a;
        if (status2 != null && obj4.r != null) {
            obj4 = this.a;
            if (obj4.r != null) {
                com.google.android.gms.internal.firebase-auth-api.an anVar = this.a;
                if (!"reauthenticateWithCredential".equals(anVar.zzb())) {
                    if ("reauthenticateWithCredentialWithData".equals(this.a.zzb())) {
                        i = anVar3.d;
                    } else {
                        i = 0;
                    }
                } else {
                }
                this.b.b(ql.c(FirebaseAuth.getInstance(obj4.c), anVar.r, i));
            }
            com.google.firebase.auth.AuthCredential authCredential = obj4.o;
            if (authCredential != null) {
                this.b.b(ql.b(status2, authCredential, obj4.p, obj4.q));
            }
            this.b.b(ql.a(status2));
        }
        this.b.c(resultt);
    }
}
