package androidx.compose.ui.text.platform;

import android.graphics.Matrix;
import android.graphics.Shader;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.Paragraph;
import androidx.compose.ui.text.ParagraphInfo;
import androidx.compose.ui.text.style.TextDecoration;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a^\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\n\u0008\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\u0008\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012\u001aT\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0012\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0015", d2 = {"drawMultiParagraph", "", "Landroidx/compose/ui/text/MultiParagraph;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "decoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawMultiParagraph-7AXcY_I", "(Landroidx/compose/ui/text/MultiParagraph;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "drawParagraphs", "drawParagraphs-7AXcY_I", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidMultiParagraphDraw_androidKt {
    public static final void drawMultiParagraph-7AXcY_I(MultiParagraph $this$drawMultiParagraph_u2d7AXcY_I, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        int height;
        int width;
        Shader shader-uvyYCjk;
        Matrix matrix;
        int index$iv2;
        List paragraphInfoList$ui_text_release;
        int i3;
        int index$iv;
        int size;
        int i2;
        float width2;
        int i5;
        int i;
        int i6;
        Canvas canvas2;
        Canvas canvas3;
        float f;
        Shadow shadow2;
        TextDecoration textDecoration;
        DrawStyle drawStyle2;
        int i4;
        final Object obj = brush;
        canvas.save();
        if ($this$drawMultiParagraph_u2d7AXcY_I.getParagraphInfoList$ui_text_release().size() <= 1) {
            AndroidMultiParagraphDraw_androidKt.drawParagraphs-7AXcY_I($this$drawMultiParagraph_u2d7AXcY_I, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
            canvas3 = canvas;
        } else {
            if (obj instanceof SolidColor) {
                AndroidMultiParagraphDraw_androidKt.drawParagraphs-7AXcY_I($this$drawMultiParagraph_u2d7AXcY_I, canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
                canvas3 = canvas;
            } else {
                if (obj instanceof ShaderBrush) {
                    height = 0;
                    width = 0;
                    List paragraphInfoList$ui_text_release3 = $this$drawMultiParagraph_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
                    int i7 = 0;
                    index$iv2 = 0;
                    while (index$iv2 < paragraphInfoList$ui_text_release3.size()) {
                        size = index$iv;
                        i2 = 0;
                        height += height2;
                        width = Math.max(width, size.getParagraph().getWidth());
                        index$iv2++;
                    }
                    shader-uvyYCjk = (ShaderBrush)obj.createShader-uvyYCjk(SizeKt.Size(width, height));
                    matrix = new Matrix();
                    shader-uvyYCjk.getLocalMatrix(matrix);
                    paragraphInfoList$ui_text_release = $this$drawMultiParagraph_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
                    i3 = 0;
                    index$iv = 0;
                    while (index$iv < paragraphInfoList$ui_text_release.size()) {
                        width2 = i2;
                        i5 = 0;
                        (ParagraphInfo)width2.getParagraph().paint-hn5TExg(canvas, (Brush)BrushKt.ShaderBrush(shader-uvyYCjk), alpha, shadow, decoration, drawStyle, blendMode);
                        i6 = 0;
                        canvas.translate(i6, width2.getParagraph().getHeight());
                        matrix.setTranslate(i6, -height4);
                        shader-uvyYCjk.setLocalMatrix(matrix);
                        index$iv++;
                    }
                    canvas3 = canvas;
                } else {
                    canvas3 = canvas;
                }
            }
        }
        canvas3.restore();
    }

    public static void drawMultiParagraph-7AXcY_I$default(MultiParagraph multiParagraph, Canvas canvas2, Brush brush3, float f4, Shadow shadow5, TextDecoration textDecoration6, DrawStyle drawStyle7, int i8, int i9, Object object10) {
        int i4;
        int i3;
        int i;
        int i2;
        int i5;
        int obj11;
        i4 = i9 & 4 != 0 ? obj11 : f4;
        int i7 = 0;
        i3 = i9 & 8 != 0 ? i7 : shadow5;
        i = i9 & 16 != 0 ? i7 : textDecoration6;
        i2 = i9 & 32 != 0 ? i7 : drawStyle7;
        if (i9 & 64 != 0) {
            i5 = obj11;
        } else {
            i5 = i8;
        }
        AndroidMultiParagraphDraw_androidKt.drawMultiParagraph-7AXcY_I(multiParagraph, canvas2, brush3, i4, i3, i, i2, i5);
    }

    private static final void drawParagraphs-7AXcY_I(MultiParagraph $this$drawParagraphs_u2d7AXcY_I, Canvas canvas, Brush brush, float alpha, Shadow shadow, TextDecoration decoration, DrawStyle drawStyle, int blendMode) {
        int index$iv;
        Object obj;
        Object obj2;
        int i3;
        float height;
        int i2;
        Canvas canvas2;
        float f;
        Shadow shadow2;
        TextDecoration textDecoration;
        DrawStyle drawStyle2;
        int i;
        final List paragraphInfoList$ui_text_release = $this$drawParagraphs_u2d7AXcY_I.getParagraphInfoList$ui_text_release();
        final int i4 = 0;
        index$iv = 0;
        while (index$iv < paragraphInfoList$ui_text_release.size()) {
            obj2 = obj;
            i3 = 0;
            (ParagraphInfo)obj2.getParagraph().paint-hn5TExg(canvas, brush, alpha, shadow, decoration, drawStyle, blendMode);
            canvas.translate(0, obj2.getParagraph().getHeight());
            index$iv++;
        }
        Canvas canvas4 = canvas;
    }
}
