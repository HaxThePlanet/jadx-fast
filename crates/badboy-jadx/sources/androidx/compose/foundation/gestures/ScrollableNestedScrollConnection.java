package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.Velocity.Companion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ScrollableNestedScrollConnection implements NestedScrollConnection {

    private boolean enabled;
    private final androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic;
    public ScrollableNestedScrollConnection(androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic, boolean enabled) {
        super();
        this.scrollingLogic = scrollingLogic;
        this.enabled = enabled;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final androidx.compose.foundation.gestures.ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public Object onPostFling-RZ2iAVY(long l, long l2, Continuation<? super Velocity> continuation3) {
        int i;
        Object _this;
        androidx.compose.foundation.gestures.ScrollableNestedScrollConnection unbox-impl;
        androidx.compose.foundation.gestures.ScrollingLogic scrollingLogic;
        int i2;
        boolean obj4;
        int obj5;
        long obj6;
        obj4 = obj8;
        i = Integer.MIN_VALUE;
        if (obj8 instanceof ScrollableNestedScrollConnection.onPostFling.1 && obj5 &= i != 0) {
            obj4 = obj8;
            i = Integer.MIN_VALUE;
            if (obj5 &= i != 0) {
                obj4.label = obj5 -= i;
            } else {
                obj4 = new ScrollableNestedScrollConnection.onPostFling.1(this, obj8);
            }
        } else {
        }
        obj5 = obj4.result;
        final Object obj8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj5);
                unbox-impl = this;
                obj4.J$0 = continuation3;
                obj4.label = 1;
                return obj8;
                obj6 = Velocity.Companion.getZero-9UxMQ8M();
                return Velocity.box-impl(obj6);
            case 1:
                obj6 = obj4.J$0;
                ResultKt.throwOnFailure(obj5);
                _this = obj5;
                break;
            default:
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
        }
        obj6 = Velocity.minus-AH228Gc(obj6, obj7);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        long rawScroll-MK-Hz9U;
        if (this.enabled) {
            rawScroll-MK-Hz9U = this.scrollingLogic.performRawScroll-MK-Hz9U(source);
        } else {
            rawScroll-MK-Hz9U = Offset.Companion.getZero-F1C5BW0();
        }
        return rawScroll-MK-Hz9U;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public final void setEnabled(boolean <set-?>) {
        this.enabled = <set-?>;
    }
}
