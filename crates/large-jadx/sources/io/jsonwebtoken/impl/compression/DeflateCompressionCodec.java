package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

/* loaded from: classes3.dex */
public class DeflateCompressionCodec extends io.jsonwebtoken.impl.compression.AbstractCompressionCodec {

    private static final String DEFLATE = "DEF";
    private static final io.jsonwebtoken.impl.compression.AbstractCompressionCodec.StreamWrapper WRAPPER;
    static {
        DeflateCompressionCodec.1 anon = new DeflateCompressionCodec.1();
        DeflateCompressionCodec.WRAPPER = anon;
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doCompress(byte[] bArr) {
        return writeAndClose(bArr, DeflateCompressionCodec.WRAPPER);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doDecompress(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            InflaterInputStream inflaterInputStream = new InflaterInputStream(byteArrayInputStream);
            return readAndClose(inflaterInputStream);
            bArr = doDecompressBackCompat(bArr);
            return bArr;
            throw th;
        } catch (java.io.IOException ioException) {
        }
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    byte[] doDecompressBackCompat(byte[] bArr) {
        Object obj2;
        Object obj;
        final int i4 = 0;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream);
        inflaterOutputStream.write(bArr);
        inflaterOutputStream.flush();
        java.io.Closeable[] arr2 = new Closeable[2];
        Objects.nullSafeClose(byteArrayOutputStream, inflaterOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    public String getAlgorithmName() {
        return "DEF";
    }
}
