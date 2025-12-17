package io.grpc.k1.r.j;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import l.d0;
import l.f;
import l.h;
import l.i;
import l.q;

/* loaded from: classes3.dex */
final class f {

    private static final i a;
    private static final io.grpc.k1.r.j.d[] b;
    private static final Map<i, Integer> c;

    static final class a {

        private final List<io.grpc.k1.r.j.d> a;
        private final h b;
        private int c;
        private int d;
        io.grpc.k1.r.j.d[] e;
        int f;
        int g;
        int h;
        a(int i, int i2, d0 d03) {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            io.grpc.k1.r.j.d[] arr = new d[8];
            this.e = arr;
            this.f = length--;
            int i5 = 0;
            this.g = i5;
            this.h = i5;
            this.c = i;
            this.d = i2;
            this.b = q.d(d03);
        }

        a(int i, d0 d02) {
            super(i, i, d02);
        }

        private void a() {
            int i;
            final int i2 = this.d;
            i = this.h;
            if (i2 < i) {
                if (i2 == 0) {
                    b();
                } else {
                    d(i -= i2);
                }
            }
        }

        private void b() {
            Arrays.fill(this.e, 0);
            this.f = length--;
            int i2 = 0;
            this.g = i2;
            this.h = i2;
        }

        private int c(int i) {
            return i3 += i;
        }

        private int d(int i) {
            int i3;
            int i2;
            int i6;
            int i4;
            int i5;
            int obj5;
            i3 = 0;
            if (i > 0) {
                length--;
                int i7 = this.f;
                while (i2 >= i7) {
                    if (obj5 > 0) {
                    }
                    io.grpc.k1.r.j.d[] objArr2 = this.e;
                    obj5 -= i11;
                    this.h = i12 -= i8;
                    this.g = i9--;
                    i3++;
                    i2--;
                    i7 = this.f;
                }
                obj5 = this.e;
                System.arraycopy(obj5, i7 + 1, obj5, i10 += i3, this.g);
                this.f = obj5 += i3;
            }
            return i3;
        }

        private i f(int i) {
            io.grpc.k1.r.j.d[] objArr;
            int length;
            if (i(i)) {
                return obj4.a;
            }
            int i3 = c(i - length2);
            if (i3 < 0) {
            } else {
                objArr = this.e;
                if (i3 >= objArr.length) {
                } else {
                    return obj4.a;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(i++);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }

        private void h(int i, io.grpc.k1.r.j.d d2) {
            int i4;
            io.grpc.k1.r.j.d[] objArr;
            io.grpc.k1.r.j.d[] objArr2;
            int i3;
            int length2;
            int i2;
            int length3;
            int length;
            int obj6;
            this.a.add(d2);
            int i5 = -1;
            if (i != i5) {
                i4 -= i3;
            }
            int i9 = this.d;
            if (i4 > i9) {
                b();
            }
            if (i == i5) {
                objArr2 = this.e;
                if (obj6++ > objArr2.length) {
                    obj6 = new d[obj6 *= 2];
                    System.arraycopy(objArr2, 0, obj6, objArr2.length, objArr2.length);
                    this.f = length4--;
                    this.e = obj6;
                }
                obj6 = this.f;
                this.f = obj6 + -1;
                this.e[obj6] = d2;
                this.g = obj6++;
            } else {
                this.e[i += i8] = d2;
            }
            this.h = obj6 += i4;
        }

        private boolean i(int i) {
            int i2;
            int i3;
            if (i >= 0 && i <= length -= i2) {
                if (i <= length -= i2) {
                } else {
                    i2 = 0;
                }
            } else {
            }
            return i2;
        }

        private int j() {
            return byte &= 255;
        }

        private void m(int i) {
            Object list;
            io.grpc.k1.r.j.d[] objArr;
            int i2;
            Object obj4;
            if (i(i)) {
                this.a.add(f.a()[i]);
            } else {
                int i4 = c(i - length);
                if (i4 < 0) {
                } else {
                    objArr = this.e;
                    if (i4 > length2--) {
                    } else {
                        this.a.add(objArr[i4]);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Header index too large ");
            stringBuilder.append(i++);
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }

        private void o(int i) {
            d dVar = new d(f(i), k());
            h(-1, dVar);
        }

        private void p() {
            i iVar = k();
            f.b(iVar);
            d dVar = new d(iVar, k());
            h(-1, dVar);
        }

        private void q(int i) {
            d dVar = new d(f(i), k());
            this.a.add(dVar);
        }

        private void r() {
            final i iVar = k();
            f.b(iVar);
            d dVar = new d(iVar, k());
            this.a.add(dVar);
        }

        public List<io.grpc.k1.r.j.d> e() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        void g(int i) {
            this.c = i;
            this.d = i;
            a();
        }

        i k() {
            int i;
            int i2 = j();
            i = i2 & 128 == 128 ? 1 : 0;
            int i3 = n(i2, 127);
            if (i != 0) {
                return i.t(h.f().c(this.b.p1((long)i3)));
            }
            return this.b.B((long)i3);
        }

        void l() {
            int i2;
            int i3;
            int i;
            while (!this.b.b0()) {
                byte &= 255;
                int i7 = 128;
                i3 = 64;
                if (i2 != 16) {
                } else {
                }
                r();
                if (i2 == 0) {
                } else {
                }
                q(i6--);
                i2 = n(i2, 31);
                this.d = i2;
                a();
                o(i5--);
                p();
                m(i4--);
            }
        }

        int n(int i, int i2) {
            int i4;
            int i3;
            int obj3;
            int obj4;
            i &= i2;
            if (obj3 < i2) {
                return obj3;
            }
            obj3 = 0;
            int i5 = j();
            while (i5 & 128 != 0) {
                obj4 += i4;
                obj3 += 7;
                i5 = j();
            }
            return obj4 += obj3;
        }
    }

    static final class b {

        private final f a;
        private boolean b;
        private int c;
        private boolean d;
        private int e;
        io.grpc.k1.r.j.d[] f;
        int g;
        private int h;
        private int i;
        b(int i, boolean z2, f f3) {
            super();
            this.c = Integer.MAX_VALUE;
            io.grpc.k1.r.j.d[] arr = new d[8];
            this.f = arr;
            this.h = length--;
            this.e = i;
            this.b = z2;
            this.a = f3;
        }

        b(f f) {
            super(4096, 0, f);
        }

        private void a() {
            Arrays.fill(this.f, 0);
            this.h = length--;
            int i2 = 0;
            this.g = i2;
            this.i = i2;
        }

        private int b(int i) {
            int i5;
            int i2;
            int i6;
            int i4;
            int i3;
            int obj5;
            i5 = 0;
            if (i > 0) {
                length--;
                int i7 = this.h;
                while (i2 >= i7) {
                    if (obj5 > 0) {
                    }
                    io.grpc.k1.r.j.d[] objArr2 = this.f;
                    obj5 -= i11;
                    this.i = i12 -= i8;
                    this.g = i9--;
                    i5++;
                    i2--;
                    i7 = this.h;
                }
                obj5 = this.f;
                System.arraycopy(obj5, i7 + 1, obj5, i10 += i5, this.g);
                this.h = obj5 += i5;
            }
            return i5;
        }

        private void c(io.grpc.k1.r.j.d d) {
            int arr;
            io.grpc.k1.r.j.d[] objArr;
            int length3;
            int length2;
            int length;
            final int i = d.c;
            int i2 = this.e;
            if (i > i2) {
                a();
            }
            b(i7 -= i2);
            objArr = this.f;
            if (i3++ > objArr.length) {
                arr = new d[length4 *= 2];
                System.arraycopy(objArr, 0, arr, objArr.length, objArr.length);
                this.h = length5--;
                this.f = arr;
            }
            int i5 = this.h;
            this.h = i5 + -1;
            this.f[i5] = d;
            this.g = obj7++;
            this.i = obj7 += i;
        }

        void d(i i) {
            boolean z;
            f fVar;
            int i3;
            int i2;
            java.io.OutputStream outputStream;
            i obj5;
            final int i6 = 127;
            if (this.b && h.f().e(i.D()) < i.A()) {
                if (h.f().e(i.D()) < i.A()) {
                    f fVar2 = new f();
                    h.f().d(i.D(), fVar2.b2());
                    obj5 = fVar2.Y0();
                    f(obj5.A(), i6, 128);
                    this.a.e0(obj5);
                } else {
                    f(i.A(), i6, 0);
                    this.a.e0(i);
                }
            } else {
            }
        }

        void e(List<io.grpc.k1.r.j.d> list) {
            boolean z;
            int i5;
            int i4;
            int i2;
            int equals3;
            i iVar;
            int i;
            f fVar;
            int equals;
            int equals2;
            int i3;
            io.grpc.k1.r.j.d[] equals4;
            int length;
            int i6;
            final int i9 = 0;
            int i7 = this.c;
            i2 = 32;
            equals3 = 31;
            if (this.d && i7 < this.e) {
                i7 = this.c;
                i2 = 32;
                equals3 = 31;
                if (i7 < this.e) {
                    f(i7, equals3, i2);
                }
                this.d = i9;
                this.c = Integer.MAX_VALUE;
                f(this.e, equals3, i2);
            }
            i4 = i9;
            while (i4 < list.size()) {
                i2 = list.get(i4);
                equals3 = i2.a.C();
                iVar = i2.b;
                Object obj = f.c().get(equals3);
                fVar = -1;
                if ((Integer)obj != null) {
                } else {
                }
                i = fVar;
                equals = i;
                if (i == fVar) {
                }
                if (i != fVar) {
                } else {
                }
                i = 64;
                if (equals == fVar) {
                } else {
                }
                if (equals3.B(f.d()) && !d.h.equals(equals3)) {
                } else {
                }
                f(equals, 63, i);
                d(iVar);
                c((d)i2);
                i4++;
                if (!d.h.equals(equals3)) {
                } else {
                }
                f(equals, 15, i9);
                d(iVar);
                this.a.z0(i);
                d(equals3);
                d(iVar);
                c(i2);
                f(i, 127, 128);
                i3 = this.h;
                i3++;
                equals4 = this.f;
                while (i3 < equals4.length) {
                    if (dVar3.a.equals(equals3)) {
                        break loop_18;
                    } else {
                    }
                    i3++;
                    equals4 = this.f;
                    if (dVar4.b.equals(iVar)) {
                        break loop_18;
                    } else {
                    }
                    if (equals == fVar) {
                    }
                    i13 += equals4;
                }
                if (dVar3.a.equals(equals3)) {
                } else {
                }
                if (dVar4.b.equals(iVar)) {
                } else {
                }
                if (equals == fVar) {
                }
                i13 += equals4;
                length2 += i3;
                intValue++;
                if (i >= 2 && i <= 7) {
                } else {
                }
                equals = i;
                i = fVar;
                if (i <= 7) {
                } else {
                }
                if (dVar.b.equals(iVar)) {
                } else {
                }
                if (dVar2.b.equals(iVar)) {
                } else {
                }
                equals = i;
                i = i6;
            }
        }

        void f(int i, int i2, int i3) {
            f fVar;
            int obj2;
            int obj3;
            int obj4;
            if (i < i2) {
                this.a.z0(i |= i3);
            }
            this.a.z0(i3 |= i2);
            i -= i2;
            obj3 = 128;
            while (obj2 >= obj3) {
                this.a.z0(obj3 |= obj4);
                obj2 >>>= 7;
                obj3 = 128;
            }
            this.a.z0(obj2);
        }
    }
    static {
        f.a = i.i(":");
        io.grpc.k1.r.j.d[] arr = new d[61];
        final String str49 = "";
        d dVar = new d(d.h, str49);
        i iVar3 = d.e;
        d dVar2 = new d(iVar3, "GET");
        d dVar3 = new d(iVar3, "POST");
        i iVar4 = d.f;
        d dVar4 = new d(iVar4, "/");
        d dVar5 = new d(iVar4, "/index.html");
        i iVar5 = d.g;
        d dVar6 = new d(iVar5, "http");
        d dVar7 = new d(iVar5, "https");
        i iVar6 = d.d;
        d dVar8 = new d(iVar6, "200");
        d dVar9 = new d(iVar6, "204");
        d dVar10 = new d(iVar6, "206");
        d dVar11 = new d(iVar6, "304");
        d dVar12 = new d(iVar6, "400");
        d dVar13 = new d(iVar6, "404");
        d dVar14 = new d(iVar6, "500");
        d dVar15 = new d("accept-charset", str49);
        d dVar16 = new d("accept-encoding", "gzip, deflate");
        d dVar17 = new d("accept-language", str49);
        d dVar18 = new d("accept-ranges", str49);
        d dVar19 = new d("accept", str49);
        d dVar20 = new d("access-control-allow-origin", str49);
        d dVar21 = new d("age", str49);
        d dVar22 = new d("allow", str49);
        d dVar23 = new d("authorization", str49);
        d dVar24 = new d("cache-control", str49);
        d dVar25 = new d("content-disposition", str49);
        d dVar26 = new d("content-encoding", str49);
        d dVar27 = new d("content-language", str49);
        d dVar28 = new d("content-length", str49);
        d dVar29 = new d("content-location", str49);
        d dVar30 = new d("content-range", str49);
        d dVar31 = new d("content-type", str49);
        d dVar32 = new d("cookie", str49);
        d dVar33 = new d("date", str49);
        d dVar34 = new d("etag", str49);
        d dVar35 = new d("expect", str49);
        d dVar36 = new d("expires", str49);
        d dVar37 = new d("from", str49);
        d dVar38 = new d("host", str49);
        d dVar39 = new d("if-match", str49);
        d dVar40 = new d("if-modified-since", str49);
        d dVar41 = new d("if-none-match", str49);
        d dVar42 = new d("if-range", str49);
        d dVar43 = new d("if-unmodified-since", str49);
        d dVar44 = new d("last-modified", str49);
        d dVar45 = new d("link", str49);
        d dVar46 = new d("location", str49);
        d dVar47 = new d("max-forwards", str49);
        d dVar48 = new d("proxy-authenticate", str49);
        d dVar49 = new d("proxy-authorization", str49);
        d dVar50 = new d("range", str49);
        d dVar51 = new d("referer", str49);
        d dVar52 = new d("refresh", str49);
        d dVar53 = new d("retry-after", str49);
        d dVar54 = new d("server", str49);
        d dVar55 = new d("set-cookie", str49);
        d dVar56 = new d("strict-transport-security", str49);
        d dVar57 = new d("transfer-encoding", str49);
        d dVar58 = new d("user-agent", str49);
        d dVar59 = new d("vary", str49);
        d dVar60 = new d("via", str49);
        d dVar61 = new d("www-authenticate", str49);
        f.b = arr;
        f.c = f.f();
    }

    static io.grpc.k1.r.j.d[] a() {
        return f.b;
    }

    static i b(i i) {
        f.e(i);
        return i;
    }

    static Map c() {
        return f.c;
    }

    static i d() {
        return f.a;
    }

    private static i e(i i) {
        int i2;
        byte b;
        int i3;
        i2 = 0;
        while (i2 < i.A()) {
            b = i.j(i2);
            i2++;
        }
        return i;
    }

    private static Map<i, Integer> f() {
        int i;
        io.grpc.k1.r.j.d[] objArr;
        boolean valueOf;
        LinkedHashMap linkedHashMap = new LinkedHashMap(objArr2.length);
        i = 0;
        objArr = f.b;
        for (Object dVar : obj2) {
            if (!linkedHashMap.containsKey(dVar2.a)) {
            }
            objArr = f.b;
            linkedHashMap.put(dVar.a, Integer.valueOf(i));
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
