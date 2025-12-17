package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecs;

/* loaded from: classes3.dex */
@Deprecated
public final class CompressionCodecs {

    @Deprecated
    public static final CompressionCodec DEFLATE;
    @Deprecated
    public static final CompressionCodec GZIP;
    private static final io.jsonwebtoken.impl.compression.CompressionCodecs I;
    static {
        CompressionCodecs compressionCodecs = new CompressionCodecs();
        CompressionCodecs.I = compressionCodecs;
        CompressionCodecs.DEFLATE = CompressionCodecs.DEFLATE;
        CompressionCodecs.GZIP = CompressionCodecs.GZIP;
    }
}
