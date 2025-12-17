package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.Size.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.text.style.TextOverflow.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSize;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0096\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001af\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001ah\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u000c2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001a\u001a\u0080\u0001\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0014\u0008\u0002\u0010'\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020*0)0(2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001aj\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020/2\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001a&\u00102\u001a\u000203*\u00020\u00062\u0006\u0010+\u001a\u00020,2\u0006\u0010\t\u001a\u00020\nH\u0002ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00066", d2 = {"clip", "", "Landroidx/compose/ui/graphics/drawscope/DrawTransform;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "drawText", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "brush", "Landroidx/compose/ui/graphics/Brush;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "alpha", "", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawText-LVfH_YU", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;Landroidx/compose/ui/graphics/Brush;JFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawText-d8-rzKo", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextLayoutResult;JJFLandroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/drawscope/DrawStyle;I)V", "textMeasurer", "Landroidx/compose/ui/text/TextMeasurer;", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "size", "Landroidx/compose/ui/geometry/Size;", "drawText-JFhB2K4", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Landroidx/compose/ui/text/AnnotatedString;JLandroidx/compose/ui/text/TextStyle;IZILjava/util/List;JI)V", "", "drawText-TPWCCtM", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/text/TextMeasurer;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;IZIJI)V", "textLayoutConstraints", "Landroidx/compose/ui/unit/Constraints;", "textLayoutConstraints-v_w8tDc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJ)J", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextPainterKt {
    private static final void clip(DrawTransform $this$clip, androidx.compose.ui.text.TextLayoutResult textLayoutResult) {
        boolean hasVisualOverflow;
        DrawTransform $this$clip2;
        int i;
        int i2;
        float f;
        float f2;
        int i3;
        int i4;
        int i5;
        if (textLayoutResult.getHasVisualOverflow()) {
            int visible-gIe3tQ8 = TextOverflow.Companion.getVisible-gIe3tQ8();
            if (!TextOverflow.equals-impl0(textLayoutResult.getLayoutInput().getOverflow-gIe3tQ8(), visible-gIe3tQ8)) {
                DrawTransform.clipRect-N_I0leg$default($this$clip, 0, 0, (float)width-impl, (float)hasVisualOverflow, 0, 16, 0);
            } else {
                $this$clip2 = $this$clip;
            }
        } else {
            $this$clip2 = $this$clip;
        }
    }

    public static final void drawText-JFhB2K4(DrawScope $this$drawText_u2dJFhB2K4, androidx.compose.ui.text.TextMeasurer textMeasurer, androidx.compose.ui.text.AnnotatedString text, long topLeft, androidx.compose.ui.text.TextStyle style, int overflow, boolean softWrap, int maxLines, List<androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.Placeholder>> placeholders, long size, int blendMode) {
        final androidx.compose.ui.unit.Density density2 = $this$drawText_u2dJFhB2K4;
        final long l = topLeft;
        final int i8 = 0;
        final boolean z = placeholders;
        androidx.compose.ui.text.TextLayoutResult measure-xDpz5zY$default = TextMeasurer.measure-xDpz5zY$default(textMeasurer, text, overflow, softWrap, maxLines, z, size, TextPainterKt.textLayoutConstraints-v_w8tDc(density2, blendMode, obj5), obj14, density2.getLayoutDirection(), (Density)density2, i8, 0, 1536);
        androidx.compose.ui.unit.Density density3 = $this$drawText_u2dJFhB2K4;
        int i = 0;
        DrawContext drawContext = density3.getDrawContext();
        int i2 = 0;
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        int i5 = 0;
        transform.translate(Offset.getX-impl(l), Offset.getY-impl(l));
        TextPainterKt.clip(transform, measure-xDpz5zY$default);
        int i6 = 0;
        MultiParagraph.paint-LG529CI$default(measure-xDpz5zY$default.getMultiParagraph(), density3.getDrawContext().getCanvas(), 0, i8, 0, 0, 0, obj36, 30);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void drawText-JFhB2K4$default(DrawScope drawScope, androidx.compose.ui.text.TextMeasurer textMeasurer2, androidx.compose.ui.text.AnnotatedString annotatedString3, long l4, androidx.compose.ui.text.TextStyle textStyle5, int i6, boolean z7, int i8, List list9, long l10, int i11, int i12, Object object13) {
        int defaultBlendMode-0nO6VwU;
        long zero-F1C5BW0;
        androidx.compose.ui.text.TextStyle default;
        int clip-gIe3tQ8;
        int i;
        int i7;
        int emptyList;
        int unspecified-NH-jbRc;
        long l;
        androidx.compose.ui.text.TextStyle textStyle;
        int i2;
        int i4;
        int i3;
        List list;
        long l2;
        int i5;
        int i9 = obj29;
        if (i9 & 4 != 0) {
            l = zero-F1C5BW0;
        } else {
            l = l4;
        }
        if (i9 & 8 != 0) {
            textStyle = default;
        } else {
            textStyle = i6;
        }
        if (i9 & 16 != 0) {
            i2 = clip-gIe3tQ8;
        } else {
            i2 = z7;
        }
        i4 = i9 & 32 != 0 ? i : i8;
        i3 = i9 & 64 != 0 ? i7 : list9;
        if (i9 & 128 != 0) {
            list = emptyList;
        } else {
            list = l10;
        }
        if (i9 & 256 != 0) {
            l2 = unspecified-NH-jbRc;
        } else {
            l2 = i11;
        }
        if (i9 &= 512 != 0) {
            i5 = defaultBlendMode-0nO6VwU;
        } else {
            i5 = object13;
        }
        TextPainterKt.drawText-JFhB2K4(drawScope, textMeasurer2, annotatedString3, l, obj7, textStyle, i2, i4, i3, list, l2);
    }

    public static final void drawText-LVfH_YU(DrawScope $this$drawText_u2dLVfH_YU, androidx.compose.ui.text.TextLayoutResult textLayoutResult, Brush brush, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Shadow textDecoration3;
        float naN;
        float f;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        androidx.compose.ui.text.TextLayoutResult textLayoutResult2;
        if (textDecoration == null) {
            textDecoration3 = textLayoutResult.getLayoutInput().getStyle().getShadow();
        } else {
            textDecoration3 = textDecoration;
        }
        if (drawStyle == null) {
            textDecoration2 = textDecoration3;
        } else {
            textDecoration2 = drawStyle;
        }
        if (blendMode == null) {
            drawStyle2 = textDecoration3;
        } else {
            drawStyle2 = blendMode;
        }
        final Object obj2 = $this$drawText_u2dLVfH_YU;
        final int i3 = 0;
        final DrawContext drawContext2 = obj2.getDrawContext();
        final int i4 = 0;
        drawContext2.getCanvas().save();
        DrawTransform transform = drawContext2.getTransform();
        int i = 0;
        transform.translate(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft));
        final androidx.compose.ui.text.TextLayoutResult textLayoutResult3 = textLayoutResult;
        TextPainterKt.clip(transform, textLayoutResult3);
        final int i5 = 0;
        if (!Float.isNaN(shadow)) {
            f = shadow;
        } else {
            f = naN;
        }
        textLayoutResult3.getMultiParagraph().paint-hn5TExg(obj2.getDrawContext().getCanvas(), brush, f, textDecoration3, textDecoration2, drawStyle2, obj26);
        drawContext2.getCanvas().restore();
        drawContext2.setSize-uvyYCjk(drawContext2.getSize-NH-jbRc());
    }

    public static void drawText-LVfH_YU$default(DrawScope drawScope, androidx.compose.ui.text.TextLayoutResult textLayoutResult2, Brush brush3, long l4, float f5, Shadow shadow6, TextDecoration textDecoration7, DrawStyle drawStyle8, int i9, int i10, Object object11) {
        int defaultBlendMode-0nO6VwU;
        long zero-F1C5BW0;
        int i2;
        long l;
        int i4;
        int i3;
        int i6;
        int i;
        int i5;
        int i7 = object11;
        if (i7 & 4 != 0) {
            l = zero-F1C5BW0;
        } else {
            l = l4;
        }
        i4 = i7 & 8 != 0 ? i2 : shadow6;
        final int i13 = 0;
        i3 = i7 & 16 != 0 ? i13 : textDecoration7;
        i6 = i7 & 32 != 0 ? i13 : drawStyle8;
        i = i7 & 64 != 0 ? i13 : i9;
        if (i7 &= 128 != 0) {
            i5 = defaultBlendMode-0nO6VwU;
        } else {
            i5 = i10;
        }
        TextPainterKt.drawText-LVfH_YU(drawScope, textLayoutResult2, brush3, l, obj7, i4, i3, i6, i);
    }

    public static final void drawText-TPWCCtM(DrawScope $this$drawText_u2dTPWCCtM, androidx.compose.ui.text.TextMeasurer textMeasurer, String text, long topLeft, androidx.compose.ui.text.TextStyle style, int overflow, boolean softWrap, int maxLines, long size, int blendMode) {
        final androidx.compose.ui.unit.Density density2 = $this$drawText_u2dTPWCCtM;
        int i4 = 6;
        int i = 0;
        AnnotatedString annotatedString = new AnnotatedString(text, i, 0, i4, 0);
        final int i8 = 0;
        final int i12 = 0;
        androidx.compose.ui.text.TextLayoutResult measure-xDpz5zY$default = TextMeasurer.measure-xDpz5zY$default(textMeasurer, annotatedString, overflow, softWrap, maxLines, size, i8, TextPainterKt.textLayoutConstraints-v_w8tDc(density2, blendMode, i4), obj10, density2.getLayoutDirection(), (Density)density2, i12, 0, 1568);
        androidx.compose.ui.unit.Density density3 = $this$drawText_u2dTPWCCtM;
        int i2 = 0;
        DrawContext drawContext = density3.getDrawContext();
        int i6 = 0;
        drawContext.getCanvas().save();
        DrawTransform transform = drawContext.getTransform();
        int i9 = 0;
        transform.translate(Offset.getX-impl(topLeft), Offset.getY-impl(topLeft));
        TextPainterKt.clip(transform, measure-xDpz5zY$default);
        int i10 = 0;
        MultiParagraph.paint-LG529CI$default(measure-xDpz5zY$default.getMultiParagraph(), density3.getDrawContext().getCanvas(), 0, i12, 0, 0, 0, obj31, 30);
        drawContext.getCanvas().restore();
        drawContext.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    public static void drawText-TPWCCtM$default(DrawScope drawScope, androidx.compose.ui.text.TextMeasurer textMeasurer2, String string3, long l4, androidx.compose.ui.text.TextStyle textStyle5, int i6, boolean z7, int i8, long l9, int i10, int i11, Object object12) {
        int defaultBlendMode-0nO6VwU;
        long zero-F1C5BW0;
        androidx.compose.ui.text.TextStyle default;
        int clip-gIe3tQ8;
        int i7;
        int i3;
        int unspecified-NH-jbRc;
        long l2;
        androidx.compose.ui.text.TextStyle textStyle;
        int i2;
        int i5;
        int i;
        long l;
        int i4;
        int i9 = obj27;
        if (i9 & 4 != 0) {
            l2 = zero-F1C5BW0;
        } else {
            l2 = l4;
        }
        if (i9 & 8 != 0) {
            textStyle = default;
        } else {
            textStyle = i6;
        }
        if (i9 & 16 != 0) {
            i2 = clip-gIe3tQ8;
        } else {
            i2 = z7;
        }
        i5 = i9 & 32 != 0 ? i7 : i8;
        i = i9 & 64 != 0 ? i3 : l9;
        if (i9 & 128 != 0) {
            l = unspecified-NH-jbRc;
        } else {
            l = i10;
        }
        if (i9 &= 256 != 0) {
            i4 = defaultBlendMode-0nO6VwU;
        } else {
            i4 = object12;
        }
        TextPainterKt.drawText-TPWCCtM(drawScope, textMeasurer2, string3, l2, obj7, textStyle, i2, i5, i, l);
    }

    public static final void drawText-d8-rzKo(DrawScope $this$drawText_u2dd8_u2drzKo, androidx.compose.ui.text.TextLayoutResult textLayoutResult, long color, long topLeft, float alpha, Shadow shadow, TextDecoration textDecoration, DrawStyle drawStyle, int blendMode) {
        Shadow textDecoration3;
        androidx.compose.ui.text.MultiParagraph multiParagraph;
        int i5;
        long $i$a$TakeOrElseDxMtmZcTextPainterKt$drawText$6$1;
        Canvas canvas;
        androidx.compose.ui.text.TextStyle brush;
        long brush2;
        int $i$f$isUnspecified8_81llA;
        float canvas2;
        TextDecoration textDecoration2;
        DrawStyle drawStyle2;
        int cmp;
        int i;
        androidx.compose.ui.text.TextLayoutResult textLayoutResult2;
        long color-0d7_KjU;
        int i4;
        Brush brush3;
        int i3;
        int i6;
        int i2;
        long l;
        if (drawStyle == null) {
            textDecoration3 = textLayoutResult.getLayoutInput().getStyle().getShadow();
        } else {
            textDecoration3 = drawStyle;
        }
        final Shadow shadow2 = textDecoration3;
        if (blendMode == null) {
            textDecoration2 = textDecoration3;
        } else {
            textDecoration2 = blendMode;
        }
        if (obj36 == null) {
            drawStyle2 = textDecoration3;
        } else {
            drawStyle2 = obj36;
        }
        final Object obj2 = $this$drawText_u2dd8_u2drzKo;
        final int i12 = 0;
        final DrawContext drawContext3 = obj2.getDrawContext();
        final int i13 = 0;
        drawContext3.getCanvas().save();
        DrawTransform transform = drawContext3.getTransform();
        int i7 = 0;
        transform.translate(Offset.getX-impl(alpha), Offset.getY-impl(alpha));
        final androidx.compose.ui.text.TextLayoutResult textLayoutResult3 = textLayoutResult;
        TextPainterKt.clip(transform, textLayoutResult3);
        Throwable obj = obj2;
        final int i14 = 0;
        brush2 = textLayoutResult3.getLayoutInput().getStyle().getBrush();
        int i8 = 1;
        color-0d7_KjU = 16;
        if (brush2 != null) {
            int i10 = 0;
            $i$f$isUnspecified8_81llA = Long.compare(i4, color-0d7_KjU) == 0 ? i8 : i5;
            if ($i$f$isUnspecified8_81llA != 0) {
                if (!Float.isNaN(textDecoration)) {
                    canvas2 = textDecoration;
                } else {
                    canvas2 = textLayoutResult3.getLayoutInput().getStyle().getAlpha();
                }
                textLayoutResult3.getMultiParagraph().paint-hn5TExg(obj.getDrawContext().getCanvas(), brush2, canvas2, shadow2, textDecoration2, drawStyle2, obj37);
                brush3 = brush2;
            } else {
                brush3 = brush2;
                canvas2 = obj.getDrawContext().getCanvas();
                i3 = color;
                int i11 = 0;
                i2 = 0;
                if (Long.compare(i6, color-0d7_KjU) != 0) {
                    i5 = brush;
                }
                if (i5 != 0) {
                    $i$a$TakeOrElseDxMtmZcTextPainterKt$drawText$6$1 = i3;
                } else {
                    int i9 = 0;
                    $i$a$TakeOrElseDxMtmZcTextPainterKt$drawText$6$1 = color-0d7_KjU;
                }
                textLayoutResult3.getMultiParagraph().paint-LG529CI(canvas2, TextDrawStyleKt.modulate-DxMtmZc($i$a$TakeOrElseDxMtmZcTextPainterKt$drawText$6$1, brush), canvas2, shadow2, textDecoration2, drawStyle2);
            }
        } else {
        }
        drawContext3.getCanvas().restore();
        drawContext3.setSize-uvyYCjk(drawContext3.getSize-NH-jbRc());
    }

    public static void drawText-d8-rzKo$default(DrawScope drawScope, androidx.compose.ui.text.TextLayoutResult textLayoutResult2, long l3, long l4, float f5, Shadow shadow6, TextDecoration textDecoration7, DrawStyle drawStyle8, int i9, int i10, Object object11) {
        int defaultBlendMode-0nO6VwU;
        long unspecified-0d7_KjU;
        long zero-F1C5BW0;
        int i3;
        int f;
        int i;
        int i2;
        int i4 = obj21;
        if (i4 & 2 != 0) {
            unspecified-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            unspecified-0d7_KjU = l3;
        }
        if (i4 & 4 != 0) {
            zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
        } else {
            zero-F1C5BW0 = f5;
        }
        i3 = i4 & 8 != 0 ? 0x7fc00000 /* Unknown resource */ : textDecoration7;
        i = 0;
        f = i4 & 16 != 0 ? i : drawStyle8;
        i2 = i4 & 32 != 0 ? i : i9;
        if (i4 & 64 != 0) {
        } else {
            i = i10;
        }
        if (i4 &= 128 != 0) {
            defaultBlendMode-0nO6VwU = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
        } else {
            defaultBlendMode-0nO6VwU = object11;
        }
        TextPainterKt.drawText-d8-rzKo(drawScope, textLayoutResult2, unspecified-0d7_KjU, shadow6, zero-F1C5BW0, drawStyle8, i3, f, i2);
    }

    private static final long textLayoutConstraints-v_w8tDc(DrawScope $this$textLayoutConstraints_u2dv_w8tDc, long size, long topLeft) {
        int minWidth;
        int maxWidth;
        int minHeight;
        int $this$isUnspecified$iv;
        int i2;
        int $this$fastRoundToInt$iv;
        int i4;
        int maxHeight;
        int naN;
        int $this$fastRoundToInt$iv2;
        int i;
        int i3;
        int i5 = 0;
        maxWidth = 0;
        int i7 = 0;
        long l2 = 9205357640488583168L;
        i3 = 1;
        final int i10 = 0;
        $this$isUnspecified$iv = Long.compare(l, l2) == 0 ? i3 : i10;
        if ($this$isUnspecified$iv == 0) {
            if (Float.isNaN(Size.getWidth-impl(size))) {
                i2 = i3;
            } else {
                i2 = i10;
            }
        } else {
        }
        if (i2 != 0) {
            minWidth = 0;
            float x-impl = Offset.getX-impl(obj15);
            i4 = 0;
            $this$fastRoundToInt$iv = Math.round((float)ceil);
        } else {
            i4 = 0;
            $this$fastRoundToInt$iv = Math.round((float)ceil2);
            minWidth = $this$fastRoundToInt$iv;
            maxWidth = $this$fastRoundToInt$iv;
        }
        int maxWidth2 = 0;
        maxHeight = 0;
        int i9 = 0;
        naN = Long.compare(l4, l2) == 0 ? i3 : i10;
        if (naN == 0) {
            if (Float.isNaN(Size.getHeight-impl(size))) {
            } else {
                i3 = i10;
            }
        } else {
        }
        if (i3 != 0) {
            minHeight = 0;
            float y-impl = Offset.getY-impl(obj15);
            i = 0;
            $this$fastRoundToInt$iv2 = Math.round((float)ceil3);
        } else {
            i = 0;
            $this$fastRoundToInt$iv2 = Math.round((float)ceil4);
            minHeight = $this$fastRoundToInt$iv2;
            maxHeight = $this$fastRoundToInt$iv2;
        }
        return ConstraintsKt.Constraints(minWidth, $this$fastRoundToInt$iv, minHeight, $this$fastRoundToInt$iv2);
    }
}
