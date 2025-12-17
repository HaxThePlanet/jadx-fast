package com.google.firebase.auth;

import com.google.android.gms.common.internal.r;

/* loaded from: classes2.dex */
public class EmailAuthProvider {

    public static final String EMAIL_LINK_SIGN_IN_METHOD = "emailLink";
    public static final String EMAIL_PASSWORD_SIGN_IN_METHOD = "password";
    public static final String PROVIDER_ID = "password";
    public static com.google.firebase.auth.AuthCredential getCredential(String string, String string2) {
        r.f(string);
        r.f(string2);
        super(string, string2, 0, 0, 0);
        return emailAuthCredential2;
    }

    public static com.google.firebase.auth.AuthCredential getCredentialWithLink(String string, String string2) {
        if (!EmailAuthCredential.zzi(string2)) {
        } else {
            super(string, 0, string2, 0, 0);
            return emailAuthCredential;
        }
        IllegalArgumentException obj7 = new IllegalArgumentException("Given link is not a valid email link. Please use FirebaseAuth#isSignInWithEmailLink(String) to determine this before calling this function");
        throw obj7;
    }
}
