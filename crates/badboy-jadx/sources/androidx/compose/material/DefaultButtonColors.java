package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u001b\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\u000cJ\u001b\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¢\u0006\u0002\u0010\u000cJ\u0013\u0010\r\u001a\u00020\u000b2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008R\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0012", d2 = {"Landroidx/compose/material/DefaultButtonColors;", "Landroidx/compose/material/ButtonColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledBackgroundColor", "disabledContentColor", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "equals", "other", "", "hashCode", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultButtonColors implements androidx.compose.material.ButtonColors {

    private final long backgroundColor;
    private final long contentColor;
    private final long disabledBackgroundColor;
    private final long disabledContentColor;
    private DefaultButtonColors(long backgroundColor, long contentColor, long disabledBackgroundColor, long disabledContentColor) {
        super();
        this.backgroundColor = backgroundColor;
        this.contentColor = disabledBackgroundColor;
        this.disabledBackgroundColor = obj5;
        this.disabledContentColor = obj7;
    }

    public DefaultButtonColors(long l, long l2, long l3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(l, l2, l3, l4, defaultConstructorMarker5, obj6, obj7, obj8);
    }

    public State<Color> backgroundColor(boolean enabled, Composer $composer, int $changed) {
        long disabledBackgroundColor;
        boolean traceInProgress;
        String str;
        int i = -655254499;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)588@23520L79:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultButtonColors.backgroundColor (Button.kt:587)");
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
        int i = -2133647540;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(contentColor)593@23702L73:Button.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultButtonColors.contentColor (Button.kt:592)");
        }
        disabledContentColor = enabled ? this.contentColor : this.disabledContentColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledContentColor), $composer, 0);
    }

    @Override // androidx.compose.material.ButtonColors
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
                if (!Color.equals-impl0(this.disabledBackgroundColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledContentColor, class2)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.ButtonColors
    public int hashCode() {
        return result2 += i8;
    }
}
