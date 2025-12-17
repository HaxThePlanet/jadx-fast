package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B6\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0017\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0002\u0010\rJ\u0008\u0010\u0016\u001a\u00020\u0002H\u0016J\u0013\u0010\u0017\u001a\u00020\u00072\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u000c\u0010 \u001a\u00020\u000b*\u00020\nH\u0016R\"\u0010\u0008\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0008\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0012\u0010\u0013R\u0019\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\u0008\u0015\u0010\u0013\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/foundation/layout/OffsetElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/layout/OffsetNode;", "x", "Landroidx/compose/ui/unit/Dp;", "y", "rtlAware", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FFZLkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getInspectorInfo", "()Lkotlin/jvm/functions/Function1;", "getRtlAware", "()Z", "getX-D9Ej5fM", "()F", "F", "getY-D9Ej5fM", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "node", "inspectableProperties", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class OffsetElement extends ModifierNodeElement<androidx.compose.foundation.layout.OffsetNode> {

    private final Function1<InspectorInfo, Unit> inspectorInfo;
    private final boolean rtlAware;
    private final float x;
    private final float y;
    private OffsetElement(float x, float y, boolean rtlAware, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super();
        this.x = x;
        this.y = y;
        this.rtlAware = rtlAware;
        this.inspectorInfo = inspectorInfo;
    }

    public OffsetElement(float f, float f2, boolean z3, Function1 function14, DefaultConstructorMarker defaultConstructorMarker5) {
        super(f, f2, z3, function14);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.layout.OffsetNode create() {
        OffsetNode offsetNode = new OffsetNode(this.x, this.y, this.rtlAware, 0);
        return offsetNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        Object obj;
        boolean rtlAware;
        float rtlAware2;
        if (this == other) {
            return 1;
        }
        if (other instanceof OffsetElement) {
            obj = other;
        } else {
            obj = 0;
        }
        final int i2 = 0;
        if (obj == null) {
            return i2;
        }
        if (Dp.equals-impl0(this.x, obj.x) && Dp.equals-impl0(this.y, obj.y) && this.rtlAware == obj.rtlAware) {
            if (Dp.equals-impl0(this.y, obj.y)) {
                if (this.rtlAware == obj.rtlAware) {
                } else {
                    i = i2;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final Function1<InspectorInfo, Unit> getInspectorInfo() {
        return this.inspectorInfo;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final boolean getRtlAware() {
        return this.rtlAware;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getX-D9Ej5fM() {
        return this.x;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final float getY-D9Ej5fM() {
        return this.y;
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
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("OffsetModifierElement(x=").append(Dp.toString-impl(this.x)).append(", y=").append(Dp.toString-impl(this.y)).append(", rtlAware=").append(this.rtlAware).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.layout.OffsetNode node) {
        node.setX-0680j_4(this.x);
        node.setY-0680j_4(this.y);
        node.setRtlAware(this.rtlAware);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((OffsetNode)node);
    }
}
