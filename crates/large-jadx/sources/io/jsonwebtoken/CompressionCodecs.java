package io.jsonwebtoken;

import io.jsonwebtoken.lang.Classes;

/* loaded from: classes3.dex */
public final class CompressionCodecs {

    public static final io.jsonwebtoken.CompressionCodec DEFLATE;
    public static final io.jsonwebtoken.CompressionCodec GZIP;
    static {
        CompressionCodecs.DEFLATE = (CompressionCodec)Classes.newInstance("io.jsonwebtoken.impl.compression.DeflateCompressionCodec");
        CompressionCodecs.GZIP = (CompressionCodec)Classes.newInstance("io.jsonwebtoken.impl.compression.GzipCompressionCodec");
    }
}
