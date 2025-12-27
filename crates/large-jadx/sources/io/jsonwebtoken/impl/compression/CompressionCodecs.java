package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecs;

/* compiled from: CompressionCodecs.java */
@Deprecated
/* loaded from: classes3.dex */
public final class CompressionCodecs {

    @Deprecated
    public static final CompressionCodec DEFLATE;
    @Deprecated
    public static final CompressionCodec GZIP;
    private static final CompressionCodecs I = new CompressionCodecs();
    static {
        CompressionCodecs.DEFLATE = CompressionCodecs.DEFLATE;
        CompressionCodecs.GZIP = CompressionCodecs.GZIP;
    }

    private CompressionCodecs() {
        super();
    }
}
