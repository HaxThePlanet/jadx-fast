package androidx.compose.foundation;

import android.graphics.Canvas;
import android.widget.EdgeEffect;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidCanvas_androidKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\n¢\u0006\u0002\u0008\r¢\u0006\u0002\u0010\u000eJ6\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u000c\u0010\u001c\u001a\u00020\u000c*\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010 \u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J \u0010!\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010\"\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J \u0010#\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010$\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002J \u0010%\u001a\u00020\u0010*\u00020\u001f2\u0006\u0010&\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0018j\u0002`\u0019H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006'", d2 = {"Landroidx/compose/foundation/DrawGlowOverscrollModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "overscrollEffect", "Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;", "edgeEffectWrapper", "Landroidx/compose/foundation/EdgeEffectWrapper;", "overscrollConfig", "Landroidx/compose/foundation/OverscrollConfiguration;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/AndroidEdgeEffectOverscrollEffect;Landroidx/compose/foundation/EdgeEffectWrapper;Landroidx/compose/foundation/OverscrollConfiguration;Lkotlin/jvm/functions/Function1;)V", "drawWithRotationAndOffset", "", "rotationDegrees", "", "offset", "Landroidx/compose/ui/geometry/Offset;", "edgeEffect", "Landroid/widget/EdgeEffect;", "canvas", "Landroid/graphics/Canvas;", "Landroidx/compose/ui/graphics/NativeCanvas;", "drawWithRotationAndOffset-ubNVwUQ", "(FJLandroid/widget/EdgeEffect;Landroid/graphics/Canvas;)Z", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "drawBottomGlow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "bottom", "drawLeftGlow", "left", "drawRightGlow", "right", "drawTopGlow", "top", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DrawGlowOverscrollModifier extends InspectorValueInfo implements DrawModifier {

    private final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper;
    private final androidx.compose.foundation.OverscrollConfiguration overscrollConfig;
    private final androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect overscrollEffect;
    public DrawGlowOverscrollModifier(androidx.compose.foundation.AndroidEdgeEffectOverscrollEffect overscrollEffect, androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper, androidx.compose.foundation.OverscrollConfiguration overscrollConfig, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        this.overscrollEffect = overscrollEffect;
        this.edgeEffectWrapper = edgeEffectWrapper;
        this.overscrollConfig = overscrollConfig;
    }

    private final boolean drawBottomGlow(DrawScope $this$drawBottomGlow, EdgeEffect bottom, Canvas canvas) {
        return this.drawWithRotationAndOffset-ubNVwUQ(1127481344, OffsetKt.Offset(-width-impl, i2 += px-0680j_4), obj6, bottom);
    }

    private final boolean drawLeftGlow(DrawScope $this$drawLeftGlow, EdgeEffect left, Canvas canvas) {
        return this.drawWithRotationAndOffset-ubNVwUQ(1132920832, OffsetKt.Offset(-height-impl, $this$drawLeftGlow.toPx-0680j_4(this.overscrollConfig.getDrawPadding().calculateLeftPadding-u2uoSUM($this$drawLeftGlow.getLayoutDirection()))), obj5, left);
    }

    private final boolean drawRightGlow(DrawScope $this$drawRightGlow, EdgeEffect right, Canvas canvas) {
        return this.drawWithRotationAndOffset-ubNVwUQ(1119092736, OffsetKt.Offset(0, i += px-0680j_4), obj7, right);
    }

    private final boolean drawTopGlow(DrawScope $this$drawTopGlow, EdgeEffect top, Canvas canvas) {
        return this.drawWithRotationAndOffset-ubNVwUQ(0, OffsetKt.Offset(0, $this$drawTopGlow.toPx-0680j_4(this.overscrollConfig.getDrawPadding().calculateTopPadding-D9Ej5fM())), obj5, top);
    }

    private final boolean drawWithRotationAndOffset-ubNVwUQ(float rotationDegrees, long offset, EdgeEffect edgeEffect, Canvas canvas) {
        obj8.rotate(rotationDegrees);
        obj8.translate(Offset.getX-impl(offset), Offset.getY-impl(offset));
        obj8.restoreToCount(obj8.save());
        return canvas.draw(obj8);
    }

    @Override // androidx.compose.ui.platform.InspectorValueInfo
    public void draw(ContentDrawScope $this$draw) {
        int needsInvalidate;
        boolean orCreateLeftEffect;
        boolean orCreateTopEffect;
        boolean orCreateRightEffect;
        boolean orCreateBottomEffect;
        boolean drawLeftGlow;
        int i;
        int drawBottomGlow;
        long size-NH-jbRc2 = $this$draw.getSize-NH-jbRc();
        this.overscrollEffect.updateSize-uvyYCjk$foundation_release(size-NH-jbRc2);
        if (Size.isEmpty-impl($this$draw.getSize-NH-jbRc())) {
            $this$draw.drawContent();
        }
        $this$draw.drawContent();
        this.overscrollEffect.getRedrawSignal$foundation_release().getValue();
        Canvas nativeCanvas = AndroidCanvas_androidKt.getNativeCanvas($this$draw.getDrawContext().getCanvas());
        needsInvalidate = 0;
        final androidx.compose.foundation.EdgeEffectWrapper edgeEffectWrapper = this.edgeEffectWrapper;
        final int i2 = 0;
        if (edgeEffectWrapper.isLeftAnimating()) {
            needsInvalidate = drawLeftGlow;
        }
        i = 0;
        final int i3 = 1;
        if (edgeEffectWrapper.isTopAnimating()) {
            if (!drawTopGlow((DrawScope)$this$draw, edgeEffectWrapper.getOrCreateTopEffect(), nativeCanvas)) {
                if (needsInvalidate != 0) {
                    drawBottomGlow = i3;
                } else {
                    drawBottomGlow = i;
                }
            } else {
            }
            needsInvalidate = drawBottomGlow;
        }
        if (edgeEffectWrapper.isRightAnimating()) {
            if (!drawRightGlow((DrawScope)$this$draw, edgeEffectWrapper.getOrCreateRightEffect(), nativeCanvas)) {
                if (needsInvalidate != 0) {
                    drawBottomGlow = i3;
                } else {
                    drawBottomGlow = i;
                }
            } else {
            }
            needsInvalidate = drawBottomGlow;
        }
        if (edgeEffectWrapper.isBottomAnimating()) {
            if (!drawBottomGlow((DrawScope)$this$draw, edgeEffectWrapper.getOrCreateBottomEffect(), nativeCanvas)) {
                if (needsInvalidate != 0) {
                    i = i3;
                }
            } else {
            }
            needsInvalidate = i;
        }
        if (needsInvalidate != 0) {
            this.overscrollEffect.invalidateOverscroll$foundation_release();
        }
    }
}
