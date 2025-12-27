package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.e;
import java.nio.ByteBuffer;

/* compiled from: BaseDescriptor.java */
@g(tags = 0)
/* loaded from: classes2.dex */
public abstract class b {

    int a;
    int b;
    int c;
    public int b() {
        return (a() + c()) + 1;
    }

    public int c() {
        int i;
        int i2 = 0;
        int i3;
        i = a();
        i2 = 0;
        while (i <= 0) {
            if (i2 >= this.c) {
                return i2;
            }
        }
        return i2;
    }

    public final void d(int i, ByteBuffer byteBuffer) {
        int i2;
        int i5;
        this.a = i;
        this.b = e.n(byteBuffer) & 127;
        i2 = 1;
        while (i5 >>> 7 != i2) {
            i2 = i2 + 1;
            i4 = e.n(byteBuffer) & 127;
            i3 = (this.b << 7) | i4;
            this.b = i3;
        }
        this.c = i2;
        ByteBuffer slice = byteBuffer.slice();
        slice.limit(this.b);
        e(slice);
        byteBuffer.position(byteBuffer.position() + this.b);
    }

    public void f(ByteBuffer byteBuffer, int i) {
        int i3;
        byte b = -128;
        int i4;
        int position = byteBuffer.position();
        i = 0;
        while (i4 <= 0) {
            if (i >= this.c) {
                byteBuffer.position(position + c());
                return;
            }
        }
        byteBuffer.position(position + c());
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "BaseDescriptor";
        String str3 = "{tag=";
        String str4 = ", sizeOfInstance=";
        str = str2 + str3 + this.a + str4 + this.b + 125;
        return str;
    }


    abstract int a();

    public abstract void e(ByteBuffer byteBuffer);
}
