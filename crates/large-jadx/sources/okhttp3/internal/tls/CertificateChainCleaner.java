package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008&\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\u0008\t\u0010\nJ+\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\u000c", d2 = {"Lokhttp3/internal/tls/CertificateChainCleaner;", "", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public abstract class CertificateChainCleaner {

    public static final okhttp3.internal.tls.CertificateChainCleaner.Companion Companion;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J!\u0010\u0005\u001a\u00020\u00042\u0012\u0010\t\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0007\"\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\n¨\u0006\r", d2 = {"Lokhttp3/internal/tls/CertificateChainCleaner$Companion;", "", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "Lokhttp3/internal/tls/CertificateChainCleaner;", "get", "(Ljavax/net/ssl/X509TrustManager;)Lokhttp3/internal/tls/CertificateChainCleaner;", "", "Ljava/security/cert/X509Certificate;", "caCerts", "([Ljava/security/cert/X509Certificate;)Lokhttp3/internal/tls/CertificateChainCleaner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.tls.CertificateChainCleaner get(X509TrustManager x509TrustManager) {
            n.f(x509TrustManager, "trustManager");
            return Platform.Companion.get().buildCertificateChainCleaner(x509TrustManager);
        }

        public final okhttp3.internal.tls.CertificateChainCleaner get(X509Certificate... x509CertificateArr) {
            n.f(x509CertificateArr, "caCerts");
            BasicTrustRootIndex basicTrustRootIndex = new BasicTrustRootIndex((X509Certificate[])Arrays.copyOf(x509CertificateArr, x509CertificateArr.length));
            BasicCertificateChainCleaner basicCertificateChainCleaner = new BasicCertificateChainCleaner(basicTrustRootIndex);
            return basicCertificateChainCleaner;
        }
    }
    static {
        CertificateChainCleaner.Companion companion = new CertificateChainCleaner.Companion(0);
        CertificateChainCleaner.Companion = companion;
    }

    public abstract List<Certificate> clean(List<? extends Certificate> list, String string2);
}
