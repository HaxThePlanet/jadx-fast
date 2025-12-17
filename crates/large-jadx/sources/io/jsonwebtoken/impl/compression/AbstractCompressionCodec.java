package io.jsonwebtoken.impl.compression;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionException;
import io.jsonwebtoken.lang.Assert;
import io.jsonwebtoken.lang.Objects;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public abstract class AbstractCompressionCodec implements CompressionCodec {

    interface StreamWrapper {
        public abstract OutputStream wrap(OutputStream outputStream);
    }
    @Override // io.jsonwebtoken.CompressionCodec
    public final byte[] compress(byte[] bArr) {
        Assert.notNull(bArr, "payload cannot be null.");
        return doCompress(bArr);
    }

    @Override // io.jsonwebtoken.CompressionCodec
    public final byte[] decompress(byte[] bArr) {
        Assert.notNull(bArr, "compressed bytes cannot be null.");
        return doDecompress(bArr);
    }

    @Override // io.jsonwebtoken.CompressionCodec
    protected abstract byte[] doCompress(byte[] bArr);

    @Override // io.jsonwebtoken.CompressionCodec
    protected abstract byte[] doDecompress(byte[] bArr);

    @Override // io.jsonwebtoken.CompressionCodec
    byte[] readAndClose(InputStream inputStream) {
        int read;
        int i;
        int i2 = 512;
        final byte[] bArr = new byte[i2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2);
        final int i4 = 0;
        read = inputStream.read(bArr);
        while (read != -1) {
            byteArrayOutputStream.write(bArr, i4, read);
            read = inputStream.read(bArr);
        }
        java.io.Closeable[] arr2 = new Closeable[1];
        arr2[i4] = inputStream;
        Objects.nullSafeClose(arr2);
        return byteArrayOutputStream.toByteArray();
    }

    @Override // io.jsonwebtoken.CompressionCodec
    byte[] writeAndClose(byte[] bArr, io.jsonwebtoken.impl.compression.AbstractCompressionCodec.StreamWrapper abstractCompressionCodec$StreamWrapper2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        final OutputStream obj5 = streamWrapper2.wrap(byteArrayOutputStream);
        obj5.write(bArr);
        obj5.flush();
        java.io.Closeable[] obj4 = new Closeable[1];
        Objects.nullSafeClose(obj5);
        return byteArrayOutputStream.toByteArray();
    }
}
