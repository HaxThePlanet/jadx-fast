package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0002*\u00020\u0002\u001a\u000f\u0010\u0006\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\u0008\u001a\u000f\u0010\t\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\u0008\u001a\u000f\u0010\n\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\u0008\u001a\u000f\u0010\u000b\u001a\u00020\u0007*\u00020\u0002¢\u0006\u0002\u0010\u0008¨\u0006\u000c", d2 = {"boundsInParent", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "boundsInRoot", "boundsInWindow", "findRootCoordinates", "positionInParent", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInRoot", "positionInWindow", "positionOnScreen", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LayoutCoordinatesKt {
    public static final Rect boundsInParent(androidx.compose.ui.layout.LayoutCoordinates $this$boundsInParent) {
        Rect parentLayoutCoordinates;
        int i2;
        int i3;
        int i;
        parentLayoutCoordinates = $this$boundsInParent.getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            if (LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, $this$boundsInParent, false, 2, 0) == null) {
                i = 0;
                parentLayoutCoordinates = new Rect(i, i, (float)width-impl, (float)height-impl);
            }
        } else {
        }
        return parentLayoutCoordinates;
    }

    public static final Rect boundsInRoot(androidx.compose.ui.layout.LayoutCoordinates $this$boundsInRoot) {
        return LayoutCoordinates.localBoundingBoxOf$default(LayoutCoordinatesKt.findRootCoordinates($this$boundsInRoot), $this$boundsInRoot, false, 2, 0);
    }

    public static final Rect boundsInWindow(androidx.compose.ui.layout.LayoutCoordinates $this$boundsInWindow) {
        int cmp;
        int i;
        float $this$fastCoerceAtLeast$iv$iv2;
        float $this$fastCoerceAtMost$iv$iv;
        float $this$fastCoerceAtLeast$iv$iv;
        float $this$fastCoerceAtMost$iv$iv2;
        float f3;
        androidx.compose.ui.layout.LayoutCoordinates root;
        Rect rect;
        float f;
        float f2;
        androidx.compose.ui.layout.LayoutCoordinates rootCoordinates = LayoutCoordinatesKt.findRootCoordinates($this$boundsInWindow);
        float f4 = (float)width-impl;
        float f5 = (float)height-impl;
        Rect boundsInRoot = LayoutCoordinatesKt.boundsInRoot($this$boundsInWindow);
        int i2 = 0;
        int i7 = 0;
        int i12 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, i2) < 0) {
            $this$fastCoerceAtLeast$iv$iv2 = i2;
        }
        int i13 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv2, f4) > 0) {
            $this$fastCoerceAtLeast$iv$iv2 = f4;
        }
        int i3 = 0;
        int i8 = 0;
        int i14 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i3) < 0) {
            $this$fastCoerceAtMost$iv$iv = i3;
        }
        int i15 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, f5) > 0) {
            $this$fastCoerceAtMost$iv$iv = f5;
        }
        int i4 = 0;
        int i9 = 0;
        int i16 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i4) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i4;
        }
        int i17 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, f4) > 0) {
            $this$fastCoerceAtLeast$iv$iv = f4;
        }
        int i5 = 0;
        int i10 = 0;
        int i18 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv2, i5) < 0) {
            $this$fastCoerceAtMost$iv$iv2 = i5;
        }
        int i19 = 0;
        int cmp10 = Float.compare($this$fastCoerceAtMost$iv$iv2, f5);
        if (cmp10 > 0) {
            $this$fastCoerceAtMost$iv$iv2 = f5;
        }
        int i11 = 0;
        cmp = Float.compare($this$fastCoerceAtLeast$iv$iv2, $this$fastCoerceAtLeast$iv$iv) == 0 ? i : i11;
        if (cmp == 0) {
            if (Float.compare($this$fastCoerceAtMost$iv$iv, $this$fastCoerceAtMost$iv$iv2) == 0) {
            } else {
                i = i11;
            }
            if (i != 0) {
                root = rootCoordinates;
                f = f4;
                f3 = f5;
                rect = boundsInRoot;
                f2 = $this$fastCoerceAtLeast$iv$iv2;
                return Rect.Companion.getZero();
            }
            long localToWindow-MK-Hz9U2 = rootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset($this$fastCoerceAtLeast$iv$iv2, $this$fastCoerceAtMost$iv$iv));
            long localToWindow-MK-Hz9U3 = rootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset($this$fastCoerceAtLeast$iv$iv, $this$fastCoerceAtMost$iv$iv));
            long localToWindow-MK-Hz9U4 = rootCoordinates.localToWindow-MK-Hz9U(OffsetKt.Offset($this$fastCoerceAtLeast$iv$iv, $this$fastCoerceAtMost$iv$iv2));
            float f19 = f5;
            androidx.compose.ui.layout.LayoutCoordinates layoutCoordinates = rootCoordinates;
            float x-impl = Offset.getX-impl(localToWindow-MK-Hz9U2);
            final long l5 = localToWindow-MK-Hz9U;
            float x-impl2 = Offset.getX-impl(localToWindow-MK-Hz9U3);
            float x-impl3 = Offset.getX-impl(l5);
            Rect rect2 = boundsInRoot;
            float x-impl4 = Offset.getX-impl(localToWindow-MK-Hz9U4);
            int i20 = 0;
            int i21 = i6;
            float f20 = x-impl;
            float y-impl = Offset.getY-impl(localToWindow-MK-Hz9U2);
            final float f21 = x-impl2;
            float y-impl2 = Offset.getY-impl(localToWindow-MK-Hz9U3);
            final float f22 = x-impl3;
            float y-impl3 = Offset.getY-impl(l5);
            final float f23 = x-impl4;
            float y-impl4 = Offset.getY-impl(localToWindow-MK-Hz9U4);
            int i22 = 0;
            float f25 = f12;
            int i23 = 0;
            float f26 = $this$fastCoerceAtLeast$iv$iv2;
            float f24 = y-impl;
            Rect topLeftY = new Rect(Math.min(x-impl, Math.min(x-impl2, Math.min(x-impl3, x-impl4))), Math.min(y-impl, Math.min(y-impl2, Math.min(y-impl3, y-impl4))), Math.max(x-impl, Math.max(x-impl2, Math.max(x-impl3, x-impl4))), Math.max(y-impl, Math.max(y-impl2, Math.max(y-impl3, y-impl4))));
            return topLeftY;
        }
        root = rootCoordinates;
        f = f4;
        f3 = f5;
        rect = boundsInRoot;
        f2 = $this$fastCoerceAtLeast$iv$iv2;
    }

    public static final androidx.compose.ui.layout.LayoutCoordinates findRootCoordinates(androidx.compose.ui.layout.LayoutCoordinates $this$findRootCoordinates) {
        Object root;
        androidx.compose.ui.layout.LayoutCoordinates parent;
        int rootCoordinator;
        NodeCoordinator parentCoordinator;
        parent = $this$findRootCoordinates.getParentLayoutCoordinates();
        while (parent != null) {
            parent = parent.getParentLayoutCoordinates();
        }
        if (root instanceof NodeCoordinator) {
            rootCoordinator = root;
        } else {
            rootCoordinator = 0;
        }
        if (rootCoordinator == 0) {
            return root;
        }
        parentCoordinator = rootCoordinator.getWrappedBy$ui_release();
        while (parentCoordinator != null) {
            rootCoordinator = parentCoordinator;
            parentCoordinator = parentCoordinator.getWrappedBy$ui_release();
        }
        return (LayoutCoordinates)rootCoordinator;
    }

    public static final long positionInParent(androidx.compose.ui.layout.LayoutCoordinates $this$positionInParent) {
        long localPositionOf-R5De75A;
        long zero-F1C5BW0;
        androidx.compose.ui.layout.LayoutCoordinates parentLayoutCoordinates = $this$positionInParent.getParentLayoutCoordinates();
        if (parentLayoutCoordinates != null) {
            localPositionOf-R5De75A = parentLayoutCoordinates.localPositionOf-R5De75A($this$positionInParent, Offset.Companion.getZero-F1C5BW0());
        } else {
            localPositionOf-R5De75A = Offset.Companion.getZero-F1C5BW0();
        }
        return localPositionOf-R5De75A;
    }

    public static final long positionInRoot(androidx.compose.ui.layout.LayoutCoordinates $this$positionInRoot) {
        return $this$positionInRoot.localToRoot-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
    }

    public static final long positionInWindow(androidx.compose.ui.layout.LayoutCoordinates $this$positionInWindow) {
        return $this$positionInWindow.localToWindow-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
    }

    public static final long positionOnScreen(androidx.compose.ui.layout.LayoutCoordinates $this$positionOnScreen) {
        return $this$positionOnScreen.localToScreen-MK-Hz9U(Offset.Companion.getZero-F1C5BW0());
    }
}
