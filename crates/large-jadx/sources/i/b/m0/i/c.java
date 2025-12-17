package i.b.m0.i;

import java.util.concurrent.atomic.AtomicInteger;
import m.c.b;

/* loaded from: classes3.dex */
public class c<T>  extends i.b.m0.i.a<T> {

    private static final long serialVersionUID = -2151279923272604993L;
    protected final b<? super T> downstream;
    protected T value;
    public c(b<? super T> b) {
        super();
        this.downstream = b;
    }

    public final void a(T t) {
        int i2;
        int i;
        int i3;
        i2 = get();
        i3 = 4;
        while (i2 == 8) {
            this.value = t;
            i3 = 4;
        }
        this.value = t;
        lazySet(16);
        b downstream = this.downstream;
        downstream.onNext(t);
        if (get() != i3) {
            downstream.onComplete();
        }
    }

    @Override // i.b.m0.i.a
    public final boolean b() {
        int i;
        i = get() == 4 ? 1 : 0;
        return i;
    }

    @Override // i.b.m0.i.a
    public void cancel() {
        set(4);
        this.value = 0;
    }

    @Override // i.b.m0.i.a
    public final void clear() {
        lazySet(32);
        this.value = 0;
    }

    @Override // i.b.m0.i.a
    public final boolean isEmpty() {
        int i;
        i = get() != 16 ? 1 : 0;
        return i;
    }

    public final T poll() {
        final int i3 = 0;
        if (get() == 16) {
            lazySet(32);
            this.value = i3;
            return this.value;
        }
        return i3;
    }

    @Override // i.b.m0.i.a
    public final void request(long l) {
        int i;
        boolean obj2;
        long obj3;
        if (g.validate(l)) {
        }
    }

    @Override // i.b.m0.i.a
    public final int requestFusion(int i) {
        final int i2 = 2;
        if (i &= i2 != 0) {
            lazySet(8);
            return i2;
        }
        return 0;
    }
}
