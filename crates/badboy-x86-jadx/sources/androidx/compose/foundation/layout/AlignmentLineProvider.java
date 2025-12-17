package androidx.compose.foundation.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measured;
import androidx.compose.ui.layout.Placeable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001:\u0002\u0007\u0008B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&\u0082\u0001\u0002\t\n¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/layout/AlignmentLineProvider;", "", "()V", "calculateAlignmentLinePosition", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "Block", "Value", "Landroidx/compose/foundation/layout/AlignmentLineProvider$Block;", "Landroidx/compose/foundation/layout/AlignmentLineProvider$Value;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class AlignmentLineProvider {

    public static final int $stable;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0015\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/layout/AlignmentLineProvider$Block;", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "lineProviderBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Measured;", "", "(Lkotlin/jvm/functions/Function1;)V", "getLineProviderBlock", "()Lkotlin/jvm/functions/Function1;", "calculateAlignmentLinePosition", "placeable", "Landroidx/compose/ui/layout/Placeable;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Block extends androidx.compose.foundation.layout.AlignmentLineProvider {

        public static final int $stable;
        private final Function1<Measured, Integer> lineProviderBlock;
        static {
        }

        public Block(Function1<? super Measured, Integer> lineProviderBlock) {
            super(0);
            this.lineProviderBlock = lineProviderBlock;
        }

        public static androidx.compose.foundation.layout.AlignmentLineProvider.Block copy$default(androidx.compose.foundation.layout.AlignmentLineProvider.Block alignmentLineProvider$Block, Function1 function12, int i3, Object object4) {
            Function1 obj1;
            if (i3 &= 1 != 0) {
                obj1 = block.lineProviderBlock;
            }
            return block.copy(obj1);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(Placeable placeable) {
            return (Number)this.lineProviderBlock.invoke(placeable).intValue();
        }

        public final Function1<Measured, Integer> component1() {
            return this.lineProviderBlock;
        }

        public final androidx.compose.foundation.layout.AlignmentLineProvider.Block copy(Function1<? super Measured, Integer> function1) {
            AlignmentLineProvider.Block block = new AlignmentLineProvider.Block(function1);
            return block;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AlignmentLineProvider.Block) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.lineProviderBlock, obj.lineProviderBlock)) {
                return i2;
            }
            return i;
        }

        public final Function1<Measured, Integer> getLineProviderBlock() {
            return this.lineProviderBlock;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int hashCode() {
            return this.lineProviderBlock.hashCode();
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Block(lineProviderBlock=").append(this.lineProviderBlock).append(')').toString();
        }
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0008HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/layout/AlignmentLineProvider$Value;", "Landroidx/compose/foundation/layout/AlignmentLineProvider;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "(Landroidx/compose/ui/layout/AlignmentLine;)V", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "calculateAlignmentLinePosition", "", "placeable", "Landroidx/compose/ui/layout/Placeable;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Value extends androidx.compose.foundation.layout.AlignmentLineProvider {

        public static final int $stable;
        private final AlignmentLine alignmentLine;
        static {
        }

        public Value(AlignmentLine alignmentLine) {
            super(0);
            this.alignmentLine = alignmentLine;
        }

        public static androidx.compose.foundation.layout.AlignmentLineProvider.Value copy$default(androidx.compose.foundation.layout.AlignmentLineProvider.Value alignmentLineProvider$Value, AlignmentLine alignmentLine2, int i3, Object object4) {
            AlignmentLine obj1;
            if (i3 &= 1 != 0) {
                obj1 = value.alignmentLine;
            }
            return value.copy(obj1);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int calculateAlignmentLinePosition(Placeable placeable) {
            return placeable.get(this.alignmentLine);
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public final AlignmentLine component1() {
            return this.alignmentLine;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public final androidx.compose.foundation.layout.AlignmentLineProvider.Value copy(AlignmentLine alignmentLine) {
            AlignmentLineProvider.Value value = new AlignmentLineProvider.Value(alignmentLine);
            return value;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof AlignmentLineProvider.Value) {
                return i2;
            }
            if (!Intrinsics.areEqual(this.alignmentLine, obj.alignmentLine)) {
                return i2;
            }
            return i;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public final AlignmentLine getAlignmentLine() {
            return this.alignmentLine;
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public int hashCode() {
            return this.alignmentLine.hashCode();
        }

        @Override // androidx.compose.foundation.layout.AlignmentLineProvider
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Value(alignmentLine=").append(this.alignmentLine).append(')').toString();
        }
    }
    static {
    }

    public AlignmentLineProvider(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract int calculateAlignmentLinePosition(Placeable placeable);
}
