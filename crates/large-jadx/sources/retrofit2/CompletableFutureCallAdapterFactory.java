package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;

/* loaded from: classes3.dex */
final class CompletableFutureCallAdapterFactory extends retrofit2.CallAdapter.Factory {

    static final retrofit2.CallAdapter.Factory INSTANCE;

    private static final class CallCancelCompletableFuture extends CompletableFuture<T> {

        private final retrofit2.Call<?> call;
        CallCancelCompletableFuture(retrofit2.Call<?> call) {
            super();
            this.call = call;
        }

        @Override // java.util.concurrent.CompletableFuture
        public boolean cancel(boolean z) {
            retrofit2.Call call;
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }

    private static final class BodyCallAdapter implements retrofit2.CallAdapter<R, CompletableFuture<R>> {

        private final Type responseType;
        BodyCallAdapter(Type type) {
            super();
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public Object adapt(retrofit2.Call call) {
            return adapt(call);
        }

        public CompletableFuture<R> adapt(retrofit2.Call<R> call) {
            CompletableFutureCallAdapterFactory.CallCancelCompletableFuture callCancelCompletableFuture = new CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(call);
            CompletableFutureCallAdapterFactory.BodyCallAdapter.BodyCallback bodyCallback = new CompletableFutureCallAdapterFactory.BodyCallAdapter.BodyCallback(this, callCancelCompletableFuture);
            call.enqueue(bodyCallback);
            return callCancelCompletableFuture;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }
    }

    private static final class ResponseCallAdapter implements retrofit2.CallAdapter<R, CompletableFuture<retrofit2.Response<R>>> {

        private final Type responseType;
        ResponseCallAdapter(Type type) {
            super();
            this.responseType = type;
        }

        @Override // retrofit2.CallAdapter
        public Object adapt(retrofit2.Call call) {
            return adapt(call);
        }

        public CompletableFuture<retrofit2.Response<R>> adapt(retrofit2.Call<R> call) {
            CompletableFutureCallAdapterFactory.CallCancelCompletableFuture callCancelCompletableFuture = new CompletableFutureCallAdapterFactory.CallCancelCompletableFuture(call);
            CompletableFutureCallAdapterFactory.ResponseCallAdapter.ResponseCallback responseCallback = new CompletableFutureCallAdapterFactory.ResponseCallAdapter.ResponseCallback(this, callCancelCompletableFuture);
            call.enqueue(responseCallback);
            return callCancelCompletableFuture;
        }

        @Override // retrofit2.CallAdapter
        public Type responseType() {
            return this.responseType;
        }
    }
    static {
        CompletableFutureCallAdapterFactory completableFutureCallAdapterFactory = new CompletableFutureCallAdapterFactory();
        CompletableFutureCallAdapterFactory.INSTANCE = completableFutureCallAdapterFactory;
    }

    public retrofit2.CallAdapter<?, ?> get(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3) {
        if (CallAdapter.Factory.getRawType(type) != CompletableFuture.class) {
            return 0;
        }
        if (!type instanceof ParameterizedType) {
        } else {
            int obj3 = 0;
            Type obj2 = CallAdapter.Factory.getParameterUpperBound(obj3, (ParameterizedType)type);
            if (CallAdapter.Factory.getRawType(obj2) != Response.class) {
                obj3 = new CompletableFutureCallAdapterFactory.BodyCallAdapter(obj2);
                return obj3;
            }
            if (!obj2 instanceof ParameterizedType) {
            } else {
                obj3 = new CompletableFutureCallAdapterFactory.ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(obj3, (ParameterizedType)obj2));
                return obj3;
            }
            obj2 = new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            throw obj2;
        }
        obj2 = new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        throw obj2;
    }
}
