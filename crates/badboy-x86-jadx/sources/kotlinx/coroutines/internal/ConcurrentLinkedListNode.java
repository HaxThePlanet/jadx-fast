package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0006\u0008 \u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00002\u00020\u0002B\u000f\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000eJ\u001e\u0010\u001a\u001a\u0004\u0018\u00018\u00002\u000c\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001cH\u0086\u0008¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0018J\u0013\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00028\u0000¢\u0006\u0002\u0010\"R\u0011\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006X\u0082\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0006X\u0082\u0004R\u0016\u0010\u0008\u001a\u0004\u0018\u00018\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00028\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\nR\u0012\u0010\r\u001a\u00020\u000eX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000fR\u0013\u0010\u0011\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\n¨\u0006#", d2 = {"Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "", "prev", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)V", "_next", "Lkotlinx/atomicfu/AtomicRef;", "_prev", "aliveSegmentLeft", "getAliveSegmentLeft", "()Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "aliveSegmentRight", "getAliveSegmentRight", "isRemoved", "", "()Z", "isTail", "next", "getNext", "nextOrClosed", "getNextOrClosed", "()Ljava/lang/Object;", "getPrev", "cleanPrev", "", "markAsClosed", "nextOrIfClosed", "onClosedAction", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "remove", "trySetNext", "value", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Z", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ConcurrentLinkedListNode<N extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<N>>  {

    private static final AtomicReferenceFieldUpdater _next$FU;
    private static final AtomicReferenceFieldUpdater _prev$FU;
    @Volatile
    private volatile Object _next;
    @Volatile
    private volatile Object _prev;
    static {
        final Class<kotlinx.coroutines.internal.ConcurrentLinkedListNode> obj3 = ConcurrentLinkedListNode.class;
        ConcurrentLinkedListNode._next$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_next");
        ConcurrentLinkedListNode._prev$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_prev");
    }

    public ConcurrentLinkedListNode(N prev) {
        super();
        this._prev = prev;
    }

    public static final Object access$getNextOrClosed(kotlinx.coroutines.internal.ConcurrentLinkedListNode $this) {
        return $this.getNextOrClosed();
    }

    private final N getAliveSegmentLeft() {
        kotlinx.coroutines.internal.ConcurrentLinkedListNode cur;
        Object removed;
        cur = getPrev();
        while (cur != null) {
            if (cur.isRemoved()) {
            }
            cur = removed;
        }
        return cur;
    }

    private final N getAliveSegmentRight() {
        boolean aSSERTIONS_ENABLED;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode cur;
        boolean tail;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (isTail()) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        Intrinsics.checkNotNull(getNext());
        while (cur.isRemoved()) {
            tail = cur.getNext();
            cur = tail;
        }
        return cur;
    }

    private final Object getNextOrClosed() {
        return ConcurrentLinkedListNode._next$FU.get(this);
    }

    private final void update$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function12, Object object3) {
        boolean z;
        Object invoke;
        final int i = 0;
        Object obj = atomicReferenceFieldUpdater.get(object3);
        while (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object3, obj, function12.invoke(obj))) {
            obj = atomicReferenceFieldUpdater.get(object3);
        }
    }

    public final void cleanPrev() {
        ConcurrentLinkedListNode._prev$FU.lazySet(this, 0);
    }

    public final N getNext() {
        final int i = 0;
        final Object obj = ConcurrentLinkedListNode.access$getNextOrClosed(this);
        final int i2 = 0;
        if (obj == ConcurrentLinkedListKt.access$getCLOSED$p()) {
            int i3 = 0;
            return 0;
        }
        return (ConcurrentLinkedListNode)obj;
    }

    public final N getPrev() {
        return (ConcurrentLinkedListNode)ConcurrentLinkedListNode._prev$FU.get(this);
    }

    public abstract boolean isRemoved();

    public final boolean isTail() {
        int i;
        i = getNext() == null ? 1 : 0;
        return i;
    }

    public final boolean markAsClosed() {
        return AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ConcurrentLinkedListNode._next$FU, this, 0, ConcurrentLinkedListKt.access$getCLOSED$p());
    }

    public final N nextOrIfClosed(Function0 onClosedAction) {
        final int i = 0;
        final Object obj = ConcurrentLinkedListNode.access$getNextOrClosed(this);
        final int i2 = 0;
        if (obj == ConcurrentLinkedListKt.access$getCLOSED$p()) {
        } else {
            return (ConcurrentLinkedListNode)obj;
        }
        onClosedAction.invoke();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public final void remove() {
        boolean aSSERTIONS_ENABLED;
        boolean aliveSegmentLeft;
        int aliveSegmentRight;
        boolean removed2;
        boolean removed;
        AtomicReferenceFieldUpdater _prev$FU;
        Object obj2;
        int i2;
        boolean z2;
        Object obj;
        int i;
        boolean z;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (!isRemoved()) {
                if (isTail()) {
                    aliveSegmentRight = 1;
                } else {
                    aliveSegmentRight = 0;
                }
            } else {
            }
            if (aliveSegmentRight == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (isTail()) {
        }
        while (/* condition */) {
            Object obj3 = _prev$FU.get(aliveSegmentRight);
            i = 0;
            do {
                obj3 = _prev$FU.get(aliveSegmentRight);
                i = 0;
                z = aliveSegmentLeft;
                if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_prev$FU, aliveSegmentRight, obj3, z)) {
                }
                z = 0;
            } while ((ConcurrentLinkedListNode)obj3 == null);
            z = aliveSegmentLeft;
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(_prev$FU, aliveSegmentRight, obj3, z)) {
            }
            if (aliveSegmentLeft) {
            }
            if (aliveSegmentRight.isRemoved()) {
            }
            if (aliveSegmentLeft) {
            }
            if (aliveSegmentLeft.isRemoved()) {
            }
            aliveSegmentLeft = getAliveSegmentLeft();
            aliveSegmentRight = getAliveSegmentRight();
            _prev$FU = ConcurrentLinkedListNode._prev$FU;
            obj2 = this;
            i2 = 0;
            if (!aliveSegmentRight.isTail()) {
            }
            ConcurrentLinkedListNode._next$FU.set(aliveSegmentLeft, aliveSegmentRight);
            z = 0;
        }
    }

    public final boolean trySetNext(N value) {
        return AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(ConcurrentLinkedListNode._next$FU, this, 0, value);
    }
}
