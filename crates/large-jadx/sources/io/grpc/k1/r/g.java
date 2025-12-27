package io.grpc.k1.r;

import java.io.IOException;

/* compiled from: Protocol.java */
/* loaded from: classes3.dex */
public enum g {

    HTTP_1_0,
    HTTP_1_1,
    HTTP_2,
    SPDY_3;

    private final String protocol;
    public static g get(String str) throws IOException {
        io.grpc.k1.r.g hTTP_1_02 = g.HTTP_1_0;
        if (str.equals(hTTP_1_02.protocol)) {
            return g.HTTP_1_0;
        }
        io.grpc.k1.r.g hTTP_1_12 = g.HTTP_1_1;
        if (str.equals(hTTP_1_12.protocol)) {
            return g.HTTP_1_1;
        }
        io.grpc.k1.r.g hTTP_22 = g.HTTP_2;
        if (str.equals(hTTP_22.protocol)) {
            return g.HTTP_2;
        }
        io.grpc.k1.r.g sPDY_32 = g.SPDY_3;
        if (!str.equals(sPDY_32.protocol)) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Unexpected protocol: ";
            str = str2 + str;
            throw new IOException(str);
        } else {
            return g.SPDY_3;
        }
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.protocol;
    }
}
