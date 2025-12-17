package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.m0.d.b;
import i.b.m0.f.c;
import i.b.p0.a;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public final class c2<T>  extends i.b.m0.e.e.a<T, T> {

    final z b;
    final boolean c;
    final int v;

    static final class a extends b<T> implements y<T>, Runnable {

        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final y<? super T> downstream;
        Throwable error;
        boolean outputFused;
        j<T> queue;
        int sourceMode;
        b upstream;
        final z.c worker;
        a(y<? super T> y, z.c z$c2, boolean z3, int i4) {
            super();
            this.downstream = y;
            this.worker = c2;
            this.delayError = z3;
            this.bufferSize = i4;
        }

        boolean a(boolean z, boolean z2, y<? super T> y3) {
            boolean delayError;
            Throwable obj3;
            final int i = 1;
            if (this.disposed) {
                this.queue.clear();
                return i;
            }
            if (z != null) {
                obj3 = this.error;
                if (this.delayError != null) {
                    if (z2) {
                        this.disposed = i;
                        if (obj3 != null) {
                            y3.onError(obj3);
                        } else {
                            y3.onComplete();
                        }
                        this.worker.dispose();
                        return i;
                    }
                } else {
                    if (obj3 != null) {
                        this.disposed = i;
                        this.queue.clear();
                        y3.onError(obj3);
                        this.worker.dispose();
                        return i;
                    }
                    if (z2) {
                        this.disposed = i;
                        y3.onComplete();
                        this.worker.dispose();
                        return i;
                    }
                }
            }
            return 0;
        }

        @Override // i.b.m0.d.b
        void b() {
            Object downstream2;
            int andGet;
            boolean done;
            y downstream;
            int i;
            int i2 = 1;
            andGet = i2;
            while (this.disposed) {
                done = this.done;
                this.downstream.onNext(0);
            }
        }

        @Override // i.b.m0.d.b
        void c() {
            int andGet;
            boolean z;
            boolean empty;
            int i;
            final j queue = this.queue;
            final y downstream = this.downstream;
            final int i2 = 1;
            andGet = i2;
            while (a(this.done, queue.isEmpty(), downstream)) {
                empty = queue.poll();
                while (!empty) {
                    i = i2;
                    downstream.onNext(empty);
                    empty = queue.poll();
                    i = 0;
                }
                i = 0;
                downstream.onNext(empty);
                i = i2;
            }
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this.queue.clear();
        }

        @Override // i.b.m0.d.b
        void d() {
            int andIncrement;
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            boolean andIncrement;
            this.disposed = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (!this.disposed && !this.outputFused && getAndIncrement() == 0) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (!this.outputFused) {
                    if (getAndIncrement() == 0) {
                        this.queue.clear();
                    }
                }
            }
        }

        @Override // i.b.m0.d.b
        public boolean isDisposed() {
            return this.disposed;
        }

        @Override // i.b.m0.d.b
        public boolean isEmpty() {
            return this.queue.isEmpty();
        }

        @Override // i.b.m0.d.b
        public void onComplete() {
            if (this.done) {
            }
            this.done = true;
            d();
        }

        @Override // i.b.m0.d.b
        public void onError(Throwable throwable) {
            if (this.done) {
                a.t(throwable);
            }
            this.error = throwable;
            this.done = true;
            d();
        }

        public void onNext(T t) {
            int sourceMode;
            if (this.done) {
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            d();
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(b b) {
            boolean bufferSize;
            boolean requestFusion;
            int i;
            Object obj3;
            this.upstream = b;
            requestFusion = (e)b.requestFusion(7);
            int i3 = 1;
            if (c.validate(this.upstream, b) && b instanceof e && requestFusion == i3) {
                this.upstream = b;
                if (b instanceof e) {
                    requestFusion = (e)b.requestFusion(7);
                    i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = requestFusion;
                        this.queue = b;
                        this.done = i3;
                        this.downstream.onSubscribe(this);
                        d();
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = b;
                        this.downstream.onSubscribe(this);
                    }
                }
                obj3 = new c(this.bufferSize);
                this.queue = obj3;
                this.downstream.onSubscribe(this);
            }
        }

        public T poll() {
            return this.queue.poll();
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i &= i2 != 0) {
                this.outputFused = true;
                return i2;
            }
            return 0;
        }

        @Override // i.b.m0.d.b
        public void run() {
            if (this.outputFused) {
                b();
            } else {
                c();
            }
        }
    }
    public c2(w<T> w, z z2, boolean z3, int i4) {
        super(w);
        this.b = z2;
        this.c = z3;
        this.v = i4;
    }

    protected void subscribeActual(y<? super T> y) {
        Object obj;
        boolean z2;
        i.b.m0.e.e.c2.a aVar;
        boolean z;
        int i;
        z zVar = this.b;
        if (zVar instanceof n) {
            this.a.subscribe(y);
        } else {
            aVar = new c2.a(y, zVar.a(), this.c, this.v);
            this.a.subscribe(aVar);
        }
    }
}
