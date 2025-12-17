package com.google.firebase.installations.remote;

/* loaded from: classes2.dex */
public abstract class InstallationResponse {

    public static abstract class Builder {
        public abstract com.google.firebase.installations.remote.InstallationResponse build();

        public abstract com.google.firebase.installations.remote.InstallationResponse.Builder setAuthToken(com.google.firebase.installations.remote.TokenResult tokenResult);

        public abstract com.google.firebase.installations.remote.InstallationResponse.Builder setFid(String string);

        public abstract com.google.firebase.installations.remote.InstallationResponse.Builder setRefreshToken(String string);

        public abstract com.google.firebase.installations.remote.InstallationResponse.Builder setResponseCode(com.google.firebase.installations.remote.InstallationResponse.ResponseCode installationResponse$ResponseCode);

        public abstract com.google.firebase.installations.remote.InstallationResponse.Builder setUri(String string);
    }

    public static enum ResponseCode {

        OK,
        BAD_CONFIG;
    }
    public static com.google.firebase.installations.remote.InstallationResponse.Builder builder() {
        AutoValue_InstallationResponse.Builder builder = new AutoValue_InstallationResponse.Builder();
        return builder;
    }

    public abstract com.google.firebase.installations.remote.TokenResult getAuthToken();

    public abstract String getFid();

    public abstract String getRefreshToken();

    public abstract com.google.firebase.installations.remote.InstallationResponse.ResponseCode getResponseCode();

    public abstract String getUri();

    public abstract com.google.firebase.installations.remote.InstallationResponse.Builder toBuilder();
}
