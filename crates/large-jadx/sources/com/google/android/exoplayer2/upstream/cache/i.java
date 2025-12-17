package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.v;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* loaded from: classes2.dex */
final class i {

    public final int a;
    public final String b;
    private final TreeSet<com.google.android.exoplayer2.upstream.cache.p> c;
    private final ArrayList<com.google.android.exoplayer2.upstream.cache.i.a> d;
    private com.google.android.exoplayer2.upstream.cache.m e;

    private static final class a {

        public final long a;
        public final long b;
        public a(long l, long l2) {
            super();
            this.a = l;
            this.b = obj3;
        }

        public boolean a(long l, long l2) {
            long l3;
            int i;
            long obj8;
            final long l4 = this.b;
            int i2 = -1;
            i = 1;
            final int i3 = 0;
            if (Long.compare(l4, i2) == 0) {
                if (Long.compare(l, obj10) >= 0) {
                } else {
                    i = i3;
                }
                return i;
            }
            if (Long.compare(obj10, i2) == 0) {
                return i3;
            }
            l3 = this.a;
            if (Long.compare(l3, l) <= 0 && Long.compare(obj8, l3) <= 0) {
                if (Long.compare(obj8, l3) <= 0) {
                } else {
                    i = i3;
                }
            } else {
            }
            return i;
        }

        public boolean b(long l, long l2) {
            long l3;
            int i;
            long obj8;
            l3 = this.a;
            i = 0;
            final int i2 = 1;
            final int i3 = -1;
            if (Long.compare(l3, l) <= 0) {
                final long obj10 = this.b;
                if (Long.compare(obj10, i3) != 0) {
                    if (Long.compare(l3, l) > 0) {
                        i = i2;
                    }
                } else {
                }
                return i;
            }
            if (Long.compare(obj10, i3) != 0) {
                if (Long.compare(obj8, l3) > 0) {
                    i = i2;
                }
            } else {
            }
            return i;
        }
    }
    public i(int i, String string2) {
        super(i, string2, m.c);
    }

    public i(int i, String string2, com.google.android.exoplayer2.upstream.cache.m m3) {
        super();
        this.a = i;
        this.b = string2;
        this.e = m3;
        TreeSet obj1 = new TreeSet();
        this.c = obj1;
        obj1 = new ArrayList();
        this.d = obj1;
    }

    public void a(com.google.android.exoplayer2.upstream.cache.p p) {
        this.c.add(p);
    }

    public boolean b(com.google.android.exoplayer2.upstream.cache.l l) {
        final com.google.android.exoplayer2.upstream.cache.m mVar = this.e;
        com.google.android.exoplayer2.upstream.cache.m obj2 = mVar.g(l);
        this.e = obj2;
        return obj2 ^= 1;
    }

    public com.google.android.exoplayer2.upstream.cache.m c() {
        return this.e;
    }

    public com.google.android.exoplayer2.upstream.cache.p d(long l, long l2) {
        Object ceiling;
        int cmp;
        long l3;
        int obj9;
        com.google.android.exoplayer2.upstream.cache.p pVar = p.m(this.b, l);
        Object floor = this.c.floor(pVar);
        if ((p)floor != null && Long.compare(i2, l) > 0) {
            if (Long.compare(i2, l) > 0) {
                return (p)floor;
            }
        }
        TreeSet set2 = this.c;
        ceiling = set2.ceiling(pVar);
        if ((p)ceiling != null) {
            l4 -= l;
            if (Long.compare(obj9, i) == 0) {
                obj9 = ceiling;
            } else {
                obj9 = Math.min(ceiling, set2);
            }
        }
        return p.k(this.b, l, l2);
    }

    public TreeSet<com.google.android.exoplayer2.upstream.cache.p> e() {
        return this.c;
    }

    public boolean equals(Object object) {
        int i2;
        int equals;
        Class<com.google.android.exoplayer2.upstream.cache.i> obj;
        int i;
        Class class;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i3 = 0;
        if (object != null) {
            if (i.class != object.getClass()) {
            } else {
                if (this.a == object.a && this.b.equals(object.b) && this.c.equals(object.c) && this.e.equals(object.e)) {
                    if (this.b.equals(object.b)) {
                        if (this.c.equals(object.c)) {
                            if (this.e.equals(object.e)) {
                            } else {
                                i2 = i3;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            return i2;
        }
        return i3;
    }

    public boolean f() {
        return this.c.isEmpty();
    }

    public boolean g(long l, long l2) {
        int i;
        boolean z;
        final int i2 = 0;
        i = i2;
        while (i < this.d.size()) {
            i++;
        }
        return i2;
    }

    public boolean h() {
        return this.d.isEmpty();
    }

    public int hashCode() {
        return i4 += i7;
    }

    public boolean i(long l, long l2) {
        int i;
        boolean z;
        int i2 = 0;
        i = i2;
        while (i < this.d.size()) {
            i++;
        }
        i.a aVar = new i.a(l, l2, obj6, obj7);
        this.d.add(aVar);
        return 1;
    }

    public boolean j(com.google.android.exoplayer2.upstream.cache.h h) {
        File obj2 = h.w;
        if (this.c.remove(h) && obj2 != null) {
            obj2 = h.w;
            if (obj2 != null) {
                obj2.delete();
            }
            return 1;
        }
        return 0;
    }

    public com.google.android.exoplayer2.upstream.cache.p k(com.google.android.exoplayer2.upstream.cache.p p, long l2, boolean z3) {
        File file;
        String renameTo;
        String str;
        StringBuilder stringBuilder;
        long l;
        Object obj11;
        g.f(this.c.remove(p));
        file = p.w;
        g.e(file);
        if (obj11 != null) {
            obj11 = (File)file.getParentFile();
            g.e(obj11);
            obj11 = p.n((File)obj11, this.a, p.b, obj4);
            if (file.renameTo(obj11) != null) {
                file = obj11;
            } else {
                String valueOf = String.valueOf(file);
                obj11 = String.valueOf(obj11);
                stringBuilder = new StringBuilder(i += length2);
                stringBuilder.append("Failed to rename ");
                stringBuilder.append(valueOf);
                stringBuilder.append(" to ");
                stringBuilder.append(obj11);
                v.h("CachedContent", stringBuilder.toString());
            }
        }
        final com.google.android.exoplayer2.upstream.cache.p obj8 = p.f(file, l2);
        this.c.add(obj8);
        return obj8;
    }

    public void l(long l) {
        int i;
        int cmp;
        i = 0;
        while (i < this.d.size()) {
            i++;
        }
        IllegalStateException obj4 = new IllegalStateException();
        throw obj4;
    }
}
