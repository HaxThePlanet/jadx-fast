package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.n;
import i.b.y;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class i<T>  extends AtomicReference<b> implements y<T>, b {

    public static final Object a = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;
    static {
        Object object = new Object();
        i.a = object;
    }

    public i(Queue<Object> queue) {
        super();
        this.queue = queue;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        boolean dispose;
        Object obj;
        if (c.dispose(this)) {
            this.queue.offer(i.a);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        int i;
        i = get() == c.DISPOSED ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        this.queue.offer(n.complete());
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        this.queue.offer(n.error(throwable));
    }

    public void onNext(T t) {
        this.queue.offer(n.next(t));
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        c.setOnce(this, b);
    }
}
