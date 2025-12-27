package io.grpc.k1.r.j;

/* compiled from: HeadersMode.java */
/* loaded from: classes3.dex */
public enum e {

    HTTP_20_HEADERS,
    SPDY_HEADERS,
    SPDY_REPLY,
    SPDY_SYN_STREAM;
    @Override // java.lang.Enum
    public boolean failIfHeadersAbsent() {
        boolean z = true;
        int r0 = this == e.SPDY_HEADERS ? 1 : 0;
        return (this == e.SPDY_HEADERS ? 1 : 0);
    }

    @Override // java.lang.Enum
    public boolean failIfHeadersPresent() {
        boolean z = true;
        int r0 = this == e.SPDY_REPLY ? 1 : 0;
        return (this == e.SPDY_REPLY ? 1 : 0);
    }

    @Override // java.lang.Enum
    public boolean failIfStreamAbsent() {
        boolean z = false;
        if (this == e.SPDY_REPLY || this == e.SPDY_HEADERS) {
            int i2 = 1;
        }
        return z;
    }

    @Override // java.lang.Enum
    public boolean failIfStreamPresent() {
        boolean z = true;
        int r0 = this == e.SPDY_SYN_STREAM ? 1 : 0;
        return (this == e.SPDY_SYN_STREAM ? 1 : 0);
    }
}
