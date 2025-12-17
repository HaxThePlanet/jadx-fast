package kotlinx.coroutines.flow;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowKt;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0007\u001a\u00020\u00082\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016J\u0011\u0010\n\u001a\u00020\u000bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000cJ'\u0010\r\u001a\u0010\u0012\u000c\u0012\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f0\u000e2\n\u0010\t\u001a\u0006\u0012\u0002\u0008\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000bJ\u0006\u0010\u0012\u001a\u00020\u0008R\u0011\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005X\u0082\u0004\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0013", d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "Lkotlinx/coroutines/flow/StateFlowImpl;", "()V", "_state", "Lkotlinx/atomicfu/AtomicRef;", "", "allocateLocked", "", "flow", "awaitPending", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "freeLocked", "", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StateFlowSlot extends AbstractSharedFlowSlot<kotlinx.coroutines.flow.StateFlowImpl<?>> {

    private static final AtomicReferenceFieldUpdater _state$FU;
    @Volatile
    private volatile Object _state;
    static {
        StateFlowSlot._state$FU = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    }

    public static final AtomicReferenceFieldUpdater access$get_state$FU$p() {
        return StateFlowSlot._state$FU;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public boolean allocateLocked(Object flow) {
        return allocateLocked((StateFlowImpl)flow);
    }

    public boolean allocateLocked(kotlinx.coroutines.flow.StateFlowImpl<?> flow) {
        if (StateFlowSlot._state$FU.get(this) != null) {
            return 0;
        }
        StateFlowSlot._state$FU.set(this, StateFlowKt.access$getNONE$p());
        return 1;
    }

    public final Object awaitPending(Continuation<? super Unit> $completion) {
        int i;
        boolean aSSERTIONS_ENABLED2;
        boolean constructor-impl;
        boolean aSSERTIONS_ENABLED;
        boolean z;
        Object symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        int i2 = 0;
        int i3 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        final int i4 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED2 = 0;
            if (obj instanceof CancellableContinuationImpl) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(StateFlowSlot.access$get_state$FU$p(), this, StateFlowKt.access$getNONE$p(), (CancellableContinuation)cancellableContinuationImpl2) && DebugKt.getASSERTIONS_ENABLED()) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                if (StateFlowSlot.access$get_state$FU$p().get(this) == StateFlowKt.access$getPENDING$p()) {
                } else {
                    i = 0;
                }
                if (i == 0) {
                } else {
                }
                AssertionError assertionError2 = new AssertionError();
                throw assertionError2;
            }
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)cancellableContinuationImpl2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
        }
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public Continuation[] freeLocked(Object flow) {
        return freeLocked((StateFlowImpl)flow);
    }

    public Continuation<Unit>[] freeLocked(kotlinx.coroutines.flow.StateFlowImpl<?> flow) {
        StateFlowSlot._state$FU.set(this, 0);
        return AbstractSharedFlowKt.EMPTY_RESUMES;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final void makePending() {
        Object obj;
        int i;
        boolean z;
        kotlinx.coroutines.internal.Symbol symbol;
        final Object obj2 = this;
        final int i2 = 0;
        obj = StateFlowSlot._state$FU.get(this);
        i = 0;
        while (obj == null) {
            obj = _state$FU.get(this);
            i = 0;
        }
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    public final boolean takePending() {
        boolean aSSERTIONS_ENABLED;
        int i;
        boolean z;
        Object andSet = StateFlowSlot._state$FU.getAndSet(this, StateFlowKt.access$getNONE$p());
        Intrinsics.checkNotNull(andSet);
        int i2 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (andSet instanceof CancellableContinuationImpl) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        i = andSet == StateFlowKt.access$getPENDING$p() ? 1 : 0;
        return i;
    }
}
