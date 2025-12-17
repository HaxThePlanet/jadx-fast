package androidx.compose.ui.text.android.style;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0001\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J8\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J'\u0010$\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008H\u0000¢\u0006\u0002\u0008%R\u000e\u0010\u000c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006&", d2 = {"Landroidx/compose/ui/text/android/style/LineHeightStyleSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "startIndex", "", "endIndex", "trimFirstLineTop", "", "trimLastLineBottom", "topRatio", "(FIIZZF)V", "ascent", "descent", "firstAscent", "<set-?>", "firstAscentDiff", "getFirstAscentDiff", "()I", "lastDescent", "lastDescentDiff", "getLastDescentDiff", "getLineHeight", "()F", "getTrimLastLineBottom", "()Z", "calculateTargetMetrics", "", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "chooseHeight", "text", "", "start", "end", "spanStartVertical", "copy", "copy$ui_text_release", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LineHeightStyleSpan implements LineHeightSpan {

    public static final int $stable = 8;
    private int ascent = Integer.MIN_VALUE;
    private int descent = Integer.MIN_VALUE;
    private final int endIndex;
    private int firstAscent = Integer.MIN_VALUE;
    private int firstAscentDiff;
    private int lastDescent = Integer.MIN_VALUE;
    private int lastDescentDiff;
    private final float lineHeight;
    private final int startIndex;
    private final float topRatio;
    private final boolean trimFirstLineTop;
    private final boolean trimLastLineBottom;
    static {
        final int i = 8;
    }

    public LineHeightStyleSpan(float lineHeight, int startIndex, int endIndex, boolean trimFirstLineTop, boolean trimLastLineBottom, float topRatio) {
        float topRatio2;
        int i;
        int cmp;
        int i2;
        super();
        this.lineHeight = lineHeight;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.trimFirstLineTop = trimFirstLineTop;
        this.trimLastLineBottom = trimLastLineBottom;
        this.topRatio = topRatio;
        int i3 = Integer.MIN_VALUE;
        topRatio2 = this.topRatio;
        i2 = 1;
        final int i6 = 0;
        if (Float.compare(i5, topRatio2) <= 0 && Float.compare(topRatio2, cmp) <= 0) {
            i = Float.compare(topRatio2, cmp) <= 0 ? i2 : i6;
        } else {
        }
        if (i == 0) {
            i = Float.compare(topRatio3, cmp) == 0 ? i2 : i6;
            if (i != 0) {
            } else {
                i2 = i6;
            }
        }
        if (i2 == 0) {
        } else {
        }
        int i4 = 0;
        IllegalStateException $i$a$CheckLineHeightStyleSpan$1 = new IllegalStateException("topRatio should be in [0..1] range or -1".toString());
        throw $i$a$CheckLineHeightStyleSpan$1;
    }

    private final void calculateTargetMetrics(Paint.FontMetricsInt fontMetricsInt) {
        int i;
        int topRatio;
        float i2;
        int i3;
        double d;
        int ascent;
        int descent;
        int i4 = (int)f;
        final int i5 = i4 - lineHeight;
        i = Float.compare(topRatio2, i2) == 0 ? 1 : 0;
        if (i != 0) {
            f3 /= i2;
        } else {
            topRatio = this.topRatio;
        }
        if (i5 <= 0) {
            i3 = (int)f5;
        } else {
            i12 -= topRatio;
            i3 = (int)f7;
        }
        this.descent = descent2 += i3;
        this.ascent = descent3 -= i4;
        ascent = this.trimFirstLineTop ? fontMetricsInt.ascent : this.ascent;
        this.firstAscent = ascent;
        descent = this.trimLastLineBottom ? fontMetricsInt.descent : this.descent;
        this.lastDescent = descent;
        this.firstAscentDiff = ascent3 -= firstAscent;
        this.lastDescentDiff = lastDescent -= descent4;
    }

    public static androidx.compose.ui.text.android.style.LineHeightStyleSpan copy$ui_text_release$default(androidx.compose.ui.text.android.style.LineHeightStyleSpan lineHeightStyleSpan, int i2, int i3, boolean z4, int i5, Object object6) {
        boolean obj3;
        if (i5 &= 4 != 0) {
            obj3 = lineHeightStyleSpan.trimFirstLineTop;
        }
        return lineHeightStyleSpan.copy$ui_text_release(i2, i3, obj3);
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(java.lang.CharSequence text, int start, int end, int spanStartVertical, int lineHeight, Paint.FontMetricsInt fontMetricsInt) {
        int i2;
        int i;
        int trimLastLineBottom;
        int firstAscent;
        int lastDescent;
        if (LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt) <= 0) {
        }
        trimLastLineBottom = 0;
        i2 = start == this.startIndex ? i : trimLastLineBottom;
        if (end == this.endIndex) {
        } else {
            i = trimLastLineBottom;
        }
        if (i2 != 0 && i != 0 && this.trimFirstLineTop && this.trimLastLineBottom) {
            if (i != 0) {
                if (this.trimFirstLineTop) {
                    if (this.trimLastLineBottom) {
                    }
                }
            }
        }
        if (this.firstAscent == Integer.MIN_VALUE) {
            calculateTargetMetrics(fontMetricsInt);
        }
        firstAscent = i2 != 0 ? this.firstAscent : this.ascent;
        fontMetricsInt.ascent = firstAscent;
        lastDescent = i != 0 ? this.lastDescent : this.descent;
        fontMetricsInt.descent = lastDescent;
    }

    @Override // android.text.style.LineHeightSpan
    public final androidx.compose.ui.text.android.style.LineHeightStyleSpan copy$ui_text_release(int startIndex, int endIndex, boolean trimFirstLineTop) {
        LineHeightStyleSpan lineHeightStyleSpan = new LineHeightStyleSpan(this.lineHeight, startIndex, endIndex, trimFirstLineTop, this.trimLastLineBottom, this.topRatio);
        return lineHeightStyleSpan;
    }

    @Override // android.text.style.LineHeightSpan
    public final int getFirstAscentDiff() {
        return this.firstAscentDiff;
    }

    @Override // android.text.style.LineHeightSpan
    public final int getLastDescentDiff() {
        return this.lastDescentDiff;
    }

    @Override // android.text.style.LineHeightSpan
    public final float getLineHeight() {
        return this.lineHeight;
    }

    @Override // android.text.style.LineHeightSpan
    public final boolean getTrimLastLineBottom() {
        return this.trimLastLineBottom;
    }
}
