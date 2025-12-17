package retrofit2;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.IOException;
import java.util.Objects;
import l.e0;
import l.h;
import l.q;
import okhttp3.Call;
import okhttp3.Call.Factory;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
final class OkHttpCall<T>  implements retrofit2.Call<T> {

    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private Call rawCall;
    private final retrofit2.RequestFactory requestFactory;
    private final retrofit2.Converter<ResponseBody, T> responseConverter;

    static final class ExceptionCatchingResponseBody extends ResponseBody {

        private final ResponseBody delegate;
        private final h delegateSource;
        IOException thrownException;
        ExceptionCatchingResponseBody(ResponseBody responseBody) {
            super();
            this.delegate = responseBody;
            OkHttpCall.ExceptionCatchingResponseBody.1 anon = new OkHttpCall.ExceptionCatchingResponseBody.1(this, responseBody.source());
            this.delegateSource = q.d(anon);
        }

        @Override // okhttp3.ResponseBody
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.ResponseBody
        public h source() {
            return this.delegateSource;
        }

        @Override // okhttp3.ResponseBody
        void throwIfCaught() {
            final IOException thrownException = this.thrownException;
            if (thrownException != null) {
            } else {
            }
            throw thrownException;
        }
    }

    static final class NoContentResponseBody extends ResponseBody {

        private final long contentLength;
        private final MediaType contentType;
        NoContentResponseBody(MediaType mediaType, long l2) {
            super();
            this.contentType = mediaType;
            this.contentLength = l2;
        }

        @Override // okhttp3.ResponseBody
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.ResponseBody
        public MediaType contentType() {
            return this.contentType;
        }

        @Override // okhttp3.ResponseBody
        public h source() {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot read raw response body of a converted body.");
            throw illegalStateException;
        }
    }
    OkHttpCall(retrofit2.RequestFactory requestFactory, Object[] object2Arr2, Call.Factory call$Factory3, retrofit2.Converter<ResponseBody, T> converter4) {
        super();
        this.requestFactory = requestFactory;
        this.args = object2Arr2;
        this.callFactory = factory3;
        this.responseConverter = converter4;
    }

    private Call createRawCall() {
        Call call = this.callFactory.newCall(this.requestFactory.create(this.args));
        Objects.requireNonNull(call, "Call.Factory returned null.");
        return call;
    }

    private Call getRawCall() {
        Call rawCall = this.rawCall;
        if (rawCall != null) {
            return rawCall;
        }
        Throwable creationFailure = this.creationFailure;
        if (creationFailure != null) {
            if (creationFailure instanceof IOException != null) {
            } else {
                if (creationFailure instanceof RuntimeException != null) {
                    throw (RuntimeException)creationFailure;
                }
                throw (Error)creationFailure;
            }
            throw (IOException)creationFailure;
        }
        Call rawCall2 = createRawCall();
        this.rawCall = rawCall2;
        return rawCall2;
    }

    @Override // retrofit2.Call
    public void cancel() {
        this.canceled = true;
        Call rawCall = this.rawCall;
        synchronized (this) {
            this.canceled = true;
            rawCall = this.rawCall;
        }
        rawCall.cancel();
    }

    @Override // retrofit2.Call
    public Object clone() {
        return clone();
    }

    @Override // retrofit2.Call
    public retrofit2.Call clone() {
        return clone();
    }

    public retrofit2.OkHttpCall<T> clone() {
        OkHttpCall okHttpCall = new OkHttpCall(this.requestFactory, this.args, this.callFactory, this.responseConverter);
        return okHttpCall;
    }

    public void enqueue(retrofit2.Callback<T> callback) {
        Call rawCall2;
        Throwable creationFailure;
        Call rawCall;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            this.executed = true;
            if (this.rawCall == null && this.creationFailure == null) {
                if (this.creationFailure == null) {
                    rawCall = createRawCall();
                    this.rawCall = rawCall;
                    rawCall2 = rawCall;
                }
            }
            if (creationFailure != null) {
            }
            if (this.canceled) {
                rawCall2.cancel();
            }
            OkHttpCall.1 anon = new OkHttpCall.1(this, callback);
            FirebasePerfOkHttpClient.enqueue(rawCall2, anon);
        }
        try {
            callback.onFailure(this, creationFailure);
            if (this.canceled) {
            }
            rawCall2.cancel();
            anon = new OkHttpCall.1(this, callback);
            FirebasePerfOkHttpClient.enqueue(rawCall2, anon);
            IllegalStateException obj4 = new IllegalStateException("Already executed.");
            throw obj4;
            throw callback;
        } catch (Throwable th) {
        }
    }

    public retrofit2.Response<T> execute() {
        synchronized (this) {
            try {
                this.executed = true;
                Call rawCall = getRawCall();
                if (this.canceled) {
                }
                rawCall.cancel();
                return parseResponse(FirebasePerfOkHttpClient.execute(rawCall));
                IllegalStateException illegalStateException = new IllegalStateException("Already executed.");
                throw illegalStateException;
                throw th;
            }
        }
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        Call rawCall;
        int i;
        if (this.canceled) {
            return 1;
        }
        rawCall = this.rawCall;
        synchronized (this) {
            if (rawCall.isCanceled()) {
            } else {
                i = 0;
            }
            return i;
        }
    }

    @Override // retrofit2.Call
    public boolean isExecuted() {
        return this.executed;
        synchronized (this) {
            return this.executed;
        }
    }

    retrofit2.Response<T> parseResponse(Response response) {
        int i2;
        int i;
        ResponseBody body = response.body();
        OkHttpCall.NoContentResponseBody noContentResponseBody = new OkHttpCall.NoContentResponseBody(body.contentType(), body.contentLength(), obj4);
        Response obj6 = response.newBuilder().body(noContentResponseBody).build();
        int code = obj6.code();
        if (code >= 200) {
            if (code >= 300) {
            } else {
                if (code != 204 && code == 205) {
                    if (code == 205) {
                    }
                    OkHttpCall.ExceptionCatchingResponseBody exceptionCatchingResponseBody = new OkHttpCall.ExceptionCatchingResponseBody(body);
                    return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), obj6);
                }
            }
            body.close();
            return Response.success(0, obj6);
        }
        body.close();
        return Response.error(Utils.buffer(body), obj6);
    }

    @Override // retrofit2.Call
    public Request request() {
        return getRawCall().request();
        synchronized (this) {
            return getRawCall().request();
        }
    }

    @Override // retrofit2.Call
    public e0 timeout() {
        return getRawCall().timeout();
        synchronized (this) {
            return getRawCall().timeout();
        }
    }
}
