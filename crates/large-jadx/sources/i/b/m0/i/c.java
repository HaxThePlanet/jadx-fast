package i.b.m0.i;

import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;

/* compiled from: DeferredScalarSubscription.java */
/* loaded from: classes3.dex */
public class c<T> extends a<T> {

    private static final long serialVersionUID = -2151279923272604993L;
    protected final b<? super T> downstream;
    protected T value;
    public c(b<? super T> bVar) {
        super();
        this.downstream = bVar;
    }

    @Override // i.b.m0.i.a
    public final void a(T t) {
        int i;
        i = get();
        int i3 = 4;
        while (i == 8) {
            this.value = t;
            int i2 = 1;
            if (get() == i3) {
                this.value = null;
                return;
            }
            i3 = 4;
        }
        this.value = t;
        lazySet(16);
        this.downstream.onNext(t);
        if (get() != i3) {
            this.downstream.onComplete();
        }
    }

    @Override // i.b.m0.i.a
    public final boolean b() {
        boolean z = true;
        int r0 = get() == 4 ? 1 : 0;
        return (get() == 4 ? 1 : 0);
    }

    @Override // i.b.m0.i.a
    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // i.b.m0.i.a
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    @Override // i.b.m0.i.a
    public final boolean isEmpty() {
        boolean z = true;
        int r0 = get() != 16 ? 1 : 0;
        return (get() != 16 ? 1 : 0);
    }

    @Override // i.b.m0.i.a
    public final T poll() {
        final Object obj = null;
        if (get() == 16) {
            lazySet(32);
            this.value = obj;
            return this.value;
        }
        return obj;
    }

    @Override // i.b.m0.i.a
    public final void request(long j) {
        if (g.validate(j)) {
            int i4 = get();
            while (i4 & (-2) != 0) {
                int i3 = 1;
                int i2 = 2;
                if (compareAndSet(0, i2)) {
                    return;
                }
                i4 = get();
            }
            return;
        }
    }

    @Override // i.b.m0.i.a
    public final int requestFusion(int i) {
        final int i2 = 2;
        if (i & i2 != 0) {
            lazySet(8);
            return i2;
        }
        return 0;
    }
}
