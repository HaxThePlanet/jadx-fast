package androidx.compose.ui.graphics.layer;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Outline.Generic;
import androidx.compose.ui.graphics.Outline.Rectangle;
import androidx.compose.ui.graphics.Outline.Rounded;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n", d2 = {"DefaultCameraDistance", "", "drawLayer", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "graphicsLayer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "setOutline", "outline", "Landroidx/compose/ui/graphics/Outline;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class GraphicsLayerKt {

    public static final float DefaultCameraDistance = 8f;
    public static final void drawLayer(DrawScope $this$drawLayer, androidx.compose.ui.graphics.layer.GraphicsLayer graphicsLayer) {
        final int i = 0;
        final int i2 = 0;
        graphicsLayer.draw$ui_graphics_release($this$drawLayer.getDrawContext().getCanvas(), $this$drawLayer.getDrawContext().getGraphicsLayer());
    }

    public static final void setOutline(androidx.compose.ui.graphics.layer.GraphicsLayer $this$setOutline, Outline outline) {
        androidx.compose.ui.graphics.Path roundRectPath$ui_graphics_release;
        long bottomLeftCornerRadius-kKHJgLs;
        float height;
        Object $this$setOutline2;
        long l;
        long l2;
        float x-impl;
        if (outline instanceof Outline.Rectangle) {
            bottomLeftCornerRadius-kKHJgLs = (Outline.Rectangle)outline.getRect().getTop();
            float height2 = (Outline.Rectangle)outline.getRect().getHeight();
            $this$setOutline.setRectOutline-tz77jQw(OffsetKt.Offset((Outline.Rectangle)outline.getRect().getLeft(), bottomLeftCornerRadius-kKHJgLs), bottomLeftCornerRadius-kKHJgLs);
            $this$setOutline2 = $this$setOutline;
        } else {
            if (outline instanceof Outline.Generic) {
                $this$setOutline.setPathOutline((Outline.Generic)outline.getPath());
                $this$setOutline2 = $this$setOutline;
            } else {
                if (outline instanceof Outline.Rounded) {
                    if ((Outline.Rounded)outline.getRoundRectPath$ui_graphics_release() != null) {
                        $this$setOutline.setPathOutline((Outline.Rounded)outline.getRoundRectPath$ui_graphics_release());
                        $this$setOutline2 = $this$setOutline;
                    } else {
                        roundRectPath$ui_graphics_release = (Outline.Rounded)outline.getRoundRect();
                        height = roundRectPath$ui_graphics_release.getHeight();
                        $this$setOutline.setRoundRectOutline-TNW_H78(OffsetKt.Offset(roundRectPath$ui_graphics_release.getLeft(), roundRectPath$ui_graphics_release.getTop()), obj5, SizeKt.Size(roundRectPath$ui_graphics_release.getWidth(), height));
                    }
                } else {
                    $this$setOutline2 = $this$setOutline;
                }
            }
        }
    }
}
