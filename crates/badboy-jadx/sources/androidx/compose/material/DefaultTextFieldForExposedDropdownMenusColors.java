package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0003\u0018\u00002\u00020\u0001Bµ\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\u000c\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0003\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019J\u001b\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001f\u001a\u00020\u001dH\u0017¢\u0006\u0002\u0010\u001eJ\u0013\u0010 \u001a\u00020\u001d2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0096\u0002J\u0008\u0010#\u001a\u00020$H\u0016J+\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0017¢\u0006\u0002\u0010(J+\u0010)\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0017¢\u0006\u0002\u0010(J#\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0017¢\u0006\u0002\u0010+J\u001b\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017¢\u0006\u0002\u0010\u001eJ\u001b\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0017¢\u0006\u0002\u0010\u001eJ#\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001dH\u0017¢\u0006\u0002\u0010+J+\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020'H\u0017¢\u0006\u0002\u0010(R\u0016\u0010\u0012\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0015\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u000c\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0018\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0016\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\r\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0011\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0013\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u000f\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0017\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0008\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001aR\u0016\u0010\u0014\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006,²\u0006\n\u0010-\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020\u001dX\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020\u001dX\u008a\u0084\u0002", d2 = {"Landroidx/compose/material/DefaultTextFieldForExposedDropdownMenusColors;", "Landroidx/compose/material/TextFieldColors;", "textColor", "Landroidx/compose/ui/graphics/Color;", "disabledTextColor", "cursorColor", "errorCursorColor", "focusedIndicatorColor", "unfocusedIndicatorColor", "errorIndicatorColor", "disabledIndicatorColor", "leadingIconColor", "disabledLeadingIconColor", "errorLeadingIconColor", "trailingIconColor", "focusedTrailingIconColor", "disabledTrailingIconColor", "errorTrailingIconColor", "backgroundColor", "focusedLabelColor", "unfocusedLabelColor", "disabledLabelColor", "errorLabelColor", "placeholderColor", "disabledPlaceholderColor", "(JJJJJJJJJJJJJJJJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "Landroidx/compose/runtime/State;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "isError", "equals", "other", "", "hashCode", "", "indicatorColor", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "labelColor", "error", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release", "focused"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultTextFieldForExposedDropdownMenusColors implements androidx.compose.material.TextFieldColors {

    private final long backgroundColor;
    private final long cursorColor;
    private final long disabledIndicatorColor;
    private final long disabledLabelColor;
    private final long disabledLeadingIconColor;
    private final long disabledPlaceholderColor;
    private final long disabledTextColor;
    private final long disabledTrailingIconColor;
    private final long errorCursorColor;
    private final long errorIndicatorColor;
    private final long errorLabelColor;
    private final long errorLeadingIconColor;
    private final long errorTrailingIconColor;
    private final long focusedIndicatorColor;
    private final long focusedLabelColor;
    private final long focusedTrailingIconColor;
    private final long leadingIconColor;
    private final long placeholderColor;
    private final long textColor;
    private final long trailingIconColor;
    private final long unfocusedIndicatorColor;
    private final long unfocusedLabelColor;
    private DefaultTextFieldForExposedDropdownMenusColors(long textColor, long disabledTextColor, long cursorColor, long errorCursorColor, long focusedIndicatorColor, long unfocusedIndicatorColor, long errorIndicatorColor, long disabledIndicatorColor, long leadingIconColor, long disabledLeadingIconColor, long errorLeadingIconColor, long trailingIconColor, long focusedTrailingIconColor, long disabledTrailingIconColor, long errorTrailingIconColor, long backgroundColor, long focusedLabelColor, long unfocusedLabelColor, long disabledLabelColor, long errorLabelColor, long placeholderColor, long disabledPlaceholderColor) {
        super();
        this.textColor = textColor;
        this.disabledTextColor = cursorColor;
        this.cursorColor = focusedIndicatorColor;
        this.errorCursorColor = errorIndicatorColor;
        this.focusedIndicatorColor = leadingIconColor;
        this.unfocusedIndicatorColor = errorLeadingIconColor;
        this.errorIndicatorColor = focusedTrailingIconColor;
        this.disabledIndicatorColor = errorTrailingIconColor;
        this.leadingIconColor = focusedLabelColor;
        this.disabledLeadingIconColor = disabledLabelColor;
        this.errorLeadingIconColor = placeholderColor;
        this.trailingIconColor = obj37;
        this.focusedTrailingIconColor = obj39;
        this.disabledTrailingIconColor = obj41;
        this.errorTrailingIconColor = obj43;
        this.backgroundColor = obj45;
        this.focusedLabelColor = obj47;
        this.unfocusedLabelColor = obj49;
        this.disabledLabelColor = obj51;
        this.errorLabelColor = obj53;
        this.placeholderColor = obj55;
        this.disabledPlaceholderColor = obj57;
    }

    public DefaultTextFieldForExposedDropdownMenusColors(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, long l13, long l14, long l15, long l16, long l17, long l18, long l19, long l20, long l21, long l22, DefaultConstructorMarker defaultConstructorMarker23) {
        super(l, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, l19, l20, l21, l22, defaultConstructorMarker23, obj24, obj25, obj26, obj27, obj28, obj29, obj30, obj31, obj32, obj33, obj34, obj35, obj36, obj37, obj38, obj39, obj40, obj41, obj42, obj43, obj44);
    }

    private static final boolean indicatorColor$lambda$1(State<Boolean> $focused$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$focused$delegate.getValue().booleanValue();
    }

    private static final boolean labelColor$lambda$2(State<Boolean> $focused$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$focused$delegate.getValue().booleanValue();
    }

    private static final boolean trailingIconColor$lambda$0(State<Boolean> $focused$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$focused$delegate.getValue().booleanValue();
    }

    public State<Color> backgroundColor(boolean enabled, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1206593285;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(backgroundColor)645@28108L37:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.backgroundColor (ExposedDropdownMenu.android.kt:644)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(this.backgroundColor), $composer, 0);
    }

    public State<Color> cursorColor(boolean isError, Composer $composer, int $changed) {
        long errorCursorColor;
        boolean traceInProgress;
        String str;
        int i = 603205843;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(cursorColor)677@29092L68:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.cursorColor (ExposedDropdownMenu.android.kt:676)");
        }
        errorCursorColor = isError != null ? this.errorCursorColor : this.cursorColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(errorCursorColor), $composer, 0);
    }

    @Override // androidx.compose.material.TextFieldColors
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
                if (!Color.equals-impl0(this.textColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTextColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.cursorColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorCursorColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedIndicatorColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedIndicatorColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorIndicatorColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledIndicatorColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.leadingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLeadingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorLeadingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.trailingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedTrailingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledTrailingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorTrailingIconColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.backgroundColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.focusedLabelColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.unfocusedLabelColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledLabelColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.errorLabelColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.placeholderColor, class2)) {
                    return i2;
                }
                if (!Color.equals-impl0(this.disabledPlaceholderColor, class2)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // androidx.compose.material.TextFieldColors
    public int hashCode() {
        return result20 += i44;
    }

    public State<Color> indicatorColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        long disabledIndicatorColor;
        boolean traceInProgress;
        String str;
        State rememberUpdatedState;
        Color box-impl;
        int i;
        int i2;
        int i3;
        int i4 = -1956761869;
        $composer.startReplaceGroup(i4);
        ComposerKt.sourceInformation($composer, "C(indicatorColor)P(!1,2)628@27563L25:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.indicatorColor (ExposedDropdownMenu.android.kt:627)");
        }
        disabledIndicatorColor = !enabled ? this.disabledIndicatorColor : isError != null ? this.errorIndicatorColor : indicatorColor$lambda$1 ? this.focusedIndicatorColor : this.unfocusedIndicatorColor;
        int i7 = 0;
        if (enabled) {
            $composer.startReplaceGroup(-887939641);
            ComposerKt.sourceInformation($composer, "637@27854L75");
            i = 0;
            rememberUpdatedState = SingleValueAnimationKt.animateColorAsState-euL9pac(disabledIndicatorColor, traceInProgress, (AnimationSpec)AnimationSpecKt.tween$default(150, i7, i, 6, i), 0, i, $composer, 48);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-887836783);
            ComposerKt.sourceInformation($composer, "639@27959L33");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledIndicatorColor), $composer, i7);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return rememberUpdatedState;
    }

    public State<Color> labelColor(boolean enabled, boolean error, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        long unfocusedLabelColor;
        String str;
        int i = -1110039826;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(labelColor)659@28544L25,667@28790L33:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.labelColor (ExposedDropdownMenu.android.kt:658)");
        }
        unfocusedLabelColor = !enabled ? this.disabledLabelColor : error != null ? this.errorLabelColor : labelColor$lambda$2 ? this.focusedLabelColor : this.unfocusedLabelColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(unfocusedLabelColor), $composer, 0);
    }

    public State<Color> leadingIconColor(boolean enabled, boolean isError, Composer $composer, int $changed) {
        long disabledLeadingIconColor;
        boolean traceInProgress;
        String str;
        int i = 1834640354;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(leadingIconColor)583@26241L207:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.leadingIconColor (ExposedDropdownMenu.android.kt:582)");
        }
        disabledLeadingIconColor = !enabled ? this.disabledLeadingIconColor : isError != null ? this.errorLeadingIconColor : this.leadingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledLeadingIconColor), $composer, 0);
    }

    public State<Color> placeholderColor(boolean enabled, Composer $composer, int $changed) {
        long disabledPlaceholderColor;
        boolean traceInProgress;
        String str;
        int i = 1682014002;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(placeholderColor)650@28252L81:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.placeholderColor (ExposedDropdownMenu.android.kt:649)");
        }
        disabledPlaceholderColor = enabled ? this.placeholderColor : this.disabledPlaceholderColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledPlaceholderColor), $composer, 0);
    }

    public State<Color> textColor(boolean enabled, Composer $composer, int $changed) {
        long disabledTextColor;
        boolean traceInProgress;
        String str;
        int i = -855386788;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(textColor)672@28923L67:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.textColor (ExposedDropdownMenu.android.kt:671)");
        }
        disabledTextColor = enabled ? this.textColor : this.disabledTextColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledTextColor), $composer, 0);
    }

    public State<Color> trailingIconColor(boolean enabled, boolean isError, InteractionSource interactionSource, Composer $composer, int $changed) {
        boolean traceInProgress;
        long disabledTrailingIconColor;
        String str;
        int i = 1172839089;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)P(!1,2)610@27042L25,612@27084L262:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.trailingIconColor (ExposedDropdownMenu.android.kt:609)");
        }
        disabledTrailingIconColor = !enabled ? this.disabledTrailingIconColor : isError != null ? this.errorTrailingIconColor : trailingIconColor$lambda$0 ? this.focusedTrailingIconColor : this.trailingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledTrailingIconColor), $composer, 0);
    }

    public State<Color> trailingIconColor(boolean enabled, boolean isError, Composer $composer, int $changed) {
        long disabledTrailingIconColor;
        boolean traceInProgress;
        String str;
        int i = 1174562608;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(trailingIconColor)595@26612L210:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DefaultTextFieldForExposedDropdownMenusColors.trailingIconColor (ExposedDropdownMenu.android.kt:594)");
        }
        disabledTrailingIconColor = !enabled ? this.disabledTrailingIconColor : isError != null ? this.errorTrailingIconColor : this.trailingIconColor;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return SnapshotStateKt.rememberUpdatedState(Color.box-impl(disabledTrailingIconColor), $composer, 0);
    }
}
