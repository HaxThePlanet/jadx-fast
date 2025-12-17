package androidx.compose.material3;

import androidx.compose.animation.SplineBasedFloatDecayAnimationSpec_androidKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsetsSides.Companion;
import androidx.compose.material3.internal.SystemBarsDefaultInsets_androidKt;
import androidx.compose.material3.tokens.TopAppBarLargeTokens;
import androidx.compose.material3.tokens.TopAppBarMediumTokens;
import androidx.compose.material3.tokens.TopAppBarSmallCenteredTokens;
import androidx.compose.material3.tokens.TopAppBarSmallTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u001f\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010 JD\u0010\u001f\u001a\u00020\u00152\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010$\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"2\u0008\u0008\u0002\u0010&\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(JK\u0010)\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u000e\u0008\u0002\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0010\u0008\u0002\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001012\u0010\u0008\u0002\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u000104H\u0007¢\u0006\u0002\u00105JK\u00106\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u000e\u0008\u0002\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.2\u0010\u0008\u0002\u00100\u001a\n\u0012\u0004\u0012\u000202\u0018\u0001012\u0010\u0008\u0002\u00103\u001a\n\u0012\u0004\u0012\u000202\u0018\u000104H\u0007¢\u0006\u0002\u00105J\r\u00107\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010 JD\u00107\u001a\u00020\u00152\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010$\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"2\u0008\u0008\u0002\u0010&\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u0010(J\r\u00109\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010 JD\u00109\u001a\u00020\u00152\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010$\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"2\u0008\u0008\u0002\u0010&\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u0008:\u0010(J'\u0010;\u001a\u00020*2\u0008\u0008\u0002\u0010+\u001a\u00020,2\u000e\u0008\u0002\u0010-\u001a\u0008\u0012\u0004\u0012\u00020/0.H\u0007¢\u0006\u0002\u0010<J\r\u0010=\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010 JD\u0010=\u001a\u00020\u00152\u0008\u0008\u0002\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010#\u001a\u00020\"2\u0008\u0008\u0002\u0010$\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020\"2\u0008\u0008\u0002\u0010&\u001a\u00020\"H\u0007ø\u0001\u0000¢\u0006\u0004\u0008>\u0010(R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u00118G¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0018\u0010\u0019\u001a\u00020\u0015*\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0018R\u0018\u0010\u001b\u001a\u00020\u0015*\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0018R\u0018\u0010\u001d\u001a\u00020\u0015*\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001e\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006?", d2 = {"Landroidx/compose/material3/TopAppBarDefaults;", "", "()V", "LargeAppBarCollapsedHeight", "Landroidx/compose/ui/unit/Dp;", "getLargeAppBarCollapsedHeight-D9Ej5fM", "()F", "F", "LargeAppBarExpandedHeight", "getLargeAppBarExpandedHeight-D9Ej5fM", "MediumAppBarCollapsedHeight", "getMediumAppBarCollapsedHeight-D9Ej5fM", "MediumAppBarExpandedHeight", "getMediumAppBarExpandedHeight-D9Ej5fM", "TopAppBarExpandedHeight", "getTopAppBarExpandedHeight-D9Ej5fM", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "getWindowInsets", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "defaultCenterAlignedTopAppBarColors", "Landroidx/compose/material3/TopAppBarColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCenterAlignedTopAppBarColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TopAppBarColors;", "defaultLargeTopAppBarColors", "getDefaultLargeTopAppBarColors$material3_release", "defaultMediumTopAppBarColors", "getDefaultMediumTopAppBarColors$material3_release", "defaultTopAppBarColors", "getDefaultTopAppBarColors$material3_release", "centerAlignedTopAppBarColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TopAppBarColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "scrolledContainerColor", "navigationIconContentColor", "titleContentColor", "actionIconContentColor", "centerAlignedTopAppBarColors-zjMxDiM", "(JJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarColors;", "enterAlwaysScrollBehavior", "Landroidx/compose/material3/TopAppBarScrollBehavior;", "state", "Landroidx/compose/material3/TopAppBarState;", "canScroll", "Lkotlin/Function0;", "", "snapAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "flingAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/animation/core/AnimationSpec;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "exitUntilCollapsedScrollBehavior", "largeTopAppBarColors", "largeTopAppBarColors-zjMxDiM", "mediumTopAppBarColors", "mediumTopAppBarColors-zjMxDiM", "pinnedScrollBehavior", "(Landroidx/compose/material3/TopAppBarState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TopAppBarScrollBehavior;", "topAppBarColors", "topAppBarColors-zjMxDiM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TopAppBarDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.TopAppBarDefaults INSTANCE;
    private static final float LargeAppBarCollapsedHeight;
    private static final float LargeAppBarExpandedHeight;
    private static final float MediumAppBarCollapsedHeight;
    private static final float MediumAppBarExpandedHeight;
    private static final float TopAppBarExpandedHeight;
    static {
        TopAppBarDefaults topAppBarDefaults = new TopAppBarDefaults();
        TopAppBarDefaults.INSTANCE = topAppBarDefaults;
        TopAppBarDefaults.TopAppBarExpandedHeight = TopAppBarSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.MediumAppBarCollapsedHeight = TopAppBarSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.MediumAppBarExpandedHeight = TopAppBarMediumTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.LargeAppBarCollapsedHeight = TopAppBarSmallTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        TopAppBarDefaults.LargeAppBarExpandedHeight = TopAppBarLargeTokens.INSTANCE.getContainerHeight-D9Ej5fM();
    }

    public final androidx.compose.material3.TopAppBarColors centerAlignedTopAppBarColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 513940029;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(centerAlignedTopAppBarColors)1035@49843L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1035)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultCenterAlignedTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.TopAppBarColors centerAlignedTopAppBarColors-zjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i8) {
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU2;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU4;
        boolean traceInProgress;
        String str;
        long l2;
        long l4;
        long l;
        long l5;
        long l3;
        int i;
        final Composer composer = obj27;
        int i2 = 1896017784;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(centerAlignedTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)1056@50929L11:AppBar.kt#uh7d8r");
        if (obj29 & 1 != 0) {
            l2 = unspecified-0d7_KjU3;
        } else {
            l2 = containerColor;
        }
        if (obj29 & 2 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = navigationIconContentColor;
        }
        if (obj29 & 4 != 0) {
            l = unspecified-0d7_KjU2;
        } else {
            l = actionIconContentColor;
        }
        if (obj29 & 8 != 0) {
            l5 = unspecified-0d7_KjU5;
        } else {
            l5 = $changed;
        }
        if (obj29 & 16 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = obj25;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj28, -1, "androidx.compose.material3.TopAppBarDefaults.centerAlignedTopAppBarColors (AppBar.kt:1056)");
        } else {
            i = obj28;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultCenterAlignedTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-t635Npw(l2, obj6, l4, obj8, l);
    }

    public final androidx.compose.material3.TopAppBarScrollBehavior enterAlwaysScrollBehavior(androidx.compose.material3.TopAppBarState state, Function0<Boolean> canScroll, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> flingAnimationSpec, Composer $composer, int $changed, int i7) {
        int i;
        int i4;
        int i2;
        int i5;
        Composer $composer2;
        int i3;
        int i6;
        androidx.compose.material3.TopAppBarState obj9;
        androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior.1 obj10;
        androidx.compose.animation.core.SpringSpec obj11;
        DecayAnimationSpec obj12;
        int obj13;
        int obj15;
        final int i8 = 959086674;
        ComposerKt.sourceInformationMarkerStart($composer, i8, "C(enterAlwaysScrollBehavior)P(3!1,2)1214@58881L24,1217@59107L26:AppBar.kt#uh7d8r");
        if (i7 & 1 != 0) {
            obj9 = AppBarKt.rememberTopAppBarState(0, 0, 0, $composer, 0, 7);
        } else {
            $composer2 = $composer;
        }
        if (i7 & 2 != 0) {
            obj10 = obj13;
        }
        if (i7 & 4 != 0) {
            i2 = 0;
            obj11 = obj13;
        }
        if (i7 & 8 != 0) {
            obj12 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.enterAlwaysScrollBehavior (AppBar.kt:1219)");
        }
        obj13 = new EnterAlwaysScrollBehavior(obj9, obj11, obj12, obj10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return (TopAppBarScrollBehavior)obj13;
    }

    public final androidx.compose.material3.TopAppBarScrollBehavior exitUntilCollapsedScrollBehavior(androidx.compose.material3.TopAppBarState state, Function0<Boolean> canScroll, AnimationSpec<Float> snapAnimationSpec, DecayAnimationSpec<Float> flingAnimationSpec, Composer $composer, int $changed, int i7) {
        int i6;
        int i;
        int i5;
        int i3;
        Composer $composer2;
        int i2;
        int i4;
        androidx.compose.material3.TopAppBarState obj9;
        androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior.1 obj10;
        androidx.compose.animation.core.SpringSpec obj11;
        DecayAnimationSpec obj12;
        int obj13;
        int obj15;
        final int i8 = -1757023234;
        ComposerKt.sourceInformationMarkerStart($composer, i8, "C(exitUntilCollapsedScrollBehavior)P(3!1,2)1247@60644L24,1250@60870L26:AppBar.kt#uh7d8r");
        if (i7 & 1 != 0) {
            obj9 = AppBarKt.rememberTopAppBarState(0, 0, 0, $composer, 0, 7);
        } else {
            $composer2 = $composer;
        }
        if (i7 & 2 != 0) {
            obj10 = obj13;
        }
        if (i7 & 4 != 0) {
            i5 = 0;
            obj11 = obj13;
        }
        if (i7 & 8 != 0) {
            obj12 = SplineBasedFloatDecayAnimationSpec_androidKt.rememberSplineBasedDecay($composer2, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.exitUntilCollapsedScrollBehavior (AppBar.kt:1252)");
        }
        obj13 = new ExitUntilCollapsedScrollBehavior(obj9, obj11, obj12, obj10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return (TopAppBarScrollBehavior)obj13;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultCenterAlignedTopAppBarColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultCenterAlignedTopAppBarColors) {
        androidx.compose.material3.TopAppBarColors defaultCenterAlignedTopAppBarColorsCached$material3_release;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i;
        long token2;
        long token4;
        long token3;
        long token;
        int i2;
        if ($this$defaultCenterAlignedTopAppBarColors.getDefaultCenterAlignedTopAppBarColorsCached$material3_release() == null) {
            topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken($this$defaultCenterAlignedTopAppBarColors, TopAppBarSmallCenteredTokens.INSTANCE.getContainerColor()), obj3, ColorSchemeKt.fromToken($this$defaultCenterAlignedTopAppBarColors, TopAppBarSmallCenteredTokens.INSTANCE.getOnScrollContainerColor()), obj5, ColorSchemeKt.fromToken($this$defaultCenterAlignedTopAppBarColors, TopAppBarSmallCenteredTokens.INSTANCE.getLeadingIconColor()), obj7, ColorSchemeKt.fromToken($this$defaultCenterAlignedTopAppBarColors, TopAppBarSmallCenteredTokens.INSTANCE.getHeadlineColor()), obj9, ColorSchemeKt.fromToken($this$defaultCenterAlignedTopAppBarColors, TopAppBarSmallCenteredTokens.INSTANCE.getTrailingIconColor()), obj11, 0);
            i = 0;
            $this$defaultCenterAlignedTopAppBarColors.setDefaultCenterAlignedTopAppBarColorsCached$material3_release(topAppBarColors);
        }
        return defaultCenterAlignedTopAppBarColorsCached$material3_release;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultLargeTopAppBarColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultLargeTopAppBarColors) {
        androidx.compose.material3.TopAppBarColors defaultLargeTopAppBarColorsCached$material3_release;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i2;
        long token;
        long token4;
        long token3;
        long token2;
        int i;
        if ($this$defaultLargeTopAppBarColors.getDefaultLargeTopAppBarColorsCached$material3_release() == null) {
            topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken($this$defaultLargeTopAppBarColors, TopAppBarLargeTokens.INSTANCE.getContainerColor()), obj3, ColorSchemeKt.fromToken($this$defaultLargeTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getOnScrollContainerColor()), obj5, ColorSchemeKt.fromToken($this$defaultLargeTopAppBarColors, TopAppBarLargeTokens.INSTANCE.getLeadingIconColor()), obj7, ColorSchemeKt.fromToken($this$defaultLargeTopAppBarColors, TopAppBarLargeTokens.INSTANCE.getHeadlineColor()), obj9, ColorSchemeKt.fromToken($this$defaultLargeTopAppBarColors, TopAppBarLargeTokens.INSTANCE.getTrailingIconColor()), obj11, 0);
            i2 = 0;
            $this$defaultLargeTopAppBarColors.setDefaultLargeTopAppBarColorsCached$material3_release(topAppBarColors);
        }
        return defaultLargeTopAppBarColorsCached$material3_release;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultMediumTopAppBarColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultMediumTopAppBarColors) {
        androidx.compose.material3.TopAppBarColors defaultMediumTopAppBarColorsCached$material3_release;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i2;
        long token4;
        long token3;
        long token2;
        long token;
        int i;
        if ($this$defaultMediumTopAppBarColors.getDefaultMediumTopAppBarColorsCached$material3_release() == null) {
            topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken($this$defaultMediumTopAppBarColors, TopAppBarMediumTokens.INSTANCE.getContainerColor()), obj3, ColorSchemeKt.fromToken($this$defaultMediumTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getOnScrollContainerColor()), obj5, ColorSchemeKt.fromToken($this$defaultMediumTopAppBarColors, TopAppBarMediumTokens.INSTANCE.getLeadingIconColor()), obj7, ColorSchemeKt.fromToken($this$defaultMediumTopAppBarColors, TopAppBarMediumTokens.INSTANCE.getHeadlineColor()), obj9, ColorSchemeKt.fromToken($this$defaultMediumTopAppBarColors, TopAppBarMediumTokens.INSTANCE.getTrailingIconColor()), obj11, 0);
            i2 = 0;
            $this$defaultMediumTopAppBarColors.setDefaultMediumTopAppBarColorsCached$material3_release(topAppBarColors);
        }
        return defaultMediumTopAppBarColorsCached$material3_release;
    }

    public final androidx.compose.material3.TopAppBarColors getDefaultTopAppBarColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultTopAppBarColors) {
        androidx.compose.material3.TopAppBarColors defaultTopAppBarColorsCached$material3_release;
        androidx.compose.material3.TopAppBarColors topAppBarColors;
        int i;
        long token4;
        long token2;
        long token3;
        long token;
        int i2;
        if ($this$defaultTopAppBarColors.getDefaultTopAppBarColorsCached$material3_release() == null) {
            topAppBarColors = new TopAppBarColors(ColorSchemeKt.fromToken($this$defaultTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getContainerColor()), obj3, ColorSchemeKt.fromToken($this$defaultTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getOnScrollContainerColor()), obj5, ColorSchemeKt.fromToken($this$defaultTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getLeadingIconColor()), obj7, ColorSchemeKt.fromToken($this$defaultTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getHeadlineColor()), obj9, ColorSchemeKt.fromToken($this$defaultTopAppBarColors, TopAppBarSmallTokens.INSTANCE.getTrailingIconColor()), obj11, 0);
            i = 0;
            $this$defaultTopAppBarColors.setDefaultTopAppBarColorsCached$material3_release(topAppBarColors);
        }
        return defaultTopAppBarColorsCached$material3_release;
    }

    public final float getLargeAppBarCollapsedHeight-D9Ej5fM() {
        return TopAppBarDefaults.LargeAppBarCollapsedHeight;
    }

    public final float getLargeAppBarExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.LargeAppBarExpandedHeight;
    }

    public final float getMediumAppBarCollapsedHeight-D9Ej5fM() {
        return TopAppBarDefaults.MediumAppBarCollapsedHeight;
    }

    public final float getMediumAppBarExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.MediumAppBarExpandedHeight;
    }

    public final float getTopAppBarExpandedHeight-D9Ej5fM() {
        return TopAppBarDefaults.TopAppBarExpandedHeight;
    }

    public final WindowInsets getWindowInsets(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 2143182847;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C1025@49443L29:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.<get-windowInsets> (AppBar.kt:1025)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return WindowInsetsKt.only-bOOhFvg(SystemBarsDefaultInsets_androidKt.getSystemBarsForVisualComponents(WindowInsets.Companion, $composer, 6), WindowInsetsSides.plus-gK_yJZ4(WindowInsetsSides.Companion.getHorizontal-JoeWqyM(), WindowInsetsSides.Companion.getTop-JoeWqyM()));
    }

    public final androidx.compose.material3.TopAppBarColors largeTopAppBarColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1744932393;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(largeTopAppBarColors)1135@54826L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1135)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultLargeTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.TopAppBarColors largeTopAppBarColors-zjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i8) {
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU5;
        boolean traceInProgress;
        String str;
        long l4;
        long l2;
        long l3;
        long l5;
        long l;
        int i;
        final Composer composer = obj27;
        int i2 = -1471507700;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(largeTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)1157@55926L11:AppBar.kt#uh7d8r");
        if (obj29 & 1 != 0) {
            l4 = unspecified-0d7_KjU3;
        } else {
            l4 = containerColor;
        }
        if (obj29 & 2 != 0) {
            l2 = unspecified-0d7_KjU4;
        } else {
            l2 = navigationIconContentColor;
        }
        if (obj29 & 4 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = actionIconContentColor;
        }
        if (obj29 & 8 != 0) {
            l5 = unspecified-0d7_KjU2;
        } else {
            l5 = $changed;
        }
        if (obj29 & 16 != 0) {
            l = unspecified-0d7_KjU5;
        } else {
            l = obj25;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj28, -1, "androidx.compose.material3.TopAppBarDefaults.largeTopAppBarColors (AppBar.kt:1157)");
        } else {
            i = obj28;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultLargeTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-t635Npw(l4, obj6, l2, obj8, l3);
    }

    public final androidx.compose.material3.TopAppBarColors mediumTopAppBarColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1268886463;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(mediumTopAppBarColors)1085@52373L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1085)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultMediumTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.TopAppBarColors mediumTopAppBarColors-zjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i8) {
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU5;
        int unspecified-0d7_KjU4;
        int unspecified-0d7_KjU;
        boolean traceInProgress;
        String str;
        long l3;
        long l;
        long l5;
        long l2;
        long l4;
        int i;
        final Composer composer = obj27;
        int i2 = -582474442;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(mediumTopAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)1107@53476L11:AppBar.kt#uh7d8r");
        if (obj29 & 1 != 0) {
            l3 = unspecified-0d7_KjU3;
        } else {
            l3 = containerColor;
        }
        if (obj29 & 2 != 0) {
            l = unspecified-0d7_KjU2;
        } else {
            l = navigationIconContentColor;
        }
        if (obj29 & 4 != 0) {
            l5 = unspecified-0d7_KjU5;
        } else {
            l5 = actionIconContentColor;
        }
        if (obj29 & 8 != 0) {
            l2 = unspecified-0d7_KjU4;
        } else {
            l2 = $changed;
        }
        if (obj29 & 16 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = obj25;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj28, -1, "androidx.compose.material3.TopAppBarDefaults.mediumTopAppBarColors (AppBar.kt:1107)");
        } else {
            i = obj28;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultMediumTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-t635Npw(l3, obj6, l, obj8, l5);
    }

    public final androidx.compose.material3.TopAppBarScrollBehavior pinnedScrollBehavior(androidx.compose.material3.TopAppBarState state, Function0<Boolean> canScroll, Composer $composer, int $changed, int i5) {
        int i;
        int i3;
        int i2;
        Composer $composer2;
        int i4;
        int i6;
        androidx.compose.material3.TopAppBarState obj9;
        androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior.1 obj10;
        int obj11;
        int obj13;
        final int i7 = 286497075;
        ComposerKt.sourceInformationMarkerStart($composer, i7, "C(pinnedScrollBehavior)P(1)1192@57597L24:AppBar.kt#uh7d8r");
        if (i5 & 1 != 0) {
            obj9 = AppBarKt.rememberTopAppBarState(0, 0, 0, $composer, 0, 7);
        } else {
            $composer2 = $composer;
        }
        if (i5 & 2 != 0) {
            obj10 = obj11;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.pinnedScrollBehavior (AppBar.kt:1194)");
        }
        obj11 = new PinnedScrollBehavior(obj9, obj10);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer2);
        return (TopAppBarScrollBehavior)obj11;
    }

    public final androidx.compose.material3.TopAppBarColors topAppBarColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1388520854;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(topAppBarColors)977@47193L11:AppBar.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:977)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.TopAppBarColors topAppBarColors-zjMxDiM(long containerColor, long scrolledContainerColor, long navigationIconContentColor, long titleContentColor, long actionIconContentColor, Composer $composer, int $changed, int i8) {
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU5;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU3;
        boolean traceInProgress;
        String str;
        long l;
        long l2;
        long l5;
        long l3;
        long l4;
        int i;
        final Composer composer = obj27;
        int i2 = 2142919275;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(topAppBarColors)P(1:c#ui.graphics.Color,3:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.graphics.Color,0:c#ui.graphics.Color)998@48245L11:AppBar.kt#uh7d8r");
        if (obj29 & 1 != 0) {
            l = unspecified-0d7_KjU4;
        } else {
            l = containerColor;
        }
        if (obj29 & 2 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = navigationIconContentColor;
        }
        if (obj29 & 4 != 0) {
            l5 = unspecified-0d7_KjU5;
        } else {
            l5 = actionIconContentColor;
        }
        if (obj29 & 8 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = $changed;
        }
        if (obj29 & 16 != 0) {
            l4 = unspecified-0d7_KjU3;
        } else {
            l4 = obj25;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj28, -1, "androidx.compose.material3.TopAppBarDefaults.topAppBarColors (AppBar.kt:998)");
        } else {
            i = obj28;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultTopAppBarColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-t635Npw(l, obj6, l2, obj8, l5);
    }
}
