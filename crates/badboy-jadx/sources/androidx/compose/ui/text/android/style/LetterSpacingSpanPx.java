package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u000c\u0010\u000c\u001a\u00020\u0008*\u00020\nH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\r", d2 = {"Landroidx/compose/ui/text/android/style/LetterSpacingSpanPx;", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "", "(F)V", "getLetterSpacing", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "updatePaint", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LetterSpacingSpanPx extends MetricAffectingSpan {

    public static final int $stable;
    private final float letterSpacing;
    static {
    }

    public LetterSpacingSpanPx(float letterSpacing) {
        super();
        this.letterSpacing = letterSpacing;
    }

    private final void updatePaint(TextPaint $this$updatePaint) {
        int i;
        textSize *= textScaleX;
        i = Float.compare(i2, i3) == 0 ? 1 : 0;
        if (i == 0) {
            $this$updatePaint.setLetterSpacing(letterSpacing /= i2);
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final float getLetterSpacing() {
        return this.letterSpacing;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateDrawState(TextPaint textPaint) {
        updatePaint(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        updatePaint(textPaint);
    }
}
