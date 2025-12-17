package io.grpc.k1.r;

import java.io.IOException;

/* loaded from: classes3.dex */
public enum g {

    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");

    private final String protocol;
    public static io.grpc.k1.r.g get(String string) {
        io.grpc.k1.r.g hTTP_1_0 = g.HTTP_1_0;
        if (string.equals(hTTP_1_0.protocol)) {
            return hTTP_1_0;
        }
        io.grpc.k1.r.g hTTP_1_1 = g.HTTP_1_1;
        if (string.equals(hTTP_1_1.protocol)) {
            return hTTP_1_1;
        }
        io.grpc.k1.r.g hTTP_2 = g.HTTP_2;
        if (string.equals(hTTP_2.protocol)) {
            return hTTP_2;
        }
        io.grpc.k1.r.g sPDY_3 = g.SPDY_3;
        if (!string.equals(sPDY_3.protocol)) {
        } else {
            return sPDY_3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected protocol: ");
        stringBuilder.append(string);
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
