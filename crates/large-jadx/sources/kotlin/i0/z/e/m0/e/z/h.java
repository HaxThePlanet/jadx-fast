package kotlin.i0.z.e.m0.e.z;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.e.c;
import kotlin.i0.z.e.m0.e.d;
import kotlin.i0.z.e.m0.e.i;
import kotlin.i0.z.e.m0.e.n;
import kotlin.i0.z.e.m0.e.r;
import kotlin.i0.z.e.m0.e.v;
import kotlin.i0.z.e.m0.e.v.d;
import kotlin.reflect.jvm.internal.impl.protobuf.o;

/* loaded from: classes3.dex */
public final class h {

    public static final kotlin.i0.z.e.m0.e.z.h.a f;
    private final kotlin.i0.z.e.m0.e.z.h.b a;
    private final v.d b;
    private final a c;
    private final Integer d;
    private final String e;

    public static final class a {
        public a(g g) {
            super();
        }

        public final List<kotlin.i0.z.e.m0.e.z.h> a(o o, kotlin.i0.z.e.m0.e.z.c c2, kotlin.i0.z.e.m0.e.z.i i3) {
            boolean z;
            kotlin.i0.z.e.m0.e.z.h hVar;
            String str;
            List obj4;
            n.f(o, "proto");
            n.f(c2, "nameResolver");
            n.f(i3, "table");
            if (o instanceof c) {
                obj4 = (c)o.C0();
                n.e(obj4, "ids");
                ArrayList arrayList = new ArrayList();
                obj4 = obj4.iterator();
                while (obj4.hasNext()) {
                    Object next2 = obj4.next();
                    n.e((Integer)next2, "id");
                    hVar = b(next2.intValue(), c2, i3);
                    if (hVar != null) {
                    }
                    arrayList.add(hVar);
                }
                return arrayList;
            } else {
                if (o instanceof d) {
                    obj4 = (d)o.H();
                } else {
                    if (o instanceof i) {
                        obj4 = (i)o.c0();
                    } else {
                        if (o instanceof n) {
                            obj4 = (n)o.Z();
                        } else {
                            if (!o instanceof r) {
                            } else {
                                obj4 = (r)o.W();
                            }
                        }
                    }
                }
            }
            IllegalStateException obj5 = new IllegalStateException(n.o("Unexpected declaration: ", o.getClass()));
            throw obj5;
        }

        public final kotlin.i0.z.e.m0.e.z.h b(int i, kotlin.i0.z.e.m0.e.z.c c2, kotlin.i0.z.e.m0.e.z.i i3) {
            a wARNING;
            boolean valueOf;
            Integer valueOf3;
            int i4;
            Integer valueOf2;
            int i2;
            int obj12;
            n.f(c2, "nameResolver");
            n.f(i3, "table");
            v obj10 = i3.b(i);
            obj12 = 0;
            if (obj10 == null) {
                return obj12;
            }
            if (obj10.D()) {
                valueOf3 = Integer.valueOf(obj10.x());
            } else {
                valueOf3 = obj12;
            }
            if (obj10.E()) {
                valueOf2 = Integer.valueOf(obj10.y());
            } else {
                valueOf2 = obj12;
            }
            kotlin.i0.z.e.m0.e.v.c cVar = obj10.v();
            n.d(cVar);
            int i5 = h.a.a.a[cVar.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                    } else {
                        wARNING = a.HIDDEN;
                    }
                    obj10 = new NoWhenBranchMatchedException();
                    throw obj10;
                }
                wARNING = a.ERROR;
            } else {
                wARNING = a.WARNING;
            }
            if (obj10.A()) {
                i2 = valueOf;
            } else {
                i2 = obj12;
            }
            if (obj10.C()) {
                obj12 = c2.getString(obj10.w());
            }
            final v.d dVar = obj10.z();
            n.e(dVar, "info.versionKind");
            super(h.b.d.a(valueOf3, valueOf2), dVar, wARNING, i2, obj12);
            return obj11;
        }
    }

    public static final class b {

        public static final kotlin.i0.z.e.m0.e.z.h.b.a d;
        public static final kotlin.i0.z.e.m0.e.z.h.b e;
        private final int a;
        private final int b;
        private final int c;
        static {
            h.b.a aVar = new h.b.a(0);
            h.b.d = aVar;
            int i2 = 256;
            h.b bVar = new h.b(i2, i2, i2);
            h.b.e = bVar;
        }

        public b(int i, int i2, int i3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        public b(int i, int i2, int i3, int i4, g g5) {
            int obj3;
            obj3 = i4 &= 4 != 0 ? 0 : obj3;
            super(i, i2, obj3);
        }

        public final String a() {
            StringBuilder stringBuilder;
            int i;
            int i2;
            int i4 = 46;
            if (this.c == 0) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append(i4);
                i = this.b;
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append(this.a);
                stringBuilder.append(i4);
                stringBuilder.append(this.b);
                stringBuilder.append(i4);
                i = this.c;
            }
            stringBuilder.append(i);
            return stringBuilder.toString();
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i5 = 0;
            if (!object instanceof h.b) {
                return i5;
            }
            if (this.a != object.a) {
                return i5;
            }
            if (this.b != object.b) {
                return i5;
            }
            if (this.c != object.c) {
                return i5;
            }
            return i;
        }

        public int hashCode() {
            return i4 += i7;
        }

        public String toString() {
            return a();
        }
    }
    static {
        h.a aVar = new h.a(0);
        h.f = aVar;
    }

    public h(kotlin.i0.z.e.m0.e.z.h.b h$b, v.d v$d2, a a3, Integer integer4, String string5) {
        n.f(b, "version");
        n.f(d2, "kind");
        n.f(a3, "level");
        super();
        this.a = b;
        this.b = d2;
        this.c = a3;
        this.d = integer4;
        this.e = string5;
    }

    public final v.d a() {
        return this.b;
    }

    public final kotlin.i0.z.e.m0.e.z.h.b b() {
        return this.a;
    }

    public String toString() {
        String str3;
        String str;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("since ");
        stringBuilder.append(this.a);
        stringBuilder.append(' ');
        stringBuilder.append(this.c);
        Integer num = this.d;
        if (num != null) {
            str3 = n.o(" error ", num);
        } else {
            str3 = str;
        }
        stringBuilder.append(str3);
        String str5 = this.e;
        if (str5 != null) {
            str = n.o(": ", str5);
        }
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
