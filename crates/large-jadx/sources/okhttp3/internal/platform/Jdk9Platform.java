package okhttp3.internal.platform;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0016\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\u0008\u0013\u0010\u0014J/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0017¢\u0006\u0004\u0008\n\u0010\u000bJ\u0019\u0010\u000c\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\u0008\u000c\u0010\rJ\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012¨\u0006\u0016", d2 = {"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public class Jdk9Platform extends okhttp3.internal.platform.Platform {

    public static final okhttp3.internal.platform.Jdk9Platform.Companion Companion;
    private static final boolean isAvailable = false;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0006\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "Lokhttp3/internal/platform/Jdk9Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Jdk9Platform;", "", "isAvailable", "Z", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.Jdk9Platform buildIfSupported() {
            okhttp3.internal.platform.Jdk9Platform jdk9Platform;
            if (isAvailable()) {
                jdk9Platform = new Jdk9Platform();
            } else {
                jdk9Platform = 0;
            }
            return jdk9Platform;
        }

        public final boolean isAvailable() {
            return Jdk9Platform.access$isAvailable$cp();
        }
    }
    static {
        int i;
        Jdk9Platform.Companion companion = new Jdk9Platform.Companion(0);
        Jdk9Platform.Companion = companion;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            i = l.m(property);
        }
        int i2 = 1;
        final int i4 = 0;
        if (i != 0) {
            if (i.intValue() >= 9) {
            } else {
                int i3 = i4;
            }
        }
        SSLSocket.class.getMethod("getApplicationProtocol", new Class[i4]);
    }

    public static final boolean access$isAvailable$cp() {
        return Jdk9Platform.isAvailable;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list3) {
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        SSLParameters obj3 = sSLSocket.getSSLParameters();
        n.e(obj3, "sslParameters");
        Object[] obj4 = Platform.Companion.alpnProtocolNames(list3).toArray(new String[0]);
        Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Array<T>");
        obj3.setApplicationProtocols((String[])obj4);
        sSLSocket.setSSLParameters(obj3);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String i;
        int equals;
        n.f(sSLSocket, "sslSocket");
        i = 0;
        final String obj3 = sSLSocket.getApplicationProtocol();
        if (obj3 == null) {
        } else {
            if (obj3.hashCode() != 0) {
                try {
                    i = obj3;
                    return i;
                }
            } else {
                if (obj3.equals("")) {
                } else {
                }
            }
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        UnsupportedOperationException obj2 = new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+");
        throw obj2;
    }
}
