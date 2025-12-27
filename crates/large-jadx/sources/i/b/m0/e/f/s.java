package i.b.m0.e.f;

import i.b.a0;
import i.b.d0;
import i.b.g0;
import i.b.j0.b;
import i.b.l0.f;
import i.b.m0.a.d;

/* compiled from: SingleDoOnSubscribe.java */
/* loaded from: classes3.dex */
public final class s<T> extends a0<T> {

    final g0<T> a;
    final f<? super b> b;

    static final class a<T> implements d0<T> {

        final d0<? super T> a;
        final f<? super b> b;
        boolean c;
        a(d0<? super T> d0Var, f<? super b> fVar) {
            super();
            this.a = d0Var;
            this.b = fVar;
        }

        public void onError(Throwable th) {
            if (this.c) {
                a.t(th);
                return;
            }
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            try {
                this.b.accept(bVar);
            } catch (Throwable th) {
                a.b(th);
                this.c = true;
                bVar.dispose();
                d.error(th, this.a);
                return;
            }
            this.a.onSubscribe(this.a);
        }

        public void onSuccess(T t) {
            if (this.c) {
                return;
            }
            this.a.onSuccess(t);
        }
    }
    public s(g0<T> g0Var, f<? super b> fVar) {
        super();
        this.a = g0Var;
        this.b = fVar;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.subscribe(new s.a(d0Var, this.b));
    }
}
