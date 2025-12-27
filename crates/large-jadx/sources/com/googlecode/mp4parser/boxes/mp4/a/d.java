package com.googlecode.mp4parser.boxes.mp4.a;

import java.nio.ByteBuffer;

/* compiled from: BitWriterBuffer.java */
/* loaded from: classes2.dex */
public class d {

    int a;
    int b = 0;
    private ByteBuffer c;
    public d(ByteBuffer byteBuffer) {
        super();
        this.c = byteBuffer;
        this.a = byteBuffer.position();
    }

    public void a(int i, int i2) {
        byte b;
        int i4;
        int i6 = 0;
        i5 = (i11 % 8) - 8;
        i6 = 1;
        if (i2 <= i5) {
            i8 = this.a + (i11 / 8);
            b = this.c.get(i8);
            if (b < 0) {
                b += 256;
            }
            i4 = b + (i << (i5 - i2));
            i5 = this.a + (this.b / 8);
            int i7 = 127;
            if (this.b > 127) {
                i4 = i4 - 256;
            }
            this.c.put(this.a + this.b / 8, (byte)i4);
            this.b += i2;
        } else {
            i10 = i2 - i5;
            a(i >> i10, i5);
            i3 = (i6 << i10) - i6;
            i9 = i & i3;
            a(i9, i10);
        }
        if (i12 % 8 <= 0) {
            i6 = 0;
        }
        this.c.position((this.a + (i12 / 8)) + i6);
    }

    public void b(boolean z) {
        a(z, 1);
    }

}
