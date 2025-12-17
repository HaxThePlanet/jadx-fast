package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001BN\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000e¢\u0006\u0002\u0010\u000fJ\u0008\u0010\u0011\u001a\u00020\u0002H\u0016J\u0013\u0010\u0012\u001a\u00020\t2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u000c\u0010\u0019\u001a\u00020\r*\u00020\u000cH\u0016R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u000c\u0012\u0004\u0012\u00020\r0\u000b¢\u0006\u0002\u0008\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/layout/SizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/SizeNode;", "minWidth", "Landroidx/compose/ui/unit/Dp;", "minHeight", "maxWidth", "maxHeight", "enforceIncoming", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFFFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "create", "equals", "other", "", "hashCode", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SizeElement extends ModifierNodeElement<androidx.compose.foundation.layout.SizeNode> {

    private final boolean enforceIncoming;
    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final float maxHeight;
    private final float maxWidth;
    private final float minHeight;
    private final float minWidth;
    private SizeElement(float minWidth, float minHeight, float maxWidth, float maxHeight, boolean enforceIncoming, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super();
        this.minWidth = minWidth;
        this.minHeight = minHeight;
        this.maxWidth = maxWidth;
        this.maxHeight = maxHeight;
        this.enforceIncoming = enforceIncoming;
        this.inspectorInfo = inspectorInfo;
    }

    public SizeElement(float f, float f2, float f3, float f4, boolean z5, Function1 function16, int i7, DefaultConstructorMarker defaultConstructorMarker8) {
        float f5;
        float f8;
        float f6;
        float f7;
        float obj9;
        float obj10;
        float obj11;
        float obj12;
        if (i7 & 1 != 0) {
            f5 = obj9;
        } else {
            f5 = f;
        }
        if (i7 & 2 != 0) {
            f8 = obj10;
        } else {
            f8 = f2;
        }
        if (i7 & 4 != 0) {
            f6 = obj11;
        } else {
            f6 = f3;
        }
        if (i7 & 8 != 0) {
            f7 = obj12;
        } else {
            f7 = f4;
        }
        super(f5, f8, f6, f7, z5, function16, 0);
    }

    public SizeElement(float f, float f2, float f3, float f4, boolean z5, Function1 function16, DefaultConstructorMarker defaultConstructorMarker7) {
        super(f, f2, f3, f4, z5, function16);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.SizeNode create() {
        SizeNode sizeNode = new SizeNode(this.minWidth, this.minHeight, this.maxWidth, this.maxHeight, this.enforceIncoming, 0);
        return sizeNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof SizeElement) {
            return i2;
        }
        if (!Dp.equals-impl0(this.minWidth, obj.minWidth)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.minHeight, obj2.minHeight)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.maxWidth, obj3.maxWidth)) {
            return i2;
        }
        if (!Dp.equals-impl0(this.maxHeight, obj4.maxHeight)) {
            return i2;
        }
        if (this.enforceIncoming != obj5.enforceIncoming) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return result2 += i10;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        this.inspectorInfo.invoke($this$inspectableProperties);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.SizeNode node) {
        node.setMinWidth-0680j_4(this.minWidth);
        node.setMinHeight-0680j_4(this.minHeight);
        node.setMaxWidth-0680j_4(this.maxWidth);
        node.setMaxHeight-0680j_4(this.maxHeight);
        node.setEnforceIncoming(this.enforceIncoming);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((SizeNode)node);
    }
}
