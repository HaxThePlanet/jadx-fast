package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\u000cJ#\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J#\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00102\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J#\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/material/DefaultSelectableChipColors;", "Landroidx/compose/material/SelectableChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "(JJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "selected", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultSelectableChipColors implements androidx.compose.material.SelectableChipColors {

    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private final long disabledLeadingIconColor;
    private final long leadingIconColor;
    private final long selectedBackgroundColor;
    private final long selectedContentColor;
    private final long selectedLeadingIconColor;
    private DefaultSelectableChipColors(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor) {
        super();
        this.backgroundColor = backgroundColor;
        this.contentColor = leadingIconColor;
        this.leadingIconColor = disabledContentColor;
        this.disabledBackgroundColor = selectedBackgroundColor;
        this.disabledContentColor = selectedLeadingIconColor;
        this.disabledLeadingIconColor = obj25;
        this.selectedBackgroundColor = obj27;
        this.selectedContentColor = obj29;
        this.selectedLeadingIconColor = obj31;
    }

    public DefaultSelectableChipColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, DefaultConstructorMarker defaultConstructorMarker10) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, defaultConstructorMarker10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    public State<Color> backgroundColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long disabledBackgroundColor;
        boolean traceInProgress;
        String str;
        int i = -403836585;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)667@29299L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSelectableChipColors.backgroundColor (Chip.kt:661)");
        }
        disabledBackgroundColor = !enabled ? this.disabledBackgroundColor : !selected ? this.backgroundColor : this.selectedBackgroundColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledBackgroundColor), $composer, 0);
    }

    public State<Color> contentColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long disabledContentColor;
        boolean traceInProgress;
        String str;
        int i = 2025240134;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(contentColor)677@29611L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSelectableChipColors.contentColor (Chip.kt:671)");
        }
        disabledContentColor = !enabled ? this.disabledContentColor : !selected ? this.contentColor : this.selectedContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledContentColor), $composer, 0);
    }

    @Override // androidx.compose.material.SelectableChipColors
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
                if (!Color.equals-impl0(this.backgroundColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.contentColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.leadingIconColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledBackgroundColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContentColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLeadingIconColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedBackgroundColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedContentColor, class)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.selectedLeadingIconColor, class)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.SelectableChipColors
    public int hashCode() {
        return result4 += i18;
    }

    public State<Color> leadingIconColor(boolean enabled, boolean selected, Composer $composer, int $changed) {
        long disabledLeadingIconColor;
        boolean traceInProgress;
        String str;
        int i = 189838188;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)687@29939L28:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultSelectableChipColors.leadingIconColor (Chip.kt:681)");
        }
        disabledLeadingIconColor = !enabled ? this.disabledLeadingIconColor : !selected ? this.leadingIconColor : this.selectedLeadingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledLeadingIconColor), $composer, 0);
    }
}
