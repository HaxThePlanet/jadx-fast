package androidx.compose.ui.graphics.layer;

import android.graphics.Matrix;
import android.graphics.Outline;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008`\u0018\u0000 r2\u00020\u0001:\u0001rJ\u0008\u0010U\u001a\u00020VH&J\u0008\u0010W\u001a\u00020XH&J\u0010\u0010Y\u001a\u00020X2\u0006\u0010Z\u001a\u00020[H&J9\u0010\\\u001a\u00020X2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020b2\u0017\u0010c\u001a\u0013\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020X0d¢\u0006\u0002\u0008fH&J\u0012\u0010g\u001a\u00020X2\u0008\u0010h\u001a\u0004\u0018\u00010iH&J*\u0010j\u001a\u00020X2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020l2\u0006\u0010n\u001a\u00020oH&ø\u0001\u0000¢\u0006\u0004\u0008p\u0010qR\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000fX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0015\u0010\u0005\"\u0004\u0008\u0016\u0010\u0007R\u0018\u0010\u0017\u001a\u00020\u0018X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001eX¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"R\u001e\u0010#\u001a\u00020$X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008%\u0010\u0011\"\u0004\u0008&\u0010\u0013R\u0014\u0010'\u001a\u00020\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008(\u0010\u001aR\u0018\u0010)\u001a\u00020\u0018X¦\u000e¢\u0006\u000c\u001a\u0004\u0008)\u0010\u001a\"\u0004\u0008*\u0010\u001cR\u0012\u0010+\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\u0008-\u0010\u000bR\u0012\u0010.\u001a\u00020,X¦\u0004¢\u0006\u0006\u001a\u0004\u0008/\u0010\u000bR\u001e\u00100\u001a\u000201X¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u00082\u0010\u000b\"\u0004\u00083\u0010\rR\u001a\u00104\u001a\u0004\u0018\u000105X¦\u000e¢\u0006\u000c\u001a\u0004\u00086\u00107\"\u0004\u00088\u00109R\u0018\u0010:\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008;\u0010\u0005\"\u0004\u0008<\u0010\u0007R\u0018\u0010=\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008>\u0010\u0005\"\u0004\u0008?\u0010\u0007R\u0018\u0010@\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008A\u0010\u0005\"\u0004\u0008B\u0010\u0007R\u0018\u0010C\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008D\u0010\u0005\"\u0004\u0008E\u0010\u0007R\u0018\u0010F\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008G\u0010\u0005\"\u0004\u0008H\u0010\u0007R\u0018\u0010I\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008J\u0010\u0005\"\u0004\u0008K\u0010\u0007R\u001e\u0010L\u001a\u00020\tX¦\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u000c\u001a\u0004\u0008M\u0010\u000b\"\u0004\u0008N\u0010\rR\u0018\u0010O\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008P\u0010\u0005\"\u0004\u0008Q\u0010\u0007R\u0018\u0010R\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008S\u0010\u0005\"\u0004\u0008T\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!\n\u0004\u0008!0\u0001¨\u0006sÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl;", "", "alpha", "", "getAlpha", "()F", "setAlpha", "(F)V", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "getAmbientShadowColor-0d7_KjU", "()J", "setAmbientShadowColor-8_81llA", "(J)V", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "getBlendMode-0nO6VwU", "()I", "setBlendMode-s9anfk8", "(I)V", "cameraDistance", "getCameraDistance", "setCameraDistance", "clip", "", "getClip", "()Z", "setClip", "(Z)V", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "getColorFilter", "()Landroidx/compose/ui/graphics/ColorFilter;", "setColorFilter", "(Landroidx/compose/ui/graphics/ColorFilter;)V", "compositingStrategy", "Landroidx/compose/ui/graphics/layer/CompositingStrategy;", "getCompositingStrategy-ke2Ky5w", "setCompositingStrategy-Wpw9cng", "hasDisplayList", "getHasDisplayList", "isInvalidated", "setInvalidated", "layerId", "", "getLayerId", "ownerId", "getOwnerId", "pivotOffset", "Landroidx/compose/ui/geometry/Offset;", "getPivotOffset-F1C5BW0", "setPivotOffset-k-4lQ0M", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "getRenderEffect", "()Landroidx/compose/ui/graphics/RenderEffect;", "setRenderEffect", "(Landroidx/compose/ui/graphics/RenderEffect;)V", "rotationX", "getRotationX", "setRotationX", "rotationY", "getRotationY", "setRotationY", "rotationZ", "getRotationZ", "setRotationZ", "scaleX", "getScaleX", "setScaleX", "scaleY", "getScaleY", "setScaleY", "shadowElevation", "getShadowElevation", "setShadowElevation", "spotShadowColor", "getSpotShadowColor-0d7_KjU", "setSpotShadowColor-8_81llA", "translationX", "getTranslationX", "setTranslationX", "translationY", "getTranslationY", "setTranslationY", "calculateMatrix", "Landroid/graphics/Matrix;", "discardDisplayList", "", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "record", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "setOutline", "outline", "Landroid/graphics/Outline;", "setPosition", "x", "", "y", "size", "Landroidx/compose/ui/unit/IntSize;", "setPosition-H0pRuoY", "(IIJ)V", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface GraphicsLayerImpl {

    public static final androidx.compose.ui.graphics.layer.GraphicsLayerImpl.Companion Companion;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Landroidx/compose/ui/graphics/layer/GraphicsLayerImpl$Companion;", "", "()V", "DefaultDrawBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "getDefaultDrawBlock", "()Lkotlin/jvm/functions/Function1;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.graphics.layer.GraphicsLayerImpl.Companion $$INSTANCE;
        private static final Function1<DrawScope, Unit> DefaultDrawBlock;
        static {
            GraphicsLayerImpl.Companion companion = new GraphicsLayerImpl.Companion();
            GraphicsLayerImpl.Companion.$$INSTANCE = companion;
            GraphicsLayerImpl.Companion.DefaultDrawBlock = (Function1)GraphicsLayerImpl.Companion.DefaultDrawBlock.1.INSTANCE;
        }

        public final Function1<DrawScope, Unit> getDefaultDrawBlock() {
            return GraphicsLayerImpl.Companion.DefaultDrawBlock;
        }
    }
    static {
        GraphicsLayerImpl.Companion = GraphicsLayerImpl.Companion.$$INSTANCE;
    }

    public abstract Matrix calculateMatrix();

    public abstract void discardDisplayList();

    public abstract void draw(Canvas canvas);

    public abstract float getAlpha();

    public abstract long getAmbientShadowColor-0d7_KjU();

    public abstract int getBlendMode-0nO6VwU();

    public abstract float getCameraDistance();

    public abstract boolean getClip();

    public abstract ColorFilter getColorFilter();

    public abstract int getCompositingStrategy-ke2Ky5w();

    public boolean getHasDisplayList() {
        return 1;
    }

    public abstract long getLayerId();

    public abstract long getOwnerId();

    public abstract long getPivotOffset-F1C5BW0();

    public abstract RenderEffect getRenderEffect();

    public abstract float getRotationX();

    public abstract float getRotationY();

    public abstract float getRotationZ();

    public abstract float getScaleX();

    public abstract float getScaleY();

    public abstract float getShadowElevation();

    public abstract long getSpotShadowColor-0d7_KjU();

    public abstract float getTranslationX();

    public abstract float getTranslationY();

    public abstract boolean isInvalidated();

    public abstract void record(Density density, LayoutDirection layoutDirection2, androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer3, Function1<? super DrawScope, Unit> function14);

    public abstract void setAlpha(float f);

    public abstract void setAmbientShadowColor-8_81llA(long l);

    public abstract void setBlendMode-s9anfk8(int i);

    public abstract void setCameraDistance(float f);

    public abstract void setClip(boolean z);

    public abstract void setColorFilter(ColorFilter colorFilter);

    public abstract void setCompositingStrategy-Wpw9cng(int i);

    public abstract void setInvalidated(boolean z);

    public abstract void setOutline(Outline outline);

    public abstract void setPivotOffset-k-4lQ0M(long l);

    public abstract void setPosition-H0pRuoY(int i, int i2, long l3);

    public abstract void setRenderEffect(RenderEffect renderEffect);

    public abstract void setRotationX(float f);

    public abstract void setRotationY(float f);

    public abstract void setRotationZ(float f);

    public abstract void setScaleX(float f);

    public abstract void setScaleY(float f);

    public abstract void setShadowElevation(float f);

    public abstract void setSpotShadowColor-8_81llA(long l);

    public abstract void setTranslationX(float f);

    public abstract void setTranslationY(float f);
}
