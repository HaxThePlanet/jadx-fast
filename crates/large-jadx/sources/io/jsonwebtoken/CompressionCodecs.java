package io.jsonwebtoken;

import io.jsonwebtoken.lang.Classes;

/* compiled from: CompressionCodecs.java */
/* loaded from: classes3.dex */
public final class CompressionCodecs {

    public static final CompressionCodec DEFLATE;
    public static final CompressionCodec GZIP;
    static {
        CompressionCodecs.DEFLATE = (CompressionCodec)Classes.newInstance("io.jsonwebtoken.impl.compression.DeflateCompressionCodec");
        CompressionCodecs.GZIP = (CompressionCodec)Classes.newInstance("io.jsonwebtoken.impl.compression.GzipCompressionCodec");
    }

    private CompressionCodecs() {
        super();
    }
}
