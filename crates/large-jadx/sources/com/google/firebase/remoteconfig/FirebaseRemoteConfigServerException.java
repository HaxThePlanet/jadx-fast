package com.google.firebase.remoteconfig;

/* loaded from: classes2.dex */
public class FirebaseRemoteConfigServerException extends com.google.firebase.remoteconfig.FirebaseRemoteConfigException {

    private final int httpStatusCode;
    public FirebaseRemoteConfigServerException(int i, String string2) {
        super(string2);
        this.httpStatusCode = i;
    }

    public FirebaseRemoteConfigServerException(int i, String string2, Throwable throwable3) {
        super(string2, throwable3);
        this.httpStatusCode = i;
    }

    @Override // com.google.firebase.remoteconfig.FirebaseRemoteConfigException
    public int getHttpStatusCode() {
        return this.httpStatusCode;
    }
}
