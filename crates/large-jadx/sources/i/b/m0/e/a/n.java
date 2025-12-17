package i.b.m0.e.a;

import i.b.b;
import i.b.d;
import i.b.f;
import i.b.j0.b;
import i.b.l0.n;
import i.b.m0.a.c;
import i.b.m0.b.b;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class n extends b {

    final f a;
    final n<? super Throwable, ? extends f> b;

    static final class a extends AtomicReference<b> implements d, b {

        private static final long serialVersionUID = 5018523762564524046L;
        final d downstream;
        final n<? super Throwable, ? extends f> errorMapper;
        boolean once;
        a(d d, n<? super Throwable, ? extends f> n2) {
            super();
            this.downstream = d;
            this.errorMapper = n2;
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
        public void onError(Throwable throwable) {
            if (this.once) {
                this.downstream.onError(throwable);
            }
            this.once = true;
            Object apply = this.errorMapper.apply(throwable);
            b.e(apply, "The errorMapper returned a null CompletableSource");
            (f)apply.b(this);
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public void onSubscribe(b b) {
            c.replace(this, b);
        }
    }
    public n(f f, n<? super Throwable, ? extends f> n2) {
        super();
        this.a = f;
        this.b = n2;
    }

    @Override // i.b.b
    protected void x(d d) {
        n.a aVar = new n.a(d, this.b);
        d.onSubscribe(aVar);
        this.a.b(aVar);
    }
}
