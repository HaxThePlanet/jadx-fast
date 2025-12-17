package okhttp3.internal.authenticator;

import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;
import okhttp3.Address;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.Route;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0004\u0008\u0013\u0010\u0014J#\u0010\u0008\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ#\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012¨\u0006\u0015", d2 = {"Lokhttp3/internal/authenticator/JavaNetAuthenticator;", "Lokhttp3/Authenticator;", "Ljava/net/Proxy;", "Lokhttp3/HttpUrl;", "url", "Lokhttp3/Dns;", "dns", "Ljava/net/InetAddress;", "connectToInetAddress", "(Ljava/net/Proxy;Lokhttp3/HttpUrl;Lokhttp3/Dns;)Ljava/net/InetAddress;", "Lokhttp3/Route;", "route", "Lokhttp3/Response;", "response", "Lokhttp3/Request;", "authenticate", "(Lokhttp3/Route;Lokhttp3/Response;)Lokhttp3/Request;", "defaultDns", "Lokhttp3/Dns;", "<init>", "(Lokhttp3/Dns;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class JavaNetAuthenticator implements Authenticator {

    private final Dns defaultDns;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public final class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int[] iArr = new int[values.length];
            JavaNetAuthenticator.WhenMappings.$EnumSwitchMapping$0 = iArr;
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        }
    }
    public JavaNetAuthenticator() {
        final int i = 0;
        super(i, 1, i);
    }

    public JavaNetAuthenticator(Dns dns) {
        n.f(dns, "defaultDns");
        super();
        this.defaultDns = dns;
    }

    public JavaNetAuthenticator(Dns dns, int i2, g g3) {
        Dns obj1;
        obj1 = i2 &= 1 != 0 ? Dns.SYSTEM : obj1;
        super(obj1);
    }

    private final InetAddress connectToInetAddress(Proxy proxy, HttpUrl httpUrl2, Dns dns3) {
        Proxy.Type type;
        int i;
        Object obj3;
        String obj4;
        type = proxy.type();
        if (type == null) {
            obj3 = proxy.address();
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.net.InetSocketAddress");
            n.e((InetSocketAddress)obj3.getAddress(), "(address() as InetSocketAddress).address");
        } else {
            if (JavaNetAuthenticator.WhenMappings.$EnumSwitchMapping$0[type.ordinal()] != 1) {
            } else {
                obj3 = p.X(dns3.lookup(httpUrl2.host()));
            }
        }
        return obj3;
    }

    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response2) {
        String str;
        int i;
        int nO_PROXY;
        Object next;
        PasswordAuthentication requestPasswordAuthentication;
        String str2;
        java.net.SocketAddress address;
        String hostName;
        InetAddress toInetAddress;
        int realm2;
        String scheme;
        String realm;
        String sERVER;
        java.net.URL url;
        Authenticator.RequestorType pROXY;
        final Object obj = this;
        n.f(response2, "response");
        Request request = response2.request();
        HttpUrl httpUrl = request.url();
        int i3 = 1;
        i = response2.code() == 407 ? i3 : 0;
        if (route != null && route.proxy() != null) {
            if (route.proxy() != null) {
            } else {
                nO_PROXY = Proxy.NO_PROXY;
            }
        } else {
        }
        Iterator iterator = response2.challenges().iterator();
        for (Challenge next : iterator) {
            requestPasswordAuthentication = route.address();
            if (route != null && requestPasswordAuthentication != null && requestPasswordAuthentication.dns() != null) {
            } else {
            }
            requestPasswordAuthentication = obj.defaultDns;
            str2 = "proxy";
            if (i != 0) {
            } else {
            }
            n.e(nO_PROXY, str2);
            requestPasswordAuthentication = Authenticator.requestPasswordAuthentication(httpUrl.host(), obj.connectToInetAddress(nO_PROXY, httpUrl, requestPasswordAuthentication), httpUrl.port(), httpUrl.scheme(), next.realm(), next.scheme(), httpUrl.url(), Authenticator.RequestorType.SERVER);
            address = nO_PROXY.address();
            Objects.requireNonNull(address, "null cannot be cast to non-null type java.net.InetSocketAddress");
            n.e(nO_PROXY, str2);
            requestPasswordAuthentication = Authenticator.requestPasswordAuthentication((InetSocketAddress)address.getHostName(), obj.connectToInetAddress(nO_PROXY, httpUrl, requestPasswordAuthentication), address.getPort(), httpUrl.scheme(), next.realm(), next.scheme(), httpUrl.url(), Authenticator.RequestorType.PROXY);
            requestPasswordAuthentication = route.address();
            if (requestPasswordAuthentication != null) {
            } else {
            }
            if (requestPasswordAuthentication.dns() != null) {
            } else {
            }
        }
        return null;
    }
}
