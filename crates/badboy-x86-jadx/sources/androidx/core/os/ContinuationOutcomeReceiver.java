package androidx.core.os;

import android.os.OutcomeReceiver;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\u0008\u0003\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u0005B\u0013\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\u0008J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000cJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000fJ\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/core/os/ContinuationOutcomeReceiver;", "R", "E", "", "Landroid/os/OutcomeReceiver;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "continuation", "Lkotlin/coroutines/Continuation;", "(Lkotlin/coroutines/Continuation;)V", "onError", "", "error", "(Ljava/lang/Throwable;)V", "onResult", "result", "(Ljava/lang/Object;)V", "toString", "", "core-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ContinuationOutcomeReceiver<R, E extends Throwable>  extends AtomicBoolean implements OutcomeReceiver<R, E> {

    private final Continuation<R> continuation;
    public ContinuationOutcomeReceiver(Continuation<? super R> continuation) {
        super(0);
        this.continuation = continuation;
    }

    public void onError(E error) {
        boolean compareAndSet;
        int constructor-impl;
        if (compareAndSet(false, true)) {
            kotlin.Result.Companion companion = Result.Companion;
            this.continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(error)));
        }
    }

    public void onResult(R result) {
        boolean compareAndSet;
        int constructor-impl;
        if (compareAndSet(false, true)) {
            kotlin.Result.Companion companion = Result.Companion;
            this.continuation.resumeWith(Result.constructor-impl(result));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContinuationOutcomeReceiver(outcomeReceived = ").append(get()).append(')').toString();
    }
}
