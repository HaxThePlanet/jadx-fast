package com.google.firebase.auth;

/* loaded from: classes2.dex */
public class GoogleAuthProvider {

    public static final String GOOGLE_SIGN_IN_METHOD = "google.com";
    public static final String PROVIDER_ID = "google.com";
    public static com.google.firebase.auth.AuthCredential getCredential(String string, String string2) {
        GoogleAuthCredential googleAuthCredential = new GoogleAuthCredential(string, string2);
        return googleAuthCredential;
    }
}
