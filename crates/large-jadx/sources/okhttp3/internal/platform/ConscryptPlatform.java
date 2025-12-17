package okhttp3.internal.platform;

import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Protocol;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt.Version;
import org.conscrypt.ConscryptHostnameVerifier;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001f B\t\u0008\u0002¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ/\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000c2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0019\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\u000cH\u0016¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u001c¨\u0006!", d2 = {"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "newSslSocketFactory", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "Ljava/security/Provider;", "provider", "Ljava/security/Provider;", "<init>", "()V", "Companion", "DisabledHostnameVerifier", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConscryptPlatform extends okhttp3.internal.platform.Platform {

    public static final okhttp3.internal.platform.ConscryptPlatform.Companion Companion;
    private static final boolean isSupported = true;
    private final Provider provider;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0005¢\u0006\u0004\u0008\n\u0010\u000bR\u0019\u0010\u000c\u001a\u00020\t8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\u000c\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "Lokhttp3/internal/platform/ConscryptPlatform;", "buildIfSupported", "()Lokhttp3/internal/platform/ConscryptPlatform;", "", "major", "minor", "patch", "", "atLeastVersion", "(III)Z", "isSupported", "Z", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static boolean atLeastVersion$default(okhttp3.internal.platform.ConscryptPlatform.Companion conscryptPlatform$Companion, int i2, int i3, int i4, int i5, Object object6) {
            int obj3;
            int obj4;
            final int i = 0;
            if (i5 & 2 != 0) {
                obj3 = i;
            }
            if (i5 &= 4 != 0) {
                obj4 = i;
            }
            return companion.atLeastVersion(i2, obj3, obj4);
        }

        public final boolean atLeastVersion(int i, int i2, int i3) {
            int i4;
            final Conscrypt.Version version = Conscrypt.version();
            i4 = 1;
            final int i5 = 0;
            if (version.major() != i) {
                if (version.major() > i) {
                } else {
                    i4 = i5;
                }
                return i4;
            }
            if (version.minor() != i2) {
                if (version.minor() > i2) {
                } else {
                    i4 = i5;
                }
                return i4;
            }
            if (version.patch() >= i3) {
            } else {
                i4 = i5;
            }
            return i4;
        }

        public final okhttp3.internal.platform.ConscryptPlatform buildIfSupported() {
            boolean conscryptPlatform;
            int i;
            if (isSupported()) {
                conscryptPlatform = new ConscryptPlatform(0);
                i = conscryptPlatform;
            }
            return i;
        }

        public final boolean isSupported() {
            return ConscryptPlatform.access$isSupported$cp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008À\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ!\u0010\u0007\u001a\u00020\u00062\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008J5\u0010\u0007\u001a\u00020\u00062\u0010\u0010\u000b\u001a\u000c\u0012\u0006\u0008\u0001\u0012\u00020\n\u0018\u00010\t2\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\u0008\u0007\u0010\u000c¨\u0006\u000f", d2 = {"Lokhttp3/internal/platform/ConscryptPlatform$DisabledHostnameVerifier;", "Lorg/conscrypt/ConscryptHostnameVerifier;", "", "hostname", "Ljavax/net/ssl/SSLSession;", "session", "", "verify", "(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "", "Ljava/security/cert/X509Certificate;", "certs", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class DisabledHostnameVerifier implements ConscryptHostnameVerifier {

        public static final okhttp3.internal.platform.ConscryptPlatform.DisabledHostnameVerifier INSTANCE;
        static {
            ConscryptPlatform.DisabledHostnameVerifier disabledHostnameVerifier = new ConscryptPlatform.DisabledHostnameVerifier();
            ConscryptPlatform.DisabledHostnameVerifier.INSTANCE = disabledHostnameVerifier;
        }

        @Override // org.conscrypt.ConscryptHostnameVerifier
        public final boolean verify(String string, SSLSession sSLSession2) {
            return 1;
        }

        @Override // org.conscrypt.ConscryptHostnameVerifier
        public boolean verify(X509Certificate[] x509CertificateArr, String string2, SSLSession sSLSession3) {
            return 1;
        }
    }
    static {
        ConscryptPlatform.Companion companion = new ConscryptPlatform.Companion(0);
        ConscryptPlatform.Companion = companion;
        int i2 = 0;
        Class.forName("org.conscrypt.Conscrypt$Version", i2, companion.getClass().getClassLoader());
        int i5 = 1;
        int i3 = i5;
    }

    private ConscryptPlatform() {
        super();
        final Provider provider = Conscrypt.newProvider();
        n.e(provider, "Conscrypt.newProvider()");
        this.provider = provider;
    }

    public ConscryptPlatform(g g) {
        super();
    }

    public static final boolean access$isSupported$cp() {
        return ConscryptPlatform.isSupported;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list3) {
        Object[] obj3;
        Object obj4;
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            Conscrypt.setUseSessionTickets(sSLSocket, true);
            obj3 = Platform.Companion.alpnProtocolNames(list3).toArray(new String[0]);
            Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<T>");
            Conscrypt.setApplicationProtocols(sSLSocket, (String[])obj3);
        } else {
            super.configureTlsExtensions(sSLSocket, string2, list3);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String obj2;
        n.f(sSLSocket, "sslSocket");
        if (Conscrypt.isConscrypt(sSLSocket)) {
            obj2 = Conscrypt.getApplicationProtocol(sSLSocket);
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
    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        n.f(x509TrustManager, "trustManager");
        SSLContext sSLContext = newSSLContext();
        javax.net.ssl.TrustManager[] arr = new TrustManager[1];
        int obj4 = 0;
        sSLContext.init(obj4, arr, obj4);
        obj4 = sSLContext.getSocketFactory();
        n.e(obj4, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return obj4;
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager platformTrustManager() {
        int length;
        int i;
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        instance.init(0);
        n.e(instance, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
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
            Conscrypt.setHostnameVerifier((X509TrustManager)trustManager, (ConscryptHostnameVerifier)ConscryptPlatform.DisabledHostnameVerifier.INSTANCE);
            return trustManager;
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
        return null;
    }
}
