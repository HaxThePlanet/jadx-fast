package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJF\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0007H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"Landroidx/compose/material/ripple/PlatformRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformRipple extends androidx.compose.material.ripple.Ripple {

    public static final int $stable;
    static {
    }

    private PlatformRipple(boolean bounded, float radius, State<Color> color) {
        super(bounded, radius, color, 0);
    }

    public PlatformRipple(boolean z, float f2, State state3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(z, f2, state3);
    }

    public androidx.compose.material.ripple.RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo(InteractionSource interactionSource, boolean bounded, float radius, State<Color> color, State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha, Composer $composer, int $changed) {
        Object obj;
        boolean traceInProgress;
        int i6;
        String str;
        int i;
        boolean changed;
        boolean changed2;
        Object androidRippleIndicationInstance;
        int i4;
        int i2;
        State state;
        State state2;
        int i3;
        Object obj2;
        int i5;
        final Composer composer = $composer;
        final int i7 = $changed;
        int i8 = 331259447;
        composer.startReplaceGroup(i8);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)93@3647L7,94@3671L138:Ripple.android.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, i7, -1, "androidx.compose.material.ripple.PlatformRipple.rememberUpdatedRippleInstance (Ripple.android.kt:92)");
        }
        int i12 = 0;
        int i15 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        final android.view.ViewGroup view = Ripple_androidKt.access$findNearestViewGroup((View)composer.consume((CompositionLocal)AndroidCompositionLocals_androidKt.getLocalView()));
        ComposerKt.sourceInformationMarkerStart(composer, -598285110, "CC(remember):Ripple.android.kt#9igjgp");
        int i16 = 1;
        int i18 = 4;
        if (i10 ^= 6 > i18) {
            if (!composer.changed(interactionSource)) {
                i = i7 & 6 == i18 ? i16 : i6;
            } else {
            }
        } else {
            obj = interactionSource;
        }
        i4 = 196608;
        i2 = 131072;
        if (i21 ^= i4 > i2) {
            if (!composer.changed(this)) {
                if (i7 & i4 == i2) {
                    i6 = i16;
                }
            } else {
            }
        } else {
            obj2 = this;
        }
        Composer composer2 = $composer;
        int i19 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i22 = 0;
        if (i13 |= changed3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i5 = 0;
                androidRippleIndicationInstance = new AndroidRippleIndicationInstance(bounded, radius, color, rippleAlpha, view, 0);
                composer2.updateRememberedValue(androidRippleIndicationInstance);
            } else {
                androidRippleIndicationInstance = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return (RippleIndicationInstance)(AndroidRippleIndicationInstance)androidRippleIndicationInstance;
    }
}
