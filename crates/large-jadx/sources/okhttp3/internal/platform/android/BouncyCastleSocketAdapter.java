package okhttp3.internal.platform.android;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Protocol;
import okhttp3.internal.platform.BouncyCastlePlatform;
import okhttp3.internal.platform.BouncyCastlePlatform.Companion;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012¨\u0006\u0016", d2 = {"Lokhttp3/internal/platform/android/BouncyCastleSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "isSupported", "()Z", "", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BouncyCastleSocketAdapter implements okhttp3.internal.platform.android.SocketAdapter {

    public static final okhttp3.internal.platform.android.BouncyCastleSocketAdapter.Companion Companion;
    private static final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory factory;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/internal/platform/android/BouncyCastleSocketAdapter$Companion;", "", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "factory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory getFactory() {
            return BouncyCastleSocketAdapter.access$getFactory$cp();
        }
    }
    static {
        BouncyCastleSocketAdapter.Companion companion = new BouncyCastleSocketAdapter.Companion(0);
        BouncyCastleSocketAdapter.Companion = companion;
        BouncyCastleSocketAdapter.Companion.factory.1 anon = new BouncyCastleSocketAdapter.Companion.factory.1();
        BouncyCastleSocketAdapter.factory = anon;
    }

    public static final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory access$getFactory$cp() {
        return BouncyCastleSocketAdapter.factory;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<? extends Protocol> list3) {
        String str;
        boolean obj3;
        Object obj4;
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        if (matchesSocket(sSLSocket)) {
            obj3 = (BCSSLSocket)sSLSocket.getParameters();
            n.e(obj3, "sslParameters");
            obj4 = Platform.Companion.alpnProtocolNames(list3).toArray(new String[0]);
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Array<T>");
            obj3.setApplicationProtocols((String[])obj4);
            sSLSocket.setParameters(obj3);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String equals;
        int obj2;
        n.f(sSLSocket, "sslSocket");
        obj2 = (BCSSLSocket)sSLSocket.getApplicationProtocol();
        if (obj2 == null) {
            obj2 = 0;
        } else {
            if (obj2.hashCode() != 0) {
            } else {
                if (obj2.equals("")) {
                }
            }
        }
        return obj2;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return BouncyCastlePlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket sSLSocket) {
        n.f(sSLSocket, "sslSocket");
        return sSLSocket instanceof BCSSLSocket;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
