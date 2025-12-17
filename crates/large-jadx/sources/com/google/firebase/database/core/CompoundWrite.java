package com.google.firebase.database.core;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public final class CompoundWrite implements Iterable<Map.Entry<com.google.firebase.database.core.Path, Node>> {

    private static final com.google.firebase.database.core.CompoundWrite EMPTY;
    private final ImmutableTree<Node> writeTree;
    static {
        ImmutableTree immutableTree = new ImmutableTree(0);
        CompoundWrite compoundWrite = new CompoundWrite(immutableTree);
        CompoundWrite.EMPTY = compoundWrite;
    }

    private CompoundWrite(ImmutableTree<Node> immutableTree) {
        super();
        this.writeTree = immutableTree;
    }

    private Node applySubtreeWrite(com.google.firebase.database.core.Path path, ImmutableTree<Node> immutableTree2, Node node3) {
        int value2;
        int i;
        Object child;
        Object value;
        boolean priorityChildName;
        com.google.firebase.database.core.Path obj5;
        boolean obj6;
        Node obj7;
        if (immutableTree2.getValue() != null) {
            return node3.updateChild(path, (Node)immutableTree2.getValue());
        }
        value2 = 0;
        obj6 = immutableTree2.getChildren().iterator();
        while (obj6.hasNext()) {
            Object next2 = obj6.next();
            value = (Map.Entry)next2.getValue();
            Object key = next2.getKey();
            if ((ChildKey)key.isPriorityChildName()) {
            } else {
            }
            obj7 = applySubtreeWrite(path.child(key), (ImmutableTree)value, obj7);
            if (value.getValue() != null) {
            } else {
            }
            i = 0;
            Utilities.hardAssert(i, "Priority writes must always be leaf nodes");
            value2 = value.getValue();
            i = 1;
        }
        if (!obj7.getChild(path).isEmpty() && value2 != null) {
            if (value2 != null) {
                obj7 = obj7.updateChild(path.child(ChildKey.getPriorityKey()), value2);
            }
        }
        return obj7;
    }

    public static com.google.firebase.database.core.CompoundWrite emptyWrite() {
        return CompoundWrite.EMPTY;
    }

    public static com.google.firebase.database.core.CompoundWrite fromChildMerge(Map<ChildKey, Node> map) {
        ImmutableTree emptyInstance;
        Object key;
        ImmutableTree immutableTree;
        com.google.firebase.database.core.Path path;
        ChildKey[] arr;
        int i;
        emptyInstance = ImmutableTree.emptyInstance();
        Iterator obj6 = map.entrySet().iterator();
        for (Map.Entry next2 : obj6) {
            immutableTree = new ImmutableTree((Node)next2.getValue());
            arr = new ChildKey[1];
            path = new Path(arr);
            emptyInstance = emptyInstance.setTree(path, immutableTree);
        }
        obj6 = new CompoundWrite(emptyInstance);
        return obj6;
    }

    public static com.google.firebase.database.core.CompoundWrite fromPathMerge(Map<com.google.firebase.database.core.Path, Node> map) {
        ImmutableTree emptyInstance;
        Object key;
        ImmutableTree immutableTree;
        Object value;
        emptyInstance = ImmutableTree.emptyInstance();
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            immutableTree = new ImmutableTree((Node)next2.getValue());
            emptyInstance = emptyInstance.setTree((Path)next2.getKey(), immutableTree);
        }
        obj4 = new CompoundWrite(emptyInstance);
        return obj4;
    }

    public static com.google.firebase.database.core.CompoundWrite fromValue(Map<String, Object> map) {
        ImmutableTree emptyInstance;
        Object key;
        ImmutableTree immutableTree;
        com.google.firebase.database.core.Path path;
        emptyInstance = ImmutableTree.emptyInstance();
        Iterator obj4 = map.entrySet().iterator();
        for (Map.Entry next2 : obj4) {
            immutableTree = new ImmutableTree(NodeUtilities.NodeFromJSON(next2.getValue()));
            path = new Path((String)next2.getKey());
            emptyInstance = emptyInstance.setTree(path, immutableTree);
        }
        obj4 = new CompoundWrite(emptyInstance);
        return obj4;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.CompoundWrite addWrite(com.google.firebase.database.core.Path path, Node node2) {
        ChildKey priorityChildName;
        if (path.isEmpty()) {
            ImmutableTree immutableTree2 = new ImmutableTree(node2);
            CompoundWrite obj4 = new CompoundWrite(immutableTree2);
            return obj4;
        }
        com.google.firebase.database.core.Path rootMostPathWithValue = this.writeTree.findRootMostPathWithValue(path);
        obj4 = Path.getRelative(rootMostPathWithValue, path);
        Object obj = this.writeTree.get(rootMostPathWithValue);
        priorityChildName = obj4.getBack();
        if (rootMostPathWithValue != null && priorityChildName != null && priorityChildName.isPriorityChildName() && (Node)obj.getChild(obj4.getParent()).isEmpty()) {
            obj4 = Path.getRelative(rootMostPathWithValue, path);
            obj = this.writeTree.get(rootMostPathWithValue);
            priorityChildName = obj4.getBack();
            if (priorityChildName != null) {
                if (priorityChildName.isPriorityChildName()) {
                    if ((Node)obj.getChild(obj4.getParent()).isEmpty()) {
                        return this;
                    }
                }
            }
            CompoundWrite obj5 = new CompoundWrite(this.writeTree.set(rootMostPathWithValue, obj.updateChild(obj4, node2)));
            return obj5;
        }
        ImmutableTree immutableTree = new ImmutableTree(node2);
        obj5 = new CompoundWrite(this.writeTree.setTree(path, immutableTree));
        return obj5;
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.CompoundWrite addWrite(ChildKey childKey, Node node2) {
        ChildKey[] arr = new ChildKey[1];
        Path path = new Path(arr);
        return addWrite(path, node2);
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.CompoundWrite addWrites(com.google.firebase.database.core.Path path, com.google.firebase.database.core.CompoundWrite compoundWrite2) {
        CompoundWrite.1 anon = new CompoundWrite.1(this, path);
        return (CompoundWrite)compoundWrite2.writeTree.fold(this, anon);
    }

    @Override // java.lang.Iterable
    public Node apply(Node node) {
        return applySubtreeWrite(Path.getEmptyPath(), this.writeTree, node);
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.CompoundWrite childCompoundWrite(com.google.firebase.database.core.Path path) {
        if (path.isEmpty()) {
            return this;
        }
        Node completeNode = getCompleteNode(path);
        if (completeNode != null) {
            ImmutableTree immutableTree = new ImmutableTree(completeNode);
            CompoundWrite obj3 = new CompoundWrite(immutableTree);
            return obj3;
        }
        CompoundWrite compoundWrite = new CompoundWrite(this.writeTree.subtree(path));
        return compoundWrite;
    }

    public Map<ChildKey, com.google.firebase.database.core.CompoundWrite> childCompoundWrites() {
        Object value;
        Object key;
        com.google.firebase.database.core.CompoundWrite compoundWrite;
        HashMap hashMap = new HashMap();
        Iterator iterator = this.writeTree.getChildren().iterator();
        for (Map.Entry next2 : iterator) {
            compoundWrite = new CompoundWrite((ImmutableTree)next2.getValue());
            hashMap.put((ChildKey)next2.getKey(), compoundWrite);
        }
        return hashMap;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        Class class;
        Class<com.google.firebase.database.core.CompoundWrite> obj;
        int i = 1;
        if (object == this) {
            return i;
        }
        if (object != null && object.getClass() != CompoundWrite.class) {
            if (object.getClass() != CompoundWrite.class) {
            }
            return (CompoundWrite)object.getValue(i).equals(getValue(i));
        }
        return 0;
    }

    public List<NamedNode> getCompleteChildren() {
        Iterator iterator;
        Node node;
        boolean next;
        NamedNode namedNode;
        ChildKey namedNode2;
        ArrayList arrayList = new ArrayList();
        if (this.writeTree.getValue() != null) {
            iterator = (Node)this.writeTree.getValue().iterator();
            for (NamedNode next2 : iterator) {
                namedNode = new NamedNode(next2.getName(), next2.getNode());
                arrayList.add(namedNode);
            }
        } else {
            iterator = this.writeTree.getChildren().iterator();
            while (iterator.hasNext()) {
                node = iterator.next();
                namedNode = (Map.Entry)node.getValue();
                if ((ImmutableTree)namedNode.getValue() != null) {
                }
                namedNode2 = new NamedNode((ChildKey)node.getKey(), (Node)namedNode.getValue());
                arrayList.add(namedNode2);
            }
        }
        return arrayList;
    }

    @Override // java.lang.Iterable
    public Node getCompleteNode(com.google.firebase.database.core.Path path) {
        com.google.firebase.database.core.Path rootMostPathWithValue = this.writeTree.findRootMostPathWithValue(path);
        if (rootMostPathWithValue != null) {
            return (Node)this.writeTree.get(rootMostPathWithValue).getChild(Path.getRelative(rootMostPathWithValue, path));
        }
        return null;
    }

    public Map<String, Object> getValue(boolean z) {
        HashMap hashMap = new HashMap();
        CompoundWrite.2 anon = new CompoundWrite.2(this, hashMap, z);
        this.writeTree.foreach(anon);
        return hashMap;
    }

    @Override // java.lang.Iterable
    public boolean hasCompleteWrite(com.google.firebase.database.core.Path path) {
        int obj1;
        obj1 = getCompleteNode(path) != null ? 1 : 0;
        return obj1;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        return getValue(true).hashCode();
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        return this.writeTree.isEmpty();
    }

    public Iterator<Map.Entry<com.google.firebase.database.core.Path, Node>> iterator() {
        return this.writeTree.iterator();
    }

    @Override // java.lang.Iterable
    public com.google.firebase.database.core.CompoundWrite removeWrite(com.google.firebase.database.core.Path path) {
        if (path.isEmpty()) {
            return CompoundWrite.EMPTY;
        }
        CompoundWrite compoundWrite = new CompoundWrite(this.writeTree.setTree(path, ImmutableTree.emptyInstance()));
        return compoundWrite;
    }

    @Override // java.lang.Iterable
    public Node rootWrite() {
        return (Node)this.writeTree.getValue();
    }

    @Override // java.lang.Iterable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CompoundWrite{");
        stringBuilder.append(getValue(true).toString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
