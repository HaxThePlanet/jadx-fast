package i.b.m0.e.a;

import i.b.a0;
import i.b.d;
import i.b.d0;
import i.b.f;
import i.b.j0.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class q<T>  extends a0<T> {

    final f a;
    final Callable<? extends T> b;
    final T c;

    final class a implements d {

        private final d0<? super T> a;
        final i.b.m0.e.a.q b;
        a(i.b.m0.e.a.q q, d0 d02) {
            this.b = q;
            super();
            this.a = d02;
        }

        @Override // i.b.d
        public void onComplete() {
            Object call;
            Object nullPointerException;
            String str;
            i.b.m0.e.a.q qVar = this.b;
            Callable callable = qVar.b;
            if (callable != null) {
                call = callable.call();
            } else {
                call = qVar.c;
            }
            if (call == null) {
                nullPointerException = new NullPointerException("The value supplied is null");
                this.a.onError(nullPointerException);
            } else {
                try {
                    this.a.onSuccess(call);
                }
            }
        }

        @Override // i.b.d
        public void onError(Throwable throwable) {
            this.a.onError(throwable);
        }

        @Override // i.b.d
        public void onSubscribe(b b) {
            this.a.onSubscribe(b);
        }
    }
    public q(f f, Callable<? extends T> callable2, T t3) {
        super();
        this.a = f;
        this.c = t3;
        this.b = callable2;
    }

    protected void subscribeActual(d0<? super T> d0) {
        q.a aVar = new q.a(this, d0);
        this.a.b(aVar);
    }
}
