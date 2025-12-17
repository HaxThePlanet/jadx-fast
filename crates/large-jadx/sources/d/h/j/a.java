package d.h.j;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    static final d.h.j.e d;
    private static final String e;
    private static final String f;
    static final d.h.j.a g;
    static final d.h.j.a h;
    private final boolean a;
    private final int b;
    private final d.h.j.e c;

    public static final class a {

        private boolean a;
        private int b;
        private d.h.j.e c;
        public a() {
            super();
            c(a.e(Locale.getDefault()));
        }

        private static d.h.j.a b(boolean z) {
            d.h.j.a obj0;
            obj0 = z ? a.h : a.g;
            return obj0;
        }

        private void c(boolean z) {
            this.a = z;
            this.c = a.d;
            this.b = 2;
        }

        public d.h.j.a a() {
            int i2;
            int i;
            if (this.b == 2 && this.c == a.d) {
                if (this.c == a.d) {
                    return a.a.b(this.a);
                }
            }
            a aVar = new a(this.a, this.b, this.c);
            return aVar;
        }
    }

    private static class b {

        private static final byte[] f;
        private final java.lang.CharSequence a;
        private final boolean b;
        private final int c;
        private int d;
        private char e;
        static {
            int i;
            byte[] bArr;
            byte directionality;
            final int i2 = 1792;
            a.b.f = new byte[i2];
            i = 0;
            while (i < i2) {
                a.b.f[i] = Character.getDirectionality(i);
                i++;
            }
        }

        b(java.lang.CharSequence charSequence, boolean z2) {
            super();
            this.a = charSequence;
            this.b = z2;
            this.c = charSequence.length();
        }

        private static byte c(char c) {
            byte[] i;
            byte obj1;
            if (c < 1792) {
                obj1 = a.b.f[c];
            } else {
                obj1 = Character.getDirectionality(c);
            }
            return obj1;
        }

        private byte f() {
            char charAt;
            int i2;
            int i;
            charAt = this.d;
            i2 = 59;
            while (charAt > 0) {
                charAt--;
                this.d = i6;
                charAt = this.a.charAt(i6);
                this.e = charAt;
                charAt = this.d;
                i2 = 59;
            }
            this.d = this.d;
            this.e = i2;
            return 13;
        }

        private byte g() {
            int charAt;
            int i;
            int i2;
            charAt = this.d;
            while (charAt < this.c) {
                this.d = charAt + 1;
                charAt = this.a.charAt(charAt);
                this.e = charAt;
                if (charAt != 59) {
                }
                charAt = this.d;
            }
            return 12;
        }

        private byte h() {
            char charAt;
            int charAt2;
            int i;
            charAt = this.d;
            int i6 = 62;
            while (charAt > 0) {
                charAt--;
                this.d = i5;
                charAt = this.a.charAt(i5);
                this.e = charAt;
                if (charAt != 34 && charAt == 39) {
                }
                charAt2 = this.d;
                while (charAt2 > 0) {
                    charAt2--;
                    this.d = i7;
                    charAt2 = this.a.charAt(i7);
                    this.e = charAt2;
                    if (charAt2 != charAt) {
                    }
                    charAt2 = this.d;
                }
                charAt = this.d;
                i6 = 62;
                charAt2--;
                this.d = i7;
                charAt2 = this.a.charAt(i7);
                this.e = charAt2;
                if (charAt2 != charAt) {
                }
                if (charAt == 39) {
                }
            }
            this.d = this.d;
            this.e = i6;
            return 13;
        }

        private byte i() {
            char charAt;
            int charAt2;
            int i;
            int i2;
            int i7 = this.d;
            while (i7 < this.c) {
                this.d = i7 + 1;
                charAt = this.a.charAt(i7);
                this.e = charAt;
                if (charAt != 34 && charAt == 39) {
                }
                charAt2 = this.d;
                while (charAt2 < this.c) {
                    this.d = charAt2 + 1;
                    charAt2 = this.a.charAt(charAt2);
                    this.e = charAt2;
                    if (charAt2 != charAt) {
                    }
                    charAt2 = this.d;
                }
                i7 = this.d;
                this.d = charAt2 + 1;
                charAt2 = this.a.charAt(charAt2);
                this.e = charAt2;
                if (charAt2 != charAt) {
                }
                if (charAt == 39) {
                }
            }
            this.d = this.d;
            this.e = '<';
            return 13;
        }

        byte a() {
            byte b;
            boolean z;
            int i;
            char charAt = this.a.charAt(i4--);
            this.e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.d);
                this.d = i7 -= charCount;
                return Character.getDirectionality(codePointBefore);
            }
            this.d = i2--;
            b = a.b.c(this.e);
            if (this.b) {
                z = this.e;
                if (z == 62) {
                    b = h();
                } else {
                    if (z == 59) {
                        b = f();
                    }
                }
            }
            return b;
        }

        byte b() {
            byte b;
            boolean z;
            int i;
            char charAt = this.a.charAt(this.d);
            this.e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.a, this.d);
                this.d = i6 += charCount;
                return Character.getDirectionality(codePointAt);
            }
            this.d = i2++;
            b = a.b.c(this.e);
            if (this.b) {
                z = this.e;
                if (z == 60) {
                    b = i();
                } else {
                    if (z == 38) {
                        b = g();
                    }
                }
            }
            return b;
        }

        int d() {
            int i;
            int i3;
            int i2;
            byte b;
            int i4;
            final int i5 = 0;
            this.d = i5;
            final int i6 = -1;
            final int i7 = 1;
            i2 = i3;
            while (this.d < this.c) {
                b = b();
                i = i2;
                if (b != 9) {
                }
                i2--;
                i3 = i5;
                i2++;
                i3 = i7;
                i2++;
                i3 = i6;
            }
            if (i == 0) {
                return i5;
            }
            if (i3 != 0) {
                return i3;
            }
            while (this.d > 0) {
                i2++;
                i2--;
            }
            return i5;
        }

        int e() {
            int i4;
            int i;
            byte b;
            int i2;
            int i5;
            int i3;
            this.d = this.c;
            int i7 = 0;
            i4 = i7;
            while (/* condition */) {
                while (this.d > 0) {
                    b = a();
                    i2 = -1;
                    if (i == 0) {
                        break loop_2;
                    }
                    i5 = 1;
                    if (i == 0) {
                        break loop_2;
                    }
                    if (i == 0) {
                        break loop_2;
                    }
                    i4++;
                    i4--;
                }
                b = a();
                i2 = -1;
                if (i == 0) {
                }
                i = i4;
                i5 = 1;
                if (i == 0) {
                }
                if (i == 0) {
                }
                i4++;
                i4--;
            }
            return i7;
        }
    }
    static {
        final d.h.j.e eVar = f.c;
        a.d = eVar;
        a.e = Character.toString('\u200e');
        a.f = Character.toString('\u200f');
        final int i5 = 2;
        a aVar = new a(0, i5, eVar);
        a.g = aVar;
        a aVar2 = new a(1, i5, eVar);
        a.h = aVar2;
    }

    a(boolean z, int i2, d.h.j.e e3) {
        super();
        this.a = z;
        this.b = i2;
        this.c = e3;
    }

    private static int a(java.lang.CharSequence charSequence) {
        a.b bVar = new a.b(charSequence, 0);
        return bVar.d();
    }

    private static int b(java.lang.CharSequence charSequence) {
        a.b bVar = new a.b(charSequence, 0);
        return bVar.e();
    }

    public static d.h.j.a c() {
        a.a aVar = new a.a();
        return aVar.a();
    }

    static boolean e(Locale locale) {
        int i;
        if (g.b(locale) == 1) {
        } else {
            i = 0;
        }
        return i;
    }

    private String f(java.lang.CharSequence charSequence, d.h.j.e e2) {
        boolean z;
        int i;
        java.lang.CharSequence obj3;
        boolean obj4;
        obj4 = e2.a(charSequence, 0, charSequence.length());
        if (!this.a && obj4 == null && a.b(charSequence) == 1) {
            if (obj4 == null) {
                if (a.b(charSequence) == 1) {
                }
            }
            return a.e;
        }
        if (this.a && obj4 != null && a.b(charSequence) == -1) {
            if (obj4 != null) {
                if (a.b(charSequence) == -1) {
                }
            }
            return a.f;
        }
        return "";
    }

    private String g(java.lang.CharSequence charSequence, d.h.j.e e2) {
        boolean z;
        int i;
        java.lang.CharSequence obj3;
        boolean obj4;
        obj4 = e2.a(charSequence, 0, charSequence.length());
        if (!this.a && obj4 == null && a.a(charSequence) == 1) {
            if (obj4 == null) {
                if (a.a(charSequence) == 1) {
                }
            }
            return a.e;
        }
        if (this.a && obj4 != null && a.a(charSequence) == -1) {
            if (obj4 != null) {
                if (a.a(charSequence) == -1) {
                }
            }
            return a.f;
        }
        return "";
    }

    public boolean d() {
        int i;
        i = i2 &= 2 != 0 ? 1 : 0;
        return i;
    }

    public java.lang.CharSequence h(java.lang.CharSequence charSequence) {
        return i(charSequence, this.c, true);
    }

    public java.lang.CharSequence i(java.lang.CharSequence charSequence, d.h.j.e e2, boolean z3) {
        d.h.j.e eVar;
        boolean z;
        int z2;
        int i;
        Object obj3;
        d.h.j.e obj4;
        if (charSequence == null) {
            return null;
        }
        obj4 = e2.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z3) {
            if (z3) {
                eVar = obj4 != null ? f.b : f.a;
                spannableStringBuilder.append(g(charSequence, eVar));
            }
        }
        if (obj4 != this.a) {
            i = obj4 != null ? 8235 : 8234;
            spannableStringBuilder.append(i);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append('\u202c');
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z3) {
            obj4 = obj4 != null ? f.b : f.a;
            spannableStringBuilder.append(f(charSequence, obj4));
        }
        return spannableStringBuilder;
    }

    public String j(String string) {
        return k(string, this.c, true);
    }

    public String k(String string, d.h.j.e e2, boolean z3) {
        if (string == null) {
            return null;
        }
        return i(string, e2, z3).toString();
    }
}
