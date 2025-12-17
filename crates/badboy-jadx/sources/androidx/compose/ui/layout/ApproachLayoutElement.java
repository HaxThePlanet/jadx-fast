package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.ValueElementSequence;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0082\u0008\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u008c\u0001\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0004¢\u0006\u0002\u0008\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012.\u0008\u0002\u0010\u0012\u001a(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\r¢\u0006\u0002\u0010\u0017JD\u0010\u001c\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0004¢\u0006\u0002\u0008\rHÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fHÆ\u0003J/\u0010\u001e\u001a(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\rHÆ\u0003J\u0094\u0001\u0010\u001f\u001a\u00020\u00002C\u0008\u0002\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0004¢\u0006\u0002\u0008\r2\u0014\u0008\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2.\u0008\u0002\u0010\u0012\u001a(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\rHÆ\u0001J\u0008\u0010 \u001a\u00020\u0002H\u0016J\u0013\u0010!\u001a\u00020\u00112\u0008\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u000c\u0010+\u001a\u00020)*\u00020,H\u0016RL\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0004¢\u0006\u0002\u0008\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u001aR7\u0010\u0012\u001a(\u0012\u0004\u0012\u00020\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u0016\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\r¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u001b¨\u0006-", d2 = {"Landroidx/compose/ui/layout/ApproachLayoutElement;", "Landroidx/compose/ui/node/ModifierNodeElement;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "approachMeasure", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "isMeasurementApproachInProgress", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "lookaheadCoordinates", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getApproachMeasure", "()Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function2;", "component1", "component2", "component3", "copy", "create", "equals", "other", "", "hashCode", "", "toString", "", "update", "", "node", "inspectableProperties", "Landroidx/compose/ui/platform/InspectorInfo;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ApproachLayoutElement extends ModifierNodeElement<androidx.compose.ui.layout.ApproachLayoutModifierNodeImpl> {

    private final Function3<androidx.compose.ui.layout.ApproachMeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> approachMeasure;
    private final Function1<IntSize, Boolean> isMeasurementApproachInProgress;
    private final Function2<androidx.compose.ui.layout.Placeable.PlacementScope, androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress;
    public ApproachLayoutElement(Function3<? super androidx.compose.ui.layout.ApproachMeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> approachMeasure, Function1<? super IntSize, Boolean> isMeasurementApproachInProgress, Function2<? super androidx.compose.ui.layout.Placeable.PlacementScope, ? super androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress) {
        super();
        this.approachMeasure = approachMeasure;
        this.isMeasurementApproachInProgress = isMeasurementApproachInProgress;
        this.isPlacementApproachInProgress = isPlacementApproachInProgress;
    }

    public ApproachLayoutElement(Function3 function3, Function1 function12, Function2 function23, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        Function2 obj3;
        if (i4 &= 4 != 0) {
            obj3 = LookaheadScopeKt.access$getDefaultPlacementApproachInProgress$p();
        }
        super(function3, function12, obj3);
    }

    public static androidx.compose.ui.layout.ApproachLayoutElement copy$default(androidx.compose.ui.layout.ApproachLayoutElement approachLayoutElement, Function3 function32, Function1 function13, Function2 function24, int i5, Object object6) {
        Function3 obj1;
        Function1 obj2;
        Function2 obj3;
        if (i5 & 1 != 0) {
            obj1 = approachLayoutElement.approachMeasure;
        }
        if (i5 & 2 != 0) {
            obj2 = approachLayoutElement.isMeasurementApproachInProgress;
        }
        if (i5 &= 4 != 0) {
            obj3 = approachLayoutElement.isPlacementApproachInProgress;
        }
        return approachLayoutElement.copy(obj1, obj2, obj3);
    }

    public final Function3<androidx.compose.ui.layout.ApproachMeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> component1() {
        return this.approachMeasure;
    }

    public final Function1<IntSize, Boolean> component2() {
        return this.isMeasurementApproachInProgress;
    }

    public final Function2<androidx.compose.ui.layout.Placeable.PlacementScope, androidx.compose.ui.layout.LayoutCoordinates, Boolean> component3() {
        return this.isPlacementApproachInProgress;
    }

    public final androidx.compose.ui.layout.ApproachLayoutElement copy(Function3<? super androidx.compose.ui.layout.ApproachMeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> function3, Function1<? super IntSize, Boolean> function12, Function2<? super androidx.compose.ui.layout.Placeable.PlacementScope, ? super androidx.compose.ui.layout.LayoutCoordinates, Boolean> function23) {
        ApproachLayoutElement approachLayoutElement = new ApproachLayoutElement(function3, function12, function23);
        return approachLayoutElement;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public Modifier.Node create() {
        return (Modifier.Node)create();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public androidx.compose.ui.layout.ApproachLayoutModifierNodeImpl create() {
        ApproachLayoutModifierNodeImpl approachLayoutModifierNodeImpl = new ApproachLayoutModifierNodeImpl(this.approachMeasure, this.isMeasurementApproachInProgress, this.isPlacementApproachInProgress);
        return approachLayoutModifierNodeImpl;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ApproachLayoutElement) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.approachMeasure, obj.approachMeasure)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.isMeasurementApproachInProgress, obj.isMeasurementApproachInProgress)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.isPlacementApproachInProgress, obj.isPlacementApproachInProgress)) {
            return i2;
        }
        return i;
    }

    public final Function3<androidx.compose.ui.layout.ApproachMeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> getApproachMeasure() {
        return this.approachMeasure;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public int hashCode() {
        return i2 += i7;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo $this$inspectableProperties) {
        $this$inspectableProperties.setName("approachLayout");
        $this$inspectableProperties.getProperties().set("approachMeasure", this.approachMeasure);
        $this$inspectableProperties.getProperties().set("isMeasurementApproachInProgress", this.isMeasurementApproachInProgress);
        $this$inspectableProperties.getProperties().set("isPlacementApproachInProgress", this.isPlacementApproachInProgress);
    }

    public final Function1<IntSize, Boolean> isMeasurementApproachInProgress() {
        return this.isMeasurementApproachInProgress;
    }

    public final Function2<androidx.compose.ui.layout.Placeable.PlacementScope, androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress() {
        return this.isPlacementApproachInProgress;
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ApproachLayoutElement(approachMeasure=").append(this.approachMeasure).append(", isMeasurementApproachInProgress=").append(this.isMeasurementApproachInProgress).append(", isPlacementApproachInProgress=").append(this.isPlacementApproachInProgress).append(')').toString();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(Modifier.Node node) {
        update((ApproachLayoutModifierNodeImpl)node);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void update(androidx.compose.ui.layout.ApproachLayoutModifierNodeImpl node) {
        node.setMeasureBlock(this.approachMeasure);
        node.setMeasurementApproachInProgress(this.isMeasurementApproachInProgress);
        node.setPlacementApproachInProgress(this.isPlacementApproachInProgress);
    }
}
