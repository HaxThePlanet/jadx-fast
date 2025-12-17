package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0008&\u0018\u0000 M2\u00020\u0001:\u0002MNB\u0007¢\u0006\u0004\u0008K\u0010LJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\t\u0010\nJ-\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u00072\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0012\u0010\u0013J-\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u000bH\u0016¢\u0006\u0004\u0008\u0016\u0010\u0017J'\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u001d\u0010\u0006J!\u0010 \u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\u0008 \u0010!J1\u0010$\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000c2\u0008\u0010#\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\u0008$\u0010%J9\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000c2\u0008\u0010#\u001a\u0004\u0018\u00010\"2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\u0008(\u0010)J\u001f\u0010,\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\u0008,\u0010-J\u001f\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\u0008.\u0010-J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008/\u0010\u0006J\u001f\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u000200H\u0016¢\u0006\u0004\u00082\u00103J\u0017\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u00084\u0010\u0006J\u001f\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\u00087\u00108J\u001f\u00109\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\u00089\u0010:J\u0017\u0010;\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008;\u0010\u0006J\u001f\u0010>\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\u0008>\u0010?J\u0017\u0010@\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008@\u0010\u0006J\u001f\u0010A\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\u0008A\u00108J\u001f\u0010B\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\u0008B\u0010:J\u0017\u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008C\u0010\u0006J\u001f\u0010D\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\u0008D\u0010:J\u0017\u0010E\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008E\u0010\u0006J\u001f\u0010F\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\u0008F\u0010?J\u001f\u0010G\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\u0008G\u0010?J\u0017\u0010H\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008H\u0010\u0006J\u001f\u0010J\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010I\u001a\u00020<H\u0016¢\u0006\u0004\u0008J\u0010?¨\u0006O", d2 = {"Lokhttp3/EventListener;", "", "Lokhttp3/Call;", "call", "Lkotlin/w;", "callStart", "(Lokhttp3/Call;)V", "Lokhttp3/HttpUrl;", "url", "proxySelectStart", "(Lokhttp3/Call;Lokhttp3/HttpUrl;)V", "", "Ljava/net/Proxy;", "proxies", "proxySelectEnd", "(Lokhttp3/Call;Lokhttp3/HttpUrl;Ljava/util/List;)V", "", "domainName", "dnsStart", "(Lokhttp3/Call;Ljava/lang/String;)V", "Ljava/net/InetAddress;", "inetAddressList", "dnsEnd", "(Lokhttp3/Call;Ljava/lang/String;Ljava/util/List;)V", "Ljava/net/InetSocketAddress;", "inetSocketAddress", "proxy", "connectStart", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;)V", "secureConnectStart", "Lokhttp3/Handshake;", "handshake", "secureConnectEnd", "(Lokhttp3/Call;Lokhttp3/Handshake;)V", "Lokhttp3/Protocol;", "protocol", "connectEnd", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;)V", "Ljava/io/IOException;", "ioe", "connectFailed", "(Lokhttp3/Call;Ljava/net/InetSocketAddress;Ljava/net/Proxy;Lokhttp3/Protocol;Ljava/io/IOException;)V", "Lokhttp3/Connection;", "connection", "connectionAcquired", "(Lokhttp3/Call;Lokhttp3/Connection;)V", "connectionReleased", "requestHeadersStart", "Lokhttp3/Request;", "request", "requestHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Request;)V", "requestBodyStart", "", "byteCount", "requestBodyEnd", "(Lokhttp3/Call;J)V", "requestFailed", "(Lokhttp3/Call;Ljava/io/IOException;)V", "responseHeadersStart", "Lokhttp3/Response;", "response", "responseHeadersEnd", "(Lokhttp3/Call;Lokhttp3/Response;)V", "responseBodyStart", "responseBodyEnd", "responseFailed", "callEnd", "callFailed", "canceled", "satisfactionFailure", "cacheHit", "cacheMiss", "cachedResponse", "cacheConditionalHit", "<init>", "()V", "Companion", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class EventListener {

    public static final okhttp3.EventListener.Companion Companion;
    public static final okhttp3.EventListener NONE;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/EventListener$Companion;", "", "Lokhttp3/EventListener;", "NONE", "Lokhttp3/EventListener;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lokhttp3/EventListener$Factory;", "", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "create", "(Lokhttp3/Call;)Lokhttp3/EventListener;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Factory {
        public abstract okhttp3.EventListener create(okhttp3.Call call);
    }
    static {
        EventListener.Companion companion = new EventListener.Companion(0);
        EventListener.Companion = companion;
        EventListener.Companion.NONE.1 anon = new EventListener.Companion.NONE.1();
        EventListener.NONE = anon;
    }

    public void cacheConditionalHit(okhttp3.Call call, okhttp3.Response response2) {
        n.f(call, "call");
        n.f(response2, "cachedResponse");
    }

    public void cacheHit(okhttp3.Call call, okhttp3.Response response2) {
        n.f(call, "call");
        n.f(response2, "response");
    }

    public void cacheMiss(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void callEnd(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void callFailed(okhttp3.Call call, IOException iOException2) {
        n.f(call, "call");
        n.f(iOException2, "ioe");
    }

    public void callStart(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void canceled(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void connectEnd(okhttp3.Call call, InetSocketAddress inetSocketAddress2, Proxy proxy3, okhttp3.Protocol protocol4) {
        n.f(call, "call");
        n.f(inetSocketAddress2, "inetSocketAddress");
        n.f(proxy3, "proxy");
    }

    public void connectFailed(okhttp3.Call call, InetSocketAddress inetSocketAddress2, Proxy proxy3, okhttp3.Protocol protocol4, IOException iOException5) {
        n.f(call, "call");
        n.f(inetSocketAddress2, "inetSocketAddress");
        n.f(proxy3, "proxy");
        n.f(iOException5, "ioe");
    }

    public void connectStart(okhttp3.Call call, InetSocketAddress inetSocketAddress2, Proxy proxy3) {
        n.f(call, "call");
        n.f(inetSocketAddress2, "inetSocketAddress");
        n.f(proxy3, "proxy");
    }

    public void connectionAcquired(okhttp3.Call call, okhttp3.Connection connection2) {
        n.f(call, "call");
        n.f(connection2, "connection");
    }

    public void connectionReleased(okhttp3.Call call, okhttp3.Connection connection2) {
        n.f(call, "call");
        n.f(connection2, "connection");
    }

    public void dnsEnd(okhttp3.Call call, String string2, List<InetAddress> list3) {
        n.f(call, "call");
        n.f(string2, "domainName");
        n.f(list3, "inetAddressList");
    }

    public void dnsStart(okhttp3.Call call, String string2) {
        n.f(call, "call");
        n.f(string2, "domainName");
    }

    public void proxySelectEnd(okhttp3.Call call, okhttp3.HttpUrl httpUrl2, List<Proxy> list3) {
        n.f(call, "call");
        n.f(httpUrl2, "url");
        n.f(list3, "proxies");
    }

    public void proxySelectStart(okhttp3.Call call, okhttp3.HttpUrl httpUrl2) {
        n.f(call, "call");
        n.f(httpUrl2, "url");
    }

    public void requestBodyEnd(okhttp3.Call call, long l2) {
        n.f(call, "call");
    }

    public void requestBodyStart(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void requestFailed(okhttp3.Call call, IOException iOException2) {
        n.f(call, "call");
        n.f(iOException2, "ioe");
    }

    public void requestHeadersEnd(okhttp3.Call call, okhttp3.Request request2) {
        n.f(call, "call");
        n.f(request2, "request");
    }

    public void requestHeadersStart(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void responseBodyEnd(okhttp3.Call call, long l2) {
        n.f(call, "call");
    }

    public void responseBodyStart(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void responseFailed(okhttp3.Call call, IOException iOException2) {
        n.f(call, "call");
        n.f(iOException2, "ioe");
    }

    public void responseHeadersEnd(okhttp3.Call call, okhttp3.Response response2) {
        n.f(call, "call");
        n.f(response2, "response");
    }

    public void responseHeadersStart(okhttp3.Call call) {
        n.f(call, "call");
    }

    public void satisfactionFailure(okhttp3.Call call, okhttp3.Response response2) {
        n.f(call, "call");
        n.f(response2, "response");
    }

    public void secureConnectEnd(okhttp3.Call call, okhttp3.Handshake handshake2) {
        n.f(call, "call");
    }

    public void secureConnectStart(okhttp3.Call call) {
        n.f(call, "call");
    }
}
