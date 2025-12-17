package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.d;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\u0008\u0000\u0018\u00002\u00020\u000cB%\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0001\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008J\r\u0010\t\u001a\u00020\u0005¢\u0006\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/CancelledContinuation;", "Lkotlin/coroutines/Continuation;", "continuation", "", "cause", "", "handled", "<init>", "(Lkotlin/coroutines/Continuation;Ljava/lang/Throwable;Z)V", "makeResumed", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/CompletedExceptionally;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t extends kotlinx.coroutines.b0 {

    private static final AtomicIntegerFieldUpdater c;
    private volatile int _resumed = 0;
    static {
        t.c = AtomicIntegerFieldUpdater.newUpdater(t.class, "_resumed");
    }

    public t(d<?> d, Throwable throwable2, boolean z3) {
        StringBuilder stringBuilder;
        String str;
        Object obj3;
        CancellationException obj4;
        if (throwable2 == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Continuation ");
            stringBuilder.append(d);
            stringBuilder.append(" was cancelled normally");
            obj4 = new CancellationException(stringBuilder.toString());
        }
        super(obj4, z3);
        obj3 = 0;
    }

    @Override // kotlinx.coroutines.b0
    public final boolean c() {
        return t.c.compareAndSet(this, 0, 1);
    }
}
