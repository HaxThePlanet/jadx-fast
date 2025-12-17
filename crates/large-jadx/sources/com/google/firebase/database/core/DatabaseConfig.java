package com.google.firebase.database.core;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Logger.Level;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.util.List;

/* loaded from: classes2.dex */
public class DatabaseConfig extends com.google.firebase.database.core.Context {
    @Override // com.google.firebase.database.core.Context
    public void setAppCheckTokenProvider(com.google.firebase.database.core.TokenProvider tokenProvider) {
        this.appCheckTokenProvider = tokenProvider;
    }

    @Override // com.google.firebase.database.core.Context
    public void setAuthTokenProvider(com.google.firebase.database.core.TokenProvider tokenProvider) {
        this.authTokenProvider = tokenProvider;
    }

    public void setDebugLogComponents(List<String> list) {
        assertUnfrozen();
        setLogLevel(Logger.Level.DEBUG);
        this.loggedComponents = list;
        return;
        synchronized (this) {
            assertUnfrozen();
            setLogLevel(Logger.Level.DEBUG);
            this.loggedComponents = list;
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setEventTarget(com.google.firebase.database.core.EventTarget eventTarget) {
        assertUnfrozen();
        this.eventTarget = eventTarget;
        return;
        synchronized (this) {
            assertUnfrozen();
            this.eventTarget = eventTarget;
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setFirebaseApp(FirebaseApp firebaseApp) {
        this.firebaseApp = firebaseApp;
        return;
        synchronized (this) {
            this.firebaseApp = firebaseApp;
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setLogLevel(Logger.Level logger$Level) {
        int i;
        Logger.Level obj4;
        assertUnfrozen();
        int i2 = DatabaseConfig.1.$SwitchMap$com$google$firebase$database$Logger$Level[level.ordinal()];
        synchronized (this) {
            try {
                if (i2 != 2) {
                } else {
                }
                if (i2 != 3) {
                } else {
                }
                if (i2 != 4) {
                }
                if (i2 != 5) {
                } else {
                }
                this.logLevel = Logger.Level.NONE;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown log level: ");
                stringBuilder.append(level);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
                this.logLevel = Logger.Level.ERROR;
                this.logLevel = Logger.Level.WARN;
                this.logLevel = Logger.Level.INFO;
                this.logLevel = Logger.Level.DEBUG;
                throw level;
            }
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setLogger(Logger logger) {
        assertUnfrozen();
        this.logger = logger;
        return;
        synchronized (this) {
            assertUnfrozen();
            this.logger = logger;
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setPersistenceCacheSizeBytes(long l) {
        assertUnfrozen();
        synchronized (this) {
            try {
                if (Long.compare(l, i2) > 0) {
                } else {
                }
                this.cacheSize = l;
                DatabaseException obj3 = new DatabaseException("Firebase Database currently doesn't support a cache size larger than 100MB");
                throw obj3;
                obj3 = new DatabaseException("The minimum cache size must be at least 1MB");
                throw obj3;
                throw l;
            }
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setPersistenceEnabled(boolean z) {
        assertUnfrozen();
        this.persistenceEnabled = z;
        return;
        synchronized (this) {
            assertUnfrozen();
            this.persistenceEnabled = z;
        }
    }

    @Override // com.google.firebase.database.core.Context
    public void setRunLoop(com.google.firebase.database.core.RunLoop runLoop) {
        this.runLoop = runLoop;
    }

    @Override // com.google.firebase.database.core.Context
    public void setSessionPersistenceKey(String string) {
        boolean empty;
        assertUnfrozen();
        synchronized (this) {
            try {
                if (string.isEmpty()) {
                } else {
                }
                this.persistenceKey = string;
                IllegalArgumentException obj2 = new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
                throw obj2;
                throw string;
            }
        }
    }
}
