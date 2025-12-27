package io.grpc.k1;

import io.grpc.j1.c;
import io.grpc.j1.v1;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import l.f;

/* compiled from: OkHttpReadableBuffer.java */
/* loaded from: classes3.dex */
class k extends c {

    private final f a;
    k(f fVar) {
        super();
        this.a = fVar;
    }

    @Override // io.grpc.j1.c
    public void D1(OutputStream outputStream, int i) {
        this.a.a1(outputStream, (long)i);
    }

    @Override // io.grpc.j1.c
    public void O0(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int read = this.a.read(bArr, i, i2);
            if (read == -1) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "EOF trying to read ";
                String str2 = " bytes";
                i = str + i2 + str2;
                throw new IndexOutOfBoundsException(i);
            }
        }
    }

    @Override // io.grpc.j1.c
    public v1 Q(int i) {
        final f fVar = new f();
        fVar.write(this.a, (long)i);
        return new k(fVar);
    }

    @Override // io.grpc.j1.c
    public void W1(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.j1.c
    public void close() {
        this.a.a();
    }

    @Override // io.grpc.j1.c
    public int g() {
        return (int)this.a.size();
    }

    @Override // io.grpc.j1.c
    public int readUnsignedByte() {
        try {
            c();
        } catch (java.io.EOFException e) {
            Throwable e2 = e.getMessage();
            throw new IndexOutOfBoundsException(e2);
        }
        return this.a.readByte() & 255;
    }

    @Override // io.grpc.j1.c
    public void skipBytes(int i) {
        try {
            this.a.skip((long)i);
        } catch (java.io.EOFException e) {
            e = e.getMessage();
            throw new IndexOutOfBoundsException(e);
        }
    }

    private void c() {
    }
}
