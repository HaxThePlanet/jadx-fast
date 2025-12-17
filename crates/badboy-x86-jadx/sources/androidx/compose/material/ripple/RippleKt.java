package androidx.compose.material.ripple;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Dp.Companion;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a>\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002\u001a\u0018\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002\u001a0\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001c", d2 = {"DefaultTweenSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "createRippleModifierNode", "Landroidx/compose/ui/node/DelegatableNode;", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", "bounded", "", "radius", "Landroidx/compose/ui/unit/Dp;", "color", "Landroidx/compose/ui/graphics/ColorProducer;", "rippleAlpha", "Lkotlin/Function0;", "Landroidx/compose/material/ripple/RippleAlpha;", "createRippleModifierNode-TDGSqEk", "(Landroidx/compose/foundation/interaction/InteractionSource;ZFLandroidx/compose/ui/graphics/ColorProducer;Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/node/DelegatableNode;", "incomingStateLayerAnimationSpecFor", "Landroidx/compose/animation/core/AnimationSpec;", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "outgoingStateLayerAnimationSpecFor", "rememberRipple", "Landroidx/compose/foundation/Indication;", "Landroidx/compose/ui/graphics/Color;", "rememberRipple-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RippleKt {

    private static final TweenSpec<Float> DefaultTweenSpec;
    static {
        TweenSpec tweenSpec = new TweenSpec(15, 0, EasingKt.getLinearEasing(), 2, 0);
        RippleKt.DefaultTweenSpec = tweenSpec;
    }

    public static final AnimationSpec access$incomingStateLayerAnimationSpecFor(Interaction interaction) {
        return RippleKt.incomingStateLayerAnimationSpecFor(interaction);
    }

    public static final AnimationSpec access$outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        return RippleKt.outgoingStateLayerAnimationSpecFor(interaction);
    }

    public static final DelegatableNode createRippleModifierNode-TDGSqEk(InteractionSource interactionSource, boolean bounded, float radius, ColorProducer color, Function0<androidx.compose.material.ripple.RippleAlpha> rippleAlpha) {
        return Ripple_androidKt.createPlatformRippleNode-TDGSqEk(interactionSource, bounded, radius, color, rippleAlpha);
    }

    private static final AnimationSpec<Float> incomingStateLayerAnimationSpecFor(Interaction interaction) {
        TweenSpec defaultTweenSpec;
        TweenSpec tweenSpec;
        int i3;
        int i;
        androidx.compose.animation.core.Easing linearEasing;
        int i4;
        int i2;
        if (interaction instanceof HoverInteraction.Enter) {
            defaultTweenSpec = RippleKt.DefaultTweenSpec;
        } else {
            if (interaction instanceof FocusInteraction.Focus) {
                tweenSpec = new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, 0);
                defaultTweenSpec = tweenSpec;
            } else {
                if (interaction instanceof DragInteraction.Start) {
                    tweenSpec = new TweenSpec(45, 0, EasingKt.getLinearEasing(), 2, 0);
                    defaultTweenSpec = tweenSpec;
                } else {
                    defaultTweenSpec = RippleKt.DefaultTweenSpec;
                }
            }
        }
        return defaultTweenSpec;
    }

    private static final AnimationSpec<Float> outgoingStateLayerAnimationSpecFor(Interaction interaction) {
        TweenSpec defaultTweenSpec;
        TweenSpec tweenSpec;
        int i2;
        int i4;
        androidx.compose.animation.core.Easing linearEasing;
        int i;
        int i3;
        if (interaction instanceof HoverInteraction.Enter) {
            defaultTweenSpec = RippleKt.DefaultTweenSpec;
        } else {
            if (interaction instanceof FocusInteraction.Focus) {
                defaultTweenSpec = RippleKt.DefaultTweenSpec;
            } else {
                if (interaction instanceof DragInteraction.Start) {
                    tweenSpec = new TweenSpec(150, 0, EasingKt.getLinearEasing(), 2, 0);
                    defaultTweenSpec = tweenSpec;
                } else {
                    defaultTweenSpec = RippleKt.DefaultTweenSpec;
                }
            }
        }
        return defaultTweenSpec;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "rememberRipple has been deprecated - it returns an old Indication implementation that is not compatible with the new Indication APIs that provide notable performance improvements. Instead, use the new ripple APIs provided by design system libraries, such as material and material3. If you are implementing your own design system library, use createRippleNode to create your own custom ripple implementation that queries your own theme values. For a migration guide and background information, please visit developer.android.com")
    public static final Indication rememberRipple-9IZ8Weo(boolean bounded, float radius, long color, Composer $composer, int $changed, int i6) {
        boolean changed2;
        int i;
        int companion;
        int changed;
        String str;
        int i2;
        Object empty;
        Object platformRipple;
        int i3;
        int obj8;
        float obj9;
        long obj10;
        int obj14;
        int i4 = 1635163520;
        ComposerKt.sourceInformationMarkerStart($changed, i4, "C(rememberRipple)P(!1,2:c#ui.unit.Dp,1:c#ui.graphics.Color)147@7571L27,148@7610L85:Ripple.kt#vhb33q");
        if (obj14 & 1 != 0) {
            obj8 = 1;
        }
        if (obj14 & 2 != 0) {
            obj9 = Dp.Companion.getUnspecified-D9Ej5fM();
        }
        int i12 = 4;
        if (obj14 &= i12 != 0) {
            obj10 = Color.Companion.getUnspecified-0d7_KjU();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i6, -1, "androidx.compose.material.ripple.rememberRipple (Ripple.kt:146)");
        }
        ComposerKt.sourceInformationMarkerStart($changed, 487972074, "CC(remember):Ripple.kt#9igjgp");
        int i15 = 1;
        if (i9 ^= 6 > i12) {
            if (!$changed.changed(obj8)) {
                i = i6 & 6 == i12 ? i15 : i2;
            } else {
            }
        } else {
        }
        int i16 = 32;
        if (i13 ^= 48 > i16) {
            if (!$changed.changed(obj9)) {
                if (i6 & 48 == i16) {
                    i2 = i15;
                }
            } else {
            }
        } else {
        }
        Composer composer = $changed;
        int i14 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i17 = 0;
        if (i |= i2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                platformRipple = new PlatformRipple(obj8, obj9, SnapshotStateKt.rememberUpdatedState(Color.box-impl(obj10), $changed, i5 &= 14), 0);
                composer.updateRememberedValue(platformRipple);
            } else {
                platformRipple = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return (Indication)(PlatformRipple)platformRipple;
    }
}
