package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Context;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class DefaultPersistenceManager implements com.google.firebase.database.core.persistence.PersistenceManager {

    private final com.google.firebase.database.core.persistence.CachePolicy cachePolicy;
    private final LogWrapper logger;
    private long serverCacheUpdatesSinceLastPruneCheck;
    private final com.google.firebase.database.core.persistence.PersistenceStorageEngine storageLayer;
    private final com.google.firebase.database.core.persistence.TrackedQueryManager trackedQueryManager;
    public DefaultPersistenceManager(Context context, com.google.firebase.database.core.persistence.PersistenceStorageEngine persistenceStorageEngine2, com.google.firebase.database.core.persistence.CachePolicy cachePolicy3) {
        DefaultClock defaultClock = new DefaultClock();
        super(context, persistenceStorageEngine2, cachePolicy3, defaultClock);
    }

    public DefaultPersistenceManager(Context context, com.google.firebase.database.core.persistence.PersistenceStorageEngine persistenceStorageEngine2, com.google.firebase.database.core.persistence.CachePolicy cachePolicy3, Clock clock4) {
        super();
        this.serverCacheUpdatesSinceLastPruneCheck = 0;
        this.storageLayer = persistenceStorageEngine2;
        final LogWrapper obj3 = context.getLogger("Persistence");
        this.logger = obj3;
        TrackedQueryManager trackedQueryManager = new TrackedQueryManager(persistenceStorageEngine2, obj3, clock4);
        this.trackedQueryManager = trackedQueryManager;
        this.cachePolicy = cachePolicy3;
    }

    private void doPruneCheckAfterServerUpdate() {
        boolean logsDebug;
        int checkCacheSize;
        int i;
        com.google.firebase.database.core.persistence.CachePolicy serverCacheEstimatedSizeInBytes;
        String prunesAnything;
        boolean cachePolicy;
        String countOfPrunableQueries;
        Object[] arr;
        serverCacheUpdatesSinceLastPruneCheck += i3;
        this.serverCacheUpdatesSinceLastPruneCheck = i2;
        i = 0;
        if (this.cachePolicy.shouldCheckCacheSize(i2) && this.logger.logsDebug()) {
            i = 0;
            if (this.logger.logsDebug()) {
                this.logger.debug("Reached prune check threshold.", new Object[i]);
            }
            this.serverCacheUpdatesSinceLastPruneCheck = 0;
            checkCacheSize = 1;
            if (this.logger.logsDebug()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Cache size: ");
                stringBuilder2.append(this.storageLayer.serverCacheEstimatedSizeInBytes());
                this.logger.debug(stringBuilder2.toString(), new Object[i]);
            }
            while (checkCacheSize != 0) {
                if (this.cachePolicy.shouldPrune(serverCacheEstimatedSizeInBytes, prunesAnything)) {
                }
                com.google.firebase.database.core.persistence.PruneForest pruneOldQueries = this.trackedQueryManager.pruneOldQueries(this.cachePolicy);
                if (pruneOldQueries.prunesAnything()) {
                } else {
                }
                checkCacheSize = i;
                if (this.logger.logsDebug()) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Cache size after prune: ");
                stringBuilder.append(this.storageLayer.serverCacheEstimatedSizeInBytes());
                this.logger.debug(stringBuilder.toString(), new Object[i]);
                this.storageLayer.pruneCache(Path.getEmptyPath(), pruneOldQueries);
            }
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void applyUserWriteToServerCache(Path path, CompoundWrite compoundWrite2) {
        Object value;
        Path child;
        final Iterator obj4 = compoundWrite2.iterator();
        for (Map.Entry next2 : obj4) {
            applyUserWriteToServerCache(path.child((Path)next2.getKey()), (Node)next2.getValue());
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void applyUserWriteToServerCache(Path path, Node node2) {
        boolean activeDefaultQuery;
        Object obj3;
        if (!this.trackedQueryManager.hasActiveDefaultQuery(path)) {
            this.storageLayer.overwriteServerCache(path, node2);
            this.trackedQueryManager.ensureCompleteTrackedQuery(path);
        }
    }

    public List<UserWriteRecord> loadUserWrites() {
        return this.storageLayer.loadUserWrites();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void removeAllUserWrites() {
        this.storageLayer.removeAllUserWrites();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void removeUserWrite(long l) {
        this.storageLayer.removeUserWrite(l);
    }

    public <T> T runInTransaction(Callable<T> callable) {
        this.storageLayer.beginTransaction();
        this.storageLayer.setTransactionSuccessful();
        this.storageLayer.endTransaction();
        return callable.call();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void saveUserMerge(Path path, CompoundWrite compoundWrite2, long l3) {
        this.storageLayer.saveUserMerge(path, compoundWrite2, l3);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void saveUserOverwrite(Path path, Node node2, long l3) {
        this.storageLayer.saveUserOverwrite(path, node2, l3);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public CacheNode serverCache(QuerySpec querySpec) {
        Set knownCompleteChildren;
        EmptyNode immediateChild2;
        com.google.firebase.database.core.persistence.PersistenceStorageEngine loadsAllData;
        int i;
        long l;
        Path path;
        Node immediateChild;
        final int i2 = 1;
        int i3 = 0;
        if (this.trackedQueryManager.isQueryComplete(querySpec)) {
            com.google.firebase.database.core.persistence.TrackedQuery trackedQuery = this.trackedQueryManager.findTrackedQuery(querySpec);
            if (!querySpec.loadsAllData() && trackedQuery != null && trackedQuery.complete) {
                if (trackedQuery != null) {
                    if (trackedQuery.complete) {
                        knownCompleteChildren = this.storageLayer.loadTrackedQueryKeys(trackedQuery.id);
                    } else {
                        knownCompleteChildren = 0;
                    }
                } else {
                }
            } else {
            }
            i = i2;
        } else {
            knownCompleteChildren = this.trackedQueryManager.getKnownCompleteChildren(querySpec.getPath());
            i = i3;
        }
        Node serverCache = this.storageLayer.serverCache(querySpec.getPath());
        if (knownCompleteChildren != null) {
            immediateChild2 = EmptyNode.Empty();
            Iterator iterator = knownCompleteChildren.iterator();
            for (ChildKey path : iterator) {
                immediateChild2 = immediateChild2.updateImmediateChild(path, serverCache.getImmediateChild(path));
            }
            CacheNode cacheNode2 = new CacheNode(IndexedNode.from(immediateChild2, querySpec.getIndex()), i, i2);
            return cacheNode2;
        }
        CacheNode cacheNode = new CacheNode(IndexedNode.from(serverCache, querySpec.getIndex()), i, i3);
        return cacheNode;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void setQueryActive(QuerySpec querySpec) {
        this.trackedQueryManager.setQueryActive(querySpec);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void setQueryComplete(QuerySpec querySpec) {
        com.google.firebase.database.core.persistence.TrackedQueryManager trackedQueryManager;
        Object obj2;
        if (querySpec.loadsAllData()) {
            this.trackedQueryManager.setQueriesComplete(querySpec.getPath());
        } else {
            this.trackedQueryManager.setQueryCompleteIfExists(querySpec);
        }
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void setQueryInactive(QuerySpec querySpec) {
        this.trackedQueryManager.setQueryInactive(querySpec);
    }

    public void setTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set2) {
        com.google.firebase.database.core.persistence.TrackedQueryManager trackedQueryManager;
        int i;
        final String str2 = "We should only track keys for filtered queries.";
        Utilities.hardAssert(loadsAllData ^= i, str2);
        final com.google.firebase.database.core.persistence.TrackedQuery obj4 = this.trackedQueryManager.findTrackedQuery(querySpec);
        if (obj4 != null && obj4.active) {
            if (obj4.active) {
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i, "We only expect tracked keys for currently-active queries.");
        this.storageLayer.saveTrackedQueryKeys(obj4.id, str2);
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void updateServerCache(Path path, CompoundWrite compoundWrite2) {
        this.storageLayer.mergeIntoServerCache(path, compoundWrite2);
        doPruneCheckAfterServerUpdate();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void updateServerCache(QuerySpec querySpec, Node node2) {
        com.google.firebase.database.core.persistence.PersistenceStorageEngine storageLayer;
        Path path;
        if (querySpec.loadsAllData()) {
            this.storageLayer.overwriteServerCache(querySpec.getPath(), node2);
        } else {
            this.storageLayer.mergeIntoServerCache(querySpec.getPath(), node2);
        }
        setQueryComplete(querySpec);
        doPruneCheckAfterServerUpdate();
    }

    public void updateTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set2, Set<ChildKey> set3) {
        com.google.firebase.database.core.persistence.TrackedQueryManager trackedQueryManager;
        int i;
        final String str2 = "We should only track keys for filtered queries.";
        Utilities.hardAssert(loadsAllData ^= i, str2);
        final com.google.firebase.database.core.persistence.TrackedQuery obj4 = this.trackedQueryManager.findTrackedQuery(querySpec);
        if (obj4 != null && obj4.active) {
            if (obj4.active) {
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i, "We only expect tracked keys for currently-active queries.");
        this.storageLayer.updateTrackedQueryKeys(obj4.id, str2, set2);
    }
}
