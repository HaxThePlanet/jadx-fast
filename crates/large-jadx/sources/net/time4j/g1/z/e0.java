package net.time4j.g1.z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.g1.a;
import net.time4j.g1.e;
import net.time4j.g1.g;
import net.time4j.tz.f;
import net.time4j.tz.k;
import net.time4j.tz.l;

/* compiled from: TimezoneOffsetProcessor.java */
/* loaded from: classes3.dex */
final class e0 implements h<k> {

    static final e0 x = new e0();
    private final e a;
    private final boolean b;
    private final List<String> c;
    private final boolean v;
    private final g w;

    e0(e eVar, boolean z, List<String> list) {
        super();
        Objects.requireNonNull(eVar, "Missing display mode.");
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Missing zero offsets.");
        } else {
            ArrayList arrayList = new ArrayList(list);
            final Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if ((String)it.next().trim().isEmpty()) {
                    throw new IllegalArgumentException("Zero offset must not be white-space-only.");
                }
            }
            this.a = eVar;
            this.b = z;
            this.c = Collections.unmodifiableList(arrayList);
            this.v = true;
            this.w = g.SMART;
            return;
        }
    }

    private static net.time4j.tz.p a(o oVar, d dVar) {
        cVar = a.d;
        if (!dVar.c(cVar)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Cannot extract timezone offset from format attributes for: ";
            oVar = str + oVar;
            throw new IllegalArgumentException(oVar);
        } else {
            Object obj = dVar.b(a.d);
            if (obj instanceof p) {
                return obj;
            }
            if (obj != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                final String str2 = "Use a timezone offset instead of [";
                String str4 = obj.a();
                String str5 = "] when formatting [";
                String str3 = "].";
                oVar = str2 + str4 + str5 + oVar + str3;
                throw new IllegalArgumentException(oVar);
            }
        }
    }

    private static int b(java.lang.CharSequence charSequence, int i, g gVar) {
        i = 0;
        while (i < 2) {
            int i7 = i + i;
            int i4 = 48;
            if (i >= 48 && i <= 57) {
            }
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        e eVar;
        e eVar2;
        boolean equals;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof e0) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (!(this.c.equals(object.c))) {
                    }
                }
            }
            return z;
        }
        return false;
    }

    public net.time4j.engine.p<k> getElement() {
        return b0.TIMEZONE_OFFSET;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.a.hashCode() * 7) + (this.c.hashCode() * 31) + this.b;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int i;
        net.time4j.tz.p pVar;
        g gVar;
        int i2;
        int length;
        int i3;
        f aHEAD_OF_UTC2;
        char c = 43;
        e lONG2;
        boolean booleanValue;
        String str2;
        Boolean tRUE2;
        final Object charSequence4 = this;
        charSequence2 = charSequence;
        final Object dVar32 = sVar;
        Object tVar42 = dVar;
        final Object z52 = tVar;
        length = charSequence.length();
        i3 = sVar.f();
        if (i3 >= length) {
            dVar32.k(i3, "Missing timezone offset.");
            return;
        }
        Iterator it = charSequence4.c.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            int length2 = item.length();
            if (length - i3 >= length2) {
                length2 = length2 + i3;
                String charSequence3 = charSequence2.subSequence(i3, length2).toString();
            }
        }
        if (z) {
        } else {
            Object obj = tVar42.a(a.f, g.SMART);
        }
        char charAt3 = charSequence2.charAt(i3);
        c = '+';
        if (charAt3 == '+') {
            aHEAD_OF_UTC2 = f.AHEAD_OF_UTC;
            i3 = i3 + 1;
            i2 = e0.b(charSequence2, i3, gVar);
            i = -1000;
            if (i2 == i) {
                dVar32.k(i3, "Hour part in timezone offset does not match expected pattern HH.");
                return;
            }
            i = 1;
            i = i2 < 0 ? i3 + i : i3 + 2;
            if (i >= length) {
                if (charSequence4.a == e.SHORT) {
                    z52.K(b0.TIMEZONE_OFFSET, p.s(aHEAD_OF_UTC2, i2));
                    dVar32.l(i);
                } else {
                    dVar32.k(i, "Missing minute part in timezone offset.");
                }
                return;
            }
            str2 = "Colon expected in timezone offset.";
            char c4 = ':';
            i = 0;
            if (charSequence4.b) {
                if (charSequence2.charAt(i) == c4) {
                    i += i;
                    final g sTRICT2 = g.STRICT;
                    int i4 = e0.b(charSequence2, i9, sTRICT2);
                    if (i4 == i) {
                        if (charSequence4.a == e.SHORT) {
                            z52.K(b0.TIMEZONE_OFFSET, p.s(aHEAD_OF_UTC2, i2));
                            dVar32.l(i);
                        } else {
                            str = "Minute part in timezone offset does not match expected pattern mm.";
                            dVar32.k(i9, str);
                        }
                        return;
                    }
                    i = i9 + 2;
                    if (charSequence4.b < length) {
                        if (charSequence4.a == e.LONG || charSequence4.a == e.FULL) {
                            if (charSequence4.b) {
                                if (charSequence2.charAt(i) != c4) {
                                    if (charSequence4.a == e.FULL) {
                                        dVar32.k(i, "Colon expected in timezone offset.");
                                        return;
                                    }
                                } else {
                                    i = e0.b(charSequence2, i + 1, g.STRICT);
                                    i = 1;
                                }
                            } else {
                                i = e0.b(charSequence2, i, g.STRICT);
                            }
                            if (charSequence4.b == i) {
                                if (charSequence4.a == e.FULL) {
                                    dVar32.k(i, "Second part in timezone offset does not match expected pattern ss.");
                                    return;
                                }
                            } else {
                                i = (i + i) + 2;
                                i = i + 10;
                                if (i + 10 <= length && charSequence4.a.charAt(charSequence4.b) == '.') {
                                    i = i + 1;
                                    length = i + 9;
                                    while (charSequence4.b < e.SHORT) {
                                        char charAt4 = charSequence2.charAt(i);
                                        char c2 = '0';
                                        if (charAt4 >= '0' && charAt4 <= 57) {
                                            dVar32.k(i, "9 digits in fractional part of timezone offset expected.");
                                            return;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (i != 0 || "9 digits in fractional part of timezone offset expected." != 0) {
                        i4 = i4 * 60;
                        i2 = (i2 * 3600) + i4 + i;
                        if (a.f == f.BEHIND_UTC) {
                            i2 = -(i2 * 3600 + i4 * 60 + i);
                            i = -i;
                        }
                        pVar = p.v(i2, i);
                    } else {
                        pVar = p.t(aHEAD_OF_UTC2, i2, i4);
                    }
                    z52.K(b0.TIMEZONE_OFFSET, pVar);
                    dVar32.l(i);
                    return;
                } else {
                    if (charSequence4.a == e.SHORT) {
                        z52.K(b0.TIMEZONE_OFFSET, p.s(aHEAD_OF_UTC2, i2));
                        dVar32.l(i);
                        return;
                    }
                }
                dVar32.k(i, "Colon expected in timezone offset.");
                return;
            }
        }
        dVar32.k(i3, "Missing sign of timezone offset.");
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        k kVar = null;
        int i = 1;
        int dVar32;
        char c = 43;
        e eVar;
        int i2;
        char c3 = 58;
        net.time4j.tz.p pVar;
        int length;
        length = -1;
        if (appendable instanceof CharSequence) {
            length = (CharSequence)appendable.length();
        } else {
        }
        int i4 = 0;
        if (oVar.j()) {
            kVar = oVar.t();
        }
        if (kVar == null) {
            pVar = e0.a(oVar, dVar);
            dVar32 = pVar.o();
            int i8 = pVar.n();
            dVar32 = dVar32 | i8;
            i = 0;
            if (dVar32 | i8 == 0) {
                Object item = this.c.get(i);
                appendable.append(item);
                dVar32 = item.length();
            } else {
                i = 1;
                if (dVar32 < 0 || i8 < 0) {
                }
                int r3 = i != 0 ? 45 : 43;
                appendable.append((i != 0 ? 45 : 43));
                int abs2 = Math.abs(dVar32);
                int i6 = abs2 / 3600;
                i2 = (abs2 / 60) % 60;
                dVar32 = abs2 % 60;
                int i3 = 10;
                char c2 = '0';
                if (i6 < i3) {
                    appendable.append(c2);
                    i = 2;
                }
                String str = String.valueOf(i6);
                appendable.append(str);
                dVar32 = i + str.length();
                sHORT2 = e.SHORT;
                if (this.a == e.SHORT && i2 != 0) {
                    c3 = ':';
                    if (this.b) {
                        appendable.append(c3);
                        dVar32 = (i + str.length()) + 1;
                    }
                    if (i2 < i3) {
                        appendable.append(c2);
                        dVar32 = dVar32 + 1;
                    }
                    String str2 = String.valueOf(i2);
                    appendable.append(str2);
                    dVar32 = dVar32 + str2.length();
                    oVar = dVar32;
                }
            }
            if (length != length && this.c > 0 && set != null) {
                length = length + dVar32;
                set.add(new g(b0.TIMEZONE_ID, length, length));
            }
            return dVar32;
        } else {
            if (kVar instanceof p) {
            } else {
                if (dVar32 instanceof f) {
                    pVar = l.N(kVar).B(oVar);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        final String str5 = "Cannot extract timezone offset from: ";
        oVar = str5 + oVar;
        throw new IllegalArgumentException(oVar);
    }

    public h<k> quickPath(c<?> cVar, d dVar, int i) {
        e0 cVar2 = new e0(this.a, this.b, this.c, (Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue(), (g)dVar.a(a.f, g.SMART));
        return cVar2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = e0.class.getName();
        String str2 = "[precision=";
        String str3 = ", extended=";
        String str4 = ", zero-offsets=";
        str = 64 + name + str2 + this.a + str3 + this.b + str4 + this.c + 93;
        return str;
    }

    private e0() {
        super();
        this.a = e.LONG;
        boolean z = true;
        this.b = z;
        this.c = Collections.emptyList();
        this.v = z;
        this.w = g.SMART;
    }

    private e0(e eVar, boolean z, List<String> list, boolean z2, g gVar) {
        super();
        this.a = eVar;
        this.b = z;
        this.c = list;
        this.v = z2;
        this.w = gVar;
    }

    public boolean isNumerical() {
        return false;
    }

    public h<k> withElement(net.time4j.engine.p<k> pVar) {
        return this;
    }
}
