package com.googlecode.mp4parser.boxes.mp4.a;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class c {

    int a;
    int b;
    private ByteBuffer c;
    public c(ByteBuffer byteBuffer) {
        super();
        this.c = byteBuffer;
        this.a = byteBuffer.position();
    }

    public int a(int i) {
        byte b;
        int i4;
        int i3;
        int i2;
        int i5;
        int obj7;
        b = this.c.get(i10 += i15);
        if (b < 0) {
            b += 256;
        }
        i3 = this.b;
        i2 = i16 - 8;
        if (i <= i2) {
            i7 >>= i5;
            this.b = i3 += i;
        } else {
            i -= i2;
            i9 += obj7;
        }
        this.c.position(i12 += i19);
        return i4;
    }

    public boolean b() {
        int i = 1;
        if (a(i) == i) {
            return i;
        }
        return 0;
    }

    public int c() {
        return i -= i3;
    }
}
