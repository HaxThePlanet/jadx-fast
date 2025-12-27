package i.b.o0;

import i.b.d;
import i.b.d0;
import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.c.e;
import i.b.m0.c.f;
import i.b.m0.c.j;
import i.b.n;
import i.b.y;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: TestObserver.java */
/* loaded from: classes3.dex */
public class f<T> extends a<T, f<T>> implements y<T>, b, n<T>, d0<T>, d {

    private final AtomicReference<b> A;
    private e<T> B;
    private final y<? super T> z;

    enum a implements y<Object> {

        INSTANCE;
        @Override // java.lang.Enum
        public void onComplete() {
        }

        @Override // java.lang.Enum
        public void onError(Throwable th) {
        }

        @Override // java.lang.Enum
        public void onNext(Object object) {
        }

        @Override // java.lang.Enum
        public void onSubscribe(b bVar) {
        }
    }
    public f() {
        this(f.a.INSTANCE);
    }

    @Override // i.b.o0.a
    public final void a() {
        dispose();
    }

    @Override // i.b.o0.a
    public final void dispose() {
        c.dispose(this.A);
    }

    @Override // i.b.o0.a
    public final boolean isDisposed() {
        return c.isDisposed((b)this.A.get());
    }

    @Override // i.b.o0.a
    public void onComplete() {
        if (!this.w) {
            this.w = true;
            if (this.A.get() == null) {
                str = "onSubscribe not called in proper order";
                this.c.add(new IllegalStateException(str));
            }
        }
        try {
            Thread.currentThread();
            this.v++;
            this.z.onComplete();
        } finally {
            this.a.countDown();
            throw th;
        }
        this.a.countDown();
    }

    @Override // i.b.o0.a
    public void onError(Throwable th) {
        java.lang.IllegalStateException illegalStateException;
        String str;
        if (!this.w && this.A.get() == null) {
            str = "onSubscribe not called in proper order";
            this.c.add(new IllegalStateException(str));
        }
        try {
            Thread.currentThread();
            if (th == null) {
                str = "onError received a null Throwable";
                this.c.add(new NullPointerException(str));
            } else {
                this.c.add(th);
            }
            this.z.onError(th);
        } finally {
            this.a.countDown();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
        this.a.countDown();
    }

    @Override // i.b.o0.a
    public void onNext(T t) {
        int i;
        String str;
        if (!this.w) {
            this.w = true;
            if (this.A.get() == null) {
                str = "onSubscribe not called in proper order";
                this.c.add(new IllegalStateException(str));
            }
        }
        Thread.currentThread();
        int i2 = 2;
        if (this.y == 2) {
            Object poll = this.B.poll();
            while (poll != null) {
                this.b.add(poll);
                try {
                    poll = this.B.poll();
                    this.b.add(poll);
                } catch (Throwable th) {
                    this.c.add(th);
                    this.B.dispose();
                }
            }
            return;
        }
        this.b.add(this.B);
        if (this.B == null) {
            str = "onNext received a null value";
            this.c.add(new NullPointerException(str));
        }
        this.z.onNext(this.B);
    }

    @Override // i.b.o0.a
    public void onSubscribe(b bVar) {
        Thread.currentThread();
        if (bVar == null) {
            this.c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        Object obj2 = null;
        if (!this.A.compareAndSet(obj2, bVar)) {
            bVar.dispose();
            if (this.A.get() != c.DISPOSED) {
                StringBuilder stringBuilder = new StringBuilder();
                str = "onSubscribe received multiple subscriptions: ";
                str2 = str + bVar;
                this.c.add(new IllegalStateException(str2));
            }
            return;
        }
        if (this.x != 0) {
            if (bVar instanceof e) {
                Object bVar2 = bVar;
                this.B = bVar2;
                int requestFusion = bVar2.requestFusion(this.x);
                this.y = requestFusion;
                int i = 1;
                if (requestFusion == i) {
                    this.w = true;
                    Thread.currentThread();
                    Object poll = this.B.poll();
                    while (poll != null) {
                        this.b.add(poll);
                        try {
                            poll = this.B.poll();
                            while (poll != null) {
                                this.b.add(poll);
                                try {
                                    poll = this.B.poll();
                                    while (poll != null) {
                                        this.b.add(poll);
                                        try {
                                            poll = this.B.poll();
                                            while (poll != null) {
                                                this.b.add(poll);
                                                try {
                                                    poll = this.B.poll();
                                                    while (poll != null) {
                                                        this.b.add(poll);
                                                        try {
                                                            poll = this.B.poll();
                                                            while (poll != null) {
                                                                this.b.add(poll);
                                                                try {
                                                                    poll = this.B.poll();
                                                                    while (poll != null) {
                                                                        this.b.add(poll);
                                                                        try {
                                                                            poll = this.B.poll();
                                                                            while (poll != null) {
                                                                                this.b.add(poll);
                                                                                try {
                                                                                    poll = this.B.poll();
                                                                                    while (poll != null) {
                                                                                        this.b.add(poll);
                                                                                        try {
                                                                                            poll = this.B.poll();
                                                                                            while (poll != null) {
                                                                                                this.b.add(poll);
                                                                                                try {
                                                                                                    poll = this.B.poll();
                                                                                                    while (poll != null) {
                                                                                                        this.b.add(poll);
                                                                                                        try {
                                                                                                            poll = this.B.poll();
                                                                                                            while (poll != null) {
                                                                                                                this.b.add(poll);
                                                                                                                try {
                                                                                                                    poll = this.B.poll();
                                                                                                                    while (poll != null) {
                                                                                                                        this.b.add(poll);
                                                                                                                        try {
                                                                                                                            poll = this.B.poll();
                                                                                                                            while (poll != null) {
                                                                                                                                this.b.add(poll);
                                                                                                                                try {
                                                                                                                                    poll = this.B.poll();
                                                                                                                                    while (poll != null) {
                                                                                                                                        this.b.add(poll);
                                                                                                                                        try {
                                                                                                                                            poll = this.B.poll();
                                                                                                                                            while (poll != null) {
                                                                                                                                                this.b.add(poll);
                                                                                                                                                try {
                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                    while (poll != null) {
                                                                                                                                                        this.b.add(poll);
                                                                                                                                                        try {
                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                            while (poll != null) {
                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                try {
                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                        try {
                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                try {
                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                        try {
                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                try {
                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                        try {
                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                try {
                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                                                        try {
                                                                                                                                                                                                                                                                                                                                                                                                            poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                                                            while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                                                                try {
                                                                                                                                                                                                                                                                                                                                                                                                                    poll = this.B.poll();
                                                                                                                                                                                                                                                                                                                                                                                                                    while (poll != null) {
                                                                                                                                                                                                                                                                                                                                                                                                                        this.b.add(poll);
                                                                                                                                                                                                                                                                                                                                                                                                                        /* DEPTH_LIMIT_EXCEEDED: Region nesting too deep */
                                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                            this.v++;
                                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                    this.v++;
                                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                            this.v++;
                                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                    this.v++;
                                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                            this.v++;
                                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                                            this.c.add(th);
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                    this.v++;
                                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                                    this.c.add(th);
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                            this.v++;
                                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                                        } catch (Throwable th) {
                                                                                                                                                            this.c.add(th);
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                    this.v++;
                                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                                } catch (Throwable th) {
                                                                                                                                                    this.c.add(th);
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                            this.v++;
                                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                                        } catch (Throwable th) {
                                                                                                                                            this.c.add(th);
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                    this.v++;
                                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                                } catch (Throwable th) {
                                                                                                                                    this.c.add(th);
                                                                                                                                }
                                                                                                                            }
                                                                                                                            this.v++;
                                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                                        } catch (Throwable th) {
                                                                                                                            this.c.add(th);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    this.v++;
                                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                                } catch (Throwable th) {
                                                                                                                    this.c.add(th);
                                                                                                                }
                                                                                                            }
                                                                                                            this.v++;
                                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                                        } catch (Throwable th) {
                                                                                                            this.c.add(th);
                                                                                                        }
                                                                                                    }
                                                                                                    this.v++;
                                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                                } catch (Throwable th) {
                                                                                                    this.c.add(th);
                                                                                                }
                                                                                            }
                                                                                            this.v++;
                                                                                            this.A.lazySet(c.DISPOSED);
                                                                                        } catch (Throwable th) {
                                                                                            this.c.add(th);
                                                                                        }
                                                                                    }
                                                                                    this.v++;
                                                                                    this.A.lazySet(c.DISPOSED);
                                                                                } catch (Throwable th) {
                                                                                    this.c.add(th);
                                                                                }
                                                                            }
                                                                            this.v++;
                                                                            this.A.lazySet(c.DISPOSED);
                                                                        } catch (Throwable th) {
                                                                            this.c.add(th);
                                                                        }
                                                                    }
                                                                    this.v++;
                                                                    this.A.lazySet(c.DISPOSED);
                                                                } catch (Throwable th) {
                                                                    this.c.add(th);
                                                                }
                                                            }
                                                            this.v++;
                                                            this.A.lazySet(c.DISPOSED);
                                                        } catch (Throwable th) {
                                                            this.c.add(th);
                                                        }
                                                    }
                                                    this.v++;
                                                    this.A.lazySet(c.DISPOSED);
                                                } catch (Throwable th) {
                                                    this.c.add(th);
                                                }
                                            }
                                            this.v++;
                                            this.A.lazySet(c.DISPOSED);
                                        } catch (Throwable th) {
                                            this.c.add(th);
                                        }
                                    }
                                    this.v++;
                                    this.A.lazySet(c.DISPOSED);
                                } catch (Throwable th) {
                                    this.c.add(th);
                                }
                            }
                            this.v++;
                            this.A.lazySet(c.DISPOSED);
                        } catch (Throwable th) {
                            this.c.add(th);
                        }
                    }
                }
            }
        }
        this.z.onSubscribe(th);
    }

    @Override // i.b.o0.a
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    public f(y<? super T> yVar) {
        super();
        this.A = new AtomicReference();
        this.z = yVar;
    }
}
