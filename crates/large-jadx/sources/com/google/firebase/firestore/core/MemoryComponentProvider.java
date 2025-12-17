package com.google.firebase.firestore.core;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.local.DefaultQueryEngine;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.MemoryPersistence;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.AndroidConnectivityMonitor;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback;
import io.grpc.d1;

/* loaded from: classes2.dex */
public class MemoryComponentProvider extends com.google.firebase.firestore.core.ComponentProvider {

    private class RemoteStoreCallback implements RemoteStore.RemoteStoreCallback {

        final com.google.firebase.firestore.core.MemoryComponentProvider this$0;
        private RemoteStoreCallback(com.google.firebase.firestore.core.MemoryComponentProvider memoryComponentProvider) {
            this.this$0 = memoryComponentProvider;
            super();
        }

        RemoteStoreCallback(com.google.firebase.firestore.core.MemoryComponentProvider memoryComponentProvider, com.google.firebase.firestore.core.MemoryComponentProvider.1 memoryComponentProvider$12) {
            super(memoryComponentProvider);
        }

        public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
            return this.this$0.getSyncEngine().getRemoteKeysForTarget(i);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
        public void handleOnlineStateChange(com.google.firebase.firestore.core.OnlineState onlineState) {
            this.this$0.getSyncEngine().handleOnlineStateChange(onlineState);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
        public void handleRejectedListen(int i, d1 d12) {
            this.this$0.getSyncEngine().handleRejectedListen(i, d12);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
        public void handleRejectedWrite(int i, d1 d12) {
            this.this$0.getSyncEngine().handleRejectedWrite(i, d12);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
        public void handleRemoteEvent(RemoteEvent remoteEvent) {
            this.this$0.getSyncEngine().handleRemoteEvent(remoteEvent);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
        public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
            this.this$0.getSyncEngine().handleSuccessfulWrite(mutationBatchResult);
        }
    }
    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected AndroidConnectivityMonitor createConnectivityMonitor(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        AndroidConnectivityMonitor androidConnectivityMonitor = new AndroidConnectivityMonitor(configuration.getContext());
        return androidConnectivityMonitor;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected ConnectivityMonitor createConnectivityMonitor(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        return createConnectivityMonitor(configuration);
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected com.google.firebase.firestore.core.EventManager createEventManager(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        EventManager obj2 = new EventManager(getSyncEngine());
        return obj2;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected Scheduler createGarbageCollectionScheduler(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        return null;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected Scheduler createIndexBackfillScheduler(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        return null;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected LocalStore createLocalStore(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        DefaultQueryEngine defaultQueryEngine = new DefaultQueryEngine();
        LocalStore localStore = new LocalStore(getPersistence(), defaultQueryEngine, configuration.getInitialUser());
        return localStore;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected Persistence createPersistence(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        return MemoryPersistence.createEagerGcMemoryPersistence();
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected RemoteStore createRemoteStore(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        MemoryComponentProvider.RemoteStoreCallback remoteStoreCallback = new MemoryComponentProvider.RemoteStoreCallback(this, 0);
        super(remoteStoreCallback, getLocalStore(), configuration.getDatastore(), configuration.getAsyncQueue(), getConnectivityMonitor());
        return remoteStore2;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected com.google.firebase.firestore.core.SyncEngine createSyncEngine(com.google.firebase.firestore.core.ComponentProvider.Configuration componentProvider$Configuration) {
        SyncEngine syncEngine = new SyncEngine(getLocalStore(), getRemoteStore(), configuration.getInitialUser(), configuration.getMaxConcurrentLimboResolutions());
        return syncEngine;
    }
}
