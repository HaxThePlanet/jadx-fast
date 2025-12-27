package i.b.m0.d;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.j.n;
import i.b.y;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: BlockingObserver.java */
/* loaded from: classes3.dex */
public final class i<T> extends AtomicReference<b> implements y<T>, b {

    public static final Object a = null;
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;
    static {
        i.a = new Object();
    }

    public i(Queue<Object> queue) {
        super();
        this.queue = queue;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        if (c.dispose(this)) {
            this.queue.offer(i.a);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        boolean z = true;
        int r0 = get() == c.DISPOSED ? 1 : 0;
        return (get() == c.DISPOSED ? 1 : 0);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onComplete() {
        this.queue.offer(n.complete());
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable th) {
        this.queue.offer(n.error(th));
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onNext(T t) {
        this.queue.offer(n.next(t));
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b bVar) {
        c.setOnce(this, bVar);
    }
}
