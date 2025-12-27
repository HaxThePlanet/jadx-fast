package i.b.m0.e.a;

import i.b.d;
import i.b.f;
import i.b.l0.n;
import i.b.m0.a.c;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: CompletableResumeNext.java */
/* loaded from: classes3.dex */
public final class n extends i.b.b {

    final f a;
    final n<? super Throwable, ? extends f> b;

    static final class a extends AtomicReference<i.b.j0.b> implements d, i.b.j0.b {

        private static final long serialVersionUID = 5018523762564524046L;
        final d downstream;
        final n<? super Throwable, ? extends f> errorMapper;
        boolean once;
        a(d dVar, n<? super Throwable, ? extends f> nVar) {
            super();
            this.downstream = dVar;
            this.errorMapper = nVar;
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void dispose() {
            c.dispose(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public boolean isDisposed() {
            return c.isDisposed((b)get());
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onComplete() {
            this.downstream.onComplete();
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onError(Throwable th) {
            if (this.once) {
                this.downstream.onError(th);
                return;
            }
            this.once = true;
            try {
                Object apply = this.errorMapper.apply(th);
                b.e(apply, "The errorMapper returned a null CompletableSource");
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                arr[i] = th;
                this.downstream.onError(new CompositeException(arr));
                return;
            }
            apply.b(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(i.b.j0.b bVar) {
            c.replace(this, bVar);
        }
    }
    public n(f fVar, n<? super Throwable, ? extends f> nVar) {
        super();
        this.a = fVar;
        this.b = nVar;
    }

    @Override // i.b.b
    protected void x(d dVar) {
        final i.b.m0.e.a.n.a aVar = new n.a(dVar, this.b);
        dVar.onSubscribe(aVar);
        this.a.b(aVar);
    }
}
