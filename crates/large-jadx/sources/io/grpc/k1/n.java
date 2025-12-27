package io.grpc.k1;

import io.grpc.j1.p2;
import l.f;

/* compiled from: OkHttpWritableBuffer.java */
/* loaded from: classes3.dex */
class n implements p2 {

    private final f a;
    private int b;
    private int c;
    n(f fVar, int i) {
        super();
        this.a = fVar;
        this.b = i;
    }

    public void b(byte[] bArr, int i, int i2) {
        this.a.v0(bArr, i, i2);
        this.b -= i2;
        this.c += i2;
    }

    public int c() {
        return this.b;
    }

    public void d(byte b) {
        this.a.z0(b);
        this.b--;
        this.c++;
    }

    f e() {
        return this.a;
    }

    public int g() {
        return this.c;
    }

    public void a() {
    }
}
