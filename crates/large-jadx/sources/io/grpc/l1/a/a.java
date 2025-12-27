package io.grpc.l1.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.d1;
import com.google.protobuf.t0;
import io.grpc.n0;
import io.grpc.x;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: ProtoInputStream.java */
/* loaded from: classes3.dex */
final class a extends InputStream implements x, n0 {

    private t0 a;
    private final d1<?> b;
    private ByteArrayInputStream c;
    a(t0 t0Var, d1<?> d1Var) {
        super();
        this.a = t0Var;
        this.b = d1Var;
    }

    @Override // java.io.InputStream
    public int a(OutputStream outputStream) {
        int serializedSize = 0;
        final t0 t0Var3 = null;
        if (this.a != null) {
            serializedSize = this.a.getSerializedSize();
            this.a.writeTo(outputStream);
            this.a = t0Var3;
        } else {
            if (this.c != null) {
                serializedSize = (int)(b.a(this.c, outputStream));
                this.c = t0Var3;
            } else {
                serializedSize = 0;
            }
        }
        return serializedSize;
    }

    @Override // java.io.InputStream
    public int available() {
        if (this.a != null) {
            return this.a.getSerializedSize();
        }
        if (this.c != null) {
            return this.c.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    t0 c() {
        if (this.a == null) {
            throw new IllegalStateException("message not available");
        } else {
            return this.a;
        }
    }

    @Override // java.io.InputStream
    d1<?> e() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.a != null) {
            this.c = new ByteArrayInputStream(this.a.toByteArray());
            t0 t0Var = null;
            this.a = t0Var;
        }
        if (this.c != null) {
            return this.c.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        i = -1;
        if (this.a != null) {
            int serializedSize = this.a.getSerializedSize();
            t0 t0Var2 = null;
            if (serializedSize == 0) {
                this.a = t0Var2;
                this.c = t0Var2;
                return i;
            }
            if (i2 >= serializedSize) {
                CodedOutputStream codedOutputStream = CodedOutputStream.i0(bArr, i, serializedSize);
                this.a.writeTo(codedOutputStream);
                codedOutputStream.d0();
                codedOutputStream.d();
                this.a = t0Var2;
                this.c = t0Var2;
                return serializedSize;
            }
            this.c = new ByteArrayInputStream(this.a.toByteArray());
            this.a = t0Var2;
        }
        if (this.c != null) {
            return this.c.read(bArr, i, i2);
        }
        return i;
    }
}
