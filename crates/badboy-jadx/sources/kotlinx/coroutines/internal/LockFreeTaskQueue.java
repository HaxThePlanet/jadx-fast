package kotlinx.coroutines.internal;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0010\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0004J&\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u0002H\u00180\u0017\"\u0004\u0008\u0001\u0010\u00182\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00180\u001aJ\r\u0010\u001b\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001cR\u001f\u0010\u0006\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00028\u00000\u0008j\u0008\u0012\u0004\u0012\u00028\u0000`\t0\u0007X\u0082\u0004R\u0011\u0010\n\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u001d", d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueue;", "E", "", "singleConsumer", "", "(Z)V", "_cur", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Lkotlinx/coroutines/internal/Core;", "isEmpty", "()Z", "size", "", "getSize", "()I", "addLast", "element", "(Ljava/lang/Object;)Z", "close", "", "isClosed", "map", "", "R", "transform", "Lkotlin/Function1;", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class LockFreeTaskQueue<E>  {

    private static final AtomicReferenceFieldUpdater _cur$FU;
    @Volatile
    private volatile Object _cur;
    static {
        LockFreeTaskQueue._cur$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueue.class, Object.class, "_cur");
    }

    public LockFreeTaskQueue(boolean singleConsumer) {
        super();
        LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, singleConsumer);
        this._cur = lockFreeTaskQueueCore;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    public final boolean addLast(E element) {
        Object obj;
        int i;
        AtomicReferenceFieldUpdater _cur$FU;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore next;
        final Object obj2 = this;
        final int i2 = 0;
        while (/* condition */) {
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueue._cur$FU, this, obj, obj.next());
            obj = LockFreeTaskQueue._cur$FU.get(this);
            i = 0;
        }
        return 1;
    }

    public final void close() {
        Object obj;
        int i;
        AtomicReferenceFieldUpdater _cur$FU;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore next;
        final Object obj2 = this;
        final int i2 = 0;
        obj = LockFreeTaskQueue._cur$FU.get(this);
        i = 0;
        while ((LockFreeTaskQueueCore)obj.close()) {
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueue._cur$FU, this, obj, obj.next());
            obj = _cur$FU2.get(this);
            i = 0;
        }
    }

    public final int getSize() {
        return (LockFreeTaskQueueCore)LockFreeTaskQueue._cur$FU.get(this).getSize();
    }

    public final boolean isClosed() {
        return (LockFreeTaskQueueCore)LockFreeTaskQueue._cur$FU.get(this).isClosed();
    }

    public final boolean isEmpty() {
        return (LockFreeTaskQueueCore)LockFreeTaskQueue._cur$FU.get(this).isEmpty();
    }

    public final <R> List<R> map(Function1<? super E, ? extends R> transform) {
        return (LockFreeTaskQueueCore)LockFreeTaskQueue._cur$FU.get(this).map(transform);
    }

    public final E removeFirstOrNull() {
        Object obj;
        int i;
        Object firstOrNull;
        AtomicReferenceFieldUpdater _cur$FU;
        kotlinx.coroutines.internal.LockFreeTaskQueueCore next;
        final Object obj2 = this;
        final int i2 = 0;
        obj = LockFreeTaskQueue._cur$FU.get(this);
        i = 0;
        firstOrNull = (LockFreeTaskQueueCore)obj.removeFirstOrNull();
        while (firstOrNull != LockFreeTaskQueueCore.REMOVE_FROZEN) {
            AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(LockFreeTaskQueue._cur$FU, this, obj, obj.next());
            obj = _cur$FU2.get(this);
            i = 0;
            firstOrNull = (LockFreeTaskQueueCore)obj.removeFirstOrNull();
        }
        return firstOrNull;
    }
}
