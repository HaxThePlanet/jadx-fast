package io.grpc.l1.a;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.d1;
import com.google.protobuf.t0;
import io.grpc.n0;
import io.grpc.x;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
final class a extends InputStream implements x, n0 {

    private t0 a;
    private final d1<?> b;
    private ByteArrayInputStream c;
    a(t0 t0, d1<?> d12) {
        super();
        this.a = t0;
        this.b = d12;
    }

    @Override // java.io.InputStream
    public int a(OutputStream outputStream) {
        int serializedSize;
        t0 t0Var;
        t0 t0Var2 = this.a;
        final int i = 0;
        if (t0Var2 != null) {
            serializedSize = t0Var2.getSerializedSize();
            this.a.writeTo(outputStream);
            this.a = i;
        } else {
            ByteArrayInputStream inputStream = this.c;
            if (inputStream != null) {
                serializedSize = (int)t0Var;
                this.c = i;
            } else {
                serializedSize = 0;
            }
        }
        return serializedSize;
    }

    @Override // java.io.InputStream
    public int available() {
        t0 t0Var = this.a;
        if (t0Var != null) {
            return t0Var.getSerializedSize();
        }
        ByteArrayInputStream inputStream = this.c;
        if (inputStream != null) {
            return inputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    t0 c() {
        t0 t0Var = this.a;
        if (t0Var == null) {
        } else {
            return t0Var;
        }
        IllegalStateException illegalStateException = new IllegalStateException("message not available");
        throw illegalStateException;
    }

    d1<?> e() {
        return this.b;
    }

    @Override // java.io.InputStream
    public int read() {
        t0 t0Var;
        byte[] byteArray;
        if (this.a != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.a.toByteArray());
            this.c = byteArrayInputStream;
            this.a = 0;
        }
        ByteArrayInputStream inputStream = this.c;
        if (inputStream != null) {
            return inputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        Object byteArrayInputStream;
        int i;
        byte[] byteArray;
        byteArrayInputStream = this.a;
        final int i4 = -1;
        int serializedSize = byteArrayInputStream.getSerializedSize();
        i = 0;
        if (byteArrayInputStream != null && serializedSize == 0) {
            serializedSize = byteArrayInputStream.getSerializedSize();
            i = 0;
            if (serializedSize == 0) {
                this.a = i;
                this.c = i;
                return i4;
            }
            if (i3 >= serializedSize) {
                CodedOutputStream obj5 = CodedOutputStream.i0(bArr, i2, serializedSize);
                this.a.writeTo(obj5);
                obj5.d0();
                obj5.d();
                this.a = i;
                this.c = i;
                return serializedSize;
            }
            byteArrayInputStream = new ByteArrayInputStream(this.a.toByteArray());
            this.c = byteArrayInputStream;
            this.a = i;
        }
        ByteArrayInputStream inputStream = this.c;
        if (inputStream != null) {
            return inputStream.read(bArr, i2, i3);
        }
        return i4;
    }
}
