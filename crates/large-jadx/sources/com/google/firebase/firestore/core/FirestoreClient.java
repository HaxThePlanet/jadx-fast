package com.google.firebase.firestore.core;

import android.content.Context;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.FirebaseFirestoreException.Code;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.auth.CredentialsProvider;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleReader;
import com.google.firebase.firestore.bundle.BundleSerializer;
import com.google.firebase.firestore.bundle.BundledQuery;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.remote.Datastore;
import com.google.firebase.firestore.remote.GrpcMetadataProvider;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public final class FirestoreClient {

    private static final String LOG_TAG = "FirestoreClient";
    private static final int MAX_CONCURRENT_LIMBO_RESOLUTIONS = 100;
    private final CredentialsProvider<String> appCheckProvider;
    private final AsyncQueue asyncQueue;
    private final CredentialsProvider<User> authProvider;
    private final BundleSerializer bundleSerializer;
    private final com.google.firebase.firestore.core.DatabaseInfo databaseInfo;
    private com.google.firebase.firestore.core.EventManager eventManager;
    private Scheduler gcScheduler;
    private Scheduler indexBackfillScheduler;
    private LocalStore localStore;
    private final GrpcMetadataProvider metadataProvider;
    private Persistence persistence;
    private RemoteStore remoteStore;
    private com.google.firebase.firestore.core.SyncEngine syncEngine;
    public FirestoreClient(Context context, com.google.firebase.firestore.core.DatabaseInfo databaseInfo2, FirebaseFirestoreSettings firebaseFirestoreSettings3, CredentialsProvider<User> credentialsProvider4, CredentialsProvider<String> credentialsProvider5, AsyncQueue asyncQueue6, GrpcMetadataProvider grpcMetadataProvider7) {
        super();
        this.databaseInfo = databaseInfo2;
        this.authProvider = credentialsProvider4;
        this.appCheckProvider = credentialsProvider5;
        this.asyncQueue = asyncQueue6;
        this.metadataProvider = grpcMetadataProvider7;
        RemoteSerializer remoteSerializer = new RemoteSerializer(databaseInfo2.getDatabaseId());
        BundleSerializer obj8 = new BundleSerializer(remoteSerializer);
        this.bundleSerializer = obj8;
        k obj3 = new k();
        obj8 = new AtomicBoolean(0);
        k kVar = new k(this, obj3, context, firebaseFirestoreSettings3);
        asyncQueue6.enqueueAndForget(kVar);
        w obj2 = new w(this, obj8, obj3, asyncQueue6);
        credentialsProvider4.setChangeListener(obj2);
        credentialsProvider5.setChangeListener(p.a);
    }

    private void A(EventListener eventListener) {
        this.eventManager.removeSnapshotsInSyncListener(eventListener);
    }

    private void C(com.google.firebase.firestore.core.QueryListener queryListener) {
        this.eventManager.removeQueryListener(queryListener);
    }

    private void E() {
        this.remoteStore.shutdown();
        this.persistence.shutdown();
        Scheduler gcScheduler = this.gcScheduler;
        if (gcScheduler != null) {
            gcScheduler.stop();
        }
        Scheduler indexBackfillScheduler = this.indexBackfillScheduler;
        if (indexBackfillScheduler != null) {
            indexBackfillScheduler.stop();
        }
    }

    private j G(Function function) {
        return this.syncEngine.transaction(this.asyncQueue, function);
    }

    private void I(k k) {
        this.syncEngine.registerPendingWritesTask(k);
    }

    private void K(List list, k k2) {
        this.syncEngine.writeMutations(list, k2);
    }

    private void a(EventListener eventListener) {
        this.eventManager.addSnapshotsInSyncListener(eventListener);
    }

    private void c(List list) {
        this.localStore.configureIndices(list);
    }

    private void e() {
        this.remoteStore.disableNetwork();
    }

    private void g() {
        this.remoteStore.enableNetwork();
    }

    static Document i(j j) {
        Object obj2 = j.getResult();
        if ((Document)obj2.isFoundDocument()) {
            return obj2;
        }
        if (!obj2.isNoDocument()) {
        } else {
            return null;
        }
        obj2 = new FirebaseFirestoreException("Failed to get document from cache. (However, this document may exist on the server. Run again without setting source to CACHE to attempt to retrieve the document from the server.)", FirebaseFirestoreException.Code.UNAVAILABLE);
        throw obj2;
    }

    private void initialize(Context context, User user2, FirebaseFirestoreSettings firebaseFirestoreSettings3) {
        int indexBackfillScheduler;
        com.google.firebase.firestore.core.MemoryComponentProvider memoryComponentProvider;
        boolean iNDEXING_SUPPORT_ENABLED;
        final Object obj = this;
        Object[] arr = new Object[1];
        final int i = 0;
        arr[i] = user2.getUid();
        Logger.debug("FirestoreClient", "Initializing. user=%s", arr);
        super(obj.databaseInfo, obj.asyncQueue, obj.authProvider, obj.appCheckProvider, context, obj.metadataProvider);
        super(context, obj.asyncQueue, obj.databaseInfo, datastore, user2, 100, firebaseFirestoreSettings3);
        if (firebaseFirestoreSettings3.isPersistenceEnabled()) {
            memoryComponentProvider = new SQLiteComponentProvider();
        } else {
            memoryComponentProvider = new MemoryComponentProvider();
        }
        memoryComponentProvider.initialize(configuration);
        obj.persistence = memoryComponentProvider.getPersistence();
        obj.gcScheduler = memoryComponentProvider.getGarbageCollectionScheduler();
        obj.localStore = memoryComponentProvider.getLocalStore();
        obj.remoteStore = memoryComponentProvider.getRemoteStore();
        obj.syncEngine = memoryComponentProvider.getSyncEngine();
        obj.eventManager = memoryComponentProvider.getEventManager();
        Scheduler gcScheduler = obj.gcScheduler;
        if (gcScheduler != null) {
            gcScheduler.start();
        }
        if (Persistence.INDEXING_SUPPORT_ENABLED && firebaseFirestoreSettings3.isPersistenceEnabled()) {
            if (firebaseFirestoreSettings3.isPersistenceEnabled()) {
                Scheduler indexBackfillScheduler2 = memoryComponentProvider.getIndexBackfillScheduler();
                obj.indexBackfillScheduler = indexBackfillScheduler2;
                if (indexBackfillScheduler2 != null) {
                } else {
                    indexBackfillScheduler = i;
                }
                Assert.hardAssert(indexBackfillScheduler, "Index backfill scheduler should not be null.", new Object[i]);
                obj.indexBackfillScheduler.start();
            }
        }
    }

    private Document j(DocumentKey documentKey) {
        return this.localStore.readDocument(documentKey);
    }

    private com.google.firebase.firestore.core.ViewSnapshot l(com.google.firebase.firestore.core.Query query) {
        QueryResult query2 = this.localStore.executeQuery(query, true);
        View view = new View(query, query2.getRemoteKeys());
        return view.applyChanges(view.computeDocChanges(query2.getDocuments())).getSnapshot();
    }

    private void n(String string, k k2) {
        Object localStore;
        com.google.firebase.firestore.core.Query query2;
        com.google.firebase.firestore.model.ResourcePath path;
        String collectionGroup;
        List filters;
        List orderBy;
        long limit;
        com.google.firebase.firestore.core.Query.LimitType limitType;
        com.google.firebase.firestore.core.Bound startAt;
        com.google.firebase.firestore.core.Bound endAt;
        com.google.firebase.firestore.core.Query query;
        BundledQuery obj13;
        obj13 = this.localStore.getNamedQuery(string);
        if (obj13 != null) {
            localStore = obj13.getBundledQuery().getTarget();
            super(localStore.getPath(), localStore.getCollectionGroup(), localStore.getFilters(), localStore.getOrderBy(), localStore.getLimit(), obj7, obj13.getBundledQuery().getLimitType(), localStore.getStartAt(), localStore.getEndAt());
            k2.c(query);
        } else {
            k2.c(0);
        }
    }

    private void p(com.google.firebase.firestore.core.QueryListener queryListener) {
        this.eventManager.addQueryListener(queryListener);
    }

    private void r(BundleReader bundleReader, LoadBundleTask loadBundleTask2) {
        this.syncEngine.loadBundle(bundleReader, loadBundleTask2);
    }

    private void t(k k, Context context2, FirebaseFirestoreSettings firebaseFirestoreSettings3) {
        try {
            initialize(context2, (User)m.a(k.a()), firebaseFirestoreSettings3);
            context2 = new RuntimeException(k);
            throw context2;
        }
    }

    private void v(User user) {
        int i;
        int i2 = 1;
        int i3 = 0;
        i = this.syncEngine != null ? i2 : i3;
        Assert.hardAssert(i, "SyncEngine not yet initialized", new Object[i3]);
        Object[] arr = new Object[i2];
        arr[i3] = user.getUid();
        Logger.debug("FirestoreClient", "Credential changed. Current user: %s", arr);
        this.syncEngine.handleCredentialChange(user);
    }

    private void verifyNotTerminated() {
        if (isTerminated()) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("The client has already been terminated");
        throw illegalStateException;
    }

    private void x(AtomicBoolean atomicBoolean, k k2, AsyncQueue asyncQueue3, User user4) {
        String str;
        int obj3;
        Object[] obj5;
        str = 0;
        final int i = 1;
        if (atomicBoolean.compareAndSet(str, i)) {
            Assert.hardAssert(obj3 ^= i, "Already fulfilled first user task", new Object[str]);
            k2.c(user4);
        } else {
            obj3 = new i(this, user4);
            asyncQueue3.enqueueAndForget(obj3);
        }
    }

    static void z(String string) {
    }

    public void B(EventListener eventListener) {
        A(eventListener);
    }

    public void D(com.google.firebase.firestore.core.QueryListener queryListener) {
        C(queryListener);
    }

    public void F() {
        E();
    }

    public j H(Function function) {
        return G(function);
    }

    public void J(k k) {
        I(k);
    }

    public void L(List list, k k2) {
        K(list, k2);
    }

    public void addSnapshotsInSyncListener(EventListener<Void> eventListener) {
        verifyNotTerminated();
        l lVar = new l(this, eventListener);
        this.asyncQueue.enqueueAndForget(lVar);
    }

    public void b(EventListener eventListener) {
        a(eventListener);
    }

    public j<Void> configureIndices(List<FieldIndex> list) {
        verifyNotTerminated();
        m mVar = new m(this, list);
        return this.asyncQueue.enqueue(mVar);
    }

    public void d(List list) {
        c(list);
    }

    public j<Void> disableNetwork() {
        verifyNotTerminated();
        t tVar = new t(this);
        return this.asyncQueue.enqueue(tVar);
    }

    public j<Void> enableNetwork() {
        verifyNotTerminated();
        v vVar = new v(this);
        return this.asyncQueue.enqueue(vVar);
    }

    public void f() {
        e();
    }

    public j<Document> getDocumentFromLocalCache(DocumentKey documentKey) {
        verifyNotTerminated();
        u uVar = new u(this, documentKey);
        return this.asyncQueue.enqueue(uVar).continueWith(d.a);
    }

    public j<com.google.firebase.firestore.core.ViewSnapshot> getDocumentsFromLocalCache(com.google.firebase.firestore.core.Query query) {
        verifyNotTerminated();
        r rVar = new r(this, query);
        return this.asyncQueue.enqueue(rVar);
    }

    public j<com.google.firebase.firestore.core.Query> getNamedQuery(String string) {
        verifyNotTerminated();
        k kVar = new k();
        g gVar = new g(this, string, kVar);
        this.asyncQueue.enqueueAndForget(gVar);
        return kVar.a();
    }

    public void h() {
        g();
    }

    public boolean isTerminated() {
        return this.asyncQueue.isShuttingDown();
    }

    public Document k(DocumentKey documentKey) {
        return j(documentKey);
    }

    public com.google.firebase.firestore.core.QueryListener listen(com.google.firebase.firestore.core.Query query, com.google.firebase.firestore.core.EventManager.ListenOptions eventManager$ListenOptions2, EventListener<com.google.firebase.firestore.core.ViewSnapshot> eventListener3) {
        verifyNotTerminated();
        QueryListener queryListener = new QueryListener(query, listenOptions2, eventListener3);
        h obj3 = new h(this, queryListener);
        this.asyncQueue.enqueueAndForget(obj3);
        return queryListener;
    }

    public void loadBundle(InputStream inputStream, LoadBundleTask loadBundleTask2) {
        verifyNotTerminated();
        BundleReader bundleReader = new BundleReader(this.bundleSerializer, inputStream);
        n nVar = new n(this, bundleReader, loadBundleTask2);
        this.asyncQueue.enqueueAndForget(nVar);
    }

    public com.google.firebase.firestore.core.ViewSnapshot m(com.google.firebase.firestore.core.Query query) {
        return l(query);
    }

    public void o(String string, k k2) {
        n(string, k2);
    }

    public void q(com.google.firebase.firestore.core.QueryListener queryListener) {
        p(queryListener);
    }

    public void removeSnapshotsInSyncListener(EventListener<Void> eventListener) {
        if (isTerminated()) {
        }
        q qVar = new q(this, eventListener);
        this.asyncQueue.enqueueAndForget(qVar);
    }

    public void s(BundleReader bundleReader, LoadBundleTask loadBundleTask2) {
        r(bundleReader, loadBundleTask2);
    }

    public void stopListening(com.google.firebase.firestore.core.QueryListener queryListener) {
        if (isTerminated()) {
        }
        e eVar = new e(this, queryListener);
        this.asyncQueue.enqueueAndForget(eVar);
    }

    public j<Void> terminate() {
        this.authProvider.removeChangeListener();
        this.appCheckProvider.removeChangeListener();
        f fVar = new f(this);
        return this.asyncQueue.enqueueAndInitiateShutdown(fVar);
    }

    public <TResult> j<TResult> transaction(Function<com.google.firebase.firestore.core.Transaction, j<TResult>> function) {
        verifyNotTerminated();
        s sVar = new s(this, function);
        return AsyncQueue.callTask(this.asyncQueue.getExecutor(), sVar);
    }

    public void u(k k, Context context2, FirebaseFirestoreSettings firebaseFirestoreSettings3) {
        t(k, context2, firebaseFirestoreSettings3);
    }

    public void w(User user) {
        v(user);
    }

    public j<Void> waitForPendingWrites() {
        verifyNotTerminated();
        k kVar = new k();
        o oVar = new o(this, kVar);
        this.asyncQueue.enqueueAndForget(oVar);
        return kVar.a();
    }

    public j<Void> write(List<Mutation> list) {
        verifyNotTerminated();
        k kVar = new k();
        j jVar = new j(this, list, kVar);
        this.asyncQueue.enqueueAndForget(jVar);
        return kVar.a();
    }

    public void y(AtomicBoolean atomicBoolean, k k2, AsyncQueue asyncQueue3, User user4) {
        x(atomicBoolean, k2, asyncQueue3, user4);
    }
}
