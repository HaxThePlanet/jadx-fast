package com.android.installreferrer.api;

import android.content.Context;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: InstallReferrerClient.java */
/* loaded from: classes.dex */
public abstract class InstallReferrerClient {

    public static final class Builder {

        private final Context mContext;
        public InstallReferrerClient build() {
            if (this.mContext == null) {
                throw new IllegalArgumentException("Please provide a valid Context.");
            } else {
                return new InstallReferrerClientImpl(mContext2);
            }
        }

        private Builder(Context context) {
            super();
            this.mContext = context;
        }

        /* synthetic */ Builder(Context context, InstallReferrerClient.a aVar) {
            this(context);
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
    public static InstallReferrerClient.Builder newBuilder(Context context) {
        return new InstallReferrerClient.Builder(context, null);
    }

    public abstract void endConnection();

    public abstract ReferrerDetails getInstallReferrer();

    public abstract boolean isReady();

    public abstract void startConnection(InstallReferrerStateListener list);
}
