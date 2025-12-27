package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: AbstractCompressionCodec.java */
/* loaded from: classes3.dex */
public abstract class AbstractCompressionCodec implements CompressionCodec {

    interface StreamWrapper {
        OutputStream wrap(OutputStream outputStream);
    }
    public final byte[] compress(byte[] bArr) throws CompressionException {
        Assert.notNull(bArr, "payload cannot be null.");
        try {
        } catch (java.io.IOException ioException) {
            throw new CompressionException("Unable to compress payload.", ioException);
        }
        return doCompress(bArr);
    }

    public final byte[] decompress(byte[] bArr) throws CompressionException {
        Assert.notNull(bArr, "compressed bytes cannot be null.");
        try {
        } catch (java.io.IOException ioException) {
            throw new CompressionException("Unable to decompress bytes.", ioException);
        }
        return doDecompress(bArr);
    }

    byte[] readAndClose(InputStream inputStream) {
        int bytesRead;
        int i2 = 512;
        final byte[] bArr = new byte[i2];
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        final int i5 = 0;
        try {
            bytesRead = inputStream.read(bArr);
            int i = -1;
            byteArrayOutputStream.write(bArr, i5, bytesRead);
            bytesRead = inputStream.read(bArr);
        } finally {
            int arr = new Closeable[arr];
            arr[i4] = inputStream;
            Objects.nullSafeClose(arr);
            throw th;
        }
        java.io.Closeable[] arr2 = new Closeable[1];
        arr2[i5] = inputStream;
        Objects.nullSafeClose(arr2);
        return byteArrayOutputStream.toByteArray();
    }

    byte[] writeAndClose(byte[] bArr, AbstractCompressionCodec.StreamWrapper streamWrapper) {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        final OutputStream wrap = streamWrapper.wrap(byteArrayOutputStream);
        try {
            wrap.write(bArr);
            wrap.flush();
        } finally {
            java.io.Closeable[] arr = new Closeable[i4];
            arr[i] = streamWrapper;
            Objects.nullSafeClose(arr);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) bArr;
        }
        java.io.Closeable[] arr2 = new Closeable[1];
        Objects.nullSafeClose(wrap);
        return byteArrayOutputStream.toByteArray();
    }

    protected abstract byte[] doCompress(byte[] bArr);

    protected abstract byte[] doDecompress(byte[] bArr);
}
