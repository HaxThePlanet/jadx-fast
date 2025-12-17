package androidx.emoji2.text;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.stream.IntStream;

/* loaded from: classes5.dex */
class UnprecomputeTextOnModificationSpannable implements Spannable {

    private Spannable mDelegate;
    private boolean mSafeToWrite = false;

    private static class CharSequenceHelper_API24 {
        static IntStream chars(java.lang.CharSequence charSequence) {
            return charSequence.chars();
        }

        static IntStream codePoints(java.lang.CharSequence charSequence) {
            return charSequence.codePoints();
        }
    }

    static class PrecomputedTextDetector {
        boolean isPrecomputedText(java.lang.CharSequence text) {
            return text instanceof PrecomputedTextCompat;
        }
    }

    static class PrecomputedTextDetector_28 extends androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector {
        @Override // androidx.emoji2.text.UnprecomputeTextOnModificationSpannable$PrecomputedTextDetector
        boolean isPrecomputedText(java.lang.CharSequence text) {
            int i;
            boolean z;
            if (!text instanceof PrecomputedText) {
                if (text instanceof PrecomputedTextCompat) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }
    }
    UnprecomputeTextOnModificationSpannable(Spannable delegate) {
        super();
        final int i = 0;
        this.mDelegate = delegate;
    }

    UnprecomputeTextOnModificationSpannable(Spanned delegate) {
        super();
        int i = 0;
        SpannableString spannableString = new SpannableString(delegate);
        this.mDelegate = spannableString;
    }

    UnprecomputeTextOnModificationSpannable(java.lang.CharSequence delegate) {
        super();
        int i = 0;
        SpannableString spannableString = new SpannableString(delegate);
        this.mDelegate = spannableString;
    }

    private void ensureSafeWrites() {
        boolean precomputedText;
        final Spannable mDelegate = this.mDelegate;
        if (!this.mSafeToWrite && UnprecomputeTextOnModificationSpannable.precomputedTextDetector().isPrecomputedText(mDelegate)) {
            if (UnprecomputeTextOnModificationSpannable.precomputedTextDetector().isPrecomputedText(mDelegate)) {
                precomputedText = new SpannableString(mDelegate);
                this.mDelegate = precomputedText;
            }
        }
        this.mSafeToWrite = true;
    }

    static androidx.emoji2.text.UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector precomputedTextDetector() {
        UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector_28 precomputedTextDetector_28 = new UnprecomputeTextOnModificationSpannable.PrecomputedTextDetector_28();
        return precomputedTextDetector_28;
    }

    @Override // android.text.Spannable
    public char charAt(int i) {
        return this.mDelegate.charAt(i);
    }

    @Override // android.text.Spannable
    public IntStream chars() {
        return UnprecomputeTextOnModificationSpannable.CharSequenceHelper_API24.chars(this.mDelegate);
    }

    @Override // android.text.Spannable
    public IntStream codePoints() {
        return UnprecomputeTextOnModificationSpannable.CharSequenceHelper_API24.codePoints(this.mDelegate);
    }

    @Override // android.text.Spannable
    public int getSpanEnd(Object o) {
        return this.mDelegate.getSpanEnd(o);
    }

    @Override // android.text.Spannable
    public int getSpanFlags(Object o) {
        return this.mDelegate.getSpanFlags(o);
    }

    @Override // android.text.Spannable
    public int getSpanStart(Object o) {
        return this.mDelegate.getSpanStart(o);
    }

    public <T> T[] getSpans(int i, int i1, Class<T> class3) {
        return this.mDelegate.getSpans(i, i1, class3);
    }

    @Override // android.text.Spannable
    Spannable getUnwrappedSpannable() {
        return this.mDelegate;
    }

    @Override // android.text.Spannable
    public int length() {
        return this.mDelegate.length();
    }

    @Override // android.text.Spannable
    public int nextSpanTransition(int i, int i1, Class aClass) {
        return this.mDelegate.nextSpanTransition(i, i1, aClass);
    }

    @Override // android.text.Spannable
    public void removeSpan(Object o) {
        ensureSafeWrites();
        this.mDelegate.removeSpan(o);
    }

    @Override // android.text.Spannable
    public void setSpan(Object o, int i, int i1, int i2) {
        ensureSafeWrites();
        this.mDelegate.setSpan(o, i, i1, i2);
    }

    @Override // android.text.Spannable
    public java.lang.CharSequence subSequence(int i, int i1) {
        return this.mDelegate.subSequence(i, i1);
    }

    @Override // android.text.Spannable
    public String toString() {
        return this.mDelegate.toString();
    }
}
