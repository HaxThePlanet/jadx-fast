package okhttp3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;
import kotlin.z.a;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0011\n\u0002\u0008\u0008\u0018\u0000 +2\u00020\u0001:\u0002,+B9\u0008\u0000\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%\u0012\u000e\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0004\u0008)\u0010*J\u001f\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0017\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0008H\u0007¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u0008H\u0007¢\u0006\u0004\u0008\u000e\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0007¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001f\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001a\u0010\u001b\u001a\u00020\u00042\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\u0008!\u0010\"R\u001b\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00088G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\u000bR\u001b\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00088G@\u0006¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u000bR\u0019\u0010#\u001a\u00020\u00048\u0007@\u0006¢\u0006\u000c\n\u0004\u0008#\u0010$\u001a\u0004\u0008#\u0010\u0011R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008&\u0010'R\u0019\u0010\u0012\u001a\u00020\u00048\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0012\u0010$\u001a\u0004\u0008\u0012\u0010\u0011R\u001e\u0010(\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010%8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008(\u0010'¨\u0006-", d2 = {"Lokhttp3/ConnectionSpec;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "isFallback", "supportedSpec", "(Ljavax/net/ssl/SSLSocket;Z)Lokhttp3/ConnectionSpec;", "", "Lokhttp3/CipherSuite;", "-deprecated_cipherSuites", "()Ljava/util/List;", "cipherSuites", "Lokhttp3/TlsVersion;", "-deprecated_tlsVersions", "tlsVersions", "-deprecated_supportsTlsExtensions", "()Z", "supportsTlsExtensions", "Lkotlin/w;", "apply$okhttp", "(Ljavax/net/ssl/SSLSocket;Z)V", "apply", "socket", "isCompatible", "(Ljavax/net/ssl/SSLSocket;)Z", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "isTls", "Z", "", "tlsVersionsAsString", "[Ljava/lang/String;", "cipherSuitesAsString", "<init>", "(ZZ[Ljava/lang/String;[Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class ConnectionSpec {

    private static final okhttp3.CipherSuite[] APPROVED_CIPHER_SUITES;
    public static final okhttp3.ConnectionSpec CLEARTEXT;
    public static final okhttp3.ConnectionSpec COMPATIBLE_TLS;
    public static final okhttp3.ConnectionSpec.Companion Companion;
    public static final okhttp3.ConnectionSpec MODERN_TLS;
    private static final okhttp3.CipherSuite[] RESTRICTED_CIPHER_SUITES;
    public static final okhttp3.ConnectionSpec RESTRICTED_TLS;
    private final String[] cipherSuitesAsString;
    private final boolean isTls;
    private final boolean supportsTlsExtensions;
    private final String[] tlsVersionsAsString;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0015\u0018\u00002\u00020\u0001B\u0011\u0008\u0010\u0012\u0006\u0010 \u001a\u00020\u000e¢\u0006\u0004\u0008#\u0010\u001dB\u0011\u0008\u0016\u0012\u0006\u0010$\u001a\u00020\u0011¢\u0006\u0004\u0008#\u0010%J\r\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\u0008\u0002\u0010\u0003J!\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0006\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00050\u0004\"\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J!\u0010\u0006\u001a\u00020\u00002\u0012\u0010\u0006\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0004\"\u00020\u0008¢\u0006\u0004\u0008\u0006\u0010\tJ\r\u0010\n\u001a\u00020\u0000¢\u0006\u0004\u0008\n\u0010\u0003J!\u0010\u000c\u001a\u00020\u00002\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000b0\u0004\"\u00020\u000b¢\u0006\u0004\u0008\u000c\u0010\rJ!\u0010\u000c\u001a\u00020\u00002\u0012\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0004\"\u00020\u0008¢\u0006\u0004\u0008\u000c\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\u0008\u0012\u0010\u0013R*\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0006\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0019\u001a\u0004\u0008\u001a\u0010\u001b\"\u0004\u0008\u001c\u0010\u001dR*\u0010\u000c\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000c\u0010\u0014\u001a\u0004\u0008\u001e\u0010\u0016\"\u0004\u0008\u001f\u0010\u0018R\"\u0010 \u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008 \u0010\u0019\u001a\u0004\u0008!\u0010\u001b\"\u0004\u0008\"\u0010\u001d¨\u0006&", d2 = {"Lokhttp3/ConnectionSpec$Builder;", "", "allEnabledCipherSuites", "()Lokhttp3/ConnectionSpec$Builder;", "", "Lokhttp3/CipherSuite;", "cipherSuites", "([Lokhttp3/CipherSuite;)Lokhttp3/ConnectionSpec$Builder;", "", "([Ljava/lang/String;)Lokhttp3/ConnectionSpec$Builder;", "allEnabledTlsVersions", "Lokhttp3/TlsVersion;", "tlsVersions", "([Lokhttp3/TlsVersion;)Lokhttp3/ConnectionSpec$Builder;", "", "supportsTlsExtensions", "(Z)Lokhttp3/ConnectionSpec$Builder;", "Lokhttp3/ConnectionSpec;", "build", "()Lokhttp3/ConnectionSpec;", "[Ljava/lang/String;", "getCipherSuites$okhttp", "()[Ljava/lang/String;", "setCipherSuites$okhttp", "([Ljava/lang/String;)V", "Z", "getSupportsTlsExtensions$okhttp", "()Z", "setSupportsTlsExtensions$okhttp", "(Z)V", "getTlsVersions$okhttp", "setTlsVersions$okhttp", "tls", "getTls$okhttp", "setTls$okhttp", "<init>", "connectionSpec", "(Lokhttp3/ConnectionSpec;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private String[] cipherSuites;
        private boolean supportsTlsExtensions;
        private boolean tls;
        private String[] tlsVersions;
        public Builder(okhttp3.ConnectionSpec connectionSpec) {
            n.f(connectionSpec, "connectionSpec");
            super();
            this.tls = connectionSpec.isTls();
            this.cipherSuites = ConnectionSpec.access$getCipherSuitesAsString$p(connectionSpec);
            this.tlsVersions = ConnectionSpec.access$getTlsVersionsAsString$p(connectionSpec);
            this.supportsTlsExtensions = connectionSpec.supportsTlsExtensions();
        }

        public Builder(boolean z) {
            super();
            this.tls = z;
        }

        public final okhttp3.ConnectionSpec.Builder allEnabledCipherSuites() {
            if (!this.tls) {
            } else {
                this.cipherSuites = 0;
                return this;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            throw illegalArgumentException;
        }

        public final okhttp3.ConnectionSpec.Builder allEnabledTlsVersions() {
            if (!this.tls) {
            } else {
                this.tlsVersions = 0;
                return this;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            throw illegalArgumentException;
        }

        public final okhttp3.ConnectionSpec build() {
            ConnectionSpec connectionSpec = new ConnectionSpec(this.tls, this.supportsTlsExtensions, this.cipherSuites, this.tlsVersions);
            return connectionSpec;
        }

        public final okhttp3.ConnectionSpec.Builder cipherSuites(String... stringArr) {
            int i;
            n.f(stringArr, "cipherSuites");
            if (!this.tls) {
            } else {
                final int i3 = 1;
                i = stringArr.length == 0 ? i3 : 0;
                if (i ^= i3 == 0) {
                } else {
                    Object obj3 = stringArr.clone();
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    this.cipherSuites = (String[])obj3;
                    return this;
                }
                obj3 = new IllegalArgumentException("At least one cipher suite is required".toString());
                throw obj3;
            }
            obj3 = new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            throw obj3;
        }

        public final okhttp3.ConnectionSpec.Builder cipherSuites(okhttp3.CipherSuite... cipherSuiteArr) {
            int i;
            String javaName;
            n.f(cipherSuiteArr, "cipherSuites");
            if (!this.tls) {
            } else {
                ArrayList arrayList = new ArrayList(cipherSuiteArr.length);
                final int i2 = 0;
                i = i2;
                while (i < cipherSuiteArr.length) {
                    arrayList.add(cipherSuiteArr[i].javaName());
                    i++;
                }
                Object[] obj6 = arrayList.toArray(new String[i2]);
                Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.Array<T>");
                return cipherSuites((String[])Arrays.copyOf((String[])obj6, obj6.length));
            }
            obj6 = new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            throw obj6;
        }

        public final String[] getCipherSuites$okhttp() {
            return this.cipherSuites;
        }

        public final boolean getSupportsTlsExtensions$okhttp() {
            return this.supportsTlsExtensions;
        }

        public final boolean getTls$okhttp() {
            return this.tls;
        }

        public final String[] getTlsVersions$okhttp() {
            return this.tlsVersions;
        }

        public final void setCipherSuites$okhttp(String[] stringArr) {
            this.cipherSuites = stringArr;
        }

        public final void setSupportsTlsExtensions$okhttp(boolean z) {
            this.supportsTlsExtensions = z;
        }

        public final void setTls$okhttp(boolean z) {
            this.tls = z;
        }

        public final void setTlsVersions$okhttp(String[] stringArr) {
            this.tlsVersions = stringArr;
        }

        public final okhttp3.ConnectionSpec.Builder supportsTlsExtensions(boolean z) {
            if (!this.tls) {
            } else {
                this.supportsTlsExtensions = z;
                return this;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            throw obj2;
        }

        public final okhttp3.ConnectionSpec.Builder tlsVersions(String... stringArr) {
            int i;
            n.f(stringArr, "tlsVersions");
            if (!this.tls) {
            } else {
                final int i3 = 1;
                i = stringArr.length == 0 ? i3 : 0;
                if (i ^= i3 == 0) {
                } else {
                    Object obj3 = stringArr.clone();
                    Objects.requireNonNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
                    this.tlsVersions = (String[])obj3;
                    return this;
                }
                obj3 = new IllegalArgumentException("At least one TLS version is required".toString());
                throw obj3;
            }
            obj3 = new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            throw obj3;
        }

        public final okhttp3.ConnectionSpec.Builder tlsVersions(okhttp3.TlsVersion... tlsVersionArr) {
            int i;
            String javaName;
            n.f(tlsVersionArr, "tlsVersions");
            if (!this.tls) {
            } else {
                ArrayList arrayList = new ArrayList(tlsVersionArr.length);
                final int i2 = 0;
                i = i2;
                while (i < tlsVersionArr.length) {
                    arrayList.add(tlsVersionArr[i].javaName());
                    i++;
                }
                Object[] obj6 = arrayList.toArray(new String[i2]);
                Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.Array<T>");
                return tlsVersions((String[])Arrays.copyOf((String[])obj6, obj6.length));
            }
            obj6 = new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            throw obj6;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\r\u0010\u000eR\u001c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0007\u0010\u0008R\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\u0008R\u0016\u0010\n\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\n\u0010\u0008R\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u0005R\u0016\u0010\u000c\u001a\u00020\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\u0008¨\u0006\u000f", d2 = {"Lokhttp3/ConnectionSpec$Companion;", "", "", "Lokhttp3/CipherSuite;", "APPROVED_CIPHER_SUITES", "[Lokhttp3/CipherSuite;", "Lokhttp3/ConnectionSpec;", "CLEARTEXT", "Lokhttp3/ConnectionSpec;", "COMPATIBLE_TLS", "MODERN_TLS", "RESTRICTED_CIPHER_SUITES", "RESTRICTED_TLS", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        ConnectionSpec.Companion companion = new ConnectionSpec.Companion(0);
        ConnectionSpec.Companion = companion;
        okhttp3.CipherSuite[] arr2 = new CipherSuite[9];
        okhttp3.CipherSuite tLS_AES_128_GCM_SHA256 = CipherSuite.TLS_AES_128_GCM_SHA256;
        final int i4 = 0;
        arr2[i4] = tLS_AES_128_GCM_SHA256;
        okhttp3.CipherSuite tLS_AES_256_GCM_SHA384 = CipherSuite.TLS_AES_256_GCM_SHA384;
        final int i12 = 1;
        arr2[i12] = tLS_AES_256_GCM_SHA384;
        okhttp3.CipherSuite tLS_CHACHA20_POLY1305_SHA256 = CipherSuite.TLS_CHACHA20_POLY1305_SHA256;
        final int i13 = 2;
        arr2[i13] = tLS_CHACHA20_POLY1305_SHA256;
        final okhttp3.CipherSuite tLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        final int i14 = 3;
        arr2[i14] = tLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        final okhttp3.CipherSuite tLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        final int i15 = 4;
        arr2[i15] = tLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        final okhttp3.CipherSuite tLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        final int i16 = 5;
        arr2[i16] = tLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        final okhttp3.CipherSuite tLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        final int i17 = 6;
        arr2[i17] = tLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        final okhttp3.CipherSuite tLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        final int i18 = 7;
        arr2[i18] = tLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        final okhttp3.CipherSuite tLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        final int i19 = 8;
        arr2[i19] = tLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        ConnectionSpec.RESTRICTED_CIPHER_SUITES = arr2;
        okhttp3.CipherSuite[] arr = new CipherSuite[16];
        arr[i4] = tLS_AES_128_GCM_SHA256;
        arr[i12] = tLS_AES_256_GCM_SHA384;
        arr[i13] = tLS_CHACHA20_POLY1305_SHA256;
        arr[i14] = tLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        arr[i15] = tLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        arr[i16] = tLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
        arr[i17] = tLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
        arr[i18] = tLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
        arr[i19] = tLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
        arr[9] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
        arr[10] = CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
        arr[11] = CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256;
        arr[12] = CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384;
        arr[13] = CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA;
        arr[14] = CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA;
        arr[15] = CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA;
        ConnectionSpec.APPROVED_CIPHER_SUITES = arr;
        ConnectionSpec.Builder builder4 = new ConnectionSpec.Builder(i12);
        okhttp3.TlsVersion[] arr4 = new TlsVersion[i13];
        okhttp3.TlsVersion tLS_1_3 = TlsVersion.TLS_1_3;
        arr4[i4] = tLS_1_3;
        okhttp3.TlsVersion tLS_1_2 = TlsVersion.TLS_1_2;
        arr4[i12] = tLS_1_2;
        ConnectionSpec.RESTRICTED_TLS = builder4.cipherSuites((CipherSuite[])Arrays.copyOf(arr2, arr2.length)).tlsVersions(arr4).supportsTlsExtensions(i12).build();
        ConnectionSpec.Builder builder2 = new ConnectionSpec.Builder(i12);
        okhttp3.TlsVersion[] arr5 = new TlsVersion[i13];
        arr5[i4] = tLS_1_3;
        arr5[i12] = tLS_1_2;
        ConnectionSpec.MODERN_TLS = builder2.cipherSuites((CipherSuite[])Arrays.copyOf(arr, arr.length)).tlsVersions(arr5).supportsTlsExtensions(i12).build();
        ConnectionSpec.Builder builder3 = new ConnectionSpec.Builder(i12);
        okhttp3.TlsVersion[] arr3 = new TlsVersion[i15];
        arr3[i4] = tLS_1_3;
        arr3[i12] = tLS_1_2;
        arr3[i13] = TlsVersion.TLS_1_1;
        arr3[i14] = TlsVersion.TLS_1_0;
        ConnectionSpec.COMPATIBLE_TLS = builder3.cipherSuites((CipherSuite[])Arrays.copyOf(arr, arr.length)).tlsVersions(arr3).supportsTlsExtensions(i12).build();
        ConnectionSpec.Builder builder = new ConnectionSpec.Builder(i4);
        ConnectionSpec.CLEARTEXT = builder.build();
    }

    public ConnectionSpec(boolean z, boolean z2, String[] string3Arr3, String[] string4Arr4) {
        super();
        this.isTls = z;
        this.supportsTlsExtensions = z2;
        this.cipherSuitesAsString = string3Arr3;
        this.tlsVersionsAsString = string4Arr4;
    }

    public static final String[] access$getCipherSuitesAsString$p(okhttp3.ConnectionSpec connectionSpec) {
        return connectionSpec.cipherSuitesAsString;
    }

    public static final String[] access$getTlsVersionsAsString$p(okhttp3.ConnectionSpec connectionSpec) {
        return connectionSpec.tlsVersionsAsString;
    }

    private final okhttp3.ConnectionSpec supportedSpec(SSLSocket sSLSocket, boolean z2) {
        String[] enabledCipherSuites;
        String[] cipherSuitesAsString;
        String[] enabledProtocols;
        java.util.Comparator oRDER_BY_NAME$okhttp;
        java.util.Comparator comparator;
        String[] obj5;
        int obj6;
        if (this.cipherSuitesAsString != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            n.e(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = Util.intersect(enabledCipherSuites2, this.cipherSuitesAsString, CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.tlsVersionsAsString != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            n.e(enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = Util.intersect(enabledProtocols2, this.tlsVersionsAsString, a.e());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        obj5 = sSLSocket.getSupportedCipherSuites();
        n.e(obj5, "supportedCipherSuites");
        int indexOf = Util.indexOf(obj5, "TLS_FALLBACK_SCSV", CipherSuite.Companion.getORDER_BY_NAME$okhttp());
        String str5 = "cipherSuitesIntersection";
        if (z2 != 0 && indexOf != -1) {
            if (indexOf != -1) {
                n.e(enabledCipherSuites, str5);
                obj5 = obj5[indexOf];
                n.e(obj5, "supportedCipherSuites[indexOfFallbackScsv]");
                enabledCipherSuites = Util.concat(enabledCipherSuites, obj5);
            }
        }
        obj5 = new ConnectionSpec.Builder(this);
        n.e(enabledCipherSuites, str5);
        n.e(enabledProtocols, "tlsVersionsIntersection");
        return obj5.cipherSuites((String[])Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length)).tlsVersions((String[])Arrays.copyOf(enabledProtocols, enabledProtocols.length)).build();
    }

    public final List<okhttp3.CipherSuite> -deprecated_cipherSuites() {
        return cipherSuites();
    }

    public final boolean -deprecated_supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<okhttp3.TlsVersion> -deprecated_tlsVersions() {
        return tlsVersions();
    }

    public final void apply$okhttp(SSLSocket sSLSocket, boolean z2) {
        List tlsVersionsAsString;
        okhttp3.ConnectionSpec obj3;
        n.f(sSLSocket, "sslSocket");
        obj3 = supportedSpec(sSLSocket, z2);
        if (obj3.tlsVersions() != null) {
            sSLSocket.setEnabledProtocols(obj3.tlsVersionsAsString);
        }
        if (obj3.cipherSuites() != null) {
            sSLSocket.setEnabledCipherSuites(obj3.cipherSuitesAsString);
        }
    }

    public final List<okhttp3.CipherSuite> cipherSuites() {
        int i;
        ArrayList arrayList;
        int length;
        int i2;
        okhttp3.CipherSuite forJavaName;
        okhttp3.CipherSuite.Companion companion;
        String[] cipherSuitesAsString = this.cipherSuitesAsString;
        if (cipherSuitesAsString != null) {
            arrayList = new ArrayList(cipherSuitesAsString.length);
            i2 = 0;
            while (i2 < cipherSuitesAsString.length) {
                arrayList.add(CipherSuite.Companion.forJavaName(cipherSuitesAsString[i2]));
                i2++;
            }
            i = p.L0(arrayList);
        } else {
            i = 0;
        }
        return i;
    }

    public boolean equals(Object object) {
        boolean supportsTlsExtensions;
        boolean tlsVersionsAsString;
        Object obj5;
        final int i2 = 0;
        if (!object instanceof ConnectionSpec) {
            return i2;
        }
        int i = 1;
        if (object == this) {
            return i;
        }
        supportsTlsExtensions = this.isTls;
        if (supportsTlsExtensions != object.isTls) {
            return i2;
        }
        if (supportsTlsExtensions && !Arrays.equals(this.cipherSuitesAsString, object.cipherSuitesAsString)) {
            if (!Arrays.equals(this.cipherSuitesAsString, object.cipherSuitesAsString)) {
                return i2;
            }
            if (!Arrays.equals(this.tlsVersionsAsString, object.tlsVersionsAsString)) {
                return i2;
            }
            if (this.supportsTlsExtensions != object.supportsTlsExtensions) {
                return i2;
            }
        }
        return i;
    }

    public int hashCode() {
        int i;
        int i2;
        int i4;
        int i3;
        if (this.isTls) {
            String[] cipherSuitesAsString = this.cipherSuitesAsString;
            if (cipherSuitesAsString != null) {
                i2 = Arrays.hashCode(cipherSuitesAsString);
            } else {
                i2 = i3;
            }
            String[] tlsVersionsAsString = this.tlsVersionsAsString;
            if (tlsVersionsAsString != null) {
                i3 = Arrays.hashCode(tlsVersionsAsString);
            }
            i9 += i4;
        } else {
            i = 17;
        }
        return i;
    }

    public final boolean isCompatible(SSLSocket sSLSocket) {
        String[] tlsVersionsAsString;
        String[] oRDER_BY_NAME$okhttp;
        java.util.Comparator comparator;
        Object obj5;
        n.f(sSLSocket, "socket");
        final int i = 0;
        if (!this.isTls) {
            return i;
        }
        tlsVersionsAsString = this.tlsVersionsAsString;
        if (tlsVersionsAsString != null && !Util.hasIntersection(tlsVersionsAsString, sSLSocket.getEnabledProtocols(), a.e())) {
            if (!Util.hasIntersection(tlsVersionsAsString, sSLSocket.getEnabledProtocols(), a.e())) {
                return i;
            }
        }
        String[] cipherSuitesAsString = this.cipherSuitesAsString;
        if (cipherSuitesAsString != null && !Util.hasIntersection(cipherSuitesAsString, sSLSocket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp())) {
            if (!Util.hasIntersection(cipherSuitesAsString, sSLSocket.getEnabledCipherSuites(), CipherSuite.Companion.getORDER_BY_NAME$okhttp())) {
                return i;
            }
        }
        return 1;
    }

    public final boolean isTls() {
        return this.isTls;
    }

    public final boolean supportsTlsExtensions() {
        return this.supportsTlsExtensions;
    }

    public final List<okhttp3.TlsVersion> tlsVersions() {
        int i;
        ArrayList arrayList;
        int length;
        int i2;
        okhttp3.TlsVersion forJavaName;
        okhttp3.TlsVersion.Companion companion;
        String[] tlsVersionsAsString = this.tlsVersionsAsString;
        if (tlsVersionsAsString != null) {
            arrayList = new ArrayList(tlsVersionsAsString.length);
            i2 = 0;
            while (i2 < tlsVersionsAsString.length) {
                arrayList.add(TlsVersion.Companion.forJavaName(tlsVersionsAsString[i2]));
                i2++;
            }
            i = p.L0(arrayList);
        } else {
            i = 0;
        }
        return i;
    }

    public String toString() {
        if (!this.isTls) {
            return "ConnectionSpec()";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ConnectionSpec(");
        stringBuilder.append("cipherSuites=");
        String str6 = "[all enabled]";
        stringBuilder.append(Objects.toString(cipherSuites(), str6));
        String str4 = ", ";
        stringBuilder.append(str4);
        stringBuilder.append("tlsVersions=");
        stringBuilder.append(Objects.toString(tlsVersions(), str6));
        stringBuilder.append(str4);
        stringBuilder.append("supportsTlsExtensions=");
        stringBuilder.append(this.supportsTlsExtensions);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
