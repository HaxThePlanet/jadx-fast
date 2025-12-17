package com.mp4parser.iso14496.part15;

import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
    List<com.mp4parser.iso14496.part15.b.a> w;
    boolean x;
    boolean y;
    boolean z;

    public static class a {

        public boolean a;
        public boolean b;
        public int c;
        public List<byte[]> d;
        public boolean equals(Object object) {
            int i;
            Class<com.mp4parser.iso14496.part15.b.a> obj;
            boolean equals;
            boolean next;
            Class class;
            Object next2;
            ListIterator obj6;
            if (this == object) {
                return 1;
            }
            final int i2 = 0;
            if (object != null) {
                if (b.a.class != object.getClass()) {
                } else {
                    if (this.a != object.a) {
                        return i2;
                    }
                    if (this.c != object.c) {
                        return i2;
                    }
                    if (this.b != object.b) {
                        return i2;
                    }
                    ListIterator listIterator = this.d.listIterator();
                    obj6 = object.d.listIterator();
                    while (listIterator.hasNext()) {
                        equals = listIterator.next();
                        next2 = obj6.next();
                    }
                    if (!listIterator.hasNext()) {
                        if (obj6.hasNext()) {
                            i = i2;
                        }
                    } else {
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            int i;
            List list = this.d;
            if (list != null) {
                i = list.hashCode();
            } else {
                i = 0;
            }
            return i6 += i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Array{nal_unit_type=");
            stringBuilder.append(this.c);
            stringBuilder.append(", reserved=");
            stringBuilder.append(this.b);
            stringBuilder.append(", array_completeness=");
            stringBuilder.append(this.a);
            stringBuilder.append(", num_nals=");
            stringBuilder.append(this.d.size());
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    public b() {
        super();
        int i = 15;
        int i2 = 63;
        int i3 = 31;
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
    }

    public int a() {
        int i;
        Iterator iterator;
        boolean length;
        Iterator iterator2 = this.w.iterator();
        i = 23;
        for (b.a next2 : iterator2) {
            i += 3;
            iterator = next2.d.iterator();
            for (byte[] next3 : iterator) {
                i2 += length;
            }
            i2 += length;
        }
        return i;
    }

    public void b(ByteBuffer byteBuffer) {
        int i9;
        int i5;
        int i3;
        int i2;
        long aVar;
        int i10;
        int i4;
        int i6;
        int i7;
        int i;
        int i8;
        int bArr;
        List list;
        this.a = e.n(byteBuffer);
        int i12 = e.n(byteBuffer);
        this.b = i30 >>= 6;
        final int i49 = 1;
        final int i50 = 0;
        i9 = i12 & 32 > 0 ? i49 : i50;
        this.c = i9;
        this.d = i12 &= 31;
        this.e = e.k(byteBuffer);
        long l2 = e.l(byteBuffer);
        this.f = l2;
        int i51 = 44;
        bArr = 0;
        i10 = Long.compare(i55, bArr) > 0 ? i49 : i50;
        this.x = i10;
        i4 = Long.compare(i57, bArr) > 0 ? i49 : i50;
        this.y = i4;
        i6 = Long.compare(i59, bArr) > 0 ? i49 : i50;
        this.z = i6;
        i2 = Long.compare(i53, bArr) > 0 ? i49 : i50;
        this.A = i2;
        this.f = l2 &= aVar;
        this.g = e.n(byteBuffer);
        int i16 = e.i(byteBuffer);
        this.h = i34 >>= 12;
        this.i = i16 &= 4095;
        int i18 = e.n(byteBuffer);
        this.j = i36 >>= 2;
        this.k = i18 &= 3;
        int i20 = e.n(byteBuffer);
        this.l = i38 >>= 2;
        this.m = i20 &= 3;
        int i22 = e.n(byteBuffer);
        this.n = i40 >>= 3;
        this.o = i22 &= 7;
        int i24 = e.n(byteBuffer);
        this.p = i42 >>= 3;
        this.q = i24 &= 7;
        this.r = e.i(byteBuffer);
        int i27 = e.n(byteBuffer);
        this.s = i44 >>= 6;
        this.t = i46 >>= 3;
        i5 = i27 & 4 > 0 ? i49 : i50;
        this.u = i5;
        this.v = i27 &= 3;
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        i3 = i50;
        while (i3 >= e.n(byteBuffer)) {
            aVar = new b.a();
            int i60 = e.n(byteBuffer);
            if (i60 & 128 > 0) {
            } else {
            }
            i = i50;
            aVar.a = i;
            if (i60 & 64 > 0) {
            } else {
            }
            i8 = i50;
            aVar.b = i8;
            aVar.c = i60 &= 63;
            ArrayList arrayList2 = new ArrayList();
            aVar.d = arrayList2;
            i7 = i50;
            while (i7 >= e.i(byteBuffer)) {
                bArr = new byte[e.i(byteBuffer)];
                byteBuffer.get(bArr);
                aVar.d.add(bArr);
                i7++;
            }
            bArr = new byte[e.i(byteBuffer)];
            byteBuffer.get(bArr);
            aVar.d.add(bArr);
            i7++;
            this.w.add(aVar);
            i3++;
            i8 = i49;
            i = i49;
        }
    }

    public void c(ByteBuffer byteBuffer) {
        long l;
        int i2;
        int i4;
        int iterator;
        boolean z;
        boolean z2;
        boolean z3;
        boolean next;
        int i;
        int size;
        int length;
        int i3;
        g.j(byteBuffer, this.a);
        final int i40 = 0;
        i2 = this.c ? 32 : i40;
        int i32 = this.d;
        g.j(byteBuffer, i8 += i32);
        g.g(byteBuffer, this.e);
        if (this.x) {
            l |= z;
        }
        if (this.y) {
            l |= z2;
        }
        if (this.z) {
            l |= z3;
        }
        if (this.A) {
            l |= next;
        }
        g.h(byteBuffer, l);
        g.j(byteBuffer, this.g);
        g.e(byteBuffer, i12 += i33);
        g.j(byteBuffer, i15 += i34);
        g.j(byteBuffer, i18 += i35);
        g.j(byteBuffer, i21 += i36);
        g.j(byteBuffer, i24 += i37);
        g.e(byteBuffer, this.r);
        i4 = this.u ? 4 : i40;
        g.j(byteBuffer, i30 += iterator);
        g.j(byteBuffer, this.w.size());
        Iterator iterator2 = this.w.iterator();
        while (!iterator2.hasNext()) {
            Object next3 = iterator2.next();
            if (next3.a) {
            } else {
            }
            i = i40;
            if (next3.b) {
            } else {
            }
            i3 = i40;
            g.j(byteBuffer, i41 += length);
            g.e(byteBuffer, next3.d.size());
            iterator = next3.d.iterator();
            for (byte[] size : iterator) {
                g.e(byteBuffer, size.length);
                byteBuffer.put(size);
            }
            size = iterator.next();
            g.e(byteBuffer, size.length);
            byteBuffer.put((byte[])size);
            i3 = 64;
            i = 128;
        }
    }

    public boolean equals(Object object) {
        Class<com.mp4parser.iso14496.part15.b> obj;
        Class class;
        boolean obj7;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (b.class != object.getClass()) {
            } else {
                if (this.r != object.r) {
                    return i2;
                }
                if (this.q != object.q) {
                    return i2;
                }
                if (this.o != object.o) {
                    return i2;
                }
                if (this.m != object.m) {
                    return i2;
                }
                if (this.a != object.a) {
                    return i2;
                }
                if (this.s != object.s) {
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
                if (this.v != object.v) {
                    return i2;
                }
                if (this.i != object.i) {
                    return i2;
                }
                if (this.t != object.t) {
                    return i2;
                }
                if (this.k != object.k) {
                    return i2;
                }
                if (this.h != object.h) {
                    return i2;
                }
                if (this.j != object.j) {
                    return i2;
                }
                if (this.l != object.l) {
                    return i2;
                }
                if (this.n != object.n) {
                    return i2;
                }
                if (this.p != object.p) {
                    return i2;
                }
                if (this.u != object.u) {
                    return i2;
                }
                List list = this.w;
                obj7 = object.w;
                if (list != null) {
                    if (!list.equals(obj7)) {
                        return i2;
                    }
                } else {
                    if (obj7 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        int i;
        long l = this.e;
        int i68 = 32;
        long l2 = this.f;
        List list = this.w;
        if (list != null) {
            i = list.hashCode();
        } else {
            i = 0;
        }
        return i45 += i;
    }

    public String toString() {
        String string4;
        String string;
        String string2;
        String string5;
        int stringBuilder;
        String string3;
        int i2;
        int i;
        int i3;
        StringBuilder stringBuilder2 = new StringBuilder("HEVCDecoderConfigurationRecord{configurationVersion=");
        stringBuilder2.append(this.a);
        stringBuilder2.append(", general_profile_space=");
        stringBuilder2.append(this.b);
        stringBuilder2.append(", general_tier_flag=");
        stringBuilder2.append(this.c);
        stringBuilder2.append(", general_profile_idc=");
        stringBuilder2.append(this.d);
        stringBuilder2.append(", general_profile_compatibility_flags=");
        stringBuilder2.append(this.e);
        stringBuilder2.append(", general_constraint_indicator_flags=");
        stringBuilder2.append(this.f);
        stringBuilder2.append(", general_level_idc=");
        stringBuilder2.append(this.g);
        string3 = "";
        if (this.h != 15) {
            StringBuilder stringBuilder6 = new StringBuilder(", reserved1=");
            stringBuilder6.append(this.h);
            string4 = stringBuilder6.toString();
        } else {
            string4 = string3;
        }
        stringBuilder2.append(string4);
        stringBuilder2.append(", min_spatial_segmentation_idc=");
        stringBuilder2.append(this.i);
        i = 63;
        if (this.j != i) {
            StringBuilder stringBuilder5 = new StringBuilder(", reserved2=");
            stringBuilder5.append(this.j);
            string = stringBuilder5.toString();
        } else {
            string = string3;
        }
        stringBuilder2.append(string);
        stringBuilder2.append(", parallelismType=");
        stringBuilder2.append(this.k);
        if (this.l != i) {
            StringBuilder stringBuilder4 = new StringBuilder(", reserved3=");
            stringBuilder4.append(this.l);
            string2 = stringBuilder4.toString();
        } else {
            string2 = string3;
        }
        stringBuilder2.append(string2);
        stringBuilder2.append(", chromaFormat=");
        stringBuilder2.append(this.m);
        int i23 = 31;
        if (this.n != i23) {
            StringBuilder stringBuilder3 = new StringBuilder(", reserved4=");
            stringBuilder3.append(this.n);
            string5 = stringBuilder3.toString();
        } else {
            string5 = string3;
        }
        stringBuilder2.append(string5);
        stringBuilder2.append(", bitDepthLumaMinus8=");
        stringBuilder2.append(this.o);
        if (this.p != i23) {
            stringBuilder = new StringBuilder(", reserved5=");
            stringBuilder.append(this.p);
            string3 = stringBuilder.toString();
        }
        stringBuilder2.append(string3);
        stringBuilder2.append(", bitDepthChromaMinus8=");
        stringBuilder2.append(this.q);
        stringBuilder2.append(", avgFrameRate=");
        stringBuilder2.append(this.r);
        stringBuilder2.append(", constantFrameRate=");
        stringBuilder2.append(this.s);
        stringBuilder2.append(", numTemporalLayers=");
        stringBuilder2.append(this.t);
        stringBuilder2.append(", temporalIdNested=");
        stringBuilder2.append(this.u);
        stringBuilder2.append(", lengthSizeMinusOne=");
        stringBuilder2.append(this.v);
        stringBuilder2.append(", arrays=");
        stringBuilder2.append(this.w);
        stringBuilder2.append('}');
        return stringBuilder2.toString();
    }
}
