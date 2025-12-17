package androidx.compose.ui.layout;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001:\u0001\nJ\u001c\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0001H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "", "areCompatible", "", "slotId", "reusableSlotId", "getSlotsToRetain", "", "slotIds", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "SlotIdsSet", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SubcomposeSlotReusePolicy {

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010#\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010)\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0019\u0008\u0000\u0012\u0010\u0008\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0002\u0008\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0003J\u0019\u0010\u0012\u001a\u00020\u000b2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0096\u0001J\t\u0010\u0014\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0016H\u0096\u0002J\u0010\u0010\u0017\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\u0018\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0016\u0010\u0018\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u001c\u001a\u00020\u000b2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u000b0\u001aJ\u0016\u0010\u001c\u001a\u00020\u000b2\u000e\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001R\u0016\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u001d", d2 = {"Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "", "", "set", "", "(Ljava/util/Set;)V", "size", "", "getSize", "()I", "add", "", "slotId", "add$ui_release", "clear", "", "contains", "element", "containsAll", "elements", "isEmpty", "iterator", "", "remove", "removeAll", "predicate", "Lkotlin/Function1;", "slotIds", "retainAll", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SlotIdsSet implements Collection<Object>, KMappedMarker {

        public static final int $stable = 8;
        private final Set<Object> set;
        static {
            final int i = 8;
        }

        public SlotIdsSet() {
            final int i = 0;
            super(i, 1, i);
        }

        public SlotIdsSet(Set<Object> set) {
            super();
            this.set = set;
        }

        public SlotIdsSet(Set set, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
            LinkedHashSet obj1;
            if (i2 &= 1 != 0) {
                obj1 = new LinkedHashSet();
            }
            super(obj1);
        }

        @Override // java.util.Collection
        public boolean add(Object element) {
            return add$ui_release(element);
        }

        @Override // java.util.Collection
        public final boolean add$ui_release(Object slotId) {
            return this.set.add(slotId);
        }

        public boolean addAll(Collection<? extends Object> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.Collection
        public final void clear() {
            this.set.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object object) {
            return this.set.contains(object);
        }

        public boolean containsAll(Collection<? extends Object> collection) {
            return this.set.containsAll(collection);
        }

        @Override // java.util.Collection
        public int getSize() {
            return this.set.size();
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return this.set.isEmpty();
        }

        public Iterator<Object> iterator() {
            return this.set.iterator();
        }

        @Override // java.util.Collection
        public final boolean remove(Object slotId) {
            return this.set.remove(slotId);
        }

        public final boolean removeAll(Collection<? extends Object> slotIds) {
            return this.set.remove(slotIds);
        }

        public final boolean removeAll(Function1<Object, Boolean> predicate) {
            return CollectionsKt.removeAll((Iterable)this.set, predicate);
        }

        public boolean removeIf(Predicate<? super Object> predicate) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public final boolean retainAll(Collection<? extends Object> slotIds) {
            return this.set.retainAll(slotIds);
        }

        public final boolean retainAll(Function1<Object, Boolean> predicate) {
            return CollectionsKt.retainAll((Iterable)this.set, predicate);
        }

        @Override // java.util.Collection
        public final int size() {
            return getSize();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.toArray((Collection)this);
        }

        public <T> T[] toArray(T[] tArr) {
            return CollectionToArray.toArray((Collection)this, tArr);
        }
    }
    public abstract boolean areCompatible(Object object, Object object2);

    public abstract void getSlotsToRetain(androidx.compose.ui.layout.SubcomposeSlotReusePolicy.SlotIdsSet subcomposeSlotReusePolicy$SlotIdsSet);
}
