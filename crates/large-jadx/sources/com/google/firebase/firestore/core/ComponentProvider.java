package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.AsyncQueue;

/* loaded from: classes2.dex */
public abstract class ComponentProvider {

    private ConnectivityMonitor connectivityMonitor;
    private com.google.firebase.firestore.core.EventManager eventManager;
    private Scheduler garbageCollectionScheduler;
    private Scheduler indexBackfillScheduler;
    private LocalStore localStore;
    private Persistence persistence;
    private RemoteStore remoteStore;
    private com.google.firebase.firestore.core.SyncEngine syncEngine;

    public static class Configuration {

        private final AsyncQueue asyncQueue;
        private final Context context;
        private final com.google.firebase.firestore.core.DatabaseInfo databaseInfo;
        private final Datastore datastore;
        private final User initialUser;
        private final int maxConcurrentLimboResolutions;
        private final FirebaseFirestoreSettings settings;
        public Configuration(Context context, AsyncQueue asyncQueue2, com.google.firebase.firestore.core.DatabaseInfo databaseInfo3, Datastore datastore4, User user5, int i6, FirebaseFirestoreSettings firebaseFirestoreSettings7) {
            super();
            this.context = context;
            this.asyncQueue = asyncQueue2;
            this.databaseInfo = databaseInfo3;
            this.datastore = datastore4;
            this.initialUser = user5;
            this.maxConcurrentLimboResolutions = i6;
            this.settings = firebaseFirestoreSettings7;
        }

        AsyncQueue getAsyncQueue() {
            return this.asyncQueue;
        }

        Context getContext() {
            return this.context;
        }

        com.google.firebase.firestore.core.DatabaseInfo getDatabaseInfo() {
            return this.databaseInfo;
        }

        Datastore getDatastore() {
            return this.datastore;
        }

        User getInitialUser() {
            return this.initialUser;
        }

        int getMaxConcurrentLimboResolutions() {
            return this.maxConcurrentLimboResolutions;
        }

        FirebaseFirestoreSettings getSettings() {
            return this.settings;
        }
    }
    protected abstract ConnectivityMonitor createConnectivityMonitor(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract com.google.firebase.firestore.core.EventManager createEventManager(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract Scheduler createGarbageCollectionScheduler(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract Scheduler createIndexBackfillScheduler(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract LocalStore createLocalStore(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract Persistence createPersistence(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract RemoteStore createRemoteStore(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected abstract com.google.firebase.firestore.core.SyncEngine createSyncEngine(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration);

    protected ConnectivityMonitor getConnectivityMonitor() {
        return this.connectivityMonitor;
    }

    public com.google.firebase.firestore.core.EventManager getEventManager() {
        return this.eventManager;
    }

    public Scheduler getGarbageCollectionScheduler() {
        return this.garbageCollectionScheduler;
    }

    public Scheduler getIndexBackfillScheduler() {
        return this.indexBackfillScheduler;
    }

    public LocalStore getLocalStore() {
        return this.localStore;
    }

    public Persistence getPersistence() {
        return this.persistence;
    }

    public RemoteStore getRemoteStore() {
        return this.remoteStore;
    }

    public com.google.firebase.firestore.core.SyncEngine getSyncEngine() {
        return this.syncEngine;
    }

    public void initialize(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        Persistence persistence = createPersistence(configuration);
        this.persistence = persistence;
        persistence.start();
        this.localStore = createLocalStore(configuration);
        this.connectivityMonitor = createConnectivityMonitor(configuration);
        this.remoteStore = createRemoteStore(configuration);
        this.syncEngine = createSyncEngine(configuration);
        this.eventManager = createEventManager(configuration);
        this.localStore.start();
        this.remoteStore.start();
        this.garbageCollectionScheduler = createGarbageCollectionScheduler(configuration);
        this.indexBackfillScheduler = createIndexBackfillScheduler(configuration);
    }
}
