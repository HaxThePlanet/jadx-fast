package androidx.compose.runtime.collection;

import androidx.collection.ScatterSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010(\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\rH\u0016J\u000f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0002R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0008\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/collection/ScatterSetWrapper;", "T", "", "set", "Landroidx/collection/ScatterSet;", "(Landroidx/collection/ScatterSet;)V", "getSet$runtime_release", "()Landroidx/collection/ScatterSet;", "size", "", "getSize", "()I", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "elements", "", "isEmpty", "iterator", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ScatterSetWrapper<T>  implements Set<T>, KMappedMarker {

    public static final int $stable = 8;
    private final ScatterSet<T> set;
    static {
        final int i = 8;
    }

    public ScatterSetWrapper(ScatterSet<T> set) {
        super();
        this.set = set;
    }

    public boolean add(T t) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends T> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Set
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.Set
    public boolean contains(Object element) {
        return this.set.contains(element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        boolean iterator;
        int i;
        boolean next;
        boolean it;
        int i2;
        ScatterSet set;
        final Object obj = elements;
        final int i3 = 0;
        i = 1;
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

    public final ScatterSet<T> getSet$runtime_release() {
        return this.set;
    }

    @Override // java.util.Set
    public int getSize() {
        return this.set.getSize();
    }

    @Override // java.util.Set
    public boolean isEmpty() {
        return this.set.isEmpty();
    }

    public Iterator<T> iterator() {
        ScatterSetWrapper.iterator.1 anon = new ScatterSetWrapper.iterator.1(this, 0);
        return SequencesKt.iterator((Function2)anon);
    }

    @Override // java.util.Set
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

    @Override // java.util.Set
    public final int size() {
        return getSize();
    }

    @Override // java.util.Set
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }
}
