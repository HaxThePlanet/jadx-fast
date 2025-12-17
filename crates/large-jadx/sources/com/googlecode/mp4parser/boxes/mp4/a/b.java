package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
@g(tags = 0)
public abstract class b {

    int a;
    int b;
    int c;
    static {
    }

    abstract int a();

    public int b() {
        return i2++;
    }

    public int c() {
        int i;
        int i2;
        int i3;
        i = a();
        i2 = 0;
        while (i <= 0) {
            if (i2 < this.c) {
            }
            i >>>= 7;
            i2++;
        }
        return i2;
    }

    public final void d(int i, ByteBuffer byteBuffer2) {
        int i3;
        int i2;
        int i4;
        int obj5;
        this.a = i;
        this.b = obj5 & 127;
        int i6 = 1;
        i3 = i6;
        while (obj5 >>>= 7 != i6) {
            i3++;
            this.b = i10 |= i4;
        }
        this.c = i3;
        obj5 = byteBuffer2.slice();
        obj5.limit(this.b);
        e(obj5);
        byteBuffer2.position(obj5 += i8);
    }

    public abstract void e(ByteBuffer byteBuffer);

    public void f(ByteBuffer byteBuffer, int i2) {
        int i;
        int i4;
        int i3;
        int obj6;
        int position = byteBuffer.position();
        i = 0;
        while (obj6 <= 0) {
            if (i < this.c) {
            }
            i++;
            if (obj6 > 0) {
            } else {
            }
            byteBuffer.put(i7 -= i, -128);
            obj6 >>>= 7;
            byteBuffer.put(i9 -= i, (byte)i10);
        }
        byteBuffer.position(position += obj6);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BaseDescriptor");
        stringBuilder.append("{tag=");
        stringBuilder.append(this.a);
        stringBuilder.append(", sizeOfInstance=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
