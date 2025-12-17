package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.snapshots.SnapshotStateList;
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
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0005\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\u0008\u0007\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u0015\u0008\u0002\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0003J\u0017\u0010\u000e\u001a\u00020\u000c2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0010H\u0096\u0001J\u0011\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0008H\u0096\u0003J\u0011\u0010\u0013\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000cH\u0096\u0001J\u000f\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0016H\u0096\u0003J\u0011\u0010\u0017\u001a\u00020\u00082\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0001J\u000f\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0019H\u0096\u0001J\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u0008H\u0096\u0001J\u0015\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0000¢\u0006\u0002\u0008\u001dJ\u0015\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0002H\u0000¢\u0006\u0002\u0008\u001fJ\u001f\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010!\u001a\u00020\u00082\u0006\u0010\"\u001a\u00020\u0008H\u0096\u0001R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u0008X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006$", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList;", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "()V", "items", "", "(Ljava/util/List;)V", "size", "", "getSize", "()I", "contains", "", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "pin", "", "item", "pin$foundation_release", "release", "release$foundation_release", "subList", "fromIndex", "toIndex", "PinnedItem", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyLayoutPinnedItemList implements List<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem>, KMappedMarker {

    public static final int $stable = 8;
    private final List<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> items;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u0008w\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0001\u0001\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnedItemList$PinnedItem;", "", "index", "", "getIndex", "()I", "key", "getKey", "()Ljava/lang/Object;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPinnableItem;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface PinnedItem {
        public abstract int getIndex();

        public abstract Object getKey();
    }
    static {
        final int i = 8;
    }

    public LazyLayoutPinnedItemList() {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        super((List)snapshotStateList);
    }

    private LazyLayoutPinnedItemList(List<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> items) {
        super();
        this.items = items;
    }

    @Override // java.util.List
    public void add(int i, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem lazyLayoutPinnedItemList$PinnedItem2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public void add(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean add(androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem lazyLayoutPinnedItemList$PinnedItem) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int i, Collection<? extends androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> collection2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean contains(androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem lazyLayoutPinnedItemList$PinnedItem) {
        return this.items.contains(pinnedItem);
    }

    @Override // java.util.List
    public final boolean contains(Object element) {
        if (!element instanceof LazyLayoutPinnedItemList.PinnedItem) {
            return 0;
        }
        return contains((LazyLayoutPinnedItemList.PinnedItem)element);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.items.containsAll(collection);
    }

    @Override // java.util.List
    public androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem get(int i) {
        return (LazyLayoutPinnedItemList.PinnedItem)this.items.get(i);
    }

    @Override // java.util.List
    public Object get(int index) {
        return get(index);
    }

    @Override // java.util.List
    public int getSize() {
        return this.items.size();
    }

    @Override // java.util.List
    public int indexOf(androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem lazyLayoutPinnedItemList$PinnedItem) {
        return this.items.indexOf(pinnedItem);
    }

    @Override // java.util.List
    public final int indexOf(Object element) {
        if (!element instanceof LazyLayoutPinnedItemList.PinnedItem) {
            return -1;
        }
        return indexOf((LazyLayoutPinnedItemList.PinnedItem)element);
    }

    @Override // java.util.List
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    public Iterator<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> iterator() {
        return this.items.iterator();
    }

    @Override // java.util.List
    public int lastIndexOf(androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem lazyLayoutPinnedItemList$PinnedItem) {
        return this.items.lastIndexOf(pinnedItem);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object element) {
        if (!element instanceof LazyLayoutPinnedItemList.PinnedItem) {
            return -1;
        }
        return lastIndexOf((LazyLayoutPinnedItemList.PinnedItem)element);
    }

    public ListIterator<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> listIterator() {
        return this.items.listIterator();
    }

    public ListIterator<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> listIterator(int i) {
        return this.items.listIterator(i);
    }

    @Override // java.util.List
    public final void pin$foundation_release(androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem item) {
        this.items.add(item);
    }

    @Override // java.util.List
    public final void release$foundation_release(androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem item) {
        this.items.remove(item);
    }

    @Override // java.util.List
    public androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem remove(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public Object remove(int i) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean remove(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean removeAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void replaceAll(UnaryOperator<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> unaryOperator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem set(int i, androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem lazyLayoutPinnedItemList$PinnedItem2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public Object set(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final int size() {
        return getSize();
    }

    public void sort(Comparator<? super androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> comparator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public List<androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList.PinnedItem> subList(int i, int i2) {
        return this.items.subList(i, i2);
    }

    @Override // java.util.List
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }
}
