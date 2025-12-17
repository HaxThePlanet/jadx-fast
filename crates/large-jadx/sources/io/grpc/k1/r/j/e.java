package io.grpc.k1.r.j;

/* loaded from: classes3.dex */
public enum e {

    SPDY_SYN_STREAM,
    SPDY_REPLY,
    SPDY_HEADERS,
    HTTP_20_HEADERS;
    @Override // java.lang.Enum
    public boolean failIfHeadersAbsent() {
        int i;
        i = this == e.SPDY_HEADERS ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean failIfHeadersPresent() {
        int i;
        i = this == e.SPDY_REPLY ? 1 : 0;
        return i;
    }

    @Override // java.lang.Enum
    public boolean failIfStreamAbsent() {
        int i;
        io.grpc.k1.r.j.e sPDY_HEADERS;
        if (this != e.SPDY_REPLY) {
            if (this == e.SPDY_HEADERS) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    public boolean failIfStreamPresent() {
        int i;
        i = this == e.SPDY_SYN_STREAM ? 1 : 0;
        return i;
    }
}
