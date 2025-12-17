package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import okhttp3.Protocol;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner.Companion;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.AndroidSocketAdapter.Companion;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter.Companion;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.CloseGuard.Companion;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter.Companion;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter.Companion;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u0000 42\u00020\u0001:\u000245B\u0007¢\u0006\u0004\u00082\u00103J'\u0010\t\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\t\u0010\nJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fJ/\u0010\u0017\u001a\u00020\u00082\u0006\u0010\u0011\u001a\u00020\u00102\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016¢\u0006\u0004\u0008\u001d\u0010\u001eJ!\u0010!\u001a\u00020\u00082\u0006\u0010\u001f\u001a\u00020\u00122\u0008\u0010 \u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\u0008!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\u0008$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\u0008'\u0010(J\u0017\u0010*\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\u0008*\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008-\u0010.R\u001c\u00100\u001a\u0008\u0012\u0004\u0012\u00020/0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u00080\u00101¨\u00066", d2 = {"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "Ljava/net/Socket;", "socket", "Ljava/net/InetSocketAddress;", "address", "", "connectTimeout", "Lkotlin/w;", "connectSocket", "(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "closer", "", "getStackTraceForCloseable", "(Ljava/lang/String;)Ljava/lang/Object;", "message", "stackTrace", "logCloseableLeak", "(Ljava/lang/String;Ljava/lang/Object;)V", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/tls/TrustRootIndex;", "buildTrustRootIndex", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/TrustRootIndex;", "Lokhttp3/internal/platform/android/CloseGuard;", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapters", "Ljava/util/List;", "<init>", "()V", "Companion", "CustomTrustRootIndex", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidPlatform extends okhttp3.internal.platform.Platform {

    public static final okhttp3.internal.platform.AndroidPlatform.Companion Companion;
    private static final boolean isSupported = false;
    private final CloseGuard closeGuard;
    private final List<SocketAdapter> socketAdapters;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0006\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "Lokhttp3/internal/platform/Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Platform;", "", "isSupported", "Z", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.Platform buildIfSupported() {
            okhttp3.internal.platform.AndroidPlatform androidPlatform;
            if (isSupported()) {
                androidPlatform = new AndroidPlatform();
            } else {
                androidPlatform = 0;
            }
            return androidPlatform;
        }

        public final boolean isSupported() {
            return AndroidPlatform.access$isSupported$cp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000c\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÂ\u0003¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÂ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ$\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00022\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\u0008\u0019\u0010\u001aR\u0016\u0010\r\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u001bR\u0016\u0010\u000c\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u001c¨\u0006\u001f", d2 = {"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "Ljavax/net/ssl/X509TrustManager;", "component1", "()Ljavax/net/ssl/X509TrustManager;", "Ljava/lang/reflect/Method;", "component2", "()Ljava/lang/reflect/Method;", "Ljava/security/cert/X509Certificate;", "cert", "findByIssuerAndSignature", "(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;", "trustManager", "findByIssuerAndSignatureMethod", "copy", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/reflect/Method;", "Ljavax/net/ssl/X509TrustManager;", "<init>", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class CustomTrustRootIndex implements TrustRootIndex {

        private final Method findByIssuerAndSignatureMethod;
        private final X509TrustManager trustManager;
        public CustomTrustRootIndex(X509TrustManager x509TrustManager, Method method2) {
            n.f(x509TrustManager, "trustManager");
            n.f(method2, "findByIssuerAndSignatureMethod");
            super();
            this.trustManager = x509TrustManager;
            this.findByIssuerAndSignatureMethod = method2;
        }

        private final X509TrustManager component1() {
            return this.trustManager;
        }

        private final Method component2() {
            return this.findByIssuerAndSignatureMethod;
        }

        public static okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex copy$default(okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex androidPlatform$CustomTrustRootIndex, X509TrustManager x509TrustManager2, Method method3, int i4, Object object5) {
            X509TrustManager obj1;
            Method obj2;
            if (i4 & 1 != 0) {
                obj1 = customTrustRootIndex.trustManager;
            }
            if (i4 &= 2 != 0) {
                obj2 = customTrustRootIndex.findByIssuerAndSignatureMethod;
            }
            return customTrustRootIndex.copy(obj1, obj2);
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public final okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex copy(X509TrustManager x509TrustManager, Method method2) {
            n.f(x509TrustManager, "trustManager");
            n.f(method2, "findByIssuerAndSignatureMethod");
            AndroidPlatform.CustomTrustRootIndex customTrustRootIndex = new AndroidPlatform.CustomTrustRootIndex(x509TrustManager, method2);
            return customTrustRootIndex;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public boolean equals(Object object) {
            boolean findByIssuerAndSignatureMethod;
            X509TrustManager trustManager;
            Object obj3;
            if (this != (AndroidPlatform.CustomTrustRootIndex)object && object instanceof AndroidPlatform.CustomTrustRootIndex && n.b(this.trustManager, object.trustManager) && n.b(this.findByIssuerAndSignatureMethod, object.findByIssuerAndSignatureMethod)) {
                if (object instanceof AndroidPlatform.CustomTrustRootIndex) {
                    if (n.b(this.trustManager, object.trustManager)) {
                        if (n.b(this.findByIssuerAndSignatureMethod, object.findByIssuerAndSignatureMethod)) {
                        }
                    }
                }
                return 0;
            }
            return 1;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
            X509Certificate obj5;
            n.f(x509Certificate, "cert");
            Object[] arr = new Object[1];
            obj5 = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, x509Certificate);
            if (obj5 == null) {
            } else {
                obj5 = (TrustAnchor)obj5.getTrustedCert();
                return obj5;
            }
            obj5 = new NullPointerException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
            throw obj5;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public int hashCode() {
            int i;
            int i2;
            X509TrustManager trustManager = this.trustManager;
            if (trustManager != null) {
                i = trustManager.hashCode();
            } else {
                i = i2;
            }
            final Method findByIssuerAndSignatureMethod = this.findByIssuerAndSignatureMethod;
            if (findByIssuerAndSignatureMethod != null) {
                i2 = findByIssuerAndSignatureMethod.hashCode();
            }
            return i3 += i2;
        }

        @Override // okhttp3.internal.tls.TrustRootIndex
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CustomTrustRootIndex(trustManager=");
            stringBuilder.append(this.trustManager);
            stringBuilder.append(", findByIssuerAndSignatureMethod=");
            stringBuilder.append(this.findByIssuerAndSignatureMethod);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
    static {
        boolean sDK_INT;
        int i;
        int i2;
        AndroidPlatform.Companion companion = new AndroidPlatform.Companion(0);
        AndroidPlatform.Companion = companion;
        if (!Platform.Companion.isAndroid()) {
            int i5 = i;
        }
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 30) {
        }
        if (sDK_INT >= 21) {
            i = i4;
        }
        if (i == 0) {
        } else {
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected Android API level 21+ but was ");
        stringBuilder.append(sDK_INT);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString().toString());
        throw illegalStateException;
    }

    public AndroidPlatform() {
        int next;
        int supported;
        super();
        SocketAdapter[] arr = new SocketAdapter[4];
        int i2 = 0;
        supported = 1;
        DeferredSocketAdapter deferredSocketAdapter = new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory());
        arr[supported] = deferredSocketAdapter;
        DeferredSocketAdapter deferredSocketAdapter2 = new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory());
        arr[2] = deferredSocketAdapter2;
        DeferredSocketAdapter deferredSocketAdapter3 = new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory());
        arr[3] = deferredSocketAdapter3;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = p.l(arr).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((SocketAdapter)next.isSupported() != 0) {
            }
            arrayList.add(next);
        }
        this.socketAdapters = arrayList;
        this.closeGuard = CloseGuard.Companion.get();
    }

    public static final boolean access$isSupported$cp() {
        return AndroidPlatform.isSupported;
    }

    @Override // okhttp3.internal.platform.Platform
    public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager x509TrustManager) {
        CertificateChainCleaner certificateChainCleaner;
        n.f(x509TrustManager, "trustManager");
        if (AndroidCertificateChainCleaner.Companion.buildIfSupported(x509TrustManager) != null) {
        } else {
            certificateChainCleaner = super.buildCertificateChainCleaner(x509TrustManager);
        }
        return certificateChainCleaner;
    }

    @Override // okhttp3.internal.platform.Platform
    public TrustRootIndex buildTrustRootIndex(X509TrustManager x509TrustManager) {
        okhttp3.internal.platform.AndroidPlatform.CustomTrustRootIndex customTrustRootIndex;
        n.f(x509TrustManager, "trustManager");
        final int i = 1;
        final Class[] arr = new Class[i];
        arr[0] = X509Certificate.class;
        Method declaredMethod = x509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", arr);
        n.e(declaredMethod, "method");
        declaredMethod.setAccessible(i);
        customTrustRootIndex = new AndroidPlatform.CustomTrustRootIndex(x509TrustManager, declaredMethod);
        return customTrustRootIndex;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<Protocol> list3) {
        Object next;
        boolean matchesSocket;
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        Iterator iterator = this.socketAdapters.iterator();
        for (Object next : iterator) {
        }
        next = 0;
        if ((SocketAdapter)next != null) {
            (SocketAdapter)next.configureTlsExtensions(sSLSocket, string2, list3);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress2, int i3) {
        n.f(socket, "socket");
        n.f(inetSocketAddress2, "address");
        socket.connect(inetSocketAddress2, i3);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Object next;
        int selectedProtocol;
        boolean matchesSocket;
        n.f(sSLSocket, "sslSocket");
        Iterator iterator = this.socketAdapters.iterator();
        for (Object next : iterator) {
        }
        next = selectedProtocol;
        if ((SocketAdapter)next != null) {
            selectedProtocol = (SocketAdapter)next.getSelectedProtocol(sSLSocket);
        }
        return selectedProtocol;
    }

    @Override // okhttp3.internal.platform.Platform
    public Object getStackTraceForCloseable(String string) {
        n.f(string, "closer");
        return this.closeGuard.createAndOpen(string);
    }

    @Override // okhttp3.internal.platform.Platform
    public boolean isCleartextTrafficPermitted(String string) {
        NetworkSecurityPolicy sDK_INT;
        boolean obj3;
        n.f(string, "hostname");
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 24) {
            obj3 = NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(string);
        } else {
            if (sDK_INT >= 23) {
                obj3 = NetworkSecurityPolicy.getInstance();
                n.e(obj3, "NetworkSecurityPolicy.getInstance()");
                obj3 = obj3.isCleartextTrafficPermitted();
            } else {
                obj3 = 1;
            }
        }
        return obj3;
    }

    @Override // okhttp3.internal.platform.Platform
    public void logCloseableLeak(String string, Object object2) {
        Object closeGuard;
        Object obj;
        int i2;
        int i3;
        int i4;
        int i;
        n.f(string, "message");
        if (!this.closeGuard.warnIfOpen(object2)) {
            Platform.log$default(this, string, 5, 0, 4, 0);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object next;
        int trustManager;
        boolean matchesSocketFactory;
        n.f(sSLSocketFactory, "sslSocketFactory");
        Iterator iterator = this.socketAdapters.iterator();
        for (Object next : iterator) {
        }
        next = trustManager;
        if ((SocketAdapter)next != null) {
            trustManager = (SocketAdapter)next.trustManager(sSLSocketFactory);
        }
        return trustManager;
    }
}
