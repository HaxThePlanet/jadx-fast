package net.time4j.g1.z;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import net.time4j.engine.c;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.a;
import net.time4j.g1.b;

/* loaded from: classes3.dex */
final class m implements net.time4j.g1.z.h<Void> {

    private final char a;
    private final char b;
    private final String c;
    private final c<Character> v;
    private final boolean w;
    private final boolean x;
    private final boolean y;
    m(char c, char c2) {
        boolean obj2;
        super();
        this.a = c;
        this.b = c2;
        int i = 0;
        this.v = i;
        this.c = i;
        int i2 = 32;
        if (c < i2) {
        } else {
            if (c2 < i2) {
            } else {
                if (Character.isDigit(c)) {
                } else {
                    if (Character.isDigit(c2)) {
                    } else {
                        this.w = true;
                        obj2 = 0;
                        this.x = obj2;
                        this.y = obj2;
                    }
                }
                obj2 = new IllegalArgumentException("Literal must not be a decimal digit.");
                throw obj2;
            }
        }
        obj2 = new IllegalArgumentException("Literal must not start with non-printable char.");
        throw obj2;
    }

    private m(char c, char c2, String string3, c<Character> c4, boolean z5, boolean z6, boolean z7) {
        super();
        this.a = c;
        this.b = c2;
        this.c = string3;
        this.v = c4;
        this.w = z5;
        this.x = z6;
        this.y = z7;
    }

    m(String string) {
        int i;
        boolean obj4;
        super();
        if (string.isEmpty()) {
        } else {
            int i2 = 0;
            final char charAt = string.charAt(i2);
            this.a = charAt;
            this.b = charAt;
            this.v = 0;
            this.c = string;
            if (charAt < 32) {
            } else {
                i = 1;
                this.w = i;
                if (string.length() == i && m.d(charAt)) {
                    if (m.d(charAt)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
                this.x = i;
                this.y = i2;
            }
            obj4 = new IllegalArgumentException("Literal must not start with non-printable char.");
            throw obj4;
        }
        obj4 = new IllegalArgumentException("Missing literal.");
        throw obj4;
    }

    m(c<Character> c) {
        super();
        Objects.requireNonNull(c, "Missing format attribute.");
        int i = 0;
        this.a = i;
        this.b = i;
        this.v = c;
        this.c = 0;
        this.w = true;
        this.x = i;
        this.y = i;
    }

    private static boolean a(char c, char c2) {
        char upperCase;
        char upperCase2;
        char obj2;
        char obj3;
        if (c != c2 && Character.toUpperCase(c) != Character.toUpperCase(c2)) {
            if (Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    private static boolean c(char c) {
        int i;
        int obj1;
        if (c != 8206 && c != 8207) {
            if (c != 8207) {
                if (c == 1564) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static boolean d(char c) {
        boolean letter;
        int obj1;
        if (!Character.isLetter(c) && !Character.isDigit(c) && !m.c(c)) {
            if (!Character.isDigit(c)) {
                obj1 = !m.c(c) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    private void e(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2) {
        final int i = s2.f();
        StringBuilder stringBuilder = new StringBuilder("Cannot parse: \"");
        stringBuilder.append(charSequence);
        stringBuilder.append("\" (expected: [");
        stringBuilder.append(this.c);
        stringBuilder.append("], found: [");
        stringBuilder.append(charSequence.subSequence(i, Math.min(length += i, charSequence.length())));
        stringBuilder.append("])");
        s2.k(i, stringBuilder.toString());
    }

    private void f(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, boolean z4) {
        int i;
        char charValue;
        char charAt;
        int length;
        int i3;
        char c;
        c equals;
        int i2;
        Object tRUE;
        Object obj9;
        boolean obj11;
        c obj12;
        i = s2.f();
        charValue = this.a;
        c cVar = this.v;
        i3 = 0;
        if (cVar != null) {
            charValue = (Character)d3.a(cVar, Character.valueOf(i3)).charValue();
        }
        final int i4 = 1;
        if (i < charSequence.length() && charValue != 0) {
            if (charValue != 0) {
                if (Character.isDigit(charValue)) {
                    charAt = i3;
                    i3 = i4;
                } else {
                    charAt = charSequence.charAt(i);
                    c = this.b;
                    Locale rOOT = Locale.ROOT;
                    if (this.v != null && a.o.name().equals(this.v.name()) && rOOT.equals(d3.a(a.c, rOOT))) {
                        if (a.o.name().equals(this.v.name())) {
                            rOOT = Locale.ROOT;
                            if (rOOT.equals(d3.a(a.c, rOOT))) {
                                equals = 44;
                                if (charValue == equals) {
                                } else {
                                    c = charValue == 46 ? equals : charValue;
                                }
                            }
                        }
                    }
                    if (charAt != charValue && charAt != c) {
                        i2 = charAt != c ? i4 : i3;
                    } else {
                    }
                    if (i2 != 0) {
                        if (z4 != null) {
                            obj11 = this.w;
                        } else {
                            obj11 = (Boolean)d3.a(a.i, Boolean.TRUE).booleanValue();
                        }
                        if (obj11 != null) {
                            if (!m.a(charAt, charValue)) {
                                if (m.a(charAt, c)) {
                                } else {
                                    i3 = i2;
                                }
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (i3 != 0) {
            obj11 = new StringBuilder("Cannot parse: \"");
            obj11.append(charSequence);
            obj11.append("\" (expected: [");
            obj11.append(charValue);
            obj11.append("], found: [");
            if (charAt != 0) {
                obj11.append(charAt);
            }
            obj11.append("])");
            s2.k(i, obj11.toString());
        } else {
            s2.l(i += i4);
        }
    }

    private void g(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, boolean z4) {
        int i;
        boolean booleanValue;
        Boolean rOOT;
        boolean obj6;
        c obj7;
        i = s2.f();
        if (z4 != null) {
            booleanValue = this.w;
        } else {
            booleanValue = (Boolean)d3.a(a.i, Boolean.TRUE).booleanValue();
        }
        if (z4 != null) {
            obj6 = this.y;
        } else {
            obj6 = b.q((Locale)d3.a(a.c, Locale.ROOT));
        }
        obj6 = m.h(charSequence, i, this.c, booleanValue, obj6);
        if (obj6 == -1) {
            e(charSequence, s2);
        } else {
            s2.l(i += obj6);
        }
    }

    static int h(java.lang.CharSequence charSequence, int i2, java.lang.CharSequence charSequence3, boolean z4, boolean z5) {
        int i;
        int i4;
        char charAt;
        boolean charAt2;
        int i3;
        int i5;
        boolean obj11;
        final int length = charSequence.length();
        final int i6 = 0;
        i4 = i;
        while (i < charSequence3.length()) {
            charAt = charSequence3.charAt(i);
            if (z5) {
            } else {
            }
            int i7 = i4 + i2;
            if (i7 < length) {
            } else {
            }
            charAt2 = i6;
            i5 = -1;
            i4++;
            i++;
            charAt2 = charSequence.charAt(i7);
            charAt2 = i6;
            i3 = i4 + i2;
            while (i3 < length) {
                if (m.c(charSequence.charAt(i3))) {
                }
                i4++;
                i3 = i4 + i2;
            }
            if (m.c(charSequence.charAt(i3))) {
            }
            i4++;
        }
        if (z5) {
        }
        return i4;
    }

    @Override // net.time4j.g1.z.h
    int b() {
        int i;
        int i2;
        boolean digit;
        String str = this.c;
        i = 0;
        if (str == null) {
            return i;
        }
        i2 = i;
        while (i < str.length()) {
            if (Character.isDigit(this.c.charAt(i))) {
            }
            i2++;
            i++;
        }
        return i2;
    }

    @Override // net.time4j.g1.z.h
    public boolean equals(Object object) {
        int i;
        char str;
        boolean equals;
        char c;
        char obj5;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        c cVar = this.v;
        if (object instanceof m && cVar != null) {
            cVar = this.v;
            if (cVar != null) {
                return cVar.equals(object.v);
            }
            String str2 = this.c;
            if (str2 == null) {
                if (object.c == null && this.a == object.a && this.b == object.b) {
                    if (this.a == object.a) {
                        if (this.b == object.b) {
                        } else {
                            i = i2;
                        }
                    } else {
                    }
                } else {
                }
                return i;
            }
            if (str2.equals(object.c) && this.x == object.x) {
                if (this.x == object.x) {
                } else {
                    i = i2;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public p<Void> getElement() {
        return 0;
    }

    @Override // net.time4j.g1.z.h
    public int hashCode() {
        String name;
        c cVar = this.v;
        if (cVar == null) {
            if (this.c == null) {
                name = "";
            }
        } else {
            name = cVar.name();
        }
        return i ^= c;
    }

    @Override // net.time4j.g1.z.h
    public boolean isNumerical() {
        int i;
        if (this.c == null) {
            return 0;
        }
        if (b() == this.c.length()) {
            i = 1;
        }
        return i;
    }

    public void parse(java.lang.CharSequence charSequence, net.time4j.g1.z.s s2, d d3, net.time4j.g1.z.t<?> t4, boolean z5) {
        char c;
        d obj4;
        int obj5;
        char obj6;
        if (z5 && this.x) {
            if (this.x) {
                obj5 = s2.f();
                if (obj5 < charSequence.length() && charSequence.charAt(obj5) == this.a) {
                    if (charSequence.charAt(obj5) == this.a) {
                        s2.l(obj5++);
                    } else {
                        if (this.a == 46) {
                            if (!(Boolean)d3.a(a.k, Boolean.TRUE).booleanValue()) {
                                e(charSequence, s2);
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
                if (this.c == null) {
                    f(charSequence, s2, d3, z5);
                } else {
                    g(charSequence, s2, d3, z5);
                }
            }
        } else {
        }
    }

    public int print(o o, java.lang.Appendable appendable2, d d3, Set<net.time4j.g1.z.g> set4, boolean z5) {
        c obj1 = this.v;
        final int obj4 = 1;
        if (obj1 != null) {
            appendable2.append((Character)d3.a(obj1, 0).charValue());
            return obj4;
        }
        obj1 = this.c;
        if (obj1 == null) {
            appendable2.append(this.a);
            return obj4;
        }
        appendable2.append(obj1);
        return this.c.length();
    }

    public net.time4j.g1.z.h<Void> quickPath(net.time4j.g1.z.c<?> c, d d2, int i3) {
        int obj10;
        final boolean z = b.q((Locale)d2.a(a.c, Locale.ROOT));
        if (this.x && !z) {
            obj10 = !z ? 1 : 0;
        } else {
        }
        super(this.a, this.b, this.c, this.v, (Boolean)d2.a(a.i, Boolean.TRUE).booleanValue(), obj10, z);
        return obj9;
    }

    @Override // net.time4j.g1.z.h
    public String toString() {
        int i;
        char c;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m.class.getName());
        stringBuilder.append("[literal=");
        if (this.v != null) {
            stringBuilder.append('{');
            stringBuilder.append(this.v);
            stringBuilder.append('}');
        } else {
            i = this.c;
            if (i == null) {
                stringBuilder.append(this.a);
                if (this.b != this.a) {
                    stringBuilder.append(", alternative=");
                    stringBuilder.append(this.b);
                }
            } else {
                stringBuilder.append(i);
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public net.time4j.g1.z.h<Void> withElement(p<Void> p) {
        return this;
    }
}
