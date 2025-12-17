package kotlinx.coroutines.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\u000c\u001a\u00020\rJ\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000fJ\r\u0010\u0010\u001a\u00020\u0011H\u0000¢\u0006\u0002\u0008\u0012J\u0008\u0010\u0013\u001a\u00020\u0011H\u0016J\t\u0010\u0014\u001a\u00020\u0004H\u0082\u0008J\r\u0010\u0015\u001a\u00020\r*\u00020\u0004H\u0082\u0008R\t\u0010\u0008\u001a\u00020\tX\u0082\u0004R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016", d2 = {"Lkotlinx/coroutines/internal/OnDemandAllocatingPool;", "T", "", "maxCapacity", "", "create", "Lkotlin/Function1;", "(ILkotlin/jvm/functions/Function1;)V", "controlState", "Lkotlinx/atomicfu/AtomicInt;", "elements", "Lkotlinx/atomicfu/AtomicArray;", "allocate", "", "close", "", "stateRepresentation", "", "stateRepresentation$kotlinx_coroutines_core", "toString", "tryForbidNewElements", "isClosed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OnDemandAllocatingPool<T>  {

    private static final AtomicIntegerFieldUpdater controlState$FU;
    @Volatile
    private volatile int controlState;
    private final Function1<Integer, T> create;
    private final AtomicReferenceArray elements;
    private final int maxCapacity;
    static {
        OnDemandAllocatingPool.controlState$FU = AtomicIntegerFieldUpdater.newUpdater(OnDemandAllocatingPool.class, "controlState");
    }

    public OnDemandAllocatingPool(int maxCapacity, Function1<? super Integer, ? extends T> create) {
        super();
        this.maxCapacity = maxCapacity;
        this.create = create;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(this.maxCapacity);
        this.elements = atomicReferenceArray;
    }

    private final boolean isClosed(int $this$isClosed) {
        int i;
        final int i2 = 0;
        i = i3 &= $this$isClosed != 0 ? 1 : 0;
        return i;
    }

    private final void loop$atomicfu(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Function1<? super Integer, Unit> function12, Object object3) {
        Integer valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Integer.valueOf(atomicIntegerFieldUpdater.get(object3)));
        }
    }

    private final int tryForbidNewElements() {
        int i6;
        int i7;
        boolean compareAndSet;
        int i2;
        int i;
        int i3;
        int i4;
        int i5;
        final int i8 = 0;
        final Object obj = this;
        final int i9 = 0;
        i6 = OnDemandAllocatingPool.controlState$FU.get(this);
        i7 = 0;
        Object obj2 = this;
        i = 0;
        i3 = Integer.MIN_VALUE;
        i5 = 0;
        while (i10 & i3 != 0) {
            i4 = 1;
            i6 = controlState$FU.get(this);
            i7 = 0;
            obj2 = this;
            i = 0;
            i3 = Integer.MIN_VALUE;
            i5 = 0;
            i4 = i5;
        }
        return i5;
    }

    public final boolean allocate() {
        int i6;
        int i4;
        boolean compareAndSet;
        int $this$isClosed$iv;
        int i2;
        int i5;
        int i3;
        int i7;
        int i;
        final Object obj = this;
        final int i8 = 0;
        i6 = OnDemandAllocatingPool.controlState$FU.get(this);
        i4 = 0;
        Object obj2 = this;
        i5 = 0;
        i7 = 0;
        i = 1;
        while (i10 &= i9 != 0) {
            $this$isClosed$iv = i;
            i6 = controlState$FU.get(this);
            i4 = 0;
            obj2 = this;
            i5 = 0;
            i7 = 0;
            i = 1;
            $this$isClosed$iv = i7;
        }
        return i7;
    }

    public final List<T> close() {
        int it$iv;
        int i2;
        boolean compareAndSet;
        int i;
        int i5;
        int i4;
        int i6;
        int andSet;
        int i3;
        Object obj = this;
        int i7 = 0;
        Object obj2 = obj;
        int i10 = 0;
        it$iv = OnDemandAllocatingPool.controlState$FU.get(obj);
        i2 = 0;
        i = obj;
        i5 = 0;
        i4 = Integer.MIN_VALUE;
        andSet = 0;
        while (compareAndSet & i4 != 0) {
            i6 = 1;
            if (i6 != 0) {
                break;
            } else {
            }
            if (!OnDemandAllocatingPool.controlState$FU.compareAndSet(obj, it$iv, it$iv | i4)) {
                break;
            }
            it$iv = controlState$FU.get(obj);
            i2 = 0;
            i = obj;
            i5 = 0;
            i4 = Integer.MIN_VALUE;
            andSet = 0;
            i6 = andSet;
        }
        it$iv = andSet;
        kotlin.ranges.IntRange until = RangesKt.until(andSet, it$iv);
        int i8 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
        int i11 = 0;
        Iterator iterator = until.iterator();
        while (iterator.hasNext()) {
            i5 = 0;
            i4 = 0;
            i6 = 0;
            andSet = this.elements.getAndSet((IntIterator)iterator.nextInt(), 0);
            while (andSet != null) {
                i6 = 0;
                andSet = this.elements.getAndSet(i, 0);
            }
            (Collection)arrayList.add(andSet);
        }
        return (List)arrayList;
    }

    public final String stateRepresentation$kotlinx_coroutines_core() {
        int i2;
        String str;
        int nextInt;
        Object it;
        int i;
        AtomicReferenceArray elements;
        int i3 = OnDemandAllocatingPool.controlState$FU.get(this);
        kotlin.ranges.IntRange until = RangesKt.until(0, i4 &= i3);
        int i6 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)until, 10));
        int i10 = 0;
        final Iterator iterator = until.iterator();
        while (iterator.hasNext()) {
            i = 0;
            (Collection)arrayList.add(this.elements.get((IntIterator)iterator.nextInt()));
        }
        Object obj = this;
        int i9 = 0;
        if (i11 &= i7 != 0) {
            i2 = 1;
        }
        str = i2 != 0 ? "[closed]" : "";
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append((List)arrayList.toString()).append(str).toString();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("OnDemandAllocatingPool(").append(stateRepresentation$kotlinx_coroutines_core()).append(')').toString();
    }
}
