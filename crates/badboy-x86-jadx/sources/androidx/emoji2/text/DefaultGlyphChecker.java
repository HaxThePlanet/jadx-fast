package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;

/* loaded from: classes5.dex */
class DefaultGlyphChecker implements androidx.emoji2.text.EmojiCompat.GlyphChecker {

    private static final int PAINT_TEXT_SIZE = 10;
    private static final java.lang.ThreadLocal<StringBuilder> sStringBuilder;
    private final TextPaint mTextPaint;
    static {
        ThreadLocal threadLocal = new ThreadLocal();
        DefaultGlyphChecker.sStringBuilder = threadLocal;
    }

    DefaultGlyphChecker() {
        super();
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        this.mTextPaint.setTextSize(1092616192);
    }

    private static StringBuilder getStringBuilder() {
        Object sStringBuilder;
        StringBuilder stringBuilder;
        if (DefaultGlyphChecker.sStringBuilder.get() == null) {
            stringBuilder = new StringBuilder();
            DefaultGlyphChecker.sStringBuilder.set(stringBuilder);
        }
        return (StringBuilder)DefaultGlyphChecker.sStringBuilder.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat$GlyphChecker
    public boolean hasGlyph(java.lang.CharSequence charSequence, int start, int end, int sdkAdded) {
        int charAt;
        int obj5;
        final StringBuilder stringBuilder = DefaultGlyphChecker.getStringBuilder();
        stringBuilder.setLength(0);
        while (obj5 < end) {
            stringBuilder.append(charSequence.charAt(obj5));
            obj5++;
        }
        return PaintCompat.hasGlyph(this.mTextPaint, stringBuilder.toString());
    }
}
