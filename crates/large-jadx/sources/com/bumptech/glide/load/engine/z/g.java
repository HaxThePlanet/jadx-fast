package com.bumptech.glide.load.engine.z;

/* loaded from: classes.dex */
public final class g implements com.bumptech.glide.load.engine.z.a<byte[]> {
    @Override // com.bumptech.glide.load.engine.z.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int b(Object object) {
        return c((byte[])object);
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public int c(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public byte[] d(int i) {
        return new byte[i];
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public String getTag() {
        return "ByteArrayPool";
    }

    @Override // com.bumptech.glide.load.engine.z.a
    public Object newArray(int i) {
        return d(i);
    }
}
