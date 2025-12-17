package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u000e2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010\u001a\u001a\u0004\u0008\t\u0010\u0008R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\u001b\u001a\u0004\u0008\u0005\u0010\u0004R\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u001c\u001a\u0004\u0008\r\u0010\u000c¨\u0006\u001f", d2 = {"Lokhttp3/Route;", "", "Lokhttp3/Address;", "-deprecated_address", "()Lokhttp3/Address;", "address", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljava/net/InetSocketAddress;", "-deprecated_socketAddress", "()Ljava/net/InetSocketAddress;", "socketAddress", "", "requiresTunnel", "()Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Ljava/net/Proxy;", "Lokhttp3/Address;", "Ljava/net/InetSocketAddress;", "<init>", "(Lokhttp3/Address;Ljava/net/Proxy;Ljava/net/InetSocketAddress;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Route {

    private final okhttp3.Address address;
    private final Proxy proxy;
    private final InetSocketAddress socketAddress;
    public Route(okhttp3.Address address, Proxy proxy2, InetSocketAddress inetSocketAddress3) {
        n.f(address, "address");
        n.f(proxy2, "proxy");
        n.f(inetSocketAddress3, "socketAddress");
        super();
        this.address = address;
        this.proxy = proxy2;
        this.socketAddress = inetSocketAddress3;
    }

    public final okhttp3.Address -deprecated_address() {
        return this.address;
    }

    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    public final InetSocketAddress -deprecated_socketAddress() {
        return this.socketAddress;
    }

    public final okhttp3.Address address() {
        return this.address;
    }

    public boolean equals(Object object) {
        boolean socketAddress;
        Object address;
        Object obj3;
        if (object instanceof Route && n.b(object.address, this.address) && n.b(object.proxy, this.proxy) && n.b(object.socketAddress, this.socketAddress)) {
            if (n.b(object.address, this.address)) {
                if (n.b(object.proxy, this.proxy)) {
                    obj3 = n.b(object.socketAddress, this.socketAddress) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public int hashCode() {
        return i8 += i3;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final boolean requiresTunnel() {
        Object sslSocketFactory;
        int i;
        Proxy.Type hTTP;
        if (this.address.sslSocketFactory() != null && this.proxy.type() == Proxy.Type.HTTP) {
            i = this.proxy.type() == Proxy.Type.HTTP ? 1 : 0;
        } else {
        }
        return i;
    }

    public final InetSocketAddress socketAddress() {
        return this.socketAddress;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Route{");
        stringBuilder.append(this.socketAddress);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
