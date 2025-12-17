package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.BlendMode.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorFilter.Companion;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapConfig.Companion;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.PathOperation.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope.DrawParams;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006/", d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BorderModifierNode extends DelegatingNode {

    public static final int $stable = 8;
    private androidx.compose.foundation.BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;
    static {
        final int i = 8;
    }

    private BorderModifierNode(float widthParameter, Brush brushParameter, Shape shapeParameter) {
        super();
        this.width = widthParameter;
        this.brush = brushParameter;
        this.shape = shapeParameter;
        BorderModifierNode.drawWithCacheModifierNode.1 anon = new BorderModifierNode.drawWithCacheModifierNode.1(this);
        this.drawWithCacheModifierNode = (CacheDrawModifierNode)delegate((DelegatableNode)DrawModifierKt.CacheDrawModifierNode((Function1)anon));
    }

    public BorderModifierNode(float f, Brush brush2, Shape shape3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(f, brush2, shape3);
    }

    public static final DrawResult access$drawGenericBorder(androidx.compose.foundation.BorderModifierNode $this, CacheDrawScope $receiver, Brush brush, Outline.Generic outline, boolean fillArea, float strokeWidth) {
        return $this.drawGenericBorder($receiver, brush, outline, fillArea, strokeWidth);
    }

    public static final DrawResult access$drawRoundRectBorder-JqoCqck(androidx.compose.foundation.BorderModifierNode $this, CacheDrawScope $receiver, Brush brush, Outline.Rounded outline, long topLeft, long borderSize, boolean fillArea, float strokeWidth) {
        return $this.drawRoundRectBorder-JqoCqck($receiver, brush, outline, topLeft, borderSize, fillArea, strokeWidth);
    }

    private final DrawResult drawGenericBorder(CacheDrawScope $this$drawGenericBorder, Brush brush, Outline.Generic outline, boolean fillArea, float strokeWidth) {
        int config2;
        androidx.compose.foundation.BorderCache borderCache;
        ImageBitmap targetImageBitmap$iv;
        CanvasDrawScope canvasDrawScope6;
        DrawResult onDrawWithContent;
        Ref.ObjectRef objectRef;
        Object obj;
        long l;
        int i3;
        androidx.compose.foundation.BorderModifierNode.drawGenericBorder.3 anon;
        ColorFilter colorFilter;
        Rect rect2;
        Object companion;
        DrawContext transform;
        int i20;
        ColorFilter.Companion prevCanvas$iv$iv;
        long $this$withTransform_u24lambda_u246$iv$iv;
        boolean equals-impl;
        long left$iv;
        int top$iv;
        Canvas targetCanvas$iv;
        int pathBounds;
        int box-impl;
        boolean equals-impl0;
        int i21;
        int i23;
        int prevCanvas$iv$iv2;
        long $this$drawGenericBorder_u24lambda_u244_u24lambda_u243_u24lambda_u242;
        int size-NH-jbRc;
        ImageBitmap imageBitmap;
        Canvas canvas;
        androidx.compose.ui.unit.LayoutDirection targetCanvas$iv2;
        Canvas config;
        int i13;
        int i17;
        int i15;
        int i6;
        int i18;
        ColorFilter canvas2;
        int maskPath;
        int i19;
        int i7;
        int i2;
        int i8;
        int i;
        int i24;
        int i10;
        CanvasDrawScope canvasDrawScope5;
        CanvasDrawScope canvasDrawScope;
        int i12;
        CanvasDrawScope canvasDrawScope7;
        int i5;
        long l2;
        int i22;
        androidx.compose.ui.unit.LayoutDirection cacheImageBitmap;
        Rect rect;
        Canvas prevSize$iv$iv;
        int i11;
        ImageBitmap left$iv2;
        Ref.ObjectRef prevDensity$iv$iv;
        long prevLayoutDirection$iv$iv;
        CanvasDrawScope canvasDrawScope3;
        int i4;
        int i9;
        CanvasDrawScope canvasDrawScope4;
        int i25;
        int i16;
        int i14;
        DrawContext previousSize$iv$iv;
        androidx.compose.ui.unit.LayoutDirection layoutDirection;
        long l3;
        CanvasDrawScope canvasDrawScope2;
        DrawContext context;
        long l4;
        obj = this;
        i3 = $this$drawGenericBorder;
        Brush brush2 = brush;
        if (fillArea) {
            BorderModifierNode.drawGenericBorder.1 anon2 = new BorderModifierNode.drawGenericBorder.1(outline, brush2);
            onDrawWithContent = i3.onDrawWithContent((Function1)anon2);
            i20 = i3;
        } else {
            Outline.Generic generic = outline;
            int i26 = 0;
            int i34 = 0;
            if (brush2 instanceof SolidColor) {
                i13 = config2;
                canvas2 = colorFilter;
            } else {
                i13 = config2;
                canvas2 = colorFilter;
            }
            Rect bounds = generic.getPath().getBounds();
            if (obj.borderCache == null) {
                maskPath = new BorderCache(0, 0, 0, 0, 15, 0);
                obj.borderCache = maskPath;
            }
            androidx.compose.foundation.BorderCache borderCache2 = obj.borderCache;
            Intrinsics.checkNotNull(borderCache2);
            Path path3 = borderCache2.obtainPath();
            Path path2 = path3;
            int i41 = 0;
            path2.reset();
            equals-impl = 0;
            Path.addRect$default(path2, bounds, equals-impl, 2, equals-impl);
            int difference-b3I0S0c = PathOperation.Companion.getDifference-b3I0S0c();
            path2.op-N5in7k0(path2, generic.getPath(), difference-b3I0S0c);
            Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            i19 = IntSizeKt.IntSize((int)f, (int)f4);
            androidx.compose.foundation.BorderCache borderCache3 = obj.borderCache;
            Intrinsics.checkNotNull(borderCache3);
            i8 = 0;
            androidx.compose.foundation.BorderCache borderCache4 = i2;
            i = i28;
            i24 = 0;
            targetImageBitmap$iv = BorderCache.access$getImageBitmap$p(borderCache4);
            targetCanvas$iv = BorderCache.access$getCanvas$p(borderCache4);
            if (targetImageBitmap$iv != null) {
                box-impl = ImageBitmapConfig.box-impl(targetImageBitmap$iv.getConfig-_sVssgQ());
            } else {
                box-impl = equals-impl;
            }
            if (box-impl == 0) {
                equals-impl0 = size-NH-jbRc;
            } else {
                equals-impl0 = ImageBitmapConfig.equals-impl0(box-impl.unbox-impl(), ImageBitmapConfig.Companion.getArgb8888-_sVssgQ());
            }
            if (!equals-impl0) {
                if (targetImageBitmap$iv != null) {
                    equals-impl = ImageBitmapConfig.box-impl(targetImageBitmap$iv.getConfig-_sVssgQ());
                }
                if (ImageBitmapConfig.equals-impl(i13, equals-impl)) {
                    size-NH-jbRc = 1;
                }
            } else {
            }
            if (targetImageBitmap$iv != null && targetCanvas$iv != null && Float.compare(width-impl3, equals-impl0) <= 0 && Float.compare(height-impl3, equals-impl0) <= 0) {
                if (targetCanvas$iv != null) {
                    if (Float.compare(width-impl3, equals-impl0) <= 0) {
                        if (Float.compare(height-impl3, equals-impl0) <= 0) {
                            if (size-NH-jbRc == 0) {
                                ImageBitmap imageBitmap3 = ImageBitmapKt.ImageBitmap-x__-hDU$default(IntSize.getWidth-impl(i19), IntSize.getHeight-impl(i19), i13, false, 0, 24, 0);
                                int i51 = 0;
                                BorderCache.access$setImageBitmap$p(borderCache4, imageBitmap3);
                                targetImageBitmap$iv = imageBitmap3;
                                equals-impl = CanvasKt.Canvas(targetImageBitmap$iv);
                                int i52 = 0;
                                BorderCache.access$setCanvas$p(borderCache4, equals-impl);
                                imageBitmap = targetImageBitmap$iv;
                                canvas = targetCanvas$iv;
                            } else {
                                imageBitmap = targetImageBitmap$iv;
                                canvas = targetCanvas$iv;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            if (BorderCache.access$getCanvasDrawScope$p(borderCache4) == null) {
                canvasDrawScope6 = new CanvasDrawScope();
                targetCanvas$iv = 0;
                BorderCache.access$setCanvasDrawScope$p(borderCache4, canvasDrawScope6);
            }
            long size-ozmzZPI = IntSizeKt.toSize-ozmzZPI(i19);
            androidx.compose.ui.unit.LayoutDirection layoutDirection4 = layoutDirection2;
            i15 = i17;
            i6 = 0;
            CanvasDrawScope.DrawParams drawParams = i15.getDrawParams();
            i18 = borderCache4;
            CanvasDrawScope.DrawParams drawParams2 = i15.getDrawParams();
            int i53 = 0;
            drawParams2.setDensity((Density)i);
            drawParams2.setLayoutDirection(layoutDirection4);
            drawParams2.setCanvas(canvas);
            drawParams2.setSize-uvyYCjk(size-ozmzZPI);
            canvas.save();
            canvasDrawScope5 = i15;
            i4 = 0;
            DrawScope.drawRect-n-J9OG0$default((DrawScope)canvasDrawScope5, Color.Companion.getBlack-0d7_KjU(), obj31, 0, obj33, size-ozmzZPI, obj35, 0, 0, 0);
            i12 = 0;
            int i45 = -left;
            canvasDrawScope7 = canvasDrawScope;
            int i47 = i29;
            i5 = 0;
            canvasDrawScope7.getDrawContext().getTransform().translate(i45, i47);
            CanvasDrawScope pathBounds2 = canvasDrawScope7;
            i22 = 0;
            Path path4 = outline.getPath();
            Stroke stroke = new Stroke(strokeWidth * f2, 0, 0, 0, 0, 30, 0);
            int prevCanvas$iv$iv3 = 0;
            targetCanvas$iv2 = layoutDirection5;
            i11 = i13;
            left$iv2 = imageBitmap;
            cacheImageBitmap = layoutDirection4;
            DrawScope.drawPath-GBMwjPU$default(pathBounds2, path4, brush2, prevCanvas$iv$iv3, (DrawStyle)stroke, 0, 0, 52, 0);
            CanvasDrawScope canvasDrawScope8 = pathBounds2;
            float f3 = (float)i31;
            i35 /= width-impl2;
            i38 /= height-impl;
            canvasDrawScope3 = canvasDrawScope8;
            long center-F1C5BW0 = canvasDrawScope3.getCenter-F1C5BW0();
            i9 = 0;
            canvasDrawScope4 = canvasDrawScope3;
            i25 = 0;
            DrawContext context4 = drawContext2;
            i16 = 0;
            context4.getCanvas().save();
            int i49 = 0;
            context4.getTransform().scale-0AR0LA0(i36, i39, center-F1C5BW0);
            int i32 = 0;
            i14 = i50;
            l3 = center-F1C5BW0;
            $this$withTransform_u24lambda_u246$iv$iv = 0;
            maskPath = i39;
            Path scaleY$iv = path7;
            canvasDrawScope2 = canvasDrawScope8;
            previousSize$iv$iv = context;
            DrawScope.drawPath-GBMwjPU$default(canvasDrawScope4, scaleY$iv, brush, 0, $this$withTransform_u24lambda_u246$iv$iv, 0, BlendMode.Companion.getClear-0nO6VwU(), 28, 0);
            top$iv = scaleY$iv;
            previousSize$iv$iv.getCanvas().restore();
            previousSize$iv$iv.setSize-uvyYCjk(context4.getSize-NH-jbRc());
            canvasDrawScope7.getDrawContext().getTransform().translate(-i33, -prevCanvas$iv$iv2);
            canvas.restore();
            CanvasDrawScope.DrawParams drawParams3 = i15.getDrawParams();
            i3 = 0;
            drawParams3.setDensity(drawParams.component1());
            drawParams3.setLayoutDirection(targetCanvas$iv2);
            drawParams3.setCanvas(drawParams.component3());
            drawParams3.setSize-uvyYCjk(drawParams.component4-NH-jbRc());
            left$iv2.prepareToDraw();
            Ref.ObjectRef objectRef4 = prevDensity$iv$iv;
            objectRef4.element = left$iv2;
            prevCanvas$iv$iv = i19;
            anon = new BorderModifierNode.drawGenericBorder.3(bounds, objectRef4, prevCanvas$iv$iv, $this$withTransform_u24lambda_u246$iv$iv, canvas2);
            pathBounds = prevCanvas$iv$iv;
            onDrawWithContent = $this$drawGenericBorder.onDrawWithContent((Function1)anon);
        }
        return onDrawWithContent;
    }

    private final DrawResult drawRoundRectBorder-JqoCqck(CacheDrawScope $this$drawRoundRectBorder_u2dJqoCqck, Brush brush, Outline.Rounded outline, long topLeft, long borderSize, boolean fillArea, float strokeWidth) {
        DrawResult path;
        boolean z;
        boolean z2;
        long onDrawWithContent;
        Brush brush2;
        int i2;
        int i;
        long borderCache;
        long topLeftCornerRadius-kKHJgLs;
        int i4;
        int i5;
        Stroke stroke;
        int i6;
        int i3;
        final Object obj = this;
        final Object obj2 = $this$drawRoundRectBorder_u2dJqoCqck;
        if (RoundRectKt.isSimple(outline.getRoundRect())) {
            topLeftCornerRadius-kKHJgLs = outline.getRoundRect().getTopLeftCornerRadius-kKHJgLs();
            i5 = obj25 / f;
            int i11 = 0;
            super(obj25, 0, 0, i11, 0, 30, 0);
            BorderModifierNode.drawRoundRectBorder.1 anon = new BorderModifierNode.drawRoundRectBorder.1(obj24, brush, topLeftCornerRadius-kKHJgLs, i11, i5, obj25, topLeft, topLeftCornerRadius-kKHJgLs, fillArea, i5, stroke);
            path = obj2.onDrawWithContent((Function1)anon);
            brush2 = brush;
            z2 = obj24;
        } else {
            if (obj.borderCache == null) {
                borderCache = new BorderCache(0, 0, 0, 0, 15, 0);
                obj.borderCache = borderCache;
            }
            androidx.compose.foundation.BorderCache borderCache3 = obj.borderCache;
            Intrinsics.checkNotNull(borderCache3);
            BorderModifierNode.drawRoundRectBorder.2 anon2 = new BorderModifierNode.drawRoundRectBorder.2(BorderKt.access$createRoundRectPath(borderCache3.obtainPath(), outline.getRoundRect(), obj25, obj24), brush);
            path = onDrawWithContent;
        }
        return path;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final Brush getBrush() {
        return this.brush;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final Shape getShape() {
        return this.shape;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final float getWidth-D9Ej5fM() {
        return this.width;
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setBrush(Brush value) {
        boolean drawWithCacheModifierNode;
        if (!Intrinsics.areEqual(this.brush, value)) {
            this.brush = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setShape(Shape value) {
        boolean drawWithCacheModifierNode;
        if (!Intrinsics.areEqual(this.shape, value)) {
            this.shape = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void setWidth-0680j_4(float value) {
        boolean drawWithCacheModifierNode;
        if (!Dp.equals-impl0(this.width, value)) {
            this.width = value;
            this.drawWithCacheModifierNode.invalidateDrawCache();
        }
    }
}
