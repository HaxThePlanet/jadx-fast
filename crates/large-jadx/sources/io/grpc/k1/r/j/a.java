package io.grpc.k1.r.j;

/* compiled from: ErrorCode.java */
/* loaded from: classes3.dex */
public enum a {

    NO_ERROR(0, -1, 0),
    INTERNAL_ERROR(2, 6, 2),
    FLOW_CONTROL_ERROR(3, 7, -1),
    CONNECT_ERROR(10, -1, -1),
    ENHANCE_YOUR_CALM(11, -1, -1);

    public final int httpCode;
    public final int spdyGoAwayCode;
    public final int spdyRstCode;
    public static a fromHttp2(int i) {
        int i2 = 0;
        final io.grpc.k1.r.j.a[] values = a.values();
        i2 = 0;
        for (io.grpc.k1.r.j.a aVar : values) {
            if (aVar.httpCode == i) {
                return aVar;
            }
        }
        return null;
    }

    public static a fromSpdy3Rst(int i) {
        int i2 = 0;
        final io.grpc.k1.r.j.a[] values = a.values();
        i2 = 0;
        for (io.grpc.k1.r.j.a aVar : values) {
            if (aVar.spdyRstCode == i) {
                return aVar;
            }
        }
        return null;
    }

    public static a fromSpdyGoAway(int i) {
        int i2 = 0;
        final io.grpc.k1.r.j.a[] values = a.values();
        i2 = 0;
        for (io.grpc.k1.r.j.a aVar : values) {
            if (aVar.spdyGoAwayCode == i) {
                return aVar;
            }
        }
        return null;
    }
}
