package com.google.firebase.auth;

/* loaded from: classes2.dex */
public abstract class OAuthCredential extends com.google.firebase.auth.AuthCredential {
    @Override // com.google.firebase.auth.AuthCredential
    public abstract String getAccessToken();

    @Override // com.google.firebase.auth.AuthCredential
    public abstract String getIdToken();

    @Override // com.google.firebase.auth.AuthCredential
    public abstract String getSecret();
}
