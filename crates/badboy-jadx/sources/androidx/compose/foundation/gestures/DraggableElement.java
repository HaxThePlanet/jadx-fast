package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000 &2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B³\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0008\u0012<\u0010\u000c\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\u0008\u0016\u0012<\u0010\u0017\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\u0008\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u0008¢\u0006\u0002\u0010\u001bJ\u0008\u0010\u001d\u001a\u00020\u0002H\u0016J\u0013\u0010\u001e\u001a\u00020\u00082\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010 \u001a\u00020!H\u0016J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0002H\u0016J\u000c\u0010$\u001a\u00020\u0014*\u00020%H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000RF\u0010\u000c\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0012\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\u0008\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cRF\u0010\u0017\u001a8\u0008\u0001\u0012\u0004\u0012\u00020\u000e\u0012\u0013\u0012\u00110\u0018¢\u0006\u000c\u0008\u0010\u0012\u0008\u0008\u0011\u0012\u0004\u0008\u0008(\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00150\r¢\u0006\u0002\u0008\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Landroidx/compose/foundation/gestures/DraggableElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/DraggableNode;", "state", "Landroidx/compose/foundation/gestures/DraggableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "onDragStopped", "", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/DraggableState;Landroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Z)V", "Lkotlin/jvm/functions/Function3;", "create", "equals", "other", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DraggableElement extends ModifierNodeElement<androidx.compose.foundation.gestures.DraggableNode> {

    public static final int $stable;
    private static final Function1<PointerInputChange, Boolean> CanDrag;
    public static final androidx.compose.foundation.gestures.DraggableElement.Companion Companion;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function3<CoroutineScope, Offset, Continuation<? super Unit>, Object> onDragStarted;
    private final Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> onDragStopped;
    private final androidx.compose.foundation.gestures.Orientation orientation;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final androidx.compose.foundation.gestures.DraggableState state;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/foundation/gestures/DraggableElement$Companion;", "", "()V", "CanDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Function1<PointerInputChange, Boolean> getCanDrag() {
            return DraggableElement.access$getCanDrag$cp();
        }
    }
    static {
        DraggableElement.Companion companion = new DraggableElement.Companion(0);
        DraggableElement.Companion = companion;
        DraggableElement.CanDrag = (Function1)DraggableElement.Companion.CanDrag.1.INSTANCE;
    }

    public DraggableElement(androidx.compose.foundation.gestures.DraggableState state, androidx.compose.foundation.gestures.Orientation orientation, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function3<? super CoroutineScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> onDragStarted, Function3<? super CoroutineScope, ? super Float, ? super Continuation<? super Unit>, ? extends Object> onDragStopped, boolean reverseDirection) {
        super();
        this.state = state;
        this.orientation = orientation;
        this.enabled = enabled;
        this.interactionSource = interactionSource;
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.reverseDirection = reverseDirection;
    }

    public static final Function1 access$getCanDrag$cp() {
        return DraggableElement.CanDrag;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.gestures.DraggableNode create() {
        DraggableNode draggableNode = new DraggableNode(this.state, DraggableElement.CanDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
        return draggableNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other == null) {
            return i2;
        }
        if (getClass() != other.getClass()) {
            return i2;
        }
        Object obj = other;
        if (!Intrinsics.areEqual(this.state, obj2.state)) {
            return i2;
        }
        if (this.orientation != obj3.orientation) {
            return i2;
        }
        if (this.enabled != obj4.enabled) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.interactionSource, obj5.interactionSource)) {
            return i2;
        }
        if (this.startDragImmediately != obj6.startDragImmediately) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onDragStarted, obj7.onDragStarted)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onDragStopped, obj8.onDragStopped)) {
            return i2;
        }
        if (this.reverseDirection != obj9.reverseDirection) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        MutableInteractionSource interactionSource = this.interactionSource;
        if (interactionSource != null) {
            i = interactionSource.hashCode();
        } else {
            i = 0;
        }
        return result6 += i16;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("draggable");
        $this$inspectableProperties.getProperties().set("orientation", this.orientation);
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
        $this$inspectableProperties.getProperties().set("onDragStarted", this.onDragStarted);
        $this$inspectableProperties.getProperties().set("onDragStopped", this.onDragStopped);
        $this$inspectableProperties.getProperties().set("state", this.state);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.gestures.DraggableNode node) {
        node.update(this.state, DraggableElement.CanDrag, this.orientation, this.enabled, this.interactionSource, this.startDragImmediately, this.onDragStarted, this.onDragStopped, this.reverseDirection);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((DraggableNode)node);
    }
}
