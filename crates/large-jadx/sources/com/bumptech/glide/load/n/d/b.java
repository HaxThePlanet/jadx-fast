package com.bumptech.glide.load.n.d;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.k;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements u<byte[]> {

    private final byte[] a;
    public b(byte[] bArr) {
        super();
        k.d(bArr);
        this.a = bArr;
    }

    public Class<byte[]> b() {
        return byte[].class;
    }

    public byte[] c() {
        return this.a;
    }

    public int getSize() {
        return this.a.length;
    }

    public void a() {
    }
}
