package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.Volatile;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B#\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0006\u0010\u000b\u001a\u00020\u0007R\t\u0010\t\u001a\u00020\nX\u0082\u0004¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlinx/coroutines/CompletedExceptionally;", "continuation", "Lkotlin/coroutines/Continuation;", "cause", "", "handled", "", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "_resumed", "Lkotlinx/atomicfu/AtomicBoolean;", "makeResumed", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CancelledContinuation extends kotlinx.coroutines.CompletedExceptionally {

    private static final AtomicIntegerFieldUpdater _resumed$FU;
    @Volatile
    private volatile int _resumed = 0;
    static {
        CancelledContinuation._resumed$FU = AtomicIntegerFieldUpdater.newUpdater(CancelledContinuation.class, "_resumed");
    }

    public CancelledContinuation(Continuation<?> continuation, Throwable cause, boolean handled) {
        CancellationException cancellationException;
        String string;
        String str;
        if (cause == null) {
            StringBuilder stringBuilder = new StringBuilder();
            cancellationException = new CancellationException(stringBuilder.append("Continuation ").append(continuation).append(" was cancelled normally").toString());
        } else {
            cancellationException = cause;
        }
        super(cancellationException, handled);
        int i = 0;
    }

    @Override // kotlinx.coroutines.CompletedExceptionally
    public final boolean makeResumed() {
        return CancelledContinuation._resumed$FU.compareAndSet(this, 0, 1);
    }
}
