package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000c\u0010K\u001a\u00060\u0004j\u0002`LH\u0016R\u0016\u0010\u0006\u001a\u00020\u0007X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR*\u0010\u0010\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00078V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0008\u0010\t\u001a\u0004\u0018\u00010\u001b8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R*\u0010\"\u001a\u00020!2\u0006\u0010\t\u001a\u00020!8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008#\u0010\u0012\"\u0004\u0008$\u0010\u0014R\u0010\u0010%\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010&\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010*\u001a\u00020)2\u0006\u0010\t\u001a\u00020)8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008*\u0010+\"\u0004\u0008,\u0010-R(\u0010/\u001a\u0004\u0018\u00010.2\u0008\u0010\t\u001a\u0004\u0018\u00010.@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R4\u00104\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(2\u000e\u0010\t\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u00085\u00106\"\u0004\u00087\u00108R*\u0010:\u001a\u0002092\u0006\u0010\t\u001a\u0002098V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008;\u0010\u0012\"\u0004\u0008<\u0010\u0014R*\u0010>\u001a\u00020=2\u0006\u0010\t\u001a\u00020=8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008?\u0010\u0012\"\u0004\u0008@\u0010\u0014R$\u0010A\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008B\u0010\r\"\u0004\u0008C\u0010\u000fR$\u0010D\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008E\u0010\r\"\u0004\u0008F\u0010\u000fR*\u0010H\u001a\u00020G2\u0006\u0010\t\u001a\u00020G8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008I\u0010\u0012\"\u0004\u0008J\u0010\u0014\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006M", d2 = {"Landroidx/compose/ui/graphics/AndroidPaint;", "Landroidx/compose/ui/graphics/Paint;", "()V", "internalPaint", "Landroid/graphics/Paint;", "(Landroid/graphics/Paint;)V", "_blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "I", "value", "", "alpha", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "Landroidx/compose/ui/graphics/ColorFilter;", "colorFilter", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "Landroidx/compose/ui/graphics/FilterQuality;", "filterQuality", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "internalColorFilter", "internalShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "", "isAntiAlias", "()Z", "setAntiAlias", "(Z)V", "Landroidx/compose/ui/graphics/PathEffect;", "pathEffect", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", "shader", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeCap", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeJoin", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeMiterLimit", "getStrokeMiterLimit", "setStrokeMiterLimit", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "Landroidx/compose/ui/graphics/PaintingStyle;", "style", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "asFrameworkPaint", "Landroidx/compose/ui/graphics/NativePaint;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidPaint implements androidx.compose.ui.graphics.Paint {

    private int _blendMode;
    private androidx.compose.ui.graphics.ColorFilter internalColorFilter;
    private Paint internalPaint;
    private Shader internalShader;
    private androidx.compose.ui.graphics.PathEffect pathEffect;
    public AndroidPaint() {
        super(AndroidPaint_androidKt.makeNativePaint());
    }

    public AndroidPaint(Paint internalPaint) {
        super();
        this.internalPaint = internalPaint;
        this._blendMode = BlendMode.Companion.getSrcOver-0nO6VwU();
    }

    @Override // androidx.compose.ui.graphics.Paint
    public Paint asFrameworkPaint() {
        return this.internalPaint;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float getAlpha() {
        return AndroidPaint_androidKt.getNativeAlpha(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int getBlendMode-0nO6VwU() {
        return this._blendMode;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public long getColor-0d7_KjU() {
        return AndroidPaint_androidKt.getNativeColor(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public androidx.compose.ui.graphics.ColorFilter getColorFilter() {
        return this.internalColorFilter;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int getFilterQuality-f-v9h1I() {
        return AndroidPaint_androidKt.getNativeFilterQuality(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public androidx.compose.ui.graphics.PathEffect getPathEffect() {
        return this.pathEffect;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public Shader getShader() {
        return this.internalShader;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int getStrokeCap-KaPHkGw() {
        return AndroidPaint_androidKt.getNativeStrokeCap(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int getStrokeJoin-LxFBmk8() {
        return AndroidPaint_androidKt.getNativeStrokeJoin(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float getStrokeMiterLimit() {
        return AndroidPaint_androidKt.getNativeStrokeMiterLimit(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public float getStrokeWidth() {
        return AndroidPaint_androidKt.getNativeStrokeWidth(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public int getStyle-TiuSbCo() {
        return AndroidPaint_androidKt.getNativeStyle(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public boolean isAntiAlias() {
        return AndroidPaint_androidKt.getNativeAntiAlias(this.internalPaint);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setAlpha(float value) {
        AndroidPaint_androidKt.setNativeAlpha(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setAntiAlias(boolean value) {
        AndroidPaint_androidKt.setNativeAntiAlias(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setBlendMode-s9anfk8(int value) {
        boolean internalPaint;
        if (!BlendMode.equals-impl0(this._blendMode, value)) {
            this._blendMode = value;
            AndroidPaint_androidKt.setNativeBlendMode-GB0RdKg(this.internalPaint, value);
        }
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setColor-8_81llA(long color) {
        AndroidPaint_androidKt.setNativeColor-4WTKRHQ(this.internalPaint, color);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setColorFilter(androidx.compose.ui.graphics.ColorFilter value) {
        this.internalColorFilter = value;
        AndroidPaint_androidKt.setNativeColorFilter(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setFilterQuality-vDHp3xo(int value) {
        AndroidPaint_androidKt.setNativeFilterQuality-50PEsBU(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setPathEffect(androidx.compose.ui.graphics.PathEffect value) {
        AndroidPaint_androidKt.setNativePathEffect(this.internalPaint, value);
        this.pathEffect = value;
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setShader(Shader value) {
        this.internalShader = value;
        AndroidPaint_androidKt.setNativeShader(this.internalPaint, this.internalShader);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStrokeCap-BeK7IIE(int value) {
        AndroidPaint_androidKt.setNativeStrokeCap-CSYIeUk(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStrokeJoin-Ww9F2mQ(int value) {
        AndroidPaint_androidKt.setNativeStrokeJoin-kLtJ_vA(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStrokeMiterLimit(float value) {
        AndroidPaint_androidKt.setNativeStrokeMiterLimit(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStrokeWidth(float value) {
        AndroidPaint_androidKt.setNativeStrokeWidth(this.internalPaint, value);
    }

    @Override // androidx.compose.ui.graphics.Paint
    public void setStyle-k9PVt8s(int value) {
        AndroidPaint_androidKt.setNativeStyle--5YerkU(this.internalPaint, value);
    }
}
