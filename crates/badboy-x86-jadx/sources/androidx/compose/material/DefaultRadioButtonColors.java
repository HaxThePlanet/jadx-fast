package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\u0008\u0010\u000c\u001a\u00020\rH\u0016J#\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0017¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/material/DefaultRadioButtonColors;", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "(JJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "radioColor", "Landroidx/compose/runtime/State;", "enabled", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultRadioButtonColors implements androidx.compose.material.RadioButtonColors {

    private final long disabledColor;
    private final long selectedColor;
    private final long unselectedColor;
    private DefaultRadioButtonColors(long selectedColor, long unselectedColor, long disabledColor) {
        super();
        this.selectedColor = selectedColor;
        this.unselectedColor = disabledColor;
        this.disabledColor = obj5;
    }

    public DefaultRadioButtonColors(long l, long l2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, l3, defaultConstructorMarker4, obj5, obj6);
    }

    @Override // androidx.compose.material.RadioButtonColors
    public boolean equals(Object other) {
        Class class2;
        Class class;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            class = other.getClass();
            if (getClass() != class) {
            } else {
                Object obj = other;
                if (!Color.equals-impl0(this.selectedColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unselectedColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledColor, class)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.RadioButtonColors
    public int hashCode() {
        return result += i6;
    }

    public State<Color> radioColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long unselectedColor;
        int tween$default;
        boolean traceInProgress;
        String str;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i4;
        int i;
        Composer $composer2;
        int i2;
        int i3;
        State obj13;
        int i5 = 1243421834;
        $composer.startReplaceGroup(i5);
        ComposerKt.sourceInformation($composer, "C(radioColor):RadioButton.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material.DefaultRadioButtonColors.radioColor (RadioButton.kt:186)");
        }
        unselectedColor = !enabled ? this.disabledColor : !selected ? this.unselectedColor : this.selectedColor;
        long l = unselectedColor;
        tween$default = 0;
        if (enabled) {
            $composer.startReplaceGroup(1872507307);
            ComposerKt.sourceInformation($composer, "196@7636L75");
            i4 = 0;
            $composer2 = $composer;
            obj13 = SingleValueAnimationKt.animateColorAsState-euL9pac(l, obj3, (AnimationSpec)AnimationSpecKt.tween$default(100, tween$default, i4, 6, i4), i4, 0, $composer2, 48);
            $composer2.endReplaceGroup();
        } else {
            $composer2 = $composer;
            $composer2.startReplaceGroup(1872610010);
            ComposerKt.sourceInformation($composer2, "198@7741L28");
            obj13 = SnapshotStateKt.rememberUpdatedState(Color.box-impl(l), $composer2, tween$default);
            $composer2.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer2.endReplaceGroup();
        return obj13;
    }
}
