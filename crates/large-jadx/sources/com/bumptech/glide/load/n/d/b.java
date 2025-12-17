package com.bumptech.glide.load.n.d;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.k;

/* loaded from: classes.dex */
public class b implements u<byte[]> {

    private final byte[] a;
    public b(byte[] bArr) {
        super();
        k.d(bArr);
        this.a = (byte[])bArr;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void a() {
    }

    public Class<byte[]> b() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.u
    public byte[] c() {
        return this.a;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Object get() {
        return c();
    }

    @Override // com.bumptech.glide.load.engine.u
    public int getSize() {
        return bArr.length;
    }
}
