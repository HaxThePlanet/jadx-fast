package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.text.SpanStyleKt;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0005H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0005*\u00020\u00052\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\rH\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"lerp", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "start", "stop", "fraction", "", "modulate", "Landroidx/compose/ui/graphics/Color;", "alpha", "modulate-DxMtmZc", "(JF)J", "takeOrElse", "block", "Lkotlin/Function0;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextDrawStyleKt {
    public static final float access$takeOrElse(float $receiver, Function0 block) {
        return TextDrawStyleKt.takeOrElse($receiver, block);
    }

    public static final androidx.compose.ui.text.style.TextForegroundStyle lerp(androidx.compose.ui.text.style.TextForegroundStyle start, androidx.compose.ui.text.style.TextForegroundStyle stop, float fraction) {
        Object lerpDiscrete2;
        boolean z;
        boolean z2;
        Object lerpDiscrete;
        long lerp;
        float color-0d7_KjU;
        if (!start instanceof BrushStyle && !stop instanceof BrushStyle) {
            if (!stop instanceof BrushStyle) {
                lerpDiscrete2 = TextForegroundStyle.Companion.from-8_81llA(ColorKt.lerp-jxsXWHM(start.getColor-0d7_KjU(), obj2, stop.getColor-0d7_KjU()));
            } else {
                if (start instanceof BrushStyle && stop instanceof BrushStyle) {
                    if (stop instanceof BrushStyle) {
                        lerpDiscrete2 = TextForegroundStyle.Companion.from((Brush)SpanStyleKt.lerpDiscrete((BrushStyle)start.getBrush(), (BrushStyle)stop.getBrush(), fraction), MathHelpersKt.lerp(start.getAlpha(), stop.getAlpha(), fraction));
                    } else {
                        lerpDiscrete2 = SpanStyleKt.lerpDiscrete(start, stop, fraction);
                    }
                } else {
                }
            }
        } else {
        }
        return lerpDiscrete2;
    }

    public static final long modulate-DxMtmZc(long $this$modulate_u2dDxMtmZc, float alpha) {
        int alpha-impl;
        long $this$modulate_u2dDxMtmZc2;
        int i6;
        int i;
        int i3;
        int i4;
        int i5;
        int i2;
        long obj9;
        if (!Float.isNaN(obj11)) {
            if (Float.compare(obj11, i7) >= 0) {
                $this$modulate_u2dDxMtmZc2 = $this$modulate_u2dDxMtmZc;
                obj9 = $this$modulate_u2dDxMtmZc2;
            } else {
                obj9 = Color.copy-wmQWz5c$default($this$modulate_u2dDxMtmZc, obj2, alpha-impl * obj11, 0, 0, 0, 14);
            }
        } else {
            $this$modulate_u2dDxMtmZc2 = $this$modulate_u2dDxMtmZc;
        }
        return obj9;
    }

    private static final float takeOrElse(float $this$takeOrElse, Function0<Float> block) {
        float floatValue;
        if (Float.isNaN($this$takeOrElse)) {
            floatValue = (Number)block.invoke().floatValue();
        } else {
            floatValue = $this$takeOrElse;
        }
        return floatValue;
    }
}
