package io.grpc.k1.r.j;

/* loaded from: classes3.dex */
public enum a {

    NO_ERROR(false, -1, false),
    INTERNAL_ERROR(true, 2, -1),
    FLOW_CONTROL_ERROR(true, true, true),
    CONNECT_ERROR(6, 11, -1),
    ENHANCE_YOUR_CALM(2, -1, -1);

    public final int httpCode;
    public final int spdyGoAwayCode;
    public final int spdyRstCode;
    public static io.grpc.k1.r.j.a fromHttp2(int i) {
        int i2;
        io.grpc.k1.r.j.a aVar;
        int httpCode;
        final io.grpc.k1.r.j.a[] values = a.values();
        i2 = 0;
        while (i2 < values.length) {
            aVar = values[i2];
            i2++;
        }
        return null;
    }

    public static io.grpc.k1.r.j.a fromSpdy3Rst(int i) {
        int i2;
        io.grpc.k1.r.j.a aVar;
        int spdyRstCode;
        final io.grpc.k1.r.j.a[] values = a.values();
        i2 = 0;
        while (i2 < values.length) {
            aVar = values[i2];
            i2++;
        }
        return null;
    }

    public static io.grpc.k1.r.j.a fromSpdyGoAway(int i) {
        int i2;
        io.grpc.k1.r.j.a aVar;
        int spdyGoAwayCode;
        final io.grpc.k1.r.j.a[] values = a.values();
        i2 = 0;
        while (i2 < values.length) {
            aVar = values[i2];
            i2++;
        }
        return null;
    }
}
