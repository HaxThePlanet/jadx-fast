package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aH\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u000bH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\u0004X\u008a\u0084\u0002", d2 = {"animateBorderStrokeAsState", "Landroidx/compose/runtime/State;", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "colors", "Landroidx/compose/material/TextFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "animateBorderStrokeAsState-NuRrP5Q", "(ZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/material/TextFieldColors;FFLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "material_release", "focused"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TextFieldDefaultsKt {
    public static final State access$animateBorderStrokeAsState-NuRrP5Q(boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material.TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        return TextFieldDefaultsKt.animateBorderStrokeAsState-NuRrP5Q(enabled, isError, interactionSource, colors, focusedBorderThickness, unfocusedBorderThickness, $composer, $changed);
    }

    private static final State<BorderStroke> animateBorderStrokeAsState-NuRrP5Q(boolean enabled, boolean isError, InteractionSource interactionSource, androidx.compose.material.TextFieldColors colors, float focusedBorderThickness, float unfocusedBorderThickness, Composer $composer, int $changed) {
        float f;
        boolean traceInProgress;
        State rememberUpdatedState;
        String str;
        int i2;
        InteractionSource interactionSource2;
        int i;
        int i3;
        final Composer composer = $composer;
        final int i18 = $changed;
        int i4 = 1097899920;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(animateBorderStrokeAsState)P(1,4,3!1,2:c#ui.unit.Dp,5:c#ui.unit.Dp)983@42959L25,984@43017L51,991@43374L107:TextFieldDefaults.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i18, -1, "androidx.compose.material.animateBorderStrokeAsState (TextFieldDefaults.kt:982)");
        }
        interactionSource2 = interactionSource;
        f = TextFieldDefaultsKt.animateBorderStrokeAsState_NuRrP5Q$lambda$0(FocusInteractionKt.collectIsFocusedAsState(interactionSource2, composer, i5 &= 14)) ? focusedBorderThickness : unfocusedBorderThickness;
        final int i19 = 0;
        final int i20 = 0;
        if (enabled) {
            composer.startReplaceGroup(772641254);
            ComposerKt.sourceInformation(composer, "987@43212L76");
            rememberUpdatedState = AnimateAsStateKt.animateDpAsState-AjpBEmI(f, (AnimationSpec)AnimationSpecKt.tween$default(150, i19, i20, 6, i20), 0, 0, composer, 48, 12);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(772737540);
            ComposerKt.sourceInformation(composer, "989@43310L46");
            rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Dp.box-impl(unfocusedBorderThickness), composer, i16 &= 14);
            composer.endReplaceGroup();
        }
        SolidColor solidColor = new SolidColor((Color)colors.indicatorColor(enabled, isError, interactionSource2, composer, i9 | i12).getValue().unbox-impl(), obj13, i20);
        BorderStroke borderStroke = new BorderStroke((Dp)rememberUpdatedState.getValue().unbox-impl(), (Brush)solidColor, i20);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return SnapshotStateKt.rememberUpdatedState(borderStroke, composer, i19);
    }

    private static final boolean animateBorderStrokeAsState_NuRrP5Q$lambda$0(State<Boolean> $focused$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$focused$delegate.getValue().booleanValue();
    }
}
