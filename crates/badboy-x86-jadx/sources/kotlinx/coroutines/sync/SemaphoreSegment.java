package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.ChannelSegment$$ExternalSyntheticBackportWithForwarding0;
import kotlinx.coroutines.internal.Segment;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0086\u0008J\u0013\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0008J\u001d\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0086\u0008J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001b\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0086\u0008J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016R\u000e\u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\tR\u0014\u0010\u000b\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/sync/SemaphoreSegment;", "Lkotlinx/coroutines/internal/Segment;", "id", "", "prev", "pointers", "", "(JLkotlinx/coroutines/sync/SemaphoreSegment;I)V", "acquirers", "Lkotlinx/atomicfu/AtomicArray;", "", "numberOfSlots", "getNumberOfSlots", "()I", "cas", "", "index", "expected", "value", "get", "getAndSet", "onCancellation", "", "cause", "", "context", "Lkotlin/coroutines/CoroutineContext;", "set", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SemaphoreSegment extends Segment<kotlinx.coroutines.sync.SemaphoreSegment> {

    private final AtomicReferenceArray acquirers;
    public SemaphoreSegment(long id, kotlinx.coroutines.sync.SemaphoreSegment prev, int pointers) {
        super(id, prev, (Segment)pointers, obj6);
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(SemaphoreKt.access$getSEGMENT_SIZE$p());
        this.acquirers = atomicReferenceArray;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final boolean cas(int index, Object expected, Object value) {
        final int i = 0;
        return ChannelSegment$$ExternalSyntheticBackportWithForwarding0.m(getAcquirers(), index, expected, value);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final Object get(int index) {
        final int i = 0;
        return getAcquirers().get(index);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final AtomicReferenceArray getAcquirers() {
        return this.acquirers;
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final Object getAndSet(int index, Object value) {
        final int i = 0;
        return getAcquirers().getAndSet(index, value);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public int getNumberOfSlots() {
        return SemaphoreKt.access$getSEGMENT_SIZE$p();
    }

    @Override // kotlinx.coroutines.internal.Segment
    public void onCancellation(int index, Throwable cause, CoroutineContext context) {
        final int i = 0;
        this.getAcquirers().set(index, SemaphoreKt.access$getCANCELLED$p());
        onSlotCleaned();
    }

    @Override // kotlinx.coroutines.internal.Segment
    public final void set(int index, Object value) {
        final int i = 0;
        getAcquirers().set(index, value);
    }

    @Override // kotlinx.coroutines.internal.Segment
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SemaphoreSegment[id=").append(this.id).append(", hashCode=").append(hashCode()).append(']').toString();
    }
}
