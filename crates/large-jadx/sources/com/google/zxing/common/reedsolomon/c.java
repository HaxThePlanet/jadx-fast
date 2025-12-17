package com.google.zxing.common.reedsolomon;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {

    private final com.google.zxing.common.reedsolomon.a a;
    private final List<com.google.zxing.common.reedsolomon.b> b;
    public c(com.google.zxing.common.reedsolomon.a a) {
        super();
        this.a = a;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        final int i = 1;
        final int[] iArr = new int[i];
        iArr[0] = i;
        b bVar = new b(a, iArr);
        arrayList.add(bVar);
    }

    private com.google.zxing.common.reedsolomon.b a(int i) {
        Object size;
        int size2;
        int i3;
        List list;
        com.google.zxing.common.reedsolomon.a aVar;
        int[] iArr;
        int i4;
        int i2;
        if (i >= this.b.size()) {
            List list3 = this.b;
            i3 = 1;
            size = list3.get(size3 -= i3);
            size2 = this.b.size();
            while (size2 <= i) {
                aVar = this.a;
                iArr = new int[2];
                iArr[i3] = aVar.c(i8 += i2);
                b bVar = new b(aVar, iArr);
                this.b.add(size.g(bVar));
                size2++;
            }
        }
        return (b)this.b.get(i);
    }

    public void b(int[] iArr, int i2) {
        int i;
        com.google.zxing.common.reedsolomon.b bVar;
        if (i2 == 0) {
        } else {
            length -= i2;
            if (i3 <= 0) {
            } else {
                int[] iArr3 = new int[i3];
                final int i6 = 0;
                System.arraycopy(iArr, i6, iArr3, i6, i3);
                b bVar4 = new b(this.a, iArr3);
                int i5 = 1;
                int[] iArr2 = bVar4.h(i2, i5).b(a(i2))[i5].d();
                i2 -= length2;
                i = i6;
                while (i < obj8) {
                    iArr[i3 + i] = i6;
                    i++;
                }
                System.arraycopy(iArr2, i6, iArr, i3 += obj8, iArr2.length);
            }
            IllegalArgumentException obj7 = new IllegalArgumentException("No data bytes provided");
            throw obj7;
        }
        obj7 = new IllegalArgumentException("No error correction bytes");
        throw obj7;
    }
}
