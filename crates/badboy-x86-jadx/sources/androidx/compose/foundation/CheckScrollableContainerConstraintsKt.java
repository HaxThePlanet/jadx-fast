package androidx.compose.foundation;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0008", d2 = {"checkScrollableContainerConstraints", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "checkScrollableContainerConstraints-K40F9xA", "(JLandroidx/compose/foundation/gestures/Orientation;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckScrollableContainerConstraintsKt {
    public static final void checkScrollableContainerConstraints-K40F9xA(long constraints, Orientation orientation) {
        int maxHeight-impl;
        int i;
        i = 1;
        final int i4 = 0;
        final int i5 = Integer.MAX_VALUE;
        if (obj6 == Orientation.Vertical) {
            if (Constraints.getMaxHeight-impl(constraints) != i5) {
            } else {
                i = i4;
            }
            if (i == 0) {
            } else {
            }
            int i3 = 0;
            IllegalStateException illegalStateException2 = new IllegalStateException("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.".toString());
            throw illegalStateException2;
        }
        if (Constraints.getMaxWidth-impl(constraints) != i5) {
        } else {
            i = i4;
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.".toString());
        throw illegalStateException;
    }
}
