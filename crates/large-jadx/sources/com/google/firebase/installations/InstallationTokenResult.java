package com.google.firebase.installations;

/* loaded from: classes2.dex */
public abstract class InstallationTokenResult {

    public static abstract class Builder {
        public abstract com.google.firebase.installations.InstallationTokenResult build();

        public abstract com.google.firebase.installations.InstallationTokenResult.Builder setToken(String string);

        public abstract com.google.firebase.installations.InstallationTokenResult.Builder setTokenCreationTimestamp(long l);

        public abstract com.google.firebase.installations.InstallationTokenResult.Builder setTokenExpirationTimestamp(long l);
    }
    public static com.google.firebase.installations.InstallationTokenResult.Builder builder() {
        AutoValue_InstallationTokenResult.Builder builder = new AutoValue_InstallationTokenResult.Builder();
        return builder;
    }

    public abstract String getToken();

    public abstract long getTokenCreationTimestamp();

    public abstract long getTokenExpirationTimestamp();

    public abstract com.google.firebase.installations.InstallationTokenResult.Builder toBuilder();
}
