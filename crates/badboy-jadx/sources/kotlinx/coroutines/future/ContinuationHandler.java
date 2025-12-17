package kotlinx.coroutines.future;

import java.util.concurrent.CompletionException;
import java.util.function.BiFunction;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0018\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002B\u0015\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J!\u0010\u0008\u001a\u00020\u00042\u0008\u0010\t\u001a\u0004\u0018\u00018\u00002\u0008\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0002\u0010\u000bR\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/future/ContinuationHandler;", "T", "Ljava/util/function/BiFunction;", "", "", "cont", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "apply", "result", "exception", "(Ljava/lang/Object;Ljava/lang/Throwable;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ContinuationHandler<T>  implements BiFunction<T, Throwable, Unit> {

    public volatile Continuation<? super T> cont;
    public ContinuationHandler(Continuation<? super T> cont) {
        super();
        this.cont = cont;
    }

    @Override // java.util.function.BiFunction
    public Object apply(Object p0, Object p1) {
        apply(p0, (Throwable)p1);
        return Unit.INSTANCE;
    }

    public void apply(T result, Throwable exception) {
        Object constructor-impl;
        int cause;
        kotlin.Result.Companion companion;
        final Continuation cont = this.cont;
        if (cont == null) {
        }
        if (exception == null) {
            kotlin.Result.Companion companion2 = Result.Companion;
            cont.resumeWith(Result.constructor-impl(result));
        } else {
            if (exception instanceof CompletionException != null) {
                cause = exception;
            } else {
                cause = 0;
            }
            if (cause != null) {
                if (cause.getCause() == null) {
                    cause = exception;
                }
            } else {
            }
            companion = Result.Companion;
            cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(cause)));
        }
    }
}
