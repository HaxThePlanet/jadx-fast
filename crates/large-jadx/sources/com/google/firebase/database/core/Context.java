package com.google.firebase.database.core;

import com.google.android.gms.common.internal.r;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.android.AndroidPlatform;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.ConnectionTokenProvider;
import com.google.firebase.database.connection.ConnectionTokenProvider.GetTokenCallback;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.io.File;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class Context {

    private static final long DEFAULT_CACHE_SIZE = 10485760L;
    protected com.google.firebase.database.core.TokenProvider appCheckTokenProvider;
    protected com.google.firebase.database.core.TokenProvider authTokenProvider;
    protected long cacheSize = 10485760;
    protected com.google.firebase.database.core.EventTarget eventTarget;
    protected FirebaseApp firebaseApp;
    private PersistenceManager forcedPersistenceManager;
    private boolean frozen = false;
    protected Logger.Level logLevel;
    protected List<String> loggedComponents;
    protected Logger logger;
    protected boolean persistenceEnabled;
    protected String persistenceKey;
    private com.google.firebase.database.core.Platform platform;
    protected com.google.firebase.database.core.RunLoop runLoop;
    private boolean stopped = false;
    protected String userAgent;
    public Context() {
        super();
        this.logLevel = Logger.Level.INFO;
        int i = 10485760;
        int i2 = 0;
    }

    static void a(com.google.firebase.database.core.TokenProvider tokenProvider, ScheduledExecutorService scheduledExecutorService2, boolean z3, ConnectionTokenProvider.GetTokenCallback connectionTokenProvider$GetTokenCallback4) {
        Context.1 anon = new Context.1(scheduledExecutorService2, getTokenCallback4);
        tokenProvider.getToken(z3, anon);
    }

    private String buildUserAgent(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Firebase/");
        stringBuilder.append("5");
        String str3 = "/";
        stringBuilder.append(str3);
        stringBuilder.append(FirebaseDatabase.getSdkVersion());
        stringBuilder.append(str3);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    private void ensureAppTokenProvider() {
        r.k(this.appCheckTokenProvider, "You must register an appCheckTokenProvider before initializing Context.");
    }

    private void ensureAuthTokenProvider() {
        r.k(this.authTokenProvider, "You must register an authTokenProvider before initializing Context.");
    }

    private void ensureEventTarget() {
        com.google.firebase.database.core.EventTarget eventTarget;
        if (this.eventTarget == null) {
            this.eventTarget = getPlatform().newEventTarget(this);
        }
    }

    private void ensureLogger() {
        Logger logger;
        Logger.Level logLevel;
        List loggedComponents;
        if (this.logger == null) {
            this.logger = getPlatform().newLogger(this, this.logLevel, this.loggedComponents);
        }
    }

    private void ensureRunLoop() {
        com.google.firebase.database.core.RunLoop runLoop;
        if (this.runLoop == null) {
            this.runLoop = this.platform.newRunLoop(this);
        }
    }

    private void ensureSessionIdentifier() {
        String persistenceKey;
        if (this.persistenceKey == null) {
            this.persistenceKey = "default";
        }
    }

    private void ensureUserAgent() {
        String userAgent;
        if (this.userAgent == null) {
            this.userAgent = buildUserAgent(getPlatform().getUserAgent(this));
        }
    }

    private ScheduledExecutorService getExecutorService() {
        com.google.firebase.database.core.RunLoop runLoop = getRunLoop();
        if (!runLoop instanceof DefaultRunLoop) {
        } else {
            return (DefaultRunLoop)runLoop.getExecutorService();
        }
        RuntimeException runtimeException = new RuntimeException("Custom run loops are not supported!");
        throw runtimeException;
    }

    private com.google.firebase.database.core.Platform getPlatform() {
        if (this.platform == null) {
            initializeAndroidPlatform();
        }
        return this.platform;
    }

    private void initServices() {
        ensureLogger();
        getPlatform();
        ensureUserAgent();
        ensureEventTarget();
        ensureRunLoop();
        ensureSessionIdentifier();
        ensureAuthTokenProvider();
        ensureAppTokenProvider();
    }

    private void initializeAndroidPlatform() {
        AndroidPlatform androidPlatform = new AndroidPlatform(this.firebaseApp);
        this.platform = androidPlatform;
        return;
        synchronized (this) {
            androidPlatform = new AndroidPlatform(this.firebaseApp);
            this.platform = androidPlatform;
        }
    }

    private void restartServices() {
        this.eventTarget.restart();
        this.runLoop.restart();
    }

    private static ConnectionTokenProvider wrapTokenProvider(com.google.firebase.database.core.TokenProvider tokenProvider, ScheduledExecutorService scheduledExecutorService2) {
        c cVar = new c(tokenProvider, scheduledExecutorService2);
        return cVar;
    }

    protected void assertUnfrozen() {
        if (isFrozen()) {
        } else {
        }
        DatabaseException databaseException = new DatabaseException("Modifications to DatabaseConfig objects must occur before they are in use");
        throw databaseException;
    }

    void forcePersistenceManager(PersistenceManager persistenceManager) {
        this.forcedPersistenceManager = persistenceManager;
    }

    void freeze() {
        boolean frozen;
        synchronized (this) {
            try {
                this.frozen = true;
                initServices();
                throw th;
            }
        }
    }

    public com.google.firebase.database.core.TokenProvider getAppCheckTokenProvider() {
        return this.appCheckTokenProvider;
    }

    public com.google.firebase.database.core.TokenProvider getAuthTokenProvider() {
        return this.authTokenProvider;
    }

    public ConnectionContext getConnectionContext() {
        super(getLogger(), Context.wrapTokenProvider(getAuthTokenProvider(), getExecutorService()), Context.wrapTokenProvider(getAppCheckTokenProvider(), getExecutorService()), getExecutorService(), isPersistenceEnabled(), FirebaseDatabase.getSdkVersion(), getUserAgent(), this.firebaseApp.getOptions().getApplicationId(), getSSLCacheDirectory().getAbsolutePath());
        return connectionContext;
    }

    public com.google.firebase.database.core.EventTarget getEventTarget() {
        return this.eventTarget;
    }

    public Logger.Level getLogLevel() {
        return this.logLevel;
    }

    public LogWrapper getLogger(String string) {
        LogWrapper logWrapper = new LogWrapper(this.logger, string);
        return logWrapper;
    }

    public LogWrapper getLogger(String string, String string2) {
        LogWrapper logWrapper = new LogWrapper(this.logger, string, string2);
        return logWrapper;
    }

    public Logger getLogger() {
        return this.logger;
    }

    public List<String> getOptDebugLogComponents() {
        return this.loggedComponents;
    }

    public long getPersistenceCacheSizeBytes() {
        return this.cacheSize;
    }

    PersistenceManager getPersistenceManager(String string) {
        PersistenceManager forcedPersistenceManager = this.forcedPersistenceManager;
        if (forcedPersistenceManager != null) {
            return forcedPersistenceManager;
        }
        if (this.persistenceEnabled) {
            PersistenceManager obj2 = this.platform.createPersistenceManager(this, string);
            if (obj2 == null) {
            } else {
                return obj2;
            }
            obj2 = new IllegalArgumentException("You have enabled persistence, but persistence is not supported on this platform.");
            throw obj2;
        }
        obj2 = new NoopPersistenceManager();
        return obj2;
    }

    public String getPlatformVersion() {
        return getPlatform().getPlatformVersion();
    }

    public com.google.firebase.database.core.RunLoop getRunLoop() {
        return this.runLoop;
    }

    public File getSSLCacheDirectory() {
        return getPlatform().getSSLCacheDirectory();
    }

    public String getSessionPersistenceKey() {
        return this.persistenceKey;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public boolean isFrozen() {
        return this.frozen;
    }

    public boolean isPersistenceEnabled() {
        return this.persistenceEnabled;
    }

    public boolean isStopped() {
        return this.stopped;
    }

    public PersistentConnection newPersistentConnection(HostInfo hostInfo, PersistentConnection.Delegate persistentConnection$Delegate2) {
        return getPlatform().newPersistentConnection(this, getConnectionContext(), hostInfo, delegate2);
    }

    public void requireStarted() {
        boolean stopped;
        if (this.stopped) {
            restartServices();
            this.stopped = false;
        }
    }

    void stop() {
        this.stopped = true;
        this.eventTarget.shutdown();
        this.runLoop.shutdown();
    }
}
