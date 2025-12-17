package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.internal.SuppressSignatureCheck;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\u0008\u0017\u0010\u0018J+\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001a\u0010\u000c\u001a\u00020\u000b2\u0008\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002¢\u0006\u0004\u0008\u000c\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016¨\u0006\u001a", d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Landroid/net/http/X509TrustManagerExtensions;", "x509TrustManagerExtensions", "Landroid/net/http/X509TrustManagerExtensions;", "<init>", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class AndroidCertificateChainCleaner extends CertificateChainCleaner {

    public static final okhttp3.internal.platform.android.AndroidCertificateChainCleaner.Companion Companion;
    private final X509TrustManager trustManager;
    private final X509TrustManagerExtensions x509TrustManagerExtensions;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "buildIfSupported", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.android.AndroidCertificateChainCleaner buildIfSupported(X509TrustManager x509TrustManager) {
            int androidCertificateChainCleaner;
            X509TrustManagerExtensions x509TrustManagerExtensions;
            n.f(x509TrustManager, "trustManager");
            androidCertificateChainCleaner = 0;
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            if (x509TrustManagerExtensions != null) {
                androidCertificateChainCleaner = new AndroidCertificateChainCleaner(x509TrustManager, x509TrustManagerExtensions);
            }
            return androidCertificateChainCleaner;
        }
    }
    static {
        AndroidCertificateChainCleaner.Companion companion = new AndroidCertificateChainCleaner.Companion(0);
        AndroidCertificateChainCleaner.Companion = companion;
    }

    public AndroidCertificateChainCleaner(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions2) {
        n.f(x509TrustManager, "trustManager");
        n.f(x509TrustManagerExtensions2, "x509TrustManagerExtensions");
        super();
        this.trustManager = x509TrustManager;
        this.x509TrustManagerExtensions = x509TrustManagerExtensions2;
    }

    public List<Certificate> clean(List<? extends Certificate> list, String string2) {
        n.f(list, "chain");
        n.f(string2, "hostname");
        Object[] obj3 = list.toArray(new X509Certificate[0]);
        Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<T>");
        obj3 = this.x509TrustManagerExtensions.checkServerTrusted((X509Certificate[])obj3, "RSA", string2);
        n.e(obj3, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
        return obj3;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public boolean equals(Object object) {
        boolean trustManager;
        Object obj2;
        if (object instanceof AndroidCertificateChainCleaner && object.trustManager == this.trustManager) {
            obj2 = object.trustManager == this.trustManager ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public int hashCode() {
        return System.identityHashCode(this.trustManager);
    }
}
