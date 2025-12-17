package com.google.firebase.database.core.persistence;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.Node;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public interface PersistenceManager {
    public abstract void applyUserWriteToServerCache(Path path, CompoundWrite compoundWrite2);

    public abstract void applyUserWriteToServerCache(Path path, Node node2);

    public abstract List<UserWriteRecord> loadUserWrites();

    public abstract void removeAllUserWrites();

    public abstract void removeUserWrite(long l);

    public abstract <T> T runInTransaction(Callable<T> callable);

    public abstract void saveUserMerge(Path path, CompoundWrite compoundWrite2, long l3);

    public abstract void saveUserOverwrite(Path path, Node node2, long l3);

    public abstract CacheNode serverCache(QuerySpec querySpec);

    public abstract void setQueryActive(QuerySpec querySpec);

    public abstract void setQueryComplete(QuerySpec querySpec);

    public abstract void setQueryInactive(QuerySpec querySpec);

    public abstract void setTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set2);

    public abstract void updateServerCache(Path path, CompoundWrite compoundWrite2);

    public abstract void updateServerCache(QuerySpec querySpec, Node node2);

    public abstract void updateTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set2, Set<ChildKey> set3);
}
