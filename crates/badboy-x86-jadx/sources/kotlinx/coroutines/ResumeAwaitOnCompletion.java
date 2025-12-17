package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"Lkotlinx/coroutines/ResumeAwaitOnCompletion;", "T", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "(Lkotlinx/coroutines/CancellableContinuationImpl;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ResumeAwaitOnCompletion<T>  extends kotlinx.coroutines.JobNode {

    private final kotlinx.coroutines.CancellableContinuationImpl<T> continuation;
    public ResumeAwaitOnCompletion(kotlinx.coroutines.CancellableContinuationImpl<? super T> continuation) {
        super();
        this.continuation = continuation;
    }

    @Override // kotlinx.coroutines.JobNode
    public Object invoke(Object p1) {
        invoke((Throwable)p1);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(Throwable cause) {
        boolean aSSERTIONS_ENABLED;
        kotlinx.coroutines.CancellableContinuationImpl continuation;
        boolean z;
        Object constructor-impl;
        Object state$kotlinx_coroutines_core = getJob().getState$kotlinx_coroutines_core();
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (state$kotlinx_coroutines_core instanceof Incomplete) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            kotlin.Result.Companion companion2 = Result.Companion;
            (Continuation)this.continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(obj.cause)));
        } else {
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)this.continuation.resumeWith(Result.constructor-impl(JobSupportKt.unboxState(state$kotlinx_coroutines_core)));
        }
    }
}
