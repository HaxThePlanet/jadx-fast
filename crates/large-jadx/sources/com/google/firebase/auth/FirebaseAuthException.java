package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class FirebaseAuthException extends FirebaseException {

    private final String zza;
    public FirebaseAuthException(String string, String string2) {
        super(string2);
        r.f(string);
        this.zza = string;
    }

    @Override // com.google.firebase.FirebaseException
    public String getErrorCode() {
        return this.zza;
    }
}
