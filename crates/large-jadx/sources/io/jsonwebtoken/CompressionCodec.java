package io.jsonwebtoken;

/* loaded from: classes3.dex */
public interface CompressionCodec {
    public abstract byte[] compress(byte[] bArr);

    public abstract byte[] decompress(byte[] bArr);

    public abstract String getAlgorithmName();
}
