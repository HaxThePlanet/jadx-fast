package i.b.m0.d;

import i.b.d0;
import i.b.j0.b;
import i.b.l0.b;
import i.b.m0.a.c;
import i.b.p0.a;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class d<T>  extends AtomicReference<b> implements d0<T>, b {

    private static final long serialVersionUID = 4943102778943297569L;
    final b<? super T, ? super Throwable> onCallback;
    public d(b<? super T, ? super Throwable> b) {
        super();
        this.onCallback = b;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void dispose() {
        c.dispose(this);
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public boolean isDisposed() {
        int i;
        i = get() == c.DISPOSED ? 1 : 0;
        return i;
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onError(Throwable throwable) {
        b onCallback;
        int i;
        int arr;
        int i2;
        Object obj5;
        try {
            lazySet(c.DISPOSED);
            this.onCallback.a(0, throwable);
            a.b(th);
            arr = 2;
            arr = new Throwable[arr];
            arr[0] = throwable;
            throwable = 1;
            arr[throwable] = th;
            CompositeException compositeException = new CompositeException(arr);
            a.t(compositeException);
        }
    }

    @Override // java.util.concurrent.atomic.AtomicReference
    public void onSubscribe(b b) {
        c.setOnce(this, b);
    }

    public void onSuccess(T t) {
        Object obj3;
        try {
            lazySet(c.DISPOSED);
            this.onCallback.a(t, 0);
            a.b(t);
            a.t(t);
        }
    }
}
