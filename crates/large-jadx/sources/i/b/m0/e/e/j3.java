package i.b.m0.e.e;

import i.b.j0.b;
import i.b.m0.a.a;
import i.b.m0.a.c;
import i.b.o0.e;
import i.b.w;
import i.b.y;

/* loaded from: classes3.dex */
public final class j3<T, U>  extends i.b.m0.e.e.a<T, T> {

    final w<U> b;

    final class a implements y<U> {

        final a a;
        final i.b.m0.e.e.j3.b<T> b;
        final e<T> c;
        b v;
        a(i.b.m0.e.e.j3 j3, a a2, i.b.m0.e.e.j3.b j3$b3, e e4) {
            super();
            this.a = a2;
            this.b = b3;
            this.c = e4;
        }

        @Override // i.b.y
        public void onComplete() {
            bVar.v = true;
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.dispose();
            this.c.onError(throwable);
        }

        public void onNext(U u) {
            this.v.dispose();
            obj2.v = true;
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            boolean validate;
            int i;
            if (c.validate(this.v, b)) {
                this.v = b;
                this.a.a(1, b);
            }
        }
    }

    static final class b implements y<T> {

        final y<? super T> a;
        final a b;
        b c;
        volatile boolean v;
        boolean w;
        b(y<? super T> y, a a2) {
            super();
            this.a = y;
            this.b = a2;
        }

        @Override // i.b.y
        public void onComplete() {
            this.b.dispose();
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.b.dispose();
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            y yVar;
            if (this.w) {
                this.a.onNext(t);
            } else {
                if (this.v) {
                    this.w = true;
                    this.a.onNext(t);
                }
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            boolean validate;
            int i;
            if (c.validate(this.c, b)) {
                this.c = b;
                this.b.a(0, b);
            }
        }
    }
    public j3(w<T> w, w<U> w2) {
        super(w);
        this.b = w2;
    }

    public void subscribeActual(y<? super T> y) {
        e eVar = new e(y);
        a obj5 = new a(2);
        eVar.onSubscribe(obj5);
        j3.b bVar = new j3.b(eVar, obj5);
        j3.a aVar = new j3.a(this, obj5, bVar, eVar);
        this.b.subscribe(aVar);
        this.a.subscribe(bVar);
    }
}
