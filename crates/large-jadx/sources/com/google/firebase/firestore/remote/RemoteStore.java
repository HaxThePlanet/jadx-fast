package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.j;
import io.grpc.d1;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes2.dex */
public final class RemoteStore implements com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider {

    private static final String LOG_TAG = "RemoteStore";
    private static final int MAX_PENDING_WRITES = 10;
    private final com.google.firebase.firestore.remote.ConnectivityMonitor connectivityMonitor;
    private final com.google.firebase.firestore.remote.Datastore datastore;
    private final Map<Integer, TargetData> listenTargets;
    private final LocalStore localStore;
    private boolean networkEnabled = false;
    private final com.google.firebase.firestore.remote.OnlineStateTracker onlineStateTracker;
    private final com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback remoteStoreCallback;
    private com.google.firebase.firestore.remote.WatchChangeAggregator watchChangeAggregator;
    private final com.google.firebase.firestore.remote.WatchStream watchStream;
    private final Deque<MutationBatch> writePipeline;
    private final com.google.firebase.firestore.remote.WriteStream writeStream;

    public interface RemoteStoreCallback {
        public abstract ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i);

        public abstract void handleOnlineStateChange(OnlineState onlineState);

        public abstract void handleRejectedListen(int i, d1 d12);

        public abstract void handleRejectedWrite(int i, d1 d12);

        public abstract void handleRemoteEvent(com.google.firebase.firestore.remote.RemoteEvent remoteEvent);

        public abstract void handleSuccessfulWrite(MutationBatchResult mutationBatchResult);
    }
    public RemoteStore(com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback remoteStore$RemoteStoreCallback, LocalStore localStore2, com.google.firebase.firestore.remote.Datastore datastore3, AsyncQueue asyncQueue4, com.google.firebase.firestore.remote.ConnectivityMonitor connectivityMonitor5) {
        super();
        int i = 0;
        this.remoteStoreCallback = remoteStoreCallback;
        this.localStore = localStore2;
        this.datastore = datastore3;
        this.connectivityMonitor = connectivityMonitor5;
        HashMap obj3 = new HashMap();
        this.listenTargets = obj3;
        obj3 = new ArrayDeque();
        this.writePipeline = obj3;
        Objects.requireNonNull(remoteStoreCallback);
        y yVar = new y(remoteStoreCallback);
        obj3 = new OnlineStateTracker(asyncQueue4, yVar);
        this.onlineStateTracker = obj3;
        RemoteStore.1 obj2 = new RemoteStore.1(this);
        this.watchStream = datastore3.createWatchStream(obj2);
        obj2 = new RemoteStore.2(this);
        this.writeStream = datastore3.createWriteStream(obj2);
        obj2 = new w(this, asyncQueue4);
        connectivityMonitor5.addCallback(obj2);
    }

    private void a(com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus connectivityMonitor$NetworkStatus) {
        boolean equals;
        Enum uNREACHABLE;
        OnlineState oNLINE;
        boolean obj3;
        if (networkStatus.equals(ConnectivityMonitor.NetworkStatus.REACHABLE) && this.onlineStateTracker.getState().equals(OnlineState.ONLINE)) {
            if (this.onlineStateTracker.getState().equals(OnlineState.ONLINE)) {
            }
        }
        if (networkStatus.equals(ConnectivityMonitor.NetworkStatus.UNREACHABLE) && this.onlineStateTracker.getState().equals(OnlineState.OFFLINE)) {
            if (this.onlineStateTracker.getState().equals(OnlineState.OFFLINE)) {
            }
        }
        if (!canUseNetwork()) {
        }
        Logger.debug("RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
        restartNetwork();
    }

    static void access$000(com.google.firebase.firestore.remote.RemoteStore remoteStore) {
        remoteStore.handleWatchStreamOpen();
    }

    static void access$100(com.google.firebase.firestore.remote.RemoteStore remoteStore, SnapshotVersion snapshotVersion2, com.google.firebase.firestore.remote.WatchChange watchChange3) {
        remoteStore.handleWatchChange(snapshotVersion2, watchChange3);
    }

    static void access$200(com.google.firebase.firestore.remote.RemoteStore remoteStore, d1 d12) {
        remoteStore.handleWatchStreamClose(d12);
    }

    static com.google.firebase.firestore.remote.WriteStream access$300(com.google.firebase.firestore.remote.RemoteStore remoteStore) {
        return remoteStore.writeStream;
    }

    static void access$400(com.google.firebase.firestore.remote.RemoteStore remoteStore) {
        remoteStore.handleWriteStreamHandshakeComplete();
    }

    static void access$500(com.google.firebase.firestore.remote.RemoteStore remoteStore, SnapshotVersion snapshotVersion2, List list3) {
        remoteStore.handleWriteStreamMutationResults(snapshotVersion2, list3);
    }

    static void access$600(com.google.firebase.firestore.remote.RemoteStore remoteStore, d1 d12) {
        remoteStore.handleWriteStreamClose(d12);
    }

    private void addToWritePipeline(MutationBatch mutationBatch) {
        boolean handshakeComplete;
        Object obj4;
        Assert.hardAssert(canAddToWritePipeline(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.writePipeline.add(mutationBatch);
        if (this.writeStream.isOpen() && this.writeStream.isHandshakeComplete()) {
            if (this.writeStream.isHandshakeComplete()) {
                this.writeStream.writeMutations(mutationBatch.getMutations());
            }
        }
    }

    private void c(AsyncQueue asyncQueue, com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus connectivityMonitor$NetworkStatus2) {
        x xVar = new x(this, networkStatus2);
        asyncQueue.enqueueAndForget(xVar);
    }

    private boolean canAddToWritePipeline() {
        boolean useNetwork;
        int i;
        int i2;
        if (canUseNetwork() && this.writePipeline.size() < 10) {
            i = this.writePipeline.size() < 10 ? 1 : 0;
        } else {
        }
        return i;
    }

    private void cleanUpWatchStreamState() {
        this.watchChangeAggregator = 0;
    }

    private void disableNetworkInternal() {
        boolean writePipeline;
        String str;
        String str2;
        this.watchStream.stop();
        this.writeStream.stop();
        if (!this.writePipeline.isEmpty()) {
            Object[] arr = new Object[1];
            Logger.debug("RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.writePipeline.size()));
            this.writePipeline.clear();
        }
        cleanUpWatchStreamState();
    }

    private void handleWatchChange(SnapshotVersion snapshotVersion, com.google.firebase.firestore.remote.WatchChange watchChange2) {
        Object watchChangeAggregator;
        int i;
        com.google.firebase.firestore.remote.WatchChangeAggregator watchChangeAggregator2;
        int arr;
        int str;
        String equals;
        com.google.firebase.firestore.remote.WatchChange.WatchTargetChangeType removed;
        boolean obj7;
        this.onlineStateTracker.updateState(OnlineState.ONLINE);
        arr = 0;
        if (this.watchStream != null && this.watchChangeAggregator != null) {
            i = this.watchChangeAggregator != null ? 1 : arr;
        } else {
        }
        Assert.hardAssert(i, "WatchStream and WatchStreamAggregator should both be non-null", new Object[arr]);
        watchChangeAggregator2 = watchChange2 instanceof WatchChange.WatchTargetChange;
        if (watchChangeAggregator2) {
            str = watchChange2;
        } else {
            str = 0;
        }
        if (str != null && str.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed) && str.getCause() != null) {
            if (str.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed)) {
                if (str.getCause() != null) {
                    processTargetError(str);
                } else {
                    if (watchChange2 instanceof WatchChange.DocumentChange) {
                        this.watchChangeAggregator.handleDocumentChange((WatchChange.DocumentChange)watchChange2);
                    } else {
                        if (watchChange2 instanceof WatchChange.ExistenceFilterWatchChange) {
                            this.watchChangeAggregator.handleExistenceFilter((WatchChange.ExistenceFilterWatchChange)watchChange2);
                        } else {
                            Assert.hardAssert(watchChangeAggregator2, "Expected watchChange to be an instance of WatchTargetChange", new Object[arr]);
                            this.watchChangeAggregator.handleTargetChange((WatchChange.WatchTargetChange)watchChange2);
                        }
                    }
                    if (!snapshotVersion.equals(SnapshotVersion.NONE) && snapshotVersion.compareTo(this.localStore.getLastRemoteSnapshotVersion()) >= 0) {
                        if (snapshotVersion.compareTo(this.localStore.getLastRemoteSnapshotVersion()) >= 0) {
                            raiseWatchSnapshot(snapshotVersion);
                        }
                    }
                }
            } else {
            }
        } else {
        }
    }

    private void handleWatchStreamClose(d1 d1) {
        boolean z;
        Object onlineStateTracker;
        Object[] arr;
        String str;
        Object obj4;
        if (d1.p()) {
            Assert.hardAssert(startWatchStream ^= 1, "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        cleanUpWatchStreamState();
        if (shouldStartWatchStream()) {
            this.onlineStateTracker.handleWatchStreamFailure(d1);
            startWatchStream();
        } else {
            this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
        }
    }

    private void handleWatchStreamOpen() {
        Object next;
        Iterator iterator = this.listenTargets.values().iterator();
        for (TargetData next : iterator) {
            sendWatchRequest(next);
        }
    }

    private void handleWriteError(d1 d1) {
        boolean permanentWriteError;
        Object[] remoteStoreCallback;
        Assert.hardAssert(z ^= 1, "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentWriteError(d1)) {
            this.writeStream.inhibitBackoff();
            this.remoteStoreCallback.handleRejectedWrite((MutationBatch)this.writePipeline.poll().getBatchId(), d1);
            fillWritePipeline();
        }
    }

    private void handleWriteHandshakeError(d1 d1) {
        boolean eMPTY_STREAM_TOKEN;
        Object[] arr;
        Object obj6;
        final int i2 = 1;
        final int i3 = 0;
        Assert.hardAssert(z ^= i2, "Handling write error with status OK.", new Object[i3]);
        if (Datastore.isPermanentError(d1)) {
            arr = new Object[2];
            arr[i3] = Util.toDebugString(this.writeStream.getLastStreamToken());
            arr[i2] = d1;
            Logger.debug("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", arr);
            eMPTY_STREAM_TOKEN = WriteStream.EMPTY_STREAM_TOKEN;
            this.writeStream.setLastStreamToken(eMPTY_STREAM_TOKEN);
            this.localStore.setLastStreamToken(eMPTY_STREAM_TOKEN);
        }
    }

    private void handleWriteStreamClose(d1 d1) {
        boolean z;
        boolean handshakeComplete;
        Object[] arr;
        String str;
        if (d1.p()) {
            Assert.hardAssert(startWriteStream ^= 1, "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!d1.p() && !this.writePipeline.isEmpty()) {
            if (!this.writePipeline.isEmpty()) {
                if (this.writeStream.isHandshakeComplete()) {
                    handleWriteError(d1);
                } else {
                    handleWriteHandshakeError(d1);
                }
            }
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    private void handleWriteStreamHandshakeComplete() {
        j lastStreamToken;
        com.google.firebase.firestore.remote.WriteStream writeStream;
        this.localStore.setLastStreamToken(this.writeStream.getLastStreamToken());
        Iterator iterator = this.writePipeline.iterator();
        for (MutationBatch next2 : iterator) {
            this.writeStream.writeMutations(next2.getMutations());
        }
    }

    private void handleWriteStreamMutationResults(SnapshotVersion snapshotVersion, List<MutationResult> list2) {
        this.remoteStoreCallback.handleSuccessfulWrite(MutationBatchResult.create((MutationBatch)this.writePipeline.poll(), snapshotVersion, list2, this.writeStream.getLastStreamToken()));
        fillWritePipeline();
    }

    private void processTargetError(com.google.firebase.firestore.remote.WatchChange.WatchTargetChange watchChange$WatchTargetChange) {
        int i;
        Object[] intValue;
        String remoteStoreCallback;
        d1 cause;
        int i2 = 0;
        i = watchTargetChange.getCause() != null ? 1 : i2;
        Assert.hardAssert(i, "Processing target error without a cause", new Object[i2]);
        Iterator iterator = watchTargetChange.getTargetIds().iterator();
        while (iterator.hasNext()) {
            intValue = iterator.next();
            if (this.listenTargets.containsKey((Integer)intValue) != null) {
            }
            this.listenTargets.remove(intValue);
            this.watchChangeAggregator.removeTarget(intValue.intValue());
            this.remoteStoreCallback.handleRejectedListen(intValue.intValue(), watchTargetChange.getCause());
        }
    }

    private void raiseWatchSnapshot(SnapshotVersion snapshotVersion) {
        Iterator iterator;
        String intValue2;
        boolean valueOf;
        Object resumeToken;
        boolean intValue;
        Object sequenceNumber;
        SnapshotVersion snapshotVersion2;
        QueryPurpose eXISTENCE_FILTER_MISMATCH;
        TargetData targetData;
        Assert.hardAssert(equals ^= 1, "Can't raise event for unknown SnapshotVersion", new Object[0]);
        com.google.firebase.firestore.remote.RemoteEvent remoteEvent = this.watchChangeAggregator.createRemoteEvent(snapshotVersion);
        iterator = remoteEvent.getTargetChanges().entrySet().iterator();
        while (iterator.hasNext()) {
            intValue2 = iterator.next();
            resumeToken = (Map.Entry)intValue2.getValue();
            intValue2 = (Integer)intValue2.getKey().intValue();
            intValue = this.listenTargets.get(Integer.valueOf(intValue2));
            if (!(TargetChange)resumeToken.getResumeToken().isEmpty() && (TargetData)intValue != null) {
            }
            intValue2 = (Integer)intValue2.getKey().intValue();
            intValue = this.listenTargets.get(Integer.valueOf(intValue2));
            if ((TargetData)(TargetData)intValue != null) {
            }
            this.listenTargets.put(Integer.valueOf(intValue2), (TargetData)(TargetData)intValue.withResumeToken(resumeToken.getResumeToken(), snapshotVersion));
        }
        Iterator obj10 = remoteEvent.getTargetMismatches().iterator();
        while (obj10.hasNext()) {
            intValue = (Integer)obj10.next().intValue();
            iterator = this.listenTargets.get(Integer.valueOf(intValue));
            if ((TargetData)iterator != null) {
            }
            snapshotVersion2 = (TargetData)iterator.getSnapshotVersion();
            this.listenTargets.put(Integer.valueOf(intValue), iterator.withResumeToken(j.a, snapshotVersion2));
            sendUnwatchRequest(intValue);
            super(iterator.getTarget(), intValue, iterator.getSequenceNumber(), snapshotVersion2, QueryPurpose.EXISTENCE_FILTER_MISMATCH);
            sendWatchRequest(targetData);
        }
        this.remoteStoreCallback.handleRemoteEvent(remoteEvent);
    }

    private void restartNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
        this.writeStream.inhibitBackoff();
        this.watchStream.inhibitBackoff();
        enableNetwork();
    }

    private void sendUnwatchRequest(int i) {
        this.watchChangeAggregator.recordPendingTargetRequest(i);
        this.watchStream.unwatchTarget(i);
    }

    private void sendWatchRequest(TargetData targetData) {
        this.watchChangeAggregator.recordPendingTargetRequest(targetData.getTargetId());
        this.watchStream.watchQuery(targetData);
    }

    private boolean shouldStartWatchStream() {
        int i;
        boolean useNetwork;
        if (canUseNetwork() && !this.watchStream.isStarted() && !this.listenTargets.isEmpty()) {
            if (!this.watchStream.isStarted()) {
                i = !this.listenTargets.isEmpty() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private boolean shouldStartWriteStream() {
        int i;
        boolean useNetwork;
        if (canUseNetwork() && !this.writeStream.isStarted() && !this.writePipeline.isEmpty()) {
            if (!this.writeStream.isStarted()) {
                i = !this.writePipeline.isEmpty() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    private void startWatchStream() {
        Assert.hardAssert(shouldStartWatchStream(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        WatchChangeAggregator watchChangeAggregator = new WatchChangeAggregator(this);
        this.watchChangeAggregator = watchChangeAggregator;
        this.watchStream.start();
        this.onlineStateTracker.handleWatchStreamStart();
    }

    private void startWriteStream() {
        Assert.hardAssert(shouldStartWriteStream(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.writeStream.start();
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void b(com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus connectivityMonitor$NetworkStatus) {
        a(networkStatus);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public boolean canUseNetwork() {
        return this.networkEnabled;
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public Transaction createTransaction() {
        Transaction transaction = new Transaction(this.datastore);
        return transaction;
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void d(AsyncQueue asyncQueue, com.google.firebase.firestore.remote.ConnectivityMonitor.NetworkStatus connectivityMonitor$NetworkStatus2) {
        c(asyncQueue, networkStatus2);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void disableNetwork() {
        this.networkEnabled = false;
        disableNetworkInternal();
        this.onlineStateTracker.updateState(OnlineState.OFFLINE);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void enableNetwork() {
        com.google.firebase.firestore.remote.OnlineStateTracker onlineStateTracker;
        Object lastStreamToken;
        this.networkEnabled = true;
        if (canUseNetwork()) {
            this.writeStream.setLastStreamToken(this.localStore.getLastStreamToken());
            if (shouldStartWatchStream()) {
                startWatchStream();
            } else {
                this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
            }
            fillWritePipeline();
        }
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void fillWritePipeline() {
        int writeStream;
        LocalStore addToWritePipeline;
        if (this.writePipeline.isEmpty()) {
            writeStream = -1;
        } else {
            writeStream = (MutationBatch)this.writePipeline.getLast().getBatchId();
        }
        while (canAddToWritePipeline()) {
            MutationBatch nextMutationBatch = this.localStore.getNextMutationBatch(writeStream);
            if (nextMutationBatch == null) {
                break;
            } else {
            }
            addToWritePipeline(nextMutationBatch);
            writeStream = nextMutationBatch.getBatchId();
        }
        if (shouldStartWriteStream()) {
            startWriteStream();
        }
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    void forceEnableNetwork() {
        enableNetwork();
        this.onlineStateTracker.updateState(OnlineState.ONLINE);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i) {
        return this.remoteStoreCallback.getRemoteKeysForTarget(i);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public TargetData getTargetDataForTarget(int i) {
        return (TargetData)this.listenTargets.get(Integer.valueOf(i));
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void handleCredentialChange() {
        boolean useNetwork;
        String str;
        String str2;
        if (canUseNetwork()) {
            Logger.debug("RemoteStore", "Restarting streams for new credential.", new Object[0]);
            restartNetwork();
        }
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void listen(TargetData targetData) {
        boolean startWatchStream;
        Integer valueOf = Integer.valueOf(targetData.getTargetId());
        if (this.listenTargets.containsKey(valueOf)) {
        }
        this.listenTargets.put(valueOf, targetData);
        if (shouldStartWatchStream()) {
            startWatchStream();
        } else {
            if (this.watchStream.isOpen()) {
                sendWatchRequest(targetData);
            }
        }
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void shutdown() {
        int i = 0;
        Logger.debug("RemoteStore", "Shutting down", new Object[i]);
        this.connectivityMonitor.shutdown();
        this.networkEnabled = i;
        disableNetworkInternal();
        this.datastore.shutdown();
        this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void start() {
        enableNetwork();
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator$TargetMetadataProvider
    public void stopListening(int i) {
        int i2;
        boolean uNKNOWN;
        boolean obj5;
        int i3 = 1;
        int i4 = 0;
        i2 = (TargetData)this.listenTargets.remove(Integer.valueOf(i)) != null ? i3 : i4;
        Object[] arr = new Object[i3];
        arr[i4] = Integer.valueOf(i);
        Assert.hardAssert(i2, "stopListening called on target no currently watched: %d", arr);
        if (this.watchStream.isOpen()) {
            sendUnwatchRequest(i);
        }
        if (this.listenTargets.isEmpty()) {
            if (this.watchStream.isOpen()) {
                this.watchStream.markIdle();
            } else {
                if (canUseNetwork()) {
                    this.onlineStateTracker.updateState(OnlineState.UNKNOWN);
                }
            }
        }
    }
}
