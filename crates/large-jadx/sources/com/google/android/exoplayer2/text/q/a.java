package com.google.android.exoplayer2.text.q;

import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.b;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class a extends d {

    private static final Pattern s;
    private final boolean n = true;
    private final com.google.android.exoplayer2.text.q.b o = null;
    private Map<String, com.google.android.exoplayer2.text.q.c> p;
    private float q = -340282350000000000000000000000000000000f;
    private float r = -340282350000000000000000000000000000000f;
    static {
        a.s = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)[:.](\\d+)");
    }

    public a(List<byte[]> list) {
        int d0Var;
        boolean empty;
        boolean startsWith;
        int obj4;
        super("SsaDecoder");
        int i = -8388609;
        d0Var = 0;
        if (list != null && !list.isEmpty()) {
            if (!list.isEmpty()) {
                String str2 = p0.A((byte[])list.get(d0Var));
                g.a(str2.startsWith("Format:"));
                com.google.android.exoplayer2.text.q.b bVar = b.a(str2);
                g.e(bVar);
                this.o = (b)bVar;
                d0Var = new d0((byte[])list.get(1));
                H(d0Var);
            } else {
                this.n = d0Var;
                obj4 = 0;
            }
        } else {
        }
    }

    private static int C(long l, List<Long> list2, List<List<c>> list3) {
        int i;
        int i2;
        int cmp;
        Object obj4;
        size--;
        while (i >= 0) {
            i--;
        }
        i2 = 0;
        list3.add(i2, Long.valueOf(l));
        if (i2 == 0) {
            ArrayList obj3 = new ArrayList();
        } else {
            super((Collection)obj6.get(i2 + -1));
        }
        obj6.add(i2, obj3);
        return i2;
    }

    private static float D(int i) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return -8388609;
                }
                return 1064514355;
            }
            return 1056964608;
        }
        return 1028443341;
    }

    private static c E(String string, com.google.android.exoplayer2.text.q.c c2, com.google.android.exoplayer2.text.q.c.b c$b3, float f4, float f5) {
        int cmp;
        boolean strikethroughSpan;
        Object foregroundColorSpan;
        float f;
        boolean styleSpan;
        boolean underlineSpan;
        int i;
        int length;
        int i2;
        int obj8;
        SpannableString spannableString = new SpannableString(string);
        c.b obj7 = new c.b();
        obj7.o(spannableString);
        final int i3 = -8388609;
        final int i4 = 0;
        i = 33;
        if (c2 != null && c2.c != null) {
            i = 33;
            if (c2.c != null) {
                foregroundColorSpan = new ForegroundColorSpan(c2.c.intValue());
                spannableString.setSpan(foregroundColorSpan, i4, spannableString.length(), i);
            }
            f = c2.d;
            i2 = 1;
            if (Float.compare(f, i3) != 0 && Float.compare(f5, i3) != 0) {
                if (Float.compare(f5, i3) != 0) {
                    obj7.q(f /= f5, i2);
                }
            }
            boolean z = c2.e;
            if (z && c2.f) {
                if (c2.f) {
                    styleSpan = new StyleSpan(3);
                    spannableString.setSpan(styleSpan, i4, spannableString.length(), i);
                } else {
                    if (z) {
                        styleSpan = new StyleSpan(i2);
                        spannableString.setSpan(styleSpan, i4, spannableString.length(), i);
                    } else {
                        if (c2.f) {
                            styleSpan = new StyleSpan(2);
                            spannableString.setSpan(styleSpan, i4, spannableString.length(), i);
                        }
                    }
                }
            } else {
            }
            if (c2.g) {
                underlineSpan = new UnderlineSpan();
                spannableString.setSpan(underlineSpan, i4, spannableString.length(), i);
            }
            if (c2.h) {
                strikethroughSpan = new StrikethroughSpan();
                spannableString.setSpan(strikethroughSpan, i4, spannableString.length(), i);
            }
        }
        int i5 = -1;
        if (b3.a != i5) {
        } else {
            cmp = c2 != null ? c2.b : i5;
        }
        obj7.p(a.N(cmp));
        obj7.l(a.M(cmp));
        obj7.i(a.L(cmp));
        obj8 = b3.b;
        if (obj8 != null && Float.compare(f5, i3) != 0 && Float.compare(f4, i3) != 0) {
            if (Float.compare(f5, i3) != 0) {
                if (Float.compare(f4, i3) != 0) {
                    obj7.k(obj8 /= f4);
                    obj7.h(obj8 /= f5, i4);
                } else {
                    obj7.k(a.D(obj7.d()));
                    obj7.h(a.D(obj7.c()), i4);
                }
            } else {
            }
        } else {
        }
        return obj7.a();
    }

    private void F(String string, com.google.android.exoplayer2.text.q.b b2, List<List<c>> list3, List<Long> list4) {
        com.google.android.exoplayer2.text.q.c.b bVar;
        String trim;
        int cmp;
        String obj11;
        int obj12;
        g.a(string.startsWith("Dialogue:"));
        String[] split = string.substring(9).split(",", b2.e);
        int i4 = b2.e;
        trim = "SsaDecoder";
        if (split.length != i4) {
            obj12 = "Skipping dialogue line with fewer columns than format: ";
            obj11 = String.valueOf(string);
            if (obj11.length() != 0) {
                obj11 = obj12.concat(obj11);
            } else {
                obj11 = new String(obj12);
            }
            v.h(trim, obj11);
        }
        long l = a.K(split[b2.a]);
        long l2 = -9223372036854775807L;
        final String str11 = "Skipping invalid timing: ";
        if (Long.compare(l, l2) == 0) {
            obj11 = String.valueOf(string);
            if (obj11.length() != 0) {
                obj11 = str11.concat(obj11);
            } else {
                obj11 = new String(str11);
            }
            v.h(trim, obj11);
        }
        final long l3 = a.K(split[b2.b]);
        if (Long.compare(l3, l2) == 0) {
            obj11 = String.valueOf(string);
            if (obj11.length() != 0) {
                obj11 = str11.concat(obj11);
            } else {
                obj11 = new String(str11);
            }
            v.h(trim, obj11);
        }
        obj11 = this.p;
        trim = b2.c;
        if (obj11 != null && trim != -1) {
            trim = b2.c;
            if (trim != -1) {
                obj11 = obj11.get(split[trim].trim());
            } else {
                obj11 = 0;
            }
        } else {
        }
        obj12 = split[b2.d];
        String str8 = "\n";
        obj12 = a.C(l, i4, list4);
        while (obj12 < a.C(l3, obj9, list4)) {
            (List)list3.get(obj12).add(a.E(c.b.d(obj12).replace("\\N", str8).replace("\\n", str8).replace("\\h", " "), obj11, c.b.b(obj12), this.q, this.r));
            obj12++;
        }
    }

    private void G(d0 d0, List<List<c>> list2, List<Long> list3) {
        int i;
        String string;
        boolean startsWith;
        int length;
        i = this.n ? this.o : 0;
        string = d0.o();
        while (string != null) {
            if (string.startsWith("Format:")) {
            } else {
            }
            if (string.startsWith("Dialogue:")) {
            }
            string = d0.o();
            if (i == 0) {
            } else {
            }
            F(string, i, list2, list3);
            String str3 = "Skipping dialogue line before complete format: ";
            String valueOf = String.valueOf(string);
            if (valueOf.length() != 0) {
            } else {
            }
            string = new String(str3);
            v.h("SsaDecoder", string);
            string = str3.concat(valueOf);
            i = b.a(string);
        }
    }

    private void H(d0 d0) {
        boolean equalsIgnoreCase2;
        String equalsIgnoreCase;
        equalsIgnoreCase2 = d0.o();
        while (equalsIgnoreCase2 != null) {
            if ("[Script Info]".equalsIgnoreCase(equalsIgnoreCase2)) {
            } else {
            }
            if ("[V4+ Styles]".equalsIgnoreCase(equalsIgnoreCase2)) {
            } else {
            }
            if ("[V4 Styles]".equalsIgnoreCase(equalsIgnoreCase2)) {
            } else {
            }
            if (!"[Events]".equalsIgnoreCase(equalsIgnoreCase2)) {
            }
            equalsIgnoreCase2 = d0.o();
            v.f("SsaDecoder", "[V4 Styles] are not supported");
            this.p = a.J(d0);
            I(d0);
        }
    }

    private void I(d0 d0) {
        String[] split;
        boolean length;
        String equals;
        int i;
        String str = d0.o();
        while (str != null) {
            if (d0.a() != 0) {
            } else {
            }
            split = str.split(":");
            if (split.length != 2) {
            } else {
            }
            length = b.c(split[0].trim());
            length.hashCode();
            i = 1;
            if (!length.equals("playresx")) {
            } else {
            }
            this.q = Float.parseFloat(split[i].trim());
            str = d0.o();
            if (!length.equals("playresy")) {
            } else {
            }
            this.r = Float.parseFloat(split[i].trim());
            if (d0.h() != 91) {
            }
        }
    }

    private static Map<String, com.google.android.exoplayer2.text.q.c> J(d0 d0) {
        int i;
        Object concat;
        boolean startsWith;
        int length;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        i = 0;
        concat = d0.o();
        while (concat != null) {
            if (d0.a() != 0) {
            } else {
            }
            if (concat.startsWith("Format:")) {
            } else {
            }
            if (concat.startsWith("Style:")) {
            }
            concat = d0.o();
            if (i == 0) {
            } else {
            }
            concat = c.b(concat, i);
            if (concat != null) {
            }
            linkedHashMap.put(concat.a, concat);
            String str3 = "Skipping 'Style:' line before 'Format:' line: ";
            String valueOf = String.valueOf(concat);
            if (valueOf.length() != 0) {
            } else {
            }
            concat = new String(str3);
            v.h("SsaDecoder", concat);
            concat = str3.concat(valueOf);
            i = c.a.a(concat);
            if (d0.h() != 91) {
            }
        }
        return linkedHashMap;
    }

    private static long K(String string) {
        Matcher obj8 = a.s.matcher(string.trim());
        if (!obj8.matches()) {
            return -9223372036854775807L;
        }
        String group = obj8.group(1);
        p0.i(group);
        int i8 = 60;
        int i13 = 1000000;
        String group3 = obj8.group(2);
        p0.i(group3);
        String group2 = obj8.group(3);
        p0.i(group2);
        obj8 = obj8.group(4);
        p0.i(obj8);
        return i6 += i12;
    }

    private static int L(int i) {
        final int i2 = Integer.MIN_VALUE;
        switch (i) {
            case -1:
                return i2;
            case 0:
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown alignment: ");
                stringBuilder.append(i);
                v.h("SsaDecoder", stringBuilder.toString());
                return i2;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                return 0;
        }
    }

    private static int M(int i) {
        final int i2 = Integer.MIN_VALUE;
        switch (i) {
            case -1:
                return i2;
            case 0:
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown alignment: ");
                stringBuilder.append(i);
                v.h("SsaDecoder", stringBuilder.toString());
                return i2;
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return 2;
        }
    }

    private static Layout.Alignment N(int i) {
        final int i2 = 0;
        switch (i) {
            case -1:
                return i2;
            case 0:
                StringBuilder stringBuilder = new StringBuilder(30);
                stringBuilder.append("Unknown alignment: ");
                stringBuilder.append(i);
                v.h("SsaDecoder", stringBuilder.toString());
                return i2;
            case 1:
                return Layout.Alignment.ALIGN_NORMAL;
            case 2:
                return Layout.Alignment.ALIGN_CENTER;
            default:
                return Layout.Alignment.ALIGN_OPPOSITE;
        }
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        ArrayList obj5 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        d0 d0Var = new d0(bArr, i2);
        if (!this.n) {
            H(d0Var);
        }
        G(d0Var, obj5, arrayList);
        d obj3 = new d(obj5, arrayList);
        return obj3;
    }
}
