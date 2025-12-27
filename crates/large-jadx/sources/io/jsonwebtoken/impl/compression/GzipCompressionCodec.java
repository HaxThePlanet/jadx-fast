package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: GzipCompressionCodec.java */
/* loaded from: classes3.dex */
public class GzipCompressionCodec extends AbstractCompressionCodec implements CompressionCodec {

    private static final String GZIP = "GZIP";
    private static final AbstractCompressionCodec.StreamWrapper WRAPPER = new GzipCompressionCodec$1();

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doCompress(byte[] bArr) {
        return writeAndClose(bArr, GzipCompressionCodec.WRAPPER);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doDecompress(byte[] bArr) throws java.io.IOException {
        return readAndClose(new GZIPInputStream(new ByteArrayInputStream(bArr)));
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    public String getAlgorithmName() {
        return "GZIP";
    }
}
