package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.d2;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.u.a;
import com.google.android.exoplayer2.drm.v;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.n2.g;
import com.google.android.exoplayer2.n2.j;
import com.google.android.exoplayer2.source.f0;
import com.google.android.exoplayer2.source.g0;
import com.google.android.exoplayer2.source.g0.a;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker.b;
import com.google.android.exoplayer2.source.hls.playlist.f;
import com.google.android.exoplayer2.source.hls.playlist.f.a;
import com.google.android.exoplayer2.source.k0;
import com.google.android.exoplayer2.source.l0;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.source.w;
import com.google.android.exoplayer2.source.w.a;
import com.google.android.exoplayer2.source.z.a;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.upstream.w;
import com.google.android.exoplayer2.upstream.w.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.z;
import f.c.c.b.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o implements w, com.google.android.exoplayer2.source.hls.q.b, HlsPlaylistTracker.b {

    private final f A;
    private final IdentityHashMap<f0, Integer> B;
    private final com.google.android.exoplayer2.source.hls.s C;
    private final n D;
    private final boolean E;
    private final int F;
    private final boolean G;
    private w.a H;
    private int I;
    private l0 J;
    private com.google.android.exoplayer2.source.hls.q[] K;
    private com.google.android.exoplayer2.source.hls.q[] L;
    private int M;
    private g0 N;
    private final com.google.android.exoplayer2.source.hls.k a;
    private final HlsPlaylistTracker b;
    private final com.google.android.exoplayer2.source.hls.j c;
    private final b0 v;
    private final v w;
    private final u.a x;
    private final w y;
    private final z.a z;
    public o(com.google.android.exoplayer2.source.hls.k k, HlsPlaylistTracker hlsPlaylistTracker2, com.google.android.exoplayer2.source.hls.j j3, b0 b04, v v5, u.a u$a6, w w7, z.a z$a8, f f9, n n10, boolean z11, int i12, boolean z13) {
        super();
        this.a = k;
        this.b = hlsPlaylistTracker2;
        this.c = j3;
        this.v = b04;
        this.w = v5;
        this.x = a6;
        this.y = w7;
        this.z = a8;
        this.A = f9;
        this.D = n10;
        this.E = z11;
        this.F = i12;
        this.G = z13;
        int obj1 = 0;
        this.N = n10.a(new g0[obj1]);
        IdentityHashMap obj2 = new IdentityHashMap();
        this.B = obj2;
        obj2 = new s();
        this.C = obj2;
        this.K = new q[obj1];
        this.L = new q[obj1];
    }

    private void s(long l, List<f.a> list2, List<com.google.android.exoplayer2.source.hls.q> list3, List<int[]> list4, Map<String, t> map5) {
        int i2;
        String str;
        boolean arr;
        Object obj4;
        int i3;
        int iArr;
        boolean z;
        Object obj;
        boolean k0Var;
        Object[] objArr;
        int i;
        List emptyList;
        Map map;
        long l2;
        final Object obj2 = list3;
        ArrayList arrayList = new ArrayList(list3.size());
        ArrayList arrayList2 = new ArrayList(list3.size());
        ArrayList arrayList3 = new ArrayList(list3.size());
        HashSet hashSet = new HashSet();
        final int i4 = 0;
        i2 = i4;
        while (i2 < list3.size()) {
            str = obj3.c;
            if (!hashSet.add(str)) {
            } else {
            }
            arrayList.clear();
            arrayList2.clear();
            arrayList3.clear();
            arr = 1;
            i3 = i4;
            iArr = arr;
            while (i3 < list3.size()) {
                if (p0.b(str, obj5.c)) {
                }
                i3++;
                Object obj6 = obj2.get(i3);
                arrayList3.add(Integer.valueOf(i3));
                arrayList.add(obj6.a);
                arrayList2.add(obj6.b);
                if (p0.E(i1Var.A, arr) == arr) {
                } else {
                }
                z = i4;
                iArr &= z;
                z = arr;
            }
            Uri[] arr2 = new Uri[i4];
            p0.j(arr2);
            str = this.w(1, (Uri[])arrayList.toArray((Uri[])arr2), (i1[])arrayList2.toArray(new i1[i4]), 0, Collections.emptyList(), obj26, l);
            map5.add(b.k(arrayList3));
            list4.add(str);
            if (obj.E && iArr != 0) {
            }
            i2++;
            if (iArr != 0) {
            }
            arr = new k0[arr];
            k0Var = new k0((i1[])arrayList2.toArray(new i1[i4]));
            arr[i4] = k0Var;
            str.c0(arr, i4, new int[i4]);
            if (p0.b(str, obj5.c)) {
            }
            i3++;
            obj6 = obj2.get(i3);
            arrayList3.add(Integer.valueOf(i3));
            arrayList.add(obj6.a);
            arrayList2.add(obj6.b);
            if (p0.E(i1Var.A, arr) == arr) {
            } else {
            }
            z = i4;
            iArr &= z;
            z = arr;
            obj = this;
            obj4 = list4;
            z = map5;
        }
        Object obj8 = this;
    }

    private void t(f f, long l2, List<com.google.android.exoplayer2.source.hls.q> list3, List<int[]> list4, Map<String, t> map5) {
        Object k0Var;
        Object indexOf;
        int k0Var2;
        i1[] k0Var3;
        int i2;
        int i6;
        int i;
        int i10;
        int arr;
        int str2;
        int i7;
        i1[] arr2;
        String str;
        int i8;
        int arrayList;
        int i4;
        String str3;
        int i5;
        boolean z;
        int i9;
        int i3;
        int size;
        Uri uri;
        indexOf = f;
        k0Var2 = indexOf.e.size();
        int[] iArr = new int[k0Var2];
        final int i11 = 0;
        i7 = i;
        i8 = 2;
        i4 = 1;
        while (i2 < indexOf.e.size()) {
            str = obj.b;
            if (str.J <= 0) {
            } else {
            }
            iArr[i2] = i8;
            i++;
            i2++;
            i8 = 2;
            i4 = 1;
            if (p0.F(str.A, i8) != null) {
            } else {
            }
            if (p0.F(str.A, i4) != null) {
            } else {
            }
            iArr[i2] = -1;
            iArr[i2] = i4;
            i7++;
        }
        if (i > 0) {
            k0Var2 = i;
            i6 = i4;
            i10 = i11;
        } else {
            if (i7 < k0Var2) {
                k0Var2 -= i7;
                i6 = i11;
                i10 = i4;
            } else {
                i10 = i6;
            }
        }
        final Uri[] arr5 = new Uri[k0Var2];
        arr2 = new i1[k0Var2];
        int[] iArr2 = new int[k0Var2];
        i9 = i5;
        while (i5 < indexOf.e.size()) {
            if (i6 != 0) {
            } else {
            }
            if (i10 != 0) {
            } else {
            }
            Object obj6 = indexOf.e.get(i5);
            arr5[i9] = obj6.a;
            arr2[i9] = obj6.b;
            iArr2[i9] = i5;
            i9 = size;
            i5++;
            if (iArr[i5] != i4) {
            }
            if (iArr[i5] == i8) {
            }
        }
        String str4 = i1Var.A;
        str2 = p0.E(str4, i8);
        k0Var3 = p0.E(str4, i4);
        if (k0Var3 <= i4 && str2 <= i4 && k0Var3 + str2 > 0) {
            if (str2 <= i4) {
                arrayList = k0Var3 + str2 > 0 ? i4 : i11;
            } else {
            }
        } else {
        }
        if (i6 == 0 && k0Var3 > 0) {
            i3 = k0Var3 > 0 ? i4 : i11;
        } else {
        }
        com.google.android.exoplayer2.source.hls.q qVar = this.w(i3, arr5, arr2, indexOf.j, indexOf.k, obj25, l2);
        list4.add(qVar);
        map5.add(iArr2);
        if (obj2.E && arrayList != null) {
            if (arrayList != null) {
                arrayList = new ArrayList();
                if (str2 > 0) {
                    arr = new i1[k0Var2];
                    z = i11;
                    while (z < k0Var2) {
                        arr[z] = o.z(arr2[z]);
                        z++;
                    }
                    k0Var2 = new k0(arr);
                    arrayList.add(k0Var2);
                    if (k0Var3 > 0) {
                        if (indexOf.j == null) {
                            if (indexOf.g.isEmpty()) {
                                k0Var3 = new i1[i4];
                                k0Var3[i11] = o.x(arr2[i11], indexOf.j, i11);
                                k0Var2 = new k0(k0Var3);
                                arrayList.add(k0Var2);
                            }
                        } else {
                        }
                    }
                    k0Var = indexOf.k;
                    if (k0Var != null) {
                        k0Var2 = i11;
                        while (k0Var2 < k0Var.size()) {
                            arr = new i1[i4];
                            arr[i11] = (i1)k0Var.get(k0Var2);
                            k0Var3 = new k0(arr);
                            arrayList.add(k0Var3);
                            k0Var2++;
                        }
                    }
                } else {
                    k0Var3 = new i1[k0Var2];
                    arr = i11;
                    while (arr < k0Var2) {
                        k0Var3[arr] = o.x(arr2[arr], indexOf.j, i4);
                        arr++;
                    }
                    k0Var = new k0(k0Var3);
                    arrayList.add(k0Var);
                }
                i1[] arr3 = new i1[i4];
                i1.b bVar = new i1.b();
                bVar.S("ID3");
                bVar.e0("application/id3");
                arr3[i11] = bVar.E();
                k0 k0Var4 = new k0(arr3);
                arrayList.add(k0Var4);
                k0Var3 = new int[i4];
                k0Var3[i11] = arrayList.indexOf(k0Var4);
                qVar.c0((k0[])arrayList.toArray(new k0[i11]), i11, k0Var3);
            }
        }
    }

    private void v(long l) {
        Map emptyMap;
        int i2;
        int size;
        long arr2;
        long iArr;
        List arr;
        ArrayList list3;
        ArrayList list;
        ArrayList list2;
        ArrayList emptyList;
        Map map2;
        Map map;
        int i;
        Object obj2;
        int i3;
        int i4;
        Object obj;
        final Object obj7 = this;
        f fVar = obj7.b.g();
        g.e(fVar);
        if (obj7.G) {
            emptyMap = o.y(fVar.m);
        } else {
            emptyMap = Collections.emptyMap();
        }
        final Map map3 = emptyMap;
        final int i7 = 1;
        final List list7 = fVar.h;
        i3 = 0;
        obj7.I = i3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (empty ^= i7 != 0) {
            this.t(fVar, l, obj3, arrayList, arrayList2);
        }
        this.s(l, iArr, fVar.g, arrayList, arrayList2);
        obj7.M = arrayList.size();
        i = i3;
        while (i < list7.size()) {
            obj2 = obj4;
            Uri[] arr4 = new Uri[i7];
            arr4[i3] = obj2.a;
            i1[] arr5 = new i1[i7];
            arr5[i3] = obj2.b;
            i4 = i;
            size = this.w(3, arr4, arr5, 0, Collections.emptyList(), map3, l);
            int[] iArr3 = new int[i7];
            iArr3[i3] = i4;
            arrayList2.add(iArr3);
            arrayList.add(size);
            arr2 = new k0[i7];
            arr = new i1[i7];
            arr[i3] = obj6.b;
            k0 k0Var = new k0(arr);
            arr2[i3] = k0Var;
            size.c0(arr2, i3, new int[i3]);
            i = i4 + 1;
        }
        obj7.K = (q[])arrayList.toArray(new q[i3]);
        Object[] array2 = arrayList2.toArray(new int[i3]);
        com.google.android.exoplayer2.source.hls.q[] objArr = obj7.K;
        obj7.I = objArr.length;
        objArr[i3].l0(i7);
        com.google.android.exoplayer2.source.hls.q[] objArr2 = obj7.K;
        while (i3 < objArr2.length) {
            objArr2[i3].z();
            i3++;
        }
        obj7.L = obj7.K;
    }

    private com.google.android.exoplayer2.source.hls.q w(int i, Uri[] uri2Arr2, i1[] i13Arr3, i1 i14, List<i1> list5, Map<String, t> map6, long l7) {
        final Object obj = this;
        final com.google.android.exoplayer2.source.hls.s sVar = obj.C;
        super(obj.a, obj.b, uri2Arr2, i13Arr3, obj.c, obj.v, sVar, list5);
        super(i, this, iVar3, map6, obj.A, l7, sVar, i14, obj.w, obj.x, obj.y, obj.z, obj.F);
        return qVar2;
    }

    private static i1 x(i1 i1, i1 i12, boolean z3) {
        String str;
        com.google.android.exoplayer2.m2.a aVar;
        int i5;
        int i3;
        int i6;
        String str2;
        int i;
        int i7;
        int i2;
        int i4;
        String obj13;
        i5 = -1;
        if (i12 != null) {
            str = i12.A;
            aVar = i12.B;
            i6 = i12.v;
            obj13 = i12.b;
            i = i14;
            i3 = i16;
            str2 = i2;
        } else {
            obj13 = p0.F(i1.A, 1);
            com.google.android.exoplayer2.m2.a aVar2 = i1.B;
            if (z3) {
                str2 = i1.c;
                str = obj13;
                obj13 = str3;
                i = i2;
                i6 = i11;
                aVar = aVar2;
                i3 = i4;
            } else {
                i = i5;
                str = obj13;
                obj13 = str2;
                aVar = aVar2;
                i3 = i6;
            }
        }
        i7 = z3 ? i1.x : i5;
        if (z3) {
            i5 = i1.y;
        }
        i1.b obj14 = new i1.b();
        obj14.S(i1.a);
        obj14.U(obj13);
        obj14.K(i1.C);
        obj14.e0(z.g(str));
        obj14.I(str);
        obj14.X(aVar);
        obj14.G(i7);
        obj14.Z(i5);
        obj14.H(i);
        obj14.g0(i6);
        obj14.c0(i3);
        obj14.V(str2);
        return obj14.E();
    }

    private static Map<String, t> y(List<t> list) {
        int i;
        Object obj;
        String str;
        int i2;
        int size;
        boolean equals;
        ArrayList arrayList = new ArrayList(list);
        HashMap hashMap = new HashMap();
        i = 0;
        while (i < arrayList.size()) {
            str = obj.c;
            i2 = i;
            while (i2 < arrayList.size()) {
                size = arrayList.get(i2);
                if (TextUtils.equals(size.c, str)) {
                } else {
                }
                i2++;
                obj = obj.f((t)size);
                arrayList.remove(i2);
            }
            hashMap.put(str, obj);
            size = arrayList.get(i2);
            if (TextUtils.equals(size.c, str)) {
            } else {
            }
            i2++;
            obj = obj.f((t)size);
            arrayList.remove(i2);
        }
        return hashMap;
    }

    private static i1 z(i1 i1) {
        String str2 = p0.F(i1.A, 2);
        i1.b bVar = new i1.b();
        bVar.S(i1.a);
        bVar.U(i1.b);
        bVar.K(i1.C);
        bVar.e0(z.g(str2));
        bVar.I(str2);
        bVar.X(i1.B);
        bVar.G(i1.x);
        bVar.Z(i1.y);
        bVar.j0(i1.I);
        bVar.Q(i1.J);
        bVar.P(i1.K);
        bVar.g0(i1.v);
        bVar.c0(i1.w);
        return bVar.E();
    }

    @Override // com.google.android.exoplayer2.source.w
    public void A(com.google.android.exoplayer2.source.hls.q q) {
        this.H.i(this);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void B() {
        int i;
        com.google.android.exoplayer2.source.hls.q qVar;
        this.b.b(this);
        com.google.android.exoplayer2.source.hls.q[] objArr = this.K;
        i = 0;
        while (i < objArr.length) {
            objArr[i].e0();
            i++;
        }
        this.H = 0;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long a() {
        return this.N.a();
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean b(long l) {
        int i;
        com.google.android.exoplayer2.source.hls.q qVar;
        if (this.J == null) {
            com.google.android.exoplayer2.source.hls.q[] obj4 = this.K;
            int i2 = 0;
            i = i2;
            while (i < obj4.length) {
                obj4[i].z();
                i++;
            }
            return i2;
        }
        return this.N.b(l);
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean c() {
        return this.N.c();
    }

    @Override // com.google.android.exoplayer2.source.w
    public void d() {
        int i6;
        int i7;
        int i2;
        int i3;
        int i5;
        com.google.android.exoplayer2.source.hls.q qVar;
        int i;
        int i4;
        int i8;
        k0 k0Var;
        i9--;
        this.I = i10;
        if (i10 > 0) {
        }
        com.google.android.exoplayer2.source.hls.q[] objArr = this.K;
        final int i11 = 0;
        i7 = i6;
        while (i6 < objArr.length) {
            i7 += i3;
            i6++;
        }
        k0[] arr = new k0[i7];
        com.google.android.exoplayer2.source.hls.q[] objArr2 = this.K;
        i5 = i2;
        while (i2 < objArr2.length) {
            qVar = objArr2[i2];
            i4 = i11;
            while (i4 < l0Var3.a) {
                arr[i5] = qVar.r().a(i4);
                i4++;
                i5 = i8;
            }
            i2++;
            arr[i5] = qVar.r().a(i4);
            i4++;
            i5 = i8;
        }
        l0 l0Var = new l0(arr);
        this.J = l0Var;
        this.H.n(this);
    }

    @Override // com.google.android.exoplayer2.source.w
    public long e() {
        return this.N.e();
    }

    @Override // com.google.android.exoplayer2.source.w
    public void f(long l) {
        this.N.f(l);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void g() {
        int i;
        com.google.android.exoplayer2.source.hls.q qVar;
        com.google.android.exoplayer2.source.hls.q[] objArr = this.K;
        i = 0;
        while (i < objArr.length) {
            objArr[i].a0();
            i++;
        }
        this.H.i(this);
    }

    @Override // com.google.android.exoplayer2.source.w
    public boolean h(Uri uri, w.c w$c2, boolean z3) {
        int i;
        int i2;
        boolean z;
        final com.google.android.exoplayer2.source.hls.q[] objArr = this.K;
        i = 1;
        i2 = 0;
        while (i2 < objArr.length) {
            i &= z;
            i2++;
        }
        this.H.i(this);
        return i;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void i(g0 g0) {
        A((q)g0);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void j(Uri uri) {
        this.b.l(uri);
    }

    @Override // com.google.android.exoplayer2.source.w
    public void k() {
        int i;
        com.google.android.exoplayer2.source.hls.q qVar;
        final com.google.android.exoplayer2.source.hls.q[] objArr = this.K;
        i = 0;
        while (i < objArr.length) {
            objArr[i].k();
            i++;
        }
    }

    @Override // com.google.android.exoplayer2.source.w
    public long l(long l) {
        com.google.android.exoplayer2.source.hls.q[] objArr;
        int length2;
        com.google.android.exoplayer2.source.hls.q qVar;
        int length;
        objArr = this.L;
        if (objArr.length > 0) {
            int i = 0;
            objArr = objArr[i].h0(l, obj6);
            length2 = 1;
            qVar = this.L;
            for (Object qVar : obj2) {
                qVar.h0(l, obj6);
                qVar = this.L;
            }
            if (objArr) {
                this.C.b();
            }
        }
        return l;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long m(long l, d2 d22) {
        return l;
    }

    @Override // com.google.android.exoplayer2.source.w
    public long o() {
        return -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void p(w.a w$a, long l2) {
        this.H = a;
        this.b.m(this);
        v(l2);
    }

    @Override // com.google.android.exoplayer2.source.w
    public long q(g[] gArr, boolean[] z2Arr2, f0[] f03Arr3, boolean[] z4Arr4, long l5) {
        Object[] objArr2;
        com.google.android.exoplayer2.source.hls.s sVar;
        int i10;
        int length2;
        Object obj2;
        int intValue;
        int i;
        Object obj;
        int length;
        int i2;
        com.google.android.exoplayer2.source.hls.q[] length3;
        int i8;
        int length4;
        int i6;
        f0[] objArr3;
        int i7;
        boolean[] zArr;
        g[] arr2;
        long valueOf;
        com.google.android.exoplayer2.source.hls.q[] arr;
        int i9;
        int i3;
        int i4;
        g[] objArr;
        int i5;
        final Object obj3 = this;
        Object[] objArr4 = gArr;
        objArr2 = f03Arr3;
        int[] iArr = new int[objArr4.length];
        int[] iArr2 = new int[objArr4.length];
        i10 = 0;
        for (Object obj6 : obj1) {
            i = -1;
            if (objArr2[i10] == null) {
            } else {
            }
            intValue = (Integer)obj3.B.get(objArr2[i10]).intValue();
            iArr[i10] = intValue;
            iArr2[i10] = i;
            if (objArr4[i10] != null) {
            }
            obj = 0;
            length3 = obj3.K;
            while (obj < length3.length) {
                if (length3[obj].r().b(obj6.a()) != i) {
                    break loop_7;
                } else {
                }
                obj++;
                length3 = obj3.K;
            }
            if (length3[obj].r().b(obj2) != i) {
            } else {
            }
            obj++;
            iArr2[i10] = obj;
            intValue = i;
        }
        obj3.B.clear();
        f0[] arr3 = new f0[objArr4.length];
        f0[] arr4 = new f0[objArr4.length];
        arr2 = new g[objArr4.length];
        arr = new q[objArr8.length];
        i6 = 0;
        i7 = 0;
        i3 = 0;
        while (i7 < objArr9.length) {
            i2 = 0;
            for (Object length4 : obj1) {
                if (iArr[i2] == i7) {
                } else {
                }
                i8 = length4;
                arr4[i2] = i8;
                if (iArr2[i2] == i7) {
                }
                arr2[i2] = length4;
                i8 = objArr2[i2];
            }
            com.google.android.exoplayer2.source.hls.q qVar3 = obj3.K[i7];
            sVar = qVar3;
            int i12 = i7;
            i5 = i11;
            com.google.android.exoplayer2.source.hls.q[] objArr7 = arr;
            length3 = 0;
            length4 = 0;
            zArr = 1;
            while (length3 < objArr4.length) {
                objArr3 = arr4[length3];
                if (iArr2[length3] == i12) {
                } else {
                }
                if (iArr[length3] == i12) {
                }
                length3++;
                zArr = 1;
                if (objArr3 == null) {
                } else {
                }
                zArr = 0;
                g.f(zArr);
                g.e(objArr3);
                arr3[length3] = objArr3;
                obj3.B.put(objArr3, Integer.valueOf(i12));
                length4 = zArr;
            }
            if (length4 != 0) {
            } else {
            }
            i6 = i5;
            i7 = i12 + 1;
            arr = objArr7;
            length2 = i4;
            arr2 = objArr;
            objArr2 = f03Arr3;
            objArr7[i5] = sVar;
            i6 = i5 + 1;
            if (i5 == 0) {
            } else {
            }
            if (i12 < obj3.M) {
            } else {
            }
            zArr = 0;
            sVar.l0(zArr);
            sVar.l0(zArr);
            length = obj3.L;
            if (!qVar3.i0(arr2, z2Arr2, arr4, z4Arr4, l5, arr) && length.length != 0) {
            } else {
            }
            obj3.C.b();
            i3 = zArr;
            length = obj3.L;
            if (length.length != 0) {
            } else {
            }
            if (sVar != length[0]) {
            }
            objArr3 = arr4[length3];
            if (iArr2[length3] == i12) {
            } else {
            }
            if (iArr[length3] == i12) {
            }
            length3++;
            if (objArr3 == null) {
            } else {
            }
            zArr = 0;
            g.f(zArr);
            g.e(objArr3);
            arr3[length3] = objArr3;
            obj3.B.put(objArr3, Integer.valueOf(i12));
            length4 = zArr;
            if (iArr[i2] == i7) {
            } else {
            }
            i8 = length4;
            arr4[i2] = i8;
            if (iArr2[i2] == i7) {
            }
            arr2[i2] = length4;
            i2++;
            length4 = objArr4[i2];
            i8 = objArr2[i2];
        }
        int i13 = 0;
        System.arraycopy(arr3, i13, objArr2, i13, length2);
        Object[] objArr5 = p0.s0(arr, i6);
        obj3.L = (q[])objArr5;
        obj3.N = obj3.D.a(objArr5);
        return l5;
    }

    @Override // com.google.android.exoplayer2.source.w
    public l0 r() {
        final l0 l0Var = this.J;
        g.e(l0Var);
        return (l0)l0Var;
    }

    @Override // com.google.android.exoplayer2.source.w
    public void u(long l, boolean z2) {
        int i;
        com.google.android.exoplayer2.source.hls.q qVar;
        final com.google.android.exoplayer2.source.hls.q[] objArr = this.L;
        i = 0;
        while (i < objArr.length) {
            objArr[i].u(l, z2);
            i++;
        }
    }
}
