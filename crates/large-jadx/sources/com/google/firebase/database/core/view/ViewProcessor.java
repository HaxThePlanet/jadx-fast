package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Operation.OperationType;
import com.google.firebase.database.core.operation.OperationSource;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.core.view.filter.NodeFilter.CompleteChildSource;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class ViewProcessor {

    private static NodeFilter.CompleteChildSource NO_COMPLETE_SOURCE;
    private final NodeFilter filter;

    public static class ProcessorResult {

        public final List<com.google.firebase.database.core.view.Change> changes;
        public final com.google.firebase.database.core.view.ViewCache viewCache;
        public ProcessorResult(com.google.firebase.database.core.view.ViewCache viewCache, List<com.google.firebase.database.core.view.Change> list2) {
            super();
            this.viewCache = viewCache;
            this.changes = list2;
        }
    }

    private static class WriteTreeCompleteChildSource implements NodeFilter.CompleteChildSource {

        private final Node optCompleteServerCache;
        private final com.google.firebase.database.core.view.ViewCache viewCache;
        private final WriteTreeRef writes;
        public WriteTreeCompleteChildSource(WriteTreeRef writeTreeRef, com.google.firebase.database.core.view.ViewCache viewCache2, Node node3) {
            super();
            this.writes = writeTreeRef;
            this.viewCache = viewCache2;
            this.optCompleteServerCache = node3;
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter$CompleteChildSource
        public NamedNode getChildAfterChild(Index index, NamedNode namedNode2, boolean z3) {
            Node optCompleteServerCache;
            if (this.optCompleteServerCache != null) {
            } else {
                optCompleteServerCache = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(optCompleteServerCache, namedNode2, z3, index);
        }

        @Override // com.google.firebase.database.core.view.filter.NodeFilter$CompleteChildSource
        public Node getCompleteChild(ChildKey childKey) {
            Object viewCache;
            com.google.firebase.database.core.view.CacheNode serverCache;
            int i2;
            int i;
            com.google.firebase.database.core.view.CacheNode eventCache = this.viewCache.getEventCache();
            if (eventCache.isCompleteForChild(childKey)) {
                return eventCache.getNode().getImmediateChild(childKey);
            }
            Node optCompleteServerCache = this.optCompleteServerCache;
            if (optCompleteServerCache != null) {
                serverCache = new CacheNode(IndexedNode.from(optCompleteServerCache, KeyIndex.getInstance()), 1, 0);
            } else {
                serverCache = this.viewCache.getServerCache();
            }
            return this.writes.calcCompleteChild(childKey, serverCache);
        }
    }
    static {
        ViewProcessor.1 anon = new ViewProcessor.1();
        ViewProcessor.NO_COMPLETE_SOURCE = anon;
    }

    public ViewProcessor(NodeFilter nodeFilter) {
        super();
        this.filter = nodeFilter;
    }

    private com.google.firebase.database.core.view.ViewCache ackUserWrite(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, ImmutableTree<Boolean> immutableTree3, WriteTreeRef writeTreeRef4, Node node5, ChildChangeAccumulator childChangeAccumulator6) {
        Object serverCache;
        Object value;
        CompoundWrite emptyWrite;
        com.google.firebase.database.core.view.ViewCache child;
        Path completeForPath;
        CompoundWrite write2;
        CompoundWrite write;
        WriteTreeRef writeTreeRef;
        Node node;
        ChildChangeAccumulator childChangeAccumulator;
        com.google.firebase.database.core.view.ViewCache obj10;
        boolean obj12;
        if (writeTreeRef4.shadowingWrite(path2) != null) {
            return viewCache;
        }
        final boolean filtered = viewCache.getServerCache().isFiltered();
        serverCache = viewCache.getServerCache();
        if (immutableTree3.getValue() != null) {
            if (path2.isEmpty()) {
                if (!serverCache.isFullyInitialized() && serverCache.isCompleteForPath(path2)) {
                    if (serverCache.isCompleteForPath(path2)) {
                    }
                }
                return this.applyServerOverwrite(viewCache, path2, serverCache.getNode().getChild(path2), writeTreeRef4, node5, filtered, childChangeAccumulator6);
            } else {
            }
            if (path2.isEmpty()) {
                serverCache = serverCache.getNode().iterator();
                write2 = obj12;
                for (NamedNode obj12 : serverCache) {
                    write2 = write2.addWrite(obj12.getName(), obj12.getNode());
                }
                obj10 = this.applyServerMerge(viewCache, path2, write2, writeTreeRef4, node5, filtered, childChangeAccumulator6);
            }
            return obj10;
        }
        obj12 = immutableTree3.iterator();
        write = emptyWrite;
        while (obj12.hasNext()) {
            emptyWrite = (Map.Entry)obj12.next().getKey();
            child = path2.child((Path)emptyWrite);
            if (serverCache.isCompleteForPath(child)) {
            }
            write = write.addWrite(emptyWrite, serverCache.getNode().getChild(child));
        }
        return this.applyServerMerge(viewCache, path2, write, writeTreeRef4, node5, filtered, childChangeAccumulator6);
    }

    private com.google.firebase.database.core.view.ViewCache applyServerMerge(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, CompoundWrite compoundWrite3, WriteTreeRef writeTreeRef4, Node node5, boolean z6, ChildChangeAccumulator childChangeAccumulator7) {
        boolean fullyInitialized;
        int i;
        CompoundWrite writes;
        Object str;
        CompoundWrite compoundWrite;
        Iterator serverOverwrite2;
        Object next;
        boolean next2;
        com.google.firebase.database.core.view.ViewCache serverOverwrite;
        Object rootWrite;
        Object child2;
        boolean child;
        com.google.firebase.database.core.view.ViewCache view;
        WriteTreeRef path;
        Node apply;
        boolean z;
        ChildChangeAccumulator childChangeAccumulator;
        boolean z2;
        ChildChangeAccumulator childChangeAccumulator2;
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            if (!viewCache.getServerCache().isFullyInitialized()) {
                return viewCache;
            }
        }
        final int i2 = 1;
        final int i3 = 0;
        i = compoundWrite3.rootWrite() == null ? i2 : i3;
        Utilities.hardAssert(i, "Can't have a merge that is an overwrite");
        if (path2.isEmpty()) {
            writes = compoundWrite3;
        } else {
            writes = CompoundWrite.emptyWrite().addWrites(path2, compoundWrite3);
        }
        Node node2 = viewCache.getServerCache().getNode();
        Map childCompoundWrites = writes.childCompoundWrites();
        serverOverwrite2 = childCompoundWrites.entrySet().iterator();
        serverOverwrite = viewCache;
        while (serverOverwrite2.hasNext()) {
            next = serverOverwrite2.next();
            child2 = (Map.Entry)next.getKey();
            if (node2.hasChild((ChildKey)child2)) {
            }
            ChildKey[] arr2 = new ChildKey[i2];
            arr2[i3] = child2;
            Path path3 = new Path(arr2);
            serverOverwrite = this.applyServerOverwrite(serverOverwrite, path3, (CompoundWrite)next.getValue().apply(node2.getImmediateChild(child2)), writeTreeRef4, node5, z6, childChangeAccumulator7);
        }
        Iterator iterator = childCompoundWrites.entrySet().iterator();
        view = serverOverwrite;
        while (iterator.hasNext()) {
            serverOverwrite2 = iterator.next();
            next2 = (Map.Entry)serverOverwrite2.getKey();
            if (!viewCache.getServerCache().isCompleteForChild((ChildKey)next2) && (CompoundWrite)serverOverwrite2.getValue().rootWrite() == null) {
            } else {
            }
            serverOverwrite = i3;
            if (!node2.hasChild(next2) && serverOverwrite == null) {
            }
            if (serverOverwrite == null) {
            }
            ChildKey[] arr = new ChildKey[i2];
            arr[i3] = next2;
            path = new Path(arr);
            view = serverOverwrite2;
            if (rootWrite.rootWrite() == null) {
            } else {
            }
            serverOverwrite = i2;
        }
        return view;
    }

    private com.google.firebase.database.core.view.ViewCache applyServerOverwrite(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, Node node3, WriteTreeRef writeTreeRef4, Node node5, boolean z6, ChildChangeAccumulator childChangeAccumulator7) {
        IndexedNode fullNode;
        boolean fullyInitialized;
        NodeFilter indexedFilter;
        boolean filtersNodes;
        Path path;
        IndexedNode indexedNode2;
        boolean completeForPath;
        Node immediateChild2;
        Object indexedNode;
        Object immediateChild;
        ChildKey front;
        Node child;
        Path popFront;
        NodeFilter.CompleteChildSource nO_COMPLETE_SOURCE;
        int i;
        int i2;
        Object obj = viewCache;
        Node node2 = node3;
        com.google.firebase.database.core.view.CacheNode serverCache = viewCache.getServerCache();
        if (z6) {
        } else {
            indexedFilter = obj3.filter.getIndexedFilter();
        }
        immediateChild2 = 0;
        i2 = 1;
        if (path2.isEmpty()) {
            fullNode = indexedFilter.updateFullNode(serverCache.getIndexedNode(), IndexedNode.from(node2, indexedFilter.getIndex()), immediateChild2);
            path = path2;
        } else {
        }
        if (!serverCache.isFullyInitialized()) {
            if (path2.isEmpty()) {
            } else {
                i2 = 0;
            }
        }
        com.google.firebase.database.core.view.ViewCache serverSnap = obj.updateServerSnap(fullNode, i2, indexedFilter.filtersNodes());
        WriteTreeRef writeTreeRef = writeTreeRef4;
        ViewProcessor.WriteTreeCompleteChildSource writeTreeCompleteChildSource = new ViewProcessor.WriteTreeCompleteChildSource(writeTreeRef, serverSnap, node5);
        return this.generateEventCacheAfterServerEvent(serverSnap, path2, writeTreeRef, writeTreeCompleteChildSource, childChangeAccumulator7);
    }

    private com.google.firebase.database.core.view.ViewCache applyUserMerge(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, CompoundWrite compoundWrite3, WriteTreeRef writeTreeRef4, Node node5, ChildChangeAccumulator childChangeAccumulator6) {
        int i;
        String next;
        boolean userOverwrite;
        com.google.firebase.database.core.view.ViewCache cacheHasChild2;
        Path child;
        boolean cacheHasChild;
        com.google.firebase.database.core.view.ViewCache view;
        WriteTreeRef child2;
        Node node2;
        ChildChangeAccumulator childChangeAccumulator;
        Node node;
        ChildChangeAccumulator childChangeAccumulator2;
        final Object obj = path2;
        i = compoundWrite3.rootWrite() == null ? 1 : 0;
        Utilities.hardAssert(i, "Can't have a merge that is an overwrite");
        Iterator iterator = compoundWrite3.iterator();
        cacheHasChild2 = view2;
        while (iterator.hasNext()) {
            next = iterator.next();
            child = path2.child((Path)(Map.Entry)next.getKey());
            if (ViewProcessor.cacheHasChild(viewCache, child.getFront())) {
            }
            cacheHasChild2 = this.applyUserOverwrite(cacheHasChild2, child, (Node)next.getValue(), writeTreeRef4, node5, childChangeAccumulator6);
        }
        Iterator iterator2 = compoundWrite3.iterator();
        view = cacheHasChild2;
        while (iterator2.hasNext()) {
            userOverwrite = iterator2.next();
            child2 = path2.child((Path)(Map.Entry)userOverwrite.getKey());
            if (ViewProcessor.cacheHasChild(viewCache, child2.getFront()) == null) {
            }
            view = userOverwrite;
        }
        return view;
    }

    private com.google.firebase.database.core.view.ViewCache applyUserOverwrite(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, Node node3, WriteTreeRef writeTreeRef4, Node node5, ChildChangeAccumulator childChangeAccumulator6) {
        NodeFilter filter;
        IndexedNode indexedNode;
        ChildKey front;
        boolean z;
        Path popFront;
        ChildChangeAccumulator childChangeAccumulator;
        com.google.firebase.database.core.view.ViewCache obj9;
        IndexedNode obj10;
        int obj11;
        boolean obj12;
        Node obj13;
        final com.google.firebase.database.core.view.CacheNode eventCache = viewCache.getEventCache();
        ViewProcessor.WriteTreeCompleteChildSource writeTreeCompleteChildSource = new ViewProcessor.WriteTreeCompleteChildSource(writeTreeRef4, viewCache, node5);
        if (path2.isEmpty()) {
            obj9 = viewCache.updateEventSnap(this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(node3, this.filter.getIndex()), childChangeAccumulator6), true, this.filter.filtersNodes());
        } else {
            front = path2.getFront();
            if (front.isPriorityChildName()) {
                obj9 = viewCache.updateEventSnap(this.filter.updatePriority(viewCache.getEventCache().getIndexedNode(), node3), eventCache.isFullyInitialized(), eventCache.isFiltered());
            } else {
                popFront = path2.popFront();
                if (popFront.isEmpty()) {
                    z = obj11;
                } else {
                }
                if (!eventCache.getNode().getImmediateChild(front).equals(z)) {
                    obj9 = viewCache.updateEventSnap(this.filter.updateChild(eventCache.getIndexedNode(), front, z, popFront, writeTreeCompleteChildSource, childChangeAccumulator6), eventCache.isFullyInitialized(), this.filter.filtersNodes());
                }
            }
        }
        return obj9;
    }

    private static boolean cacheHasChild(com.google.firebase.database.core.view.ViewCache viewCache, ChildKey childKey2) {
        return viewCache.getEventCache().isCompleteForChild(childKey2);
    }

    private com.google.firebase.database.core.view.ViewCache generateEventCacheAfterServerEvent(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, WriteTreeRef writeTreeRef3, NodeFilter.CompleteChildSource nodeFilter$CompleteChildSource4, ChildChangeAccumulator childChangeAccumulator5) {
        Path empty;
        Node calcCompleteEventCache;
        IndexedNode indexedNode3;
        Node calcCompleteChild;
        Node completeServerSnap;
        Object immediateChild;
        int i;
        int i2;
        String str;
        Object indexedNode2;
        NodeFilter filter;
        IndexedNode indexedNode;
        ChildKey front;
        Node node;
        Path popFront;
        NodeFilter.CompleteChildSource completeChildSource;
        ChildChangeAccumulator childChangeAccumulator;
        final Object obj = this;
        Object obj2 = viewCache;
        empty = path2;
        Object obj3 = writeTreeRef3;
        com.google.firebase.database.core.view.CacheNode eventCache = viewCache.getEventCache();
        if (obj3.shadowingWrite(empty) != null) {
            return obj2;
        }
        final int i3 = 1;
        if (path2.isEmpty()) {
            Utilities.hardAssert(viewCache.getServerCache().isFullyInitialized(), "If change path is empty, we must have complete server data");
            if (viewCache.getServerCache().isFiltered()) {
                if (completeServerSnap instanceof ChildrenNode) {
                } else {
                    completeServerSnap = EmptyNode.Empty();
                }
                calcCompleteEventCache = obj3.calcCompleteEventChildren(completeServerSnap);
            } else {
                calcCompleteEventCache = obj3.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            indexedNode3 = obj.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(calcCompleteEventCache, obj.filter.getIndex()), childChangeAccumulator5);
        } else {
            childChangeAccumulator = childChangeAccumulator5;
            front = path2.getFront();
            if (front.isPriorityChildName()) {
                i = path2.size() == i3 ? i3 : i2;
                Utilities.hardAssert(i, "Can't have a priority with additional path components");
                Node calcEventCacheAfterServerOverwrite = obj3.calcEventCacheAfterServerOverwrite(empty, eventCache.getNode(), viewCache.getServerCache().getNode());
                if (calcEventCacheAfterServerOverwrite != null) {
                    indexedNode3 = obj.filter.updatePriority(eventCache.getIndexedNode(), calcEventCacheAfterServerOverwrite);
                } else {
                    indexedNode3 = eventCache.getIndexedNode();
                }
            } else {
                popFront = path2.popFront();
                if (eventCache.isCompleteForChild(front)) {
                    Node calcEventCacheAfterServerOverwrite2 = obj3.calcEventCacheAfterServerOverwrite(empty, eventCache.getNode(), viewCache.getServerCache().getNode());
                    if (calcEventCacheAfterServerOverwrite2 != null) {
                        calcCompleteChild = eventCache.getNode().getImmediateChild(front).updateChild(popFront, calcEventCacheAfterServerOverwrite2);
                    } else {
                        calcCompleteChild = eventCache.getNode().getImmediateChild(front);
                    }
                } else {
                    calcCompleteChild = obj3.calcCompleteChild(front, viewCache.getServerCache());
                }
                node = calcCompleteChild;
                if (node != null) {
                    indexedNode3 = obj.filter.updateChild(eventCache.getIndexedNode(), front, node, popFront, completeChildSource4, childChangeAccumulator5);
                } else {
                    indexedNode3 = eventCache.getIndexedNode();
                }
            }
        }
        if (!eventCache.isFullyInitialized()) {
            if (path2.isEmpty()) {
                i2 = i3;
            }
        } else {
        }
        return obj2.updateEventSnap(indexedNode3, i2, obj.filter.filtersNodes());
    }

    private com.google.firebase.database.core.view.ViewCache listenComplete(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, WriteTreeRef writeTreeRef3, Node node4, ChildChangeAccumulator childChangeAccumulator5) {
        int i;
        boolean fullyInitialized;
        com.google.firebase.database.core.view.CacheNode obj12 = viewCache.getServerCache();
        if (!obj12.isFullyInitialized()) {
            if (path2.isEmpty()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return this.generateEventCacheAfterServerEvent(viewCache.updateServerSnap(obj12.getIndexedNode(), i, obj12.isFiltered()), path2, writeTreeRef3, ViewProcessor.NO_COMPLETE_SOURCE, childChangeAccumulator5);
    }

    private void maybeAddValueEvent(com.google.firebase.database.core.view.ViewCache viewCache, com.google.firebase.database.core.view.ViewCache viewCache2, List<com.google.firebase.database.core.view.Change> list3) {
        int fullyInitialized;
        boolean leafNode;
        boolean completeEventSnap;
        boolean obj3;
        final com.google.firebase.database.core.view.CacheNode obj4 = viewCache2.getEventCache();
        if (obj4.isFullyInitialized()) {
            if (!obj4.getNode().isLeafNode()) {
                if (obj4.getNode().isEmpty()) {
                    fullyInitialized = 1;
                } else {
                    fullyInitialized = 0;
                }
            } else {
            }
            if (list3.isEmpty() && viewCache.getEventCache().isFullyInitialized()) {
                if (viewCache.getEventCache().isFullyInitialized()) {
                    if (fullyInitialized != 0) {
                        if (obj4.getNode().equals(viewCache.getCompleteEventSnap())) {
                            if (!obj4.getNode().getPriority().equals(viewCache.getCompleteEventSnap().getPriority())) {
                                list3.add(Change.valueChange(obj4.getIndexedNode()));
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    public com.google.firebase.database.core.view.ViewProcessor.ProcessorResult applyOperation(com.google.firebase.database.core.view.ViewCache viewCache, Operation operation2, WriteTreeRef writeTreeRef3, Node node4) {
        boolean filtered2;
        boolean filtered;
        Object obj;
        com.google.firebase.database.core.view.ViewCache view;
        Path path;
        Object affectedTree;
        Object writeTreeRef;
        Object node;
        int childChangeAccumulator;
        ChildChangeAccumulator childChangeAccumulator2;
        com.google.firebase.database.core.view.ViewCache obj11;
        ChildChangeAccumulator childChangeAccumulator3 = new ChildChangeAccumulator();
        int i = ViewProcessor.2.$SwitchMap$com$google$firebase$database$core$operation$Operation$OperationType[operation2.getType().ordinal()];
        int i2 = 0;
        int i5 = 1;
        if (i != i5) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                    } else {
                        obj11 = this.listenComplete(viewCache, operation2.getPath(), writeTreeRef3, node4, childChangeAccumulator3);
                    }
                    StringBuilder obj12 = new StringBuilder();
                    obj12.append("Unknown operation: ");
                    obj12.append(operation2.getType());
                    AssertionError obj10 = new AssertionError(obj12.toString());
                    throw obj10;
                }
                if (!(AckUserWrite)operation2.isRevert()) {
                    obj11 = this.ackUserWrite(viewCache, operation2.getPath(), operation2.getAffectedTree(), writeTreeRef3, node4, childChangeAccumulator3);
                } else {
                    obj11 = this.revertUserWrite(viewCache, operation2.getPath(), writeTreeRef3, node4, childChangeAccumulator3);
                }
            } else {
                if ((Merge)operation2.getSource().isFromUser()) {
                    obj11 = this.applyUserMerge(viewCache, operation2.getPath(), operation2.getChildren(), writeTreeRef3, node4, childChangeAccumulator3);
                } else {
                    Utilities.hardAssert(operation2.getSource().isFromServer());
                    if (!operation2.getSource().isTagged()) {
                        if (viewCache.getServerCache().isFiltered()) {
                            childChangeAccumulator = i5;
                        } else {
                            childChangeAccumulator = i2;
                        }
                    } else {
                    }
                    obj11 = this.applyServerMerge(viewCache, operation2.getPath(), operation2.getChildren(), writeTreeRef3, node4, childChangeAccumulator, childChangeAccumulator3);
                }
            }
        } else {
            if ((Overwrite)operation2.getSource().isFromUser()) {
                obj11 = this.applyUserOverwrite(viewCache, operation2.getPath(), operation2.getSnapshot(), writeTreeRef3, node4, childChangeAccumulator3);
            } else {
                Utilities.hardAssert(operation2.getSource().isFromServer());
                if (!operation2.getSource().isTagged()) {
                    if (viewCache.getServerCache().isFiltered() && !operation2.getPath().isEmpty()) {
                        if (!operation2.getPath().isEmpty()) {
                            childChangeAccumulator = i5;
                        } else {
                            childChangeAccumulator = i2;
                        }
                    } else {
                    }
                } else {
                }
                obj11 = this.applyServerOverwrite(viewCache, operation2.getPath(), operation2.getSnapshot(), writeTreeRef3, node4, childChangeAccumulator, childChangeAccumulator3);
            }
        }
        obj12 = new ArrayList(childChangeAccumulator3.getChanges());
        maybeAddValueEvent(viewCache, obj11, obj12);
        obj10 = new ViewProcessor.ProcessorResult(obj11, obj12);
        return obj10;
    }

    public com.google.firebase.database.core.view.ViewCache revertUserWrite(com.google.firebase.database.core.view.ViewCache viewCache, Path path2, WriteTreeRef writeTreeRef3, Node node4, ChildChangeAccumulator childChangeAccumulator5) {
        Node completeForChild;
        NodeFilter filter;
        IndexedNode indexedNode;
        ChildKey front;
        Node node;
        Path popFront;
        ChildChangeAccumulator childChangeAccumulator;
        Node obj10;
        Node obj12;
        if (writeTreeRef3.shadowingWrite(path2) != null) {
            return viewCache;
        }
        ViewProcessor.WriteTreeCompleteChildSource writeTreeCompleteChildSource = new ViewProcessor.WriteTreeCompleteChildSource(writeTreeRef3, viewCache, node4);
        indexedNode = viewCache.getEventCache().getIndexedNode();
        if (!path2.isEmpty()) {
            if (path2.getFront().isPriorityChildName()) {
                if (viewCache.getServerCache().isFullyInitialized()) {
                    obj10 = writeTreeRef3.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                } else {
                    obj10 = writeTreeRef3.calcCompleteEventChildren(viewCache.getServerCache().getNode());
                }
                indexedNode = this.filter.updateFullNode(indexedNode, IndexedNode.from(obj10, this.filter.getIndex()), childChangeAccumulator5);
            } else {
                front = path2.getFront();
                if (writeTreeRef3.calcCompleteChild(front, viewCache.getServerCache()) == null && viewCache.getServerCache().isCompleteForChild(front)) {
                    if (viewCache.getServerCache().isCompleteForChild(front)) {
                        obj12 = indexedNode.getNode().getImmediateChild(front);
                    }
                }
                node = obj12;
                if (node != null) {
                    indexedNode = this.filter.updateChild(indexedNode, front, node, path2.popFront(), writeTreeCompleteChildSource, childChangeAccumulator5);
                } else {
                    if (node == null && viewCache.getEventCache().getNode().hasChild(front)) {
                        if (viewCache.getEventCache().getNode().hasChild(front)) {
                            indexedNode = this.filter.updateChild(indexedNode, front, EmptyNode.Empty(), path2.popFront(), writeTreeCompleteChildSource, childChangeAccumulator5);
                        }
                    }
                }
                obj10 = writeTreeRef3.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                if (indexedNode.getNode().isEmpty() && viewCache.getServerCache().isFullyInitialized() && obj10.isLeafNode()) {
                    if (viewCache.getServerCache().isFullyInitialized()) {
                        obj10 = writeTreeRef3.calcCompleteEventCache(viewCache.getCompleteServerSnap());
                        if (obj10.isLeafNode()) {
                            indexedNode = this.filter.updateFullNode(indexedNode, IndexedNode.from(obj10, this.filter.getIndex()), childChangeAccumulator5);
                        }
                    }
                }
            }
        } else {
        }
        if (!viewCache.getServerCache().isFullyInitialized()) {
            if (writeTreeRef3.shadowingWrite(Path.getEmptyPath()) != null) {
                obj10 = 1;
            } else {
                obj10 = 0;
            }
        } else {
        }
        return viewCache.updateEventSnap(indexedNode, obj10, this.filter.filtersNodes());
    }
}
