package com.google.firebase.firestore.local;

import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Supplier;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class MemoryPersistence extends com.google.firebase.firestore.local.Persistence {

    private final com.google.firebase.firestore.local.MemoryBundleCache bundleCache;
    private final com.google.firebase.firestore.local.MemoryIndexManager indexManager;
    private final Map<User, com.google.firebase.firestore.local.MemoryMutationQueue> mutationQueues;
    private final Map<User, com.google.firebase.firestore.local.MemoryDocumentOverlay> overlays;
    private com.google.firebase.firestore.local.ReferenceDelegate referenceDelegate;
    private final com.google.firebase.firestore.local.MemoryRemoteDocumentCache remoteDocumentCache;
    private boolean started;
    private final com.google.firebase.firestore.local.MemoryTargetCache targetCache;
    private MemoryPersistence() {
        super();
        HashMap hashMap = new HashMap();
        this.mutationQueues = hashMap;
        MemoryIndexManager memoryIndexManager = new MemoryIndexManager();
        this.indexManager = memoryIndexManager;
        MemoryTargetCache memoryTargetCache = new MemoryTargetCache(this);
        this.targetCache = memoryTargetCache;
        MemoryBundleCache memoryBundleCache = new MemoryBundleCache();
        this.bundleCache = memoryBundleCache;
        MemoryRemoteDocumentCache memoryRemoteDocumentCache = new MemoryRemoteDocumentCache(this);
        this.remoteDocumentCache = memoryRemoteDocumentCache;
        HashMap hashMap2 = new HashMap();
        this.overlays = hashMap2;
    }

    public static com.google.firebase.firestore.local.MemoryPersistence createEagerGcMemoryPersistence() {
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        MemoryEagerReferenceDelegate memoryEagerReferenceDelegate = new MemoryEagerReferenceDelegate(memoryPersistence);
        memoryPersistence.setReferenceDelegate(memoryEagerReferenceDelegate);
        return memoryPersistence;
    }

    public static com.google.firebase.firestore.local.MemoryPersistence createLruGcMemoryPersistence(com.google.firebase.firestore.local.LruGarbageCollector.Params lruGarbageCollector$Params, com.google.firebase.firestore.local.LocalSerializer localSerializer2) {
        MemoryPersistence memoryPersistence = new MemoryPersistence();
        MemoryLruReferenceDelegate memoryLruReferenceDelegate = new MemoryLruReferenceDelegate(memoryPersistence, params, localSerializer2);
        memoryPersistence.setReferenceDelegate(memoryLruReferenceDelegate);
        return memoryPersistence;
    }

    private void setReferenceDelegate(com.google.firebase.firestore.local.ReferenceDelegate referenceDelegate) {
        this.referenceDelegate = referenceDelegate;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.BundleCache getBundleCache() {
        return this.bundleCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.DocumentOverlay getDocumentOverlay(User user) {
        Object memoryDocumentOverlay;
        Map overlays;
        if ((MemoryDocumentOverlay)this.overlays.get(user) == null) {
            memoryDocumentOverlay = new MemoryDocumentOverlay();
            this.overlays.put(user, memoryDocumentOverlay);
        }
        return memoryDocumentOverlay;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.IndexManager getIndexManager() {
        return this.indexManager;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.MutationQueue getMutationQueue(User user) {
        Object memoryMutationQueue;
        Map mutationQueues;
        if ((MemoryMutationQueue)this.mutationQueues.get(user) == null) {
            memoryMutationQueue = new MemoryMutationQueue(this);
            this.mutationQueues.put(user, memoryMutationQueue);
        }
        return memoryMutationQueue;
    }

    Iterable<com.google.firebase.firestore.local.MemoryMutationQueue> getMutationQueues() {
        return this.mutationQueues.values();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.ReferenceDelegate getReferenceDelegate() {
        return this.referenceDelegate;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.MemoryRemoteDocumentCache getRemoteDocumentCache() {
        return this.remoteDocumentCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.RemoteDocumentCache getRemoteDocumentCache() {
        return getRemoteDocumentCache();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.MemoryTargetCache getTargetCache() {
        return this.targetCache;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    com.google.firebase.firestore.local.TargetCache getTargetCache() {
        return getTargetCache();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public boolean isStarted() {
        return this.started;
    }

    <T> T runTransaction(String string, Supplier<T> supplier2) {
        this.referenceDelegate.onTransactionStarted();
        this.referenceDelegate.onTransactionCommitted();
        return supplier2.get();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    void runTransaction(String string, Runnable runnable2) {
        this.referenceDelegate.onTransactionStarted();
        runnable2.run();
        this.referenceDelegate.onTransactionCommitted();
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void shutdown() {
        final int i = 0;
        Assert.hardAssert(this.started, "MemoryPersistence shutdown without start", new Object[i]);
        this.started = i;
    }

    @Override // com.google.firebase.firestore.local.Persistence
    public void start() {
        final int i2 = 1;
        Assert.hardAssert(started ^= i2, "MemoryPersistence double-started!", new Object[0]);
        this.started = i2;
    }
}
