package androidx.compose.foundation.draganddrop;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0083\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BG\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007\u0012'\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\u0007¢\u0006\u0002\u0010\rJ\u001a\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007HÆ\u0003J/\u0010\u0014\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJT\u0010\u0015\u001a\u00020\u00002\u0019\u0008\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u00072)\u0008\u0002\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\u0008\u0010\u0017\u001a\u00020\u0002H\u0016J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u000cHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u0002H\u0016J\u000c\u0010!\u001a\u00020\u0006*\u00020\"H\u0016R4\u0010\u0008\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\t¢\u0006\u0002\u0008\u0007¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006#", d2 = {"Landroidx/compose/foundation/draganddrop/DragAndDropSourceElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceNode;", "drawDragDecoration", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "dragAndDropSourceHandler", "Lkotlin/Function2;", "Landroidx/compose/foundation/draganddrop/DragAndDropSourceScope;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getDragAndDropSourceHandler", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getDrawDragDecoration", "()Lkotlin/jvm/functions/Function1;", "component1", "component2", "copy", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/draganddrop/DragAndDropSourceElement;", "create", "equals", "", "other", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DragAndDropSourceElement extends ModifierNodeElement<androidx.compose.foundation.draganddrop.DragAndDropSourceNode> {

    private final Function2<androidx.compose.foundation.draganddrop.DragAndDropSourceScope, Continuation<? super Unit>, Object> dragAndDropSourceHandler;
    private final Function1<DrawScope, Unit> drawDragDecoration;
    public DragAndDropSourceElement(Function1<? super DrawScope, Unit> drawDragDecoration, Function2<? super androidx.compose.foundation.draganddrop.DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> dragAndDropSourceHandler) {
        super();
        this.drawDragDecoration = drawDragDecoration;
        this.dragAndDropSourceHandler = dragAndDropSourceHandler;
    }

    public static androidx.compose.foundation.draganddrop.DragAndDropSourceElement copy$default(androidx.compose.foundation.draganddrop.DragAndDropSourceElement dragAndDropSourceElement, Function1 function12, Function2 function23, int i4, Object object5) {
        Function1 obj1;
        Function2 obj2;
        if (i4 & 1 != 0) {
            obj1 = dragAndDropSourceElement.drawDragDecoration;
        }
        if (i4 &= 2 != 0) {
            obj2 = dragAndDropSourceElement.dragAndDropSourceHandler;
        }
        return dragAndDropSourceElement.copy(obj1, obj2);
    }

    public final Function1<DrawScope, Unit> component1() {
        return this.drawDragDecoration;
    }

    public final Function2<androidx.compose.foundation.draganddrop.DragAndDropSourceScope, Continuation<? super Unit>, Object> component2() {
        return this.dragAndDropSourceHandler;
    }

    public final androidx.compose.foundation.draganddrop.DragAndDropSourceElement copy(Function1<? super DrawScope, Unit> function1, Function2<? super androidx.compose.foundation.draganddrop.DragAndDropSourceScope, ? super Continuation<? super Unit>, ? extends Object> function22) {
        DragAndDropSourceElement dragAndDropSourceElement = new DragAndDropSourceElement(function1, function22);
        return dragAndDropSourceElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.draganddrop.DragAndDropSourceNode create() {
        DragAndDropSourceNode dragAndDropSourceNode = new DragAndDropSourceNode(this.drawDragDecoration, this.dragAndDropSourceHandler);
        return dragAndDropSourceNode;
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
        if (!object instanceof DragAndDropSourceElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.drawDragDecoration, obj.drawDragDecoration)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.dragAndDropSourceHandler, obj.dragAndDropSourceHandler)) {
            return i2;
        }
        return i;
    }

    public final Function2<androidx.compose.foundation.draganddrop.DragAndDropSourceScope, Continuation<? super Unit>, Object> getDragAndDropSourceHandler() {
        return this.dragAndDropSourceHandler;
    }

    public final Function1<DrawScope, Unit> getDrawDragDecoration() {
        return this.drawDragDecoration;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("dragSource");
        $this$inspectableProperties.getProperties().set("drawDragDecoration", this.drawDragDecoration);
        $this$inspectableProperties.getProperties().set("dragAndDropSourceHandler", this.dragAndDropSourceHandler);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DragAndDropSourceElement(drawDragDecoration=").append(this.drawDragDecoration).append(", dragAndDropSourceHandler=").append(this.dragAndDropSourceHandler).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.draganddrop.DragAndDropSourceNode node) {
        final Object obj = node;
        final int i = 0;
        obj.setDrawDragDecoration(this.drawDragDecoration);
        obj.setDragAndDropSourceHandler(this.dragAndDropSourceHandler);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((DragAndDropSourceNode)node);
    }
}
