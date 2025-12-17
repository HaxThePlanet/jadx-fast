package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001:\u0001UB\u0011\u0008\u0002\u0012\u0006\u0010O\u001a\u00020N¢\u0006\u0004\u0008S\u0010TJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ-\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J-\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00022\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u000fH\u0016¢\u0006\u0004\u0008\u0019\u0010\u001aJ'\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008 \u0010\nJ!\u0010#\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0008\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\u0008#\u0010$J1\u0010'\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00102\u0008\u0010&\u001a\u0004\u0018\u00010%H\u0016¢\u0006\u0004\u0008'\u0010(J9\u0010+\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00102\u0008\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\u0008+\u0010,J\u001f\u0010/\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\u0008/\u00100J\u001f\u00101\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\u00081\u00100J\u0017\u00102\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u00082\u0010\nJ\u001f\u00105\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u00104\u001a\u000203H\u0016¢\u0006\u0004\u00085\u00106J\u0017\u00107\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u00087\u0010\nJ\u001f\u0010:\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\u0008:\u0010;J\u001f\u0010<\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\u0008<\u0010=J\u0017\u0010>\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008>\u0010\nJ\u001f\u0010A\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\u0008A\u0010BJ\u0017\u0010C\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008C\u0010\nJ\u001f\u0010D\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u00109\u001a\u000208H\u0016¢\u0006\u0004\u0008D\u0010;J\u001f\u0010E\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\u0008E\u0010=J\u0017\u0010F\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008F\u0010\nJ\u001f\u0010G\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\u0008G\u0010=J\u0017\u0010H\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008H\u0010\nJ\u001f\u0010I\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\u0008I\u0010BJ\u001f\u0010J\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\u0008J\u0010BJ\u0017\u0010K\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008K\u0010\nJ\u001f\u0010M\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010L\u001a\u00020?H\u0016¢\u0006\u0004\u0008M\u0010BR\u0016\u0010O\u001a\u00020N8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008O\u0010PR\u0016\u0010Q\u001a\u0002088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008Q\u0010R¨\u0006V", d2 = {"Lokhttp3/logging/LoggingEventListener;", "Lokhttp3/EventListener;", "", "message", "Lkotlin/w;", "logWithTime", "(Ljava/lang/String;)V", "Lokhttp3/Call;", "call", "callStart", "(Lokhttp3/Call;)V", "Lokhttp3/HttpUrl;", "url", "proxySelectStart", "(Lokhttp3/Call;Lokhttp3/HttpUrl;)V", "", "Ljava/net/Proxy;", "proxies", "proxySelectEnd", "(Lokhttp3/Call;Lokhttp3/HttpUrl;Ljava/util/List;)V", "domainName", "dnsStart", "(Lokhttp3/Call;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "(Lokhttp3/Call;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "connectStart", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "(Lokhttp3/Call;Lokhttp3/Handshake;)V", "Lokhttp3/Protocol;", "protocol", "connectEnd", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", "connectFailed", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Lokhttp3/Connection;", "connection", "connectionAcquired", "(Lokhttp3/Call;Lokhttp3/Connection;)V", "connectionReleased", "requestHeadersStart", "Lokhttp3/Request;", "request", "requestHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Request;)V", "requestBodyStart", "", "byteCount", "requestBodyEnd", "(Lokhttp3/Call;J)V", "requestFailed", "(Lokhttp3/Call;Ljava/io/IOException;)V", "responseHeadersStart", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Response;)V", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "startNs", "J", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Factory", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
public final class LoggingEventListener extends EventListener {

    private final okhttp3.logging.HttpLoggingInterceptor.Logger logger;
    private long startNs;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0016\u0018\u00002\u00020\u0001B\u0013\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0008\u001a\u00020\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lokhttp3/logging/LoggingEventListener$Factory;", "Lokhttp3/EventListener$Factory;", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "create", "(Lokhttp3/Call;)Lokhttp3/EventListener;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "okhttp-logging-interceptor"}, k = 1, mv = {1, 4, 0})
    public static class Factory implements EventListener.Factory {

        private final okhttp3.logging.HttpLoggingInterceptor.Logger logger;
        public Factory() {
            final int i = 0;
            super(i, 1, i);
        }

        public Factory(okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptor$Logger) {
            n.f(logger, "logger");
            super();
            this.logger = logger;
        }

        public Factory(okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptor$Logger, int i2, g g3) {
            okhttp3.logging.HttpLoggingInterceptor.Logger obj1;
            obj1 = i2 &= 1 != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : obj1;
            super(obj1);
        }

        @Override // okhttp3.EventListener$Factory
        public EventListener create(Call call) {
            n.f(call, "call");
            LoggingEventListener obj3 = new LoggingEventListener(this.logger, 0);
            return obj3;
        }
    }
    private LoggingEventListener(okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptor$Logger) {
        super();
        this.logger = logger;
    }

    public LoggingEventListener(okhttp3.logging.HttpLoggingInterceptor.Logger httpLoggingInterceptor$Logger, g g2) {
        super(logger);
    }

    private final void logWithTime(String string) {
        nanoTime -= startNs;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(TimeUnit.NANOSECONDS.toMillis(i));
        stringBuilder.append(" ms] ");
        stringBuilder.append(string);
        this.logger.log(stringBuilder.toString());
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response response2) {
        n.f(call, "call");
        n.f(response2, "cachedResponse");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("cacheConditionalHit: ");
        obj2.append(response2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response2) {
        n.f(call, "call");
        n.f(response2, "response");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("cacheHit: ");
        obj2.append(response2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        n.f(call, "call");
        logWithTime("cacheMiss");
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        n.f(call, "call");
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException iOException2) {
        n.f(call, "call");
        n.f(iOException2, "ioe");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("callFailed: ");
        obj2.append(iOException2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        n.f(call, "call");
        this.startNs = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("callStart: ");
        stringBuilder.append(call.request());
        logWithTime(stringBuilder.toString());
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        n.f(call, "call");
        logWithTime("canceled");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress2, Proxy proxy3, Protocol protocol4) {
        n.f(call, "call");
        n.f(inetSocketAddress2, "inetSocketAddress");
        n.f(proxy3, "proxy");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("connectEnd: ");
        obj2.append(protocol4);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress2, Proxy proxy3, Protocol protocol4, IOException iOException5) {
        n.f(call, "call");
        n.f(inetSocketAddress2, "inetSocketAddress");
        n.f(proxy3, "proxy");
        n.f(iOException5, "ioe");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("connectFailed: ");
        obj2.append(protocol4);
        obj2.append(' ');
        obj2.append(iOException5);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress2, Proxy proxy3) {
        n.f(call, "call");
        n.f(inetSocketAddress2, "inetSocketAddress");
        n.f(proxy3, "proxy");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("connectStart: ");
        obj2.append(inetSocketAddress2);
        obj2.append(' ');
        obj2.append(proxy3);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection2) {
        n.f(call, "call");
        n.f(connection2, "connection");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("connectionAcquired: ");
        obj2.append(connection2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection2) {
        n.f(call, "call");
        n.f(connection2, "connection");
        logWithTime("connectionReleased");
    }

    public void dnsEnd(Call call, String string2, List<? extends InetAddress> list3) {
        n.f(call, "call");
        n.f(string2, "domainName");
        n.f(list3, "inetAddressList");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("dnsEnd: ");
        obj2.append(list3);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String string2) {
        n.f(call, "call");
        n.f(string2, "domainName");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("dnsStart: ");
        obj2.append(string2);
        logWithTime(obj2.toString());
    }

    public void proxySelectEnd(Call call, HttpUrl httpUrl2, List<? extends Proxy> list3) {
        n.f(call, "call");
        n.f(httpUrl2, "url");
        n.f(list3, "proxies");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("proxySelectEnd: ");
        obj2.append(list3);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl httpUrl2) {
        n.f(call, "call");
        n.f(httpUrl2, "url");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("proxySelectStart: ");
        obj2.append(httpUrl2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long l2) {
        n.f(call, "call");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("requestBodyEnd: byteCount=");
        obj2.append(l2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        n.f(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException iOException2) {
        n.f(call, "call");
        n.f(iOException2, "ioe");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("requestFailed: ");
        obj2.append(iOException2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request2) {
        n.f(call, "call");
        n.f(request2, "request");
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        n.f(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long l2) {
        n.f(call, "call");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("responseBodyEnd: byteCount=");
        obj2.append(l2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        n.f(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException iOException2) {
        n.f(call, "call");
        n.f(iOException2, "ioe");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("responseFailed: ");
        obj2.append(iOException2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response2) {
        n.f(call, "call");
        n.f(response2, "response");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("responseHeadersEnd: ");
        obj2.append(response2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        n.f(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response2) {
        n.f(call, "call");
        n.f(response2, "response");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("satisfactionFailure: ");
        obj2.append(response2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake2) {
        n.f(call, "call");
        StringBuilder obj2 = new StringBuilder();
        obj2.append("secureConnectEnd: ");
        obj2.append(handshake2);
        logWithTime(obj2.toString());
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        n.f(call, "call");
        logWithTime("secureConnectStart");
    }
}
