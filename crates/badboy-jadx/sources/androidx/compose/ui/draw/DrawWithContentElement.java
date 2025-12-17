package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u001e\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007¢\u0006\u0002\u0010\u0008J\u001a\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007HÆ\u0003J$\u0010\u000c\u001a\u00020\u00002\u0019\u0008\u0002\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007HÆ\u0001J\u0008\u0010\r\u001a\u00020\u0002H\u0016J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u000c\u0010\u0018\u001a\u00020\u0006*\u00020\u0019H\u0016R\"\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0008\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001a", d2 = {"Landroidx/compose/ui/draw/DrawWithContentElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/draw/DrawWithContentModifier;", "onDraw", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "getOnDraw", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DrawWithContentElement extends ModifierNodeElement<androidx.compose.ui.draw.DrawWithContentModifier> {

    private final Function1<ContentDrawScope, Unit> onDraw;
    public DrawWithContentElement(Function1<? super ContentDrawScope, Unit> onDraw) {
        super();
        this.onDraw = onDraw;
    }

    public static androidx.compose.ui.draw.DrawWithContentElement copy$default(androidx.compose.ui.draw.DrawWithContentElement drawWithContentElement, Function1 function12, int i3, Object object4) {
        Function1 obj1;
        if (i3 &= 1 != 0) {
            obj1 = drawWithContentElement.onDraw;
        }
        return drawWithContentElement.copy(obj1);
    }

    public final Function1<ContentDrawScope, Unit> component1() {
        return this.onDraw;
    }

    public final androidx.compose.ui.draw.DrawWithContentElement copy(Function1<? super ContentDrawScope, Unit> function1) {
        DrawWithContentElement drawWithContentElement = new DrawWithContentElement(function1);
        return drawWithContentElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.draw.DrawWithContentModifier create() {
        DrawWithContentModifier drawWithContentModifier = new DrawWithContentModifier(this.onDraw);
        return drawWithContentModifier;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DrawWithContentElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onDraw, obj.onDraw)) {
            return i2;
        }
        return i;
    }

    public final Function1<ContentDrawScope, Unit> getOnDraw() {
        return this.onDraw;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.onDraw.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("drawWithContent");
        $this$inspectableProperties.getProperties().set("onDraw", this.onDraw);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DrawWithContentElement(onDraw=").append(this.onDraw).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((DrawWithContentModifier)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.draw.DrawWithContentModifier node) {
        node.setOnDraw(this.onDraw);
    }
}
