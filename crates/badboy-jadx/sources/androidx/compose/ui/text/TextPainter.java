package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shadow.Companion;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextForegroundStyle.Unspecified;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/text/TextPainter;", "", "()V", "paint", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextPainter {

    public static final int $stable;
    public static final androidx.compose.ui.text.TextPainter INSTANCE;
    static {
        TextPainter textPainter = new TextPainter();
        TextPainter.INSTANCE = textPainter;
    }

    public final void paint(Canvas canvas, androidx.compose.ui.text.TextLayoutResult textLayoutResult) {
        boolean hasVisualOverflow;
        int i4;
        TextDecoration textDecoration;
        Shadow shadow;
        androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle;
        Color.Companion textForegroundStyle$ui_text_release;
        int visible-gIe3tQ8;
        float f;
        androidx.compose.ui.text.MultiParagraph multiParagraph;
        long l2;
        Canvas canvas2;
        long l;
        long black-0d7_KjU;
        int i3;
        int i5;
        int i;
        int i2;
        androidx.compose.ui.graphics.Brush obj14;
        int i6 = 0;
        if (textLayoutResult.getHasVisualOverflow() && !TextOverflow.equals-impl0(textLayoutResult.getLayoutInput().getOverflow-gIe3tQ8(), TextOverflow.Companion.getVisible-gIe3tQ8())) {
            i4 = !TextOverflow.equals-impl0(textLayoutResult.getLayoutInput().getOverflow-gIe3tQ8(), TextOverflow.Companion.getVisible-gIe3tQ8()) ? 1 : i6;
        } else {
        }
        int i7 = i4;
        if (i7 != 0) {
            canvas.save();
            Canvas.clipRect-mtrdD-E$default(canvas, RectKt.Rect-tz77jQw(Offset.Companion.getZero-F1C5BW0(), obj5), i6, 2, 0);
        }
        androidx.compose.ui.text.SpanStyle spanStyle$ui_text_release = textLayoutResult.getLayoutInput().getStyle().getSpanStyle$ui_text_release();
        if (spanStyle$ui_text_release.getTextDecoration() == null) {
            textDecoration = TextDecoration.Companion.getNone();
        }
        final TextDecoration textDecoration2 = textDecoration;
        if (spanStyle$ui_text_release.getShadow() == null) {
            shadow = Shadow.Companion.getNone();
        }
        final Shadow shadow2 = shadow;
        if (spanStyle$ui_text_release.getDrawStyle() == null) {
            drawStyle = Fill.INSTANCE;
        }
        final androidx.compose.ui.graphics.drawscope.DrawStyle drawStyle2 = drawStyle;
        black-0d7_KjU = spanStyle$ui_text_release.getBrush();
        if (black-0d7_KjU != null) {
            if (spanStyle$ui_text_release.getTextForegroundStyle$ui_text_release() != TextForegroundStyle.Unspecified.INSTANCE) {
                i3 = textForegroundStyle$ui_text_release;
            } else {
                i3 = textForegroundStyle$ui_text_release;
            }
            MultiParagraph.paint-hn5TExg$default(textLayoutResult.getMultiParagraph(), canvas, black-0d7_KjU, i3, shadow2, textDecoration2, drawStyle2, 0, 64, 0);
            obj14 = black-0d7_KjU;
        } else {
            obj14 = black-0d7_KjU;
            if (spanStyle$ui_text_release.getTextForegroundStyle$ui_text_release() != TextForegroundStyle.Unspecified.INSTANCE) {
                black-0d7_KjU = spanStyle$ui_text_release.getTextForegroundStyle$ui_text_release().getColor-0d7_KjU();
            } else {
                black-0d7_KjU = Color.Companion.getBlack-0d7_KjU();
            }
            MultiParagraph.paint-LG529CI$default(textLayoutResult.getMultiParagraph(), canvas, black-0d7_KjU, i3, shadow2, textDecoration2, drawStyle2, 0, 32);
        }
        if (i7 != 0) {
            canvas2.restore();
        }
    }
}
