package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.Query;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.annotations.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.LLRBNode.NodeVisitor;
import com.google.firebase.database.connection.CompoundHash;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.ListenComplete;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.Clock;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.core.view.View;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.CompoundHash;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.RangeMerge;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public class SyncTree {

    private static final long SIZE_THRESHOLD_FOR_COMPOUND_HASH = 1024L;
    private final Set<QuerySpec> keepSyncedQueries;
    private final com.google.firebase.database.core.SyncTree.ListenProvider listenProvider;
    private final LogWrapper logger;
    private long nextQueryTag = 1;
    private final com.google.firebase.database.core.WriteTree pendingWriteTree;
    private final PersistenceManager persistenceManager;
    private final Map<QuerySpec, com.google.firebase.database.core.Tag> queryToTagMap;
    private ImmutableTree<com.google.firebase.database.core.SyncPoint> syncPointTree;
    private final Map<com.google.firebase.database.core.Tag, QuerySpec> tagToQueryMap;

    public interface CompletionListener {
        public abstract List<? extends Event> onListenComplete(DatabaseError databaseError);
    }

    public interface ListenProvider {
        public abstract void startListening(QuerySpec querySpec, com.google.firebase.database.core.Tag tag2, ListenHashProvider listenHashProvider3, com.google.firebase.database.core.SyncTree.CompletionListener syncTree$CompletionListener4);

        public abstract void stopListening(QuerySpec querySpec, com.google.firebase.database.core.Tag tag2);
    }

    private static class KeepSyncedEventRegistration extends com.google.firebase.database.core.EventRegistration {

        private QuerySpec spec;
        public KeepSyncedEventRegistration(QuerySpec querySpec) {
            super();
            this.spec = querySpec;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public com.google.firebase.database.core.EventRegistration clone(QuerySpec querySpec) {
            SyncTree.KeepSyncedEventRegistration keepSyncedEventRegistration = new SyncTree.KeepSyncedEventRegistration(querySpec);
            return keepSyncedEventRegistration;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public DataEvent createEvent(Change change, QuerySpec querySpec2) {
            return null;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean equals(Object object) {
            boolean spec;
            Object obj2;
            if (object instanceof SyncTree.KeepSyncedEventRegistration && object.spec.equals(this.spec)) {
                obj2 = object.spec.equals(this.spec) ? 1 : 0;
            } else {
            }
            return obj2;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireCancelEvent(DatabaseError databaseError) {
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public void fireEvent(DataEvent dataEvent) {
        }

        public QuerySpec getQuerySpec() {
            return this.spec;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public int hashCode() {
            return this.spec.hashCode();
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean isSameListener(com.google.firebase.database.core.EventRegistration eventRegistration) {
            return eventRegistration instanceof SyncTree.KeepSyncedEventRegistration;
        }

        @Override // com.google.firebase.database.core.EventRegistration
        public boolean respondsTo(Event.EventType event$EventType) {
            return 0;
        }
    }

    private class ListenContainer implements ListenHashProvider, com.google.firebase.database.core.SyncTree.CompletionListener {

        private final com.google.firebase.database.core.Tag tag;
        final com.google.firebase.database.core.SyncTree this$0;
        private final View view;
        public ListenContainer(com.google.firebase.database.core.SyncTree syncTree, View view2) {
            this.this$0 = syncTree;
            super();
            this.view = view2;
            this.tag = SyncTree.access$000(syncTree, view2.getQuery());
        }

        static com.google.firebase.database.core.Tag access$1400(com.google.firebase.database.core.SyncTree.ListenContainer syncTree$ListenContainer) {
            return listenContainer.tag;
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public CompoundHash getCompoundHash() {
            int size;
            CompoundHash node = CompoundHash.fromNode(this.view.getServerCache());
            List posts = node.getPosts();
            ArrayList arrayList = new ArrayList(posts.size());
            Iterator iterator = posts.iterator();
            for (Path next2 : iterator) {
                arrayList.add(next2.asList());
            }
            CompoundHash compoundHash = new CompoundHash(arrayList, node.getHashes());
            return compoundHash;
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public String getSimpleHash() {
            return this.view.getServerCache().getHash();
        }

        public List<? extends Event> onListenComplete(DatabaseError databaseError) {
            com.google.firebase.database.core.Tag tag = this.tag;
            if (databaseError == null && tag != null) {
                tag = this.tag;
                if (tag != null) {
                    return this.this$0.applyTaggedListenComplete(tag);
                }
                return this.this$0.applyListenComplete(this.view.getQuery().getPath());
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Listen at ");
            stringBuilder.append(this.view.getQuery().getPath());
            stringBuilder.append(" failed: ");
            stringBuilder.append(databaseError.toString());
            SyncTree.access$100(this.this$0).warn(stringBuilder.toString());
            return this.this$0.removeAllEventRegistrations(this.view.getQuery(), databaseError);
        }

        @Override // com.google.firebase.database.connection.ListenHashProvider
        public boolean shouldIncludeCompoundHash() {
            int i;
            i = Long.compare(estimateSerializedNodeSize, i2) > 0 ? 1 : 0;
            return i;
        }
    }
    public SyncTree(com.google.firebase.database.core.Context context, PersistenceManager persistenceManager2, com.google.firebase.database.core.SyncTree.ListenProvider syncTree$ListenProvider3) {
        super();
        int i = 1;
        this.syncPointTree = ImmutableTree.emptyInstance();
        WriteTree writeTree = new WriteTree();
        this.pendingWriteTree = writeTree;
        HashMap hashMap = new HashMap();
        this.tagToQueryMap = hashMap;
        HashMap hashMap2 = new HashMap();
        this.queryToTagMap = hashMap2;
        HashSet hashSet = new HashSet();
        this.keepSyncedQueries = hashSet;
        this.listenProvider = listenProvider3;
        this.persistenceManager = persistenceManager2;
        this.logger = context.getLogger("SyncTree");
    }

    private Node a(QuerySpec querySpec) {
        ImmutableTree syncPointTree;
        Object syncPoint;
        int completeServerCache;
        com.google.firebase.database.core.Path popFront;
        int completeView;
        EmptyNode emptyNode;
        ChildKey string;
        int i;
        com.google.firebase.database.core.Path path = querySpec.getPath();
        syncPointTree = this.syncPointTree;
        int i2 = 0;
        completeServerCache = 0;
        popFront = path;
        completeView = i2;
        while (!syncPointTree.isEmpty()) {
            Object value = syncPointTree.getValue();
            if ((SyncPoint)value != null) {
            }
            if (popFront.isEmpty()) {
            } else {
            }
            string = popFront.getFront();
            syncPointTree = syncPointTree.getChild(string);
            popFront = popFront.popFront();
            string = ChildKey.fromString("");
            if (completeServerCache != 0) {
            } else {
            }
            completeServerCache = (SyncPoint)value.getCompleteServerCache(popFront);
            if (completeView == null) {
            } else {
            }
            completeView = i;
            if (value.hasCompleteView()) {
            } else {
            }
            completeView = i2;
        }
        syncPoint = this.syncPointTree.get(path);
        if ((SyncPoint)syncPoint == null) {
            syncPoint = new SyncPoint(this.persistenceManager);
            this.syncPointTree = this.syncPointTree.set(path, syncPoint);
        } else {
            if (completeServerCache != 0) {
            } else {
                completeServerCache = (SyncPoint)syncPoint.getCompleteServerCache(Path.getEmptyPath());
            }
        }
        if (completeServerCache != 0) {
            emptyNode = completeServerCache;
        } else {
            emptyNode = EmptyNode.Empty();
        }
        if (completeServerCache != 0) {
        } else {
            i = i2;
        }
        CacheNode cacheNode = new CacheNode(IndexedNode.from(emptyNode, querySpec.getIndex()), i, i2);
        return syncPoint.getView(querySpec, this.pendingWriteTree.childWrites(path), cacheNode).getCompleteNode();
    }

    static com.google.firebase.database.core.Tag access$000(com.google.firebase.database.core.SyncTree syncTree, QuerySpec querySpec2) {
        return syncTree.tagForQuery(querySpec2);
    }

    static LogWrapper access$100(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.logger;
    }

    static Map access$1000(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.tagToQueryMap;
    }

    static void access$1100(com.google.firebase.database.core.SyncTree syncTree, QuerySpec querySpec2, View view3) {
        syncTree.setupListener(querySpec2, view3);
    }

    static List access$1200(com.google.firebase.database.core.SyncTree syncTree, ImmutableTree immutableTree2) {
        return syncTree.collectDistinctViewsForSubTree(immutableTree2);
    }

    static QuerySpec access$1300(com.google.firebase.database.core.SyncTree syncTree, QuerySpec querySpec2) {
        return syncTree.queryForListening(querySpec2);
    }

    static com.google.firebase.database.core.SyncTree.ListenProvider access$1500(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.listenProvider;
    }

    static void access$1600(com.google.firebase.database.core.SyncTree syncTree, List list2) {
        syncTree.removeTags(list2);
    }

    static List access$1700(com.google.firebase.database.core.SyncTree syncTree, Operation operation2, ImmutableTree immutableTree3, Node node4, com.google.firebase.database.core.WriteTreeRef writeTreeRef5) {
        return syncTree.applyOperationDescendantsHelper(operation2, immutableTree3, node4, writeTreeRef5);
    }

    static PersistenceManager access$200(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.persistenceManager;
    }

    static com.google.firebase.database.core.WriteTree access$300(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.pendingWriteTree;
    }

    static List access$400(com.google.firebase.database.core.SyncTree syncTree, Operation operation2) {
        return syncTree.applyOperationToSyncPoints(operation2);
    }

    static QuerySpec access$500(com.google.firebase.database.core.SyncTree syncTree, com.google.firebase.database.core.Tag tag2) {
        return syncTree.queryForTag(tag2);
    }

    static List access$600(com.google.firebase.database.core.SyncTree syncTree, QuerySpec querySpec2, Operation operation3) {
        return syncTree.applyTaggedOperation(querySpec2, operation3);
    }

    static ImmutableTree access$700(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.syncPointTree;
    }

    static ImmutableTree access$702(com.google.firebase.database.core.SyncTree syncTree, ImmutableTree immutableTree2) {
        syncTree.syncPointTree = immutableTree2;
        return immutableTree2;
    }

    static Map access$800(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.queryToTagMap;
    }

    static com.google.firebase.database.core.Tag access$900(com.google.firebase.database.core.SyncTree syncTree) {
        return syncTree.getNextQueryTag();
    }

    private List<Event> applyOperationDescendantsHelper(Operation operation, ImmutableTree<com.google.firebase.database.core.SyncPoint> immutableTree2, Node node3, com.google.firebase.database.core.WriteTreeRef writeTreeRef4) {
        Object obj10;
        Node obj12;
        final Object value = immutableTree2.getValue();
        if (node3 == null && (SyncPoint)value != null) {
            if ((SyncPoint)value != null) {
                obj12 = (SyncPoint)value.getCompleteServerCache(Path.getEmptyPath());
            }
        }
        ArrayList arrayList = new ArrayList();
        super(this, obj12, writeTreeRef4, operation, arrayList);
        immutableTree2.getChildren().inOrderTraversal(anon2);
        if (value != null) {
            arrayList.addAll(value.applyOperation(operation, writeTreeRef4, obj12));
        }
        return arrayList;
    }

    private List<Event> applyOperationHelper(Operation operation, ImmutableTree<com.google.firebase.database.core.SyncPoint> immutableTree2, Node node3, com.google.firebase.database.core.WriteTreeRef writeTreeRef4) {
        Object front;
        int immediateChild;
        Object obj6;
        Object obj7;
        Node obj8;
        if (operation.getPath().isEmpty()) {
            return applyOperationDescendantsHelper(operation, immutableTree2, node3, writeTreeRef4);
        }
        Object value = immutableTree2.getValue();
        if (node3 == null && (SyncPoint)value != null) {
            if ((SyncPoint)value != null) {
                obj8 = (SyncPoint)value.getCompleteServerCache(Path.getEmptyPath());
            }
        }
        ArrayList arrayList = new ArrayList();
        front = operation.getPath().getFront();
        final Operation operationForChild = operation.operationForChild(front);
        obj7 = immutableTree2.getChildren().get(front);
        if ((ImmutableTree)obj7 != null && operationForChild != null) {
            if (operationForChild != null) {
                if (obj8 != null) {
                    immediateChild = obj8.getImmediateChild(front);
                } else {
                    immediateChild = 0;
                }
                arrayList.addAll(applyOperationHelper(operationForChild, (ImmutableTree)obj7, immediateChild, writeTreeRef4.child(front)));
            }
        }
        if (value != null) {
            arrayList.addAll(value.applyOperation(operation, writeTreeRef4, obj8));
        }
        return arrayList;
    }

    private List<Event> applyOperationToSyncPoints(Operation operation) {
        return applyOperationHelper(operation, this.syncPointTree, 0, this.pendingWriteTree.childWrites(Path.getEmptyPath()));
    }

    private List<? extends Event> applyTaggedOperation(QuerySpec querySpec, Operation operation2) {
        int i;
        com.google.firebase.database.core.Path obj4 = querySpec.getPath();
        Object obj = this.syncPointTree.get(obj4);
        i = (SyncPoint)obj != null ? 1 : 0;
        Utilities.hardAssert(i, "Missing sync point for query tag that we're tracking");
        return (SyncPoint)obj.applyOperation(operation2, this.pendingWriteTree.childWrites(obj4), 0);
    }

    private List<View> collectDistinctViewsForSubTree(ImmutableTree<com.google.firebase.database.core.SyncPoint> immutableTree) {
        ArrayList arrayList = new ArrayList();
        collectDistinctViewsForSubTree(immutableTree, arrayList);
        return arrayList;
    }

    private void collectDistinctViewsForSubTree(ImmutableTree<com.google.firebase.database.core.SyncPoint> immutableTree, List<View> list2) {
        Object queryViews;
        boolean completeView;
        Object obj3;
        queryViews = immutableTree.getValue();
        if (queryViews != null && (SyncPoint)queryViews.hasCompleteView()) {
            if (queryViews.hasCompleteView()) {
                list2.add(queryViews.getCompleteView());
            } else {
                if (queryViews != null) {
                    list2.addAll(queryViews.getQueryViews());
                }
                obj3 = immutableTree.getChildren().iterator();
                for (Map.Entry next : obj3) {
                    collectDistinctViewsForSubTree((ImmutableTree)next.getValue(), list2);
                }
            }
        } else {
        }
    }

    private com.google.firebase.database.core.Tag getNextQueryTag() {
        final long nextQueryTag = this.nextQueryTag;
        this.nextQueryTag = i += nextQueryTag;
        Tag tag = new Tag(nextQueryTag, obj2);
        return tag;
    }

    private QuerySpec queryForListening(QuerySpec querySpec) {
        boolean loadsAllData;
        QuerySpec obj2;
        if (querySpec.loadsAllData() && !querySpec.isDefault()) {
            if (!querySpec.isDefault()) {
                obj2 = QuerySpec.defaultQueryAtPath(querySpec.getPath());
            }
        }
        return obj2;
    }

    private QuerySpec queryForTag(com.google.firebase.database.core.Tag tag) {
        return (QuerySpec)this.tagToQueryMap.get(tag);
    }

    private List<Event> removeEventRegistration(QuerySpec querySpec, com.google.firebase.database.core.EventRegistration eventRegistration2, DatabaseError databaseError3) {
        SyncTree.14 anon = new SyncTree.14(this, querySpec, eventRegistration2, databaseError3);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    private void removeTags(List<QuerySpec> list) {
        Object tagToQueryMap;
        boolean loadsAllData;
        Map queryToTagMap;
        int i;
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            tagToQueryMap = obj4.next();
            if (!(QuerySpec)tagToQueryMap.loadsAllData()) {
            }
            loadsAllData = tagForQuery(tagToQueryMap);
            if (loadsAllData != null) {
            } else {
            }
            i = 0;
            Utilities.hardAssert(i);
            this.queryToTagMap.remove(tagToQueryMap);
            this.tagToQueryMap.remove(loadsAllData);
            i = 1;
        }
    }

    private void setupListener(QuerySpec querySpec, View view2) {
        int obj4;
        Object obj5;
        final com.google.firebase.database.core.Tag tagForQuery = tagForQuery(querySpec);
        SyncTree.ListenContainer listenContainer = new SyncTree.ListenContainer(this, view2);
        this.listenProvider.startListening(queryForListening(querySpec), tagForQuery, listenContainer, listenContainer);
        obj4 = this.syncPointTree.subtree(querySpec.getPath());
        if (tagForQuery != null) {
            Utilities.hardAssert(obj4 ^= 1, "If we're adding a query, it shouldn't be shadowed");
        } else {
            obj5 = new SyncTree.15(this);
            obj4.foreach(obj5);
        }
    }

    private com.google.firebase.database.core.Tag tagForQuery(QuerySpec querySpec) {
        return (Tag)this.queryToTagMap.get(querySpec);
    }

    public List<? extends Event> ackUserWrite(long l, boolean z2, boolean z3, Clock clock4) {
        super(this, clock4, l, obj5, z3, obj14);
        return (List)this.persistenceManager.runInTransaction(anon2);
    }

    public List<? extends Event> addEventRegistration(com.google.firebase.database.core.EventRegistration eventRegistration) {
        SyncTree.13 anon = new SyncTree.13(this, eventRegistration);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyListenComplete(com.google.firebase.database.core.Path path) {
        SyncTree.7 anon = new SyncTree.7(this, path);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyServerMerge(com.google.firebase.database.core.Path path, Map<com.google.firebase.database.core.Path, Node> map2) {
        SyncTree.6 anon = new SyncTree.6(this, map2, path);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyServerOverwrite(com.google.firebase.database.core.Path path, Node node2) {
        SyncTree.5 anon = new SyncTree.5(this, path, node2);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyServerRangeMerges(com.google.firebase.database.core.Path path, List<RangeMerge> list2) {
        Node serverCache;
        Object next;
        Object obj = this.syncPointTree.get(path);
        if ((SyncPoint)obj == null) {
            return Collections.emptyList();
        }
        View completeView = (SyncPoint)obj.getCompleteView();
        if (completeView != null) {
            serverCache = completeView.getServerCache();
            final Iterator obj4 = list2.iterator();
            for (RangeMerge next : obj4) {
                serverCache = next.applyTo(serverCache);
            }
            return applyServerOverwrite(path, serverCache);
        }
        return Collections.emptyList();
    }

    public List<? extends Event> applyTaggedListenComplete(com.google.firebase.database.core.Tag tag) {
        SyncTree.8 anon = new SyncTree.8(this, tag);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyTaggedQueryMerge(com.google.firebase.database.core.Path path, Map<com.google.firebase.database.core.Path, Node> map2, com.google.firebase.database.core.Tag tag3) {
        SyncTree.10 anon = new SyncTree.10(this, tag3, path, map2);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyTaggedQueryOverwrite(com.google.firebase.database.core.Path path, Node node2, com.google.firebase.database.core.Tag tag3) {
        SyncTree.9 anon = new SyncTree.9(this, tag3, path, node2);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<? extends Event> applyTaggedRangeMerges(com.google.firebase.database.core.Path path, List<RangeMerge> list2, com.google.firebase.database.core.Tag tag3) {
        Node serverCache;
        String next;
        int i;
        int i2;
        QuerySpec forTag = queryForTag(tag3);
        if (forTag != null) {
            Utilities.hardAssert(path.equals(forTag.getPath()));
            Object obj = this.syncPointTree.get(forTag.getPath());
            final int i3 = 0;
            i2 = (SyncPoint)obj != null ? i : i3;
            Utilities.hardAssert(i2, "Missing sync point for query tag that we're tracking");
            View viewForQuery = (SyncPoint)obj.viewForQuery(forTag);
            if (viewForQuery != null) {
            } else {
                i = i3;
            }
            Utilities.hardAssert(i, "Missing view for query tag that we're tracking");
            serverCache = viewForQuery.getServerCache();
            final Iterator obj8 = list2.iterator();
            for (RangeMerge next : obj8) {
                serverCache = next.applyTo(serverCache);
            }
            return applyTaggedQueryOverwrite(path, serverCache, tag3);
        }
        return Collections.emptyList();
    }

    public List<? extends Event> applyUserMerge(com.google.firebase.database.core.Path path, com.google.firebase.database.core.CompoundWrite compoundWrite2, com.google.firebase.database.core.CompoundWrite compoundWrite3, long l4, boolean z5) {
        super(this, obj17, path, compoundWrite2, l4, obj6, compoundWrite3);
        return (List)obj2.persistenceManager.runInTransaction(anon2);
    }

    public List<? extends Event> applyUserOverwrite(com.google.firebase.database.core.Path path, Node node2, Node node3, long l4, boolean z5, boolean z6) {
        int i;
        if (!z6) {
            if (obj19 == null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        Utilities.hardAssert(i, "We shouldn't be persisting non-visible writes.");
        super(this, obj19, path, node2, l4, obj6, node3, z6);
        return (List)obj2.persistenceManager.runInTransaction(anon2);
    }

    public Node b(QuerySpec querySpec) {
        return a(querySpec);
    }

    public Node calcCompleteEventCache(com.google.firebase.database.core.Path path, List<Long> list2) {
        ImmutableTree syncPointTree;
        com.google.firebase.database.core.Path emptyPath;
        int completeServerCache;
        com.google.firebase.database.core.Path popFront;
        boolean empty;
        com.google.firebase.database.core.Path relative;
        Object value = this.syncPointTree.getValue();
        emptyPath = Path.getEmptyPath();
        completeServerCache = 0;
        popFront = path;
        ChildKey front = popFront.getFront();
        while (front != null) {
            syncPointTree = syncPointTree.getChild(front);
            Object value2 = syncPointTree.getValue();
            if ((SyncPoint)value2 != null) {
            }
            if (!popFront.popFront().isEmpty()) {
            }
            if (completeServerCache == 0) {
            }
            front = popFront.getFront();
            syncPointTree = ImmutableTree.emptyInstance();
            completeServerCache = (SyncPoint)value2.getCompleteServerCache(Path.getRelative(emptyPath.child(front), path));
        }
        return this.pendingWriteTree.calcCompleteEventCache(path, completeServerCache, list2, true);
    }

    public Node calcCompleteEventCacheFromRoot(com.google.firebase.database.core.Path path, List<Long> list2) {
        Node completeServerCache;
        com.google.firebase.database.core.Path emptyPath;
        Object value = this.syncPointTree.getValue();
        if ((SyncPoint)value != null) {
            completeServerCache = (SyncPoint)value.getCompleteServerCache(Path.getEmptyPath());
        } else {
            completeServerCache = 0;
        }
        if (completeServerCache != null) {
            return this.pendingWriteTree.calcCompleteEventCache(path, completeServerCache, list2, true);
        }
        return calcCompleteEventCache(path, list2);
    }

    public Node getServerValue(QuerySpec querySpec) {
        d dVar = new d(this, querySpec);
        return (Node)this.persistenceManager.runInTransaction(dVar);
    }

    ImmutableTree<com.google.firebase.database.core.SyncPoint> getSyncPointTree() {
        return this.syncPointTree;
    }

    public boolean isEmpty() {
        return this.syncPointTree.isEmpty();
    }

    public void keepSynced(QuerySpec querySpec, boolean z2) {
        boolean contains;
        boolean obj3;
        if (z2 && !this.keepSyncedQueries.contains(querySpec)) {
            if (!this.keepSyncedQueries.contains(querySpec)) {
                obj3 = new SyncTree.KeepSyncedEventRegistration(querySpec);
                addEventRegistration(obj3);
                this.keepSyncedQueries.add(querySpec);
            } else {
                if (!z2 && this.keepSyncedQueries.contains(querySpec)) {
                    if (this.keepSyncedQueries.contains(querySpec)) {
                        obj3 = new SyncTree.KeepSyncedEventRegistration(querySpec);
                        removeEventRegistration(obj3);
                        this.keepSyncedQueries.remove(querySpec);
                    }
                }
            }
        } else {
        }
    }

    public DataSnapshot persistenceServerCache(Query query) {
        return InternalHelpers.createDataSnapshot(query.getRef(), this.persistenceManager.serverCache(query.getSpec()).getIndexedNode());
    }

    public List<Event> removeAllEventRegistrations(QuerySpec querySpec, DatabaseError databaseError2) {
        return removeEventRegistration(querySpec, 0, databaseError2);
    }

    public List<? extends Event> removeAllWrites() {
        SyncTree.4 anon = new SyncTree.4(this);
        return (List)this.persistenceManager.runInTransaction(anon);
    }

    public List<Event> removeEventRegistration(com.google.firebase.database.core.EventRegistration eventRegistration) {
        return removeEventRegistration(eventRegistration.getQuerySpec(), eventRegistration, 0);
    }

    public void setQueryActive(QuerySpec querySpec) {
        SyncTree.11 anon = new SyncTree.11(this, querySpec);
        this.persistenceManager.runInTransaction(anon);
    }

    public void setQueryInactive(QuerySpec querySpec) {
        SyncTree.12 anon = new SyncTree.12(this, querySpec);
        this.persistenceManager.runInTransaction(anon);
    }
}
