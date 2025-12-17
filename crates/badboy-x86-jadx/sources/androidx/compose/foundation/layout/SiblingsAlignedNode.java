package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.node.ParentDataModifierNode;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u00012\u00020\u0002:\u0002\u0008\tB\u0007\u0008\u0004¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0005H&\u0082\u0001\u0002\n\u000b¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/layout/SiblingsAlignedNode;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "WithAlignmentLineBlockNode", "WithAlignmentLineNode", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineBlockNode;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineNode;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class SiblingsAlignedNode extends Modifier.Node implements ParentDataModifierNode {

    public static final int $stable;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0016\u0010\n\u001a\u00020\u000b*\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000bH\u0016R&\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\u0006¨\u0006\u000e", d2 = {"Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineBlockNode;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode;", "block", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "(Lkotlin/jvm/functions/Function1;)V", "getBlock", "()Lkotlin/jvm/functions/Function1;", "setBlock", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WithAlignmentLineBlockNode extends androidx.compose.foundation.layout.SiblingsAlignedNode {

        public static final int $stable = 8;
        private Function1<? super Measured, Integer> block;
        static {
            final int i = 8;
        }

        public WithAlignmentLineBlockNode(Function1<? super Measured, Integer> block) {
            super(0);
            this.block = block;
        }

        public final Function1<Measured, Integer> getBlock() {
            return this.block;
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedNode
        public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
            Object obj;
            androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData;
            int i3;
            int i;
            int i4;
            int i5;
            int i6;
            int i2;
            if (parentData instanceof RowColumnParentData != null) {
                obj = parentData;
            } else {
                obj = 0;
            }
            if (obj == null) {
                rowColumnParentData = new RowColumnParentData(0, 0, 0, 0, 15, 0);
                obj = rowColumnParentData;
            }
            int i7 = 0;
            AlignmentLineProvider.Block block = new AlignmentLineProvider.Block(this.block);
            obj.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release((AlignmentLineProvider)block));
            return obj;
        }

        public final void setBlock(Function1<? super Measured, Integer> <set-?>) {
            this.block = <set-?>;
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0008\u001a\u00020\t*\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/layout/SiblingsAlignedNode$WithAlignmentLineNode;", "Landroidx/compose/foundation/layout/SiblingsAlignedNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "setAlignmentLine", "modifyParentData", "", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class WithAlignmentLineNode extends androidx.compose.foundation.layout.SiblingsAlignedNode {

        public static final int $stable = 8;
        private AlignmentLine alignmentLine;
        static {
            final int i = 8;
        }

        public WithAlignmentLineNode(AlignmentLine alignmentLine) {
            super(0);
            this.alignmentLine = alignmentLine;
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedNode
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedNode
        public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
            Object obj;
            androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData;
            int i2;
            int i5;
            int i6;
            int i3;
            int i;
            int i4;
            if (parentData instanceof RowColumnParentData != null) {
                obj = parentData;
            } else {
                obj = 0;
            }
            if (obj == null) {
                rowColumnParentData = new RowColumnParentData(0, 0, 0, 0, 15, 0);
                obj = rowColumnParentData;
            }
            int i7 = 0;
            AlignmentLineProvider.Value value = new AlignmentLineProvider.Value(this.alignmentLine);
            obj.setCrossAxisAlignment(CrossAxisAlignment.Companion.Relative$foundation_layout_release((AlignmentLineProvider)value));
            return obj;
        }

        @Override // androidx.compose.foundation.layout.SiblingsAlignedNode
        public final void setAlignmentLine(AlignmentLine <set-?>) {
            this.alignmentLine = <set-?>;
        }
    }
    static {
    }

    public SiblingsAlignedNode(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public abstract Object modifyParentData(Density density, Object object2);
}
