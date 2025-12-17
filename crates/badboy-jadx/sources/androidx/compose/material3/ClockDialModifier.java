package androidx.compose.material3;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0080\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u000b\u001a\u00020\u0004HÂ\u0003J\t\u0010\u000c\u001a\u00020\u0006HÂ\u0003J\u0016\u0010\r\u001a\u00020\u0008HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ1\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0008\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\u00062\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0002H\u0016J\u000c\u0010\u001e\u001a\u00020\u001c*\u00020\u001fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u0008X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/material3/ClockDialModifier;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/material3/ClockDialNode;", "state", "Landroidx/compose/material3/AnalogTimePickerState;", "autoSwitchToMinute", "", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "(Landroidx/compose/material3/AnalogTimePickerState;ZILkotlin/jvm/internal/DefaultConstructorMarker;)V", "I", "component1", "component2", "component3", "component3-yecRtBI", "()I", "copy", "copy-e8ubxrI", "(Landroidx/compose/material3/AnalogTimePickerState;ZI)Landroidx/compose/material3/ClockDialModifier;", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ClockDialModifier extends ModifierNodeElement<androidx.compose.material3.ClockDialNode> {

    public static final int $stable;
    private final boolean autoSwitchToMinute;
    private final int selection;
    private final androidx.compose.material3.AnalogTimePickerState state;
    static {
    }

    private ClockDialModifier(androidx.compose.material3.AnalogTimePickerState state, boolean autoSwitchToMinute, int selection) {
        super();
        this.state = state;
        this.autoSwitchToMinute = autoSwitchToMinute;
        this.selection = selection;
    }

    public ClockDialModifier(androidx.compose.material3.AnalogTimePickerState analogTimePickerState, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(analogTimePickerState, z2, i3);
    }

    private final androidx.compose.material3.AnalogTimePickerState component1() {
        return this.state;
    }

    private final boolean component2() {
        return this.autoSwitchToMinute;
    }

    private final int component3-yecRtBI() {
        return this.selection;
    }

    public static androidx.compose.material3.ClockDialModifier copy-e8ubxrI$default(androidx.compose.material3.ClockDialModifier clockDialModifier, androidx.compose.material3.AnalogTimePickerState analogTimePickerState2, boolean z3, int i4, int i5, Object object6) {
        androidx.compose.material3.AnalogTimePickerState obj1;
        boolean obj2;
        int obj3;
        if (i5 & 1 != 0) {
            obj1 = clockDialModifier.state;
        }
        if (i5 & 2 != 0) {
            obj2 = clockDialModifier.autoSwitchToMinute;
        }
        if (i5 &= 4 != 0) {
            obj3 = clockDialModifier.selection;
        }
        return clockDialModifier.copy-e8ubxrI(obj1, obj2, obj3);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final androidx.compose.material3.ClockDialModifier copy-e8ubxrI(androidx.compose.material3.AnalogTimePickerState analogTimePickerState, boolean z2, int i3) {
        ClockDialModifier clockDialModifier = new ClockDialModifier(analogTimePickerState, z2, i3, 0);
        return clockDialModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.material3.ClockDialNode create() {
        ClockDialNode clockDialNode = new ClockDialNode(this.state, this.autoSwitchToMinute, this.selection, 0);
        return clockDialNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ClockDialModifier) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.state, obj.state)) {
            return i2;
        }
        if (this.autoSwitchToMinute != obj.autoSwitchToMinute) {
            return i2;
        }
        if (!TimePickerSelectionMode.equals-impl0(this.selection, obj.selection)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ClockDialModifier(state=").append(this.state).append(", autoSwitchToMinute=").append(this.autoSwitchToMinute).append(", selection=").append(TimePickerSelectionMode.toString-impl(this.selection)).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.material3.ClockDialNode node) {
        node.updateNode-e8ubxrI(this.state, this.autoSwitchToMinute, this.selection);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ClockDialNode)node);
    }
}
