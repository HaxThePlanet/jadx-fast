package com.google.firebase.database.connection;

import com.google.firebase.database.logging.Logger;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class ConnectionContext {

    private final com.google.firebase.database.connection.ConnectionTokenProvider appCheckTokenProvider;
    private final String applicationId;
    private final com.google.firebase.database.connection.ConnectionTokenProvider authTokenProvider;
    private final String clientSdkVersion;
    private final ScheduledExecutorService executorService;
    private final Logger logger;
    private final boolean persistenceEnabled;
    private final String sslCacheDirectory;
    private final String userAgent;
    public ConnectionContext(Logger logger, com.google.firebase.database.connection.ConnectionTokenProvider connectionTokenProvider2, com.google.firebase.database.connection.ConnectionTokenProvider connectionTokenProvider3, ScheduledExecutorService scheduledExecutorService4, boolean z5, String string6, String string7, String string8, String string9) {
        super();
        this.logger = logger;
        this.authTokenProvider = connectionTokenProvider2;
        this.appCheckTokenProvider = connectionTokenProvider3;
        this.executorService = scheduledExecutorService4;
        this.persistenceEnabled = z5;
        this.clientSdkVersion = string6;
        this.userAgent = string7;
        this.applicationId = string8;
        this.sslCacheDirectory = string9;
    }

    public com.google.firebase.database.connection.ConnectionTokenProvider getAppCheckTokenProvider() {
        return this.appCheckTokenProvider;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public com.google.firebase.database.connection.ConnectionTokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public String getClientSdkVersion() {
        return this.clientSdkVersion;
    }

    public ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public String getSslCacheDirectory() {
        return this.sslCacheDirectory;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }
}
