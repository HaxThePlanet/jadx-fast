package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class e extends b {

    int a;
    int b;
    boolean c;
    int d;
    long e;
    long f;
    int g;
    int h;
    int i;
    int j;
    int k;
    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public ByteBuffer a() {
        int i;
        ByteBuffer allocate = ByteBuffer.allocate(20);
        g.j(allocate, this.a);
        i = this.c ? 32 : 0;
        int i13 = this.d;
        g.j(allocate, i6 += i13);
        g.g(allocate, this.e);
        g.h(allocate, this.f);
        g.j(allocate, this.g);
        g.e(allocate, this.h);
        g.e(allocate, this.i);
        g.j(allocate, this.j);
        g.e(allocate, this.k);
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "tscl";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public void c(ByteBuffer byteBuffer) {
        int i;
        this.a = e.n(byteBuffer);
        int i3 = e.n(byteBuffer);
        this.b = i9 >>= 6;
        i = i3 & 32 > 0 ? 1 : 0;
        this.c = i;
        this.d = i3 &= 31;
        this.e = e.k(byteBuffer);
        this.f = e.l(byteBuffer);
        this.g = e.n(byteBuffer);
        this.h = e.i(byteBuffer);
        this.i = e.i(byteBuffer);
        this.j = e.n(byteBuffer);
        this.k = e.i(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int d() {
        return 20;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        Class<com.mp4parser.iso14496.part15.e> obj;
        Class class;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (e.class != object.getClass()) {
            } else {
                if (this.a != object.a) {
                    return i2;
                }
                if (this.i != object.i) {
                    return i2;
                }
                if (this.k != object.k) {
                    return i2;
                }
                if (this.j != object.j) {
                    return i2;
                }
                if (this.h != object.h) {
                    return i2;
                }
                if (Long.compare(l, l3) != 0) {
                    return i2;
                }
                if (this.g != object.g) {
                    return i2;
                }
                if (Long.compare(l2, l4) != 0) {
                    return i2;
                }
                if (this.d != object.d) {
                    return i2;
                }
                if (this.b != object.b) {
                    return i2;
                }
                if (this.c != object.c) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        long l = this.e;
        int i33 = 32;
        long l2 = this.f;
        return i20 += i32;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("TemporalLayerSampleGroup{temporalLayerId=");
        stringBuilder.append(this.a);
        stringBuilder.append(", tlprofile_space=");
        stringBuilder.append(this.b);
        stringBuilder.append(", tltier_flag=");
        stringBuilder.append(this.c);
        stringBuilder.append(", tlprofile_idc=");
        stringBuilder.append(this.d);
        stringBuilder.append(", tlprofile_compatibility_flags=");
        stringBuilder.append(this.e);
        stringBuilder.append(", tlconstraint_indicator_flags=");
        stringBuilder.append(this.f);
        stringBuilder.append(", tllevel_idc=");
        stringBuilder.append(this.g);
        stringBuilder.append(", tlMaxBitRate=");
        stringBuilder.append(this.h);
        stringBuilder.append(", tlAvgBitRate=");
        stringBuilder.append(this.i);
        stringBuilder.append(", tlConstantFrameRate=");
        stringBuilder.append(this.j);
        stringBuilder.append(", tlAvgFrameRate=");
        stringBuilder.append(this.k);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
