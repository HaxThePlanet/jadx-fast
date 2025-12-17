package androidx.compose.material.pullrefresh;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0002\u0018\u00002\u00020\u0001Bc\u0012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00040\u0003\u00121\u0010\u0008\u001a-\u0008\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ*\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001b\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0014\u001a\u00020\u001aH\u0096@ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\"\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R;\u0010\u0008\u001a-\u0008\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\tX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006 ", d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPull", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pullDelta", "onRelease", "Lkotlin/Function2;", "flingVelocity", "Lkotlin/coroutines/Continuation;", "", "enabled", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Z)V", "Lkotlin/jvm/functions/Function2;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "Landroidx/compose/ui/unit/Velocity;", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PullRefreshNestedScrollConnection implements NestedScrollConnection {

    private final boolean enabled;
    private final Function1<Float, Float> onPull;
    private final Function2<Float, Continuation<? super Float>, Object> onRelease;
    public PullRefreshNestedScrollConnection(Function1<? super Float, Float> onPull, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> onRelease, boolean enabled) {
        super();
        this.onPull = onPull;
        this.onRelease = onRelease;
        this.enabled = enabled;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPostScroll-DzOQY0M(long consumed, long available, int source) {
        long zero-F1C5BW0;
        boolean cmp;
        int i;
        Float valueOf;
        if (!this.enabled) {
            zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
        } else {
            i = 0;
            if (NestedScrollSource.equals-impl0(obj8, NestedScrollSource.Companion.getUserInput-WNlRxjI()) && Float.compare(y-impl, i) > 0) {
                i = 0;
                if (Float.compare(y-impl, i) > 0) {
                    zero-F1C5BW0 = OffsetKt.Offset(i, (Number)this.onPull.invoke(Float.valueOf(Offset.getY-impl(source))).floatValue());
                } else {
                    zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
                }
            } else {
            }
        }
        return zero-F1C5BW0;
    }

    public Object onPreFling-QWom1Mo(long l, Continuation<? super Velocity> continuation2) {
        boolean anon;
        int i;
        int i4;
        androidx.compose.material.pullrefresh.PullRefreshNestedScrollConnection label;
        Function2 onRelease;
        Float boxFloat;
        int i2;
        int i3;
        Object obj8;
        Object obj10;
        anon = obj10;
        i4 = Integer.MIN_VALUE;
        if (obj10 instanceof PullRefreshNestedScrollConnection.onPreFling.1 && label2 &= i4 != 0) {
            anon = obj10;
            i4 = Integer.MIN_VALUE;
            if (label2 &= i4 != 0) {
                anon.label = obj10 -= i4;
            } else {
                anon = new PullRefreshNestedScrollConnection.onPreFling.1(this, obj10);
            }
        } else {
        }
        obj10 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                anon.F$0 = 0;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                ResultKt.throwOnFailure(obj10);
                i2 = obj8;
                obj8 = obj10;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        return Velocity.box-impl(VelocityKt.Velocity(i2, (Number)obj8.floatValue()));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    public long onPreScroll-OzD1aCk(long available, int source) {
        long zero-F1C5BW0;
        boolean cmp;
        int i;
        Float valueOf;
        if (!this.enabled) {
            zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
        } else {
            i = 0;
            if (NestedScrollSource.equals-impl0(obj6, NestedScrollSource.Companion.getUserInput-WNlRxjI()) && Float.compare(y-impl, i) < 0) {
                i = 0;
                if (Float.compare(y-impl, i) < 0) {
                    zero-F1C5BW0 = OffsetKt.Offset(i, (Number)this.onPull.invoke(Float.valueOf(Offset.getY-impl(available))).floatValue());
                } else {
                    zero-F1C5BW0 = Offset.Companion.getZero-F1C5BW0();
                }
            } else {
            }
        }
        return zero-F1C5BW0;
    }
}
