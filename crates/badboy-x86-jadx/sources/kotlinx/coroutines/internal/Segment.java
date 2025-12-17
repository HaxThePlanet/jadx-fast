package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.Volatile;
import kotlinx.coroutines.NotCompleted;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008 \u0018\u0000*\u000e\u0008\u0000\u0010\u0001*\u0008\u0012\u0004\u0012\u0002H\u00010\u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\r\u0010\u0012\u001a\u00020\rH\u0000¢\u0006\u0002\u0008\u0013J\"\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00082\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0006\u0010\u001b\u001a\u00020\u0015J\r\u0010\u001c\u001a\u00020\rH\u0000¢\u0006\u0002\u0008\u001dR\t\u0010\n\u001a\u00020\u000bX\u0082\u0004R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0008X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/coroutines/NotCompleted;", "id", "", "prev", "pointers", "", "(JLkotlinx/coroutines/internal/Segment;I)V", "cleanedAndPointers", "Lkotlinx/atomicfu/AtomicInt;", "isRemoved", "", "()Z", "numberOfSlots", "getNumberOfSlots", "()I", "decPointers", "decPointers$kotlinx_coroutines_core", "onCancellation", "", "index", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "onSlotCleaned", "tryIncPointers", "tryIncPointers$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Segment<S extends kotlinx.coroutines.internal.Segment<S>>  extends kotlinx.coroutines.internal.ConcurrentLinkedListNode<S> implements NotCompleted {

    private static final AtomicIntegerFieldUpdater cleanedAndPointers$FU;
    @Volatile
    private volatile int cleanedAndPointers;
    public final long id;
    static {
        Segment.cleanedAndPointers$FU = AtomicIntegerFieldUpdater.newUpdater(Segment.class, "cleanedAndPointers");
    }

    public Segment(long id, S prev, int pointers) {
        super((ConcurrentLinkedListNode)pointers);
        this.id = id;
        this.cleanedAndPointers = obj5 << 16;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public final boolean decPointers$kotlinx_coroutines_core() {
        int andGet;
        int i;
        if (Segment.cleanedAndPointers$FU.addAndGet(this, -65536) == getNumberOfSlots() && !isTail()) {
            i = !isTail() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public abstract int getNumberOfSlots();

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public boolean isRemoved() {
        int tail;
        int i;
        if (Segment.cleanedAndPointers$FU.get(this) == getNumberOfSlots() && !isTail()) {
            i = !isTail() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public abstract void onCancellation(int i, Throwable throwable2, CoroutineContext coroutineContext3);

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public final void onSlotCleaned() {
        if (Segment.cleanedAndPointers$FU.incrementAndGet(this) == getNumberOfSlots()) {
            remove();
        }
    }

    @Override // kotlinx.coroutines.internal.ConcurrentLinkedListNode
    public final boolean tryIncPointers$kotlinx_coroutines_core() {
        int i4;
        boolean it;
        int i;
        boolean numberOfSlots;
        int i2;
        int i3;
        final AtomicIntegerFieldUpdater cleanedAndPointers$FU = Segment.cleanedAndPointers$FU;
        final int i6 = 0;
        i4 = cleanedAndPointers$FU.get(this);
        i = 0;
        i3 = 1;
        while (i4 == getNumberOfSlots()) {
            if (isTail()) {
            } else {
            }
            it = i2;
            i4 = cleanedAndPointers$FU.get(this);
            i = 0;
            i3 = 1;
            it = i3;
        }
        return i2;
    }
}
