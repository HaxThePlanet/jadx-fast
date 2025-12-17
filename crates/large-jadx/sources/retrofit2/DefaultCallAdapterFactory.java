package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import l.e0;
import okhttp3.Request;

/* loaded from: classes3.dex */
final class DefaultCallAdapterFactory extends retrofit2.CallAdapter.Factory {

    private final Executor callbackExecutor;

    static final class ExecutorCallbackCall implements retrofit2.Call<T> {

        final Executor callbackExecutor;
        final retrofit2.Call<T> delegate;
        ExecutorCallbackCall(Executor executor, retrofit2.Call<T> call2) {
            super();
            this.callbackExecutor = executor;
            this.delegate = call2;
        }

        @Override // retrofit2.Call
        public void cancel() {
            this.delegate.cancel();
        }

        @Override // retrofit2.Call
        public Object clone() {
            return clone();
        }

        public retrofit2.Call<T> clone() {
            DefaultCallAdapterFactory.ExecutorCallbackCall executorCallbackCall = new DefaultCallAdapterFactory.ExecutorCallbackCall(this.callbackExecutor, this.delegate.clone());
            return executorCallbackCall;
        }

        public void enqueue(retrofit2.Callback<T> callback) {
            Objects.requireNonNull(callback, "callback == null");
            DefaultCallAdapterFactory.ExecutorCallbackCall.1 anon = new DefaultCallAdapterFactory.ExecutorCallbackCall.1(this, callback);
            this.delegate.enqueue(anon);
        }

        public retrofit2.Response<T> execute() {
            return this.delegate.execute();
        }

        @Override // retrofit2.Call
        public boolean isCanceled() {
            return this.delegate.isCanceled();
        }

        @Override // retrofit2.Call
        public boolean isExecuted() {
            return this.delegate.isExecuted();
        }

        @Override // retrofit2.Call
        public Request request() {
            return this.delegate.request();
        }

        @Override // retrofit2.Call
        public e0 timeout() {
            return this.delegate.timeout();
        }
    }
    DefaultCallAdapterFactory(Executor executor) {
        super();
        this.callbackExecutor = executor;
    }

    public retrofit2.CallAdapter<?, ?> get(Type type, Annotation[] annotation2Arr2, retrofit2.Retrofit retrofit3) {
        Executor callbackExecutor;
        if (CallAdapter.Factory.getRawType(type) != Call.class) {
            return 0;
        }
        if (!type instanceof ParameterizedType) {
        } else {
            if (Utils.isAnnotationPresent(annotation2Arr2, SkipCallbackExecutor.class)) {
            } else {
                callbackExecutor = this.callbackExecutor;
            }
            DefaultCallAdapterFactory.1 obj4 = new DefaultCallAdapterFactory.1(this, Utils.getParameterUpperBound(0, (ParameterizedType)type), callbackExecutor);
            return obj4;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
        throw obj3;
    }
}
