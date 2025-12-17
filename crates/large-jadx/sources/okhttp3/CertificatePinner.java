package okhttp3;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.g0;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.i;
import kotlin.y.p;
import l.i;
import l.i.a;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\"\n\u0002\u0008\n\u0018\u0000 *2\u00020\u0001:\u0003+*,B#\u0008\u0000\u0012\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00110#\u0012\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\u0008(\u0010)J#\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\u0008\u0008\u0010\tJ+\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000b0\u00040\nH\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ+\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u000f\"\u00020\u0005H\u0007¢\u0006\u0004\u0008\u0008\u0010\u0010J\u001b\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014H\u0000¢\u0006\u0004\u0008\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\u0008\u001e\u0010\u001fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u0015\u0010 \u001a\u0004\u0008!\u0010\"R\u001f\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00110#8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008$\u0010%\u001a\u0004\u0008&\u0010'¨\u0006-", d2 = {"Lokhttp3/CertificatePinner;", "", "", "hostname", "", "Ljava/security/cert/Certificate;", "peerCertificates", "Lkotlin/w;", "check", "(Ljava/lang/String;Ljava/util/List;)V", "Lkotlin/Function0;", "Ljava/security/cert/X509Certificate;", "cleanedPeerCertificatesFn", "check$okhttp", "(Ljava/lang/String;Lkotlin/d0/c/a;)V", "", "(Ljava/lang/String;[Ljava/security/cert/Certificate;)V", "Lokhttp3/CertificatePinner$Pin;", "findMatchingPins", "(Ljava/lang/String;)Ljava/util/List;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "certificateChainCleaner", "withCertificateChainCleaner$okhttp", "(Lokhttp3/internal/tls/CertificateChainCleaner;)Lokhttp3/CertificatePinner;", "withCertificateChainCleaner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Lokhttp3/internal/tls/CertificateChainCleaner;", "getCertificateChainCleaner$okhttp", "()Lokhttp3/internal/tls/CertificateChainCleaner;", "", "pins", "Ljava/util/Set;", "getPins", "()Ljava/util/Set;", "<init>", "(Ljava/util/Set;Lokhttp3/internal/tls/CertificateChainCleaner;)V", "Companion", "Builder", "Pin", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CertificatePinner {

    public static final okhttp3.CertificatePinner.Companion Companion;
    public static final okhttp3.CertificatePinner DEFAULT;
    private final CertificateChainCleaner certificateChainCleaner;
    private final Set<okhttp3.CertificatePinner.Pin> pins;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0010\u0010\u0011J)\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0005\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u0004\"\u00020\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\t\u0010\nR\u001f\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\r\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0012", d2 = {"Lokhttp3/CertificatePinner$Builder;", "", "", "pattern", "", "pins", "add", "(Ljava/lang/String;[Ljava/lang/String;)Lokhttp3/CertificatePinner$Builder;", "Lokhttp3/CertificatePinner;", "build", "()Lokhttp3/CertificatePinner;", "", "Lokhttp3/CertificatePinner$Pin;", "Ljava/util/List;", "getPins", "()Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private final List<okhttp3.CertificatePinner.Pin> pins;
        public Builder() {
            super();
            ArrayList arrayList = new ArrayList();
            this.pins = arrayList;
        }

        public final okhttp3.CertificatePinner.Builder add(String string, String... string2Arr2) {
            int i;
            Object obj;
            List pins;
            okhttp3.CertificatePinner.Pin pin;
            n.f(string, "pattern");
            n.f(string2Arr2, "pins");
            i = 0;
            while (i < string2Arr2.length) {
                pin = new CertificatePinner.Pin(string, string2Arr2[i]);
                this.pins.add(pin);
                i++;
            }
            return this;
        }

        public final okhttp3.CertificatePinner build() {
            final int i = 0;
            CertificatePinner certificatePinner = new CertificatePinner(p.P0(this.pins), i, 2, i);
            return certificatePinner;
        }

        public final List<okhttp3.CertificatePinner.Pin> getPins() {
            return this.pins;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0005J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\u0007H\u0007¢\u0006\u0004\u0008\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\u000c8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000e¨\u0006\u0011", d2 = {"Lokhttp3/CertificatePinner$Companion;", "", "Ljava/security/cert/X509Certificate;", "Ll/i;", "sha1Hash", "(Ljava/security/cert/X509Certificate;)Ll/i;", "sha256Hash", "Ljava/security/cert/Certificate;", "certificate", "", "pin", "(Ljava/security/cert/Certificate;)Ljava/lang/String;", "Lokhttp3/CertificatePinner;", "DEFAULT", "Lokhttp3/CertificatePinner;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final String pin(Certificate certificate) {
            n.f(certificate, "certificate");
            if (!certificate instanceof X509Certificate) {
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("sha256/");
                stringBuilder.append(sha256Hash((X509Certificate)certificate).a());
                return stringBuilder.toString();
            }
            IllegalArgumentException obj3 = new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            throw obj3;
        }

        public final i sha1Hash(X509Certificate x509Certificate) {
            n.f(x509Certificate, "$this$sha1Hash");
            PublicKey obj8 = x509Certificate.getPublicKey();
            n.e(obj8, "publicKey");
            final byte[] encoded = obj8.getEncoded();
            n.e(encoded, "publicKey.encoded");
            return i.a.g(i.v, encoded, 0, 0, 3, 0).y();
        }

        public final i sha256Hash(X509Certificate x509Certificate) {
            n.f(x509Certificate, "$this$sha256Hash");
            PublicKey obj8 = x509Certificate.getPublicKey();
            n.e(obj8, "publicKey");
            final byte[] encoded = obj8.getEncoded();
            n.e(encoded, "publicKey.encoded");
            return i.a.g(i.v, encoded, 0, 0, 3, 0).z();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\u0002¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u001a\u0010\u000e\u001a\u00020\u00042\u0008\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\u00020\u00138\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017R\u0019\u0010\u0018\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0018\u0010\u0019\u001a\u0004\u0008\u001a\u0010\u000cR\u0019\u0010\u001b\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001b\u0010\u0019\u001a\u0004\u0008\u001c\u0010\u000c¨\u0006 ", d2 = {"Lokhttp3/CertificatePinner$Pin;", "", "", "hostname", "", "matchesHostname", "(Ljava/lang/String;)Z", "Ljava/security/cert/X509Certificate;", "certificate", "matchesCertificate", "(Ljava/security/cert/X509Certificate;)Z", "toString", "()Ljava/lang/String;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "Ll/i;", "hash", "Ll/i;", "getHash", "()Ll/i;", "pattern", "Ljava/lang/String;", "getPattern", "hashAlgorithm", "getHashAlgorithm", "pin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Pin {

        private final i hash;
        private final String hashAlgorithm;
        private final String pattern;
        public Pin(String string, String string2) {
            int i2;
            boolean z;
            String substring;
            Object obj;
            String str;
            int i3;
            int i;
            int i4;
            int i5;
            i obj12;
            n.f(string, "pattern");
            n.f(string2, "pin");
            super();
            int i6 = 0;
            final int i9 = 2;
            final int i10 = 0;
            int i11 = -1;
            if (l.M(string, "*.", i6, i9, i10)) {
                if (l.e0(string, "*", 1, false, 4, 0) != i11) {
                    if (l.M(string, "**.", i6, i9, i10)) {
                        if (l.e0(string, "*", 2, false, 4, 0) != i11) {
                            i2 = l.e0(string, "*", 0, false, 6, 0) == i11 ? 1 : i6;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (i2 == 0) {
            } else {
                String canonicalHost = HostnamesKt.toCanonicalHost(string);
                if (canonicalHost == null) {
                } else {
                    this.pattern = canonicalHost;
                    String str6 = "Invalid pin hash: ";
                    String str10 = "(this as java.lang.String).substring(startIndex)";
                    if (l.M(string2, "sha1/", i6, i9, i10)) {
                        this.hashAlgorithm = "sha1";
                        substring = string2.substring(5);
                        n.e(substring, str10);
                        obj12 = i.v.a(substring);
                        if (obj12 == null) {
                        } else {
                            this.hash = obj12;
                        }
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(str6);
                        stringBuilder3.append(string2);
                        obj12 = new IllegalArgumentException(stringBuilder3.toString());
                        throw obj12;
                    }
                    if (!l.M(string2, "sha256/", i6, i9, i10)) {
                    } else {
                        this.hashAlgorithm = "sha256";
                        substring = string2.substring(7);
                        n.e(substring, str10);
                        obj12 = i.v.a(substring);
                        if (obj12 == null) {
                        } else {
                            this.hash = obj12;
                        }
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(str6);
                        stringBuilder4.append(string2);
                        obj12 = new IllegalArgumentException(stringBuilder4.toString());
                        throw obj12;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("pins must start with 'sha256/' or 'sha1/': ");
                    stringBuilder.append(string2);
                    obj12 = new IllegalArgumentException(stringBuilder.toString());
                    throw obj12;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Invalid pattern: ");
                stringBuilder2.append(string);
                IllegalArgumentException obj13 = new IllegalArgumentException(stringBuilder2.toString());
                throw obj13;
            }
            obj13 = new StringBuilder();
            obj13.append("Unexpected pattern: ");
            obj13.append(string);
            obj13 = new IllegalArgumentException(obj13.toString().toString());
            throw obj13;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i4 = 0;
            if (!object instanceof CertificatePinner.Pin) {
                return i4;
            }
            if (z2 ^= i != 0) {
                return i4;
            }
            if (z3 ^= i != 0) {
                return i4;
            }
            if (obj5 ^= i != 0) {
                return i4;
            }
            return i;
        }

        public final i getHash() {
            return this.hash;
        }

        public final String getHashAlgorithm() {
            return this.hashAlgorithm;
        }

        public final String getPattern() {
            return this.pattern;
        }

        public int hashCode() {
            return i4 += i7;
        }

        public final boolean matchesCertificate(X509Certificate x509Certificate) {
            boolean hashAlgorithm;
            String companion;
            int i;
            int obj4;
            n.f(x509Certificate, "certificate");
            hashAlgorithm = this.hashAlgorithm;
            companion = hashAlgorithm.hashCode();
            if (companion != -903629273) {
                if (companion != 3528965) {
                    obj4 = 0;
                } else {
                    if (hashAlgorithm.equals("sha1")) {
                        obj4 = n.b(this.hash, CertificatePinner.Companion.sha1Hash(x509Certificate));
                    } else {
                    }
                }
            } else {
                if (hashAlgorithm.equals("sha256")) {
                    obj4 = n.b(this.hash, CertificatePinner.Companion.sha256Hash(x509Certificate));
                } else {
                }
            }
            return obj4;
        }

        public final boolean matchesHostname(String string) {
            int pattern;
            int i3;
            boolean i7;
            int i;
            String pattern2;
            int i4;
            int i6;
            int i8;
            int i2;
            int i5;
            Object obj12;
            n.f(string, "hostname");
            i3 = 0;
            i7 = 2;
            i = 0;
            int i10 = 1;
            if (l.M(this.pattern, "**.", i3, i7, i)) {
                i6 = length3 + -3;
                length4 -= i6;
                if (l.B(string, length6 - i6, this.pattern, 3, i6, false, 16, 0)) {
                    if (pattern != 0) {
                        if (string.charAt(pattern -= i10) == 46) {
                            i3 = i10;
                        }
                    } else {
                    }
                }
            } else {
            }
            return i3;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.hashAlgorithm);
            stringBuilder.append('/');
            stringBuilder.append(this.hash.a());
            return stringBuilder.toString();
        }
    }
    static {
        CertificatePinner.Companion companion = new CertificatePinner.Companion(0);
        CertificatePinner.Companion = companion;
        CertificatePinner.Builder builder = new CertificatePinner.Builder();
        CertificatePinner.DEFAULT = builder.build();
    }

    public CertificatePinner(Set<okhttp3.CertificatePinner.Pin> set, CertificateChainCleaner certificateChainCleaner2) {
        n.f(set, "pins");
        super();
        this.pins = set;
        this.certificateChainCleaner = certificateChainCleaner2;
    }

    public CertificatePinner(Set set, CertificateChainCleaner certificateChainCleaner2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(set, obj2);
    }

    public static final String pin(Certificate certificate) {
        return CertificatePinner.Companion.pin(certificate);
    }

    public static final i sha1Hash(X509Certificate x509Certificate) {
        return CertificatePinner.Companion.sha1Hash(x509Certificate);
    }

    public static final i sha256Hash(X509Certificate x509Certificate) {
        return CertificatePinner.Companion.sha256Hash(x509Certificate);
    }

    public final void check(String string, List<? extends Certificate> list2) {
        n.f(string, "hostname");
        n.f(list2, "peerCertificates");
        CertificatePinner.check.1 anon = new CertificatePinner.check.1(this, list2, string);
        check$okhttp(string, anon);
    }

    public final void check(String string, Certificate... certificate2Arr2) {
        n.f(string, "hostname");
        n.f(certificate2Arr2, "peerCertificates");
        check(string, i.a0(certificate2Arr2));
    }

    public final void check$okhttp(String string, a<? extends List<? extends X509Certificate>> a2) {
        Object next;
        String name;
        Iterator iterator;
        int sha256Hash;
        int sha1Hash;
        boolean next2;
        boolean hashAlgorithm;
        String str;
        int i;
        String obj12;
        n.f(string, "hostname");
        n.f(a2, "cleanedPeerCertificatesFn");
        List matchingPins = findMatchingPins(string);
        if (matchingPins.isEmpty()) {
        }
        obj12 = a2.invoke();
        Iterator iterator2 = (List)obj12.iterator();
        for (X509Certificate next : iterator2) {
            iterator = matchingPins.iterator();
            sha1Hash = sha256Hash;
            for (CertificatePinner.Pin next6 : iterator) {
                hashAlgorithm = next6.getHashAlgorithm();
                str = hashAlgorithm.hashCode();
                if (sha256Hash == 0) {
                }
                sha256Hash = CertificatePinner.Companion.sha256Hash(next);
                if (sha1Hash == 0) {
                }
                sha1Hash = CertificatePinner.Companion.sha1Hash(next);
            }
            Object next6 = iterator.next();
            hashAlgorithm = (CertificatePinner.Pin)next6.getHashAlgorithm();
            str = hashAlgorithm.hashCode();
            if (sha256Hash == 0) {
            }
            sha256Hash = CertificatePinner.Companion.sha256Hash(next);
            if (sha1Hash == 0) {
            }
            sha1Hash = CertificatePinner.Companion.sha1Hash(next);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Certificate pinning failure!");
        stringBuilder.append("\n  Peer certificate chain:");
        obj12 = obj12.iterator();
        String str6 = "\n    ";
        for (X509Certificate next5 : obj12) {
            stringBuilder.append(str6);
            stringBuilder.append(CertificatePinner.Companion.pin(next5));
            stringBuilder.append(": ");
            Principal subjectDN = next5.getSubjectDN();
            n.e(subjectDN, "element.subjectDN");
            stringBuilder.append(subjectDN.getName());
            str6 = "\n    ";
        }
        stringBuilder.append("\n  Pinned certificates for ");
        stringBuilder.append(string);
        stringBuilder.append(":");
        Iterator obj11 = matchingPins.iterator();
        for (CertificatePinner.Pin obj12 : obj11) {
            stringBuilder.append(str6);
            stringBuilder.append(obj12);
        }
        obj11 = stringBuilder.toString();
        n.e(obj11, "StringBuilder().apply(builderAction).toString()");
        obj12 = new SSLPeerUnverifiedException(obj11);
        throw obj12;
    }

    public boolean equals(Object object) {
        CertificateChainCleaner certificateChainCleaner;
        Set pins;
        int obj3;
        if (object instanceof CertificatePinner && n.b(object.pins, this.pins) && n.b(object.certificateChainCleaner, this.certificateChainCleaner)) {
            if (n.b(object.pins, this.pins)) {
                obj3 = n.b(object.certificateChainCleaner, this.certificateChainCleaner) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    public final List<okhttp3.CertificatePinner.Pin> findMatchingPins(String string) {
        List arrayList;
        Object next;
        boolean matchesHostname;
        n.f(string, "hostname");
        arrayList = p.g();
        Iterator iterator = this.pins.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((CertificatePinner.Pin)next.matchesHostname(string) && arrayList.isEmpty()) {
            }
            if (arrayList.isEmpty()) {
            }
            Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<T>");
            g0.b(arrayList).add(next);
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public final CertificateChainCleaner getCertificateChainCleaner$okhttp() {
        return this.certificateChainCleaner;
    }

    public final Set<okhttp3.CertificatePinner.Pin> getPins() {
        return this.pins;
    }

    public int hashCode() {
        int i;
        CertificateChainCleaner certificateChainCleaner = this.certificateChainCleaner;
        if (certificateChainCleaner != null) {
            i = certificateChainCleaner.hashCode();
        } else {
            i = 0;
        }
        return i5 += i;
    }

    public final okhttp3.CertificatePinner withCertificateChainCleaner$okhttp(CertificateChainCleaner certificateChainCleaner) {
        Object certificatePinner;
        Set pins;
        n.f(certificateChainCleaner, "certificateChainCleaner");
        if (n.b(this.certificateChainCleaner, certificateChainCleaner)) {
            certificatePinner = this;
        } else {
            certificatePinner = new CertificatePinner(this.pins, certificateChainCleaner);
        }
        return certificatePinner;
    }
}
