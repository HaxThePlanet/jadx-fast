package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0008\u001a\u00020\u0002H\u0016J\u0013\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0096\u0002J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u000c\u0010\u0012\u001a\u00020\u0010*\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/layout/WithAlignmentLineElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "create", "equals", "", "other", "", "hashCode", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WithAlignmentLineElement extends ModifierNodeElement<androidx.compose.foundation.layout.SiblingsAlignedNode.WithAlignmentLineNode> {

    public static final int $stable;
    private final AlignmentLine alignmentLine;
    static {
    }

    public WithAlignmentLineElement(AlignmentLine alignmentLine) {
        super();
        this.alignmentLine = alignmentLine;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.SiblingsAlignedNode.WithAlignmentLineNode create() {
        SiblingsAlignedNode.WithAlignmentLineNode withAlignmentLineNode = new SiblingsAlignedNode.WithAlignmentLineNode(this.alignmentLine);
        return withAlignmentLineNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        Object obj;
        if (this == other) {
            return 1;
        }
        if (other instanceof WithAlignmentLineElement) {
            obj = other;
        } else {
            obj = 0;
        }
        if (obj == null) {
            return 0;
        }
        return Intrinsics.areEqual(this.alignmentLine, obj.alignmentLine);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.alignmentLine.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("alignBy");
        $this$inspectableProperties.setValue(this.alignmentLine);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.SiblingsAlignedNode.WithAlignmentLineNode node) {
        node.setAlignmentLine(this.alignmentLine);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SiblingsAlignedNode.WithAlignmentLineNode)node);
    }
}
