package io.grpc.k1.r;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes3.dex */
public final class b {

    private static final io.grpc.k1.r.a[] e;
    public static final io.grpc.k1.r.b f;
    final boolean a;
    private final String[] b;
    private final String[] c;
    final boolean d;

    static class a {
    }

    public static final class b {

        private boolean a;
        private String[] b;
        private String[] c;
        private boolean d;
        public b(io.grpc.k1.r.b b) {
            super();
            this.a = b.a;
            this.b = b.a(b);
            this.c = b.b(b);
            this.d = b.d;
        }

        public b(boolean z) {
            super();
            this.a = z;
        }

        static boolean a(io.grpc.k1.r.b.b b$b) {
            return b.a;
        }

        static String[] b(io.grpc.k1.r.b.b b$b) {
            return b.b;
        }

        static String[] c(io.grpc.k1.r.b.b b$b) {
            return b.c;
        }

        static boolean d(io.grpc.k1.r.b.b b$b) {
            return b.d;
        }

        public io.grpc.k1.r.b e() {
            b bVar = new b(this, 0);
            return bVar;
        }

        public io.grpc.k1.r.b.b f(io.grpc.k1.r.a... aArr) {
            int i;
            String javaName;
            if (!this.a) {
            } else {
                String[] strArr = new String[aArr.length];
                i = 0;
                for (Object obj : aArr) {
                    strArr[i] = obj.javaName;
                }
                this.b = strArr;
                return this;
            }
            IllegalStateException obj4 = new IllegalStateException("no cipher suites for cleartext connections");
            throw obj4;
        }

        public io.grpc.k1.r.b.b g(String... stringArr) {
            Object obj2;
            if (!this.a) {
            } else {
                if (stringArr == null) {
                    this.b = 0;
                } else {
                    this.b = (String[])stringArr.clone();
                }
                return this;
            }
            obj2 = new IllegalStateException("no cipher suites for cleartext connections");
            throw obj2;
        }

        public io.grpc.k1.r.b.b h(boolean z) {
            if (!this.a) {
            } else {
                this.d = z;
                return this;
            }
            IllegalStateException obj2 = new IllegalStateException("no TLS extensions for cleartext connections");
            throw obj2;
        }

        public io.grpc.k1.r.b.b i(io.grpc.k1.r.h... hArr) {
            int i;
            String javaName;
            if (!this.a) {
            } else {
                if (hArr.length == 0) {
                } else {
                    String[] strArr = new String[hArr.length];
                    i = 0;
                    for (Object obj : hArr) {
                        strArr[i] = obj.javaName;
                    }
                    this.c = strArr;
                    return this;
                }
                IllegalArgumentException obj4 = new IllegalArgumentException("At least one TlsVersion is required");
                throw obj4;
            }
            obj4 = new IllegalStateException("no TLS versions for cleartext connections");
            throw obj4;
        }

        public io.grpc.k1.r.b.b j(String... stringArr) {
            Object obj2;
            if (!this.a) {
            } else {
                if (stringArr == null) {
                    this.c = 0;
                } else {
                    this.c = (String[])stringArr.clone();
                }
                return this;
            }
            obj2 = new IllegalStateException("no TLS versions for cleartext connections");
            throw obj2;
        }
    }
    static {
        io.grpc.k1.r.a[] arr = new a[14];
        final int i2 = 0;
        arr[i2] = a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
        final int i3 = 1;
        arr[i3] = a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
        final int i4 = 2;
        arr[i4] = a.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
        int i5 = 3;
        arr[i5] = a.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
        arr[4] = a.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
        arr[5] = a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
        arr[6] = a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
        arr[7] = a.TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
        arr[8] = a.TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
        arr[9] = a.TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
        arr[10] = a.TLS_RSA_WITH_AES_128_GCM_SHA256;
        arr[11] = a.TLS_RSA_WITH_AES_128_CBC_SHA;
        arr[12] = a.TLS_RSA_WITH_AES_256_CBC_SHA;
        arr[13] = a.TLS_RSA_WITH_3DES_EDE_CBC_SHA;
        b.e = arr;
        b.b bVar3 = new b.b(i3);
        bVar3.f(arr);
        io.grpc.k1.r.h[] arr2 = new h[i5];
        arr2[i2] = h.TLS_1_2;
        arr2[i3] = h.TLS_1_1;
        io.grpc.k1.r.h tLS_1_0 = h.TLS_1_0;
        arr2[i4] = tLS_1_0;
        bVar3.i(arr2);
        bVar3.h(i3);
        io.grpc.k1.r.b bVar = bVar3.e();
        b.f = bVar;
        b.b bVar4 = new b.b(bVar);
        io.grpc.k1.r.h[] arr3 = new h[i3];
        arr3[i2] = tLS_1_0;
        bVar4.i(arr3);
        bVar4.h(i3);
        bVar4.e();
        b.b bVar2 = new b.b(i2);
        bVar2.e();
    }

    private b(io.grpc.k1.r.b.b b$b) {
        super();
        this.a = b.b.a(b);
        this.b = b.b.b(b);
        this.c = b.b.c(b);
        this.d = b.b.d(b);
    }

    b(io.grpc.k1.r.b.b b$b, io.grpc.k1.r.b.a b$a2) {
        super(b);
    }

    static String[] a(io.grpc.k1.r.b b) {
        return b.b;
    }

    static String[] b(io.grpc.k1.r.b b) {
        return b.c;
    }

    private io.grpc.k1.r.b e(SSLSocket sSLSocket, boolean z2) {
        int enabledCipherSuites;
        String[] str;
        String[] strArr;
        int length;
        int i;
        boolean obj8;
        final Class<String> obj = String.class;
        if (this.b != null) {
            enabledCipherSuites = i.c(obj, this.b, sSLSocket.getEnabledCipherSuites());
        } else {
            enabledCipherSuites = 0;
        }
        str = "TLS_FALLBACK_SCSV";
        if (z2 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains(str)) {
            str = "TLS_FALLBACK_SCSV";
            if (Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains(str)) {
                if (enabledCipherSuites != 0) {
                } else {
                    enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
                }
                obj8++;
                strArr = new String[obj8];
                i = 0;
                System.arraycopy(enabledCipherSuites, i, strArr, i, enabledCipherSuites.length);
                strArr[obj8--] = str;
                enabledCipherSuites = strArr;
            }
        }
        obj8 = new b.b(this);
        obj8.g(enabledCipherSuites);
        obj8.j((String[])i.c(obj, this.c, sSLSocket.getEnabledProtocols()));
        return obj8.e();
    }

    public void c(SSLSocket sSLSocket, boolean z2) {
        io.grpc.k1.r.b obj3 = e(sSLSocket, z2);
        sSLSocket.setEnabledProtocols(obj3.c);
        obj3 = obj3.b;
        if (obj3 != null) {
            sSLSocket.setEnabledCipherSuites(obj3);
        }
    }

    public List<io.grpc.k1.r.a> d() {
        int i;
        io.grpc.k1.r.a forJavaName;
        int length;
        String[] strArr = this.b;
        if (strArr == null) {
            return 0;
        }
        io.grpc.k1.r.a[] arr = new a[strArr.length];
        i = 0;
        String[] strArr2 = this.b;
        for (Object str : obj2) {
            arr[i] = a.forJavaName(str);
            strArr2 = this.b;
        }
        return i.a(arr);
    }

    public boolean equals(Object object) {
        boolean z2;
        boolean z;
        Object obj5;
        final int i2 = 0;
        if (!object instanceof b) {
            return i2;
        }
        int i = 1;
        if (object == this) {
            return i;
        }
        z2 = this.a;
        if (z2 != object.a) {
            return i2;
        }
        if (z2 && !Arrays.equals(this.b, object.b)) {
            if (!Arrays.equals(this.b, object.b)) {
                return i2;
            }
            if (!Arrays.equals(this.c, object.c)) {
                return i2;
            }
            if (this.d != object.d) {
                return i2;
            }
        }
        return i;
    }

    public boolean f() {
        return this.d;
    }

    public List<io.grpc.k1.r.h> g() {
        int i;
        io.grpc.k1.r.h forJavaName;
        int length;
        io.grpc.k1.r.h[] arr = new h[strArr.length];
        i = 0;
        String[] strArr2 = this.c;
        for (Object str : obj2) {
            arr[i] = h.forJavaName(str);
            strArr2 = this.c;
        }
        return i.a(arr);
    }

    public int hashCode() {
        int i;
        int i2;
        if (this.a) {
            i7 += i2;
        } else {
            i = 17;
        }
        return i;
    }

    public String toString() {
        String string;
        if (this.a) {
            List list = d();
            if (list == null) {
                string = "[use default]";
            } else {
                string = list.toString();
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ConnectionSpec(cipherSuites=");
            stringBuilder.append(string);
            stringBuilder.append(", tlsVersions=");
            stringBuilder.append(g());
            stringBuilder.append(", supportsTlsExtensions=");
            stringBuilder.append(this.d);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
        return "ConnectionSpec()";
    }
}
