package com.google.android.exoplayer2.ui;

import android.text.Spannable;
import android.text.SpannableString;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.util.g;
import com.google.common.base.o;

/* loaded from: classes2.dex */
final class y {
    static boolean a(Object object) {
        return obj0 ^= 1;
    }

    static boolean b(Object object) {
        int obj1;
        if (!object instanceof AbsoluteSizeSpan) {
            if (object instanceof RelativeSizeSpan) {
                obj1 = 1;
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static void c(c.b c$b) {
        boolean valueOf;
        boolean charSequence;
        com.google.android.exoplayer2.ui.g gVar;
        b.b();
        if (charSequence2 instanceof Spanned && !charSequence3 instanceof Spannable) {
            if (!charSequence3 instanceof Spannable) {
                b.o(SpannableString.valueOf(b.e()));
            }
            charSequence = b.e();
            g.e(charSequence);
            y.e((Spannable)charSequence, g.a);
        }
        y.d(b);
    }

    public static void d(c.b c$b) {
        boolean valueOf;
        boolean hVar;
        java.lang.CharSequence obj2;
        b.q(-8388609, Integer.MIN_VALUE);
        if (charSequence instanceof Spanned && !charSequence2 instanceof Spannable) {
            if (!charSequence2 instanceof Spannable) {
                b.o(SpannableString.valueOf(b.e()));
            }
            obj2 = b.e();
            g.e(obj2);
            y.e((Spannable)obj2, h.a);
        }
    }

    private static void e(Spannable spannable, o<Object> o2) {
        int i;
        Object obj;
        boolean apply;
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        while (i < spans.length) {
            obj = spans[i];
            if (o2.apply(obj)) {
            }
            i++;
            spannable.removeSpan(obj);
        }
    }

    public static float f(int i, float f2, int i3, int i4) {
        float obj2;
        int obj5;
        final int i2 = -8388609;
        if (Float.compare(f2, i2) == 0) {
            return i2;
        }
        if (i != 0) {
            if (i != 1 && i != 2) {
                if (i != 2) {
                    return i2;
                }
                return f2;
            }
            obj2 = (float)i3;
        } else {
            obj2 = (float)i4;
        }
        return f2 *= obj2;
    }
}
