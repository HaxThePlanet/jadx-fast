package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0086@¢\u0006\u0002\u0010\u0007J\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tJ\u0006\u0010\n\u001a\u00020\u0005R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/ProduceFrameSignal;", "", "()V", "pendingFrameContinuation", "awaitFrameRequest", "", "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestFrameLocked", "Lkotlin/coroutines/Continuation;", "takeFrameRequestLocked", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ProduceFrameSignal {

    private Object pendingFrameContinuation;
    public static final Object access$getPendingFrameContinuation$p(androidx.compose.runtime.ProduceFrameSignal $this) {
        return $this.pendingFrameContinuation;
    }

    public static final void access$setPendingFrameContinuation$p(androidx.compose.runtime.ProduceFrameSignal $this, Object <set-?>) {
        $this.pendingFrameContinuation = <set-?>;
    }

    public final Object awaitFrameRequest(Object lock, Continuation<? super Unit> $completion) {
        int constructor-impl;
        CancellableContinuationImpl cancellableContinuationImpl;
        int i = 0;
        int i2 = 0;
        synchronized (lock) {
            this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();
            return Unit.INSTANCE;
        }
        try {
            ProduceFrameSignal.access$setPendingFrameContinuation$p(this, RecomposerKt.access$getFramePending$p());
            cancellableContinuationImpl = cancellableContinuationImpl3;
            ProduceFrameSignal.access$setPendingFrameContinuation$p(this, cancellableContinuationImpl3);
            cancellableContinuationImpl = 0;
            if (cancellableContinuationImpl != null) {
            }
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)cancellableContinuationImpl.resumeWith(Result.constructor-impl(Unit.INSTANCE));
            Object uCont$iv2 = cancellableContinuationImpl2.getResult();
            if (uCont$iv2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            DebugProbesKt.probeCoroutineSuspended($completion);
            if (uCont$iv2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            return uCont$iv2;
            return Unit.INSTANCE;
            throw th;
            throw uCont$iv;
        } catch (Throwable th) {
        }
    }

    public final Continuation<Unit> requestFrameLocked() {
        int equal;
        int i;
        int i2;
        final Object pendingFrameContinuation = this.pendingFrameContinuation;
        if (pendingFrameContinuation instanceof Continuation) {
            this.pendingFrameContinuation = RecomposerKt.access$getFramePending$p();
            i = pendingFrameContinuation;
            return i;
        } else {
            if (Intrinsics.areEqual(pendingFrameContinuation, RecomposerKt.access$getProduceAnotherFrame$p())) {
                equal = 1;
            } else {
                equal = Intrinsics.areEqual(pendingFrameContinuation, RecomposerKt.access$getFramePending$p());
            }
            i2 = 0;
            if (equal != 0) {
                i = i2;
            } else {
                if (pendingFrameContinuation != null) {
                } else {
                    this.pendingFrameContinuation = RecomposerKt.access$getProduceAnotherFrame$p();
                    i = i2;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("invalid pendingFrameContinuation ").append(pendingFrameContinuation).toString().toString());
        throw illegalStateException;
    }

    public final void takeFrameRequestLocked() {
        int i;
        String $i$a$CheckPreconditionProduceFrameSignal$takeFrameRequestLocked$1;
        i = this.pendingFrameContinuation == RecomposerKt.access$getFramePending$p() ? 1 : 0;
        int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            PreconditionsKt.throwIllegalStateException("frame not pending");
        }
        this.pendingFrameContinuation = 0;
    }
}
