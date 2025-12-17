package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.unit.IntSize;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\u000c\u0010\u0007\u001a\u00020\u0008*\u00020\u0002H\u0007\u001a\u000c\u0010\t\u001a\u00020\u0008*\u00020\u0002H\u0007\u001a\u000c\u0010\n\u001a\u00020\u0008*\u00020\u0002H\u0007\u001a\u001e\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a$\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a\u000f\u0010\u0014\u001a\u00020\u0015*\u00020\u0002¢\u0006\u0002\u0010\u0016\u001a\u000c\u0010\u0017\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u000f\u0010\u0018\u001a\u00020\u0015*\u00020\u0002¢\u0006\u0002\u0010\u0016\u001a\u001b\u0010\u0019\u001a\u00020\u0015*\u00020\u00022\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u001b\u001a\n\u0010\u001c\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u001d\u001a\u00020\u0001*\u00020\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"anyChangeConsumed", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changedToDown", "changedToDownIgnoreConsumed", "changedToUp", "changedToUpIgnoreConsumed", "consumeAllChanges", "", "consumeDownChange", "consumePositionChange", "isOutOfBounds", "size", "Landroidx/compose/ui/unit/IntSize;", "isOutOfBounds-O0kMr_c", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)Z", "extendedTouchPadding", "Landroidx/compose/ui/geometry/Size;", "isOutOfBounds-jwHxaWs", "(Landroidx/compose/ui/input/pointer/PointerInputChange;JJ)Z", "positionChange", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)J", "positionChangeConsumed", "positionChangeIgnoreConsumed", "positionChangeInternal", "ignoreConsumed", "(Landroidx/compose/ui/input/pointer/PointerInputChange;Z)J", "positionChanged", "positionChangedIgnoreConsumed", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PointerEventKt {
    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(...))
    public static final boolean anyChangeConsumed(androidx.compose.ui.input.pointer.PointerInputChange $this$anyChangeConsumed) {
        return $this$anyChangeConsumed.isConsumed();
    }

    public static final boolean changedToDown(androidx.compose.ui.input.pointer.PointerInputChange $this$changedToDown) {
        int i;
        boolean previousPressed;
        if (!$this$changedToDown.isConsumed() && !$this$changedToDown.getPreviousPressed() && $this$changedToDown.getPressed()) {
            if (!$this$changedToDown.getPreviousPressed()) {
                i = $this$changedToDown.getPressed() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean changedToDownIgnoreConsumed(androidx.compose.ui.input.pointer.PointerInputChange $this$changedToDownIgnoreConsumed) {
        boolean previousPressed;
        int i;
        if (!$this$changedToDownIgnoreConsumed.getPreviousPressed() && $this$changedToDownIgnoreConsumed.getPressed()) {
            i = $this$changedToDownIgnoreConsumed.getPressed() ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean changedToUp(androidx.compose.ui.input.pointer.PointerInputChange $this$changedToUp) {
        int i;
        boolean previousPressed;
        if (!$this$changedToUp.isConsumed() && $this$changedToUp.getPreviousPressed() && !$this$changedToUp.getPressed()) {
            if ($this$changedToUp.getPreviousPressed()) {
                i = !$this$changedToUp.getPressed() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public static final boolean changedToUpIgnoreConsumed(androidx.compose.ui.input.pointer.PointerInputChange $this$changedToUpIgnoreConsumed) {
        boolean previousPressed;
        int i;
        if ($this$changedToUpIgnoreConsumed.getPreviousPressed() && !$this$changedToUpIgnoreConsumed.getPressed()) {
            i = !$this$changedToUpIgnoreConsumed.getPressed() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Deprecated(message = "Use consume() instead", replaceWith = @ReplaceWith(...))
    public static final void consumeAllChanges(androidx.compose.ui.input.pointer.PointerInputChange $this$consumeAllChanges) {
        $this$consumeAllChanges.consume();
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(...))
    public static final void consumeDownChange(androidx.compose.ui.input.pointer.PointerInputChange $this$consumeDownChange) {
        if ($this$consumeDownChange.getPressed() != $this$consumeDownChange.getPreviousPressed()) {
            $this$consumeDownChange.consume();
        }
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use consume() instead.", replaceWith = @ReplaceWith(...))
    public static final void consumePositionChange(androidx.compose.ui.input.pointer.PointerInputChange $this$consumePositionChange) {
        if (!Offset.equals-impl0(PointerEventKt.positionChange($this$consumePositionChange), obj1)) {
            $this$consumePositionChange.consume();
        }
    }

    @Deprecated(message = "Use isOutOfBounds() that supports minimum touch target", replaceWith = @ReplaceWith(...))
    public static final boolean isOutOfBounds-O0kMr_c(androidx.compose.ui.input.pointer.PointerInputChange $this$isOutOfBounds_u2dO0kMr_c, long size) {
        int i;
        int cmp2;
        int cmp;
        final long position-F1C5BW0 = $this$isOutOfBounds_u2dO0kMr_c.getPosition-F1C5BW0();
        final float x-impl = Offset.getX-impl(position-F1C5BW0);
        final float y-impl = Offset.getY-impl(position-F1C5BW0);
        cmp2 = 0;
        if (Float.compare(x-impl, cmp2) >= 0 && Float.compare(x-impl, f2) <= 0 && Float.compare(y-impl, cmp2) >= 0) {
            if (Float.compare(x-impl, f2) <= 0) {
                if (Float.compare(y-impl, cmp2) >= 0) {
                    if (Float.compare(y-impl, f) > 0) {
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

    public static final boolean isOutOfBounds-jwHxaWs(androidx.compose.ui.input.pointer.PointerInputChange $this$isOutOfBounds_u2djwHxaWs, long size, long extendedTouchPadding) {
        int i;
        int cmp;
        int touch-T8wyACA = PointerType.Companion.getTouch-T8wyACA();
        if (!PointerType.equals-impl0($this$isOutOfBounds_u2djwHxaWs.getType-T8wyACA(), touch-T8wyACA)) {
            return PointerEventKt.isOutOfBounds-O0kMr_c($this$isOutOfBounds_u2djwHxaWs, size);
        }
        long position-F1C5BW0 = $this$isOutOfBounds_u2djwHxaWs.getPosition-F1C5BW0();
        final float x-impl = Offset.getX-impl(position-F1C5BW0);
        final float y-impl = Offset.getY-impl(position-F1C5BW0);
        if (Float.compare(x-impl, i2) >= 0 && Float.compare(x-impl, i3) <= 0 && Float.compare(y-impl, i4) >= 0) {
            if (Float.compare(x-impl, i3) <= 0) {
                if (Float.compare(y-impl, i4) >= 0) {
                    if (Float.compare(y-impl, i5) > 0) {
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

    public static final long positionChange(androidx.compose.ui.input.pointer.PointerInputChange $this$positionChange) {
        return PointerEventKt.positionChangeInternal($this$positionChange, false);
    }

    @Deprecated(message = "Partial consumption has been deprecated. Use isConsumed instead", replaceWith = @ReplaceWith(...))
    public static final boolean positionChangeConsumed(androidx.compose.ui.input.pointer.PointerInputChange $this$positionChangeConsumed) {
        return $this$positionChangeConsumed.isConsumed();
    }

    public static final long positionChangeIgnoreConsumed(androidx.compose.ui.input.pointer.PointerInputChange $this$positionChangeIgnoreConsumed) {
        return PointerEventKt.positionChangeInternal($this$positionChangeIgnoreConsumed, true);
    }

    private static final long positionChangeInternal(androidx.compose.ui.input.pointer.PointerInputChange $this$positionChangeInternal, boolean ignoreConsumed) {
        boolean consumed;
        long zero-F1C5BW0;
        if (!ignoreConsumed && $this$positionChangeInternal.isConsumed()) {
            if ($this$positionChangeInternal.isConsumed()) {
                zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
            } else {
                zero-F1C5BW0 = minus-MK-Hz9U;
            }
        } else {
        }
        return zero-F1C5BW0;
    }

    static long positionChangeInternal$default(androidx.compose.ui.input.pointer.PointerInputChange pointerInputChange, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return PointerEventKt.positionChangeInternal(pointerInputChange, obj1);
    }

    public static final boolean positionChanged(androidx.compose.ui.input.pointer.PointerInputChange $this$positionChanged) {
        return equals-impl0 ^= 1;
    }

    public static final boolean positionChangedIgnoreConsumed(androidx.compose.ui.input.pointer.PointerInputChange $this$positionChangedIgnoreConsumed) {
        int i = 1;
        return i ^= equals-impl0;
    }
}
