package i.b.m0.e.b;

import i.b.h;
import i.b.j0.b;
import i.b.r;
import i.b.y;
import m.c.b;
import m.c.c;

/* loaded from: classes3.dex */
public final class r<T>  extends h<T> {

    private final r<T> b;

    static final class a implements y<T>, c {

        final b<? super T> a;
        b b;
        a(b<? super T> b) {
            super();
            this.a = b;
        }

        @Override // i.b.y
        public void cancel() {
            this.b.dispose();
        }

        @Override // i.b.y
        public void onComplete() {
            this.a.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.b = b;
            this.a.onSubscribe(this);
        }

        @Override // i.b.y
        public void request(long l) {
        }
    }
    public r(r<T> r) {
        super();
        this.b = r;
    }

    protected void c0(b<? super T> b) {
        r.a aVar = new r.a(b);
        this.b.subscribe(aVar);
    }
}
