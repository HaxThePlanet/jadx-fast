package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsetsSides.Companion;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.BottomAppBarTokens;
import androidx.compose.material3.tokens.FabSecondaryTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JK\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u000e\u0008\u0002\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b2\u0010\u0008\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e2\u0010\u0008\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010!H\u0007¢\u0006\u0002\u0010\"R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u000c\u001a\u00020\r8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\r8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/material3/BottomAppBarDefaults;", "", "()V", "ContainerElevation", "Landroidx/compose/ui/unit/Dp;", "getContainerElevation-D9Ej5fM", "()F", "F", "ContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "bottomAppBarFabColor", "Landroidx/compose/ui/graphics/Color;", "getBottomAppBarFabColor", "(Landroidx/compose/runtime/Composer;I)J", "containerColor", "getContainerColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "exitAlwaysScrollBehavior", "Landroidx/compose/material3/BottomAppBarScrollBehavior;", "state", "Landroidx/compose/material3/BottomAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/BottomAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/BottomAppBarScrollBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomAppBarDefaults {

    public static final int $stable;
    private static final float ContainerElevation;
    private static final PaddingValues ContentPadding;
    public static final androidx.compose.material3.BottomAppBarDefaults INSTANCE;
    static {
        BottomAppBarDefaults bottomAppBarDefaults = new BottomAppBarDefaults();
        BottomAppBarDefaults.INSTANCE = bottomAppBarDefaults;
        int i2 = 0;
        BottomAppBarDefaults.ContainerElevation = Dp.constructor-impl((float)i);
        BottomAppBarDefaults.ContentPadding = PaddingKt.PaddingValues-a9UjIt4$default(AppBarKt.access$getBottomAppBarHorizontalPadding$p(), AppBarKt.getBottomAppBarVerticalPadding(), AppBarKt.access$getBottomAppBarHorizontalPadding$p(), 0, 8, 0);
    }

    public final androidx.compose.material3.BottomAppBarScrollBehavior exitAlwaysScrollBehavior(androidx.compose.material3.BottomAppBarState state, Function0<Boolean> canScroll, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> flingAnimationSpec, Composer $composer, int $changed, int i7) {
        int i5;
        int i2;
        int i6;
        int i4;
        Composer $composer2;
        int i3;
        int i;
        androidx.compose.material3.BottomAppBarState obj9;
        androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior.1 obj10;
        androidx.compose.animation.core.SpringSpec obj11;
        DecayAnimationSpec obj12;
        int obj13;
        int obj15;
        final int i8 = 457144034;
        ComposerKt.sourceInformationMarkerStart($composer, i8, "C(exitAlwaysScrollBehavior)P(3!1,2)1581@74185L27,1584@74414L26:AppBar.kt#uh7d8r");
        if (i7 & 1 != 0) {
            obj9 = AppBarKt.rememberBottomAppBarState(0, 0, 0, $composer, 0, 7);
        } else {
            $composer2 = $composer;
        }
        if (i7 & 2 != 0) {
            obj10 = obj13;
        }
        if (i7 & 4 != 0) {
            i6 = 0;
            obj11 = obj13;
        }
        if (i7 & 8 != 0) {
            obj12 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, $changed, -1, "androidx.compose.material3.BottomAppBarDefaults.exitAlwaysScrollBehavior (AppBar.kt:1586)");
        }
        obj13 = new ExitAlwaysScrollBehavior(obj9, obj11, obj12, obj10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return (BottomAppBarScrollBehavior)obj13;
    }

    public final long getBottomAppBarFabColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1464561486;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1561@73035L5:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-bottomAppBarFabColor> (AppBar.kt:1561)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(FabSecondaryTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -368340078;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1534@72082L5:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-containerColor> (AppBar.kt:1534)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(BottomAppBarTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final float getContainerElevation-D9Ej5fM() {
        return BottomAppBarDefaults.ContainerElevation;
    }

    public final PaddingValues getContentPadding() {
        return BottomAppBarDefaults.ContentPadding;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 688896409;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1554@72738L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.BottomAppBarDefaults.<get-windowInsets> (AppBar.kt:1553)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getBottom-JoeWqyM()));
    }
}
