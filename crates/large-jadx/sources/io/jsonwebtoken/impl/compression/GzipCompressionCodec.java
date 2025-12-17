package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public class GzipCompressionCodec extends io.jsonwebtoken.impl.compression.AbstractCompressionCodec implements CompressionCodec {

    private static final String GZIP = "GZIP";
    private static final io.jsonwebtoken.impl.compression.AbstractCompressionCodec.StreamWrapper WRAPPER;
    static {
        GzipCompressionCodec.1 anon = new GzipCompressionCodec.1();
        GzipCompressionCodec.WRAPPER = anon;
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doCompress(byte[] bArr) {
        return writeAndClose(bArr, GzipCompressionCodec.WRAPPER);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doDecompress(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        return readAndClose(gZIPInputStream);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    public String getAlgorithmName() {
        return "GZIP";
    }
}
