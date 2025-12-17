package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.CertificateChainCleaner.Companion;
import okhttp3.internal.tls.OkHostnameVerifier;
import okhttp3.internal.ws.RealWebSocket;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\t\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0016\u0018\u0000 \u0090\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0004\u0091\u0001\u0090\u0001B\u0014\u0008\u0000\u0012\u0007\u0010\u008d\u0001\u001a\u00020\u0011¢\u0006\u0006\u0008\u008e\u0001\u0010\u008f\u0001B\n\u0008\u0016¢\u0006\u0005\u0008\u008e\u0001\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0017\u001a\u00020\u0014H\u0007¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u001b\u001a\u00020\u0018H\u0007¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0015\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001cH\u0007¢\u0006\u0004\u0008!\u0010\u001fJ\u000f\u0010&\u001a\u00020#H\u0007¢\u0006\u0004\u0008$\u0010%J\u000f\u0010*\u001a\u00020'H\u0007¢\u0006\u0004\u0008(\u0010)J\u000f\u0010.\u001a\u00020+H\u0007¢\u0006\u0004\u0008,\u0010-J\u000f\u00100\u001a\u00020'H\u0007¢\u0006\u0004\u0008/\u0010)J\u000f\u00102\u001a\u00020'H\u0007¢\u0006\u0004\u00081\u0010)J\u000f\u00106\u001a\u000203H\u0007¢\u0006\u0004\u00084\u00105J\u0011\u0010:\u001a\u0004\u0018\u000107H\u0007¢\u0006\u0004\u00088\u00109J\u000f\u0010>\u001a\u00020;H\u0007¢\u0006\u0004\u0008<\u0010=J\u0011\u0010B\u001a\u0004\u0018\u00010?H\u0007¢\u0006\u0004\u0008@\u0010AJ\u000f\u0010F\u001a\u00020CH\u0007¢\u0006\u0004\u0008D\u0010EJ\u000f\u0010H\u001a\u00020+H\u0007¢\u0006\u0004\u0008G\u0010-J\u000f\u0010L\u001a\u00020IH\u0007¢\u0006\u0004\u0008J\u0010KJ\u000f\u0010P\u001a\u00020MH\u0007¢\u0006\u0004\u0008N\u0010OJ\u0015\u0010S\u001a\u0008\u0012\u0004\u0012\u00020Q0\u001cH\u0007¢\u0006\u0004\u0008R\u0010\u001fJ\u0015\u0010V\u001a\u0008\u0012\u0004\u0012\u00020T0\u001cH\u0007¢\u0006\u0004\u0008U\u0010\u001fJ\u000f\u0010Z\u001a\u00020WH\u0007¢\u0006\u0004\u0008X\u0010YJ\u000f\u0010^\u001a\u00020[H\u0007¢\u0006\u0004\u0008\\\u0010]J\u000f\u0010b\u001a\u00020_H\u0007¢\u0006\u0004\u0008`\u0010aJ\u000f\u0010d\u001a\u00020_H\u0007¢\u0006\u0004\u0008c\u0010aJ\u000f\u0010f\u001a\u00020_H\u0007¢\u0006\u0004\u0008e\u0010aJ\u000f\u0010h\u001a\u00020_H\u0007¢\u0006\u0004\u0008g\u0010aJ\u000f\u0010j\u001a\u00020_H\u0007¢\u0006\u0004\u0008i\u0010aR\u001f\u0010S\u001a\u0008\u0012\u0004\u0012\u00020Q0\u001c8G@\u0006¢\u0006\u000c\n\u0004\u0008S\u0010k\u001a\u0004\u0008S\u0010\u001fR\u0013\u0010P\u001a\u00020M8G@\u0006¢\u0006\u0006\u001a\u0004\u0008P\u0010OR\u0019\u0010H\u001a\u00020+8G@\u0006¢\u0006\u000c\n\u0004\u0008H\u0010l\u001a\u0004\u0008H\u0010-R\u0019\u0010.\u001a\u00020+8G@\u0006¢\u0006\u000c\n\u0004\u0008.\u0010l\u001a\u0004\u0008.\u0010-R\u001b\u0010n\u001a\u0004\u0018\u00010m8G@\u0006¢\u0006\u000c\n\u0004\u0008n\u0010o\u001a\u0004\u0008n\u0010pR\u0019\u0010&\u001a\u00020#8G@\u0006¢\u0006\u000c\n\u0004\u0008&\u0010q\u001a\u0004\u0008&\u0010%R\u0019\u0010Z\u001a\u00020W8G@\u0006¢\u0006\u000c\n\u0004\u0008Z\u0010r\u001a\u0004\u0008Z\u0010YR\u001f\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c8G@\u0006¢\u0006\u000c\n\u0004\u0008\"\u0010k\u001a\u0004\u0008\"\u0010\u001fR\u0019\u0010F\u001a\u00020C8G@\u0006¢\u0006\u000c\n\u0004\u0008F\u0010s\u001a\u0004\u0008F\u0010ER\u0019\u0010\u001b\u001a\u00020\u00188G@\u0006¢\u0006\u000c\n\u0004\u0008\u001b\u0010t\u001a\u0004\u0008\u001b\u0010\u001aR\u0019\u00100\u001a\u00020'8G@\u0006¢\u0006\u000c\n\u0004\u00080\u0010u\u001a\u0004\u00080\u0010)R\u0019\u0010f\u001a\u00020_8G@\u0006¢\u0006\u000c\n\u0004\u0008f\u0010v\u001a\u0004\u0008f\u0010aR\u0019\u0010\u0017\u001a\u00020\u00148G@\u0006¢\u0006\u000c\n\u0004\u0008\u0017\u0010w\u001a\u0004\u0008\u0017\u0010\u0016R\u001b\u0010B\u001a\u0004\u0018\u00010?8G@\u0006¢\u0006\u000c\n\u0004\u0008B\u0010x\u001a\u0004\u0008B\u0010AR\u0019\u0010*\u001a\u00020'8G@\u0006¢\u0006\u000c\n\u0004\u0008*\u0010u\u001a\u0004\u0008*\u0010)R\u0019\u0010h\u001a\u00020_8G@\u0006¢\u0006\u000c\n\u0004\u0008h\u0010v\u001a\u0004\u0008h\u0010aR\u001f\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u001d0\u001c8G@\u0006¢\u0006\u000c\n\u0004\u0008 \u0010k\u001a\u0004\u0008 \u0010\u001fR\u0019\u00102\u001a\u00020'8G@\u0006¢\u0006\u000c\n\u0004\u00082\u0010u\u001a\u0004\u00082\u0010)R\u0019\u0010b\u001a\u00020_8G@\u0006¢\u0006\u000c\n\u0004\u0008b\u0010v\u001a\u0004\u0008b\u0010aR\u0019\u00106\u001a\u0002038G@\u0006¢\u0006\u000c\n\u0004\u00086\u0010y\u001a\u0004\u00086\u00105R\u0019\u0010^\u001a\u00020[8G@\u0006¢\u0006\u000c\n\u0004\u0008^\u0010z\u001a\u0004\u0008^\u0010]R\u0019\u0010|\u001a\u00020{8G@\u0006¢\u0006\u000c\n\u0004\u0008|\u0010}\u001a\u0004\u0008|\u0010~R\u0019\u0010L\u001a\u00020I8G@\u0006¢\u0006\u000c\n\u0004\u0008L\u0010\u007f\u001a\u0004\u0008L\u0010KR\u001a\u0010>\u001a\u00020;8G@\u0006¢\u0006\r\n\u0005\u0008>\u0010\u0080\u0001\u001a\u0004\u0008>\u0010=R\u001b\u0010\u0081\u0001\u001a\u0004\u0018\u00010M8\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0081\u0001\u0010\u0082\u0001R\u001c\u0010:\u001a\u0004\u0018\u0001078G@\u0006¢\u0006\r\n\u0005\u0008:\u0010\u0083\u0001\u001a\u0004\u0008:\u00109R\u0019\u0010d\u001a\u00020_8G@\u0006¢\u0006\u000c\n\u0004\u0008d\u0010v\u001a\u0004\u0008d\u0010aR\u0019\u0010j\u001a\u00020_8G@\u0006¢\u0006\u000c\n\u0004\u0008j\u0010v\u001a\u0004\u0008j\u0010aR\u001f\u0010V\u001a\u0008\u0012\u0004\u0012\u00020T0\u001c8G@\u0006¢\u0006\u000c\n\u0004\u0008V\u0010k\u001a\u0004\u0008V\u0010\u001fR!\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0084\u00018G@\u0006¢\u0006\u0010\n\u0006\u0008\u0085\u0001\u0010\u0086\u0001\u001a\u0006\u0008\u0085\u0001\u0010\u0087\u0001R\u001f\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\u0008\u0089\u0001\u0010\u008a\u0001\u001a\u0006\u0008\u008b\u0001\u0010\u008c\u0001¨\u0006\u0092\u0001", d2 = {"Lokhttp3/OkHttpClient;", "", "Lokhttp3/Call$Factory;", "Lokhttp3/WebSocket$Factory;", "Lkotlin/w;", "verifyClientState", "()V", "Lokhttp3/Request;", "request", "Lokhttp3/Call;", "newCall", "(Lokhttp3/Request;)Lokhttp3/Call;", "Lokhttp3/WebSocketListener;", "listener", "Lokhttp3/WebSocket;", "newWebSocket", "(Lokhttp3/Request;Lokhttp3/WebSocketListener;)Lokhttp3/WebSocket;", "Lokhttp3/OkHttpClient$Builder;", "newBuilder", "()Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dispatcher;", "-deprecated_dispatcher", "()Lokhttp3/Dispatcher;", "dispatcher", "Lokhttp3/ConnectionPool;", "-deprecated_connectionPool", "()Lokhttp3/ConnectionPool;", "connectionPool", "", "Lokhttp3/Interceptor;", "-deprecated_interceptors", "()Ljava/util/List;", "interceptors", "-deprecated_networkInterceptors", "networkInterceptors", "Lokhttp3/EventListener$Factory;", "-deprecated_eventListenerFactory", "()Lokhttp3/EventListener$Factory;", "eventListenerFactory", "", "-deprecated_retryOnConnectionFailure", "()Z", "retryOnConnectionFailure", "Lokhttp3/Authenticator;", "-deprecated_authenticator", "()Lokhttp3/Authenticator;", "authenticator", "-deprecated_followRedirects", "followRedirects", "-deprecated_followSslRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "-deprecated_cookieJar", "()Lokhttp3/CookieJar;", "cookieJar", "Lokhttp3/Cache;", "-deprecated_cache", "()Lokhttp3/Cache;", "cache", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "-deprecated_proxyAuthenticator", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Lokhttp3/Protocol;", "-deprecated_protocols", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "", "-deprecated_callTimeoutMillis", "()I", "callTimeoutMillis", "-deprecated_connectTimeoutMillis", "connectTimeoutMillis", "-deprecated_readTimeoutMillis", "readTimeoutMillis", "-deprecated_writeTimeoutMillis", "writeTimeoutMillis", "-deprecated_pingIntervalMillis", "pingIntervalMillis", "Ljava/util/List;", "Lokhttp3/Authenticator;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/EventListener$Factory;", "Ljavax/net/ssl/HostnameVerifier;", "Ljava/net/ProxySelector;", "Lokhttp3/ConnectionPool;", "Z", "I", "Lokhttp3/Dispatcher;", "Ljava/net/Proxy;", "Lokhttp3/CookieJar;", "Lokhttp3/CertificatePinner;", "", "minWebSocketMessageToCompress", "J", "()J", "Ljavax/net/SocketFactory;", "Lokhttp3/Dns;", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "Lokhttp3/Cache;", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManager", "Ljavax/net/ssl/X509TrustManager;", "()Ljavax/net/ssl/X509TrustManager;", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase", "()Lokhttp3/internal/connection/RouteDatabase;", "builder", "<init>", "(Lokhttp3/OkHttpClient$Builder;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public class OkHttpClient implements java.lang.Cloneable, okhttp3.Call.Factory, okhttp3.WebSocket.Factory {

    public static final okhttp3.OkHttpClient.Companion Companion;
    private static final List<okhttp3.ConnectionSpec> DEFAULT_CONNECTION_SPECS;
    private static final List<okhttp3.Protocol> DEFAULT_PROTOCOLS;
    private final okhttp3.Authenticator authenticator;
    private final okhttp3.Cache cache;
    private final int callTimeoutMillis;
    private final CertificateChainCleaner certificateChainCleaner;
    private final okhttp3.CertificatePinner certificatePinner;
    private final int connectTimeoutMillis;
    private final okhttp3.ConnectionPool connectionPool;
    private final List<okhttp3.ConnectionSpec> connectionSpecs;
    private final okhttp3.CookieJar cookieJar;
    private final okhttp3.Dispatcher dispatcher;
    private final okhttp3.Dns dns;
    private final okhttp3.EventListener.Factory eventListenerFactory;
    private final boolean followRedirects;
    private final boolean followSslRedirects;
    private final HostnameVerifier hostnameVerifier;
    private final List<okhttp3.Interceptor> interceptors;
    private final long minWebSocketMessageToCompress;
    private final List<okhttp3.Interceptor> networkInterceptors;
    private final int pingIntervalMillis;
    private final List<okhttp3.Protocol> protocols;
    private final Proxy proxy;
    private final okhttp3.Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final int readTimeoutMillis;
    private final boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactoryOrNull;
    private final int writeTimeoutMillis;
    private final X509TrustManager x509TrustManager;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008=\n\u0002\u0018\u0002\n\u0002\u0008<\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\u0008Ü\u0001\u0010Ý\u0001B\u0014\u0008\u0010\u0012\u0007\u0010Þ\u0001\u001a\u00020]¢\u0006\u0006\u0008Ü\u0001\u0010ß\u0001J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0013\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0004\u0008\r\u0010\u000eJ)\u0010\r\u001a\u00020\u00002\u0014\u0008\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0013\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0008¢\u0006\u0004\u0008\u0015\u0010\u000bJ\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\t¢\u0006\u0004\u0008\u0016\u0010\u000eJ)\u0010\u0016\u001a\u00020\u00002\u0014\u0008\u0004\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0087\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\u0008\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\u0008\"\u0010#J\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u001e¢\u0006\u0004\u0008$\u0010 J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u001e¢\u0006\u0004\u0008&\u0010 J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020'¢\u0006\u0004\u0008(\u0010)J\u0017\u0010+\u001a\u00020\u00002\u0008\u0010+\u001a\u0004\u0018\u00010*¢\u0006\u0004\u0008+\u0010,J\u0015\u0010.\u001a\u00020\u00002\u0006\u0010.\u001a\u00020-¢\u0006\u0004\u0008.\u0010/J\u0017\u00101\u001a\u00020\u00002\u0008\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\u00081\u00102J\u0015\u00104\u001a\u00020\u00002\u0006\u00104\u001a\u000203¢\u0006\u0004\u00084\u00105J\u0015\u00106\u001a\u00020\u00002\u0006\u00106\u001a\u00020!¢\u0006\u0004\u00086\u0010#J\u0015\u00108\u001a\u00020\u00002\u0006\u00108\u001a\u000207¢\u0006\u0004\u00088\u00109J\u0017\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:H\u0007¢\u0006\u0004\u0008;\u0010<J\u001d\u0010;\u001a\u00020\u00002\u0006\u0010;\u001a\u00020:2\u0006\u0010>\u001a\u00020=¢\u0006\u0004\u0008;\u0010?J\u001b\u0010B\u001a\u00020\u00002\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u00020A0@¢\u0006\u0004\u0008B\u0010CJ\u001b\u0010E\u001a\u00020\u00002\u000c\u0010E\u001a\u0008\u0012\u0004\u0012\u00020D0@¢\u0006\u0004\u0008E\u0010CJ\u0015\u0010G\u001a\u00020\u00002\u0006\u0010G\u001a\u00020F¢\u0006\u0004\u0008G\u0010HJ\u0015\u0010J\u001a\u00020\u00002\u0006\u0010J\u001a\u00020I¢\u0006\u0004\u0008J\u0010KJ\u001d\u0010P\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\u0008P\u0010QJ\u0017\u0010P\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\u0008P\u0010TJ\u001d\u0010U\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\u0008U\u0010QJ\u0017\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\u0008U\u0010TJ\u001d\u0010V\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\u0008V\u0010QJ\u0017\u0010V\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\u0008V\u0010TJ\u001d\u0010W\u001a\u00020\u00002\u0006\u0010M\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\u0008W\u0010QJ\u0017\u0010W\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\u0008W\u0010TJ\u001d\u0010Y\u001a\u00020\u00002\u0006\u0010X\u001a\u00020L2\u0006\u0010O\u001a\u00020N¢\u0006\u0004\u0008Y\u0010QJ\u0017\u0010Y\u001a\u00020\u00002\u0006\u0010S\u001a\u00020RH\u0007¢\u0006\u0004\u0008Y\u0010TJ\u0015\u0010[\u001a\u00020\u00002\u0006\u0010Z\u001a\u00020L¢\u0006\u0004\u0008[\u0010\\J\r\u0010^\u001a\u00020]¢\u0006\u0004\u0008^\u0010_R\"\u0010U\u001a\u00020`8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008U\u0010a\u001a\u0004\u0008b\u0010c\"\u0004\u0008d\u0010eR$\u0010g\u001a\u0004\u0018\u00010f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008g\u0010h\u001a\u0004\u0008i\u0010j\"\u0004\u0008k\u0010lR\"\u00106\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u00086\u0010m\u001a\u0004\u0008n\u0010o\"\u0004\u0008p\u0010qR\"\u0010$\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008$\u0010r\u001a\u0004\u0008s\u0010t\"\u0004\u0008u\u0010vR\"\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\"\u0010m\u001a\u0004\u0008w\u0010o\"\u0004\u0008x\u0010qR\"\u0010(\u001a\u00020'8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008(\u0010y\u001a\u0004\u0008z\u0010{\"\u0004\u0008|\u0010}R%\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0004\u0008\u0006\u0010~\u001a\u0005\u0008\u007f\u0010\u0080\u0001\"\u0006\u0008\u0081\u0001\u0010\u0082\u0001R$\u0010V\u001a\u00020`8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\u0008V\u0010a\u001a\u0005\u0008\u0083\u0001\u0010c\"\u0005\u0008\u0084\u0001\u0010eR)\u0010+\u001a\u0004\u0018\u00010*8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008+\u0010\u0085\u0001\u001a\u0006\u0008\u0086\u0001\u0010\u0087\u0001\"\u0006\u0008\u0088\u0001\u0010\u0089\u0001R$\u0010P\u001a\u00020`8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\u0008P\u0010a\u001a\u0005\u0008\u008a\u0001\u0010c\"\u0005\u0008\u008b\u0001\u0010eR,\u0010E\u001a\u0008\u0012\u0004\u0012\u00020D0@8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\u0008E\u0010\u008c\u0001\u001a\u0005\u0008\u008d\u0001\u0010\u000b\"\u0006\u0008\u008e\u0001\u0010\u008f\u0001R$\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\u0008\u0015\u0010\u008c\u0001\u001a\u0005\u0008\u0090\u0001\u0010\u000bR,\u0010B\u001a\u0008\u0012\u0004\u0012\u00020A0@8\u0000@\u0000X\u0080\u000e¢\u0006\u0016\n\u0005\u0008B\u0010\u008c\u0001\u001a\u0005\u0008\u0091\u0001\u0010\u000b\"\u0006\u0008\u0092\u0001\u0010\u008f\u0001R'\u0010\u001c\u001a\u00020\u001b8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008\u001c\u0010\u0093\u0001\u001a\u0006\u0008\u0094\u0001\u0010\u0095\u0001\"\u0006\u0008\u0096\u0001\u0010\u0097\u0001R$\u0010W\u001a\u00020`8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\u0008W\u0010a\u001a\u0005\u0008\u0098\u0001\u0010c\"\u0005\u0008\u0099\u0001\u0010eR)\u00104\u001a\u0004\u0018\u0001038\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u00084\u0010\u009a\u0001\u001a\u0006\u0008\u009b\u0001\u0010\u009c\u0001\"\u0006\u0008\u009d\u0001\u0010\u009e\u0001R'\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008\u0003\u0010\u009f\u0001\u001a\u0006\u0008 \u0001\u0010¡\u0001\"\u0006\u0008¢\u0001\u0010£\u0001R,\u0010¥\u0001\u001a\u0005\u0018\u00010¤\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\u0008¥\u0001\u0010¦\u0001\u001a\u0006\u0008§\u0001\u0010¨\u0001\"\u0006\u0008©\u0001\u0010ª\u0001R'\u00108\u001a\u0002078\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u00088\u0010«\u0001\u001a\u0006\u0008¬\u0001\u0010­\u0001\"\u0006\u0008®\u0001\u0010¯\u0001R'\u0010[\u001a\u00020L8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008[\u0010°\u0001\u001a\u0006\u0008±\u0001\u0010²\u0001\"\u0006\u0008³\u0001\u0010´\u0001R$\u0010\u001f\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\u0008\u001f\u0010r\u001a\u0005\u0008µ\u0001\u0010t\"\u0005\u0008¶\u0001\u0010vR'\u0010G\u001a\u00020F8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008G\u0010·\u0001\u001a\u0006\u0008¸\u0001\u0010¹\u0001\"\u0006\u0008º\u0001\u0010»\u0001R$\u0010&\u001a\u00020\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\u0008&\u0010r\u001a\u0005\u0008¼\u0001\u0010t\"\u0005\u0008½\u0001\u0010vR$\u0010Y\u001a\u00020`8\u0000@\u0000X\u0080\u000e¢\u0006\u0014\n\u0004\u0008Y\u0010a\u001a\u0005\u0008¾\u0001\u0010c\"\u0005\u0008¿\u0001\u0010eR+\u0010À\u0001\u001a\u0004\u0018\u00010=8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\u0008À\u0001\u0010Á\u0001\u001a\u0006\u0008Â\u0001\u0010Ã\u0001\"\u0006\u0008Ä\u0001\u0010Å\u0001R+\u0010Æ\u0001\u001a\u0004\u0018\u00010:8\u0000@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\u0008Æ\u0001\u0010Ç\u0001\u001a\u0006\u0008È\u0001\u0010É\u0001\"\u0006\u0008Ê\u0001\u0010Ë\u0001R'\u0010J\u001a\u00020I8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008J\u0010Ì\u0001\u001a\u0006\u0008Í\u0001\u0010Î\u0001\"\u0006\u0008Ï\u0001\u0010Ð\u0001R'\u0010.\u001a\u00020-8\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u0008.\u0010Ñ\u0001\u001a\u0006\u0008Ò\u0001\u0010Ó\u0001\"\u0006\u0008Ô\u0001\u0010Õ\u0001R)\u00101\u001a\u0004\u0018\u0001008\u0000@\u0000X\u0080\u000e¢\u0006\u0017\n\u0005\u00081\u0010Ö\u0001\u001a\u0006\u0008×\u0001\u0010Ø\u0001\"\u0006\u0008Ù\u0001\u0010Ú\u0001R$\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088\u0000@\u0000X\u0080\u0004¢\u0006\u000e\n\u0005\u0008\n\u0010\u008c\u0001\u001a\u0005\u0008Û\u0001\u0010\u000b\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006à\u0001", d2 = {"Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Dispatcher;", "dispatcher", "(Lokhttp3/Dispatcher;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/ConnectionPool;", "connectionPool", "(Lokhttp3/ConnectionPool;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/Interceptor;", "interceptors", "()Ljava/util/List;", "interceptor", "addInterceptor", "(Lokhttp3/Interceptor;)Lokhttp3/OkHttpClient$Builder;", "Lkotlin/Function1;", "Lokhttp3/Interceptor$Chain;", "Lokhttp3/Response;", "block", "-addInterceptor", "(Lkotlin/d0/c/l;)Lokhttp3/OkHttpClient$Builder;", "networkInterceptors", "addNetworkInterceptor", "-addNetworkInterceptor", "Lokhttp3/EventListener;", "eventListener", "(Lokhttp3/EventListener;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/EventListener$Factory;", "eventListenerFactory", "(Lokhttp3/EventListener$Factory;)Lokhttp3/OkHttpClient$Builder;", "", "retryOnConnectionFailure", "(Z)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Authenticator;", "authenticator", "(Lokhttp3/Authenticator;)Lokhttp3/OkHttpClient$Builder;", "followRedirects", "followProtocolRedirects", "followSslRedirects", "Lokhttp3/CookieJar;", "cookieJar", "(Lokhttp3/CookieJar;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Cache;", "cache", "(Lokhttp3/Cache;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Dns;", "dns", "(Lokhttp3/Dns;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/Proxy;", "proxy", "(Ljava/net/Proxy;)Lokhttp3/OkHttpClient$Builder;", "Ljava/net/ProxySelector;", "proxySelector", "(Ljava/net/ProxySelector;)Lokhttp3/OkHttpClient$Builder;", "proxyAuthenticator", "Ljavax/net/SocketFactory;", "socketFactory", "(Ljavax/net/SocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Lokhttp3/OkHttpClient$Builder;", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/X509TrustManager;)Lokhttp3/OkHttpClient$Builder;", "", "Lokhttp3/ConnectionSpec;", "connectionSpecs", "(Ljava/util/List;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/Protocol;", "protocols", "Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "(Ljavax/net/ssl/HostnameVerifier;)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/CertificatePinner;", "certificatePinner", "(Lokhttp3/CertificatePinner;)Lokhttp3/OkHttpClient$Builder;", "", "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "callTimeout", "(JLjava/util/concurrent/TimeUnit;)Lokhttp3/OkHttpClient$Builder;", "Ljava/time/Duration;", "duration", "(Ljava/time/Duration;)Lokhttp3/OkHttpClient$Builder;", "connectTimeout", "readTimeout", "writeTimeout", "interval", "pingInterval", "bytes", "minWebSocketMessageToCompress", "(J)Lokhttp3/OkHttpClient$Builder;", "Lokhttp3/OkHttpClient;", "build", "()Lokhttp3/OkHttpClient;", "", "I", "getConnectTimeout$okhttp", "()I", "setConnectTimeout$okhttp", "(I)V", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "getRouteDatabase$okhttp", "()Lokhttp3/internal/connection/RouteDatabase;", "setRouteDatabase$okhttp", "(Lokhttp3/internal/connection/RouteDatabase;)V", "Lokhttp3/Authenticator;", "getProxyAuthenticator$okhttp", "()Lokhttp3/Authenticator;", "setProxyAuthenticator$okhttp", "(Lokhttp3/Authenticator;)V", "Z", "getFollowRedirects$okhttp", "()Z", "setFollowRedirects$okhttp", "(Z)V", "getAuthenticator$okhttp", "setAuthenticator$okhttp", "Lokhttp3/CookieJar;", "getCookieJar$okhttp", "()Lokhttp3/CookieJar;", "setCookieJar$okhttp", "(Lokhttp3/CookieJar;)V", "Lokhttp3/ConnectionPool;", "getConnectionPool$okhttp", "()Lokhttp3/ConnectionPool;", "setConnectionPool$okhttp", "(Lokhttp3/ConnectionPool;)V", "getReadTimeout$okhttp", "setReadTimeout$okhttp", "Lokhttp3/Cache;", "getCache$okhttp", "()Lokhttp3/Cache;", "setCache$okhttp", "(Lokhttp3/Cache;)V", "getCallTimeout$okhttp", "setCallTimeout$okhttp", "Ljava/util/List;", "getProtocols$okhttp", "setProtocols$okhttp", "(Ljava/util/List;)V", "getNetworkInterceptors$okhttp", "getConnectionSpecs$okhttp", "setConnectionSpecs$okhttp", "Lokhttp3/EventListener$Factory;", "getEventListenerFactory$okhttp", "()Lokhttp3/EventListener$Factory;", "setEventListenerFactory$okhttp", "(Lokhttp3/EventListener$Factory;)V", "getWriteTimeout$okhttp", "setWriteTimeout$okhttp", "Ljava/net/ProxySelector;", "getProxySelector$okhttp", "()Ljava/net/ProxySelector;", "setProxySelector$okhttp", "(Ljava/net/ProxySelector;)V", "Lokhttp3/Dispatcher;", "getDispatcher$okhttp", "()Lokhttp3/Dispatcher;", "setDispatcher$okhttp", "(Lokhttp3/Dispatcher;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "setCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)V", "Ljavax/net/SocketFactory;", "getSocketFactory$okhttp", "()Ljavax/net/SocketFactory;", "setSocketFactory$okhttp", "(Ljavax/net/SocketFactory;)V", "J", "getMinWebSocketMessageToCompress$okhttp", "()J", "setMinWebSocketMessageToCompress$okhttp", "(J)V", "getRetryOnConnectionFailure$okhttp", "setRetryOnConnectionFailure$okhttp", "Ljavax/net/ssl/HostnameVerifier;", "getHostnameVerifier$okhttp", "()Ljavax/net/ssl/HostnameVerifier;", "setHostnameVerifier$okhttp", "(Ljavax/net/ssl/HostnameVerifier;)V", "getFollowSslRedirects$okhttp", "setFollowSslRedirects$okhttp", "getPingInterval$okhttp", "setPingInterval$okhttp", "x509TrustManagerOrNull", "Ljavax/net/ssl/X509TrustManager;", "getX509TrustManagerOrNull$okhttp", "()Ljavax/net/ssl/X509TrustManager;", "setX509TrustManagerOrNull$okhttp", "(Ljavax/net/ssl/X509TrustManager;)V", "sslSocketFactoryOrNull", "Ljavax/net/ssl/SSLSocketFactory;", "getSslSocketFactoryOrNull$okhttp", "()Ljavax/net/ssl/SSLSocketFactory;", "setSslSocketFactoryOrNull$okhttp", "(Ljavax/net/ssl/SSLSocketFactory;)V", "Lokhttp3/CertificatePinner;", "getCertificatePinner$okhttp", "()Lokhttp3/CertificatePinner;", "setCertificatePinner$okhttp", "(Lokhttp3/CertificatePinner;)V", "Lokhttp3/Dns;", "getDns$okhttp", "()Lokhttp3/Dns;", "setDns$okhttp", "(Lokhttp3/Dns;)V", "Ljava/net/Proxy;", "getProxy$okhttp", "()Ljava/net/Proxy;", "setProxy$okhttp", "(Ljava/net/Proxy;)V", "getInterceptors$okhttp", "<init>", "()V", "okHttpClient", "(Lokhttp3/OkHttpClient;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private okhttp3.Authenticator authenticator;
        private okhttp3.Cache cache;
        private int callTimeout;
        private CertificateChainCleaner certificateChainCleaner;
        private okhttp3.CertificatePinner certificatePinner;
        private int connectTimeout;
        private okhttp3.ConnectionPool connectionPool;
        private List<okhttp3.ConnectionSpec> connectionSpecs;
        private okhttp3.CookieJar cookieJar;
        private okhttp3.Dispatcher dispatcher;
        private okhttp3.Dns dns;
        private okhttp3.EventListener.Factory eventListenerFactory;
        private boolean followRedirects;
        private boolean followSslRedirects;
        private HostnameVerifier hostnameVerifier;
        private final List<okhttp3.Interceptor> interceptors;
        private long minWebSocketMessageToCompress;
        private final List<okhttp3.Interceptor> networkInterceptors;
        private int pingInterval;
        private List<? extends okhttp3.Protocol> protocols;
        private Proxy proxy;
        private okhttp3.Authenticator proxyAuthenticator;
        private ProxySelector proxySelector;
        private int readTimeout;
        private boolean retryOnConnectionFailure;
        private RouteDatabase routeDatabase;
        private SocketFactory socketFactory;
        private SSLSocketFactory sslSocketFactoryOrNull;
        private int writeTimeout;
        private X509TrustManager x509TrustManagerOrNull;
        public Builder() {
            super();
            Dispatcher dispatcher = new Dispatcher();
            this.dispatcher = dispatcher;
            ConnectionPool connectionPool = new ConnectionPool();
            this.connectionPool = connectionPool;
            ArrayList arrayList = new ArrayList();
            this.interceptors = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.networkInterceptors = arrayList2;
            this.eventListenerFactory = Util.asFactory(EventListener.NONE);
            int i = 1;
            this.retryOnConnectionFailure = i;
            okhttp3.Authenticator nONE2 = Authenticator.NONE;
            this.authenticator = nONE2;
            this.followRedirects = i;
            this.followSslRedirects = i;
            this.cookieJar = CookieJar.NO_COOKIES;
            this.dns = Dns.SYSTEM;
            this.proxyAuthenticator = nONE2;
            SocketFactory default = SocketFactory.getDefault();
            n.e(default, "SocketFactory.getDefault()");
            this.socketFactory = default;
            okhttp3.OkHttpClient.Companion companion = OkHttpClient.Companion;
            this.connectionSpecs = companion.getDEFAULT_CONNECTION_SPECS$okhttp();
            this.protocols = companion.getDEFAULT_PROTOCOLS$okhttp();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            int i2 = 10000;
            this.connectTimeout = i2;
            this.readTimeout = i2;
            this.writeTimeout = i2;
            this.minWebSocketMessageToCompress = 1024;
        }

        public Builder(okhttp3.OkHttpClient okHttpClient) {
            n.f(okHttpClient, "okHttpClient");
            super();
            this.dispatcher = okHttpClient.dispatcher();
            this.connectionPool = okHttpClient.connectionPool();
            p.y(this.interceptors, okHttpClient.interceptors());
            p.y(this.networkInterceptors, okHttpClient.networkInterceptors());
            this.eventListenerFactory = okHttpClient.eventListenerFactory();
            this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure();
            this.authenticator = okHttpClient.authenticator();
            this.followRedirects = okHttpClient.followRedirects();
            this.followSslRedirects = okHttpClient.followSslRedirects();
            this.cookieJar = okHttpClient.cookieJar();
            this.cache = okHttpClient.cache();
            this.dns = okHttpClient.dns();
            this.proxy = okHttpClient.proxy();
            this.proxySelector = okHttpClient.proxySelector();
            this.proxyAuthenticator = okHttpClient.proxyAuthenticator();
            this.socketFactory = okHttpClient.socketFactory();
            this.sslSocketFactoryOrNull = OkHttpClient.access$getSslSocketFactoryOrNull$p(okHttpClient);
            this.x509TrustManagerOrNull = okHttpClient.x509TrustManager();
            this.connectionSpecs = okHttpClient.connectionSpecs();
            this.protocols = okHttpClient.protocols();
            this.hostnameVerifier = okHttpClient.hostnameVerifier();
            this.certificatePinner = okHttpClient.certificatePinner();
            this.certificateChainCleaner = okHttpClient.certificateChainCleaner();
            this.callTimeout = okHttpClient.callTimeoutMillis();
            this.connectTimeout = okHttpClient.connectTimeoutMillis();
            this.readTimeout = okHttpClient.readTimeoutMillis();
            this.writeTimeout = okHttpClient.writeTimeoutMillis();
            this.pingInterval = okHttpClient.pingIntervalMillis();
            this.minWebSocketMessageToCompress = okHttpClient.minWebSocketMessageToCompress();
            this.routeDatabase = okHttpClient.getRouteDatabase();
        }

        public final okhttp3.OkHttpClient.Builder -addInterceptor(l<? super okhttp3.Interceptor.Chain, okhttp3.Response> l) {
            n.f(l, "block");
            OkHttpClient.Builder.addInterceptor.2 anon = new OkHttpClient.Builder.addInterceptor.2(l);
            return addInterceptor(anon);
        }

        public final okhttp3.OkHttpClient.Builder -addNetworkInterceptor(l<? super okhttp3.Interceptor.Chain, okhttp3.Response> l) {
            n.f(l, "block");
            OkHttpClient.Builder.addNetworkInterceptor.2 anon = new OkHttpClient.Builder.addNetworkInterceptor.2(l);
            return addNetworkInterceptor(anon);
        }

        public final okhttp3.OkHttpClient.Builder addInterceptor(okhttp3.Interceptor interceptor) {
            n.f(interceptor, "interceptor");
            this.interceptors.add(interceptor);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder addNetworkInterceptor(okhttp3.Interceptor interceptor) {
            n.f(interceptor, "interceptor");
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder authenticator(okhttp3.Authenticator authenticator) {
            n.f(authenticator, "authenticator");
            this.authenticator = authenticator;
            return this;
        }

        public final okhttp3.OkHttpClient build() {
            OkHttpClient okHttpClient = new OkHttpClient(this);
            return okHttpClient;
        }

        public final okhttp3.OkHttpClient.Builder cache(okhttp3.Cache cache) {
            this.cache = cache;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder callTimeout(long l, TimeUnit timeUnit2) {
            n.f(obj4, "unit");
            this.callTimeout = Util.checkDuration("timeout", l, timeUnit2);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder callTimeout(Duration duration) {
            n.f(duration, "duration");
            callTimeout(duration.toMillis(), obj1);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder certificatePinner(okhttp3.CertificatePinner certificatePinner) {
            int i;
            n.f(certificatePinner, "certificatePinner");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.certificatePinner = certificatePinner;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder connectTimeout(long l, TimeUnit timeUnit2) {
            n.f(obj4, "unit");
            this.connectTimeout = Util.checkDuration("timeout", l, timeUnit2);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder connectTimeout(Duration duration) {
            n.f(duration, "duration");
            connectTimeout(duration.toMillis(), obj1);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder connectionPool(okhttp3.ConnectionPool connectionPool) {
            n.f(connectionPool, "connectionPool");
            this.connectionPool = connectionPool;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder connectionSpecs(List<okhttp3.ConnectionSpec> list) {
            int i;
            n.f(list, "connectionSpecs");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.connectionSpecs = Util.toImmutableList(list);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder cookieJar(okhttp3.CookieJar cookieJar) {
            n.f(cookieJar, "cookieJar");
            this.cookieJar = cookieJar;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder dispatcher(okhttp3.Dispatcher dispatcher) {
            n.f(dispatcher, "dispatcher");
            this.dispatcher = dispatcher;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder dns(okhttp3.Dns dns) {
            int i;
            n.f(dns, "dns");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.dns = dns;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder eventListener(okhttp3.EventListener eventListener) {
            n.f(eventListener, "eventListener");
            this.eventListenerFactory = Util.asFactory(eventListener);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder eventListenerFactory(okhttp3.EventListener.Factory eventListener$Factory) {
            n.f(factory, "eventListenerFactory");
            this.eventListenerFactory = factory;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public final okhttp3.Authenticator getAuthenticator$okhttp() {
            return this.authenticator;
        }

        public final okhttp3.Cache getCache$okhttp() {
            return this.cache;
        }

        public final int getCallTimeout$okhttp() {
            return this.callTimeout;
        }

        public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
            return this.certificateChainCleaner;
        }

        public final okhttp3.CertificatePinner getCertificatePinner$okhttp() {
            return this.certificatePinner;
        }

        public final int getConnectTimeout$okhttp() {
            return this.connectTimeout;
        }

        public final okhttp3.ConnectionPool getConnectionPool$okhttp() {
            return this.connectionPool;
        }

        public final List<okhttp3.ConnectionSpec> getConnectionSpecs$okhttp() {
            return this.connectionSpecs;
        }

        public final okhttp3.CookieJar getCookieJar$okhttp() {
            return this.cookieJar;
        }

        public final okhttp3.Dispatcher getDispatcher$okhttp() {
            return this.dispatcher;
        }

        public final okhttp3.Dns getDns$okhttp() {
            return this.dns;
        }

        public final okhttp3.EventListener.Factory getEventListenerFactory$okhttp() {
            return this.eventListenerFactory;
        }

        public final boolean getFollowRedirects$okhttp() {
            return this.followRedirects;
        }

        public final boolean getFollowSslRedirects$okhttp() {
            return this.followSslRedirects;
        }

        public final HostnameVerifier getHostnameVerifier$okhttp() {
            return this.hostnameVerifier;
        }

        public final List<okhttp3.Interceptor> getInterceptors$okhttp() {
            return this.interceptors;
        }

        public final long getMinWebSocketMessageToCompress$okhttp() {
            return this.minWebSocketMessageToCompress;
        }

        public final List<okhttp3.Interceptor> getNetworkInterceptors$okhttp() {
            return this.networkInterceptors;
        }

        public final int getPingInterval$okhttp() {
            return this.pingInterval;
        }

        public final List<okhttp3.Protocol> getProtocols$okhttp() {
            return this.protocols;
        }

        public final Proxy getProxy$okhttp() {
            return this.proxy;
        }

        public final okhttp3.Authenticator getProxyAuthenticator$okhttp() {
            return this.proxyAuthenticator;
        }

        public final ProxySelector getProxySelector$okhttp() {
            return this.proxySelector;
        }

        public final int getReadTimeout$okhttp() {
            return this.readTimeout;
        }

        public final boolean getRetryOnConnectionFailure$okhttp() {
            return this.retryOnConnectionFailure;
        }

        public final RouteDatabase getRouteDatabase$okhttp() {
            return this.routeDatabase;
        }

        public final SocketFactory getSocketFactory$okhttp() {
            return this.socketFactory;
        }

        public final SSLSocketFactory getSslSocketFactoryOrNull$okhttp() {
            return this.sslSocketFactoryOrNull;
        }

        public final int getWriteTimeout$okhttp() {
            return this.writeTimeout;
        }

        public final X509TrustManager getX509TrustManagerOrNull$okhttp() {
            return this.x509TrustManagerOrNull;
        }

        public final okhttp3.OkHttpClient.Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            int i;
            n.f(hostnameVerifier, "hostnameVerifier");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        public final List<okhttp3.Interceptor> interceptors() {
            return this.interceptors;
        }

        public final okhttp3.OkHttpClient.Builder minWebSocketMessageToCompress(long l) {
            int i;
            i = Long.compare(l, i2) >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.minWebSocketMessageToCompress = l;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("minWebSocketMessageToCompress must be positive: ");
            stringBuilder.append(l);
            IllegalArgumentException obj4 = new IllegalArgumentException(stringBuilder.toString().toString());
            throw obj4;
        }

        public final List<okhttp3.Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public final okhttp3.OkHttpClient.Builder pingInterval(long l, TimeUnit timeUnit2) {
            n.f(obj4, "unit");
            this.pingInterval = Util.checkDuration("interval", l, timeUnit2);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder pingInterval(Duration duration) {
            n.f(duration, "duration");
            pingInterval(duration.toMillis(), obj1);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder protocols(List<? extends okhttp3.Protocol> list) {
            int contains2;
            boolean contains;
            int i;
            int i2;
            n.f(list, "protocols");
            List obj5 = p.N0(list);
            okhttp3.Protocol h2_PRIOR_KNOWLEDGE = Protocol.H2_PRIOR_KNOWLEDGE;
            final int i7 = 1;
            if (!obj5.contains(h2_PRIOR_KNOWLEDGE)) {
                if (obj5.contains(Protocol.HTTP_1_1)) {
                    i = i7;
                } else {
                    i = i2;
                }
            } else {
            }
            if (i == 0) {
            } else {
                if (obj5.contains(h2_PRIOR_KNOWLEDGE)) {
                    if (obj5.size() <= i7) {
                        i2 = i7;
                    }
                } else {
                }
                if (i2 == 0) {
                } else {
                    if (contains3 ^= i7 == 0) {
                    } else {
                        Objects.requireNonNull(obj5, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
                        int i4 = 0;
                        if (contains4 ^= i7 == 0) {
                        } else {
                            obj5.remove(Protocol.SPDY_3);
                            if (z ^= i7 != 0) {
                                this.routeDatabase = i4;
                            }
                            obj5 = Collections.unmodifiableList(obj5);
                            n.e(obj5, "Collections.unmodifiableList(protocolsCopy)");
                            this.protocols = obj5;
                            return this;
                        }
                        obj5 = new IllegalArgumentException("protocols must not contain null".toString());
                        throw obj5;
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("protocols must not contain http/1.0: ");
                    stringBuilder2.append(obj5);
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString().toString());
                    throw illegalArgumentException2;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("protocols containing h2_prior_knowledge cannot use other protocols: ");
                stringBuilder.append(obj5);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
                throw illegalArgumentException;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("protocols must contain h2_prior_knowledge or http/1.1: ");
            stringBuilder3.append(obj5);
            IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder3.toString().toString());
            throw illegalArgumentException3;
        }

        public final okhttp3.OkHttpClient.Builder proxy(Proxy proxy) {
            int i;
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.proxy = proxy;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder proxyAuthenticator(okhttp3.Authenticator authenticator) {
            int i;
            n.f(authenticator, "proxyAuthenticator");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.proxyAuthenticator = authenticator;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder proxySelector(ProxySelector proxySelector) {
            int i;
            n.f(proxySelector, "proxySelector");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.proxySelector = proxySelector;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder readTimeout(long l, TimeUnit timeUnit2) {
            n.f(obj4, "unit");
            this.readTimeout = Util.checkDuration("timeout", l, timeUnit2);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder readTimeout(Duration duration) {
            n.f(duration, "duration");
            readTimeout(duration.toMillis(), obj1);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public final void setAuthenticator$okhttp(okhttp3.Authenticator authenticator) {
            n.f(authenticator, "<set-?>");
            this.authenticator = authenticator;
        }

        public final void setCache$okhttp(okhttp3.Cache cache) {
            this.cache = cache;
        }

        public final void setCallTimeout$okhttp(int i) {
            this.callTimeout = i;
        }

        public final void setCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
            this.certificateChainCleaner = certificateChainCleaner;
        }

        public final void setCertificatePinner$okhttp(okhttp3.CertificatePinner certificatePinner) {
            n.f(certificatePinner, "<set-?>");
            this.certificatePinner = certificatePinner;
        }

        public final void setConnectTimeout$okhttp(int i) {
            this.connectTimeout = i;
        }

        public final void setConnectionPool$okhttp(okhttp3.ConnectionPool connectionPool) {
            n.f(connectionPool, "<set-?>");
            this.connectionPool = connectionPool;
        }

        public final void setConnectionSpecs$okhttp(List<okhttp3.ConnectionSpec> list) {
            n.f(list, "<set-?>");
            this.connectionSpecs = list;
        }

        public final void setCookieJar$okhttp(okhttp3.CookieJar cookieJar) {
            n.f(cookieJar, "<set-?>");
            this.cookieJar = cookieJar;
        }

        public final void setDispatcher$okhttp(okhttp3.Dispatcher dispatcher) {
            n.f(dispatcher, "<set-?>");
            this.dispatcher = dispatcher;
        }

        public final void setDns$okhttp(okhttp3.Dns dns) {
            n.f(dns, "<set-?>");
            this.dns = dns;
        }

        public final void setEventListenerFactory$okhttp(okhttp3.EventListener.Factory eventListener$Factory) {
            n.f(factory, "<set-?>");
            this.eventListenerFactory = factory;
        }

        public final void setFollowRedirects$okhttp(boolean z) {
            this.followRedirects = z;
        }

        public final void setFollowSslRedirects$okhttp(boolean z) {
            this.followSslRedirects = z;
        }

        public final void setHostnameVerifier$okhttp(HostnameVerifier hostnameVerifier) {
            n.f(hostnameVerifier, "<set-?>");
            this.hostnameVerifier = hostnameVerifier;
        }

        public final void setMinWebSocketMessageToCompress$okhttp(long l) {
            this.minWebSocketMessageToCompress = l;
        }

        public final void setPingInterval$okhttp(int i) {
            this.pingInterval = i;
        }

        public final void setProtocols$okhttp(List<? extends okhttp3.Protocol> list) {
            n.f(list, "<set-?>");
            this.protocols = list;
        }

        public final void setProxy$okhttp(Proxy proxy) {
            this.proxy = proxy;
        }

        public final void setProxyAuthenticator$okhttp(okhttp3.Authenticator authenticator) {
            n.f(authenticator, "<set-?>");
            this.proxyAuthenticator = authenticator;
        }

        public final void setProxySelector$okhttp(ProxySelector proxySelector) {
            this.proxySelector = proxySelector;
        }

        public final void setReadTimeout$okhttp(int i) {
            this.readTimeout = i;
        }

        public final void setRetryOnConnectionFailure$okhttp(boolean z) {
            this.retryOnConnectionFailure = z;
        }

        public final void setRouteDatabase$okhttp(RouteDatabase routeDatabase) {
            this.routeDatabase = routeDatabase;
        }

        public final void setSocketFactory$okhttp(SocketFactory socketFactory) {
            n.f(socketFactory, "<set-?>");
            this.socketFactory = socketFactory;
        }

        public final void setSslSocketFactoryOrNull$okhttp(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactoryOrNull = sSLSocketFactory;
        }

        public final void setWriteTimeout$okhttp(int i) {
            this.writeTimeout = i;
        }

        public final void setX509TrustManagerOrNull$okhttp(X509TrustManager x509TrustManager) {
            this.x509TrustManagerOrNull = x509TrustManager;
        }

        public final okhttp3.OkHttpClient.Builder socketFactory(SocketFactory socketFactory) {
            int i;
            n.f(socketFactory, "socketFactory");
            if (z ^= 1 == 0) {
            } else {
                if (z2 ^= 1 != 0) {
                    this.routeDatabase = 0;
                }
                this.socketFactory = socketFactory;
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("socketFactory instanceof SSLSocketFactory".toString());
            throw obj2;
        }

        public final okhttp3.OkHttpClient.Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            int i;
            n.f(sSLSocketFactory, "sslSocketFactory");
            if (z ^= 1 != 0) {
                this.routeDatabase = 0;
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            Platform.Companion companion = Platform.Companion;
            X509TrustManager trustManager = companion.get().trustManager(sSLSocketFactory);
            if (trustManager == null) {
            } else {
                this.x509TrustManagerOrNull = trustManager;
                X509TrustManager x509TrustManagerOrNull = this.x509TrustManagerOrNull;
                n.d(x509TrustManagerOrNull);
                this.certificateChainCleaner = companion.get().buildCertificateChainCleaner(x509TrustManagerOrNull);
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unable to extract the trust manager on ");
            stringBuilder.append(companion.get());
            stringBuilder.append(", ");
            stringBuilder.append("sslSocketFactory is ");
            stringBuilder.append(sSLSocketFactory.getClass());
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }

        public final okhttp3.OkHttpClient.Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager2) {
            int i;
            n.f(sSLSocketFactory, "sslSocketFactory");
            n.f(x509TrustManager2, "trustManager");
            if (z ^= 1 == 0) {
                if (z2 ^= 1 != 0) {
                    this.routeDatabase = 0;
                }
            } else {
            }
            this.sslSocketFactoryOrNull = sSLSocketFactory;
            this.certificateChainCleaner = CertificateChainCleaner.Companion.get(x509TrustManager2);
            this.x509TrustManagerOrNull = x509TrustManager2;
            return this;
        }

        public final okhttp3.OkHttpClient.Builder writeTimeout(long l, TimeUnit timeUnit2) {
            n.f(obj4, "unit");
            this.writeTimeout = Util.checkDuration("timeout", l, timeUnit2);
            return this;
        }

        public final okhttp3.OkHttpClient.Builder writeTimeout(Duration duration) {
            n.f(duration, "duration");
            writeTimeout(duration.toMillis(), obj1);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cR\"\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007R\"\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00028\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\t\u0010\u0005\u001a\u0004\u0008\n\u0010\u0007¨\u0006\r", d2 = {"Lokhttp3/OkHttpClient$Companion;", "", "", "Lokhttp3/ConnectionSpec;", "DEFAULT_CONNECTION_SPECS", "Ljava/util/List;", "getDEFAULT_CONNECTION_SPECS$okhttp", "()Ljava/util/List;", "Lokhttp3/Protocol;", "DEFAULT_PROTOCOLS", "getDEFAULT_PROTOCOLS$okhttp", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final List<okhttp3.ConnectionSpec> getDEFAULT_CONNECTION_SPECS$okhttp() {
            return OkHttpClient.access$getDEFAULT_CONNECTION_SPECS$cp();
        }

        public final List<okhttp3.Protocol> getDEFAULT_PROTOCOLS$okhttp() {
            return OkHttpClient.access$getDEFAULT_PROTOCOLS$cp();
        }
    }
    static {
        OkHttpClient.Companion companion = new OkHttpClient.Companion(0);
        OkHttpClient.Companion = companion;
        int i = 2;
        okhttp3.Protocol[] arr2 = new Protocol[i];
        final int i3 = 0;
        arr2[i3] = Protocol.HTTP_2;
        final int i4 = 1;
        arr2[i4] = Protocol.HTTP_1_1;
        OkHttpClient.DEFAULT_PROTOCOLS = Util.immutableListOf(arr2);
        okhttp3.ConnectionSpec[] arr = new ConnectionSpec[i];
        arr[i3] = ConnectionSpec.MODERN_TLS;
        arr[i4] = ConnectionSpec.CLEARTEXT;
        OkHttpClient.DEFAULT_CONNECTION_SPECS = Util.immutableListOf(arr);
    }

    public OkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        super(builder);
    }

    public OkHttpClient(okhttp3.OkHttpClient.Builder okHttpClient$Builder) {
        ProxySelector proxySelector$okhttp;
        Object connectionSpecs$okhttp;
        RouteDatabase routeDatabase$okhttp;
        boolean platformTrustManager;
        int i;
        okhttp3.CertificatePinner obj4;
        n.f(builder, "builder");
        super();
        this.dispatcher = builder.getDispatcher$okhttp();
        this.connectionPool = builder.getConnectionPool$okhttp();
        this.interceptors = Util.toImmutableList(builder.getInterceptors$okhttp());
        this.networkInterceptors = Util.toImmutableList(builder.getNetworkInterceptors$okhttp());
        this.eventListenerFactory = builder.getEventListenerFactory$okhttp();
        this.retryOnConnectionFailure = builder.getRetryOnConnectionFailure$okhttp();
        this.authenticator = builder.getAuthenticator$okhttp();
        this.followRedirects = builder.getFollowRedirects$okhttp();
        this.followSslRedirects = builder.getFollowSslRedirects$okhttp();
        this.cookieJar = builder.getCookieJar$okhttp();
        this.cache = builder.getCache$okhttp();
        this.dns = builder.getDns$okhttp();
        this.proxy = builder.getProxy$okhttp();
        if (builder.getProxy$okhttp() != null) {
            proxySelector$okhttp = NullProxySelector.INSTANCE;
        } else {
            if (builder.getProxySelector$okhttp() != null) {
            } else {
                proxySelector$okhttp = ProxySelector.getDefault();
            }
            if (proxySelector$okhttp != null) {
            } else {
                proxySelector$okhttp = NullProxySelector.INSTANCE;
            }
        }
        this.proxySelector = proxySelector$okhttp;
        this.proxyAuthenticator = builder.getProxyAuthenticator$okhttp();
        this.socketFactory = builder.getSocketFactory$okhttp();
        connectionSpecs$okhttp = builder.getConnectionSpecs$okhttp();
        this.connectionSpecs = connectionSpecs$okhttp;
        this.protocols = builder.getProtocols$okhttp();
        this.hostnameVerifier = builder.getHostnameVerifier$okhttp();
        this.callTimeoutMillis = builder.getCallTimeout$okhttp();
        this.connectTimeoutMillis = builder.getConnectTimeout$okhttp();
        this.readTimeoutMillis = builder.getReadTimeout$okhttp();
        this.writeTimeoutMillis = builder.getWriteTimeout$okhttp();
        this.pingIntervalMillis = builder.getPingInterval$okhttp();
        this.minWebSocketMessageToCompress = builder.getMinWebSocketMessageToCompress$okhttp();
        if (builder.getRouteDatabase$okhttp() != null) {
        } else {
            routeDatabase$okhttp = new RouteDatabase();
        }
        this.routeDatabase = routeDatabase$okhttp;
        i = 1;
        if (connectionSpecs$okhttp instanceof Collection != null && connectionSpecs$okhttp.isEmpty()) {
            if (connectionSpecs$okhttp.isEmpty()) {
            } else {
                connectionSpecs$okhttp = connectionSpecs$okhttp.iterator();
                while (connectionSpecs$okhttp.hasNext()) {
                    if ((ConnectionSpec)connectionSpecs$okhttp.next().isTls()) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        if (i != 0) {
            obj4 = 0;
            this.sslSocketFactoryOrNull = obj4;
            this.certificateChainCleaner = obj4;
            this.x509TrustManager = obj4;
            this.certificatePinner = CertificatePinner.DEFAULT;
        } else {
            if (builder.getSslSocketFactoryOrNull$okhttp() != null) {
                this.sslSocketFactoryOrNull = builder.getSslSocketFactoryOrNull$okhttp();
                connectionSpecs$okhttp = builder.getCertificateChainCleaner$okhttp();
                n.d(connectionSpecs$okhttp);
                this.certificateChainCleaner = connectionSpecs$okhttp;
                platformTrustManager = builder.getX509TrustManagerOrNull$okhttp();
                n.d(platformTrustManager);
                this.x509TrustManager = platformTrustManager;
                n.d(connectionSpecs$okhttp);
                this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(connectionSpecs$okhttp);
            } else {
                Platform.Companion companion = Platform.Companion;
                platformTrustManager = companion.get().platformTrustManager();
                this.x509TrustManager = platformTrustManager;
                n.d(platformTrustManager);
                this.sslSocketFactoryOrNull = companion.get().newSslSocketFactory(platformTrustManager);
                n.d(platformTrustManager);
                connectionSpecs$okhttp = CertificateChainCleaner.Companion.get(platformTrustManager);
                this.certificateChainCleaner = connectionSpecs$okhttp;
                n.d(connectionSpecs$okhttp);
                this.certificatePinner = builder.getCertificatePinner$okhttp().withCertificateChainCleaner$okhttp(connectionSpecs$okhttp);
            }
        }
        verifyClientState();
    }

    public static final List access$getDEFAULT_CONNECTION_SPECS$cp() {
        return OkHttpClient.DEFAULT_CONNECTION_SPECS;
    }

    public static final List access$getDEFAULT_PROTOCOLS$cp() {
        return OkHttpClient.DEFAULT_PROTOCOLS;
    }

    public static final SSLSocketFactory access$getSslSocketFactoryOrNull$p(okhttp3.OkHttpClient okHttpClient) {
        return okHttpClient.sslSocketFactoryOrNull;
    }

    private final void verifyClientState() {
        int i;
        X509TrustManager x509TrustManager;
        int i2;
        int i3;
        List connectionSpecs;
        boolean empty;
        int dEFAULT;
        int i4;
        List interceptors = this.interceptors;
        String str = "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>";
        Objects.requireNonNull(interceptors, str);
        int i7 = 0;
        i4 = 1;
        if (contains ^= i4 == 0) {
        } else {
            List networkInterceptors = this.networkInterceptors;
            Objects.requireNonNull(networkInterceptors, str);
            if (contains2 ^= i4 == 0) {
            } else {
                connectionSpecs = this.connectionSpecs;
                dEFAULT = 0;
                if (connectionSpecs instanceof Collection != null && connectionSpecs.isEmpty()) {
                    if (connectionSpecs.isEmpty()) {
                        i = i4;
                    } else {
                        connectionSpecs = connectionSpecs.iterator();
                        for (ConnectionSpec next : connectionSpecs) {
                        }
                    }
                } else {
                }
                if (i != 0) {
                    i2 = this.sslSocketFactoryOrNull == null ? i4 : dEFAULT;
                    empty = "Check failed.";
                    if (i2 == 0) {
                    } else {
                        i3 = this.certificateChainCleaner == null ? i4 : dEFAULT;
                        if (i3 == 0) {
                        } else {
                            if (this.x509TrustManager == null) {
                            } else {
                                i4 = dEFAULT;
                            }
                            if (i4 == 0) {
                            } else {
                                if (!n.b(this.certificatePinner, CertificatePinner.DEFAULT)) {
                                } else {
                                }
                                IllegalStateException illegalStateException5 = new IllegalStateException(empty.toString());
                                throw illegalStateException5;
                            }
                            IllegalStateException illegalStateException6 = new IllegalStateException(empty.toString());
                            throw illegalStateException6;
                        }
                        IllegalStateException illegalStateException7 = new IllegalStateException(empty.toString());
                        throw illegalStateException7;
                    }
                    IllegalStateException illegalStateException4 = new IllegalStateException(empty.toString());
                    throw illegalStateException4;
                }
                if (this.sslSocketFactoryOrNull == null) {
                } else {
                    if (this.certificateChainCleaner == null) {
                    } else {
                        if (this.x509TrustManager == null) {
                        } else {
                        }
                        IllegalStateException illegalStateException2 = new IllegalStateException("x509TrustManager == null".toString());
                        throw illegalStateException2;
                    }
                    IllegalStateException illegalStateException3 = new IllegalStateException("certificateChainCleaner == null".toString());
                    throw illegalStateException3;
                }
                IllegalStateException illegalStateException = new IllegalStateException("sslSocketFactory == null".toString());
                throw illegalStateException;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Null network interceptor: ");
            stringBuilder2.append(this.networkInterceptors);
            IllegalStateException illegalStateException9 = new IllegalStateException(stringBuilder2.toString().toString());
            throw illegalStateException9;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Null interceptor: ");
        stringBuilder.append(this.interceptors);
        IllegalStateException illegalStateException8 = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException8;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Authenticator -deprecated_authenticator() {
        return this.authenticator;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Cache -deprecated_cache() {
        return this.cache;
    }

    @Override // java.lang.Cloneable
    public final int -deprecated_callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.CertificatePinner -deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    @Override // java.lang.Cloneable
    public final int -deprecated_connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.ConnectionPool -deprecated_connectionPool() {
        return this.connectionPool;
    }

    public final List<okhttp3.ConnectionSpec> -deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.CookieJar -deprecated_cookieJar() {
        return this.cookieJar;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Dispatcher -deprecated_dispatcher() {
        return this.dispatcher;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Dns -deprecated_dns() {
        return this.dns;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.EventListener.Factory -deprecated_eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Override // java.lang.Cloneable
    public final boolean -deprecated_followRedirects() {
        return this.followRedirects;
    }

    @Override // java.lang.Cloneable
    public final boolean -deprecated_followSslRedirects() {
        return this.followSslRedirects;
    }

    @Override // java.lang.Cloneable
    public final HostnameVerifier -deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<okhttp3.Interceptor> -deprecated_interceptors() {
        return this.interceptors;
    }

    public final List<okhttp3.Interceptor> -deprecated_networkInterceptors() {
        return this.networkInterceptors;
    }

    @Override // java.lang.Cloneable
    public final int -deprecated_pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<okhttp3.Protocol> -deprecated_protocols() {
        return this.protocols;
    }

    @Override // java.lang.Cloneable
    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Authenticator -deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Override // java.lang.Cloneable
    public final ProxySelector -deprecated_proxySelector() {
        return this.proxySelector;
    }

    @Override // java.lang.Cloneable
    public final int -deprecated_readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final boolean -deprecated_retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Override // java.lang.Cloneable
    public final SocketFactory -deprecated_socketFactory() {
        return this.socketFactory;
    }

    @Override // java.lang.Cloneable
    public final SSLSocketFactory -deprecated_sslSocketFactory() {
        return sslSocketFactory();
    }

    @Override // java.lang.Cloneable
    public final int -deprecated_writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Authenticator authenticator() {
        return this.authenticator;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Cache cache() {
        return this.cache;
    }

    @Override // java.lang.Cloneable
    public final int callTimeoutMillis() {
        return this.callTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final CertificateChainCleaner certificateChainCleaner() {
        return this.certificateChainCleaner;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return super.clone();
    }

    @Override // java.lang.Cloneable
    public final int connectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.ConnectionPool connectionPool() {
        return this.connectionPool;
    }

    public final List<okhttp3.ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.CookieJar cookieJar() {
        return this.cookieJar;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Dispatcher dispatcher() {
        return this.dispatcher;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Dns dns() {
        return this.dns;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.EventListener.Factory eventListenerFactory() {
        return this.eventListenerFactory;
    }

    @Override // java.lang.Cloneable
    public final boolean followRedirects() {
        return this.followRedirects;
    }

    @Override // java.lang.Cloneable
    public final boolean followSslRedirects() {
        return this.followSslRedirects;
    }

    @Override // java.lang.Cloneable
    public final RouteDatabase getRouteDatabase() {
        return this.routeDatabase;
    }

    @Override // java.lang.Cloneable
    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<okhttp3.Interceptor> interceptors() {
        return this.interceptors;
    }

    @Override // java.lang.Cloneable
    public final long minWebSocketMessageToCompress() {
        return this.minWebSocketMessageToCompress;
    }

    public final List<okhttp3.Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    @Override // java.lang.Cloneable
    public okhttp3.OkHttpClient.Builder newBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder(this);
        return builder;
    }

    @Override // java.lang.Cloneable
    public okhttp3.Call newCall(okhttp3.Request request) {
        n.f(request, "request");
        RealCall realCall = new RealCall(this, request, 0);
        return realCall;
    }

    @Override // java.lang.Cloneable
    public okhttp3.WebSocket newWebSocket(okhttp3.Request request, okhttp3.WebSocketListener webSocketListener2) {
        n.f(request, "request");
        n.f(webSocketListener2, "listener");
        Random random = new Random();
        super(TaskRunner.INSTANCE, request, webSocketListener2, random, (long)pingIntervalMillis, obj7, 0, this.minWebSocketMessageToCompress, obj10);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    @Override // java.lang.Cloneable
    public final int pingIntervalMillis() {
        return this.pingIntervalMillis;
    }

    public final List<okhttp3.Protocol> protocols() {
        return this.protocols;
    }

    @Override // java.lang.Cloneable
    public final Proxy proxy() {
        return this.proxy;
    }

    @Override // java.lang.Cloneable
    public final okhttp3.Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    @Override // java.lang.Cloneable
    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    @Override // java.lang.Cloneable
    public final int readTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final boolean retryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    @Override // java.lang.Cloneable
    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    @Override // java.lang.Cloneable
    public final SSLSocketFactory sslSocketFactory() {
        SSLSocketFactory sslSocketFactoryOrNull = this.sslSocketFactoryOrNull;
        if (sslSocketFactoryOrNull == null) {
        } else {
            return sslSocketFactoryOrNull;
        }
        IllegalStateException illegalStateException = new IllegalStateException("CLEARTEXT-only client");
        throw illegalStateException;
    }

    @Override // java.lang.Cloneable
    public final int writeTimeoutMillis() {
        return this.writeTimeoutMillis;
    }

    @Override // java.lang.Cloneable
    public final X509TrustManager x509TrustManager() {
        return this.x509TrustManager;
    }
}
