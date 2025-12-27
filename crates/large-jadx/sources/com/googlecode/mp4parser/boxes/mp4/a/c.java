package com.googlecode.mp4parser.boxes.mp4.a;

import java.nio.ByteBuffer;

/* compiled from: BitReaderBuffer.java */
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
        int i2;
        int i5;
        b = this.c.get(this.a + (this.b / 8));
        if (b < 0) {
            b += 256;
        }
        i4 = (i3 % 8) - 8;
        if (i <= this.b) {
            i4 = i4 - i;
            i5 = (i3 % 8) + i4;
            i2 = (b << (i3 % 8)) & 255 >> i5;
            this.b += i;
        } else {
            i -= i4;
            i2 = (a(i4) << i23) + a(i23);
        }
        this.c.position(this.a + (int)(Math.ceil((double)this.b / 8d)));
        return i2;
    }

    public boolean b() {
        int i = 1;
        if (a(i) == i) {
            return true;
        }
        return false;
    }

    public int c() {
        return (this.c.limit() * 8) - this.b;
    }
}
