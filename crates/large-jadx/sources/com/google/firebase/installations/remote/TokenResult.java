package com.google.firebase.installations.remote;

/* loaded from: classes2.dex */
public abstract class TokenResult {

    public static abstract class Builder {
        public abstract com.google.firebase.installations.remote.TokenResult build();

        public abstract com.google.firebase.installations.remote.TokenResult.Builder setResponseCode(com.google.firebase.installations.remote.TokenResult.ResponseCode tokenResult$ResponseCode);

        public abstract com.google.firebase.installations.remote.TokenResult.Builder setToken(String string);

        public abstract com.google.firebase.installations.remote.TokenResult.Builder setTokenExpirationTimestamp(long l);
    }

    public static enum ResponseCode {

        OK,
        BAD_CONFIG,
        AUTH_ERROR;
    }
    public static com.google.firebase.installations.remote.TokenResult.Builder builder() {
        AutoValue_TokenResult.Builder builder = new AutoValue_TokenResult.Builder();
        return builder.setTokenExpirationTimestamp(0);
    }

    public abstract com.google.firebase.installations.remote.TokenResult.ResponseCode getResponseCode();

    public abstract String getToken();

    public abstract long getTokenExpirationTimestamp();

    public abstract com.google.firebase.installations.remote.TokenResult.Builder toBuilder();
}
