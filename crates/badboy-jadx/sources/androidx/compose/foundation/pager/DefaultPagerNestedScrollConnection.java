package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import androidx.compose.ui.unit.Velocity;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000cH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\"\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\u001c\u0010\u001a\u001a\u00020\u000c*\u00020\u000c2\u0006\u0010\u0004\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u001e*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006!", d2 = {"Landroidx/compose/foundation/pager/DefaultPagerNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "state", "Landroidx/compose/foundation/pager/PagerState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;)V", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "getState", "()Landroidx/compose/foundation/pager/PagerState;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "consumeOnOrientation", "consumeOnOrientation-QWom1Mo", "(JLandroidx/compose/foundation/gestures/Orientation;)J", "mainAxis", "", "mainAxis-k-4lQ0M", "(J)F", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultPagerNestedScrollConnection implements NestedScrollConnection {

    private final Orientation orientation;
    private final androidx.compose.foundation.pager.PagerState state;
    public DefaultPagerNestedScrollConnection(androidx.compose.foundation.pager.PagerState state, Orientation orientation) {
        super();
        this.state = state;
        this.orientation = orientation;
    }

    private final float mainAxis-k-4lQ0M(long $this$mainAxis_u2dk_u2d4lQ0M) {
        float x-impl;
        if (this.orientation == Orientation.Horizontal) {
            x-impl = Offset.getX-impl($this$mainAxis_u2dk_u2d4lQ0M);
        } else {
            x-impl = Offset.getY-impl($this$mainAxis_u2dk_u2d4lQ0M);
        }
        return x-impl;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final long consumeOnOrientation-QWom1Mo(long $this$consumeOnOrientation_u2dQWom1Mo, Orientation orientation) {
        long $this$consumeOnOrientation_u2dQWom1Mo2;
        long l;
        long l2;
        int i2;
        int i3;
        int i;
        int i4;
        long obj8;
        if (obj10 == Orientation.Vertical) {
            l = $this$consumeOnOrientation_u2dQWom1Mo;
            obj8 = Velocity.copy-OhffZ5M$default(l, obj2, 0, 0, 2);
            $this$consumeOnOrientation_u2dQWom1Mo2 = l;
        } else {
            obj8 = Velocity.copy-OhffZ5M$default($this$consumeOnOrientation_u2dQWom1Mo, obj1, 0, 0, 1);
        }
        return obj8;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final androidx.compose.foundation.pager.PagerState getState() {
        return this.state;
    }

    public Object onPostFling-RZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        return Velocity.box-impl(consumeOnOrientation-QWom1Mo($completion, obj6));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        boolean equals-impl0;
        int i;
        if (NestedScrollSource.equals-impl0(obj7, NestedScrollSource.Companion.getSideEffect-WNlRxjI())) {
            equals-impl0 = Float.compare(mainAxis-k-4lQ0M, i) == 0 ? 1 : 0;
            if (equals-impl0 == 0) {
            } else {
            }
            CancellationException cancellationException = new CancellationException();
            throw cancellationException;
        }
        return Offset.Companion.getZero-F1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPreScroll-OzD1aCk(long available, int source) {
        boolean cmp;
        long currentPageOffset;
        int i2;
        long l;
        int minBound;
        int maxBound;
        float x-impl;
        float coerceIn;
        int i;
        int x-impl2;
        int y-impl;
        Orientation vertical;
        if (NestedScrollSource.equals-impl0(obj14, NestedScrollSource.Companion.getUserInput-WNlRxjI()) && Double.compare(d, l) > 0) {
            if (Double.compare(d, l) > 0) {
                currentPageOffsetFraction2 *= f2;
                i4 += i3;
                int i6 = 0;
                int i7 = 0;
                maxBound = Float.compare(currentPageOffsetFraction4, i8) > 0 ? i3 : l;
                if (this.orientation == Orientation.Horizontal) {
                    x-impl = Offset.getX-impl(available);
                } else {
                    x-impl = Offset.getY-impl(available);
                }
                i = -dispatchRawDelta;
                if (this.orientation == Orientation.Horizontal) {
                    x-impl2 = i;
                } else {
                    x-impl2 = Offset.getX-impl(available);
                }
                if (this.orientation == Orientation.Vertical) {
                    y-impl = i;
                } else {
                    y-impl = Offset.getY-impl(available);
                }
                currentPageOffset = Offset.copy-dBAh8RU(available, source, x-impl2);
            } else {
                currentPageOffset = Offset.Companion.getZero-F1C5BW0();
            }
        } else {
        }
        return currentPageOffset;
    }
}
