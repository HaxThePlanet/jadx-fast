package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001BÇ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012<\u0010\u000e\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\u0008\u0018\u0012<\u0010\u0019\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u001b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\u0008\u0018\u0012\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJM\u0010\u001f\u001a\u00020\u00162=\u0010 \u001a9\u0008\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\"¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(#\u0012\u0004\u0012\u00020\u00160\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170!H\u0096@¢\u0006\u0002\u0010$J\u001a\u0010\u000e\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&J\u001a\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\u0008(\u0010&J\u0008\u0010\r\u001a\u00020\u0007H\u0016JÍ\u0001\u0010)\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u00072<\u0010\u000e\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\u0008\u00182<\u0010\u0019\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u001b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\u0008\u00182\u0006\u0010\u001c\u001a\u00020\u0007¢\u0006\u0002\u0010\u001dJ\u0016\u0010*\u001a\u00020\u0011*\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u0016\u0010*\u001a\u00020'*\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\u0008-\u0010,RF\u0010\u000e\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0011¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\u0008\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eRF\u0010\u0019\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0012\u0012\u0008\u0008\u0013\u0012\u0004\u0008\u0008(\u001b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u000f¢\u0006\u0002\u0008\u0018X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"Landroidx/compose/foundation/gestures/DraggableNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/DraggableState;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted-k-4lQ0M", "(J)V", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "update", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DraggableNode extends androidx.compose.foundation.gestures.DragGestureNode {

    public static final int $stable = 8;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private androidx.compose.foundation.gestures.Orientation orientation;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private androidx.compose.foundation.gestures.DraggableState state;
    static {
        final int i = 8;
    }

    public DraggableNode(androidx.compose.foundation.gestures.DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        super(canDrag, enabled, interactionSource, orientation);
        this.state = state;
        this.orientation = orientation;
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.reverseDirection = reverseDirection;
    }

    public static final Function3 access$getOnDragStarted$p(androidx.compose.foundation.gestures.DraggableNode $this) {
        return $this.onDragStarted;
    }

    public static final Function3 access$getOnDragStopped$p(androidx.compose.foundation.gestures.DraggableNode $this) {
        return $this.onDragStopped;
    }

    public static final androidx.compose.foundation.gestures.Orientation access$getOrientation$p(androidx.compose.foundation.gestures.DraggableNode $this) {
        return $this.orientation;
    }

    public static final long access$reverseIfNeeded-AH228Gc(androidx.compose.foundation.gestures.DraggableNode $this, long $receiver) {
        return $this.reverseIfNeeded-AH228Gc($receiver);
    }

    public static final long access$reverseIfNeeded-MK-Hz9U(androidx.compose.foundation.gestures.DraggableNode $this, long $receiver) {
        return $this.reverseIfNeeded-MK-Hz9U($receiver);
    }

    private final long reverseIfNeeded-AH228Gc(long $this$reverseIfNeeded_u2dAH228Gc) {
        int i;
        i = this.reverseDirection ? -1082130432 : 1065353216;
        return Velocity.times-adjELrA($this$reverseIfNeeded_u2dAH228Gc, obj4);
    }

    private final long reverseIfNeeded-MK-Hz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        int i;
        i = this.reverseDirection ? -1082130432 : 1065353216;
        return Offset.times-tuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, obj4);
    }

    public Object drag(Function2<? super Function1<? super androidx.compose.foundation.gestures.DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> forEachDelta, Continuation<? super Unit> $completion) {
        DraggableNode.drag.2 anon = new DraggableNode.drag.2(forEachDelta, this, 0);
        Object drag = this.state.drag(MutatePriority.UserInput, (Function2)anon, $completion);
        if (drag == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return drag;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStarted-k-4lQ0M(long startedPosition) {
        boolean attached;
        Function3 function3;
        if (isAttached() && Intrinsics.areEqual(this.onDragStarted, DraggableKt.access$getNoOpOnDragStarted$p())) {
            if (Intrinsics.areEqual(this.onDragStarted, DraggableKt.access$getNoOpOnDragStarted$p())) {
            }
            final int i = 0;
            DraggableNode.onDragStarted.1 anon = new DraggableNode.onDragStarted.1(this, startedPosition, obj9, i);
            BuildersKt.launch$default(getCoroutineScope(), i, 0, (Function2)anon, 3, 0);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped-TH1AsA0(long velocity) {
        boolean attached;
        Function3 function3;
        if (isAttached() && Intrinsics.areEqual(this.onDragStopped, DraggableKt.access$getNoOpOnDragStopped$p())) {
            if (Intrinsics.areEqual(this.onDragStopped, DraggableKt.access$getNoOpOnDragStopped$p())) {
            }
            final int i = 0;
            DraggableNode.onDragStopped.1 anon = new DraggableNode.onDragStopped.1(this, velocity, obj9, i);
            BuildersKt.launch$default(getCoroutineScope(), i, 0, (Function2)anon, 3, 0);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(androidx.compose.foundation.gestures.DraggableState state, Function1<? super PointerInputChange, Boolean> canDrag, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        int resetPointerInputHandling;
        int i;
        final boolean z = reverseDirection;
        resetPointerInputHandling = 0;
        if (!Intrinsics.areEqual(this.state, state)) {
            this.state = state;
            resetPointerInputHandling = 1;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            resetPointerInputHandling = 1;
        }
        if (this.reverseDirection != z) {
            this.reverseDirection = z;
            i = resetPointerInputHandling;
        } else {
            i = resetPointerInputHandling;
        }
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.startDragImmediately = startDragImmediately;
        this.update(canDrag, enabled, interactionSource, orientation, i);
    }
}
