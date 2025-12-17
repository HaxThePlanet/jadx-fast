package androidx.compose.material3;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerEventPass;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutAwareModifierNode;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J*\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J\u001a\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J(\u0010(\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nø\u0001\u0000¢\u0006\u0004\u0008)\u0010*R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000c\u001a\u00020\rX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\nX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0018R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006+", d2 = {"Landroidx/compose/material3/ClockDialNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "(Landroidx/compose/material3/AnalogTimePickerState;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "center", "Landroidx/compose/ui/unit/IntOffset;", "J", "maxDist", "", "getMaxDist", "()F", "offsetX", "offsetY", "pointerInputDragNode", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNode;", "pointerInputTapNode", "I", "onCancelPointerInput", "", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "Landroidx/compose/ui/unit/IntSize;", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "size", "onRemeasured-ozmzZPI", "(J)V", "updateNode", "updateNode-e8ubxrI", "(Landroidx/compose/material3/AnalogTimePickerState;ZI)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClockDialNode extends DelegatingNode implements PointerInputModifierNode, CompositionLocalConsumerModifierNode, LayoutAwareModifierNode {

    public static final int $stable = 8;
    private boolean autoSwitchToMinute;
    private long center;
    private float offsetX;
    private float offsetY;
    private final SuspendingPointerInputModifierNode pointerInputDragNode;
    private final SuspendingPointerInputModifierNode pointerInputTapNode;
    private int selection;
    private androidx.compose.material3.AnalogTimePickerState state;
    static {
        final int i = 8;
    }

    private ClockDialNode(androidx.compose.material3.AnalogTimePickerState state, boolean autoSwitchToMinute, int selection) {
        super();
        this.state = state;
        this.autoSwitchToMinute = autoSwitchToMinute;
        this.selection = selection;
        this.center = IntOffset.Companion.getZero-nOcc-ac();
        final int i = 0;
        ClockDialNode.pointerInputTapNode.1 anon = new ClockDialNode.pointerInputTapNode.1(this, i);
        this.pointerInputTapNode = (SuspendingPointerInputModifierNode)delegate((DelegatableNode)SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)anon));
        ClockDialNode.pointerInputDragNode.1 anon2 = new ClockDialNode.pointerInputDragNode.1(this, i);
        this.pointerInputDragNode = (SuspendingPointerInputModifierNode)delegate((DelegatableNode)SuspendingPointerInputFilterKt.SuspendingPointerInputModifierNode((Function2)anon2));
    }

    public ClockDialNode(androidx.compose.material3.AnalogTimePickerState analogTimePickerState, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(analogTimePickerState, z2, i3);
    }

    public static final boolean access$getAutoSwitchToMinute$p(androidx.compose.material3.ClockDialNode $this) {
        return $this.autoSwitchToMinute;
    }

    public static final long access$getCenter$p(androidx.compose.material3.ClockDialNode $this) {
        return $this.center;
    }

    public static final float access$getMaxDist(androidx.compose.material3.ClockDialNode $this) {
        return $this.getMaxDist();
    }

    public static final float access$getOffsetX$p(androidx.compose.material3.ClockDialNode $this) {
        return $this.offsetX;
    }

    public static final float access$getOffsetY$p(androidx.compose.material3.ClockDialNode $this) {
        return $this.offsetY;
    }

    public static final androidx.compose.material3.AnalogTimePickerState access$getState$p(androidx.compose.material3.ClockDialNode $this) {
        return $this.state;
    }

    public static final void access$setOffsetX$p(androidx.compose.material3.ClockDialNode $this, float <set-?>) {
        $this.offsetX = <set-?>;
    }

    public static final void access$setOffsetY$p(androidx.compose.material3.ClockDialNode $this, float <set-?>) {
        $this.offsetY = <set-?>;
    }

    private final float getMaxDist() {
        final int i = 0;
        return DelegatableNodeKt.requireDensity((DelegatableNode)this).toPx-0680j_4(TimePickerKt.access$getMaxDistance$p());
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onCancelPointerInput() {
        this.pointerInputTapNode.onCancelPointerInput();
        this.pointerInputDragNode.onCancelPointerInput();
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onPointerEvent-H0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        this.pointerInputTapNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
        this.pointerInputDragNode.onPointerEvent-H0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public void onRemeasured-ozmzZPI(long size) {
        this.center = IntSizeKt.getCenter-ozmzZPI(size);
    }

    @Override // androidx.compose.ui.node.DelegatingNode
    public final void updateNode-e8ubxrI(androidx.compose.material3.AnalogTimePickerState state, boolean autoSwitchToMinute, int selection) {
        boolean anon2;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i2;
        int i3;
        androidx.compose.material3.ClockDialNode.updateNode.1 anon;
        int i4;
        int i;
        this.state = state;
        this.autoSwitchToMinute = autoSwitchToMinute;
        if (!TimePickerSelectionMode.equals-impl0(this.selection, selection)) {
            this.selection = selection;
            i2 = 0;
            anon2 = new ClockDialNode.updateNode.1(state, i2);
            BuildersKt.launch$default(getCoroutineScope(), i2, 0, (Function2)anon2, 3, 0);
        }
    }
}
