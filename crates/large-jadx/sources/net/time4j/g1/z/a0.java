package net.time4j.g1.z;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.time4j.c0;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g0;
import net.time4j.g1.a0.e;
import net.time4j.g1.g;
import net.time4j.g1.m;
import net.time4j.g1.t;
import net.time4j.g1.v;

/* compiled from: TextProcessor.java */
/* loaded from: classes3.dex */
final class a0<V> implements h<V> {

    private final t<V> a;
    private final boolean b;
    private final e<V> c = null;
    private final Locale v;
    private final v w;
    private final m x;
    private final g y;
    private final int z;
    private a0(t<V> tVar, boolean z, Locale locale, v vVar, m mVar, g gVar, int i) {
        super();
        Objects.requireNonNull(tVar, "Missing element.");
        this.a = tVar;
        this.b = z;
        tVar = tVar instanceof e ? (e)tVar : 0;
    }

    static <V> a0<V> a(t<V> tVar) {
        a0 a0Var = new a0(tVar, false, Locale.ROOT, v.WIDE, m.FORMAT, g.SMART, 0);
        return a0Var;
    }

    private boolean b(o oVar, java.lang.Appendable appendable, d dVar, boolean z) {
        z = true;
        if (this.c != null && z) {
            this.c.print(oVar, appendable, this.v, this.w, this.x);
            return true;
        }
        if (oVar.v(this.a)) {
            this.a.print(oVar, appendable, dVar);
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof a0) {
            if (this.a.equals(object.a)) {
                if (this.b != object.b) {
                }
            }
            return z;
        }
        return false;
    }

    public p<V> getElement() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int length;
        int value;
        Integer num;
        Integer num2;
        t tVar2;
        final int i = sVar.f();
        if (z) {
        } else {
            value = (Integer)dVar.a(a.s, null).intValue();
        }
        if (this.z > 0) {
            length = charSequence.length() - value;
        }
        if (i >= length) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Missing chars for: ";
            String name3 = this.a.name();
            str2 = str5 + name3;
            sVar.k(i, str2);
            sVar.n();
            return;
        }
        if (!this.y || this.c == null || this.y == null) {
            if (tVar2 instanceof a) {
                num2 = tVar2.q(charSequence, sVar.e(), dVar, tVar);
            } else {
                Object parse = tVar2.parse(charSequence, sVar.e(), dVar);
            }
        } else {
            Object parse2 = this.c.parse(charSequence, sVar.e(), this.v, this.w, this.x, this.y);
        }
        if (sVar.i()) {
            Class type = this.a.getType();
            if (type.isEnum()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str7 = "No suitable enum found: ";
                String name2 = type.getName();
                str3 = str7 + name2;
                sVar.k(sVar.c(), str3);
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str6 = "Unparseable element: ";
                String name = this.a.name();
                str = str6 + name;
                sVar.k(sVar.c(), str);
            }
        } else {
            if (this.a == null) {
                sVar.k(i, "No interpretable value.");
            } else {
                if (this.a == g0.K) {
                    str = c0.class;
                    tVar.J(g0.L, (c0)str.cast(num2).getValue());
                } else {
                    tVar.K(this.a, num2);
                }
            }
        }
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) {
        z = appendable instanceof CharSequence;
        if (appendable instanceof CharSequence) {
            Object appendable22 = appendable;
            int length = appendable22.length();
            if (b(oVar, appendable, dVar, z) && set != null) {
                set.add(new g(this.a, length, appendable22.length()));
                return appendable22.length() - length;
            }
        } else {
            if (b(oVar, appendable, dVar, z)) {
                return 0x7fffffff /* Unknown resource */;
            }
        }
        return -1;
    }

    public h<V> quickPath(c<?> cVar, d dVar, int i) {
        g gVar;
        final Object cVar2 = this;
        Object i32 = dVar;
        g sMART2 = g.SMART;
        Object obj = i32.a(a.f, sMART2);
        Boolean tRUE2 = Boolean.TRUE;
        boolean booleanValue = (Boolean)i32.a(a.k, tRUE2).booleanValue();
        boolean booleanValue2 = (Boolean)i32.a(a.i, tRUE2).booleanValue();
        boolean booleanValue3 = (Boolean)i32.a(a.j, Boolean.FALSE).booleanValue();
        int r15 = 0;
        a0 a0Var = new a0(cVar2.a, cVar2.b, (Locale)i32.a(a.c, Locale.ROOT), (v)i32.a(a.g, v.WIDE), (m)i32.a(a.h, m.FORMAT), null, i32.a(a.s, Integer.valueOf(0)).intValue());
        return a0Var;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = a0.class.getName();
        String str2 = "[element=";
        String name2 = this.a.name();
        String str3 = ",protected-mode=";
        str = 64 + name + str2 + name2 + str3 + this.b + 93;
        return str;
    }

    public h<V> withElement(p<V> pVar) {
        return this;
    }

    public boolean isNumerical() {
        return false;
    }
}
