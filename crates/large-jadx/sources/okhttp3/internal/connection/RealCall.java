package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.b;
import kotlin.d0.d.n;
import kotlin.w;
import kotlin.y.p;
import l.d;
import l.e0;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheInterceptor;
import okhttp3.internal.http.BridgeInterceptor;
import okhttp3.internal.http.CallServerInterceptor;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RetryAndFollowUpInterceptor;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000«\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000e*\u0001Z\u0018\u00002\u00020\u0001:\u0002z{B\u001f\u0012\u0006\u0010o\u001a\u00020n\u0012\u0006\u0010b\u001a\u00020\u0019\u0012\u0006\u0010\\\u001a\u00020\u001d¢\u0006\u0004\u0008x\u0010yJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J#\u0010\u0008\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ#\u0010\u000b\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\u0008\u000b\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u001c\u0010\u0004J\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\u0008!\u0010\"J\u0017\u0010%\u001a\u00020\u00022\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\u0008%\u0010&J\u000f\u0010'\u001a\u00020\u001dH\u0016¢\u0006\u0004\u0008'\u0010\u001fJ\u000f\u0010)\u001a\u00020 H\u0000¢\u0006\u0004\u0008(\u0010\"J\u001d\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u001d¢\u0006\u0004\u0008+\u0010,J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0004\u00080\u00101J\u0015\u00105\u001a\u00020\u00022\u0006\u00104\u001a\u000203¢\u0006\u0004\u00085\u00106J;\u0010<\u001a\u00028\u0000\"\n\u0008\u0000\u0010\u0006*\u0004\u0018\u00010\u00052\u0006\u00107\u001a\u00020/2\u0006\u00108\u001a\u00020\u001d2\u0006\u00109\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00028\u0000H\u0000¢\u0006\u0004\u0008:\u0010;J\u001b\u0010>\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\u0008=\u0010\tJ\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0000¢\u0006\u0004\u0008@\u0010AJ\r\u0010C\u001a\u00020\u0002¢\u0006\u0004\u0008C\u0010\u0004J\u0017\u0010G\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u001dH\u0000¢\u0006\u0004\u0008E\u0010FJ\r\u0010H\u001a\u00020\u001d¢\u0006\u0004\u0008H\u0010\u001fJ\u000f\u0010J\u001a\u00020\u0011H\u0000¢\u0006\u0004\u0008I\u0010\u0013R\u0018\u0010L\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008L\u0010MR\u001c\u0010O\u001a\u00020N8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008O\u0010P\u001a\u0004\u0008Q\u0010RR$\u0010S\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008S\u0010T\u001a\u0004\u0008U\u0010V\"\u0004\u0008W\u00106R(\u00104\u001a\u0004\u0018\u0001032\u0008\u0010X\u001a\u0004\u0018\u0001038\u0006@BX\u0086\u000e¢\u0006\u000c\n\u0004\u00084\u0010T\u001a\u0004\u0008Y\u0010VR\u0016\u0010\u0015\u001a\u00020Z8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010[R\u0019\u0010\\\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\\\u0010]\u001a\u0004\u0008^\u0010\u001fR\u0016\u0010`\u001a\u00020_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008`\u0010aR\u0019\u0010b\u001a\u00020\u00198\u0006@\u0006¢\u0006\u000c\n\u0004\u0008b\u0010c\u001a\u0004\u0008d\u0010\u001bR\u0018\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008f\u0010gR\u0016\u0010i\u001a\u00020h8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008i\u0010jR\u0016\u0010k\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008k\u0010]R\u0016\u0010l\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008l\u0010]R\u0018\u00107\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00087\u0010mR\u0019\u0010o\u001a\u00020n8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008o\u0010p\u001a\u0004\u0008q\u0010rR(\u0010s\u001a\u0004\u0018\u00010/2\u0008\u0010X\u001a\u0004\u0018\u00010/8\u0000@BX\u0080\u000e¢\u0006\u000c\n\u0004\u0008s\u0010m\u001a\u0004\u0008t\u0010uR\u0016\u0010v\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008v\u0010]R\u0016\u0010w\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008w\u0010]R\u0016\u0010C\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008C\u0010]¨\u0006|", d2 = {"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "Lkotlin/w;", "callStart", "()V", "Ljava/io/IOException;", "E", "e", "callDone", "(Ljava/io/IOException;)Ljava/io/IOException;", "cause", "timeoutExit", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Address;", "createAddress", "(Lokhttp3/HttpUrl;)Lokhttp3/Address;", "", "toLoggableString", "()Ljava/lang/String;", "Ll/d;", "timeout", "()Ll/d;", "clone", "()Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "cancel", "", "isCanceled", "()Z", "Lokhttp3/Response;", "execute", "()Lokhttp3/Response;", "Lokhttp3/Callback;", "responseCallback", "enqueue", "(Lokhttp3/Callback;)V", "isExecuted", "getResponseWithInterceptorChain$okhttp", "getResponseWithInterceptorChain", "newExchangeFinder", "enterNetworkInterceptorExchange", "(Lokhttp3/Request;Z)V", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/connection/Exchange;", "initExchange$okhttp", "(Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/connection/Exchange;", "initExchange", "Lokhttp3/internal/connection/RealConnection;", "connection", "acquireConnectionNoEvents", "(Lokhttp3/internal/connection/RealConnection;)V", "exchange", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "messageDone", "noMoreExchanges$okhttp", "noMoreExchanges", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "()Ljava/net/Socket;", "releaseConnectionNoEvents", "timeoutEarlyExit", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "(Z)V", "exitNetworkInterceptorExchange", "retryAfterFailure", "redactedUrl$okhttp", "redactedUrl", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "getEventListener$okhttp", "()Lokhttp3/EventListener;", "connectionToCancel", "Lokhttp3/internal/connection/RealConnection;", "getConnectionToCancel", "()Lokhttp3/internal/connection/RealConnection;", "setConnectionToCancel", "<set-?>", "getConnection", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "forWebSocket", "Z", "getForWebSocket", "Ljava/util/concurrent/atomic/AtomicBoolean;", "executed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "originalRequest", "Lokhttp3/Request;", "getOriginalRequest", "", "callStackTrace", "Ljava/lang/Object;", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "requestBodyOpen", "canceled", "Lokhttp3/internal/connection/Exchange;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/OkHttpClient;", "getClient", "()Lokhttp3/OkHttpClient;", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "expectMoreExchanges", "responseBodyOpen", "<init>", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "AsyncCall", "CallReference", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealCall implements Call {

    private Object callStackTrace;
    private volatile boolean canceled;
    private final OkHttpClient client;
    private okhttp3.internal.connection.RealConnection connection;
    private final okhttp3.internal.connection.RealConnectionPool connectionPool;
    private volatile okhttp3.internal.connection.RealConnection connectionToCancel;
    private final EventListener eventListener;
    private volatile okhttp3.internal.connection.Exchange exchange;
    private okhttp3.internal.connection.ExchangeFinder exchangeFinder;
    private final AtomicBoolean executed;
    private boolean expectMoreExchanges = true;
    private final boolean forWebSocket;
    private okhttp3.internal.connection.Exchange interceptorScopedExchange;
    private final Request originalRequest;
    private boolean requestBodyOpen;
    private boolean responseBodyOpen;
    private final okhttp3.internal.connection.RealCall.timeout.1 timeout;
    private boolean timeoutEarlyExit;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\u0008!\u0010\"J\u0019\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u00060\u0000R\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0013\u0010\u0010\u001a\u00020\r8F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0013\u0010\u0014\u001a\u00020\u00118F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0013\u0010\u0017\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u001aR$\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b8\u0006@BX\u0086\u000e¢\u0006\u000c\n\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001f\u0010 ¨\u0006#", d2 = {"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "Lokhttp3/internal/connection/RealCall;", "other", "Lkotlin/w;", "reuseCallsPerHostFrom", "(Lokhttp3/internal/connection/RealCall$AsyncCall;)V", "Ljava/util/concurrent/ExecutorService;", "executorService", "executeOn", "(Ljava/util/concurrent/ExecutorService;)V", "run", "()V", "", "getHost", "()Ljava/lang/String;", "host", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "request", "getCall", "()Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/Callback;", "responseCallback", "Lokhttp3/Callback;", "Ljava/util/concurrent/atomic/AtomicInteger;", "<set-?>", "callsPerHost", "Ljava/util/concurrent/atomic/AtomicInteger;", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "<init>", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class AsyncCall implements Runnable {

        private volatile AtomicInteger callsPerHost;
        private final Callback responseCallback;
        final okhttp3.internal.connection.RealCall this$0;
        public AsyncCall(okhttp3.internal.connection.RealCall realCall, Callback callback2) {
            n.f(callback2, "responseCallback");
            this.this$0 = realCall;
            super();
            this.responseCallback = callback2;
            AtomicInteger obj2 = new AtomicInteger(0);
            this.callsPerHost = obj2;
        }

        @Override // java.lang.Runnable
        public final void executeOn(ExecutorService executorService) {
            Dispatcher dispatcher;
            boolean assertionsEnabled;
            Object obj5;
            n.f(executorService, "executorService");
            dispatcher = this.this$0.getClient().dispatcher();
            if (Util.assertionsEnabled) {
                if (Thread.holdsLock(dispatcher)) {
                } else {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Thread ");
                Thread currentThread = Thread.currentThread();
                n.e(currentThread, "Thread.currentThread()");
                stringBuilder.append(currentThread.getName());
                stringBuilder.append(" MUST NOT hold lock on ");
                stringBuilder.append(dispatcher);
                obj5 = new AssertionError(stringBuilder.toString());
                throw obj5;
            }
            executorService.execute(this);
        }

        @Override // java.lang.Runnable
        public final okhttp3.internal.connection.RealCall getCall() {
            return this.this$0;
        }

        @Override // java.lang.Runnable
        public final AtomicInteger getCallsPerHost() {
            return this.callsPerHost;
        }

        @Override // java.lang.Runnable
        public final String getHost() {
            return this.this$0.getOriginalRequest().url().host();
        }

        @Override // java.lang.Runnable
        public final Request getRequest() {
            return this.this$0.getOriginalRequest();
        }

        @Override // java.lang.Runnable
        public final void reuseCallsPerHostFrom(okhttp3.internal.connection.RealCall.AsyncCall realCall$AsyncCall) {
            n.f(asyncCall, "other");
            this.callsPerHost = asyncCall.callsPerHost;
        }

        @Override // java.lang.Runnable
        public void run() {
            Dispatcher dispatcher;
            Throwable dispatcher2;
            int i;
            okhttp3.internal.connection.RealCall this$0;
            Callback responseCallback;
            String str;
            okhttp3.internal.connection.RealCall this$02;
            Throwable th2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("OkHttp ");
            stringBuilder.append(this.this$0.redactedUrl$okhttp());
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "currentThread");
            currentThread.setName(stringBuilder.toString());
            int i2 = 0;
            RealCall.access$getTimeout$p(this.this$0).enter();
            i = 1;
            this.responseCallback.onResponse(this.this$0, this.this$0.getResponseWithInterceptorChain$okhttp());
            dispatcher = this.this$0.getClient().dispatcher();
            dispatcher.finished$okhttp(this);
            currentThread.setName(currentThread.getName());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0006\u0010\u0008\u001a\u00020\u0002\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\u0008\t\u0010\nR\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000b", d2 = {"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "", "callStackTrace", "Ljava/lang/Object;", "getCallStackTrace", "()Ljava/lang/Object;", "referent", "<init>", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class CallReference extends WeakReference<okhttp3.internal.connection.RealCall> {

        private final Object callStackTrace;
        public CallReference(okhttp3.internal.connection.RealCall realCall, Object object2) {
            n.f(realCall, "referent");
            super(realCall);
            this.callStackTrace = object2;
        }

        @Override // java.lang.ref.WeakReference
        public final Object getCallStackTrace() {
            return this.callStackTrace;
        }
    }
    public RealCall(OkHttpClient okHttpClient, Request request2, boolean z3) {
        n.f(okHttpClient, "client");
        n.f(request2, "originalRequest");
        super();
        this.client = okHttpClient;
        this.originalRequest = request2;
        this.forWebSocket = z3;
        this.connectionPool = okHttpClient.connectionPool().getDelegate$okhttp();
        this.eventListener = okHttpClient.eventListenerFactory().create(this);
        RealCall.timeout.1 obj4 = new RealCall.timeout.1(this);
        obj4.timeout((long)obj3, obj1);
        w obj3 = w.a;
        this.timeout = obj4;
        obj3 = new AtomicBoolean();
        this.executed = obj3;
        obj3 = 1;
    }

    public static final okhttp3.internal.connection.RealCall.timeout.1 access$getTimeout$p(okhttp3.internal.connection.RealCall realCall) {
        return realCall.timeout;
    }

    public static final String access$toLoggableString(okhttp3.internal.connection.RealCall realCall) {
        return realCall.toLoggableString();
    }

    private final <E extends IOException> E callDone(E e) {
        boolean assertionsEnabled;
        boolean holdsLock;
        okhttp3.internal.connection.RealConnection connection;
        EventListener obj5;
        assertionsEnabled = Util.assertionsEnabled;
        if (assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(this);
            obj5 = new AssertionError(stringBuilder.toString());
            throw obj5;
        }
        okhttp3.internal.connection.RealConnection connection2 = this.connection;
        if (connection2 != null && assertionsEnabled) {
            if (assertionsEnabled) {
                if (Thread.holdsLock(connection2)) {
                } else {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Thread ");
                Thread currentThread2 = Thread.currentThread();
                n.e(currentThread2, "Thread.currentThread()");
                stringBuilder2.append(currentThread2.getName());
                stringBuilder2.append(" MUST NOT hold lock on ");
                stringBuilder2.append(connection2);
                obj5 = new AssertionError(stringBuilder2.toString());
                throw obj5;
            }
            Socket releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            synchronized (connection2) {
                releaseConnectionNoEvents$okhttp = releaseConnectionNoEvents$okhttp();
            }
            if (releaseConnectionNoEvents$okhttp != null) {
                Util.closeQuietly(releaseConnectionNoEvents$okhttp);
            }
            this.eventListener.connectionReleased(this, connection2);
        }
        IOException timeoutExit = timeoutExit(e);
        if (e != null) {
            n.d(timeoutExit);
            this.eventListener.callFailed(this, timeoutExit);
        } else {
            this.eventListener.callEnd(this);
        }
        return timeoutExit;
    }

    private final void callStart() {
        this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
        this.eventListener.callStart(this);
    }

    private final Address createAddress(HttpUrl httpUrl) {
        javax.net.ssl.HostnameVerifier hostnameVerifier2;
        javax.net.ssl.SSLSocketFactory sslSocketFactory;
        okhttp3.CertificatePinner certificatePinner2;
        javax.net.ssl.SSLSocketFactory factory;
        javax.net.ssl.HostnameVerifier hostnameVerifier;
        okhttp3.CertificatePinner certificatePinner;
        final Object obj = this;
        if (httpUrl.isHttps()) {
            hostnameVerifier = hostnameVerifier2;
            factory = sslSocketFactory;
            certificatePinner = certificatePinner2;
        } else {
            certificatePinner = hostnameVerifier;
        }
        super(httpUrl.host(), httpUrl.port(), obj.client.dns(), obj.client.socketFactory(), factory, hostnameVerifier, certificatePinner, obj.client.proxyAuthenticator(), obj.client.proxy(), obj.client.protocols(), obj.client.connectionSpecs(), obj.client.proxySelector());
        return address;
    }

    private final <E extends IOException> E timeoutExit(E e) {
        if (this.timeoutEarlyExit) {
            return e;
        }
        if (!this.timeout.exit()) {
            return e;
        }
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (e != null) {
            interruptedIOException.initCause(e);
        }
        return interruptedIOException;
    }

    private final String toLoggableString() {
        String str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        str = isCanceled() ? "canceled " : "";
        stringBuilder.append(str);
        str2 = this.forWebSocket ? "web socket" : "call";
        stringBuilder.append(str2);
        stringBuilder.append(" to ");
        stringBuilder.append(redactedUrl$okhttp());
        return stringBuilder.toString();
    }

    @Override // okhttp3.Call
    public final void acquireConnectionNoEvents(okhttp3.internal.connection.RealConnection realConnection) {
        boolean assertionsEnabled;
        int i;
        n.f(realConnection, "connection");
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(realConnection)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(realConnection);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        i = this.connection == null ? 1 : 0;
        if (i == 0) {
        } else {
            this.connection = realConnection;
            RealCall.CallReference callReference = new RealCall.CallReference(this, this.callStackTrace);
            realConnection.getCalls().add(callReference);
        }
        IllegalStateException obj5 = new IllegalStateException("Check failed.".toString());
        throw obj5;
    }

    @Override // okhttp3.Call
    public void cancel() {
        if (this.canceled) {
        }
        this.canceled = true;
        okhttp3.internal.connection.Exchange exchange = this.exchange;
        if (exchange != null) {
            exchange.cancel();
        }
        okhttp3.internal.connection.RealConnection connectionToCancel = this.connectionToCancel;
        if (connectionToCancel != null) {
            connectionToCancel.cancel();
        }
        this.eventListener.canceled(this);
    }

    @Override // okhttp3.Call
    public Object clone() {
        return clone();
    }

    @Override // okhttp3.Call
    public Call clone() {
        return clone();
    }

    @Override // okhttp3.Call
    public okhttp3.internal.connection.RealCall clone() {
        RealCall realCall = new RealCall(this.client, this.originalRequest, this.forWebSocket);
        return realCall;
    }

    @Override // okhttp3.Call
    public void enqueue(Callback callback) {
        n.f(callback, "responseCallback");
        if (!this.executed.compareAndSet(false, true)) {
        } else {
            callStart();
            RealCall.AsyncCall asyncCall = new RealCall.AsyncCall(this, callback);
            this.client.dispatcher().enqueue$okhttp(asyncCall);
        }
        IllegalStateException obj4 = new IllegalStateException("Already Executed".toString());
        throw obj4;
    }

    @Override // okhttp3.Call
    public final void enterNetworkInterceptorExchange(Request request, boolean z2) {
        int i;
        Object connectionPool;
        int eventListener;
        Object obj3;
        okhttp3.internal.connection.ExchangeFinder obj4;
        n.f(request, "request");
        eventListener = 1;
        i = this.interceptorScopedExchange == null ? eventListener : 0;
        if (i == 0) {
        } else {
            synchronized (this) {
                if (requestBodyOpen ^= eventListener == null) {
                } else {
                    connectionPool = w.a;
                    if (z2 != null) {
                    }
                }
                obj4 = new IllegalStateException("Check failed.".toString());
                throw obj4;
            }
            obj4 = new ExchangeFinder(this.connectionPool, createAddress(request.url()), this, this.eventListener);
            this.exchangeFinder = obj4;
        }
        obj4 = new IllegalStateException("Check failed.".toString());
        throw obj4;
    }

    @Override // okhttp3.Call
    public Response execute() {
        if (!this.executed.compareAndSet(false, true)) {
        } else {
            this.timeout.enter();
            callStart();
            this.client.dispatcher().executed$okhttp(this);
            this.client.dispatcher().finished$okhttp(this);
            return getResponseWithInterceptorChain$okhttp();
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already Executed".toString());
        throw illegalStateException;
    }

    @Override // okhttp3.Call
    public final void exitNetworkInterceptorExchange$okhttp(boolean z) {
        Object obj2;
        synchronized (this) {
            try {
                w wVar = w.a;
                obj2 = this.exchange;
                if (z != null && obj2 != null) {
                }
                obj2 = this.exchange;
                if (obj2 != null) {
                }
                obj2.detachWithViolence();
                this.interceptorScopedExchange = 0;
                IllegalStateException illegalStateException = new IllegalStateException("released".toString());
                throw illegalStateException;
                throw z;
            }
        }
    }

    @Override // okhttp3.Call
    public final OkHttpClient getClient() {
        return this.client;
    }

    @Override // okhttp3.Call
    public final okhttp3.internal.connection.RealConnection getConnection() {
        return this.connection;
    }

    @Override // okhttp3.Call
    public final okhttp3.internal.connection.RealConnection getConnectionToCancel() {
        return this.connectionToCancel;
    }

    @Override // okhttp3.Call
    public final EventListener getEventListener$okhttp() {
        return this.eventListener;
    }

    @Override // okhttp3.Call
    public final boolean getForWebSocket() {
        return this.forWebSocket;
    }

    @Override // okhttp3.Call
    public final okhttp3.internal.connection.Exchange getInterceptorScopedExchange$okhttp() {
        return this.interceptorScopedExchange;
    }

    @Override // okhttp3.Call
    public final Request getOriginalRequest() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public final Response getResponseWithInterceptorChain$okhttp() {
        boolean networkInterceptors;
        Throwable th2;
        Throwable th;
        ArrayList arrayList = new ArrayList();
        p.y(arrayList, this.client.interceptors());
        RetryAndFollowUpInterceptor retryAndFollowUpInterceptor = new RetryAndFollowUpInterceptor(this.client);
        arrayList.add(retryAndFollowUpInterceptor);
        BridgeInterceptor bridgeInterceptor = new BridgeInterceptor(this.client.cookieJar());
        arrayList.add(bridgeInterceptor);
        CacheInterceptor cacheInterceptor = new CacheInterceptor(this.client.cache());
        arrayList.add(cacheInterceptor);
        arrayList.add(ConnectInterceptor.INSTANCE);
        if (!this.forWebSocket) {
            p.y(arrayList, this.client.networkInterceptors());
        }
        CallServerInterceptor callServerInterceptor = new CallServerInterceptor(this.forWebSocket);
        arrayList.add(callServerInterceptor);
        super(this, arrayList, 0, 0, this.originalRequest, this.client.connectTimeoutMillis(), this.client.readTimeoutMillis(), this.client.writeTimeoutMillis());
        int i = 0;
        Response proceed = realInterceptorChain2.proceed(this.originalRequest);
        if (isCanceled()) {
        } else {
            noMoreExchanges$okhttp(0);
            return proceed;
        }
        Util.closeQuietly(proceed);
        IOException iOException = new IOException("Canceled");
        throw iOException;
    }

    @Override // okhttp3.Call
    public final okhttp3.internal.connection.Exchange initExchange$okhttp(RealInterceptorChain realInterceptorChain) {
        n.f(realInterceptorChain, "chain");
        synchronized (this) {
            final int i3 = 1;
            if (responseBodyOpen ^= i3 == 0) {
            } else {
                if (requestBodyOpen ^= i3 == 0) {
                } else {
                    w wVar = w.a;
                    okhttp3.internal.connection.ExchangeFinder exchangeFinder = this.exchangeFinder;
                    n.d(exchangeFinder);
                    Exchange exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, realInterceptorChain));
                    this.interceptorScopedExchange = exchange;
                    this.exchange = exchange;
                    this.requestBodyOpen = i3;
                    this.responseBodyOpen = i3;
                    synchronized (this) {
                        wVar = w.a;
                        exchangeFinder = this.exchangeFinder;
                        n.d(exchangeFinder);
                        exchange = new Exchange(this, this.eventListener, exchangeFinder, exchangeFinder.find(this.client, realInterceptorChain));
                        this.interceptorScopedExchange = exchange;
                        this.exchange = exchange;
                        this.requestBodyOpen = i3;
                        this.responseBodyOpen = i3;
                    }
                }
                IllegalStateException illegalStateException2 = new IllegalStateException("Check failed.".toString());
                throw illegalStateException2;
            }
            IllegalStateException illegalStateException3 = new IllegalStateException("Check failed.".toString());
            throw illegalStateException3;
        }
        return exchange;
    }

    @Override // okhttp3.Call
    public boolean isCanceled() {
        return this.canceled;
    }

    @Override // okhttp3.Call
    public boolean isExecuted() {
        return this.executed.get();
    }

    public final <E extends IOException> E messageDone$okhttp(okhttp3.internal.connection.Exchange exchange, boolean z2, boolean z3, E e4) {
        int i;
        boolean responseBodyOpen;
        int obj3;
        boolean obj4;
        int obj5;
        n.f(exchange, "exchange");
        i = 1;
        if (obj3 ^= i != 0) {
            return e4;
        }
        obj3 = 0;
        synchronized (this) {
            if (!this.requestBodyOpen) {
                if (z3 && this.responseBodyOpen) {
                    if (this.responseBodyOpen) {
                        if (z2) {
                            this.requestBodyOpen = obj3;
                        }
                        if (z3) {
                            this.responseBodyOpen = obj3;
                        }
                        obj4 = this.requestBodyOpen;
                        if (obj4 == null && !this.responseBodyOpen) {
                            obj5 = !this.responseBodyOpen ? i : obj3;
                        } else {
                        }
                        if (obj4 == null && !this.responseBodyOpen && !this.expectMoreExchanges) {
                            if (!this.responseBodyOpen) {
                                if (!this.expectMoreExchanges) {
                                } else {
                                    try {
                                        i = obj3;
                                        obj3 = obj5;
                                        i = obj3;
                                        obj4 = w.a;
                                        this.exchange = 0;
                                        obj3 = this.connection;
                                        if (obj3 != null && obj3 != null) {
                                        }
                                        this.exchange = 0;
                                        obj3 = this.connection;
                                        if (obj3 != null) {
                                        }
                                        obj3.incrementSuccessCount$okhttp();
                                        if (i != 0) {
                                        }
                                        return callDone(e4);
                                        return e4;
                                        throw exchange;
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    @Override // okhttp3.Call
    public final IOException noMoreExchanges$okhttp(IOException iOException) {
        boolean expectMoreExchanges;
        int i;
        IOException obj3;
        synchronized (this) {
            try {
                this.expectMoreExchanges = false;
                if (!this.requestBodyOpen) {
                }
                if (!this.responseBodyOpen) {
                }
                i = expectMoreExchanges;
                w wVar = w.a;
                if (i != 0) {
                }
                obj3 = callDone(iOException);
                return obj3;
                throw iOException;
            }
        }
    }

    @Override // okhttp3.Call
    public final String redactedUrl$okhttp() {
        return this.originalRequest.url().redact();
    }

    @Override // okhttp3.Call
    public final Socket releaseConnectionNoEvents$okhttp() {
        boolean assertionsEnabled;
        boolean connectionBecameIdle;
        int nanoTime;
        int i;
        boolean next;
        int i2;
        okhttp3.internal.connection.RealConnection connection = this.connection;
        n.d(connection);
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(connection)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(connection);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        List calls = connection.getCalls();
        Iterator iterator = calls.iterator();
        i = nanoTime;
        i2 = -1;
        for (Reference next2 : iterator) {
            i++;
            i2 = -1;
        }
        i = i2;
        if (i != i2) {
            nanoTime = 1;
        }
        if (nanoTime == 0) {
        } else {
            calls.remove(i);
            int i3 = 0;
            this.connection = i3;
            connection.setIdleAtNs$okhttp(System.nanoTime());
            if (calls.isEmpty() && this.connectionPool.connectionBecameIdle(connection)) {
                connection.setIdleAtNs$okhttp(System.nanoTime());
                if (this.connectionPool.connectionBecameIdle(connection)) {
                    return connection.socket();
                }
            }
            return i3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }

    @Override // okhttp3.Call
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.Call
    public final boolean retryAfterFailure() {
        okhttp3.internal.connection.ExchangeFinder exchangeFinder = this.exchangeFinder;
        n.d(exchangeFinder);
        return exchangeFinder.retryAfterFailure();
    }

    @Override // okhttp3.Call
    public final void setConnectionToCancel(okhttp3.internal.connection.RealConnection realConnection) {
        this.connectionToCancel = realConnection;
    }

    @Override // okhttp3.Call
    public d timeout() {
        return this.timeout;
    }

    @Override // okhttp3.Call
    public e0 timeout() {
        return timeout();
    }

    @Override // okhttp3.Call
    public final void timeoutEarlyExit() {
        int i2 = 1;
        if (timeoutEarlyExit ^= i2 == 0) {
        } else {
            this.timeoutEarlyExit = i2;
            this.timeout.exit();
        }
        IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
        throw illegalStateException;
    }
}
