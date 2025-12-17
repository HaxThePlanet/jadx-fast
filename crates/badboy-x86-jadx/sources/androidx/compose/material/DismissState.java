package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0007\u0018\u0000 \u00132\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0008\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0086@¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u0012R\u0013\u0010\u0008\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0014", d2 = {"Landroidx/compose/material/DismissState;", "Landroidx/compose/material/SwipeableState;", "Landroidx/compose/material/DismissValue;", "initialValue", "confirmStateChange", "Lkotlin/Function1;", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;)V", "dismissDirection", "Landroidx/compose/material/DismissDirection;", "getDismissDirection", "()Landroidx/compose/material/DismissDirection;", "dismiss", "", "direction", "(Landroidx/compose/material/DismissDirection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isDismissed", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DismissState extends androidx.compose.material.SwipeableState<androidx.compose.material.DismissValue> {

    public static final int $stable;
    public static final androidx.compose.material.DismissState.Companion Companion;

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u0008¨\u0006\n", d2 = {"Landroidx/compose/material/DismissState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material/DismissState;", "Landroidx/compose/material/DismissValue;", "confirmStateChange", "Lkotlin/Function1;", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material.DismissState, androidx.compose.material.DismissValue> Saver(Function1<? super androidx.compose.material.DismissValue, Boolean> confirmStateChange) {
            DismissState.Companion.Saver.2 anon = new DismissState.Companion.Saver.2(confirmStateChange);
            return SaverKt.Saver((Function2)DismissState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        DismissState.Companion companion = new DismissState.Companion(0);
        DismissState.Companion = companion;
    }

    public DismissState(androidx.compose.material.DismissValue initialValue, Function1<? super androidx.compose.material.DismissValue, Boolean> confirmStateChange) {
        super(initialValue, 0, confirmStateChange, 2, 0);
    }

    public DismissState(androidx.compose.material.DismissValue dismissValue, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.material.DismissState.1 obj2;
        if (i3 &= 2 != 0) {
            obj2 = DismissState.1.INSTANCE;
        }
        super(dismissValue, obj2);
    }

    public final Object dismiss(androidx.compose.material.DismissDirection direction, Continuation<? super Unit> $completion) {
        androidx.compose.material.DismissValue dismissedToStart;
        dismissedToStart = direction == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart;
        Object obj9 = SwipeableState.animateTo$default((SwipeableState)this, dismissedToStart, 0, $completion, 2, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material.SwipeableState
    public final androidx.compose.material.DismissDirection getDismissDirection() {
        int i;
        androidx.compose.material.DismissDirection endToStart;
        final int i2 = 0;
        i = Float.compare(floatValue, i2) == 0 ? 1 : 0;
        endToStart = i != 0 ? 0 : cmp2 > 0 ? DismissDirection.StartToEnd : DismissDirection.EndToStart;
        return endToStart;
    }

    @Override // androidx.compose.material.SwipeableState
    public final boolean isDismissed(androidx.compose.material.DismissDirection direction) {
        int i;
        androidx.compose.material.DismissValue dismissedToStart;
        dismissedToStart = direction == DismissDirection.StartToEnd ? DismissValue.DismissedToEnd : DismissValue.DismissedToStart;
        i = getCurrentValue() == dismissedToStart ? 1 : 0;
        return i;
    }

    public final Object reset(Continuation<? super Unit> $completion) {
        Object obj7 = SwipeableState.animateTo$default((SwipeableState)this, DismissValue.Default, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }
}
