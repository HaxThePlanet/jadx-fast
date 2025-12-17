package androidx.compose.ui.input.key;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B1\u0012\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0002\u0010\u0008J\u0017\u0010\u000c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003J\u0017\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0003J9\u0010\u000e\u001a\u00020\u00002\u0016\u0008\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0016\u0008\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004HÆ\u0001J\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u000c\u0010\u001a\u001a\u00020\u0018*\u00020\u001bH\u0016R\u001f\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\n¨\u0006\u001c", d2 = {"Landroidx/compose/ui/input/key/SoftKeyboardInterceptionElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/key/InterceptedKeyInputNode;", "onKeyEvent", "Lkotlin/Function1;", "Landroidx/compose/ui/input/key/KeyEvent;", "", "onPreKeyEvent", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getOnKeyEvent", "()Lkotlin/jvm/functions/Function1;", "getOnPreKeyEvent", "component1", "component2", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SoftKeyboardInterceptionElement extends ModifierNodeElement<androidx.compose.ui.input.key.InterceptedKeyInputNode> {

    private final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> onKeyEvent;
    private final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> onPreKeyEvent;
    public SoftKeyboardInterceptionElement(Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onKeyEvent, Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> onPreKeyEvent) {
        super();
        this.onKeyEvent = onKeyEvent;
        this.onPreKeyEvent = onPreKeyEvent;
    }

    public static androidx.compose.ui.input.key.SoftKeyboardInterceptionElement copy$default(androidx.compose.ui.input.key.SoftKeyboardInterceptionElement softKeyboardInterceptionElement, Function1 function12, Function1 function13, int i4, Object object5) {
        Function1 obj1;
        Function1 obj2;
        if (i4 & 1 != 0) {
            obj1 = softKeyboardInterceptionElement.onKeyEvent;
        }
        if (i4 &= 2 != 0) {
            obj2 = softKeyboardInterceptionElement.onPreKeyEvent;
        }
        return softKeyboardInterceptionElement.copy(obj1, obj2);
    }

    public final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> component1() {
        return this.onKeyEvent;
    }

    public final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> component2() {
        return this.onPreKeyEvent;
    }

    public final androidx.compose.ui.input.key.SoftKeyboardInterceptionElement copy(Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> function1, Function1<? super androidx.compose.ui.input.key.KeyEvent, Boolean> function12) {
        SoftKeyboardInterceptionElement softKeyboardInterceptionElement = new SoftKeyboardInterceptionElement(function1, function12);
        return softKeyboardInterceptionElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.input.key.InterceptedKeyInputNode create() {
        InterceptedKeyInputNode interceptedKeyInputNode = new InterceptedKeyInputNode(this.onKeyEvent, this.onPreKeyEvent);
        return interceptedKeyInputNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof SoftKeyboardInterceptionElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.onKeyEvent, obj.onKeyEvent)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onPreKeyEvent, obj.onPreKeyEvent)) {
            return i2;
        }
        return i;
    }

    public final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> getOnKeyEvent() {
        return this.onKeyEvent;
    }

    public final Function1<androidx.compose.ui.input.key.KeyEvent, Boolean> getOnPreKeyEvent() {
        return this.onPreKeyEvent;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        int i2;
        if (this.onKeyEvent == null) {
            i = i2;
        } else {
            i = this.onKeyEvent.hashCode();
        }
        if (this.onPreKeyEvent == null) {
        } else {
            i2 = this.onPreKeyEvent.hashCode();
        }
        return i3 += i2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        int i;
        String str;
        ValueElementSequence properties;
        Function1 onKeyEvent = this.onKeyEvent;
        if (onKeyEvent != null) {
            i = 0;
            str = "onKeyToSoftKeyboardInterceptedEvent";
            $this$inspectableProperties.setName(str);
            $this$inspectableProperties.getProperties().set(str, onKeyEvent);
        }
        Function1 onPreKeyEvent = this.onPreKeyEvent;
        if (onPreKeyEvent != null) {
            i = 0;
            str = "onPreKeyToSoftKeyboardInterceptedEvent";
            $this$inspectableProperties.setName(str);
            $this$inspectableProperties.getProperties().set(str, onPreKeyEvent);
        }
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SoftKeyboardInterceptionElement(onKeyEvent=").append(this.onKeyEvent).append(", onPreKeyEvent=").append(this.onPreKeyEvent).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((InterceptedKeyInputNode)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.input.key.InterceptedKeyInputNode node) {
        node.setOnEvent(this.onKeyEvent);
        node.setOnPreEvent(this.onPreKeyEvent);
    }
}
