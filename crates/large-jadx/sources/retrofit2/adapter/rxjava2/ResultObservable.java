package retrofit2.adapter.rxjava2;

import i.b.j0.b;
import i.b.p0.a;
import i.b.r;
import i.b.y;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.a;
import retrofit2.Response;

/* loaded from: classes3.dex */
final class ResultObservable<T>  extends r<retrofit2.adapter.rxjava2.Result<T>> {

    private final r<Response<T>> upstream;

    private static class ResultObserver implements y<Response<R>> {

        private final y<? super retrofit2.adapter.rxjava2.Result<R>> observer;
        ResultObserver(y<? super retrofit2.adapter.rxjava2.Result<R>> y) {
            super();
            this.observer = y;
        }

        @Override // i.b.y
        public void onComplete() {
            this.observer.onComplete();
        }

        @Override // i.b.y
        public void onError(Throwable throwable) {
            CompositeException compositeException;
            int arr;
            int i;
            try {
                this.observer.onNext(Result.error(throwable));
                this.observer.onComplete();
                y yVar = this.observer;
                yVar.onError(throwable);
                a.b(yVar);
                arr = 2;
                arr = new Throwable[arr];
                arr[0] = throwable;
                throwable = 1;
                arr[throwable] = yVar;
                compositeException = new CompositeException(arr);
                a.t(compositeException);
            } catch (Throwable th) {
            }
        }

        @Override // i.b.y
        public void onNext(Object object) {
            onNext((Response)object);
        }

        public void onNext(Response<R> response) {
            this.observer.onNext(Result.response(response));
        }

        @Override // i.b.y
        public void onSubscribe(b b) {
            this.observer.onSubscribe(b);
        }
    }
    ResultObservable(r<Response<T>> r) {
        super();
        this.upstream = r;
    }

    protected void subscribeActual(y<? super retrofit2.adapter.rxjava2.Result<T>> y) {
        ResultObservable.ResultObserver resultObserver = new ResultObservable.ResultObserver(y);
        this.upstream.subscribe(resultObserver);
    }
}
