package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlinx.coroutines.q0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0016\u0008\u0000\u0018\u0000 /*\u0008\u0008\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ'\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\u0008\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J'\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\u0008\u0012\u0004\u0012\u00028\u0000`\u000e2\u0006\u0010\r\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u0011\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\u0008\u0012\u0010\u0013J3\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\t\u001a\u00028\u0000H\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0005¢\u0006\u0004\u0008\u0017\u0010\u0013J-\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u001b\"\u0004\u0008\u0001\u0010\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0019¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0013\u0010 \u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\u0008 \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\u0008\"\u0010#J3\u0010&\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000e2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008&\u0010'R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0004\u0010(R\u0011\u0010)\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008)\u0010\u0013R\u0014\u0010*\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008*\u0010(R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010+R\u0011\u0010.\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008,\u0010-¨\u00061", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "", "E", "", "capacity", "", "singleConsumer", "<init>", "(IZ)V", "element", "addLast", "(Ljava/lang/Object;)I", "", "state", "Lkotlinx/coroutines/internal/Core;", "allocateNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateOrGetNextCopy", "close", "()Z", "index", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "isClosed", "R", "Lkotlin/Function1;", "transform", "", "map", "(Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "markFrozen", "()J", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "removeFirstOrNull", "()Ljava/lang/Object;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "isEmpty", "mask", "Z", "getSize", "()I", "size", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q<E>  {

    public static final kotlinx.coroutines.internal.q.a e;
    private static final AtomicReferenceFieldUpdater f;
    private static final AtomicLongFieldUpdater g;
    public static final kotlinx.coroutines.internal.z h;
    private volatile Object _next = null;
    private volatile long _state = 0;
    private final int a;
    private final boolean b;
    private final int c;
    private AtomicReferenceArray d;

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0016\u001a\u00020\u0004*\u00020\tJ\u0012\u0010\u0017\u001a\u00020\t*\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0004J\u0012\u0010\u0019\u001a\u00020\t*\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0004JP\u0010\u001b\u001a\u0002H\u001c\"\u0004\u0008\u0001\u0010\u001c*\u00020\t26\u0010\u001d\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(!\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001f\u0012\u0008\u0008 \u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\u0008¢\u0006\u0002\u0010#J\u0015\u0010$\u001a\u00020\t*\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0086\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", "", "()V", "ADD_CLOSED", "", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "addFailReason", "updateHead", "newHead", "updateTail", "newTail", "withState", "T", "block", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "head", "tail", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "wo", "other", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final int a(long l) {
            int obj3;
            obj3 = Long.compare(obj3, i) != 0 ? 2 : 1;
            return obj3;
        }

        public final long b(long l, int i2) {
            return obj3 |= i3;
        }

        public final long c(long l, int i2) {
            return obj3 |= i;
        }

        public final long d(long l, long l2) {
            return l &= obj3;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", "", "index", "", "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {

        public final int a;
        public b(int i) {
            super();
            this.a = i;
        }
    }
    static {
        Class<kotlinx.coroutines.internal.q> obj = q.class;
        q.a aVar = new q.a(0);
        q.e = aVar;
        z zVar = new z("REMOVE_FROZEN");
        q.h = zVar;
        q.f = AtomicReferenceFieldUpdater.newUpdater(obj, Object.class, "_next");
        q.g = AtomicLongFieldUpdater.newUpdater(obj, "_state");
    }

    public q(int i, boolean z2) {
        int i3;
        int i2;
        super();
        this.a = i;
        this.b = z2;
        int obj6 = i + -1;
        this.c = obj6;
        int i4 = 0;
        int i5 = 0;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
        this.d = atomicReferenceArray;
        final int i6 = 1;
        i2 = obj6 <= 1073741823 ? i6 : i3;
        final String str = "Check failed.";
        if (i2 == 0) {
        } else {
            i3 = i &= obj6 == 0 ? i6 : i3;
            if (i3 == 0) {
            } else {
            }
            IllegalStateException obj5 = new IllegalStateException(str.toString());
            throw obj5;
        }
        obj5 = new IllegalStateException(str.toString());
        throw obj5;
    }

    private final kotlinx.coroutines.internal.q<E> b(long l) {
        int i3;
        int bVar;
        int i;
        int i2;
        q qVar = new q(i4 *= 2, this.b);
        i3 = (int)i8;
        int i12 = this.c;
        while (i3 & i12 != i11 & i12) {
            if (this.d.get(i12 &= i3) == null) {
            }
            qVar.d.set(i16 &= i3, bVar);
            i3++;
            i12 = this.c;
            bVar = new q.b(i3);
        }
        qVar._state = q.e.d(l, obj8);
        return qVar;
    }

    private final kotlinx.coroutines.internal.q<E> c(long l) {
        Object _next = this._next;
        while ((q)_next != null) {
            q.f.compareAndSet(this, 0, b(l));
            _next = this._next;
        }
        return (q)(q)_next;
    }

    private final kotlinx.coroutines.internal.q<E> e(int i, E e2) {
        Object obj;
        obj = this.d.get(i2 &= i);
        if (obj instanceof q.b && obj.a == i) {
            if (obj.a == i) {
                this.d.set(i &= i4, e2);
                return this;
            }
        }
        return 0;
    }

    private final long h() {
        final long _state = this._state;
        long l = 1152921504606846976L;
        while (Long.compare(i, i3) != 0) {
            int i4 = _state | l;
            _state = this._state;
            l = 1152921504606846976L;
        }
        return _state;
    }

    private final kotlinx.coroutines.internal.q<E> k(int i, int i2) {
        int i3;
        final long _state = this._state;
        final int i9 = (int)i7;
        while (q0.a()) {
            if (i9 == i) {
            }
            _state = this._state;
            i9 = (int)i7;
            i3 = 1;
        }
        AssertionError obj10 = new AssertionError();
        throw obj10;
    }

    public final int a(E e) {
        boolean compareAndSet;
        Object obj;
        Object obj2;
        int cmp;
        long _state;
        int i;
        long l;
        int i2;
        int i3;
        int i5;
        int i4;
        long l2;
        int i6;
        _state = this._state;
        final int i19 = 0;
        while (Long.compare(i7, i19) != 0) {
            i3 = 0;
            obj2 = (int)i13;
            i5 = (int)i15;
            i4 = this.c;
            l2 = 1;
            i2 = 1073741823;
            _state = this._state;
            i19 = 0;
            compareAndSet = this.a;
        }
        return q.e.a(_state);
    }

    public final boolean d() {
        final long _state = this._state;
        long l = 2305843009213693952L;
        final int i5 = 0;
        final int i6 = 1;
        while (Long.compare(i2, i5) != 0) {
            _state = this._state;
            l = 2305843009213693952L;
            i5 = 0;
            i6 = 1;
        }
        return i6;
    }

    public final int f() {
        long _state = this._state;
        return i4 &= i6;
    }

    public final boolean g() {
        int i;
        long _state = this._state;
        if ((int)i7 == (int)i3) {
            i = 1;
        }
        return i;
    }

    public final kotlinx.coroutines.internal.q<E> i() {
        return c(h());
    }

    public final Object j() {
        boolean z;
        Object obj;
        Object obj3;
        long l;
        int i3;
        int i2;
        int i4;
        Object obj2;
        int i;
        final long _state = this._state;
        while (Long.compare(i5, i13) != 0) {
            i2 = (int)i16;
            int i19 = this.c;
            i3 = i2 & i19;
            i4 = 0;
            obj2 = this.d.get(i19 &= i2);
            i = i10 & i20;
            _state = this._state;
        }
        return q.h;
    }
}
