package com.google.android.exoplayer2.text.s;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.text.p.a;
import com.google.android.exoplayer2.text.p.c;
import com.google.android.exoplayer2.text.p.d;
import com.google.android.exoplayer2.text.p.e;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/* loaded from: classes2.dex */
final class f {
    public static void a(Spannable spannable, int i2, int i3, com.google.android.exoplayer2.text.s.g g4, com.google.android.exoplayer2.text.s.d d5, Map<String, com.google.android.exoplayer2.text.s.g> map6, int i7) {
        int styleSpan;
        boolean strikethroughSpan;
        boolean underlineSpan;
        boolean foregroundColorSpan;
        boolean backgroundColorSpan;
        Object typefaceSpan;
        com.google.android.exoplayer2.text.s.b bVar;
        int i5;
        int i4;
        int i;
        e eVar;
        float obj11;
        int obj12;
        Object obj13;
        int obj14;
        i5 = -1;
        final int i6 = 33;
        if (g4.l() != i5) {
            styleSpan = new StyleSpan(g4.l());
            spannable.setSpan(styleSpan, i2, i3, i6);
        }
        if (g4.s()) {
            strikethroughSpan = new StrikethroughSpan();
            spannable.setSpan(strikethroughSpan, i2, i3, i6);
        }
        if (g4.t()) {
            underlineSpan = new UnderlineSpan();
            spannable.setSpan(underlineSpan, i2, i3, i6);
        }
        if (g4.q()) {
            foregroundColorSpan = new ForegroundColorSpan(g4.c());
            d.a(spannable, foregroundColorSpan, i2, i3, i6);
        }
        if (g4.p()) {
            backgroundColorSpan = new BackgroundColorSpan(g4.b());
            d.a(spannable, backgroundColorSpan, i2, i3, i6);
        }
        if (g4.d() != null) {
            typefaceSpan = new TypefaceSpan(g4.d());
            d.a(spannable, typefaceSpan, i2, i3, i6);
        }
        int i8 = 3;
        final int i9 = 2;
        final int i10 = 1;
        if (g4.o() != null) {
            com.google.android.exoplayer2.text.s.b bVar2 = g4.o();
            g.e(bVar2);
            if (bVar2.a == i5) {
                if (i7 != i9) {
                    if (i7 == i10) {
                        i = i8;
                    } else {
                        i = i10;
                    }
                } else {
                }
                obj14 = i10;
            } else {
                obj14 = bVar2.b;
            }
            if (bVar2.c == -2) {
                bVar = i10;
            }
            eVar = new e(i, obj14, bVar);
            d.a(spannable, eVar, i2, i3, i6);
        }
        obj14 = g4.j();
        if (obj14 != i9) {
            if (obj14 != i8 && obj14 != 4) {
                if (obj14 != 4) {
                } else {
                    obj12 = new a();
                    spannable.setSpan(obj12, i2, i3, i6);
                }
            } else {
            }
        } else {
            obj12 = f.d(d5, map6);
            if (obj12 == null) {
            } else {
                obj14 = f.e(obj12, map6);
                if (obj14 == null) {
                } else {
                    bVar = 0;
                    if (obj14.g() == i10 && dVar2.b != null) {
                        bVar = 0;
                        if (dVar2.b != null) {
                            bVar = dVar.b;
                            p0.i(bVar);
                            obj14 = f.f(obj14.f, obj14.l(), map6);
                            if (obj14 != null) {
                                obj14 = obj14.i();
                            } else {
                                obj14 = i5;
                            }
                            obj12 = f.f(obj12.f, obj12.l(), map6);
                            if (obj14 == i5 && obj12 != null) {
                                obj12 = f.f(obj12.f, obj12.l(), map6);
                                if (obj12 != null) {
                                    obj14 = obj12.i();
                                }
                            }
                            obj12 = new c((String)bVar, obj14);
                            spannable.setSpan(obj12, i2, i3, i6);
                        } else {
                            v.f("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                        }
                    } else {
                    }
                }
            }
        }
        if (g4.n()) {
            obj12 = new a();
            d.a(spannable, obj12, i2, i3, i6);
        }
        obj12 = g4.f();
        if (obj12 != i10) {
            if (obj12 != i9) {
                if (obj12 != i8) {
                } else {
                    obj12 = new RelativeSizeSpan(obj11 /= obj13);
                    d.a(spannable, obj12, i2, i3, i6);
                }
            } else {
                obj12 = new RelativeSizeSpan(g4.e());
                d.a(spannable, obj12, i2, i3, i6);
            }
        } else {
            obj12 = new AbsoluteSizeSpan((int)obj11, i10);
            d.a(spannable, obj12, i2, i3, i6);
        }
    }

    static String b(String string) {
        String str4 = "\n";
        String str3 = " ";
        return string.replaceAll("\r\n", str4).replaceAll(" *\n *", str4).replaceAll(str4, str3).replaceAll("[ \t\\x0B\u000c\r]+", str3);
    }

    static void c(SpannableStringBuilder spannableStringBuilder) {
        int charAt2;
        char charAt;
        int i;
        length--;
        while (charAt2 >= 0) {
            if (spannableStringBuilder.charAt(charAt2) == 32) {
            }
            charAt2--;
        }
        charAt = 10;
        if (charAt2 >= 0 && spannableStringBuilder.charAt(charAt2) != charAt) {
            charAt = 10;
            if (spannableStringBuilder.charAt(charAt2) != charAt) {
                spannableStringBuilder.append(charAt);
            }
        }
    }

    private static com.google.android.exoplayer2.text.s.d d(com.google.android.exoplayer2.text.s.d d, Map<String, com.google.android.exoplayer2.text.s.g> map2) {
        com.google.android.exoplayer2.text.s.g gVar;
        String[] strArr;
        while (d != null) {
            gVar = f.f(d.f, d.l(), map2);
            com.google.android.exoplayer2.text.s.d obj2 = d.j;
        }
        return null;
    }

    private static com.google.android.exoplayer2.text.s.d e(com.google.android.exoplayer2.text.s.d d, Map<String, com.google.android.exoplayer2.text.s.g> map2) {
        int i;
        com.google.android.exoplayer2.text.s.g gVar;
        String[] strArr;
        Object obj3;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(d);
        while (!arrayDeque.isEmpty()) {
            obj3 = arrayDeque.pop();
            gVar = f.f(obj3.f, (d)obj3.l(), map2);
            i2--;
            while (i >= 0) {
                arrayDeque.push(obj3.f(i));
                i--;
            }
            arrayDeque.push(obj3.f(i));
            i--;
        }
        return null;
    }

    public static com.google.android.exoplayer2.text.s.g f(com.google.android.exoplayer2.text.s.g g, String[] string2Arr2, Map<String, com.google.android.exoplayer2.text.s.g> map3) {
        int i;
        int length;
        int length2;
        i = 0;
        length = 1;
        if (g == null) {
            if (string2Arr2 == null) {
                return null;
            }
            if (string2Arr2.length == length) {
                return (g)map3.get(string2Arr2[i]);
            }
            if (string2Arr2.length > length) {
                g obj3 = new g();
                while (i < string2Arr2.length) {
                    obj3.a((g)map3.get(string2Arr2[i]));
                    i++;
                }
                return obj3;
            }
        } else {
            if (string2Arr2 != null && string2Arr2.length == length) {
                if (string2Arr2.length == length) {
                    g.a((g)map3.get(string2Arr2[i]));
                    return g;
                }
            }
            if (string2Arr2 != null && string2Arr2.length > length) {
                if (string2Arr2.length > length) {
                    while (i < string2Arr2.length) {
                        g.a((g)map3.get(string2Arr2[i]));
                        i++;
                    }
                }
            }
        }
        return g;
    }
}
