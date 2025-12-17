package okhttp3.internal.platform.android;

import android.net.ssl.SSLSockets;
import android.os.Build.VERSION;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\u0008\n\u0010\u000bJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH\u0017¢\u0006\u0004\u0008\u0011\u0010\u0012¨\u0006\u0016", d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "isSupported", "()Z", "", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Android10SocketAdapter implements okhttp3.internal.platform.android.SocketAdapter {

    public static final okhttp3.internal.platform.android.Android10SocketAdapter.Companion Companion;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\u0008\u0087\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\n", d2 = {"Lokhttp3/internal/platform/android/Android10SocketAdapter$Companion;", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildIfSupported", "()Lokhttp3/internal/platform/android/SocketAdapter;", "", "isSupported", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.android.SocketAdapter buildIfSupported() {
            okhttp3.internal.platform.android.Android10SocketAdapter android10SocketAdapter;
            if (isSupported()) {
                android10SocketAdapter = new Android10SocketAdapter();
            } else {
                android10SocketAdapter = 0;
            }
            return android10SocketAdapter;
        }

        public final boolean isSupported() {
            boolean sDK_INT;
            int i;
            int i2;
            if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29) {
                i = Build.VERSION.SDK_INT >= 29 ? 1 : 0;
            } else {
            }
            return i;
        }
    }
    static {
        Android10SocketAdapter.Companion companion = new Android10SocketAdapter.Companion(0);
        Android10SocketAdapter.Companion = companion;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<? extends Protocol> list3) {
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        SSLSockets.setUseSessionTickets(sSLSocket, true);
        SSLParameters obj3 = sSLSocket.getSSLParameters();
        n.e(obj3, "sslParameters");
        Object[] obj4 = Platform.Companion.alpnProtocolNames(list3).toArray(new String[0]);
        if (obj4 == null) {
        } else {
            obj3.setApplicationProtocols((String[])obj4);
            sSLSocket.setSSLParameters(obj3);
        }
        NullPointerException obj2 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj2;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String equals;
        int obj2;
        n.f(sSLSocket, "sslSocket");
        obj2 = sSLSocket.getApplicationProtocol();
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
        return Android10SocketAdapter.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket sSLSocket) {
        n.f(sSLSocket, "sslSocket");
        return SSLSockets.isSupportedSocket(sSLSocket);
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
