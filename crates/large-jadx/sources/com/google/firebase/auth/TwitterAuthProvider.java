package com.google.firebase.auth;

/* loaded from: classes2.dex */
public class TwitterAuthProvider {

    public static final String PROVIDER_ID = "twitter.com";
    public static final String TWITTER_SIGN_IN_METHOD = "twitter.com";
    public static com.google.firebase.auth.AuthCredential getCredential(String string, String string2) {
        TwitterAuthCredential twitterAuthCredential = new TwitterAuthCredential(string, string2);
        return twitterAuthCredential;
    }
}
