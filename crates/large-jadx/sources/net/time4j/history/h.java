package net.time4j.history;

import java.util.Objects;

/* loaded from: classes3.dex */
public final class h implements Comparable<net.time4j.history.h> {

    private final net.time4j.history.j a;
    private final int b;
    private final int c;
    private final int v;
    h(net.time4j.history.j j, int i2, int i3, int i4) {
        super();
        this.a = j;
        this.b = i2;
        this.c = i3;
        this.v = i4;
    }

    public static net.time4j.history.h k(net.time4j.history.j j, int i2, int i3, int i4) {
        return h.m(j, i2, i3, i4, p.DUAL_DATING, o.d);
    }

    public static net.time4j.history.h m(net.time4j.history.j j, int i2, int i3, int i4, net.time4j.history.p p5, net.time4j.history.o o6) {
        int i9;
        net.time4j.history.j bYZANTINE;
        boolean aFTER_NEW_YEAR;
        int i6;
        net.time4j.history.n nVar;
        int i8;
        net.time4j.history.o oVar;
        Object obj;
        int i;
        int i5;
        int i7;
        int obj10;
        Objects.requireNonNull(j, "Missing historic era.");
        i9 = 1;
        if (i4 < i9) {
        } else {
            if (i4 > 31) {
            } else {
                if (i3 < i9) {
                } else {
                    if (i3 > 12) {
                    } else {
                        if (j == j.BYZANTINE) {
                            if (i2 < 0) {
                            } else {
                                if (i2 == 0) {
                                    if (i3 < 9) {
                                    } else {
                                    }
                                }
                                if (!p5.equals(p.DUAL_DATING)) {
                                    if (p5 == p.AFTER_NEW_YEAR) {
                                    } else {
                                        i9 = 0;
                                    }
                                    obj10 = o6.f(j, i2).standardYear(i9, o6, j, i2, i3, i4);
                                }
                                h obj13 = new h(j, obj10, i3, i4);
                                return obj13;
                            }
                            StringBuilder obj14 = new StringBuilder();
                            obj14.append("Before creation of the world: ");
                            obj14.append(h.n(j, i2, i3, i4));
                            obj13 = new IllegalArgumentException(obj14.toString());
                            throw obj13;
                        }
                        if (i2 < i9) {
                        } else {
                        }
                        obj14 = new StringBuilder();
                        obj14.append("Year of era must be positive: ");
                        obj14.append(h.n(j, i2, i3, i4));
                        obj13 = new IllegalArgumentException(obj14.toString());
                        throw obj13;
                    }
                }
                obj14 = new StringBuilder();
                obj14.append("Month out of range: ");
                obj14.append(h.n(j, i2, i3, i4));
                obj13 = new IllegalArgumentException(obj14.toString());
                throw obj13;
            }
        }
        obj14 = new StringBuilder();
        obj14.append("Day of month out of range: ");
        obj14.append(h.n(j, i2, i3, i4));
        obj13 = new IllegalArgumentException(obj14.toString());
        throw obj13;
    }

    private static String n(net.time4j.history.j j, int i2, int i3, int i4) {
        int i;
        int i5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(j);
        int obj3 = 45;
        stringBuilder.append(obj3);
        String obj4 = String.valueOf(i2);
        i = length - 4;
        i5 = 48;
        while (i > 0) {
            stringBuilder.append(i5);
            i--;
            i5 = 48;
        }
        stringBuilder.append(obj4);
        stringBuilder.append(obj3);
        obj4 = 10;
        if (i3 < obj4) {
            stringBuilder.append(i5);
        }
        stringBuilder.append(i3);
        stringBuilder.append(obj3);
        if (i4 < obj4) {
            stringBuilder.append(i5);
        }
        stringBuilder.append(i4);
        return stringBuilder.toString();
    }

    @Override // java.lang.Comparable
    public int a(net.time4j.history.h h) {
        int i;
        int i2;
        Object obj5;
        int annoDomini = this.a.annoDomini(this.b);
        int annoDomini2 = h.a.annoDomini(h.b);
        if (annoDomini < annoDomini2) {
            return -1;
        }
        final int i8 = 1;
        if (annoDomini > annoDomini2) {
            return i8;
        }
        if (i3 -= i6 == 0) {
            i4 -= obj5;
        }
        if (i < 0) {
        } else {
            i2 = i > 0 ? i8 : 0;
        }
        return i2;
    }

    @Override // java.lang.Comparable
    public int c() {
        return this.v;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object object) {
        return a((h)object);
    }

    @Override // java.lang.Comparable
    public net.time4j.history.j e() {
        return this.a;
    }

    @Override // java.lang.Comparable
    public boolean equals(Object object) {
        int i;
        net.time4j.history.j jVar;
        net.time4j.history.j jVar2;
        Object obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object instanceof h) {
            if (this.a == object.a && this.b == object.b && this.c == object.c && this.v == object.v) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v == object.v) {
                        } else {
                            i = i2;
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

    @Override // java.lang.Comparable
    public int f() {
        return this.c;
    }

    @Override // java.lang.Comparable
    public int hashCode() {
        int i;
        if (this.a == j.AD) {
        } else {
            i = -i;
        }
        return i;
    }

    @Override // java.lang.Comparable
    public int i() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public int j(net.time4j.history.o o) {
        return o.c(this);
    }

    @Override // java.lang.Comparable
    public String toString() {
        return h.n(this.a, this.b, this.c, this.v);
    }
}
