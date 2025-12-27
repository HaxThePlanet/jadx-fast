package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import i.b.l0.o;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* compiled from: CompletableOnErrorComplete.java */
/* loaded from: classes3.dex */
public final class l extends i.b.b {

    final f a;
    final o<? super Throwable> b;

    final class a implements d {

        private final d a;
        final /* synthetic */ l b;
        a(d dVar) {
            this.b = lVar;
            super();
            this.a = dVar;
        }

        public void onComplete() {
            this.a.onComplete();
        }

        public void onError(Throwable th) {
            try {
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                th = 1;
                arr[th] = th;
                this.a.onError(new CompositeException(arr));
                return;
            }
            if (this.b.b.test(th)) {
                this.a.onComplete();
            } else {
                this.a.onError(th);
            }
        }

        public void onSubscribe(i.b.j0.b bVar) {
            this.a.onSubscribe(bVar);
        }
    }
    public l(f fVar, o<? super Throwable> oVar) {
        super();
        this.a = fVar;
        this.b = oVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        this.a.b(new l.a(this, dVar));
    }
}
