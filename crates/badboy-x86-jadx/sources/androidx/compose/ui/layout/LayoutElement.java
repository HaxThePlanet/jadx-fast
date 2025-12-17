package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Constraints;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B*\u0012#\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\t¢\u0006\u0002\u0010\nJ&\u0010\r\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\tHÆ\u0003J0\u0010\u000e\u001a\u00020\u00002%\u0008\u0002\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\tHÆ\u0001J\u0008\u0010\u000f\u001a\u00020\u0002H\u0016J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0002H\u0016J\u000c\u0010\u001b\u001a\u00020\u0019*\u00020\u001cH\u0016R.\u0010\u0003\u001a\u001f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u001d", d2 = {"Landroidx/compose/ui/layout/LayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/LayoutModifierImpl;", "measure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function3;)V", "getMeasure", "()Lkotlin/jvm/functions/Function3;", "component1", "copy", "create", "equals", "", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LayoutElement extends ModifierNodeElement<androidx.compose.ui.layout.LayoutModifierImpl> {

    private final Function3<androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> measure;
    public LayoutElement(Function3<? super androidx.compose.ui.layout.MeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measure) {
        super();
        this.measure = measure;
    }

    public static androidx.compose.ui.layout.LayoutElement copy$default(androidx.compose.ui.layout.LayoutElement layoutElement, Function3 function32, int i3, Object object4) {
        Function3 obj1;
        if (i3 &= 1 != 0) {
            obj1 = layoutElement.measure;
        }
        return layoutElement.copy(obj1);
    }

    public final Function3<androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> component1() {
        return this.measure;
    }

    public final androidx.compose.ui.layout.LayoutElement copy(Function3<? super androidx.compose.ui.layout.MeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> function3) {
        LayoutElement layoutElement = new LayoutElement(function3);
        return layoutElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.layout.LayoutModifierImpl create() {
        LayoutModifierImpl layoutModifierImpl = new LayoutModifierImpl(this.measure);
        return layoutModifierImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LayoutElement) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.measure, obj.measure)) {
            return i2;
        }
        return i;
    }

    public final Function3<androidx.compose.ui.layout.MeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> getMeasure() {
        return this.measure;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return this.measure.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("layout");
        $this$inspectableProperties.getProperties().set("measure", this.measure);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LayoutElement(measure=").append(this.measure).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((LayoutModifierImpl)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.layout.LayoutModifierImpl node) {
        node.setMeasureBlock(this.measure);
    }
}
