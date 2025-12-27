package net.time4j.history;

import java.util.Objects;

/* compiled from: HistoricDate.java */
/* loaded from: classes3.dex */
public final class h implements Comparable<h> {

    private final j a;
    private final int b;
    private final int c;
    private final int v;
    h(j jVar, int i, int i2, int i3) {
        super();
        this.a = jVar;
        this.b = i;
        this.c = i2;
        this.v = i3;
    }

    public static h k(j jVar, int i, int i2, int i3) {
        return h.m(jVar, i, i2, i3, p.DUAL_DATING, o.d);
    }

    public static h m(j jVar, int i, int i2, int i3, p pVar, o oVar) {
        int standardYear;
        Objects.requireNonNull(jVar, "Missing historic era.");
        i = 1;
        if (i3 < i) {
            StringBuilder stringBuilder4 = new StringBuilder();
            String str5 = "Day of month out of range: ";
            String str9 = h.n(jVar, i, i2, i3);
            jVar = str5 + str9;
            throw new IllegalArgumentException(jVar);
        } else {
            int i5 = 31;
            if (i3 <= 31) {
                if (i2 < i) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str4 = "Month out of range: ";
                    String str8 = h.n(jVar, i, i2, i3);
                    jVar = str4 + str8;
                    throw new IllegalArgumentException(jVar);
                } else {
                    i5 = 12;
                    if (i2 <= 12) {
                        if (jVar == j.BYZANTINE) {
                            if (i < 0) {
                                StringBuilder stringBuilder2 = new StringBuilder();
                                String str3 = "Before creation of the world: ";
                                String str7 = h.n(jVar, i, i2, i3);
                                jVar = str3 + str7;
                                throw new IllegalArgumentException(jVar);
                            } else {
                                if (!pVar.equals(p.DUAL_DATING)) {
                                    if (pVar != p.AFTER_NEW_YEAR) {
                                        i = 0;
                                    }
                                    standardYear = oVar.f(jVar, i).standardYear(i, oVar, jVar, i, i2, i3);
                                }
                                return new h(jVar, standardYear, i2, i3);
                            }
                        }
                        if (i < i) {
                            StringBuilder stringBuilder = new StringBuilder();
                            String str2 = "Year of era must be positive: ";
                            String str6 = h.n(jVar, i, i2, i3);
                            jVar = str2 + str6;
                            throw new IllegalArgumentException(jVar);
                        }
                    }
                }
            }
        }
    }

    private static String n(j jVar, int i, int i2, int i3) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(jVar);
        char c2 = '-';
        stringBuilder.append(c2);
        String str2 = String.valueOf(i);
        i = str2.length() - 4;
        char c = '0';
        while (i > 0) {
            stringBuilder.append(c);
            i = i - 1;
            c = '0';
        }
        stringBuilder.append(str2);
        stringBuilder.append(c2);
        int i5 = 10;
        if (i2 < i5) {
            stringBuilder.append(c);
        }
        stringBuilder.append(i2);
        stringBuilder.append(c2);
        if (i3 < i5) {
            stringBuilder.append(c);
        }
        stringBuilder.append(i3);
        return stringBuilder.toString();
    }

    public int a(h hVar) {
        int i;
        int i2 = -1;
        int annoDomini = this.a.annoDomini(this.b);
        int annoDomini2 = hVar.a.annoDomini(hVar.b);
        i2 = -1;
        if (annoDomini < annoDomini2) {
            return -1;
        }
        i2 = 1;
        if (annoDomini > annoDomini2) {
            return i2;
        }
        i = f() - hVar.f();
        if (this.f() - hVar.f() == 0) {
            i = c() - hVar.c();
        }
        if (this.a >= 0) {
            int r2 = this.a > 0 ? i2 : 0;
        }
        return (this.a > 0 ? i2 : 0);
    }

    public int c() {
        return this.v;
    }

    public j e() {
        return this.a;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        net.time4j.history.j jVar;
        net.time4j.history.j jVar2;
        int i2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof h) {
            if (this.a == object.a) {
                if (this.b == object.b) {
                    if (this.c == object.c) {
                        if (this.v != object.v) {
                        }
                    }
                }
            }
            return z;
        }
        return false;
    }

    public int f() {
        return this.c;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i;
        i = (this.b * 1000) + (this.c * 32) + this.v;
        if (this.a != j.AD) {
            i = -(this.b * 1000 + this.c * 32 + this.v);
        }
        return i;
    }

    public int i() {
        return this.b;
    }

    public int j(o oVar) {
        return oVar.c(this);
    }

    @Override // java.lang.Object
    public String toString() {
        return h.n(this.a, this.b, this.c, this.v);
    }
}
