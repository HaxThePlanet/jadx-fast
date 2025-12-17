package androidx.emoji2.text;

import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.style.ReplacementSpan;
import androidx.core.util.Preconditions;

/* loaded from: classes5.dex */
public abstract class EmojiSpan extends ReplacementSpan {

    private short mHeight = -1;
    private final androidx.emoji2.text.TypefaceEmojiRasterizer mRasterizer;
    private float mRatio = 1f;
    private final Paint.FontMetricsInt mTmpFontMetrics;
    private short mWidth = -1;
    EmojiSpan(androidx.emoji2.text.TypefaceEmojiRasterizer rasterizer) {
        super();
        Paint.FontMetricsInt fontMetricsInt = new Paint.FontMetricsInt();
        this.mTmpFontMetrics = fontMetricsInt;
        int i = -1;
        int i2 = 1065353216;
        Preconditions.checkNotNull(rasterizer, "rasterizer cannot be null");
        this.mRasterizer = rasterizer;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getHeight() {
        return this.mHeight;
    }

    @Override // android.text.style.ReplacementSpan
    public final int getId() {
        return getTypefaceRasterizer().getId();
    }

    @Override // android.text.style.ReplacementSpan
    final float getRatio() {
        return this.mRatio;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, java.lang.CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        short bottom;
        paint.getFontMetricsInt(this.mTmpFontMetrics);
        this.mRatio = i3 /= f4;
        this.mHeight = (short)i6;
        this.mWidth = (short)i8;
        if (fm != null) {
            fm.ascent = mTmpFontMetrics4.ascent;
            fm.descent = mTmpFontMetrics5.descent;
            fm.top = mTmpFontMetrics6.top;
            fm.bottom = mTmpFontMetrics7.bottom;
        }
        return this.mWidth;
    }

    @Override // android.text.style.ReplacementSpan
    public final androidx.emoji2.text.TypefaceEmojiRasterizer getTypefaceRasterizer() {
        return this.mRasterizer;
    }

    @Override // android.text.style.ReplacementSpan
    final int getWidth() {
        return this.mWidth;
    }
}
