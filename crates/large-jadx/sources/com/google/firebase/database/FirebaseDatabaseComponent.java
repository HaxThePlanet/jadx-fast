package com.google.firebase.database;

import com.google.firebase.FirebaseApp;
import com.google.firebase.appcheck.interop.InternalAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.database.android.AndroidAppCheckTokenProvider;
import com.google.firebase.database.android.AndroidAuthTokenProvider;
import com.google.firebase.database.core.DatabaseConfig;
import com.google.firebase.database.core.RepoInfo;
import com.google.firebase.database.core.TokenProvider;
import com.google.firebase.inject.Deferred;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class FirebaseDatabaseComponent {

    private final FirebaseApp app;
    private final TokenProvider appCheckProvider;
    private final TokenProvider authProvider;
    private final Map<RepoInfo, com.google.firebase.database.FirebaseDatabase> instances;
    FirebaseDatabaseComponent(FirebaseApp firebaseApp, Deferred<InternalAuthProvider> deferred2, Deferred<InternalAppCheckTokenProvider> deferred3) {
        super();
        HashMap hashMap = new HashMap();
        this.instances = hashMap;
        this.app = firebaseApp;
        AndroidAuthTokenProvider obj2 = new AndroidAuthTokenProvider(deferred2);
        this.authProvider = obj2;
        obj2 = new AndroidAppCheckTokenProvider(deferred3);
        this.appCheckProvider = obj2;
    }

    com.google.firebase.database.FirebaseDatabase get(RepoInfo repoInfo) {
        Object obj;
        boolean defaultApp;
        com.google.firebase.database.FirebaseDatabase firebaseDatabase;
        FirebaseApp app;
        synchronized (this) {
            try {
                DatabaseConfig databaseConfig = new DatabaseConfig();
                if (!this.app.isDefaultApp()) {
                }
                databaseConfig.setSessionPersistenceKey(this.app.getName());
                databaseConfig.setFirebaseApp(this.app);
                databaseConfig.setAuthTokenProvider(this.authProvider);
                databaseConfig.setAppCheckTokenProvider(this.appCheckProvider);
                firebaseDatabase = new FirebaseDatabase(this.app, repoInfo, databaseConfig);
                this.instances.put(repoInfo, firebaseDatabase);
                obj = firebaseDatabase;
                return obj;
                throw repoInfo;
            }
        }
    }
}
