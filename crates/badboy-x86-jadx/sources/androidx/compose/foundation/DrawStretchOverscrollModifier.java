package androidx.compose.foundation;

import android.graphics.Canvas;
import android.graphics.RenderNode;
import android.widget.EdgeEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B.\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0008¢\u0006\u0002\u0008\u000b¢\u0006\u0002\u0010\u000cJ\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u001c\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J$\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u0017j\u0002`\u0018H\u0002J\u0008\u0010#\u001a\u00020\u0013H\u0002J\u0008\u0010$\u001a\u00020\u0013H\u0002J\u000c\u0010%\u001a\u00020\n*\u00020&H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011¨\u0006'", d2 = {"Landroidx/compose/foundation/DrawStretchOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Lkotlin/jvm/functions/Function1;)V", "_renderNode", "Landroid/graphics/RenderNode;", "renderNode", "getRenderNode", "()Landroid/graphics/RenderNode;", "drawBottomStretch", "", "bottom", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawLeftStretch", "left", "drawRightStretch", "right", "drawTopStretch", "top", "drawWithRotation", "rotationDegrees", "", "edgeEffect", "shouldDrawHorizontalStretch", "shouldDrawVerticalStretch", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DrawStretchOverscrollModifier extends InspectorValueInfo implements DrawModifier {

    private RenderNode _renderNode;
    private final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper;
    private final androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect overscrollEffect;
    public DrawStretchOverscrollModifier(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect overscrollEffect, androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        this.overscrollEffect = overscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
    }

    private final boolean drawBottomStretch(EdgeEffect bottom, Canvas canvas) {
        return drawWithRotation(1127481344, bottom, canvas);
    }

    private final boolean drawLeftStretch(EdgeEffect left, Canvas canvas) {
        return drawWithRotation(1132920832, left, canvas);
    }

    private final boolean drawRightStretch(EdgeEffect right, Canvas canvas) {
        return drawWithRotation(1119092736, right, canvas);
    }

    private final boolean drawTopStretch(EdgeEffect top, Canvas canvas) {
        return drawWithRotation(0, top, canvas);
    }

    private final boolean drawWithRotation(float rotationDegrees, EdgeEffect edgeEffect, Canvas canvas) {
        int i;
        i = Float.compare(rotationDegrees, i2) == 0 ? 1 : 0;
        if (i != 0) {
            return edgeEffect.draw(canvas);
        }
        canvas.rotate(rotationDegrees);
        canvas.restoreToCount(canvas.save());
        return edgeEffect.draw(canvas);
    }

    private final RenderNode getRenderNode() {
        RenderNode _renderNode;
        RenderNode renderNode;
        int i;
        if (this._renderNode == null) {
            _renderNode = new RenderNode("AndroidEdgeEffectOverscrollEffect");
            i = 0;
            this._renderNode = _renderNode;
        }
        return _renderNode;
    }

    private final boolean shouldDrawHorizontalStretch() {
        int i;
        boolean leftNegationStretched;
        final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        final int i2 = 0;
        if (!edgeEffectWrapper.isLeftAnimating() && !edgeEffectWrapper.isLeftNegationStretched() && !edgeEffectWrapper.isRightAnimating()) {
            if (!edgeEffectWrapper.isLeftNegationStretched()) {
                if (!edgeEffectWrapper.isRightAnimating()) {
                    if (edgeEffectWrapper.isRightNegationStretched()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    private final boolean shouldDrawVerticalStretch() {
        int i;
        boolean topNegationStretched;
        final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        final int i2 = 0;
        if (!edgeEffectWrapper.isTopAnimating() && !edgeEffectWrapper.isTopNegationStretched() && !edgeEffectWrapper.isBottomAnimating()) {
            if (!edgeEffectWrapper.isTopNegationStretched()) {
                if (!edgeEffectWrapper.isBottomAnimating()) {
                    if (edgeEffectWrapper.isBottomNegationStretched()) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.platform.InspectorValueInfo
    public void draw(ContentDrawScope $this$draw) {
        boolean needsInvalidate;
        int needsInvalidate3;
        float i;
        int distanceCompat;
        boolean topNegationStretched;
        boolean orCreateTopEffect;
        boolean rightNegationStretched;
        boolean orCreateRightEffect;
        boolean bottomNegationStretched;
        int bottomEffect;
        RenderNode renderNode;
        int width;
        boolean leftNegationStretched;
        boolean orCreateLeftEffect;
        float f;
        int i2;
        int i3;
        int height;
        int i4;
        int leftStretched;
        long orCreateBottomEffectNegation;
        EdgeEffect orCreateLeftEffectNegation;
        int i5;
        boolean needsInvalidate2;
        DrawContext context;
        Object obj = this;
        obj.overscrollEffect.updateSize-uvyYCjk$foundation_release($this$draw.getSize-NH-jbRc());
        if (Size.isEmpty-impl($this$draw.getSize-NH-jbRc())) {
            $this$draw.drawContent();
        }
        obj.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        androidx.compose.ui.unit.Density density2 = $this$draw;
        float px-0680j_4 = density2.toPx-0680j_4(ClipScrollableContainerKt.getMaxSupportedElevation());
        final Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas(density2.getDrawContext().getCanvas());
        needsInvalidate3 = 0;
        androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper = obj.edgeEffectWrapper;
        boolean drawVerticalStretch = obj.shouldDrawVerticalStretch();
        boolean drawHorizontalStretch = obj.shouldDrawHorizontalStretch();
        distanceCompat = 0;
        if (drawVerticalStretch && drawHorizontalStretch) {
            if (drawHorizontalStretch) {
                obj.getRenderNode().setPosition(distanceCompat, distanceCompat, nativeCanvas.getWidth(), nativeCanvas.getHeight());
                android.graphics.RecordingCanvas beginRecording = obj.getRenderNode().beginRecording();
                if (edgeEffectWrapper.isLeftNegationStretched()) {
                    leftNegationStretched = edgeEffectWrapper.getOrCreateLeftEffectNegation();
                    obj.drawRightStretch(leftNegationStretched, (Canvas)beginRecording);
                    leftNegationStretched.finish();
                }
                i4 = 1;
                if (edgeEffectWrapper.isLeftAnimating()) {
                    orCreateLeftEffect = edgeEffectWrapper.getOrCreateLeftEffect();
                    needsInvalidate = drawLeftStretch;
                    if (edgeEffectWrapper.isLeftStretched()) {
                        needsInvalidate2 = needsInvalidate;
                        EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateLeftEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateLeftEffect), needsInvalidate4 -= leftStretched);
                    } else {
                        needsInvalidate2 = needsInvalidate;
                    }
                    needsInvalidate3 = needsInvalidate2;
                }
                if (edgeEffectWrapper.isTopNegationStretched()) {
                    topNegationStretched = edgeEffectWrapper.getOrCreateTopEffectNegation();
                    obj.drawBottomStretch(topNegationStretched, (Canvas)beginRecording);
                    topNegationStretched.finish();
                }
                if (edgeEffectWrapper.isTopAnimating()) {
                    orCreateTopEffect = edgeEffectWrapper.getOrCreateTopEffect();
                    if (!obj.drawTopStretch(orCreateTopEffect, (Canvas)beginRecording)) {
                        if (needsInvalidate3 != 0) {
                            i3 = i4;
                        } else {
                            i3 = 0;
                        }
                    } else {
                    }
                    needsInvalidate3 = i3;
                    if (edgeEffectWrapper.isTopStretched()) {
                        EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateTopEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateTopEffect), Offset.getX-impl(obj.overscrollEffect.displacement-F1C5BW0$foundation_release()));
                    }
                }
                if (edgeEffectWrapper.isRightNegationStretched()) {
                    rightNegationStretched = edgeEffectWrapper.getOrCreateRightEffectNegation();
                    obj.drawLeftStretch(rightNegationStretched, (Canvas)beginRecording);
                    rightNegationStretched.finish();
                }
                if (edgeEffectWrapper.isRightAnimating()) {
                    orCreateRightEffect = edgeEffectWrapper.getOrCreateRightEffect();
                    if (!obj.drawRightStretch(orCreateRightEffect, (Canvas)beginRecording)) {
                        if (needsInvalidate3 != 0) {
                            i2 = i4;
                        } else {
                            i2 = 0;
                        }
                    } else {
                    }
                    needsInvalidate3 = i2;
                    if (edgeEffectWrapper.isRightStretched()) {
                        EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateRightEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateRightEffect), Offset.getY-impl(obj.overscrollEffect.displacement-F1C5BW0$foundation_release()));
                    }
                }
                if (edgeEffectWrapper.isBottomNegationStretched()) {
                    bottomNegationStretched = edgeEffectWrapper.getOrCreateBottomEffectNegation();
                    obj.drawTopStretch(bottomNegationStretched, (Canvas)beginRecording);
                    bottomNegationStretched.finish();
                }
                if (edgeEffectWrapper.isBottomAnimating()) {
                    EdgeEffect orCreateBottomEffect = edgeEffectWrapper.getOrCreateBottomEffect();
                    if (!obj.drawBottomStretch(orCreateBottomEffect, (Canvas)beginRecording)) {
                        if (needsInvalidate3 != 0) {
                            i5 = i4;
                        } else {
                            i5 = 0;
                        }
                    } else {
                    }
                    if (edgeEffectWrapper.isBottomStretched()) {
                        EdgeEffectCompat.INSTANCE.onPullDistanceCompat(edgeEffectWrapper.getOrCreateBottomEffectNegation(), EdgeEffectCompat.INSTANCE.getDistanceCompat(orCreateBottomEffect), f3 -= orCreateLeftEffect);
                    }
                    bottomEffect = needsInvalidate3;
                } else {
                    bottomEffect = needsInvalidate3;
                }
                if (bottomEffect != 0) {
                    obj.overscrollEffect.invalidateOverscroll$foundation_release();
                }
                f = drawHorizontalStretch ? i : px-0680j_4;
                if (drawVerticalStretch) {
                } else {
                    i = px-0680j_4;
                }
                float f2 = i;
                androidx.compose.ui.unit.Density density4 = $this$draw;
                androidx.compose.ui.unit.Density density5 = density4;
                int i13 = 0;
                androidx.compose.ui.unit.Density density6 = density5;
                androidx.compose.ui.unit.LayoutDirection layoutDirection = density5.getLayoutDirection();
                Canvas canvas2 = AndroidCanvas_androidKt.Canvas((Canvas)beginRecording);
                float f4 = px-0680j_4;
                final int i14 = 0;
                final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper2 = edgeEffectWrapper;
                final int i16 = i11;
                final boolean z = drawVerticalStretch;
                final boolean z2 = drawHorizontalStretch;
                final int i17 = bottomEffect;
                final android.graphics.RecordingCanvas recordingCanvas6 = beginRecording;
                DrawContext drawContext7 = density6.getDrawContext();
                int i18 = 0;
                drawContext7.setDensity((Density)density5);
                drawContext7.setLayoutDirection(layoutDirection);
                drawContext7.setCanvas(canvas2);
                androidx.compose.ui.unit.LayoutDirection layoutDirection3 = layoutDirection;
                final Canvas canvas4 = canvas2;
                long layoutDirection$iv = l;
                drawContext7.setSize-uvyYCjk(layoutDirection$iv);
                drawContext7.setGraphicsLayer(0);
                canvas4.save();
                final int i15 = 0;
                androidx.compose.ui.unit.Density density8 = density7;
                final int i19 = 0;
                density8.getDrawContext().getTransform().translate(f, f2);
                androidx.compose.ui.unit.Density density = density8;
                int i20 = 0;
                density4.drawContent();
                long l2 = layoutDirection$iv;
                density8.getDrawContext().getTransform().translate(-f, -f2);
                canvas4.restore();
                DrawContext drawContext10 = density6.getDrawContext();
                int i6 = 0;
                drawContext10.setDensity((DrawScope)density6.getDrawContext().getDensity());
                drawContext10.setLayoutDirection(density6.getDrawContext().getLayoutDirection());
                drawContext10.setCanvas(density6.getDrawContext().getCanvas());
                drawContext10.setSize-uvyYCjk(density6.getDrawContext().getSize-NH-jbRc());
                drawContext10.setGraphicsLayer(density6.getDrawContext().getGraphicsLayer());
                getRenderNode().endRecording();
                nativeCanvas.translate(-f, -f2);
                nativeCanvas.drawRenderNode(getRenderNode());
                nativeCanvas.restoreToCount(nativeCanvas.save());
            } else {
                if (drawVerticalStretch) {
                    obj.getRenderNode().setPosition(distanceCompat, distanceCompat, width2 += i12, nativeCanvas.getHeight());
                } else {
                    if (drawHorizontalStretch) {
                        obj.getRenderNode().setPosition(distanceCompat, distanceCompat, nativeCanvas.getWidth(), height2 += leftStretched);
                    }
                }
            }
        } else {
        }
        $this$draw.drawContent();
    }
}
