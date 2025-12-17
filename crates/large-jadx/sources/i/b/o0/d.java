package i.b.o0;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.p0.a;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;

/* loaded from: classes3.dex */
public final class d<T>  implements y<T>, b {

    final y<? super T> a;
    b b;
    boolean c;
    public d(y<? super T> y) {
        super();
        this.a = y;
    }

    @Override // i.b.y
    void a() {
        int i;
        y yVar;
        d iNSTANCE;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        int i2 = 1;
        final int i3 = 0;
        i = 2;
        this.a.onSubscribe(d.INSTANCE);
        this.a.onError(nullPointerException);
    }

    @Override // i.b.y
    void b() {
        int i;
        y yVar;
        d iNSTANCE;
        this.c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        int i3 = 0;
        i = 2;
        this.a.onSubscribe(d.INSTANCE);
        this.a.onError(nullPointerException);
    }

    @Override // i.b.y
    public void dispose() {
        this.b.dispose();
    }

    @Override // i.b.y
    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    @Override // i.b.y
    public void onComplete() {
        y yVar;
        if (this.c) {
        }
        this.c = true;
        if (this.b == null) {
            a();
        }
        this.a.onComplete();
    }

    @Override // i.b.y
    public void onError(Throwable throwable) {
        Object str;
        y yVar;
        int i2;
        int compositeException;
        int i;
        y yVar2;
        CompositeException compositeException2;
        Object obj9;
        if (this.c) {
            a.t(throwable);
        }
        int i3 = 1;
        this.c = i3;
        if (this.b == null) {
            NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
            i = 3;
            this.a.onSubscribe(d.INSTANCE);
            final Throwable[] arr2 = new Throwable[2];
            arr2[i3] = nullPointerException;
            compositeException2 = new CompositeException(arr2);
            this.a.onError(compositeException2);
        }
        if (throwable == null) {
            obj9 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.a.onError(obj9);
    }

    public void onNext(T t) {
        y yVar;
        Object obj6;
        if (this.c) {
        }
        if (this.b == null) {
            b();
        }
        int i = 1;
        final int i2 = 0;
        final int i3 = 2;
        if (t == null) {
            obj6 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.b.dispose();
            onError(obj6);
        }
        this.a.onNext(t);
    }

    @Override // i.b.y
    public void onSubscribe(b b) {
        boolean validate;
        int i2;
        CompositeException compositeException;
        int arr;
        int i;
        b obj6;
        if (c.validate(this.b, b)) {
            this.b = b;
            this.a.onSubscribe(this);
        }
    }
}
