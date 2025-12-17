package androidx.compose.ui.input.pointer;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\\\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u0014\u0008\u0002\u0010\u0006\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007\u0012'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\u0002\u0008\r¢\u0006\u0002\u0010\u000eJ\u0008\u0010\u0018\u001a\u00020\u0002H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0004H\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000c2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u000c\u0010 \u001a\u00020\u000c*\u00020!H\u0016R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0010R\u001f\u0010\u0006\u001a\u000e\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R4\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040\t¢\u0006\u0002\u0008\r¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006\"", d2 = {"Landroidx/compose/ui/input/pointer/SuspendPointerInputElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/input/pointer/SuspendingPointerInputModifierNodeImpl;", "key1", "", "key2", "keys", "", "pointerInputHandler", "Lkotlin/Function2;", "Landroidx/compose/ui/input/pointer/PointerInputScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Ljava/lang/Object;[Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "getKey1", "()Ljava/lang/Object;", "getKey2", "getKeys", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getPointerInputHandler", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "create", "equals", "", "other", "hashCode", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SuspendPointerInputElement extends ModifierNodeElement<androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl> {

    public static final int $stable;
    private final Object key1;
    private final Object key2;
    private final Object[] keys;
    private final Function2<androidx.compose.ui.input.pointer.PointerInputScope, Continuation<? super Unit>, Object> pointerInputHandler;
    static {
    }

    public SuspendPointerInputElement(Object key1, Object key2, Object[] keys, Function2<? super androidx.compose.ui.input.pointer.PointerInputScope, ? super Continuation<? super Unit>, ? extends Object> pointerInputHandler) {
        super();
        this.key1 = key1;
        this.key2 = key2;
        this.keys = keys;
        this.pointerInputHandler = pointerInputHandler;
    }

    public SuspendPointerInputElement(Object object, Object object2, Object[] object3Arr3, Function2 function24, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        final int i = 0;
        obj2 = i5 & 1 != 0 ? i : obj2;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 &= 4 != 0 ? i : obj4;
        super(obj2, obj3, obj4, function24);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl create() {
        SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl = new SuspendingPointerInputModifierNodeImpl(this.key1, this.key2, this.keys, this.pointerInputHandler);
        return suspendingPointerInputModifierNodeImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        boolean equals;
        Object[] keys;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof SuspendPointerInputElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.key1, obj3.key1)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.key2, obj4.key2)) {
            return i2;
        }
        if (this.keys != null) {
            if (obj.keys == null) {
                return i2;
            }
            if (!Arrays.equals(this.keys, obj5.keys)) {
                return i2;
            }
        } else {
            if (obj2.keys != null) {
                return i2;
            }
        }
        if (this.pointerInputHandler == obj6.pointerInputHandler) {
        } else {
            i = i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Object getKey1() {
        return this.key1;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Object getKey2() {
        return this.key2;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final Object[] getKeys() {
        return this.keys;
    }

    public final Function2<androidx.compose.ui.input.pointer.PointerInputScope, Continuation<? super Unit>, Object> getPointerInputHandler() {
        return this.pointerInputHandler;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i3;
        int i;
        int i2;
        Object key1 = this.key1;
        i = 0;
        if (key1 != null) {
            i3 = key1.hashCode();
        } else {
            i3 = i;
        }
        Object key2 = this.key2;
        if (key2 != null) {
            i2 = key2.hashCode();
        } else {
            i2 = i;
        }
        Object[] keys = this.keys;
        if (keys != null) {
            i = Arrays.hashCode(keys);
        }
        return i5 += i9;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("pointerInput");
        $this$inspectableProperties.getProperties().set("key1", this.key1);
        $this$inspectableProperties.getProperties().set("key2", this.key2);
        $this$inspectableProperties.getProperties().set("keys", this.keys);
        $this$inspectableProperties.getProperties().set("pointerInputHandler", this.pointerInputHandler);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SuspendingPointerInputModifierNodeImpl)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.input.pointer.SuspendingPointerInputModifierNodeImpl node) {
        node.update$ui_release(this.key1, this.key2, this.keys, this.pointerInputHandler);
    }
}
