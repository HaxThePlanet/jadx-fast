package androidx.compose.ui.layout;

import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0013\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u0002B{\u0012A\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0004¢\u0006\u0002\u0008\r\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f\u0012\u001d\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\r¢\u0006\u0002\u0010\u0016J\u001a\u0010\u000e\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#J&\u0010$\u001a\u00020\u000c*\u00020\u00052\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&J\u0014\u0010\u0012\u001a\u00020\u0011*\u00020\u00142\u0006\u0010'\u001a\u00020\u0015H\u0016R&\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R1\u0010\u0012\u001a\u0019\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00110\u0013¢\u0006\u0002\u0008\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cRU\u0010\u0003\u001a=\u0012\u0004\u0012\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\n¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u000c0\u0004¢\u0006\u0002\u0008\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 \u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006(", d2 = {"Landroidx/compose/ui/layout/ApproachLayoutModifierNodeImpl;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "measureBlock", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/ApproachMeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", "name", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "isMeasurementApproachInProgress", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "", "isPlacementApproachInProgress", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "()Lkotlin/jvm/functions/Function1;", "setMeasurementApproachInProgress", "(Lkotlin/jvm/functions/Function1;)V", "()Lkotlin/jvm/functions/Function2;", "setPlacementApproachInProgress", "(Lkotlin/jvm/functions/Function2;)V", "getMeasureBlock", "()Lkotlin/jvm/functions/Function3;", "setMeasureBlock", "(Lkotlin/jvm/functions/Function3;)V", "lookaheadSize", "isMeasurementApproachInProgress-ozmzZPI", "(J)Z", "approachMeasure", "approachMeasure-3p2s80s", "(Landroidx/compose/ui/layout/ApproachMeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "lookaheadCoordinates", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ApproachLayoutModifierNodeImpl extends Modifier.Node implements androidx.compose.ui.layout.ApproachLayoutModifierNode {

    private Function1<? super IntSize, Boolean> isMeasurementApproachInProgress;
    private Function2<? super androidx.compose.ui.layout.Placeable.PlacementScope, ? super androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress;
    private Function3<? super androidx.compose.ui.layout.ApproachMeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measureBlock;
    public ApproachLayoutModifierNodeImpl(Function3<? super androidx.compose.ui.layout.ApproachMeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> measureBlock, Function1<? super IntSize, Boolean> isMeasurementApproachInProgress, Function2<? super androidx.compose.ui.layout.Placeable.PlacementScope, ? super androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress) {
        super();
        this.measureBlock = measureBlock;
        this.isMeasurementApproachInProgress = isMeasurementApproachInProgress;
        this.isPlacementApproachInProgress = isPlacementApproachInProgress;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public androidx.compose.ui.layout.MeasureResult approachMeasure-3p2s80s(androidx.compose.ui.layout.ApproachMeasureScope $this$approachMeasure_u2d3p2s80s, androidx.compose.ui.layout.Measurable measurable, long constraints) {
        return (MeasureResult)this.measureBlock.invoke($this$approachMeasure_u2d3p2s80s, measurable, Constraints.box-impl(constraints));
    }

    public final Function3<androidx.compose.ui.layout.ApproachMeasureScope, androidx.compose.ui.layout.Measurable, Constraints, androidx.compose.ui.layout.MeasureResult> getMeasureBlock() {
        return this.measureBlock;
    }

    public final Function1<IntSize, Boolean> isMeasurementApproachInProgress() {
        return this.isMeasurementApproachInProgress;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean isMeasurementApproachInProgress-ozmzZPI(long lookaheadSize) {
        return (Boolean)this.isMeasurementApproachInProgress.invoke(IntSize.box-impl(lookaheadSize)).booleanValue();
    }

    public final Function2<androidx.compose.ui.layout.Placeable.PlacementScope, androidx.compose.ui.layout.LayoutCoordinates, Boolean> isPlacementApproachInProgress() {
        return this.isPlacementApproachInProgress;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public boolean isPlacementApproachInProgress(androidx.compose.ui.layout.Placeable.PlacementScope $this$isPlacementApproachInProgress, androidx.compose.ui.layout.LayoutCoordinates lookaheadCoordinates) {
        return (Boolean)this.isPlacementApproachInProgress.invoke($this$isPlacementApproachInProgress, lookaheadCoordinates).booleanValue();
    }

    public final void setMeasureBlock(Function3<? super androidx.compose.ui.layout.ApproachMeasureScope, ? super androidx.compose.ui.layout.Measurable, ? super Constraints, ? extends androidx.compose.ui.layout.MeasureResult> <set-?>) {
        this.measureBlock = <set-?>;
    }

    public final void setMeasurementApproachInProgress(Function1<? super IntSize, Boolean> <set-?>) {
        this.isMeasurementApproachInProgress = <set-?>;
    }

    public final void setPlacementApproachInProgress(Function2<? super androidx.compose.ui.layout.Placeable.PlacementScope, ? super androidx.compose.ui.layout.LayoutCoordinates, Boolean> <set-?>) {
        this.isPlacementApproachInProgress = <set-?>;
    }
}
