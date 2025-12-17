package com.google.firebase.database.snapshot;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;
import com.google.firebase.database.collection.LLRBNode.NodeVisitor;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.Utilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class ChildrenNode implements com.google.firebase.database.snapshot.Node {

    public static Comparator<com.google.firebase.database.snapshot.ChildKey> NAME_ONLY_COMPARATOR;
    private final ImmutableSortedMap<com.google.firebase.database.snapshot.ChildKey, com.google.firebase.database.snapshot.Node> children;
    private String lazyHash = null;
    private final com.google.firebase.database.snapshot.Node priority;

    private static class NamedNodeIterator implements Iterator<com.google.firebase.database.snapshot.NamedNode> {

        private final Iterator<Map.Entry<com.google.firebase.database.snapshot.ChildKey, com.google.firebase.database.snapshot.Node>> iterator;
        public NamedNodeIterator(Iterator<Map.Entry<com.google.firebase.database.snapshot.ChildKey, com.google.firebase.database.snapshot.Node>> iterator) {
            super();
            this.iterator = iterator;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public com.google.firebase.database.snapshot.NamedNode next() {
            Object next = this.iterator.next();
            NamedNode namedNode = new NamedNode((ChildKey)(Map.Entry)next.getKey(), (Node)next.getValue());
            return namedNode;
        }

        @Override // java.util.Iterator
        public Object next() {
            return next();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.iterator.remove();
        }
    }

    public static abstract class ChildVisitor extends LLRBNode.NodeVisitor<com.google.firebase.database.snapshot.ChildKey, com.google.firebase.database.snapshot.Node> {
        @Override // com.google.firebase.database.collection.LLRBNode$NodeVisitor
        public abstract void visitChild(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2);

        @Override // com.google.firebase.database.collection.LLRBNode$NodeVisitor
        public void visitEntry(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
            visitChild(childKey, node2);
        }

        @Override // com.google.firebase.database.collection.LLRBNode$NodeVisitor
        public void visitEntry(Object object, Object object2) {
            visitEntry((ChildKey)object, (Node)object2);
        }
    }
    static {
        ChildrenNode.1 anon = new ChildrenNode.1();
        ChildrenNode.NAME_ONLY_COMPARATOR = anon;
    }

    protected ChildrenNode() {
        super();
        int i = 0;
        this.children = ImmutableSortedMap.Builder.emptyMap(ChildrenNode.NAME_ONLY_COMPARATOR);
        this.priority = PriorityUtilities.NullPriority();
    }

    protected ChildrenNode(ImmutableSortedMap<com.google.firebase.database.snapshot.ChildKey, com.google.firebase.database.snapshot.Node> immutableSortedMap, com.google.firebase.database.snapshot.Node node2) {
        boolean empty;
        super();
        int i = 0;
        if (immutableSortedMap.isEmpty()) {
            if (!node2.isEmpty()) {
            } else {
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
            throw obj2;
        }
        this.priority = node2;
        this.children = immutableSortedMap;
    }

    private static void addIndentation(StringBuilder stringBuilder, int i2) {
        int i;
        String str;
        i = 0;
        while (i < i2) {
            stringBuilder.append(" ");
            i++;
        }
    }

    private void toString(StringBuilder stringBuilder, int i2) {
        boolean string2;
        boolean string;
        String str;
        int i;
        boolean z;
        String obj7;
        if (this.children.isEmpty() && this.priority.isEmpty()) {
            if (this.priority.isEmpty()) {
                stringBuilder.append("{ }");
            } else {
                stringBuilder.append("{\n");
                Iterator iterator = this.children.iterator();
                str = "\n";
                while (iterator.hasNext()) {
                    Object next = iterator.next();
                    i = i2 + 2;
                    ChildrenNode.addIndentation(stringBuilder, i);
                    stringBuilder.append((ChildKey)(Map.Entry)next.getKey().asString());
                    stringBuilder.append("=");
                    if (value2 instanceof ChildrenNode) {
                    } else {
                    }
                    stringBuilder.append((Node)next.getValue().toString());
                    stringBuilder.append(str);
                    str = "\n";
                    (ChildrenNode)next.getValue().toString(stringBuilder, i);
                }
                if (!this.priority.isEmpty()) {
                    ChildrenNode.addIndentation(stringBuilder, i2 + 2);
                    stringBuilder.append(".priority=");
                    stringBuilder.append(this.priority.toString());
                    stringBuilder.append(str);
                }
                ChildrenNode.addIndentation(stringBuilder, i2);
                stringBuilder.append("}");
            }
        } else {
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int compareTo(com.google.firebase.database.snapshot.Node node) {
        final int i = 0;
        final int i2 = -1;
        if (isEmpty() && node.isEmpty()) {
            if (node.isEmpty()) {
                return i;
            }
            return i2;
        }
        final int i3 = 1;
        if (node.isLeafNode()) {
            return i3;
        }
        if (node.isEmpty()) {
            return i3;
        }
        if (node == Node.MAX_NODE) {
            return i2;
        }
        return i;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int compareTo(Object object) {
        return compareTo((Node)object);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean equals(Object object) {
        int equals;
        boolean next;
        Object value;
        boolean equals2;
        Object key;
        Iterator obj8;
        int i = 0;
        if (object == null) {
            return i;
        }
        final int i2 = 1;
        if (object == this) {
            return i2;
        }
        if (!object instanceof ChildrenNode) {
            return i;
        }
        if (!getPriority().equals((ChildrenNode)object.getPriority())) {
            return i;
        }
        if (this.children.size() != object.children.size()) {
            return i;
        }
        Iterator iterator = this.children.iterator();
        obj8 = object.children.iterator();
        while (iterator.hasNext()) {
            equals = iterator.next();
            value = obj8.next();
        }
        if (iterator.hasNext()) {
        } else {
            if (obj8.hasNext()) {
            } else {
                return i2;
            }
        }
        obj8 = new IllegalStateException("Something went wrong internally.");
        throw obj8;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public void forEachChild(com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor childrenNode$ChildVisitor) {
        forEachChild(childVisitor, false);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public void forEachChild(com.google.firebase.database.snapshot.ChildrenNode.ChildVisitor childrenNode$ChildVisitor, boolean z2) {
        com.google.firebase.database.snapshot.ChildrenNode.2 anon;
        ImmutableSortedMap obj3;
        if (z2) {
            if (getPriority().isEmpty()) {
                this.children.inOrderTraversal(childVisitor);
            } else {
                anon = new ChildrenNode.2(this, childVisitor);
                this.children.inOrderTraversal(anon);
            }
        } else {
        }
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node getChild(Path path) {
        com.google.firebase.database.snapshot.ChildKey front = path.getFront();
        if (front == null) {
            return this;
        }
        return getImmediateChild(front).getChild(path.popFront());
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int getChildCount() {
        return this.children.size();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.ChildKey getFirstChildKey() {
        return (ChildKey)this.children.getMinKey();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHash() {
        String sha1HexDigest;
        boolean empty;
        if (this.lazyHash == null) {
            String hashRepresentation = getHashRepresentation(Node.HashVersion.V1);
            if (hashRepresentation.isEmpty()) {
                sha1HexDigest = "";
            } else {
                sha1HexDigest = Utilities.sha1HexDigest(hashRepresentation);
            }
            this.lazyHash = sha1HexDigest;
        }
        return this.lazyHash;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String getHashRepresentation(com.google.firebase.database.snapshot.Node.HashVersion node$HashVersion) {
        Object hashRepresentation;
        boolean priority;
        Object iterator;
        int hash;
        boolean equals;
        Object next;
        hashRepresentation = Node.HashVersion.V1;
        if (hashVersion != hashRepresentation) {
        } else {
            StringBuilder obj7 = new StringBuilder();
            final String str3 = ":";
            if (!this.priority.isEmpty()) {
                obj7.append("priority:");
                obj7.append(this.priority.getHashRepresentation(hashRepresentation));
                obj7.append(str3);
            }
            ArrayList arrayList = new ArrayList();
            iterator = iterator();
            while (/* condition */) {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    arrayList.add((NamedNode)next);
                    if (equals == 0) {
                        break loop_5;
                    } else {
                    }
                    equals = 1;
                    if (next.getNode().getPriority().isEmpty()) {
                        break loop_5;
                    } else {
                    }
                }
                next = iterator.next();
                arrayList.add((NamedNode)next);
                if (equals == 0) {
                } else {
                }
                equals = 1;
                if (!next.getNode().getPriority().isEmpty()) {
                } else {
                }
                equals = hash;
            }
            if (equals != 0) {
                Collections.sort(arrayList, PriorityIndex.getInstance());
            }
            Iterator iterator2 = arrayList.iterator();
            while (iterator2.hasNext()) {
                iterator = iterator2.next();
                hash = (NamedNode)iterator.getNode().getHash();
                if (hash.equals("") == 0) {
                }
                obj7.append(str3);
                obj7.append(iterator.getName().asString());
                obj7.append(str3);
                obj7.append(hash);
            }
            return obj7.toString();
        }
        obj7 = new IllegalArgumentException("Hashes on children nodes only supported for V1");
        throw obj7;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node getImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey) {
        boolean priorityChildName;
        if (childKey.isPriorityChildName() && !this.priority.isEmpty()) {
            if (!this.priority.isEmpty()) {
                return this.priority;
            }
        }
        if (this.children.containsKey(childKey)) {
            return (Node)this.children.get(childKey);
        }
        return EmptyNode.Empty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.ChildKey getLastChildKey() {
        return (ChildKey)this.children.getMaxKey();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.ChildKey getPredecessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey) {
        return (ChildKey)this.children.getPredecessorKey(childKey);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node getPriority() {
        return this.priority;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.ChildKey getSuccessorChildKey(com.google.firebase.database.snapshot.ChildKey childKey) {
        return (ChildKey)this.children.getSuccessorKey(childKey);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue() {
        return getValue(false);
    }

    @Override // com.google.firebase.database.snapshot.Node
    public Object getValue(boolean z) {
        int i2;
        Object iterator;
        int str;
        int i5;
        int i;
        int i3;
        int intValue2;
        Object tryParseInt;
        String intValue;
        int i4;
        boolean obj11;
        if (isEmpty()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        iterator = this.children.iterator();
        str = 1;
        i5 = 0;
        i3 = str;
        intValue2 = i;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            intValue = (ChildKey)(Map.Entry)next2.getKey().asString();
            hashMap.put(intValue, (Node)next2.getValue().getValue(z));
            i++;
            if (i3 != 0) {
            }
            if (intValue.length() > str && intValue.charAt(i5) == 48) {
            } else {
            }
            tryParseInt = Utilities.tryParseInt(intValue);
            if (tryParseInt != null && tryParseInt.intValue() >= 0) {
            } else {
            }
            i3 = i5;
            if (tryParseInt.intValue() >= 0) {
            } else {
            }
            if (tryParseInt.intValue() > intValue2) {
            }
            intValue2 = tryParseInt.intValue();
            if (intValue.charAt(i5) == 48) {
            } else {
            }
        }
        if (!z && i3 != 0 && intValue2 < i *= 2) {
            if (i3 != 0) {
                if (intValue2 < i *= 2) {
                    obj11 = new ArrayList(intValue2 + 1);
                    while (i5 <= intValue2) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("");
                        stringBuilder.append(i5);
                        obj11.add(hashMap.get(stringBuilder.toString()));
                        i5++;
                    }
                    return obj11;
                }
            }
        }
        if (z && !this.priority.isEmpty()) {
            if (!this.priority.isEmpty()) {
                hashMap.put(".priority", this.priority.getValue());
            }
        }
        return hashMap;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean hasChild(com.google.firebase.database.snapshot.ChildKey childKey) {
        return obj1 ^= 1;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public int hashCode() {
        int i3;
        int i;
        int i2;
        final Iterator iterator = iterator();
        i3 = 0;
        for (NamedNode next2 : iterator) {
            i6 += i;
        }
        return i3;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isEmpty() {
        return this.children.isEmpty();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public boolean isLeafNode() {
        return 0;
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> iterator() {
        ChildrenNode.NamedNodeIterator namedNodeIterator = new ChildrenNode.NamedNodeIterator(this.children.iterator());
        return namedNodeIterator;
    }

    public Iterator<com.google.firebase.database.snapshot.NamedNode> reverseIterator() {
        ChildrenNode.NamedNodeIterator namedNodeIterator = new ChildrenNode.NamedNodeIterator(this.children.reverseIterator());
        return namedNodeIterator;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        toString(stringBuilder, 0);
        return stringBuilder.toString();
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node updateChild(Path path, com.google.firebase.database.snapshot.Node node2) {
        final com.google.firebase.database.snapshot.ChildKey front = path.getFront();
        if (front == null) {
            return node2;
        }
        if (front.isPriorityChildName()) {
            Utilities.hardAssert(PriorityUtilities.isValidPriority(node2));
            return updatePriority(node2);
        }
        return updateImmediateChild(front, getImmediateChild(front).updateChild(path.popFront(), node2));
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node updateImmediateChild(com.google.firebase.database.snapshot.ChildKey childKey, com.google.firebase.database.snapshot.Node node2) {
        ImmutableSortedMap children;
        if (childKey.isPriorityChildName()) {
            return updatePriority(node2);
        }
        children = this.children;
        if (children.containsKey(childKey)) {
            children = children.remove(childKey);
        }
        if (!node2.isEmpty()) {
            children = children.insert(childKey, node2);
        }
        if (children.isEmpty()) {
            return EmptyNode.Empty();
        }
        ChildrenNode obj3 = new ChildrenNode(children, this.priority);
        return obj3;
    }

    @Override // com.google.firebase.database.snapshot.Node
    public com.google.firebase.database.snapshot.Node updatePriority(com.google.firebase.database.snapshot.Node node) {
        if (this.children.isEmpty()) {
            return EmptyNode.Empty();
        }
        ChildrenNode childrenNode = new ChildrenNode(this.children, node);
        return childrenNode;
    }
}
