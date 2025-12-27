package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;
import java.util.zip.InflaterOutputStream;

/* compiled from: DeflateCompressionCodec.java */
/* loaded from: classes3.dex */
public class DeflateCompressionCodec extends AbstractCompressionCodec {

    private static final String DEFLATE = "DEF";
    private static final AbstractCompressionCodec.StreamWrapper WRAPPER = new DeflateCompressionCodec$1();

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doCompress(byte[] bArr) {
        return writeAndClose(bArr, DeflateCompressionCodec.WRAPPER);
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    protected byte[] doDecompress(byte[] bArr) throws InflaterInputStream {
        try {
        } catch (java.io.IOException unused) {
            throw th;
        }
        return readAndClose(new InflaterInputStream(new ByteArrayInputStream(bArr)));
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    byte[] doDecompressBackCompat(byte[] bArr) {
        Object obj;
        try {
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (Throwable th) {
        }
        try {
            final InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(byteArrayOutputStream);
        } catch (Throwable th) {
        }
        try {
            inflaterOutputStream.write(th);
            inflaterOutputStream.flush();
        } catch (Throwable th) {
        }
        java.io.Closeable[] arr2 = new Closeable[2];
        Objects.nullSafeClose(byteArrayOutputStream, inflaterOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // io.jsonwebtoken.impl.compression.AbstractCompressionCodec
    public String getAlgorithmName() {
        return "DEF";
    }
}
