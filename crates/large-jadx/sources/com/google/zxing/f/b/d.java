package com.google.zxing.f.b;

import android.accounts.Account;
import com.google.zxing.g.a;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public final class d {

    static final String[] b;
    static final int[][] c;
    private static final int[][] d;
    static final int[][] e;
    private final byte[] a;

    class a implements Comparator<com.google.zxing.f.b.f> {
        a(com.google.zxing.f.b.d d) {
            super();
        }

        @Override // java.util.Comparator
        public int a(com.google.zxing.f.b.f f, com.google.zxing.f.b.f f2) {
            return obj1 -= obj2;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((f)object, (f)object2);
        }
    }
    static {
        int i6;
        int i12;
        int i4;
        int i;
        int[] iArr;
        int i8;
        int i5;
        int i2;
        int i9;
        int i11;
        int i10;
        int i3;
        Class<long> obj;
        int i7;
        Class<int> obj3 = int.class;
        d.b = /* result */;
        int i14 = 5;
        int[][] iArr10 = new int[i14];
        int[] iArr17 = new int[i14];
        iArr17 = new int[]{0, 327708, 327710, 327709, 656318};
        int i21 = 0;
        iArr10[i21] = iArr17;
        int[] iArr18 = new int[i14];
        iArr18 = new int[]{590318, 0, 327710, 327709, 656318};
        int i22 = 1;
        iArr10[i22] = iArr18;
        int[] iArr19 = new int[i14];
        iArr19 = new int[]{262158, 590300, 0, 590301, 932798};
        final int i23 = 2;
        iArr10[i23] = iArr19;
        int[] iArr20 = new int[i14];
        iArr20 = new int[]{327709, 327708, 656318, 0, 327710};
        final int i24 = 3;
        iArr10[i24] = iArr20;
        int[] iArr3 = new int[i14];
        iArr3 = new int[]{327711, 656380, 656382, 656381, 0};
        int i20 = 4;
        iArr10[i20] = iArr3;
        d.c = iArr10;
        int[] iArr4 = new int[i23];
        iArr4 = new int[]{5, 256};
        Object instance2 = Array.newInstance(obj3, iArr4);
        d.d = (int[][])instance2;
        i = 32;
        instance2[i21][i] = i22;
        i6 = 65;
        while (i6 <= 90) {
            d.d[i21][i6] = i29 += i23;
            i6++;
        }
        d.d[i22][i] = i22;
        i12 = 97;
        while (i12 <= 122) {
            d.d[i22][i12] = i28 += i23;
            i12++;
        }
        d.d[i23][i] = i22;
        i4 = 48;
        while (i4 <= 57) {
            d.d[i23][i4] = i27 += i23;
            i4++;
        }
        int[][] arr4 = d.d;
        arr4[i23][44] = 12;
        arr4[i23][46] = 13;
        int i15 = 28;
        int[] iArr12 = new int[i15];
        iArr12 = new int[]{
            0, 32, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 10, 11, 12, 13, 27, 28, 29, 30, 31,
            64, 92, 94, 95, 96, 124, 126, 127
        };
        i2 = i21;
        while (i2 < i15) {
            d.d[i24][iArr12[i2]] = i2;
            i2++;
        }
        int i19 = 31;
        int[] iArr21 = new int[i19];
        iArr21 = new int[]{
            0, 13, 0, 0, 0, 0, 33, 39, 35, 36,
            37, 38, 39, 40, 41, 42, 43, 44, 45, 46,
            47, 58, 59, 60, 61, 62, 63, 91, 93, 123,
            125
        };
        i3 = i21;
        while (i3 < i19) {
            if (iArr21[i3] > 0) {
            }
            i3++;
            d.d[i20][iArr21[i3]] = i3;
        }
        int[] iArr13 = new int[i23];
        iArr13 = new int[]{6, 6};
        Object instance = Array.newInstance(obj3, iArr13);
        d.e = (int[][])instance;
        i9 = i21;
        while (i9 < instance.length) {
            Arrays.fill(instance[i9], -1);
            i9++;
        }
        int[][] arr = d.e;
        arr[i21][i20] = i21;
        arr[i22][i20] = i21;
        arr[i22][i21] = i15;
        arr[i24][i20] = i21;
        arr[i23][i20] = i21;
        arr[i23][i21] = 15;
    }

    public d(byte[] bArr) {
        super();
        this.a = bArr;
    }

    private static Collection<com.google.zxing.f.b.f> b(Iterable<com.google.zxing.f.b.f> iterable) {
        Object next2;
        int i;
        Iterator iterator;
        boolean next;
        boolean z;
        LinkedList linkedList = new LinkedList();
        final Iterator obj6 = iterable.iterator();
        for (f next2 : obj6) {
            i = 1;
            iterator = linkedList.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if ((f)next.f(next2)) {
                    break loop_3;
                } else {
                }
                if (next2.f(next)) {
                }
                iterator.remove();
            }
            if (i != 0) {
            }
            linkedList.add(next2);
            next = iterator.next();
            if ((f)next.f(next2)) {
            } else {
            }
            if (next2.f(next)) {
            }
            iterator.remove();
            i = 0;
        }
        return linkedList;
    }

    private void c(com.google.zxing.f.b.f f, int i2, Collection<com.google.zxing.f.b.f> collection3) {
        char i6;
        int i7;
        int i5;
        int i3;
        int i8;
        int i4;
        com.google.zxing.f.b.f fVar;
        int i;
        com.google.zxing.f.b.f obj8;
        i6 = (char)i9;
        i7 = d.d[f.e()][i6] > 0 ? 1 : i3;
        i8 = 0;
        while (i3 <= 4) {
            i4 = d.d[i3][i6];
            if (i4 > 0 && i8 == 0) {
            }
            i3++;
            if (i8 == 0) {
            }
            if (i7 != 0 && i3 != f.e()) {
            } else {
            }
            collection3.add(i8.g(i3, i4));
            if (i7 == 0 && d.e[f.e()][i3] >= 0) {
            }
            if (d.e[f.e()][i3] >= 0) {
            }
            collection3.add(i8.h(i3, i4));
            if (i3 != f.e()) {
            } else {
            }
            if (i3 == 2) {
            }
            i8 = f.b(i2);
        }
        if (f.c() <= 0) {
            if (d.d[f.e()][i6] == 0) {
                collection3.add(f.a(i2));
            }
        } else {
        }
    }

    private static void d(com.google.zxing.f.b.f f, int i2, int i3, Collection<com.google.zxing.f.b.f> collection4) {
        int i4;
        int i;
        com.google.zxing.f.b.f obj4;
        int obj5;
        int obj6;
        final com.google.zxing.f.b.f fVar = f.b(i2);
        i4 = 4;
        collection4.add(fVar.g(i4, i3));
        if (f.e() != i4) {
            collection4.add(fVar.h(i4, i3));
        }
        final int i6 = 1;
        if (i3 != 3) {
            if (i3 == i4) {
                i4 = 2;
                collection4.add(fVar.g(i4, i3 - 16).g(i4, i6));
            }
        } else {
        }
        if (f.c() > 0) {
            collection4.add(f.a(i2).a(i2 += i6));
        }
    }

    private Collection<com.google.zxing.f.b.f> e(Iterable<com.google.zxing.f.b.f> iterable, int i2) {
        Object next;
        LinkedList linkedList = new LinkedList();
        Iterator obj3 = iterable.iterator();
        for (f next : obj3) {
            c(next, i2, linkedList);
        }
        return d.b(linkedList);
    }

    private static Collection<com.google.zxing.f.b.f> f(Iterable<com.google.zxing.f.b.f> iterable, int i2, int i3) {
        Object next;
        LinkedList linkedList = new LinkedList();
        Iterator obj2 = iterable.iterator();
        for (f next : obj2) {
            d.d(next, i2, i3, linkedList);
        }
        return d.b(linkedList);
    }

    public a a() {
        List singletonList;
        int i4;
        int i;
        byte b2;
        int i5;
        byte b;
        int i3;
        int i2;
        singletonList = Collections.singletonList(f.e);
        int i6 = 0;
        i4 = i6;
        byte[] bArr2 = this.a;
        while (i4 < bArr2.length) {
            i5 = i4 + 1;
            if (i5 < bArr2.length) {
            } else {
            }
            b = i6;
            b2 = bArr2[i4];
            i2 = 32;
            if (b2 != 13 && b2 != 44 && b2 != 46 && b2 != 58) {
            } else {
            }
            if (b == (byte) 10) {
            } else {
            }
            i = i6;
            if (i > 0) {
            } else {
            }
            singletonList = e(singletonList, i4);
            i4++;
            bArr2 = this.a;
            singletonList = d.f(singletonList, i4, i);
            i4 = i5;
            i = 2;
            i2 = 32;
            if (b2 != 44) {
            } else {
            }
            if (b == i2) {
            } else {
            }
            i = 4;
            if (b2 != 46) {
            } else {
            }
            if (b == i2) {
            } else {
            }
            i = 3;
            if (b2 != 58) {
            } else {
            }
            if (b == i2) {
            } else {
            }
            i = 5;
            b = bArr2[i5];
        }
        d.a aVar2 = new d.a(this);
        return (f)Collections.min(singletonList, aVar2).i(this.a);
    }
}
