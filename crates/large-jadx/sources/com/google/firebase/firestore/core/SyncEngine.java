package com.google.firebase.firestore.core;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleLoader;
import com.google.firebase.firestore.bundle.BundleReader;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LocalViewChanges;
import com.google.firebase.firestore.local.LocalWriteResult;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import io.grpc.d1;
import io.grpc.d1.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class SyncEngine implements RemoteStore.RemoteStoreCallback {

    private static final String TAG = "SyncEngine";
    private final Map<Integer, com.google.firebase.firestore.core.SyncEngine.LimboResolution> activeLimboResolutionsByTarget;
    private final Map<DocumentKey, Integer> activeLimboTargetsByKey;
    private User currentUser;
    private final LinkedHashSet<DocumentKey> enqueuedLimboResolutions;
    private final ReferenceSet limboDocumentRefs;
    private final LocalStore localStore;
    private final int maxConcurrentLimboResolutions;
    private final Map<User, Map<Integer, k<Void>>> mutationUserCallbacks;
    private final Map<Integer, List<k<Void>>> pendingWritesCallbacks;
    private final Map<Integer, List<com.google.firebase.firestore.core.Query>> queriesByTarget;
    private final Map<com.google.firebase.firestore.core.Query, com.google.firebase.firestore.core.QueryView> queryViewsByQuery;
    private final RemoteStore remoteStore;
    private com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback syncEngineListener;
    private final com.google.firebase.firestore.core.TargetIdGenerator targetIdGenerator;

    private static class LimboResolution {

        private final DocumentKey key;
        private boolean receivedDocument;
        LimboResolution(DocumentKey documentKey) {
            super();
            this.key = documentKey;
        }

        static boolean access$000(com.google.firebase.firestore.core.SyncEngine.LimboResolution syncEngine$LimboResolution) {
            return limboResolution.receivedDocument;
        }

        static boolean access$002(com.google.firebase.firestore.core.SyncEngine.LimboResolution syncEngine$LimboResolution, boolean z2) {
            limboResolution.receivedDocument = z2;
            return z2;
        }

        static DocumentKey access$100(com.google.firebase.firestore.core.SyncEngine.LimboResolution syncEngine$LimboResolution) {
            return limboResolution.key;
        }
    }

    interface SyncEngineCallback {
        public abstract void handleOnlineStateChange(com.google.firebase.firestore.core.OnlineState onlineState);

        public abstract void onError(com.google.firebase.firestore.core.Query query, d1 d12);

        public abstract void onViewSnapshots(List<com.google.firebase.firestore.core.ViewSnapshot> list);
    }
    static {
    }

    public SyncEngine(LocalStore localStore, RemoteStore remoteStore2, User user3, int i4) {
        super();
        this.localStore = localStore;
        this.remoteStore = remoteStore2;
        this.maxConcurrentLimboResolutions = i4;
        HashMap obj1 = new HashMap();
        this.queryViewsByQuery = obj1;
        obj1 = new HashMap();
        this.queriesByTarget = obj1;
        obj1 = new LinkedHashSet();
        this.enqueuedLimboResolutions = obj1;
        obj1 = new HashMap();
        this.activeLimboTargetsByKey = obj1;
        obj1 = new HashMap();
        this.activeLimboResolutionsByTarget = obj1;
        obj1 = new ReferenceSet();
        this.limboDocumentRefs = obj1;
        obj1 = new HashMap();
        this.mutationUserCallbacks = obj1;
        this.targetIdGenerator = TargetIdGenerator.forSyncEngine();
        this.currentUser = user3;
        obj1 = new HashMap();
        this.pendingWritesCallbacks = obj1;
    }

    private void addUserCallback(int i, k<Void> k2) {
        Object hashMap;
        Object mutationUserCallbacks;
        User currentUser;
        if ((Map)this.mutationUserCallbacks.get(this.currentUser) == null) {
            hashMap = new HashMap();
            this.mutationUserCallbacks.put(this.currentUser, hashMap);
        }
        hashMap.put(Integer.valueOf(i), k2);
    }

    private void assertCallback(String string) {
        int i;
        int i2 = 1;
        final int i3 = 0;
        i = this.syncEngineListener != null ? i2 : i3;
        Object[] arr = new Object[i2];
        arr[i3] = string;
        Assert.hardAssert(i, "Trying to call %s before setting callback", arr);
    }

    private void emitNewSnapsAndNotifyLocalStore(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, RemoteEvent remoteEvent2) {
        Object viewSnapshot;
        Object snapshot2;
        Object obj;
        com.google.firebase.firestore.core.ViewSnapshot snapshot;
        com.google.firebase.firestore.core.View.DocumentChanges docChanges;
        int targetId;
        boolean needsRefill;
        com.google.firebase.firestore.core.Query query;
        int i;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = this.queryViewsByQuery.entrySet().iterator();
        while (iterator.hasNext()) {
            viewSnapshot = (Map.Entry)iterator.next().getValue();
            com.google.firebase.firestore.core.View view = (QueryView)viewSnapshot.getView();
            docChanges = view.computeDocChanges(immutableSortedMap);
            if (docChanges.needsRefill()) {
            }
            if (remoteEvent2 == null) {
            } else {
            }
            obj = remoteEvent2.getTargetChanges().get(Integer.valueOf(viewSnapshot.getTargetId()));
            snapshot2 = viewSnapshot.getView().applyChanges(docChanges, obj);
            updateTrackedLimboDocuments(snapshot2.getLimboChanges(), viewSnapshot.getTargetId());
            if (snapshot2.getSnapshot() != null) {
            }
            arrayList.add(snapshot2.getSnapshot());
            arrayList2.add(LocalViewChanges.fromViewSnapshot(viewSnapshot.getTargetId(), snapshot2.getSnapshot()));
            obj = 0;
            docChanges = view.computeDocChanges(this.localStore.executeQuery(viewSnapshot.getQuery(), false).getDocuments(), docChanges);
        }
        this.syncEngineListener.onViewSnapshots(arrayList);
        this.localStore.notifyLocalViewChanges(arrayList2);
    }

    private boolean errorIsInteresting(d1 d1) {
        Object fAILED_PRECONDITION;
        String obj4;
        final d1.b bVar = d1.n();
        if (d1.o() != null) {
            obj4 = d1.o();
        } else {
            obj4 = "";
        }
        final int i = 1;
        if (bVar == d1.b.FAILED_PRECONDITION && obj4.contains("requires an index")) {
            if (obj4.contains("requires an index")) {
                return i;
            }
        }
        if (bVar == d1.b.PERMISSION_DENIED) {
            return i;
        }
        return 0;
    }

    private void failOutstandingPendingWritesAwaitingTasks() {
        Iterator iterator;
        boolean next;
        FirebaseFirestoreException firebaseFirestoreException;
        FirebaseFirestoreException.Code cANCELLED;
        String str;
        Iterator iterator2 = this.pendingWritesCallbacks.entrySet().iterator();
        for (Map.Entry next3 : iterator2) {
            iterator = (List)next3.getValue().iterator();
            for (k next : iterator) {
                firebaseFirestoreException = new FirebaseFirestoreException("'waitForPendingWrites' task is cancelled due to User change.", FirebaseFirestoreException.Code.CANCELLED);
                next.b(firebaseFirestoreException);
            }
            firebaseFirestoreException = new FirebaseFirestoreException("'waitForPendingWrites' task is cancelled due to User change.", FirebaseFirestoreException.Code.CANCELLED);
            (k)iterator.next().b(firebaseFirestoreException);
        }
        this.pendingWritesCallbacks.clear();
    }

    private com.google.firebase.firestore.core.ViewSnapshot initializeViewAndComputeSnapshot(com.google.firebase.firestore.core.Query query, int i2) {
        TargetChange synthesizedTargetChangeForCurrentChange;
        boolean queriesByTarget;
        int valueOf2;
        Integer valueOf;
        com.google.firebase.firestore.core.ViewSnapshot.SyncState sYNCED;
        Object remoteKeys;
        int i = 1;
        QueryResult query2 = this.localStore.executeQuery(query, i);
        com.google.firebase.firestore.core.ViewSnapshot.SyncState nONE = ViewSnapshot.SyncState.NONE;
        if (this.queriesByTarget.get(Integer.valueOf(i2)) != null) {
            if ((QueryView)this.queryViewsByQuery.get((Query)(List)this.queriesByTarget.get(Integer.valueOf(i2)).get(0)).getView().getSyncState() == ViewSnapshot.SyncState.SYNCED) {
                valueOf2 = i;
            }
            synthesizedTargetChangeForCurrentChange = TargetChange.createSynthesizedTargetChangeForCurrentChange(valueOf2);
        } else {
            synthesizedTargetChangeForCurrentChange = 0;
        }
        View view2 = new View(query, query2.getRemoteKeys());
        com.google.firebase.firestore.core.ViewChange changes = view2.applyChanges(view2.computeDocChanges(query2.getDocuments()), synthesizedTargetChangeForCurrentChange);
        updateTrackedLimboDocuments(changes.getLimboChanges(), i2);
        QueryView queryView = new QueryView(query, i2, view2);
        this.queryViewsByQuery.put(query, queryView);
        if (!this.queriesByTarget.containsKey(Integer.valueOf(i2))) {
            remoteKeys = new ArrayList(i);
            this.queriesByTarget.put(Integer.valueOf(i2), remoteKeys);
        }
        (List)this.queriesByTarget.get(Integer.valueOf(i2)).add(query);
        return changes.getSnapshot();
    }

    private void logErrorIfInteresting(d1 d1, String string2, Object... object3Arr3) {
        boolean errorIsInteresting;
        Object obj2;
        String obj3;
        Object[] obj4;
        if (errorIsInteresting(d1)) {
            obj4 = new Object[2];
            Logger.warn("Firestore", "%s: %s", String.format(string2, object3Arr3), d1);
        }
    }

    private void notifyUser(int i, d1 d12) {
        Object currentUser;
        int obj3;
        FirebaseFirestoreException obj4;
        Object obj = this.mutationUserCallbacks.get(this.currentUser);
        obj3 = Integer.valueOf(i);
        currentUser = (Map)obj.get(obj3);
        if (obj != null && (k)currentUser != null) {
            obj3 = Integer.valueOf(i);
            currentUser = obj.get(obj3);
            if ((k)(k)currentUser != null) {
                if (d12 != null) {
                    (k)(k)currentUser.b(Util.exceptionFromStatus(d12));
                } else {
                    currentUser.c(0);
                }
                obj.remove(obj3);
            }
        }
    }

    private void pumpEnqueuedLimboResolutions() {
        boolean empty;
        int maxConcurrentLimboResolutions;
        while (!this.enqueuedLimboResolutions.isEmpty()) {
            if (this.activeLimboTargetsByKey.size() < this.maxConcurrentLimboResolutions) {
            }
            Iterator iterator = this.enqueuedLimboResolutions.iterator();
            Object next = iterator.next();
            iterator.remove();
            final int nextId = this.targetIdGenerator.nextId();
            SyncEngine.LimboResolution limboResolution = new SyncEngine.LimboResolution((DocumentKey)next);
            this.activeLimboResolutionsByTarget.put(Integer.valueOf(nextId), limboResolution);
            this.activeLimboTargetsByKey.put(next, Integer.valueOf(nextId));
            super(Query.atPath(next.getPath()).toTarget(), nextId, -1, obj6, QueryPurpose.LIMBO_RESOLUTION);
            this.remoteStore.listen(targetData2);
        }
    }

    private void removeAndCleanupTarget(int i, d1 d12) {
        ReferenceSet limboDocumentRefs;
        Integer valueOf;
        boolean arr;
        int i2;
        ImmutableSortedSet obj6;
        Iterator iterator = (List)this.queriesByTarget.get(Integer.valueOf(i)).iterator();
        while (iterator.hasNext()) {
            valueOf = iterator.next();
            this.queryViewsByQuery.remove((Query)valueOf);
            if (!d12.p()) {
            }
            this.syncEngineListener.onError(valueOf, d12);
            arr = new Object[1];
            logErrorIfInteresting(d12, "Listen for %s failed", valueOf);
        }
        this.queriesByTarget.remove(Integer.valueOf(i));
        this.limboDocumentRefs.removeReferencesForId(i);
        final Iterator obj5 = this.limboDocumentRefs.referencesForId(i).iterator();
        while (obj5.hasNext()) {
            obj6 = obj5.next();
            if (this.limboDocumentRefs.containsKey((DocumentKey)obj6) == null) {
            }
            removeLimboTarget(obj6);
        }
    }

    private void removeLimboTarget(DocumentKey documentKey) {
        Map activeLimboTargetsByKey;
        int intValue;
        Object obj4;
        this.enqueuedLimboResolutions.remove(documentKey);
        Object obj = this.activeLimboTargetsByKey.get(documentKey);
        if ((Integer)obj != null) {
            this.remoteStore.stopListening((Integer)obj.intValue());
            this.activeLimboTargetsByKey.remove(documentKey);
            this.activeLimboResolutionsByTarget.remove(obj);
            pumpEnqueuedLimboResolutions();
        }
    }

    private void resolvePendingWriteTasks(int i) {
        boolean pendingWritesCallbacks;
        Integer valueOf;
        Integer valueOf2;
        int i2;
        int obj4;
        if (this.pendingWritesCallbacks.containsKey(Integer.valueOf(i))) {
            Iterator iterator = (List)this.pendingWritesCallbacks.get(Integer.valueOf(i)).iterator();
            for (k valueOf2 : iterator) {
                valueOf2.c(0);
            }
            this.pendingWritesCallbacks.remove(Integer.valueOf(i));
        }
    }

    private void trackLimboChange(com.google.firebase.firestore.core.LimboDocumentChange limboDocumentChange) {
        boolean enqueuedLimboResolutions;
        Object[] arr;
        String str;
        final DocumentKey obj4 = limboDocumentChange.getKey();
        if (!this.activeLimboTargetsByKey.containsKey(obj4) && !this.enqueuedLimboResolutions.contains(obj4)) {
            if (!this.enqueuedLimboResolutions.contains(obj4)) {
                arr = new Object[1];
                Logger.debug(SyncEngine.TAG, "New document in limbo: %s", obj4);
                this.enqueuedLimboResolutions.add(obj4);
                pumpEnqueuedLimboResolutions();
            }
        }
    }

    private void updateTrackedLimboDocuments(List<com.google.firebase.firestore.core.LimboDocumentChange> list, int i2) {
        Object next;
        ReferenceSet limboDocumentRefs;
        DocumentKey key;
        String str;
        int i;
        Iterator obj6 = list.iterator();
        for (LimboDocumentChange next : obj6) {
            int i3 = SyncEngine.1.$SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type[next.getType().ordinal()];
            int i4 = 1;
            this.limboDocumentRefs.addReference(next.getKey(), i2);
            trackLimboChange(next);
            i = 0;
            key = new Object[i4];
            key[i] = next.getKey();
            Logger.debug(SyncEngine.TAG, "Document no longer in limbo: %s", key);
            next = next.getKey();
            this.limboDocumentRefs.removeReference(next, i2);
            if (!this.limboDocumentRefs.containsKey(next)) {
            }
            removeLimboTarget(next);
        }
    }

    public Map<DocumentKey, Integer> getActiveLimboDocumentResolutions() {
        HashMap hashMap = new HashMap(this.activeLimboTargetsByKey);
        return hashMap;
    }

    public List<DocumentKey> getEnqueuedLimboDocumentResolutions() {
        ArrayList arrayList = new ArrayList(this.enqueuedLimboResolutions);
        return arrayList;
    }

    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
        ImmutableSortedSet emptyKeySet;
        Integer valueOf;
        boolean next;
        Map queriesByTarget;
        Integer queryViewsByQuery;
        int obj4;
        Object obj = this.activeLimboResolutionsByTarget.get(Integer.valueOf(i));
        if (obj != null && SyncEngine.LimboResolution.access$000((SyncEngine.LimboResolution)obj)) {
            if (SyncEngine.LimboResolution.access$000(obj)) {
                return DocumentKey.emptyKeySet().insert(SyncEngine.LimboResolution.access$100(obj));
            }
        }
        emptyKeySet = DocumentKey.emptyKeySet();
        if (this.queriesByTarget.containsKey(Integer.valueOf(i))) {
            obj4 = (List)this.queriesByTarget.get(Integer.valueOf(i)).iterator();
            while (obj4.hasNext()) {
                queriesByTarget = obj4.next();
                if (this.queryViewsByQuery.containsKey((Query)queriesByTarget) != null) {
                }
                emptyKeySet = emptyKeySet.unionWith((QueryView)this.queryViewsByQuery.get(queriesByTarget).getView().getSyncedDocuments());
            }
        }
        return emptyKeySet;
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void handleCredentialChange(User user) {
        int i;
        Object obj2;
        this.currentUser = user;
        if (equals ^= 1 != 0) {
            failOutstandingPendingWritesAwaitingTasks();
            emitNewSnapsAndNotifyLocalStore(this.localStore.handleUserChange(user), 0);
        }
        this.remoteStore.handleCredentialChange();
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void handleOnlineStateChange(com.google.firebase.firestore.core.OnlineState onlineState) {
        Object onlineStateChange;
        com.google.firebase.firestore.core.ViewSnapshot snapshot;
        Object[] arr;
        String str;
        assertCallback("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.queryViewsByQuery.entrySet().iterator();
        while (iterator.hasNext()) {
            onlineStateChange = (QueryView)(Map.Entry)iterator.next().getValue().getView().applyOnlineStateChange(onlineState);
            Assert.hardAssert(onlineStateChange.getLimboChanges().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (onlineStateChange.getSnapshot() != null) {
            }
            arrayList.add(onlineStateChange.getSnapshot());
        }
        this.syncEngineListener.onViewSnapshots(arrayList);
        this.syncEngineListener.handleOnlineStateChange(onlineState);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void handleRejectedListen(int i, d1 d12) {
        DocumentKey localStore;
        Object valueOf;
        SnapshotVersion nONE;
        Map emptyMap;
        Set emptySet;
        Map singletonMap;
        Set singleton;
        int obj8;
        Object obj9;
        assertCallback("handleRejectedListen");
        Object obj = this.activeLimboResolutionsByTarget.get(Integer.valueOf(i));
        if ((SyncEngine.LimboResolution)obj != null) {
            localStore = SyncEngine.LimboResolution.access$100((SyncEngine.LimboResolution)obj);
        } else {
            localStore = 0;
        }
        if (localStore != null) {
            this.activeLimboTargetsByKey.remove(localStore);
            this.activeLimboResolutionsByTarget.remove(Integer.valueOf(i));
            pumpEnqueuedLimboResolutions();
            nONE = SnapshotVersion.NONE;
            super(nONE, Collections.emptyMap(), Collections.emptySet(), Collections.singletonMap(localStore, MutableDocument.newNoDocument(localStore, nONE)), Collections.singleton(localStore));
            handleRemoteEvent(obj8);
        } else {
            this.localStore.releaseTarget(i);
            removeAndCleanupTarget(i, d12);
        }
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void handleRejectedWrite(int i, d1 d12) {
        boolean empty;
        String str;
        com.google.firebase.firestore.model.ResourcePath path;
        assertCallback("handleRejectedWrite");
        ImmutableSortedMap rejectBatch = this.localStore.rejectBatch(i);
        if (!rejectBatch.isEmpty()) {
            empty = new Object[1];
            logErrorIfInteresting(d12, "Write failed at %s", (DocumentKey)rejectBatch.getMinKey().getPath());
        }
        notifyUser(i, d12);
        resolvePendingWriteTasks(i);
        emitNewSnapsAndNotifyLocalStore(rejectBatch, 0);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void handleRemoteEvent(RemoteEvent remoteEvent) {
        Object value;
        Object arr2;
        Map activeLimboResolutionsByTarget;
        int i;
        int str;
        int i2;
        Object[] arr;
        String str2;
        assertCallback("handleRemoteEvent");
        Iterator iterator = remoteEvent.getTargetChanges().entrySet().iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            value = next2.getValue();
            arr2 = this.activeLimboResolutionsByTarget.get((Integer)(Map.Entry)next2.getKey());
            if ((SyncEngine.LimboResolution)arr2 != null) {
            }
            str = 1;
            i2 = 0;
            if (i3 += size3 <= str) {
            } else {
            }
            i = i2;
            Assert.hardAssert(i, "Limbo resolution for single document contains multiple changes.", new Object[i2]);
            if (value.getAddedDocuments().size() > 0) {
            } else {
            }
            if (value.getModifiedDocuments().size() > 0) {
            } else {
            }
            if (value.getRemovedDocuments().size() > 0) {
            }
            Assert.hardAssert(SyncEngine.LimboResolution.access$000((SyncEngine.LimboResolution)arr2), "Received remove for limbo target document without add.", new Object[i2]);
            SyncEngine.LimboResolution.access$002(arr2, i2);
            Assert.hardAssert(SyncEngine.LimboResolution.access$000(arr2), "Received change for limbo target document without add.", new Object[i2]);
            SyncEngine.LimboResolution.access$002(arr2, str);
            i = str;
        }
        emitNewSnapsAndNotifyLocalStore(this.localStore.applyRemoteEvent(remoteEvent), remoteEvent);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
        assertCallback("handleSuccessfulWrite");
        final int i = 0;
        notifyUser(mutationBatchResult.getBatch().getBatchId(), i);
        resolvePendingWriteTasks(mutationBatchResult.getBatch().getBatchId());
        emitNewSnapsAndNotifyLocalStore(this.localStore.acknowledgeBatch(mutationBatchResult), i);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public int listen(com.google.firebase.firestore.core.Query query) {
        assertCallback("listen");
        int i2 = 1;
        Object[] arr = new Object[i2];
        arr[0] = query;
        Assert.hardAssert(key ^= i2, "We already listen to query: %s", arr);
        TargetData allocateTarget = this.localStore.allocateTarget(query.toTarget());
        this.syncEngineListener.onViewSnapshots(Collections.singletonList(initializeViewAndComputeSnapshot(query, allocateTarget.getTargetId())));
        this.remoteStore.listen(allocateTarget);
        return allocateTarget.getTargetId();
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void loadBundle(BundleReader bundleReader, LoadBundleTask loadBundleTask2) {
        int arr;
        LoadBundleTaskProgress forSuccess;
        LocalStore localStore;
        int i2;
        int i;
        Object[] iNVALID_ARGUMENT;
        com.google.firebase.firestore.bundle.BundleElement nextElement;
        long bytesRead;
        Throwable obj12;
        Object[] obj13;
        final String str = "Exception while closing bundle";
        final String str2 = "SyncEngine";
        final int i3 = 0;
        final int i4 = 1;
        com.google.firebase.firestore.bundle.BundleMetadata bundleMetadata = bundleReader.getBundleMetadata();
        if (this.localStore.hasNewerBundle(bundleMetadata)) {
            loadBundleTask2.setResult(LoadBundleTaskProgress.forSuccess(bundleMetadata));
            bundleReader.close();
        }
        loadBundleTask2.updateProgress(LoadBundleTaskProgress.forInitial(bundleMetadata));
        BundleLoader bundleLoader = new BundleLoader(this.localStore, bundleMetadata);
        i2 = 0;
        nextElement = bundleReader.getNextElement();
        while (nextElement != null) {
            bytesRead = bundleReader.getBytesRead();
            LoadBundleTaskProgress element = bundleLoader.addElement(nextElement, bytesRead - i2);
            if (element != null) {
            }
            i2 = bytesRead;
            nextElement = bundleReader.getNextElement();
            loadBundleTask2.updateProgress(element);
        }
        emitNewSnapsAndNotifyLocalStore(bundleLoader.applyChanges(), 0);
        this.localStore.saveBundle(bundleMetadata);
        loadBundleTask2.setResult(LoadBundleTaskProgress.forSuccess(bundleMetadata));
        bundleReader.close();
    }

    public void registerPendingWritesTask(k<Void> k) {
        boolean useNetwork;
        Object[] arr;
        boolean pendingWritesCallbacks;
        String str;
        Integer valueOf;
        ArrayList arrayList;
        if (!this.remoteStore.canUseNetwork()) {
            Logger.debug(SyncEngine.TAG, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]);
        }
        int highestUnacknowledgedBatchId = this.localStore.getHighestUnacknowledgedBatchId();
        if (highestUnacknowledgedBatchId == -1) {
            k.c(0);
        }
        if (!this.pendingWritesCallbacks.containsKey(Integer.valueOf(highestUnacknowledgedBatchId))) {
            arrayList = new ArrayList();
            this.pendingWritesCallbacks.put(Integer.valueOf(highestUnacknowledgedBatchId), arrayList);
        }
        (List)this.pendingWritesCallbacks.get(Integer.valueOf(highestUnacknowledgedBatchId)).add(k);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    public void setCallback(com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback syncEngine$SyncEngineCallback) {
        this.syncEngineListener = syncEngineCallback;
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore$RemoteStoreCallback
    void stopListening(com.google.firebase.firestore.core.Query query) {
        int i;
        boolean obj5;
        assertCallback("stopListening");
        Object obj = this.queryViewsByQuery.get(query);
        int i2 = 0;
        i = (QueryView)obj != null ? 1 : i2;
        Assert.hardAssert(i, "Trying to stop listening to a query not found", new Object[i2]);
        this.queryViewsByQuery.remove(query);
        int targetId = (QueryView)obj.getTargetId();
        Object obj2 = this.queriesByTarget.get(Integer.valueOf(targetId));
        (List)obj2.remove(query);
        if (obj2.isEmpty()) {
            this.localStore.releaseTarget(targetId);
            this.remoteStore.stopListening(targetId);
            removeAndCleanupTarget(targetId, d1.f);
        }
    }

    public <TResult> j<TResult> transaction(AsyncQueue asyncQueue, Function<com.google.firebase.firestore.core.Transaction, j<TResult>> function2) {
        TransactionRunner transactionRunner = new TransactionRunner(asyncQueue, this.remoteStore, function2);
        return transactionRunner.run();
    }

    public void writeMutations(List<Mutation> list, k<Void> k2) {
        assertCallback("writeMutations");
        LocalWriteResult obj2 = this.localStore.writeLocally(list);
        addUserCallback(obj2.getBatchId(), k2);
        emitNewSnapsAndNotifyLocalStore(obj2.getChanges(), 0);
        this.remoteStore.fillWritePipeline();
    }
}
