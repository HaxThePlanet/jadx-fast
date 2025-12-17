package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003BE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0008\n\u0012\u001d\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0002\u0008\n¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u000eH\u0016J\u0010\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J&\u0010 \u001a\u00020!*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0016ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(R%\u0010\u000b\u001a\u0019\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\u000c¢\u0006\u0002\u0008\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00058B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0016\u0010\u0017\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006)", d2 = {"Landroidx/compose/foundation/layout/DerivedHeightModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "heightCalc", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "", "(Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "<set-?>", "unconsumedInsets", "getUnconsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setUnconsumedInsets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "unconsumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "equals", "", "other", "", "hashCode", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DerivedHeightModifier extends InspectorValueInfo implements LayoutModifier, ModifierLocalConsumer {

    private final Function2<androidx.compose.foundation.layout.WindowInsets, Density, Integer> heightCalc;
    private final androidx.compose.foundation.layout.WindowInsets insets;
    private final MutableState unconsumedInsets$delegate;
    public DerivedHeightModifier(androidx.compose.foundation.layout.WindowInsets insets, Function1<? super InspectorInfo, Unit> inspectorInfo, Function2<? super androidx.compose.foundation.layout.WindowInsets, ? super Density, Integer> heightCalc) {
        super(inspectorInfo);
        this.insets = insets;
        this.heightCalc = heightCalc;
        final int i = 0;
        this.unconsumedInsets$delegate = SnapshotStateKt.mutableStateOf$default(this.insets, i, 2, i);
    }

    private final androidx.compose.foundation.layout.WindowInsets getUnconsumedInsets() {
        final int i = 0;
        final int i2 = 0;
        return (WindowInsets)(State)this.unconsumedInsets$delegate.getValue();
    }

    private final void setUnconsumedInsets(androidx.compose.foundation.layout.WindowInsets <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.unconsumedInsets$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.platform.InspectorValueInfo
    public boolean equals(Object other) {
        int i;
        boolean heightCalc2;
        Object heightCalc;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof DerivedHeightModifier) {
            return i2;
        }
        if (Intrinsics.areEqual(this.insets, obj.insets) && this.heightCalc == obj2.heightCalc) {
            if (this.heightCalc == obj2.heightCalc) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.ui.platform.InspectorValueInfo
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.platform.InspectorValueInfo
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        int intValue = (Number)this.heightCalc.invoke(getUnconsumedInsets(), $this$measure_u2d3p2s80s).intValue();
        if (intValue == 0) {
            Object obj4 = $this$measure_u2d3p2s80s;
            Object obj = obj4;
            return MeasureScope.layout$default(obj4, 0, 0, 0, (Function1)DerivedHeightModifier.measure.1.INSTANCE, 4, 0);
        }
        int i5 = intValue;
        Object obj2 = constraints;
        Object obj5 = obj2;
        Placeable obj12 = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(obj2, obj2, 0, 0, i5, i5, 3));
        DerivedHeightModifier.measure.2 anon = new DerivedHeightModifier.measure.2(obj12);
        int i = i5;
        int i6 = i;
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, obj12.getWidth(), i, 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.platform.InspectorValueInfo
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        final int i = 0;
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, (WindowInsets)scope.getCurrent((ModifierLocal)WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets())));
    }
}
