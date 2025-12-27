package i.b.m0.e.b;

import i.b.h;
import i.b.r;
import i.b.y;
import m.c.c;

/* compiled from: FlowableFromObservable.java */
/* loaded from: classes3.dex */
public final class r<T> extends h<T> {

    private final r<T> b;

    static final class a<T> implements y<T>, c {

        final m.c.b<? super T> a;
        i.b.j0.b b;
        a(m.c.b<? super T> bVar) {
            super();
            this.a = bVar;
        }

        public void cancel() {
            this.b.dispose();
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onNext(T t) {
            this.a.onNext(t);
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.b = bVar;
            this.a.onSubscribe(this);
        }

        public void request(long j) {
        }
    }
    public r(r<T> rVar) {
        super();
        this.b = rVar;
    }

    @Override // i.b.h
    protected void c0(m.c.b<? super T> bVar) {
        this.b.subscribe(new r.a(bVar));
    }
}
