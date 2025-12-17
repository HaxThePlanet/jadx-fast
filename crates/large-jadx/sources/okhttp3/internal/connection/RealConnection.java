package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.UnknownServiceException;
import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import l.b0;
import l.d0;
import l.e0;
import l.f;
import l.g;
import l.h;
import l.q;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CertificatePinner.Companion;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Handshake.Companion;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Protocol.Companion;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Connection.Builder;
import okhttp3.internal.http2.Http2Connection.Companion;
import okhttp3.internal.http2.Http2Connection.Listener;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket.Streams;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000e\u0018\u0000  \u00012\u00020\u00012\u00020\u0002:\u0002 \u0001B\u001b\u0012\u0008\u0010\u0094\u0001\u001a\u00030\u0093\u0001\u0012\u0006\u0010K\u001a\u00020\"¢\u0006\u0006\u0008\u009e\u0001\u0010\u009f\u0001J7\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ/\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ/\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\u0008\u0017\u0010\u0018J1\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0019H\u0002¢\u0006\u0004\u0008\u001f\u0010 J\u001d\u0010%\u001a\u00020$2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\"0!H\u0002¢\u0006\u0004\u0008%\u0010&J\u0017\u0010'\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\u0008'\u0010(J\u001f\u0010+\u001a\u00020$2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\u0008+\u0010,J\u000f\u0010/\u001a\u00020\u000bH\u0000¢\u0006\u0004\u0008-\u0010.J\u000f\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0004\u00080\u0010.J\u000f\u00103\u001a\u00020\u000bH\u0000¢\u0006\u0004\u00082\u0010.JE\u00105\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u00104\u001a\u00020$2\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u00085\u00106J'\u0010<\u001a\u00020$2\u0006\u00108\u001a\u0002072\u000e\u00109\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!H\u0000¢\u0006\u0004\u0008:\u0010;J\u001f\u0010D\u001a\u00020A2\u0006\u0010>\u001a\u00020=2\u0006\u0010@\u001a\u00020?H\u0000¢\u0006\u0004\u0008B\u0010CJ\u0017\u0010J\u001a\u00020G2\u0006\u0010F\u001a\u00020EH\u0000¢\u0006\u0004\u0008H\u0010IJ\u000f\u0010K\u001a\u00020\"H\u0016¢\u0006\u0004\u0008K\u0010LJ\r\u0010M\u001a\u00020\u000b¢\u0006\u0004\u0008M\u0010.J\u000f\u0010O\u001a\u00020NH\u0016¢\u0006\u0004\u0008O\u0010PJ\u0015\u0010R\u001a\u00020$2\u0006\u0010Q\u001a\u00020$¢\u0006\u0004\u0008R\u0010SJ\u0017\u0010V\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020TH\u0016¢\u0006\u0004\u0008V\u0010WJ\u001f\u0010\\\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020X2\u0006\u0010[\u001a\u00020ZH\u0016¢\u0006\u0004\u0008\\\u0010]J\u0011\u0010*\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\u0008*\u0010^J'\u0010d\u001a\u00020\u000b2\u0006\u0010>\u001a\u00020=2\u0006\u0010_\u001a\u00020\"2\u0006\u0010a\u001a\u00020`H\u0000¢\u0006\u0004\u0008b\u0010cJ!\u0010i\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020e2\u0008\u0010f\u001a\u0004\u0018\u00010`H\u0000¢\u0006\u0004\u0008g\u0010hJ\u000f\u0010k\u001a\u00020jH\u0016¢\u0006\u0004\u0008k\u0010lJ\u000f\u0010n\u001a\u00020mH\u0016¢\u0006\u0004\u0008n\u0010oR\u0016\u0010K\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008K\u0010pR\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008*\u0010qR\u0018\u0010s\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008s\u0010tR\u0018\u0010k\u001a\u0004\u0018\u00010j8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008k\u0010uR\u0018\u0010v\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008v\u0010wR\u0016\u00101\u001a\u00020$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00081\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008z\u0010{R\u0016\u0010|\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008|\u0010}R$\u0010/\u001a\u00020$8\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\u0008/\u0010x\u001a\u0004\u0008~\u0010\u007f\"\u0006\u0008\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0082\u0001\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0008\n\u0006\u0008\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008\u0084\u0001\u0010}R\u0018\u0010O\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008O\u0010wR,\u0010\u0087\u0001\u001a\u0010\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020e0\u0086\u00010\u0085\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\u0008\u0087\u0001\u0010\u0088\u0001\u001a\u0006\u0008\u0089\u0001\u0010\u008a\u0001R*\u0010\u008c\u0001\u001a\u00030\u008b\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\u0008\u008c\u0001\u0010\u008d\u0001\u001a\u0006\u0008\u008e\u0001\u0010\u008f\u0001\"\u0006\u0008\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0092\u0001\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008\u0092\u0001\u0010}R\u001f\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\u0008\u0094\u0001\u0010\u0095\u0001\u001a\u0006\u0008\u0096\u0001\u0010\u0097\u0001R'\u0010\u0098\u0001\u001a\u00020\u00038\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\u0008\u0098\u0001\u0010}\u001a\u0006\u0008\u0099\u0001\u0010\u009a\u0001\"\u0005\u0008\u009b\u0001\u0010\u0016R\u0018\u0010\u009d\u0001\u001a\u00020$8@@\u0000X\u0080\u0004¢\u0006\u0007\u001a\u0005\u0008\u009c\u0001\u0010\u007f¨\u0006¡\u0001", d2 = {"Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "Lokhttp3/Connection;", "", "connectTimeout", "readTimeout", "writeTimeout", "Lokhttp3/Call;", "call", "Lokhttp3/EventListener;", "eventListener", "Lkotlin/w;", "connectTunnel", "(IIILokhttp3/Call;Lokhttp3/EventListener;)V", "connectSocket", "(IILokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/internal/connection/ConnectionSpecSelector;", "connectionSpecSelector", "pingIntervalMillis", "establishProtocol", "(Lokhttp3/internal/connection/ConnectionSpecSelector;ILokhttp3/Call;Lokhttp3/EventListener;)V", "startHttp2", "(I)V", "connectTls", "(Lokhttp3/internal/connection/ConnectionSpecSelector;)V", "Lokhttp3/Request;", "tunnelRequest", "Lokhttp3/HttpUrl;", "url", "createTunnel", "(IILokhttp3/Request;Lokhttp3/HttpUrl;)Lokhttp3/Request;", "createTunnelRequest", "()Lokhttp3/Request;", "", "Lokhttp3/Route;", "candidates", "", "routeMatchesAny", "(Ljava/util/List;)Z", "supportsUrl", "(Lokhttp3/HttpUrl;)Z", "Lokhttp3/Handshake;", "handshake", "certificateSupportHost", "(Lokhttp3/HttpUrl;Lokhttp3/Handshake;)Z", "noNewExchanges$okhttp", "()V", "noNewExchanges", "noCoalescedConnections$okhttp", "noCoalescedConnections", "incrementSuccessCount$okhttp", "incrementSuccessCount", "connectionRetryEnabled", "connect", "(IIIIZLokhttp3/Call;Lokhttp3/EventListener;)V", "Lokhttp3/Address;", "address", "routes", "isEligible$okhttp", "(Lokhttp3/Address;Ljava/util/List;)Z", "isEligible", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "newCodec$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "newCodec", "Lokhttp3/internal/connection/Exchange;", "exchange", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams$okhttp", "(Lokhttp3/internal/connection/Exchange;)Lokhttp3/internal/ws/RealWebSocket$Streams;", "newWebSocketStreams", "route", "()Lokhttp3/Route;", "cancel", "Ljava/net/Socket;", "socket", "()Ljava/net/Socket;", "doExtensiveChecks", "isHealthy", "(Z)Z", "Lokhttp3/internal/http2/Http2Stream;", "stream", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "()Lokhttp3/Handshake;", "failedRoute", "Ljava/io/IOException;", "failure", "connectFailed$okhttp", "(Lokhttp3/OkHttpClient;Lokhttp3/Route;Ljava/io/IOException;)V", "connectFailed", "Lokhttp3/internal/connection/RealCall;", "e", "trackFailure$okhttp", "(Lokhttp3/internal/connection/RealCall;Ljava/io/IOException;)V", "trackFailure", "Lokhttp3/Protocol;", "protocol", "()Lokhttp3/Protocol;", "", "toString", "()Ljava/lang/String;", "Lokhttp3/Route;", "Lokhttp3/Handshake;", "Ll/h;", "source", "Ll/h;", "Lokhttp3/Protocol;", "rawSocket", "Ljava/net/Socket;", "Z", "Ll/g;", "sink", "Ll/g;", "refusedStreamCount", "I", "getNoNewExchanges", "()Z", "setNoNewExchanges", "(Z)V", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "allocationLimit", "", "Ljava/lang/ref/Reference;", "calls", "Ljava/util/List;", "getCalls", "()Ljava/util/List;", "", "idleAtNs", "J", "getIdleAtNs$okhttp", "()J", "setIdleAtNs$okhttp", "(J)V", "successCount", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "getConnectionPool", "()Lokhttp3/internal/connection/RealConnectionPool;", "routeFailureCount", "getRouteFailureCount$okhttp", "()I", "setRouteFailureCount$okhttp", "isMultiplexed$okhttp", "isMultiplexed", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealConnection extends Http2Connection.Listener implements Connection {

    public static final okhttp3.internal.connection.RealConnection.Companion Companion = null;
    public static final long IDLE_CONNECTION_HEALTHY_NS = 10000000000L;
    private static final int MAX_TUNNEL_ATTEMPTS = 21;
    private static final String NPE_THROW_WITH_NULL = "throw with null exception";
    private int allocationLimit = 1;
    private final List<Reference<okhttp3.internal.connection.RealCall>> calls;
    private final okhttp3.internal.connection.RealConnectionPool connectionPool;
    private Handshake handshake;
    private Http2Connection http2Connection;
    private long idleAtNs = Long.MAX_VALUE;
    private boolean noCoalescedConnections;
    private boolean noNewExchanges;
    private Protocol protocol;
    private Socket rawSocket;
    private int refusedStreamCount;
    private final Route route;
    private int routeFailureCount;
    private g sink;
    private Socket socket;
    private h source;
    private int successCount;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\r\u001a\u00020\u00088\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014¨\u0006\u0017", d2 = {"Lokhttp3/internal/connection/RealConnection$Companion;", "", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/Route;", "route", "Ljava/net/Socket;", "socket", "", "idleAtNs", "Lokhttp3/internal/connection/RealConnection;", "newTestConnection", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Route;Ljava/net/Socket;J)Lokhttp3/internal/connection/RealConnection;", "IDLE_CONNECTION_HEALTHY_NS", "J", "", "MAX_TUNNEL_ATTEMPTS", "I", "", "NPE_THROW_WITH_NULL", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.connection.RealConnection newTestConnection(okhttp3.internal.connection.RealConnectionPool realConnectionPool, Route route2, Socket socket3, long l4) {
            n.f(realConnectionPool, "connectionPool");
            n.f(route2, "route");
            n.f(socket3, "socket");
            RealConnection realConnection = new RealConnection(realConnectionPool, route2);
            RealConnection.access$setSocket$p(realConnection, socket3);
            realConnection.setIdleAtNs$okhttp(l4);
            return realConnection;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            RealConnection.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
        }
    }
    static {
        RealConnection.Companion companion = new RealConnection.Companion(0);
        RealConnection.Companion = companion;
    }

    public RealConnection(okhttp3.internal.connection.RealConnectionPool realConnectionPool, Route route2) {
        n.f(realConnectionPool, "connectionPool");
        n.f(route2, "route");
        super();
        this.connectionPool = realConnectionPool;
        this.route = route2;
        int obj2 = 1;
        obj2 = new ArrayList();
        this.calls = obj2;
        obj2 = Long.MAX_VALUE;
    }

    public static final Handshake access$getHandshake$p(okhttp3.internal.connection.RealConnection realConnection) {
        return realConnection.handshake;
    }

    public static final Socket access$getSocket$p(okhttp3.internal.connection.RealConnection realConnection) {
        return realConnection.socket;
    }

    public static final void access$setHandshake$p(okhttp3.internal.connection.RealConnection realConnection, Handshake handshake2) {
        realConnection.handshake = handshake2;
    }

    public static final void access$setSocket$p(okhttp3.internal.connection.RealConnection realConnection, Socket socket2) {
        realConnection.socket = socket2;
    }

    private final boolean certificateSupportHost(HttpUrl httpUrl, Handshake handshake2) {
        int iNSTANCE;
        int i;
        String str;
        boolean obj5;
        Object obj6;
        obj6 = handshake2.peerCertificates();
        final int i2 = 0;
        obj6 = obj6.get(i2);
        Objects.requireNonNull(obj6, "null cannot be cast to non-null type java.security.cert.X509Certificate");
        if (empty ^= i != 0 && OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate)obj6)) {
            obj6 = obj6.get(i2);
            Objects.requireNonNull(obj6, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            if (OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate)obj6)) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    private final void connectSocket(int i, int i2, Call call3, EventListener eventListener4) {
        Socket socket;
        int type;
        int i3;
        g obj5;
        Platform obj6;
        java.net.InetSocketAddress obj7;
        Proxy proxy = this.route.proxy();
        type = proxy.type();
        if (type == null) {
            socket = new Socket(proxy);
        } else {
            type = RealConnection.WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (type != 1 && type != 2) {
                if (type != 2) {
                } else {
                    n.d(this.route.address().socketFactory().createSocket());
                }
            } else {
            }
        }
        this.rawSocket = socket;
        eventListener4.connectStart(call3, this.route.socketAddress(), proxy);
        socket.setSoTimeout(i2);
        Platform.Companion.get().connectSocket(socket, this.route.socketAddress(), i);
        this.source = q.d(q.m(socket));
        this.sink = q.c(q.i(socket));
    }

    private final void connectTls(okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector) {
        SSLSocket socket;
        int selectedProtocol;
        boolean supportsTlsExtensions;
        String host;
        int protocols;
        boolean obj11;
        Address address = this.route.address();
        SSLSocketFactory sslSocketFactory = address.sslSocketFactory();
        selectedProtocol = 0;
        n.d(sslSocketFactory);
        int i3 = 1;
        Socket socket2 = sslSocketFactory.createSocket(this.rawSocket, address.url().host(), address.url().port(), i3);
        if (socket2 == null) {
        } else {
            obj11 = connectionSpecSelector.configureSecureSocket((SSLSocket)socket2);
            if (obj11.supportsTlsExtensions()) {
                Platform.Companion.get().configureTlsExtensions(socket2, address.url().host(), address.protocols());
            }
            socket2.startHandshake();
            javax.net.ssl.SSLSession session = socket2.getSession();
            n.e(session, "sslSocketSession");
            Handshake handshake = Handshake.Companion.get(session);
            HostnameVerifier hostnameVerifier = address.hostnameVerifier();
            n.d(hostnameVerifier);
            if (!hostnameVerifier.verify(address.url().host(), session)) {
                obj11 = handshake.peerCertificates();
                if (empty ^= i3 == 0) {
                } else {
                    obj11 = obj11.get(0);
                    if (obj11 == null) {
                        obj11 = new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                        throw obj11;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("\n              |Hostname ");
                    stringBuilder2.append(address.url().host());
                    stringBuilder2.append(" not verified:\n              |    certificate: ");
                    stringBuilder2.append(CertificatePinner.Companion.pin((X509Certificate)obj11));
                    stringBuilder2.append("\n              |    DN: ");
                    Principal subjectDN = obj11.getSubjectDN();
                    n.e(subjectDN, "cert.subjectDN");
                    stringBuilder2.append(subjectDN.getName());
                    stringBuilder2.append("\n              |    subjectAltNames: ");
                    stringBuilder2.append(OkHostnameVerifier.INSTANCE.allSubjectAltNames(obj11));
                    stringBuilder2.append("\n              ");
                    SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(l.h(stringBuilder2.toString(), selectedProtocol, i3, selectedProtocol));
                    throw sSLPeerUnverifiedException;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Hostname ");
                stringBuilder.append(address.url().host());
                stringBuilder.append(" not verified (no certificates)");
                obj11 = new SSLPeerUnverifiedException(stringBuilder.toString());
                throw obj11;
            }
            CertificatePinner certificatePinner = address.certificatePinner();
            n.d(certificatePinner);
            RealConnection.connectTls.1 anon2 = new RealConnection.connectTls.1(certificatePinner, handshake, address);
            Handshake handshake2 = new Handshake(handshake.tlsVersion(), handshake.cipherSuite(), handshake.localCertificates(), anon2);
            this.handshake = handshake2;
            RealConnection.connectTls.2 anon = new RealConnection.connectTls.2(this);
            certificatePinner.check$okhttp(address.url().host(), anon);
            if (obj11.supportsTlsExtensions()) {
                selectedProtocol = Platform.Companion.get().getSelectedProtocol(socket2);
            }
            try {
                this.socket = socket2;
                this.source = q.d(q.m(socket2));
                this.sink = q.c(q.i(socket2));
                if (selectedProtocol != 0) {
                } else {
                }
                obj11 = Protocol.Companion.get(selectedProtocol);
                obj11 = Protocol.HTTP_1_1;
                this.protocol = obj11;
                if (socket2 != null) {
                }
                Platform.Companion.get().afterHandshake(socket2);
                socket = obj1;
                obj11 = new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
                throw obj11;
                if (socket != null) {
                }
                Platform.Companion companion = Platform.Companion;
                companion = companion.get();
                companion.afterHandshake(socket);
                if (socket == null) {
                } else {
                }
                Util.closeQuietly(socket);
                throw connectionSpecSelector;
            } catch (Throwable th) {
            }
        }
    }

    private final void connectTunnel(int i, int i2, int i3, Call call4, EventListener eventListener5) {
        Request tunnelRequest;
        int i5;
        int i4;
        java.net.InetSocketAddress socketAddress;
        Proxy proxy;
        i5 = 0;
        while (i5 < 21) {
            connectSocket(i, i2, call4, eventListener5);
            if (createTunnel(i2, i3, tunnelRequest, createTunnelRequest().url()) != null) {
            }
            Socket rawSocket = this.rawSocket;
            if (rawSocket != null) {
            }
            i4 = 0;
            this.rawSocket = i4;
            this.sink = i4;
            this.source = i4;
            eventListener5.connectEnd(call4, this.route.socketAddress(), this.route.proxy(), i4);
            i5++;
            Util.closeQuietly(rawSocket);
        }
    }

    private final Request createTunnel(int i, int i2, Request request3, HttpUrl httpUrl4) {
        StringBuilder stringBuilder;
        String str;
        String str2;
        int i4;
        int i3;
        long l;
        TimeUnit mILLISECONDS;
        boolean obj10;
        Object obj12;
        stringBuilder = new StringBuilder();
        stringBuilder.append("CONNECT ");
        int i6 = 1;
        stringBuilder.append(Util.toHostHeader(httpUrl4, i6));
        stringBuilder.append(" HTTP/1.1");
        h source = this.source;
        n.d(source);
        g sink = this.sink;
        n.d(sink);
        i4 = 0;
        Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(i4, this, source, sink);
        mILLISECONDS = TimeUnit.MILLISECONDS;
        source.timeout().timeout((long)i, obj7);
        sink.timeout().timeout((long)i2, obj7);
        http1ExchangeCodec.writeRequest(obj12.headers(), stringBuilder.toString());
        http1ExchangeCodec.finishRequest();
        Response.Builder responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
        n.d(responseHeaders);
        obj12 = responseHeaders.request(obj12).build();
        http1ExchangeCodec.skipConnectBody(obj12);
        int code = obj12.code();
        while (code != 200) {
            stringBuilder = this.route.address().proxyAuthenticator().authenticate(this.route, obj12);
            obj12 = stringBuilder;
            source = this.source;
            n.d(source);
            sink = this.sink;
            n.d(sink);
            i4 = 0;
            http1ExchangeCodec = new Http1ExchangeCodec(i4, this, source, sink);
            mILLISECONDS = TimeUnit.MILLISECONDS;
            source.timeout().timeout((long)i, obj7);
            sink.timeout().timeout((long)i2, obj7);
            http1ExchangeCodec.writeRequest(obj12.headers(), obj13);
            http1ExchangeCodec.finishRequest();
            responseHeaders = http1ExchangeCodec.readResponseHeaders(false);
            n.d(responseHeaders);
            obj12 = responseHeaders.request(obj12).build();
            http1ExchangeCodec.skipConnectBody(obj12);
            code = obj12.code();
        }
        if (!source.h().b0()) {
        } else {
            if (!sink.h().b0()) {
            } else {
                return i4;
            }
        }
        obj10 = new IOException("TLS tunnel buffered too many bytes!");
        throw obj10;
    }

    private final Request createTunnelRequest() {
        Request build;
        Request.Builder builder = new Request.Builder();
        Response.Builder builder3 = new Response.Builder();
        int i4 = -1;
        Request authenticate = this.route.address().proxyAuthenticator().authenticate(this.route, builder3.request(builder.url(this.route.address().url()).method("CONNECT", 0).header("Host", Util.toHostHeader(this.route.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", "okhttp/4.9.2").build()).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(i4).receivedResponseAtMillis(i4).header("Proxy-Authenticate", "OkHttp-Preemptive").build());
        if (authenticate != null) {
            build = authenticate;
        }
        return build;
    }

    private final void establishProtocol(okhttp3.internal.connection.ConnectionSpecSelector connectionSpecSelector, int i2, Call call3, EventListener eventListener4) {
        Protocol obj4 = Protocol.H2_PRIOR_KNOWLEDGE;
        if (this.route.address().sslSocketFactory() == null && this.route.address().protocols().contains(obj4)) {
            obj4 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (this.route.address().protocols().contains(obj4)) {
                this.socket = this.rawSocket;
                this.protocol = obj4;
                startHttp2(i2);
            }
            this.socket = this.rawSocket;
            this.protocol = Protocol.HTTP_1_1;
        }
        eventListener4.secureConnectStart(call3);
        connectTls(connectionSpecSelector);
        eventListener4.secureConnectEnd(call3, this.handshake);
        if (this.protocol == Protocol.HTTP_2) {
            startHttp2(i2);
        }
    }

    private final boolean routeMatchesAny(List<Route> list) {
        boolean empty;
        Object next;
        int i;
        java.net.InetSocketAddress socketAddress;
        Proxy.Type dIRECT;
        Object obj6;
        final int i2 = 0;
        if (list instanceof Collection != null && list.isEmpty()) {
            if (list.isEmpty()) {
                i = i2;
            } else {
                obj6 = list.iterator();
                while (obj6.hasNext()) {
                    next = obj6.next();
                    if ((Route)next.proxy().type() == Proxy.Type.DIRECT && this.route.proxy().type() == Proxy.Type.DIRECT && n.b(this.route.socketAddress(), next.socketAddress())) {
                    } else {
                    }
                    empty = i2;
                    if (!empty) {
                        break;
                    }
                    if (this.route.proxy().type() == Proxy.Type.DIRECT) {
                    } else {
                    }
                    if (n.b(this.route.socketAddress(), next.socketAddress())) {
                    } else {
                    }
                    empty = i;
                }
            }
        } else {
        }
        return i;
    }

    private final void startHttp2(int i) {
        Socket socket = this.socket;
        n.d(socket);
        h source = this.source;
        n.d(source);
        final g sink = this.sink;
        n.d(sink);
        final int i4 = 0;
        socket.setSoTimeout(i4);
        Http2Connection.Builder builder = new Http2Connection.Builder(1, TaskRunner.INSTANCE);
        Http2Connection obj8 = builder.socket(socket, this.route.address().url().host(), source, sink).listener(this).pingIntervalMillis(i).build();
        this.http2Connection = obj8;
        this.allocationLimit = Http2Connection.Companion.getDEFAULT_SETTINGS().getMaxConcurrentStreams();
        int i2 = 0;
        Http2Connection.start$default(obj8, i4, i2, 3, i2);
    }

    private final boolean supportsUrl(HttpUrl httpUrl) {
        boolean assertionsEnabled;
        boolean noCoalescedConnections;
        int i;
        HttpUrl obj5;
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            obj5 = new AssertionError(stringBuilder.toString());
            throw obj5;
        }
        HttpUrl httpUrl2 = this.route.address().url();
        if (httpUrl.port() != httpUrl2.port()) {
            return 0;
        }
        int i2 = 1;
        if (n.b(httpUrl.host(), httpUrl2.host())) {
            return i2;
        }
        noCoalescedConnections = this.handshake;
        n.d(noCoalescedConnections);
        if (!this.noCoalescedConnections && noCoalescedConnections != null && certificateSupportHost(httpUrl, noCoalescedConnections)) {
            noCoalescedConnections = this.handshake;
            if (noCoalescedConnections != null) {
                n.d(noCoalescedConnections);
                if (certificateSupportHost(httpUrl, noCoalescedConnections)) {
                    i = i2;
                }
            }
        }
        return i;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void cancel() {
        final Socket rawSocket = this.rawSocket;
        if (rawSocket != null) {
            Util.closeQuietly(rawSocket);
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void connect(int i, int i2, int i3, int i4, boolean z5, Call call6, EventListener eventListener7) {
        int i5;
        boolean contains;
        Socket requiresTunnel;
        boolean requiresTunnel2;
        Socket socket;
        Protocol cleartextTrafficPermitted;
        int protocol;
        int socketAddress;
        int proxy;
        Call call;
        EventListener list;
        okhttp3.internal.connection.RouteException routeException;
        int i6;
        int i7;
        final Object obj = this;
        final Object obj2 = call6;
        final Object obj3 = eventListener7;
        n.f(obj2, "call");
        n.f(obj3, "eventListener");
        i5 = obj.protocol == null ? i8 : 0;
        if (i5 == 0) {
        } else {
            List connectionSpecs = obj.route.address().connectionSpecs();
            ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(connectionSpecs);
            if (obj.route.address().sslSocketFactory() == null) {
                if (!connectionSpecs.contains(ConnectionSpec.CLEARTEXT)) {
                } else {
                    contains = obj.route.address().url().host();
                    if (!Platform.Companion.get().isCleartextTrafficPermitted(contains)) {
                    } else {
                        final int i10 = i9;
                        if (obj.route.requiresTunnel()) {
                            this.connectTunnel(i, i2, i3, call6, eventListener7);
                            if (obj.rawSocket == null) {
                            } else {
                                i6 = i;
                                i7 = i2;
                                obj.establishProtocol(connectionSpecSelector, i4, obj2, obj3);
                                obj3.connectEnd(obj2, obj.route.socketAddress(), obj.route.proxy(), obj.protocol);
                            }
                        } else {
                            obj.connectSocket(i, i2, obj2, obj3);
                        }
                        if (obj.route.requiresTunnel()) {
                            if (obj.rawSocket == null) {
                            } else {
                            }
                            ProtocolException protocolException = new ProtocolException("Too many tunnel connections attempted: 21");
                            RouteException routeException2 = new RouteException(protocolException);
                            throw routeException2;
                        }
                        obj.idleAtNs = System.nanoTime();
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("CLEARTEXT communication to ");
                    stringBuilder.append(contains);
                    stringBuilder.append(" not permitted by network security policy");
                    UnknownServiceException unknownServiceException3 = new UnknownServiceException(stringBuilder.toString());
                    RouteException routeException5 = new RouteException(unknownServiceException3);
                    throw routeException5;
                }
                UnknownServiceException unknownServiceException2 = new UnknownServiceException("CLEARTEXT communication not enabled for client");
                RouteException routeException4 = new RouteException(unknownServiceException2);
                throw routeException4;
            }
            if (obj.route.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            } else {
            }
            UnknownServiceException unknownServiceException = new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
            RouteException routeException3 = new RouteException(unknownServiceException);
            throw routeException3;
        }
        IllegalStateException illegalStateException = new IllegalStateException("already connected".toString());
        throw illegalStateException;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void connectFailed$okhttp(OkHttpClient okHttpClient, Route route2, IOException iOException3) {
        Object type;
        Object proxySelector;
        java.net.SocketAddress address;
        n.f(okHttpClient, "client");
        n.f(route2, "failedRoute");
        n.f(iOException3, "failure");
        if (route2.proxy().type() != Proxy.Type.DIRECT) {
            Address address2 = route2.address();
            address2.proxySelector().connectFailed(address2.url().uri(), route2.proxy().address(), iOException3);
        }
        okHttpClient.getRouteDatabase().failed(route2);
    }

    public final List<Reference<okhttp3.internal.connection.RealCall>> getCalls() {
        return this.calls;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final okhttp3.internal.connection.RealConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final long getIdleAtNs$okhttp() {
        return this.idleAtNs;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final boolean getNoNewExchanges() {
        return this.noNewExchanges;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final int getRouteFailureCount$okhttp() {
        return this.routeFailureCount;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public Handshake handshake() {
        return this.handshake;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void incrementSuccessCount$okhttp() {
        this.successCount = successCount++;
        return;
        synchronized (this) {
            this.successCount = successCount++;
        }
    }

    public final boolean isEligible$okhttp(Address address, List<Route> list2) {
        boolean assertionsEnabled;
        int http2Connection;
        int allocationLimit;
        List obj5;
        n.f(address, "address");
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            obj5 = new StringBuilder();
            obj5.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            obj5.append(currentThread.getName());
            obj5.append(" MUST hold lock on ");
            obj5.append(this);
            AssertionError obj4 = new AssertionError(obj5.toString());
            throw obj4;
        }
        final int i = 0;
        if (this.calls.size() < this.allocationLimit) {
            if (this.noNewExchanges) {
            } else {
                if (!this.route.address().equalsNonHost$okhttp(address)) {
                    return i;
                }
                allocationLimit = 1;
                if (n.b(address.url().host(), route().address().url().host())) {
                    return allocationLimit;
                }
                if (this.http2Connection == null) {
                    return i;
                }
                if (list2 != null) {
                    if (!routeMatchesAny(list2)) {
                    } else {
                        if (address.hostnameVerifier() != OkHostnameVerifier.INSTANCE) {
                            return i;
                        }
                        if (!supportsUrl(address.url())) {
                            return i;
                        }
                    }
                    obj5 = address.certificatePinner();
                    n.d(obj5);
                    Handshake handshake = handshake();
                    n.d(handshake);
                    obj5.check(address.url().host(), handshake.peerCertificates());
                    return allocationLimit;
                }
            }
        }
        return i;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final boolean isHealthy(boolean z) {
        boolean assertionsEnabled;
        boolean outputShutdown;
        if (Util.assertionsEnabled) {
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
            AssertionError obj8 = new AssertionError(stringBuilder.toString());
            throw obj8;
        }
        long nanoTime = System.nanoTime();
        Socket rawSocket = this.rawSocket;
        n.d(rawSocket);
        final Socket socket = this.socket;
        n.d(socket);
        final h source = this.source;
        n.d(source);
        if (!rawSocket.isClosed() && !socket.isClosed() && !socket.isInputShutdown()) {
            if (!socket.isClosed()) {
                if (!socket.isInputShutdown()) {
                    if (socket.isOutputShutdown()) {
                    } else {
                        Http2Connection http2Connection = this.http2Connection;
                        if (http2Connection != null) {
                            return http2Connection.isHealthy(nanoTime);
                        }
                        synchronized (this) {
                        }
                        if (z != null) {
                            return Util.isHealthy(socket, source);
                        }
                    }
                    return 1;
                }
            }
        }
        return 0;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final boolean isMultiplexed$okhttp() {
        int i;
        i = this.http2Connection != null ? 1 : 0;
        return i;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final ExchangeCodec newCodec$okhttp(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain2) {
        Object http2ExchangeCodec;
        Http2Connection http2Connection;
        TimeUnit mILLISECONDS;
        Object obj8;
        n.f(okHttpClient, "client");
        n.f(realInterceptorChain2, "chain");
        Socket socket = this.socket;
        n.d(socket);
        final h source = this.source;
        n.d(source);
        final g sink = this.sink;
        n.d(sink);
        http2Connection = this.http2Connection;
        if (http2Connection != null) {
            http2ExchangeCodec = new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain2, http2Connection);
        } else {
            socket.setSoTimeout(realInterceptorChain2.readTimeoutMillis());
            mILLISECONDS = TimeUnit.MILLISECONDS;
            source.timeout().timeout((long)readTimeoutMillis$okhttp, obj4);
            sink.timeout().timeout((long)obj8, obj4);
            http2ExchangeCodec = new Http1ExchangeCodec(okHttpClient, this, source, sink);
        }
        return http2ExchangeCodec;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final RealWebSocket.Streams newWebSocketStreams$okhttp(okhttp3.internal.connection.Exchange exchange) {
        n.f(exchange, "exchange");
        Socket socket = this.socket;
        n.d(socket);
        final h source = this.source;
        n.d(source);
        final g sink = this.sink;
        n.d(sink);
        socket.setSoTimeout(0);
        noNewExchanges$okhttp();
        super(exchange, source, sink, 1, source, sink);
        return anon;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void noCoalescedConnections$okhttp() {
        this.noCoalescedConnections = true;
        return;
        synchronized (this) {
            this.noCoalescedConnections = true;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void noNewExchanges$okhttp() {
        this.noNewExchanges = true;
        return;
        synchronized (this) {
            this.noNewExchanges = true;
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public void onSettings(Http2Connection http2Connection, Settings settings2) {
        n.f(http2Connection, "connection");
        n.f(settings2, "settings");
        this.allocationLimit = settings2.getMaxConcurrentStreams();
        return;
        synchronized (this) {
            n.f(http2Connection, "connection");
            n.f(settings2, "settings");
            this.allocationLimit = settings2.getMaxConcurrentStreams();
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public void onStream(Http2Stream http2Stream) {
        n.f(http2Stream, "stream");
        http2Stream.close(ErrorCode.REFUSED_STREAM, 0);
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public Protocol protocol() {
        final Protocol protocol = this.protocol;
        n.d(protocol);
        return protocol;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public Route route() {
        return this.route;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void setIdleAtNs$okhttp(long l) {
        this.idleAtNs = l;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void setNoNewExchanges(boolean z) {
        this.noNewExchanges = z;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void setRouteFailureCount$okhttp(int i) {
        this.routeFailureCount = i;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public Socket socket() {
        final Socket socket = this.socket;
        n.d(socket);
        return socket;
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public String toString() {
        Object cipherSuite;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Connection{");
        stringBuilder.append(this.route.address().url().host());
        stringBuilder.append(':');
        stringBuilder.append(this.route.address().url().port());
        stringBuilder.append(',');
        stringBuilder.append(" proxy=");
        stringBuilder.append(this.route.proxy());
        stringBuilder.append(" hostAddress=");
        stringBuilder.append(this.route.socketAddress());
        stringBuilder.append(" cipherSuite=");
        cipherSuite = this.handshake;
        if (cipherSuite != null && cipherSuite.cipherSuite() != null) {
            if (cipherSuite.cipherSuite() != null) {
            } else {
                cipherSuite = "none";
            }
        } else {
        }
        stringBuilder.append(cipherSuite);
        stringBuilder.append(" protocol=");
        stringBuilder.append(this.protocol);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    @Override // okhttp3.internal.http2.Http2Connection$Listener
    public final void trackFailure$okhttp(okhttp3.internal.connection.RealCall realCall, IOException iOException2) {
        ErrorCode multiplexed$okhttp;
        ErrorCode rEFUSED_STREAM;
        int obj4;
        Object obj5;
        n.f(realCall, "call");
        final int i = 1;
        synchronized (this) {
            try {
                if (obj.errorCode == ErrorCode.REFUSED_STREAM) {
                } else {
                }
                obj4 += i;
                this.refusedStreamCount = obj4;
                if (obj4 > i) {
                }
                this.noNewExchanges = i;
                this.routeFailureCount = obj4 += i;
                if (iOException2.errorCode == ErrorCode.CANCEL && realCall.isCanceled()) {
                } else {
                }
                if (realCall.isCanceled()) {
                } else {
                }
                this.noNewExchanges = i;
                this.routeFailureCount = obj4 += i;
                if (isMultiplexed$okhttp()) {
                } else {
                }
                this.noNewExchanges = i;
                if (iOException2 instanceof ConnectionShutdownException != null && this.successCount == 0 && (StreamResetException)iOException2 != null) {
                }
                this.noNewExchanges = i;
                if (this.successCount == 0) {
                }
                if ((StreamResetException)iOException2 != null) {
                }
                connectFailed$okhttp(realCall.getClient(), this.route, (StreamResetException)iOException2);
                this.routeFailureCount = obj4 += i;
                throw realCall;
            }
        }
    }
}
