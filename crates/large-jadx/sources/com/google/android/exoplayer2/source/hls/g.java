package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.t.f;
import com.google.android.exoplayer2.l2.u.g;
import com.google.android.exoplayer2.l2.v.d0;
import com.google.android.exoplayer2.l2.v.e;
import com.google.android.exoplayer2.l2.v.g;
import com.google.android.exoplayer2.l2.v.i;
import com.google.android.exoplayer2.l2.v.k;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.z;
import f.c.c.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class g implements com.google.android.exoplayer2.source.hls.k {

    private static final int[] d;
    private final int b;
    private final boolean c;
    static {
        int[] iArr = new int[7];
        iArr = new int[]{8, 13, 11, 2, 0, 1, 7};
        g.d = iArr;
    }

    public g() {
        super(0, 1);
    }

    public g(int i, boolean z2) {
        super();
        this.b = i;
        this.c = z2;
    }

    private static void b(int i, List<Integer> list2) {
        int contains;
        int obj2;
        if (b.g(g.d, i) != -1) {
            if (list2.contains(Integer.valueOf(i))) {
            } else {
                list2.add(Integer.valueOf(i));
            }
        }
    }

    private i d(int i, i1 i12, List<i1> list3, m0 m04) {
        if (i != 0 && i != 1 && i != 2 && i != 7 && i != 8 && i != 11 && i != 13) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 11) {
                                if (i != 13) {
                                    return null;
                                }
                                t obj2 = new t(i12.c, m04);
                                return obj2;
                            }
                            return g.f(this.b, this.c, i12, list3, m04);
                        }
                        return g.e(m04, i12, list3);
                    }
                    obj2 = new f(0, 0, m04);
                    return obj2;
                }
                obj2 = new i();
                return obj2;
            }
            obj2 = new g();
            return obj2;
        }
        obj2 = new e();
        return obj2;
    }

    private static g e(m0 m0, i1 i12, List<i1> list3) {
        int obj3;
        List obj4;
        obj3 = g.g(i12) ? 4 : 0;
        if (list3 != null) {
        } else {
            obj4 = Collections.emptyList();
        }
        g gVar = new g(obj3, m0, 0, obj4);
        return gVar;
    }

    private static d0 f(int i, boolean z2, i1 i13, List<i1> list4, m0 m05) {
        int obj0;
        i1 obj1;
        boolean obj2;
        List obj3;
        if (list4 != null) {
            obj0 |= 32;
        } else {
            if (z2 != null) {
                obj1 = new i1.b();
                obj1.e0("application/cea-608");
                obj3 = Collections.singletonList(obj1.E());
            } else {
                obj3 = Collections.emptyList();
            }
        }
        obj1 = i13.A;
        if (!TextUtils.isEmpty(obj1) && !z.b(obj1, "audio/mp4a-latm")) {
            if (!z.b(obj1, "audio/mp4a-latm")) {
                obj0 |= 2;
            }
            if (!z.b(obj1, "video/avc")) {
                obj0 |= 4;
            }
        }
        obj2 = new k(obj0, obj3);
        obj1 = new d0(2, m05, obj2);
        return obj1;
    }

    private static boolean g(i1 i1) {
        int i;
        com.google.android.exoplayer2.m2.a.b bVar;
        boolean z;
        a obj4 = i1.B;
        final int i2 = 0;
        if (obj4 == null) {
            return i2;
        }
        i = i2;
        while (i < obj4.d()) {
            bVar = obj4.c(i);
            i++;
        }
        return i2;
    }

    private static boolean h(i i, j j2) {
        boolean obj0;
        try {
            obj0 = i.b(j2);
            j2.i();
            j2.i();
            throw i;
            j2.i();
            i = null;
            return obj0;
        }
    }

    @Override // com.google.android.exoplayer2.source.hls.k
    public com.google.android.exoplayer2.source.hls.n a(Uri uri, i1 i12, List list3, m0 m04, Map map5, j j6) {
        return c(uri, i12, list3, m04, map5, j6);
    }

    public com.google.android.exoplayer2.source.hls.e c(Uri uri, i1 i12, List<i1> list3, m0 m04, Map<String, List<String>> map5, j j6) {
        int i2;
        int intValue;
        int i3;
        int i;
        int i4;
        int i5 = p.a(i12.D);
        final int obj12 = p.b(map5);
        int obj8 = p.c(uri);
        int[] iArr = g.d;
        ArrayList arrayList = new ArrayList(iArr.length);
        g.b(i5, arrayList);
        g.b(obj12, arrayList);
        g.b(obj8, arrayList);
        i = i3;
        while (i < iArr.length) {
            g.b(iArr[i], arrayList);
            i++;
        }
        i2 = 0;
        j6.i();
        while (i3 < arrayList.size()) {
            intValue = (Integer)arrayList.get(i3).intValue();
            i = d(intValue, i12, list3, m04);
            g.e(i);
            if (i2 == 0) {
            }
            i3++;
            if (intValue != i5 && intValue != obj12 && intValue != obj8) {
            } else {
            }
            i2 = i;
            if (intValue != obj12) {
            } else {
            }
            if (intValue != obj8) {
            } else {
            }
            if (intValue == 11) {
            }
        }
        g.e(i2);
        obj8 = new e((i)i2, i12, m04);
        return obj8;
    }
}
