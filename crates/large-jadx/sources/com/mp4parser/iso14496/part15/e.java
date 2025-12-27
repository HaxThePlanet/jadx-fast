package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.b;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;

/* compiled from: TemporalLayerSampleGroup.java */
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
        int i = 32;
        ByteBuffer allocate = ByteBuffer.allocate(20);
        g.j(allocate, this.a);
        int r2 = this.c ? 32 : 0;
        g.j(allocate, (this.b << 6) + (this.c ? 32 : 0) + (this.c ? 32 : 0));
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
    public void c(ByteBuffer byteBuffer) {
        int i = 1;
        this.a = e.n(byteBuffer);
        int i3 = e.n(byteBuffer);
        this.b = (i3 & 192) >> 6;
        int r1 = i3 & 32 > 0 ? 1 : 0;
        this.c = (i3 & 32 > 0 ? 1 : 0);
        this.d = i3 & 31;
        this.e = e.k(byteBuffer);
        this.f = e.l(byteBuffer);
        this.g = e.n(byteBuffer);
        this.h = e.i(byteBuffer);
        this.i = e.i(byteBuffer);
        this.j = e.n(byteBuffer);
        this.k = e.i(byteBuffer);
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = e.class;
            if (obj == object.getClass()) {
                if (this.a != object.a) {
                    return false;
                }
                if (this.i != object.i) {
                    return false;
                }
                if (this.k != object.k) {
                    return false;
                }
                if (this.j != object.j) {
                    return false;
                }
                if (this.h != object.h) {
                    return false;
                }
                if (this.f != object.f) {
                    return false;
                }
                if (this.g != object.g) {
                    return false;
                }
                if (this.e != object.e) {
                    return false;
                }
                if (this.d != object.d) {
                    return false;
                }
                if (this.b != object.b) {
                    return false;
                }
                return this.c != object.c ? z2 : z;
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int hashCode() {
        int i31 = 32;
        return (this.a * 31) + this.b * 31 + this.c * 31 + this.d * 31 + (int)(l ^ (l >>> i31)) * 31 + (int)(l3 ^ (l3 >>> i31)) * 31 + this.g * 31 + this.h * 31 + this.i * 31 + this.j * 31 + this.k;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String toString() {
        String str2 = "TemporalLayerSampleGroup{temporalLayerId=";
        StringBuilder stringBuilder = new StringBuilder(str2);
        String str3 = ", tlprofile_space=";
        String str4 = ", tltier_flag=";
        String str5 = ", tlprofile_idc=";
        String str6 = ", tlprofile_compatibility_flags=";
        String str7 = ", tlconstraint_indicator_flags=";
        String str8 = ", tllevel_idc=";
        String str9 = ", tlMaxBitRate=";
        String str10 = ", tlAvgBitRate=";
        String str11 = ", tlConstantFrameRate=";
        String str12 = ", tlAvgFrameRate=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + str5 + this.d + str6 + this.e + str7 + this.f + str8 + this.g + str9 + this.h + str10 + this.i + str11 + this.j + str12 + this.k + 125;
        return str;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public String b() {
        return "tscl";
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.samplegrouping.b
    public int d() {
        return 20;
    }
}
