package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class k implements f {

    private final List<com.google.android.exoplayer2.text.u.g> a;
    private final long[] b;
    private final long[] c;
    public k(List<com.google.android.exoplayer2.text.u.g> list) {
        int i;
        Object obj;
        int i2;
        long[] lArr;
        long l;
        super();
        ArrayList arrayList = new ArrayList(list);
        this.a = Collections.unmodifiableList(arrayList);
        this.b = new long[size *= 2];
        i = 0;
        while (i < list.size()) {
            obj = list.get(i);
            int i4 = i * 2;
            lArr = this.b;
            lArr[i4] = obj.b;
            lArr[i4++] = obj.c;
            i++;
        }
        long[] obj7 = this.b;
        obj7 = Arrays.copyOf(obj7, obj7.length);
        this.c = obj7;
        Arrays.sort(obj7);
    }

    static int b(com.google.android.exoplayer2.text.u.g g, com.google.android.exoplayer2.text.u.g g2) {
        return Long.compare(g.b, obj1);
    }

    @Override // com.google.android.exoplayer2.text.f
    public int a(long l) {
        int obj3;
        final int i = 0;
        if (p0.d(this.c, l, obj4, i) < obj4.length) {
        } else {
            obj3 = -1;
        }
        return obj3;
    }

    @Override // com.google.android.exoplayer2.text.f
    public long c(int i) {
        int i2;
        int i3;
        int i4 = 0;
        i3 = i >= 0 ? i2 : i4;
        g.a(i3);
        if (i < lArr2.length) {
        } else {
            i2 = i4;
        }
        g.a(i2);
        return this.c[i];
    }

    public List<c> e(long l) {
        int i;
        int i2;
        long[] cmp2;
        int i3;
        int cmp;
        int i4;
        com.google.android.exoplayer2.text.u.b obj9;
        float obj10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        i2 = i;
        while (i2 < this.a.size()) {
            cmp2 = this.b;
            i3 = i2 * 2;
            if (Long.compare(l2, l) <= 0 && Long.compare(l, i3) < 0) {
            }
            i2++;
            if (Long.compare(l, i3) < 0) {
            }
            cmp2 = this.a.get(i2);
            i3 = cmp2.a;
            if (Float.compare(f, i4) == 0) {
            } else {
            }
            arrayList.add(i3);
            arrayList2.add((g)cmp2);
        }
        Collections.sort(arrayList2, b.a);
        while (i < arrayList2.size()) {
            obj9 = obj9.a.a();
            obj9.h((float)obj10, 1);
            arrayList.add(obj9.a());
            i++;
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.text.f
    public int f() {
        return lArr.length;
    }
}
