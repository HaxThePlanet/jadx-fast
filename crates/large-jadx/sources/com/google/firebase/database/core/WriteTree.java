package com.google.firebase.database.core;

import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.CacheNode;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public class WriteTree {

    private static final Predicate<com.google.firebase.database.core.UserWriteRecord> DEFAULT_FILTER;
    private List<com.google.firebase.database.core.UserWriteRecord> allWrites;
    private Long lastWriteId;
    private com.google.firebase.database.core.CompoundWrite visibleWrites;
    static {
        WriteTree.2 anon = new WriteTree.2();
        WriteTree.DEFAULT_FILTER = anon;
    }

    public WriteTree() {
        super();
        this.visibleWrites = CompoundWrite.emptyWrite();
        ArrayList arrayList = new ArrayList();
        this.allWrites = arrayList;
        this.lastWriteId = Long.valueOf(-1);
    }

    private static com.google.firebase.database.core.CompoundWrite layerTree(List<com.google.firebase.database.core.UserWriteRecord> list, Predicate<com.google.firebase.database.core.UserWriteRecord> predicate2, com.google.firebase.database.core.Path path3) {
        com.google.firebase.database.core.CompoundWrite emptyWrite;
        Object completeNode;
        boolean emptyPath;
        boolean emptyPath2;
        emptyWrite = CompoundWrite.emptyWrite();
        final Iterator obj4 = list.iterator();
        while (obj4.hasNext()) {
            completeNode = obj4.next();
            if (predicate2.evaluate((UserWriteRecord)completeNode)) {
            }
            emptyPath = completeNode.getPath();
            if (completeNode.isOverwrite()) {
            } else {
            }
            if (path3.contains(emptyPath)) {
            } else {
            }
            if (emptyPath.contains(path3)) {
            }
            emptyPath = Path.getRelative(emptyPath, path3);
            if (emptyPath.isEmpty()) {
            } else {
            }
            completeNode = completeNode.getMerge().getCompleteNode(emptyPath);
            if (completeNode != null) {
            }
            emptyWrite = emptyWrite.addWrite(Path.getEmptyPath(), completeNode);
            emptyWrite = emptyWrite.addWrites(Path.getEmptyPath(), completeNode.getMerge());
            emptyWrite = emptyWrite.addWrites(Path.getRelative(path3, emptyPath), completeNode.getMerge());
            if (path3.contains(emptyPath)) {
            } else {
            }
            if (emptyPath.contains(path3)) {
            }
            emptyWrite = emptyWrite.addWrite(Path.getEmptyPath(), completeNode.getOverwrite().getChild(Path.getRelative(emptyPath, path3)));
            emptyWrite = emptyWrite.addWrite(Path.getRelative(path3, emptyPath), completeNode.getOverwrite());
        }
        return emptyWrite;
    }

    private boolean recordContainsPath(com.google.firebase.database.core.UserWriteRecord userWriteRecord, com.google.firebase.database.core.Path path2) {
        boolean contains;
        com.google.firebase.database.core.Path path;
        if (userWriteRecord.isOverwrite()) {
            return userWriteRecord.getPath().contains(path2);
        }
        Iterator iterator = userWriteRecord.getMerge().iterator();
        for (Map.Entry next2 : iterator) {
        }
        return 0;
    }

    private void resetTree() {
        Long valueOf;
        int dEFAULT_FILTER;
        dEFAULT_FILTER = WriteTree.DEFAULT_FILTER;
        this.visibleWrites = WriteTree.layerTree(this.allWrites, dEFAULT_FILTER, Path.getEmptyPath());
        if (this.allWrites.size() > 0) {
            List allWrites3 = this.allWrites;
            size2--;
            this.lastWriteId = Long.valueOf((UserWriteRecord)allWrites3.get(dEFAULT_FILTER).getWriteId());
        } else {
            this.lastWriteId = Long.valueOf(-1);
        }
    }

    public void addMerge(com.google.firebase.database.core.Path path, com.google.firebase.database.core.CompoundWrite compoundWrite2, Long long3) {
        int i;
        i = Long.compare(longValue, longValue2) > 0 ? 1 : 0;
        Utilities.hardAssert(i);
        UserWriteRecord userWriteRecord = new UserWriteRecord(long3.longValue(), obj3, path, compoundWrite2);
        this.allWrites.add(userWriteRecord);
        this.visibleWrites = this.visibleWrites.addWrites(path, compoundWrite2);
        this.lastWriteId = long3;
    }

    public void addOverwrite(com.google.firebase.database.core.Path path, Node node2, Long long3, boolean z4) {
        int i;
        Object obj9;
        com.google.firebase.database.core.CompoundWrite obj12;
        i = Long.compare(longValue, longValue2) > 0 ? 1 : 0;
        Utilities.hardAssert(i);
        super(long3.longValue(), obj3, path, node2, z4);
        this.allWrites.add(userWriteRecord2);
        if (z4 != null) {
            this.visibleWrites = this.visibleWrites.addWrite(path, node2);
        }
        this.lastWriteId = long3;
    }

    public Node calcCompleteChild(com.google.firebase.database.core.Path path, ChildKey childKey2, CacheNode cacheNode3) {
        com.google.firebase.database.core.Path obj2 = path.child(childKey2);
        Node completeNode = this.visibleWrites.getCompleteNode(obj2);
        if (completeNode != null) {
            return completeNode;
        }
        if (cacheNode3.isCompleteForChild(childKey2)) {
            return this.visibleWrites.childCompoundWrite(obj2).apply(cacheNode3.getNode().getImmediateChild(childKey2));
        }
        return null;
    }

    public Node calcCompleteEventCache(com.google.firebase.database.core.Path path, Node node2) {
        ArrayList arrayList = new ArrayList();
        return calcCompleteEventCache(path, node2, arrayList);
    }

    public Node calcCompleteEventCache(com.google.firebase.database.core.Path path, Node node2, List<Long> list3) {
        return calcCompleteEventCache(path, node2, list3, false);
    }

    public Node calcCompleteEventCache(com.google.firebase.database.core.Path path, Node node2, List<Long> list3, boolean z4) {
        com.google.firebase.database.core.CompoundWrite childCompoundWrite;
        boolean emptyPath;
        EmptyNode obj5;
        boolean obj6;
        final int i = 0;
        obj6 = this.visibleWrites.getCompleteNode(path);
        if (list3.isEmpty() && !z4 && obj6 != null) {
            if (!z4) {
                obj6 = this.visibleWrites.getCompleteNode(path);
                if (obj6 != null) {
                    return obj6;
                }
                com.google.firebase.database.core.CompoundWrite obj4 = this.visibleWrites.childCompoundWrite(path);
                if (obj4.isEmpty()) {
                    return node2;
                }
                if (node2 == null && !obj4.hasCompleteWrite(Path.getEmptyPath())) {
                    if (!obj4.hasCompleteWrite(Path.getEmptyPath())) {
                        return i;
                    }
                }
                if (node2 != null) {
                } else {
                    obj5 = EmptyNode.Empty();
                }
                return obj4.apply(obj5);
            }
        }
        childCompoundWrite = this.visibleWrites.childCompoundWrite(path);
        if (!z4 && childCompoundWrite.isEmpty()) {
            if (childCompoundWrite.isEmpty()) {
                return node2;
            }
        }
        if (!z4 && node2 == null && !childCompoundWrite.hasCompleteWrite(Path.getEmptyPath())) {
            if (node2 == null) {
                if (!childCompoundWrite.hasCompleteWrite(Path.getEmptyPath())) {
                    return i;
                }
            }
        }
        WriteTree.1 anon = new WriteTree.1(this, z4, list3, path);
        if (node2 != null) {
        } else {
            obj5 = EmptyNode.Empty();
        }
        return WriteTree.layerTree(this.allWrites, anon, path).apply(obj5);
    }

    public Node calcCompleteEventChildren(com.google.firebase.database.core.Path path, Node node2) {
        EmptyNode immediateChild;
        com.google.firebase.database.core.CompoundWrite visibleWrites;
        boolean next;
        Node completeNode;
        Node apply;
        Node node;
        int i;
        ChildKey name;
        boolean obj7;
        Iterator obj8;
        immediateChild = EmptyNode.Empty();
        completeNode = this.visibleWrites.getCompleteNode(path);
        if (completeNode != null && !completeNode.isLeafNode()) {
            if (!completeNode.isLeafNode()) {
                obj7 = completeNode.iterator();
                for (NamedNode obj8 : obj7) {
                    immediateChild = immediateChild.updateImmediateChild(obj8.getName(), obj8.getNode());
                }
            }
            return immediateChild;
        }
        obj7 = this.visibleWrites.childCompoundWrite(path);
        obj8 = node2.iterator();
        for (NamedNode next2 : obj8) {
            ChildKey[] arr = new ChildKey[1];
            Path path2 = new Path(arr);
            immediateChild = immediateChild.updateImmediateChild(next2.getName(), obj7.childCompoundWrite(path2).apply(next2.getNode()));
        }
        obj7 = obj7.getCompleteChildren().iterator();
        for (NamedNode obj8 : obj7) {
            immediateChild = immediateChild.updateImmediateChild(obj8.getName(), obj8.getNode());
        }
        return immediateChild;
    }

    public Node calcEventCacheAfterServerOverwrite(com.google.firebase.database.core.Path path, com.google.firebase.database.core.Path path2, Node node3, Node node4) {
        int obj4;
        if (node3 == null) {
            if (node4 != null) {
                obj4 = 1;
            } else {
                obj4 = 0;
            }
        } else {
        }
        Utilities.hardAssert(obj4, "Either existingEventSnap or existingServerSnap must exist");
        com.google.firebase.database.core.Path obj2 = path.child(path2);
        if (this.visibleWrites.hasCompleteWrite(obj2)) {
            return null;
        }
        obj2 = this.visibleWrites.childCompoundWrite(obj2);
        if (obj2.isEmpty()) {
            return node4.getChild(path2);
        }
        return obj2.apply(node4.getChild(path2));
    }

    public NamedNode calcNextNodeAfterPost(com.google.firebase.database.core.Path path, Node node2, NamedNode namedNode3, boolean z4, Index index5) {
        Node completeNode;
        int i;
        Object obj3;
        Node obj4;
        obj3 = this.visibleWrites.childCompoundWrite(path);
        i = 0;
        if (obj3.getCompleteNode(Path.getEmptyPath()) != null) {
            obj3 = completeNode.iterator();
            while (obj3.hasNext()) {
                obj4 = obj3.next();
                if (index5.compare((NamedNode)obj4, namedNode3, z4) > 0) {
                }
                if (i != 0) {
                } else {
                }
                i = obj4;
                if (index5.compare(obj4, i, z4) < 0) {
                }
            }
        } else {
            if (node2 != null) {
                completeNode = obj3.apply(node2);
            }
        }
        return i;
    }

    public com.google.firebase.database.core.WriteTreeRef childWrites(com.google.firebase.database.core.Path path) {
        WriteTreeRef writeTreeRef = new WriteTreeRef(path, this);
        return writeTreeRef;
    }

    public Node getCompleteWriteData(com.google.firebase.database.core.Path path) {
        return this.visibleWrites.getCompleteNode(path);
    }

    public com.google.firebase.database.core.UserWriteRecord getWrite(long l) {
        Object next;
        int cmp;
        Iterator iterator = this.allWrites.iterator();
        for (UserWriteRecord next : iterator) {
        }
        return null;
    }

    public List<com.google.firebase.database.core.UserWriteRecord> purgeAllWrites() {
        ArrayList arrayList = new ArrayList(this.allWrites);
        this.visibleWrites = CompoundWrite.emptyWrite();
        ArrayList arrayList2 = new ArrayList();
        this.allWrites = arrayList2;
        return arrayList;
    }

    public boolean removeWrite(long l) {
        int write;
        boolean next;
        int visibleWrites;
        int path;
        Object next2;
        int cmp;
        int i;
        Object contains;
        boolean recordContainsPath;
        int obj9;
        Iterator iterator = this.allWrites.iterator();
        visibleWrites = 0;
        path = visibleWrites;
        for (UserWriteRecord next2 : iterator) {
            path++;
        }
        next2 = 0;
        final int obj8 = 1;
        obj9 = next2 != null ? obj8 : visibleWrites;
        Utilities.hardAssert(obj9, "removeWrite called with nonexistent writeId");
        this.allWrites.remove(next2);
        obj9 = next2.isVisible();
        size -= obj8;
        i = visibleWrites;
        while (obj9 != null) {
            if (write >= 0) {
            }
            contains = this.allWrites.get(write);
            if ((UserWriteRecord)contains.isVisible()) {
            }
            write--;
            if (write >= path && recordContainsPath(contains, next2.getPath())) {
            } else {
            }
            if (next2.getPath().contains(contains.getPath())) {
            }
            i = obj8;
            if (recordContainsPath(contains, next2.getPath())) {
            } else {
            }
            obj9 = visibleWrites;
        }
        if (obj9 == null) {
            return visibleWrites;
        }
        if (i != 0) {
            resetTree();
            return obj8;
        }
        if (next2.isOverwrite()) {
            this.visibleWrites = this.visibleWrites.removeWrite(next2.getPath());
        } else {
            obj9 = next2.getMerge().iterator();
            for (Map.Entry next3 : obj9) {
                this.visibleWrites = this.visibleWrites.removeWrite(next2.getPath().child((Path)next3.getKey()));
            }
        }
        return obj8;
    }

    public Node shadowingWrite(com.google.firebase.database.core.Path path) {
        return this.visibleWrites.getCompleteNode(path);
    }
}
