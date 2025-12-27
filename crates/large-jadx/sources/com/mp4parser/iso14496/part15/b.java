package com.mp4parser.iso14496.part15;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* compiled from: HevcDecoderConfigurationRecord.java */
/* loaded from: classes2.dex */
public class b {

    boolean A;
    int a;
    int b;
    boolean c;
    int d;
    long e;
    long f;
    int g;
    int h = 15;
    int i;
    int j = 63;
    int k;
    int l = 63;
    int m;
    int n = 31;
    int o;
    int p = 31;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    int v;
    List<b.a> w = new ArrayList<>();
    boolean x;
    boolean y;
    boolean z;

    public static class a {

        public boolean a;
        public boolean b;
        public int c;
        public List<byte[]> d;
        public boolean equals(Object object) {
            boolean z = true;
            ListIterator listIterator;
            z = true;
            if (this == object) {
                return true;
            }
            final int i = 0;
            if (object != null) {
                obj = b.a.class;
                if (obj == object.getClass()) {
                    if (this.a != object.a) {
                        return false;
                    }
                    if (this.c != object.c) {
                        return false;
                    }
                    if (this.b != object.b) {
                        return false;
                    }
                    ListIterator it = this.d.listIterator();
                    listIterator = object.d.listIterator();
                    while (it.hasNext()) {
                        Object item2 = it.next();
                        Object item = listIterator.next();
                        if (!Arrays.equals(item2, item)) {
                            return false;
                        }
                    }
                    int r0 = i;
                }
                return i;
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            if (this.d != null) {
                i = this.d.hashCode();
            } else {
                i = 0;
            }
            return (this.a * 31) + this.b * 31 + this.c * 31 + i;
        }

        public String toString() {
            String str2 = "Array{nal_unit_type=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", reserved=";
            String str4 = ", array_completeness=";
            String str5 = ", num_nals=";
            int size = this.d.size();
            str = str2 + this.c + str3 + this.b + str4 + this.a + str5 + size + 125;
            return str;
        }
    }
    public b() {
        super();
        ArrayList arrayList = new ArrayList();
    }

    public int a() {
        int i = 23;
        boolean hasNext;
        Iterator it2 = this.w.iterator();
        i = 23;
        while (!it2.hasNext()) {
            i = i + 3;
            Iterator it = (b.a)it2.next().d.iterator();
            while (!it.hasNext()) {
                hasNext = (byte[])it.next().length;
                i = (i + 2) + hasNext;
            }
            hasNext = (byte[])it.next().length;
            i = (i + 2) + hasNext;
        }
        return i;
    }

    public void b(ByteBuffer byteBuffer) {
        int i;
        long l2 = 0;
        List list;
        this.a = e.n(byteBuffer);
        int i3 = e.n(byteBuffer);
        this.b = (i3 & 192) >> 6;
        i = 1;
        i = 0;
        int r1 = i;
        this.c = i;
        this.d = i3 & 31;
        this.e = e.k(byteBuffer);
        long l4 = e.l(byteBuffer);
        this.f = l4;
        int i39 = 44;
        long l9 = (l4 >> i39) & 8L;
        l2 = 0L;
        int r5 = i;
        this.x = i;
        r5 = i & 4L;
        r5 = i;
        this.y = i;
        r5 = i & 2L;
        r5 = i;
        this.z = i;
        long l7 = (l4 >> i39) & 1L;
        int r4 = i;
        this.A = i;
        long l = 140737488355327L;
        this.f = l4 & i;
        this.g = e.n(byteBuffer);
        int i6 = e.i(byteBuffer);
        this.h = (61440 & i6) >> 12;
        this.i = i6 & 4095;
        int i8 = e.n(byteBuffer);
        this.j = (i8 & 252) >> 2;
        this.k = i8 & 3;
        int i10 = e.n(byteBuffer);
        this.l = (i10 & 252) >> 2;
        this.m = i10 & 3;
        int i12 = e.n(byteBuffer);
        this.n = (i12 & 248) >> 3;
        this.o = i12 & 7;
        int i14 = e.n(byteBuffer);
        this.p = (i14 & 248) >> 3;
        this.q = i14 & 7;
        this.r = e.i(byteBuffer);
        int i17 = e.n(byteBuffer);
        this.s = (i17 & 192) >> 6;
        this.t = (i17 & 56) >> 3;
        r1 = i;
        this.u = i;
        this.v = i17 & 3;
        this.w = i;
        while (i >= e.n(byteBuffer)) {
            com.mp4parser.iso14496.part15.b.a aVar = new b.a();
            int i40 = e.n(byteBuffer);
            int r6 = i;
            aVar.a = i;
            r6 = i;
            aVar.b = i;
            aVar.c = i40 & 63;
            aVar.d = i;
            while (i >= e.i(byteBuffer)) {
                byte[] bArr = new byte[e.i(byteBuffer)];
                byteBuffer.get(bArr);
                aVar.d.add(bArr);
                i = i + 1;
            }
            this.w.add(aVar);
            i = i + 1;
            bArr = new byte[e.i(byteBuffer)];
            byteBuffer.get(bArr);
            aVar.d.add(bArr);
            i = i + 1;
        }
    }

    public void c(ByteBuffer byteBuffer) {
        long l;
        ByteBuffer byteBuffer2;
        int i = 32;
        boolean hasNext;
        int length;
        g.j(byteBuffer, this.a);
        i = 0;
        int r1 = this.c ? 32 : i;
        g.j(byteBuffer, (this.b << 6) + (this.c ? 32 : i) + (this.c ? 32 : i));
        g.g(byteBuffer, this.e);
        if (this.x) {
            l = this.f | 140737488355328L;
        }
        if (this.y) {
            l = l | 70368744177664L;
        }
        if (this.z) {
            l = l | 35184372088832L;
        }
        if (this.A) {
            l |= l6;
        }
        g.h(byteBuffer, byteBuffer2);
        g.j(byteBuffer, this.g);
        g.e(byteBuffer, (this.h << 12) + this.i);
        g.j(byteBuffer, (this.j << 2) + this.k);
        g.j(byteBuffer, (this.l << 2) + this.m);
        g.j(byteBuffer, (this.n << 3) + this.o);
        g.j(byteBuffer, (this.p << 3) + this.q);
        g.e(byteBuffer, this.r);
        r1 = this.u ? 4 : i;
        g.j(byteBuffer, (this.s << 6) + (this.t << 3) + (this.u ? 4 : i) + (this.u ? 4 : i));
        g.j(byteBuffer, this.w.size());
        Iterator it = this.w.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            int r3 = item.a ? 128 : i;
            int r4 = item.b ? 64 : i;
            g.j(byteBuffer, (i + (item.b ? 64 : i)) + (item.b ? 64 : i));
            g.e(byteBuffer, item.d.size());
            Iterator it2 = item.d.iterator();
            while (!it2.hasNext()) {
                Object item2 = it2.next();
                length = item2.length;
                g.e(byteBuffer, length);
                byteBuffer.put(item2);
            }
            item2 = it2.next();
            length = item2.length;
            g.e(byteBuffer, length);
            byteBuffer.put(item2);
        }
    }

    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            obj = b.class;
            if (obj == object.getClass()) {
                if (this.r != object.r) {
                    return false;
                }
                if (this.q != object.q) {
                    return false;
                }
                if (this.o != object.o) {
                    return false;
                }
                if (this.m != object.m) {
                    return false;
                }
                if (this.a != object.a) {
                    return false;
                }
                if (this.s != object.s) {
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
                if (this.c != object.c) {
                    return false;
                }
                if (this.v != object.v) {
                    return false;
                }
                if (this.i != object.i) {
                    return false;
                }
                if (this.t != object.t) {
                    return false;
                }
                if (this.k != object.k) {
                    return false;
                }
                if (this.h != object.h) {
                    return false;
                }
                if (this.j != object.j) {
                    return false;
                }
                if (this.l != object.l) {
                    return false;
                }
                if (this.n != object.n) {
                    return false;
                }
                if (this.p != object.p) {
                    return false;
                }
                if (this.u != object.u) {
                    return false;
                }
                if (this.w != null) {
                    if (!this.w.equals(object.w)) {
                        return false;
                    }
                } else {
                    return object.w != null ? z2 : z;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int i66 = 32;
        if (this.w != null) {
            i = this.w.hashCode();
        } else {
            i = 0;
        }
        return (this.a * 31) + this.b * 31 + this.c * 31 + this.d * 31 + (int)(l ^ (l >>> i66)) * 31 + (int)(l3 ^ (l3 >>> i66)) * 31 + this.g * 31 + this.h * 31 + this.i * 31 + this.j * 31 + this.k * 31 + this.l * 31 + this.m * 31 + this.n * 31 + this.o * 31 + this.p * 31 + this.q * 31 + this.r * 31 + this.s * 31 + this.t * 31 + this.u * 31 + this.v * 31 + i;
    }

    public String toString() {
        String str;
        int i4;
        StringBuilder stringBuilder = new StringBuilder("HEVCDecoderConfigurationRecord{configurationVersion=");
        stringBuilder.append(this.a);
        stringBuilder.append(", general_profile_space=");
        stringBuilder.append(this.b);
        stringBuilder.append(", general_tier_flag=");
        stringBuilder.append(this.c);
        stringBuilder.append(", general_profile_idc=");
        stringBuilder.append(this.d);
        stringBuilder.append(", general_profile_compatibility_flags=");
        stringBuilder.append(this.e);
        stringBuilder.append(", general_constraint_indicator_flags=");
        stringBuilder.append(this.f);
        stringBuilder.append(", general_level_idc=");
        stringBuilder.append(this.g);
        str = "";
        int i2 = 15;
        if (this.h != 15) {
            String str23 = ", reserved1=";
            str = str23 + this.h;
        } else {
        }
        stringBuilder.append(str);
        stringBuilder.append(", min_spatial_segmentation_idc=");
        stringBuilder.append(this.i);
        int i3 = 63;
        if (this.j != i3) {
            String str25 = ", reserved2=";
            str = str25 + this.j;
        } else {
        }
        stringBuilder.append(str);
        stringBuilder.append(", parallelismType=");
        stringBuilder.append(this.k);
        if (this.l != i3) {
            String str22 = ", reserved3=";
            str = str22 + this.l;
        } else {
        }
        stringBuilder.append(str);
        stringBuilder.append(", chromaFormat=");
        stringBuilder.append(this.m);
        int i24 = 31;
        if (this.n != i24) {
            String str24 = ", reserved4=";
            str = str24 + this.n;
        } else {
        }
        stringBuilder.append(str);
        stringBuilder.append(", bitDepthLumaMinus8=");
        stringBuilder.append(this.o);
        if (this.p != i24) {
            String str21 = ", reserved5=";
            str = str21 + this.p;
        }
        stringBuilder.append(str);
        stringBuilder.append(", bitDepthChromaMinus8=");
        stringBuilder.append(this.q);
        stringBuilder.append(", avgFrameRate=");
        stringBuilder.append(this.r);
        stringBuilder.append(", constantFrameRate=");
        stringBuilder.append(this.s);
        stringBuilder.append(", numTemporalLayers=");
        stringBuilder.append(this.t);
        stringBuilder.append(", temporalIdNested=");
        stringBuilder.append(this.u);
        stringBuilder.append(", lengthSizeMinusOne=");
        stringBuilder.append(this.v);
        stringBuilder.append(", arrays=");
        stringBuilder.append(this.w);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
