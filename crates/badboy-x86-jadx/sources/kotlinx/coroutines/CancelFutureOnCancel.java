package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CancelFutureOnCancel extends kotlinx.coroutines.CancelHandler {

    private final Future<?> future;
    public CancelFutureOnCancel(Future<?> future) {
        super();
        this.future = future;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public Object invoke(Object p1) {
        invoke((Throwable)p1);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.CancelHandler
    public void invoke(Throwable cause) {
        Future future;
        int i;
        if (cause != null) {
            this.future.cancel(false);
        }
    }

    @Override // kotlinx.coroutines.CancelHandler
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CancelFutureOnCancel[").append(this.future).append(']').toString();
    }
}
