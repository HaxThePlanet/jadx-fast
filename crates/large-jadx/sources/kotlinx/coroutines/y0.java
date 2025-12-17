package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlinx.coroutines.internal.h;
import kotlinx.coroutines.internal.x;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0015B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\n2\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0014¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0019\u0010\r\u001a\u00020\n2\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008H\u0014¢\u0006\u0004\u0008\r\u0010\u000cJ\u000f\u0010\u000e\u001a\u0004\u0018\u00010\u0008¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0010H\u0002¢\u0006\u0004\u0008\u0013\u0010\u0012¨\u0006\u0014", d2 = {"Lkotlinx/coroutines/DispatchedCoroutine;", "T", "Lkotlin/coroutines/CoroutineContext;", "context", "Lkotlin/coroutines/Continuation;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)V", "", "state", "", "afterCompletion", "(Ljava/lang/Object;)V", "afterResume", "getResult", "()Ljava/lang/Object;", "", "tryResume", "()Z", "trySuspend", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/ScopeCoroutine;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y0<T>  extends x<T> {

    private static final AtomicIntegerFieldUpdater v;
    private volatile int _decision = 0;
    static {
        y0.v = AtomicIntegerFieldUpdater.newUpdater(y0.class, "_decision");
    }

    public y0(g g, d<? super T> d2) {
        super(g, d2);
        final int obj1 = 0;
    }

    private final boolean M0() {
        int _decision = this._decision;
        int i = 0;
        final int i2 = 1;
        while (_decision != 0) {
            _decision = this._decision;
            i = 0;
            i2 = 1;
        }
        if (_decision != i2) {
        } else {
            return i;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already resumed".toString());
        throw illegalStateException;
    }

    private final boolean N0() {
        int _decision = this._decision;
        int i = 0;
        while (_decision != 0) {
            int i3 = 1;
            _decision = this._decision;
            i = 0;
        }
        if (_decision != 2) {
        } else {
            return i;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already suspended".toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.internal.x
    protected void C(Object object) {
        G0(object);
    }

    @Override // kotlinx.coroutines.internal.x
    protected void G0(Object object) {
        if (M0()) {
        }
        final int i2 = 0;
        h.c(b.c(this.c), e0.a(object, this.c), i2, 2, i2);
    }

    @Override // kotlinx.coroutines.internal.x
    public final Object L0() {
        if (N0()) {
            return b.d();
        }
        Object obj3 = g2.h(c0());
        if (obj3 instanceof b0) {
        } else {
            return obj3;
        }
        throw obj3.a;
    }
}
