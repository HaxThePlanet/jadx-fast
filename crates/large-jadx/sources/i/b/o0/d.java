package i.b.o0;

import i.b.j0.b;
import i.b.m0.a.c;
import i.b.m0.a.d;
import i.b.y;
import io.reactivex.exceptions.CompositeException;

/* compiled from: SafeObserver.java */
/* loaded from: classes3.dex */
public final class d<T> implements y<T>, b {

    final y<? super T> a;
    b b;
    boolean c;
    public d(y<? super T> yVar) {
        super();
        this.a = yVar;
    }

    void a() {
        int i = 2;
        try {
            this.a.onSubscribe(d.INSTANCE);
        } catch (Throwable th) {
            a.b(th);
            int arr = new Throwable[arr];
            arr[i4] = obj;
            arr[i2] = th;
            CompositeException compositeException = new CompositeException(arr);
            a.t(compositeException);
        }
        try {
            this.a.onError(new NullPointerException("Subscription not set!"));
        } catch (Throwable th) {
            a.b(th);
            arr = new Throwable[arr];
            arr[i4] = obj;
            arr[i2] = th;
            compositeException = new CompositeException(arr);
            a.t(compositeException);
        }
    }

    void b() {
        this.c = true;
        int i = 2;
        try {
            this.a.onSubscribe(d.INSTANCE);
        } catch (Throwable th) {
            a.b(th);
            int arr = new Throwable[arr];
            arr[i4] = obj;
            arr[i2] = th;
            CompositeException compositeException = new CompositeException(arr);
            a.t(compositeException);
        }
        try {
            this.a.onError(new NullPointerException("Subscription not set!"));
        } catch (Throwable th) {
            a.b(th);
            arr = new Throwable[arr];
            arr[i4] = obj;
            arr[i2] = th;
            compositeException = new CompositeException(arr);
            a.t(compositeException);
        }
    }

    public void dispose() {
        this.b.dispose();
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void onComplete() {
        if (this.c) {
            return;
        }
        this.c = true;
        if (this.b == null) {
            a();
            return;
        }
        try {
            this.a.onComplete();
        } catch (Throwable th) {
            a.b(th);
            a.t(th);
        }
    }

    public void onError(Throwable th) {
        Object obj3;
        if (this.c) {
            a.t(th);
            return;
        }
        boolean z2 = true;
        this.c = z2;
        int i = 2;
        if (this.b == null) {
            int i2 = 3;
            try {
                this.a.onSubscribe(d.INSTANCE);
            } catch (Throwable th) {
                a.b(th);
                int compositeException2 = new Throwable[compositeException2];
                compositeException2[i4] = th;
                compositeException2[i3] = obj;
                compositeException2[arr] = th;
                CompositeException compositeException3 = new CompositeException(compositeException2);
                a.t(compositeException3);
            }
            try {
                final Throwable[] arr2 = new Throwable[2];
                arr2[z2] = new NullPointerException("Subscription not set!");
                this.a.onError(new CompositeException(arr2));
            } catch (Throwable th) {
                a.b(th);
                compositeException2 = new Throwable[compositeException2];
                compositeException2[i4] = th;
                compositeException2[i3] = obj;
                compositeException2[arr] = th;
                compositeException3 = new CompositeException(compositeException2);
                a.t(compositeException3);
            }
            return;
        }
        if (th == null) {
            java.lang.NullPointerException nullPointerException2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        try {
            this.a.onError(obj3);
        } catch (Throwable th) {
            a.b(th);
            int arr = new Throwable[arr];
            arr[i4] = th;
            arr[i3] = th;
            compositeException2 = new CompositeException(arr);
            a.t(compositeException2);
        }
    }

    public void onNext(T t) {
        if (this.c) {
            return;
        }
        if (this.b == null) {
            b();
            return;
        }
        if (t == null) {
            try {
                this.b.dispose();
            } catch (Throwable th) {
                a.b(th);
            }
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        try {
            this.a.onNext(th);
        } catch (Throwable th) {
            a.b(th);
        }
    }

    public void onSubscribe(b bVar) {
        if (c.validate(this.b, bVar)) {
            this.b = bVar;
            try {
                this.a.onSubscribe(this);
            } catch (Throwable th) {
                a.b(th);
                int arr = 2;
                arr = new Throwable[arr];
                arr[0] = th;
                arr[z] = th;
                a.t(new CompositeException(arr));
            }
        }
    }
}
