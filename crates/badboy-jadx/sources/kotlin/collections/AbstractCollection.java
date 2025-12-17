package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010(\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008'\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J\u0016\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000bJ\u0016\u0010\u000c\u001a\u00020\t2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0008\u0010\u000e\u001a\u00020\tH\u0016J\u000f\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0010H¦\u0002J\u0015\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0012H\u0015¢\u0006\u0002\u0010\u0014J'\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0012\"\u0004\u0008\u0001\u0010\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00150\u0012H\u0014¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001a", d2 = {"Lkotlin/collections/AbstractCollection;", "E", "", "()V", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "isEmpty", "iterator", "", "toArray", "", "", "()[Ljava/lang/Object;", "T", "array", "([Ljava/lang/Object;)[Ljava/lang/Object;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractCollection<E>  implements Collection<E>, KMappedMarker {
    public boolean add(E e) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends E> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean contains(E element) {
        boolean iterator;
        int i;
        boolean next;
        boolean it;
        int i2;
        final Object obj = this;
        final int i3 = 0;
        i = 0;
        if (obj instanceof Collection != null && (Collection)(Iterable)obj.isEmpty()) {
            if ((Collection)obj.isEmpty()) {
            } else {
                iterator = obj.iterator();
                for (Object next : iterator) {
                    i2 = 0;
                }
            }
        } else {
        }
        return i;
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Iterator iterator;
        int i2;
        boolean next;
        boolean it;
        int i;
        Intrinsics.checkNotNullParameter(elements, "elements");
        Object obj = elements;
        final int i3 = 0;
        i2 = 1;
        if ((Collection)(Iterable)obj.isEmpty()) {
        } else {
            iterator = obj.iterator();
            for (Object next : iterator) {
                i = 0;
            }
        }
        return i2;
    }

    @Override // java.util.Collection
    public abstract int getSize();

    @Override // java.util.Collection
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    public abstract Iterator<E> iterator();

    @Override // java.util.Collection
    public boolean remove(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Collection
    public final int size() {
        return getSize();
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return CollectionToArray.toArray((Collection)this, array);
    }

    @Override // java.util.Collection
    public String toString() {
        AbstractCollection.toString.1 anon = new AbstractCollection.toString.1(this);
        return CollectionsKt.joinToString$default((Iterable)this, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, 0, (Function1)anon, 24, 0);
    }
}
