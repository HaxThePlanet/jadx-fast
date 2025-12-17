package androidx.compose.ui.text.android.style;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0010\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Landroidx/compose/ui/text/android/style/SkewXSpan;", "Landroid/text/style/MetricAffectingSpan;", "skewX", "", "(F)V", "getSkewX", "()F", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "updateMeasureState", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class SkewXSpan extends MetricAffectingSpan {

    public static final int $stable;
    private final float skewX;
    static {
    }

    public SkewXSpan(float skewX) {
        super();
        this.skewX = skewX;
    }

    @Override // android.text.style.MetricAffectingSpan
    public final float getSkewX() {
        return this.skewX;
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateDrawState(TextPaint textPaint) {
        textPaint.setTextSkewX(skewX += textSkewX);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        textPaint.setTextSkewX(skewX += textSkewX);
    }
}
