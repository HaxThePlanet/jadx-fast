package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Rect.Companion;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRange.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0001\u0018\u0000 22\u00020\u0001:\u00012B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)H\u0000¢\u0006\u0002\u0008*J\u0018\u0010+\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001eø\u0001\u0000¢\u0006\u0004\u0008-\u0010.J&\u0010/\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u00100\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u00101\u001a\u00020)R+\u0010\t\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00068F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR+\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\u00068F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u000f\u001a\u0004\u0008\u0011\u0010\u000b\"\u0004\u0008\u0012\u0010\rR+\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0019\u0010\u001a\u001a\u0004\u0008\u0015\u0010\u0016\"\u0004\u0008\u0017\u0010\u0018R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u00020\u001eX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00063", d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "", "()V", "initialOrientation", "Landroidx/compose/foundation/gestures/Orientation;", "initial", "", "(Landroidx/compose/foundation/gestures/Orientation;F)V", "<set-?>", "maximum", "getMaximum", "()F", "setMaximum", "(F)V", "maximum$delegate", "Landroidx/compose/runtime/MutableFloatState;", "offset", "getOffset", "setOffset", "offset$delegate", "orientation", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "setOrientation", "(Landroidx/compose/foundation/gestures/Orientation;)V", "orientation$delegate", "Landroidx/compose/runtime/MutableState;", "previousCursorRect", "Landroidx/compose/ui/geometry/Rect;", "previousSelection", "Landroidx/compose/ui/text/TextRange;", "getPreviousSelection-d9O1mEE", "()J", "setPreviousSelection-5zc-tL8", "(J)V", "J", "coerceOffset", "", "cursorStart", "cursorEnd", "containerSize", "", "coerceOffset$foundation_release", "getOffsetToFollow", "selection", "getOffsetToFollow-5zc-tL8", "(J)I", "update", "cursorRect", "textFieldSize", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldScrollerPosition {

    public static final int $stable;
    public static final androidx.compose.foundation.text.TextFieldScrollerPosition.Companion Companion;
    private static final Saver<androidx.compose.foundation.text.TextFieldScrollerPosition, Object> Saver;
    private final MutableFloatState maximum$delegate;
    private final MutableFloatState offset$delegate;
    private final MutableState orientation$delegate;
    private Rect previousCursorRect;
    private long previousSelection;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/foundation/text/TextFieldScrollerPosition$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/TextFieldScrollerPosition;", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.foundation.text.TextFieldScrollerPosition, Object> getSaver() {
            return TextFieldScrollerPosition.access$getSaver$cp();
        }
    }
    static {
        TextFieldScrollerPosition.Companion companion = new TextFieldScrollerPosition.Companion(0);
        TextFieldScrollerPosition.Companion = companion;
        TextFieldScrollerPosition.Saver = ListSaverKt.listSaver((Function2)TextFieldScrollerPosition.Companion.Saver.1.INSTANCE, (Function1)TextFieldScrollerPosition.Companion.Saver.2.INSTANCE);
    }

    public TextFieldScrollerPosition() {
        super(Orientation.Vertical, 0, 2, 0);
    }

    public TextFieldScrollerPosition(Orientation initialOrientation, float initial) {
        super();
        this.offset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(initial);
        this.maximum$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(0);
        this.previousCursorRect = Rect.Companion.getZero();
        this.previousSelection = TextRange.Companion.getZero-d9O1mEE();
        this.orientation$delegate = SnapshotStateKt.mutableStateOf(initialOrientation, SnapshotStateKt.structuralEqualityPolicy());
    }

    public TextFieldScrollerPosition(Orientation orientation, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(orientation, obj2);
    }

    public static final Saver access$getSaver$cp() {
        return TextFieldScrollerPosition.Saver;
    }

    private final void setMaximum(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.maximum$delegate.setFloatValue(<set-?>);
    }

    public final void coerceOffset$foundation_release(float cursorStart, float cursorEnd, int containerSize) {
        int cmp;
        int cmp2;
        int i;
        float f;
        final float offset = getOffset();
        f2 += offset;
        if (Float.compare(cursorEnd, i2) > 0) {
            i = cursorEnd - i2;
        } else {
            if (Float.compare(cursorStart, offset) < 0 && Float.compare(i3, f) > 0) {
                if (Float.compare(i3, f) > 0) {
                    i = cursorEnd - i2;
                } else {
                    if (Float.compare(cursorStart, offset) < 0 && Float.compare(i4, f) <= 0) {
                        i = Float.compare(i4, f) <= 0 ? cursorStart - offset : 0;
                    } else {
                    }
                }
            } else {
            }
        }
        setOffset(offset2 += i);
    }

    public final float getMaximum() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.maximum$delegate.getFloatValue();
    }

    public final float getOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.offset$delegate.getFloatValue();
    }

    public final int getOffsetToFollow-5zc-tL8(long selection) {
        int start-impl;
        int start-impl2;
        if (TextRange.getStart-impl(selection) != TextRange.getStart-impl(this.previousSelection)) {
            start-impl = TextRange.getStart-impl(selection);
        } else {
            if (TextRange.getEnd-impl(selection) != TextRange.getEnd-impl(this.previousSelection)) {
                start-impl = TextRange.getEnd-impl(selection);
            } else {
                start-impl = TextRange.getMin-impl(selection);
            }
        }
        return start-impl;
    }

    public final Orientation getOrientation() {
        final int i = 0;
        final int i2 = 0;
        return (Orientation)(State)this.orientation$delegate.getValue();
    }

    public final long getPreviousSelection-d9O1mEE() {
        return this.previousSelection;
    }

    public final void setOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.offset$delegate.setFloatValue(<set-?>);
    }

    public final void setOrientation(Orientation <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.orientation$delegate.setValue(<set-?>);
    }

    public final void setPreviousSelection-5zc-tL8(long <set-?>) {
        this.previousSelection = <set-?>;
    }

    public final void update(Orientation orientation, Rect cursorRect, int containerSize, int textFieldSize) {
        int left;
        int i;
        int bottom;
        float top;
        float f = (float)i2;
        setMaximum(f);
        i = 1;
        bottom = 0;
        left = Float.compare(left2, left3) == 0 ? i : bottom;
        if (left != 0) {
            left = Float.compare(top2, top) == 0 ? i : bottom;
            if (left == 0) {
                if (orientation == Orientation.Vertical) {
                } else {
                    i = bottom;
                }
                if (i != 0) {
                    left = cursorRect.getTop();
                } else {
                    left = cursorRect.getLeft();
                }
                if (i != 0) {
                    bottom = cursorRect.getBottom();
                } else {
                    bottom = cursorRect.getRight();
                }
                coerceOffset$foundation_release(left, bottom, containerSize);
                this.previousCursorRect = cursorRect;
            }
        } else {
        }
        setOffset(RangesKt.coerceIn(getOffset(), 0, f));
    }
}
