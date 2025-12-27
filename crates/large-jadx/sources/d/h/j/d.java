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

/* compiled from: PrecomputedTextCompat.java */
/* loaded from: classes.dex */
public class d implements Spannable {

    private final Spannable a;
    private final d.a b;
    private final PrecomputedText c;

    public static final class a {

        private final TextPaint a;
        private final TextDirectionHeuristic b;
        private final int c;
        private final int d;
        a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            super();
            if (Build.VERSION.SDK_INT >= 29) {
                new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build();
            }
            this.a = textPaint;
            this.b = textDirectionHeuristic;
            this.c = i;
            this.d = i2;
        }

        public boolean a(d.a aVar) {
            sDK_INT2 = Build.VERSION.SDK_INT;
            final boolean z = false;
            int i = 23;
            if (Build.VERSION.SDK_INT >= 23) {
                if (this.c != aVar.b()) {
                    return false;
                }
                if (this.d != aVar.c()) {
                    return false;
                }
            }
            float textSize = this.a.getTextSize();
            float textSize2 = aVar.e().getTextSize();
            if (textSize != textSize2) {
                return false;
            }
            float textScaleX = this.a.getTextScaleX();
            float textScaleX2 = aVar.e().getTextScaleX();
            if (textScaleX != textScaleX2) {
                return false;
            }
            float textSkewX2 = this.a.getTextSkewX();
            float textSkewX = aVar.e().getTextSkewX();
            if (textSkewX2 != textSkewX) {
                return false;
            }
            int i2 = 21;
            if (Build.VERSION.SDK_INT >= 21) {
                float letterSpacing = this.a.getLetterSpacing();
                float letterSpacing2 = aVar.e().getLetterSpacing();
                if (letterSpacing != letterSpacing2) {
                    return false;
                }
                if (!TextUtils.equals(this.a.getFontFeatureSettings(), aVar.e().getFontFeatureSettings())) {
                    return false;
                }
            }
            if (this.a.getFlags() != aVar.e().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.a.getTextLocales().equals(aVar.e().getTextLocales())) {
                    return false;
                }
            } else {
                int i3 = 17;
                if (Build.VERSION.SDK_INT >= 17 && !this.a.getTextLocale().equals(aVar.e().getTextLocale())) {
                    return false;
                }
            }
            if (this.a.getTypeface() == null) {
                if (aVar.e().getTypeface() != null) {
                    return false;
                }
            } else {
                if (!this.a.getTypeface().equals(aVar.e().getTypeface())) {
                    return false;
                }
            }
            return true;
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
            final boolean z = true;
            if (object == this) {
                return true;
            }
            final boolean z4 = false;
            if (!(object instanceof d.a)) {
                return false;
            }
            if (!a(object)) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                return this.b != object.d() ? z4 : z;
            }
        }

        public int hashCode() {
            int sDK_INT2 = Build.VERSION.SDK_INT;
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
            if (Build.VERSION.SDK_INT >= 24) {
                Object[] arr5 = new Object[i15];
                return c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocales(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                Object[] arr = new Object[i15];
                return c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Float.valueOf(this.a.getLetterSpacing()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), Boolean.valueOf(this.a.isElegantTextHeight()), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (Build.VERSION.SDK_INT >= 18) {
                Object[] arr4 = new Object[i20];
                return c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            if (Build.VERSION.SDK_INT >= 17) {
                Object[] arr2 = new Object[i20];
                return c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTextLocale(), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
            }
            Object[] arr3 = new Object[i21];
            return c.b(Float.valueOf(this.a.getTextSize()), Float.valueOf(this.a.getTextScaleX()), Float.valueOf(this.a.getTextSkewX()), Integer.valueOf(this.a.getFlags()), this.a.getTypeface(), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d));
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            StringBuilder stringBuilder2 = new StringBuilder();
            String str12 = "textSize=";
            float textSize = this.a.getTextSize();
            str4 = str12 + textSize;
            stringBuilder.append(str4);
            StringBuilder stringBuilder3 = new StringBuilder();
            String str13 = ", textScaleX=";
            float textScaleX = this.a.getTextScaleX();
            str5 = str13 + textScaleX;
            stringBuilder.append(str5);
            StringBuilder stringBuilder4 = new StringBuilder();
            String str14 = ", textSkewX=";
            float textSkewX = this.a.getTextSkewX();
            str6 = str14 + textSkewX;
            stringBuilder.append(str6);
            sDK_INT2 = Build.VERSION.SDK_INT;
            int i = 21;
            if (Build.VERSION.SDK_INT >= 21) {
                StringBuilder stringBuilder12 = new StringBuilder();
                String str24 = ", letterSpacing=";
                float letterSpacing = this.a.getLetterSpacing();
                str20 = str24 + letterSpacing;
                stringBuilder.append(str20);
                StringBuilder stringBuilder13 = new StringBuilder();
                String str25 = ", elegantTextHeight=";
                boolean elegantTextHeight = this.a.isElegantTextHeight();
                str21 = str25 + elegantTextHeight;
                stringBuilder.append(str21);
            }
            String str22 = ", textLocale=";
            if (Build.VERSION.SDK_INT >= 24) {
                StringBuilder stringBuilder9 = new StringBuilder();
                LocaleList textLocales = this.a.getTextLocales();
                str = str22 + textLocales;
                stringBuilder.append(str);
            } else {
                if (Build.VERSION.SDK_INT >= 17) {
                    StringBuilder stringBuilder11 = new StringBuilder();
                    Locale textLocale = this.a.getTextLocale();
                    str = str22 + textLocale;
                    stringBuilder.append(str);
                }
            }
            StringBuilder stringBuilder10 = new StringBuilder();
            String str23 = ", typeface=";
            Typeface typeface = this.a.getTypeface();
            str15 = str23 + typeface;
            stringBuilder.append(str15);
            int i2 = 26;
            if (Build.VERSION.SDK_INT >= 26) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str16 = ", variationSettings=";
                String fontVariationSettings = this.a.getFontVariationSettings();
                str7 = str16 + fontVariationSettings;
                stringBuilder.append(str7);
            }
            StringBuilder stringBuilder6 = new StringBuilder();
            String str17 = ", textDir=";
            str8 = str17 + this.b;
            stringBuilder.append(str8);
            StringBuilder stringBuilder7 = new StringBuilder();
            String str18 = ", breakStrategy=";
            str9 = str18 + this.c;
            stringBuilder.append(str9);
            StringBuilder stringBuilder8 = new StringBuilder();
            String str19 = ", hyphenationFrequency=";
            str10 = str19 + this.d;
            stringBuilder.append(str10);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }

        public a(PrecomputedText.Params params) {
            super();
            this.a = params.getTextPaint();
            this.b = params.getTextDirection();
            this.c = params.getBreakStrategy();
            this.d = params.getHyphenationFrequency();
        }
    }
    public d.a a() {
        return this.b;
    }

    public PrecomputedText b() {
        if (spannable instanceof PrecomputedText) {
            return spannable;
        }
        return null;
    }

    public char charAt(int i) {
        return this.a.charAt(i);
    }

    public int getSpanEnd(Object object) {
        return this.a.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.a.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.a.getSpanStart(object);
    }

    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.c.getSpans(i, i2, cls);
        }
        return this.a.getSpans(i, i2, cls);
    }

    public int length() {
        return this.a.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.a.nextSpanTransition(i, i2, cls);
    }

    public void removeSpan(Object object) {
        if (object instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                this.c.removeSpan(object);
            } else {
                this.a.removeSpan(object);
            }
            return;
        }
    }

    public void setSpan(Object object, int i, int i2, int i3) {
        if (object instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else {
            if (Build.VERSION.SDK_INT >= 29) {
                this.c.setSpan(object, i, i2, i3);
            } else {
                this.a.setSpan(object, i, i2, i3);
            }
            return;
        }
    }

    public java.lang.CharSequence subSequence(int i, int i2) {
        return this.a.subSequence(i, i2);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a.toString();
    }

}
