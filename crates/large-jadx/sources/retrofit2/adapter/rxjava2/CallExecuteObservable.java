package retrofit2.adapter.rxjava2;

import i.b.j0.b;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
final class CallExecuteObservable<T>  extends r<Response<T>> {

    private final Call<T> originalCall;

    private static final class CallDisposable implements b {

        private final Call<?> call;
        private volatile boolean disposed;
        CallDisposable(Call<?> call) {
            super();
            this.call = call;
        }

        @Override // i.b.j0.b
        public void dispose() {
            this.disposed = true;
            this.call.cancel();
        }

        @Override // i.b.j0.b
        public boolean isDisposed() {
            return this.disposed;
        }
    }
    CallExecuteObservable(Call<T> call) {
        super();
        this.originalCall = call;
    }

    protected void subscribeActual(y<? super Response<T>> y) {
        retrofit2.adapter.rxjava2.CallExecuteObservable.CallDisposable callDisposable;
        int arr;
        boolean disposed;
        Throwable obj6;
        Call clone = this.originalCall.clone();
        callDisposable = new CallExecuteObservable.CallDisposable(clone);
        y.onSubscribe(callDisposable);
        if (callDisposable.isDisposed()) {
        }
        int i = 1;
        final int i2 = 0;
        if (!callDisposable.isDisposed()) {
            y.onNext(clone.execute());
        }
        if (!callDisposable.isDisposed()) {
            y.onComplete();
        }
    }
}
