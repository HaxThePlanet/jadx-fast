package com.google.android.exoplayer2.ui;

import android.text.Html;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.util.SparseArray;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.x;
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
final class w {

    private static final Pattern a;

    static class a {
    }

    public static class b {

        public final String a;
        public final Map<String, String> b;
        private b(String string, Map<String, String> map2) {
            super();
            this.a = string;
            this.b = map2;
        }

        b(String string, Map map2, com.google.android.exoplayer2.ui.w.a w$a3) {
            super(string, map2);
        }
    }

    private static final class c {

        private static final Comparator<com.google.android.exoplayer2.ui.w.c> e;
        private static final Comparator<com.google.android.exoplayer2.ui.w.c> f;
        public final int a;
        public final int b;
        public final String c;
        public final String d;
        static {
            w.c.e = e.a;
            w.c.f = f.a;
        }

        private c(int i, int i2, String string3, String string4) {
            super();
            this.a = i;
            this.b = i2;
            this.c = string3;
            this.d = string4;
        }

        c(int i, int i2, String string3, String string4, com.google.android.exoplayer2.ui.w.a w$a5) {
            super(i, i2, string3, string4);
        }

        static Comparator a() {
            return w.c.f;
        }

        static Comparator b() {
            return w.c.e;
        }

        static int c(com.google.android.exoplayer2.ui.w.c w$c, com.google.android.exoplayer2.ui.w.c w$c2) {
            int compare = Integer.compare(c2.b, c.b);
            if (compare != 0) {
                return compare;
            }
            int compareTo = c.c.compareTo(c2.c);
            if (compareTo != 0) {
                return compareTo;
            }
            return c.d.compareTo(c2.d);
        }

        static int d(com.google.android.exoplayer2.ui.w.c w$c, com.google.android.exoplayer2.ui.w.c w$c2) {
            int compare = Integer.compare(c2.a, c.a);
            if (compare != 0) {
                return compare;
            }
            int compareTo = c2.c.compareTo(c.c);
            if (compareTo != 0) {
                return compareTo;
            }
            return c2.d.compareTo(c.d);
        }
    }

    private static final class d {

        private final List<com.google.android.exoplayer2.ui.w.c> a;
        private final List<com.google.android.exoplayer2.ui.w.c> b;
        public d() {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.b = arrayList2;
        }

        static List a(com.google.android.exoplayer2.ui.w.d w$d) {
            return d.b;
        }

        static List b(com.google.android.exoplayer2.ui.w.d w$d) {
            return d.a;
        }
    }
    static {
        w.a = Pattern.compile("(&#13;)?&#10;");
    }

    public static com.google.android.exoplayer2.ui.w.b a(java.lang.CharSequence charSequence, float f2) {
        int length;
        int i2;
        int i;
        int keyAt;
        Integer valueOf;
        List list;
        Comparator comparator2;
        Comparator comparator;
        final int i3 = 0;
        if (charSequence == null) {
            w.b obj8 = new w.b("", x.k(), i3);
            return obj8;
        }
        if (!charSequence instanceof Spanned) {
            w.b obj9 = new w.b(w.b(charSequence), x.k(), i3);
            return obj9;
        }
        HashSet hashSet = new HashSet();
        i = 0;
        Object[] spans = charSequence.getSpans(i, (Spanned)charSequence.length(), BackgroundColorSpan.class);
        keyAt = i;
        while (keyAt < spans.length) {
            hashSet.add(Integer.valueOf((BackgroundColorSpan[])spans[keyAt].getBackgroundColor()));
            keyAt++;
        }
        HashMap hashMap = new HashMap();
        Iterator iterator = hashSet.iterator();
        for (Integer next2 : iterator) {
            int intValue = next2.intValue();
            StringBuilder stringBuilder2 = new StringBuilder(14);
            stringBuilder2.append("bg_");
            stringBuilder2.append(intValue);
            valueOf = new Object[1];
            valueOf[i] = n.b(intValue);
            hashMap.put(n.a(stringBuilder2.toString()), p0.z("background-color:%s;", valueOf));
        }
        obj9 = w.c(charSequence, f2);
        StringBuilder stringBuilder = new StringBuilder(charSequence.length());
        i2 = i;
        while (i < obj9.size()) {
            keyAt = obj9.keyAt(i);
            stringBuilder.append(w.b(charSequence.subSequence(i2, keyAt)));
            Object obj2 = obj9.get(keyAt);
            Collections.sort(w.d.a((w.d)obj2), w.c.a());
            Iterator iterator3 = w.d.a(obj2).iterator();
            for (w.c next5 : iterator3) {
                stringBuilder.append(next5.d);
            }
            Collections.sort(w.d.b(obj2), w.c.b());
            Iterator iterator2 = w.d.b(obj2).iterator();
            for (w.c next3 : iterator2) {
                stringBuilder.append(next3.c);
            }
            i++;
            i2 = keyAt;
            stringBuilder.append(next3.c);
            stringBuilder.append(next5.d);
        }
        stringBuilder.append(w.b(charSequence.subSequence(i2, charSequence.length())));
        obj8 = new w.b(stringBuilder.toString(), hashMap, i3);
        return obj8;
    }

    private static String b(java.lang.CharSequence charSequence) {
        return w.a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }

    private static SparseArray<com.google.android.exoplayer2.ui.w.d> c(Spanned spanned, float f2) {
        int i3;
        int spanEnd;
        List list;
        int i2;
        int i4;
        String str2;
        String str;
        int i;
        int spanStart;
        com.google.android.exoplayer2.ui.w.c cVar;
        SparseArray sparseArray = new SparseArray();
        Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
        while (i3 < spans.length) {
            Object obj2 = spans[i3];
            str2 = w.e(obj2, f2);
            str = w.d(obj2);
            spanStart = spanned.getSpanStart(obj2);
            spanEnd = spanned.getSpanEnd(obj2);
            if (str2 != null) {
            }
            i3++;
            g.e(str);
            super(spanStart, spanEnd, str2, str, 0);
            w.d.b(w.f(sparseArray, spanStart)).add(cVar);
            w.d.a(w.f(sparseArray, spanEnd)).add(cVar);
        }
        return sparseArray;
    }

    private static String d(Object object) {
        int i;
        boolean z;
        int str;
        int obj3;
        if (!object instanceof StrikethroughSpan && !object instanceof ForegroundColorSpan && !object instanceof BackgroundColorSpan && !object instanceof a && !object instanceof AbsoluteSizeSpan && !object instanceof RelativeSizeSpan) {
            if (!object instanceof ForegroundColorSpan) {
                if (!object instanceof BackgroundColorSpan) {
                    if (!object instanceof a) {
                        if (!object instanceof AbsoluteSizeSpan) {
                            if (!object instanceof RelativeSizeSpan) {
                                if (object instanceof e) {
                                } else {
                                    final int i5 = 0;
                                    if (object instanceof TypefaceSpan) {
                                        if ((TypefaceSpan)object.getFamily() != null) {
                                        } else {
                                            str = i5;
                                        }
                                        return str;
                                    }
                                    obj3 = (StyleSpan)object.getStyle();
                                    if (object instanceof StyleSpan && obj3 != 1 && obj3 != 2 && obj3 != 3) {
                                        obj3 = (StyleSpan)object.getStyle();
                                        if (obj3 != 1) {
                                            if (obj3 != 2) {
                                                if (obj3 != 3) {
                                                }
                                                return "</i></b>";
                                            }
                                            return "</i>";
                                        }
                                        return "</b>";
                                    }
                                    if (object instanceof c) {
                                        obj3 = w.b(object.a);
                                        StringBuilder stringBuilder = new StringBuilder(length += 16);
                                        stringBuilder.append("<rt>");
                                        stringBuilder.append(obj3);
                                        stringBuilder.append("</rt></ruby>");
                                        return stringBuilder.toString();
                                    }
                                    if (object instanceof UnderlineSpan) {
                                        return "</u>";
                                    }
                                }
                                return i5;
                            }
                        }
                    }
                }
            }
        }
        return "</span>";
    }

    private static String e(Object object, float f2) {
        int i;
        int obj4;
        boolean obj5;
        if (object instanceof StrikethroughSpan) {
            return "<span style='text-decoration:line-through;'>";
        }
        final int i4 = 0;
        final int i5 = 1;
        if (object instanceof ForegroundColorSpan) {
            obj5 = new Object[i5];
            obj5[i4] = n.b((ForegroundColorSpan)object.getForegroundColor());
            return p0.z("<span style='color:%s;'>", obj5);
        }
        if (object instanceof BackgroundColorSpan) {
            obj5 = new Object[i5];
            obj5[i4] = Integer.valueOf((BackgroundColorSpan)object.getBackgroundColor());
            return p0.z("<span class='bg_%s'>", obj5);
        }
        if (object instanceof a) {
            return "<span style='text-combine-upright:all;'>";
        }
        if (object instanceof AbsoluteSizeSpan) {
            if ((AbsoluteSizeSpan)object.getDip()) {
                obj4 = (float)obj4;
            } else {
                obj4 /= f2;
            }
            obj5 = new Object[i5];
            obj5[i4] = Float.valueOf(obj4);
            return p0.z("<span style='font-size:%.2fpx;'>", obj5);
        }
        if (object instanceof RelativeSizeSpan) {
            obj5 = new Object[i5];
            obj5[i4] = Float.valueOf(obj4 *= i3);
            return p0.z("<span style='font-size:%.2f%%;'>", obj5);
        }
        i = 0;
        obj4 = (TypefaceSpan)object.getFamily();
        if (object instanceof TypefaceSpan && obj4 != null) {
            obj4 = (TypefaceSpan)object.getFamily();
            if (obj4 != null) {
                obj5 = new Object[i5];
                obj5[i4] = obj4;
                i = p0.z("<span style='font-family:\"%s\";'>", obj5);
            }
            return i;
        }
        final int i6 = 2;
        obj4 = (StyleSpan)object.getStyle();
        if (object instanceof StyleSpan && obj4 != i5 && obj4 != i6 && obj4 != 3) {
            obj4 = (StyleSpan)object.getStyle();
            if (obj4 != i5) {
                if (obj4 != i6) {
                    if (obj4 != 3) {
                        return i;
                    }
                    return "<b><i>";
                }
                return "<i>";
            }
            return "<b>";
        }
        obj4 = object.b;
        if (object instanceof c && obj4 != -1 && obj4 != i5 && obj4 != i6) {
            obj4 = object.b;
            if (obj4 != -1) {
                if (obj4 != i5) {
                    if (obj4 != i6) {
                        return i;
                    }
                    return "<ruby style='ruby-position:under;'>";
                }
                return "<ruby style='ruby-position:over;'>";
            }
            return "<ruby style='ruby-position:unset;'>";
        }
        if (object instanceof UnderlineSpan) {
            return "<u>";
        }
        if (object instanceof e) {
            Object[] arr = new Object[i6];
            arr[i4] = w.h(object.a, object.b);
            arr[i5] = w.g(object.c);
            return p0.z("<span style='-webkit-text-emphasis-style:%1$s;text-emphasis-style:%1$s;-webkit-text-emphasis-position:%2$s;text-emphasis-position:%2$s;display:inline-block;'>", arr);
        }
        return i;
    }

    private static com.google.android.exoplayer2.ui.w.d f(SparseArray<com.google.android.exoplayer2.ui.w.d> sparseArray, int i2) {
        Object dVar;
        if ((w.d)sparseArray.get(i2) == null) {
            dVar = new w.d();
            sparseArray.put(i2, dVar);
        }
        return dVar;
    }

    private static String g(int i) {
        if (i != 2) {
            return "over right";
        }
        return "under left";
    }

    private static String h(int i, int i2) {
        String obj3;
        String obj4;
        StringBuilder stringBuilder = new StringBuilder();
        final int i3 = 2;
        final int i4 = 1;
        if (i2 != i4) {
            if (i2 != i3) {
            } else {
                stringBuilder.append("open ");
            }
        } else {
            stringBuilder.append("filled ");
        }
        if (i != 0) {
            if (i != i4) {
                if (i != i3) {
                    if (i != 3) {
                        stringBuilder.append("unset");
                    } else {
                        stringBuilder.append("sesame");
                    }
                } else {
                    stringBuilder.append("dot");
                }
            } else {
                stringBuilder.append("circle");
            }
        } else {
            stringBuilder.append("none");
        }
        return stringBuilder.toString();
    }
}
