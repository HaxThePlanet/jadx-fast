package d.h.j;

import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.os.LocaleList;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import d.h.k.c;
import java.util.Locale;

/* loaded from: classes.dex */
public class d implements Spannable {

    private final Spannable a;
    private final d.h.j.d.a b;
    private final PrecomputedText c;

    public static final class a {

        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;
        private final int d;
        public a(PrecomputedText.Params precomputedText$Params) {
            super();
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
            int obj2 = Build.VERSION.SDK_INT;
            int i = 29;
        }

        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic2, int i3, int i4) {
            int textDirection;
            super();
            if (Build.VERSION.SDK_INT >= 29) {
                PrecomputedText.Params.Builder builder = new PrecomputedText.Params.Builder(textPaint);
                builder.setBreakStrategy(i3).setHyphenationFrequency(i4).setTextDirection(textDirectionHeuristic2).build();
            }
            this.a = textPaint;
            this.b = textDirectionHeuristic2;
            this.c = i3;
            this.d = i4;
        }

        public boolean a(d.h.j.d.a d$a) {
            int sDK_INT;
            Typeface typeface;
            int i;
            int equals;
            int textLocales;
            int i2;
            float fontFeatureSettings;
            Typeface obj5;
            sDK_INT = Build.VERSION.SDK_INT;
            final int i3 = 0;
            if (sDK_INT >= 23 && this.c != a.b()) {
                if (this.c != a.b()) {
                    return i3;
                }
                if (this.d != a.c()) {
                    return i3;
                }
            }
            if (Float.compare(textSize, textSize2) != 0) {
                return i3;
            }
            if (Float.compare(textScaleX, textScaleX2) != 0) {
                return i3;
            }
            if (Float.compare(textSkewX, fontFeatureSettings) != 0) {
                return i3;
            }
            if (sDK_INT >= 21 && Float.compare(letterSpacing, letterSpacing2) != 0) {
                if (Float.compare(letterSpacing, letterSpacing2) != 0) {
                    return i3;
                }
                if (!TextUtils.equals(this.a.getFontFeatureSettings(), a.e().getFontFeatureSettings())) {
                    return i3;
                }
            }
            if (this.a.getFlags() != a.e().getFlags()) {
                return i3;
            }
            if (sDK_INT >= 24) {
                if (!this.a.getTextLocales().equals(a.e().getTextLocales())) {
                    return i3;
                }
            } else {
                if (sDK_INT >= 17 && !this.a.getTextLocale().equals(a.e().getTextLocale())) {
                    if (!this.a.getTextLocale().equals(a.e().getTextLocale())) {
                        return i3;
                    }
                }
            }
            if (this.a.getTypeface() == null) {
                if (a.e().getTypeface() != null) {
                    return i3;
                }
            } else {
                if (!this.a.getTypeface().equals(a.e().getTypeface())) {
                    return i3;
                }
            }
            return 1;
        }

        public int b() {
            return this.c;
        }

        public int c() {
            return this.d;
        }

        public TextDirectionHeuristic d() {
            return this.b;
        }

        public TextPaint e() {
            return this.a;
        }

        public boolean equals(Object object) {
            int sDK_INT;
            Object obj5;
            final int i = 1;
            if (object == this) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof d.a) {
                return i2;
            }
            if (!a((d.a)object)) {
                return i2;
            }
            if (Build.VERSION.SDK_INT >= 18 && this.b != object.d()) {
                if (this.b != object.d()) {
                    return i2;
                }
            }
            return i;
        }

        public int hashCode() {
            int sDK_INT = Build.VERSION.SDK_INT;
            int i6 = 10;
            int i15 = 11;
            final int i20 = 9;
            final int i21 = 8;
            final int i22 = 7;
            final int i23 = 6;
            final int i24 = 5;
            final int i25 = 4;
            final int i26 = 3;
            final int i27 = 2;
            final int i28 = 1;
            final int i29 = 0;
            if (sDK_INT >= 24) {
                Object[] arr5 = new Object[i15];
                arr5[i29] = Float.valueOf(this.a.getTextSize());
                arr5[i28] = Float.valueOf(this.a.getTextScaleX());
                arr5[i27] = Float.valueOf(this.a.getTextSkewX());
                arr5[i26] = Float.valueOf(this.a.getLetterSpacing());
                arr5[i25] = Integer.valueOf(this.a.getFlags());
                arr5[i24] = this.a.getTextLocales();
                arr5[i23] = this.a.getTypeface();
                arr5[i22] = Boolean.valueOf(this.a.isElegantTextHeight());
                arr5[i21] = this.b;
                arr5[i20] = Integer.valueOf(this.c);
                arr5[i6] = Integer.valueOf(this.d);
                return c.b(arr5);
            }
            if (sDK_INT >= 21) {
                Object[] arr = new Object[i15];
                arr[i29] = Float.valueOf(this.a.getTextSize());
                arr[i28] = Float.valueOf(this.a.getTextScaleX());
                arr[i27] = Float.valueOf(this.a.getTextSkewX());
                arr[i26] = Float.valueOf(this.a.getLetterSpacing());
                arr[i25] = Integer.valueOf(this.a.getFlags());
                arr[i24] = this.a.getTextLocale();
                arr[i23] = this.a.getTypeface();
                arr[i22] = Boolean.valueOf(this.a.isElegantTextHeight());
                arr[i21] = this.b;
                arr[i20] = Integer.valueOf(this.c);
                arr[i6] = Integer.valueOf(this.d);
                return c.b(arr);
            }
            if (sDK_INT >= 18) {
                Object[] arr4 = new Object[i20];
                arr4[i29] = Float.valueOf(this.a.getTextSize());
                arr4[i28] = Float.valueOf(this.a.getTextScaleX());
                arr4[i27] = Float.valueOf(this.a.getTextSkewX());
                arr4[i26] = Integer.valueOf(this.a.getFlags());
                arr4[i25] = this.a.getTextLocale();
                arr4[i24] = this.a.getTypeface();
                arr4[i23] = this.b;
                arr4[i22] = Integer.valueOf(this.c);
                arr4[i21] = Integer.valueOf(this.d);
                return c.b(arr4);
            }
            if (sDK_INT >= 17) {
                Object[] arr2 = new Object[i20];
                arr2[i29] = Float.valueOf(this.a.getTextSize());
                arr2[i28] = Float.valueOf(this.a.getTextScaleX());
                arr2[i27] = Float.valueOf(this.a.getTextSkewX());
                arr2[i26] = Integer.valueOf(this.a.getFlags());
                arr2[i25] = this.a.getTextLocale();
                arr2[i24] = this.a.getTypeface();
                arr2[i23] = this.b;
                arr2[i22] = Integer.valueOf(this.c);
                arr2[i21] = Integer.valueOf(this.d);
                return c.b(arr2);
            }
            Object[] arr3 = new Object[i21];
            arr3[i29] = Float.valueOf(this.a.getTextSize());
            arr3[i28] = Float.valueOf(this.a.getTextScaleX());
            arr3[i27] = Float.valueOf(this.a.getTextSkewX());
            arr3[i26] = Integer.valueOf(this.a.getFlags());
            arr3[i25] = this.a.getTypeface();
            arr3[i24] = this.b;
            arr3[i23] = Integer.valueOf(this.c);
            arr3[i22] = Integer.valueOf(this.d);
            return c.b(arr3);
        }

        public String toString() {
            int sDK_INT;
            int string;
            String string2;
            int fontVariationSettings;
            boolean elegantTextHeight;
            Object textLocales;
            StringBuilder stringBuilder = new StringBuilder("{");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("textSize=");
            stringBuilder2.append(this.a.getTextSize());
            stringBuilder.append(stringBuilder2.toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(", textScaleX=");
            stringBuilder3.append(this.a.getTextScaleX());
            stringBuilder.append(stringBuilder3.toString());
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(", textSkewX=");
            stringBuilder4.append(this.a.getTextSkewX());
            stringBuilder.append(stringBuilder4.toString());
            sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 21) {
                StringBuilder stringBuilder12 = new StringBuilder();
                stringBuilder12.append(", letterSpacing=");
                stringBuilder12.append(this.a.getLetterSpacing());
                stringBuilder.append(stringBuilder12.toString());
                StringBuilder stringBuilder13 = new StringBuilder();
                stringBuilder13.append(", elegantTextHeight=");
                stringBuilder13.append(this.a.isElegantTextHeight());
                stringBuilder.append(stringBuilder13.toString());
            }
            textLocales = ", textLocale=";
            if (sDK_INT >= 24) {
                StringBuilder stringBuilder9 = new StringBuilder();
                stringBuilder9.append(textLocales);
                stringBuilder9.append(this.a.getTextLocales());
                stringBuilder.append(stringBuilder9.toString());
            } else {
                if (sDK_INT >= 17) {
                    StringBuilder stringBuilder11 = new StringBuilder();
                    stringBuilder11.append(textLocales);
                    stringBuilder11.append(this.a.getTextLocale());
                    stringBuilder.append(stringBuilder11.toString());
                }
            }
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder10.append(", typeface=");
            stringBuilder10.append(this.a.getTypeface());
            stringBuilder.append(stringBuilder10.toString());
            if (sDK_INT >= 26) {
                StringBuilder stringBuilder5 = new StringBuilder();
                stringBuilder5.append(", variationSettings=");
                stringBuilder5.append(this.a.getFontVariationSettings());
                stringBuilder.append(stringBuilder5.toString());
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder6.append(", textDir=");
            stringBuilder6.append(this.b);
            stringBuilder.append(stringBuilder6.toString());
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder7.append(", breakStrategy=");
            stringBuilder7.append(this.c);
            stringBuilder.append(stringBuilder7.toString());
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(", hyphenationFrequency=");
            stringBuilder8.append(this.d);
            stringBuilder.append(stringBuilder8.toString());
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
    static {
    }

    @Override // android.text.Spannable
    public d.h.j.d.a a() {
        return this.b;
    }

    @Override // android.text.Spannable
    public PrecomputedText b() {
        Spannable spannable = this.a;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText)spannable;
        }
        return null;
    }

    @Override // android.text.Spannable
    public char charAt(int i) {
        return this.a.charAt(i);
    }

    @Override // android.text.Spannable
    public int getSpanEnd(Object object) {
        return this.a.getSpanEnd(object);
    }

    @Override // android.text.Spannable
    public int getSpanFlags(Object object) {
        return this.a.getSpanFlags(object);
    }

    @Override // android.text.Spannable
    public int getSpanStart(Object object) {
        return this.a.getSpanStart(object);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> class3) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.c.getSpans(i, i2, class3);
        }
        return this.a.getSpans(i, i2, class3);
    }

    @Override // android.text.Spannable
    public int length() {
        return this.a.length();
    }

    @Override // android.text.Spannable
    public int nextSpanTransition(int i, int i2, Class class3) {
        return this.a.nextSpanTransition(i, i2, class3);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object object) {
        Object spannable;
        if (object instanceof MetricAffectingSpan) {
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                this.c.removeSpan(object);
            } else {
                this.a.removeSpan(object);
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        throw obj3;
    }

    @Override // android.text.Spannable
    public void setSpan(Object object, int i2, int i3, int i4) {
        Object spannable;
        if (object instanceof MetricAffectingSpan) {
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                this.c.setSpan(object, i2, i3, i4);
            } else {
                this.a.setSpan(object, i2, i3, i4);
            }
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        throw obj3;
    }

    @Override // android.text.Spannable
    public java.lang.CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }

    @Override // android.text.Spannable
    public String toString() {
        return this.a.toString();
    }
}
