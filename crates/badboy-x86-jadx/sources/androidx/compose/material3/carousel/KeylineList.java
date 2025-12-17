package androidx.compose.material3.carousel;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0015\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000c\n\u0002\u0010(\n\u0002\u0008\u0003\n\u0002\u0010*\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000 =2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001=B\u0015\u0008\u0000\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0003J\u0017\u0010!\u001a\u00020\u001f2\u000c\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00020#H\u0096\u0001J\u0013\u0010$\u001a\u00020\u001f2\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\u000e\u0010'\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020(J\u0011\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\tH\u0096\u0003J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020(J\u000e\u0010-\u001a\u00020\u00022\u0006\u0010,\u001a\u00020(J\u0008\u0010.\u001a\u00020\tH\u0016J\u0011\u0010/\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0001J\t\u00100\u001a\u00020\u001fH\u0096\u0001J\u0006\u00101\u001a\u00020\u001fJ\u000e\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020(J\u000f\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u000205H\u0096\u0003J\u000e\u00106\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020(J\u0011\u00107\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u0002H\u0096\u0001J\u000f\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u000209H\u0096\u0001J\u0017\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u0002092\u0006\u0010*\u001a\u00020\tH\u0096\u0001J\u001f\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010;\u001a\u00020\t2\u0006\u0010<\u001a\u00020\tH\u0096\u0001R\u0011\u0010\u0005\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u000bR\u0011\u0010\u0014\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0007R\u0011\u0010\u0016\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u000bR\u0011\u0010\u0018\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u000bR\u0012\u0010\u001c\u001a\u00020\tX\u0096\u0005¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u000b¨\u0006>", d2 = {"Landroidx/compose/material3/carousel/KeylineList;", "", "Landroidx/compose/material3/carousel/Keyline;", "keylines", "(Ljava/util/List;)V", "firstFocal", "getFirstFocal", "()Landroidx/compose/material3/carousel/Keyline;", "firstFocalIndex", "", "getFirstFocalIndex", "()I", "firstNonAnchor", "getFirstNonAnchor", "firstNonAnchorIndex", "getFirstNonAnchorIndex", "lastFocal", "getLastFocal", "lastFocalIndex", "getLastFocalIndex", "lastNonAnchor", "getLastNonAnchor", "lastNonAnchorIndex", "getLastNonAnchorIndex", "pivot", "getPivot", "pivotIndex", "getPivotIndex", "size", "getSize", "contains", "", "element", "containsAll", "elements", "", "equals", "other", "", "firstIndexAfterFocalRangeWithSize", "", "get", "index", "getKeylineAfter", "unadjustedOffset", "getKeylineBefore", "hashCode", "indexOf", "isEmpty", "isFirstFocalItemAtStartOfContainer", "isLastFocalItemAtEndOfContainer", "carouselMainAxisSize", "iterator", "", "lastIndexBeforeFocalRangeWithSize", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeylineList implements List<androidx.compose.material3.carousel.Keyline>, KMappedMarker {

    public static final int $stable = 8;
    public static final androidx.compose.material3.carousel.KeylineList.Companion Companion;
    private static final androidx.compose.material3.carousel.KeylineList Empty;
    private final List<androidx.compose.material3.carousel.Keyline> $$delegate_0;
    private final int firstFocalIndex = -1;
    private final int firstNonAnchorIndex = -1;
    private final int lastFocalIndex;
    private final int lastNonAnchorIndex = -1;
    private final int pivotIndex = -1;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/material3/carousel/KeylineList$Companion;", "", "()V", "Empty", "Landroidx/compose/material3/carousel/KeylineList;", "getEmpty", "()Landroidx/compose/material3/carousel/KeylineList;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.material3.carousel.KeylineList getEmpty() {
            return KeylineList.access$getEmpty$cp();
        }
    }
    static {
        KeylineList.Companion companion = new KeylineList.Companion(0);
        KeylineList.Companion = companion;
        int i = 8;
        KeylineList keylineList = new KeylineList(CollectionsKt.emptyList());
        KeylineList.Empty = keylineList;
    }

    public KeylineList(List<androidx.compose.material3.carousel.Keyline> keylines) {
        int index$iv2;
        int index$iv3;
        int index$iv;
        Iterator iterator;
        Iterator it;
        Object next3;
        boolean next;
        boolean next2;
        boolean next4;
        int nextIndex;
        boolean it2;
        int i;
        boolean anchor;
        super();
        this.$$delegate_0 = keylines;
        int i2 = 0;
        index$iv2 = 0;
        Iterator iterator2 = (List)this.iterator();
        nextIndex = -1;
        while (iterator2.hasNext()) {
            i = 0;
            if ((Keyline)iterator2.next().isPivot()) {
                break;
            }
            index$iv2++;
            nextIndex = -1;
        }
        int index$iv4 = nextIndex;
        int i3 = 0;
        index$iv3 = 0;
        iterator = (List)this.iterator();
        while (iterator.hasNext()) {
            i = 0;
            if (!(Keyline)iterator.next().isAnchor()) {
                break;
            }
            index$iv3++;
        }
        int index$iv5 = nextIndex;
        Object obj3 = this;
        int i4 = 0;
        ListIterator listIterator = obj3.listIterator((List)obj3.size());
        while (listIterator.hasPrevious()) {
            next2 = false;
            if (!(Keyline)listIterator.previous().isAnchor()) {
                break;
            }
        }
        int i7 = nextIndex;
        int i5 = 0;
        index$iv = 0;
        it = (List)this.iterator();
        while (it.hasNext()) {
            i = 0;
            if ((Keyline)it.next().isFocal()) {
                break;
            }
            index$iv++;
        }
        int index$iv6 = nextIndex;
        Object obj5 = this;
        int i6 = 0;
        ListIterator listIterator2 = obj5.listIterator((List)obj5.size());
        while (listIterator2.hasPrevious()) {
            next4 = false;
        }
        this.lastFocalIndex = nextIndex;
    }

    public static final androidx.compose.material3.carousel.KeylineList access$getEmpty$cp() {
        return KeylineList.Empty;
    }

    @Override // java.util.List
    public void add(int i, androidx.compose.material3.carousel.Keyline keyline2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public void add(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean add(androidx.compose.material3.carousel.Keyline keyline) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int i, Collection<? extends androidx.compose.material3.carousel.Keyline> collection2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends androidx.compose.material3.carousel.Keyline> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean contains(androidx.compose.material3.carousel.Keyline keyline) {
        return this.$$delegate_0.contains(keyline);
    }

    @Override // java.util.List
    public final boolean contains(Object element) {
        if (!element instanceof Keyline) {
            return 0;
        }
        return contains((Keyline)element);
    }

    public boolean containsAll(Collection<? extends Object> collection) {
        return this.$$delegate_0.containsAll(collection);
    }

    @Override // java.util.List
    public boolean equals(Object other) {
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        int i2;
        boolean equal;
        final int i3 = 1;
        if (this == other) {
            return i3;
        }
        final int i4 = 0;
        if (other instanceof KeylineList == null) {
            return i4;
        }
        if (size() != (KeylineList)other.size()) {
            return i4;
        }
        Object obj3 = this;
        int i5 = 0;
        index$iv = 0;
        while (index$iv < (List)obj3.size()) {
            i2 = 0;
            index$iv++;
        }
        return i3;
    }

    @Override // java.util.List
    public final int firstIndexAfterFocalRangeWithSize(float size) {
        int lastIndex;
        Object element$iv;
        int intValue;
        int i;
        int i2;
        IntRange intRange = new IntRange(this.lastFocalIndex, CollectionsKt.getLastIndex((List)this));
        final int i3 = 0;
        final Iterator iterator = (Iterable)intRange.iterator();
        while (iterator.hasNext()) {
            i = 0;
            if (Float.compare(size2, size) == 0) {
            } else {
            }
            i2 = 0;
            i2 = 1;
        }
        element$iv = 0;
        if ((Integer)element$iv != 0) {
            lastIndex = (Integer)element$iv.intValue();
        } else {
            lastIndex = CollectionsKt.getLastIndex((List)this);
        }
        return lastIndex;
    }

    @Override // java.util.List
    public androidx.compose.material3.carousel.Keyline get(int i) {
        return (Keyline)this.$$delegate_0.get(i);
    }

    @Override // java.util.List
    public Object get(int index) {
        return get(index);
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getFirstFocal() {
        Object orNull = CollectionsKt.getOrNull((List)this, this.firstFocalIndex);
        if ((Keyline)orNull == null) {
        } else {
            return (Keyline)orNull;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("All KeylineLists must have at least one focal keyline");
        throw noSuchElementException;
    }

    @Override // java.util.List
    public final int getFirstFocalIndex() {
        return this.firstFocalIndex;
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getFirstNonAnchor() {
        return get(this.firstNonAnchorIndex);
    }

    @Override // java.util.List
    public final int getFirstNonAnchorIndex() {
        return this.firstNonAnchorIndex;
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getKeylineAfter(float unadjustedOffset) {
        Object last;
        int index$iv$iv;
        Object obj2;
        Object obj;
        int i;
        Object obj3;
        int i2;
        int i3;
        final int i4 = 0;
        final Object obj4 = last;
        final int i5 = 0;
        index$iv$iv = 0;
        while (index$iv$iv < obj4.size()) {
            i = 0;
            i2 = 0;
            if (Float.compare(unadjustedOffset2, unadjustedOffset) >= 0) {
            } else {
            }
            i3 = 0;
            index$iv$iv++;
            i3 = 1;
        }
        obj = 0;
        if ((Keyline)obj == null) {
            obj = last;
        }
        return obj;
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getKeylineBefore(float unadjustedOffset) {
        int i2;
        int i;
        androidx.compose.material3.carousel.Keyline keyline;
        int cmp;
        if (size-- >= 0) {
        }
        return (Keyline)CollectionsKt.first((List)this);
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getLastFocal() {
        Object orNull = CollectionsKt.getOrNull((List)this, this.lastFocalIndex);
        if ((Keyline)orNull == null) {
        } else {
            return (Keyline)orNull;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("All KeylineLists must have at least one focal keyline");
        throw noSuchElementException;
    }

    @Override // java.util.List
    public final int getLastFocalIndex() {
        return this.lastFocalIndex;
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getLastNonAnchor() {
        return get(this.lastNonAnchorIndex);
    }

    @Override // java.util.List
    public final int getLastNonAnchorIndex() {
        return this.lastNonAnchorIndex;
    }

    @Override // java.util.List
    public final androidx.compose.material3.carousel.Keyline getPivot() {
        return get(this.pivotIndex);
    }

    @Override // java.util.List
    public final int getPivotIndex() {
        return this.pivotIndex;
    }

    @Override // java.util.List
    public int getSize() {
        return this.$$delegate_0.size();
    }

    @Override // java.util.List
    public int hashCode() {
        int result;
        int index$iv;
        Object obj2;
        Object obj;
        int i;
        int i2;
        result = 0;
        final List list = this;
        final int i3 = 0;
        index$iv = 0;
        while (index$iv < (List)list.size()) {
            i = 0;
            result += i2;
            index$iv++;
        }
        return result;
    }

    @Override // java.util.List
    public int indexOf(androidx.compose.material3.carousel.Keyline keyline) {
        return this.$$delegate_0.indexOf(keyline);
    }

    @Override // java.util.List
    public final int indexOf(Object element) {
        if (!element instanceof Keyline) {
            return -1;
        }
        return indexOf((Keyline)element);
    }

    @Override // java.util.List
    public boolean isEmpty() {
        return this.$$delegate_0.isEmpty();
    }

    @Override // java.util.List
    public final boolean isFirstFocalItemAtStartOfContainer() {
        int equal;
        int i;
        float firstNonAnchor;
        if (Float.compare(i2, i4) >= 0 && Intrinsics.areEqual(getFirstFocal(), getFirstNonAnchor())) {
            i = Intrinsics.areEqual(getFirstFocal(), getFirstNonAnchor()) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.util.List
    public final boolean isLastFocalItemAtEndOfContainer(float carouselMainAxisSize) {
        int equal;
        int i;
        float lastNonAnchor;
        if (Float.compare(i2, carouselMainAxisSize) <= 0 && Intrinsics.areEqual(getLastFocal(), getLastNonAnchor())) {
            i = Intrinsics.areEqual(getLastFocal(), getLastNonAnchor()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public Iterator<androidx.compose.material3.carousel.Keyline> iterator() {
        return this.$$delegate_0.iterator();
    }

    @Override // java.util.List
    public final int lastIndexBeforeFocalRangeWithSize(float size) {
        int intValue2;
        Object element$iv;
        int intValue;
        int i;
        int i2;
        int i4 = 1;
        final int i5 = 0;
        final int i6 = 0;
        final Iterator iterator = (Iterable)RangesKt.downTo(firstFocalIndex -= i4, i5).iterator();
        while (iterator.hasNext()) {
            i = 0;
            if (Float.compare(size2, size) == 0) {
            } else {
            }
            i2 = 0;
            i2 = i4;
        }
        element$iv = 0;
        if ((Integer)element$iv != 0) {
            intValue2 = (Integer)element$iv.intValue();
        } else {
            intValue2 = i5;
        }
        return intValue2;
    }

    @Override // java.util.List
    public int lastIndexOf(androidx.compose.material3.carousel.Keyline keyline) {
        return this.$$delegate_0.lastIndexOf(keyline);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object element) {
        if (!element instanceof Keyline) {
            return -1;
        }
        return lastIndexOf((Keyline)element);
    }

    public ListIterator<androidx.compose.material3.carousel.Keyline> listIterator() {
        return this.$$delegate_0.listIterator();
    }

    public ListIterator<androidx.compose.material3.carousel.Keyline> listIterator(int i) {
        return this.$$delegate_0.listIterator(i);
    }

    @Override // java.util.List
    public androidx.compose.material3.carousel.Keyline remove(int i) {
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

    public void replaceAll(UnaryOperator<androidx.compose.material3.carousel.Keyline> unaryOperator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public androidx.compose.material3.carousel.Keyline set(int i, androidx.compose.material3.carousel.Keyline keyline2) {
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

    public void sort(Comparator<? super androidx.compose.material3.carousel.Keyline> comparator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public List<androidx.compose.material3.carousel.Keyline> subList(int i, int i2) {
        return this.$$delegate_0.subList(i, i2);
    }

    @Override // java.util.List
    public Object[] toArray() {
        return CollectionToArray.toArray((Collection)this);
    }

    public <T> T[] toArray(T[] tArr) {
        return CollectionToArray.toArray((Collection)this, tArr);
    }
}
