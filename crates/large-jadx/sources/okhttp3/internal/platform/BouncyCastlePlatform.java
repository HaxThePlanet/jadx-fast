package okhttp3.internal.platform;

import java.security.Provider;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Protocol;
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\u0008\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000c2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u001a¨\u0006\u001e", d2 = {"Lokhttp3/internal/platform/BouncyCastlePlatform;", "Lokhttp3/internal/platform/Platform;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/security/Provider;", "provider", "Ljava/security/Provider;", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BouncyCastlePlatform extends okhttp3.internal.platform.Platform {

    public static final okhttp3.internal.platform.BouncyCastlePlatform.Companion Companion;
    private static final boolean isSupported = true;
    private final Provider provider;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0006\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/internal/platform/BouncyCastlePlatform$Companion;", "", "Lokhttp3/internal/platform/BouncyCastlePlatform;", "buildIfSupported", "()Lokhttp3/internal/platform/BouncyCastlePlatform;", "", "isSupported", "Z", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.BouncyCastlePlatform buildIfSupported() {
            boolean bouncyCastlePlatform;
            int i;
            if (isSupported()) {
                bouncyCastlePlatform = new BouncyCastlePlatform(0);
                i = bouncyCastlePlatform;
            }
            return i;
        }

        public final boolean isSupported() {
            return BouncyCastlePlatform.access$isSupported$cp();
        }
    }
    static {
        BouncyCastlePlatform.Companion companion = new BouncyCastlePlatform.Companion(0);
        BouncyCastlePlatform.Companion = companion;
        Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, companion.getClass().getClassLoader());
        int i3 = 1;
    }

    private BouncyCastlePlatform() {
        super();
        BouncyCastleJsseProvider bouncyCastleJsseProvider = new BouncyCastleJsseProvider();
        this.provider = (Provider)bouncyCastleJsseProvider;
    }

    public BouncyCastlePlatform(g g) {
        super();
    }

    public static final boolean access$isSupported$cp() {
        return BouncyCastlePlatform.isSupported;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list3) {
        String str;
        Object obj3;
        Object[] obj4;
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        if (sSLSocket instanceof BCSSLSocket) {
            obj3 = (BCSSLSocket)sSLSocket.getParameters();
            n.e(obj3, "sslParameters");
            obj4 = Platform.Companion.alpnProtocolNames(list3).toArray(new String[0]);
            Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Array<T>");
            obj3.setApplicationProtocols((String[])obj4);
            sSLSocket.setParameters(obj3);
        } else {
            super.configureTlsExtensions(sSLSocket, string2, list3);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        boolean equals;
        String obj2;
        n.f(sSLSocket, "sslSocket");
        if (sSLSocket instanceof BCSSLSocket) {
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
        } else {
            obj2 = super.getSelectedProtocol(sSLSocket);
        }
        return obj2;
    }

    @Override // okhttp3.internal.platform.Platform
    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS", this.provider);
        n.e(instance, "SSLContext.getInstance(\"TLS\", provider)");
        return instance;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        int length;
        int i;
        TrustManagerFactory instance = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        instance.init(0);
        n.e(instance, "factory");
        javax.net.ssl.TrustManager[] trustManagers = instance.getTrustManagers();
        n.d(trustManagers);
        final int i3 = 0;
        if (trustManagers.length == 1 && trustManager2 instanceof X509TrustManager != null) {
            if (trustManager2 instanceof X509TrustManager != null) {
            } else {
                i = i3;
            }
        } else {
        }
        if (i == 0) {
        } else {
            javax.net.ssl.TrustManager trustManager = trustManagers[i3];
            Objects.requireNonNull(trustManager, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            return (X509TrustManager)trustManager;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        n.e(string, "java.util.Arrays.toString(this)");
        stringBuilder.append(string);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        UnsupportedOperationException obj2 = new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
        throw obj2;
    }
}
