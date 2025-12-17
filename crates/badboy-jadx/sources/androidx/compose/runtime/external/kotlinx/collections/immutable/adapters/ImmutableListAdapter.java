package androidx.compose.runtime.external.kotlinx.collections.immutable.adapters;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0002\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H\u0096\u0001J\u0013\u0010\u0011\u001a\u00020\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0002J\u0016\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0003¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0007H\u0016J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0019J\t\u0010\u001a\u001a\u00020\u000bH\u0096\u0001J\u000f\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001cH\u0096\u0003J\u0016\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0002\u0010\u0019J\u000f\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001fH\u0096\u0001J\u0017\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0096\u0001J\u001e\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0016J\u0008\u0010#\u001a\u00020$H\u0016R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006%", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/adapters/ImmutableListAdapter;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "", "impl", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "equals", "other", "", "get", "index", "(I)Ljava/lang/Object;", "hashCode", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImmutableListAdapter<E>  implements ImmutableList<E>, List<E>, KMappedMarker {

    public static final int $stable = 8;
    private final List<E> impl;
    static {
        final int i = 8;
    }

    public ImmutableListAdapter(List<? extends E> impl) {
        super();
        this.impl = impl;
    }

    public void add(int i, E e2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean add(E e) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int i, Collection<? extends E> collection2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends E> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public boolean contains(Object object) {
        return this.impl.contains(object);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.impl.containsAll(collection);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public boolean equals(Object other) {
        return this.impl.equals(other);
    }

    public E get(int i) {
        return this.impl.get(i);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public int getSize() {
        return this.impl.size();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public int hashCode() {
        return this.impl.hashCode();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public int indexOf(Object object) {
        return this.impl.indexOf(object);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public boolean isEmpty() {
        return this.impl.isEmpty();
    }

    public Iterator<E> iterator() {
        return this.impl.iterator();
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public int lastIndexOf(Object object) {
        return this.impl.lastIndexOf(object);
    }

    public ListIterator<E> listIterator() {
        return this.impl.listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return this.impl.listIterator(i);
    }

    public E remove(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public boolean remove(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void replaceAll(UnaryOperator<E> unaryOperator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public E set(int i, E e2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public final int size() {
        return getSize();
    }

    public void sort(Comparator<? super E> comparator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        ImmutableListAdapter immutableListAdapter = new ImmutableListAdapter(this.impl.subList(fromIndex, toIndex));
        return (ImmutableList)immutableListAdapter;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public List subList(int fromIndex, int toIndex) {
        return (List)subList(fromIndex, toIndex);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList
    public String toString() {
        return this.impl.toString();
    }
}
