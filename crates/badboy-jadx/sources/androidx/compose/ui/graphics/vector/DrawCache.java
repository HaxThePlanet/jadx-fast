package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapConfig.Companion;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002JI\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00190\u001c¢\u0006\u0002\u0008\u001eø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J$\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u001d2\u0008\u0008\u0002\u0010#\u001a\u00020$2\n\u0008\u0002\u0010%\u001a\u0004\u0018\u00010&J\u000c\u0010'\u001a\u00020\u0019*\u00020\u001dH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000c\u001a\u0004\u0018\u00010\r8\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u000e\u0010\u0002\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u00020\u0016X\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0017\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006(", d2 = {"Landroidx/compose/ui/graphics/vector/DrawCache;", "", "()V", "cacheScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "cachedCanvas", "Landroidx/compose/ui/graphics/Canvas;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "I", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "mCachedImage", "Landroidx/compose/ui/graphics/ImageBitmap;", "getMCachedImage$annotations", "getMCachedImage", "()Landroidx/compose/ui/graphics/ImageBitmap;", "setMCachedImage", "(Landroidx/compose/ui/graphics/ImageBitmap;)V", "scopeDensity", "Landroidx/compose/ui/unit/Density;", "size", "Landroidx/compose/ui/unit/IntSize;", "J", "drawCachedImage", "", "density", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Lkotlin/ExtensionFunctionType;", "drawCachedImage-FqjB98A", "(IJLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)V", "drawInto", "target", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "clear", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawCache {

    public static final int $stable = 8;
    private final CanvasDrawScope cacheScope;
    private Canvas cachedCanvas;
    private int config;
    private LayoutDirection layoutDirection;
    private ImageBitmap mCachedImage;
    private Density scopeDensity;
    private long size;
    static {
        final int i = 8;
    }

    public DrawCache() {
        super();
        this.layoutDirection = LayoutDirection.Ltr;
        this.size = IntSize.Companion.getZero-YbymL2g();
        this.config = ImageBitmapConfig.Companion.getArgb8888-_sVssgQ();
        CanvasDrawScope canvasDrawScope = new CanvasDrawScope();
        this.cacheScope = canvasDrawScope;
    }

    private final void clear(DrawScope $this$clear) {
        DrawScope.drawRect-n-J9OG0$default($this$clear, Color.Companion.getBlack-0d7_KjU(), obj3, 0, obj5, 0, obj7, 0, 0, 0);
    }

    public static void drawInto$default(androidx.compose.ui.graphics.vector.DrawCache drawCache, DrawScope drawScope2, float f3, ColorFilter colorFilter4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 1065353216;
        }
        if (i5 &= 4 != 0) {
            obj3 = 0;
        }
        drawCache.drawInto(drawScope2, obj2, obj3);
    }

    public static void getMCachedImage$annotations() {
    }

    public final void drawCachedImage-FqjB98A(int config, long size, Density density, LayoutDirection layoutDirection, Function1<? super DrawScope, Unit> block) {
        int height-impl;
        int height-impl2;
        int i3;
        int i;
        int i2;
        int i4;
        ImageBitmap targetImage;
        Canvas targetCanvas;
        Object obj = this;
        final int i5 = config;
        final Density density2 = layoutDirection;
        final LayoutDirection layoutDirection2 = block;
        obj.scopeDensity = density2;
        obj.layoutDirection = layoutDirection2;
        targetImage = obj.mCachedImage;
        if (targetImage != null && obj.cachedCanvas != null && IntSize.getWidth-impl(size) <= targetImage.getWidth() && IntSize.getHeight-impl(size) <= targetImage.getHeight()) {
            if (obj.cachedCanvas != null) {
                if (IntSize.getWidth-impl(size) <= targetImage.getWidth()) {
                    if (IntSize.getHeight-impl(size) <= targetImage.getHeight()) {
                        if (!ImageBitmapConfig.equals-impl0(obj.config, i5)) {
                            targetImage = ImageBitmapKt.ImageBitmap-x__-hDU$default(IntSize.getWidth-impl(size), IntSize.getHeight-impl(size), i5, false, 0, 24, 0);
                            obj.mCachedImage = targetImage;
                            obj.cachedCanvas = CanvasKt.Canvas(targetImage);
                            obj.config = i5;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        long l = size;
        obj.size = l;
        CanvasDrawScope cacheScope = obj.cacheScope;
        int i6 = 0;
        CanvasDrawScope.DrawParams drawParams = cacheScope.getDrawParams();
        CanvasDrawScope.DrawParams drawParams2 = cacheScope.getDrawParams();
        int i7 = 0;
        drawParams2.setDensity(density2);
        drawParams2.setLayoutDirection(layoutDirection2);
        drawParams2.setCanvas(targetCanvas);
        drawParams2.setSize-uvyYCjk(IntSizeKt.toSize-ozmzZPI(l));
        targetCanvas.save();
        CanvasDrawScope canvasDrawScope = cacheScope;
        int i8 = 0;
        obj.clear((DrawScope)canvasDrawScope);
        obj23.invoke(canvasDrawScope);
        targetCanvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = cacheScope.getDrawParams();
        int i9 = 0;
        drawParams3.setDensity(drawParams.component1());
        drawParams3.setLayoutDirection(drawParams.component2());
        drawParams3.setCanvas(drawParams.component3());
        drawParams3.setSize-uvyYCjk(drawParams.component4-NH-jbRc());
        targetImage.prepareToDraw();
    }

    public final void drawInto(DrawScope target, float alpha, ColorFilter colorFilter) {
        int i;
        String $i$a$CheckPreconditionDrawCache$drawInto$1;
        final Object obj = this;
        final ImageBitmap mCachedImage = obj.mCachedImage;
        i = mCachedImage != null ? 1 : 0;
        int i2 = 0;
        if (i == 0) {
            int i4 = 0;
            InlineClassHelperKt.throwIllegalStateException("drawCachedImage must be invoked first before attempting to draw the result into another destination");
        }
        DrawScope.drawImage-AZ2fEMs$default(target, mCachedImage, 0, $i$a$CheckPreconditionDrawCache$drawInto$1, obj.size, obj6, 0, obj8, 0, obj10, alpha, 0, colorFilter);
    }

    public final ImageBitmap getMCachedImage() {
        return this.mCachedImage;
    }

    public final void setMCachedImage(ImageBitmap <set-?>) {
        this.mCachedImage = <set-?>;
    }
}
