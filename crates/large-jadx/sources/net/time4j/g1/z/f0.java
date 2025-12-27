package net.time4j.g1.z;

import java.util.Set;
import net.time4j.engine.d;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.engine.w;
import net.time4j.f1.c;
import net.time4j.g1.a;
import net.time4j.g1.g;

/* compiled from: TwoDigitYearProcessor.java */
/* loaded from: classes3.dex */
final class f0 implements h<Integer> {

    private final p<Integer> a;
    private final int b;
    private final char c;
    private final g v;
    private final int w;
    private final int x;
    f0(p<Integer> pVar) {
        super();
        if (!pVar.name().startsWith("YEAR")) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str2 = "Year element required: ";
            pVar = str2 + pVar;
            throw new IllegalArgumentException(pVar);
        } else {
            this.a = pVar;
            int i2 = 0;
            this.b = i2;
            this.c = '0';
            this.v = g.SMART;
            this.w = i2;
            this.x = 100;
            return;
        }
    }

    private int a(boolean z, d dVar) {
        int value;
        if (z) {
        } else {
            value = (Integer)dVar.a(a.q, Integer.valueOf(this.x)).intValue();
        }
        if (this.x < 100) {
            StringBuilder stringBuilder = new StringBuilder();
            final String str = "Pivot year must not be smaller than 100: ";
            z = str + value;
            throw new IllegalArgumentException(z);
        } else {
            return value;
        }
    }

    private static int b(int i, int i2) {
        int i3;
        i3 = i >= i2 % 100 ? i7 - 1 : i2 / 100;
        return (i3 * 100) + i;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof f0) {
            return this.a.equals(object.a);
        }
        return false;
    }

    public p<Integer> getElement() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }

    public void parse(java.lang.CharSequence charSequence, s sVar, d dVar, t<?> tVar, boolean z) {
        int length;
        int value;
        int i;
        Object obj;
        int min = 2;
        int i2 = 1;
        char charValue;
        int i4;
        int i5;
        i = sVar.f();
        i2 = 0;
        if (z) {
        } else {
            value = (Integer)dVar.a(a.s, null).intValue();
        }
        if (this.w > 0) {
            length = charSequence.length() - value;
        }
        if (i >= length) {
            StringBuilder stringBuilder = new StringBuilder();
            String str5 = "Missing digits for: ";
            String name = this.a.name();
            str2 = str5 + name;
            sVar.k(i, str2);
            sVar.n();
            return;
        }
        if (z) {
        } else {
            obj = dVar.a(a.f, g.SMART);
        }
        min = 9;
        int r4 = obj.isStrict() ? 2 : min;
        if (z) {
        } else {
            charValue = (Character)dVar.a(a.m, '0').charValue();
        }
        if (this.b > 0 && this.w <= 0) {
            while (this.w < length) {
                i4 = charSequence.charAt(i) - charValue;
            }
            i3 = i2 - this.b;
            min = Math.min(min, i3);
        }
        int i7 = i + 2;
        i2 = 1;
        while (this.b < Math.min(length, min + i)) {
            i5 = charSequence.charAt(i) - charValue;
            if (i5 >= 0 && i5 <= min) {
            }
        }
        if (this.b < this.w) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str6 = "Not enough digits found for: ";
            String name2 = this.a.name();
            str3 = str6 + name2;
            sVar.k(i, str3);
            return;
        }
        if (this.b == this.w) {
            i2 = f0.b(i2, a(z, dVar));
        }
        tVar.J(this.a, i2);
        sVar.l(i);
    }

    public int print(o oVar, java.lang.Appendable appendable, d dVar, Set<g> set, boolean z) throws java.io.UnsupportedEncodingException, java.io.IOException {
        int i;
        int length;
        Character str;
        int z52;
        Object obj;
        char charValue;
        i = oVar.e(this.a);
        if (i < 0 && i == -2147483648) {
            StringBuilder stringBuilder2 = new StringBuilder();
            final String str3 = "Format context has no year: ";
            oVar = str3 + oVar;
            throw new IllegalArgumentException(oVar);
        }
        int i2 = 100;
        if (a(z, dVar) != i2) {
            i = c.c(i, i2);
        }
        char c = '0';
        if (z) {
        } else {
            charValue = (Character)dVar.a(a.m, Character.valueOf(c)).charValue();
        }
        z52 = 0;
        if (this.c != c) {
            char[] charArray = Integer.toString(i).toCharArray();
            length2 = charArray.length;
            while (z52 < charArray.length) {
                c2 = (char)(charArray[z52] + (charValue - 48));
                charArray[z52] = c2;
                z52 = z52 + 1;
                length2 = charArray.length;
            }
        }
        length = -1;
        if (appendable instanceof CharSequence) {
            length = (CharSequence)appendable.length();
        } else {
        }
        if (this.a < 10) {
            appendable.append(charValue);
            z52 = 1;
        }
        appendable.append(obj);
        z52 += length3;
        if (length != length && a.m > 0 && set != null) {
            set.add(new g(this.a, length, length + i9));
        }
        return i9;
    }

    public h<Integer> quickPath(c<?> cVar, d dVar, int i) {
        f0 f0Var = new f0(this.a, i, (Character)dVar.a(a.m, '0').charValue(), (g)dVar.a(a.f, g.SMART), (Integer)dVar.a(a.s, null).intValue(), (Integer)dVar.a(a.q, Integer.valueOf(cVar.q().d())).intValue());
        return f0Var;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        String name = f0.class.getName();
        String str2 = "[element=";
        String name2 = this.a.name();
        str = 64 + name + str2 + name2 + 93;
        return str;
    }

    public h<Integer> withElement(p<Integer> pVar) {
        if (this.a == pVar) {
            return this;
        }
        return new f0(pVar);
    }

    private f0(p<Integer> pVar, int i, char c, g gVar, int i2, int i3) {
        super();
        this.a = pVar;
        this.b = i;
        this.c = c;
        this.v = gVar;
        this.w = i2;
        this.x = i3;
    }


    public boolean isNumerical() {
        return true;
    }
}
