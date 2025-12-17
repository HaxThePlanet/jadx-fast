package net.time4j.g1.z;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.a;
import net.time4j.g1.e;
import net.time4j.g1.g;
import net.time4j.tz.f;
import net.time4j.tz.k;
import net.time4j.tz.l;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
final class e0 implements net.time4j.g1.z.h<k> {

    static final net.time4j.g1.z.e0 x;
    private final e a;
    private final boolean b;
    private final List<String> c;
    private final boolean v;
    private final g w;
    static {
        e0 e0Var = new e0();
        e0.x = e0Var;
    }

    private e0() {
        super();
        this.a = e.LONG;
        int i = 1;
        this.b = i;
        this.c = Collections.emptyList();
        this.v = i;
        this.w = g.SMART;
    }

    e0(e e, boolean z2, List<String> list3) {
        boolean empty;
        super();
        Objects.requireNonNull(e, "Missing display mode.");
        if (list3.isEmpty()) {
        } else {
            ArrayList arrayList = new ArrayList(list3);
            final Iterator obj5 = arrayList.iterator();
            for (String next2 : obj5) {
            }
            this.a = e;
            this.b = z2;
            this.c = Collections.unmodifiableList(arrayList);
            this.v = true;
            this.w = g.SMART;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("Missing zero offsets.");
        throw obj3;
    }

    private e0(e e, boolean z2, List<String> list3, boolean z4, g g5) {
        super();
        this.a = e;
        this.b = z2;
        this.c = list3;
        this.v = z4;
        this.w = g5;
    }

    private static p a(o o, d d2) {
        net.time4j.engine.c cVar;
        Object obj4;
        cVar = a.d;
        if (!d2.c(cVar)) {
        } else {
            obj4 = d2.b(cVar);
            if (obj4 instanceof p) {
                return (p)(k)obj4;
            }
            if (obj4 != null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Use a timezone offset instead of [");
                stringBuilder2.append(obj4.a());
                stringBuilder2.append("] when formatting [");
                stringBuilder2.append(o);
                stringBuilder2.append("].");
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder2.toString());
                throw illegalArgumentException;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot extract timezone offset from format attributes for: ");
        stringBuilder.append(o);
        obj4 = new IllegalArgumentException(stringBuilder.toString());
        throw obj4;
    }

    private static int b(java.lang.CharSequence charSequence, int i2, g g3) {
        int i4;
        int i5;
        int i3;
        int charAt;
        int i;
        boolean obj5;
        final int i6 = 0;
        i5 = i4;
        while (i4 < 2) {
            int i9 = i2 + i4;
            if (i9 >= charSequence.length()) {
            } else {
            }
            charAt = charSequence.charAt(i9);
            i7 += i3;
            i4++;
            charAt = i6;
        }
        return i5;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        e eVar;
        e eVar2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof e0) {
            if (this.a == object.a && this.b == object.b && this.c.equals(object.c)) {
                if (this.b == object.b) {
                    if (this.c.equals(object.c)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public p<k> getElement() {
        return b0.TIMEZONE_OFFSET;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        return i3 += z;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        return 0;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        Object tIMEZONE_OFFSET;
        Object tIMEZONE_OFFSET2;
        int i9;
        p pVar;
        Object charSequence2;
        Object obj;
        int i10;
        int bEHIND_UTC;
        int i5;
        int i6;
        Object iterator;
        f aHEAD_OF_UTC;
        boolean digit;
        Object equals;
        g sMART;
        int i11;
        int i7;
        int length;
        e lONG;
        int string;
        int i8;
        int i3;
        int i4;
        boolean booleanValue;
        String str;
        Boolean equalsIgnoreCase;
        int i;
        int i2;
        final Object obj2 = this;
        charSequence2 = charSequence;
        final Object obj3 = s2;
        Object obj4 = d3;
        final Object obj5 = t4;
        bEHIND_UTC = charSequence.length();
        i5 = s2.f();
        if (i5 >= bEHIND_UTC) {
            obj3.k(i5, "Missing timezone offset.");
        }
        iterator = obj2.c.iterator();
        for (String equals : iterator) {
            length = equals.length();
            length += i5;
            string = charSequence2.subSequence(i5, length).toString();
            if (z5) {
            } else {
            }
            booleanValue = (Boolean)obj4.a(a.i, Boolean.TRUE).booleanValue();
            booleanValue = obj2.v;
        }
        if (z5) {
            obj = obj2.w;
        } else {
            obj = obj4.a(a.f, g.SMART);
        }
        char charAt2 = charSequence2.charAt(i5);
        if (charAt2 == 43) {
            aHEAD_OF_UTC = f.AHEAD_OF_UTC;
            i5++;
            i10 = e0.b(charSequence2, i5, obj);
            i7 = -1000;
            if (i10 == i7) {
                obj3.k(i5, "Hour part in timezone offset does not match expected pattern HH.");
            }
            lONG = 1;
            i6 = i10 < 0 ? i5 + lONG : i5 + 2;
            if (i6 >= bEHIND_UTC) {
                if (obj2.a == e.SHORT) {
                    obj5.K(b0.TIMEZONE_OFFSET, p.s(aHEAD_OF_UTC, i10));
                    obj3.l(i6);
                } else {
                    obj3.k(i6, "Missing minute part in timezone offset.");
                }
            }
            str = "Colon expected in timezone offset.";
            int i17 = 58;
            i = 0;
            if (obj2.b) {
                if (charSequence2.charAt(i6) == i17) {
                    i8 = lONG;
                    i8 += i6;
                    final g sTRICT = g.STRICT;
                    i2 = e0.b(charSequence2, i15, sTRICT);
                    if (i2 == i7) {
                        if (obj2.a == e.SHORT) {
                            obj5.K(b0.TIMEZONE_OFFSET, p.s(aHEAD_OF_UTC, i10));
                            obj3.l(i6);
                        } else {
                            obj3.k(i15, "Minute part in timezone offset does not match expected pattern mm.");
                        }
                    }
                    i15 += 2;
                    if (i3 < bEHIND_UTC) {
                        i6 = obj2.a;
                        if (i6 != e.LONG) {
                            if (i6 == e.FULL) {
                                if (obj2.b) {
                                    if (charSequence2.charAt(i3) == i17) {
                                        i6 = e0.b(charSequence2, i3 + 1, sTRICT);
                                        lONG = 1;
                                    } else {
                                        if (obj2.a == e.FULL) {
                                            obj3.k(i3, str);
                                        }
                                        i6 = i7;
                                        lONG = i;
                                    }
                                } else {
                                    i6 = e0.b(charSequence2, i3, sTRICT);
                                }
                                if (i6 == i7) {
                                    if (obj2.a == e.FULL) {
                                        obj3.k(i3, "Second part in timezone offset does not match expected pattern ss.");
                                    }
                                    i9 = i;
                                } else {
                                    i16 += 2;
                                    if (i3 + 10 <= bEHIND_UTC && charSequence2.charAt(i3) == 46) {
                                        if (charSequence2.charAt(i3) == 46) {
                                            i3++;
                                            i7 = i4;
                                            while (i4 < i4 + 9) {
                                                char charAt3 = charSequence2.charAt(i4);
                                                i18 += lONG;
                                                i7++;
                                                i4++;
                                            }
                                            i3 = i7;
                                        }
                                    }
                                    i9 = i;
                                    i = i6;
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                    if (i == 0 && i9 == 0) {
                        if (i9 == 0) {
                            pVar = p.t(aHEAD_OF_UTC, i10, i2);
                        } else {
                            if (aHEAD_OF_UTC == f.BEHIND_UTC) {
                                i10 = -i10;
                                i9 = -i9;
                            }
                            pVar = p.v(i10, i9);
                        }
                    } else {
                    }
                    obj5.K(b0.TIMEZONE_OFFSET, pVar);
                    obj3.l(i3);
                } else {
                    if (obj2.a == e.SHORT) {
                        obj5.K(b0.TIMEZONE_OFFSET, p.s(aHEAD_OF_UTC, i10));
                        obj3.l(i6);
                    }
                }
                obj3.k(i6, str);
            }
            i8 = i;
        } else {
        }
        obj3.k(i5, "Missing sign of timezone offset.");
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        int i9;
        int i7;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i10;
        int i;
        int mEDIUM;
        int i3;
        int i8;
        e sHORT;
        int i2;
        p obj10;
        Object obj11;
        d obj12;
        int obj14;
        i9 = -1;
        if (appendable2 instanceof CharSequence) {
            obj14 = (CharSequence)appendable2.length();
        } else {
            obj14 = i9;
        }
        i7 = 0;
        if (o.j()) {
            i7 = o.t();
        }
        if (i7 == 0) {
            obj10 = e0.a(o, d3);
            obj12 = obj10.o();
            obj10 = obj10.n();
            i6 = 0;
            if (obj12 | obj10 == 0) {
                obj10 = this.c.get(i6);
                appendable2.append((String)obj10);
                obj10 = obj10.length();
            } else {
                if (obj12 >= 0) {
                    if (obj10 < 0) {
                        i10 = i5;
                    } else {
                        i10 = i6;
                    }
                } else {
                }
                i = i10 != 0 ? 45 : 43;
                appendable2.append(i);
                obj12 = Math.abs(obj12);
                int i12 = obj12 / 3600;
                i13 %= 60;
                obj12 %= 60;
                i3 = 10;
                i8 = 48;
                if (i12 < i3) {
                    appendable2.append(i8);
                    i5 = 2;
                }
                String valueOf = String.valueOf(i12);
                appendable2.append(valueOf);
                sHORT = e.SHORT;
                if (this.a == sHORT && mEDIUM != 0) {
                    if (mEDIUM != 0) {
                        i2 = 58;
                        if (this.b) {
                            appendable2.append(i2);
                            i4++;
                        }
                        if (mEDIUM < i3) {
                            appendable2.append(i8);
                            i4++;
                        }
                        String valueOf2 = String.valueOf(mEDIUM);
                        appendable2.append(valueOf2);
                        z = this.a;
                        if (z != sHORT) {
                            obj10 = i4;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            }
            if (obj14 != i9 && obj10 > 0 && set4 != null) {
                if (obj10 > 0) {
                    if (set4 != null) {
                        obj11 = new g(b0.TIMEZONE_ID, obj14, obj14 + obj10);
                        set4.add(obj11);
                    }
                }
            }
            return obj10;
        } else {
            if (i7 instanceof p) {
                obj10 = i7;
            } else {
                if (!o instanceof f) {
                } else {
                    obj10 = l.N(i7).B((f)o);
                }
            }
        }
        obj12 = new StringBuilder();
        obj12.append("Cannot extract timezone offset from: ");
        obj12.append(o);
        obj11 = new IllegalArgumentException(obj12.toString());
        throw obj11;
    }

    public net.time4j.g1.z.h<k> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        super(this.a, this.b, this.c, (Boolean)d2.a(a.i, Boolean.TRUE).booleanValue(), (g)d2.a(a.f, g.SMART));
        return obj7;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        stringBuilder.append(e0.class.getName());
        stringBuilder.append("[precision=");
        stringBuilder.append(this.a);
        stringBuilder.append(", extended=");
        stringBuilder.append(this.b);
        stringBuilder.append(", zero-offsets=");
        stringBuilder.append(this.c);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<k> withElement(p<k> p) {
        return this;
    }
}
