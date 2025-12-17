package androidx.compose.foundation.pager;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.VisibilityThresholdsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import androidx.compose.foundation.gestures.snapping.PagerSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.platform.CompositionLocalsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.IntCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JI\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u000e\u0008\u0002\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c2\u000e\u0008\u0002\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000f2\u0008\u0008\u0003\u0010\u0010\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0014\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Landroidx/compose/foundation/pager/PagerDefaults;", "", "()V", "BeyondViewportPageCount", "", "flingBehavior", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "state", "Landroidx/compose/foundation/pager/PagerState;", "pagerSnapDistance", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "snapPositionalThreshold", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/pager/PagerSnapDistance;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/animation/core/AnimationSpec;FLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "pageNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "(Landroidx/compose/foundation/pager/PagerState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagerDefaults {

    public static final int $stable;
    public static final int BeyondViewportPageCount;
    public static final androidx.compose.foundation.pager.PagerDefaults INSTANCE;
    static {
        PagerDefaults pagerDefaults = new PagerDefaults();
        PagerDefaults.INSTANCE = pagerDefaults;
    }

    public final TargetedFlingBehavior flingBehavior(androidx.compose.foundation.pager.PagerState state, androidx.compose.foundation.pager.PagerSnapDistance pagerSnapDistance, DecayAnimationSpec<Float> decayAnimationSpec, AnimationSpec<Float> snapAnimationSpec, float snapPositionalThreshold, Composer $composer, int $changed, int i8) {
        int i3;
        int cmp;
        androidx.compose.foundation.pager.PagerSnapDistance pagerSnapDistance2;
        int i5;
        DecayAnimationSpec decayAnimationSpec2;
        androidx.compose.animation.core.SpringSpec snapAnimationSpec2;
        int i;
        int snapPositionalThreshold2;
        int i4;
        boolean traceInProgress;
        int changed2;
        int i2;
        String str;
        boolean changed;
        Object $i$a$CachePagerDefaults$flingBehavior$2;
        int empty;
        androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider snapLayoutInfoProvider;
        final Object obj = state;
        final Composer composer = $composer;
        final int i6 = $changed;
        int i7 = 1559769181;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(flingBehavior)P(4,1)295@16853L26,306@17415L7,307@17474L7,308@17497L1053:Pager.kt#g6yjnt");
        i5 = 1;
        if (i8 & 2 != 0) {
            pagerSnapDistance2 = PagerSnapDistance.Companion.atMost(i5);
        } else {
            pagerSnapDistance2 = pagerSnapDistance;
        }
        int i15 = 0;
        if (i8 & 4 != 0) {
            decayAnimationSpec2 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay(composer, i15);
        } else {
            decayAnimationSpec2 = decayAnimationSpec;
        }
        int i17 = 0;
        if (i8 & 8 != 0) {
            snapAnimationSpec2 = AnimationSpecKt.spring$default(i17, 1137180672, Float.valueOf((float)visibilityThreshold), i5, 0);
        } else {
            snapAnimationSpec2 = snapAnimationSpec;
        }
        snapPositionalThreshold2 = i8 & 16 != 0 ? 1056964608 : snapPositionalThreshold;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, i6, -1, "androidx.compose.foundation.pager.PagerDefaults.flingBehavior (Pager.kt:301)");
        }
        if (Float.compare(i17, snapPositionalThreshold2) <= 0 && Float.compare(snapPositionalThreshold2, i9) <= 0) {
            i3 = Float.compare(snapPositionalThreshold2, i9) <= 0 ? i5 : i15;
        } else {
        }
        if (i3 == 0) {
        } else {
            int i18 = 0;
            int i20 = 0;
            int i27 = 2023513938;
            String str5 = "CC:CompositionLocal.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, i27, str5);
            ComposerKt.sourceInformationMarkerEnd(composer);
            int i21 = 0;
            empty = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i27, str5);
            ComposerKt.sourceInformationMarkerEnd(composer);
            Object this_$iv2 = consume;
            ComposerKt.sourceInformationMarkerStart(composer, -1107496563, "CC(remember):Pager.kt#9igjgp");
            int i28 = 4;
            if (i23 ^= 6 > i28) {
                if (!composer.changed(obj)) {
                    i2 = i6 & 6 == i28 ? i5 : i15;
                } else {
                }
            } else {
            }
            int i30 = 32;
            if (i29 ^= 48 > i30) {
                if (!composer.changed(pagerSnapDistance2)) {
                    if (i6 & 48 == i30) {
                    } else {
                        i5 = i15;
                    }
                } else {
                }
            } else {
            }
            Composer composer2 = $composer;
            int i26 = 0;
            Object rememberedValue = composer2.rememberedValue();
            int i31 = 0;
            if (i12 |= changed4 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i32 = 0;
                    PagerDefaults.flingBehavior.2.snapLayoutInfoProvider.1 anon = new PagerDefaults.flingBehavior.2.snapLayoutInfoProvider.1(obj, this_$iv2, snapPositionalThreshold2);
                    composer2.updateRememberedValue(SnapFlingBehaviorKt.snapFlingBehavior(PagerSnapLayoutInfoProviderKt.SnapLayoutInfoProvider(obj, pagerSnapDistance2, (Function3)anon), decayAnimationSpec2, snapAnimationSpec2));
                } else {
                    $i$a$CachePagerDefaults$flingBehavior$2 = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return (TargetedFlingBehavior)$i$a$CachePagerDefaults$flingBehavior$2;
        }
        int density = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("snapPositionalThreshold should be a number between 0 and 1. You've specified ").append(snapPositionalThreshold2).toString().toString());
        throw illegalArgumentException;
    }

    public final NestedScrollConnection pageNestedScrollConnection(androidx.compose.foundation.pager.PagerState state, Orientation orientation, Composer $composer, int $changed) {
        int changed;
        int i;
        boolean traceInProgress;
        int i2;
        String str;
        int changed2;
        Object empty;
        Object defaultPagerNestedScrollConnection;
        int i3 = 877583120;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(pageNestedScrollConnection)P(1)351@19018L107:Pager.kt#g6yjnt");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.foundation.pager.PagerDefaults.pageNestedScrollConnection (Pager.kt:350)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1511248710, "CC(remember):Pager.kt#9igjgp");
        int i7 = 1;
        int i9 = 4;
        if (i5 ^= 6 > i9) {
            if (!$composer.changed(state)) {
                i = $changed & 6 == i9 ? i7 : i2;
            } else {
            }
        } else {
        }
        int i11 = 32;
        if (i10 ^= 48 > i11) {
            if (!$composer.changed(orientation)) {
                if ($changed & 48 == i11) {
                    i2 = i7;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (i |= i2 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                defaultPagerNestedScrollConnection = new DefaultPagerNestedScrollConnection(state, orientation);
                composer.updateRememberedValue(defaultPagerNestedScrollConnection);
            } else {
                defaultPagerNestedScrollConnection = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (NestedScrollConnection)(DefaultPagerNestedScrollConnection)defaultPagerNestedScrollConnection;
    }
}
