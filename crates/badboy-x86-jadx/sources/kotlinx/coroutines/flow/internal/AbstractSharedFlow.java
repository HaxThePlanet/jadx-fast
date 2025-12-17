package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008 \u0018\u0000*\u000c\u0008\u0000\u0010\u0001*\u0006\u0012\u0002\u0008\u00030\u00022\u00060\u0003j\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J\r\u0010\u0017\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0018J\r\u0010\u0019\u001a\u00028\u0000H$¢\u0006\u0002\u0010\u0018J\u001d\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e2\u0006\u0010\u001b\u001a\u00020\tH$¢\u0006\u0002\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001e0 H\u0084\u0008J\u0015\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010#R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u000f\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e2\u0010\u0010\u0008\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000e@BX\u0084\u000e¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00148F¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006$", d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "S", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "()V", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "<set-?>", "", "nCollectors", "getNCollectors", "()I", "nextIndex", "", "slots", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "allocateSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "createSlot", "createSlotArray", "size", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "forEachSlotLocked", "", "block", "Lkotlin/Function1;", "freeSlot", "slot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AbstractSharedFlow<S extends kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<?>>  {

    private kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;
    public static final int access$getNCollectors(kotlinx.coroutines.flow.internal.AbstractSharedFlow $this) {
        return $this.nCollectors;
    }

    public static final kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] access$getSlots(kotlinx.coroutines.flow.internal.AbstractSharedFlow $this) {
        return $this.slots;
    }

    protected final S allocateSlot() {
        Object[] curSlots;
        Object[] slotArray;
        int index;
        Object[] nCollectors;
        int index2;
        int allocateLocked;
        Object slot;
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot;
        int i;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        final int i5 = 0;
        curSlots = this.slots;
        slotArray = 2;
        synchronized (this) {
            slotArray = createSlotArray(slotArray);
            allocateLocked = 0;
            this.slots = slotArray;
            curSlots = slotArray;
            int i6 = 0;
            index2 = this.nextIndex;
            index = 0;
            try {
                do {
                    index = slot;
                    if (index2++ >= curSlots.length) {
                    }
                    Intrinsics.checkNotNull(index, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                    if (index.allocateLocked(this) == 0) {
                    }
                    index2 = 0;
                    i = 0;
                    curSlots[index2] = createSlot();
                } while (curSlots[index2] == null);
                i = 0;
                curSlots[index2] = createSlot();
                index = slot;
                if (index2++ >= curSlots.length) {
                }
                index2 = 0;
                Intrinsics.checkNotNull(index, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                if (index.allocateLocked(this) == 0) {
                }
                this.nextIndex = index2;
                int i9 = 1;
                this.nCollectors = nCollectors2 += i9;
                kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow _subscriptionCount = this._subscriptionCount;
                if (_subscriptionCount != null) {
                }
                _subscriptionCount.increment(i9);
                return index;
                throw th;
            }
        }
    }

    protected abstract S createSlot();

    protected abstract S[] createSlotArray(int i);

    protected final void forEachSlotLocked(Function1<? super S, Unit> block) {
        int i;
        int length;
        int i2;
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot;
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot abstractSharedFlowSlot2;
        int i3;
        final int i4 = 0;
        if (AbstractSharedFlow.access$getNCollectors(this) == 0) {
        }
        kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot[] objArr = AbstractSharedFlow.access$getSlots(this);
        if (objArr != null) {
            i = 0;
            i2 = 0;
            while (i2 < objArr.length) {
                abstractSharedFlowSlot2 = abstractSharedFlowSlot;
                i3 = 0;
                if (abstractSharedFlowSlot2 != null) {
                }
                i2++;
                block.invoke(abstractSharedFlowSlot2);
            }
        }
    }

    protected final void freeSlot(S slot) {
        int i;
        int constructor-impl;
        int i2;
        int i3 = 0;
        int i4 = 0;
        i = 0;
        constructor-impl = 0;
        final int i6 = -1;
        this.nCollectors = nCollectors += i6;
        kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow subscriptionCount = _subscriptionCount;
        synchronized (this) {
            this.nextIndex = 0;
            Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
            Continuation[] freeLocked = slot.freeLocked(this);
        }
        while (i2 < freeLocked.length) {
            i = freeLocked[i2];
            if (i != 0) {
            }
            i2++;
            kotlin.Result.Companion companion = Result.Companion;
            i.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        if (subscriptionCount != null) {
            subscriptionCount.increment(i6);
        }
    }

    protected final int getNCollectors() {
        return this.nCollectors;
    }

    protected final S[] getSlots() {
        return this.slots;
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow subscriptionCountStateFlow;
        kotlinx.coroutines.flow.internal.SubscriptionCountStateFlow subscriptionCountStateFlow2;
        int i;
        final int i2 = 0;
        final int i3 = 0;
        final int i4 = 0;
        synchronized (this) {
            subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
            i = 0;
            this._subscriptionCount = subscriptionCountStateFlow;
            return (StateFlow)subscriptionCountStateFlow;
        }
    }
}
