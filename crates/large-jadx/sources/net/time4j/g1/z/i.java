package net.time4j.g1.z;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.n;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.a;
import net.time4j.g1.a.b;
import net.time4j.g1.g;

/* compiled from: FormatStep.java */
/* loaded from: classes3.dex */
final class i {

    private final h<?> a;
    private final int b;
    private final int c;
    private final b d;
    private final d e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final int j;
    i(h<?> hVar, int i, int i2, b bVar) {
        this(hVar, i, i2, bVar, null, 0, 0, 0, false, -1);
    }

    private void a(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        try {
            this.a.parse(charSequence, sVar, dVar, tVar, z);
        } catch (RuntimeException e) {
            e = e.getMessage();
            sVar.k(i, e);
        }
    }

    private char c(d dVar) {
        return (Character)dVar.a(a.p, ' ').charValue();
    }

    private d e(d dVar) {
        if (this.d == null) {
            return dVar;
        }
        return new p(bVar, dVar);
    }

    private static boolean h(Object object, Object object2) {
        boolean equals = false;
        if (object == null) {
            object = object2 == null ? 1 : 0;
        } else {
            object = object.equals(object2);
        }
        return (object2 == null ? 1 : 0);
    }

    private boolean k(o oVar) {
        boolean z = true;
        z = true;
        if (this.d == null) {
            return true;
        }
        n nVar = this.d.f();
        return z;
    }

    private boolean l(d dVar) {
        return (g)dVar.a(a.f, g.SMART).isStrict();
    }

    private String o() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Pad width exceeded: ";
        String name = this.a.getElement().name();
        str = str2 + name;
        return str;
    }

    private String p() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Pad width mismatched: ";
        String name = this.a.getElement().name();
        str = str2 + name;
        return str;
    }

    private static <V> h<V> w(h<V> hVar, p<?> pVar) {
        if (hVar.getElement() == null) {
            return hVar;
        }
        if (hVar.getElement().getType() != pVar.getType()) {
            if (!(pVar instanceof a)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Cannot change element value type: ";
                String name = pVar.name();
                pVar = str + name;
                throw new IllegalArgumentException(pVar);
            }
        }
        return hVar.withElement(pVar);
    }

    int b() {
        return this.b;
    }

    h<?> d() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z = true;
        boolean equals;
        net.time4j.g1.z.h hVar;
        int i2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof i) {
            if (this.a.equals(object.a)) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (i.h(this.d, object.d)) {
                            if (i.h(this.e, object.e)) {
                                if (this.f == object.f) {
                                    if (this.g == object.g) {
                                        if (this.h == object.h) {
                                            if (this.i == object.i) {
                                                if (this.j != object.j) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    int f() {
        return this.c;
    }

    boolean g() {
        boolean z2 = false;
        int r0 = !(this.a instanceof j) ? 0 : 1;
        return (!(this.a instanceof j) ? 0 : 1);
    }

    public int hashCode() {
        int i = 0;
        if (this.d == null) {
            i = 0;
        } else {
            i = this.d.hashCode();
        }
        return (this.a.hashCode() * 7) + (i * 31);
    }

    boolean i() {
        return this.i;
    }

    boolean j() {
        return this.a.isNumerical();
    }

    i m(int i) {
        if (!this.i) {
            throw new IllegalStateException("This step is not starting an or-block.");
        } else {
            i iVar = new i(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, true, i);
            return iVar;
        }
    }

    i n(int i, int i2) {
        i iVar = new i(this.a, this.b, this.c, this.d, null, this.f, this.g + i, this.h + i2, this.i, this.j);
        return iVar;
    }

    void q(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int i;
        int i2 = 0;
        char charAt;
        java.lang.CharSequence charSequence2;
        net.time4j.g1.z.s sVar22;
        d dVar32;
        int i6;
        if (z) {
        } else {
            dVar32 = e(dVar);
        }
        if (this.g == 0 && this.h == 0) {
            this.a(charSequence, sVar, dVar32, tVar, z);
            return;
        }
        z = l(dVar32);
        final char c = c(dVar32);
        i = sVar.f();
        final int length = charSequence.length();
        while (i < length) {
        }
        i3 = i - i;
        if (this.g && i3 > this.g) {
            sVar.k(i, o());
            return;
        }
        sVar.l(i);
        this.a(charSequence, sVar, dVar32, tVar, z);
        if (sVar.i()) {
            return;
        }
        i7 = (sVar.f() - i) - i3;
        if (this.g && this.g > 0) {
            i3 = i3 + i7;
            if (i3 + i7 != this.g) {
                sVar.k(i, p());
                return;
            }
        }
        i2 = 0;
        while (i6 < length) {
        }
        if (this.g && this.h > 0) {
            i7 = i7 + i2;
            if (i7 + i2 != this.h) {
                sVar.k(i6 - i2, p());
                return;
            }
        }
        sVar.l(i6);
    }

    int r(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        int length;
        LinkedHashSet linkedHashSet = null;
        char c;
        Object appendable22;
        int i4;
        int i5;
        int i6;
        int i7;
        Object obj;
        int i8 = 0;
        final Object oVar3 = this;
        appendable22 = appendable;
        Set set42 = set;
        length = 0;
        if (!k(oVar)) {
            return length;
        }
        if (z) {
        } else {
            dVar = oVar3.e(dVar);
        }
        if (oVar3.g == 0 && oVar3.h == 0) {
            return oVar3.a.print(oVar, appendable, dVar, set, z);
        }
        int i2 = 0;
        length = -1;
        if (appendable22 instanceof StringBuilder) {
        } else {
            StringBuilder stringBuilder = new StringBuilder();
        }
        if (!(appendable22 instanceof CharSequence) || set42 == null) {
        } else {
            if (appendable22 == appendable22) {
                z = hVar instanceof f;
                if (!(hVar instanceof f)) {
                    if (hVar instanceof z) {
                    } else {
                        length = (CharSequence)appendable22.length();
                    }
                }
            }
        }
        final boolean z6 = oVar3.l(dVar);
        oVar3.a.print(oVar, appendable22, dVar, linkedHashSet, z);
        i5 = appendable22.length() - appendable22.length();
        if (oVar3.g > 0) {
            i8 = 0;
            while (oVar3.g < oVar3.g) {
                i5 = i5 + 1;
                i8 = i8 + 1;
            }
            if (length == length) {
                appendable22.append(appendable22);
            }
            if (length != length) {
                length = length + i8;
                Iterator it2 = linkedHashSet.iterator();
                while (it2.hasNext()) {
                    Object item2 = it2.next();
                    set42.add(new g(item2.a(), item2.c() + length, item2.b() + length));
                }
            }
            if (!(oVar3.h <= 0 || z6 || oVar3.a <= oVar3.h)) {
                throw new IllegalArgumentException(o());
            }
        } else {
            if (z6) {
                if (oVar3.a > oVar3.h) {
                    throw new IllegalArgumentException(o());
                }
            }
            if (length == length) {
                appendable22.append(appendable22);
            }
            while (oVar3.a < oVar3.h) {
                appendable22.append(c);
                i5 = i5 + 1;
            }
            if (length != length) {
                Iterator it = linkedHashSet.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    i6 = item.c() + length;
                    c = item.b() + length;
                    set42.add(new g(item.a(), i6, c));
                }
            }
        }
        return i5;
    }

    i s(c<?> cVar) {
        net.time4j.g1.z.b bVar;
        bVar = cVar.p();
        if (this.d != null) {
            a.b bVar3 = new a.b();
            bVar3.f(bVar.e());
            bVar3.f(this.d.e());
            bVar = bVar.l(bVar3.a());
        }
        i iVar = new i(this.a.quickPath(cVar, bVar, this.f), this.b, this.c, this.d, bVar, this.f, this.g, this.h, this.i, this.j);
        return iVar;
    }

    i t(int i) {
        i iVar = new i(this.a, this.b, this.c, this.d, null, this.f + i, this.g, this.h, this.i, this.j);
        return iVar;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[processor=");
        stringBuilder.append(this.a);
        stringBuilder.append(", level=");
        stringBuilder.append(this.b);
        stringBuilder.append(", section=");
        stringBuilder.append(this.c);
        if (this.d != null) {
            stringBuilder.append(", attributes=");
            stringBuilder.append(this.d);
        }
        stringBuilder.append(", reserved=");
        stringBuilder.append(this.f);
        stringBuilder.append(", pad-left=");
        stringBuilder.append(this.g);
        stringBuilder.append(", pad-right=");
        stringBuilder.append(this.h);
        if (this.i) {
            stringBuilder.append(", or-block-started");
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    int u() {
        return this.j;
    }

    i v() {
        if (this.i) {
            throw new IllegalStateException("Cannot start or-block twice.");
        } else {
            i iVar = new i(this.a, this.b, this.c, this.d, null, this.f, this.g, this.h, true, -1);
            return iVar;
        }
    }

    i x(p<?> pVar) {
        final net.time4j.g1.z.h hVar2 = i.w(this.a, pVar);
        if (this.a == hVar2) {
            return this;
        }
        i pVar2 = new i(hVar2, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        return pVar2;
    }

    private i(h<?> hVar, int i, int i2, b bVar, d dVar, int i3, int i4, int i5, boolean z, int i6) {
        super();
        Objects.requireNonNull(hVar, "Missing format processor.");
        if (i < 0) {
            StringBuilder stringBuilder5 = new StringBuilder();
            String str4 = "Invalid level: ";
            i = str4 + i;
            throw new IllegalArgumentException(i);
        } else {
            if (i2 < 0) {
                StringBuilder stringBuilder4 = new StringBuilder();
                String str5 = "Invalid section: ";
                i = str5 + i2;
                throw new IllegalArgumentException(i);
            } else {
                if (i3 < 0) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str3 = "Reserved chars must not be negative: ";
                    i = str3 + i3;
                    throw new IllegalArgumentException(i);
                } else {
                    String str2 = "Invalid pad-width: ";
                    if (i4 < 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        i = str2 + i4;
                        throw new IllegalArgumentException(i);
                    } else {
                        if (i5 < 0) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            i = str2 + i5;
                            throw new IllegalArgumentException(i);
                        } else {
                            this.a = hVar;
                            this.b = i;
                            this.c = i2;
                            this.d = bVar;
                            this.e = dVar;
                            this.f = i3;
                            this.g = i4;
                            this.h = i5;
                            this.i = z;
                            this.j = i6;
                            return;
                        }
                    }
                }
            }
        }
    }
}
