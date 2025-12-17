package net.time4j.g1.z;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.time4j.c0;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g0;
import net.time4j.g1.a;
import net.time4j.g1.a0.a;
import net.time4j.g1.a0.e;
import net.time4j.g1.g;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* loaded from: classes3.dex */
final class a0<V>  implements net.time4j.g1.z.h<V> {

    private final t<V> a;
    private final boolean b;
    private final e<V> c = null;
    private final Locale v;
    private final v w;
    private final m x;
    private final g y;
    private final int z;
    private a0(t<V> t, boolean z2, Locale locale3, v v4, m m5, g g6, int i7) {
        super();
        Objects.requireNonNull(t, "Missing element.");
        this.a = t;
        this.b = z2;
        if (t instanceof e) {
        }
        final int obj2 = 0;
        this.v = locale3;
        this.w = v4;
        this.x = m5;
        this.y = g6;
        this.z = i7;
    }

    static <V> net.time4j.g1.z.a0<V> a(t<V> t) {
        super(t, 0, Locale.ROOT, v.WIDE, m.FORMAT, g.SMART, 0);
        return a0Var2;
    }

    private boolean b(o o, java.lang.Appendable appendable2, d d3, boolean z4) {
        final e eVar = this.c;
        final int i = 1;
        if (eVar != null && z4) {
            if (z4) {
                eVar.print(o, appendable2, this.v, this.w, this.x);
                return i;
            }
        }
        if (o.v(this.a)) {
            this.a.print(o, appendable2, d3);
            return i;
        }
        return 0;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        boolean equals;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof a0) {
            if (this.a.equals(object.a) && this.b == object.b) {
                if (this.b == object.b) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int length;
        int intValue;
        Integer valueOf;
        Locale locale;
        v vVar;
        m mVar;
        g gVar;
        Object obj9;
        Object obj10;
        String obj11;
        Object obj12;
        g obj13;
        final int i = s2.f();
        if (z5 != null) {
            intValue = this.z;
        } else {
            intValue = (Integer)d3.a(a.s, 0).intValue();
        }
        if (intValue > 0) {
            length -= intValue;
        }
        if (i >= length) {
            obj9 = new StringBuilder();
            obj9.append("Missing chars for: ");
            obj9.append(this.a.name());
            s2.k(i, obj9.toString());
            s2.n();
        }
        length = this.c;
        if (z5 != null && length != null && this.y != null) {
            length = this.c;
            if (length != null) {
                if (this.y != null) {
                    obj9 = length.parse(charSequence, s2.e(), this.v, this.w, this.x, this.y);
                } else {
                    obj13 = this.a;
                    if (obj13 instanceof a) {
                        obj9 = (a)obj13.q(charSequence, s2.e(), d3, t4);
                    } else {
                        obj9 = obj13.parse(charSequence, s2.e(), d3);
                    }
                }
            } else {
            }
        } else {
        }
        if (s2.i()) {
            obj9 = this.a.getType();
            if (obj9.isEnum()) {
                obj12 = new StringBuilder();
                obj12.append("No suitable enum found: ");
                obj12.append(obj9.getName());
                s2.k(s2.c(), obj12.toString());
            } else {
                obj11 = new StringBuilder();
                obj11.append("Unparseable element: ");
                obj11.append(this.a.name());
                s2.k(s2.c(), obj11.toString());
            }
        } else {
            if (obj9 == null) {
                s2.k(i, "No interpretable value.");
            } else {
                obj10 = this.a;
                if (obj10 == g0.K) {
                    t4.J(g0.L, (c0)c0.class.cast(obj9).getValue());
                } else {
                    t4.K(obj10, obj9);
                }
            }
        }
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        boolean z;
        int length;
        boolean obj3;
        Object obj4;
        d obj5;
        if (appendable2 instanceof CharSequence) {
            z = appendable2;
            length = (CharSequence)z.length();
            if (b(o, appendable2, d3, z5) && set4 != null) {
                if (set4 != null) {
                    obj3 = new g(this.a, length, z.length());
                    set4.add(obj3);
                }
                return obj3 -= length;
            }
        } else {
            if (b(o, appendable2, d3, z5)) {
                return Integer.MAX_VALUE;
            }
        }
        return -1;
    }

    public net.time4j.g1.z.h<V> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        int i;
        final Object obj = this;
        Object obj2 = d2;
        g sMART = g.SMART;
        Object obj4 = obj2.a(a.f, sMART);
        Boolean tRUE = Boolean.TRUE;
        boolean booleanValue = (Boolean)obj2.a(a.k, tRUE).booleanValue();
        boolean booleanValue2 = (Boolean)obj2.a(a.i, tRUE).booleanValue();
        boolean booleanValue3 = (Boolean)obj2.a(a.j, Boolean.FALSE).booleanValue();
        if ((g)obj4 == g.STRICT && !booleanValue && !booleanValue2 && booleanValue3) {
            if (!booleanValue) {
                if (!booleanValue2) {
                    if (booleanValue3) {
                        i = i4;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        super(obj.a, obj.b, (Locale)obj2.a(a.c, Locale.ROOT), (v)obj2.a(a.g, v.WIDE), (m)obj2.a(a.h, m.FORMAT), i, (Integer)obj2.a(a.s, 0).intValue());
        return a0Var;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(a0.class.getName());
        stringBuilder.append("[element=");
        stringBuilder.append(this.a.name());
        stringBuilder.append(",protected-mode=");
        stringBuilder.append(this.b);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<V> withElement(p<V> p) {
        boolean z;
        if (!this.b) {
            if (this.a == p) {
            } else {
                if (!p instanceof t) {
                } else {
                    return a0.a((t)p);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Text element required: ");
            stringBuilder.append(p.getClass().getName());
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        return this;
    }
}
