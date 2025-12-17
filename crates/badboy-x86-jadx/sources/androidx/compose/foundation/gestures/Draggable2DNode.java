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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0000\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\u0008\u001a\u00020\u0007\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u000c\u001a\u00020\u0007\u0012>\u0008\u0002\u0010\r\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\u0008\u0017\u0012#\u0008\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00150\u0005\u0012>\u0008\u0002\u0010\u0019\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\u0008\u0017\u0012#\u0008\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0005¢\u0006\u0002\u0010\u001dJM\u0010\u001f\u001a\u00020\u00152=\u0010 \u001a9\u0008\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\"¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(#\u0012\u0004\u0012\u00020\u00150\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160!H\u0096@¢\u0006\u0002\u0010$J\u001a\u0010\r\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&J\u001a\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\u0008'\u0010&J\u0008\u0010\u000b\u001a\u00020\u0007H\u0016J\u0093\u0002\u0010(\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\u0008\u001a\u00020\u00072\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00072>\u0008\u0002\u0010\r\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\u0008\u00172>\u0008\u0002\u0010\u0019\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\u0008\u00172#\u0008\u0002\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00150\u00052#\u0008\u0002\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0005¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\u0010*\u00020\u0010H\u0002ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,J\u0016\u0010*\u001a\u00020\u001a*\u00020\u001aH\u0002ø\u0001\u0000¢\u0006\u0004\u0008-\u0010,R)\u0010\u0018\u001a\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\r\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u0013\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\u0008\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR)\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00150\u0005X\u0082\u000e¢\u0006\u0002\n\u0000RF\u0010\u0019\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000f\u0012\u0013\u0012\u00110\u001a¢\u0006\u000c\u0008\u0011\u0012\u0008\u0008\u0012\u0012\u0004\u0008\u0008(\u001b\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000e¢\u0006\u0002\u0008\u0017X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u000e\u0010\u000c\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"Landroidx/compose/foundation/gestures/Draggable2DNode;", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "canDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "reverseDirection", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStart", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "onDragStop", "(Landroidx/compose/foundation/gestures/Draggable2DState;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/jvm/functions/Function3;", "drag", "forEachDelta", "Lkotlin/Function2;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "dragDelta", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped-TH1AsA0", "update", "(Landroidx/compose/foundation/gestures/Draggable2DState;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Draggable2DNode extends androidx.compose.foundation.gestures.DragGestureNode {

    public static final int $stable = 8;
    private Function1<? super Offset, Unit> onDragStart;
    private Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted;
    private Function1<? super Velocity, Unit> onDragStop;
    private Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped;
    private boolean reverseDirection;
    private boolean startDragImmediately;
    private androidx.compose.foundation.gestures.Draggable2DState state;
    static {
        final int i = 8;
    }

    public Draggable2DNode(androidx.compose.foundation.gestures.Draggable2DState state, Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, boolean reverseDirection, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function1<? super Offset, Unit> onDragStart, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, Function1<? super Velocity, Unit> onDragStop) {
        super(canDrag, enabled, interactionSource, 0);
        this.state = state;
        this.startDragImmediately = startDragImmediately;
        this.reverseDirection = reverseDirection;
        this.onDragStarted = onDragStarted;
        this.onDragStart = onDragStart;
        this.onDragStopped = onDragStopped;
        this.onDragStop = onDragStop;
    }

    public Draggable2DNode(androidx.compose.foundation.gestures.Draggable2DState draggable2DState, Function1 function12, boolean z3, MutableInteractionSource mutableInteractionSource4, boolean z5, boolean z6, Function3 function37, Function1 function18, Function3 function39, Function1 function110, int i11, DefaultConstructorMarker defaultConstructorMarker12) {
        int i2;
        int i4;
        int i;
        Function3 i3;
        Function3 function32;
        Function1 function13;
        Function3 function3;
        Function1 function1;
        int i5 = i11;
        if (i5 & 64 != 0) {
            function32 = i4;
        } else {
            function32 = function37;
        }
        if (i5 & 128 != 0) {
            function13 = i;
        } else {
            function13 = function18;
        }
        if (i5 & 256 != 0) {
            function3 = i3;
        } else {
            function3 = function39;
        }
        if (i5 &= 512 != 0) {
            function1 = i2;
        } else {
            function1 = function110;
        }
        super(draggable2DState, function12, z3, mutableInteractionSource4, z5, z6, function32, function13, function3, function1);
    }

    public static final Function3 access$getOnDragStarted$p(androidx.compose.foundation.gestures.Draggable2DNode $this) {
        return $this.onDragStarted;
    }

    public static final Function3 access$getOnDragStopped$p(androidx.compose.foundation.gestures.Draggable2DNode $this) {
        return $this.onDragStopped;
    }

    public static final long access$reverseIfNeeded-AH228Gc(androidx.compose.foundation.gestures.Draggable2DNode $this, long $receiver) {
        return $this.reverseIfNeeded-AH228Gc($receiver);
    }

    public static final long access$reverseIfNeeded-MK-Hz9U(androidx.compose.foundation.gestures.Draggable2DNode $this, long $receiver) {
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

    public static void update$default(androidx.compose.foundation.gestures.Draggable2DNode draggable2DNode, androidx.compose.foundation.gestures.Draggable2DState draggable2DState2, Function1 function13, boolean z4, MutableInteractionSource mutableInteractionSource5, boolean z6, boolean z7, Function3 function38, Function3 function39, Function1 function110, Function1 function111, int i12, Object object13) {
        int onDragStop;
        int onDragStarted;
        int onDragStopped;
        Function1 onDragStart;
        Function3 function3;
        Function3 function32;
        Function1 function12;
        Function1 function1;
        int i = i12;
        function3 = i & 64 != 0 ? onDragStarted : function38;
        function32 = i & 128 != 0 ? onDragStopped : function39;
        function12 = i & 256 != 0 ? onDragStart : function110;
        function1 = i &= 512 != 0 ? onDragStop : function111;
        draggable2DNode.update(draggable2DState2, function13, z4, mutableInteractionSource5, z6, z7, function3, function32, function12, function1);
    }

    public Object drag(Function2<? super Function1<? super androidx.compose.foundation.gestures.DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> forEachDelta, Continuation<? super Unit> $completion) {
        Draggable2DNode.drag.2 anon = new Draggable2DNode.drag.2(forEachDelta, this, 0);
        Object drag = this.state.drag(MutatePriority.UserInput, (Function2)anon, $completion);
        if (drag == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return drag;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStarted-k-4lQ0M(long startedPosition) {
        boolean onDragStarted;
        Object box-impl;
        this.onDragStart.invoke(Offset.box-impl(startedPosition));
        if (isAttached() && this.onDragStarted == Draggable2DKt.access$getNoOpOnDragStarted$p()) {
            if (this.onDragStarted == Draggable2DKt.access$getNoOpOnDragStarted$p()) {
            }
            Draggable2DNode.onDragStarted.1 anon = new Draggable2DNode.onDragStarted.1(this, startedPosition, obj10, 0);
            BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped-TH1AsA0(long velocity) {
        boolean onDragStopped;
        Object box-impl;
        this.onDragStop.invoke(Velocity.box-impl(velocity));
        if (isAttached() && this.onDragStopped == Draggable2DKt.access$getNoOpOnDragStopped$p()) {
            if (this.onDragStopped == Draggable2DKt.access$getNoOpOnDragStopped$p()) {
            }
            Draggable2DNode.onDragStopped.1 anon = new Draggable2DNode.onDragStopped.1(this, velocity, obj10, 0);
            BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
        }
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(androidx.compose.foundation.gestures.Draggable2DState state, Function1<? super PointerInputChange, Boolean> canDrag, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, boolean reverseDirection, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Velocity, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, Function1<? super Offset, Unit> onDragStart, Function1<? super Velocity, Unit> onDragStop) {
        int resetPointerInputHandling;
        int i;
        final boolean z = reverseDirection;
        resetPointerInputHandling = 0;
        if (!Intrinsics.areEqual(this.state, state)) {
            this.state = state;
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
        this.onDragStart = onDragStart;
        this.onDragStop = onDragStop;
        this.startDragImmediately = startDragImmediately;
        this.update(canDrag, enabled, interactionSource, 0, i);
    }
}
