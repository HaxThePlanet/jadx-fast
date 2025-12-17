package io.grpc.k1.r;

/* loaded from: classes3.dex */
public enum h {

    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");

    final String javaName;
    public static io.grpc.k1.r.h forJavaName(String string) {
        if ("TLSv1.2".equals(string)) {
            return h.TLS_1_2;
        }
        if ("TLSv1.1".equals(string)) {
            return h.TLS_1_1;
        }
        if ("TLSv1".equals(string)) {
            return h.TLS_1_0;
        }
        if (!"SSLv3".equals(string)) {
        } else {
            return h.SSL_3_0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected TLS version: ");
        stringBuilder.append(string);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // java.lang.Enum
    public String javaName() {
        return this.javaName;
    }
}
