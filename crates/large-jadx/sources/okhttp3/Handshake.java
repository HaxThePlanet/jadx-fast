package okhttp3;

import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h;
import kotlin.j;
import kotlin.y.p;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 -2\u00020\u0001:\u0001-B;\u0008\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u000c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0012\u0010*\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\n0)¢\u0006\u0004\u0008+\u0010,J\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\u0008\u000c\u0010\rJ\u0011\u0010\u0012\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0007¢\u0006\u0004\u0008\u0013\u0010\rJ\u0011\u0010\u0016\u001a\u0004\u0018\u00010\u000fH\u0007¢\u0006\u0004\u0008\u0015\u0010\u0011J\u001a\u0010\u0019\u001a\u00020\u00182\u0008\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\u0008\u001f\u0010 R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010!\u001a\u0004\u0008\u0005\u0010\u0004R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0011R\u001a\u0010$\u001a\u00020\u001e*\u00020\u000b8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010%\u001a\u0004\u0008\t\u0010\u0008R\u001f\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0014\u0010&\u001a\u0004\u0008\u0014\u0010\rR#\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8G@\u0006X\u0086\u0084\u0002¢\u0006\u000c\n\u0004\u0008'\u0010(\u001a\u0004\u0008\u000e\u0010\rR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u000f8G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0011¨\u0006.", d2 = {"Lokhttp3/Handshake;", "", "Lokhttp3/TlsVersion;", "-deprecated_tlsVersion", "()Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "-deprecated_cipherSuite", "()Lokhttp3/CipherSuite;", "cipherSuite", "", "Ljava/security/cert/Certificate;", "-deprecated_peerCertificates", "()Ljava/util/List;", "peerCertificates", "Ljava/security/Principal;", "-deprecated_peerPrincipal", "()Ljava/security/Principal;", "peerPrincipal", "-deprecated_localCertificates", "localCertificates", "-deprecated_localPrincipal", "localPrincipal", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lokhttp3/TlsVersion;", "getName", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "name", "Lokhttp3/CipherSuite;", "Ljava/util/List;", "peerCertificates$delegate", "Lkotlin/h;", "Lkotlin/Function0;", "peerCertificatesFn", "<init>", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Lkotlin/d0/c/a;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Handshake {

    public static final okhttp3.Handshake.Companion Companion;
    private final okhttp3.CipherSuite cipherSuite;
    private final List<Certificate> localCertificates;
    private final h peerCertificates$delegate;
    private final okhttp3.TlsVersion tlsVersion;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J#\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0004*\u000c\u0012\u0006\u0008\u0001\u0012\u00020\u0003\u0018\u00010\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u0008*\u00020\u0007H\u0007¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\t\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u0007H\u0007¢\u0006\u0004\u0008\r\u0010\nJ;\u0010\t\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00042\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0004H\u0007¢\u0006\u0004\u0008\t\u0010\u0014¨\u0006\u0017", d2 = {"Lokhttp3/Handshake$Companion;", "", "", "Ljava/security/cert/Certificate;", "", "toImmutableList", "([Ljava/security/cert/Certificate;)Ljava/util/List;", "Ljavax/net/ssl/SSLSession;", "Lokhttp3/Handshake;", "get", "(Ljavax/net/ssl/SSLSession;)Lokhttp3/Handshake;", "handshake", "sslSession", "-deprecated_get", "Lokhttp3/TlsVersion;", "tlsVersion", "Lokhttp3/CipherSuite;", "cipherSuite", "peerCertificates", "localCertificates", "(Lokhttp3/TlsVersion;Lokhttp3/CipherSuite;Ljava/util/List;Ljava/util/List;)Lokhttp3/Handshake;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        private final List<Certificate> toImmutableList(Certificate[] certificateArr) {
            int length;
            List obj2;
            if (certificateArr != null) {
                obj2 = Util.immutableListOf((Certificate[])Arrays.copyOf(certificateArr, certificateArr.length));
            } else {
                obj2 = p.g();
            }
            return obj2;
        }

        public final okhttp3.Handshake -deprecated_get(SSLSession sSLSession) {
            n.f(sSLSession, "sslSession");
            return get(sSLSession);
        }

        public final okhttp3.Handshake get(SSLSession sSLSession) {
            boolean equals;
            int i;
            List immutableList;
            n.f(sSLSession, "$this$handshake");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
            } else {
                equals = cipherSuite.hashCode();
                if (equals != 1019404634) {
                    if (equals != 1208658923) {
                        String protocol = sSLSession.getProtocol();
                        if (protocol == null) {
                        } else {
                            if (n.b("NONE", protocol)) {
                            } else {
                                immutableList = toImmutableList(sSLSession.getPeerCertificates());
                                Handshake.Companion.handshake.1 anon = new Handshake.Companion.handshake.1(immutableList);
                                Handshake handshake = new Handshake(TlsVersion.Companion.forJavaName(protocol), CipherSuite.Companion.forJavaName(cipherSuite), toImmutableList(sSLSession.getLocalCertificates()), anon);
                                return handshake;
                            }
                            IOException obj6 = new IOException("tlsVersion == NONE");
                            throw obj6;
                        }
                        obj6 = new IllegalStateException("tlsVersion == null".toString());
                        throw obj6;
                    } else {
                        if (cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                        } else {
                        }
                    }
                } else {
                    if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL")) {
                    } else {
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("cipherSuite == ");
                stringBuilder.append(cipherSuite);
                obj6 = new IOException(stringBuilder.toString());
                throw obj6;
            }
            obj6 = new IllegalStateException("cipherSuite == null".toString());
            throw obj6;
        }

        public final okhttp3.Handshake get(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite2, List<? extends Certificate> list3, List<? extends Certificate> list4) {
            n.f(tlsVersion, "tlsVersion");
            n.f(cipherSuite2, "cipherSuite");
            n.f(list3, "peerCertificates");
            n.f(list4, "localCertificates");
            Handshake.Companion.get.1 anon = new Handshake.Companion.get.1(Util.toImmutableList(list3));
            Handshake handshake = new Handshake(tlsVersion, cipherSuite2, Util.toImmutableList(list4), anon);
            return handshake;
        }
    }
    static {
        Handshake.Companion companion = new Handshake.Companion(0);
        Handshake.Companion = companion;
    }

    public Handshake(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite2, List<? extends Certificate> list3, a<? extends List<? extends Certificate>> a4) {
        n.f(tlsVersion, "tlsVersion");
        n.f(cipherSuite2, "cipherSuite");
        n.f(list3, "localCertificates");
        n.f(a4, "peerCertificatesFn");
        super();
        this.tlsVersion = tlsVersion;
        this.cipherSuite = cipherSuite2;
        this.localCertificates = list3;
        Handshake.peerCertificates.2 obj2 = new Handshake.peerCertificates.2(a4);
        this.peerCertificates$delegate = j.b(obj2);
    }

    public static final okhttp3.Handshake get(SSLSession sSLSession) {
        return Handshake.Companion.get(sSLSession);
    }

    public static final okhttp3.Handshake get(okhttp3.TlsVersion tlsVersion, okhttp3.CipherSuite cipherSuite2, List<? extends Certificate> list3, List<? extends Certificate> list4) {
        return Handshake.Companion.get(tlsVersion, cipherSuite2, list3, list4);
    }

    private final String getName(Certificate certificate) {
        boolean str;
        String obj2;
        if (certificate instanceof X509Certificate) {
            obj2 = (X509Certificate)certificate.getSubjectDN().toString();
        } else {
            n.e(certificate.getType(), "type");
        }
        return obj2;
    }

    public final okhttp3.CipherSuite -deprecated_cipherSuite() {
        return this.cipherSuite;
    }

    public final List<Certificate> -deprecated_localCertificates() {
        return this.localCertificates;
    }

    public final Principal -deprecated_localPrincipal() {
        return localPrincipal();
    }

    public final List<Certificate> -deprecated_peerCertificates() {
        return peerCertificates();
    }

    public final Principal -deprecated_peerPrincipal() {
        return peerPrincipal();
    }

    public final okhttp3.TlsVersion -deprecated_tlsVersion() {
        return this.tlsVersion;
    }

    public final okhttp3.CipherSuite cipherSuite() {
        return this.cipherSuite;
    }

    public boolean equals(Object object) {
        boolean localCertificates;
        Object peerCertificates;
        int obj3;
        if (object instanceof Handshake && object.tlsVersion == this.tlsVersion && n.b(object.cipherSuite, this.cipherSuite) && n.b((Handshake)object.peerCertificates(), peerCertificates()) && n.b(object.localCertificates, this.localCertificates)) {
            if (object.tlsVersion == this.tlsVersion) {
                if (n.b(object.cipherSuite, this.cipherSuite)) {
                    if (n.b((Handshake)object.peerCertificates(), peerCertificates())) {
                        obj3 = n.b(object.localCertificates, this.localCertificates) ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public int hashCode() {
        return i11 += i4;
    }

    public final List<Certificate> localCertificates() {
        return this.localCertificates;
    }

    public final Principal localPrincipal() {
        Object obj;
        int subjectX500Principal;
        if (!obj instanceof X509Certificate) {
            obj = subjectX500Principal;
        }
        if ((X509Certificate)obj != null) {
            subjectX500Principal = (X509Certificate)obj.getSubjectX500Principal();
        }
        return subjectX500Principal;
    }

    public final List<Certificate> peerCertificates() {
        return (List)this.peerCertificates$delegate.getValue();
    }

    public final Principal peerPrincipal() {
        Object obj;
        int subjectX500Principal;
        if (!obj instanceof X509Certificate) {
            obj = subjectX500Principal;
        }
        if ((X509Certificate)obj != null) {
            subjectX500Principal = (X509Certificate)obj.getSubjectX500Principal();
        }
        return subjectX500Principal;
    }

    public final okhttp3.TlsVersion tlsVersion() {
        return this.tlsVersion;
    }

    public String toString() {
        int name2;
        int name;
        List peerCertificates = peerCertificates();
        int i2 = 10;
        ArrayList arrayList = new ArrayList(p.r(peerCertificates, i2));
        Iterator iterator = peerCertificates.iterator();
        for (Certificate next4 : iterator) {
            arrayList.add(getName(next4));
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Handshake{");
        stringBuilder.append("tlsVersion=");
        stringBuilder.append(this.tlsVersion);
        int i3 = 32;
        stringBuilder.append(i3);
        stringBuilder.append("cipherSuite=");
        stringBuilder.append(this.cipherSuite);
        stringBuilder.append(i3);
        stringBuilder.append("peerCertificates=");
        stringBuilder.append(arrayList.toString());
        stringBuilder.append(i3);
        stringBuilder.append("localCertificates=");
        List localCertificates = this.localCertificates;
        ArrayList arrayList2 = new ArrayList(p.r(localCertificates, i2));
        Iterator iterator2 = localCertificates.iterator();
        for (Certificate next2 : iterator2) {
            arrayList2.add(getName(next2));
        }
        stringBuilder.append(arrayList2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
