package kotlin.coroutines.jvm.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u0002J\u001b\u0010\u000f\u001a\u00020\u00022\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00020\tH\u0016¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R%\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tX\u0086\u000eø\u0001\u0000¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\r\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u0011", d2 = {"Lkotlin/coroutines/jvm/internal/RunSuspend;", "Lkotlin/coroutines/Continuation;", "", "()V", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "result", "Lkotlin/Result;", "getResult-xLWZpok", "()Lkotlin/Result;", "setResult", "(Lkotlin/Result;)V", "await", "resumeWith", "(Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class RunSuspend implements Continuation<Unit> {

    private Result<Unit> result;
    @Override // kotlin.coroutines.Continuation
    public final void await() {
        Result result;
        Object obj;
        final int i = 0;
        synchronized (this) {
            result = this.result;
            while (result == null) {
                Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                (Object)this.wait();
                result = this.result;
            }
            try {
                ResultKt.throwOnFailure(result.unbox-impl());
                throw th;
            }
        }
    }

    @Override // kotlin.coroutines.Continuation
    public CoroutineContext getContext() {
        return (CoroutineContext)EmptyCoroutineContext.INSTANCE;
    }

    public final Result<Unit> getResult-xLWZpok() {
        return this.result;
    }

    @Override // kotlin.coroutines.Continuation
    public void resumeWith(Object result) {
        int i = 0;
        this.result = Result.box-impl(result);
        Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
        (Object)this.notifyAll();
        Unit $i$a$SynchronizedRunSuspend$resumeWith$1 = Unit.INSTANCE;
        return;
        synchronized (this) {
            i = 0;
            this.result = Result.box-impl(result);
            Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
            (Object)this.notifyAll();
            $i$a$SynchronizedRunSuspend$resumeWith$1 = Unit.INSTANCE;
        }
    }

    public final void setResult(Result<Unit> <set-?>) {
        this.result = <set-?>;
    }
}
