package com.google.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
final class b1 extends com.google.protobuf.j.h {

    private final ByteBuffer buffer;
    b1(ByteBuffer byteBuffer) {
        super();
        c0.b(byteBuffer, "buffer");
        this.buffer = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer a0(int i, int i2) {
        int position;
        if (i < this.buffer.position()) {
        } else {
            if (i2 > this.buffer.limit()) {
            } else {
                if (i > i2) {
                } else {
                    ByteBuffer slice = this.buffer.slice();
                    slice.position(i -= position2);
                    slice.limit(i2 -= obj4);
                    return slice;
                }
            }
        }
        Object[] arr = new Object[2];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i), Integer.valueOf(i2)));
        throw illegalArgumentException;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        InvalidObjectException obj2 = new InvalidObjectException("NioByteString instances are not to be serialized directly");
        throw obj2;
    }

    private Object writeReplace() {
        return j.p(this.buffer.slice());
    }

    @Override // com.google.protobuf.j$h
    public boolean B() {
        return x1.r(this.buffer);
    }

    @Override // com.google.protobuf.j$h
    public com.google.protobuf.k E() {
        return k.j(this.buffer, true);
    }

    @Override // com.google.protobuf.j$h
    protected int G(int i, int i2, int i3) {
        int i4;
        byte b;
        int obj3;
        i4 = i2;
        while (i4 < i2 + i3) {
            obj3 += b;
            i4++;
        }
        return obj3;
    }

    @Override // com.google.protobuf.j$h
    protected int I(int i, int i2, int i3) {
        return x1.u(i, this.buffer, i2, i3 += i2);
    }

    @Override // com.google.protobuf.j$h
    public com.google.protobuf.j N(int i, int i2) {
        try {
            b1 obj2 = new b1(a0(i, i2));
            return obj2;
            i = i.getMessage();
            i2 = new ArrayIndexOutOfBoundsException(i);
            throw i2;
            throw i;
        }
    }

    @Override // com.google.protobuf.j$h
    protected String Q(Charset charset) {
        byte[] array;
        int i;
        int remaining;
        if (this.buffer.hasArray()) {
            array = this.buffer.array();
            arrayOffset += position;
            remaining = this.buffer.remaining();
        } else {
            i = 0;
            remaining = array.length;
        }
        String string = new String(array, i, remaining, charset);
        return string;
    }

    @Override // com.google.protobuf.j$h
    void Y(com.google.protobuf.i i) {
        i.a(this.buffer.slice());
    }

    @Override // com.google.protobuf.j$h
    boolean Z(com.google.protobuf.j j, int i2, int i3) {
        return N(0, i3).equals(j.N(i2, i3 += i2));
    }

    @Override // com.google.protobuf.j$h
    public ByteBuffer b() {
        return this.buffer.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.j$h
    public boolean equals(Object object) {
        int i = 1;
        if (object == this) {
            return i;
        }
        int i2 = 0;
        if (!object instanceof j) {
            return i2;
        }
        Object obj = object;
        if (size() != (j)obj.size()) {
            return i2;
        }
        if (size() == 0) {
            return i;
        }
        if (object instanceof b1) {
            return this.buffer.equals(object.buffer);
        }
        if (object instanceof k1) {
            return (b1)object.equals(this);
        }
        return this.buffer.equals(obj.b());
    }

    @Override // com.google.protobuf.j$h
    public byte g(int i) {
        try {
            return this.buffer.get(i);
            i = i.getMessage();
            ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException(i);
            throw arrayIndexOutOfBoundsException;
            throw i;
        }
    }

    @Override // com.google.protobuf.j$h
    public int size() {
        return this.buffer.remaining();
    }

    @Override // com.google.protobuf.j$h
    protected void w(byte[] bArr, int i2, int i3, int i4) {
        ByteBuffer slice = this.buffer.slice();
        slice.position(i2);
        slice.get(bArr, i3, i4);
    }

    @Override // com.google.protobuf.j$h
    public byte z(int i) {
        return g(i);
    }
}
