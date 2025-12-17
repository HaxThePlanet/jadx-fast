package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0007\n\u0002\u0008\t\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002BI\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0008¢\u0006\u0002\u0010\u000fJM\u0010\u0013\u001a\u00020\u00142=\u0010\u0015\u001a9\u0008\u0001\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u00140\u0017\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u001c\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u0016H\u0096@¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u001a\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\u0008'\u0010#J\u0008\u0010\u000e\u001a\u00020\u0008H\u0016JO\u0010(\u001a\u00020\u00142\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u00082\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0008¢\u0006\u0002\u0010\u000fJ\u0016\u0010)\u001a\u00020!*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\u0016\u0010)\u001a\u00020&*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\u0008,\u0010+J\u0016\u0010-\u001a\u00020.*\u00020!H\u0002ø\u0001\u0000¢\u0006\u0004\u0008/\u00100J\u0016\u0010-\u001a\u00020.*\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\u00081\u00100J\u0019\u00102\u001a\u00020!*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00083\u00104J\u0019\u00105\u001a\u00020&*\u00020.H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u00086\u00104R\u0014\u0010\u0010\u001a\u00020\u00088BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000c\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u000e\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u00067", d2 = {"Landroidx/compose/foundation/gestures/AnchoredDraggableNode;", "T", "Landroidx/compose/foundation/gestures/DragGestureNode;", "state", "Landroidx/compose/foundation/gestures/AnchoredDraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "reverseDirection", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "startDragImmediately", "(Landroidx/compose/foundation/gestures/AnchoredDraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLjava/lang/Boolean;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/OverscrollEffect;Z)V", "isReverseDirection", "()Z", "Ljava/lang/Boolean;", "drag", "", "forEachDelta", "Lkotlin/Function2;", "Lkotlin/Function1;", "Landroidx/compose/foundation/gestures/DragEvent$DragDelta;", "Lkotlin/ParameterName;", "name", "dragDelta", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStarted", "startedPosition", "Landroidx/compose/ui/geometry/Offset;", "onDragStarted-k-4lQ0M", "(J)V", "onDragStopped", "velocity", "Landroidx/compose/ui/unit/Velocity;", "onDragStopped-TH1AsA0", "update", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "(J)J", "reverseIfNeeded-AH228Gc", "toFloat", "", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "toVelocity", "toVelocity-adjELrA", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AnchoredDraggableNode<T>  extends androidx.compose.foundation.gestures.DragGestureNode {

    private androidx.compose.foundation.gestures.Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private Boolean reverseDirection;
    private boolean startDragImmediately;
    private androidx.compose.foundation.gestures.AnchoredDraggableState<T> state;
    public AnchoredDraggableNode(androidx.compose.foundation.gestures.AnchoredDraggableState<T> state, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        super(AnchoredDraggableKt.access$getAlwaysDrag$p(), enabled, interactionSource, orientation);
        this.state = state;
        this.orientation = orientation;
        this.reverseDirection = reverseDirection;
        this.overscrollEffect = overscrollEffect;
        this.startDragImmediately = startDragImmediately;
    }

    public static final OverscrollEffect access$getOverscrollEffect$p(androidx.compose.foundation.gestures.AnchoredDraggableNode $this) {
        return $this.overscrollEffect;
    }

    public static final androidx.compose.foundation.gestures.AnchoredDraggableState access$getState$p(androidx.compose.foundation.gestures.AnchoredDraggableNode $this) {
        return $this.state;
    }

    public static final long access$reverseIfNeeded-AH228Gc(androidx.compose.foundation.gestures.AnchoredDraggableNode $this, long $receiver) {
        return $this.reverseIfNeeded-AH228Gc($receiver);
    }

    public static final long access$reverseIfNeeded-MK-Hz9U(androidx.compose.foundation.gestures.AnchoredDraggableNode $this, long $receiver) {
        return $this.reverseIfNeeded-MK-Hz9U($receiver);
    }

    public static final float access$toFloat-TH1AsA0(androidx.compose.foundation.gestures.AnchoredDraggableNode $this, long $receiver) {
        return $this.toFloat-TH1AsA0($receiver);
    }

    public static final float access$toFloat-k-4lQ0M(androidx.compose.foundation.gestures.AnchoredDraggableNode $this, long $receiver) {
        return $this.toFloat-k-4lQ0M($receiver);
    }

    public static final long access$toOffset-tuRUvjQ(androidx.compose.foundation.gestures.AnchoredDraggableNode $this, float $receiver) {
        return $this.toOffset-tuRUvjQ($receiver);
    }

    public static final long access$toVelocity-adjELrA(androidx.compose.foundation.gestures.AnchoredDraggableNode $this, float $receiver) {
        return $this.toVelocity-adjELrA($receiver);
    }

    private final boolean isReverseDirection() {
        Enum requireLayoutDirection;
        boolean booleanValue;
        Enum horizontal;
        if (this.reverseDirection == null) {
            if (DelegatableNodeKt.requireLayoutDirection((DelegatableNode)this) == LayoutDirection.Rtl && this.orientation == Orientation.Horizontal) {
                booleanValue = this.orientation == Orientation.Horizontal ? 1 : 0;
            } else {
            }
        } else {
            Boolean reverseDirection2 = this.reverseDirection;
            Intrinsics.checkNotNull(reverseDirection2);
            booleanValue = reverseDirection2.booleanValue();
        }
        return booleanValue;
    }

    private final long reverseIfNeeded-AH228Gc(long $this$reverseIfNeeded_u2dAH228Gc) {
        int i;
        i = isReverseDirection() ? -1082130432 : 1065353216;
        return Velocity.times-adjELrA($this$reverseIfNeeded_u2dAH228Gc, obj4);
    }

    private final long reverseIfNeeded-MK-Hz9U(long $this$reverseIfNeeded_u2dMK_u2dHz9U) {
        int i;
        i = isReverseDirection() ? -1082130432 : 1065353216;
        return Offset.times-tuRUvjQ($this$reverseIfNeeded_u2dMK_u2dHz9U, obj4);
    }

    private final float toFloat-TH1AsA0(long $this$toFloat_u2dTH1AsA0) {
        float y-impl;
        if (this.orientation == Orientation.Vertical) {
            y-impl = Velocity.getY-impl($this$toFloat_u2dTH1AsA0);
        } else {
            y-impl = Velocity.getX-impl($this$toFloat_u2dTH1AsA0);
        }
        return y-impl;
    }

    private final float toFloat-k-4lQ0M(long $this$toFloat_u2dk_u2d4lQ0M) {
        float y-impl;
        if (this.orientation == Orientation.Vertical) {
            y-impl = Offset.getY-impl($this$toFloat_u2dk_u2d4lQ0M);
        } else {
            y-impl = Offset.getX-impl($this$toFloat_u2dk_u2d4lQ0M);
        }
        return y-impl;
    }

    private final long toOffset-tuRUvjQ(float $this$toOffset_u2dtuRUvjQ) {
        int i2;
        int i;
        i2 = this.orientation == Orientation.Horizontal ? $this$toOffset_u2dtuRUvjQ : i;
        if (this.orientation == Orientation.Vertical) {
            i = $this$toOffset_u2dtuRUvjQ;
        }
        return OffsetKt.Offset(i2, i);
    }

    private final long toVelocity-adjELrA(float $this$toVelocity_u2dadjELrA) {
        int i;
        int i2;
        i = this.orientation == Orientation.Horizontal ? $this$toVelocity_u2dadjELrA : i2;
        if (this.orientation == Orientation.Vertical) {
            i2 = $this$toVelocity_u2dadjELrA;
        }
        return VelocityKt.Velocity(i, i2);
    }

    public Object drag(Function2<? super Function1<? super androidx.compose.foundation.gestures.DragEvent.DragDelta, Unit>, ? super Continuation<? super Unit>, ? extends Object> forEachDelta, Continuation<? super Unit> $completion) {
        AnchoredDraggableNode.drag.2 anon = new AnchoredDraggableNode.drag.2(forEachDelta, this, 0);
        Object obj8 = AnchoredDraggableState.anchoredDrag$default(this.state, 0, (Function3)anon, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStarted-k-4lQ0M(long startedPosition) {
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public void onDragStopped-TH1AsA0(long velocity) {
        if (!isAttached()) {
        }
        final int i = 0;
        AnchoredDraggableNode.onDragStopped.1 anon = new AnchoredDraggableNode.onDragStopped.1(this, velocity, obj9, i);
        BuildersKt.launch$default(getCoroutineScope(), i, 0, (Function2)anon, 3, 0);
    }

    @Override // androidx.compose.foundation.gestures.DragGestureNode
    public boolean startDragImmediately() {
        return this.startDragImmediately;
    }

    public final void update(androidx.compose.foundation.gestures.AnchoredDraggableState<T> state, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, Boolean reverseDirection, MutableInteractionSource interactionSource, OverscrollEffect overscrollEffect, boolean startDragImmediately) {
        int resetPointerInputHandling;
        int i;
        resetPointerInputHandling = 0;
        if (!Intrinsics.areEqual(this.state, state)) {
            this.state = state;
            resetPointerInputHandling = 1;
        }
        if (this.orientation != orientation) {
            this.orientation = orientation;
            resetPointerInputHandling = 1;
        }
        if (!Intrinsics.areEqual(this.reverseDirection, reverseDirection)) {
            this.reverseDirection = reverseDirection;
            i = resetPointerInputHandling;
        } else {
            i = resetPointerInputHandling;
        }
        this.startDragImmediately = startDragImmediately;
        this.overscrollEffect = overscrollEffect;
        DragGestureNode.update$default((DragGestureNode)this, 0, enabled, interactionSource, orientation, i, 1, 0);
    }
}
