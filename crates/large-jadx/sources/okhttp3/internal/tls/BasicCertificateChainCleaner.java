package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J+\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u0006\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00052\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\u00020\u00168\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0018¨\u0006\u001c", d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "Ljava/security/cert/X509Certificate;", "toVerify", "signingCert", "", "verifySignature", "(Ljava/security/cert/X509Certificate;Ljava/security/cert/X509Certificate;)Z", "", "Ljava/security/cert/Certificate;", "chain", "", "hostname", "clean", "(Ljava/util/List;Ljava/lang/String;)Ljava/util/List;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Lokhttp3/internal/tls/TrustRootIndex;", "trustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "<init>", "(Lokhttp3/internal/tls/TrustRootIndex;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BasicCertificateChainCleaner extends okhttp3.internal.tls.CertificateChainCleaner {

    public static final okhttp3.internal.tls.BasicCertificateChainCleaner.Companion Companion = null;
    private static final int MAX_SIGNERS = 9;
    private final okhttp3.internal.tls.TrustRootIndex trustRootIndex;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/tls/BasicCertificateChainCleaner$Companion;", "", "", "MAX_SIGNERS", "I", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        BasicCertificateChainCleaner.Companion companion = new BasicCertificateChainCleaner.Companion(0);
        BasicCertificateChainCleaner.Companion = companion;
    }

    public BasicCertificateChainCleaner(okhttp3.internal.tls.TrustRootIndex trustRootIndex) {
        n.f(trustRootIndex, "trustRootIndex");
        super();
        this.trustRootIndex = trustRootIndex;
    }

    private final boolean verifySignature(X509Certificate x509Certificate, X509Certificate x509Certificate2) {
        int i;
        if (z ^= i != 0) {
            return 0;
        }
        x509Certificate.verify(x509Certificate2.getPublicKey());
        return i;
    }

    public List<Certificate> clean(List<? extends Certificate> list, String string2) {
        int i;
        int i2;
        int size;
        Object obj;
        int iterator;
        String str;
        X509Certificate byIssuerAndSignature;
        boolean verifySignature;
        n.f(list, "chain");
        n.f(string2, "hostname");
        ArrayDeque obj9 = new ArrayDeque(list);
        ArrayList obj8 = new ArrayList();
        Object first = obj9.removeFirst();
        n.e(first, "queue.removeFirst()");
        obj8.add(first);
        i2 = i;
        while (i < 9) {
            iterator = 1;
            obj = obj8.get(size2 -= iterator);
            str = "null cannot be cast to non-null type java.security.cert.X509Certificate";
            Objects.requireNonNull(obj, str);
            byIssuerAndSignature = this.trustRootIndex.findByIssuerAndSignature((X509Certificate)obj);
            iterator = obj9.iterator();
            n.e(iterator, "queue.iterator()");
            for (Object byIssuerAndSignature : iterator) {
                Objects.requireNonNull(byIssuerAndSignature, str);
            }
            byIssuerAndSignature = iterator.next();
            Objects.requireNonNull(byIssuerAndSignature, str);
            iterator.remove();
            obj8.add(byIssuerAndSignature);
            i++;
            if (obj8.size() <= iterator) {
            } else {
            }
            obj8.add(byIssuerAndSignature);
            i2 = iterator;
            if (z ^= iterator != 0) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Certificate chain too long: ");
        stringBuilder.append(obj8);
        obj9 = new SSLPeerUnverifiedException(stringBuilder.toString());
        throw obj9;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public boolean equals(Object object) {
        int i;
        okhttp3.internal.tls.TrustRootIndex trustRootIndex;
        Object obj3;
        i = 1;
        if (object == this) {
        } else {
            if (object instanceof BasicCertificateChainCleaner && n.b(object.trustRootIndex, this.trustRootIndex)) {
                if (n.b(object.trustRootIndex, this.trustRootIndex)) {
                } else {
                    i = 0;
                }
            } else {
            }
        }
        return i;
    }

    @Override // okhttp3.internal.tls.CertificateChainCleaner
    public int hashCode() {
        return this.trustRootIndex.hashCode();
    }
}
