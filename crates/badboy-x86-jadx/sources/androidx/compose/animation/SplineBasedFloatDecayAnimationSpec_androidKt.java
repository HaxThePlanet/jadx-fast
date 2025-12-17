package androidx.compose.animation;

import android.view.ViewConfiguration;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0019\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u0006H\u0007¢\u0006\u0002\u0010\u0007\u001a!\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\u0008\u0000\u0010\u00062\u0006\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0008\u000b\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u000c", d2 = {"platformFlingScrollFriction", "", "getPlatformFlingScrollFriction", "()F", "rememberSplineBasedDecay", "Landroidx/compose/animation/core/DecayAnimationSpec;", "T", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/animation/core/DecayAnimationSpec;", "splineBasedDecayDeprecated", "density", "Landroidx/compose/ui/unit/Density;", "splineBasedDecay", "animation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SplineBasedFloatDecayAnimationSpec_androidKt {

    private static final float platformFlingScrollFriction;
    static {
        SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction = ViewConfiguration.getScrollFriction();
    }

    public static final float getPlatformFlingScrollFriction() {
        return SplineBasedFloatDecayAnimationSpec_androidKt.platformFlingScrollFriction;
    }

    public static final <T> DecayAnimationSpec<T> rememberSplineBasedDecay(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object decayAnimationSpec;
        Object empty;
        androidx.compose.animation.SplineBasedFloatDecayAnimationSpec splineBasedFloatDecayAnimationSpec;
        int i = 904445851;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberSplineBasedDecay)43@1746L7,44@1765L114:SplineBasedFloatDecayAnimationSpec.android.kt#xbi5r1");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.animation.rememberSplineBasedDecay (SplineBasedFloatDecayAnimationSpec.android.kt:40)");
        }
        int i2 = 0;
        int i3 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        Object this_$iv = consume;
        ComposerKt.sourceInformationMarkerStart($composer, 2068418658, "CC(remember):SplineBasedFloatDecayAnimationSpec.android.kt#9igjgp");
        Composer composer = $composer;
        int i6 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i7 = 0;
        if (!$composer.changed((Density)this_$iv.getDensity())) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i8 = 0;
                splineBasedFloatDecayAnimationSpec = new SplineBasedFloatDecayAnimationSpec(this_$iv);
                composer.updateRememberedValue(DecayAnimationSpecKt.generateDecayAnimationSpec((FloatDecayAnimationSpec)splineBasedFloatDecayAnimationSpec));
            } else {
                decayAnimationSpec = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (DecayAnimationSpec)decayAnimationSpec;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Moved to common code")
    public static final DecayAnimationSpec splineBasedDecay(Density density) {
        return SplineBasedDecayKt.splineBasedDecay(density);
    }
}
