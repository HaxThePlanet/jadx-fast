package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00042\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lkotlinx/coroutines/ResumeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "continuation", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/coroutines/Continuation;)V", "invoke", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ResumeOnCompletion extends kotlinx.coroutines.JobNode {

    private final Continuation<Unit> continuation;
    public ResumeOnCompletion(Continuation<? super Unit> continuation) {
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
        kotlin.Result.Companion companion = Result.Companion;
        this.continuation.resumeWith(Result.constructor-impl(Unit.INSTANCE));
    }
}
