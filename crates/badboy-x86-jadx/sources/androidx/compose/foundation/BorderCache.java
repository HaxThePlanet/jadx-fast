package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapConfig.Companion;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0082\u0008\u0018\u00002\u00020\u0001B5\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÂ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÂ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0007HÂ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\tHÂ\u0003J9\u0010\u000f\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\u0006\u0010\u0015\u001a\u00020\tJ\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J@\u0010\u0018\u001a\u00020\u0003*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f¢\u0006\u0002\u0008\"H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006%", d2 = {"Landroidx/compose/foundation/BorderCache;", "", "imageBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "borderPath", "Landroidx/compose/ui/graphics/Path;", "(Landroidx/compose/ui/graphics/ImageBitmap;Landroidx/compose/ui/graphics/Canvas;Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;Landroidx/compose/ui/graphics/Path;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "obtainPath", "toString", "", "drawBorderCache", "Landroidx/compose/ui/draw/CacheDrawScope;", "borderSize", "Landroidx/compose/ui/unit/IntSize;", "config", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawBorderCache-EMwLDEs", "(Landroidx/compose/ui/draw/CacheDrawScope;JILkotlin/jvm/functions/Function1;)Landroidx/compose/ui/graphics/ImageBitmap;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class BorderCache {

    private Path borderPath;
    private Canvas canvas;
    private CanvasDrawScope canvasDrawScope;
    private ImageBitmap imageBitmap;
    public BorderCache() {
        super(0, 0, 0, 0, 15, 0);
    }

    public BorderCache(ImageBitmap imageBitmap, Canvas canvas, CanvasDrawScope canvasDrawScope, Path borderPath) {
        super();
        this.imageBitmap = imageBitmap;
        this.canvas = canvas;
        this.canvasDrawScope = canvasDrawScope;
        this.borderPath = borderPath;
    }

    public BorderCache(ImageBitmap imageBitmap, Canvas canvas2, CanvasDrawScope canvasDrawScope3, Path path4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public static final Canvas access$getCanvas$p(androidx.compose.foundation.BorderCache $this) {
        return $this.canvas;
    }

    public static final CanvasDrawScope access$getCanvasDrawScope$p(androidx.compose.foundation.BorderCache $this) {
        return $this.canvasDrawScope;
    }

    public static final ImageBitmap access$getImageBitmap$p(androidx.compose.foundation.BorderCache $this) {
        return $this.imageBitmap;
    }

    public static final void access$setCanvas$p(androidx.compose.foundation.BorderCache $this, Canvas <set-?>) {
        $this.canvas = <set-?>;
    }

    public static final void access$setCanvasDrawScope$p(androidx.compose.foundation.BorderCache $this, CanvasDrawScope <set-?>) {
        $this.canvasDrawScope = <set-?>;
    }

    public static final void access$setImageBitmap$p(androidx.compose.foundation.BorderCache $this, ImageBitmap <set-?>) {
        $this.imageBitmap = <set-?>;
    }

    private final ImageBitmap component1() {
        return this.imageBitmap;
    }

    private final Canvas component2() {
        return this.canvas;
    }

    private final CanvasDrawScope component3() {
        return this.canvasDrawScope;
    }

    private final Path component4() {
        return this.borderPath;
    }

    public static androidx.compose.foundation.BorderCache copy$default(androidx.compose.foundation.BorderCache borderCache, ImageBitmap imageBitmap2, Canvas canvas3, CanvasDrawScope canvasDrawScope4, Path path5, int i6, Object object7) {
        ImageBitmap obj1;
        Canvas obj2;
        CanvasDrawScope obj3;
        Path obj4;
        if (i6 & 1 != 0) {
            obj1 = borderCache.imageBitmap;
        }
        if (i6 & 2 != 0) {
            obj2 = borderCache.canvas;
        }
        if (i6 & 4 != 0) {
            obj3 = borderCache.canvasDrawScope;
        }
        if (i6 &= 8 != 0) {
            obj4 = borderCache.borderPath;
        }
        return borderCache.copy(obj1, obj2, obj3, obj4);
    }

    public final androidx.compose.foundation.BorderCache copy(ImageBitmap imageBitmap, Canvas canvas2, CanvasDrawScope canvasDrawScope3, Path path4) {
        BorderCache borderCache = new BorderCache(imageBitmap, canvas2, canvasDrawScope3, path4);
        return borderCache;
    }

    public final ImageBitmap drawBorderCache-EMwLDEs(CacheDrawScope $this$drawBorderCache_u2dEMwLDEs, long borderSize, int config, Function1<? super DrawScope, Unit> block) {
        ImageBitmap targetImageBitmap;
        Canvas targetCanvas;
        int equals-impl;
        CanvasDrawScope canvasDrawScope;
        ImageBitmapConfig box-impl;
        int equals-impl0;
        int argb8888-_sVssgQ;
        int i2;
        int width-impl;
        int height-impl;
        int i3;
        int i;
        int i5;
        int i4;
        int i6;
        androidx.compose.foundation.BorderCache borderCache = this;
        targetImageBitmap = BorderCache.access$getImageBitmap$p(borderCache);
        if (targetImageBitmap != null) {
            box-impl = ImageBitmapConfig.box-impl(targetImageBitmap.getConfig-_sVssgQ());
        } else {
            box-impl = equals-impl;
        }
        if (box-impl == null) {
            equals-impl0 = i2;
        } else {
            equals-impl0 = ImageBitmapConfig.equals-impl0(box-impl.unbox-impl(), ImageBitmapConfig.Companion.getArgb8888-_sVssgQ());
        }
        if (equals-impl0 == 0) {
            if (targetImageBitmap != null) {
                equals-impl = ImageBitmapConfig.box-impl(targetImageBitmap.getConfig-_sVssgQ());
            }
            if (ImageBitmapConfig.equals-impl(block, equals-impl)) {
                i2 = 1;
            }
        } else {
            i3 = block;
        }
        equals-impl0 = (float)width;
        if (targetImageBitmap != null && BorderCache.access$getCanvas$p(borderCache) != null && Float.compare(width-impl2, equals-impl0) <= 0 && Float.compare(height-impl2, equals-impl0) <= 0) {
            if (BorderCache.access$getCanvas$p(borderCache) != null) {
                equals-impl0 = (float)width;
                if (Float.compare(width-impl2, equals-impl0) <= 0) {
                    if (Float.compare(height-impl2, equals-impl0) <= 0) {
                        if (i2 == 0) {
                            ImageBitmap imageBitmap = ImageBitmapKt.ImageBitmap-x__-hDU$default(IntSize.getWidth-impl(borderSize), IntSize.getHeight-impl(borderSize), i3, false, 0, 24, 0);
                            int i9 = 0;
                            BorderCache.access$setImageBitmap$p(borderCache, imageBitmap);
                            equals-impl = CanvasKt.Canvas(imageBitmap);
                            argb8888-_sVssgQ = 0;
                            BorderCache.access$setCanvas$p(borderCache, equals-impl);
                            targetCanvas = equals-impl;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (BorderCache.access$getCanvasDrawScope$p(borderCache) == null) {
            canvasDrawScope = new CanvasDrawScope();
            argb8888-_sVssgQ = 0;
            BorderCache.access$setCanvasDrawScope$p(borderCache, canvasDrawScope);
        }
        long size-ozmzZPI = IntSizeKt.toSize-ozmzZPI(borderSize);
        CanvasDrawScope canvasDrawScope2 = canvasDrawScope;
        final int i15 = 0;
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        androidx.compose.ui.unit.LayoutDirection component2 = drawParams.component2();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        int i11 = 0;
        drawParams2.setDensity((Density)$this$drawBorderCache_u2dEMwLDEs);
        drawParams2.setLayoutDirection($this$drawBorderCache_u2dEMwLDEs.getLayoutDirection());
        drawParams2.setCanvas(targetCanvas);
        drawParams2.setSize-uvyYCjk(size-ozmzZPI);
        targetCanvas.save();
        CanvasDrawScope canvasDrawScope3 = canvasDrawScope2;
        final int i16 = i7;
        int prevSize$iv2 = i8;
        final ImageBitmap imageBitmap3 = targetImageBitmap;
        CanvasDrawScope prevLayoutDirection$iv = canvasDrawScope;
        DrawScope.drawRect-n-J9OG0$default((DrawScope)canvasDrawScope3, Color.Companion.getBlack-0d7_KjU(), component2, 0, i5, size-ozmzZPI, i6, 0, 0, 0);
        obj35.invoke(canvasDrawScope3);
        targetCanvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        int i10 = 0;
        drawParams3.setDensity(drawParams.component1());
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(drawParams.component3());
        drawParams3.setSize-uvyYCjk(drawParams.component4-NH-jbRc());
        imageBitmap3.prepareToDraw();
        return imageBitmap3;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof BorderCache) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.imageBitmap, obj.imageBitmap)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.canvas, obj.canvas)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.canvasDrawScope, obj.canvasDrawScope)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.borderPath, obj.borderPath)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        i2 = 0;
        if (this.imageBitmap == null) {
            i = i2;
        } else {
            i = this.imageBitmap.hashCode();
        }
        if (this.canvas == null) {
            i3 = i2;
        } else {
            i3 = this.canvas.hashCode();
        }
        if (this.canvasDrawScope == null) {
            i4 = i2;
        } else {
            i4 = this.canvasDrawScope.hashCode();
        }
        if (this.borderPath == null) {
        } else {
            i2 = this.borderPath.hashCode();
        }
        return i9 += i2;
    }

    public final Path obtainPath() {
        Path borderPath;
        Path path;
        int i;
        if (this.borderPath == null) {
            i = 0;
            this.borderPath = AndroidPath_androidKt.Path();
        }
        return borderPath;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("BorderCache(imageBitmap=").append(this.imageBitmap).append(", canvas=").append(this.canvas).append(", canvasDrawScope=").append(this.canvasDrawScope).append(", borderPath=").append(this.borderPath).append(')').toString();
    }
}
