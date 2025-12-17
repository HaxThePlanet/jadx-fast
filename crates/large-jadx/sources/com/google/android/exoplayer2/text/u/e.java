package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.b;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class e {

    private static final Pattern c;
    private static final Pattern d;
    private final d0 a;
    private final StringBuilder b;
    static {
        e.c = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");
        e.d = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");
    }

    public e() {
        super();
        d0 d0Var = new d0();
        this.a = d0Var;
        StringBuilder stringBuilder = new StringBuilder();
        this.b = stringBuilder;
    }

    private void a(com.google.android.exoplayer2.text.u.f f, String string2) {
        String substring2;
        int length;
        String substring;
        Object matcher;
        int indexOf;
        boolean matches;
        Object obj8;
        if ("".equals(string2)) {
        }
        int indexOf2 = string2.indexOf(91);
        substring = -1;
        final int i2 = 0;
        final int i3 = 1;
        matcher = e.c.matcher(string2.substring(indexOf2));
        if (indexOf2 != substring && matcher.matches()) {
            matcher = e.c.matcher(string2.substring(indexOf2));
            if (matcher.matches()) {
                matcher = matcher.group(i3);
                g.e(matcher);
                f.z((String)matcher);
            }
            obj8 = string2.substring(i2, indexOf2);
        }
        obj8 = p0.C0(obj8, "\\.");
        substring2 = obj8[i2];
        indexOf = substring2.indexOf(35);
        if (indexOf != substring) {
            f.y(substring2.substring(i2, indexOf));
            f.x(substring2.substring(indexOf += i3));
        } else {
            f.y(substring2);
        }
        if (obj8.length > i3) {
            f.w((String[])p0.t0(obj8, i3, obj8.length));
        }
    }

    private static boolean b(d0 d0) {
        int i2;
        char c;
        int i3;
        int i;
        int i5;
        int i4;
        i2 = d0.e();
        final byte[] bArr = d0.d();
        i = i2 + 1;
        i5 = 47;
        i2 = i + 1;
        i4 = 42;
        if (i2 + 2 <= d0.f() && bArr[i2] == i5 && bArr[i] == i4) {
            i = i2 + 1;
            i5 = 47;
            if (bArr[i2] == i5) {
                i2 = i + 1;
                i4 = 42;
                if (bArr[i] == i4) {
                }
            }
        }
        return 0;
    }

    private static boolean c(d0 d0) {
        int i;
        char c = e.k(d0, d0.e());
        if (c != 9 && c != 10 && c != 12 && c != 13 && c != 32) {
            if (c != 10) {
                if (c != 12) {
                    if (c != 13) {
                        if (c != 32) {
                            return 0;
                        }
                    }
                }
            }
        }
        int i3 = 1;
        d0.J(i3);
        return i3;
    }

    private static void e(String string, com.google.android.exoplayer2.text.u.f f2) {
        String equals;
        int i;
        int str;
        int obj5;
        Matcher matcher = e.d.matcher(b.c(string));
        if (!matcher.matches()) {
            StringBuilder stringBuilder = new StringBuilder(obj6 += 22);
            stringBuilder.append("Invalid font-size: '");
            stringBuilder.append(string);
            stringBuilder.append("'.");
            v.h("WebvttCssParser", stringBuilder.toString());
        }
        obj5 = 2;
        equals = matcher.group(obj5);
        g.e(equals);
        (String)equals.hashCode();
        i = -1;
        final int i3 = 1;
        switch (equals) {
            case "%":
                i = 0;
                break;
            case "em":
                i = i3;
                break;
            case "px":
                i = obj5;
                break;
            default:
        }
        switch (i) {
            case 0:
                f2.t(3);
                break;
            case 1:
                f2.t(obj5);
                break;
            case 2:
                f2.t(i3);
                break;
            default:
                obj5 = new IllegalStateException();
                throw obj5;
        }
        obj5 = matcher.group(i3);
        g.e(obj5);
        f2.s(Float.parseFloat((String)obj5));
    }

    private static String f(d0 d0, StringBuilder stringBuilder2) {
        int i2;
        int i;
        char c;
        int i3;
        stringBuilder2.setLength(0);
        i = d0.e();
        while (i < d0.f()) {
            if (i2 == 0) {
            }
            c = (char)b;
            if (c >= 65) {
            } else {
            }
            if (c >= 97) {
            } else {
            }
            if (c >= 48) {
            } else {
            }
            if (c != 35) {
            } else {
            }
            i++;
            stringBuilder2.append(c);
            if (c != 45) {
            } else {
            }
            if (c != 46) {
            } else {
            }
            if (c == 95) {
            } else {
            }
            i2 = 1;
            if (c > 57 && c != 35 && c != 45 && c != 46) {
            } else {
            }
            if (c > 122) {
            } else {
            }
            if (c > 90) {
            } else {
            }
        }
        d0.J(i -= i4);
        return stringBuilder2.toString();
    }

    static String g(d0 d0, StringBuilder stringBuilder2) {
        e.n(d0);
        if (d0.a() == 0) {
            return null;
        }
        String obj2 = e.f(d0, stringBuilder2);
        if (!"".equals(obj2)) {
            return obj2;
        }
        StringBuilder stringBuilder = new StringBuilder(1);
        stringBuilder.append((char)obj1);
        return stringBuilder.toString();
    }

    private static String h(d0 d0, StringBuilder stringBuilder2) {
        int i2;
        int i;
        String str;
        boolean equals;
        StringBuilder stringBuilder = new StringBuilder();
        i2 = 0;
        while (i2 == 0) {
            str = e.g(d0, stringBuilder2);
            if (!"}".equals(str)) {
            } else {
            }
            d0.I(d0.e());
            i2 = 1;
            if (";".equals(str)) {
            } else {
            }
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    private static String i(d0 d0, StringBuilder stringBuilder2) {
        int i;
        e.n(d0);
        int i4 = 5;
        final int i5 = 0;
        if (d0.a() < i4) {
            return i5;
        }
        if (!"::cue".equals(d0.u(i4))) {
            return i5;
        }
        String str4 = e.g(d0, stringBuilder2);
        if (str4 == null) {
            return i5;
        }
        if ("{".equals(str4)) {
            d0.I(d0.e());
            return "";
        }
        if ("(".equals(str4)) {
            i = e.l(d0);
        } else {
            i = i5;
        }
        if (!")".equals(e.g(d0, stringBuilder2))) {
            return i5;
        }
        return i;
    }

    private static void j(d0 d0, com.google.android.exoplayer2.text.u.f f2, StringBuilder stringBuilder3) {
        String equals2;
        String equals;
        boolean obj4;
        boolean obj6;
        e.n(d0);
        final String str = e.f(d0, stringBuilder3);
        equals2 = "";
        if (equals2.equals(str)) {
        }
        if (!":".equals(e.g(d0, stringBuilder3))) {
        }
        e.n(d0);
        String str3 = e.h(d0, stringBuilder3);
        if (str3 != null) {
            if (equals2.equals(str3)) {
            } else {
                obj6 = e.g(d0, stringBuilder3);
                if (";".equals(obj6)) {
                    if ("color".equals(str)) {
                        f2.q(k.b(str3));
                    } else {
                        if ("background-color".equals(str)) {
                            f2.n(k.b(str3));
                        } else {
                            obj6 = 1;
                            if ("ruby-position".equals(str)) {
                                if ("over".equals(str3)) {
                                    f2.v(obj6);
                                } else {
                                    if ("under".equals(str3)) {
                                        f2.v(2);
                                    }
                                }
                            } else {
                                if ("text-combine-upright".equals(str)) {
                                    if (!"all".equals(str3)) {
                                        if (str3.startsWith("digits")) {
                                        } else {
                                            obj6 = 0;
                                        }
                                    }
                                    f2.p(obj6);
                                } else {
                                    if ("text-decoration".equals(str)) {
                                        if ("underline".equals(str3)) {
                                            f2.A(obj6);
                                        }
                                    } else {
                                        if ("font-family".equals(str)) {
                                            f2.r(str3);
                                        } else {
                                            if ("font-weight".equals(str)) {
                                                if ("bold".equals(str3)) {
                                                    f2.o(obj6);
                                                }
                                            } else {
                                                if ("font-style".equals(str)) {
                                                    if ("italic".equals(str3)) {
                                                        f2.u(obj6);
                                                    }
                                                } else {
                                                    if ("font-size".equals(str)) {
                                                        e.e(str3, f2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    if ("}".equals(obj6)) {
                        d0.I(d0.e());
                    }
                }
            }
        }
    }

    private static char k(d0 d0, int i2) {
        return (char)obj0;
    }

    private static String l(d0 d0) {
        int i3;
        char c;
        int i2;
        int i;
        i3 = d0.e();
        final int i8 = 0;
        i2 = i8;
        while (i3 < d0.f()) {
            if (i2 == 0) {
            }
            if ((char)b == 41) {
            } else {
            }
            i2 = i8;
            i3 = i;
            i2 = c;
        }
        return d0.u(i4 -= i7).trim();
    }

    static void m(d0 d0) {
        while (TextUtils.isEmpty(d0.o())) {
        }
    }

    static void n(d0 d0) {
        boolean z;
        int i2;
        int i;
        while (/* condition */) {
            while (d0.a() > 0) {
                if (i2 != 0) {
                    break loop_2;
                }
                if (e.b(d0)) {
                    break loop_2;
                } else {
                }
                i2 = 0;
            }
            if (i2 != 0) {
            }
            if (!e.c(d0)) {
            } else {
            }
            i2 = i3;
            if (e.b(d0)) {
            } else {
            }
            i2 = 0;
        }
    }

    public List<com.google.android.exoplayer2.text.u.f> d(d0 d0) {
        int equals;
        int i;
        int i2;
        d0 fVar;
        byte[] bArr;
        String equals2;
        StringBuilder sb;
        final int i3 = 0;
        this.b.setLength(i3);
        e.m(d0);
        this.a.G(d0.d(), d0.e());
        this.a.I(d0.e());
        ArrayList obj7 = new ArrayList();
        String str = e.i(this.a, this.b);
        while (str != null) {
            fVar = new f();
            a(fVar, str);
            i = 0;
            bArr = i3;
            equals2 = "}";
            while (bArr == null) {
                String str4 = e.g(this.a, this.b);
                if (str4 != null) {
                } else {
                }
                equals2 = 1;
                if (equals2 == 0) {
                }
                i = str4;
                bArr = equals2;
                equals2 = "}";
                this.a.I(this.a.e());
                e.j(this.a, fVar, this.b);
                if (equals2.equals(str4)) {
                } else {
                }
                equals2 = i3;
            }
            if (equals2.equals(i) != 0) {
            }
            str = e.i(this.a, this.b);
            obj7.add(fVar);
            str4 = e.g(this.a, this.b);
            if (str4 != null) {
            } else {
            }
            equals2 = 1;
            if (equals2 == 0) {
            }
            i = str4;
            bArr = equals2;
            this.a.I(this.a.e());
            e.j(this.a, fVar, this.b);
            if (equals2.equals(str4)) {
            } else {
            }
            equals2 = i3;
        }
        return obj7;
    }
}
