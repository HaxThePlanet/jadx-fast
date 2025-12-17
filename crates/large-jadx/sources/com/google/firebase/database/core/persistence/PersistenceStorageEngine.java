package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public interface PersistenceStorageEngine {
    public abstract void beginTransaction();

    public abstract void close();

    public abstract void deleteTrackedQuery(long l);

    public abstract void endTransaction();

    public abstract List<com.google.firebase.database.core.persistence.TrackedQuery> loadTrackedQueries();

    public abstract Set<ChildKey> loadTrackedQueryKeys(long l);

    public abstract Set<ChildKey> loadTrackedQueryKeys(Set<Long> set);

    public abstract List<UserWriteRecord> loadUserWrites();

    public abstract void mergeIntoServerCache(Path path, CompoundWrite compoundWrite2);

    public abstract void mergeIntoServerCache(Path path, Node node2);

    public abstract void overwriteServerCache(Path path, Node node2);

    public abstract void pruneCache(Path path, com.google.firebase.database.core.persistence.PruneForest pruneForest2);

    public abstract void removeAllUserWrites();

    public abstract void removeUserWrite(long l);

    public abstract void resetPreviouslyActiveTrackedQueries(long l);

    public abstract void saveTrackedQuery(com.google.firebase.database.core.persistence.TrackedQuery trackedQuery);

    public abstract void saveTrackedQueryKeys(long l, Set<ChildKey> set2);

    public abstract void saveUserMerge(Path path, CompoundWrite compoundWrite2, long l3);

    public abstract void saveUserOverwrite(Path path, Node node2, long l3);

    public abstract Node serverCache(Path path);

    public abstract long serverCacheEstimatedSizeInBytes();

    public abstract void setTransactionSuccessful();

    public abstract void updateTrackedQueryKeys(long l, Set<ChildKey> set2, Set<ChildKey> set3);
}
