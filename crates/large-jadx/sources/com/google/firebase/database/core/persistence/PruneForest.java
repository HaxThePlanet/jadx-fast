package com.google.firebase.database.core.persistence;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor;
import com.google.firebase.database.core.utilities.Predicate;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class PruneForest {

    private static final Predicate<Boolean> KEEP_PREDICATE;
    private static final ImmutableTree<Boolean> KEEP_TREE;
    private static final Predicate<Boolean> PRUNE_PREDICATE;
    private static final ImmutableTree<Boolean> PRUNE_TREE;
    private final ImmutableTree<Boolean> pruneForest;
    static {
        PruneForest.1 anon = new PruneForest.1();
        PruneForest.KEEP_PREDICATE = anon;
        PruneForest.2 anon2 = new PruneForest.2();
        PruneForest.PRUNE_PREDICATE = anon2;
        ImmutableTree immutableTree = new ImmutableTree(Boolean.TRUE);
        PruneForest.PRUNE_TREE = immutableTree;
        ImmutableTree immutableTree2 = new ImmutableTree(Boolean.FALSE);
        PruneForest.KEEP_TREE = immutableTree2;
    }

    public PruneForest() {
        super();
        this.pruneForest = ImmutableTree.emptyInstance();
    }

    private PruneForest(ImmutableTree<Boolean> immutableTree) {
        super();
        this.pruneForest = immutableTree;
    }

    private com.google.firebase.database.core.persistence.PruneForest doAll(Path path, Set<ChildKey> set2, ImmutableTree<Boolean> immutableTree3) {
        ImmutableSortedMap children;
        Object next;
        ImmutableTree subtree = this.pruneForest.subtree(path);
        children = subtree.getChildren();
        Iterator obj5 = set2.iterator();
        for (ChildKey next : obj5) {
            children = children.insert(next, immutableTree3);
        }
        ImmutableTree immutableTree = new ImmutableTree((Boolean)subtree.getValue(), children);
        obj5 = new PruneForest(this.pruneForest.setTree(path, immutableTree));
        return obj5;
    }

    public boolean affectsPath(Path path) {
        Object rootMostValue;
        int obj2;
        if (this.pruneForest.rootMostValue(path) == null) {
            if (!this.pruneForest.subtree(path).isEmpty()) {
                obj2 = 1;
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public com.google.firebase.database.core.persistence.PruneForest child(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        return child(path.getFront()).child(path.popFront());
    }

    public com.google.firebase.database.core.persistence.PruneForest child(ChildKey childKey) {
        Object emptyPath;
        Object value;
        ImmutableTree obj3;
        obj3 = this.pruneForest.getChild(childKey);
        if (obj3 == null) {
            obj3 = new ImmutableTree((Boolean)this.pruneForest.getValue());
        } else {
            if (obj3.getValue() == null && this.pruneForest.getValue() != null) {
                if (this.pruneForest.getValue() != null) {
                    obj3 = obj3.set(Path.getEmptyPath(), (Boolean)this.pruneForest.getValue());
                }
            }
        }
        PruneForest pruneForest3 = new PruneForest(obj3);
        return pruneForest3;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PruneForest) {
            return i2;
        }
        if (!this.pruneForest.equals(object.pruneForest)) {
            return i2;
        }
        return i;
    }

    public <T> T foldKeptNodes(T t, ImmutableTree.TreeVisitor<Void, T> immutableTree$TreeVisitor2) {
        PruneForest.3 anon = new PruneForest.3(this, treeVisitor2);
        return this.pruneForest.fold(t, anon);
    }

    public int hashCode() {
        return this.pruneForest.hashCode();
    }

    public com.google.firebase.database.core.persistence.PruneForest keep(Path path) {
        if (this.pruneForest.rootMostValueMatching(path, PruneForest.KEEP_PREDICATE) != null) {
            return this;
        }
        PruneForest pruneForest3 = new PruneForest(this.pruneForest.setTree(path, PruneForest.KEEP_TREE));
        return pruneForest3;
    }

    public com.google.firebase.database.core.persistence.PruneForest keepAll(Path path, Set<ChildKey> set2) {
        if (this.pruneForest.rootMostValueMatching(path, PruneForest.KEEP_PREDICATE) != null) {
            return this;
        }
        return doAll(path, set2, PruneForest.KEEP_TREE);
    }

    public com.google.firebase.database.core.persistence.PruneForest prune(Path path) {
        if (this.pruneForest.rootMostValueMatching(path, PruneForest.KEEP_PREDICATE) != null) {
        } else {
            if (this.pruneForest.rootMostValueMatching(path, PruneForest.PRUNE_PREDICATE) != null) {
                return this;
            }
            PruneForest pruneForest4 = new PruneForest(this.pruneForest.setTree(path, PruneForest.PRUNE_TREE));
            return pruneForest4;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Can't prune path that was kept previously!");
        throw obj3;
    }

    public com.google.firebase.database.core.persistence.PruneForest pruneAll(Path path, Set<ChildKey> set2) {
        if (this.pruneForest.rootMostValueMatching(path, PruneForest.KEEP_PREDICATE) != null) {
        } else {
            if (this.pruneForest.rootMostValueMatching(path, PruneForest.PRUNE_PREDICATE) != null) {
                return this;
            }
            return doAll(path, set2, PruneForest.PRUNE_TREE);
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Can't prune path that was kept previously!");
        throw obj3;
    }

    public boolean prunesAnything() {
        return this.pruneForest.containsMatchingValue(PruneForest.PRUNE_PREDICATE);
    }

    public boolean shouldKeep(Path path) {
        Object obj2;
        obj2 = this.pruneForest.leafMostValue(path);
        if (obj2 != null && !(Boolean)obj2.booleanValue()) {
            obj2 = !obj2.booleanValue() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public boolean shouldPruneUnkeptDescendants(Path path) {
        Object obj2;
        obj2 = this.pruneForest.leafMostValue(path);
        if (obj2 != null && (Boolean)obj2.booleanValue()) {
            obj2 = obj2.booleanValue() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{PruneForest:");
        stringBuilder.append(this.pruneForest.toString());
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
