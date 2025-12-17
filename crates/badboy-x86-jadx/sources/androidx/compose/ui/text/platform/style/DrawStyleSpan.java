package androidx.compose.ui.text.platform.style;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;
import androidx.compose.ui.graphics.AndroidPathEffect_androidKt;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.StrokeJoin.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\u000c\u001a\u00020\r*\u00020\u000eH\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0016", d2 = {"Landroidx/compose/ui/text/platform/style/DrawStyleSpan;", "Landroid/text/style/CharacterStyle;", "Landroid/text/style/UpdateAppearance;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "(Landroidx/compose/ui/graphics/drawscope/DrawStyle;)V", "getDrawStyle", "()Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "toAndroidCap", "Landroid/graphics/Paint$Cap;", "Landroidx/compose/ui/graphics/StrokeCap;", "toAndroidCap-BeK7IIE", "(I)Landroid/graphics/Paint$Cap;", "toAndroidJoin", "Landroid/graphics/Paint$Join;", "Landroidx/compose/ui/graphics/StrokeJoin;", "toAndroidJoin-Ww9F2mQ", "(I)Landroid/graphics/Paint$Join;", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawStyleSpan extends CharacterStyle implements UpdateAppearance {

    public static final int $stable = 8;
    private final DrawStyle drawStyle;
    static {
        final int i = 8;
    }

    public DrawStyleSpan(DrawStyle drawStyle) {
        super();
        this.drawStyle = drawStyle;
    }

    private final Paint.Cap toAndroidCap-BeK7IIE(int $this$toAndroidCap_u2dBeK7IIE) {
        Paint.Cap sQUARE;
        sQUARE = StrokeCap.equals-impl0($this$toAndroidCap_u2dBeK7IIE, StrokeCap.Companion.getButt-KaPHkGw()) ? Paint.Cap.BUTT : equals-impl02 ? Paint.Cap.ROUND : equals-impl03 ? Paint.Cap.SQUARE : Paint.Cap.BUTT;
        return sQUARE;
    }

    private final Paint.Join toAndroidJoin-Ww9F2mQ(int $this$toAndroidJoin_u2dWw9F2mQ) {
        Paint.Join rOUND;
        rOUND = StrokeJoin.equals-impl0($this$toAndroidJoin_u2dWw9F2mQ, StrokeJoin.Companion.getMiter-LxFBmk8()) ? Paint.Join.MITER : equals-impl02 ? Paint.Join.ROUND : equals-impl03 ? Paint.Join.BEVEL : Paint.Join.MITER;
        return rOUND;
    }

    @Override // android.text.style.CharacterStyle
    public final DrawStyle getDrawStyle() {
        return this.drawStyle;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        Object obj;
        int i;
        boolean androidPathEffect;
        boolean equal;
        if (textPaint != null) {
            obj = textPaint;
            i = 0;
            DrawStyle drawStyle = this.drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                obj.setStyle(Paint.Style.FILL);
            } else {
                if (drawStyle instanceof Stroke) {
                    obj.setStyle(Paint.Style.STROKE);
                    obj.setStrokeWidth((Stroke)this.drawStyle.getWidth());
                    obj.setStrokeMiter((Stroke)this.drawStyle.getMiter());
                    obj.setStrokeJoin(toAndroidJoin-Ww9F2mQ((Stroke)this.drawStyle.getJoin-LxFBmk8()));
                    obj.setStrokeCap(toAndroidCap-BeK7IIE((Stroke)this.drawStyle.getCap-KaPHkGw()));
                    androidx.compose.ui.graphics.PathEffect pathEffect = (Stroke)this.drawStyle.getPathEffect();
                    if (pathEffect != null) {
                        androidPathEffect = AndroidPathEffect_androidKt.asAndroidPathEffect(pathEffect);
                    } else {
                        androidPathEffect = 0;
                    }
                    obj.setPathEffect(androidPathEffect);
                }
            }
        }
    }
}
