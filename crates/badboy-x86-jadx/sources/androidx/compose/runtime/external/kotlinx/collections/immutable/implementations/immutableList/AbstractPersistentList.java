package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.ImmutableList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractList;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u001e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0000\n\u0002\u0010*\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008 \u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u000e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0002H\u0016J\u0016\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\r2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u000f\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0096\u0002J\u000e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0016J\u001b\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0016J\u001c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tH\u0016J\u001e\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007H\u0016¨\u0006\u001d", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/AbstractPersistentList;", "E", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "Lkotlin/collections/AbstractList;", "()V", "addAll", "index", "", "c", "", "elements", "clear", "contains", "", "element", "(Ljava/lang/Object;)Z", "containsAll", "iterator", "", "listIterator", "", "remove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "removeAll", "retainAll", "subList", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/ImmutableList;", "fromIndex", "toIndex", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractPersistentList<E>  extends AbstractList<E> implements PersistentList<E> {

    public static final int $stable;
    static {
    }

    @Override // kotlin.collections.AbstractList
    public PersistentCollection addAll(Collection elements) {
        return (PersistentCollection)addAll(elements);
    }

    public PersistentList<E> addAll(int index, Collection<? extends E> c) {
        final int i = 0;
        final PersistentList.Builder builder = (PersistentList)this.builder();
        final int i2 = 0;
        (List)builder.addAll(index, c);
        return builder.build();
    }

    public PersistentList<E> addAll(Collection<? extends E> elements) {
        final int i = 0;
        final PersistentList.Builder builder = (PersistentList)this.builder();
        final int i2 = 0;
        (List)builder.addAll(elements);
        return builder.build();
    }

    @Override // kotlin.collections.AbstractList
    public PersistentCollection clear() {
        return (PersistentCollection)clear();
    }

    public PersistentList<E> clear() {
        return UtilsKt.persistentVectorOf();
    }

    @Override // kotlin.collections.AbstractList
    public boolean contains(Object element) {
        int i;
        i = indexOf(element) != -1 ? 1 : 0;
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

    public Iterator<E> iterator() {
        return (Iterator)listIterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // kotlin.collections.AbstractList
    public PersistentCollection remove(Object element) {
        return (PersistentCollection)remove(element);
    }

    public PersistentList<E> remove(E element) {
        final int indexOf = indexOf(element);
        if (indexOf != -1) {
            return removeAt(indexOf);
        }
        return (PersistentList)this;
    }

    @Override // kotlin.collections.AbstractList
    public PersistentCollection removeAll(Collection elements) {
        return (PersistentCollection)removeAll(elements);
    }

    public PersistentList<E> removeAll(Collection<? extends E> elements) {
        AbstractPersistentList.removeAll.1 anon = new AbstractPersistentList.removeAll.1(elements);
        return removeAll((Function1)anon);
    }

    @Override // kotlin.collections.AbstractList
    public PersistentCollection retainAll(Collection elements) {
        return (PersistentCollection)retainAll(elements);
    }

    public PersistentList<E> retainAll(Collection<? extends E> elements) {
        AbstractPersistentList.retainAll.1 anon = new AbstractPersistentList.retainAll.1(elements);
        return removeAll((Function1)anon);
    }

    public ImmutableList<E> subList(int fromIndex, int toIndex) {
        return super.subList(fromIndex, toIndex);
    }

    @Override // kotlin.collections.AbstractList
    public List subList(int fromIndex, int toIndex) {
        return (List)subList(fromIndex, toIndex);
    }
}
