package i.b.m0.e.e;

import i.b.g;
import i.b.j0.b;
import i.b.l0.c;
import i.b.l0.f;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class h1<T, S>  extends r<T> {

    final Callable<S> a;
    final c<S, g<T>, S> b;
    final f<? super S> c;

    static final class a implements g<T>, b {

        final y<? super T> a;
        final c<S, ? super g<T>, S> b;
        final f<? super S> c;
        S v;
        volatile boolean w;
        boolean x;
        a(y<? super T> y, c<S, ? super g<T>, S> c2, f<? super S> f3, S s4) {
            super();
            this.a = y;
            this.b = c2;
            this.c = f3;
            this.v = s4;
        }

        private void a(S s) {
            Object obj2;
            try {
                this.c.accept(s);
                a.b(s);
                a.t(s);
            }
        }

        @Override // i.b.g
        public void b(Throwable throwable) {
            boolean str;
            Object obj2;
            if (this.x) {
                a.t(throwable);
            } else {
                if (throwable == null) {
                    obj2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
                }
                this.x = true;
                this.a.onError(obj2);
            }
        }

        @Override // i.b.g
        public void c() {
            Object apply;
            boolean z;
            boolean z2;
            final int i = 0;
            if (this.w) {
                this.v = i;
                a(this.v);
            }
            while (this.w) {
            }
            this.v = i;
            a(apply);
        }

        @Override // i.b.g
        public void dispose() {
            this.w = true;
        }

        @Override // i.b.g
        public boolean isDisposed() {
            return this.w;
        }
    }
    public h1(Callable<S> callable, c<S, g<T>, S> c2, f<? super S> f3) {
        super();
        this.a = callable;
        this.b = c2;
        this.c = f3;
    }

    public void subscribeActual(y<? super T> y) {
        try {
            h1.a aVar = new h1.a(y, this.b, this.c, this.a.call());
            y.onSubscribe(aVar);
            aVar.c();
            a.b(th);
            d.error(th, y);
        }
    }
}
