package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u0002H\u00010\u0002J\u0014\u0010\u0008\u001a\u00020\u00042\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH'J\u0008\u0010\u000f\u001a\u00020\u000cH'J1\u0010\u0010\u001a\u00020\u000c2'\u0010\u0011\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\u000c0\u0012j\u0002`\u0015H&J:\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u0017\u001a\u00028\u00002#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u0012H'¢\u0006\u0002\u0010\u0019J#\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00028\u00002\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000eH'¢\u0006\u0002\u0010\u001cJF\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0017\u001a\u00028\u00002\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u000e2#\u0010\u0018\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0013\u0012\u0008\u0008\u0014\u0012\u0004\u0008\u0008(\t\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u0012H'¢\u0006\u0002\u0010\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001f\u001a\u00020\nH'J\u0019\u0010 \u001a\u00020\u000c*\u00020!2\u0006\u0010\u0017\u001a\u00028\u0000H'¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\u000c*\u00020!2\u0006\u0010\u001f\u001a\u00020\nH'R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0005R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005¨\u0006$", d2 = {"Lkotlinx/coroutines/CancellableContinuation;", "T", "Lkotlin/coroutines/Continuation;", "isActive", "", "()Z", "isCancelled", "isCompleted", "cancel", "cause", "", "completeResume", "", "token", "", "initCancellability", "invokeOnCancellation", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "resume", "value", "onCancellation", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "tryResume", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "tryResumeWithException", "exception", "resumeUndispatched", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;Ljava/lang/Object;)V", "resumeUndispatchedWithException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface CancellableContinuation<T>  extends Continuation<T> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean cancel$default(kotlinx.coroutines.CancellableContinuation cancellableContinuation, Throwable throwable2, int i3, Object object4) {
            int obj1;
            if (object4 != null) {
            } else {
                if (i3 &= 1 != 0) {
                    obj1 = 0;
                }
                return cancellableContinuation.cancel(obj1);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            throw obj0;
        }

        public static Object tryResume$default(kotlinx.coroutines.CancellableContinuation cancellableContinuation, Object object2, Object object3, int i4, Object object5) {
            int obj2;
            if (object5 != null) {
            } else {
                if (i4 &= 2 != 0) {
                    obj2 = 0;
                }
                return cancellableContinuation.tryResume(object2, obj2);
            }
            UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
            throw obj0;
        }
    }
    @Override // kotlin.coroutines.Continuation
    public abstract boolean cancel(Throwable throwable);

    @Override // kotlin.coroutines.Continuation
    public abstract void completeResume(Object object);

    @Override // kotlin.coroutines.Continuation
    public abstract void initCancellability();

    public abstract void invokeOnCancellation(Function1<? super Throwable, Unit> function1);

    @Override // kotlin.coroutines.Continuation
    public abstract boolean isActive();

    @Override // kotlin.coroutines.Continuation
    public abstract boolean isCancelled();

    @Override // kotlin.coroutines.Continuation
    public abstract boolean isCompleted();

    public abstract void resume(T t, Function1<? super Throwable, Unit> function12);

    public abstract void resumeUndispatched(kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, T t2);

    @Override // kotlin.coroutines.Continuation
    public abstract void resumeUndispatchedWithException(kotlinx.coroutines.CoroutineDispatcher coroutineDispatcher, Throwable throwable2);

    public abstract Object tryResume(T t, Object object2);

    public abstract Object tryResume(T t, Object object2, Function1<? super Throwable, Unit> function13);

    @Override // kotlin.coroutines.Continuation
    public abstract Object tryResumeWithException(Throwable throwable);
}
