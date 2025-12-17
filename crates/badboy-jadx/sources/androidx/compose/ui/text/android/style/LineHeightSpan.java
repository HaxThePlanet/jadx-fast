package androidx.compose.ui.text.android.style;

import android.graphics.Paint.FontMetricsInt;
import android.text.style.LineHeightSpan;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J8\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\u0002\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Landroidx/compose/ui/text/android/style/LineHeightSpan;", "Landroid/text/style/LineHeightSpan;", "lineHeight", "", "(F)V", "getLineHeight", "()F", "chooseHeight", "", "text", "", "start", "", "end", "spanstartVertical", "fontMetricsInt", "Landroid/graphics/Paint$FontMetricsInt;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LineHeightSpan implements LineHeightSpan {

    public static final int $stable;
    private final float lineHeight;
    static {
    }

    public LineHeightSpan(float lineHeight) {
        super();
        this.lineHeight = lineHeight;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(java.lang.CharSequence text, int start, int end, int spanstartVertical, int lineHeight, Paint.FontMetricsInt fontMetricsInt) {
        final int lineHeight2 = LineHeightStyleSpan_androidKt.lineHeight(fontMetricsInt);
        if (lineHeight2 <= 0) {
        }
        int i = (int)f;
        fontMetricsInt.descent = (int)ceil2;
        fontMetricsInt.ascent = descent2 -= i;
    }

    @Override // android.text.style.LineHeightSpan
    public final float getLineHeight() {
        return this.lineHeight;
    }
}
