package com.google.firebase.database.core.utilities;

import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes2.dex */
public class Tree<T>  {

    private ChildKey name;
    private com.google.firebase.database.core.utilities.TreeNode<T> node;
    private com.google.firebase.database.core.utilities.Tree<T> parent;

    public interface TreeFilter {
        public abstract boolean filterTreeNode(com.google.firebase.database.core.utilities.Tree<T> tree);
    }

    public interface TreeVisitor {
        public abstract void visitTree(com.google.firebase.database.core.utilities.Tree<T> tree);
    }
    public Tree() {
        TreeNode treeNode = new TreeNode();
        final int i = 0;
        super(i, i, treeNode);
    }

    public Tree(ChildKey childKey, com.google.firebase.database.core.utilities.Tree<T> tree2, com.google.firebase.database.core.utilities.TreeNode<T> treeNode3) {
        super();
        this.name = childKey;
        this.parent = tree2;
        this.node = treeNode3;
    }

    private void updateChild(ChildKey childKey, com.google.firebase.database.core.utilities.Tree<T> tree2) {
        boolean children;
        Object obj4;
        children = tree2.isEmpty();
        boolean key = node2.children.containsKey(childKey);
        if (children && key != null) {
            if (key != null) {
                obj4.children.remove(childKey);
                updateParents();
            } else {
                if (!children && key == null) {
                    if (key == null) {
                        node.children.put(childKey, tree2.node);
                        updateParents();
                    }
                }
            }
        } else {
        }
    }

    private void updateParents() {
        ChildKey name;
        final com.google.firebase.database.core.utilities.Tree parent = this.parent;
        if (parent != null) {
            parent.updateChild(this.name, this);
        }
    }

    public boolean forEachAncestor(com.google.firebase.database.core.utilities.Tree.TreeFilter<T> tree$TreeFilter) {
        return forEachAncestor(treeFilter, false);
    }

    public boolean forEachAncestor(com.google.firebase.database.core.utilities.Tree.TreeFilter<T> tree$TreeFilter, boolean z2) {
        boolean filterTreeNode;
        com.google.firebase.database.core.utilities.Tree obj3;
        obj3 = z2 ? this : this.parent;
        while (obj3 != null) {
            obj3 = obj3.parent;
        }
        return 0;
    }

    public void forEachChild(com.google.firebase.database.core.utilities.Tree.TreeVisitor<T> tree$TreeVisitor) {
        int i;
        Object value;
        com.google.firebase.database.core.utilities.Tree tree;
        Object key;
        Object[] array = node.children.entrySet().toArray();
        i = 0;
        for (Object obj : obj0) {
            tree = new Tree((ChildKey)(Map.Entry)obj.getKey(), this, (TreeNode)obj.getValue());
            treeVisitor.visitTree(tree);
        }
    }

    public void forEachDescendant(com.google.firebase.database.core.utilities.Tree.TreeVisitor<T> tree$TreeVisitor) {
        final int i = 0;
        forEachDescendant(treeVisitor, i, i);
    }

    public void forEachDescendant(com.google.firebase.database.core.utilities.Tree.TreeVisitor<T> tree$TreeVisitor, boolean z2) {
        forEachDescendant(treeVisitor, z2, false);
    }

    public void forEachDescendant(com.google.firebase.database.core.utilities.Tree.TreeVisitor<T> tree$TreeVisitor, boolean z2, boolean z3) {
        if (z2 && !z3) {
            if (!z3) {
                treeVisitor.visitTree(this);
            }
        }
        Tree.1 anon = new Tree.1(this, treeVisitor, z3);
        forEachChild(anon);
        if (z2 && z3) {
            if (z3) {
                treeVisitor.visitTree(this);
            }
        }
    }

    public ChildKey getName() {
        return this.name;
    }

    public com.google.firebase.database.core.utilities.Tree<T> getParent() {
        return this.parent;
    }

    public Path getPath() {
        Path emptyPath;
        int i;
        int arr;
        ChildKey name;
        arr = 1;
        if (this.parent != null && this.name != null) {
            if (this.name != null) {
                i = arr;
            }
            Utilities.hardAssert(i);
            return this.parent.getPath().child(this.name);
        }
        if (this.name != null) {
            arr = new ChildKey[arr];
            arr[0] = this.name;
            emptyPath = new Path(arr);
        } else {
            emptyPath = Path.getEmptyPath();
        }
        return emptyPath;
    }

    public T getValue() {
        return node.value;
    }

    public boolean hasChildren() {
        return empty ^= 1;
    }

    public boolean isEmpty() {
        com.google.firebase.database.core.utilities.TreeNode empty;
        int i;
        empty = this.node;
        if (empty.value == null && empty.children.isEmpty()) {
            i = empty.children.isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    public com.google.firebase.database.core.utilities.TreeNode<T> lastNodeOnPath(Path path) {
        com.google.firebase.database.core.utilities.TreeNode node;
        ChildKey front;
        Object obj2;
        Map children;
        Object obj;
        Path obj5;
        node = this.node;
        front = path.getFront();
        while (front != null) {
            if (node.children.containsKey(front)) {
            } else {
            }
            obj2 = 0;
            front = front2;
            node = obj;
            obj2 = node.children.get(front);
        }
        return node;
    }

    public void setValue(T t) {
        node.value = t;
        updateParents();
    }

    public com.google.firebase.database.core.utilities.Tree<T> subTree(Path path) {
        ChildKey front;
        Object obj;
        Object treeNode;
        com.google.firebase.database.core.utilities.Tree tree;
        Path obj5;
        front = path.getFront();
        obj = this;
        while (front != null) {
            if (node.children.containsKey(front)) {
            } else {
            }
            treeNode = new TreeNode();
            tree = new Tree(front, obj, treeNode);
            front = obj5.popFront().getFront();
            obj = tree;
            treeNode = node2.children.get(front);
        }
        return obj;
    }

    public String toString() {
        return toString("");
    }

    String toString(String string) {
        String string2;
        ChildKey name = this.name;
        if (name == null) {
            string2 = "<anon>";
        } else {
            string2 = name.asString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(string2);
        stringBuilder.append("\n");
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(string);
        stringBuilder2.append("\t");
        stringBuilder.append(this.node.toString(stringBuilder2.toString()));
        return stringBuilder.toString();
    }
}
