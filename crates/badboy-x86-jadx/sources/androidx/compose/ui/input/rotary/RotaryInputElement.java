package androidx.compose.ui.input.rotary;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0008J\u0017\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\u0016\u0008\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0016\u0008\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0001J\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u000c\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\n¨\u0006\u001c", d2 = {"Landroidx/compose/ui/input/rotary/RotaryInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/rotary/RotaryInputNode;", "onRotaryScrollEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "", "onPreRotaryScrollEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnPreRotaryScrollEvent", "()Lkotlin/jvm/functions/Function1;", "getOnRotaryScrollEvent", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class RotaryInputElement extends ModifierNodeElement<androidx.compose.ui.input.rotary.RotaryInputNode> {

    private final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onPreRotaryScrollEvent;
    private final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onRotaryScrollEvent;
    public RotaryInputElement(Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onRotaryScrollEvent, Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> onPreRotaryScrollEvent) {
        super();
        this.onRotaryScrollEvent = onRotaryScrollEvent;
        this.onPreRotaryScrollEvent = onPreRotaryScrollEvent;
    }

    public static androidx.compose.ui.input.rotary.RotaryInputElement copy$default(androidx.compose.ui.input.rotary.RotaryInputElement rotaryInputElement, Function1 function12, Function1 function13, int i4, Object object5) {
        Function1 obj1;
        Function1 obj2;
        if (i4 & 1 != 0) {
            obj1 = rotaryInputElement.onRotaryScrollEvent;
        }
        if (i4 &= 2 != 0) {
            obj2 = rotaryInputElement.onPreRotaryScrollEvent;
        }
        return rotaryInputElement.copy(obj1, obj2);
    }

    public final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> component1() {
        return this.onRotaryScrollEvent;
    }

    public final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> component2() {
        return this.onPreRotaryScrollEvent;
    }

    public final androidx.compose.ui.input.rotary.RotaryInputElement copy(Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> function1, Function1<? super androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> function12) {
        RotaryInputElement rotaryInputElement = new RotaryInputElement(function1, function12);
        return rotaryInputElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.input.rotary.RotaryInputNode create() {
        RotaryInputNode rotaryInputNode = new RotaryInputNode(this.onRotaryScrollEvent, this.onPreRotaryScrollEvent);
        return rotaryInputNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof RotaryInputElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.onRotaryScrollEvent, obj.onRotaryScrollEvent)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onPreRotaryScrollEvent, obj.onPreRotaryScrollEvent)) {
            return i2;
        }
        return i;
    }

    public final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> getOnPreRotaryScrollEvent() {
        return this.onPreRotaryScrollEvent;
    }

    public final Function1<androidx.compose.ui.input.rotary.RotaryScrollEvent, Boolean> getOnRotaryScrollEvent() {
        return this.onRotaryScrollEvent;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        int i2;
        if (this.onRotaryScrollEvent == null) {
            i = i2;
        } else {
            i = this.onRotaryScrollEvent.hashCode();
        }
        if (this.onPreRotaryScrollEvent == null) {
        } else {
            i2 = this.onPreRotaryScrollEvent.hashCode();
        }
        return i3 += i2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        int i;
        String str;
        ValueElementSequence properties;
        Function1 onRotaryScrollEvent = this.onRotaryScrollEvent;
        if (onRotaryScrollEvent != null) {
            i = 0;
            str = "onRotaryScrollEvent";
            $this$inspectableProperties.setName(str);
            $this$inspectableProperties.getProperties().set(str, onRotaryScrollEvent);
        }
        Function1 onPreRotaryScrollEvent = this.onPreRotaryScrollEvent;
        if (onPreRotaryScrollEvent != null) {
            i = 0;
            str = "onPreRotaryScrollEvent";
            $this$inspectableProperties.setName(str);
            $this$inspectableProperties.getProperties().set(str, onPreRotaryScrollEvent);
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RotaryInputElement(onRotaryScrollEvent=").append(this.onRotaryScrollEvent).append(", onPreRotaryScrollEvent=").append(this.onPreRotaryScrollEvent).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((RotaryInputNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.input.rotary.RotaryInputNode node) {
        node.setOnEvent(this.onRotaryScrollEvent);
        node.setOnPreEvent(this.onPreRotaryScrollEvent);
    }
}
