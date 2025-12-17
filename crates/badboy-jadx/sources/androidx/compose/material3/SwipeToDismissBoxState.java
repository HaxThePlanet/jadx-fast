package androidx.compose.material3;

import androidx.compose.material3.internal.AnchoredDraggableDefaults;
import androidx.compose.material3.internal.AnchoredDraggableKt;
import androidx.compose.material3.internal.AnchoredDraggableState;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0008\u0007\u0018\u0000 )2\u00020\u0001:\u0001)BN\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00080\u0007\u0012!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u000b\u0012\u0008\u0008\u000c\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\u0002\u0010\u000eJ\u0016\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\nJ\u000e\u0010&\u001a\u00020\"H\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u0003H\u0086@¢\u0006\u0002\u0010$R\u001a\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\n8G¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008 \u0010\u0015¨\u0006*", d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState;", "", "initialValue", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "anchoredDraggableState", "Landroidx/compose/material3/internal/AnchoredDraggableState;", "getAnchoredDraggableState$material3_release", "()Landroidx/compose/material3/internal/AnchoredDraggableState;", "currentValue", "getCurrentValue", "()Landroidx/compose/material3/SwipeToDismissBoxValue;", "getDensity$material3_release", "()Landroidx/compose/ui/unit/Density;", "dismissDirection", "getDismissDirection", "offset", "getOffset$material3_release", "()F", "progress", "getProgress", "targetValue", "getTargetValue", "dismiss", "", "direction", "(Landroidx/compose/material3/SwipeToDismissBoxValue;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireOffset", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeToDismissBoxState {

    public static final int $stable;
    public static final androidx.compose.material3.SwipeToDismissBoxState.Companion Companion;
    private final AnchoredDraggableState<androidx.compose.material3.SwipeToDismissBoxValue> anchoredDraggableState;
    private final Density density;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\u00082!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\u000c\u0008\u000c\u0012\u0008\u0008\r\u0012\u0004\u0008\u0008(\u000e\u0012\u0004\u0012\u00020\u000b0\u00082\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0011", d2 = {"Landroidx/compose/material3/SwipeToDismissBoxState$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/SwipeToDismissBoxState;", "Landroidx/compose/material3/SwipeToDismissBoxValue;", "confirmValueChange", "Lkotlin/Function1;", "", "positionalThreshold", "", "Lkotlin/ParameterName;", "name", "totalDistance", "density", "Landroidx/compose/ui/unit/Density;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.SwipeToDismissBoxState, androidx.compose.material3.SwipeToDismissBoxValue> Saver(Function1<? super androidx.compose.material3.SwipeToDismissBoxValue, Boolean> confirmValueChange, Function1<? super Float, Float> positionalThreshold, Density density) {
            SwipeToDismissBoxState.Companion.Saver.2 anon = new SwipeToDismissBoxState.Companion.Saver.2(density, confirmValueChange, positionalThreshold);
            return SaverKt.Saver((Function2)SwipeToDismissBoxState.Companion.Saver.1.INSTANCE, (Function1)anon);
        }
    }
    static {
        SwipeToDismissBoxState.Companion companion = new SwipeToDismissBoxState.Companion(0);
        SwipeToDismissBoxState.Companion = companion;
    }

    public SwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue initialValue, Density density, Function1<? super androidx.compose.material3.SwipeToDismissBoxValue, Boolean> confirmValueChange, Function1<? super Float, Float> positionalThreshold) {
        super();
        this.density = density;
        SwipeToDismissBoxState.anchoredDraggableState.1 anon = new SwipeToDismissBoxState.anchoredDraggableState.1(this);
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(initialValue, positionalThreshold, (Function0)anon, (AnimationSpec)AnchoredDraggableDefaults.INSTANCE.getAnimationSpec(), confirmValueChange);
        this.anchoredDraggableState = anchoredDraggableState;
    }

    public SwipeToDismissBoxState(androidx.compose.material3.SwipeToDismissBoxValue swipeToDismissBoxValue, Density density2, Function1 function13, Function1 function14, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.compose.material3.SwipeToDismissBoxState.1 obj3;
        if (i5 &= 4 != 0) {
            obj3 = SwipeToDismissBoxState.1.INSTANCE;
        }
        super(swipeToDismissBoxValue, density2, obj3, function14);
    }

    public final Object dismiss(androidx.compose.material3.SwipeToDismissBoxValue direction, Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, direction, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final AnchoredDraggableState<androidx.compose.material3.SwipeToDismissBoxValue> getAnchoredDraggableState$material3_release() {
        return this.anchoredDraggableState;
    }

    public final androidx.compose.material3.SwipeToDismissBoxValue getCurrentValue() {
        return (SwipeToDismissBoxValue)this.anchoredDraggableState.getCurrentValue();
    }

    public final Density getDensity$material3_release() {
        return this.density;
    }

    public final androidx.compose.material3.SwipeToDismissBoxValue getDismissDirection() {
        int naN;
        androidx.compose.material3.SwipeToDismissBoxValue startToEnd;
        final int i = 0;
        naN = Float.compare(offset$material3_release, i) == 0 ? 1 : 0;
        if (naN == 0) {
            if (Float.isNaN(getOffset$material3_release())) {
                startToEnd = SwipeToDismissBoxValue.Settled;
            } else {
                startToEnd = Float.compare(offset$material3_release3, i) > 0 ? SwipeToDismissBoxValue.StartToEnd : SwipeToDismissBoxValue.EndToStart;
            }
        } else {
        }
        return startToEnd;
    }

    public final float getOffset$material3_release() {
        return this.anchoredDraggableState.getOffset();
    }

    public final float getProgress() {
        return this.anchoredDraggableState.getProgress();
    }

    public final androidx.compose.material3.SwipeToDismissBoxValue getTargetValue() {
        return (SwipeToDismissBoxValue)this.anchoredDraggableState.getTargetValue();
    }

    public final float requireOffset() {
        return this.anchoredDraggableState.requireOffset();
    }

    public final Object reset(Continuation<? super Unit> $completion) {
        Object obj7 = AnchoredDraggableKt.animateTo$default(this.anchoredDraggableState, SwipeToDismissBoxValue.Settled, 0, $completion, 2, 0);
        if (obj7 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj7;
        }
        return Unit.INSTANCE;
    }

    public final Object snapTo(androidx.compose.material3.SwipeToDismissBoxValue targetValue, Continuation<? super Unit> $completion) {
        Object snapTo = AnchoredDraggableKt.snapTo(this.anchoredDraggableState, targetValue, $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
