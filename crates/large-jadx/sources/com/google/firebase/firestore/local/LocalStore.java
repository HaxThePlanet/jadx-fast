package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleCallback;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.BundledQuery;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.core.TargetIdGenerator;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.protobuf.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class LocalStore implements BundleCallback {

    private static final long RESUME_TOKEN_MAX_AGE_SECONDS;
    private final com.google.firebase.firestore.local.BundleCache bundleCache;
    private final com.google.firebase.firestore.local.IndexManager indexManager;
    private com.google.firebase.firestore.local.LocalDocumentsView localDocuments;
    private final com.google.firebase.firestore.local.ReferenceSet localViewReferences;
    private com.google.firebase.firestore.local.MutationQueue mutationQueue;
    private final com.google.firebase.firestore.local.Persistence persistence;
    private final SparseArray<com.google.firebase.firestore.local.TargetData> queryDataByTarget;
    private com.google.firebase.firestore.local.QueryEngine queryEngine;
    private final com.google.firebase.firestore.local.RemoteDocumentCache remoteDocuments;
    private final com.google.firebase.firestore.local.TargetCache targetCache;
    private final Map<Target, Integer> targetIdByTarget;
    private final TargetIdGenerator targetIdGenerator;

    private static class AllocateQueryHolder {

        com.google.firebase.firestore.local.TargetData cached;
        int targetId;
        AllocateQueryHolder(com.google.firebase.firestore.local.LocalStore.1 localStore$1) {
            super();
        }
    }
    static {
        LocalStore.RESUME_TOKEN_MAX_AGE_SECONDS = TimeUnit.MINUTES.toSeconds(5);
    }

    public LocalStore(com.google.firebase.firestore.local.Persistence persistence, com.google.firebase.firestore.local.QueryEngine queryEngine2, User user3) {
        super();
        Assert.hardAssert(persistence.isStarted(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.persistence = persistence;
        com.google.firebase.firestore.local.TargetCache targetCache = persistence.getTargetCache();
        this.targetCache = targetCache;
        this.bundleCache = persistence.getBundleCache();
        this.targetIdGenerator = TargetIdGenerator.forTargetCache(targetCache.getHighestTargetId());
        this.mutationQueue = persistence.getMutationQueue(user3);
        com.google.firebase.firestore.local.RemoteDocumentCache obj6 = persistence.getRemoteDocumentCache();
        this.remoteDocuments = obj6;
        com.google.firebase.firestore.local.IndexManager indexManager = persistence.getIndexManager();
        this.indexManager = indexManager;
        LocalDocumentsView localDocumentsView = new LocalDocumentsView(obj6, this.mutationQueue, indexManager);
        this.localDocuments = localDocumentsView;
        this.queryEngine = queryEngine2;
        queryEngine2.setLocalDocumentsView(localDocumentsView);
        ReferenceSet obj5 = new ReferenceSet();
        this.localViewReferences = obj5;
        persistence.getReferenceDelegate().setInMemoryPins(obj5);
        SparseArray obj4 = new SparseArray();
        this.queryDataByTarget = obj4;
        obj4 = new HashMap();
        this.targetIdByTarget = obj4;
    }

    private void B(j j) {
        this.mutationQueue.setLastStreamToken(j);
    }

    private void D() {
        this.mutationQueue.start();
    }

    private com.google.firebase.firestore.local.LocalWriteResult F(Set set, List list2, Timestamp timestamp3) {
        Object next;
        ObjectValue transformBaseValue;
        PatchMutation patchMutation;
        com.google.firebase.firestore.model.mutation.FieldMask fieldMask;
        Precondition exists;
        final ImmutableSortedMap obj8 = this.localDocuments.getDocuments(set);
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            transformBaseValue = next.extractTransformBaseValue((Document)obj8.get((Mutation)next.getKey()));
            if (transformBaseValue != null) {
            }
            patchMutation = new PatchMutation(next.getKey(), transformBaseValue, transformBaseValue.getFieldMask(), Precondition.exists(true));
            arrayList.add(patchMutation);
        }
        MutationBatch obj9 = this.mutationQueue.addMutationBatch(timestamp3, arrayList, list2);
        obj9.applyToLocalDocumentSet(obj8);
        LocalWriteResult obj10 = new LocalWriteResult(obj9.getBatchId(), obj8);
        return obj10;
    }

    private ImmutableSortedMap a(MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        this.mutationQueue.acknowledgeBatch(batch, mutationBatchResult.getStreamToken());
        applyWriteToRemoteDocuments(mutationBatchResult);
        this.mutationQueue.performConsistencyCheck();
        return this.localDocuments.getDocuments(batch.getKeys());
    }

    private void applyWriteToRemoteDocuments(MutationBatchResult mutationBatchResult) {
        int remoteDocuments;
        MutableDocument mutableDocument;
        SnapshotVersion commitVersion;
        int i;
        String str;
        final MutationBatch batch = mutationBatchResult.getBatch();
        Iterator iterator = batch.getKeys().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            mutableDocument = this.remoteDocuments.get((DocumentKey)next2);
            Object obj = mutationBatchResult.getDocVersions().get(next2);
            int i2 = 0;
            if ((SnapshotVersion)obj != null) {
            } else {
            }
            i = i2;
            Assert.hardAssert(i, "docVersions should contain every doc in the write.", new Object[i2]);
            batch.applyToRemoteDocument(mutableDocument, mutationBatchResult);
            if (mutableDocument.getVersion().compareTo((SnapshotVersion)obj) < 0 && mutableDocument.isValidDocument()) {
            }
            batch.applyToRemoteDocument(mutableDocument, mutationBatchResult);
            if (mutableDocument.isValidDocument()) {
            }
            this.remoteDocuments.add(mutableDocument, mutationBatchResult.getCommitVersion());
            i = 1;
        }
        this.mutationQueue.removeMutationBatch(batch);
    }

    private void c(com.google.firebase.firestore.local.LocalStore.AllocateQueryHolder localStore$AllocateQueryHolder, Target target2) {
        final int nextId = this.targetIdGenerator.nextId();
        allocateQueryHolder.targetId = nextId;
        super(target2, nextId, this.persistence.getReferenceDelegate().getCurrentSequenceNumber(), obj5, QueryPurpose.LISTEN);
        allocateQueryHolder.cached = targetData;
        this.targetCache.addTargetData(targetData);
    }

    private ImmutableSortedMap e(ImmutableSortedMap immutableSortedMap, com.google.firebase.firestore.local.TargetData targetData2) {
        ImmutableSortedSet emptyKeySet;
        SnapshotVersion version;
        Object key;
        boolean foundDocument;
        emptyKeySet = DocumentKey.emptyKeySet();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        Iterator obj7 = immutableSortedMap.iterator();
        while (obj7.hasNext()) {
            Object next2 = obj7.next();
            key = (Map.Entry)next2.getKey();
            Object value = next2.getValue();
            if ((MutableDocument)value.isFoundDocument()) {
            }
            hashMap.put((DocumentKey)key, value);
            hashMap2.put(key, value.getVersion());
            emptyKeySet = emptyKeySet.insert(key);
        }
        this.targetCache.removeMatchingKeysForTargetId(targetData2.getTargetId());
        this.targetCache.addMatchingKeys(emptyKeySet, targetData2.getTargetId());
        return this.localDocuments.getLocalViewOfDocuments(populateDocumentChanges(hashMap, hashMap2, SnapshotVersion.NONE));
    }

    private ImmutableSortedMap g(RemoteEvent remoteEvent, SnapshotVersion snapshotVersion2) {
        Object lastRemoteSnapshotVersion;
        int equals;
        Iterator iterator;
        Object persistTargetData;
        boolean next;
        boolean next2;
        int referenceDelegate;
        Object obj;
        Object sequenceNumber;
        boolean queryDataByTarget;
        Iterator iterator2 = remoteEvent.getTargetChanges().entrySet().iterator();
        while (iterator2.hasNext()) {
            Object next3 = iterator2.next();
            referenceDelegate = (Integer)(Map.Entry)next3.getKey().intValue();
            persistTargetData = next3.getValue();
            obj = this.queryDataByTarget.get(referenceDelegate);
            if ((TargetData)obj == null) {
            } else {
            }
            this.targetCache.removeMatchingKeys((TargetChange)persistTargetData.getRemovedDocuments(), referenceDelegate);
            this.targetCache.addMatchingKeys(persistTargetData.getAddedDocuments(), referenceDelegate);
            sequenceNumber = persistTargetData.getResumeToken();
            sequenceNumber = (TargetData)obj.withResumeToken(sequenceNumber, remoteEvent.getSnapshotVersion()).withSequenceNumber(this.persistence.getReferenceDelegate().getCurrentSequenceNumber());
            this.queryDataByTarget.put(referenceDelegate, sequenceNumber);
            if (!sequenceNumber.isEmpty() && LocalStore.shouldPersistTargetData(obj, sequenceNumber, persistTargetData)) {
            }
            sequenceNumber = obj.withResumeToken(sequenceNumber, remoteEvent.getSnapshotVersion()).withSequenceNumber(currentSequenceNumber);
            this.queryDataByTarget.put(referenceDelegate, sequenceNumber);
            if (LocalStore.shouldPersistTargetData(obj, sequenceNumber, persistTargetData)) {
            }
            this.targetCache.updateTargetData(sequenceNumber);
        }
        Map documentUpdates = remoteEvent.getDocumentUpdates();
        iterator = documentUpdates.keySet().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (remoteEvent.getResolvedLimboDocuments().contains((DocumentKey)next)) {
            }
            this.persistence.getReferenceDelegate().updateLimboDocument(next);
        }
        lastRemoteSnapshotVersion = this.targetCache.getLastRemoteSnapshotVersion();
        if (!snapshotVersion2.equals(SnapshotVersion.NONE)) {
            iterator = 1;
            next2 = 0;
            equals = snapshotVersion2.compareTo(lastRemoteSnapshotVersion) >= 0 ? iterator : next2;
            referenceDelegate = new Object[2];
            referenceDelegate[next2] = snapshotVersion2;
            referenceDelegate[iterator] = lastRemoteSnapshotVersion;
            Assert.hardAssert(equals, "Watch stream reverted to previous snapshot?? (%s < %s)", referenceDelegate);
            this.targetCache.setLastRemoteSnapshotVersion(snapshotVersion2);
        }
        return this.localDocuments.getLocalViewOfDocuments(populateDocumentChanges(documentUpdates, 0, remoteEvent.getSnapshotVersion()));
    }

    static com.google.firebase.firestore.local.IndexBackfiller.Results i(com.google.firebase.firestore.local.IndexBackfiller indexBackfiller) {
        return indexBackfiller.backfill();
    }

    private com.google.firebase.firestore.local.LruGarbageCollector.Results j(com.google.firebase.firestore.local.LruGarbageCollector lruGarbageCollector) {
        return lruGarbageCollector.collect(this.queryDataByTarget);
    }

    private void l(List list) {
        Object next;
        com.google.firebase.firestore.local.IndexManager indexManager;
        final Iterator obj3 = list.iterator();
        for (FieldIndex next : obj3) {
            this.indexManager.addFieldIndex(next);
        }
    }

    private NamedQuery n(String string) {
        return this.bundleCache.getNamedQuery(string);
    }

    private static Target newUmbrellaTarget(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("__bundle__/docs/");
        stringBuilder.append(string);
        return Query.atPath(ResourcePath.fromString(stringBuilder.toString())).toTarget();
    }

    private Boolean p(BundleMetadata bundleMetadata) {
        Object bundleMetadata2;
        int obj3;
        bundleMetadata2 = this.bundleCache.getBundleMetadata(bundleMetadata.getBundleId());
        if (bundleMetadata2 != null && bundleMetadata2.getCreateTime().compareTo(bundleMetadata.getCreateTime()) >= 0) {
            obj3 = bundleMetadata2.getCreateTime().compareTo(bundleMetadata.getCreateTime()) >= 0 ? 1 : 0;
        } else {
        }
        return Boolean.valueOf(obj3);
    }

    private Map<DocumentKey, MutableDocument> populateDocumentChanges(Map<DocumentKey, MutableDocument> map, Map<DocumentKey, SnapshotVersion> map2, SnapshotVersion snapshotVersion3) {
        Set keySet;
        Object key;
        Object remoteDocuments;
        Object key2;
        boolean validDocument;
        SnapshotVersion nONE;
        int i;
        SnapshotVersion version;
        HashMap hashMap = new HashMap();
        Iterator obj11 = map.entrySet().iterator();
        while (obj11.hasNext()) {
            Object next2 = obj11.next();
            key = (Map.Entry)next2.getKey();
            keySet = next2.getValue();
            remoteDocuments = this.remoteDocuments.getAll(map.keySet()).get((DocumentKey)key);
            if (map2 != null) {
            } else {
            }
            key2 = snapshotVersion3;
            if ((MutableDocument)keySet.isNoDocument() && keySet.getVersion().equals(SnapshotVersion.NONE)) {
            } else {
            }
            nONE = 0;
            i = 1;
            if ((MutableDocument)remoteDocuments.isValidDocument() && keySet.getVersion().compareTo(remoteDocuments.getVersion()) <= 0) {
            } else {
            }
            Assert.hardAssert(equals ^= i, "Cannot add a document when the remote version is zero", new Object[nONE]);
            this.remoteDocuments.add(keySet, key2);
            hashMap.put(key, keySet);
            if (keySet.getVersion().compareTo(remoteDocuments.getVersion()) <= 0) {
            } else {
            }
            if (keySet.getVersion().compareTo(remoteDocuments.getVersion()) == 0 && remoteDocuments.hasPendingWrites()) {
            } else {
            }
            key2 = new Object[3];
            key2[nONE] = key;
            key2[i] = remoteDocuments.getVersion();
            key2[2] = keySet.getVersion();
            Logger.debug("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key2);
            if (remoteDocuments.hasPendingWrites()) {
            } else {
            }
            if (keySet.getVersion().equals(SnapshotVersion.NONE)) {
            } else {
            }
            this.remoteDocuments.remove(keySet.getKey());
            hashMap.put(key, keySet);
            key2 = map2.get(key);
        }
        return hashMap;
    }

    private void r(List list) {
        boolean lastLimboFreeSnapshotVersion;
        int targetId;
        Object queryDataByTarget;
        Object localViewReferences;
        boolean next;
        Integer referenceDelegate;
        final Iterator obj7 = list.iterator();
        for (LocalViewChanges next3 : obj7) {
            targetId = next3.getTargetId();
            this.localViewReferences.addReferences(next3.getAdded(), targetId);
            queryDataByTarget = next3.getRemoved();
            Iterator iterator = queryDataByTarget.iterator();
            for (DocumentKey next : iterator) {
                this.persistence.getReferenceDelegate().removeReference(next);
            }
            this.localViewReferences.removeReferences(queryDataByTarget, targetId);
            if (!next3.isFromCache()) {
            }
            Object obj = this.queryDataByTarget.get(targetId);
            int i = 1;
            int i2 = 0;
            if ((TargetData)obj != null) {
            } else {
            }
            next = i2;
            Object[] arr = new Object[i];
            arr[i2] = Integer.valueOf(targetId);
            Assert.hardAssert(next, "Can't set limbo-free snapshot version for unknown target: %s", arr);
            this.queryDataByTarget.put(targetId, obj.withLastLimboFreeSnapshotVersion((TargetData)obj.getSnapshotVersion()));
            next = i;
            this.persistence.getReferenceDelegate().removeReference((DocumentKey)iterator.next());
        }
    }

    private static boolean shouldPersistTargetData(com.google.firebase.firestore.local.TargetData targetData, com.google.firebase.firestore.local.TargetData targetData2, TargetChange targetChange3) {
        int i;
        i = 1;
        final int i3 = 0;
        Assert.hardAssert(empty ^= i, "Attempted to persist query data with empty resume token", new Object[i3]);
        if (targetData.getResumeToken().isEmpty()) {
            return i;
        }
        if (Long.compare(i4, obj5) >= 0) {
            return i;
        }
        if (obj5 += obj6 > 0) {
        } else {
            i = i3;
        }
        return i;
    }

    private void startMutationQueue() {
        k kVar = new k(this);
        this.persistence.runTransaction("Start MutationQueue", kVar);
    }

    private ImmutableSortedMap t(int i) {
        int i2;
        MutationBatch obj4 = this.mutationQueue.lookupMutationBatch(i);
        int i3 = 0;
        i2 = obj4 != null ? 1 : i3;
        Assert.hardAssert(i2, "Attempt to reject nonexistent batch!", new Object[i3]);
        this.mutationQueue.removeMutationBatch(obj4);
        this.mutationQueue.performConsistencyCheck();
        return this.localDocuments.getDocuments(obj4.getKeys());
    }

    private void v(int i) {
        String next;
        int referenceDelegate;
        Object obj = this.queryDataByTarget.get(i);
        int i2 = 1;
        int i3 = 0;
        referenceDelegate = (TargetData)obj != null ? i2 : i3;
        Object[] arr = new Object[i2];
        arr[i3] = Integer.valueOf(i);
        Assert.hardAssert(referenceDelegate, "Tried to release nonexistent target: %s", arr);
        Iterator iterator = this.localViewReferences.removeReferencesForId(i).iterator();
        for (DocumentKey next : iterator) {
            this.persistence.getReferenceDelegate().removeReference(next);
        }
        this.persistence.getReferenceDelegate().removeTarget((TargetData)obj);
        this.queryDataByTarget.remove(i);
        this.targetIdByTarget.remove(obj.getTarget());
    }

    private void x(BundleMetadata bundleMetadata) {
        this.bundleCache.saveBundleMetadata(bundleMetadata);
    }

    private void z(NamedQuery namedQuery, com.google.firebase.firestore.local.TargetData targetData2, int i3, ImmutableSortedSet immutableSortedSet4) {
        int targetCache;
        SnapshotVersion snapshotVersion;
        com.google.firebase.firestore.local.TargetCache obj4;
        if (namedQuery.getReadTime().compareTo(targetData2.getSnapshotVersion()) > 0) {
            obj4 = targetData2.withResumeToken(j.a, namedQuery.getReadTime());
            this.queryDataByTarget.append(i3, obj4);
            this.targetCache.updateTargetData(obj4);
            this.targetCache.removeMatchingKeysForTargetId(i3);
            this.targetCache.addMatchingKeys(immutableSortedSet4, i3);
        }
        this.bundleCache.saveNamedQuery(namedQuery);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void A(NamedQuery namedQuery, com.google.firebase.firestore.local.TargetData targetData2, int i3, ImmutableSortedSet immutableSortedSet4) {
        z(namedQuery, targetData2, i3, immutableSortedSet4);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void C(j j) {
        B(j);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void E() {
        D();
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public com.google.firebase.firestore.local.LocalWriteResult G(Set set, List list2, Timestamp timestamp3) {
        return F(set, list2, timestamp3);
    }

    public ImmutableSortedMap<DocumentKey, Document> acknowledgeBatch(MutationBatchResult mutationBatchResult) {
        o oVar = new o(this, mutationBatchResult);
        return (ImmutableSortedMap)this.persistence.runTransaction("Acknowledge batch", oVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public com.google.firebase.firestore.local.TargetData allocateTarget(Target target) {
        com.google.firebase.firestore.local.TargetData targetData;
        int targetId;
        com.google.firebase.firestore.local.g gVar;
        Object targetIdByTarget;
        String str;
        targetData = this.targetCache.getTargetData(target);
        if (targetData != null) {
            targetId = targetData.getTargetId();
        } else {
            LocalStore.AllocateQueryHolder allocateQueryHolder = new LocalStore.AllocateQueryHolder(0);
            gVar = new g(this, allocateQueryHolder, target);
            this.persistence.runTransaction("Allocate target", gVar);
            targetId = allocateQueryHolder.targetId;
            targetData = allocateQueryHolder.cached;
        }
        if (this.queryDataByTarget.get(targetId) == null) {
            this.queryDataByTarget.put(targetId, targetData);
            this.targetIdByTarget.put(target, Integer.valueOf(targetId));
        }
        return targetData;
    }

    public ImmutableSortedMap<DocumentKey, Document> applyBundledDocuments(ImmutableSortedMap<DocumentKey, MutableDocument> immutableSortedMap, String string2) {
        l lVar = new l(this, immutableSortedMap, allocateTarget(LocalStore.newUmbrellaTarget(string2)));
        return (ImmutableSortedMap)this.persistence.runTransaction("Apply bundle documents", lVar);
    }

    public ImmutableSortedMap<DocumentKey, Document> applyRemoteEvent(RemoteEvent remoteEvent) {
        n nVar = new n(this, remoteEvent, remoteEvent.getSnapshotVersion());
        return (ImmutableSortedMap)this.persistence.runTransaction("Apply remote event", nVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public ImmutableSortedMap b(MutationBatchResult mutationBatchResult) {
        return a(mutationBatchResult);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public com.google.firebase.firestore.local.IndexBackfiller.Results backfillIndexes(com.google.firebase.firestore.local.IndexBackfiller indexBackfiller) {
        p pVar = new p(indexBackfiller);
        return (IndexBackfiller.Results)this.persistence.runTransaction("Backfill Indexes", pVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public com.google.firebase.firestore.local.LruGarbageCollector.Results collectGarbage(com.google.firebase.firestore.local.LruGarbageCollector lruGarbageCollector) {
        r rVar = new r(this, lruGarbageCollector);
        return (LruGarbageCollector.Results)this.persistence.runTransaction("Collect garbage", rVar);
    }

    public void configureIndices(List<FieldIndex> list) {
        f fVar = new f(this, list);
        this.persistence.runTransaction("Configure indices", fVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void d(com.google.firebase.firestore.local.LocalStore.AllocateQueryHolder localStore$AllocateQueryHolder, Target target2) {
        c(allocateQueryHolder, target2);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public com.google.firebase.firestore.local.QueryResult executeQuery(Query query, boolean z2) {
        ImmutableSortedSet matchingKeysForTargetId;
        SnapshotVersion nONE;
        SnapshotVersion lastLimboFreeSnapshotVersion;
        com.google.firebase.firestore.local.TargetCache targetCache;
        ImmutableSortedSet obj6;
        com.google.firebase.firestore.local.TargetData targetData = getTargetData(query.toTarget());
        if (targetData != null) {
            lastLimboFreeSnapshotVersion = targetData.getLastLimboFreeSnapshotVersion();
            matchingKeysForTargetId = this.targetCache.getMatchingKeysForTargetId(targetData.getTargetId());
        } else {
            matchingKeysForTargetId = emptyKeySet;
            lastLimboFreeSnapshotVersion = nONE;
        }
        if (z2) {
            nONE = lastLimboFreeSnapshotVersion;
        }
        if (z2) {
            obj6 = matchingKeysForTargetId;
        } else {
            obj6 = DocumentKey.emptyKeySet();
        }
        obj6 = new QueryResult(this.queryEngine.getDocumentsMatchingQuery(query, nONE, obj6), matchingKeysForTargetId);
        return obj6;
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public ImmutableSortedMap f(ImmutableSortedMap immutableSortedMap, com.google.firebase.firestore.local.TargetData targetData2) {
        return e(immutableSortedMap, targetData2);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public int getHighestUnacknowledgedBatchId() {
        return this.mutationQueue.getHighestUnacknowledgedBatchId();
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.targetCache.getLastRemoteSnapshotVersion();
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public j getLastStreamToken() {
        return this.mutationQueue.getLastStreamToken();
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public NamedQuery getNamedQuery(String string) {
        q qVar = new q(this, string);
        return (NamedQuery)this.persistence.runTransaction("Get named query", qVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public MutationBatch getNextMutationBatch(int i) {
        return this.mutationQueue.getNextMutationBatchAfterBatchId(i);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteDocumentKeys(int i) {
        return this.targetCache.getMatchingKeysForTargetId(i);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    com.google.firebase.firestore.local.TargetData getTargetData(Target target) {
        Object obj = this.targetIdByTarget.get(target);
        if ((Integer)obj != null) {
            return (TargetData)this.queryDataByTarget.get((Integer)obj.intValue());
        }
        return this.targetCache.getTargetData(target);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public ImmutableSortedMap h(RemoteEvent remoteEvent, SnapshotVersion snapshotVersion2) {
        return g(remoteEvent, snapshotVersion2);
    }

    public ImmutableSortedMap<DocumentKey, Document> handleUserChange(User user) {
        int iterator2;
        ImmutableSortedSet emptyKeySet;
        List[] iterator;
        int next;
        this.mutationQueue = this.persistence.getMutationQueue(user);
        startMutationQueue();
        LocalDocumentsView localDocumentsView = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, this.indexManager);
        this.localDocuments = localDocumentsView;
        this.queryEngine.setLocalDocumentsView(localDocumentsView);
        emptyKeySet = DocumentKey.emptyKeySet();
        iterator = new List[2];
        Iterator obj6 = Arrays.asList(this.mutationQueue.getAllMutationBatches(), this.mutationQueue.getAllMutationBatches()).iterator();
        for (List next3 : obj6) {
            iterator2 = next3.iterator();
            for (MutationBatch next4 : iterator2) {
                iterator = next4.getMutations().iterator();
                for (Mutation next5 : iterator) {
                    emptyKeySet = emptyKeySet.insert(next5.getKey());
                }
                emptyKeySet = emptyKeySet.insert((Mutation)iterator.next().getKey());
            }
            iterator = (MutationBatch)iterator2.next().getMutations().iterator();
            for (Mutation next5 : iterator) {
                emptyKeySet = emptyKeySet.insert(next5.getKey());
            }
            emptyKeySet = emptyKeySet.insert((Mutation)iterator.next().getKey());
        }
        return this.localDocuments.getDocuments(emptyKeySet);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public boolean hasNewerBundle(BundleMetadata bundleMetadata) {
        i iVar = new i(this, bundleMetadata);
        return (Boolean)this.persistence.runTransaction("Has newer bundle", iVar).booleanValue();
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public com.google.firebase.firestore.local.LruGarbageCollector.Results k(com.google.firebase.firestore.local.LruGarbageCollector lruGarbageCollector) {
        return j(lruGarbageCollector);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void m(List list) {
        l(list);
    }

    public void notifyLocalViewChanges(List<com.google.firebase.firestore.local.LocalViewChanges> list) {
        m mVar = new m(this, list);
        this.persistence.runTransaction("notifyLocalViewChanges", mVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public NamedQuery o(String string) {
        return n(string);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public Boolean q(BundleMetadata bundleMetadata) {
        return p(bundleMetadata);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public Document readDocument(DocumentKey documentKey) {
        return this.localDocuments.getDocument(documentKey);
    }

    public ImmutableSortedMap<DocumentKey, Document> rejectBatch(int i) {
        j jVar = new j(this, i);
        return (ImmutableSortedMap)this.persistence.runTransaction("Reject batch", jVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void releaseTarget(int i) {
        h hVar = new h(this, i);
        this.persistence.runTransaction("Release target", hVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void s(List list) {
        r(list);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void saveBundle(BundleMetadata bundleMetadata) {
        t tVar = new t(this, bundleMetadata);
        this.persistence.runTransaction("Save bundle", tVar);
    }

    public void saveNamedQuery(NamedQuery namedQuery, ImmutableSortedSet<DocumentKey> immutableSortedSet2) {
        final com.google.firebase.firestore.local.TargetData allocateTarget = allocateTarget(namedQuery.getBundledQuery().getTarget());
        super(this, namedQuery, allocateTarget, allocateTarget.getTargetId(), immutableSortedSet2);
        this.persistence.runTransaction("Saved named query", uVar2);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void setLastStreamToken(j j) {
        e eVar = new e(this, j);
        this.persistence.runTransaction("Set stream token", eVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void start() {
        startMutationQueue();
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public ImmutableSortedMap u(int i) {
        return t(i);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void w(int i) {
        v(i);
    }

    public com.google.firebase.firestore.local.LocalWriteResult writeLocally(List<Mutation> list) {
        DocumentKey key;
        HashSet hashSet = new HashSet();
        Iterator iterator = list.iterator();
        for (Mutation next2 : iterator) {
            hashSet.add(next2.getKey());
        }
        s sVar = new s(this, hashSet, list, Timestamp.now());
        return (LocalWriteResult)this.persistence.runTransaction("Locally write mutations", sVar);
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void y(BundleMetadata bundleMetadata) {
        x(bundleMetadata);
    }
}
