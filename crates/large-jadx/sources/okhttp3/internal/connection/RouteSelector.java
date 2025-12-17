package okhttp3.internal.connection;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 -2\u00020\u0001:\u0002-.B'\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\u0008+\u0010,J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u000f\u0010\u000c\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\u0008\u0010\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u0011H\u0086\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001cR\u001c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\"\u0010#R\u001c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00040$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008%\u0010 R\u001c\u0010'\u001a\u0008\u0012\u0004\u0012\u00020&0$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008'\u0010 R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008)\u0010*¨\u0006/", d2 = {"Lokhttp3/internal/connection/RouteSelector;", "", "Lokhttp3/HttpUrl;", "url", "Ljava/net/Proxy;", "proxy", "Lkotlin/w;", "resetNextProxy", "(Lokhttp3/HttpUrl;Ljava/net/Proxy;)V", "", "hasNextProxy", "()Z", "nextProxy", "()Ljava/net/Proxy;", "resetNextInetSocketAddress", "(Ljava/net/Proxy;)V", "hasNext", "Lokhttp3/internal/connection/RouteSelector$Selection;", "next", "()Lokhttp3/internal/connection/RouteSelector$Selection;", "Lokhttp3/Address;", "address", "Lokhttp3/Address;", "", "nextProxyIndex", "I", "Lokhttp3/Call;", "call", "Lokhttp3/Call;", "", "Lokhttp3/Route;", "postponedRoutes", "Ljava/util/List;", "Lokhttp3/internal/connection/RouteDatabase;", "routeDatabase", "Lokhttp3/internal/connection/RouteDatabase;", "", "proxies", "Ljava/net/InetSocketAddress;", "inetSocketAddresses", "Lokhttp3/EventListener;", "eventListener", "Lokhttp3/EventListener;", "<init>", "(Lokhttp3/Address;Lokhttp3/internal/connection/RouteDatabase;Lokhttp3/Call;Lokhttp3/EventListener;)V", "Companion", "Selection", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RouteSelector {

    public static final okhttp3.internal.connection.RouteSelector.Companion Companion;
    private final Address address;
    private final Call call;
    private final EventListener eventListener;
    private List<? extends InetSocketAddress> inetSocketAddresses;
    private int nextProxyIndex;
    private final List<Route> postponedRoutes;
    private List<? extends Proxy> proxies;
    private final okhttp3.internal.connection.RouteDatabase routeDatabase;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0006\u001a\u00020\u0003*\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\t", d2 = {"Lokhttp3/internal/connection/RouteSelector$Companion;", "", "Ljava/net/InetSocketAddress;", "", "getSocketHost", "(Ljava/net/InetSocketAddress;)Ljava/lang/String;", "socketHost", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final String getSocketHost(InetSocketAddress inetSocketAddress) {
            n.f(inetSocketAddress, "$this$socketHost");
            InetAddress address = inetSocketAddress.getAddress();
            if (address != null) {
                String obj2 = address.getHostAddress();
                n.e(obj2, "address.hostAddress");
                return obj2;
            }
            obj2 = inetSocketAddress.getHostName();
            n.e(obj2, "hostName");
            return obj2;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u000b¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005H\u0086\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\u00088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\t\u0010\nR\u001f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u000b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0012", d2 = {"Lokhttp3/internal/connection/RouteSelector$Selection;", "", "", "hasNext", "()Z", "Lokhttp3/Route;", "next", "()Lokhttp3/Route;", "", "nextRouteIndex", "I", "", "routes", "Ljava/util/List;", "getRoutes", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Selection {

        private int nextRouteIndex;
        private final List<Route> routes;
        public Selection(List<Route> list) {
            n.f(list, "routes");
            super();
            this.routes = list;
        }

        public final List<Route> getRoutes() {
            return this.routes;
        }

        public final boolean hasNext() {
            int i;
            i = this.nextRouteIndex < this.routes.size() ? 1 : 0;
            return i;
        }

        public final Route next() {
            if (!hasNext()) {
            } else {
                final int nextRouteIndex = this.nextRouteIndex;
                this.nextRouteIndex = nextRouteIndex + 1;
                return (Route)this.routes.get(nextRouteIndex);
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }
    static {
        RouteSelector.Companion companion = new RouteSelector.Companion(0);
        RouteSelector.Companion = companion;
    }

    public RouteSelector(Address address, okhttp3.internal.connection.RouteDatabase routeDatabase2, Call call3, EventListener eventListener4) {
        n.f(address, "address");
        n.f(routeDatabase2, "routeDatabase");
        n.f(call3, "call");
        n.f(eventListener4, "eventListener");
        super();
        this.address = address;
        this.routeDatabase = routeDatabase2;
        this.call = call3;
        this.eventListener = eventListener4;
        this.proxies = p.g();
        this.inetSocketAddresses = p.g();
        ArrayList obj3 = new ArrayList();
        this.postponedRoutes = obj3;
        resetNextProxy(address.url(), address.proxy());
    }

    public static final Address access$getAddress$p(okhttp3.internal.connection.RouteSelector routeSelector) {
        return routeSelector.address;
    }

    private final boolean hasNextProxy() {
        int i;
        i = this.nextProxyIndex < this.proxies.size() ? 1 : 0;
        return i;
    }

    private final Proxy nextProxy() {
        if (!hasNextProxy()) {
        } else {
            int nextProxyIndex = this.nextProxyIndex;
            this.nextProxyIndex = nextProxyIndex + 1;
            Object obj = this.proxies.get(nextProxyIndex);
            resetNextInetSocketAddress((Proxy)obj);
            return obj;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("No route to ");
        stringBuilder.append(this.address.url().host());
        stringBuilder.append("; exhausted proxy configurations: ");
        stringBuilder.append(this.proxies);
        SocketException socketException = new SocketException(stringBuilder.toString());
        throw socketException;
    }

    private final void resetNextInetSocketAddress(Proxy proxy) {
        Proxy.Type type;
        int port;
        Proxy.Type dIRECT;
        String socketHost;
        EventListener inetSocketAddress;
        Call call;
        Object obj6;
        ArrayList arrayList = new ArrayList();
        this.inetSocketAddresses = arrayList;
        if (proxy.type() != Proxy.Type.DIRECT) {
            if (proxy.type() == Proxy.Type.SOCKS) {
            } else {
                java.net.SocketAddress address3 = proxy.address();
                if (!address3 instanceof InetSocketAddress) {
                } else {
                    socketHost = RouteSelector.Companion.getSocketHost((InetSocketAddress)address3);
                    port = address3.getPort();
                    if (1 > port) {
                    } else {
                        if (65535 < port) {
                        } else {
                            if (proxy.type() == Proxy.Type.SOCKS) {
                                arrayList.add(InetSocketAddress.createUnresolved(socketHost, port));
                            } else {
                                this.eventListener.dnsStart(this.call, socketHost);
                                obj6 = this.address.dns().lookup(socketHost);
                                if (obj6.isEmpty()) {
                                } else {
                                    this.eventListener.dnsEnd(this.call, socketHost, obj6);
                                    obj6 = obj6.iterator();
                                    for (InetAddress socketHost : obj6) {
                                        inetSocketAddress = new InetSocketAddress(socketHost, port);
                                        arrayList.add(inetSocketAddress);
                                    }
                                }
                            }
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append(this.address.dns());
                            stringBuilder2.append(" returned no addresses for ");
                            stringBuilder2.append(socketHost);
                            obj6 = new UnknownHostException(stringBuilder2.toString());
                            throw obj6;
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("No route to ");
                    stringBuilder.append(socketHost);
                    stringBuilder.append(':');
                    stringBuilder.append(port);
                    stringBuilder.append("; port is out of range");
                    obj6 = new SocketException(stringBuilder.toString());
                    throw obj6;
                }
            }
            obj6 = new StringBuilder();
            obj6.append("Proxy.address() is not an InetSocketAddress: ");
            obj6.append(address3.getClass());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(obj6.toString().toString());
            throw illegalArgumentException;
        }
        socketHost = this.address.url().host();
        port = this.address.url().port();
    }

    private final void resetNextProxy(HttpUrl httpUrl, Proxy proxy2) {
        RouteSelector.resetNextProxy.1 anon = new RouteSelector.resetNextProxy.1(this, proxy2, httpUrl);
        this.eventListener.proxySelectStart(this.call, httpUrl);
        List obj4 = anon.invoke();
        this.proxies = obj4;
        this.nextProxyIndex = 0;
        this.eventListener.proxySelectEnd(this.call, httpUrl, obj4);
    }

    public final boolean hasNext() {
        boolean nextProxy;
        int i;
        if (!hasNextProxy()) {
            if (empty ^= i != 0) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    public final okhttp3.internal.connection.RouteSelector.Selection next() {
        int nextProxy;
        boolean postponedRoutes;
        Iterator iterator;
        boolean postponedRoutes2;
        Route route;
        Address address;
        if (!hasNext()) {
        } else {
            ArrayList arrayList = new ArrayList();
            while (hasNextProxy()) {
                iterator = this.inetSocketAddresses.iterator();
                while (iterator.hasNext()) {
                    route = new Route(this.address, nextProxy(), (InetSocketAddress)iterator.next());
                    if (this.routeDatabase.shouldPostpone(route)) {
                    } else {
                    }
                    arrayList.add(route);
                    this.postponedRoutes.add(route);
                }
                if (empty ^= 1 == 0) {
                }
                route = new Route(this.address, nextProxy2, (InetSocketAddress)iterator.next());
                if (this.routeDatabase.shouldPostpone(route)) {
                } else {
                }
                arrayList.add(route);
                this.postponedRoutes.add(route);
            }
            if (arrayList.isEmpty()) {
                p.y(arrayList, this.postponedRoutes);
                this.postponedRoutes.clear();
            }
            RouteSelector.Selection selection = new RouteSelector.Selection(arrayList);
            return selection;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}
