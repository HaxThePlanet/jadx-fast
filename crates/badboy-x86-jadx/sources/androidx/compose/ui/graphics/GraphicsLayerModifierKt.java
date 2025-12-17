package androidx.compose.ui.graphics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0007\u001a\u0098\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a¤\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a¸\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\u0008!\u0010\"\u001aÂ\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u00082\u0008\u0008\u0002\u0010\r\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\n\u0008\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020\u001f2\u0008\u0008\u0002\u0010#\u001a\u00020$H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a\u000c\u0010'\u001a\u00020\u0001*\u00020\u0001H\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"graphicsLayer", "Landroidx/compose/ui/Modifier;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "", "Lkotlin/ExtensionFunctionType;", "scaleX", "", "scaleY", "alpha", "translationX", "translationY", "shadowElevation", "rotationX", "rotationY", "rotationZ", "cameraDistance", "transformOrigin", "Landroidx/compose/ui/graphics/TransformOrigin;", "shape", "Landroidx/compose/ui/graphics/Shape;", "clip", "", "graphicsLayer-sKFY_QE", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;Z)Landroidx/compose/ui/Modifier;", "renderEffect", "Landroidx/compose/ui/graphics/RenderEffect;", "graphicsLayer-2Xn7asI", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;)Landroidx/compose/ui/Modifier;", "ambientShadowColor", "Landroidx/compose/ui/graphics/Color;", "spotShadowColor", "graphicsLayer-pANQ8Wg", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJ)Landroidx/compose/ui/Modifier;", "compositingStrategy", "Landroidx/compose/ui/graphics/CompositingStrategy;", "graphicsLayer-Ap8cVGQ", "(Landroidx/compose/ui/Modifier;FFFFFFFFFFJLandroidx/compose/ui/graphics/Shape;ZLandroidx/compose/ui/graphics/RenderEffect;JJI)Landroidx/compose/ui/Modifier;", "toolingGraphicsLayer", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayerModifierKt {
    public static final Modifier graphicsLayer(Modifier $this$graphicsLayer, Function1<? super androidx.compose.ui.graphics.GraphicsLayerScope, Unit> block) {
        BlockGraphicsLayerElement blockGraphicsLayerElement = new BlockGraphicsLayerElement(block);
        return $this$graphicsLayer.then((Modifier)blockGraphicsLayerElement);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes shadow color parameters", replaceWith = @ReplaceWith(...))
    public static final Modifier graphicsLayer-2Xn7asI(Modifier $this$graphicsLayer_u2d2Xn7asI, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, androidx.compose.ui.graphics.Shape shape, boolean clip, androidx.compose.ui.graphics.RenderEffect renderEffect) {
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ($this$graphicsLayer_u2d2Xn7asI, scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, obj13, clip, renderEffect, obj37, GraphicsLayerScopeKt.getDefaultShadowColor(), obj18);
    }

    public static Modifier graphicsLayer-2Xn7asI$default(Modifier modifier, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long l12, androidx.compose.ui.graphics.Shape shape13, boolean z14, androidx.compose.ui.graphics.RenderEffect renderEffect15, int i16, Object object17) {
        int i2;
        int i11;
        int i9;
        int i6;
        int i4;
        int i10;
        int i3;
        int i12;
        int i;
        int i8;
        int i7;
        long center-SzJe1aQ;
        androidx.compose.ui.graphics.Shape rectangleShape;
        int i5;
        int i13 = object17;
        i9 = 1065353216;
        i11 = i13 & 1 != 0 ? i9 : f2;
        i6 = i13 & 2 != 0 ? i9 : f3;
        if (i13 & 4 != 0) {
        } else {
            i9 = f4;
        }
        i10 = 0;
        i4 = i13 & 8 != 0 ? i10 : f5;
        i3 = i13 & 16 != 0 ? i10 : f6;
        i12 = i13 & 32 != 0 ? i10 : f7;
        i = i13 & 64 != 0 ? i10 : f8;
        i8 = i13 & 128 != 0 ? i10 : f9;
        if (i13 & 256 != 0) {
        } else {
            i10 = f10;
        }
        i7 = i13 & 512 != 0 ? 1090519040 : f11;
        if (i13 & 1024 != 0) {
            center-SzJe1aQ = TransformOrigin.Companion.getCenter-SzJe1aQ();
        } else {
            center-SzJe1aQ = l12;
        }
        if (i13 & 2048 != 0) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        } else {
            rectangleShape = z14;
        }
        i5 = i13 & 4096 != 0 ? 0 : renderEffect15;
        i2 = i13 &= 8192 != 0 ? 0 : i16;
        return GraphicsLayerModifierKt.graphicsLayer-2Xn7asI(modifier, i11, i6, i9, i4, i3, i12, i, i8, i10, i7, center-SzJe1aQ, z14, rectangleShape, i5);
    }

    public static final Modifier graphicsLayer-Ap8cVGQ(Modifier $this$graphicsLayer_u2dAp8cVGQ, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, androidx.compose.ui.graphics.Shape shape, boolean clip, androidx.compose.ui.graphics.RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor, int compositingStrategy) {
        GraphicsLayerElement graphicsLayerElement = new GraphicsLayerElement(scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, obj12, clip, renderEffect, ambientShadowColor, spotShadowColor, obj17, obj40, obj19, obj42, 0);
        return $this$graphicsLayer_u2dAp8cVGQ.then((Modifier)graphicsLayerElement);
    }

    public static Modifier graphicsLayer-Ap8cVGQ$default(Modifier modifier, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long l12, androidx.compose.ui.graphics.Shape shape13, boolean z14, androidx.compose.ui.graphics.RenderEffect renderEffect15, long l16, long l17, int i18, int i19, Object object20) {
        int auto--NrFUSI;
        int i3;
        int i10;
        int i9;
        int i4;
        int i11;
        int i8;
        int i5;
        int i2;
        int i;
        int i6;
        long center-SzJe1aQ;
        androidx.compose.ui.graphics.Shape rectangleShape;
        int i7;
        int i12;
        long defaultShadowColor2;
        long defaultShadowColor;
        int i13 = obj41;
        i10 = 1065353216;
        i3 = i13 & 1 != 0 ? i10 : f2;
        i9 = i13 & 2 != 0 ? i10 : f3;
        if (i13 & 4 != 0) {
        } else {
            i10 = f4;
        }
        i11 = 0;
        i4 = i13 & 8 != 0 ? i11 : f5;
        i8 = i13 & 16 != 0 ? i11 : f6;
        i5 = i13 & 32 != 0 ? i11 : f7;
        i2 = i13 & 64 != 0 ? i11 : f8;
        i = i13 & 128 != 0 ? i11 : f9;
        if (i13 & 256 != 0) {
        } else {
            i11 = f10;
        }
        i6 = i13 & 512 != 0 ? 1090519040 : f11;
        if (i13 & 1024 != 0) {
            center-SzJe1aQ = TransformOrigin.Companion.getCenter-SzJe1aQ();
        } else {
            center-SzJe1aQ = l12;
        }
        if (i13 & 2048 != 0) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        } else {
            rectangleShape = z14;
        }
        i7 = i13 & 4096 != 0 ? 0 : renderEffect15;
        i12 = i13 & 8192 != 0 ? 0 : l16;
        if (i13 & 16384 != 0) {
            defaultShadowColor2 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            defaultShadowColor2 = l17;
        }
        if (i17 &= i13 != 0) {
            defaultShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            defaultShadowColor = i19;
        }
        if (i13 &= i21 != 0) {
            auto--NrFUSI = CompositingStrategy.Companion.getAuto--NrFUSI();
        } else {
            auto--NrFUSI = obj40;
        }
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ(modifier, i3, i9, i10, i4, i8, i5, i2, i, i11, i6, center-SzJe1aQ, z14, rectangleShape, i7, i12, defaultShadowColor2, i19);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes a compositing strategy", replaceWith = @ReplaceWith(...))
    public static final Modifier graphicsLayer-pANQ8Wg(Modifier $this$graphicsLayer_u2dpANQ8Wg, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, androidx.compose.ui.graphics.Shape shape, boolean clip, androidx.compose.ui.graphics.RenderEffect renderEffect, long ambientShadowColor, long spotShadowColor) {
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ($this$graphicsLayer_u2dpANQ8Wg, scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, obj13, clip, renderEffect, ambientShadowColor, spotShadowColor, obj18);
    }

    public static Modifier graphicsLayer-pANQ8Wg$default(Modifier modifier, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long l12, androidx.compose.ui.graphics.Shape shape13, boolean z14, androidx.compose.ui.graphics.RenderEffect renderEffect15, long l16, long l17, int i18, Object object19) {
        long defaultShadowColor2;
        int i7;
        int i9;
        int i;
        int i3;
        int i10;
        int i6;
        int i8;
        int i4;
        int i12;
        int i5;
        long center-SzJe1aQ;
        androidx.compose.ui.graphics.Shape rectangleShape;
        int i11;
        int i2;
        long defaultShadowColor;
        int i13 = obj38;
        i9 = 1065353216;
        i7 = i13 & 1 != 0 ? i9 : f2;
        i = i13 & 2 != 0 ? i9 : f3;
        if (i13 & 4 != 0) {
        } else {
            i9 = f4;
        }
        i10 = 0;
        i3 = i13 & 8 != 0 ? i10 : f5;
        i6 = i13 & 16 != 0 ? i10 : f6;
        i8 = i13 & 32 != 0 ? i10 : f7;
        i4 = i13 & 64 != 0 ? i10 : f8;
        i12 = i13 & 128 != 0 ? i10 : f9;
        if (i13 & 256 != 0) {
        } else {
            i10 = f10;
        }
        i5 = i13 & 512 != 0 ? 1090519040 : f11;
        if (i13 & 1024 != 0) {
            center-SzJe1aQ = TransformOrigin.Companion.getCenter-SzJe1aQ();
        } else {
            center-SzJe1aQ = l12;
        }
        if (i13 & 2048 != 0) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        } else {
            rectangleShape = z14;
        }
        i11 = i13 & 4096 != 0 ? 0 : renderEffect15;
        i2 = i13 & 8192 != 0 ? 0 : l16;
        if (i13 & 16384 != 0) {
            defaultShadowColor = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            defaultShadowColor = l17;
        }
        if (i13 &= i17 != 0) {
            defaultShadowColor2 = GraphicsLayerScopeKt.getDefaultShadowColor();
        } else {
            defaultShadowColor2 = object19;
        }
        return GraphicsLayerModifierKt.graphicsLayer-pANQ8Wg(modifier, i7, i, i9, i3, i6, i8, i4, i12, i10, i5, center-SzJe1aQ, z14, rectangleShape, i11, i2, defaultShadowColor);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Replace with graphicsLayer that consumes an optional RenderEffect parameter and shadow color parameters", replaceWith = @ReplaceWith(...))
    public static final Modifier graphicsLayer-sKFY_QE(Modifier $this$graphicsLayer_u2dsKFY_QE, float scaleX, float scaleY, float alpha, float translationX, float translationY, float shadowElevation, float rotationX, float rotationY, float rotationZ, float cameraDistance, long transformOrigin, androidx.compose.ui.graphics.Shape shape, boolean clip) {
        return GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default($this$graphicsLayer_u2dsKFY_QE, scaleX, scaleY, alpha, translationX, translationY, shadowElevation, rotationX, rotationY, rotationZ, cameraDistance, transformOrigin, obj13, clip, obj38, 0, 0, obj18, 0, obj20);
    }

    public static Modifier graphicsLayer-sKFY_QE$default(Modifier modifier, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, long l12, androidx.compose.ui.graphics.Shape shape13, boolean z14, int i15, Object object16) {
        int i9;
        int i;
        int i8;
        int i5;
        int i10;
        int i2;
        int i6;
        int i3;
        int i4;
        int i7;
        long center-SzJe1aQ;
        androidx.compose.ui.graphics.Shape rectangleShape;
        int obj14;
        int i11 = object16;
        i8 = 1065353216;
        if (i11 & 1 != 0) {
            obj14 = i8;
        }
        i = i11 & 2 != 0 ? i8 : f3;
        if (i11 & 4 != 0) {
        } else {
            i8 = f4;
        }
        i10 = 0;
        i5 = i11 & 8 != 0 ? i10 : f5;
        i2 = i11 & 16 != 0 ? i10 : f6;
        i6 = i11 & 32 != 0 ? i10 : f7;
        i3 = i11 & 64 != 0 ? i10 : f8;
        i4 = i11 & 128 != 0 ? i10 : f9;
        if (i11 & 256 != 0) {
        } else {
            i10 = f10;
        }
        i7 = i11 & 512 != 0 ? 1090519040 : f11;
        if (i11 & 1024 != 0) {
            center-SzJe1aQ = TransformOrigin.Companion.getCenter-SzJe1aQ();
        } else {
            center-SzJe1aQ = l12;
        }
        if (i11 & 2048 != 0) {
            rectangleShape = RectangleShapeKt.getRectangleShape();
        } else {
            rectangleShape = z14;
        }
        i9 = i11 &= 4096 != 0 ? 0 : i15;
        return GraphicsLayerModifierKt.graphicsLayer-sKFY_QE(modifier, obj14, i, i8, i5, i2, i6, i3, i4, i10, i7, center-SzJe1aQ, z14, rectangleShape);
    }

    public static final Modifier toolingGraphicsLayer(Modifier $this$toolingGraphicsLayer) {
        Modifier then;
        Modifier modifier;
        int i4;
        int i15;
        int i14;
        int i;
        int i2;
        int i10;
        int i3;
        int i16;
        int i18;
        int i5;
        int i11;
        int i9;
        int i8;
        int i6;
        int i12;
        int i17;
        int i19;
        int i7;
        int i13;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            then = $this$toolingGraphicsLayer.then(GraphicsLayerModifierKt.graphicsLayer-Ap8cVGQ$default((Modifier)Modifier.Companion, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, obj13, false, 0, 0, 0, obj18, 0, obj20));
        } else {
            then = modifier;
        }
        return then;
    }
}
