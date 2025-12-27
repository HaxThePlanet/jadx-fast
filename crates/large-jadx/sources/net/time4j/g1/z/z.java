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

/* compiled from: StyleProcessor.java */
/* loaded from: classes3.dex */
final class z<T> implements h<T> {

    private final c<T> a;
    private final x b;
    private final x c;
    z(x xVar, x xVar2) {
        this(null, xVar, xVar2);
    }

    private static <T> c<T> a(w<?> wVar, x xVar, x xVar2, Locale locale, boolean z, l lVar) {
        net.time4j.g1.z.c cVar;
        String replaced;
        boolean assignableFrom;
        if (wVar.equals(g0.t0())) {
            replaced = b.r(xVar, locale);
            if (z && replaced.contains(str) && !replaced.contains("yyy")) {
                replaced = replaced.replace(str, "yyyy");
            }
            if (lVar != null) {
                cVar = c.C(replaced, w.CLDR, locale, wVar).U(lVar);
            }
            return cVar;
        } else {
            if (wVar.equals(h0.k0())) {
                replaced = b.t(xVar2, locale);
            } else {
                if (wVar.equals(i0.U())) {
                    replaced = b.u(xVar, xVar2, locale);
                } else {
                    if (wVar.equals(b0.V())) {
                        replaced = b.s(xVar, xVar2, locale);
                    } else {
                        if (h.class.isAssignableFrom(wVar.l())) {
                            replaced = wVar.f(xVar, locale);
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str2 = "Localized format patterns not available: ";
        wVar = str2 + wVar;
        throw new UnsupportedOperationException(wVar);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        z = true;
        if (this == object) {
            return true;
        }
        equals = object instanceof z;
        final int i = 0;
        if (object instanceof z) {
            if (this.b.equals(object.b)) {
                if (this.c.equals(object.c) && this.a == null) {
                    if (object.a != null) {
                    }
                    return z;
                }
            }
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        return i;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        Object obj = null;
        net.time4j.g1.z.c cVar2;
        if (z) {
        } else {
            dVar = this.a.o();
            net.time4j.engine.c cVar3 = a.e;
            cVar = a.d;
            obj = null;
            Object obj2 = dVar.a(cVar, dVar.a(cVar, obj));
            if (obj2 != null) {
                l lVar2 = l.N(obj2).Q((o)dVar.a(cVar3, dVar.a(cVar3, l.c)));
            }
            cVar2 = z.a(this.a.q(), this.b, this.c, (Locale)dVar.a(a.c, this.a.u()), (Boolean)dVar.a(a.v, Boolean.FALSE).booleanValue(), obj);
        }
        final Object obj5 = cVar2.b(charSequence, sVar, dVar);
        if (!sVar.i() && obj5 != null) {
            tVar.L(obj5);
        }
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) {
        int r0 = set != null ? 1 : 0;
        if (set != null) {
            set.addAll(this.a.K(oVar, appendable, dVar, (set != null ? 1 : 0)));
        }
        return 0x7fffffff /* Unknown resource */;
    }

    public h<T> quickPath(c<?> cVar, d dVar, int i) {
        Object obj = null;
        obj = null;
        Object obj3 = dVar.a(a.d, obj);
        if (obj3 != null) {
            l lVar = l.N(obj3).Q((o)dVar.a(a.e, l.c));
        }
        return new z(z.a(cVar.q(), this.b, this.c, (Locale)dVar.a(a.c, Locale.ROOT), (Boolean)dVar.a(a.v, Boolean.FALSE).booleanValue(), obj), this.b, this.c);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = z.class.getName();
        String str2 = "[date-style=";
        String str3 = ",time-style=";
        String str4 = ",delegate=";
        str = 64 + name + str2 + this.b + str3 + this.c + str4 + this.a + 93;
        return str;
    }

    private z(c<T> cVar, x xVar, x xVar2) {
        super();
        if (xVar == null) {
            throw new NullPointerException("Missing display style.");
        } else {
            if (xVar2 != null) {
                this.b = xVar;
                this.c = xVar2;
                this.a = cVar;
                return;
            }
        }
    }


    public p<T> getElement() {
        return null;
    }

    public boolean isNumerical() {
        return false;
    }

    public h<T> withElement(p<T> pVar) {
        return this;
    }
}
