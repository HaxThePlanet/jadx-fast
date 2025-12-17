package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0014\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u0013\"\u00020\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000c\u001a\u00020\u000bH\u0016¢\u0006\u0004\u0008\u000c\u0010\rR(\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u00100\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012¨\u0006\u0017", d2 = {"Lokhttp3/internal/tls/BasicTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "Ljava/security/cert/X509Certificate;", "cert", "findByIssuerAndSignature", "(Ljava/security/cert/X509Certificate;)Ljava/security/cert/X509Certificate;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "Ljavax/security/auth/x500/X500Principal;", "", "subjectToCaCerts", "Ljava/util/Map;", "", "caCerts", "<init>", "([Ljava/security/cert/X509Certificate;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class BasicTrustRootIndex implements okhttp3.internal.tls.TrustRootIndex {

    private final Map<X500Principal, Set<X509Certificate>> subjectToCaCerts;
    public BasicTrustRootIndex(X509Certificate... x509CertificateArr) {
        int i;
        Object obj;
        X500Principal subjectX500Principal;
        Object linkedHashSet;
        n.f(x509CertificateArr, "caCerts");
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i = 0;
        while (i < x509CertificateArr.length) {
            obj = x509CertificateArr[i];
            subjectX500Principal = obj.getSubjectX500Principal();
            n.e(subjectX500Principal, "caCert.subjectX500Principal");
            if (linkedHashMap.get(subjectX500Principal) == null) {
            }
            (Set)linkedHashSet.add(obj);
            i++;
            linkedHashSet = new LinkedHashSet();
            linkedHashMap.put(subjectX500Principal, linkedHashSet);
        }
        this.subjectToCaCerts = linkedHashMap;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public boolean equals(Object object) {
        boolean subjectToCaCerts;
        Object obj2;
        if (object != this) {
            if (object instanceof BasicTrustRootIndex && n.b(object.subjectToCaCerts, this.subjectToCaCerts)) {
                if (n.b(object.subjectToCaCerts, this.subjectToCaCerts)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public X509Certificate findByIssuerAndSignature(X509Certificate x509Certificate) {
        Object iterator;
        int i2;
        Object next;
        int i;
        n.f(x509Certificate, "cert");
        iterator = this.subjectToCaCerts.get(x509Certificate.getIssuerX500Principal());
        i2 = 0;
        if ((Set)iterator != null) {
            iterator = (Set)iterator.iterator();
            for (Object next : iterator) {
                x509Certificate.verify((X509Certificate)next.getPublicKey());
                i = 1;
                if (i != 0) {
                    break;
                } else {
                }
                i = 0;
            }
        }
        return i2;
    }

    @Override // okhttp3.internal.tls.TrustRootIndex
    public int hashCode() {
        return this.subjectToCaCerts.hashCode();
    }
}
