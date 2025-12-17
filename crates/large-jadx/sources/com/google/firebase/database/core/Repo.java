package com.google.firebase.database.core;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DatabaseReference.CompletionListener;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Query;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.Transaction.Handler;
import com.google.firebase.database.Transaction.Result;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.PersistentConnection.Delegate;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.DefaultRunLoop;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Tree.TreeFilter;
import com.google.firebase.database.core.utilities.Tree.TreeVisitor;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QueryParams;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class Repo implements PersistentConnection.Delegate {

    private static final String INTERRUPT_REASON = "repo_interrupt";
    private static final int TRANSACTION_MAX_RETRIES = 25;
    private static final String TRANSACTION_OVERRIDE_BY_SET = "overriddenBySet";
    private static final String TRANSACTION_TOO_MANY_RETRIES = "maxretries";
    private PersistentConnection connection;
    private final com.google.firebase.database.core.Context ctx;
    private final LogWrapper dataLogger;
    public long dataUpdateCount = 0;
    private FirebaseDatabase database;
    private final EventRaiser eventRaiser;
    private boolean hijackHash = false;
    private com.google.firebase.database.core.SnapshotHolder infoData;
    private com.google.firebase.database.core.SyncTree infoSyncTree;
    private boolean loggedTransactionPersistenceWarning = false;
    private long nextWriteId = 1;
    private com.google.firebase.database.core.SparseSnapshotTree onDisconnect;
    private final LogWrapper operationLogger;
    private final com.google.firebase.database.core.RepoInfo repoInfo;
    private final OffsetClock serverClock;
    private com.google.firebase.database.core.SyncTree serverSyncTree;
    private final LogWrapper transactionLogger;
    private long transactionOrder = 0;
    private Tree<List<com.google.firebase.database.core.Repo.TransactionData>> transactionQueueTree;

    private static class TransactionData implements Comparable<com.google.firebase.database.core.Repo.TransactionData> {

        private DatabaseError abortReason;
        private boolean applyLocally;
        private Node currentInputSnapshot;
        private Node currentOutputSnapshotRaw;
        private Node currentOutputSnapshotResolved;
        private long currentWriteId;
        private Transaction.Handler handler;
        private long order;
        private ValueEventListener outstandingListener;
        private com.google.firebase.database.core.Path path;
        private int retryCount;
        private com.google.firebase.database.core.Repo.TransactionStatus status;
        private TransactionData(com.google.firebase.database.core.Path path, Transaction.Handler transaction$Handler2, ValueEventListener valueEventListener3, com.google.firebase.database.core.Repo.TransactionStatus repo$TransactionStatus4, boolean z5, long l6) {
            super();
            this.path = path;
            this.handler = handler2;
            this.outstandingListener = valueEventListener3;
            this.status = transactionStatus4;
            this.retryCount = 0;
            this.applyLocally = z5;
            this.order = l6;
            int obj1 = 0;
            this.abortReason = obj1;
            this.currentInputSnapshot = obj1;
            this.currentOutputSnapshotRaw = obj1;
            this.currentOutputSnapshotResolved = obj1;
        }

        TransactionData(com.google.firebase.database.core.Path path, Transaction.Handler transaction$Handler2, ValueEventListener valueEventListener3, com.google.firebase.database.core.Repo.TransactionStatus repo$TransactionStatus4, boolean z5, long l6, com.google.firebase.database.core.Repo.1 repo$17) {
            super(path, handler2, valueEventListener3, transactionStatus4, z5, l6, 17);
        }

        static Node access$1500(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.currentInputSnapshot;
        }

        static Node access$1502(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData, Node node2) {
            transactionData.currentInputSnapshot = node2;
            return node2;
        }

        static Node access$1600(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.currentOutputSnapshotRaw;
        }

        static Node access$1602(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData, Node node2) {
            transactionData.currentOutputSnapshotRaw = node2;
            return node2;
        }

        static Node access$1700(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.currentOutputSnapshotResolved;
        }

        static Node access$1702(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData, Node node2) {
            transactionData.currentOutputSnapshotResolved = node2;
            return node2;
        }

        static com.google.firebase.database.core.Repo.TransactionStatus access$1800(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.status;
        }

        static com.google.firebase.database.core.Repo.TransactionStatus access$1802(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData, com.google.firebase.database.core.Repo.TransactionStatus repo$TransactionStatus2) {
            transactionData.status = transactionStatus2;
            return transactionStatus2;
        }

        static long access$1900(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.currentWriteId;
        }

        static long access$1902(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData, long l2) {
            transactionData.currentWriteId = l2;
            return l2;
        }

        static int access$2100(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.retryCount;
        }

        static int access$2108(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            final int retryCount = transactionData.retryCount;
            transactionData.retryCount = retryCount + 1;
            return retryCount;
        }

        static com.google.firebase.database.core.Path access$2200(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.path;
        }

        static Transaction.Handler access$2400(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.handler;
        }

        static ValueEventListener access$2500(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.outstandingListener;
        }

        static DatabaseError access$2900(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.abortReason;
        }

        static DatabaseError access$2902(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData, DatabaseError databaseError2) {
            transactionData.abortReason = databaseError2;
            return databaseError2;
        }

        static boolean access$3000(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            return transactionData.applyLocally;
        }

        @Override // java.lang.Comparable
        public int compareTo(com.google.firebase.database.core.Repo.TransactionData repo$TransactionData) {
            final long order = this.order;
            final long order2 = transactionData.order;
            if (Long.compare(order, order2) < 0) {
                return -1;
            }
            if (Long.compare(order, order2) == 0) {
                return 0;
            }
            return 1;
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return compareTo((Repo.TransactionData)object);
        }
    }

    private static enum TransactionStatus {

        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT;
    }
    Repo(com.google.firebase.database.core.RepoInfo repoInfo, com.google.firebase.database.core.Context context2, FirebaseDatabase firebaseDatabase3) {
        super();
        DefaultClock defaultClock = new DefaultClock();
        OffsetClock offsetClock = new OffsetClock(defaultClock, 0, obj3);
        this.serverClock = offsetClock;
        int i = 0;
        final int i3 = 1;
        this.repoInfo = repoInfo;
        this.ctx = context2;
        this.database = firebaseDatabase3;
        this.operationLogger = context2.getLogger("RepoOperation");
        this.transactionLogger = context2.getLogger("Transaction");
        this.dataLogger = context2.getLogger("DataOperation");
        EventRaiser obj7 = new EventRaiser(context2);
        this.eventRaiser = obj7;
        obj7 = new Repo.1(this);
        scheduleNow(obj7);
    }

    private com.google.firebase.database.core.Path abortTransactions(com.google.firebase.database.core.Path path, int i2) {
        boolean operationLogger;
        String string;
        Object[] arr;
        com.google.firebase.database.core.Path path2 = getAncestorTransactionNode(path).getPath();
        if (this.transactionLogger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Aborting transactions for path: ");
            stringBuilder.append(path);
            stringBuilder.append(". Affected: ");
            stringBuilder.append(path2);
            this.operationLogger.debug(stringBuilder.toString(), new Object[0]);
        }
        final Tree obj5 = this.transactionQueueTree.subTree(path);
        Repo.23 anon = new Repo.23(this, i2);
        obj5.forEachAncestor(anon);
        abortTransactionsAtNode(obj5, i2);
        Repo.24 anon2 = new Repo.24(this, i2);
        obj5.forEachDescendant(anon2);
        return path2;
    }

    private void abortTransactionsAtNode(Tree<List<com.google.firebase.database.core.Repo.TransactionData>> tree, int i2) {
        Iterator iterator;
        int next;
        int subList;
        ArrayList arrayList;
        String str;
        int i6;
        int i5;
        int anon;
        int i4;
        int ackUserWrite;
        com.google.firebase.database.core.Repo.TransactionStatus sENT_NEEDS_ABORT;
        DatabaseError status;
        int i3;
        String defaultQueryAtPath;
        int i8;
        int i;
        int size;
        com.google.firebase.database.core.SyncTree syncTree;
        long l;
        int i7;
        int i9;
        OffsetClock offsetClock;
        final com.google.firebase.database.core.Repo repo = this;
        iterator = tree;
        next = i2;
        final Object value = tree.getValue();
        ArrayList arrayList2 = new ArrayList();
        if ((List)value != null) {
            arrayList = new ArrayList();
            str = "Unknown transaction abort reason: ";
            i6 = -9;
            i5 = -25;
            if (next == i6) {
                status = DatabaseError.fromStatus("overriddenBySet");
            } else {
                i3 = next == i5 ? 1 : 0;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(str);
                stringBuilder2.append(next);
                Utilities.hardAssert(i3, stringBuilder2.toString());
                status = DatabaseError.fromCode(i5);
            }
            i8 = 0;
            i = -1;
            while (i8 < (List)value.size()) {
                size = value.get(i8);
                sENT_NEEDS_ABORT = Repo.TransactionStatus.SENT_NEEDS_ABORT;
                if (Repo.TransactionData.access$1800((Repo.TransactionData)size) == sENT_NEEDS_ABORT) {
                } else {
                }
                if (Repo.TransactionData.access$1800(size) == Repo.TransactionStatus.SENT) {
                } else {
                }
                if (Repo.TransactionData.access$1800(size) == Repo.TransactionStatus.RUN) {
                } else {
                }
                i4 = 0;
                Utilities.hardAssert(i4);
                ValueEventRegistration valueEventRegistration = new ValueEventRegistration(repo, Repo.TransactionData.access$2500(size), QuerySpec.defaultQueryAtPath(Repo.TransactionData.access$2200(size)));
                repo.removeEventCallback(valueEventRegistration);
                if (next == i6) {
                } else {
                }
                if (next == i5) {
                } else {
                }
                ackUserWrite = 0;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(next);
                Utilities.hardAssert(ackUserWrite, stringBuilder.toString());
                anon = new Repo.25(repo, size, status);
                arrayList.add(anon);
                i8++;
                ackUserWrite = 1;
                arrayList2.addAll(repo.serverSyncTree.ackUserWrite(Repo.TransactionData.access$1900(size), obj18, true, 0));
                i4 = 1;
                if (i == i8 + -1) {
                } else {
                }
                anon = 0;
                Utilities.hardAssert(anon);
                Repo.TransactionData.access$1802(size, sENT_NEEDS_ABORT);
                Repo.TransactionData.access$2902(size, status);
                i = i8;
                anon = 1;
            }
            if (i == -1) {
                iterator.setValue(0);
            } else {
                iterator.setValue(value.subList(0, i += i10));
            }
            repo.postEvents(arrayList2);
            iterator = arrayList.iterator();
            for (Runnable subList : iterator) {
                repo.postEvent(subList);
            }
        }
    }

    static void access$000(com.google.firebase.database.core.Repo repo) {
        repo.deferredInitialization();
    }

    static LogWrapper access$100(com.google.firebase.database.core.Repo repo) {
        return repo.operationLogger;
    }

    static com.google.firebase.database.core.Context access$1000(com.google.firebase.database.core.Repo repo) {
        return repo.ctx;
    }

    static com.google.firebase.database.core.SparseSnapshotTree access$1100(com.google.firebase.database.core.Repo repo) {
        return repo.onDisconnect;
    }

    static com.google.firebase.database.core.Path access$1200(com.google.firebase.database.core.Repo repo, com.google.firebase.database.core.Path path2, int i3) {
        return repo.abortTransactions(path2, i3);
    }

    static com.google.firebase.database.core.Path access$1300(com.google.firebase.database.core.Repo repo, com.google.firebase.database.core.Path path2) {
        return repo.rerunTransactions(path2);
    }

    static PersistentConnection access$200(com.google.firebase.database.core.Repo repo) {
        return repo.connection;
    }

    static void access$2000(com.google.firebase.database.core.Repo repo, Tree tree2) {
        repo.sendReadyTransactions(tree2);
    }

    static OffsetClock access$2300(com.google.firebase.database.core.Repo repo) {
        return repo.serverClock;
    }

    static Tree access$2600(com.google.firebase.database.core.Repo repo) {
        return repo.transactionQueueTree;
    }

    static void access$2700(com.google.firebase.database.core.Repo repo, Tree tree2) {
        repo.pruneCompletedTransactions(tree2);
    }

    static void access$2800(com.google.firebase.database.core.Repo repo) {
        repo.sendAllReadyTransactions();
    }

    static com.google.firebase.database.core.SnapshotHolder access$300(com.google.firebase.database.core.Repo repo) {
        return repo.infoData;
    }

    static void access$3100(com.google.firebase.database.core.Repo repo, List list2, Tree tree3) {
        repo.aggregateTransactionQueues(list2, tree3);
    }

    static void access$3200(com.google.firebase.database.core.Repo repo, Tree tree2, int i3) {
        repo.abortTransactionsAtNode(tree2, i3);
    }

    static com.google.firebase.database.core.SyncTree access$400(com.google.firebase.database.core.Repo repo) {
        return repo.infoSyncTree;
    }

    static void access$500(com.google.firebase.database.core.Repo repo, List list2) {
        repo.postEvents(list2);
    }

    static DatabaseError access$600(String string, String string2) {
        return Repo.fromErrorCode(string, string2);
    }

    static void access$700(com.google.firebase.database.core.Repo repo, String string2, com.google.firebase.database.core.Path path3, DatabaseError databaseError4) {
        repo.warnIfWriteFailed(string2, path3, databaseError4);
    }

    static void access$800(com.google.firebase.database.core.Repo repo, long l2, com.google.firebase.database.core.Path path3, DatabaseError databaseError4) {
        repo.ackWriteAndRerunTransactions(l2, path3, databaseError4);
    }

    static com.google.firebase.database.core.SyncTree access$900(com.google.firebase.database.core.Repo repo) {
        return repo.serverSyncTree;
    }

    private void ackWriteAndRerunTransactions(long l, com.google.firebase.database.core.Path path2, DatabaseError databaseError3) {
        int code;
        int serverSyncTree;
        long l2;
        int i;
        int i2;
        OffsetClock serverClock;
        List obj8;
        int obj9;
        int obj11;
        if (obj11 != null && obj11.getCode() == -25) {
            if (obj11.getCode() == -25) {
            } else {
                obj11 = obj11 == null ? code : 0;
                obj8 = this.serverSyncTree.ackUserWrite(l, obj3, obj11 ^ 1, 1);
                if (obj8.size() > 0) {
                    rerunTransactions(databaseError3);
                }
                postEvents(obj8);
            }
        } else {
        }
    }

    private void aggregateTransactionQueues(List<com.google.firebase.database.core.Repo.TransactionData> list, Tree<List<com.google.firebase.database.core.Repo.TransactionData>> tree2) {
        Object value = tree2.getValue();
        if ((List)value != null) {
            list.addAll((List)value);
        }
        Repo.22 anon = new Repo.22(this, list);
        tree2.forEachChild(anon);
    }

    private List<com.google.firebase.database.core.Repo.TransactionData> buildTransactionQueue(Tree<List<com.google.firebase.database.core.Repo.TransactionData>> tree) {
        ArrayList arrayList = new ArrayList();
        aggregateTransactionQueues(arrayList, tree);
        Collections.sort(arrayList);
        return arrayList;
    }

    private void deferredInitialization() {
        com.google.firebase.database.core.RepoInfo repoInfo = this.repoInfo;
        HostInfo hostInfo = new HostInfo(repoInfo.host, repoInfo.namespace, repoInfo.secure);
        this.connection = this.ctx.newPersistentConnection(hostInfo, this);
        Repo.2 anon = new Repo.2(this);
        this.ctx.getAuthTokenProvider().addTokenChangeListener((DefaultRunLoop)this.ctx.getRunLoop().getExecutorService(), anon);
        Repo.3 anon2 = new Repo.3(this);
        this.ctx.getAppCheckTokenProvider().addTokenChangeListener((DefaultRunLoop)this.ctx.getRunLoop().getExecutorService(), anon2);
        this.connection.initialize();
        PersistenceManager persistenceManager = this.ctx.getPersistenceManager(repoInfo2.host);
        SnapshotHolder snapshotHolder = new SnapshotHolder();
        this.infoData = snapshotHolder;
        SparseSnapshotTree sparseSnapshotTree = new SparseSnapshotTree();
        this.onDisconnect = sparseSnapshotTree;
        Tree tree = new Tree();
        this.transactionQueueTree = tree;
        NoopPersistenceManager noopPersistenceManager = new NoopPersistenceManager();
        Repo.4 anon4 = new Repo.4(this);
        SyncTree syncTree = new SyncTree(this.ctx, noopPersistenceManager, anon4);
        this.infoSyncTree = syncTree;
        Repo.5 anon3 = new Repo.5(this);
        SyncTree syncTree2 = new SyncTree(this.ctx, persistenceManager, anon3);
        this.serverSyncTree = syncTree2;
        restoreWrites(persistenceManager);
        Boolean fALSE = Boolean.FALSE;
        updateInfo(Constants.DOT_INFO_AUTHENTICATED, fALSE);
        updateInfo(Constants.DOT_INFO_CONNECTED, fALSE);
    }

    private static DatabaseError fromErrorCode(String string, String string2) {
        if (string != null) {
            return DatabaseError.fromStatus(string, string2);
        }
        return null;
    }

    private Tree<List<com.google.firebase.database.core.Repo.TransactionData>> getAncestorTransactionNode(com.google.firebase.database.core.Path path) {
        Tree transactionQueueTree;
        com.google.firebase.database.core.Path path2;
        boolean empty;
        ChildKey[] arr;
        int i;
        ChildKey front;
        com.google.firebase.database.core.Path obj6;
        transactionQueueTree = this.transactionQueueTree;
        while (!obj6.isEmpty()) {
            if (transactionQueueTree.getValue() == null) {
            }
            arr = new ChildKey[1];
            path2 = new Path(arr);
            transactionQueueTree = transactionQueueTree.subTree(path2);
            obj6 = obj6.popFront();
        }
        return transactionQueueTree;
    }

    private Node getLatestState(com.google.firebase.database.core.Path path) {
        ArrayList arrayList = new ArrayList();
        return getLatestState(path, arrayList);
    }

    private Node getLatestState(com.google.firebase.database.core.Path path, List<Long> list2) {
        Node obj2;
        if (this.serverSyncTree.calcCompleteEventCache(path, list2) == null) {
            obj2 = EmptyNode.Empty();
        }
        return obj2;
    }

    private long getNextWriteId() {
        final long nextWriteId = this.nextWriteId;
        this.nextWriteId = i += nextWriteId;
        return nextWriteId;
    }

    private long nextTransactionOrder() {
        final long transactionOrder = this.transactionOrder;
        this.transactionOrder = i += transactionOrder;
        return transactionOrder;
    }

    private void postEvents(List<? extends Event> list) {
        boolean eventRaiser;
        if (!list.isEmpty()) {
            this.eventRaiser.raiseEvents(list);
        }
    }

    private void pruneCompletedTransactions(Tree<List<com.google.firebase.database.core.Repo.TransactionData>> tree) {
        Object value;
        int size2;
        int i;
        int size;
        com.google.firebase.database.core.Repo.TransactionStatus cOMPLETED;
        value = tree.getValue();
        if ((List)value != null) {
            i = 0;
            while (i < (List)value.size()) {
                if (Repo.TransactionData.access$1800((Repo.TransactionData)value.get(i)) == Repo.TransactionStatus.COMPLETED) {
                } else {
                }
                i++;
                value.remove(i);
            }
            if (value.size() > 0) {
                tree.setValue(value);
            } else {
                tree.setValue(0);
            }
        }
        Repo.19 anon = new Repo.19(this);
        tree.forEachChild(anon);
    }

    private void rerunTransactionQueue(List<com.google.firebase.database.core.Repo.TransactionData> list, com.google.firebase.database.core.Path path2) {
        Iterator ackUserWrite;
        int i;
        Transaction.Result doTransaction;
        Tree transactionQueueTree;
        Long valueOf2;
        long anon;
        Object obj;
        com.google.firebase.database.core.Path path;
        ArrayList arrayList;
        int valueOf;
        com.google.firebase.database.core.Repo.TransactionStatus nEEDS_ABORT;
        int status;
        Object serverSyncTree2;
        String serverSyncTree;
        boolean z3;
        boolean z4;
        int i3;
        OffsetClock offsetClock;
        boolean z;
        boolean z2;
        int i2;
        LogWrapper logWrapper;
        final Object obj2 = this;
        if (list.isEmpty()) {
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ackUserWrite = list.iterator();
        for (Repo.TransactionData next4 : ackUserWrite) {
            arrayList3.add(Long.valueOf(Repo.TransactionData.access$1900(next4)));
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            obj = next2;
            arrayList = new ArrayList();
            valueOf = 1;
            if (Path.getRelative(path2, Repo.TransactionData.access$2200((Repo.TransactionData)obj)) != null) {
            } else {
            }
            i = anon;
            Utilities.hardAssert(i);
            if (Repo.TransactionData.access$1800(obj) == Repo.TransactionStatus.NEEDS_ABORT) {
            } else {
            }
            if (Repo.TransactionData.access$1800(obj) == Repo.TransactionStatus.RUN) {
            }
            obj2.postEvents(arrayList);
            if (anon != 0) {
            }
            Repo.TransactionData.access$1802(obj, Repo.TransactionStatus.COMPLETED);
            Repo.20 anon2 = new Repo.20(obj2, obj);
            obj2.scheduleNow(anon2);
            anon = new Repo.21(obj2, obj, status, InternalHelpers.createDataSnapshot(InternalHelpers.createReference(obj2, Repo.TransactionData.access$2200(obj)), IndexedNode.from(Repo.TransactionData.access$1500(obj))));
            arrayList2.add(anon);
            if (Repo.TransactionData.access$2100(obj) >= 25) {
            } else {
            }
            nEEDS_ABORT = obj2.getLatestState(Repo.TransactionData.access$2200(obj), arrayList3);
            Repo.TransactionData.access$1502(obj, nEEDS_ABORT);
            doTransaction = Repo.TransactionData.access$2400(obj).doTransaction(InternalHelpers.createMutableData(nEEDS_ABORT));
            serverSyncTree2 = status;
            boolean success = doTransaction.isSuccess();
            if (success) {
            } else {
            }
            arrayList.addAll(obj2.serverSyncTree.ackUserWrite(Repo.TransactionData.access$1900(obj), z4, true, 0));
            anon = valueOf;
            status = serverSyncTree2;
            valueOf = Long.valueOf(Repo.TransactionData.access$1900(obj));
            Node node2 = doTransaction.getNode();
            Node resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(node2, nEEDS_ABORT, ServerValues.generateServerValues(obj2.serverClock));
            Repo.TransactionData.access$1602(obj, node2);
            Repo.TransactionData.access$1702(obj, resolveDeferredValueSnapshot);
            Repo.TransactionData.access$1902(obj, getNextWriteId());
            arrayList3.remove(valueOf);
            z3 = Repo.TransactionData.access$2200(obj);
            arrayList.addAll(obj2.serverSyncTree.applyUserOverwrite(z3, node2, resolveDeferredValueSnapshot, Repo.TransactionData.access$1900(obj), z, Repo.TransactionData.access$3000(obj)));
            arrayList.addAll(obj2.serverSyncTree.ackUserWrite(valueOf.longValue(), z3, true, 0));
            status = DatabaseError.fromStatus("maxretries");
            arrayList.addAll(obj2.serverSyncTree.ackUserWrite(Repo.TransactionData.access$1900(obj), z3, true, 0));
            anon = valueOf;
            if (Repo.TransactionData.access$2900(obj).getCode() != -25) {
            }
            arrayList.addAll(obj2.serverSyncTree.ackUserWrite(Repo.TransactionData.access$1900(obj), z3, true, 0));
            i = valueOf;
            serverSyncTree2 = obj1.operationLogger;
            serverSyncTree2.error("Caught Throwable.", th);
            Throwable th = DatabaseError.fromException(th);
            serverSyncTree2 = Transaction.abort();
            serverSyncTree2 = th;
            th = logWrapper;
        }
        obj2.pruneCompletedTransactions(obj2.transactionQueueTree);
        while (anon < arrayList2.size()) {
            obj2.postEvent((Runnable)arrayList2.get(anon));
            anon++;
        }
        sendAllReadyTransactions();
    }

    private com.google.firebase.database.core.Path rerunTransactions(com.google.firebase.database.core.Path path) {
        Tree obj2 = getAncestorTransactionNode(path);
        final com.google.firebase.database.core.Path path2 = obj2.getPath();
        rerunTransactionQueue(buildTransactionQueue(obj2), path2);
        return path2;
    }

    private void restoreWrites(PersistenceManager persistenceManager) {
        long writeId3;
        Object next;
        Object overwrite;
        com.google.firebase.database.core.SyncTree serverSyncTree2;
        boolean operationLogger2;
        boolean operationLogger;
        com.google.firebase.database.core.Path path;
        int arr;
        com.google.firebase.database.core.SyncTree serverSyncTree;
        com.google.firebase.database.core.Path string;
        Object writeId2;
        Object resolveDeferredValueMerge;
        long writeId;
        int i2;
        int i;
        final Object obj = this;
        Map serverValues = ServerValues.generateServerValues(obj.serverClock);
        Iterator iterator = persistenceManager.loadUserWrites().iterator();
        writeId3 = Long.MIN_VALUE;
        for (UserWriteRecord next : iterator) {
            Repo.6 anon = new Repo.6(obj, next);
            writeId3 = next.getWriteId();
            obj.nextWriteId = writeId5 += i4;
            arr = 0;
            int i5 = 1;
            if (next.isOverwrite()) {
            } else {
            }
            if (obj.operationLogger.logsDebug()) {
            }
            obj.connection.merge(next.getPath().asList(), next.getMerge().getValue(i5), anon);
            obj.serverSyncTree.applyUserMerge(next.getPath(), next.getMerge(), ServerValues.resolveDeferredValueMerge(next.getMerge(), obj.serverSyncTree, next.getPath(), serverValues), next.getWriteId(), obj14);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Restoring merge with id ");
            stringBuilder.append(next.getWriteId());
            obj.operationLogger.debug(stringBuilder.toString(), new Object[arr]);
            if (obj.operationLogger.logsDebug()) {
            }
            obj.connection.put(next.getPath().asList(), next.getOverwrite().getValue(i5), anon);
            obj.serverSyncTree.applyUserOverwrite(next.getPath(), next.getOverwrite(), ServerValues.resolveDeferredValueSnapshot(next.getOverwrite(), obj.serverSyncTree, next.getPath(), serverValues), next.getWriteId(), obj14, true);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Restoring overwrite with id ");
            stringBuilder2.append(next.getWriteId());
            obj.operationLogger.debug(stringBuilder2.toString(), new Object[arr]);
        }
    }

    private void runOnDisconnectEvents() {
        ArrayList arrayList = new ArrayList();
        Repo.14 anon = new Repo.14(this, ServerValues.generateServerValues(this.serverClock), arrayList);
        this.onDisconnect.forEachTree(Path.getEmptyPath(), anon);
        SparseSnapshotTree sparseSnapshotTree = new SparseSnapshotTree();
        this.onDisconnect = sparseSnapshotTree;
        postEvents(arrayList);
    }

    private void sendAllReadyTransactions() {
        final Tree transactionQueueTree = this.transactionQueueTree;
        pruneCompletedTransactions(transactionQueueTree);
        sendReadyTransactions(transactionQueueTree);
    }

    private void sendReadyTransactions(Tree<List<com.google.firebase.database.core.Repo.TransactionData>> tree) {
        boolean transactionQueue;
        int i;
        Boolean fALSE;
        boolean booleanValue;
        Iterator iterator;
        com.google.firebase.database.core.Repo.TransactionStatus next;
        com.google.firebase.database.core.Repo.TransactionStatus rUN;
        Object obj6;
        if ((List)tree.getValue() != null) {
            transactionQueue = buildTransactionQueue(tree);
            i = transactionQueue.size() > 0 ? 1 : 0;
            Utilities.hardAssert(i);
            fALSE = Boolean.TRUE;
            iterator = transactionQueue.iterator();
            while (iterator.hasNext()) {
                if (Repo.TransactionData.access$1800((Repo.TransactionData)iterator.next()) != Repo.TransactionStatus.RUN) {
                    break;
                } else {
                }
            }
            if (fALSE.booleanValue()) {
                sendTransactionQueue(transactionQueue, tree.getPath());
            }
        } else {
            if (tree.hasChildren()) {
                transactionQueue = new Repo.17(this);
                tree.forEachChild(transactionQueue);
            }
        }
    }

    private void sendTransactionQueue(List<com.google.firebase.database.core.Repo.TransactionData> list, com.google.firebase.database.core.Path path2) {
        Node latestState;
        String hash;
        Long valueOf;
        long l;
        com.google.firebase.database.core.Path relative;
        int i;
        com.google.firebase.database.core.Repo.TransactionStatus transactionStatus;
        com.google.firebase.database.core.Repo.TransactionStatus rUN;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = list.iterator();
        for (Repo.TransactionData next2 : iterator) {
            arrayList.add(Long.valueOf(Repo.TransactionData.access$1900(next2)));
        }
        if (!this.hijackHash) {
            hash = getLatestState(path2, arrayList).getHash();
        } else {
            hash = "badhash";
        }
        Iterator iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            Object next4 = iterator2.next();
            if (Repo.TransactionData.access$1800((Repo.TransactionData)next4) == Repo.TransactionStatus.RUN) {
            } else {
            }
            i = 0;
            Utilities.hardAssert(i);
            Repo.TransactionData.access$1802(next4, Repo.TransactionStatus.SENT);
            Repo.TransactionData.access$2108(next4);
            latestState = latestState.updateChild(Path.getRelative(path2, Repo.TransactionData.access$2200(next4)), Repo.TransactionData.access$1600(next4));
        }
        Repo.18 anon = new Repo.18(this, path2, list, this);
        this.connection.compareAndPut(path2.asList(), latestState.getValue(true), hash, anon);
    }

    private void updateInfo(ChildKey childKey, Object object2) {
        boolean serverClock;
        com.google.firebase.database.core.Path path;
        long longValue;
        List obj5;
        com.google.firebase.database.core.SyncTree obj6;
        if (childKey.equals(Constants.DOT_INFO_SERVERTIME_OFFSET)) {
            this.serverClock.setOffset((Long)object2.longValue());
        }
        ChildKey[] arr = new ChildKey[2];
        path = new Path(arr);
        obj5 = NodeUtilities.NodeFromJSON(object2);
        this.infoData.update(path, obj5);
        postEvents(this.infoSyncTree.applyServerOverwrite(path, obj5));
    }

    private void warnIfWriteFailed(String string, com.google.firebase.database.core.Path path2, DatabaseError databaseError3) {
        int operationLogger;
        int stringBuilder;
        String obj3;
        if (databaseError3 != null && databaseError3.getCode() != -1 && databaseError3.getCode() != -25) {
            if (databaseError3.getCode() != -1) {
                if (databaseError3.getCode() != -25) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(string);
                    stringBuilder.append(" at ");
                    stringBuilder.append(path2.toString());
                    stringBuilder.append(" failed: ");
                    stringBuilder.append(databaseError3.toString());
                    this.operationLogger.warn(stringBuilder.toString());
                }
            }
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void addEventCallback(com.google.firebase.database.core.EventRegistration eventRegistration) {
        ChildKey equals;
        com.google.firebase.database.core.SyncTree serverSyncTree;
        ChildKey dOT_INFO;
        List obj3;
        equals = eventRegistration.getQuerySpec().getPath().getFront();
        if (equals != null && equals.equals(Constants.DOT_INFO)) {
            if (equals.equals(Constants.DOT_INFO)) {
                obj3 = this.infoSyncTree.addEventRegistration(eventRegistration);
            } else {
                obj3 = this.serverSyncTree.addEventRegistration(eventRegistration);
            }
        } else {
        }
        postEvents(obj3);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    void callOnComplete(DatabaseReference.CompletionListener databaseReference$CompletionListener, DatabaseError databaseError2, com.google.firebase.database.core.Path path3) {
        ChildKey priorityChildName;
        com.google.firebase.database.core.Repo.7 anon;
        DatabaseReference obj4;
        if (completionListener != null) {
            priorityChildName = path3.getBack();
            if (priorityChildName != null && priorityChildName.isPriorityChildName()) {
                if (priorityChildName.isPriorityChildName()) {
                    obj4 = InternalHelpers.createReference(this, path3.getParent());
                } else {
                    obj4 = InternalHelpers.createReference(this, path3);
                }
            } else {
            }
            anon = new Repo.7(this, completionListener, databaseError2, obj4);
            postEvent(anon);
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    PersistentConnection getConnection() {
        return this.connection;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public FirebaseDatabase getDatabase() {
        return this.database;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    com.google.firebase.database.core.SyncTree getInfoSyncTree() {
        return this.infoSyncTree;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public com.google.firebase.database.core.RepoInfo getRepoInfo() {
        return this.repoInfo;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    com.google.firebase.database.core.SyncTree getServerSyncTree() {
        return this.serverSyncTree;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public long getServerTime() {
        return this.serverClock.millis();
    }

    public j<DataSnapshot> getValue(Query query) {
        k kVar = new k();
        Repo.9 anon = new Repo.9(this, query, kVar);
        scheduleNow(anon);
        return kVar.a();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    boolean hasListeners() {
        int i;
        boolean empty;
        if (this.infoSyncTree.isEmpty()) {
            if (!this.serverSyncTree.isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    void interrupt() {
        this.connection.interrupt("repo_interrupt");
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void keepSynced(QuerySpec querySpec, boolean z2) {
        int i;
        boolean equals;
        ChildKey dOT_INFO;
        if (!querySpec.getPath().isEmpty()) {
            if (!querySpec.getPath().getFront().equals(Constants.DOT_INFO)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i);
        this.serverSyncTree.keepSynced(querySpec, z2);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void onConnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, Boolean.TRUE);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void onConnectionStatus(boolean z) {
        onServerInfoUpdate(Constants.DOT_INFO_AUTHENTICATED, Boolean.valueOf(z));
    }

    public void onDataUpdate(List<String> list, Object object2, boolean z3, Long long4) {
        int arr;
        int longValue;
        String string;
        String stringBuilder;
        Object[] arr2;
        boolean obj6;
        Object obj7;
        Object obj8;
        boolean obj9;
        Path path = new Path(list);
        arr = 0;
        string = "onDataUpdate: ";
        if (this.operationLogger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(path);
            this.operationLogger.debug(stringBuilder2.toString(), new Object[arr]);
        }
        if (this.dataLogger.logsDebug()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(path);
            stringBuilder.append(" ");
            stringBuilder.append(object2);
            this.operationLogger.debug(stringBuilder.toString(), new Object[arr]);
        }
        this.dataUpdateCount = dataUpdateCount += i;
        if (long4) {
            obj6 = new Tag(long4.longValue(), string);
            if (z3 != null) {
                obj8 = new HashMap();
                obj7 = (Map)object2.entrySet().iterator();
                for (Map.Entry obj9 : obj7) {
                    string = new Path((String)obj9.getKey());
                    obj8.put(string, NodeUtilities.NodeFromJSON(obj9.getValue()));
                }
                obj6 = this.serverSyncTree.applyTaggedQueryMerge(path, obj8, obj6);
            } else {
                obj6 = this.serverSyncTree.applyTaggedQueryOverwrite(path, NodeUtilities.NodeFromJSON(object2), obj6);
            }
        } else {
            if (z3 != null) {
                obj6 = new HashMap();
                obj7 = (Map)object2.entrySet().iterator();
                for (Map.Entry obj8 : obj7) {
                    longValue = new Path((String)obj8.getKey());
                    obj6.put(longValue, NodeUtilities.NodeFromJSON(obj8.getValue()));
                }
                obj6 = this.serverSyncTree.applyServerMerge(path, obj6);
            } else {
                obj6 = this.serverSyncTree.applyServerOverwrite(path, NodeUtilities.NodeFromJSON(object2));
            }
        }
        if (obj6.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(obj6);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void onDisconnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, Boolean.FALSE);
        runOnDisconnectEvents();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void onDisconnectCancel(com.google.firebase.database.core.Path path, DatabaseReference.CompletionListener databaseReference$CompletionListener2) {
        Repo.13 anon = new Repo.13(this, path, completionListener2);
        this.connection.onDisconnectCancel(path.asList(), anon);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void onDisconnectSetValue(com.google.firebase.database.core.Path path, Node node2, DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        Repo.11 anon = new Repo.11(this, path, node2, completionListener3);
        this.connection.onDisconnectPut(path.asList(), node2.getValue(true), anon);
    }

    public void onDisconnectUpdate(com.google.firebase.database.core.Path path, Map<com.google.firebase.database.core.Path, Node> map2, DatabaseReference.CompletionListener databaseReference$CompletionListener3, Map<String, Object> map4) {
        Repo.12 anon = new Repo.12(this, path, map2, completionListener3);
        this.connection.onDisconnectMerge(path.asList(), map4, anon);
    }

    public void onRangeMergeUpdate(List<String> list, List<RangeMerge> list2, Long long3) {
        int arr2;
        int size;
        boolean next;
        String rangeMerge;
        String stringBuilder;
        Object[] arr;
        boolean obj6;
        com.google.firebase.database.core.SyncTree obj7;
        Path path = new Path(list);
        arr2 = 0;
        rangeMerge = "onRangeMergeUpdate: ";
        if (this.operationLogger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(rangeMerge);
            stringBuilder2.append(path);
            this.operationLogger.debug(stringBuilder2.toString(), new Object[arr2]);
        }
        if (this.dataLogger.logsDebug()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(rangeMerge);
            stringBuilder.append(path);
            stringBuilder.append(" ");
            stringBuilder.append(list2);
            this.operationLogger.debug(stringBuilder.toString(), new Object[arr2]);
        }
        int i2 = 1;
        this.dataUpdateCount = dataUpdateCount += i2;
        obj6 = new ArrayList(list2.size());
        obj7 = list2.iterator();
        for (RangeMerge size : obj7) {
            rangeMerge = new RangeMerge(size);
            obj6.add(rangeMerge);
        }
        if (long3 != null) {
            next = new Tag(long3.longValue(), i2);
            obj6 = this.serverSyncTree.applyTaggedRangeMerges(path, obj6, next);
        } else {
            obj6 = this.serverSyncTree.applyServerRangeMerges(path, obj6);
        }
        if (obj6.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(obj6);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void onServerInfoUpdate(ChildKey childKey, Object object2) {
        updateInfo(childKey, object2);
    }

    public void onServerInfoUpdate(Map<String, Object> map) {
        Object value;
        ChildKey string;
        Iterator obj3 = map.entrySet().iterator();
        for (Map.Entry next2 : obj3) {
            updateInfo(ChildKey.fromString((String)next2.getKey()), next2.getValue());
        }
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void postEvent(Runnable runnable) {
        this.ctx.requireStarted();
        this.ctx.getEventTarget().postEvent(runnable);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void purgeOutstandingWrites() {
        boolean operationLogger;
        Object[] arr;
        String str;
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("Purging writes", new Object[0]);
        }
        postEvents(this.serverSyncTree.removeAllWrites());
        abortTransactions(Path.getEmptyPath(), -25);
        this.connection.purgeOutstandingWrites();
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void removeEventCallback(com.google.firebase.database.core.EventRegistration eventRegistration) {
        com.google.firebase.database.core.SyncTree serverSyncTree;
        List obj3;
        if (Constants.DOT_INFO.equals(eventRegistration.getQuerySpec().getPath().getFront())) {
            obj3 = this.infoSyncTree.removeEventRegistration(eventRegistration);
        } else {
            obj3 = this.serverSyncTree.removeEventRegistration(eventRegistration);
        }
        postEvents(obj3);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    void resume() {
        this.connection.resume("repo_interrupt");
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void scheduleNow(Runnable runnable) {
        this.ctx.requireStarted();
        this.ctx.getRunLoop().scheduleNow(runnable);
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void setHijackHash(boolean z) {
        this.hijackHash = z;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void setValue(com.google.firebase.database.core.Path path, Node node2, DatabaseReference.CompletionListener databaseReference$CompletionListener3) {
        boolean operationLogger;
        boolean dataLogger;
        int arr2;
        String string;
        String stringBuilder;
        Object[] arr;
        arr2 = 0;
        string = "set: ";
        if (this.operationLogger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(path);
            this.operationLogger.debug(stringBuilder2.toString(), new Object[arr2]);
        }
        if (this.dataLogger.logsDebug()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(path);
            stringBuilder.append(" ");
            stringBuilder.append(node2);
            this.dataLogger.debug(stringBuilder.toString(), new Object[arr2]);
        }
        ArrayList arrayList = new ArrayList();
        long nextWriteId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserOverwrite(path, node2, ServerValues.resolveDeferredValueSnapshot(node2, this.serverSyncTree.calcCompleteEventCache(path, arrayList), ServerValues.generateServerValues(this.serverClock)), nextWriteId, obj7, true));
        super(this, path, nextWriteId, obj10, completionListener3);
        this.connection.put(path.asList(), node2.getValue(true), anon);
        rerunTransactions(abortTransactions(path, -9));
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public void startTransaction(com.google.firebase.database.core.Path path, Transaction.Handler transaction$Handler2, boolean z3) {
        boolean operationLogger;
        boolean operationLogger2;
        boolean loggedTransactionPersistenceWarning;
        Object arrayList;
        DatabaseReference nextWriteId;
        int arr;
        Transaction.Result doTransaction;
        String string;
        int serverSyncTree;
        Object stringBuilder;
        int i;
        Object[] str;
        com.google.firebase.database.core.Repo.15 anon;
        boolean success;
        Object resolveDeferredValueSnapshot;
        boolean z;
        com.google.firebase.database.core.Repo.1 z2;
        int i2;
        LogWrapper logWrapper;
        Object obj13;
        Object obj14;
        com.google.firebase.database.core.Repo.16 obj15;
        arr = 0;
        string = "transaction: ";
        if (this.operationLogger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(path);
            this.operationLogger.debug(stringBuilder2.toString(), new Object[arr]);
        }
        if (this.dataLogger.logsDebug()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(path);
            this.operationLogger.debug(stringBuilder.toString(), new Object[arr]);
        }
        if (this.ctx.isPersistenceEnabled() && !this.loggedTransactionPersistenceWarning) {
            if (!this.loggedTransactionPersistenceWarning) {
                this.loggedTransactionPersistenceWarning = true;
                this.transactionLogger.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
            }
        }
        nextWriteId = InternalHelpers.createReference(this, path);
        anon = new Repo.15(this);
        ValueEventRegistration valueEventRegistration = new ValueEventRegistration(this, anon, nextWriteId.getSpec());
        addEventCallback(valueEventRegistration);
        final long nextTransactionOrder = nextTransactionOrder();
        super(path, handler2, anon, Repo.TransactionStatus.INITIALIZING, z3, nextTransactionOrder, obj8, 0);
        Node latestState = getLatestState(path);
        Repo.TransactionData.access$1502(transactionData2, latestState);
        serverSyncTree = 0;
        if (handler2.doTransaction(InternalHelpers.createMutableData(latestState)) == null) {
        } else {
            i = serverSyncTree;
            if (!doTransaction.isSuccess()) {
                Repo.TransactionData.access$1602(transactionData2, serverSyncTree);
                Repo.TransactionData.access$1702(transactionData2, serverSyncTree);
                obj15 = new Repo.16(this, handler2, i, InternalHelpers.createDataSnapshot(nextWriteId, IndexedNode.from(Repo.TransactionData.access$1500(transactionData2))));
                postEvent(obj15);
            } else {
                Repo.TransactionData.access$1802(transactionData2, Repo.TransactionStatus.RUN);
                obj14 = this.transactionQueueTree.subTree(path);
                if ((List)obj14.getValue() == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(transactionData2);
                obj14.setValue(arrayList);
                success = doTransaction.getNode();
                resolveDeferredValueSnapshot = ServerValues.resolveDeferredValueSnapshot(success, Repo.TransactionData.access$1500(transactionData2), ServerValues.generateServerValues(this.serverClock));
                Repo.TransactionData.access$1602(transactionData2, success);
                Repo.TransactionData.access$1702(transactionData2, resolveDeferredValueSnapshot);
                Repo.TransactionData.access$1902(transactionData2, getNextWriteId());
                postEvents(this.serverSyncTree.applyUserOverwrite(path, success, resolveDeferredValueSnapshot, Repo.TransactionData.access$1900(transactionData2), nextTransactionOrder, z3));
                sendAllReadyTransactions();
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Transaction returned null as result");
        throw nullPointerException;
    }

    @Override // com.google.firebase.database.connection.PersistentConnection$Delegate
    public String toString() {
        return this.repoInfo.toString();
    }

    public void updateChildren(com.google.firebase.database.core.Path path, com.google.firebase.database.core.CompoundWrite compoundWrite2, DatabaseReference.CompletionListener databaseReference$CompletionListener3, Map<String, Object> map4) {
        boolean operationLogger2;
        boolean dataLogger;
        boolean operationLogger;
        String string;
        com.google.firebase.database.core.Repo abortTransactions;
        int str;
        com.google.firebase.database.core.Path path2;
        String string2;
        Object[] arr;
        final Object obj = this;
        final Object obj2 = path;
        final Object obj3 = map4;
        string = "update: ";
        str = 0;
        if (obj.operationLogger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(string);
            stringBuilder2.append(obj2);
            obj.operationLogger.debug(stringBuilder2.toString(), new Object[str]);
        }
        if (obj.dataLogger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(obj2);
            stringBuilder.append(" ");
            stringBuilder.append(obj3);
            obj.dataLogger.debug(stringBuilder.toString(), new Object[str]);
        }
        if (compoundWrite2.isEmpty() && obj.operationLogger.logsDebug()) {
            if (obj.operationLogger.logsDebug()) {
                obj.operationLogger.debug("update called with no changes. No-op", new Object[str]);
            }
            obj.callOnComplete(completionListener3, 0, obj2);
        }
        final long nextWriteId = getNextWriteId();
        obj.postEvents(obj.serverSyncTree.applyUserMerge(path, compoundWrite2, ServerValues.resolveDeferredValueMerge(compoundWrite2, obj.serverSyncTree, obj2, ServerValues.generateServerValues(obj.serverClock)), nextWriteId, obj12));
        super(this, path, nextWriteId, arr, completionListener3);
        obj.connection.merge(path.asList(), obj3, anon2);
        Iterator iterator = compoundWrite2.iterator();
        for (Map.Entry next2 : iterator) {
            obj.rerunTransactions(obj.abortTransactions(obj2.child((Path)next2.getKey()), -9));
        }
    }
}
