package net.time4j.g1.z;

import java.util.Locale;
import java.util.Set;
import net.time4j.b0;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.w;
import net.time4j.engine.x;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.b;
import net.time4j.h0;
import net.time4j.i0;
import net.time4j.tz.l;

/* loaded from: classes3.dex */
final class z<T>  implements net.time4j.g1.z.h<T> {

    private final net.time4j.g1.z.c<T> a;
    private final x b;
    private final x c;
    static {
    }

    z(x x, x x2) {
        super(0, x, x2);
    }

    private z(net.time4j.g1.z.c<T> c, x x2, x x3) {
        super();
        if (x2 == null) {
        } else {
            if (x3 == null) {
            } else {
                this.b = x2;
                this.c = x3;
                this.a = c;
            }
        }
        NullPointerException obj1 = new NullPointerException("Missing display style.");
        throw obj1;
    }

    private static <T> net.time4j.g1.z.c<T> a(w<?> w, x x2, x x3, Locale locale4, boolean z5, l l6) {
        boolean equals;
        net.time4j.g1.z.c obj1;
        String obj2;
        net.time4j.g1.e obj3;
        boolean obj5;
        if (w.equals(g0.t0())) {
            obj2 = b.r((e)x2, locale4);
            obj3 = "yy";
            if (z5 && obj2.contains(obj3) && !obj2.contains("yyy")) {
                obj3 = "yy";
                if (obj2.contains(obj3)) {
                    if (!obj2.contains("yyy")) {
                        obj2 = obj2.replace(obj3, "yyyy");
                    }
                }
            }
            if (l6 != null) {
                obj1 = c.C(obj2, w.CLDR, locale4, w).U(l6);
            }
            return obj1;
        } else {
            if (w.equals(h0.k0())) {
                obj2 = b.t((e)x3, locale4);
            } else {
                if (w.equals(i0.U())) {
                    obj2 = b.u((e)x2, (e)x3, locale4);
                } else {
                    if (w.equals(b0.V())) {
                        obj2 = b.s((e)x2, (e)x3, locale4);
                    } else {
                        if (!h.class.isAssignableFrom(w.l())) {
                        } else {
                            obj2 = w.f(x2, locale4);
                        }
                    }
                }
            }
        }
        obj3 = new StringBuilder();
        obj3.append("Localized format patterns not available: ");
        obj3.append(w);
        obj2 = new UnsupportedOperationException(obj3.toString());
        throw obj2;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        x xVar;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        net.time4j.g1.z.c cVar = this.a;
        if (object instanceof z && this.b.equals(object.b) && this.c.equals(object.c) && cVar == null) {
            if (this.b.equals(object.b)) {
                if (this.c.equals(object.c)) {
                    cVar = this.a;
                    if (cVar == null) {
                        if (object.a == null) {
                        } else {
                            i = i2;
                        }
                        return i;
                    }
                    return cVar.equals(object.a);
                }
            }
        }
        return i2;
    }

    public p<T> getElement() {
        return 0;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        int i;
        net.time4j.g1.z.c cVar = this.a;
        if (cVar == null) {
            i = 0;
        } else {
            i = cVar.hashCode();
        }
        return i;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        Boolean fALSE;
        net.time4j.engine.c cVar;
        int i;
        w wVar;
        x xVar2;
        x xVar;
        Object obj;
        boolean booleanValue;
        int i2;
        net.time4j.g1.z.c obj14;
        if (z5) {
            obj14 = this.a;
        } else {
            obj14 = this.a.o();
            net.time4j.engine.c cVar2 = a.e;
            cVar = a.d;
            obj14 = d3.a(cVar, obj14.a(cVar, 0));
            if ((k)obj14 == null) {
            } else {
                i = l.N((k)obj14).Q((o)d3.a(cVar2, obj14.a(cVar2, l.c)));
            }
            obj14 = z.a(this.a.q(), this.b, this.c, (Locale)d3.a(a.c, this.a.u()), (Boolean)d3.a(a.v, Boolean.FALSE).booleanValue(), i);
        }
        final Object obj10 = obj14.b(charSequence, s2, d3);
        if (!s2.i() && obj10 != null) {
            if (obj10 != null) {
                t4.L(obj10);
            }
        }
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        int i;
        i = set4 != null ? 1 : 0;
        if (set4 != null) {
            set4.addAll(this.a.K(o, appendable2, d3, i));
        }
        return Integer.MAX_VALUE;
    }

    public net.time4j.g1.z.h<T> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        int i;
        Object obj10;
        Object obj = d2.a(a.d, 0);
        if ((k)obj == null) {
        } else {
            i = l.N((k)obj).Q((o)d2.a(a.e, l.c));
        }
        z obj11 = new z(z.a(c.q(), this.b, this.c, (Locale)d2.a(a.c, Locale.ROOT), (Boolean)d2.a(a.v, Boolean.FALSE).booleanValue(), i), this.b, this.c);
        return obj11;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(z.class.getName());
        stringBuilder.append("[date-style=");
        stringBuilder.append(this.b);
        stringBuilder.append(",time-style=");
        stringBuilder.append(this.c);
        stringBuilder.append(",delegate=");
        stringBuilder.append(this.a);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<T> withElement(p<T> p) {
        return this;
    }
}
