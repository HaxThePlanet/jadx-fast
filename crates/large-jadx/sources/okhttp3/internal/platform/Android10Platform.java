package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
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
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.Android10SocketAdapter.Companion;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner.Companion;
import okhttp3.internal.platform.android.AndroidSocketAdapter;
import okhttp3.internal.platform.android.AndroidSocketAdapter.Companion;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter;
import okhttp3.internal.platform.android.BouncyCastleSocketAdapter.Companion;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter.Companion;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0008\u001a\u00020\u00072\u0008\u0010\n\u001a\u0004\u0018\u00010\t2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0008\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u001b¨\u0006\u001f", d2 = {"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "", "isCleartextTrafficPermitted", "(Ljava/lang/String;)Z", "Lokhttp3/internal/tls/CertificateChainCleaner;", "buildCertificateChainCleaner", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "Lokhttp3/internal/platform/android/SocketAdapter;", "socketAdapters", "Ljava/util/List;", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Android10Platform extends okhttp3.internal.platform.Platform {

    public static final okhttp3.internal.platform.Android10Platform.Companion Companion;
    private static final boolean isSupported = false;
    private final List<SocketAdapter> socketAdapters;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0019\u0010\u0006\u001a\u00020\u00058\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0006\u0010\u0008¨\u0006\u000b", d2 = {"Lokhttp3/internal/platform/Android10Platform$Companion;", "", "Lokhttp3/internal/platform/Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Platform;", "", "isSupported", "Z", "()Z", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.Platform buildIfSupported() {
            okhttp3.internal.platform.Android10Platform android10Platform;
            if (isSupported()) {
                android10Platform = new Android10Platform();
            } else {
                android10Platform = 0;
            }
            return android10Platform;
        }

        public final boolean isSupported() {
            return Android10Platform.access$isSupported$cp();
        }
    }
    static {
        boolean sDK_INT;
        int i;
        Android10Platform.Companion companion = new Android10Platform.Companion(0);
        Android10Platform.Companion = companion;
        if (Platform.Companion.isAndroid() && Build.VERSION.SDK_INT >= 29) {
            if (Build.VERSION.SDK_INT >= 29) {
                int i3 = 1;
            }
        }
        int i2 = 0;
    }

    public Android10Platform() {
        int next;
        boolean supported;
        super();
        SocketAdapter[] arr = new SocketAdapter[4];
        DeferredSocketAdapter deferredSocketAdapter = new DeferredSocketAdapter(AndroidSocketAdapter.Companion.getPlayProviderFactory());
        DeferredSocketAdapter deferredSocketAdapter2 = new DeferredSocketAdapter(ConscryptSocketAdapter.Companion.getFactory());
        DeferredSocketAdapter deferredSocketAdapter3 = new DeferredSocketAdapter(BouncyCastleSocketAdapter.Companion.getFactory());
        ArrayList arrayList = new ArrayList();
        Iterator iterator = p.l(Android10SocketAdapter.Companion.buildIfSupported(), deferredSocketAdapter, deferredSocketAdapter2, deferredSocketAdapter3).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((SocketAdapter)next.isSupported()) {
            }
            arrayList.add(next);
        }
        this.socketAdapters = arrayList;
    }

    public static final boolean access$isSupported$cp() {
        return Android10Platform.isSupported;
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

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<? extends Protocol> list3) {
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
    public boolean isCleartextTrafficPermitted(String string) {
        n.f(string, "hostname");
        return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(string);
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
