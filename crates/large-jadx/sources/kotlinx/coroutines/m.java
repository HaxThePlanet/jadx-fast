package kotlinx.coroutines;

import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002J\u0008\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/CancelFutureOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "future", "Ljava/util/concurrent/Future;", "(Ljava/util/concurrent/Future;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class m extends kotlinx.coroutines.n {

    private final Future<?> a;
    public m(Future<?> future) {
        super();
        this.a = future;
    }

    @Override // kotlinx.coroutines.n
    public void a(Throwable throwable) {
        int i;
        Future obj2;
        if (throwable != null) {
            this.a.cancel(false);
        }
    }

    @Override // kotlinx.coroutines.n
    public Object invoke(Object object) {
        a((Throwable)object);
        return w.a;
    }

    @Override // kotlinx.coroutines.n
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CancelFutureOnCancel[");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
