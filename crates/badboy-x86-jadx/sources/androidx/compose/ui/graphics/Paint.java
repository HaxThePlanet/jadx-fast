package androidx.compose.ui.graphics;

import android.graphics.Paint;
import android.graphics.Shader;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u000c\u0010B\u001a\u00060Cj\u0002`DH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000fX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001bX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u001c\u0010\u000b\"\u0004\u0008\u001d\u0010\rR\u0018\u0010\u001e\u001a\u00020\u001fX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u001e\u0010 \"\u0004\u0008!\u0010\"R\u001a\u0010#\u001a\u0004\u0018\u00010$X¦\u000e¢\u0006\u000c\u001a\u0004\u0008%\u0010&\"\u0004\u0008'\u0010(R \u0010)\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+X¦\u000e¢\u0006\u000c\u001a\u0004\u0008,\u0010-\"\u0004\u0008.\u0010/R\u001e\u00100\u001a\u000201X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u00082\u0010\u000b\"\u0004\u00083\u0010\rR\u001e\u00104\u001a\u000205X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u00086\u0010\u000b\"\u0004\u00087\u0010\rR\u0018\u00108\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u00089\u0010\u0005\"\u0004\u0008:\u0010\u0007R\u0018\u0010;\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008<\u0010\u0005\"\u0004\u0008=\u0010\u0007R\u001e\u0010>\u001a\u00020?X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008@\u0010\u000b\"\u0004\u0008A\u0010\rø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006EÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/graphics/Paint;", "", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "color", "Landroidx/compose/ui/graphics/Color;", "getColor-0d7_KjU", "()J", "setColor-8_81llA", "(J)V", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "getFilterQuality-f-v9h1I", "setFilterQuality-vDHp3xo", "isAntiAlias", "", "()Z", "setAntiAlias", "(Z)V", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "getPathEffect", "()Landroidx/compose/ui/graphics/PathEffect;", "setPathEffect", "(Landroidx/compose/ui/graphics/PathEffect;)V", "shader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "getShader", "()Landroid/graphics/Shader;", "setShader", "(Landroid/graphics/Shader;)V", "strokeCap", "Landroidx/compose/ui/graphics/StrokeCap;", "getStrokeCap-KaPHkGw", "setStrokeCap-BeK7IIE", "strokeJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeJoin-LxFBmk8", "setStrokeJoin-Ww9F2mQ", "strokeMiterLimit", "getStrokeMiterLimit", "setStrokeMiterLimit", "strokeWidth", "getStrokeWidth", "setStrokeWidth", "style", "Landroidx/compose/ui/graphics/PaintingStyle;", "getStyle-TiuSbCo", "setStyle-k9PVt8s", "asFrameworkPaint", "Landroid/graphics/Paint;", "Landroidx/compose/ui/graphics/NativePaint;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Paint {
    public abstract Paint asFrameworkPaint();

    public abstract float getAlpha();

    public abstract int getBlendMode-0nO6VwU();

    public abstract long getColor-0d7_KjU();

    public abstract androidx.compose.ui.graphics.ColorFilter getColorFilter();

    public abstract int getFilterQuality-f-v9h1I();

    public abstract androidx.compose.ui.graphics.PathEffect getPathEffect();

    public abstract Shader getShader();

    public abstract int getStrokeCap-KaPHkGw();

    public abstract int getStrokeJoin-LxFBmk8();

    public abstract float getStrokeMiterLimit();

    public abstract float getStrokeWidth();

    public abstract int getStyle-TiuSbCo();

    public abstract boolean isAntiAlias();

    public abstract void setAlpha(float f);

    public abstract void setAntiAlias(boolean z);

    public abstract void setBlendMode-s9anfk8(int i);

    public abstract void setColor-8_81llA(long l);

    public abstract void setColorFilter(androidx.compose.ui.graphics.ColorFilter colorFilter);

    public abstract void setFilterQuality-vDHp3xo(int i);

    public abstract void setPathEffect(androidx.compose.ui.graphics.PathEffect pathEffect);

    public abstract void setShader(Shader shader);

    public abstract void setStrokeCap-BeK7IIE(int i);

    public abstract void setStrokeJoin-Ww9F2mQ(int i);

    public abstract void setStrokeMiterLimit(float f);

    public abstract void setStrokeWidth(float f);

    public abstract void setStyle-k9PVt8s(int i);
}
