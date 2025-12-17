package androidx.compose.foundation.gestures;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000  2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0001 Bu\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00100\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u0015J\u0008\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u000c\u0010\u001e\u001a\u00020\u0010*\u00020\u001fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u000c¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u0013\u0012\u0004\u0012\u00020\u00100\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Landroidx/compose/foundation/gestures/Draggable2DElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/gestures/Draggable2DNode;", "state", "Landroidx/compose/foundation/gestures/Draggable2DState;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "startDragImmediately", "onDragStarted", "Lkotlin/Function1;", "Landroidx/compose/ui/geometry/Offset;", "Lkotlin/ParameterName;", "name", "startedPosition", "", "onDragStopped", "Landroidx/compose/ui/unit/Velocity;", "velocity", "reverseDirection", "(Landroidx/compose/foundation/gestures/Draggable2DState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)V", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Draggable2DElement extends ModifierNodeElement<androidx.compose.foundation.gestures.Draggable2DNode> {

    public static final int $stable;
    private static final Function1<PointerInputChange, Boolean> CanDrag;
    public static final androidx.compose.foundation.gestures.Draggable2DElement.Companion Companion;
    private final boolean enabled;
    private final MutableInteractionSource interactionSource;
    private final Function1<Offset, Unit> onDragStarted;
    private final Function1<Velocity, Unit> onDragStopped;
    private final boolean reverseDirection;
    private final boolean startDragImmediately;
    private final androidx.compose.foundation.gestures.Draggable2DState state;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/foundation/gestures/Draggable2DElement$Companion;", "", "()V", "CanDrag", "Lkotlin/Function1;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "", "getCanDrag", "()Lkotlin/jvm/functions/Function1;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Function1<PointerInputChange, Boolean> getCanDrag() {
            return Draggable2DElement.access$getCanDrag$cp();
        }
    }
    static {
        Draggable2DElement.Companion companion = new Draggable2DElement.Companion(0);
        Draggable2DElement.Companion = companion;
        Draggable2DElement.CanDrag = (Function1)Draggable2DElement.Companion.CanDrag.1.INSTANCE;
    }

    public Draggable2DElement(androidx.compose.foundation.gestures.Draggable2DState state, boolean enabled, MutableInteractionSource interactionSource, boolean startDragImmediately, Function1<? super Offset, Unit> onDragStarted, Function1<? super Velocity, Unit> onDragStopped, boolean reverseDirection) {
        super();
        this.state = state;
        this.enabled = enabled;
        this.interactionSource = interactionSource;
        this.startDragImmediately = startDragImmediately;
        this.onDragStarted = onDragStarted;
        this.onDragStopped = onDragStopped;
        this.reverseDirection = reverseDirection;
    }

    public static final Function1 access$getCanDrag$cp() {
        return Draggable2DElement.CanDrag;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.gestures.Draggable2DNode create() {
        Draggable2DNode draggable2DNode = new Draggable2DNode(this.state, Draggable2DElement.CanDrag, this.enabled, this.interactionSource, this.startDragImmediately, this.reverseDirection, 0, this.onDragStarted, 0, this.onDragStopped, 320, 0);
        return draggable2DNode;
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
        if (this.enabled != obj3.enabled) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.interactionSource, obj4.interactionSource)) {
            return i2;
        }
        if (this.startDragImmediately != obj5.startDragImmediately) {
            return i2;
        }
        if (this.onDragStarted != obj6.onDragStarted) {
            return i2;
        }
        if (this.onDragStopped != obj7.onDragStopped) {
            return i2;
        }
        if (this.reverseDirection != obj8.reverseDirection) {
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
        return result3 += i14;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("draggable2D");
        $this$inspectableProperties.getProperties().set("enabled", Boolean.valueOf(this.enabled));
        $this$inspectableProperties.getProperties().set("interactionSource", this.interactionSource);
        $this$inspectableProperties.getProperties().set("startDragImmediately", Boolean.valueOf(this.startDragImmediately));
        $this$inspectableProperties.getProperties().set("onDragStarted", this.onDragStarted);
        $this$inspectableProperties.getProperties().set("onDragStopped", this.onDragStopped);
        $this$inspectableProperties.getProperties().set("reverseDirection", Boolean.valueOf(this.reverseDirection));
        $this$inspectableProperties.getProperties().set("state", this.state);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.gestures.Draggable2DNode node) {
        Draggable2DNode.update$default(node, this.state, Draggable2DElement.CanDrag, this.enabled, this.interactionSource, this.startDragImmediately, this.reverseDirection, 0, 0, this.onDragStarted, this.onDragStopped, 192, 0);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((Draggable2DNode)node);
    }
}
