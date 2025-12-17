package com.android.installreferrer.api;

import android.content.Context;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public abstract class InstallReferrerClient {

    public static final class Builder {

        private final Context mContext;
        private Builder(Context context) {
            super();
            this.mContext = context;
        }

        Builder(Context context, com.android.installreferrer.api.InstallReferrerClient.a installReferrerClient$a2) {
            super(context);
        }

        public com.android.installreferrer.api.InstallReferrerClient build() {
            Context mContext = this.mContext;
            if (mContext == null) {
            } else {
                InstallReferrerClientImpl installReferrerClientImpl = new InstallReferrerClientImpl(mContext);
                return installReferrerClientImpl;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Please provide a valid Context.");
            throw illegalArgumentException;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface InstallReferrerResponse {

        public static final int DEVELOPER_ERROR = 3;
        public static final int FEATURE_NOT_SUPPORTED = 2;
        public static final int OK = 0;
        public static final int PERMISSION_ERROR = 4;
        public static final int SERVICE_DISCONNECTED = -1;
        public static final int SERVICE_UNAVAILABLE = 1;
    }

    static class a {
    }
    public static com.android.installreferrer.api.InstallReferrerClient.Builder newBuilder(Context context) {
        InstallReferrerClient.Builder builder = new InstallReferrerClient.Builder(context, 0);
        return builder;
    }

    public abstract void endConnection();

    public abstract com.android.installreferrer.api.ReferrerDetails getInstallReferrer();

    public abstract boolean isReady();

    public abstract void startConnection(com.android.installreferrer.api.InstallReferrerStateListener installReferrerStateListener);
}
