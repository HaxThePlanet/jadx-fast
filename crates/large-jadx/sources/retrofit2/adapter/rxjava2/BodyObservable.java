package retrofit2.adapter.rxjava2;

import i.b.j0.b;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import retrofit2.Response;

/* loaded from: classes3.dex */
final class BodyObservable<T>  extends r<T> {

    private final r<Response<T>> upstream;

    private static class BodyObserver implements y<Response<R>> {

        private final y<? super R> observer;
        private boolean terminated;
        BodyObserver(y<? super R> y) {
            super();
            this.observer = y;
        }

        @Override // i.b.y
        public void onComplete() {
            boolean terminated;
            if (!this.terminated) {
                this.observer.onComplete();
            }
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            Object assertionError;
            String str;
            if (!this.terminated) {
                this.observer.onError(throwable);
            } else {
                assertionError = new AssertionError("This should never happen! Report as a bug with the full stacktrace.");
                assertionError.initCause(throwable);
                a.t(assertionError);
            }
        }

        @Override // i.b.y
        public void onNext(Object object) {
            onNext((Response)object);
        }

        public void onNext(Response<R> response) {
            y observer;
            Object httpException;
            CompositeException compositeException;
            int arr;
            int i;
            Object obj6;
            if (response.isSuccessful()) {
                this.observer.onNext(response.body());
            } else {
                this.terminated = true;
                httpException = new HttpException(response);
                this.observer.onError(httpException);
            }
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.observer.onSubscribe(b);
        }
    }
    BodyObservable(r<Response<T>> r) {
        super();
        this.upstream = r;
    }

    protected void subscribeActual(y<? super T> y) {
        BodyObservable.BodyObserver bodyObserver = new BodyObservable.BodyObserver(y);
        this.upstream.subscribe(bodyObserver);
    }
}
