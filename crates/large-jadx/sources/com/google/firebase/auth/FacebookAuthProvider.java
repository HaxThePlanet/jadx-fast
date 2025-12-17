package com.google.firebase.auth;

/* loaded from: classes2.dex */
public class FacebookAuthProvider {

    public static final String FACEBOOK_SIGN_IN_METHOD = "facebook.com";
    public static final String PROVIDER_ID = "facebook.com";
    public static com.google.firebase.auth.AuthCredential getCredential(String string) {
        FacebookAuthCredential facebookAuthCredential = new FacebookAuthCredential(string);
        return facebookAuthCredential;
    }
}
