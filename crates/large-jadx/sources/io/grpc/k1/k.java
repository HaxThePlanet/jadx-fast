package io.grpc.k1;

import io.grpc.j1.c;
import io.grpc.j1.v1;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import l.f;

/* loaded from: classes3.dex */
class k extends c {

    private final f a;
    k(f f) {
        super();
        this.a = f;
    }

    private void c() {
    }

    @Override // io.grpc.j1.c
    public void D1(OutputStream outputStream, int i2) {
        this.a.a1(outputStream, (long)i2);
    }

    @Override // io.grpc.j1.c
    public void O0(byte[] bArr, int i2, int i3) {
        while (i3 > 0) {
            int read = this.a.read(bArr, i2, i3);
            i3 -= read;
            i2 += read;
        }
    }

    @Override // io.grpc.j1.c
    public v1 Q(int i) {
        f fVar = new f();
        fVar.write(this.a, (long)i);
        k obj5 = new k(fVar);
        return obj5;
    }

    @Override // io.grpc.j1.c
    public void W1(ByteBuffer byteBuffer) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException();
        throw obj1;
    }

    @Override // io.grpc.j1.c
    public void close() {
        this.a.a();
    }

    @Override // io.grpc.j1.c
    public int g() {
        return (int)size;
    }

    @Override // io.grpc.j1.c
    public int readUnsignedByte() {
        try {
            c();
            return byte &= 255;
            Throwable message = message.getMessage();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(message);
            throw indexOutOfBoundsException;
        }
    }

    @Override // io.grpc.j1.c
    public void skipBytes(int i) {
        try {
            this.a.skip((long)i);
            i = i.getMessage();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(i);
            throw indexOutOfBoundsException;
        }
    }
}
