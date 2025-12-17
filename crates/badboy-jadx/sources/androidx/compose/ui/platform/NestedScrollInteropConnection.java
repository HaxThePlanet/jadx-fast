package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\t\u001a\u00020\nH\u0002J#\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000cH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u000e\u001a\u00020\u000cH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J\"\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/ui/platform/NestedScrollInteropConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "consumedScrollCache", "", "nestedScrollChildHelper", "Landroidx/core/view/NestedScrollingChildHelper;", "interruptOngoingScrolls", "", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NestedScrollInteropConnection implements NestedScrollConnection {

    public static final int $stable = 8;
    private final int[] consumedScrollCache;
    private final NestedScrollingChildHelper nestedScrollChildHelper;
    private final View view;
    static {
        final int i = 8;
    }

    public NestedScrollInteropConnection(View view) {
        super();
        this.view = view;
        NestedScrollingChildHelper nestedScrollingChildHelper = new NestedScrollingChildHelper(this.view);
        final int i2 = 0;
        final int i3 = 1;
        nestedScrollingChildHelper.setNestedScrollingEnabled(i3);
        this.nestedScrollChildHelper = nestedScrollingChildHelper;
        this.consumedScrollCache = new int[2];
        ViewCompat.setNestedScrollingEnabled(this.view, i3);
    }

    private final void interruptOngoingScrolls() {
        boolean nestedScrollingParent;
        boolean nestedScrollingParent2;
        int i = 0;
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(i)) {
            this.nestedScrollChildHelper.stopNestedScroll(i);
        }
        int i2 = 1;
        if (this.nestedScrollChildHelper.hasNestedScrollingParent(i2)) {
            this.nestedScrollChildHelper.stopNestedScroll(i2);
        }
    }

    public Object onPostFling-RZ2iAVY(long consumed, long available, Continuation<? super Velocity> $completion) {
        long zero-9UxMQ8M;
        float f = NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getX-impl($completion));
        if (this.nestedScrollChildHelper.dispatchNestedFling(f, NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getY-impl($completion)), true)) {
            zero-9UxMQ8M = $completion;
        } else {
            zero-9UxMQ8M = Velocity.Companion.getZero-9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.box-impl(zero-9UxMQ8M);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        final Object obj = this;
        if (obj.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.access$getScrollAxes-k-4lQ0M(source), NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(obj21))) {
            int i3 = 0;
            ArraysKt.fill$default(obj.consumedScrollCache, i3, 0, 0, 6, 0);
            obj.nestedScrollChildHelper.dispatchNestedScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getX-impl(consumed)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getY-impl(consumed)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getX-impl(source)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getY-impl(source)), 0, NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(obj21), obj.consumedScrollCache);
            return NestedScrollInteropConnectionKt.access$toOffset-Uv8p0NA(obj.consumedScrollCache, source);
        }
        int[] iArr2 = source;
        return Offset.Companion.getZero-F1C5BW0();
    }

    public Object onPreFling-QWom1Mo(long available, Continuation<? super Velocity> $completion) {
        long zero-9UxMQ8M;
        float f = NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getX-impl(available));
        if (this.nestedScrollChildHelper.dispatchNestedPreFling(f, NestedScrollInteropConnectionKt.access$toViewVelocity(Velocity.getY-impl(available)))) {
            zero-9UxMQ8M = available;
        } else {
            zero-9UxMQ8M = Velocity.Companion.getZero-9UxMQ8M();
        }
        interruptOngoingScrolls();
        return Velocity.box-impl(zero-9UxMQ8M);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPreScroll-OzD1aCk(long available, int source) {
        if (this.nestedScrollChildHelper.startNestedScroll(NestedScrollInteropConnectionKt.access$getScrollAxes-k-4lQ0M(available), NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(obj16))) {
            ArraysKt.fill$default(this.consumedScrollCache, 0, 0, 0, 6, 0);
            this.nestedScrollChildHelper.dispatchNestedPreScroll(NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getX-impl(available)), NestedScrollInteropConnectionKt.composeToViewOffset(Offset.getY-impl(available)), this.consumedScrollCache, 0, NestedScrollInteropConnectionKt.access$toViewType-GyEprt8(obj16));
            return NestedScrollInteropConnectionKt.access$toOffset-Uv8p0NA(this.consumedScrollCache, available);
        }
        return Offset.Companion.getZero-F1C5BW0();
    }
}
