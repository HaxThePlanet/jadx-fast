package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* loaded from: classes2.dex */
class d0 extends InputStream {

    private long A = 0;
    private Iterator<ByteBuffer> a;
    private ByteBuffer b;
    private int c = 0;
    private int v;
    private int w = 0;
    private boolean x;
    private byte[] y;
    private int z;
    d0(Iterable<ByteBuffer> iterable) {
        int i2;
        int i;
        boolean obj3;
        super();
        this.a = iterable.iterator();
        obj3 = iterable.iterator();
        for (ByteBuffer next2 : obj3) {
            this.c = i3++;
        }
        this.v = -1;
        if (!a()) {
            this.b = c0.c;
            this.v = 0;
            i2 = 0;
        }
    }

    private boolean a() {
        int arrayOffset;
        int i;
        final int i4 = 1;
        this.v = i2 += i4;
        i = 0;
        if (!this.a.hasNext()) {
            return i;
        }
        Object next2 = this.a.next();
        this.b = (ByteBuffer)next2;
        this.w = next2.position();
        if (this.b.hasArray()) {
            this.x = i4;
            this.y = this.b.array();
            this.z = this.b.arrayOffset();
        } else {
            this.x = i;
            this.A = w1.k(this.b);
            this.y = 0;
        }
        return i4;
    }

    private void c(int i) {
        i2 += i;
        this.w = i3;
        if (i3 == this.b.limit()) {
            a();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.v == this.c) {
            return -1;
        }
        int i7 = 1;
        if (this.x) {
            c(i7);
            return b &= 255;
        }
        c(i7);
        return b2 &= 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) {
        int position;
        ByteBuffer byteBuffer;
        int i;
        Object obj4;
        int obj6;
        if (this.v == this.c) {
            return -1;
        }
        int i7 = this.w;
        limit -= i7;
        if (i3 > i5) {
            obj6 = i5;
        }
        if (this.x) {
            System.arraycopy(this.y, i7 += i, bArr, i2, obj6);
            c(obj6);
        } else {
            this.b.position(this.w);
            this.b.get(bArr, i2, obj6);
            this.b.position(this.b.position());
            c(obj6);
        }
        return obj6;
    }
}
