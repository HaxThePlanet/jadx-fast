package i.b.m0.e.e;

import i.b.g;
import i.b.j0.b;
import i.b.l0.c;
import i.b.l0.f;
import i.b.m0.a.d;
import i.b.r;
import i.b.y;
import java.util.concurrent.Callable;

/* compiled from: ObservableGenerate.java */
/* loaded from: classes3.dex */
public final class h1<T, S> extends r<T> {

    final Callable<S> a;
    final c<S, g<T>, S> b;
    final f<? super S> c;

    static final class a<T, S> implements g<T>, b {

        final y<? super T> a;
        final c<S, ? super g<T>, S> b;
        final f<? super S> c;
        S v;
        volatile boolean w;
        boolean x;
        a(y<? super T> yVar, c<S, ? super g<T>, S> cVar, f<? super S> fVar, S s) {
            super();
            this.a = yVar;
            this.b = cVar;
            this.c = fVar;
            this.v = s;
        }

        private void a(S s) {
            try {
                this.c.accept(s);
            } catch (Throwable th) {
                a.b(th);
                a.t(th);
            }
        }

        public void b(Throwable th) {
            Object obj;
            if (this.x) {
                a.t(th);
            } else {
                if (th == null) {
                    java.lang.NullPointerException nullPointerException = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                this.x = true;
                this.a.onError(obj);
            }
        }

        public void c() {
            Object apply;
            final Object obj3 = null;
            if (this.w) {
                this.v = obj3;
                a(this.v);
                return;
            }
            while (this.w) {
                boolean z = true;
                try {
                } catch (Throwable th) {
                    a.b(th);
                    this.v = obj2;
                    this.w = z4;
                    b(th);
                    a(obj);
                    return;
                }
                if (this.x) {
                    this.w = z;
                    this.v = obj3;
                    a(this.b.apply(apply, this));
                    return;
                }
            }
            this.v = obj3;
            a(apply);
        }

        public void dispose() {
            this.w = true;
        }

        public boolean isDisposed() {
            return this.w;
        }
    }
    public h1(Callable<S> callable, c<S, g<T>, S> cVar, f<? super S> fVar) {
        super();
        this.a = callable;
        this.b = cVar;
        this.c = fVar;
    }

    @Override // i.b.r
    public void subscribeActual(y<? super T> yVar) {
        try {
        } catch (Throwable th) {
            a.b(th);
            d.error(th, yVar);
            return;
        }
        final i.b.m0.e.e.h1.a aVar = new h1.a(yVar, this.b, this.c, this.a.call());
        yVar.onSubscribe(aVar);
        aVar.c();
    }
}
