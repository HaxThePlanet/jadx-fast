package androidx.compose.material.pullrefresh;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001aq\u0010\u0000\u001a\u00020\u0001*\u00020\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00040\u000321\u0010\u0008\u001a-\u0008\u0001\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u0012", d2 = {"pullRefresh", "Landroidx/compose/ui/Modifier;", "onPull", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pullDelta", "onRelease", "Lkotlin/Function2;", "flingVelocity", "Lkotlin/coroutines/Continuation;", "", "enabled", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Z)Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PullRefreshKt {
    public static final Object access$pullRefresh$onRelease(androidx.compose.material.pullrefresh.PullRefreshState $receiver, float p0, Continuation $completion) {
        return PullRefreshKt.pullRefresh$onRelease($receiver, p0, $completion);
    }

    public static final Modifier pullRefresh(Modifier $this$pullRefresh, androidx.compose.material.pullrefresh.PullRefreshState state, boolean enabled) {
        PullRefreshKt.pullRefresh.1 anon = new PullRefreshKt.pullRefresh.1(state);
        PullRefreshKt.pullRefresh.2 anon2 = new PullRefreshKt.pullRefresh.2(state);
        return PullRefreshKt.pullRefresh($this$pullRefresh, (Function1)anon, (Function2)anon2, enabled);
    }

    public static final Modifier pullRefresh(Modifier $this$pullRefresh, Function1<? super Float, Float> onPull, Function2<? super Float, ? super Continuation<? super Float>, ? extends Object> onRelease, boolean enabled) {
        PullRefreshNestedScrollConnection pullRefreshNestedScrollConnection = new PullRefreshNestedScrollConnection(onPull, onRelease, enabled);
        final int i = 0;
        return NestedScrollModifierKt.nestedScroll$default($this$pullRefresh, (NestedScrollConnection)pullRefreshNestedScrollConnection, i, 2, i);
    }

    public static Modifier pullRefresh$default(Modifier modifier, androidx.compose.material.pullrefresh.PullRefreshState pullRefreshState2, boolean z3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 1;
        }
        return PullRefreshKt.pullRefresh(modifier, pullRefreshState2, obj2);
    }

    public static Modifier pullRefresh$default(Modifier modifier, Function1 function12, Function2 function23, boolean z4, int i5, Object object6) {
        int obj3;
        if (i5 &= 4 != 0) {
            obj3 = 1;
        }
        return PullRefreshKt.pullRefresh(modifier, function12, function23, obj3);
    }

    private static final Object pullRefresh$onRelease(androidx.compose.material.pullrefresh.PullRefreshState $this$pullRefresh_u24onRelease, float p0, Continuation $completion) {
        return Boxing.boxFloat($this$pullRefresh_u24onRelease.onRelease$material_release(p0));
    }
}
