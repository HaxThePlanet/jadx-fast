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

/* compiled from: LiteralProcessor.java */
/* loaded from: classes3.dex */
final class m implements h<Void> {

    private final char a;
    private final char b;
    private final String c;
    private final c<Character> v;
    private final boolean w;
    private final boolean x;
    private final boolean y;
    m(String str) {
        boolean z = true;
        int length;
        super();
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Missing literal.");
        } else {
            int i = 0;
            final char charAt = str.charAt(i);
            this.a = charAt;
            this.b = charAt;
            this.v = null;
            this.c = str;
            if (charAt < 32) {
                throw new IllegalArgumentException("Literal must not start with non-printable char.");
            } else {
                z = true;
                this.w = z;
                if (str.length() != z || !m.d(charAt)) {
                }
                this.x = z;
                this.y = false;
                return;
            }
        }
    }

    private static boolean a(char c, char c2) {
        char upperCase;
        char upperCase2;
        boolean z = false;
        char lowerCase2;
        if (c != c2) {
            if (Character.toUpperCase(c) != Character.toUpperCase(c2)) {
                if (Character.toLowerCase(c) == Character.toLowerCase(c2)) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z;
    }

    private static boolean d(char c) {
        boolean letter;
        boolean z2 = true;
        c = !Character.isLetter(c) && !Character.isDigit(c) && !m.c(c) ? 1 : 0;
        return (!Character.isLetter(c) && !Character.isDigit(c) && !m.c(c) ? 1 : 0);
    }

    private void e(java.lang.CharSequence charSequence, s sVar) {
        final int i = sVar.f();
        String str = "Cannot parse: \"";
        final StringBuilder stringBuilder = new StringBuilder(str);
        String str2 = "\" (expected: [";
        String str4 = "], found: [";
        java.lang.CharSequence subSequence = charSequence.subSequence(i, Math.min(this.c.length() + i, charSequence.length()));
        String str6 = "])";
        str7 = str + charSequence + str2 + this.c + str4 + subSequence + str6;
        sVar.k(i, str7);
    }

    private void f(java.lang.CharSequence charSequence, s sVar, d dVar, boolean z) {
        char charValue;
        char charAt;
        int i2 = 0;
        String name;
        Boolean tRUE2;
        boolean booleanValue;
        c cVar2;
        int i = sVar.f();
        charAt = '\0';
        if (this.v != null) {
            charValue = (Character)dVar.a(this.v, Character.valueOf(charAt)).charValue();
        }
        i2 = 1;
        if (i >= charSequence.length() || !(this.a == 0 && !Character.isDigit(this.a))) {
        }
        if (i2 != 0) {
            str2 = "Cannot parse: \"";
            StringBuilder stringBuilder = new StringBuilder(str2);
            stringBuilder.append(charSequence);
            stringBuilder.append("\" (expected: [");
            stringBuilder.append(charValue);
            stringBuilder.append("], found: [");
            if (this.v != 0) {
                stringBuilder.append(charAt);
            }
            stringBuilder.append("])");
            sVar.k(i, stringBuilder.toString());
        } else {
            i = i + i2;
            sVar.l(i);
        }
    }

    private void g(java.lang.CharSequence charSequence, s sVar, d dVar, boolean z) {
        boolean booleanValue;
        Boolean tRUE2;
        int i = sVar.f();
        if (z) {
        } else {
            booleanValue = (Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue();
        }
        if (z) {
        } else {
            z = b.q((Locale)dVar.a(a.c, Locale.ROOT));
        }
        int i2 = m.h(charSequence, i, this.c, booleanValue, z);
        if (i2 == -1) {
            e(charSequence, sVar);
        } else {
            i = i + i2;
            sVar.l(i);
        }
    }

    static int h(java.lang.CharSequence charSequence, int i, java.lang.CharSequence charSequence2, boolean z, boolean z2) {
        char charAt;
        char charAt2;
        int i3;
        int i4;
        final int length = charSequence.length();
        i = 0;
        while (i < charSequence2.length()) {
            charAt = charSequence2.charAt(i);
            if (!m.c(charAt)) {
            }
        }
        if (z2) {
            i5 = i + i;
            while (i5 < length) {
            }
        }
        return i;
    }

    int b() {
        int i = 0;
        boolean digit;
        i = 0;
        if (this.c == null) {
            return i;
        }
        while (i < this.c.length()) {
        }
        return i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z = true;
        String str;
        boolean equals;
        char c2;
        char c3;
        boolean z2;
        z = true;
        if (this == object) {
            return true;
        }
        final int i = 0;
        if (object instanceof m) {
            if (this.v != null) {
                return this.v.equals(object.v);
            }
            if (this.c == null) {
                if (object.c == null) {
                    if (this.a == object.a) {
                        if (this.b != object.b) {
                        }
                    }
                }
                return z;
            }
            if (this.c.equals(object.c)) {
                if (this.x != object.x) {
                }
            }
            return z;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String name;
        if (this.v != null) {
            name = this.v.name();
        } else {
            if (this.c == null) {
                name = "";
            }
        }
        return name.hashCode() ^ this.a;
    }

    public boolean isNumerical() {
        boolean z = false;
        z = false;
        if (this.c == null) {
            return false;
        }
        if (b() == this.c.length()) {
            int i2 = 1;
        }
        return z;
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        char c;
        boolean booleanValue;
        char c2;
        char charAt = 46;
        if (!z || !this.x) {
            if (this.c == null) {
                f(charSequence, sVar, dVar, z);
            } else {
                g(charSequence, sVar, dVar, z);
            }
        } else {
            int i2 = sVar.f();
            if (i2 < charSequence.length()) {
                if (charSequence.charAt(i2) == this.a) {
                    i = i2 + 1;
                    sVar.l(i);
                } else {
                    charAt = '.';
                    if (this.a == '.') {
                        if (!(Boolean)dVar.a(a.k, Boolean.TRUE).booleanValue()) {
                            e(charSequence, sVar);
                        }
                    }
                }
            }
        }
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.IOException {
        final int i = 1;
        if (this.v != null) {
            appendable.append((Character)dVar.a(this.v, null).charValue());
            return i;
        }
        if (this.c == null) {
            appendable.append(this.a);
            return i;
        }
        appendable.append(this.c);
        return this.c.length();
    }

    public h<Void> quickPath(c<?> cVar, d dVar, int i) {
        final boolean z = b.q((Locale)dVar.a(a.c, Locale.ROOT));
        dVar = this.x && !z ? 1 : 0;
        m cVar2 = new m(this.a, this.b, this.c, this.v, (Boolean)dVar.a(a.i, Boolean.TRUE).booleanValue(), (this.x && !z ? 1 : 0), z);
        return cVar2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(m.class.getName());
        stringBuilder.append("[literal=");
        if (this.v != null) {
            stringBuilder.append('{');
            stringBuilder.append(this.v);
            char c = '}';
            stringBuilder.append(c);
        } else {
            if (this.c != null) {
                stringBuilder.append(this.c);
            } else {
                stringBuilder.append(this.a);
                if (this.b != this.a) {
                    stringBuilder.append(", alternative=");
                    stringBuilder.append(this.b);
                }
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    m(char c, char c2) {
        super();
        this.a = c;
        this.b = c2;
        c cVar = null;
        this.v = cVar;
        this.c = cVar;
        char c3 = ' ';
        if (c < c3) {
            throw new IllegalArgumentException("Literal must not start with non-printable char.");
        } else {
            if (c2 >= c3) {
                if (Character.isDigit(c)) {
                    throw new IllegalArgumentException("Literal must not be a decimal digit.");
                } else {
                    if (!Character.isDigit(c2)) {
                        this.w = true;
                        boolean z = false;
                        this.x = z;
                        this.y = z;
                        return;
                    }
                }
            }
        }
    }

    m(c<Character> cVar) {
        super();
        Objects.requireNonNull(cVar, "Missing format attribute.");
        char c = '\0';
        this.a = c;
        this.b = c;
        this.v = cVar;
        this.c = null;
        this.w = true;
        this.x = c;
        this.y = c;
    }

    private m(char c, char c2, String str, c<Character> cVar, boolean z, boolean z2, boolean z3) {
        super();
        this.a = c;
        this.b = c2;
        this.c = str;
        this.v = cVar;
        this.w = z;
        this.x = z2;
        this.y = z3;
    }

    private static boolean c(char c) {
        int i = 8206;
        boolean z = false;
        i = 8206;
        if (c == 8206 || !(c == 8207 && c != 1564)) {
            int i3 = 1;
        }
        return z;
    }

    public p<Void> getElement() {
        return null;
    }

    public h<Void> withElement(p<Void> pVar) {
        return this;
    }
}
