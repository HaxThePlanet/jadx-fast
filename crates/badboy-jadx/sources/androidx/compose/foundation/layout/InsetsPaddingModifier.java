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
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u0008\u0012\u0004\u0012\u00020\u00040\u0003B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0096\u0002J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J&\u0010\"\u001a\u00020#*\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*R+\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000c\u0010\r\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u0006R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R+\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0015\u0010\r\u001a\u0004\u0008\u0013\u0010\n\"\u0004\u0008\u0014\u0010\u0006R\u0014\u0010\u0016\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006+", d2 = {"Landroidx/compose/foundation/layout/InsetsPaddingModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "(Landroidx/compose/foundation/layout/WindowInsets;)V", "<set-?>", "consumedInsets", "getConsumedInsets", "()Landroidx/compose/foundation/layout/WindowInsets;", "setConsumedInsets", "consumedInsets$delegate", "Landroidx/compose/runtime/MutableState;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "unconsumedInsets", "getUnconsumedInsets", "setUnconsumedInsets", "unconsumedInsets$delegate", "value", "getValue", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InsetsPaddingModifier implements LayoutModifier, ModifierLocalConsumer, ModifierLocalProvider<androidx.compose.foundation.layout.WindowInsets> {

    public static final int $stable;
    private final MutableState consumedInsets$delegate;
    private final androidx.compose.foundation.layout.WindowInsets insets;
    private final MutableState unconsumedInsets$delegate;
    static {
    }

    public InsetsPaddingModifier(androidx.compose.foundation.layout.WindowInsets insets) {
        super();
        this.insets = insets;
        final int i = 0;
        final int i2 = 2;
        this.unconsumedInsets$delegate = SnapshotStateKt.mutableStateOf$default(this.insets, i, i2, i);
        this.consumedInsets$delegate = SnapshotStateKt.mutableStateOf$default(this.insets, i, i2, i);
    }

    private final androidx.compose.foundation.layout.WindowInsets getConsumedInsets() {
        final int i = 0;
        final int i2 = 0;
        return (WindowInsets)(State)this.consumedInsets$delegate.getValue();
    }

    private final androidx.compose.foundation.layout.WindowInsets getUnconsumedInsets() {
        final int i = 0;
        final int i2 = 0;
        return (WindowInsets)(State)this.unconsumedInsets$delegate.getValue();
    }

    private final void setConsumedInsets(androidx.compose.foundation.layout.WindowInsets <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.consumedInsets$delegate.setValue(<set-?>);
    }

    private final void setUnconsumedInsets(androidx.compose.foundation.layout.WindowInsets <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.unconsumedInsets$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        if (!other instanceof InsetsPaddingModifier) {
            return 0;
        }
        return Intrinsics.areEqual(obj.insets, this.insets);
    }

    public ProvidableModifierLocal<androidx.compose.foundation.layout.WindowInsets> getKey() {
        return WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public androidx.compose.foundation.layout.WindowInsets getValue() {
        return getConsumedInsets();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int hashCode() {
        return this.insets.hashCode();
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final Object obj = constraints;
        int left = getUnconsumedInsets().getLeft((Density)$this$measure_u2d3p2s80s, $this$measure_u2d3p2s80s.getLayoutDirection());
        int top = getUnconsumedInsets().getTop((Density)$this$measure_u2d3p2s80s);
        int i = left + right;
        final int i2 = top + bottom;
        final int i4 = -i2;
        final Placeable measure-BRTryo0 = measurable.measure-BRTryo0(ConstraintsKt.offset-NN6Ew-U(obj, obj1, -i));
        InsetsPaddingModifier.measure.1 anon = new InsetsPaddingModifier.measure.1(measure-BRTryo0, left, top);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, ConstraintsKt.constrainWidth-K40F9xA(obj, obj1), ConstraintsKt.constrainHeight-K40F9xA(obj, obj1), 0, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        final int i = 0;
        Object current = scope.getCurrent((ModifierLocal)WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        setUnconsumedInsets(WindowInsetsKt.exclude(this.insets, (WindowInsets)current));
        setConsumedInsets(WindowInsetsKt.union(current, this.insets));
    }
}
