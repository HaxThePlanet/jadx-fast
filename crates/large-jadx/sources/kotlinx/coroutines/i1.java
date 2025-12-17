package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\n\u0008 \u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0004H\u0002J\u0012\u0010\u0016\u001a\u00020\u00132\n\u0010\u0017\u001a\u0006\u0012\u0002\u0008\u00030\u0010J\u0010\u0010\u0018\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0004J\u0008\u0010\u0019\u001a\u00020\nH\u0016J\u0006\u0010\u001a\u001a\u00020\u0004J\u0008\u0010\u001b\u001a\u00020\u0004H\u0016J\u0008\u0010\u001c\u001a\u00020\u0013H\u0014R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00048TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0005R\u0011\u0010\u0008\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0005R\u0014\u0010\t\u001a\u00020\n8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d", d2 = {"Lkotlinx/coroutines/EventLoop;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "isActive", "", "()Z", "isEmpty", "isUnconfinedLoopActive", "isUnconfinedQueueEmpty", "nextTime", "", "getNextTime", "()J", "shared", "unconfinedQueue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Lkotlinx/coroutines/DispatchedTask;", "useCount", "decrementUseCount", "", "unconfined", "delta", "dispatchUnconfined", "task", "incrementUseCount", "processNextEvent", "processUnconfinedEvent", "shouldBeProcessedFromContext", "shutdown", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class i1 extends kotlinx.coroutines.h0 {

    private long b;
    private boolean c;
    private a<kotlinx.coroutines.z0<?>> v;
    private final long T(boolean z) {
        long l;
        l = z ? 4294967296L : 1;
        return l;
    }

    public static void e0(kotlinx.coroutines.i1 i1, boolean z2, int i3, Object object4) {
        int obj1;
        if (object4 != null) {
        } else {
            if (i3 &= 1 != 0) {
                obj1 = 0;
            }
            i1.Y(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
        throw obj0;
    }

    @Override // kotlinx.coroutines.h0
    public final void M(boolean z) {
        int i;
        int obj5;
        l -= l2;
        this.b = i;
        int i2 = 0;
        if (Long.compare(i, i2) > 0) {
        }
        if (q0.a()) {
            obj5 = Long.compare(i, i2) == 0 ? 1 : 0;
            if (obj5 == null) {
            } else {
            }
            obj5 = new AssertionError();
            throw obj5;
        }
        if (this.c) {
            shutdown();
        }
    }

    public final void U(kotlinx.coroutines.z0<?> z0) {
        a aVar;
        if (this.v == null) {
            aVar = new a();
            this.v = aVar;
        }
        aVar.a(z0);
    }

    @Override // kotlinx.coroutines.h0
    protected long V() {
        long l;
        a aVar = this.v;
        if (aVar == null) {
            return Long.MAX_VALUE;
        }
        if (aVar.c()) {
        } else {
            l = 0;
        }
        return l;
    }

    @Override // kotlinx.coroutines.h0
    public final void Y(boolean z) {
        boolean obj5;
        this.b = l += l2;
        if (!z) {
            this.c = true;
        }
    }

    @Override // kotlinx.coroutines.h0
    public final boolean g0() {
        int i;
        if (Long.compare(l, l2) >= 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlinx.coroutines.h0
    public final boolean j0() {
        int i;
        a aVar = this.v;
        if (aVar == null) {
            i = 1;
        } else {
            i = aVar.c();
        }
        return i;
    }

    @Override // kotlinx.coroutines.h0
    public final boolean l0() {
        a aVar = this.v;
        final int i2 = 0;
        if (aVar == null) {
            return i2;
        }
        Object obj = aVar.d();
        if ((z0)obj == null) {
            return i2;
        }
        (z0)obj.run();
        return 1;
    }

    @Override // kotlinx.coroutines.h0
    protected void shutdown() {
    }
}
