package androidx.compose.material.ripple;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Deprecated(message = "Replaced by the new RippleNode implementation")
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007¢\u0006\u0002\u0010\tJF\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0007H\u0017ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0012", d2 = {"Landroidx/compose/material/ripple/CommonRipple;", "Landroidx/compose/material/ripple/Ripple;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/graphics/Color;", "(ZFLandroidx/compose/runtime/State;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "rememberUpdatedRippleInstance", "Landroidx/compose/material/ripple/RippleIndicationInstance;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "rememberUpdatedRippleInstance-942rkJo", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/ripple/RippleIndicationInstance;", "material-ripple_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CommonRipple extends androidx.compose.material.ripple.Ripple {

    public static final int $stable;
    static {
    }

    private CommonRipple(boolean bounded, float radius, State<Color> color) {
        super(bounded, radius, color, 0);
    }

    public CommonRipple(boolean z, float f2, State state3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(z, f2, state3);
    }

    public androidx.compose.material.ripple.RippleIndicationInstance rememberUpdatedRippleInstance-942rkJo(InteractionSource interactionSource, boolean bounded, float radius, State<Color> color, State<androidx.compose.material.ripple.RippleAlpha> rippleAlpha, Composer $composer, int $changed) {
        Object obj2;
        boolean traceInProgress;
        int i2;
        String str;
        int i3;
        boolean changed2;
        Object obj;
        int i;
        boolean changed;
        Object commonRippleIndicationInstance;
        boolean z;
        float f;
        State state2;
        State state;
        int i4;
        final Composer composer = $composer;
        final int i5 = $changed;
        int i6 = -1768051227;
        composer.startReplaceGroup(i6);
        ComposerKt.sourceInformation(composer, "C(rememberUpdatedRippleInstance)P(2!1,3:c#ui.unit.Dp)60@2195L125:CommonRipple.kt#vhb33q");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, i5, -1, "androidx.compose.material.ripple.CommonRipple.rememberUpdatedRippleInstance (CommonRipple.kt:59)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1865672267, "CC(remember):CommonRipple.kt#9igjgp");
        int i11 = 1;
        int i12 = 4;
        if (i8 ^= 6 > i12) {
            if (!composer.changed(interactionSource)) {
                i3 = i5 & 6 == i12 ? i11 : i2;
            } else {
            }
        } else {
            obj2 = interactionSource;
        }
        i = 196608;
        int i17 = 131072;
        if (i15 ^= i > i17) {
            if (!composer.changed(this)) {
                if (i &= i5 == i17) {
                    i2 = i11;
                }
            } else {
            }
        } else {
            obj = this;
        }
        Composer composer2 = $composer;
        int i13 = 0;
        Object rememberedValue = composer2.rememberedValue();
        int i18 = 0;
        if (i2 |= i3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                changed = 0;
                commonRippleIndicationInstance = new CommonRippleIndicationInstance(bounded, radius, color, rippleAlpha, 0);
                composer2.updateRememberedValue(commonRippleIndicationInstance);
            } else {
                commonRippleIndicationInstance = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return (RippleIndicationInstance)(CommonRippleIndicationInstance)commonRippleIndicationInstance;
    }
}
