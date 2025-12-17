package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a`\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\t2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019\u001aX\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u000b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\u0008\u00162\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\u0008\u00162\u0008\u0008\u0001\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010!\u001aR\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2&\u0010\u0013\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\u000c\u0008'\u0012\u0008\u0008(\u0012\u0004\u0008\u0008()\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\u0008\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a\u0094\u0001\u0010,\u001a\u00020\u000b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\u000c\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u001e2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010.\u001a\u00020&2\u0015\u0008\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010/\u001a\u00020&2\n\u0008\u0002\u00100\u001a\u0004\u0018\u0001012\u0008\u0008\u0002\u00102\u001a\u00020\u00102\u0008\u0008\u0002\u00103\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001a&\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>\u001a8\u0010?\u001a\u000207*\u0002082\u0006\u0010@\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\u0008\u0008\u0001\u0010 \u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\u0008A\u0010B\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006C²\u0006\n\u0010)\u001a\u00020\u0002X\u008a\u0084\u0002", d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomNavigation", "", "windowInsets", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-_UMDTes", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", "onClick", "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BottomNavigationKt {

    private static final TweenSpec<Float> BottomNavigationAnimationSpec;
    private static final float BottomNavigationHeight;
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;
    private static final WindowInsets ZeroInsets;
    static {
        TweenSpec tweenSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
        BottomNavigationKt.BottomNavigationAnimationSpec = tweenSpec;
        int i6 = 0;
        BottomNavigationKt.BottomNavigationHeight = Dp.constructor-impl((float)i);
        int i7 = 0;
        BottomNavigationKt.BottomNavigationItemHorizontalPadding = Dp.constructor-impl((float)i2);
        int i8 = 0;
        BottomNavigationKt.CombinedItemTextBaseline = Dp.constructor-impl((float)i3);
        int i9 = 0;
        int i11 = 0;
        int i12 = 0;
        int i14 = 0;
        BottomNavigationKt.ZeroInsets = WindowInsetsKt.WindowInsets-a9UjIt4(Dp.constructor-impl((float)i4), Dp.constructor-impl((float)$i$f$getDp), Dp.constructor-impl((float)$i$f$getDp2), Dp.constructor-impl((float)$i$f$getDp3));
    }

    public static final void BottomNavigation-PEIptTM(Modifier modifier, long backgroundColor, long contentColor, float elevation, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i8) {
        boolean traceInProgress2;
        Object $composer2;
        int $dirty;
        long $dirty2;
        Object modifier4;
        int modifier3;
        int i3;
        Object backgroundColor2;
        boolean traceInProgress;
        long l;
        int i2;
        long str;
        int elevation-D9Ej5fM;
        float f;
        int changed2;
        int i4;
        int i;
        boolean changed;
        long contentColorFor-ek8zF_U;
        Object obj;
        int modifier2;
        float f3;
        int i6;
        Object obj2;
        int i10;
        int skipping;
        int defaultsInvalid;
        int i5;
        float f2;
        Composer composer2;
        Composer composer;
        int i9;
        int i7;
        long l2;
        final int i33 = obj30;
        traceInProgress2 = 456489494;
        Composer restartGroup = i8.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(BottomNavigation)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)156@6823L6,157@6872L32,161@7015L89:BottomNavigation.kt#jmzs0o");
        $dirty = obj30;
        i3 = obj31 & 1;
        if (i3 != 0) {
            $dirty |= 6;
            backgroundColor2 = modifier;
        } else {
            if (i33 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i2;
            } else {
                backgroundColor2 = modifier;
            }
        }
        if (i33 & 48 == 0) {
            if (obj31 & 2 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                str = backgroundColor;
            }
            $dirty |= changed2;
        } else {
            str = backgroundColor;
        }
        if (i33 & 384 == 0) {
            if (obj31 & 4 == 0) {
                i4 = restartGroup.changed(elevation) ? 256 : 128;
            } else {
                contentColorFor-ek8zF_U = elevation;
            }
            $dirty |= i4;
        } else {
            contentColorFor-ek8zF_U = elevation;
        }
        i = obj31 & 8;
        if (i != 0) {
            $dirty |= 3072;
            f3 = $composer;
        } else {
            if (i33 & 3072 == 0) {
                i6 = restartGroup.changed($composer) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                f3 = $composer;
            }
        }
        if (obj31 & 16 != 0) {
            $dirty |= 24576;
            obj2 = $changed;
        } else {
            if (i33 & 24576 == 0) {
                i10 = restartGroup.changedInstance($changed) ? 16384 : 8192;
                $dirty |= i10;
            } else {
                obj2 = $changed;
            }
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i5 = 6;
                if (i33 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i3 != 0) {
                            modifier4 = Modifier.Companion;
                        } else {
                            modifier4 = backgroundColor2;
                        }
                        if (obj31 & 2 != 0) {
                            backgroundColor2 = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, i5));
                            $dirty &= -113;
                        } else {
                            backgroundColor2 = str;
                        }
                        if (obj31 & 4 != 0) {
                            contentColorFor-ek8zF_U = ColorsKt.contentColorFor-ek8zF_U(backgroundColor2, str, restartGroup);
                            $dirty &= -897;
                        }
                        if (i != 0) {
                            obj = modifier4;
                            modifier3 = i5;
                            skipping = l3;
                            f3 = backgroundColor2;
                            f2 = elevation-D9Ej5fM;
                        } else {
                            obj = modifier4;
                            modifier3 = i5;
                            skipping = l2;
                            f2 = f3;
                            f3 = backgroundColor2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj31 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj31 & 4 != 0) {
                            $dirty &= -897;
                        }
                        f2 = f3;
                        modifier3 = i5;
                        f3 = str;
                        skipping = contentColorFor-ek8zF_U;
                        obj = backgroundColor2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:160)");
                }
                BottomNavigationKt.BottomNavigation-_UMDTes(BottomNavigationKt.ZeroInsets, obj, f3, obj2, skipping, i5, f2, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = obj;
                l = skipping;
                f = f2;
                modifier2 = $dirty;
                $dirty2 = f3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = backgroundColor2;
                modifier2 = $dirty;
                $dirty2 = str;
                l = l2;
                f = f3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new BottomNavigationKt.BottomNavigation.3($composer2, $dirty2, i3, l, str, f, $changed, i33, obj31);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void BottomNavigation-_UMDTes(WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, float elevation, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        boolean traceInProgress;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int i3;
        int elevation-D9Ej5fM;
        boolean traceInProgress2;
        int companion;
        int colors;
        Object str;
        long l2;
        int i4;
        long primarySurface;
        float f3;
        int changed2;
        long contentColor2;
        int i8;
        int changed;
        long i;
        float f2;
        int i10;
        int i5;
        int skipping;
        int defaultsInvalid;
        int i6;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i2;
        int i7;
        long l;
        final Object obj = windowInsets;
        final Object obj3 = $changed;
        final int i28 = obj33;
        traceInProgress = -1278406810;
        Composer restartGroup = i9.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BottomNavigation)P(5,4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp)101@4623L6,102@4672L32,111@4959L330,106@4815L474:BottomNavigation.kt#jmzs0o");
        $dirty2 = obj33;
        if (obj34 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i28 & 6 == 0) {
                i3 = restartGroup.changed(obj) ? 4 : 2;
                $dirty2 |= i3;
            }
        }
        companion = obj34 & 2;
        if (companion != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i28 & 48 == 0) {
                i4 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i4;
            } else {
                str = modifier;
            }
        }
        if (i28 & 384 == 0) {
            if (obj34 & 4 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 256 : 128;
            } else {
                primarySurface = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            primarySurface = backgroundColor;
        }
        if (i28 & 3072 == 0) {
            if (obj34 & 8 == 0) {
                changed = restartGroup.changed(elevation) ? 2048 : 1024;
            } else {
                contentColor2 = elevation;
            }
            $dirty2 |= changed;
        } else {
            contentColor2 = elevation;
        }
        i = obj34 & 16;
        if (i != 0) {
            $dirty2 |= 24576;
            f2 = $composer;
        } else {
            if (i28 & 24576 == 0) {
                i10 = restartGroup.changed($composer) ? 16384 : 8192;
                $dirty2 |= i10;
            } else {
                f2 = $composer;
            }
        }
        int i34 = 196608;
        if (obj34 & 32 != 0) {
            $dirty2 |= i34;
        } else {
            if (i28 & i34 == 0) {
                i5 = restartGroup.changedInstance(obj3) ? 131072 : 65536;
                $dirty2 |= i5;
            }
        }
        int i35 = 74898;
        if (i33 &= $dirty2 == i35) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i28 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion != 0) {
                            str = companion;
                        }
                        if (obj34 & 4 != 0) {
                            primarySurface = ColorsKt.getPrimarySurface(MaterialTheme.INSTANCE.getColors(restartGroup, 6));
                            $dirty2 &= -897;
                        }
                        if (obj34 & 8 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(primarySurface, obj7, restartGroup);
                            $dirty2 &= -7169;
                        }
                        if (i != 0) {
                            f = elevation-D9Ej5fM;
                            i = primarySurface;
                            skipping = contentColor2;
                            contentColor2 = str;
                        } else {
                            skipping = contentColor2;
                            f = f2;
                            contentColor2 = str;
                            i = primarySurface;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj34 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj34 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        skipping = contentColor2;
                        f = f2;
                        contentColor2 = str;
                        i = primarySurface;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.BottomNavigation (BottomNavigation.kt:105)");
                }
                BottomNavigationKt.BottomNavigation.1 anon = new BottomNavigationKt.BottomNavigation.1(obj, obj3);
                SurfaceKt.Surface-F-jzlyU(contentColor2, 0, i, f2, skipping, i35, 0, f, (Function2)ComposableLambdaKt.rememberComposableLambda(-352628062, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i8 = $dirty2;
                $composer2 = contentColor2;
                $dirty = i;
                l2 = skipping;
                f3 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = str;
                i8 = $dirty2;
                $dirty = primarySurface;
                l2 = l;
                f3 = f2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BottomNavigationKt.BottomNavigation.2(obj, $composer2, $dirty, companion, l2, primarySurface, f3, obj3, i28, obj34);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void BottomNavigationItem-jY6E1Zs(RowScope $this$BottomNavigationItem_u2djY6E1Zs, boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int $changed1, int i15) {
        int rememberComposableLambda;
        Function0 factory$iv$iv$iv;
        Object endRestartGroup;
        boolean l2;
        Object obj7;
        int $dirty13;
        int $dirty12;
        int $dirty15;
        Integer valueOf;
        int $dirty4;
        int defaultsInvalid;
        Object modifier2;
        int i3;
        int $dirty14;
        Composer traceInProgress;
        int $dirty3;
        int $dirty2;
        int $dirty;
        Composer composer;
        Object currentCompositionLocalMap;
        Object obj4;
        long $dirty1;
        long unselectedContentColor2;
        Object obj5;
        Object obj2;
        boolean z3;
        Object obj6;
        int interactionSource2;
        int interactionSource3;
        int i11;
        boolean z;
        int obj8;
        int i4;
        Object obj;
        long l;
        int i5;
        int i19;
        int alwaysShowLabel2;
        Object obj3;
        int unbox-impl;
        long modifier3;
        int i20;
        int it;
        boolean traceInProgress2;
        boolean z2;
        int i14;
        int i26;
        int i2;
        int i23;
        int i12;
        int i16;
        int i25;
        int i6;
        int changed;
        int i10;
        int i;
        float medium;
        int i21;
        int i13;
        int i22;
        int i24;
        int i18;
        Modifier modifier4;
        int i17;
        int i9;
        int i8;
        BoxScopeInstance boxScopeInstance;
        Function0 function0;
        Composer composer2;
        Composer $composer2;
        Composer $composer3;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier5;
        int i7;
        ScopeUpdateScope scopeUpdateScope;
        Object obj43;
        Modifier obj44;
        long obj45;
        long obj46;
        Object obj47;
        androidx.compose.runtime.internal.ComposableLambda obj48;
        Composer obj49;
        int obj50;
        long obj51;
        obj4 = icon;
        final int i79 = i15;
        rememberComposableLambda = obj55;
        traceInProgress = $changed1.startRestartGroup(-1473735525);
        ComposerKt.sourceInformation(traceInProgress, "C(BottomNavigationItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)206@9443L7,207@9535L6,218@10038L77,220@10121L804:BottomNavigation.kt#jmzs0o");
        $dirty3 = i15;
        int i52 = obj54;
        if (i60 &= rememberComposableLambda != 0) {
            $dirty3 |= 6;
            obj2 = $this$BottomNavigationItem_u2djY6E1Zs;
        } else {
            if (i79 & 6 == 0) {
                i11 = traceInProgress.changed($this$BottomNavigationItem_u2djY6E1Zs) ? 4 : 2;
                $dirty3 |= i11;
            } else {
                obj2 = $this$BottomNavigationItem_u2djY6E1Zs;
            }
        }
        if (rememberComposableLambda & 1 != 0) {
            $dirty3 |= 48;
            z = selected;
        } else {
            if (i79 & 48 == 0) {
                i4 = traceInProgress.changed(selected) ? 32 : 16;
                $dirty3 |= i4;
            } else {
                z = selected;
            }
        }
        if (rememberComposableLambda & 2 != 0) {
            $dirty3 |= 384;
            obj = onClick;
        } else {
            if (i79 & 384 == 0) {
                i5 = traceInProgress.changedInstance(onClick) ? 256 : 128;
                $dirty3 |= i5;
            } else {
                obj = onClick;
            }
        }
        if (rememberComposableLambda & 4 != 0) {
            $dirty3 |= 3072;
        } else {
            if (i79 & 3072 == 0) {
                i19 = traceInProgress.changedInstance(obj4) ? 2048 : 1024;
                $dirty3 |= i19;
            }
        }
        alwaysShowLabel2 = rememberComposableLambda & 8;
        if (alwaysShowLabel2 != 0) {
            $dirty3 |= 24576;
            obj3 = modifier;
        } else {
            if (i79 & 24576 == 0) {
                i20 = traceInProgress.changed(modifier) ? 16384 : 8192;
                $dirty3 |= i20;
            } else {
                obj3 = modifier;
            }
        }
        it = rememberComposableLambda & 16;
        int i80 = 196608;
        if (it != 0) {
            $dirty3 |= i80;
            z2 = enabled;
        } else {
            if (i80 &= i79 == 0) {
                i14 = traceInProgress.changed(enabled) ? 131072 : 65536;
                $dirty3 |= i14;
            } else {
                z2 = enabled;
            }
        }
        i26 = rememberComposableLambda & 32;
        i2 = 1572864;
        if (i26 != 0) {
            $dirty3 |= i2;
            obj6 = label;
        } else {
            if (i79 & i2 == 0) {
                i2 = traceInProgress.changedInstance(label) ? 1048576 : 524288;
                $dirty3 |= i2;
            } else {
                obj6 = label;
            }
        }
        i23 = rememberComposableLambda & 64;
        i12 = 12582912;
        if (i23 != 0) {
            $dirty3 |= i12;
            l2 = alwaysShowLabel;
        } else {
            if (i79 & i12 == 0) {
                i25 = traceInProgress.changed(alwaysShowLabel) ? 8388608 : 4194304;
                $dirty3 |= i25;
            } else {
                l2 = alwaysShowLabel;
            }
        }
        int i65 = rememberComposableLambda & 128;
        i6 = 100663296;
        if (i65 != 0) {
            $dirty3 |= i6;
            obj7 = interactionSource;
        } else {
            if (i79 & i6 == 0) {
                i6 = traceInProgress.changed(interactionSource) ? 67108864 : 33554432;
                $dirty3 |= i6;
            } else {
                obj7 = interactionSource;
            }
        }
        if (i79 & i87 == 0) {
            if (rememberComposableLambda & 256 == 0) {
                $dirty13 = i52;
                changed = traceInProgress.changed(selectedContentColor) ? 536870912 : 268435456;
            } else {
                $dirty13 = i52;
                $dirty1 = selectedContentColor;
            }
            $dirty3 |= changed;
        } else {
            $dirty13 = i52;
            $dirty1 = selectedContentColor;
        }
        if (obj54 & 6 == 0) {
            if (rememberComposableLambda & 512 == 0) {
                i3 = traceInProgress.changed($composer) ? 4 : 2;
            } else {
                unselectedContentColor2 = $composer;
            }
            $dirty13 = i10 | i3;
        } else {
            unselectedContentColor2 = $composer;
            i10 = $dirty13;
        }
        final int obj52 = $dirty13;
        i = $dirty3;
        if ($dirty3 & i89 == 306783378 && obj52 & 3 == 2) {
            if (obj52 & 3 == 2) {
                if (!traceInProgress.getSkipping()) {
                    traceInProgress.startDefaults();
                    int i86 = -1879048193;
                    if (i79 & 1 != 0) {
                        if (traceInProgress.getDefaultsInvalid()) {
                            if (alwaysShowLabel2 != 0) {
                                modifier2 = Modifier.Companion;
                            } else {
                                modifier2 = obj3;
                            }
                            if (it != 0) {
                                z2 = alwaysShowLabel2;
                            }
                            if (i26 != 0) {
                                obj6 = 0;
                            }
                            alwaysShowLabel2 = i23 != 0 ? 1 : alwaysShowLabel;
                            interactionSource2 = i65 != 0 ? 0 : interactionSource;
                            if (rememberComposableLambda & 256 != 0) {
                                it = 6;
                                i26 = 0;
                                obj43 = modifier2;
                                ComposerKt.sourceInformationMarkerStart(traceInProgress, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                                ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                                $dirty = i & i86;
                                i25 = unbox-impl;
                            } else {
                                obj43 = modifier2;
                                $dirty = i;
                                i25 = selectedContentColor;
                            }
                            if (rememberComposableLambda & 512 != 0) {
                                unselectedContentColor2 = Color.copy-wmQWz5c$default(i25, i, ContentAlpha.INSTANCE.getMedium(traceInProgress, 6), 0, 0, 0, 14);
                                $dirty15 = obj52 & -15;
                                obj3 = obj43;
                            } else {
                                obj3 = obj43;
                                $dirty15 = obj52;
                            }
                        } else {
                            traceInProgress.skipToGroupEnd();
                            $dirty4 = rememberComposableLambda & 256 != 0 ? i & i86 : i;
                            if (rememberComposableLambda & 512 != 0) {
                                alwaysShowLabel2 = alwaysShowLabel;
                                i25 = selectedContentColor;
                                $dirty = $dirty4;
                                $dirty15 = i67;
                                interactionSource2 = interactionSource;
                            } else {
                                alwaysShowLabel2 = alwaysShowLabel;
                                interactionSource2 = interactionSource;
                                i25 = selectedContentColor;
                                $dirty = $dirty4;
                                $dirty15 = obj52;
                            }
                        }
                    } else {
                    }
                    traceInProgress.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1473735525, $dirty, $dirty15, "androidx.compose.material.BottomNavigationItem (BottomNavigation.kt:208)");
                    }
                    if (obj6 == null) {
                        traceInProgress.startReplaceGroup(399096877);
                        traceInProgress.endReplaceGroup();
                        it = 0;
                        i16 = $dirty15;
                        medium = $dirty;
                        obj51 = unselectedContentColor2;
                    } else {
                        traceInProgress.startReplaceGroup(399096878);
                        ComposerKt.sourceInformation(traceInProgress, "*210@9629L156");
                        Object obj10 = obj6;
                        i26 = 0;
                        BottomNavigationKt.BottomNavigationItem.styledLabel.1.1 anon2 = new BottomNavigationKt.BottomNavigationItem.styledLabel.1.1(obj6);
                        i16 = $dirty15;
                        medium = $dirty;
                        obj51 = unselectedContentColor2;
                        it = rememberComposableLambda;
                        traceInProgress.endReplaceGroup();
                    }
                    int i83 = 6;
                    obj47 = traceInProgress;
                    valueOf = obj47;
                    obj46 = rippleOrFallbackImplementation-9IZ8Weo;
                    obj44 = selectable-O2vRcR0;
                    obj46 = i70;
                    Modifier weight$default = RowScope.weight$default($this$BottomNavigationItem_u2djY6E1Zs, obj44, 1065353216, obj46, 2, 0);
                    Alignment center = Alignment.Companion.getCenter();
                    int i55 = 48;
                    int i63 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    i21 = 0;
                    i13 = indication;
                    i22 = center;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositionLocalMap = valueOf.getCurrentCompositionLocalMap();
                    i24 = currentCompositeKeyHash;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf, weight$default);
                    modifier4 = weight$default;
                    int i84 = 6;
                    Function0 function02 = constructor;
                    i18 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf.startReusableNode();
                    if (valueOf.getInserting()) {
                        valueOf.createNode(function02);
                    } else {
                        factory$iv$iv$iv = function02;
                        valueOf.useNode();
                    }
                    Composer constructor-impl = Updater.constructor-impl(valueOf);
                    int i90 = 0;
                    function0 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(center, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i91 = 0;
                    obj43 = constructor-impl;
                    int i92 = 0;
                    if (!obj43.getInserting()) {
                        $composer3 = valueOf;
                        map = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(obj43.rememberedValue(), Integer.valueOf(i24))) {
                            obj43.updateRememberedValue(Integer.valueOf(i24));
                            constructor-impl.apply(Integer.valueOf(i24), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = obj43;
                        }
                    } else {
                        $composer3 = valueOf;
                        map = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    Composer composer3 = $composer3;
                    i17 = i33;
                    ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    int i85 = 6;
                    i58 |= 6;
                    obj49 = composer3;
                    i23 = 0;
                    boxScopeInstance = iNSTANCE;
                    modifier5 = materializeModifier;
                    Composer materialized$iv$iv = obj49;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 239990375, "C237@10627L292,233@10498L421:BottomNavigation.kt#jmzs0o");
                    BottomNavigationKt.BottomNavigationItem.1.1 anon = new BottomNavigationKt.BottomNavigationItem.1.1(alwaysShowLabel2, obj4, it);
                    i7 = i47;
                    obj45 = obj51;
                    BottomNavigationKt.BottomNavigationTransition-Klgx-Pg(i25, obj44, obj45, obj46, selected, (Function3)ComposableLambdaKt.rememberComposableLambda(-1411872801, true, anon, materialized$iv$iv, 54));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    $composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    ComposerKt.sourceInformationMarkerEnd($composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj8 = interactionSource2;
                    interactionSource3 = alwaysShowLabel2;
                    obj5 = obj3;
                    l = i25;
                    i = medium;
                    modifier3 = rememberComposableLambda;
                    z3 = z2;
                } else {
                    traceInProgress.skipToGroupEnd();
                    obj5 = obj3;
                    modifier3 = l3;
                    interactionSource3 = alwaysShowLabel;
                    obj8 = interactionSource;
                    l = selectedContentColor;
                    i16 = obj52;
                    $composer3 = traceInProgress;
                    z3 = z2;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = $composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = $composer3;
            endRestartGroup = new BottomNavigationKt.BottomNavigationItem.2($this$BottomNavigationItem_u2djY6E1Zs, selected, onClick, icon, obj5, z3, obj6, interactionSource3, obj8, l, alwaysShowLabel2, modifier3, it, i79, obj54, obj55);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = $composer3;
        }
    }

    private static final void BottomNavigationItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, float iconPositionAnimationProgress, Composer $composer, int $changed) {
        int traceInProgress;
        int i20;
        Integer valueOf;
        Function0 factory$iv$iv$iv2;
        Object $changed$iv;
        Function0 factory$iv$iv$iv;
        int $dirty;
        int i3;
        int i13;
        int i5;
        boolean valueOf4;
        boolean traceInProgress2;
        int i14;
        Integer valueOf3;
        boolean currentCompositionLocalMap2;
        Object materialized$iv;
        int materialized$iv$iv;
        Function0 factory$iv$iv;
        Composer composer3;
        boolean valueOf2;
        int str;
        Composer composer4;
        Object currentCompositionLocalMap;
        int str2;
        Composer composer2;
        Object maybeCachedBoxMeasurePolicy;
        int i16;
        Object currentCompositeKeyHash;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        int i9;
        int i2;
        Composer composer8;
        int i15;
        int i4;
        Composer composer6;
        int i21;
        int compositeKeyHash$iv;
        int i10;
        int i;
        Modifier modifier2;
        int $i$f$Layout;
        Function0 function0;
        int i12;
        int i7;
        int i11;
        Modifier modifier;
        int i8;
        int i22;
        Function0 currentCompositeKeyHash2;
        int i18;
        BoxScopeInstance boxScopeInstance;
        int $changed$iv2;
        Object obj;
        Composer composer7;
        int i19;
        BoxScopeInstance iNSTANCE;
        androidx.compose.ui.Modifier.Companion companion;
        int i6;
        Composer composer;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i17;
        Composer composer5;
        Modifier modifier3;
        Alignment obj54;
        final Object obj2 = icon;
        final Object obj3 = label;
        final float f = iconPositionAnimationProgress;
        final int i23 = $changed;
        traceInProgress = -1162995092;
        $changed$iv = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($changed$iv, "C(BottomNavigationItemBaselineLayout)P(!1,2)330@13785L806,318@13380L1211:BottomNavigation.kt#jmzs0o");
        if (i23 & 6 == 0) {
            i3 = $changed$iv.changedInstance(obj2) ? 4 : 2;
            $dirty |= i3;
        }
        materialized$iv$iv = 32;
        if (i23 & 48 == 0) {
            i13 = $changed$iv.changedInstance(obj3) ? materialized$iv$iv : 16;
            $dirty |= i13;
        }
        str = 256;
        if (i23 & 384 == 0) {
            i5 = $changed$iv.changed(f) ? str : 128;
            $dirty |= i5;
        }
        if ($dirty & 147 == 146) {
            if (!$changed$iv.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:317)");
                }
                ComposerKt.sourceInformationMarkerStart($changed$iv, 1507126189, "CC(remember):BottomNavigation.kt#9igjgp");
                int i54 = 0;
                i20 = $dirty & 112 == materialized$iv$iv ? i14 : i54;
                if ($dirty & 896 == str) {
                } else {
                    i14 = i54;
                }
                Composer composer9 = $changed$iv;
                int i46 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i59 = 0;
                if (i20 |= i14 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        currentCompositeKeyHash = 0;
                        anon = new BottomNavigationKt.BottomNavigationItemBaselineLayout.2.1(obj3, f);
                        composer9.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($changed$iv);
                int i27 = i54;
                valueOf3 = 0;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, str);
                androidx.compose.ui.Modifier.Companion companion10 = Modifier.Companion;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($changed$iv, i54);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier($changed$iv, (Modifier)companion10);
                i56 |= 6;
                Function0 function02 = constructor;
                i9 = 0;
                i4 = i27;
                String $changed$iv3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, $changed$iv3);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed$iv.startReusableNode();
                if ($changed$iv.getInserting()) {
                    $changed$iv.createNode(function02);
                } else {
                    factory$iv$iv = function02;
                    $changed$iv.useNode();
                }
                composer8 = $changed$iv;
                Composer constructor-impl = Updater.constructor-impl(composer8);
                int i65 = 0;
                i10 = $dirty;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, $changed$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i66 = 0;
                Composer composer11 = constructor-impl;
                int i68 = 0;
                if (!composer11.getInserting()) {
                    $i$f$Layout = valueOf3;
                    function0 = factory$iv$iv;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer11;
                    }
                } else {
                    $i$f$Layout = valueOf3;
                    function0 = factory$iv$iv;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                $dirty = composer8;
                i21 = i33;
                ComposerKt.sourceInformationMarkerStart($dirty, -1180092681, "C320@13410L41:BottomNavigation.kt#jmzs0o");
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                int i67 = 0;
                i = i38;
                modifier2 = materializeModifier;
                materialized$iv = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($dirty, 733328855, materialized$iv);
                Alignment topStart = Alignment.Companion.getTopStart();
                i12 = i50;
                int $changed$iv5 = 0;
                i11 = i57;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, $changed$iv5);
                i8 = 0;
                i22 = topStart;
                ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, str);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($dirty, 0);
                currentCompositionLocalMap2 = $dirty.getCurrentCompositionLocalMap();
                i18 = $changed$iv5;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty, layoutId);
                $changed$iv2 = layoutId;
                Function0 function04 = constructor3;
                boxScopeInstance = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -692256719, $changed$iv3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty.startReusableNode();
                if ($dirty.getInserting()) {
                    $dirty.createNode(function04);
                } else {
                    factory$iv$iv$iv = function04;
                    $dirty.useNode();
                }
                obj = factory$iv$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl($dirty);
                int i73 = 0;
                companion = companion10;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i74 = 0;
                Composer composer13 = constructor-impl2;
                int i77 = 0;
                if (!composer13.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer13;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer10 = $dirty;
                str2 = 0;
                i19 = i37;
                $changed$iv = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, $changed$iv);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i76 |= 6;
                i17 = 0;
                modifier3 = materializeModifier2;
                materialized$iv$iv = composer;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 2094895896, "C320@13443L6:BottomNavigation.kt#jmzs0o");
                obj2.invoke(materialized$iv$iv, Integer.valueOf(i10 & 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                $dirty.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                if (obj3 != null) {
                    $dirty.startReplaceGroup(-1180022529);
                    ComposerKt.sourceInformation($dirty, "322@13501L253");
                    compositeKeyHash$iv = currentCompositeKeyHash;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label"), f), BottomNavigationKt.BottomNavigationItemHorizontalPadding, 0, 2, 0);
                    valueOf2 = i63;
                    str2 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, 733328855, materialized$iv);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i7 = 0;
                    obj54 = topStart2;
                    ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, str);
                    currentCompositionLocalMap = $dirty.getCurrentCompositionLocalMap();
                    i2 = currentCompositeKeyHash3;
                    modifier = padding-VpY3zN4$default;
                    Function0 function03 = constructor2;
                    i15 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -692256719, $changed$iv3);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty.startReusableNode();
                    if ($dirty.getInserting()) {
                        $dirty.createNode(function03);
                    } else {
                        factory$iv$iv$iv2 = function03;
                        $dirty.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl($dirty);
                    int i64 = 0;
                    currentCompositeKeyHash2 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i71 = 0;
                    Composer composer12 = constructor-impl3;
                    int i72 = 0;
                    if (!composer12.getInserting()) {
                        $changed$iv2 = valueOf2;
                        obj = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(i2))) {
                            composer12.updateRememberedValue(Integer.valueOf(i2));
                            constructor-impl3.apply(Integer.valueOf(i2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer12;
                        }
                    } else {
                        $changed$iv2 = valueOf2;
                        obj = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($dirty, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                    valueOf4 = $dirty;
                    materialized$iv$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf4, -2146769399, $changed$iv);
                    i53 |= 6;
                    composer6 = valueOf4;
                    i8 = 0;
                    i18 = i29;
                    boxScopeInstance = iNSTANCE2;
                    ComposerKt.sourceInformationMarkerStart(valueOf4, 2095195511, "C327@13745L7:BottomNavigation.kt#jmzs0o");
                    obj3.invoke(valueOf4, Integer.valueOf(i30 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(valueOf4);
                    ComposerKt.sourceInformationMarkerEnd(valueOf4);
                    $dirty.endNode();
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $dirty.endReplaceGroup();
                } else {
                    compositeKeyHash$iv = currentCompositeKeyHash;
                    $dirty.startReplaceGroup(-1179748644);
                    $dirty.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer8.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer8);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $changed$iv.skipToGroupEnd();
                composer8 = $changed$iv;
                i10 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer8.endRestartGroup();
        if (endRestartGroup != null) {
            $changed$iv = new BottomNavigationKt.BottomNavigationItemBaselineLayout.3(obj2, obj3, f, i23);
            endRestartGroup.updateScope((Function2)$changed$iv);
        }
    }

    private static final void BottomNavigationTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function3<? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        int i16;
        int $dirty;
        int i17;
        int i11;
        int i;
        int i15;
        boolean rememberComposableLambda;
        boolean traceInProgress2;
        int i9;
        int str;
        int i7;
        int i10;
        int i3;
        int i13;
        long lerp-jxsXWHM;
        int i2;
        int i12;
        int i4;
        int i8;
        int i5;
        int i6;
        int i14;
        final long l = activeColor;
        final long l2 = selected;
        final boolean z = $composer;
        final Object obj = $changed;
        final int i19 = obj33;
        traceInProgress = -985175058;
        final Composer restartGroup = obj32.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)286@12327L128,296@12669L42,293@12530L181:BottomNavigation.kt#jmzs0o");
        i9 = 2;
        if (i19 & 6 == 0) {
            i17 = restartGroup.changed(l) ? 4 : i9;
            $dirty |= i17;
        }
        if (i19 & 48 == 0) {
            i11 = restartGroup.changed(l2) ? 32 : 16;
            $dirty |= i11;
        }
        if (i19 & 384 == 0) {
            i = restartGroup.changed(z) ? 256 : 128;
            $dirty |= i;
        }
        if (i19 & 3072 == 0) {
            i15 = restartGroup.changedInstance(obj) ? 2048 : 1024;
            $dirty |= i15;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:285)");
                }
                i16 = z ? 1065353216 : 0;
                int i24 = 0;
                i13 = i14;
                $dirty = AnimateAsStateKt.animateFloatAsState(i16, (AnimationSpec)BottomNavigationKt.BottomNavigationAnimationSpec, 0, i24, 0, restartGroup, 48, 28);
                lerp-jxsXWHM = ColorKt.lerp-jxsXWHM(l2, obj4, l);
                ProvidedValue[] arr = new ProvidedValue[i9];
                arr[0] = ContentColorKt.getLocalContentColor().provides(Color.box-impl(Color.copy-wmQWz5c$default(lerp-jxsXWHM, obj18, 1065353216, 0, 0, 0, 14)));
                int i22 = 1;
                arr[i22] = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(lerp-jxsXWHM)));
                BottomNavigationKt.BottomNavigationTransition.1 anon = new BottomNavigationKt.BottomNavigationTransition.1(obj, $dirty);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-138092754, i22, anon, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i13 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new BottomNavigationKt.BottomNavigationTransition.2(l, obj2, l2, obj4, z, obj, i19);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final float BottomNavigationTransition_Klgx_Pg$lambda$2(State<Float> $animationProgress$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$animationProgress$delegate.getValue().floatValue();
    }

    public static final void access$BottomNavigationItemBaselineLayout(Function2 icon, Function2 label, float iconPositionAnimationProgress, Composer $composer, int $changed) {
        BottomNavigationKt.BottomNavigationItemBaselineLayout(icon, label, iconPositionAnimationProgress, $composer, $changed);
    }

    public static final void access$BottomNavigationTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function3 content, Composer $composer, int $changed) {
        BottomNavigationKt.BottomNavigationTransition-Klgx-Pg(activeColor, inactiveColor, selected, content, $composer, $changed);
    }

    public static final float access$BottomNavigationTransition_Klgx_Pg$lambda$2(State $animationProgress$delegate) {
        return BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$2($animationProgress$delegate);
    }

    public static final float access$getBottomNavigationHeight$p() {
        return BottomNavigationKt.BottomNavigationHeight;
    }

    public static final MeasureResult access$placeIcon-3p2s80s(MeasureScope $receiver, Placeable iconPlaceable, long constraints) {
        return BottomNavigationKt.placeIcon-3p2s80s($receiver, iconPlaceable, constraints);
    }

    public static final MeasureResult access$placeLabelAndIcon-DIyivk0(MeasureScope $receiver, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        return BottomNavigationKt.placeLabelAndIcon-DIyivk0($receiver, labelPlaceable, iconPlaceable, constraints, iconPositionAnimationProgress);
    }

    private static final MeasureResult placeIcon-3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, Placeable iconPlaceable, long constraints) {
        final int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(constraints, obj11);
        BottomNavigationKt.placeIcon.1 anon = new BottomNavigationKt.placeIcon.1(iconPlaceable, i /= 2);
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, iconPlaceable.getWidth(), constrainHeight-K40F9xA, 0, (Function1)anon, 4, 0);
    }

    private static final MeasureResult placeLabelAndIcon-DIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        MeasureScope measureScope = $this$placeLabelAndIcon_u2dDIyivk0;
        Placeable placeable = labelPlaceable;
        final int i25 = roundToPx-0680j_42 - i24;
        final int i26 = i3 + i25;
        int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(constraints, obj3);
        final int i23 = coerceAtLeast;
        int i16 = i11 + i25;
        final int i28 = Math.max(placeable.getWidth(), iconPlaceable.getWidth());
        i12 /= 2;
        int i19 = i27 - i23;
        final int i29 = i19;
        int iconDistance = roundToInt;
        BottomNavigationKt.placeLabelAndIcon.1 anon = new BottomNavigationKt.placeLabelAndIcon.1(obj25, placeable, i13, i16, iconDistance, iconPlaceable, i18 / 2, i23);
        int i21 = i13;
        final int i30 = iconDistance;
        int offset = i16;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dDIyivk0, i28, constrainHeight-K40F9xA, 0, (Function1)anon, 4, 0);
    }
}
