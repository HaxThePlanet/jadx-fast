package i.b.m0.e.e;

import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.w;
import i.b.y;
import i.b.z;
import i.b.z.c;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ObservableObserveOn.java */
/* loaded from: classes3.dex */
public final class c2<T> extends a<T, T> {

    final z b;
    final boolean c;
    final int v;

    static final class a<T> extends i.b.m0.d.b<T> implements y<T>, Runnable {

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
        i.b.j0.b upstream;
        final z.c worker;
        a(y<? super T> yVar, z.c cVar, boolean z, int i) {
            super();
            this.downstream = yVar;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i;
        }

        @Override // i.b.m0.d.b
        boolean a(boolean z, boolean z2, y<? super T> yVar) {
            final boolean z3 = true;
            if (this.disposed) {
                this.queue.clear();
                return true;
            }
            if (this.queue) {
                if (this.delayError != null) {
                    if (z2) {
                        this.disposed = z3;
                        if (this.error != null) {
                            yVar.onError(this.error);
                        } else {
                            yVar.onComplete();
                        }
                        this.worker.dispose();
                        return true;
                    }
                } else {
                    if (this.error != null) {
                        this.disposed = z3;
                        this.queue.clear();
                        yVar.onError(this.error);
                        this.worker.dispose();
                        return true;
                    }
                    if (this.queue) {
                        this.disposed = z3;
                        yVar.onComplete();
                        this.worker.dispose();
                        return true;
                    }
                }
            }
            return false;
        }

        @Override // i.b.m0.d.b
        void b() {
            int andGet;
            boolean z = true;
            andGet = z;
            while (this.disposed) {
                Object obj = null;
                this.downstream.onNext(obj);
                if (addAndGet(-andGet) == 0) {
                    return;
                }
            }
        }

        @Override // i.b.m0.d.b
        void c() {
            int andGet;
            boolean z2;
            andGet = 1;
            while (a(this.done, this.queue.isEmpty(), this.downstream)) {
                while (/* condition */) {
                    try {
                        Object poll = this.queue.poll();
                    } catch (Throwable th) {
                        a.b(th);
                        this.disposed = upstream2;
                        this.upstream.dispose();
                        worker2.clear();
                        obj.onError(th);
                        this.worker.dispose();
                        return;
                    }
                    int r6 = poll == null ? andGet : 0;
                    if (r6) {
                    }
                }
                try {
                    poll = this.queue.poll();
                } catch (Throwable th) {
                    a.b(th);
                    this.disposed = this.upstream;
                    this.upstream.dispose();
                    this.worker.clear();
                    obj.onError(th);
                    this.worker.dispose();
                    return;
                }
                r6 = poll == null ? andGet : 0;
                if (r6) {
                }
            }
        }

        @Override // i.b.m0.d.b
        public void clear() {
            this.queue.clear();
        }

        @Override // i.b.m0.d.b
        void d() {
            if (getAndIncrement() == 0) {
                this.worker.b(this);
            }
        }

        @Override // i.b.m0.d.b
        public void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (!this.outputFused && this.getAndIncrement() == 0) {
                    this.queue.clear();
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
                return;
            }
            this.done = true;
            d();
        }

        @Override // i.b.m0.d.b
        public void onError(Throwable th) {
            if (this.done) {
                a.t(th);
                return;
            }
            this.error = th;
            this.done = true;
            d();
        }

        @Override // i.b.m0.d.b
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            if (this.sourceMode != 2) {
                this.queue.offer(t);
            }
            d();
        }

        @Override // i.b.m0.d.b
        public void onSubscribe(i.b.j0.b bVar) {
            int i = 2;
            if (c.validate(this.upstream, bVar)) {
                this.upstream = bVar;
                z = bVar instanceof e;
                if (bVar instanceof e) {
                    int requestFusion = bVar.requestFusion(7);
                    int i3 = 1;
                    if (requestFusion == i3) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        d();
                        return;
                    }
                    i = 2;
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = bVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new c(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        @Override // i.b.m0.d.b
        public T poll() {
            return this.queue.poll();
        }

        @Override // i.b.m0.d.b
        public int requestFusion(int i) {
            final int i2 = 2;
            if (i & i2 != 0) {
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
    public c2(w<T> wVar, z zVar, boolean z, int i) {
        super(wVar);
        this.b = zVar;
        this.c = z;
        this.v = i;
    }

    @Override // i.b.m0.e.e.a
    protected void subscribeActual(y<? super T> yVar) {
        z = zVar instanceof n;
        if (zVar instanceof n) {
            this.a.subscribe(yVar);
        } else {
            this.a.subscribe(new c2.a(yVar, this.b.a(), this.c, this.v));
        }
    }
}
