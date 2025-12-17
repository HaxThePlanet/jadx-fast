package com.coremedia.iso.boxes.fragment;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class a {

    private byte a;
    private byte b;
    private byte c;
    private byte d;
    private byte e;
    private byte f;
    private boolean g;
    private int h;
    public a(ByteBuffer byteBuffer) {
        int obj7;
        super();
        long l = e.k(byteBuffer);
        this.a = (byte)obj7;
        this.b = (byte)obj7;
        this.c = (byte)obj7;
        this.d = (byte)obj7;
        this.e = (byte)obj7;
        this.f = (byte)obj7;
        obj7 = Long.compare(i22, i24) > 0 ? 1 : 0;
        this.g = obj7;
        this.h = (int)i;
    }

    public void a(ByteBuffer byteBuffer) {
        g.g(byteBuffer, i8 |= l8);
    }

    public boolean b() {
        return this.g;
    }

    public boolean equals(Object object) {
        Class<com.coremedia.iso.boxes.fragment.a> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (a.class != object.getClass()) {
            } else {
                if (this.b != object.b) {
                    return i2;
                }
                if (this.a != object.a) {
                    return i2;
                }
                if (this.h != object.h) {
                    return i2;
                }
                if (this.c != object.c) {
                    return i2;
                }
                if (this.e != object.e) {
                    return i2;
                }
                if (this.d != object.d) {
                    return i2;
                }
                if (this.g != object.g) {
                    return i2;
                }
                if (this.f != object.f) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i13 += i15;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("SampleFlags{reserved=");
        stringBuilder.append(this.a);
        stringBuilder.append(", isLeading=");
        stringBuilder.append(this.b);
        stringBuilder.append(", depOn=");
        stringBuilder.append(this.c);
        stringBuilder.append(", isDepOn=");
        stringBuilder.append(this.d);
        stringBuilder.append(", hasRedundancy=");
        stringBuilder.append(this.e);
        stringBuilder.append(", padValue=");
        stringBuilder.append(this.f);
        stringBuilder.append(", isDiffSample=");
        stringBuilder.append(this.g);
        stringBuilder.append(", degradPrio=");
        stringBuilder.append(this.h);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
