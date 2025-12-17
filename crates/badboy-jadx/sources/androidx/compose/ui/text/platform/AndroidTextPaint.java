package androidx.compose.ui.text.platform;

import android.graphics.Paint.Style;
import android.graphics.Shader;
import android.text.TextPaint;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.PaintingStyle.Companion;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shadow.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope.Companion;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDecoration.Companion;
import androidx.compose.ui.text.style.TextDrawStyleKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u00107\u001a\u000208H\u0002J,\u00109\u001a\u0002082\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010:\u001a\u00020\u001b2\u0008\u0008\u0002\u0010;\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=J\u0018\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJ\u0010\u0010C\u001a\u0002082\u0008\u0010$\u001a\u0004\u0018\u00010%J\u0010\u0010D\u001a\u0002082\u0008\u0010.\u001a\u0004\u0018\u00010/J\u0010\u0010E\u001a\u0002082\u0008\u00105\u001a\u0004\u0018\u000106R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u00020\u00082\u0006\u0010\u000c\u001a\u00020\u00088F@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R&\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0014\u0010\u0015\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R,\u0010\u001a\u001a\u0004\u0018\u00010\u001b8\u0000@\u0000X\u0081\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u001c\u0010\u0015\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R\u0014\u0010!\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010#R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010&\u001a\u0012\u0012\u000c\u0012\n\u0018\u00010(j\u0004\u0018\u0001`)\u0018\u00010'X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-R$\u0010.\u001a\u00020/8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u00080\u0010\u0015\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006F", d2 = {"Landroidx/compose/ui/text/platform/AndroidTextPaint;", "Landroid/text/TextPaint;", "flags", "", "density", "", "(IF)V", "backingBlendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "backingComposePaint", "Landroidx/compose/ui/graphics/Paint;", "value", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush$ui_text_release$annotations", "()V", "getBrush$ui_text_release", "()Landroidx/compose/ui/graphics/Brush;", "setBrush$ui_text_release", "(Landroidx/compose/ui/graphics/Brush;)V", "brushSize", "Landroidx/compose/ui/geometry/Size;", "getBrushSize-VsRJwc0$ui_text_release$annotations", "getBrushSize-VsRJwc0$ui_text_release", "()Landroidx/compose/ui/geometry/Size;", "setBrushSize-iaC8Vc4$ui_text_release", "(Landroidx/compose/ui/geometry/Size;)V", "composePaint", "getComposePaint", "()Landroidx/compose/ui/graphics/Paint;", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "shaderState", "Landroidx/compose/runtime/State;", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShaderState$ui_text_release", "()Landroidx/compose/runtime/State;", "setShaderState$ui_text_release", "(Landroidx/compose/runtime/State;)V", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "getShadow$ui_text_release$annotations", "getShadow$ui_text_release", "()Landroidx/compose/ui/graphics/Shadow;", "setShadow$ui_text_release", "(Landroidx/compose/ui/graphics/Shadow;)V", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "clearShader", "", "setBrush", "size", "alpha", "setBrush-12SF9DM", "(Landroidx/compose/ui/graphics/Brush;JF)V", "setColor", "color", "Landroidx/compose/ui/graphics/Color;", "setColor-8_81llA", "(J)V", "setDrawStyle", "setShadow", "setTextDecoration", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidTextPaint extends TextPaint {

    public static final int $stable = 8;
    private int backingBlendMode;
    private Paint backingComposePaint;
    private Brush brush;
    private Size brushSize;
    private DrawStyle drawStyle;
    private State<? extends Shader> shaderState;
    private Shadow shadow;
    private TextDecoration textDecoration;
    static {
        final int i = 8;
    }

    public AndroidTextPaint(int flags, float density) {
        super(flags);
        this.density = density;
        this.textDecoration = TextDecoration.Companion.getNone();
        this.backingBlendMode = DrawScope.Companion.getDefaultBlendMode-0nO6VwU();
        this.shadow = Shadow.Companion.getNone();
    }

    private final void clearShader() {
        final int i = 0;
        this.shaderState = i;
        this.brush = i;
        this.brushSize = i;
        setShader(i);
    }

    public static void getBrush$ui_text_release$annotations() {
    }

    public static void getBrushSize-VsRJwc0$ui_text_release$annotations() {
    }

    private final Paint getComposePaint() {
        final Paint backingComposePaint = this.backingComposePaint;
        if (backingComposePaint != null) {
            return backingComposePaint;
        }
        Paint composePaint = AndroidPaint_androidKt.asComposePaint((Paint)this);
        final int i = 0;
        this.backingComposePaint = composePaint;
        return composePaint;
    }

    public static void getShadow$ui_text_release$annotations() {
    }

    public static void setBrush-12SF9DM$default(androidx.compose.ui.text.platform.AndroidTextPaint androidTextPaint, Brush brush2, long l3, float f4, int i5, Object object6) {
        int obj4;
        if (object6 &= 4 != 0) {
            obj4 = 2143289344;
        }
        androidTextPaint.setBrush-12SF9DM(brush2, l3, f4);
    }

    @Override // android.text.TextPaint
    public final int getBlendMode-0nO6VwU() {
        return this.backingBlendMode;
    }

    @Override // android.text.TextPaint
    public final Brush getBrush$ui_text_release() {
        return this.brush;
    }

    @Override // android.text.TextPaint
    public final Size getBrushSize-VsRJwc0$ui_text_release() {
        return this.brushSize;
    }

    public final State<Shader> getShaderState$ui_text_release() {
        return this.shaderState;
    }

    @Override // android.text.TextPaint
    public final Shadow getShadow$ui_text_release() {
        return this.shadow;
    }

    @Override // android.text.TextPaint
    public final void setBlendMode-s9anfk8(int value) {
        if (BlendMode.equals-impl0(value, this.backingBlendMode)) {
        }
        getComposePaint().setBlendMode-s9anfk8(value);
        this.backingBlendMode = value;
    }

    @Override // android.text.TextPaint
    public final void setBrush$ui_text_release(Brush <set-?>) {
        this.brush = <set-?>;
    }

    @Override // android.text.TextPaint
    public final void setBrush-12SF9DM(Brush brush, long size, float alpha) {
        long modulate-DxMtmZc;
        int derivedStateOf;
        long value;
        int i;
        long unbox-impl;
        int cmp;
        if (brush == null) {
            clearShader();
        } else {
            if (brush instanceof SolidColor) {
                setColor-8_81llA(TextDrawStyleKt.modulate-DxMtmZc((SolidColor)brush.getValue-0d7_KjU(), obj1));
            } else {
                if (brush instanceof ShaderBrush) {
                    if (Intrinsics.areEqual(this.brush, brush)) {
                        Size brushSize = this.brushSize;
                        if (brushSize == null) {
                            derivedStateOf = i;
                        } else {
                            derivedStateOf = Size.equals-impl0(brushSize.unbox-impl(), obj3);
                        }
                        derivedStateOf = 0;
                        if (derivedStateOf == 0 && Long.compare(unbox-impl, l) != 0) {
                            derivedStateOf = 0;
                            if (Long.compare(unbox-impl, l) != 0) {
                                i = 1;
                            }
                            if (i != 0) {
                                this.brush = brush;
                                this.brushSize = Size.box-impl(size);
                                AndroidTextPaint.setBrush.1 anon = new AndroidTextPaint.setBrush.1(brush, size, alpha);
                                this.shaderState = SnapshotStateKt.derivedStateOf((Function0)anon);
                            }
                        }
                    } else {
                    }
                    State shaderState = this.shaderState;
                    if (shaderState != null) {
                        value = shaderState.getValue();
                    } else {
                        value = 0;
                    }
                    getComposePaint().setShader(value);
                    AndroidTextPaint_androidKt.setAlpha((TextPaint)this, obj10);
                }
            }
        }
    }

    @Override // android.text.TextPaint
    public final void setBrushSize-iaC8Vc4$ui_text_release(Size <set-?>) {
        this.brushSize = <set-?>;
    }

    @Override // android.text.TextPaint
    public final void setColor-8_81llA(long color) {
        int argb-8_81llA;
        int i;
        final int i2 = 0;
        i = Long.compare(argb-8_81llA, i3) != 0 ? 1 : 0;
        if (i != 0) {
            setColor(ColorKt.toArgb-8_81llA(color));
            clearShader();
        }
    }

    @Override // android.text.TextPaint
    public final void setDrawStyle(DrawStyle drawStyle) {
        boolean composePaint;
        androidx.compose.ui.graphics.PathEffect pathEffect;
        if (drawStyle == null) {
        }
        if (!Intrinsics.areEqual(this.drawStyle, drawStyle)) {
            this.drawStyle = drawStyle;
            if (Intrinsics.areEqual(drawStyle, Fill.INSTANCE)) {
                setStyle(Paint.Style.FILL);
            } else {
                if (drawStyle instanceof Stroke) {
                    getComposePaint().setStyle-k9PVt8s(PaintingStyle.Companion.getStroke-TiuSbCo());
                    getComposePaint().setStrokeWidth((Stroke)drawStyle.getWidth());
                    getComposePaint().setStrokeMiterLimit((Stroke)drawStyle.getMiter());
                    getComposePaint().setStrokeJoin-Ww9F2mQ((Stroke)drawStyle.getJoin-LxFBmk8());
                    getComposePaint().setStrokeCap-BeK7IIE((Stroke)drawStyle.getCap-KaPHkGw());
                    getComposePaint().setPathEffect((Stroke)drawStyle.getPathEffect());
                }
            }
        }
    }

    public final void setShaderState$ui_text_release(State<? extends Shader> <set-?>) {
        this.shaderState = <set-?>;
    }

    @Override // android.text.TextPaint
    public final void setShadow(Shadow shadow) {
        boolean correctBlurRadius;
        float x-impl;
        long y-impl;
        long argb-8_81llA;
        if (shadow == null) {
        }
        if (!Intrinsics.areEqual(this.shadow, shadow)) {
            this.shadow = shadow;
            if (Intrinsics.areEqual(this.shadow, Shadow.Companion.getNone())) {
                clearShadowLayer();
            } else {
                setShadowLayer(TextPaintExtensions_androidKt.correctBlurRadius(this.shadow.getBlurRadius()), Offset.getX-impl(this.shadow.getOffset-F1C5BW0()), Offset.getY-impl(this.shadow.getOffset-F1C5BW0()), ColorKt.toArgb-8_81llA(this.shadow.getColor-0d7_KjU()));
            }
        }
    }

    @Override // android.text.TextPaint
    public final void setShadow$ui_text_release(Shadow <set-?>) {
        this.shadow = <set-?>;
    }

    @Override // android.text.TextPaint
    public final void setTextDecoration(TextDecoration textDecoration) {
        boolean contains;
        TextDecoration lineThrough;
        if (textDecoration == null) {
        }
        if (!Intrinsics.areEqual(this.textDecoration, textDecoration)) {
            this.textDecoration = textDecoration;
            setUnderlineText(this.textDecoration.contains(TextDecoration.Companion.getUnderline()));
            setStrikeThruText(this.textDecoration.contains(TextDecoration.Companion.getLineThrough()));
        }
    }
}
