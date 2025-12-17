package retrofit2.adapter.rxjava2;

import i.b.j0.b;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes3.dex */
final class CallEnqueueObservable<T>  extends r<Response<T>> {

    private final Call<T> originalCall;

    private static final class CallCallback implements b, Callback<T> {

        private final Call<?> call;
        private volatile boolean disposed;
        private final y<? super Response<T>> observer;
        boolean terminated = false;
        CallCallback(Call<?> call, y<? super Response<T>> y2) {
            super();
            final int i = 0;
            this.call = call;
            this.observer = y2;
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

        public void onFailure(Call<T> call, Throwable throwable2) {
            CompositeException compositeException;
            int arr;
            int i;
            y obj4;
            Throwable obj5;
            if (call.isCanceled()) {
            }
            this.observer.onError(throwable2);
        }

        public void onResponse(Call<T> call, Response<T> response2) {
            y observer;
            CompositeException compositeException;
            int arr;
            int i;
            boolean obj6;
            if (this.disposed) {
            }
            this.observer.onNext(response2);
            if (!this.disposed) {
                this.terminated = true;
                this.observer.onComplete();
            }
        }
    }
    CallEnqueueObservable(Call<T> call) {
        super();
        this.originalCall = call;
    }

    protected void subscribeActual(y<? super Response<T>> y) {
        Call clone = this.originalCall.clone();
        CallEnqueueObservable.CallCallback callCallback = new CallEnqueueObservable.CallCallback(clone, y);
        y.onSubscribe(callCallback);
        if (!callCallback.isDisposed()) {
            clone.enqueue(callCallback);
        }
    }
}
