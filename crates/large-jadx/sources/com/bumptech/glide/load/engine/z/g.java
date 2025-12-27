package com.bumptech.glide.load.engine.z;

/* compiled from: ByteArrayAdapter.java */
/* loaded from: classes.dex */
public final class g implements a<byte[]> {
    public int c(byte[] bArr) {
        return bArr.length;
    }

    public byte[] d(int i) {
        return new byte[i];
    }

    public int a() {
        return 1;
    }

    public String getTag() {
        return "ByteArrayPool";
    }
}
