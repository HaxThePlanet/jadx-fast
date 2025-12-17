package androidx.compose.foundation.lazy;

import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\u0008\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0010\u0008\u0002\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0013\u001a\u00020\u0002H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\u0008\u0010\u0018\u001a\u00020\u0007H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u000c\u0010\u001c\u001a\u00020\u001a*\u00020\u001dH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0008\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000f¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/lazy/ParentSizeElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/foundation/lazy/ParentSizeNode;", "fraction", "", "widthState", "Landroidx/compose/runtime/State;", "", "heightState", "inspectorName", "", "(FLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Ljava/lang/String;)V", "getFraction", "()F", "getHeightState", "()Landroidx/compose/runtime/State;", "getInspectorName", "()Ljava/lang/String;", "getWidthState", "create", "equals", "", "other", "", "hashCode", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ParentSizeElement extends ModifierNodeElement<androidx.compose.foundation.lazy.ParentSizeNode> {

    private final float fraction;
    private final State<Integer> heightState;
    private final String inspectorName;
    private final State<Integer> widthState;
    public ParentSizeElement(float fraction, State<Integer> widthState, State<Integer> heightState, String inspectorName) {
        super();
        this.fraction = fraction;
        this.widthState = widthState;
        this.heightState = heightState;
        this.inspectorName = inspectorName;
    }

    public ParentSizeElement(float f, State state2, State state3, String string4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj3;
        int obj4;
        final int i = 0;
        obj3 = i5 & 2 != 0 ? i : obj3;
        obj4 = i5 &= 4 != 0 ? i : obj4;
        super(f, obj3, obj4, string4);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.foundation.lazy.ParentSizeNode create() {
        ParentSizeNode parentSizeNode = new ParentSizeNode(this.fraction, this.widthState, this.heightState);
        return parentSizeNode;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object other) {
        int i;
        int equal;
        float heightState;
        i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof ParentSizeElement) {
            return i2;
        }
        equal = Float.compare(fraction, heightState) == 0 ? i : i2;
        if (equal != 0 && Intrinsics.areEqual(this.widthState, obj2.widthState) && Intrinsics.areEqual(this.heightState, obj3.heightState)) {
            if (Intrinsics.areEqual(this.widthState, obj2.widthState)) {
                if (Intrinsics.areEqual(this.heightState, obj3.heightState)) {
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
    public final float getFraction() {
        return this.fraction;
    }

    public final State<Integer> getHeightState() {
        return this.heightState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public final String getInspectorName() {
        return this.inspectorName;
    }

    public final State<Integer> getWidthState() {
        return this.widthState;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        int i;
        int i2;
        State widthState = this.widthState;
        if (widthState != null) {
            i = widthState.hashCode();
        } else {
            i = i2;
        }
        final State heightState = this.heightState;
        if (heightState != null) {
            i2 = heightState.hashCode();
        }
        return result += i4;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName(this.inspectorName);
        $this$inspectableProperties.setValue(Float.valueOf(this.fraction));
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.foundation.lazy.ParentSizeNode node) {
        node.setFraction(this.fraction);
        node.setWidthState(this.widthState);
        node.setHeightState(this.heightState);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ParentSizeNode)node);
    }
}
