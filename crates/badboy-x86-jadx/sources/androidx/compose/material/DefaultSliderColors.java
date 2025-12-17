package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0003\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u001b\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u001aJ#\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u001aR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u000c\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u000e\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/material/DefaultSliderColors;", "Landroidx/compose/material/SliderColors;", "thumbColor", "Landroidx/compose/ui/graphics/Color;", "disabledThumbColor", "activeTrackColor", "inactiveTrackColor", "disabledActiveTrackColor", "disabledInactiveTrackColor", "activeTickColor", "inactiveTickColor", "disabledActiveTickColor", "disabledInactiveTickColor", "(JJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "Landroidx/compose/runtime/State;", "enabled", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "tickColor", "active", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSliderColors implements androidx.compose.material.SliderColors {

    private final long activeTickColor;
    private final long activeTrackColor;
    private final long disabledActiveTickColor;
    private final long disabledActiveTrackColor;
    private final long disabledInactiveTickColor;
    private final long disabledInactiveTrackColor;
    private final long disabledThumbColor;
    private final long inactiveTickColor;
    private final long inactiveTrackColor;
    private final long thumbColor;
    private DefaultSliderColors(long thumbColor, long disabledThumbColor, long activeTrackColor, long inactiveTrackColor, long disabledActiveTrackColor, long disabledInactiveTrackColor, long activeTickColor, long inactiveTickColor, long disabledActiveTickColor, long disabledInactiveTickColor) {
        super();
        this.thumbColor = thumbColor;
        this.disabledThumbColor = activeTrackColor;
        this.activeTrackColor = disabledActiveTrackColor;
        this.inactiveTrackColor = activeTickColor;
        this.disabledActiveTrackColor = disabledActiveTickColor;
        this.disabledInactiveTrackColor = obj25;
        this.activeTickColor = obj27;
        this.inactiveTickColor = obj29;
        this.disabledActiveTickColor = obj31;
        this.disabledInactiveTickColor = obj33;
    }

    public DefaultSliderColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, DefaultConstructorMarker defaultConstructorMarker11) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, defaultConstructorMarker11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // androidx.compose.material.SliderColors
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
                if (!Color.equals-impl0(this.thumbColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledThumbColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.activeTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.inactiveTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledActiveTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledInactiveTrackColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.activeTickColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.inactiveTickColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledActiveTickColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledInactiveTickColor, class2)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.SliderColors
    public int hashCode() {
        return result8 += i20;
    }

    public State<Color> thumbColor(boolean enabled, Composer $composer, int $changed) {
        long disabledThumbColor;
        boolean traceInProgress;
        String str;
        int i = -1733795637;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(thumbColor)1096@42843L69:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSliderColors.thumbColor (Slider.kt:1095)");
        }
        disabledThumbColor = enabled ? this.thumbColor : this.disabledThumbColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledThumbColor), $composer, 0);
    }

    public State<Color> tickColor(boolean enabled, boolean active, Composer $composer, int $changed) {
        long disabledActiveTickColor;
        boolean traceInProgress;
        String str;
        int i = -1491563694;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(tickColor)P(1)1112@43394L243:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSliderColors.tickColor (Slider.kt:1111)");
        }
        if (enabled) {
            disabledActiveTickColor = active ? this.activeTickColor : this.inactiveTickColor;
        } else {
            disabledActiveTickColor = active ? this.disabledActiveTickColor : this.disabledInactiveTickColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledActiveTickColor), $composer, 0);
    }

    public State<Color> trackColor(boolean enabled, boolean active, Composer $composer, int $changed) {
        long disabledActiveTrackColor;
        boolean traceInProgress;
        String str;
        int i = 1575395620;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(trackColor)P(1)1101@43030L247:Slider.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSliderColors.trackColor (Slider.kt:1100)");
        }
        if (enabled) {
            disabledActiveTrackColor = active ? this.activeTrackColor : this.inactiveTrackColor;
        } else {
            disabledActiveTrackColor = active ? this.disabledActiveTrackColor : this.disabledInactiveTrackColor;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledActiveTrackColor), $composer, 0);
    }
}
