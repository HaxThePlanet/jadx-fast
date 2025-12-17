package okhttp3.internal.proxy;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u001f\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J-\u0010\r\u001a\u00020\u000c2\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/internal/proxy/NullProxySelector;", "Ljava/net/ProxySelector;", "Ljava/net/URI;", "uri", "", "Ljava/net/Proxy;", "select", "(Ljava/net/URI;)Ljava/util/List;", "Ljava/net/SocketAddress;", "sa", "Ljava/io/IOException;", "ioe", "Lkotlin/w;", "connectFailed", "(Ljava/net/URI;Ljava/net/SocketAddress;Ljava/io/IOException;)V", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class NullProxySelector extends ProxySelector {

    public static final okhttp3.internal.proxy.NullProxySelector INSTANCE;
    static {
        NullProxySelector nullProxySelector = new NullProxySelector();
        NullProxySelector.INSTANCE = nullProxySelector;
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uRI, SocketAddress socketAddress2, IOException iOException3) {
    }

    public List<Proxy> select(URI uRI) {
        if (uRI == null) {
        } else {
            return p.b(Proxy.NO_PROXY);
        }
        IllegalArgumentException obj2 = new IllegalArgumentException("uri must not be null".toString());
        throw obj2;
    }
}
