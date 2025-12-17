package com.google.firebase.auth;

import com.google.android.gms.tasks.c;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.m;

/* loaded from: classes2.dex */
final class zzr implements c<Void, j<Void>> {
    zzr(com.google.firebase.auth.FirebaseAuth firebaseAuth) {
        super();
    }

    @Override // com.google.android.gms.tasks.c
    public final Object then(j j) {
        boolean successful;
        String str;
        j obj3;
        if (!j.isSuccessful() && exception instanceof FirebaseAuthException != null && (FirebaseAuthException)j.getException().getErrorCode().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) {
            if (exception instanceof FirebaseAuthException != null) {
                if ((FirebaseAuthException)j.getException().getErrorCode().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) {
                    obj3 = m.e(0);
                }
            }
        }
        return obj3;
    }
}
