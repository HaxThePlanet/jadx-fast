package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000b\u001a\u00020\u0002H\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u000c\u0010\u0015\u001a\u00020\u0013*\u00020\u0016H\u0016R\u0019\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\n\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/layout/UnspecifiedConstraintsElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/UnspecifiedConstraintsNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "(FFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMinHeight-D9Ej5fM", "()F", "F", "getMinWidth-D9Ej5fM", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class UnspecifiedConstraintsElement extends ModifierNodeElement<androidx.compose.foundation.layout.UnspecifiedConstraintsNode> {

    private final float minHeight;
    private final float minWidth;
    private UnspecifiedConstraintsElement(float minWidth, float minHeight) {
        super();
        this.minWidth = minWidth;
        this.minHeight = minHeight;
    }

    public UnspecifiedConstraintsElement(float f, float f2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        float obj1;
        float obj2;
        if (i3 & 1 != 0) {
            obj1 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        if (i3 &= 2 != 0) {
            obj2 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        super(obj1, obj2, 0);
    }

    public UnspecifiedConstraintsElement(float f, float f2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(f, f2);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.UnspecifiedConstraintsNode create() {
        UnspecifiedConstraintsNode unspecifiedConstraintsNode = new UnspecifiedConstraintsNode(this.minWidth, this.minHeight, 0);
        return unspecifiedConstraintsNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        boolean equals-impl0;
        int i;
        float minHeight;
        if (!other instanceof UnspecifiedConstraintsElement) {
            return 0;
        }
        if (Dp.equals-impl0(this.minWidth, obj.minWidth) && Dp.equals-impl0(this.minHeight, obj2.minHeight)) {
            if (Dp.equals-impl0(this.minHeight, obj2.minHeight)) {
                i = 1;
            }
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getMinHeight-D9Ej5fM() {
        return this.minHeight;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getMinWidth-D9Ej5fM() {
        return this.minWidth;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("defaultMinSize");
        $this$inspectableProperties.getProperties().set("minWidth", Dp.box-impl(this.minWidth));
        $this$inspectableProperties.getProperties().set("minHeight", Dp.box-impl(this.minHeight));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.UnspecifiedConstraintsNode node) {
        node.setMinWidth-0680j_4(this.minWidth);
        node.setMinHeight-0680j_4(this.minHeight);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((UnspecifiedConstraintsNode)node);
    }
}
