package io.grpc.k1.r;

/* compiled from: TlsVersion.java */
/* loaded from: classes3.dex */
public enum h {

    SSL_3_0,
    TLS_1_0,
    TLS_1_1,
    TLS_1_2;

    final String javaName;
    public static h forJavaName(String str) {
        if ("TLSv1.2".equals(str)) {
            return h.TLS_1_2;
        }
        if ("TLSv1.1".equals(str)) {
            return h.TLS_1_1;
        }
        if ("TLSv1".equals(str)) {
            return h.TLS_1_0;
        }
        if (!"SSLv3".equals(str)) {
            final StringBuilder stringBuilder = new StringBuilder();
            final String str6 = "Unexpected TLS version: ";
            str = str6 + str;
            throw new IllegalArgumentException(str);
        } else {
            return h.SSL_3_0;
        }
    }

    @Override // java.lang.Enum
    public String javaName() {
        return this.javaName;
    }
}
