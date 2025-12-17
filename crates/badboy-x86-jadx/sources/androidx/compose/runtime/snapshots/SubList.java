package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\t\n\u0002\u0010)\n\u0002\u0008\u0002\n\u0002\u0010+\n\u0002\u0008\t\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B#\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u0015\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u001d\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00062\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u0018\u001a\u00020\u00122\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u0015H\u0016J\u0016\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001d\u001a\u00020\u00122\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0016\u0010\u001e\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0096\u0002¢\u0006\u0002\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u0008\u0010\"\u001a\u00020\u0012H\u0016J\u000f\u0010#\u001a\u0008\u0012\u0004\u0012\u00028\u00000$H\u0096\u0002J\u0015\u0010%\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010!J\u000e\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000'H\u0016J\u0016\u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000'2\u0006\u0010\u0016\u001a\u00020\u0006H\u0016J\u0015\u0010(\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0014J\u0016\u0010)\u001a\u00020\u00122\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0002\u0010\u001fJ\u0016\u0010+\u001a\u00020\u00122\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001aH\u0016J\u001e\u0010,\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010-J\u001e\u0010.\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0008\u0010/\u001a\u00020\u0015H\u0002R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001e\u0010\r\u001a\u00020\u00062\u0006\u0010\u000c\u001a\u00020\u0006@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060", d2 = {"Landroidx/compose/runtime/snapshots/SubList;", "T", "", "parentList", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "fromIndex", "", "toIndex", "(Landroidx/compose/runtime/snapshots/SnapshotStateList;II)V", "offset", "getParentList", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "<set-?>", "size", "getSize", "()I", "structure", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "clear", "contains", "containsAll", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "subList", "validateModification", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SubList<T>  implements List<T>, KMutableList {

    private final int offset;
    private final androidx.compose.runtime.snapshots.SnapshotStateList<T> parentList;
    private int size;
    private int structure;
    public SubList(androidx.compose.runtime.snapshots.SnapshotStateList<T> parentList, int fromIndex, int toIndex) {
        super();
        this.parentList = parentList;
        this.offset = fromIndex;
        this.structure = this.parentList.getStructure$runtime_release();
        this.size = toIndex - fromIndex;
    }

    private final void validateModification() {
        if (this.parentList.getStructure$runtime_release() != this.structure) {
        } else {
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public void add(int index, T element) {
        validateModification();
        this.parentList.add(offset += index, element);
        this.size = size++;
        this.structure = this.parentList.getStructure$runtime_release();
    }

    public boolean add(T element) {
        validateModification();
        this.parentList.add(offset += size2, element);
        int i3 = 1;
        this.size = size += i3;
        this.structure = this.parentList.getStructure$runtime_release();
        return i3;
    }

    public boolean addAll(int index, Collection<? extends T> elements) {
        int structure$runtime_release;
        int size;
        validateModification();
        boolean all = this.parentList.addAll(offset += index, elements);
        if (all) {
            this.size = size2 += size;
            this.structure = this.parentList.getStructure$runtime_release();
        }
        return all;
    }

    public boolean addAll(Collection<? extends T> elements) {
        return addAll(size(), elements);
    }

    @Override // java.util.List
    public void clear() {
        int structure$runtime_release;
        int offset;
        int i;
        int size;
        if (size() > 0) {
            validateModification();
            this.parentList.removeRange(this.offset, offset2 += size);
            this.size = 0;
            this.structure = this.parentList.getStructure$runtime_release();
        }
    }

    @Override // java.util.List
    public boolean contains(Object element) {
        int i;
        i = indexOf(element) >= 0 ? 1 : 0;
        return i;
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        boolean iterator;
        int i;
        boolean next;
        boolean it;
        int i2;
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

    public T get(int index) {
        validateModification();
        SnapshotStateListKt.access$validateRange(index, size());
        return this.parentList.get(offset += index);
    }

    public final androidx.compose.runtime.snapshots.SnapshotStateList<T> getParentList() {
        return this.parentList;
    }

    @Override // java.util.List
    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        int nextInt;
        int i2;
        int i;
        boolean equal;
        validateModification();
        int i4 = 0;
        Iterator iterator = (Iterable)RangesKt.until(this.offset, offset2 += size).iterator();
        while (iterator.hasNext()) {
            i2 = nextInt;
            i = 0;
        }
        return -1;
    }

    @Override // java.util.List
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    public Iterator<T> iterator() {
        return (Iterator)listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        int index;
        int equal;
        validateModification();
        i--;
        while (index >= this.offset) {
            index--;
        }
        return -1;
    }

    public ListIterator<T> listIterator() {
        return listIterator(0);
    }

    public ListIterator<T> listIterator(int index) {
        validateModification();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = index + -1;
        SubList.listIterator.1 anon = new SubList.listIterator.1(intRef, this);
        return (ListIterator)anon;
    }

    public final T remove(int index) {
        return removeAt(index);
    }

    @Override // java.util.List
    public boolean remove(Object element) {
        int i;
        final int indexOf = indexOf(element);
        i = indexOf >= 0 ? 1 : 0;
        return i;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        int removed;
        Object next;
        int i;
        removed = 0;
        final Iterator iterator = elements.iterator();
        while (iterator.hasNext()) {
            if (!remove(iterator.next())) {
            } else {
            }
            i = 1;
            removed = i;
            if (removed != 0) {
            } else {
            }
            i = 0;
        }
        return removed;
    }

    public T removeAt(int index) {
        validateModification();
        Object remove = this.parentList.remove(offset += index);
        Object obj = remove;
        final int i2 = 0;
        this.size = size--;
        this.structure = this.parentList.getStructure$runtime_release();
        return remove;
    }

    public boolean retainAll(Collection<? extends Object> elements) {
        int offset;
        int i;
        validateModification();
        int retainAllInRange$runtime_release = this.parentList.retainAllInRange$runtime_release(elements, this.offset, offset2 += size2);
        if (retainAllInRange$runtime_release > 0) {
            this.structure = this.parentList.getStructure$runtime_release();
            this.size = size -= retainAllInRange$runtime_release;
        }
        i = retainAllInRange$runtime_release > 0 ? 1 : 0;
        return i;
    }

    public T set(int index, T element) {
        SnapshotStateListKt.access$validateRange(index, size());
        validateModification();
        this.structure = this.parentList.getStructure$runtime_release();
        return this.parentList.set(offset += index, element);
    }

    @Override // java.util.List
    public final int size() {
        return getSize();
    }

    public List<T> subList(int fromIndex, int toIndex) {
        int i;
        int $i$a$RequirePreconditionSubList$subList$1;
        int i2 = 0;
        if (fromIndex >= 0 && fromIndex <= toIndex) {
            $i$a$RequirePreconditionSubList$subList$1 = fromIndex <= toIndex ? i : i2;
        } else {
        }
        if ($i$a$RequirePreconditionSubList$subList$1 != 0 && toIndex <= size()) {
            if (toIndex <= size()) {
            } else {
                i = i2;
            }
        } else {
        }
        int i3 = 0;
        if (i == 0) {
            int i5 = 0;
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        validateModification();
        SubList subList = new SubList(this.parentList, offset += fromIndex, offset2 += toIndex);
        return (List)subList;
    }

    @Override // java.util.List
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }
}
