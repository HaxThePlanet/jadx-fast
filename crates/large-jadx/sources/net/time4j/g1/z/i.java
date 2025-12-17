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

/* loaded from: classes3.dex */
final class i {

    private final net.time4j.g1.z.h<?> a;
    private final int b;
    private final int c;
    private final net.time4j.g1.z.b d;
    private final d e;
    private final int f;
    private final int g;
    private final int h;
    private final boolean i;
    private final int j;
    i(net.time4j.g1.z.h<?> h, int i2, int i3, net.time4j.g1.z.b b4) {
        super(h, i2, i3, b4, 0, 0, 0, 0, 0, -1);
    }

    private i(net.time4j.g1.z.h<?> h, int i2, int i3, net.time4j.g1.z.b b4, d d5, int i6, int i7, int i8, boolean z9, int i10) {
        super();
        Objects.requireNonNull(h, "Missing format processor.");
        if (i2 < 0) {
        } else {
            if (i3 < 0) {
            } else {
                if (i6 < 0) {
                } else {
                    String str2 = "Invalid pad-width: ";
                    if (i7 < 0) {
                    } else {
                        if (i8 < 0) {
                        } else {
                            this.a = h;
                            this.b = i2;
                            this.c = i3;
                            this.d = b4;
                            this.e = d5;
                            this.f = i6;
                            this.g = i7;
                            this.h = i8;
                            this.i = z9;
                            this.j = i10;
                        }
                        StringBuilder obj3 = new StringBuilder();
                        obj3.append(str2);
                        obj3.append(i8);
                        IllegalArgumentException obj2 = new IllegalArgumentException(obj3.toString());
                        throw obj2;
                    }
                    obj3 = new StringBuilder();
                    obj3.append(str2);
                    obj3.append(i7);
                    obj2 = new IllegalArgumentException(obj3.toString());
                    throw obj2;
                }
                obj3 = new StringBuilder();
                obj3.append("Reserved chars must not be negative: ");
                obj3.append(i6);
                obj2 = new IllegalArgumentException(obj3.toString());
                throw obj2;
            }
            obj3 = new StringBuilder();
            obj3.append("Invalid section: ");
            obj3.append(i3);
            obj2 = new IllegalArgumentException(obj3.toString());
            throw obj2;
        }
        StringBuilder obj4 = new StringBuilder();
        obj4.append("Invalid level: ");
        obj4.append(i2);
        obj2 = new IllegalArgumentException(obj4.toString());
        throw obj2;
    }

    private void a(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        Throwable obj8;
        final int i = s2.f();
        this.a.parse(charSequence, s2, d3, t4, z5);
    }

    private char c(d d) {
        return (Character)d.a(a.p, ' ').charValue();
    }

    private d e(d d) {
        final net.time4j.g1.z.b bVar = this.d;
        if (bVar == null) {
            return d;
        }
        p pVar = new p(bVar, d);
        return pVar;
    }

    private static boolean h(Object object, Object object2) {
        int obj0;
        if (object == null) {
            obj0 = object2 == null ? 1 : 0;
        } else {
            obj0 = object.equals(object2);
        }
        return obj0;
    }

    private boolean k(o o) {
        int i;
        Object obj3;
        net.time4j.g1.z.b bVar = this.d;
        if (bVar == null) {
            return 1;
        }
        n nVar = bVar.f();
        if (nVar != null) {
            if (nVar.test(o)) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    private boolean l(d d) {
        return (g)d.a(a.f, g.SMART).isStrict();
    }

    private String o() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pad width exceeded: ");
        stringBuilder.append(this.a.getElement().name());
        return stringBuilder.toString();
    }

    private String p() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pad width mismatched: ");
        stringBuilder.append(this.a.getElement().name());
        return stringBuilder.toString();
    }

    private static <V> net.time4j.g1.z.h<V> w(net.time4j.g1.z.h<V> h, p<?> p2) {
        Class type;
        if (h.getElement() == null) {
            return h;
        }
        if (h.getElement().getType() != p2.getType()) {
            if (!p2 instanceof a) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot change element value type: ");
            stringBuilder.append(p2.name());
            IllegalArgumentException obj2 = new IllegalArgumentException(stringBuilder.toString());
            throw obj2;
        }
        return h.withElement(p2);
    }

    int b() {
        return this.b;
    }

    net.time4j.g1.z.h<?> d() {
        return this.a;
    }

    public boolean equals(Object object) {
        int i;
        boolean equals;
        net.time4j.g1.z.h hVar;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof i) {
            if (this.a.equals(object.a) && this.b == object.b && this.c == object.c && i.h(this.d, object.d) && i.h(this.e, object.e) && this.f == object.f && this.g == object.g && this.h == object.h && this.i == object.i && this.j == object.j) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (i.h(this.d, object.d)) {
                            if (i.h(this.e, object.e)) {
                                if (this.f == object.f) {
                                    if (this.g == object.g) {
                                        if (this.h == object.h) {
                                            if (this.i == object.i) {
                                                if (this.j == object.j) {
                                                } else {
                                                    i = i2;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    int f() {
        return this.c;
    }

    boolean g() {
        int i;
        i = !hVar instanceof j ? 0 : 1;
        return i;
    }

    public int hashCode() {
        int i;
        net.time4j.g1.z.b bVar = this.d;
        if (bVar == null) {
            i = 0;
        } else {
            i = bVar.hashCode();
        }
        return i3 += i5;
    }

    boolean i() {
        return this.i;
    }

    boolean j() {
        return this.a.isNumerical();
    }

    net.time4j.g1.z.i m(int i) {
        if (!this.i) {
        } else {
            super(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, 1, i);
            return iVar;
        }
        IllegalStateException obj13 = new IllegalStateException("This step is not starting an or-block.");
        throw obj13;
    }

    net.time4j.g1.z.i n(int i, int i2) {
        super(this.a, this.b, this.c, this.d, 0, this.f, i3 + i, obj13 + i2, this.i, this.j);
        return iVar2;
    }

    void q(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        int i3;
        Object obj;
        int i;
        char charAt2;
        java.lang.CharSequence charAt;
        net.time4j.g1.z.s sVar;
        int i2;
        int obj11;
        d obj13;
        int obj14;
        int obj15;
        if (z5) {
            obj13 = this.e;
        } else {
            obj13 = e(d3);
        }
        final d dVar = obj13;
        if (this.g == 0 && this.h == 0) {
            if (this.h == 0) {
                this.a(charSequence, s2, dVar, t4, z5);
            }
        }
        obj13 = l(dVar);
        final char c = c(dVar);
        final int i4 = s2.f();
        final int length = charSequence.length();
        i3 = i4;
        while (i3 < length) {
            if (charSequence.charAt(i3) == c) {
            }
            i3++;
        }
        i2 = i3 - i4;
        if (obj13 != null && i2 > this.g) {
            if (i2 > this.g) {
                s2.k(i4, o());
            }
        }
        s2.l(i3);
        this.a(charSequence, s2, dVar, t4, z5);
        if (s2.i()) {
        }
        obj15 -= i2;
        obj = this.g;
        if (obj13 != null && obj > 0 && i2 += obj15 != obj) {
            obj = this.g;
            if (obj > 0) {
                if (i2 += obj15 != obj) {
                    s2.k(i4, p());
                }
            }
        }
        i = 0;
        while (obj14 < length) {
            if (obj13 != null) {
            } else {
            }
            if (charSequence.charAt(obj14) == c) {
            }
            obj14++;
            i++;
            if (obj15 + i < this.h) {
            }
        }
        obj11 = this.h;
        if (obj13 != null && obj11 > 0 && obj15 += i != obj11) {
            obj11 = this.h;
            if (obj11 > 0) {
                if (obj15 += i != obj11) {
                    s2.k(obj14 -= i, p());
                }
            }
        }
        s2.l(obj14);
    }

    int r(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        d dVar2;
        int i2;
        int length2;
        int iterator;
        char next;
        Object gVar;
        Object stringBuilder;
        int length;
        boolean linkedHashSet;
        int i5;
        int i3;
        int i4;
        StringBuilder gVar2;
        d dVar;
        LinkedHashSet set;
        int i;
        int i7;
        int i6;
        final Object obj = this;
        gVar = appendable2;
        Set set2 = set4;
        int i8 = 0;
        if (!k(o)) {
            return i8;
        }
        if (z5) {
            dVar2 = obj.e;
        } else {
            dVar2 = obj.e(d3);
        }
        dVar = dVar2;
        if (obj.g == 0 && obj.h == 0) {
            if (obj.h == 0) {
                return obj.a.print(o, appendable2, dVar, set4, z5);
            }
        }
        iterator = 0;
        final int i13 = -1;
        if (gVar instanceof StringBuilder != null) {
            i = length;
        } else {
            stringBuilder = new StringBuilder();
            i = i13;
        }
        if (gVar instanceof CharSequence && set2 != null) {
            if (set2 != null) {
                if (stringBuilder == gVar) {
                    iterator = obj.a;
                    if (!iterator instanceof f) {
                        if (iterator instanceof z) {
                            length2 = i8;
                        } else {
                            length2 = (CharSequence)gVar.length();
                        }
                    } else {
                    }
                } else {
                }
                linkedHashSet = new LinkedHashSet();
                i7 = length2;
                iterator = linkedHashSet;
            } else {
                i7 = i13;
            }
        } else {
        }
        final boolean z6 = obj.l(dVar);
        next = c;
        obj.a.print(o, stringBuilder, dVar, iterator, z5);
        length3 -= length4;
        i3 = obj.g;
        if (i3 > 0) {
            if (z6) {
                if (i5 > i3) {
                } else {
                }
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(o());
                throw illegalArgumentException3;
            }
            i4 = i5;
            i6 = 0;
            while (i4 < obj.g) {
                if (i == i13) {
                } else {
                }
                stringBuilder.insert(i, next);
                i4++;
                i6++;
                gVar.append(next);
            }
            if (i == i13) {
                gVar.append(stringBuilder);
            }
            if (i7 != i13) {
                i7 += i6;
                iterator = iterator.iterator();
                for (g next3 : iterator) {
                    gVar2 = new g(next3.a(), i12 += i7, i10 += i7);
                    set2.add(gVar2);
                }
            }
            iterator = obj.h;
            if (iterator > 0 && z6) {
                if (z6) {
                    if (i5 > iterator) {
                    } else {
                    }
                    IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(o());
                    throw illegalArgumentException2;
                }
                while (i5 < obj.h) {
                    gVar.append(next);
                    i5++;
                    i4++;
                }
            }
        } else {
            if (z6) {
                if (i5 > obj.h) {
                } else {
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(o());
                throw illegalArgumentException;
            }
            if (i == i13) {
                gVar.append(stringBuilder);
            }
            while (i5 < obj.h) {
                gVar.append(next);
                i5++;
            }
            if (i7 != i13) {
                iterator = iterator.iterator();
                for (g next2 : iterator) {
                    gVar = new g(next2.a(), i11 += i7, i9 += i7);
                    set2.add(gVar);
                }
            }
            i4 = i5;
        }
        return i4;
    }

    net.time4j.g1.z.i s(net.time4j.g1.z.c<?> c) {
        net.time4j.g1.z.b bVar;
        Object bVar2;
        a aVar;
        bVar = c.p();
        if (this.d != null) {
            a.b bVar3 = new a.b();
            bVar3.f(bVar.e());
            bVar3.f(this.d.e());
            bVar = bVar.l(bVar3.a());
        }
        final net.time4j.g1.z.b bVar6 = bVar;
        super(this.a.quickPath(c, bVar6, this.f), this.b, this.c, this.d, bVar6, this.f, this.g, this.h, this.i, this.j);
        return iVar;
    }

    net.time4j.g1.z.i t(int i) {
        super(this.a, this.b, this.c, this.d, 0, i2 + i, this.g, this.h, this.i, this.j);
        return iVar2;
    }

    public String toString() {
        net.time4j.g1.z.b bVar;
        boolean str;
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

    net.time4j.g1.z.i v() {
        if (this.i) {
        } else {
            super(this.a, this.b, this.c, this.d, 0, this.f, this.g, this.h, 1, -1);
            return iVar;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Cannot start or-block twice.");
        throw illegalStateException;
    }

    net.time4j.g1.z.i x(p<?> p) {
        final net.time4j.g1.z.h hVar2 = i.w(this.a, p);
        if (this.a == hVar2) {
            return this;
        }
        super(hVar2, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j);
        return obj13;
    }
}
