package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.a;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;

/* compiled from: ObservableSkipUntil.java */
/* loaded from: classes3.dex */
public final class j3<T, U> extends a<T, T> {

    final w<U> b;

    final class a implements y<U> {

        final a a;
        final j3.b<T> b;
        final e<T> c;
        b v;
        a(a aVar, j3.b bVar, e eVar) {
            super();
            this.a = aVar;
            this.b = bVar;
            this.c = eVar;
        }

        public void onComplete() {
            this.b.v = true;
        }

        public void onError(Throwable th) {
            this.a.dispose();
            this.c.onError(th);
        }

        public void onNext(U u) {
            this.v.dispose();
            this.b.v = true;
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.v, bVar)) {
                this.v = bVar;
                int i = 1;
                this.a.a(i, bVar);
            }
        }
    }

    static final class b<T> implements y<T> {

        final y<? super T> a;
        final a b;
        b c;
        volatile boolean v;
        boolean w;
        b(y<? super T> yVar, a aVar) {
            super();
            this.a = yVar;
            this.b = aVar;
        }

        public void onComplete() {
            this.b.dispose();
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.b.dispose();
            this.a.onError(th);
        }

        public void onNext(T t) {
            if (this.w) {
                this.a.onNext(t);
            } else {
                if (this.v) {
                    this.w = true;
                    this.a.onNext(t);
                }
            }
        }

        public void onSubscribe(b bVar) {
            if (c.validate(this.c, bVar)) {
                this.c = bVar;
                int i = 0;
                this.b.a(i, bVar);
            }
        }
    }
    public j3(w<T> wVar, w<U> wVar2) {
        super(wVar);
        this.b = wVar2;
    }

    @Override // i.b.m0.e.e.a
    public void subscribeActual(y<? super T> yVar) {
        final e eVar = new e(yVar);
        a aVar2 = new a(2);
        eVar.onSubscribe(aVar2);
        i.b.m0.e.e.j3.b bVar = new j3.b(eVar, aVar2);
        this.b.subscribe(new j3.a(this, aVar2, bVar, eVar));
        this.a.subscribe(bVar);
    }
}
