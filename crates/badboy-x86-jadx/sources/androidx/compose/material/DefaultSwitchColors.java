package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J#\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000cR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/material/DefaultSwitchColors;", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "thumbColor", "Landroidx/compose/runtime/State;", "enabled", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSwitchColors implements androidx.compose.material.SwitchColors {

    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;
    private DefaultSwitchColors(long checkedThumbColor, long checkedTrackColor, long uncheckedThumbColor, long uncheckedTrackColor, long disabledCheckedThumbColor, long disabledCheckedTrackColor, long disabledUncheckedThumbColor, long disabledUncheckedTrackColor) {
        super();
        this.checkedThumbColor = checkedThumbColor;
        this.checkedTrackColor = uncheckedThumbColor;
        this.uncheckedThumbColor = disabledCheckedThumbColor;
        this.uncheckedTrackColor = disabledUncheckedThumbColor;
        this.disabledCheckedThumbColor = obj23;
        this.disabledCheckedTrackColor = obj25;
        this.disabledUncheckedThumbColor = obj27;
        this.disabledUncheckedTrackColor = obj29;
    }

    public DefaultSwitchColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, DefaultConstructorMarker defaultConstructorMarker9) {
        super(l, l2, l3, l4, l5, l6, l7, l8, defaultConstructorMarker9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // androidx.compose.material.SwitchColors
    public boolean equals(Object other) {
        Class class;
        Class class2;
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (other != null) {
            class2 = other.getClass();
            if (getClass() != class2) {
            } else {
                Object obj = other;
                if (!Color.equals-impl0(this.checkedThumbColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.checkedTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedThumbColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.uncheckedTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedThumbColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledCheckedTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedThumbColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledUncheckedTrackColor, class2)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.SwitchColors
    public int hashCode() {
        return result6 += i16;
    }

    public State<Color> thumbColor(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long disabledCheckedThumbColor;
        boolean traceInProgress;
        String str;
        int i = -66424183;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(thumbColor)P(1)372@15413L253:Switch.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSwitchColors.thumbColor (Switch.kt:371)");
        }
        if (enabled) {
            disabledCheckedThumbColor = checked ? this.checkedThumbColor : this.uncheckedThumbColor;
        } else {
            disabledCheckedThumbColor = checked ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledCheckedThumbColor), $composer, 0);
    }

    public State<Color> trackColor(boolean enabled, boolean checked, Composer $composer, int $changed) {
        long disabledCheckedTrackColor;
        boolean traceInProgress;
        String str;
        int i = -1176343362;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(trackColor)P(1)383@15785L253:Switch.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSwitchColors.trackColor (Switch.kt:382)");
        }
        if (enabled) {
            disabledCheckedTrackColor = checked ? this.checkedTrackColor : this.uncheckedTrackColor;
        } else {
            disabledCheckedTrackColor = checked ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledCheckedTrackColor), $composer, 0);
    }
}
