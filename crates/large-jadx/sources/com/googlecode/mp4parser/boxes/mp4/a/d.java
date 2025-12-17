package com.googlecode.mp4parser.boxes.mp4.a;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class d {

    int a;
    int b = 0;
    private ByteBuffer c;
    static {
    }

    public d(ByteBuffer byteBuffer) {
        super();
        final int i = 0;
        this.c = byteBuffer;
        this.a = byteBuffer.position();
    }

    public void a(int i, int i2) {
        int i5;
        byte b;
        int i6;
        int i4;
        int i7;
        int i8;
        int i3;
        int obj6;
        int obj7;
        int i9 = this.b;
        i4 = i15 - 8;
        i7 = 1;
        if (i2 <= i4) {
            b = this.c.get(i21 += i14);
            if (b < 0) {
                b += 256;
            }
            b += obj6;
            if (i6 > 127) {
                i6 += -256;
            }
            this.c.put(i18 += i20, (byte)i6);
            this.b = obj6 += i2;
        } else {
            i2 -= i4;
            a(i >> obj7, i4);
            a(i &= i5, obj7);
        }
        int i10 = this.b;
        if (i10 %= 8 > 0) {
        } else {
            i7 = 0;
        }
        this.c.position(obj7 += i7);
    }

    public void b(boolean z) {
        a(z, 1);
    }
}
