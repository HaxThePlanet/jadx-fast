package io.grpc.k1;

import io.grpc.j1.p2;
import l.f;

/* loaded from: classes3.dex */
class n implements p2 {

    private final f a;
    private int b;
    private int c;
    n(f f, int i2) {
        super();
        this.a = f;
        this.b = i2;
    }

    @Override // io.grpc.j1.p2
    public void a() {
    }

    @Override // io.grpc.j1.p2
    public void b(byte[] bArr, int i2, int i3) {
        this.a.v0(bArr, i2, i3);
        this.b = obj2 -= i3;
        this.c = obj2 += i3;
    }

    @Override // io.grpc.j1.p2
    public int c() {
        return this.b;
    }

    @Override // io.grpc.j1.p2
    public void d(byte b) {
        this.a.z0(b);
        this.b = obj2--;
        this.c = obj2++;
    }

    @Override // io.grpc.j1.p2
    f e() {
        return this.a;
    }

    @Override // io.grpc.j1.p2
    public int g() {
        return this.c;
    }
}
