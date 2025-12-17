package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\u0008\u0002\u0018\u00002\u00020\u000fB0\u0012'\u0010\u0008\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007¢\u0006\u0004\u0008\t\u0010\nJ\u001a\u0010\u000b\u001a\u00020\u00062\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cR5\u0010\u0008\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\r¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/InvokeOnCancelling;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "handler", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "(Ljava/lang/Throwable;)V", "Lkotlin/jvm/functions/Function1;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/JobCancellingNode;"}, k = 1, mv = {1, 5, 1}, xi = 48)
final class w1 extends kotlinx.coroutines.z1 {

    private static final AtomicIntegerFieldUpdater x;
    private volatile int _invoked = 0;
    private final l<Throwable, w> w;
    static {
        w1.x = AtomicIntegerFieldUpdater.newUpdater(w1.class, "_invoked");
    }

    public w1(l<? super Throwable, w> l) {
        super();
        this.w = l;
        final int obj1 = 0;
    }

    @Override // kotlinx.coroutines.z1
    public Object invoke(Object object) {
        y((Throwable)object);
        return w.a;
    }

    @Override // kotlinx.coroutines.z1
    public void y(Throwable throwable) {
        boolean compareAndSet;
        if (w1.x.compareAndSet(this, 0, 1)) {
            this.w.invoke(throwable);
        }
    }
}
