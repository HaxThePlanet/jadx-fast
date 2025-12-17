package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class o0 implements io.grpc.j1.v1 {

    private final io.grpc.j1.v1 a;
    protected o0(io.grpc.j1.v1 v1) {
        super();
        n.p(v1, "buf");
        this.a = (v1)v1;
    }

    @Override // io.grpc.j1.v1
    public void D1(OutputStream outputStream, int i2) {
        this.a.D1(outputStream, i2);
    }

    @Override // io.grpc.j1.v1
    public void O0(byte[] bArr, int i2, int i3) {
        this.a.O0(bArr, i2, i3);
    }

    @Override // io.grpc.j1.v1
    public io.grpc.j1.v1 Q(int i) {
        return this.a.Q(i);
    }

    @Override // io.grpc.j1.v1
    public void W1(ByteBuffer byteBuffer) {
        this.a.W1(byteBuffer);
    }

    @Override // io.grpc.j1.v1
    public void c1() {
        this.a.c1();
    }

    @Override // io.grpc.j1.v1
    public int g() {
        return this.a.g();
    }

    @Override // io.grpc.j1.v1
    public boolean markSupported() {
        return this.a.markSupported();
    }

    @Override // io.grpc.j1.v1
    public int readUnsignedByte() {
        return this.a.readUnsignedByte();
    }

    @Override // io.grpc.j1.v1
    public void reset() {
        this.a.reset();
    }

    @Override // io.grpc.j1.v1
    public void skipBytes(int i) {
        this.a.skipBytes(i);
    }

    @Override // io.grpc.j1.v1
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", this.a);
        return bVar.toString();
    }
}
