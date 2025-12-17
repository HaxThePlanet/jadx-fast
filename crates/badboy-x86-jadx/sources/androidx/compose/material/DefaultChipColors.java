package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\u001b\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\r2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016J\u001b\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0017¢\u0006\u0002\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\nR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/material/DefaultChipColors;", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "(JJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultChipColors implements androidx.compose.material.ChipColors {

    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconContentColor;
    private final long leadingIconContentColor;
    private DefaultChipColors(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor) {
        super();
        this.backgroundColor = backgroundColor;
        this.contentColor = leadingIconContentColor;
        this.leadingIconContentColor = disabledContentColor;
        this.disabledBackgroundColor = obj7;
        this.disabledContentColor = obj9;
        this.disabledLeadingIconContentColor = obj11;
    }

    public DefaultChipColors(long l, long l2, long l3, long l4, long l5, long l6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(l, l2, l3, l4, l5, l6, defaultConstructorMarker7, obj8, obj9, obj10, obj11, obj12);
    }

    public State<Color> backgroundColor(boolean enabled, Composer $composer, int $changed) {
        long disabledBackgroundColor;
        boolean traceInProgress;
        String str;
        int i = -1593588247;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)600@26752L79:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultChipColors.backgroundColor (Chip.kt:599)");
        }
        disabledBackgroundColor = enabled ? this.backgroundColor : this.disabledBackgroundColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledBackgroundColor), $composer, 0);
    }

    public State<Color> contentColor(boolean enabled, Composer $composer, int $changed) {
        long disabledContentColor;
        boolean traceInProgress;
        String str;
        int i = 483145880;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(contentColor)605@26934L73:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultChipColors.contentColor (Chip.kt:604)");
        }
        disabledContentColor = enabled ? this.contentColor : this.disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledContentColor), $composer, 0);
    }

    @Override // androidx.compose.material.ChipColors
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
                if (!Color.equals-impl0(this.backgroundColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.contentColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.leadingIconContentColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledBackgroundColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContentColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLeadingIconContentColor, class2)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.ChipColors
    public int hashCode() {
        return result4 += i12;
    }

    public State<Color> leadingIconContentColor(boolean enabled, Composer $composer, int $changed) {
        long leadingIconContentColor;
        boolean traceInProgress;
        String str;
        int i = 1955749013;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(leadingIconContentColor)610@27121L117:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultChipColors.leadingIconContentColor (Chip.kt:609)");
        }
        leadingIconContentColor = enabled ? this.leadingIconContentColor : this.disabledLeadingIconContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(leadingIconContentColor), $composer, 0);
    }
}
