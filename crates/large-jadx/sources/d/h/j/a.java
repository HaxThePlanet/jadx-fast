package d.h.j;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* compiled from: BidiFormatter.java */
/* loaded from: classes.dex */
public final class a {

    static final e d;
    private static final String e;
    private static final String f;
    static final a g = new a();
    static final a h = new a();
    private final boolean a;
    private final int b;
    private final e c;

    public static final class a {

        private boolean a;
        private int b;
        private e c;
        public a() {
            super();
            c(a.e(Locale.getDefault()));
        }

        private static a b(boolean z) {
            d.h.j.a aVar;
            z = z ? a.h : a.g;
            return (z ? a.h : a.g);
        }

        private void c(boolean z) {
            this.a = z;
            this.c = a.d;
            this.b = 2;
        }

        public a a() {
            int i2 = 2;
            if (this.b == 2) {
                if (this.c == a.d) {
                    return a.a.b(this.a);
                }
            }
            return new a(this.a, this.b, this.c);
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
            int i = 0;
            final int i2 = 1792;
            a.b.f = new byte[i2];
            i = 0;
            while (i < i2) {
                a.b.f[i] = Character.getDirectionality(i);
                i = i + 1;
            }
        }

        b(java.lang.CharSequence charSequence, boolean z) {
            super();
            this.a = charSequence;
            this.b = z;
            this.c = charSequence.length();
        }

        private static byte c(char c) {
            byte directionality;
            if (c < '\u0700') {
                directionality = a.b.f[c];
            } else {
                directionality = Character.getDirectionality(c);
            }
            return directionality;
        }

        private byte f() {
            char c2 = 38;
            char c = ';';
            while (this.d > 0) {
                this.d--;
                char charAt = this.a.charAt(i5);
                this.e = charAt;
                c2 = '&';
                if (charAt == '&') {
                    return 12;
                }
            }
            this.d = this.d;
            this.e = c;
            return 13;
        }

        private byte g() {
            while (this.d < this.c) {
                this.d++;
                char charAt = this.a.charAt(this.d);
                this.e = charAt;
                if (charAt == ';') {
                    return 12;
                }
            }
            return 12;
        }

        private byte h() {
            java.lang.CharSequence charSequence;
            char c = 60;
            char c2 = '>';
            while (this.d > 0) {
                this.d--;
                char charAt = this.a.charAt(i6);
                this.e = charAt;
                if (this.d == c2) {
                    break;
                }
            }
            this.d = this.d;
            this.e = c2;
            return 13;
        }

        private byte i() {
            int i3;
            while (this.d < this.c) {
                this.d++;
                char charAt = this.a.charAt(this.d);
                this.e = charAt;
                if (charAt == 62) {
                    return 12;
                }
            }
            this.d = this.d;
            this.e = '<';
            return 13;
        }

        byte a() {
            byte b;
            char charAt = this.a.charAt(this.d - 1);
            this.e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.a, this.d);
                this.d -= charCount;
                return Character.getDirectionality(codePointBefore);
            }
            this.d--;
            b = a.b.c(this.e);
            if (this.b) {
                char c = '>';
                if (this.e == '>') {
                    b = h();
                } else {
                    c = ';';
                    if (this.e == ';') {
                        b = f();
                    }
                }
            }
            return b;
        }

        byte b() {
            byte b;
            char charAt = this.a.charAt(this.d);
            this.e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.a, this.d);
                this.d += charCount;
                return Character.getDirectionality(codePointAt);
            }
            this.d++;
            b = a.b.c(this.e);
            if (this.b) {
                char c = '<';
                if (this.e == '<') {
                    b = i();
                } else {
                    c = '&';
                    if (this.e == '&') {
                        b = g();
                    }
                }
            }
            return b;
        }

        int d() {
            int i;
            int i2 = 2;
            i = 0;
            this.d = i;
            i = -1;
            final byte b3 = (byte) 1;
            while (this.d < this.c) {
                byte b = b();
                if (i == 0) {
                    return i;
                }
                if (this.d != b3 && this.d != (byte) 2) {
                }
            }
            if (i == 0) {
                return i;
            }
            if (i != 0) {
                return i;
            }
            while (this.d > 0) {
                i = i + 1;
                if (i == i) {
                    return b3;
                }
                if (i == i) {
                    return i;
                }
            }
            return i;
        }

        int e() {
            int i;
            byte b;
            int i2 = -1;
            int i3;
            byte b2;
            this.d = this.c;
            i = 0;
            while (/* condition */) {
                while (this.d > 0) {
                    b = a();
                    i2 = -1;
                    if (i == 0) {
                        break loop_2;
                    }
                    i3 = 1;
                    if (i == 0) {
                        break loop_2;
                    }
                    b2 = (byte) 2;
                    b2 = (byte) 9;
                    if (this.d != (byte) 9) {
                    }
                }
                b = a();
                i2 = -1;
                if (i == 0) {
                    return i2;
                }
                i3 = 1;
                if (i == 0) {
                    return i3;
                }
                b2 = (byte) 2;
                b2 = (byte) 9;
                if (this.d != (byte) 9) {
                }
            }
            return i;
        }
    }
    static {
        a.d = f.c;
        a.e = Character.toString('\u200e');
        a.f = Character.toString('\u200f');
    }

    a(boolean z, int i, e eVar) {
        super();
        this.a = z;
        this.b = i;
        this.c = eVar;
    }

    private static int a(java.lang.CharSequence charSequence) {
        return new a.b(charSequence, false).d();
    }

    private static int b(java.lang.CharSequence charSequence) {
        return new a.b(charSequence, false).e();
    }

    public static a c() {
        return new a.a().a();
    }

    static boolean e(Locale locale) {
        boolean z = true;
        if (g.b(locale) != 1) {
            int i2 = 0;
        }
        return z;
    }

    private String f(java.lang.CharSequence charSequence, e eVar) {
        int i = 0;
        boolean z2 = eVar.a(charSequence, i, charSequence.length());
        if (!this.a) {
            return a.e;
        }
        if (this.a && z2) {
            if (a.b(charSequence) == -1) {
                return a.f;
            }
        }
        return "";
    }

    private String g(java.lang.CharSequence charSequence, e eVar) {
        int i = 0;
        boolean z2 = eVar.a(charSequence, i, charSequence.length());
        if (!this.a) {
            return a.e;
        }
        if (this.a && z2) {
            if (a.a(charSequence) == -1) {
                return a.f;
            }
        }
        return "";
    }

    public boolean d() {
        boolean z = true;
        int r0 = this.b & 2 != 0 ? 1 : 0;
        return (this.b & 2 != 0 ? 1 : 0);
    }

    public java.lang.CharSequence h(java.lang.CharSequence charSequence) {
        return i(charSequence, this.c, true);
    }

    public java.lang.CharSequence i(java.lang.CharSequence charSequence, e eVar, boolean z) {
        char c2 = 8234;
        d.h.j.e eVar3;
        if (charSequence == null) {
            return null;
        }
        boolean z2 = eVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z) {
            d.h.j.e r1 = z2 ? f.b : f.a;
            spannableStringBuilder.append((z2 ? f.b : f.a));
        }
        if (z2 != this.a) {
            r1 = z2 ? 8235 : 8234;
            spannableStringBuilder.append((z2 ? 8235 : 8234));
            spannableStringBuilder.append(charSequence);
            char c = '\u202c';
            spannableStringBuilder.append((z2 ? 8235 : 8234));
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z && z2) {
            eVar3 = f.b;
            spannableStringBuilder.append(f(charSequence, eVar3));
        }
        return spannableStringBuilder;
    }

    public String j(String str) {
        return k(str, this.c, true);
    }

    public String k(String str, e eVar, boolean z) {
        if (str == null) {
            return null;
        }
        return i(str, eVar, z).toString();
    }
}
