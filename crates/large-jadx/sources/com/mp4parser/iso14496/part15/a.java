package com.mp4parser.iso14496.part15;

import com.googlecode.mp4parser.boxes.mp4.a.c;
import com.googlecode.mp4parser.boxes.mp4.a.d;
import com.googlecode.mp4parser.e.i.b;
import com.googlecode.mp4parser.g.c.e;
import com.googlecode.mp4parser.g.c.h;
import f.b.a.c;
import f.b.a.e;
import f.b.a.g;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a {

    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public List<byte[]> f;
    public List<byte[]> g;
    public boolean h;
    public int i;
    public int j;
    public int k;
    public List<byte[]> l;
    public int m = 63;
    public int n = 7;
    public int o = 31;
    public int p = 31;
    public int q = 31;
    public a() {
        super();
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.g = arrayList2;
        int i = 1;
        this.h = i;
        this.i = i;
        int i2 = 0;
        this.j = i2;
        this.k = i2;
        ArrayList arrayList3 = new ArrayList();
        this.l = arrayList3;
        int i3 = 63;
        int i4 = 7;
        int i5 = 31;
    }

    public a(ByteBuffer byteBuffer) {
        int i2;
        int i4;
        boolean z;
        int i;
        int bArr3;
        int i3;
        int bArr2;
        int i5;
        byte[] bArr;
        List list2;
        List list;
        int obj12;
        super();
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.g = arrayList2;
        int i6 = 1;
        this.h = i6;
        this.i = i6;
        i2 = 0;
        this.j = i2;
        this.k = i2;
        ArrayList arrayList3 = new ArrayList();
        this.l = arrayList3;
        int i7 = 63;
        int i8 = 7;
        int i9 = 31;
        this.a = e.n(byteBuffer);
        this.b = e.n(byteBuffer);
        this.c = e.n(byteBuffer);
        this.d = e.n(byteBuffer);
        c cVar = new c(byteBuffer);
        i = 6;
        this.m = cVar.a(i);
        bArr3 = 2;
        this.e = cVar.a(bArr3);
        i3 = 3;
        this.n = cVar.a(i3);
        int i26 = 5;
        bArr2 = i2;
        while (bArr2 >= cVar.a(i26)) {
            bArr = new byte[e.i(byteBuffer)];
            byteBuffer.get(bArr);
            this.f.add(bArr);
            bArr2++;
        }
        i4 = i2;
        while (Long.compare(l3, l2) >= 0) {
            bArr2 = new byte[e.i(byteBuffer)];
            byteBuffer.get(bArr2);
            this.g.add(bArr2);
            i4++;
        }
        if (byteBuffer.remaining() < 4) {
            this.h = i2;
        }
        if (this.h) {
            z = this.b;
            if (z != 100 && z != 110 && z != 122) {
                if (z != 110) {
                    if (z != 122) {
                        if (z == 144) {
                            c cVar2 = new c(byteBuffer);
                            this.o = cVar2.a(i);
                            this.i = cVar2.a(bArr3);
                            this.p = cVar2.a(i26);
                            this.j = cVar2.a(i3);
                            this.q = cVar2.a(i26);
                            this.k = cVar2.a(i3);
                            while (Long.compare(l, z) >= 0) {
                                bArr3 = new byte[e.i(byteBuffer)];
                                byteBuffer.get(bArr3);
                                this.l.add(bArr3);
                                i2++;
                            }
                        } else {
                            obj12 = -1;
                            this.i = obj12;
                            this.j = obj12;
                            this.k = obj12;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    public void a(ByteBuffer byteBuffer) {
        List next;
        boolean iterator2;
        int size;
        Iterator iterator;
        int next2;
        int length;
        int length2;
        g.j(byteBuffer, this.a);
        g.j(byteBuffer, this.b);
        g.j(byteBuffer, this.c);
        g.j(byteBuffer, this.d);
        d dVar = new d(byteBuffer);
        length = 6;
        dVar.a(this.m, length);
        final int i13 = 2;
        dVar.a(this.e, i13);
        final int i14 = 3;
        dVar.a(this.n, i14);
        final int i15 = 5;
        dVar.a(this.g.size(), i15);
        Iterator iterator3 = this.f.iterator();
        for (byte[] size : iterator3) {
            g.e(byteBuffer, size.length);
            byteBuffer.put(size);
        }
        g.j(byteBuffer, this.g.size());
        iterator = this.g.iterator();
        for (byte[] next : iterator) {
            g.e(byteBuffer, next.length);
            byteBuffer.put(next);
        }
        if (this.h) {
            iterator2 = this.b;
            if (iterator2 != 100 && iterator2 != 110 && iterator2 != 122) {
                if (iterator2 != 110) {
                    if (iterator2 != 122) {
                        if (iterator2 == 144) {
                            d dVar2 = new d(byteBuffer);
                            dVar2.a(this.o, length);
                            dVar2.a(this.i, i13);
                            dVar2.a(this.p, i15);
                            dVar2.a(this.j, i14);
                            dVar2.a(this.q, i15);
                            dVar2.a(this.k, i14);
                            iterator2 = this.l.iterator();
                            for (byte[] next2 : iterator2) {
                                g.e(byteBuffer, next2.length);
                                byteBuffer.put(next2);
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    public long b() {
        List length;
        boolean iterator;
        int i4;
        int i;
        long l;
        Iterator iterator2;
        int i2;
        int i3;
        Iterator iterator3 = this.f.iterator();
        i4 = 6;
        i2 = 2;
        for (byte[] next4 : iterator3) {
            i5 += l;
            i2 = 2;
        }
        i4 += i3;
        iterator2 = this.g.iterator();
        for (byte[] next2 : iterator2) {
            i6 += i3;
        }
        if (this.h) {
            iterator = this.b;
            if (iterator != 100 && iterator != 110 && iterator != 122) {
                if (iterator != 110) {
                    if (iterator != 122) {
                        if (iterator == 144) {
                            i += i3;
                            iterator = this.l.iterator();
                            for (byte[] next5 : iterator) {
                                i7 += i3;
                            }
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
        return i;
    }

    public String[] c() {
        String string;
        ByteArrayInputStream byteArrayInputStream;
        int i;
        int i2;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.g.iterator();
        for (byte[] next2 : iterator) {
            i2 = 1;
            byteArrayInputStream = new ByteArrayInputStream(next2, i2, length -= i2);
            arrayList.add(e.a(byteArrayInputStream).toString());
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public List<String> d() {
        String str;
        ArrayList arrayList = new ArrayList(this.g.size());
        Iterator iterator = this.g.iterator();
        for (byte[] next2 : iterator) {
            arrayList.add(c.a(next2));
        }
        return arrayList;
    }

    public String[] e() {
        String string;
        b bVar;
        ByteArrayInputStream byteArrayInputStream;
        int i2;
        int i;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.f.iterator();
        for (byte[] next2 : iterator) {
            i = 1;
            byteArrayInputStream = new ByteArrayInputStream(next2, i, length -= i);
            bVar = new b(byteArrayInputStream);
            string = h.b(bVar).toString();
            arrayList.add(string);
            string = "not parsable";
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public List<String> f() {
        String str;
        ArrayList arrayList = new ArrayList(this.l.size());
        Iterator iterator = this.l.iterator();
        for (byte[] next2 : iterator) {
            arrayList.add(c.a(next2));
        }
        return arrayList;
    }

    public List<String> g() {
        String str;
        ArrayList arrayList = new ArrayList(this.f.size());
        Iterator iterator = this.f.iterator();
        for (byte[] next2 : iterator) {
            arrayList.add(c.a(next2));
        }
        return arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("AvcDecoderConfigurationRecord{configurationVersion=");
        stringBuilder.append(this.a);
        stringBuilder.append(", avcProfileIndication=");
        stringBuilder.append(this.b);
        stringBuilder.append(", profileCompatibility=");
        stringBuilder.append(this.c);
        stringBuilder.append(", avcLevelIndication=");
        stringBuilder.append(this.d);
        stringBuilder.append(", lengthSizeMinusOne=");
        stringBuilder.append(this.e);
        stringBuilder.append(", hasExts=");
        stringBuilder.append(this.h);
        stringBuilder.append(", chromaFormat=");
        stringBuilder.append(this.i);
        stringBuilder.append(", bitDepthLumaMinus8=");
        stringBuilder.append(this.j);
        stringBuilder.append(", bitDepthChromaMinus8=");
        stringBuilder.append(this.k);
        stringBuilder.append(", lengthSizeMinusOnePaddingBits=");
        stringBuilder.append(this.m);
        stringBuilder.append(", numberOfSequenceParameterSetsPaddingBits=");
        stringBuilder.append(this.n);
        stringBuilder.append(", chromaFormatPaddingBits=");
        stringBuilder.append(this.o);
        stringBuilder.append(", bitDepthLumaMinus8PaddingBits=");
        stringBuilder.append(this.p);
        stringBuilder.append(", bitDepthChromaMinus8PaddingBits=");
        stringBuilder.append(this.q);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
