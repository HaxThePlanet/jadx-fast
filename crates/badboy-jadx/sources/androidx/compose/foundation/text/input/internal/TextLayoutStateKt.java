package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a\u001e\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\t\u0010\n\u001a\u001e\u0010\u000b\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\n\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f", d2 = {"coerceIn", "Landroidx/compose/ui/geometry/Offset;", "rect", "Landroidx/compose/ui/geometry/Rect;", "coerceIn-3MmeM6k", "(JLandroidx/compose/ui/geometry/Rect;)J", "fromDecorationToTextLayout", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "offset", "fromDecorationToTextLayout-Uv8p0NA", "(Landroidx/compose/foundation/text/input/internal/TextLayoutState;J)J", "fromTextLayoutToCore", "fromTextLayoutToCore-Uv8p0NA", "fromWindowToDecoration", "fromWindowToDecoration-Uv8p0NA", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextLayoutStateKt {
    public static final long coerceIn-3MmeM6k(long $this$coerceIn_u2d3MmeM6k, Rect rect) {
        float x-impl;
        float right;
        float y-impl;
        float bottom;
        if (Float.compare(x-impl2, right) < 0) {
            x-impl = obj6.getLeft();
        } else {
            if (Float.compare(x-impl3, right) > 0) {
                x-impl = obj6.getRight();
            } else {
                x-impl = Offset.getX-impl($this$coerceIn_u2d3MmeM6k);
            }
        }
        if (Float.compare(y-impl2, bottom) < 0) {
            y-impl = obj6.getTop();
        } else {
            if (Float.compare(y-impl3, bottom) > 0) {
                y-impl = obj6.getBottom();
            } else {
                y-impl = Offset.getY-impl($this$coerceIn_u2d3MmeM6k);
            }
        }
        return OffsetKt.Offset(x-impl, y-impl);
    }

    public static final long fromDecorationToTextLayout-Uv8p0NA(androidx.compose.foundation.text.input.internal.TextLayoutState $this$fromDecorationToTextLayout_u2dUv8p0NA, long offset) {
        long unbox-impl;
        int i;
        int box-impl;
        int i2;
        long localPositionOf-R5De75A;
        boolean attached;
        LayoutCoordinates textLayoutNodeCoordinates = $this$fromDecorationToTextLayout_u2dUv8p0NA.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            i = 0;
            LayoutCoordinates decoratorNodeCoordinates = $this$fromDecorationToTextLayout_u2dUv8p0NA.getDecoratorNodeCoordinates();
            if (decoratorNodeCoordinates != null) {
                i2 = 0;
                if (textLayoutNodeCoordinates.isAttached() && decoratorNodeCoordinates.isAttached()) {
                    if (decoratorNodeCoordinates.isAttached()) {
                        localPositionOf-R5De75A = textLayoutNodeCoordinates.localPositionOf-R5De75A(decoratorNodeCoordinates, offset);
                    } else {
                        localPositionOf-R5De75A = offset;
                    }
                } else {
                }
                box-impl = Offset.box-impl(localPositionOf-R5De75A);
            } else {
                box-impl = 0;
            }
            if (box-impl != 0) {
                unbox-impl = box-impl.unbox-impl();
            } else {
                unbox-impl = offset;
            }
        } else {
        }
        return unbox-impl;
    }

    public static final long fromTextLayoutToCore-Uv8p0NA(androidx.compose.foundation.text.input.internal.TextLayoutState $this$fromTextLayoutToCore_u2dUv8p0NA, long offset) {
        LayoutCoordinates textLayoutNodeCoordinates;
        long unbox-impl;
        boolean it2;
        int $i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1;
        LayoutCoordinates coreNodeCoordinates;
        boolean it;
        int i;
        textLayoutNodeCoordinates = $this$fromTextLayoutToCore_u2dUv8p0NA.getTextLayoutNodeCoordinates();
        if (textLayoutNodeCoordinates != null) {
            int i2 = 0;
            $i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1 = 0;
            if (textLayoutNodeCoordinates.isAttached()) {
            } else {
                textLayoutNodeCoordinates = $i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1;
            }
            if (textLayoutNodeCoordinates != 0) {
                it2 = 0;
                coreNodeCoordinates = $this$fromTextLayoutToCore_u2dUv8p0NA.getCoreNodeCoordinates();
                if (coreNodeCoordinates != null) {
                    i = 0;
                    if (coreNodeCoordinates.isAttached()) {
                    } else {
                        coreNodeCoordinates = $i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1;
                    }
                    if (coreNodeCoordinates != null) {
                        $i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1 = Offset.box-impl(coreNodeCoordinates.localPositionOf-R5De75A(textLayoutNodeCoordinates, offset));
                    } else {
                    }
                } else {
                }
                if ($i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1 != 0) {
                    unbox-impl = $i$a$TakeIfTextLayoutStateKt$fromTextLayoutToCore$1.unbox-impl();
                } else {
                    unbox-impl = offset;
                }
            } else {
            }
        } else {
        }
        return unbox-impl;
    }

    public static final long fromWindowToDecoration-Uv8p0NA(androidx.compose.foundation.text.input.internal.TextLayoutState $this$fromWindowToDecoration_u2dUv8p0NA, long offset) {
        int i;
        long windowToLocal-MK-Hz9U;
        final LayoutCoordinates decoratorNodeCoordinates = $this$fromWindowToDecoration_u2dUv8p0NA.getDecoratorNodeCoordinates();
        if (decoratorNodeCoordinates != null) {
            i = 0;
            if (decoratorNodeCoordinates.isAttached()) {
                windowToLocal-MK-Hz9U = decoratorNodeCoordinates.windowToLocal-MK-Hz9U(offset);
            } else {
                windowToLocal-MK-Hz9U = offset;
            }
        } else {
            windowToLocal-MK-Hz9U = offset;
        }
        return windowToLocal-MK-Hz9U;
    }
}
