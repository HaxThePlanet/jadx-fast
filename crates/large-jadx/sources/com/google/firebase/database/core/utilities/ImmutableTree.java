package com.google.firebase.database.core.utilities;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedMap.Builder;
import com.google.firebase.database.collection.StandardComparator;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.snapshot.ChildKey;
import java.util.AbstractMap.SimpleImmutableEntry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public final class ImmutableTree<T>  implements Iterable<Map.Entry<Path, T>> {

    private static final com.google.firebase.database.core.utilities.ImmutableTree EMPTY;
    private static final ImmutableSortedMap EMPTY_CHILDREN;
    private final ImmutableSortedMap<ChildKey, com.google.firebase.database.core.utilities.ImmutableTree<T>> children;
    private final T value;

    public interface TreeVisitor {
        public abstract R onNodeValue(Path path, T t2, R r3);
    }
    static {
        ImmutableSortedMap emptyMap = ImmutableSortedMap.Builder.emptyMap(StandardComparator.getComparator(ChildKey.class));
        ImmutableTree.EMPTY_CHILDREN = emptyMap;
        ImmutableTree immutableTree = new ImmutableTree(0, emptyMap);
        ImmutableTree.EMPTY = immutableTree;
    }

    public ImmutableTree(T t) {
        super(t, ImmutableTree.EMPTY_CHILDREN);
    }

    public ImmutableTree(T t, ImmutableSortedMap<ChildKey, com.google.firebase.database.core.utilities.ImmutableTree<T>> immutableSortedMap2) {
        super();
        this.value = t;
        this.children = immutableSortedMap2;
    }

    public static <V> com.google.firebase.database.core.utilities.ImmutableTree<V> emptyInstance() {
        return ImmutableTree.EMPTY;
    }

    private <R> R fold(Path path, com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor<? super T, R> immutableTree$TreeVisitor2, R r3) {
        Path child;
        Object value;
        Object obj6;
        Iterator iterator = this.children.iterator();
        for (Map.Entry next2 : iterator) {
            obj6 = (ImmutableTree)next2.getValue().fold(path.child((ChildKey)next2.getKey()), treeVisitor2, obj6);
        }
        Object value2 = this.value;
        if (value2 != null) {
            obj6 = treeVisitor2.onNodeValue(path, value2, obj6);
        }
        return obj6;
    }

    public boolean containsMatchingValue(com.google.firebase.database.core.utilities.Predicate<? super T> predicate) {
        Object evaluate;
        boolean matchingValue;
        evaluate = this.value;
        final int i = 1;
        if (evaluate != null && predicate.evaluate(evaluate)) {
            if (predicate.evaluate(evaluate)) {
                return i;
            }
        }
        Iterator iterator = this.children.iterator();
        for (Map.Entry next2 : iterator) {
        }
        return 0;
    }

    @Override // java.lang.Iterable
    public boolean equals(Object object) {
        boolean children2;
        Class<com.google.firebase.database.core.utilities.ImmutableTree> obj;
        Object children;
        boolean obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (ImmutableTree.class != object.getClass()) {
            } else {
                ImmutableSortedMap children3 = this.children;
                if (children3 != null) {
                    if (!children3.equals(object.children)) {
                        return i2;
                    }
                } else {
                    if (object.children != null) {
                    }
                }
                Object value = this.value;
                obj5 = object.value;
                if (value != null) {
                    if (!value.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    public Path findRootMostMatchingPath(Path path, com.google.firebase.database.core.utilities.Predicate<? super T> predicate2) {
        Object evaluate;
        Path obj4;
        evaluate = this.value;
        if (evaluate != null && predicate2.evaluate(evaluate)) {
            if (predicate2.evaluate(evaluate)) {
                return Path.getEmptyPath();
            }
        }
        int i = 0;
        if (path.isEmpty()) {
            return i;
        }
        ChildKey front = path.getFront();
        Object obj = this.children.get(front);
        obj4 = (ImmutableTree)obj.findRootMostMatchingPath(path.popFront(), predicate2);
        if (obj != null && obj4 != null) {
            obj4 = obj.findRootMostMatchingPath(path.popFront(), predicate2);
            if (obj4 != null) {
                ChildKey[] arr = new ChildKey[1];
                Path obj5 = new Path(arr);
                return obj5.child(obj4);
            }
        }
        return i;
    }

    @Override // java.lang.Iterable
    public Path findRootMostPathWithValue(Path path) {
        return findRootMostMatchingPath(path, Predicate.TRUE);
    }

    public <R> R fold(R r, com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor<? super T, R> immutableTree$TreeVisitor2) {
        return fold(Path.getEmptyPath(), treeVisitor2, r);
    }

    public void foreach(com.google.firebase.database.core.utilities.ImmutableTree.TreeVisitor<T, Void> immutableTree$TreeVisitor) {
        fold(Path.getEmptyPath(), treeVisitor, 0);
    }

    public T get(Path path) {
        if (path.isEmpty()) {
            return this.value;
        }
        Object obj = this.children.get(path.getFront());
        if ((ImmutableTree)obj != null) {
            return (ImmutableTree)obj.get(path.popFront());
        }
        return 0;
    }

    public com.google.firebase.database.core.utilities.ImmutableTree<T> getChild(ChildKey childKey) {
        Object obj2 = this.children.get(childKey);
        if ((ImmutableTree)obj2 != null) {
            return (ImmutableTree)obj2;
        }
        return ImmutableTree.emptyInstance();
    }

    public ImmutableSortedMap<ChildKey, com.google.firebase.database.core.utilities.ImmutableTree<T>> getChildren() {
        return this.children;
    }

    public T getValue() {
        return this.value;
    }

    @Override // java.lang.Iterable
    public int hashCode() {
        int i;
        int i2;
        Object value = this.value;
        if (value != null) {
            i = value.hashCode();
        } else {
            i = i2;
        }
        final ImmutableSortedMap children = this.children;
        if (children != null) {
            i2 = children.hashCode();
        }
        return i3 += i2;
    }

    @Override // java.lang.Iterable
    public boolean isEmpty() {
        Object value;
        int i;
        if (this.value == null && this.children.isEmpty()) {
            i = this.children.isEmpty() ? 1 : 0;
        } else {
        }
        return i;
    }

    public Iterator<Map.Entry<Path, T>> iterator() {
        ArrayList arrayList = new ArrayList();
        ImmutableTree.2 anon = new ImmutableTree.2(this, arrayList);
        foreach(anon);
        return arrayList.iterator();
    }

    public T leafMostValue(Path path) {
        return leafMostValueMatching(path, Predicate.TRUE);
    }

    public T leafMostValueMatching(Path path, com.google.firebase.database.core.utilities.Predicate<? super T> predicate2) {
        Object evaluate2;
        int value;
        Object obj;
        Object evaluate;
        evaluate2 = this.value;
        if (evaluate2 != null && predicate2.evaluate(evaluate2)) {
            value = predicate2.evaluate(evaluate2) ? this.value : 0;
        } else {
        }
        final Iterator obj4 = path.iterator();
        obj = this;
        for (ChildKey next2 : obj4) {
            obj = obj.children.get(next2);
            evaluate = obj.value;
            if (evaluate != null && predicate2.evaluate(evaluate)) {
            }
            if (predicate2.evaluate(evaluate)) {
            }
            value = obj.value;
        }
        return value;
    }

    public com.google.firebase.database.core.utilities.ImmutableTree<T> remove(Path path) {
        Object value;
        ImmutableSortedMap children;
        ImmutableSortedMap obj3;
        if (path.isEmpty() && this.children.isEmpty()) {
            if (this.children.isEmpty()) {
                return ImmutableTree.emptyInstance();
            }
            obj3 = new ImmutableTree(0, this.children);
            return obj3;
        }
        ChildKey front = path.getFront();
        Object obj = this.children.get(front);
        if ((ImmutableTree)obj != null) {
            obj3 = (ImmutableTree)obj.remove(path.popFront());
            if (obj3.isEmpty()) {
                obj3 = this.children.remove(front);
            } else {
                obj3 = this.children.insert(front, obj3);
            }
            if (this.value == null && obj3.isEmpty()) {
                if (obj3.isEmpty()) {
                    return ImmutableTree.emptyInstance();
                }
            }
            ImmutableTree immutableTree = new ImmutableTree(this.value, obj3);
            return immutableTree;
        }
        return this;
    }

    public T rootMostValue(Path path) {
        return rootMostValueMatching(path, Predicate.TRUE);
    }

    public T rootMostValueMatching(Path path, com.google.firebase.database.core.utilities.Predicate<? super T> predicate2) {
        Object evaluate;
        Object obj;
        Object evaluate2;
        int i;
        evaluate = this.value;
        if (evaluate != null && predicate2.evaluate(evaluate)) {
            if (predicate2.evaluate(evaluate)) {
                return this.value;
            }
        }
        Iterator obj4 = path.iterator();
        obj = this;
        i = 0;
        for (ChildKey next2 : obj4) {
            obj = obj.children.get(next2);
            evaluate2 = obj.value;
            i = 0;
        }
        return i;
    }

    public com.google.firebase.database.core.utilities.ImmutableTree<T> set(Path path, T t2) {
        Object emptyInstance;
        if (path.isEmpty()) {
            ImmutableTree obj3 = new ImmutableTree(t2, this.children);
            return obj3;
        }
        ChildKey front = path.getFront();
        if ((ImmutableTree)this.children.get(front) == null) {
            emptyInstance = ImmutableTree.emptyInstance();
        }
        ImmutableTree obj4 = new ImmutableTree(this.value, this.children.insert(front, emptyInstance.set(path.popFront(), t2)));
        return obj4;
    }

    public com.google.firebase.database.core.utilities.ImmutableTree<T> setTree(Path path, com.google.firebase.database.core.utilities.ImmutableTree<T> immutableTree2) {
        Object emptyInstance;
        ImmutableSortedMap obj3;
        ImmutableSortedMap obj4;
        if (path.isEmpty()) {
            return immutableTree2;
        }
        ChildKey front = path.getFront();
        if ((ImmutableTree)this.children.get(front) == null) {
            emptyInstance = ImmutableTree.emptyInstance();
        }
        obj3 = emptyInstance.setTree(path.popFront(), immutableTree2);
        if (obj3.isEmpty()) {
            obj3 = this.children.remove(front);
        } else {
            obj3 = this.children.insert(front, obj3);
        }
        obj4 = new ImmutableTree(this.value, obj3);
        return obj4;
    }

    public com.google.firebase.database.core.utilities.ImmutableTree<T> subtree(Path path) {
        if (path.isEmpty()) {
            return this;
        }
        Object obj = this.children.get(path.getFront());
        if ((ImmutableTree)obj != null) {
            return (ImmutableTree)obj.subtree(path.popFront());
        }
        return ImmutableTree.emptyInstance();
    }

    @Override // java.lang.Iterable
    public String toString() {
        Object value;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ImmutableTree { value=");
        stringBuilder.append(getValue());
        stringBuilder.append(", children={");
        Iterator iterator = this.children.iterator();
        for (Map.Entry next2 : iterator) {
            stringBuilder.append((ChildKey)next2.getKey().asString());
            stringBuilder.append("=");
            stringBuilder.append(next2.getValue());
        }
        stringBuilder.append("} }");
        return stringBuilder.toString();
    }

    public Collection<T> values() {
        ArrayList arrayList = new ArrayList();
        ImmutableTree.1 anon = new ImmutableTree.1(this, arrayList);
        foreach(anon);
        return arrayList;
    }
}
