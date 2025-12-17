package okhttp3.internal.platform;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import l.f;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.platform.android.AndroidLog;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0016\u0018\u0000 >2\u00020\u0001:\u0001>B\u0007¢\u0006\u0004\u0008<\u0010=J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ/\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000f2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0016¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008\u001a\u0010\u001bJ'\u0010\"\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\u0008\"\u0010#J-\u0010(\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00022\u0008\u0008\u0002\u0010%\u001a\u00020 2\n\u0008\u0002\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\u0008(\u0010)J\u0017\u0010+\u001a\u00020*2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008+\u0010,J\u0019\u0010.\u001a\u0004\u0018\u00010\u00012\u0006\u0010-\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008.\u0010/J!\u00101\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00022\u0008\u00100\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\u00081\u00102J\u0017\u00104\u001a\u0002032\u0006\u0010\r\u001a\u00020\u0008H\u0016¢\u0006\u0004\u00084\u00105J\u0017\u00107\u001a\u0002062\u0006\u0010\r\u001a\u00020\u0008H\u0016¢\u0006\u0004\u00087\u00108J\u0017\u00109\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0008H\u0016¢\u0006\u0004\u00089\u0010:J\u000f\u0010;\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008;\u0010\u0004¨\u0006?", d2 = {"Lokhttp3/internal/platform/Platform;", "", "", "getPrefix", "()Ljava/lang/String;", "Ljavax/net/ssl/SSLContext;", "newSSLContext", "()Ljavax/net/ssl/SSLContext;", "Ljavax/net/ssl/X509TrustManager;", "platformTrustManager", "()Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "message", "level", "", "t", "log", "(Ljava/lang/String;ILjava/lang/Throwable;)V", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "closer", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "newSslSocketFactory", "(Ljavax/net/ssl/X509TrustManager;)Ljavax/net/ssl/SSLSocketFactory;", "toString", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public class Platform {

    public static final okhttp3.internal.platform.Platform.Companion Companion = null;
    public static final int INFO = 4;
    public static final int WARN = 5;
    private static final Logger logger;
    private static volatile okhttp3.internal.platform.Platform platform;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008$\u0010%J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0004J\u0017\u0010\n\u001a\u00020\t2\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ!\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000c2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00122\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00158B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u001b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u001dR\u001e\u0010!\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008!\u0010\"R\u0016\u0010\u0008\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0008\u0010#¨\u0006&", d2 = {"Lokhttp3/internal/platform/Platform$Companion;", "", "Lokhttp3/internal/platform/Platform;", "findPlatform", "()Lokhttp3/internal/platform/Platform;", "findAndroidPlatform", "findJvmPlatform", "get", "platform", "Lkotlin/w;", "resetForTests", "(Lokhttp3/internal/platform/Platform;)V", "", "Lokhttp3/Protocol;", "protocols", "", "alpnProtocolNames", "(Ljava/util/List;)Ljava/util/List;", "", "concatLengthPrefixed", "(Ljava/util/List;)[B", "", "isBouncyCastlePreferred", "()Z", "isAndroid", "isConscryptPreferred", "isOpenJSSEPreferred", "", "INFO", "I", "WARN", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "logger", "Ljava/util/logging/Logger;", "Lokhttp3/internal/platform/Platform;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final okhttp3.internal.platform.Platform access$findPlatform(okhttp3.internal.platform.Platform.Companion platform$Companion) {
            return companion.findPlatform();
        }

        private final okhttp3.internal.platform.Platform findAndroidPlatform() {
            okhttp3.internal.platform.Platform ifSupported;
            AndroidLog.INSTANCE.enable();
            if (Android10Platform.Companion.buildIfSupported() != null) {
            } else {
                n.d(AndroidPlatform.Companion.buildIfSupported());
            }
            return ifSupported;
        }

        private final okhttp3.internal.platform.Platform findJvmPlatform() {
            boolean conscryptPreferred;
            boolean bouncyCastlePreferred;
            boolean openJSSEPreferred;
            conscryptPreferred = ConscryptPlatform.Companion.buildIfSupported();
            if (isConscryptPreferred() && conscryptPreferred != null) {
                conscryptPreferred = ConscryptPlatform.Companion.buildIfSupported();
                if (conscryptPreferred != null) {
                    return conscryptPreferred;
                }
            }
            bouncyCastlePreferred = BouncyCastlePlatform.Companion.buildIfSupported();
            if (isBouncyCastlePreferred() && bouncyCastlePreferred != null) {
                bouncyCastlePreferred = BouncyCastlePlatform.Companion.buildIfSupported();
                if (bouncyCastlePreferred != null) {
                    return bouncyCastlePreferred;
                }
            }
            openJSSEPreferred = OpenJSSEPlatform.Companion.buildIfSupported();
            if (isOpenJSSEPreferred() && openJSSEPreferred != null) {
                openJSSEPreferred = OpenJSSEPlatform.Companion.buildIfSupported();
                if (openJSSEPreferred != null) {
                    return openJSSEPreferred;
                }
            }
            okhttp3.internal.platform.Jdk9Platform ifSupported = Jdk9Platform.Companion.buildIfSupported();
            if (ifSupported != null) {
                return ifSupported;
            }
            okhttp3.internal.platform.Platform ifSupported2 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
            if (ifSupported2 != null) {
                return ifSupported2;
            }
            Platform platform = new Platform();
            return platform;
        }

        private final okhttp3.internal.platform.Platform findPlatform() {
            okhttp3.internal.platform.Platform androidPlatform;
            if (isAndroid()) {
                androidPlatform = findAndroidPlatform();
            } else {
                androidPlatform = findJvmPlatform();
            }
            return androidPlatform;
        }

        private final boolean isBouncyCastlePreferred() {
            Provider provider = Security.getProviders()[0];
            n.e(provider, "Security.getProviders()[0]");
            return n.b("BC", provider.getName());
        }

        private final boolean isConscryptPreferred() {
            Provider provider = Security.getProviders()[0];
            n.e(provider, "Security.getProviders()[0]");
            return n.b("Conscrypt", provider.getName());
        }

        private final boolean isOpenJSSEPreferred() {
            Provider provider = Security.getProviders()[0];
            n.e(provider, "Security.getProviders()[0]");
            return n.b("OpenJSSE", provider.getName());
        }

        public static void resetForTests$default(okhttp3.internal.platform.Platform.Companion platform$Companion, okhttp3.internal.platform.Platform platform2, int i3, Object object4) {
            okhttp3.internal.platform.Platform obj1;
            if (i3 &= 1 != 0) {
                obj1 = companion.findPlatform();
            }
            companion.resetForTests(obj1);
        }

        public final List<String> alpnProtocolNames(List<? extends Protocol> list) {
            Object next;
            int string;
            int i;
            Protocol hTTP_1_0;
            n.f(list, "protocols");
            ArrayList arrayList = new ArrayList();
            Iterator obj5 = list.iterator();
            while (obj5.hasNext()) {
                next = obj5.next();
                if ((Protocol)next != Protocol.HTTP_1_0) {
                } else {
                }
                i = 0;
                if (i != 0) {
                }
                arrayList.add(next);
                i = 1;
            }
            obj5 = new ArrayList(p.r(arrayList, 10));
            Iterator iterator = arrayList.iterator();
            for (Protocol next4 : iterator) {
                obj5.add(next4.toString());
            }
            return obj5;
        }

        public final byte[] concatLengthPrefixed(List<? extends Protocol> list) {
            Object next;
            int length;
            n.f(list, "protocols");
            f fVar = new f();
            Iterator obj4 = alpnProtocolNames(list).iterator();
            for (String next : obj4) {
                fVar.z0(next.length());
                fVar.b1(next);
            }
            return fVar.X();
        }

        public final okhttp3.internal.platform.Platform get() {
            return Platform.access$getPlatform$cp();
        }

        public final boolean isAndroid() {
            return n.b("Dalvik", System.getProperty("java.vm.name"));
        }

        public final void resetForTests(okhttp3.internal.platform.Platform platform) {
            n.f(platform, "platform");
            Platform.access$setPlatform$cp(platform);
        }
    }
    static {
        Platform.Companion companion = new Platform.Companion(0);
        Platform.Companion = companion;
        Platform.platform = Platform.Companion.access$findPlatform(companion);
        Platform.logger = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static final okhttp3.internal.platform.Platform access$getPlatform$cp() {
        return Platform.platform;
    }

    public static final void access$setPlatform$cp(okhttp3.internal.platform.Platform platform) {
        Platform.platform = platform;
    }

    public static final okhttp3.internal.platform.Platform get() {
        return Platform.Companion.get();
    }

    public static void log$default(okhttp3.internal.platform.Platform platform, String string2, int i3, Throwable throwable4, int i5, Object object6) {
        int obj3;
        int obj4;
        if (object6 != null) {
        } else {
            final int i = 4;
            if (i5 & 2 != 0) {
                obj3 = i;
            }
            if (i5 &= i != 0) {
                obj4 = 0;
            }
            platform.log(string2, obj3, obj4);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        throw obj1;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
        n.f(sSLSocket, "sslSocket");
    }

    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        n.f(x509TrustManager, "trustManager");
        BasicCertificateChainCleaner basicCertificateChainCleaner = new BasicCertificateChainCleaner(buildTrustRootIndex(x509TrustManager));
        return basicCertificateChainCleaner;
    }

    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        n.f(x509TrustManager, "trustManager");
        java.security.cert.X509Certificate[] obj3 = x509TrustManager.getAcceptedIssuers();
        n.e(obj3, "trustManager.acceptedIssuers");
        BasicTrustRootIndex basicTrustRootIndex = new BasicTrustRootIndex((X509Certificate[])Arrays.copyOf(obj3, obj3.length));
        return basicTrustRootIndex;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list3) {
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress2, int i3) {
        n.f(socket, "socket");
        n.f(inetSocketAddress2, "address");
        socket.connect(inetSocketAddress2, i3);
    }

    public final String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        n.f(sSLSocket, "sslSocket");
        return null;
    }

    public Object getStackTraceForCloseable(String string) {
        Throwable throwable;
        n.f(string, "closer");
        if (Platform.logger.isLoggable(Level.FINE)) {
            throwable = new Throwable(string);
        } else {
            throwable = 0;
        }
        return throwable;
    }

    public boolean isCleartextTrafficPermitted(String string) {
        n.f(string, "hostname");
        return 1;
    }

    public void log(String string, int i2, Throwable throwable3) {
        Level obj3;
        n.f(string, "message");
        obj3 = i2 == 5 ? Level.WARNING : Level.INFO;
        Platform.logger.log(obj3, string, throwable3);
    }

    public void logCloseableLeak(String string, Object object2) {
        Object stringBuilder;
        Object obj2;
        n.f(string, "message");
        if (object2 == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            obj2 = stringBuilder.toString();
        }
        log(obj2, 5, (Throwable)object2);
    }

    public SSLContext newSSLContext() {
        SSLContext instance = SSLContext.getInstance("TLS");
        n.e(instance, "SSLContext.getInstance(\"TLS\")");
        return instance;
    }

    public SSLSocketFactory newSslSocketFactory(X509TrustManager x509TrustManager) {
        n.f(x509TrustManager, "trustManager");
        SSLContext sSLContext = newSSLContext();
        javax.net.ssl.TrustManager[] arr = new TrustManager[1];
        int obj4 = 0;
        sSLContext.init(obj4, arr, obj4);
        obj4 = sSLContext.getSocketFactory();
        n.e(obj4, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
        return obj4;
    }

    public X509TrustManager platformTrustManager() {
        int length;
        int i;
        TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    public String toString() {
        String simpleName = getClass().getSimpleName();
        n.e(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        Class forName = Class.forName("sun.security.ssl.SSLContextImpl");
        n.e(forName, "sslContextClass");
        Object obj4 = Util.readFieldOrNull(sSLSocketFactory, forName, "context");
        if (obj4 != null) {
            try {
                return (X509TrustManager)Util.readFieldOrNull(obj4, X509TrustManager.class, "trustManager");
            }
        }
        return null;
    }
}
