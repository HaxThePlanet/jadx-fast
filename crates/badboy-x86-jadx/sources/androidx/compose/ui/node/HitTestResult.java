package androidx.compose.ui.node;

import androidx.compose.ui.Modifier.Node;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u001e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0002=>B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0017J\u0011\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u001b\u001a\u00020\t2\u000c\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u0017H\u0002J\u0015\u0010\u001f\u001a\u00020 H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008!\u0010\"J\u0011\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0007H\u0096\u0002J\u0006\u0010%\u001a\u00020\tJ$\u0010&\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\t2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00170*J,\u0010+\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\t2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00170*J\u0010\u0010.\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u0008\u0010/\u001a\u00020\tH\u0016J\u0016\u00100\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\tJ\u000f\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u000202H\u0096\u0002J\u0010\u00103\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u000e\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u000205H\u0016J\u0016\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u0002052\u0006\u0010$\u001a\u00020\u0007H\u0016J\u0008\u00106\u001a\u00020\u0017H\u0002J\u0017\u00107\u001a\u00020\u00172\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u00170*H\u0086\u0008J,\u00109\u001a\u00020\u00172\u0006\u0010'\u001a\u00020\u00022\u0006\u0010,\u001a\u00020-2\u0006\u0010(\u001a\u00020\t2\u000c\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00170*J\u001e\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0008\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006?", d2 = {"Landroidx/compose/ui/node/HitTestResult;", "", "Landroidx/compose/ui/Modifier$Node;", "()V", "distanceFromEdgeAndInLayer", "", "hitDepth", "", "shouldSharePointerInputWithSibling", "", "getShouldSharePointerInputWithSibling", "()Z", "setShouldSharePointerInputWithSibling", "(Z)V", "<set-?>", "size", "getSize", "()I", "values", "", "", "[Ljava/lang/Object;", "acceptHits", "", "clear", "contains", "element", "containsAll", "elements", "", "ensureContainerSize", "findBestHitDistance", "Landroidx/compose/ui/node/DistanceAndInLayer;", "findBestHitDistance-ptXAw2c", "()J", "get", "index", "hasHit", "hit", "node", "isInLayer", "childHitTest", "Lkotlin/Function0;", "hitInMinimumTouchTarget", "distanceFromEdge", "", "indexOf", "isEmpty", "isHitInMinimumTouchTargetBetter", "iterator", "", "lastIndexOf", "listIterator", "", "resizeToHitDepth", "siblingHits", "block", "speculativeHit", "subList", "fromIndex", "toIndex", "HitTestResultIterator", "SubList", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class HitTestResult implements List<Modifier.Node>, KMappedMarker {

    public static final int $stable = 8;
    private long[] distanceFromEdgeAndInLayer;
    private int hitDepth = -1;
    private boolean shouldSharePointerInputWithSibling = true;
    private int size;
    private Object[] values;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u000fH\u0016J\t\u0010\u0011\u001a\u00020\u0002H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0004H\u0016J\u0008\u0010\u0013\u001a\u00020\u0002H\u0016J\u0008\u0010\u0014\u001a\u00020\u0004H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\t¨\u0006\u0015", d2 = {"Landroidx/compose/ui/node/HitTestResult$HitTestResultIterator;", "", "Landroidx/compose/ui/Modifier$Node;", "index", "", "minIndex", "maxIndex", "(Landroidx/compose/ui/node/HitTestResult;III)V", "getIndex", "()I", "setIndex", "(I)V", "getMaxIndex", "getMinIndex", "hasNext", "", "hasPrevious", "next", "nextIndex", "previous", "previousIndex", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class HitTestResultIterator implements ListIterator<Modifier.Node>, KMappedMarker {

        private int index;
        private final int maxIndex;
        private final int minIndex;
        final androidx.compose.ui.node.HitTestResult this$0;
        public HitTestResultIterator(androidx.compose.ui.node.HitTestResult this$0, int index, int minIndex, int maxIndex) {
            this.this$0 = this$0;
            super();
            this.index = index;
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
        }

        public HitTestResultIterator(androidx.compose.ui.node.HitTestResult hitTestResult, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
            int obj3;
            int obj4;
            int obj5;
            final int i = 0;
            obj3 = i5 & 1 != 0 ? i : obj3;
            obj4 = i5 & 2 != 0 ? i : obj4;
            if (i5 &= 4 != 0) {
                obj5 = hitTestResult.size();
            }
            super(hitTestResult, obj3, obj4, obj5);
        }

        @Override // java.util.ListIterator
        public void add(Modifier.Node modifier$Node) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public void add(Object object) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public final int getIndex() {
            return this.index;
        }

        @Override // java.util.ListIterator
        public final int getMaxIndex() {
            return this.maxIndex;
        }

        @Override // java.util.ListIterator
        public final int getMinIndex() {
            return this.minIndex;
        }

        @Override // java.util.ListIterator
        public boolean hasNext() {
            int i;
            i = this.index < this.maxIndex ? 1 : 0;
            return i;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            int i;
            i = this.index > this.minIndex ? 1 : 0;
            return i;
        }

        @Override // java.util.ListIterator
        public Modifier.Node next() {
            int index = this.index;
            this.index = index + 1;
            Object obj = HitTestResult.access$getValues$p(this.this$0)[index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node)obj;
        }

        @Override // java.util.ListIterator
        public Object next() {
            return next();
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return index -= minIndex;
        }

        @Override // java.util.ListIterator
        public Modifier.Node previous() {
            this.index = index--;
            Object obj = HitTestResult.access$getValues$p(this.this$0)[this.index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node)obj;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            return previous();
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return i--;
        }

        @Override // java.util.ListIterator
        public void remove() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public void set(Modifier.Node modifier$Node) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public void set(Object object) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.ListIterator
        public final void setIndex(int <set-?>) {
            this.index = <set-?>;
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0008\u0005\n\u0002\u0010(\n\u0002\u0008\u0002\n\u0002\u0010*\n\u0002\u0008\u0004\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0096\u0002J\u0016\u0010\u000f\u001a\u00020\r2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0011H\u0016J\u0011\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0096\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0008\u0010\u0015\u001a\u00020\rH\u0016J\u000f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0017H\u0096\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u000e\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001aH\u0016J\u0016\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\u001e\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0004H\u0016R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0014\u0010\n\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u0008¨\u0006\u001e", d2 = {"Landroidx/compose/ui/node/HitTestResult$SubList;", "", "Landroidx/compose/ui/Modifier$Node;", "minIndex", "", "maxIndex", "(Landroidx/compose/ui/node/HitTestResult;II)V", "getMaxIndex", "()I", "getMinIndex", "size", "getSize", "contains", "", "element", "containsAll", "elements", "", "get", "index", "indexOf", "isEmpty", "iterator", "", "lastIndexOf", "listIterator", "", "subList", "fromIndex", "toIndex", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SubList implements List<Modifier.Node>, KMappedMarker {

        private final int maxIndex;
        private final int minIndex;
        final androidx.compose.ui.node.HitTestResult this$0;
        public SubList(androidx.compose.ui.node.HitTestResult this$0, int minIndex, int maxIndex) {
            this.this$0 = this$0;
            super();
            this.minIndex = minIndex;
            this.maxIndex = maxIndex;
        }

        @Override // java.util.List
        public void add(int i, Modifier.Node modifier$Node2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.List
        public void add(int i, Object object2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.List
        public boolean add(Modifier.Node modifier$Node) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.List
        public boolean add(Object object) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean addAll(int i, Collection<? extends Modifier.Node> collection2) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean addAll(Collection<? extends Modifier.Node> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.List
        public void clear() {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.List
        public boolean contains(Modifier.Node element) {
            int i;
            i = indexOf(element) != -1 ? 1 : 0;
            return i;
        }

        @Override // java.util.List
        public final boolean contains(Object element) {
            if (!element instanceof Modifier.Node) {
                return 0;
            }
            return contains((Modifier.Node)element);
        }

        public boolean containsAll(Collection<? extends Object> elements) {
            Object next;
            Object obj;
            int i;
            boolean contains;
            final int i2 = 0;
            Iterator iterator = (Iterable)elements.iterator();
            for (Object next : iterator) {
                i = 0;
            }
            return 1;
        }

        @Override // java.util.List
        public Modifier.Node get(int index) {
            Object obj = HitTestResult.access$getValues$p(this.this$0)[minIndex += index];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node)obj;
        }

        @Override // java.util.List
        public Object get(int index) {
            return get(index);
        }

        @Override // java.util.List
        public final int getMaxIndex() {
            return this.maxIndex;
        }

        @Override // java.util.List
        public final int getMinIndex() {
            return this.minIndex;
        }

        @Override // java.util.List
        public int getSize() {
            return maxIndex -= minIndex;
        }

        @Override // java.util.List
        public int indexOf(Modifier.Node element) {
            int i;
            boolean equal;
            int maxIndex = this.maxIndex;
            if (this.minIndex <= maxIndex) {
            }
            return -1;
        }

        @Override // java.util.List
        public final int indexOf(Object element) {
            if (!element instanceof Modifier.Node) {
                return -1;
            }
            return indexOf((Modifier.Node)element);
        }

        @Override // java.util.List
        public boolean isEmpty() {
            int i;
            i = size() == 0 ? 1 : 0;
            return i;
        }

        public Iterator<Modifier.Node> iterator() {
            HitTestResult.HitTestResultIterator hitTestResultIterator = new HitTestResult.HitTestResultIterator(this.this$0, this.minIndex, this.minIndex, this.maxIndex);
            return (Iterator)hitTestResultIterator;
        }

        @Override // java.util.List
        public int lastIndexOf(Modifier.Node element) {
            int i;
            boolean equal;
            int minIndex = this.minIndex;
            if (minIndex <= this.maxIndex) {
            }
            return -1;
        }

        @Override // java.util.List
        public final int lastIndexOf(Object element) {
            if (!element instanceof Modifier.Node) {
                return -1;
            }
            return lastIndexOf((Modifier.Node)element);
        }

        public ListIterator<Modifier.Node> listIterator() {
            HitTestResult.HitTestResultIterator hitTestResultIterator = new HitTestResult.HitTestResultIterator(this.this$0, this.minIndex, this.minIndex, this.maxIndex);
            return (ListIterator)hitTestResultIterator;
        }

        public ListIterator<Modifier.Node> listIterator(int index) {
            HitTestResult.HitTestResultIterator hitTestResultIterator = new HitTestResult.HitTestResultIterator(this.this$0, minIndex += index, this.minIndex, this.maxIndex);
            return (ListIterator)hitTestResultIterator;
        }

        @Override // java.util.List
        public Modifier.Node remove(int i) {
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

        public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public boolean retainAll(Collection<? extends Object> collection) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        @Override // java.util.List
        public Modifier.Node set(int i, Modifier.Node modifier$Node2) {
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

        public void sort(Comparator<? super Modifier.Node> comparator) {
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            throw unsupportedOperationException;
        }

        public List<Modifier.Node> subList(int fromIndex, int toIndex) {
            HitTestResult.SubList subList = new HitTestResult.SubList(this.this$0, minIndex += fromIndex, minIndex2 += toIndex);
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
    static {
        final int i = 8;
    }

    public HitTestResult() {
        super();
        int i = 16;
        this.values = new Object[i];
        this.distanceFromEdgeAndInLayer = new long[i];
        int i2 = -1;
        int i3 = 1;
    }

    public static final int access$getHitDepth$p(androidx.compose.ui.node.HitTestResult $this) {
        return $this.hitDepth;
    }

    public static final Object[] access$getValues$p(androidx.compose.ui.node.HitTestResult $this) {
        return $this.values;
    }

    public static final void access$setHitDepth$p(androidx.compose.ui.node.HitTestResult $this, int <set-?>) {
        $this.hitDepth = <set-?>;
    }

    private final void ensureContainerSize() {
        int hitDepth;
        int copyOf;
        String str;
        if (this.hitDepth >= values2.length) {
            length += 16;
            Object[] copyOf2 = Arrays.copyOf(this.values, hitDepth);
            str = "copyOf(this, newSize)";
            Intrinsics.checkNotNullExpressionValue(copyOf2, str);
            this.values = copyOf2;
            copyOf = Arrays.copyOf(this.distanceFromEdgeAndInLayer, hitDepth);
            Intrinsics.checkNotNullExpressionValue(copyOf, str);
            this.distanceFromEdgeAndInLayer = copyOf;
        }
    }

    private final long findBestHitDistance-ptXAw2c() {
        long bestDistance;
        int i;
        long constructor-impl;
        int inLayer-impl;
        long l;
        int i2;
        final int i4 = 0;
        bestDistance = HitTestResultKt.access$DistanceAndInLayer(2139095040, i4);
        int lastIndex = CollectionsKt.getLastIndex((List)this);
        if (hitDepth++ <= lastIndex) {
        }
        return bestDistance;
    }

    private final void resizeToHitDepth() {
        int i;
        Object[] values;
        int i2;
        int lastIndex = CollectionsKt.getLastIndex((List)this);
        if (hitDepth++ <= lastIndex) {
        }
        this.size = i3++;
    }

    @Override // java.util.List
    public final void acceptHits() {
        this.hitDepth = size--;
    }

    @Override // java.util.List
    public void add(int i, Modifier.Node modifier$Node2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public void add(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean add(Modifier.Node modifier$Node) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public boolean add(Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int i, Collection<? extends Modifier.Node> collection2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection<? extends Modifier.Node> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final void clear() {
        this.hitDepth = -1;
        resizeToHitDepth();
        this.shouldSharePointerInputWithSibling = true;
    }

    @Override // java.util.List
    public boolean contains(Modifier.Node element) {
        int i;
        i = indexOf(element) != -1 ? 1 : 0;
        return i;
    }

    @Override // java.util.List
    public final boolean contains(Object element) {
        if (!element instanceof Modifier.Node) {
            return 0;
        }
        return contains((Modifier.Node)element);
    }

    public boolean containsAll(Collection<? extends Object> elements) {
        Object next;
        Object obj;
        int i;
        boolean contains;
        final int i2 = 0;
        Iterator iterator = (Iterable)elements.iterator();
        for (Object next : iterator) {
            i = 0;
        }
        return 1;
    }

    @Override // java.util.List
    public Modifier.Node get(int index) {
        Object obj = this.values[index];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (Modifier.Node)obj;
    }

    @Override // java.util.List
    public Object get(int index) {
        return get(index);
    }

    @Override // java.util.List
    public final boolean getShouldSharePointerInputWithSibling() {
        return this.shouldSharePointerInputWithSibling;
    }

    @Override // java.util.List
    public int getSize() {
        return this.size;
    }

    @Override // java.util.List
    public final boolean hasHit() {
        int inLayer-impl;
        int i;
        final long bestHitDistance-ptXAw2c = findBestHitDistance-ptXAw2c();
        if (Float.compare(distance-impl, i2) < 0 && DistanceAndInLayer.isInLayer-impl(bestHitDistance-ptXAw2c)) {
            i = DistanceAndInLayer.isInLayer-impl(bestHitDistance-ptXAw2c) ? 1 : 0;
        } else {
        }
        return i;
    }

    public final void hit(Modifier.Node node, boolean isInLayer, Function0<Unit> childHitTest) {
        androidx.compose.ui.node.NodeCoordinator sharePointerInputWithSiblings;
        int i;
        hitInMinimumTouchTarget(node, -1082130432, isInLayer, childHitTest);
        sharePointerInputWithSiblings = node.getCoordinator$ui_release();
        final int i3 = 0;
        if (sharePointerInputWithSiblings != null && !sharePointerInputWithSiblings.shouldSharePointerInputWithSiblings()) {
            i = !sharePointerInputWithSiblings.shouldSharePointerInputWithSiblings() ? 1 : i3;
        } else {
        }
        if (i != 0) {
            this.shouldSharePointerInputWithSibling = i3;
        }
    }

    public final void hitInMinimumTouchTarget(Modifier.Node node, float distanceFromEdge, boolean isInLayer, Function0<Unit> childHitTest) {
        this.hitDepth = hitDepth2++;
        ensureContainerSize();
        this.values[this.hitDepth] = node;
        this.distanceFromEdgeAndInLayer[this.hitDepth] = HitTestResultKt.access$DistanceAndInLayer(distanceFromEdge, isInLayer);
        resizeToHitDepth();
        childHitTest.invoke();
        this.hitDepth = this.hitDepth;
    }

    @Override // java.util.List
    public int indexOf(Modifier.Node element) {
        int i;
        boolean equal;
        int lastIndex = CollectionsKt.getLastIndex((List)this);
        if (0 <= lastIndex) {
        }
        return -1;
    }

    @Override // java.util.List
    public final int indexOf(Object element) {
        if (!element instanceof Modifier.Node) {
            return -1;
        }
        return indexOf((Modifier.Node)element);
    }

    @Override // java.util.List
    public boolean isEmpty() {
        int i;
        i = size() == 0 ? 1 : 0;
        return i;
    }

    @Override // java.util.List
    public final boolean isHitInMinimumTouchTargetBetter(float distanceFromEdge, boolean isInLayer) {
        int i;
        int lastIndex = CollectionsKt.getLastIndex((List)this);
        if (this.hitDepth == lastIndex) {
            return 1;
        }
        if (DistanceAndInLayer.compareTo-S_HNhKs(findBestHitDistance-ptXAw2c(), obj4) > 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public Iterator<Modifier.Node> iterator() {
        HitTestResult.HitTestResultIterator hitTestResultIterator = new HitTestResult.HitTestResultIterator(this, 0, 0, 0, 7, 0);
        return (Iterator)hitTestResultIterator;
    }

    @Override // java.util.List
    public int lastIndexOf(Modifier.Node element) {
        int i;
        boolean equal;
        i = CollectionsKt.getLastIndex((List)this);
        int i2 = -1;
        while (i2 < i) {
            i--;
            i2 = -1;
        }
        return i2;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object element) {
        if (!element instanceof Modifier.Node) {
            return -1;
        }
        return lastIndexOf((Modifier.Node)element);
    }

    public ListIterator<Modifier.Node> listIterator() {
        HitTestResult.HitTestResultIterator hitTestResultIterator = new HitTestResult.HitTestResultIterator(this, 0, 0, 0, 7, 0);
        return (ListIterator)hitTestResultIterator;
    }

    public ListIterator<Modifier.Node> listIterator(int index) {
        HitTestResult.HitTestResultIterator hitTestResultIterator = new HitTestResult.HitTestResultIterator(this, index, 0, 0, 6, 0);
        return (ListIterator)hitTestResultIterator;
    }

    @Override // java.util.List
    public Modifier.Node remove(int i) {
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

    public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean retainAll(Collection<? extends Object> collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public Modifier.Node set(int i, Modifier.Node modifier$Node2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public Object set(int i, Object object2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    @Override // java.util.List
    public final void setShouldSharePointerInputWithSibling(boolean <set-?>) {
        this.shouldSharePointerInputWithSibling = <set-?>;
    }

    public final void siblingHits(Function0<Unit> block) {
        final int i = 0;
        block.invoke();
        HitTestResult.access$setHitDepth$p(this, HitTestResult.access$getHitDepth$p(this));
    }

    @Override // java.util.List
    public final int size() {
        return getSize();
    }

    public void sort(Comparator<? super Modifier.Node> comparator) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public final void speculativeHit(Modifier.Node node, float distanceFromEdge, boolean isInLayer, Function0<Unit> childHitTest) {
        int compareTo-S_HNhKs;
        int lastIndex;
        int i;
        int hitDepth;
        int size;
        int lastIndex2 = CollectionsKt.getLastIndex((List)this);
        hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
        if (this.hitDepth == lastIndex2 && hitDepth3++ == CollectionsKt.getLastIndex((List)this)) {
            hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
            if (hitDepth3++ == CollectionsKt.getLastIndex((List)this)) {
                resizeToHitDepth();
            }
        }
        final int hitDepth4 = this.hitDepth;
        this.hitDepth = CollectionsKt.getLastIndex((List)this);
        hitInMinimumTouchTarget(node, distanceFromEdge, isInLayer, childHitTest);
        lastIndex = CollectionsKt.getLastIndex((List)this);
        if (hitDepth5++ < lastIndex && DistanceAndInLayer.compareTo-S_HNhKs(findBestHitDistance-ptXAw2c(), lastIndex2) > 0) {
            if (DistanceAndInLayer.compareTo-S_HNhKs(bestHitDistance-ptXAw2c, lastIndex2) > 0) {
                hitDepth6++;
                lastIndex = hitDepth4 + 1;
                ArraysKt.copyInto(this.values, this.values, lastIndex, compareTo-S_HNhKs, size());
                ArraysKt.copyInto(this.distanceFromEdgeAndInLayer, this.distanceFromEdgeAndInLayer, lastIndex, compareTo-S_HNhKs, size());
                this.hitDepth = i4--;
            }
        }
        resizeToHitDepth();
        this.hitDepth = hitDepth4;
    }

    public List<Modifier.Node> subList(int fromIndex, int toIndex) {
        HitTestResult.SubList subList = new HitTestResult.SubList(this, fromIndex, toIndex);
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
