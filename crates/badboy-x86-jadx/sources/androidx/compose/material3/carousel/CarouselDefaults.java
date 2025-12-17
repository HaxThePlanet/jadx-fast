package androidx.compose.material3.carousel;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.pager.PagerDefaults;
import androidx.compose.foundation.pager.PagerSnapDistance;
import androidx.compose.foundation.pager.PagerSnapDistance.Companion;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0008\u0002\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00132\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0015H\u0007¢\u0006\u0002\u0010\u0016J\r\u0010\u0017\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0018J%\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u000e\u0008\u0002\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u0015H\u0007¢\u0006\u0002\u0010\u001aR\u001c\u0010\u0003\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u001c\u0010\u0008\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000R\u001c\u0010\u000c\u001a\u00020\u0004X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/material3/carousel/CarouselDefaults;", "", "()V", "AnchorSize", "Landroidx/compose/ui/unit/Dp;", "getAnchorSize-D9Ej5fM$material3_release", "()F", "F", "MaxSmallItemSize", "getMaxSmallItemSize-D9Ej5fM$material3_release", "MediumLargeItemDiffThreshold", "", "MinSmallItemSize", "getMinSmallItemSize-D9Ej5fM$material3_release", "multiBrowseFlingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "state", "Landroidx/compose/material3/carousel/CarouselState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "noSnapFlingBehavior", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "singleAdvanceFlingBehavior", "(Landroidx/compose/material3/carousel/CarouselState;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselDefaults {

    public static final int $stable = 0;
    private static final float AnchorSize = 0f;
    public static final androidx.compose.material3.carousel.CarouselDefaults INSTANCE = null;
    private static final float MaxSmallItemSize = 0f;
    public static final float MediumLargeItemDiffThreshold = 0.85f;
    private static final float MinSmallItemSize;
    static {
        CarouselDefaults carouselDefaults = new CarouselDefaults();
        CarouselDefaults.INSTANCE = carouselDefaults;
        int i4 = 0;
        CarouselDefaults.MinSmallItemSize = Dp.constructor-impl((float)i);
        int i5 = 0;
        CarouselDefaults.MaxSmallItemSize = Dp.constructor-impl((float)i2);
        int i6 = 0;
        CarouselDefaults.AnchorSize = Dp.constructor-impl((float)i3);
    }

    public final float getAnchorSize-D9Ej5fM$material3_release() {
        return CarouselDefaults.AnchorSize;
    }

    public final float getMaxSmallItemSize-D9Ej5fM$material3_release() {
        return CarouselDefaults.MaxSmallItemSize;
    }

    public final float getMinSmallItemSize-D9Ej5fM$material3_release() {
        return CarouselDefaults.MinSmallItemSize;
    }

    public final TargetedFlingBehavior multiBrowseFlingBehavior(androidx.compose.material3.carousel.CarouselState state, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> snapAnimationSpec, Composer $composer, int $changed, int i6) {
        int i3;
        int i;
        int i2;
        DecayAnimationSpec decayAnimationSpec2;
        androidx.compose.animation.core.SpringSpec springSpec;
        DecayAnimationSpec obj13;
        androidx.compose.animation.core.SpringSpec obj14;
        final int i4 = $changed;
        int i5 = -1105043293;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(multiBrowseFlingBehavior)P(2)642@29119L26,657@29722L217:Carousel.kt#dcf9yb");
        if (i6 & 2 != 0) {
            decayAnimationSpec2 = obj13;
        } else {
            decayAnimationSpec2 = decayAnimationSpec;
        }
        if (i6 & 4 != 0) {
            i2 = 0;
            springSpec = obj14;
        } else {
            springSpec = snapAnimationSpec;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i4, -1, "androidx.compose.material3.carousel.CarouselDefaults.multiBrowseFlingBehavior (Carousel.kt:644)");
        }
        obj13 = new CarouselDefaults.multiBrowseFlingBehavior.pagerSnapDistance.1();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return PagerDefaults.INSTANCE.flingBehavior(state.getPagerState$material3_release(), (PagerSnapDistance)obj13, decayAnimationSpec2, springSpec, 0, $composer, obj14 | i9, 16);
    }

    public final TargetedFlingBehavior noSnapFlingBehavior(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int empty;
        Object anon;
        int i = -418415756;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(noSnapFlingBehavior)674@30353L158,680@30528L75:Carousel.kt#dcf9yb");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.carousel.CarouselDefaults.noSnapFlingBehavior (Carousel.kt:673)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 1269150096, "CC(remember):Carousel.kt#9igjgp");
        int i3 = 0;
        Composer composer = $composer;
        int i4 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i6 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            empty = 0;
            anon = new CarouselDefaults.noSnapFlingBehavior.decayLayoutInfoProvider.1.1();
            composer.updateRememberedValue(anon);
        } else {
            anon = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return SnapFlingBehaviorKt.rememberSnapFlingBehavior((SnapLayoutInfoProvider)(CarouselDefaults.noSnapFlingBehavior.decayLayoutInfoProvider.1.1)anon, $composer, 6);
    }

    public final TargetedFlingBehavior singleAdvanceFlingBehavior(androidx.compose.material3.carousel.CarouselState state, AnimationSpec<Float> snapAnimationSpec, Composer $composer, int $changed, int i5) {
        String str;
        int i2;
        int i;
        androidx.compose.animation.core.SpringSpec springSpec;
        androidx.compose.animation.core.SpringSpec obj12;
        int obj15;
        final int i3 = 1701587199;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(singleAdvanceFlingBehavior)P(1)612@27409L174:Carousel.kt#dcf9yb");
        if (i5 &= 2 != 0) {
            i = 0;
            springSpec = obj12;
        } else {
            springSpec = snapAnimationSpec;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.material3.carousel.CarouselDefaults.singleAdvanceFlingBehavior (Carousel.kt:611)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return PagerDefaults.INSTANCE.flingBehavior(state.getPagerState$material3_release(), PagerSnapDistance.Companion.atMost(1), 0, springSpec, 0, composer, obj12 | obj15, 20);
    }
}
