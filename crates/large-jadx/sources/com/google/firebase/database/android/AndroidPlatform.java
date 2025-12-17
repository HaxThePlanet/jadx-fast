package com.google.firebase.database.android;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseApp.BackgroundStateChangeListener;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.connection.PersistentConnectionImpl;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.EventTarget;
import com.google.firebase.database.core.Platform;
import com.google.firebase.database.core.RunLoop;
import com.google.firebase.database.core.persistence.DefaultPersistenceManager;
import com.google.firebase.database.core.persistence.LRUCachePolicy;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.logging.AndroidLogger;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import com.google.firebase.database.logging.Logger.Level;
import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class AndroidPlatform implements Platform {

    private static final String APP_IN_BACKGROUND_INTERRUPT_REASON = "app_in_background";
    private final Context applicationContext;
    private final Set<String> createdPersistenceCaches;
    private final FirebaseApp firebaseApp;
    public AndroidPlatform(FirebaseApp firebaseApp) {
        super();
        HashSet hashSet = new HashSet();
        this.createdPersistenceCaches = hashSet;
        this.firebaseApp = firebaseApp;
        if (firebaseApp == null) {
        } else {
            this.applicationContext = firebaseApp.getApplicationContext();
        }
        String obj3 = "FirebaseDatabase";
        String str = "!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!";
        Log.e(obj3, str);
        Log.e(obj3, "ERROR: You must call FirebaseApp.initializeApp() before using Firebase Database.");
        Log.e(obj3, str);
        obj3 = new RuntimeException("You need to call FirebaseApp.initializeApp() before using Firebase Database.");
        throw obj3;
    }

    static Context access$000(com.google.firebase.database.android.AndroidPlatform androidPlatform) {
        return androidPlatform.applicationContext;
    }

    @Override // com.google.firebase.database.core.Platform
    public PersistenceManager createPersistenceManager(Context context, String string2) {
        String sessionPersistenceKey = context.getSessionPersistenceKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append("_");
        stringBuilder.append(sessionPersistenceKey);
        String obj5 = stringBuilder.toString();
        if (this.createdPersistenceCaches.contains(obj5)) {
        } else {
            this.createdPersistenceCaches.add(obj5);
            SqlPersistenceStorageEngine sqlPersistenceStorageEngine = new SqlPersistenceStorageEngine(this.applicationContext, context, obj5);
            obj5 = new LRUCachePolicy(context.getPersistenceCacheSizeBytes(), obj2);
            DefaultPersistenceManager defaultPersistenceManager = new DefaultPersistenceManager(context, sqlPersistenceStorageEngine, obj5);
            return defaultPersistenceManager;
        }
        obj5 = new StringBuilder();
        obj5.append("SessionPersistenceKey '");
        obj5.append(sessionPersistenceKey);
        obj5.append("' has already been used.");
        DatabaseException obj4 = new DatabaseException(obj5.toString());
        throw obj4;
    }

    @Override // com.google.firebase.database.core.Platform
    public String getPlatformVersion() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android-");
        stringBuilder.append(FirebaseDatabase.getSdkVersion());
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.database.core.Platform
    public File getSSLCacheDirectory() {
        return this.applicationContext.getApplicationContext().getDir("sslcache", 0);
    }

    @Override // com.google.firebase.database.core.Platform
    public String getUserAgent(Context context) {
        StringBuilder obj2 = new StringBuilder();
        obj2.append(Build.VERSION.SDK_INT);
        obj2.append("/Android");
        return obj2.toString();
    }

    @Override // com.google.firebase.database.core.Platform
    public EventTarget newEventTarget(Context context) {
        AndroidEventTarget obj1 = new AndroidEventTarget();
        return obj1;
    }

    public Logger newLogger(Context context, Logger.Level logger$Level2, List<String> list3) {
        AndroidLogger obj1 = new AndroidLogger(level2, list3);
        return obj1;
    }

    @Override // com.google.firebase.database.core.Platform
    public PersistentConnection newPersistentConnection(Context context, ConnectionContext connectionContext2, HostInfo hostInfo3, PersistentConnection.Delegate persistentConnection$Delegate4) {
        PersistentConnectionImpl obj1 = new PersistentConnectionImpl(connectionContext2, hostInfo3, delegate4);
        AndroidPlatform.2 obj3 = new AndroidPlatform.2(this, obj1);
        this.firebaseApp.addBackgroundStateChangeListener(obj3);
        return obj1;
    }

    @Override // com.google.firebase.database.core.Platform
    public RunLoop newRunLoop(Context context) {
        AndroidPlatform.1 anon = new AndroidPlatform.1(this, context.getLogger("RunLoop"));
        return anon;
    }
}
