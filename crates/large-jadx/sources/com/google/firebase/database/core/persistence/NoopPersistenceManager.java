package com.google.firebase.database.core.persistence;

import android.util.Log;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class NoopPersistenceManager implements com.google.firebase.database.core.persistence.PersistenceManager {

    private static final String TAG = "NoopPersistenceManager";
    private boolean insideTransaction = false;
    public NoopPersistenceManager() {
        super();
        final int i = 0;
    }

    private void verifyInsideTransaction() {
        Utilities.hardAssert(this.insideTransaction, "Transaction expected to already be in progress.");
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void applyUserWriteToServerCache(Path path, CompoundWrite compoundWrite2) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void applyUserWriteToServerCache(Path path, Node node2) {
        verifyInsideTransaction();
    }

    public List<UserWriteRecord> loadUserWrites() {
        return Collections.emptyList();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void removeAllUserWrites() {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void removeUserWrite(long l) {
        verifyInsideTransaction();
    }

    public <T> T runInTransaction(Callable<T> callable) {
        final int i3 = 1;
        Utilities.hardAssert(insideTransaction ^= i3, "runInTransaction called when an existing transaction is already in progress.");
        this.insideTransaction = i3;
        this.insideTransaction = false;
        return callable.call();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void saveUserMerge(Path path, CompoundWrite compoundWrite2, long l3) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void saveUserOverwrite(Path path, Node node2, long l3) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public CacheNode serverCache(QuerySpec querySpec) {
        int i = 0;
        CacheNode cacheNode = new CacheNode(IndexedNode.from(EmptyNode.Empty(), querySpec.getIndex()), i, i);
        return cacheNode;
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void setQueryActive(QuerySpec querySpec) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void setQueryComplete(QuerySpec querySpec) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void setQueryInactive(QuerySpec querySpec) {
        verifyInsideTransaction();
    }

    public void setTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set2) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void updateServerCache(Path path, CompoundWrite compoundWrite2) {
        verifyInsideTransaction();
    }

    @Override // com.google.firebase.database.core.persistence.PersistenceManager
    public void updateServerCache(QuerySpec querySpec, Node node2) {
        verifyInsideTransaction();
    }

    public void updateTrackedQueryKeys(QuerySpec querySpec, Set<ChildKey> set2, Set<ChildKey> set3) {
        verifyInsideTransaction();
    }
}
