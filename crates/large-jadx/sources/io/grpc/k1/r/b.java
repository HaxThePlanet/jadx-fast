package io.grpc.k1.r;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* compiled from: ConnectionSpec.java */
/* loaded from: classes3.dex */
public final class b {

    private static final a[] e;
    public static final b f;
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
        public b(boolean z) {
            super();
            this.a = z;
        }

        static /* synthetic */ boolean a(b.b bVar) {
            return bVar.a;
        }

        static /* synthetic */ String[] b(b.b bVar) {
            return bVar.b;
        }

        static /* synthetic */ String[] c(b.b bVar) {
            return bVar.c;
        }

        static /* synthetic */ boolean d(b.b bVar) {
            return bVar.d;
        }

        public b e() {
            return new b(this, null);
        }

        public b.b f(a... aVarArr) {
            int i = 0;
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else {
                String[] strArr = new String[aVarArr.length];
                i = 0;
                while (i < aVarArr.length) {
                    strArr[i] = aVarArr[i].javaName;
                    i = i + 1;
                }
                this.b = strArr;
                return this;
            }
        }

        public b.b g(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else {
                if (strArr == null) {
                    this.b = null;
                } else {
                    this.b = (String[])strArr.clone();
                }
                return this;
            }
        }

        public b.b h(boolean z) {
            if (!this.a) {
                throw new IllegalStateException("no TLS extensions for cleartext connections");
            } else {
                this.d = z;
                return this;
            }
        }

        public b.b i(h... hVarArr) {
            int i = 0;
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else {
                if (hVarArr.length == 0) {
                    throw new IllegalArgumentException("At least one TlsVersion is required");
                } else {
                    String[] strArr = new String[hVarArr.length];
                    i = 0;
                    while (i < hVarArr.length) {
                        strArr[i] = hVarArr[i].javaName;
                        i = i + 1;
                    }
                    this.c = strArr;
                    return this;
                }
            }
        }

        public b.b j(String... strArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else {
                if (strArr == null) {
                    this.c = null;
                } else {
                    this.c = (String[])strArr.clone();
                }
                return this;
            }
        }

        public b() {
            super();
            this.a = bVar.a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.d = bVar.d;
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
        io.grpc.k1.r.b.b bVar3 = new b.b(i3);
        bVar3.f(arr);
        io.grpc.k1.r.h[] arr2 = new h[i5];
        arr2[i2] = h.TLS_1_2;
        arr2[i3] = h.TLS_1_1;
        io.grpc.k1.r.h tLS_1_02 = h.TLS_1_0;
        arr2[i4] = tLS_1_02;
        bVar3.i(arr2);
        bVar3.h(true);
        io.grpc.k1.r.b bVar = bVar3.e();
        b.f = bVar;
        io.grpc.k1.r.b.b bVar4 = new b.b(bVar);
        io.grpc.k1.r.h[] arr3 = new h[i3];
        arr3[i2] = tLS_1_02;
        bVar4.i(arr3);
        bVar4.h(true);
        bVar4.e();
        new b.b(i2).e();
    }

    /* synthetic */ b(b.b bVar, b.a aVar) {
        this(bVar);
    }

    static /* synthetic */ String[] a(b bVar) {
        return bVar.b;
    }

    static /* synthetic */ String[] b(b bVar) {
        return bVar.c;
    }

    private b e(SSLSocket sSLSocket, boolean z) {
        int i = 0;
        String[] strArr;
        String[] enabledCipherSuites;
        String[] strArr2;
        final Class<String> obj = String.class;
        if (this.b != null) {
            Object[] objArr = i.c(obj, this.b, sSLSocket.getEnabledCipherSuites());
        } else {
            i = 0;
        }
        if (z) {
            String str = "TLS_FALLBACK_SCSV";
            if (Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains(str) && this.b != 0) {
                int i3 = enabledCipherSuites.length + 1;
                strArr = new String[i3];
                length = enabledCipherSuites.length;
                int i2 = 0;
                System.arraycopy(enabledCipherSuites, i2, strArr, i2, length);
                strArr[i3 - 1] = str;
            }
        }
        io.grpc.k1.r.b.b bVar2 = new b.b(this);
        bVar2.g(strArr);
        bVar2.j((String[])i.c(obj, this.c, sSLSocket.getEnabledProtocols()));
        return bVar2.e();
    }

    public void c(SSLSocket sSLSocket, boolean z) {
        io.grpc.k1.r.b bVar = e(sSLSocket, z);
        sSLSocket.setEnabledProtocols(bVar.c);
        if (bVar.b != null) {
            sSLSocket.setEnabledCipherSuites(bVar.b);
        }
    }

    public List<a> d() {
        int i = 0;
        if (this.b == null) {
            return null;
        }
        io.grpc.k1.r.a[] arr = new a[strArr.length];
        i = 0;
        length = strArr2.length;
        while (i < strArr2.length) {
            arr[i] = a.forJavaName(strArr2[i]);
            i = i + 1;
            length = strArr2.length;
        }
        return i.a(arr);
    }

    public boolean equals(Object object) {
        final boolean z6 = false;
        if (!(object instanceof b)) {
            return false;
        }
        boolean z5 = true;
        if (object == this) {
            return true;
        }
        if (this.a != object.a) {
            return false;
        }
        if (this.a) {
            if (!Arrays.equals(this.b, object.b)) {
                return false;
            }
            if (!Arrays.equals(this.c, object.c)) {
                return false;
            }
            return this.d != object.d ? z6 : z5;
        }
    }

    public boolean f() {
        return this.d;
    }

    public List<h> g() {
        int i = 0;
        io.grpc.k1.r.h[] arr = new h[this.c.length];
        i = 0;
        length = strArr2.length;
        while (i < strArr2.length) {
            arr[i] = h.forJavaName(strArr2[i]);
            i = i + 1;
            length = strArr2.length;
        }
        return i.a(arr);
    }

    public int hashCode() {
        int i = 17;
        if (this.a) {
            i2 = !this.d;
            i = (527 + Arrays.hashCode(this.b)) * 31 + Arrays.hashCode(this.c) * 31 + i2;
        } else {
            i = 17;
        }
        return i;
    }

    public String toString() {
        String object;
        if (this.a && list == null) {
            object = "[use default]";
            final StringBuilder stringBuilder = new StringBuilder();
            final String str6 = "ConnectionSpec(cipherSuites=";
            String str2 = ", tlsVersions=";
            List list2 = g();
            String str3 = ", supportsTlsExtensions=";
            String str4 = ")";
            str5 = str6 + object + str2 + list2 + str3 + this.d + str4;
            return str5;
        }
        return "ConnectionSpec()";
    }

    private b(b.b bVar) {
        super();
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.d = bVar.d;
    }
}
