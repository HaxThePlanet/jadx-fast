package com.google.firebase.database.core;

import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.io.File;
import java.util.List;

/* loaded from: classes2.dex */
public interface Platform {
    public abstract PersistenceManager createPersistenceManager(com.google.firebase.database.core.Context context, String string2);

    public abstract String getPlatformVersion();

    public abstract File getSSLCacheDirectory();

    public abstract String getUserAgent(com.google.firebase.database.core.Context context);

    public abstract com.google.firebase.database.core.EventTarget newEventTarget(com.google.firebase.database.core.Context context);

    public abstract Logger newLogger(com.google.firebase.database.core.Context context, Logger.Level logger$Level2, List<String> list3);

    public abstract PersistentConnection newPersistentConnection(com.google.firebase.database.core.Context context, ConnectionContext connectionContext2, HostInfo hostInfo3, PersistentConnection.Delegate persistentConnection$Delegate4);

    public abstract com.google.firebase.database.core.RunLoop newRunLoop(com.google.firebase.database.core.Context context);
}
