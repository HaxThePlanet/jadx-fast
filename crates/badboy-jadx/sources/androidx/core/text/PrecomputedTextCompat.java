package androidx.core.text;

import android.graphics.Typeface;
import android.os.LocaleList;
import android.os.Trace;
import android.text.PrecomputedText;
import android.text.PrecomputedText.Params;
import android.text.PrecomputedText.Params.Builder;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout.Builder;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/* loaded from: classes5.dex */
public class PrecomputedTextCompat implements Spannable {

    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock;
    private final int[] mParagraphEnds;
    private final androidx.core.text.PrecomputedTextCompat.Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    static class Api28Impl {
        static Spannable castToSpannable(PrecomputedText precomputedText) {
            return precomputedText;
        }
    }

    public static final class Params {

        private final int mBreakStrategy;
        private final int mHyphenationFrequency;
        private final TextPaint mPaint;
        private final TextDirectionHeuristic mTextDir;
        final PrecomputedText.Params mWrapped;
        public Params(PrecomputedText.Params wrapped) {
            super();
            this.mPaint = wrapped.getTextPaint();
            this.mTextDir = wrapped.getTextDirection();
            this.mBreakStrategy = wrapped.getBreakStrategy();
            this.mHyphenationFrequency = wrapped.getHyphenationFrequency();
            this.mWrapped = wrapped;
        }

        Params(TextPaint paint, TextDirectionHeuristic textDir, int strategy, int frequency) {
            super();
            PrecomputedText.Params.Builder builder = new PrecomputedText.Params.Builder(paint);
            this.mWrapped = builder.setBreakStrategy(strategy).setHyphenationFrequency(frequency).setTextDirection(textDir).build();
            this.mPaint = paint;
            this.mTextDir = textDir;
            this.mBreakStrategy = strategy;
            this.mHyphenationFrequency = frequency;
        }

        public boolean equals(Object o) {
            int i;
            if (o == this) {
                return 1;
            }
            final int i2 = 0;
            if (!o instanceof PrecomputedTextCompat.Params) {
                return i2;
            }
            Object obj = o;
            if (!equalsWithoutTextDirection((PrecomputedTextCompat.Params)obj)) {
                return i2;
            }
            if (this.mTextDir == obj.getTextDirection()) {
            } else {
                i = i2;
            }
            return i;
        }

        public boolean equalsWithoutTextDirection(androidx.core.text.PrecomputedTextCompat.Params other) {
            boolean typeface;
            Object textLocales;
            final int i2 = 0;
            if (this.mBreakStrategy != other.getBreakStrategy()) {
                return i2;
            }
            if (this.mHyphenationFrequency != other.getHyphenationFrequency()) {
                return i2;
            }
            if (Float.compare(textSize, textSize2) != 0) {
                return i2;
            }
            if (Float.compare(textScaleX, textScaleX2) != 0) {
                return i2;
            }
            if (Float.compare(textSkewX, textSkewX2) != 0) {
                return i2;
            }
            if (Float.compare(letterSpacing, letterSpacing2) != 0) {
                return i2;
            }
            if (!TextUtils.equals(this.mPaint.getFontFeatureSettings(), other.getTextPaint().getFontFeatureSettings())) {
                return i2;
            }
            if (this.mPaint.getFlags() != other.getTextPaint().getFlags()) {
                return i2;
            }
            if (!this.mPaint.getTextLocales().equals(other.getTextPaint().getTextLocales())) {
                return i2;
            }
            if (this.mPaint.getTypeface() == null) {
                if (other.getTextPaint().getTypeface() != null) {
                    return i2;
                }
            } else {
                if (!this.mPaint.getTypeface().equals(other.getTextPaint().getTypeface())) {
                    return i2;
                }
            }
            return 1;
        }

        public int getBreakStrategy() {
            return this.mBreakStrategy;
        }

        public int getHyphenationFrequency() {
            return this.mHyphenationFrequency;
        }

        public TextDirectionHeuristic getTextDirection() {
            return this.mTextDir;
        }

        public TextPaint getTextPaint() {
            return this.mPaint;
        }

        public int hashCode() {
            return ObjectsCompat.hash(/* result */);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("{");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder.append(stringBuilder2.append("textSize=").append(this.mPaint.getTextSize()).toString());
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder.append(stringBuilder3.append(", textScaleX=").append(this.mPaint.getTextScaleX()).toString());
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder.append(stringBuilder4.append(", textSkewX=").append(this.mPaint.getTextSkewX()).toString());
            StringBuilder stringBuilder5 = new StringBuilder();
            stringBuilder.append(stringBuilder5.append(", letterSpacing=").append(this.mPaint.getLetterSpacing()).toString());
            StringBuilder stringBuilder6 = new StringBuilder();
            stringBuilder.append(stringBuilder6.append(", elegantTextHeight=").append(this.mPaint.isElegantTextHeight()).toString());
            StringBuilder stringBuilder7 = new StringBuilder();
            stringBuilder.append(stringBuilder7.append(", textLocale=").append(this.mPaint.getTextLocales()).toString());
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder.append(stringBuilder8.append(", typeface=").append(this.mPaint.getTypeface()).toString());
            StringBuilder stringBuilder9 = new StringBuilder();
            stringBuilder.append(stringBuilder9.append(", variationSettings=").append(this.mPaint.getFontVariationSettings()).toString());
            StringBuilder stringBuilder10 = new StringBuilder();
            stringBuilder.append(stringBuilder10.append(", textDir=").append(this.mTextDir).toString());
            StringBuilder stringBuilder11 = new StringBuilder();
            stringBuilder.append(stringBuilder11.append(", breakStrategy=").append(this.mBreakStrategy).toString());
            StringBuilder stringBuilder12 = new StringBuilder();
            stringBuilder.append(stringBuilder12.append(", hyphenationFrequency=").append(this.mHyphenationFrequency).toString());
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }

    private static class PrecomputedTextFutureTask extends FutureTask<androidx.core.text.PrecomputedTextCompat> {
        PrecomputedTextFutureTask(androidx.core.text.PrecomputedTextCompat.Params params, java.lang.CharSequence text) {
            PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback precomputedTextCallback = new PrecomputedTextCompat.PrecomputedTextFutureTask.PrecomputedTextCallback(params, text);
            super(precomputedTextCallback);
        }
    }
    static {
        Object object = new Object();
        PrecomputedTextCompat.sLock = object;
        PrecomputedTextCompat.sExecutor = 0;
    }

    private PrecomputedTextCompat(PrecomputedText precomputed, androidx.core.text.PrecomputedTextCompat.Params params) {
        super();
        this.mText = PrecomputedTextCompat.Api28Impl.castToSpannable(precomputed);
        this.mParams = params;
        this.mParagraphEnds = 0;
        this.mWrapped = precomputed;
    }

    private PrecomputedTextCompat(java.lang.CharSequence text, androidx.core.text.PrecomputedTextCompat.Params params, int[] paraEnds) {
        super();
        SpannableString spannableString = new SpannableString(text);
        this.mText = spannableString;
        this.mParams = params;
        this.mParagraphEnds = paraEnds;
        this.mWrapped = 0;
    }

    public static androidx.core.text.PrecomputedTextCompat create(java.lang.CharSequence text, androidx.core.text.PrecomputedTextCompat.Params params) {
        int i;
        int paraStart;
        Integer valueOf;
        int i2;
        int paraEnd;
        int intValue;
        Preconditions.checkNotNull(text);
        Preconditions.checkNotNull(params);
        Trace.beginSection("PrecomputedText");
        if (params.mWrapped != null) {
            PrecomputedTextCompat precomputedTextCompat = new PrecomputedTextCompat(PrecomputedText.create(text, params.mWrapped), params);
            Trace.endSection();
            return precomputedTextCompat;
        }
        ArrayList arrayList = new ArrayList();
        i = 0;
        final int length = text.length();
        paraStart = 0;
        while (paraStart < length) {
            paraEnd = TextUtils.indexOf(text, '\n', paraStart, length);
            if (paraEnd < 0) {
            } else {
            }
            i = paraEnd;
            arrayList.add(Integer.valueOf(i));
            paraStart = i;
            i = length;
        }
        int[] iArr = new int[arrayList.size()];
        i2 = 0;
        while (i2 < arrayList.size()) {
            iArr[i2] = (Integer)arrayList.get(i2).intValue();
            i2++;
        }
        StaticLayout.Builder.obtain(text, 0, text.length(), params.getTextPaint(), Integer.MAX_VALUE).setBreakStrategy(params.getBreakStrategy()).setHyphenationFrequency(params.getHyphenationFrequency()).setTextDirection(params.getTextDirection()).build();
        PrecomputedTextCompat precomputedTextCompat2 = new PrecomputedTextCompat(text, params, iArr);
        Trace.endSection();
        return precomputedTextCompat2;
    }

    public static Future<androidx.core.text.PrecomputedTextCompat> getTextFuture(java.lang.CharSequence charSequence, androidx.core.text.PrecomputedTextCompat.Params params, Executor executor) {
        Object sLock;
        Object fixedThreadPool;
        Object sExecutor;
        Executor obj5;
        PrecomputedTextCompat.PrecomputedTextFutureTask precomputedTextFutureTask = new PrecomputedTextCompat.PrecomputedTextFutureTask(params, charSequence);
        sLock = PrecomputedTextCompat.sLock;
        if (executor == null && PrecomputedTextCompat.sExecutor == null) {
            sLock = PrecomputedTextCompat.sLock;
            synchronized (sLock) {
                PrecomputedTextCompat.sExecutor = Executors.newFixedThreadPool(1);
                obj5 = sExecutor;
            }
        }
        obj5.execute(precomputedTextFutureTask);
        return precomputedTextFutureTask;
    }

    @Override // android.text.Spannable
    public char charAt(int index) {
        return this.mText.charAt(index);
    }

    @Override // android.text.Spannable
    public int getParagraphCount() {
        return this.mWrapped.getParagraphCount();
    }

    @Override // android.text.Spannable
    public int getParagraphEnd(int paraIndex) {
        Preconditions.checkArgumentInRange(paraIndex, 0, getParagraphCount(), "paraIndex");
        return this.mWrapped.getParagraphEnd(paraIndex);
    }

    @Override // android.text.Spannable
    public int getParagraphStart(int paraIndex) {
        Preconditions.checkArgumentInRange(paraIndex, 0, getParagraphCount(), "paraIndex");
        return this.mWrapped.getParagraphStart(paraIndex);
    }

    @Override // android.text.Spannable
    public androidx.core.text.PrecomputedTextCompat.Params getParams() {
        return this.mParams;
    }

    @Override // android.text.Spannable
    public PrecomputedText getPrecomputedText() {
        if (mText instanceof PrecomputedText) {
            return (PrecomputedText)this.mText;
        }
        return null;
    }

    @Override // android.text.Spannable
    public int getSpanEnd(Object tag) {
        return this.mText.getSpanEnd(tag);
    }

    @Override // android.text.Spannable
    public int getSpanFlags(Object tag) {
        return this.mText.getSpanFlags(tag);
    }

    @Override // android.text.Spannable
    public int getSpanStart(Object tag) {
        return this.mText.getSpanStart(tag);
    }

    public <T> T[] getSpans(int start, int end, Class<T> class3) {
        return this.mWrapped.getSpans(start, end, class3);
    }

    @Override // android.text.Spannable
    public int length() {
        return this.mText.length();
    }

    @Override // android.text.Spannable
    public int nextSpanTransition(int start, int limit, Class type) {
        return this.mText.nextSpanTransition(start, limit, type);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object what) {
        if (what instanceof MetricAffectingSpan) {
        } else {
            this.mWrapped.removeSpan(what);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        throw illegalArgumentException;
    }

    @Override // android.text.Spannable
    public void setSpan(Object what, int start, int end, int flags) {
        if (what instanceof MetricAffectingSpan) {
        } else {
            this.mWrapped.setSpan(what, start, end, flags);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        throw illegalArgumentException;
    }

    @Override // android.text.Spannable
    public java.lang.CharSequence subSequence(int start, int end) {
        return this.mText.subSequence(start, end);
    }

    @Override // android.text.Spannable
    public String toString() {
        return this.mText.toString();
    }
}
