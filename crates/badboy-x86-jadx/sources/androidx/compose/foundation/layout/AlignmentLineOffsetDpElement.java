package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0002\u0010\rJ\u0008\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u000c\u0010\u001f\u001a\u00020\u000b*\u00020\nH\u0016R\u0019\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u0013\u0010\u000fR\"\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006 ", d2 = {"Landroidx/compose/foundation/layout/AlignmentLineOffsetDpElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/AlignmentLineOffsetDpNode;", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "before", "Landroidx/compose/ui/unit/Dp;", "after", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/layout/AlignmentLine;FFLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfter-D9Ej5fM", "()F", "F", "getAlignmentLine", "()Landroidx/compose/ui/layout/AlignmentLine;", "getBefore-D9Ej5fM", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "create", "equals", "", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class AlignmentLineOffsetDpElement extends ModifierNodeElement<androidx.compose.foundation.layout.AlignmentLineOffsetDpNode> {

    private final float after;
    private final AlignmentLine alignmentLine;
    private final float before;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float before, float after, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        int i;
        int cmp;
        int unspecified-D9Ej5fM;
        float unspecified-D9Ej5fM2;
        super();
        this.alignmentLine = alignmentLine;
        this.before = before;
        this.after = after;
        this.inspectorInfo = inspectorInfo;
        unspecified-D9Ej5fM = 0;
        if (Float.compare(before2, unspecified-D9Ej5fM) < 0) {
            if (Dp.equals-impl0(this.before, Dp.Companion.getUnspecified-D9Ej5fM())) {
                if (Float.compare(after2, unspecified-D9Ej5fM) < 0) {
                    if (Dp.equals-impl0(this.after, Dp.Companion.getUnspecified-D9Ej5fM())) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Padding from alignment line must be a non-negative number".toString());
        throw illegalArgumentException;
    }

    public AlignmentLineOffsetDpElement(AlignmentLine alignmentLine, float f2, float f3, Function1 function14, DefaultConstructorMarker defaultConstructorMarker5) {
        super(alignmentLine, f2, f3, function14);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.AlignmentLineOffsetDpNode create() {
        AlignmentLineOffsetDpNode alignmentLineOffsetDpNode = new AlignmentLineOffsetDpNode(this.alignmentLine, this.before, this.after, 0);
        return alignmentLineOffsetDpNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        Object obj;
        boolean equal;
        AlignmentLine alignmentLine;
        if (this == other) {
            return 1;
        }
        if (other instanceof AlignmentLineOffsetDpElement) {
            obj = other;
        } else {
            obj = 0;
        }
        final int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (Intrinsics.areEqual(this.alignmentLine, obj.alignmentLine) && Dp.equals-impl0(this.before, obj.before) && Dp.equals-impl0(this.after, obj.after)) {
            if (Dp.equals-impl0(this.before, obj.before)) {
                if (Dp.equals-impl0(this.after, obj.after)) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getAfter-D9Ej5fM() {
        return this.after;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final AlignmentLine getAlignmentLine() {
        return this.alignmentLine;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getBefore-D9Ej5fM() {
        return this.before;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return result += i6;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.AlignmentLineOffsetDpNode node) {
        node.setAlignmentLine(this.alignmentLine);
        node.setBefore-0680j_4(this.before);
        node.setAfter-0680j_4(this.after);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((AlignmentLineOffsetDpNode)node);
    }
}
