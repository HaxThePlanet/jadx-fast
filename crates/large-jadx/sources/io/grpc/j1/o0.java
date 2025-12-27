package io.grpc.j1;

import com.google.common.base.j;
import com.google.common.base.j.b;
import com.google.common.base.n;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* compiled from: ForwardingReadableBuffer.java */
/* loaded from: classes3.dex */
public abstract class o0 implements v1 {

    private final v1 a;
    protected o0(v1 v1Var) {
        super();
        n.p(v1Var, "buf");
        this.a = v1Var;
    }

    public void D1(OutputStream outputStream, int i) {
        this.a.D1(outputStream, i);
    }

    public void O0(byte[] bArr, int i, int i2) {
        this.a.O0(bArr, i, i2);
    }

    public v1 Q(int i) {
        return this.a.Q(i);
    }

    public void W1(ByteBuffer byteBuffer) {
        this.a.W1(byteBuffer);
    }

    public void c1() {
        this.a.c1();
    }

    public int g() {
        return this.a.g();
    }

    public boolean markSupported() {
        return this.a.markSupported();
    }

    public int readUnsignedByte() {
        return this.a.readUnsignedByte();
    }

    public void reset() {
        this.a.reset();
    }

    public void skipBytes(int i) {
        this.a.skipBytes(i);
    }

    @Override // java.lang.Object
    public String toString() {
        j.b bVar = j.c(this);
        bVar.d("delegate", this.a);
        return bVar.toString();
    }
}
