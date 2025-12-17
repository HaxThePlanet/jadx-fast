package com.google.android.exoplayer2.upstream.cache;

import android.net.Uri;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.a0;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.i;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.upstream.l;
import com.google.android.exoplayer2.upstream.n;
import com.google.android.exoplayer2.upstream.n.b;
import com.google.android.exoplayer2.upstream.u;
import com.google.android.exoplayer2.upstream.y;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.InterruptedIOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c implements l {

    private final com.google.android.exoplayer2.upstream.cache.Cache a;
    private final l b;
    private final l c;
    private final l d;
    private final com.google.android.exoplayer2.upstream.cache.g e;
    private final com.google.android.exoplayer2.upstream.cache.c.a f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private Uri j;
    private n k;
    private n l;
    private l m;
    private long n;
    private long o;
    private long p;
    private com.google.android.exoplayer2.upstream.cache.h q;
    private boolean r;
    private boolean s;
    private long t;
    private long u;

    public interface a {
        public abstract void a(int i);

        public abstract void b(long l, long l2);
    }
    public c(com.google.android.exoplayer2.upstream.cache.Cache cache, l l2, l l3, k k4, int i5, com.google.android.exoplayer2.upstream.cache.c.a c$a6) {
        super(cache, l2, l3, k4, i5, a6, 0);
    }

    public c(com.google.android.exoplayer2.upstream.cache.Cache cache, l l2, l l3, k k4, int i5, com.google.android.exoplayer2.upstream.cache.c.a c$a6, com.google.android.exoplayer2.upstream.cache.g g7) {
        super(cache, l2, l3, k4, g7, i5, 0, 0, a6);
    }

    private c(com.google.android.exoplayer2.upstream.cache.Cache cache, l l2, l l3, k k4, com.google.android.exoplayer2.upstream.cache.g g5, int i6, PriorityTaskManager priorityTaskManager7, int i8, com.google.android.exoplayer2.upstream.cache.c.a c$a9) {
        int obj1;
        l obj2;
        int obj3;
        com.google.android.exoplayer2.upstream.cache.g obj5;
        super();
        this.a = cache;
        this.b = l3;
        if (g5 != null) {
        } else {
            obj5 = g.a;
        }
        this.e = obj5;
        obj3 = 0;
        obj5 = 1;
        obj1 = i6 & 1 != 0 ? obj5 : obj3;
        this.g = obj1;
        obj1 = i6 & 2 != 0 ? obj5 : obj3;
        this.h = obj1;
        obj3 = i6 & 4 != 0 ? obj5 : obj3;
        this.i = obj3;
        if (l2 != null) {
            if (priorityTaskManager7 != null) {
                obj3 = new y(l2, priorityTaskManager7, i8);
                obj2 = obj3;
            }
            this.d = obj2;
            if (k4 != null) {
                obj1 = new a0(obj2, k4);
            }
            this.c = obj1;
        } else {
            this.d = u.a;
            this.c = 0;
        }
        this.f = a9;
    }

    private void n() {
        com.google.android.exoplayer2.upstream.cache.h hVar;
        com.google.android.exoplayer2.upstream.cache.Cache cache;
        l lVar = this.m;
        if (lVar == null) {
        }
        final int i = 0;
        lVar.close();
        this.l = i;
        this.m = i;
        com.google.android.exoplayer2.upstream.cache.h hVar2 = this.q;
        if (hVar2 != null) {
            this.a.i(hVar2);
            this.q = i;
        }
    }

    private static Uri o(com.google.android.exoplayer2.upstream.cache.Cache cache, String string2, Uri uri3) {
        Uri obj2;
        Uri obj0 = k.a(cache.b(string2));
        if (obj0 != null) {
            obj2 = obj0;
        }
        return obj2;
    }

    private void p(Throwable throwable) {
        boolean obj2;
        if (!r()) {
            if (throwable instanceof Cache.CacheException != null) {
                this.r = true;
            }
        } else {
        }
    }

    private boolean q() {
        int i;
        i = this.m == this.d ? 1 : 0;
        return i;
    }

    private boolean r() {
        int i;
        i = this.m == this.b ? 1 : 0;
        return i;
    }

    private boolean s() {
        return z ^= 1;
    }

    private boolean t() {
        int i;
        i = this.m == this.c ? 1 : 0;
        return i;
    }

    private void u() {
        int cmp;
        int i;
        long l;
        final com.google.android.exoplayer2.upstream.cache.c.a aVar = this.f;
        i = 0;
        if (aVar != null && Long.compare(l2, i) > 0) {
            i = 0;
            if (Long.compare(l2, i) > 0) {
                aVar.b(this.a.h(), obj2);
                this.t = i;
            }
        }
    }

    private void v(int i) {
        final com.google.android.exoplayer2.upstream.cache.c.a aVar = this.f;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    private void w(n n, boolean z2) {
        Object obj;
        boolean z4;
        com.google.android.exoplayer2.upstream.cache.h hVar;
        String str;
        int cmp;
        boolean z;
        long l5;
        long l2;
        l lVar;
        long l;
        n nVar;
        int cmp3;
        boolean z3;
        int i;
        long l3;
        int i2;
        long l4;
        int i3;
        n.b bVar;
        int cmp2;
        final Object obj2 = this;
        obj = n;
        final String str2 = obj.h;
        p0.i(str2);
        i = 0;
        if (obj2.s) {
            hVar = i;
        } else {
            if (obj2.g) {
                hVar = obj2.a.f(str2, obj2.o, obj5);
            } else {
                hVar = obj2.a.e(str2, obj2.o, obj5);
            }
        }
        cmp = -1;
        if (hVar == null) {
            lVar = obj2.d;
            n.b bVar2 = n.a();
            bVar2.h(obj2.o);
            bVar2.g(obj2.p);
            nVar = bVar2.a();
        } else {
            if (hVar.v) {
                java.io.File file = hVar.w;
                p0.i(file);
                long l7 = hVar.b;
                l9 -= l7;
                long l14 = obj2.p;
                if (Long.compare(l14, cmp) != 0) {
                    i3 = Math.min(l13 -= i2, obj13);
                }
                bVar = n.a();
                bVar.i(Uri.fromFile(file));
                bVar.k(l7);
                bVar.h(i2);
                bVar.g(i3);
                nVar = bVar.a();
                lVar = obj2.b;
            } else {
                if (hVar.e()) {
                    l2 = obj2.p;
                } else {
                    l3 = obj2.p;
                    if (Long.compare(l3, cmp) != 0) {
                        l2 = Math.min(hVar.c, l);
                    }
                }
                cmp3 = n.a();
                cmp3.h(obj2.o);
                cmp3.g(l2);
                nVar = cmp3.a();
                if (obj2.c != null) {
                } else {
                    lVar = obj2.d;
                    obj2.a.i(hVar);
                    hVar = i;
                }
            }
        }
        if (!obj2.s && lVar == obj2.d) {
            try {
                if (lVar == obj2.d) {
                } else {
                }
                l11 += i3;
                l4 = Long.MAX_VALUE;
                obj2.u = l4;
                g.f(q());
                if (z2 && lVar == obj2.d) {
                }
                g.f(q());
                if (lVar == obj2.d) {
                }
                n();
                p0.i(obj2);
                Thread thread = obj2.c();
                if (thread == null) {
                } else {
                }
                thread = obj1.a;
                thread.i(obj2);
                throw thread;
            } catch (Throwable th) {
            }
            if (hVar.c()) {
                obj2.q = hVar;
            }
            obj2.m = lVar;
            obj2.l = nVar;
            obj2.n = 0;
            long l12 = lVar.c(nVar);
            l lVar2 = new l();
            if (Long.compare(l8, cmp) == 0 && Long.compare(l12, cmp) != 0) {
                if (Long.compare(l12, cmp) != 0) {
                    obj2.p = l12;
                    l.g(lVar2, l6 += l12);
                }
            }
            z = lVar.l();
            obj2.j = z;
            if (s() && equals ^= 1 != 0) {
                z = lVar.l();
                obj2.j = z;
                if (equals ^= 1 != 0) {
                    i = obj2.j;
                }
                l.h(lVar2, i);
            }
            if (t()) {
                obj2.a.c(str2, lVar2);
            }
        } else {
        }
    }

    private void x(String string) {
        boolean lVar;
        com.google.android.exoplayer2.upstream.cache.Cache cache;
        this.p = 0;
        if (t()) {
            lVar = new l();
            l.g(lVar, this.o);
            this.a.c(string, lVar);
        }
    }

    private int y(n n) {
        boolean z;
        boolean z2;
        int i;
        Object obj5;
        if (this.h && this.r) {
            if (this.r) {
                return 0;
            }
        }
        if (this.i && Long.compare(z2, i) == 0) {
            if (Long.compare(z2, i) == 0) {
                return 1;
            }
        }
        return -1;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public long c(n n) {
        String cmp3;
        int cmp2;
        int cmp;
        long l3;
        boolean z;
        long l;
        int i;
        long l2;
        try {
            cmp3 = this.e.a(n);
            n.b bVar = n.a();
            bVar.f(cmp3);
            n nVar = bVar.a();
            this.k = nVar;
            this.j = c.o(this.a, cmp3, nVar.a);
            this.o = n.f;
            int i3 = y(n);
            final int i5 = 0;
            if (i3 != -1) {
            } else {
            }
            i = 1;
            i = i5;
            this.s = i;
            if (i != 0) {
            }
            v(i3);
            final int i6 = 0;
            final int i7 = -1;
            if (this.s) {
            } else {
            }
            this.p = i7;
            z = k.d(this.a.b(cmp3));
            this.p = z;
            if (Long.compare(z, i7) != 0) {
            }
            z -= l2;
            this.p = z;
            if (Long.compare(z, i6) < 0) {
            } else {
            }
            DataSourceException obj12 = new DataSourceException(2008);
            throw obj12;
            l = n.g;
            if (Long.compare(l, i7) != 0) {
            }
            l2 = this.p;
            if (Long.compare(l2, i7) == 0) {
            } else {
            }
            l = Math.min(l2, obj10);
            this.p = l;
            long l5 = this.p;
            if (Long.compare(l5, i6) <= 0) {
            } else {
            }
            if (Long.compare(l5, i7) == 0) {
            }
            w(nVar, i5);
            if (Long.compare(l3, i7) != 0) {
            } else {
            }
            l3 = this.p;
            return l3;
            p(n);
            throw n;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void close() {
        int i = 0;
        this.k = i;
        this.j = i;
        this.o = 0;
        u();
        n();
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public void d(b0 b0) {
        g.e(b0);
        this.b.d(b0);
        this.d.d(b0);
    }

    public Map<String, List<String>> h() {
        Map emptyMap;
        if (s()) {
            emptyMap = this.d.h();
        } else {
            emptyMap = Collections.emptyMap();
        }
        return emptyMap;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public Uri l() {
        return this.j;
    }

    @Override // com.google.android.exoplayer2.upstream.l
    public int read(byte[] bArr, int i2, int i3) {
        String cmp2;
        int i4;
        int cmp3;
        int i5;
        int cmp;
        int i;
        long l;
        final Object obj = this;
        cmp2 = i3;
        i4 = 0;
        if (cmp2 == 0) {
            return i4;
        }
        final int i9 = 0;
        i5 = -1;
        if (Long.compare(l5, i9) == 0) {
            return i5;
        }
        n nVar = obj.k;
        g.e(nVar);
        final n nVar2 = obj.l;
        g.e(nVar2);
        if (Long.compare(l6, l7) >= 0) {
            w((n)nVar, true);
        }
        l lVar = obj.m;
        g.e(lVar);
        int read2 = (l)lVar.read(bArr, i2, cmp2);
        i = -1;
        if (read2 != i5) {
            if (r()) {
                obj.t = l4 += i5;
            }
            cmp3 = (long)read2;
            obj.o = l2 += cmp3;
            obj.n = l3 += cmp3;
            i4 = obj.p;
            if (Long.compare(i4, i) != 0) {
                obj.p = i4 -= cmp3;
            }
            return read2;
        } else {
            if (s()) {
                l = nVar2.g;
                if (Long.compare(l, i) != 0) {
                    if (Long.compare(i, l) < 0) {
                        cmp2 = nVar.h;
                        p0.i(cmp2);
                        x((String)cmp2);
                    } else {
                        i = obj.p;
                        if (Long.compare(i, i9) <= 0 && Long.compare(i, i8) == 0) {
                            if (Long.compare(i, i8) == 0) {
                            }
                        }
                    }
                } else {
                }
            } else {
            }
        }
        n();
        w(nVar, i4);
        return read(bArr, i2, i3);
    }
}
