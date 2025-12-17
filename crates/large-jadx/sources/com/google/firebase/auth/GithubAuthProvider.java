package com.google.firebase.auth;

/* loaded from: classes2.dex */
public class GithubAuthProvider {

    public static final String GITHUB_SIGN_IN_METHOD = "github.com";
    public static final String PROVIDER_ID = "github.com";
    public static com.google.firebase.auth.AuthCredential getCredential(String string) {
        GithubAuthCredential githubAuthCredential = new GithubAuthCredential(string);
        return githubAuthCredential;
    }
}
