package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a8\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00032!\u0010\u0008\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0004\u0012\u00020\u00050\tH\u0082\u0008\u001a!\u0010\r\u001a\u0002H\u000e\"\u000e\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f*\u0002H\u000eH\u0000¢\u0006\u0002\u0010\u0010\u001av\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\u0008\u0000\u0010\u0013*\u0008\u0012\u0004\u0012\u0002H\u00130\u0014*\u0008\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002H\u001328\u0008\u0008\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0080\u0008ø\u0001\u0000\u001aj\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00130\u0012\"\u000e\u0008\u0000\u0010\u0013*\u0008\u0012\u0004\u0012\u0002H\u00130\u0014*\u0002H\u00132\u0006\u0010\u0016\u001a\u00020\u001726\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u0016\u0012\u0013\u0012\u0011H\u0013¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u0002H\u00130\u001aH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a+\u0010\u001e\u001a\u00020\u0005\"\u000e\u0008\u0000\u0010\u0013*\u0008\u0012\u0004\u0012\u0002H\u00130\u0014*\u0008\u0012\u0004\u0012\u0002H\u00130\u00152\u0006\u0010\u001f\u001a\u0002H\u0013H\u0080\u0008\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006 ", d2 = {"CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "POINTERS_SHIFT", "", "addConditionally", "", "Lkotlinx/atomicfu/AtomicInt;", "delta", "condition", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "cur", "close", "N", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "findSegmentAndMoveForward", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "S", "Lkotlinx/coroutines/internal/Segment;", "Lkotlinx/atomicfu/AtomicRef;", "id", "", "startFrom", "createNewSegment", "Lkotlin/Function2;", "prev", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "moveForward", "to", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConcurrentLinkedListKt {

    private static final kotlinx.coroutines.internal.Symbol CLOSED = null;
    private static final int POINTERS_SHIFT = 16;
    static {
        Symbol symbol = new Symbol("CLOSED");
        ConcurrentLinkedListKt.CLOSED = symbol;
    }

    public static final kotlinx.coroutines.internal.Symbol access$getCLOSED$p() {
        return ConcurrentLinkedListKt.CLOSED;
    }

    private static final boolean addConditionally$atomicfu(Object atomicfu$dispatchReceiver, AtomicIntegerFieldUpdater atomicfu$handler, int delta, Function1<? super Integer, Boolean> condition) {
        int i;
        boolean compareAndSet;
        final int i2 = 0;
        i = atomicfu$handler.get(atomicfu$dispatchReceiver);
        while (!(Boolean)condition.invoke(Integer.valueOf(i)).booleanValue()) {
            i = atomicfu$handler.get(atomicfu$dispatchReceiver);
        }
        return 0;
    }

    private static final boolean addConditionally$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicIntegerArray atomicfu$handler, int atomicfu$index, int delta, Function1<? super Integer, Boolean> condition) {
        int i;
        boolean compareAndSet;
        final int i2 = 0;
        i = atomicfu$handler.get(atomicfu$index);
        while (!(Boolean)condition.invoke(Integer.valueOf(i)).booleanValue()) {
            i = atomicfu$handler.get(atomicfu$index);
        }
        return 0;
    }

    public static final <N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>> N close(N $this$close) {
        Object cur;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode markAsClosed;
        int i2;
        Object obj;
        int i;
        Object $i$a$NextOrIfClosedConcurrentLinkedListKt$close$next$1;
        int i3 = 0;
        cur = $this$close;
        i2 = 0;
        obj = ConcurrentLinkedListNode.access$getNextOrClosed(cur);
        i = 0;
        while (obj == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            $i$a$NextOrIfClosedConcurrentLinkedListKt$close$next$1 = obj;
            cur = $i$a$NextOrIfClosedConcurrentLinkedListKt$close$next$1;
            i2 = 0;
            obj = ConcurrentLinkedListNode.access$getNextOrClosed(cur);
            i = 0;
        }
        int i4 = 0;
        return cur;
    }

    public static final Object findSegmentAndMoveForward$atomicfu(Object atomicfu$dispatchReceiver, AtomicReferenceFieldUpdater atomicfu$handler, long id, S startFrom, Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        int tryIncPointers$kotlinx_coroutines_core;
        int i4;
        Object obj3;
        Function2 function2;
        Object segmentInternal;
        kotlinx.coroutines.internal.Segment segment-impl;
        int i;
        int i2;
        Object obj;
        int i3;
        long l;
        int $i$f$findSegmentAndMoveForward$atomicfu;
        final Object obj2 = atomicfu$dispatchReceiver;
        final AtomicReferenceFieldUpdater field = atomicfu$handler;
        tryIncPointers$kotlinx_coroutines_core = 0;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal(createNewSegment, id, obj4);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            segment-impl = SegmentOrClosed.getSegment-impl(segmentInternal);
            i = 0;
            i2 = 0;
            obj = field.get(obj2);
            i3 = 0;
            $i$f$findSegmentAndMoveForward$atomicfu = tryIncPointers$kotlinx_coroutines_core;
            i4 = 1;
            while (Long.compare(l, $i$f$findSegmentAndMoveForward$atomicfu2) >= 0) {
                if (segment-impl.decPointers$kotlinx_coroutines_core()) {
                }
                i4 = id;
                tryIncPointers$kotlinx_coroutines_core = $i$f$findSegmentAndMoveForward$atomicfu;
                obj = field.get(obj2);
                i3 = 0;
                $i$f$findSegmentAndMoveForward$atomicfu = tryIncPointers$kotlinx_coroutines_core;
                i4 = 1;
                segment-impl.remove();
            }
            if (!segment-impl.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(field, obj2, (Segment)obj, segment-impl)) {
            } else {
            }
            if (segment-impl.decPointers$kotlinx_coroutines_core()) {
            }
            i4 = id;
            tryIncPointers$kotlinx_coroutines_core = $i$f$findSegmentAndMoveForward$atomicfu;
            segment-impl.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            tryIncPointers$kotlinx_coroutines_core = $i$f$findSegmentAndMoveForward$atomicfu;
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal(createNewSegment, id, obj4);
            obj.remove();
            i4 = 0;
        }
        $i$f$findSegmentAndMoveForward$atomicfu = tryIncPointers$kotlinx_coroutines_core;
        return segmentInternal;
    }

    public static final Object findSegmentAndMoveForward$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicReferenceArray atomicfu$handler, int atomicfu$index, long id, S startFrom, Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        kotlinx.coroutines.internal.Segment segment;
        Object obj2;
        Function2 function2;
        Object segmentInternal;
        kotlinx.coroutines.internal.Segment segment-impl;
        int i;
        int i3;
        Object obj;
        int i4;
        AtomicReferenceArray atomicReferenceArray;
        int decPointers$kotlinx_coroutines_core2;
        int i2;
        boolean decPointers$kotlinx_coroutines_core;
        final int i5 = 0;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal(createNewSegment, id, obj2);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            segment-impl = SegmentOrClosed.getSegment-impl(segmentInternal);
            i = 0;
            i3 = 0;
            obj = atomicfu$handler.get(atomicfu$index);
            i4 = 0;
            decPointers$kotlinx_coroutines_core2 = 1;
            while (Long.compare(l, l2) >= 0) {
                if (segment-impl.decPointers$kotlinx_coroutines_core()) {
                }
                obj = atomicfu$handler.get(atomicfu$index);
                i4 = 0;
                decPointers$kotlinx_coroutines_core2 = 1;
                segment-impl.remove();
            }
            if (!segment-impl.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(atomicfu$handler, atomicfu$index, (Segment)obj, segment-impl)) {
            } else {
            }
            if (segment-impl.decPointers$kotlinx_coroutines_core()) {
            }
            segment-impl.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal(createNewSegment, id, obj2);
            obj.remove();
            decPointers$kotlinx_coroutines_core2 = 0;
            atomicReferenceArray = atomicfu$handler;
            i2 = atomicfu$index;
            atomicReferenceArray = atomicfu$handler;
            i2 = atomicfu$index;
        }
        atomicReferenceArray = atomicfu$handler;
        i2 = atomicfu$index;
        return segmentInternal;
    }

    public static final <S extends kotlinx.coroutines.internal.Segment<S>> Object findSegmentInternal(S $this$findSegmentInternal, long id, Function2<? super Long, ? super S, ? extends S> createNewSegment) {
        Object cur;
        Object this_$iv;
        int removed;
        Object invoke;
        boolean trySetNext;
        int i;
        Object $i$a$NextOrIfClosedConcurrentLinkedListKt$findSegmentInternal$next$1;
        cur = $this$findSegmentInternal;
        while (Long.compare(l, id) >= 0) {
            invoke = 0;
            trySetNext = ConcurrentLinkedListNode.access$getNextOrClosed((ConcurrentLinkedListNode)cur);
            i = 0;
            this_$iv = $i$a$NextOrIfClosedConcurrentLinkedListKt$findSegmentInternal$next$1;
            if ((Segment)this_$iv != null) {
            } else {
            }
            invoke = obj10.invoke(Long.valueOf(l2 += i), cur);
            if (cur.trySetNext((ConcurrentLinkedListNode)(Segment)invoke) && cur.isRemoved()) {
            }
            if (cur.isRemoved()) {
            }
            cur = invoke;
            cur.remove();
            cur = this_$iv;
        }
        return SegmentOrClosed.constructor-impl(cur);
    }

    private static final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private static final void loop$atomicfu$array(AtomicReferenceArray atomicReferenceArray, int i2, Function1<Object, Unit> function13) {
        Object obj;
        final int i = 0;
        while (true) {
            function13.invoke(atomicReferenceArray.get(i2));
        }
    }

    public static final boolean moveForward$atomicfu(Object atomicfu$dispatchReceiver, AtomicReferenceFieldUpdater atomicfu$handler, S to) {
        Object obj;
        int i2;
        boolean decPointers$kotlinx_coroutines_core;
        int i;
        long l;
        final int i3 = 0;
        final int i4 = 0;
        obj = atomicfu$handler.get(atomicfu$dispatchReceiver);
        i2 = 0;
        i = 1;
        while (Long.compare(l2, l) >= 0) {
            if (to.decPointers$kotlinx_coroutines_core()) {
            }
            obj = atomicfu$handler.get(atomicfu$dispatchReceiver);
            i2 = 0;
            i = 1;
            to.remove();
        }
        return i;
    }

    public static final boolean moveForward$atomicfu$array(Object atomicfu$dispatchReceiver, AtomicReferenceArray atomicfu$handler, int atomicfu$index, S to) {
        Object obj;
        int i2;
        boolean decPointers$kotlinx_coroutines_core;
        int i;
        long l;
        final int i3 = 0;
        final int i4 = 0;
        obj = atomicfu$handler.get(atomicfu$index);
        i2 = 0;
        i = 1;
        while (Long.compare(l2, l) >= 0) {
            if (to.decPointers$kotlinx_coroutines_core()) {
            }
            obj = atomicfu$handler.get(atomicfu$index);
            i2 = 0;
            i = 1;
            to.remove();
        }
        return i;
    }
}
