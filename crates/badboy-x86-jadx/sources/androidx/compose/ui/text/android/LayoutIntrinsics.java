package androidx.compose.ui.text.android;

import android.text.BoringLayout.Metrics;
import android.text.Layout;
import android.text.TextPaint;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/ui/text/android/LayoutIntrinsics;", "", "charSequence", "", "textPaint", "Landroid/text/TextPaint;", "textDirectionHeuristic", "", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;I)V", "_boringMetrics", "Landroid/text/BoringLayout$Metrics;", "_maxIntrinsicWidth", "", "_minIntrinsicWidth", "boringMetrics", "getBoringMetrics", "()Landroid/text/BoringLayout$Metrics;", "boringMetricsIsInit", "", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()F", "minIntrinsicWidth", "getMinIntrinsicWidth", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LayoutIntrinsics {

    public static final int $stable = 8;
    private BoringLayout.Metrics _boringMetrics;
    private float _maxIntrinsicWidth = NaNf;
    private float _minIntrinsicWidth = NaNf;
    private boolean boringMetricsIsInit;
    private final java.lang.CharSequence charSequence;
    private final int textDirectionHeuristic;
    private final TextPaint textPaint;
    static {
        final int i = 8;
    }

    public LayoutIntrinsics(java.lang.CharSequence charSequence, TextPaint textPaint, int textDirectionHeuristic) {
        super();
        this.charSequence = charSequence;
        this.textPaint = textPaint;
        this.textDirectionHeuristic = textDirectionHeuristic;
        final int i = 2143289344;
    }

    public final BoringLayout.Metrics getBoringMetrics() {
        boolean textDirectionHeuristic;
        int i;
        java.lang.CharSequence charSequence;
        TextPaint textPaint;
        if (!this.boringMetricsIsInit) {
            this._boringMetrics = BoringLayoutFactory.INSTANCE.measure(this.charSequence, this.textPaint, TextLayout_androidKt.getTextDirectionHeuristic(this.textDirectionHeuristic));
            this.boringMetricsIsInit = true;
        }
        return this._boringMetrics;
    }

    public final float getMaxIntrinsicWidth() {
        float desiredWidth;
        int width;
        float desiredWidth2;
        float _maxIntrinsicWidth;
        int cmp;
        boolean z;
        TextPaint textPaint2;
        TextPaint textPaint;
        int i;
        if (!Float.isNaN(this._maxIntrinsicWidth)) {
            desiredWidth = this._maxIntrinsicWidth;
        } else {
            BoringLayout.Metrics boringMetrics = getBoringMetrics();
            width = boringMetrics != null ? boringMetrics.width : -1;
            if (Float.compare(desiredWidth2, i2) < 0) {
                textPaint2 = this.charSequence.length();
                desiredWidth2 = cmp;
            }
            if (LayoutIntrinsics_androidKt.access$shouldIncreaseMaxIntrinsic(desiredWidth2, this.charSequence, this.textPaint)) {
                desiredWidth2 += z;
            }
            this._maxIntrinsicWidth = desiredWidth2;
            desiredWidth = _maxIntrinsicWidth;
        }
        return desiredWidth;
    }

    public final float getMinIntrinsicWidth() {
        float _minIntrinsicWidth;
        TextPaint textPaint;
        if (!Float.isNaN(this._minIntrinsicWidth)) {
            _minIntrinsicWidth = this._minIntrinsicWidth;
        } else {
            this._minIntrinsicWidth = LayoutIntrinsics_androidKt.minIntrinsicWidth(this.charSequence, this.textPaint);
            _minIntrinsicWidth = this._minIntrinsicWidth;
        }
        return _minIntrinsicWidth;
    }
}
