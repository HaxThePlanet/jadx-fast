package i.b.m0.e.a;

import i.b.a0;
import i.b.d;
import i.b.d0;
import i.b.f;
import i.b.j0.b;
import io.reactivex.exceptions.a;
import java.util.concurrent.Callable;

/* compiled from: CompletableToSingle.java */
/* loaded from: classes3.dex */
public final class q<T> extends a0<T> {

    final f a;
    final Callable<? extends T> b;
    final T c;

    final class a implements d {

        private final d0<? super T> a;
        final /* synthetic */ q b;
        a(d0 d0Var) {
            this.b = qVar;
            super();
            this.a = d0Var;
        }

        public void onComplete() {
            Object call;
            if (qVar.b != null) {
                try {
                    call = qVar.b.call();
                } catch (Throwable th) {
                    a.b(th);
                    this.a.onError(th);
                    return;
                }
            } else {
            }
            if (qVar.c == null) {
                str = "The value supplied is null";
                this.a.onError(new NullPointerException(str));
            } else {
                this.a.onSuccess(call);
            }
        }

        public void onError(Throwable th) {
            this.a.onError(th);
        }

        public void onSubscribe(b bVar) {
            this.a.onSubscribe(bVar);
        }
    }
    public q(f fVar, Callable<? extends T> callable, T t) {
        super();
        this.a = fVar;
        this.c = t;
        this.b = callable;
    }

    @Override // i.b.a0
    protected void subscribeActual(d0<? super T> d0Var) {
        this.a.b(new q.a(this, d0Var));
    }
}
