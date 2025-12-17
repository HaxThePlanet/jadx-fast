package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u0000 ,*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0002,-B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000¢\u0006\u0002\u0010\u0017J \u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\u0008\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\u0008\u0012\u0004\u0012\u00028\u0000`\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0006\u0010\u001c\u001a\u00020\u0006J1\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001fJ\u0006\u0010 \u001a\u00020\u0006J&\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H#0\"\"\u0004\u0008\u0001\u0010#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H#0%J\u0008\u0010&\u001a\u00020\u001aH\u0002J\u000c\u0010'\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000J\u0008\u0010(\u001a\u0004\u0018\u00010\u0002J,\u0010)\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u0004H\u0002R#\u0010\u0008\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\n0\tX\u0082\u0004R\t\u0010\u000b\u001a\u00020\u000cX\u0082\u0004R\u0011\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000eX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006.", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "E", "", "capacity", "", "singleConsumer", "", "(IZ)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/Core;", "_state", "Lkotlinx/atomicfu/AtomicLong;", "array", "Lkotlinx/atomicfu/AtomicArray;", "isEmpty", "()Z", "mask", "size", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)I", "allocateNextCopy", "state", "", "allocateOrGetNextCopy", "close", "fillPlaceholder", "index", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "markFrozen", "next", "removeFirstOrNull", "removeSlowPath", "oldHead", "newHead", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LockFreeTaskQueueCore<E>  {

    public static final int ADD_CLOSED = 2;
    public static final int ADD_FROZEN = 1;
    public static final int ADD_SUCCESS = 0;
    public static final int CAPACITY_BITS = 30;
    public static final long CLOSED_MASK = 2305843009213693952L;
    public static final int CLOSED_SHIFT = 61;
    public static final kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion Companion = null;
    public static final long FROZEN_MASK = 1152921504606846976L;
    public static final int FROZEN_SHIFT = 60;
    public static final long HEAD_MASK = 1073741823L;
    public static final int HEAD_SHIFT = 0;
    public static final int INITIAL_CAPACITY = 8;
    public static final int MAX_CAPACITY_MASK = 1073741823;
    public static final int MIN_ADD_SPIN_CAPACITY = 1024;
    public static final kotlinx.coroutines.internal.Symbol REMOVE_FROZEN = null;
    public static final long TAIL_MASK = 1152921503533105152L;
    public static final int TAIL_SHIFT = 30;
    private static final AtomicReferenceFieldUpdater _next$FU;
    private static final AtomicLongFieldUpdater _state$FU;
    @Volatile
    private volatile Object _next;
    @Volatile
    private volatile long _state;
    private final AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\u0008\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\u0008¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int addFailReason(long $this$addFailReason) {
            int i;
            i = Long.compare(i2, i3) != 0 ? 2 : 1;
            return i;
        }

        public final long updateHead(long $this$updateHead, int newHead) {
            return l |= i3;
        }

        public final long updateTail(long $this$updateTail, int newTail) {
            return l2 |= i2;
        }

        public final <T> T withState(long $this$withState, Function2<? super Integer, ? super Integer, ? extends T> block) {
            final int i = 0;
            return obj8.invoke(Integer.valueOf((int)i4), Integer.valueOf((int)i7));
        }

        public final long wo(long $this$wo, long other) {
            return i &= $this$wo;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Placeholder {

        public final int index;
        public Placeholder(int index) {
            super();
            this.index = index;
        }
    }
    static {
        LockFreeTaskQueueCore.Companion companion = new LockFreeTaskQueueCore.Companion(0);
        LockFreeTaskQueueCore.Companion = companion;
        final Class<kotlinx.coroutines.internal.LockFreeTaskQueueCore> obj2 = LockFreeTaskQueueCore.class;
        LockFreeTaskQueueCore._next$FU = AtomicReferenceFieldUpdater.newUpdater(obj2, Object.class, "_next");
        LockFreeTaskQueueCore._state$FU = AtomicLongFieldUpdater.newUpdater(obj2, "_state");
        Symbol symbol = new Symbol("REMOVE_FROZEN");
        LockFreeTaskQueueCore.REMOVE_FROZEN = symbol;
    }

    public LockFreeTaskQueueCore(int capacity, boolean singleConsumer) {
        int i2;
        int i;
        super();
        this.capacity = capacity;
        this.singleConsumer = singleConsumer;
        i = 1;
        this.mask = capacity2 -= i;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(this.capacity);
        this.array = atomicReferenceArray;
        final int i6 = 0;
        i2 = this.mask <= 1073741823 ? i : i6;
        String str = "Check failed.";
        if (i2 == 0) {
        } else {
            if (capacity3 &= mask2 == 0) {
            } else {
                i = i6;
            }
            if (i == 0) {
            } else {
            }
            IllegalStateException illegalStateException2 = new IllegalStateException(str.toString());
            throw illegalStateException2;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str.toString());
        throw illegalStateException;
    }

    private final kotlinx.coroutines.internal.LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        int index;
        Object placeholder;
        AtomicReferenceArray array;
        int i;
        final Object obj = this;
        LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(capacity *= 2, obj.singleConsumer);
        long l = state;
        final int i3 = 0;
        final int i15 = 0;
        index = i12;
        while (mask &= index != mask2 &= i14) {
            if (obj.array.get(mask3 &= index) == null) {
            }
            lockFreeTaskQueueCore.array.set(mask4 &= index, placeholder);
            index++;
            placeholder = new LockFreeTaskQueueCore.Placeholder(index);
        }
        long l4 = 1152921504606846976L;
        final kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion queue = companion;
        final long l5 = l;
        LockFreeTaskQueueCore._state$FU.set(lockFreeTaskQueueCore, LockFreeTaskQueueCore.Companion.wo(state, l));
        return lockFreeTaskQueueCore;
    }

    private final kotlinx.coroutines.internal.LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        Object obj;
        int i;
        AtomicReferenceFieldUpdater _next$FU;
        int i2;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore allocateNextCopy;
        final Object obj2 = this;
        final int i3 = 0;
        obj = LockFreeTaskQueueCore._next$FU.get(this);
        i = 0;
        while ((LockFreeTaskQueueCore)obj != null) {
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueueCore._next$FU, this, 0, allocateNextCopy(state));
            obj = _next$FU2.get(this);
            i = 0;
        }
        return (LockFreeTaskQueueCore)(LockFreeTaskQueueCore)obj;
    }

    private final kotlinx.coroutines.internal.LockFreeTaskQueueCore<E> fillPlaceholder(int index, E element) {
        boolean index2;
        Object obj = this.array.get(mask &= index);
        if (obj instanceof LockFreeTaskQueueCore.Placeholder && obj2.index == index) {
            if (obj2.index == index) {
                this.array.set(mask2 &= index, element);
                return this;
            }
        }
        return 0;
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function12, Object object3) {
        Long valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Long.valueOf(atomicLongFieldUpdater.get(object3)));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final long markFrozen() {
        Object obj;
        boolean compareAndSet;
        int state;
        long l;
        int cmp;
        int i;
        final AtomicLongFieldUpdater _state$FU = LockFreeTaskQueueCore._state$FU;
        final Object obj2 = this;
        final int i3 = 0;
        long l2 = _state$FU.get(this);
        long l3 = l2;
        int i2 = 0;
        l = 1152921504606846976L;
        while (Long.compare(i4, i) != 0) {
            l3 |= l;
            l2 = _state$FU.get(this);
            l3 = l2;
            i2 = 0;
            l = 1152921504606846976L;
        }
        return l3;
    }

    private final kotlinx.coroutines.internal.LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        boolean compareAndSet;
        int i3;
        long l3;
        long head;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion;
        boolean aSSERTIONS_ENABLED;
        AtomicLongFieldUpdater _state$FU;
        int atomicfu$handler$iv;
        int i5;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion2;
        long l2;
        int i6;
        int i4;
        int i;
        int i2;
        AtomicLongFieldUpdater atomicfu$handler$iv2;
        int i8;
        int i7;
        long l;
        final Object obj = this;
        _state$FU = LockFreeTaskQueueCore._state$FU;
        final Object obj3 = this;
        final int i17 = 0;
        l3 = _state$FU.get(obj);
        i5 = 0;
        companion2 = LockFreeTaskQueueCore.Companion;
        l2 = l4;
        i6 = 0;
        i = (int)i13;
        int i14 = i4;
        i2 = 0;
        while (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            atomicfu$handler$iv2 = _state$FU;
            if (i14 == oldHead) {
            }
            companion = LockFreeTaskQueueCore.Companion;
            _state$FU = atomicfu$handler$iv2;
            l3 = _state$FU.get(obj);
            i5 = 0;
            companion2 = LockFreeTaskQueueCore.Companion;
            l2 = l4;
            i6 = 0;
            i = (int)i13;
            i14 = i4;
            i2 = 0;
            atomicfu$handler$iv2 = _state$FU;
            atomicfu$handler$iv = oldHead;
            i3 = 1;
        }
        AssertionError assertionError = new AssertionError();
        throw assertionError;
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function12, Object object3) {
        Object obj2;
        Object obj;
        long l;
        long longValue;
        Object obj8;
        Object obj10;
        final int i = 0;
        l = obj8.get(obj10);
        obj2 = obj8;
        obj = obj10;
        while (obj2.compareAndSet(obj, l, obj4)) {
            obj8 = obj2;
            obj10 = obj;
            l = obj8.get(obj10);
            obj2 = obj8;
            obj = obj10;
        }
    }

    private final long updateAndGet$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function12, Object object3) {
        Object obj3;
        Object obj;
        long l;
        long longValue;
        Object obj2;
        Object obj9;
        Object obj11;
        final int i = 0;
        l = obj9.get(obj11);
        obj2 = invoke;
        obj3 = obj9;
        obj = obj11;
        while (obj3.compareAndSet(obj, l, obj4)) {
            obj9 = obj3;
            obj11 = obj;
            l = obj9.get(obj11);
            obj2 = invoke;
            obj3 = obj9;
            obj = obj11;
        }
        return obj2.longValue();
    }

    public final int addLast(E element) {
        AtomicLongFieldUpdater compareAndSet;
        Object singleConsumer;
        Object cur;
        long l3;
        int tail$iv;
        int fillPlaceholder;
        int i7;
        Object obj;
        int i12;
        int mask;
        int i3;
        int i10;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion;
        long l;
        int i;
        int i11;
        int i2;
        int i6;
        int i4;
        int i8;
        int i9;
        int i5;
        long l2;
        Object obj2;
        final Object obj3 = this;
        final Object obj4 = element;
        obj = this;
        final int i23 = 0;
        l3 = LockFreeTaskQueueCore._state$FU.get(obj3);
        i12 = 0;
        int i24 = 0;
        while (Long.compare(i16, i24) != 0) {
            companion = LockFreeTaskQueueCore.Companion;
            l = l5;
            i = 0;
            i11 = 0;
            int i13 = (int)i19;
            tail$iv = (int)i21;
            i2 = i13;
            i7 = tail$iv;
            i6 = 0;
            mask = obj3.mask;
            i8 = i13;
            i9 = 1;
            i5 = 1073741823;
            i9 = tail$iv;
            int this_$iv = i7;
            obj = i5;
            l3 = num2.get(obj3);
            i12 = 0;
            i24 = 0;
        }
        return LockFreeTaskQueueCore.Companion.addFailReason(l3);
    }

    public final boolean close() {
        Object obj;
        boolean compareAndSet;
        int state;
        int i3;
        long l;
        int cmp;
        int i4;
        int i2;
        int i;
        final AtomicLongFieldUpdater _state$FU = LockFreeTaskQueueCore._state$FU;
        final Object obj2 = this;
        final int i6 = 0;
        obj = this;
        long l2 = _state$FU.get(obj);
        long l3 = l2;
        i3 = 0;
        l = 2305843009213693952L;
        i2 = 0;
        i4 = 1;
        while (Long.compare(i7, i2) != 0) {
            obj = this;
            l2 = _state$FU.get(obj);
            l3 = l2;
            i3 = 0;
            l = 2305843009213693952L;
            i2 = 0;
            i4 = 1;
        }
        return i4;
    }

    public final int getSize() {
        final kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.Companion;
        long l = LockFreeTaskQueueCore._state$FU.get(this);
        final int i = 0;
        final int i13 = 0;
        return i14 & i15;
    }

    public final boolean isClosed() {
        int i;
        i = Long.compare(i2, i3) != 0 ? 1 : 0;
        return i;
    }

    public final boolean isEmpty() {
        int i;
        final kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.Companion;
        long l = LockFreeTaskQueueCore._state$FU.get(this);
        final int i2 = 0;
        final int i13 = 0;
        if ((int)i5 == (int)i10) {
            i = 1;
        }
        return i;
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        int index;
        Object obj;
        int invoke;
        ArrayList arrayList = new ArrayList(this.capacity);
        kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion = LockFreeTaskQueueCore.Companion;
        long l = LockFreeTaskQueueCore._state$FU.get(this);
        final int i = 0;
        final int i13 = 0;
        index = i10;
        while (mask &= index != mask2 &= i12) {
            obj = this.array.get(mask3 &= index);
            if (obj != null && !obj instanceof LockFreeTaskQueueCore.Placeholder) {
            }
            index++;
            if (!obj instanceof LockFreeTaskQueueCore.Placeholder) {
            }
            arrayList.add(transform.invoke(obj));
        }
        return (List)arrayList;
    }

    public final kotlinx.coroutines.internal.LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    public final Object removeFirstOrNull() {
        int singleConsumer2;
        Object cur;
        long l;
        Object element;
        boolean singleConsumer;
        AtomicLongFieldUpdater head;
        Object newHead;
        int i;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore.Companion companion;
        long l2;
        int i6;
        int i4;
        int i2;
        int i3;
        int i5;
        AtomicLongFieldUpdater num;
        Object head2;
        Object obj2;
        Object obj;
        final Object obj3 = this;
        head = LockFreeTaskQueueCore._state$FU;
        newHead = this;
        final int i22 = 0;
        l = head.get(obj3);
        i = 0;
        while (Long.compare(i9, i23) != 0) {
            companion = LockFreeTaskQueueCore.Companion;
            l2 = l;
            i6 = 0;
            singleConsumer2 = i4;
            i5 = 0;
            num = head;
            int atomicfu$handler$iv = 0;
            element = obj3.array.get(mask4 &= singleConsumer2);
            i19 &= i24;
            int i21 = i25;
            head2 = element;
            head = num;
            newHead = obj2;
            l = head.get(obj3);
            i = 0;
            head = num;
        }
        return LockFreeTaskQueueCore.REMOVE_FROZEN;
    }
}
