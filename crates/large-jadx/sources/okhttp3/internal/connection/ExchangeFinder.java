package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ErrorCode;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B'\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\u0008>\u0010?J?\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ7\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0008\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u0011\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001d\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0015\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\u0008\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u0007¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\u0008\"\u0010#R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010&R\u0018\u0010'\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008'\u0010(R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008*\u0010+R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008-\u0010.R\u0016\u0010/\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008/\u00100R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00081\u00100R\u0016\u00103\u001a\u0002028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00083\u00104R\u0016\u00106\u001a\u0002058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00086\u00107R\u001c\u00109\u001a\u0002088\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u00089\u0010:\u001a\u0004\u0008;\u0010<R\u0016\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008=\u00100¨\u0006@", d2 = {"Lokhttp3/internal/connection/ExchangeFinder;", "", "", "connectTimeout", "readTimeout", "writeTimeout", "pingIntervalMillis", "", "connectionRetryEnabled", "doExtensiveHealthChecks", "Lokhttp3/internal/connection/RealConnection;", "findHealthyConnection", "(IIIIZZ)Lokhttp3/internal/connection/RealConnection;", "findConnection", "(IIIIZ)Lokhttp3/internal/connection/RealConnection;", "Lokhttp3/Route;", "retryRoute", "()Lokhttp3/Route;", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/internal/http/RealInterceptorChain;", "chain", "Lokhttp3/internal/http/ExchangeCodec;", "find", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/http/RealInterceptorChain;)Lokhttp3/internal/http/ExchangeCodec;", "Ljava/io/IOException;", "e", "Lkotlin/w;", "trackFailure", "(Ljava/io/IOException;)V", "retryAfterFailure", "()Z", "Lokhttp3/HttpUrl;", "url", "sameHostAndPort", "(Lokhttp3/HttpUrl;)Z", "Lokhttp3/internal/connection/RealCall;", "call", "Lokhttp3/internal/connection/RealCall;", "nextRouteToTry", "Lokhttp3/Route;", "Lokhttp3/internal/connection/RouteSelector$Selection;", "routeSelection", "Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/internal/connection/RouteSelector;", "routeSelector", "Lokhttp3/internal/connection/RouteSelector;", "connectionShutdownCount", "I", "refusedStreamCount", "Lokhttp3/internal/connection/RealConnectionPool;", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "Lokhttp3/Address;", "address", "Lokhttp3/Address;", "getAddress$okhttp", "()Lokhttp3/Address;", "otherFailureCount", "<init>", "(Lokhttp3/internal/connection/RealConnectionPool;Lokhttp3/Address;Lokhttp3/internal/connection/RealCall;Lokhttp3/EventListener;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ExchangeFinder {

    private final Address address;
    private final okhttp3.internal.connection.RealCall call;
    private final okhttp3.internal.connection.RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private okhttp3.internal.connection.RouteSelector.Selection routeSelection;
    private okhttp3.internal.connection.RouteSelector routeSelector;
    public ExchangeFinder(okhttp3.internal.connection.RealConnectionPool realConnectionPool, Address address2, okhttp3.internal.connection.RealCall realCall3, EventListener eventListener4) {
        n.f(realConnectionPool, "connectionPool");
        n.f(address2, "address");
        n.f(realCall3, "call");
        n.f(eventListener4, "eventListener");
        super();
        this.connectionPool = realConnectionPool;
        this.address = address2;
        this.call = realCall3;
        this.eventListener = eventListener4;
    }

    private final okhttp3.internal.connection.RealConnection findConnection(int i, int i2, int i3, int i4, boolean z5) {
        int i5;
        Route nextRouteToTry;
        okhttp3.internal.connection.RouteSelector.Selection routeSelection;
        okhttp3.internal.connection.RouteSelector routeSelector;
        int callAcquirePooledConnection;
        EventListener eventListener;
        Address address2;
        int routes;
        boolean sameHostAndPort;
        int releaseConnectionNoEvents$okhttp;
        okhttp3.internal.connection.RealCall call;
        Object connectionPool;
        okhttp3.internal.connection.RealCall address;
        EventListener eventListener2;
        final Object obj = this;
        if (obj.call.isCanceled()) {
        } else {
            okhttp3.internal.connection.RealConnection connection4 = obj.call.getConnection();
            callAcquirePooledConnection = 0;
            int i6 = 0;
            if (connection4 != null) {
                synchronized (connection4) {
                    if (!sameHostAndPort(connection4.route().address().url())) {
                        releaseConnectionNoEvents$okhttp = obj.call.releaseConnectionNoEvents$okhttp();
                    } else {
                        releaseConnectionNoEvents$okhttp = i6;
                    }
                    w wVar2 = w.a;
                    if (obj.call.getConnection() != null) {
                    }
                    if (releaseConnectionNoEvents$okhttp != 0) {
                        Util.closeQuietly(releaseConnectionNoEvents$okhttp);
                    }
                    obj.eventListener.connectionReleased(obj.call, connection4);
                }
                if (releaseConnectionNoEvents$okhttp == 0) {
                } else {
                    i5 = callAcquirePooledConnection;
                }
                if (i5 == 0) {
                } else {
                    return connection4;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Check failed.".toString());
                throw illegalStateException;
            }
            obj.refusedStreamCount = callAcquirePooledConnection;
            obj.connectionShutdownCount = callAcquirePooledConnection;
            obj.otherFailureCount = callAcquirePooledConnection;
            if (obj.connectionPool.callAcquirePooledConnection(obj.address, obj.call, i6, callAcquirePooledConnection)) {
                okhttp3.internal.connection.RealConnection connection3 = obj.call.getConnection();
                n.d(connection3);
                obj.eventListener.connectionAcquired(obj.call, connection3);
                return connection3;
            }
            nextRouteToTry = obj.nextRouteToTry;
            if (nextRouteToTry != null) {
                try {
                    n.d(nextRouteToTry);
                    obj.nextRouteToTry = i6;
                    routes = i6;
                    routeSelection = obj.routeSelection;
                    if (routeSelection != null) {
                    } else {
                    }
                    n.d(routeSelection);
                    if (routeSelection.hasNext()) {
                    } else {
                    }
                    okhttp3.internal.connection.RouteSelector.Selection routeSelection2 = obj.routeSelection;
                    n.d(routeSelection2);
                    nextRouteToTry = routeSelection2.next();
                    if (obj.routeSelector == null) {
                    }
                    routeSelector = new RouteSelector(obj.address, obj.call.getClient().getRouteDatabase(), obj.call, obj.eventListener);
                    obj.routeSelector = routeSelector;
                    okhttp3.internal.connection.RouteSelector.Selection next = routeSelector.next();
                    obj.routeSelection = next;
                    if (obj.call.isCanceled()) {
                    } else {
                    }
                    if (obj.connectionPool.callAcquirePooledConnection(obj.address, obj.call, next.getRoutes(), callAcquirePooledConnection)) {
                    }
                    okhttp3.internal.connection.RealConnection connection = obj.call.getConnection();
                    n.d(connection);
                    obj.eventListener.connectionAcquired(obj.call, connection);
                    return connection;
                    nextRouteToTry = next.next();
                    RealConnection realConnection = new RealConnection(obj.connectionPool, nextRouteToTry);
                    obj.call.setConnectionToCancel(realConnection);
                    realConnection.connect(i, i2, i3, i4, z5, obj.call, obj.eventListener);
                    obj.call.setConnectionToCancel(i6);
                    obj.call.getClient().getRouteDatabase().connected(realConnection.route());
                    if (obj.connectionPool.callAcquirePooledConnection(obj.address, obj.call, routes, true)) {
                    }
                    okhttp3.internal.connection.RealConnection connection2 = obj.call.getConnection();
                    n.d(connection2);
                    obj.nextRouteToTry = nextRouteToTry;
                    Util.closeQuietly(realConnection.socket());
                    obj.eventListener.connectionAcquired(obj.call, connection2);
                    return connection2;
                    obj.connectionPool.put(realConnection);
                    obj.call.acquireConnectionNoEvents(realConnection);
                    w wVar = w.a;
                    obj.eventListener.connectionAcquired(obj.call, realConnection);
                    return realConnection;
                    throw th;
                    okhttp3.internal.connection.RealCall call8 = obj1.call;
                    call8.setConnectionToCancel(obj4);
                    throw th;
                    IOException iOException = new IOException("Canceled");
                    throw iOException;
                    IOException iOException2 = new IOException("Canceled");
                    throw iOException2;
                } catch (Throwable th) {
                }
            } else {
            }
        }
    }

    private final okhttp3.internal.connection.RealConnection findHealthyConnection(int i, int i2, int i3, int i4, boolean z5, boolean z6) {
        Route nextRouteToTry;
        boolean healthy;
        okhttp3.internal.connection.RealConnection connection = findConnection(i, i2, i3, i4, z5);
        while (connection.isHealthy(z6)) {
            connection.noNewExchanges$okhttp();
            okhttp3.internal.connection.RouteSelector.Selection routeSelection = this.routeSelection;
            if (routeSelection != null) {
            } else {
            }
            nextRouteToTry = healthy;
            nextRouteToTry = this.routeSelector;
            if (nextRouteToTry != null) {
            }
            connection = findConnection(i, i2, i3, i4, z5);
            healthy = nextRouteToTry.hasNext();
            nextRouteToTry = routeSelection.hasNext();
        }
        return connection;
    }

    private final Route retryRoute() {
        int connectionShutdownCount;
        int i = 1;
        final int i2 = 0;
        if (this.refusedStreamCount <= i && this.connectionShutdownCount <= i) {
            if (this.connectionShutdownCount <= i) {
                if (this.otherFailureCount > 0) {
                } else {
                    connectionShutdownCount = this.call.getConnection();
                    if (connectionShutdownCount != null && connectionShutdownCount.getRouteFailureCount$okhttp() != 0) {
                        synchronized (connectionShutdownCount) {
                            return i2;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public final ExchangeCodec find(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain2) {
        n.f(okHttpClient, "client");
        n.f(realInterceptorChain2, "chain");
        return this.findHealthyConnection(realInterceptorChain2.getConnectTimeoutMillis$okhttp(), realInterceptorChain2.getReadTimeoutMillis$okhttp(), realInterceptorChain2.getWriteTimeoutMillis$okhttp(), okHttpClient.pingIntervalMillis(), okHttpClient.retryOnConnectionFailure(), z ^ 1).newCodec$okhttp(okHttpClient, realInterceptorChain2);
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        int connectionShutdownCount;
        okhttp3.internal.connection.RouteSelector.Selection routeSelection;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            if (this.connectionShutdownCount == 0) {
                if (this.otherFailureCount == 0) {
                    return 0;
                }
            }
        }
        final int i2 = 1;
        if (this.nextRouteToTry != null) {
            return i2;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return i2;
        }
        routeSelection = this.routeSelection;
        if (routeSelection != null && routeSelection.hasNext() == i2) {
            if (routeSelection.hasNext() == i2) {
                return i2;
            }
        }
        okhttp3.internal.connection.RouteSelector routeSelector = this.routeSelector;
        if (routeSelector != null) {
            return routeSelector.hasNext();
        }
        return i2;
    }

    public final boolean sameHostAndPort(HttpUrl httpUrl) {
        Object host;
        Object obj4;
        n.f(httpUrl, "url");
        host = this.address.url();
        if (httpUrl.port() == host.port() && n.b(httpUrl.host(), host.host())) {
            obj4 = n.b(httpUrl.host(), host.host()) ? 1 : 0;
        } else {
        }
        return obj4;
    }

    public final void trackFailure(IOException iOException) {
        boolean errorCode;
        ErrorCode rEFUSED_STREAM;
        int obj3;
        n.f(iOException, "e");
        this.nextRouteToTry = 0;
        if (iOException instanceof StreamResetException != null && obj.errorCode == ErrorCode.REFUSED_STREAM) {
            if (obj.errorCode == ErrorCode.REFUSED_STREAM) {
                this.refusedStreamCount = obj3++;
            } else {
                if (iOException instanceof ConnectionShutdownException != null) {
                    this.connectionShutdownCount = obj3++;
                } else {
                    this.otherFailureCount = obj3++;
                }
            }
        } else {
        }
    }
}
