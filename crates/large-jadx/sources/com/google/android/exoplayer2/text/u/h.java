package com.google.android.exoplayer2.text.u;

import android.accounts.Account;
import android.graphics.Color;
import android.text.Layout.Alignment;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.p.a;
import com.google.android.exoplayer2.text.p.c;
import com.google.android.exoplayer2.text.p.d;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.googlecode.mp4parser.boxes.microsoft.XtraBox;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class h {

    public static final Pattern a;
    private static final Pattern b;
    private static final Map<String, Integer> c;
    private static final Map<String, Integer> d;

    static class a {
    }

    private static class b {

        private static final Comparator<com.google.android.exoplayer2.text.u.h.b> c;
        private final com.google.android.exoplayer2.text.u.h.c a;
        private final int b;
        static {
            h.b.c = a.a;
        }

        private b(com.google.android.exoplayer2.text.u.h.c h$c, int i2) {
            super();
            this.a = c;
            this.b = i2;
        }

        b(com.google.android.exoplayer2.text.u.h.c h$c, int i2, com.google.android.exoplayer2.text.u.h.a h$a3) {
            super(c, i2);
        }

        static Comparator a() {
            return h.b.c;
        }

        static com.google.android.exoplayer2.text.u.h.c b(com.google.android.exoplayer2.text.u.h.b h$b) {
            return b.a;
        }

        static int c(com.google.android.exoplayer2.text.u.h.b h$b) {
            return b.b;
        }

        static int d(com.google.android.exoplayer2.text.u.h.b h$b, com.google.android.exoplayer2.text.u.h.b h$b2) {
            return Integer.compare(obj0.b, obj1.b);
        }
    }

    private static final class c {

        public final String a;
        public final int b;
        public final String c;
        public final Set<String> d;
        private c(String string, int i2, String string3, Set<String> set4) {
            super();
            this.b = i2;
            this.a = string;
            this.c = string3;
            this.d = set4;
        }

        public static com.google.android.exoplayer2.text.u.h.c a(String string, int i2) {
            String str;
            int i;
            int trim;
            String str2;
            String obj5;
            obj5 = string.trim();
            g.a(empty ^= i);
            int indexOf = obj5.indexOf(" ");
            int i4 = 0;
            if (indexOf == -1) {
                str = "";
            } else {
                obj5 = obj5.substring(i4, indexOf);
                str = trim;
            }
            obj5 = p0.C0(obj5, "\\.");
            HashSet hashSet = new HashSet();
            for (Object str2 : string) {
                hashSet.add(str2);
            }
            obj5 = new h.c(obj5[i4], i2, str, hashSet);
            return obj5;
        }

        public static com.google.android.exoplayer2.text.u.h.c b() {
            final String str = "";
            h.c cVar = new h.c(str, 0, str, Collections.emptySet());
            return cVar;
        }
    }

    private static final class d implements Comparable<com.google.android.exoplayer2.text.u.h.d> {

        public final int a;
        public final com.google.android.exoplayer2.text.u.f b;
        public d(int i, com.google.android.exoplayer2.text.u.f f2) {
            super();
            this.a = i;
            this.b = f2;
        }

        @Override // java.lang.Comparable
        public int a(com.google.android.exoplayer2.text.u.h.d h$d) {
            return Integer.compare(this.a, d.a);
        }

        @Override // java.lang.Comparable
        public int compareTo(Object object) {
            return a((h.d)object);
        }
    }

    private static final class e {

        public long a = 0;
        public long b = 0;
        public java.lang.CharSequence c;
        public int d = 2;
        public float e = -340282350000000000000000000000000000000f;
        public int f = 1;
        public int g = 0;
        public float h = -340282350000000000000000000000000000000f;
        public int i = Integer.MIN_VALUE;
        public float j = 1f;
        public int k = Integer.MIN_VALUE;
        public e() {
            super();
            int i = 0;
            int i2 = 2;
            int i3 = -8388609;
            int i5 = 1;
            int i6 = 0;
            int i4 = Integer.MIN_VALUE;
            int i7 = 1065353216;
        }

        private static float b(float f, int i2) {
            int cmp;
            final int i = -8388609;
            final int cmp2 = Float.compare(f, i);
            final int i3 = 1065353216;
            if (cmp2 != 0 && i2 == 0 && Float.compare(f, i4) >= 0 && Float.compare(f, i3) > 0) {
                if (i2 == 0) {
                    if (Float.compare(f, i4) >= 0) {
                        if (Float.compare(f, i3) > 0) {
                        }
                    }
                    return i3;
                }
            }
            if (cmp2 != 0) {
                return f;
            }
            if (i2 == 0) {
                return i3;
            }
            return i;
        }

        private static Layout.Alignment c(int i) {
            int i2;
            int i3;
            if (i != 1 && i != 2 && i != 3 && i != 4 && i != 5) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                StringBuilder stringBuilder = new StringBuilder(34);
                                stringBuilder.append("Unknown textAlignment: ");
                                stringBuilder.append(i);
                                v.h("WebvttCueParser", stringBuilder.toString());
                                return null;
                            }
                        }
                    }
                    return Layout.Alignment.ALIGN_OPPOSITE;
                }
                return Layout.Alignment.ALIGN_CENTER;
            }
            return Layout.Alignment.ALIGN_NORMAL;
        }

        private static float d(int i, float f2) {
            int i2 = 1065353216;
            if (i != 0 && i != 1) {
                if (i != 1) {
                    if (i != 2) {
                    } else {
                        return f2;
                    }
                    IllegalStateException obj3 = new IllegalStateException(String.valueOf(i));
                    throw obj3;
                }
                int i8 = 1073741824;
                if (Float.compare(f2, obj2) <= 0) {
                    return f2 *= i8;
                }
                return i4 *= i8;
            }
            return i2 -= f2;
        }

        private static float e(int i) {
            if (i != 4 && i != 5) {
                if (i != 5) {
                    return 1056964608;
                }
                return 1065353216;
            }
            return 0;
        }

        private static int f(int i) {
            int i2;
            int i3;
            final int i4 = 1;
            if (i != i4 && i != 3 && i != 4 && i != 5) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return i4;
                        }
                    }
                }
                return 2;
            }
            return 0;
        }

        public com.google.android.exoplayer2.text.u.g a() {
            super(g().a(), this.a, obj3, this.b, obj5);
            return gVar2;
        }

        public c.b g() {
            float f;
            int i;
            if (Float.compare(f, i4) != 0) {
            } else {
                f = h.e.e(this.d);
            }
            if (this.i != Integer.MIN_VALUE) {
            } else {
                i = h.e.f(this.d);
            }
            c.b bVar = new c.b();
            bVar.p(h.e.c(this.d));
            bVar.h(h.e.b(this.e, this.f), this.f);
            bVar.i(this.g);
            bVar.k(f);
            bVar.l(i);
            bVar.n(Math.min(this.j, h.e.d(i, f)));
            bVar.r(this.k);
            java.lang.CharSequence charSequence = this.c;
            if (charSequence != null) {
                bVar.o(charSequence);
            }
            return bVar;
        }
    }
    static {
        h.a = Pattern.compile("^(\\S+)\\s+-->\\s+(\\S+)(.*)?$");
        h.b = Pattern.compile("(\\S+?):(\\S+)");
        HashMap hashMap = new HashMap();
        int i = 255;
        hashMap.put("white", Integer.valueOf(Color.rgb(i, i, i)));
        int i5 = 0;
        hashMap.put("lime", Integer.valueOf(Color.rgb(i5, i, i5)));
        hashMap.put("cyan", Integer.valueOf(Color.rgb(i5, i, i)));
        hashMap.put("red", Integer.valueOf(Color.rgb(i, i5, i5)));
        hashMap.put("yellow", Integer.valueOf(Color.rgb(i, i, i5)));
        hashMap.put("magenta", Integer.valueOf(Color.rgb(i, i5, i)));
        hashMap.put("blue", Integer.valueOf(Color.rgb(i5, i5, i)));
        hashMap.put("black", Integer.valueOf(Color.rgb(i5, i5, i5)));
        h.c = Collections.unmodifiableMap(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bg_white", Integer.valueOf(Color.rgb(i, i, i)));
        hashMap2.put("bg_lime", Integer.valueOf(Color.rgb(i5, i, i5)));
        hashMap2.put("bg_cyan", Integer.valueOf(Color.rgb(i5, i, i)));
        hashMap2.put("bg_red", Integer.valueOf(Color.rgb(i, i5, i5)));
        hashMap2.put("bg_yellow", Integer.valueOf(Color.rgb(i, i, i5)));
        hashMap2.put("bg_magenta", Integer.valueOf(Color.rgb(i, i5, i)));
        hashMap2.put("bg_blue", Integer.valueOf(Color.rgb(i5, i5, i)));
        hashMap2.put("bg_black", Integer.valueOf(Color.rgb(i5, i5, i5)));
        h.d = Collections.unmodifiableMap(hashMap2);
    }

    private static void a(SpannableStringBuilder spannableStringBuilder, Set<String> set2, int i3, int i4) {
        int intValue;
        Object foregroundColorSpan;
        boolean key;
        int i;
        final Iterator obj5 = set2.iterator();
        while (obj5.hasNext()) {
            intValue = obj5.next();
            Map map = h.c;
            i = 33;
            if (map.containsKey((String)intValue)) {
            } else {
            }
            foregroundColorSpan = h.d;
            if (foregroundColorSpan.containsKey(intValue)) {
            }
            foregroundColorSpan = new BackgroundColorSpan((Integer)foregroundColorSpan.get(intValue).intValue());
            spannableStringBuilder.setSpan(foregroundColorSpan, i3, i4, i);
            foregroundColorSpan = new ForegroundColorSpan((Integer)map.get(intValue).intValue());
            spannableStringBuilder.setSpan(foregroundColorSpan, i3, i4, i);
        }
    }

    private static void b(String string, SpannableStringBuilder spannableStringBuilder2) {
        boolean stringBuilder;
        int i;
        int obj2;
        String obj3;
        string.hashCode();
        i = -1;
        switch (string) {
            case "gt":
                i = 0;
                break;
            case "lt":
                i = 1;
                break;
            case "amp":
                i = 2;
                break;
            case "nbsp":
                i = 3;
                break;
            default:
        }
        switch (i) {
            case 0:
                spannableStringBuilder2.append('>');
                break;
            case 1:
                spannableStringBuilder2.append('<');
                break;
            case 2:
                spannableStringBuilder2.append('&');
                break;
            case 3:
                spannableStringBuilder2.append(' ');
                break;
            default:
                stringBuilder = new StringBuilder(obj3 += 33);
                stringBuilder.append("ignoring unsupported entity: '&");
                stringBuilder.append(string);
                stringBuilder.append(";'");
                v.h("WebvttCueParser", stringBuilder.toString());
        }
    }

    private static void c(SpannableStringBuilder spannableStringBuilder, String string2, com.google.android.exoplayer2.text.u.h.c h$c3, List<com.google.android.exoplayer2.text.u.h.b> list4, List<com.google.android.exoplayer2.text.u.f> list5) {
        int i2;
        boolean cVar;
        String str;
        int i;
        java.lang.CharSequence subSequence;
        String string;
        int obj10;
        int obj11;
        ArrayList arrayList = new ArrayList(list4.size());
        arrayList.addAll(list4);
        Collections.sort(arrayList, h.b.a());
        obj10 = c3.b;
        i2 = obj11;
        while (obj11 < arrayList.size()) {
            if (!"rt".equals(cVar2.a)) {
            } else {
            }
            Object obj2 = arrayList.get(obj11);
            i9 -= i2;
            i4 -= i2;
            subSequence = spannableStringBuilder.subSequence(i, i5);
            spannableStringBuilder.delete(i, i5);
            cVar = new c(subSequence.toString(), h.g(h.i(list5, string2, h.b.b((h.b)obj2)), h.i(list5, string2, c3), 1));
            spannableStringBuilder.setSpan(cVar, obj10, i, 33);
            i2 += obj10;
            obj10 = i;
            obj11++;
        }
    }

    private static void d(String string, com.google.android.exoplayer2.text.u.h.c h$c2, List<com.google.android.exoplayer2.text.u.h.b> list3, SpannableStringBuilder spannableStringBuilder4, List<com.google.android.exoplayer2.text.u.f> list5) {
        boolean equals;
        String str;
        int i2;
        int i;
        Object obj9;
        Object obj10;
        final int i3 = c2.b;
        equals = c2.a;
        equals.hashCode();
        final int i5 = 2;
        final int i6 = 1;
        i = -1;
        switch (equals) {
            case "":
                i = i2;
                break;
            case "b":
                i = i6;
                break;
            case "c":
                i = i5;
                break;
            case "i":
                i = 3;
                break;
            case "u":
                i = 4;
                break;
            case "v":
                i = 5;
                break;
            case "lang":
                i = 6;
                break;
            case "ruby":
                i = 7;
                break;
            default:
        }
        int i4 = 33;
        switch (i) {
            case 0:
                final List obj8 = h.h(list5, string, c2);
                break;
            case 1:
                obj10 = new StyleSpan(i6);
                spannableStringBuilder4.setSpan(obj10, i3, length, i4);
                obj8 = h.h(list5, string, c2);
                break;
            case 2:
                h.a(spannableStringBuilder4, c2.d, i3, length);
                obj8 = h.h(list5, string, c2);
                break;
            case 3:
                obj10 = new StyleSpan(i5);
                spannableStringBuilder4.setSpan(obj10, i3, length, i4);
                obj8 = h.h(list5, string, c2);
                break;
            case 4:
                obj10 = new UnderlineSpan();
                spannableStringBuilder4.setSpan(obj10, i3, length, i4);
                obj8 = h.h(list5, string, c2);
                break;
            case 5:
                h.c(spannableStringBuilder4, string, c2, list3, list5);
                obj8 = h.h(list5, string, c2);
                break;
            default:
        }
        while (i2 < obj8.size()) {
            h.e(spannableStringBuilder4, obj9.b, i3, length);
            i2++;
        }
    }

    private static void e(SpannableStringBuilder spannableStringBuilder, com.google.android.exoplayer2.text.u.f f2, int i3, int i4) {
        int styleSpan;
        boolean strikethroughSpan;
        boolean underlineSpan;
        boolean foregroundColorSpan;
        boolean backgroundColorSpan;
        Object typefaceSpan;
        AbsoluteSizeSpan absoluteSizeSpan;
        int i;
        int i2;
        int i5;
        boolean obj5;
        if (f2 == null) {
        }
        final int i7 = 33;
        if (f2.i() != -1) {
            styleSpan = new StyleSpan(f2.i());
            d.a(spannableStringBuilder, styleSpan, i3, i4, i7);
        }
        if (f2.l()) {
            strikethroughSpan = new StrikethroughSpan();
            spannableStringBuilder.setSpan(strikethroughSpan, i3, i4, i7);
        }
        if (f2.m()) {
            underlineSpan = new UnderlineSpan();
            spannableStringBuilder.setSpan(underlineSpan, i3, i4, i7);
        }
        if (f2.k()) {
            foregroundColorSpan = new ForegroundColorSpan(f2.c());
            d.a(spannableStringBuilder, foregroundColorSpan, i3, i4, i7);
        }
        if (f2.j()) {
            backgroundColorSpan = new BackgroundColorSpan(f2.a());
            d.a(spannableStringBuilder, backgroundColorSpan, i3, i4, i7);
        }
        if (f2.d() != null) {
            typefaceSpan = new TypefaceSpan(f2.d());
            d.a(spannableStringBuilder, typefaceSpan, i3, i4, i7);
        }
        absoluteSizeSpan = f2.f();
        i2 = 1;
        if (absoluteSizeSpan != i2) {
            if (absoluteSizeSpan != 2) {
                if (absoluteSizeSpan != 3) {
                } else {
                    absoluteSizeSpan = new RelativeSizeSpan(f /= i5);
                    d.a(spannableStringBuilder, absoluteSizeSpan, i3, i4, i7);
                }
            } else {
                absoluteSizeSpan = new RelativeSizeSpan(f2.e());
                d.a(spannableStringBuilder, absoluteSizeSpan, i3, i4, i7);
            }
        } else {
            absoluteSizeSpan = new AbsoluteSizeSpan((int)f3, i2);
            d.a(spannableStringBuilder, absoluteSizeSpan, i3, i4, i7);
        }
        if (f2.b()) {
            obj5 = new a();
            spannableStringBuilder.setSpan(obj5, i3, i4, i7);
        }
    }

    private static int f(String string, int i2) {
        int obj1;
        final int obj2 = string.indexOf(62, i2);
        if (obj2 == -1) {
            obj1 = string.length();
        } else {
            obj1 = obj2 + 1;
        }
        return obj1;
    }

    private static int g(int i, int i2, int i3) {
        final int i4 = -1;
        if (i != i4) {
            return i;
        }
        if (i2 != i4) {
            return i2;
        }
        if (i3 == i4) {
        } else {
            return i3;
        }
        IllegalArgumentException obj1 = new IllegalArgumentException();
        throw obj1;
    }

    private static List<com.google.android.exoplayer2.text.u.h.d> h(List<com.google.android.exoplayer2.text.u.f> list, String string2, com.google.android.exoplayer2.text.u.h.c h$c3) {
        int i2;
        Object obj;
        int i;
        Set dVar;
        String str;
        ArrayList arrayList = new ArrayList();
        i2 = 0;
        while (i2 < list.size()) {
            obj = list.get(i2);
            i = (f)obj.h(string2, c3.a, c3.d, c3.c);
            if (i > 0) {
            }
            i2++;
            dVar = new h.d(i, obj);
            arrayList.add(dVar);
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    private static int i(List<com.google.android.exoplayer2.text.u.f> list, String string2, com.google.android.exoplayer2.text.u.h.c h$c3) {
        int i;
        int i2;
        int obj3;
        com.google.android.exoplayer2.text.u.h.c obj4;
        List obj2 = h.h(list, string2, c3);
        obj3 = 0;
        i = -1;
        while (obj3 < obj2.size()) {
            obj4 = obj4.b;
            obj3++;
            i = -1;
        }
        return i;
    }

    private static String j(String string) {
        String obj1 = string.trim();
        g.a(empty ^= 1);
        return p0.D0(obj1, "[ \\.]")[0];
    }

    private static boolean k(String string) {
        String str;
        int i;
        boolean obj4;
        string.hashCode();
        final int i2 = 1;
        final int i3 = 0;
        i = -1;
        switch (string) {
            case "b":
                i = i3;
                break;
            case "c":
                i = i2;
                break;
            case "i":
                i = 2;
                break;
            case "u":
                i = 3;
                break;
            case "v":
                i = 4;
                break;
            case "rt":
                i = 5;
                break;
            case "lang":
                i = 6;
                break;
            case "ruby":
                i = 7;
                break;
            default:
        }
        if (/* condition */) {
            return i2;
        }
        return i3;
    }

    static c l(java.lang.CharSequence charSequence) {
        h.e eVar = new h.e();
        eVar.c = charSequence;
        return eVar.g().a();
    }

    public static com.google.android.exoplayer2.text.u.g m(d0 d0, List<com.google.android.exoplayer2.text.u.f> list2) {
        String str = d0.o();
        final int i = 0;
        if (str == null) {
            return i;
        }
        Pattern pattern = h.a;
        Matcher matcher2 = pattern.matcher(str);
        if (matcher2.matches()) {
            return h.n(i, matcher2, d0, list2);
        }
        String str2 = d0.o();
        if (str2 == null) {
            return i;
        }
        Matcher matcher = pattern.matcher(str2);
        if (matcher.matches()) {
            return h.n(str.trim(), matcher, d0, list2);
        }
        return i;
    }

    private static com.google.android.exoplayer2.text.u.g n(String string, Matcher matcher2, d0 d03, List<com.google.android.exoplayer2.text.u.f> list4) {
        String str;
        int length;
        h.e eVar = new h.e();
        String group = matcher2.group(1);
        g.e(group);
        eVar.a = j.d((String)group);
        String group2 = matcher2.group(2);
        g.e(group2);
        eVar.b = j.d((String)group2);
        String obj4 = matcher2.group(3);
        g.e(obj4);
        h.p((String)obj4, eVar);
        obj4 = new StringBuilder();
        str = d03.o();
        while (!TextUtils.isEmpty(str)) {
            if (obj4.length() > 0) {
            }
            obj4.append(str.trim());
            str = d03.o();
            obj4.append("\n");
        }
        eVar.c = h.q(string, obj4.toString(), list4);
        return eVar.a();
    }

    static c.b o(String string) {
        h.e eVar = new h.e();
        h.p(string, eVar);
        return eVar.g();
    }

    private static void p(String string, com.google.android.exoplayer2.text.u.h.e h$e2) {
        String str;
        Pattern string2;
        String string3;
        int length;
        StringBuilder stringBuilder;
        final Matcher obj5 = h.b.matcher(string);
        while (obj5.find()) {
            string2 = obj5.group(1);
            g.e(string2);
            string3 = obj5.group(2);
            g.e(string3);
            if ("line".equals((String)string2)) {
            } else {
            }
            if ("align".equals(string2)) {
            } else {
            }
            if ("position".equals(string2)) {
            } else {
            }
            if ("size".equals(string2)) {
            } else {
            }
            if ("vertical".equals(string2)) {
            } else {
            }
            stringBuilder = new StringBuilder(i3 += length3);
            stringBuilder.append("Unknown cue setting ");
            stringBuilder.append(string2);
            stringBuilder.append(":");
            stringBuilder.append(string3);
            v.h("WebvttCueParser", stringBuilder.toString());
            e2.k = h.w(string3);
            e2.j = j.c(string3);
            h.u(string3, e2);
            e2.d = h.v(string3);
            h.s(string3, e2);
        }
    }

    static SpannedString q(String string, String string2, List<com.google.android.exoplayer2.text.u.f> list3) {
        int substring;
        String substring2;
        int charAt2;
        int indexOf;
        int indexOf2;
        String empty;
        int i;
        boolean z;
        char charAt;
        String obj12;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        substring = i2;
        while (substring < string2.length()) {
            charAt2 = string2.charAt(substring);
            if (charAt2 != 38) {
            } else {
            }
            substring++;
            indexOf = string2.indexOf(59, substring);
            indexOf2 = string2.indexOf(32, substring);
            empty = -1;
            if (indexOf == empty) {
            } else {
            }
            if (indexOf2 == empty) {
            } else {
            }
            indexOf = Math.min(indexOf, indexOf2);
            if (indexOf != empty) {
            } else {
            }
            spannableStringBuilder.append(charAt2);
            h.b(string2.substring(substring, indexOf), spannableStringBuilder);
            if (indexOf == indexOf2) {
            }
            substring = indexOf;
            spannableStringBuilder.append(" ");
            indexOf = indexOf2;
            if (charAt2 != 60) {
            } else {
            }
            charAt2 = substring + 1;
            if (charAt2 >= string2.length()) {
            } else {
            }
            int i6 = 47;
            i = 1;
            if (string2.charAt(charAt2) == i6) {
            } else {
            }
            indexOf = i2;
            charAt2 = h.f(string2, charAt2);
            if (string2.charAt(charAt2 + -2) == i6) {
            } else {
            }
            indexOf2 = i2;
            if (indexOf != 0) {
            }
            if (indexOf2 != 0) {
            } else {
            }
            z = charAt2 + -1;
            substring = string2.substring(substring += i, z);
            if (substring.trim().isEmpty()) {
            } else {
            }
            empty = h.j(substring);
            if (h.k(empty)) {
            }
            if (indexOf != 0) {
            } else {
            }
            if (indexOf2 == 0) {
            }
            substring = charAt2;
            arrayDeque.push(h.c.a(substring, spannableStringBuilder.length()));
            while (arrayDeque.isEmpty() != 0) {
                Object obj = arrayDeque.pop();
                h.d(string, (h.c)obj, arrayList, spannableStringBuilder, list3);
                if (!arrayDeque.isEmpty()) {
                } else {
                }
                arrayList.clear();
                indexOf = new h.b(obj, spannableStringBuilder.length(), 0);
                arrayList.add(indexOf);
            }
            obj = arrayDeque.pop();
            h.d(string, (h.c)obj, arrayList, spannableStringBuilder, list3);
            if (!arrayDeque.isEmpty()) {
            } else {
            }
            arrayList.clear();
            if (obj.a.equals(empty) != 0) {
            } else {
            }
            indexOf = new h.b(obj, spannableStringBuilder.length(), 0);
            arrayList.add(indexOf);
            i = 2;
            indexOf2 = i;
            indexOf = i;
            spannableStringBuilder.append(charAt2);
            substring++;
        }
        while (!arrayDeque.isEmpty()) {
            h.d(string, (h.c)arrayDeque.pop(), arrayList, spannableStringBuilder, list3);
        }
        h.d(string, h.c.b(), Collections.emptyList(), spannableStringBuilder, list3);
        return SpannedString.valueOf(spannableStringBuilder);
    }

    private static int r(String string) {
        boolean equals;
        int i;
        String obj5;
        string.hashCode();
        int i2 = 2;
        final int i3 = 1;
        final int i4 = 0;
        i = -1;
        switch (string) {
            case "center":
                i = i4;
                break;
            case "middle":
                i = i3;
                break;
            case "end":
                i = i2;
                break;
            case "start":
                i = 3;
                break;
            default:
        }
        switch (i) {
            case 0:
                return i3;
            case 1:
                return i2;
            case 2:
                return i4;
            default:
                String str2 = "Invalid anchor value: ";
                obj5 = String.valueOf(string);
                obj5 = str2.concat(obj5);
                obj5 = new String(str2);
        }
        v.h("WebvttCueParser", obj5);
        return Integer.MIN_VALUE;
    }

    private static void s(String string, com.google.android.exoplayer2.text.u.h.e h$e2) {
        int i;
        String obj3;
        int indexOf = string.indexOf(44);
        final int i3 = 0;
        if (indexOf != -1) {
            e2.g = h.r(string.substring(indexOf + 1));
            obj3 = string.substring(i3, indexOf);
        }
        if (obj3.endsWith("%")) {
            e2.e = j.c(obj3);
            e2.f = i3;
        } else {
            e2.e = (float)obj3;
            e2.f = 1;
        }
    }

    private static int t(String string) {
        boolean equals;
        int i;
        String obj5;
        string.hashCode();
        int i2 = 2;
        final int i3 = 1;
        final int i4 = 0;
        i = -1;
        switch (string) {
            case "line-left":
                i = i4;
                break;
            case "center":
                i = i3;
                break;
            case "line-right":
                i = i2;
                break;
            case "middle":
                i = 3;
                break;
            case "end":
                i = 4;
                break;
            case "start":
                i = 5;
                break;
            default:
        }
        switch (i) {
            case 0:
                return i4;
            case 1:
                return i3;
            case 2:
                return i2;
            default:
                String str4 = "Invalid anchor value: ";
                obj5 = String.valueOf(string);
                obj5 = str4.concat(obj5);
                obj5 = new String(str4);
        }
        v.h("WebvttCueParser", obj5);
        return Integer.MIN_VALUE;
    }

    private static void u(String string, com.google.android.exoplayer2.text.u.h.e h$e2) {
        int i;
        String obj2;
        int indexOf = string.indexOf(44);
        if (indexOf != -1) {
            e2.i = h.t(string.substring(indexOf + 1));
            obj2 = string.substring(0, indexOf);
        }
        e2.h = j.c(obj2);
    }

    private static int v(String string) {
        boolean equals;
        int i;
        String obj7;
        string.hashCode();
        int i2 = 5;
        final int i3 = 4;
        final int i4 = 3;
        final int i5 = 1;
        final int i6 = 2;
        i = -1;
        switch (string) {
            case "center":
                i = 0;
                break;
            case "middle":
                i = i5;
                break;
            case "end":
                i = i6;
                break;
            case "left":
                i = i4;
                break;
            case "right":
                i = i3;
                break;
            case "start":
                i = i2;
                break;
            default:
        }
        switch (i) {
            case 0:
                return i6;
            case 1:
                return i4;
            case 2:
                return i3;
            case 3:
                return i2;
            case 4:
                return i5;
            default:
                String str7 = "Invalid alignment value: ";
                obj7 = String.valueOf(string);
                obj7 = str7.concat(obj7);
                obj7 = new String(str7);
        }
        v.h("WebvttCueParser", obj7);
        return i6;
    }

    private static int w(String string) {
        String obj2;
        string.hashCode();
        if (!string.equals("lr") && !string.equals("rl")) {
            if (!string.equals("rl")) {
                String str3 = "Invalid 'vertical' value: ";
                obj2 = String.valueOf(string);
                if (obj2.length() != 0) {
                    obj2 = str3.concat(obj2);
                } else {
                    obj2 = new String(str3);
                }
                v.h("WebvttCueParser", obj2);
                return Integer.MIN_VALUE;
            }
            return 1;
        }
        return 2;
    }
}
