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

/* compiled from: Hpack.java */
/* loaded from: classes3.dex */
final class f {

    private static final i a;
    private static final d[] b;
    private static final Map<i, Integer> c;

    static final class a {

        private final List<d> a;
        private final h b;
        private int c;
        private int d;
        d[] e;
        int f;
        int g;
        int h;
        a(int i, d0 d0Var) {
            this(i, i, d0Var);
        }

        private void a() {
            if (this.d < this.h && this.d == 0) {
                b();
            }
        }

        private void b() {
            Arrays.fill(this.e, null);
            this.f = this.e.length - 1;
            int i2 = 0;
            this.g = i2;
            this.h = i2;
        }

        private int c(int i) {
            return (this.f + 1) + i;
        }

        private int d(int i) {
            int i2 = 0;
            int i3;
            int i9;
            i2 = 0;
            if (i > 0) {
                i3 = this.e.length - 1;
                while (i3 >= this.f) {
                }
                i4 = i11 + 1;
                i6 = (i11 + 1) + i2;
                System.arraycopy(this.e, i4, this.e, i6, this.g);
                this.f += i2;
            }
            return i2;
        }

        private i f(int i) throws IOException {
            if (i(i)) {
                return f.b[i].a;
            }
            int i3 = c(i - f.b.length);
            if (i3 < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Header index too large ";
                i++;
                i = str + i4;
                throw new IOException(i);
            } else {
                length = objArr.length;
                if (i3 < objArr.length) {
                    return objArr[i3].a;
                }
            }
        }

        private void h(int i, d dVar) {
            int i2;
            int length = 0;
            int length2;
            int length3;
            this.a.add(dVar);
            int i7 = -1;
            if (i != i7) {
                i2 = dVar.c - this.e[c(i)].c;
            }
            if (this.a > this.d) {
                b();
                return;
            }
            length2 = (this.h + i2) - i12;
            if (i == i7) {
                i6 = this.g + 1;
                length = objArr2.length;
                if (this.g + 1 > objArr2.length) {
                    io.grpc.k1.r.j.d[] arr = new d[objArr2.length * 2];
                    length = 0;
                    length2 = objArr2.length;
                    length3 = objArr2.length;
                    System.arraycopy(this.e, length, arr, length2, length3);
                    this.f = this.e.length - 1;
                    this.e = arr;
                }
                this.f--;
                this.e[this.f] = dVar;
                this.g++;
            } else {
                i5 = i + (c(i) + d(length2));
                this.e[i5] = dVar;
            }
            this.h += i2;
        }

        private boolean i(int i) {
            boolean z = false;
            int i2;
            if (i >= 0) {
                i2 = f.b.length - 1;
                if (i > f.a().length - i3) {
                    int i4 = 0;
                }
            }
            return z;
        }

        private int j() {
            return this.b.readByte() & 255;
        }

        private void m(int i) throws IOException {
            if (i(i)) {
                this.a.add(f.b[i]);
                return;
            } else {
                int i4 = c(i - f.b.length);
                if (i4 >= 0) {
                    i2 = objArr.length - 1;
                    if (i4 <= objArr.length - 1) {
                        this.a.add(objArr[i4]);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Header index too large ";
            i++;
            i = str + i5;
            throw new IOException(i);
        }

        private void o(int i) {
            h(-1, new d(f(i), k()));
        }

        private void p() {
            i iVar = k();
            f.e(iVar);
            h(-1, new d(iVar, k()));
        }

        private void q(int i) {
            this.a.add(new d(f(i), k()));
        }

        private void r() {
            final i iVar = k();
            f.e(iVar);
            this.a.add(new d(iVar, k()));
        }

        public List<d> e() {
            this.a.clear();
            return new ArrayList(this.a);
        }

        void g(int i) {
            this.c = i;
            this.d = i;
            a();
        }

        i k() {
            int i = 1;
            int i2 = j();
            int r1 = (i2 & 128) == 128 ? 1 : 0;
            int i3 = n(i2, 127);
            if (i != 0) {
                return i.t(h.f().c(this.b.p1((long)i3)));
            }
            return this.b.B((long)i3);
        }

        void l() throws IOException {
            while (!this.b.b0()) {
                i = this.b.readByte() & 255;
                int i7 = 128;
                i3 = i & 128;
                if ((i & 128) != i7) {
                    int i2 = 64;
                }
            }
        }

        int n(int i, int i2) {
            int i5 = 0;
            int i6;
            i &= i2;
            if (i9 < i2) {
                return i9;
            }
            i5 = 0;
            int i7 = j();
            i4 = i7 & 128;
            while (i7 & 128 != 0) {
                i3 = (i7 & 127) << i5;
                i6 = i6 + i3;
                i5 = i5 + 7;
                i7 = j();
                i4 = i7 & 128;
            }
            return i6 + (i7 << i5);
        }

        a(int i, int i2, d0 d0Var) {
            super();
            this.a = new ArrayList();
            io.grpc.k1.r.j.d[] arr = new d[8];
            this.e = arr;
            this.f = arr.length - 1;
            int i5 = 0;
            this.g = i5;
            this.h = i5;
            this.c = i;
            this.d = i2;
            this.b = q.d(d0Var);
        }
    }

    static final class b {

        private final f a;
        private boolean b;
        private int c;
        private boolean d;
        private int e;
        d[] f;
        int g;
        private int h;
        private int i;
        b(f fVar) {
            this(4096, false, fVar);
        }

        private void a() {
            Arrays.fill(this.f, null);
            this.h = this.f.length - 1;
            int i2 = 0;
            this.g = i2;
            this.i = i2;
        }

        private int b(int i) {
            int i2 = 0;
            int i3;
            int i9;
            i2 = 0;
            if (i > 0) {
                i3 = this.f.length - 1;
                while (i3 >= this.h) {
                }
                i4 = i11 + 1;
                i6 = (i11 + 1) + i2;
                System.arraycopy(this.f, i4, this.f, i6, this.g);
                this.h += i2;
            }
            return i2;
        }

        private void c(d dVar) {
            if (dVar.c > this.e) {
                a();
                return;
            }
            b((this.i + i2) - i3);
            i = this.g + 1;
            length = objArr.length;
            if (this.g + 1 > objArr.length) {
                io.grpc.k1.r.j.d[] arr = new d[objArr.length * 2];
                int length = 0;
                length2 = objArr.length;
                length3 = objArr.length;
                System.arraycopy(this.f, length, arr, length2, length3);
                this.h = this.f.length - 1;
                this.f = arr;
            }
            this.h--;
            this.f[this.h] = dVar;
            this.g++;
            this.i += i2;
        }

        void d(i iVar) {
            final int i6 = 127;
            if (this.b) {
                if (h.f().e(iVar.D()) < iVar.A()) {
                    f fVar2 = new f();
                    h.f().d(iVar.D(), fVar2.b2());
                    i iVar2 = fVar2.Y0();
                    int i2 = 128;
                    f(iVar2.A(), i6, i2);
                    this.a.e0(iVar2);
                } else {
                    i2 = 0;
                    f(iVar.A(), i6, i2);
                    this.a.e0(iVar);
                }
            }
        }

        void e(List<d> list) {
            int i2;
            int i3 = 32;
            int i4 = 31;
            int i5;
            boolean z3;
            f fVar;
            int i7;
            io.grpc.k1.r.j.d[] objArr;
            boolean equals;
            int length;
            final boolean z2 = false;
            if (this.d) {
                i3 = 32;
                i4 = 31;
                if (this.c < this.e) {
                    f(this.c, i4, i3);
                }
                this.d = z2;
                this.c = Integer.MAX_VALUE;
                f(this.e, i4, i3);
            }
            while (this.e < list.size()) {
                Object item = list.get(i2);
                i iVar = item.a.C();
                Object value = f.c.get(iVar);
                i5 = -1;
                i2 = i2 + 1;
            }
        }

        void f(int i, int i2, int i3) {
            int i4;
            if (i < i2) {
                this.a.z0(i | i3);
                return;
            }
            i6 = i3 | i2;
            this.a.z0(i6);
            i4 = i - i2;
            int i8 = 128;
            while (i4 >= i8) {
                i6 = i4 & 127;
                i5 = i8 | i6;
                this.a.z0(i5);
                i4 = i4 >>> 7;
                i8 = 128;
            }
            this.a.z0(i4);
        }

        b(int i, boolean z, f fVar) {
            super();
            this.c = Integer.MAX_VALUE;
            io.grpc.k1.r.j.d[] arr = new d[8];
            this.f = arr;
            this.h = arr.length - 1;
            this.e = i;
            this.b = z;
            this.a = fVar;
        }
    }
    static {
        f.a = i.i(":");
        io.grpc.k1.r.j.d[] arr = new d[61];
        final String str49 = "";
        i iVar3 = d.e;
        i iVar4 = d.f;
        i iVar5 = d.g;
        i iVar6 = d.d;
        f.b = new d[] { new d(d.h, str49), new d(iVar3, "GET"), new d(iVar3, "POST"), new d(iVar4, "/"), new d(iVar4, "/index.html"), new d(iVar5, "http"), new d(iVar5, "https"), new d(iVar6, "200"), new d(iVar6, "204"), new d(iVar6, "206"), new d(iVar6, "304"), new d(iVar6, "400"), new d(iVar6, "404"), new d(iVar6, "500"), new d("accept-charset", str49), new d("accept-encoding", "gzip, deflate"), new d("accept-language", str49), new d("accept-ranges", str49), new d("accept", str49), new d("access-control-allow-origin", str49), new d("age", str49), new d("allow", str49), new d("authorization", str49), new d("cache-control", str49), new d("content-disposition", str49), new d("content-encoding", str49), new d("content-language", str49), new d("content-length", str49), new d("content-location", str49), new d("content-range", str49), new d("content-type", str49), new d("cookie", str49), new d("date", str49), new d("etag", str49), new d("expect", str49), new d("expires", str49), new d("from", str49), new d("host", str49), new d("if-match", str49), new d("if-modified-since", str49), new d("if-none-match", str49), new d("if-range", str49), new d("if-unmodified-since", str49), new d("last-modified", str49), new d("link", str49), new d("location", str49), new d("max-forwards", str49), new d("proxy-authenticate", str49), new d("proxy-authorization", str49), new d("range", str49), new d("referer", str49), new d("refresh", str49), new d("retry-after", str49), new d("server", str49), new d("set-cookie", str49), new d("strict-transport-security", str49), new d("transfer-encoding", str49), new d("user-agent", str49), new d("vary", str49), new d("via", str49), new d("www-authenticate", str49) };
        f.c = f.f();
    }

    static /* synthetic */ d[] a() {
        return f.b;
    }

    static /* synthetic */ i b(i iVar) {
        f.e(iVar);
        return iVar;
    }

    static /* synthetic */ Map c() {
        return f.c;
    }

    static /* synthetic */ i d() {
        return f.a;
    }

    private static i e(i iVar) throws IOException {
        int i = 0;
        byte b2 = 65;
        i = 0;
        while (i < iVar.A()) {
            byte b = iVar.j(i);
            b2 = (byte) 65;
            if (b < (byte) 65 || b > (byte) 90) {
                b2 = (byte) 90;
            }
        }
        return iVar;
    }

    private static Map<i, Integer> f() {
        int i = 0;
        io.grpc.k1.r.j.d[] objArr;
        boolean key;
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.b.length);
        i = 0;
        objArr = f.b;
        for (io.grpc.k1.r.j.d dVar2 : objArr) {
            objArr = f.b;
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
