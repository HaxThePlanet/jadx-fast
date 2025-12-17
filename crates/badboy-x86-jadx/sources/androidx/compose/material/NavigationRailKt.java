package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0082\u0001\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00012 \u0008\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001az\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00012 \u0008\u0002\u0010\u0016\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\u0008\u0019¢\u0006\u0002\u0008\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u0090\u0001\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u000c\u0010#\u001a\u0008\u0012\u0004\u0012\u00020\u000e0$2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u000e0$¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010&\u001a\u00020\"2\u0015\u0008\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010$¢\u0006\u0002\u0008\u00192\u0008\u0008\u0002\u0010(\u001a\u00020\"2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0008\u0008\u0002\u0010+\u001a\u00020\u00132\u0008\u0008\u0002\u0010,\u001a\u00020\u0013H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010.\u001a?\u0010/\u001a\u00020\u000e2\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u000e0$¢\u0006\u0002\u0008\u00192\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u000e\u0018\u00010$¢\u0006\u0002\u0008\u00192\u0008\u0008\u0001\u00100\u001a\u00020\u0007H\u0003¢\u0006\u0002\u00101\u001aR\u00102\u001a\u00020\u000e2\u0006\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"2&\u0010\u001b\u001a\"\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u00085\u0012\u0008\u00086\u0012\u0004\u0008\u0008(7\u0012\u0004\u0012\u00020\u000e0\u0017¢\u0006\u0002\u0008\u0019H\u0003ø\u0001\u0000¢\u0006\u0004\u00088\u00109\u001a&\u0010:\u001a\u00020;*\u00020<2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\u0008A\u0010B\u001a8\u0010C\u001a\u00020;*\u00020<2\u0006\u0010D\u001a\u00020>2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0008\u0008\u0001\u00100\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0014\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006G²\u0006\n\u00107\u001a\u00020\u0007X\u008a\u0084\u0002", d2 = {"HeaderPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ItemIconTopOffset", "ItemLabelBaselineBottomOffset", "NavigationRailAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "NavigationRailItemCompactSize", "NavigationRailItemSize", "NavigationRailPadding", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "NavigationRail", "", "windowInsets", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "NavigationRail-afqeVBk", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRail-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "NavigationRailItem-0S3VyRs", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "NavigationRailItemBaselineLayout", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "NavigationRailTransition", "activeColor", "inactiveColor", "Lkotlin/ParameterName;", "name", "animationProgress", "NavigationRailTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavigationRailKt {

    private static final float HeaderPadding;
    private static final float ItemIconTopOffset;
    private static final float ItemLabelBaselineBottomOffset;
    private static final TweenSpec<Float> NavigationRailAnimationSpec;
    private static final float NavigationRailItemCompactSize;
    private static final float NavigationRailItemSize;
    private static final float NavigationRailPadding;
    private static final WindowInsets ZeroInsets;
    static {
        TweenSpec tweenSpec = new TweenSpec(300, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
        NavigationRailKt.NavigationRailAnimationSpec = tweenSpec;
        int i9 = 0;
        NavigationRailKt.NavigationRailItemSize = Dp.constructor-impl((float)i);
        int i10 = 0;
        NavigationRailKt.NavigationRailItemCompactSize = Dp.constructor-impl((float)i2);
        int i11 = 0;
        NavigationRailKt.NavigationRailPadding = Dp.constructor-impl((float)i3);
        int i12 = 0;
        NavigationRailKt.HeaderPadding = Dp.constructor-impl((float)i4);
        int i13 = 0;
        NavigationRailKt.ItemLabelBaselineBottomOffset = Dp.constructor-impl((float)i5);
        int i14 = 0;
        NavigationRailKt.ItemIconTopOffset = Dp.constructor-impl((float)i6);
        int i15 = 0;
        NavigationRailKt.ZeroInsets = WindowInsetsKt.WindowInsets-a9UjIt4$default(Dp.constructor-impl((float)i7), 0, 0, 0, 14, 0);
    }

    public static final void NavigationRail-HsRjFd4(Modifier modifier, long backgroundColor, long contentColor, float elevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> header, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        int defaultsInvalid;
        Object modifier2;
        int modifier3;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int surface-0d7_KjU;
        int backgroundColor2;
        int i;
        int i5;
        Object obj;
        boolean traceInProgress2;
        long l;
        int i2;
        long str;
        float f;
        int changed2;
        long l2;
        Object obj2;
        int i6;
        int changed;
        int zeroInsets;
        float f3;
        Object elevation2;
        int modifier4;
        int i7;
        long i3;
        Object obj4;
        int i4;
        Object obj5;
        int i12;
        int i11;
        float f2;
        Object obj3;
        Composer composer;
        Composer composer2;
        int i10;
        int i8;
        final int i44 = obj31;
        Composer restartGroup = i9.startRestartGroup(1790971523);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRail)P(5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)168@7492L6,169@7534L32,174@7736L95:NavigationRail.kt#jmzs0o");
        $dirty2 = obj31;
        i5 = obj32 & 1;
        if (i5 != 0) {
            $dirty2 |= 6;
            obj = modifier;
        } else {
            if (i44 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                obj = modifier;
            }
        }
        if (i44 & 48 == 0) {
            if (obj32 & 2 == 0) {
                changed2 = restartGroup.changed(backgroundColor) ? 32 : 16;
            } else {
                str = backgroundColor;
            }
            $dirty2 |= changed2;
        } else {
            str = backgroundColor;
        }
        if (i44 & 384 == 0) {
            if (obj32 & 4 == 0) {
                changed = restartGroup.changed(elevation) ? 256 : 128;
            } else {
                l2 = elevation;
            }
            $dirty2 |= changed;
        } else {
            l2 = elevation;
        }
        zeroInsets = obj32 & 8;
        if (zeroInsets != 0) {
            $dirty2 |= 3072;
            f3 = content;
        } else {
            if (i44 & 3072 == 0) {
                i7 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                f3 = content;
            }
        }
        i3 = obj32 & 16;
        if (i3 != 0) {
            $dirty2 |= 24576;
            obj4 = $composer;
        } else {
            if (i44 & 24576 == 0) {
                i4 = restartGroup.changedInstance($composer) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                obj4 = $composer;
            }
        }
        i12 = 196608;
        if (obj32 & 32 != 0) {
            $dirty2 |= i12;
            obj5 = $changed;
        } else {
            if (i44 & i12 == 0) {
                i12 = restartGroup.changedInstance($changed) ? 131072 : 65536;
                $dirty2 |= i12;
            } else {
                obj5 = $changed;
            }
        }
        if (i49 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i11 = 6;
                if (i44 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i5 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
                        }
                        if (obj32 & 2 != 0) {
                            $dirty2 &= -113;
                            str = surface-0d7_KjU;
                        }
                        if (obj32 & 4 != 0) {
                            $dirty2 &= -897;
                            l2 = backgroundColor2;
                        }
                        if (zeroInsets != 0) {
                            f3 = backgroundColor2;
                        }
                        if (i3 != 0) {
                            obj3 = i22;
                            i3 = str;
                            f2 = f3;
                            i = 1790971523;
                            elevation2 = modifier2;
                            modifier3 = i11;
                            obj5 = l2;
                        } else {
                            f2 = f3;
                            obj3 = obj4;
                            i = 1790971523;
                            elevation2 = modifier2;
                            i3 = str;
                            modifier3 = i11;
                            obj5 = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj32 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj32 & 4 != 0) {
                            $dirty2 = i21;
                            f2 = f3;
                            obj3 = obj4;
                            modifier3 = i11;
                            i = 1790971523;
                            elevation2 = obj;
                            i3 = str;
                            obj5 = l2;
                        } else {
                            f2 = f3;
                            obj3 = obj4;
                            modifier3 = i11;
                            i = 1790971523;
                            elevation2 = obj;
                            i3 = str;
                            obj5 = l2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i, $dirty2, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:173)");
                }
                NavigationRailKt.NavigationRail-afqeVBk(NavigationRailKt.ZeroInsets, elevation2, i3, obj4, obj5, i11, f2, obj3, $changed, restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2 = elevation2;
                l = obj5;
                f = f2;
                obj2 = obj3;
                modifier4 = $dirty2;
                $dirty = i3;
            } else {
                restartGroup.skipToGroupEnd();
                modifier4 = $dirty2;
                $dirty = str;
                f = f4;
                composer2 = restartGroup;
                $composer2 = obj;
                l = l2;
                obj2 = obj4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationRailKt.NavigationRail.3($composer2, $dirty, i5, l, str, f, obj2, $changed, i44, obj32);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void NavigationRail-afqeVBk(WindowInsets windowInsets, Modifier modifier, long backgroundColor, long contentColor, float elevation, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> header, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int skipping;
        int defaultsInvalid;
        int colors;
        int elevation-D9Ej5fM;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int i9;
        int i3;
        int i13;
        Object obj;
        boolean traceInProgress;
        long l2;
        int i6;
        long surface-0d7_KjU;
        float f2;
        int changed;
        int i4;
        Object obj2;
        boolean changed2;
        long contentColor2;
        int i;
        float elevation2;
        int i11;
        Object obj3;
        int i12;
        int i2;
        int i5;
        float f;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i7;
        int i8;
        long l;
        final Object obj4 = windowInsets;
        final Object obj6 = $changed;
        final int i35 = obj35;
        Composer restartGroup = i10.startRestartGroup(-1389243291);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRail)P(6,5,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.unit.Dp,4)103@4797L6,104@4839L32,114@5185L459,109@5041L603:NavigationRail.kt#jmzs0o");
        $dirty2 = obj35;
        if (obj36 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i35 & 6 == 0) {
                i9 = restartGroup.changed(obj4) ? 4 : 2;
                $dirty2 |= i9;
            }
        }
        int i19 = obj36 & 2;
        if (i19 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if (i35 & 48 == 0) {
                i6 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj = modifier;
            }
        }
        if (i35 & 384 == 0) {
            if (obj36 & 4 == 0) {
                changed = restartGroup.changed(backgroundColor) ? 256 : 128;
            } else {
                surface-0d7_KjU = backgroundColor;
            }
            $dirty2 |= changed;
        } else {
            surface-0d7_KjU = backgroundColor;
        }
        if (i35 & 3072 == 0) {
            if (obj36 & 8 == 0) {
                i4 = restartGroup.changed(elevation) ? 2048 : 1024;
            } else {
                contentColor2 = elevation;
            }
            $dirty2 |= i4;
        } else {
            contentColor2 = elevation;
        }
        int i34 = obj36 & 16;
        if (i34 != 0) {
            $dirty2 |= 24576;
            elevation2 = content;
        } else {
            if (i35 & 24576 == 0) {
                i11 = restartGroup.changed(content) ? 16384 : 8192;
                $dirty2 |= i11;
            } else {
                elevation2 = content;
            }
        }
        int i38 = obj36 & 32;
        int i39 = 196608;
        if (i38 != 0) {
            $dirty2 |= i39;
            obj3 = $composer;
        } else {
            if (i39 &= i35 == 0) {
                i12 = restartGroup.changedInstance($composer) ? 131072 : 65536;
                $dirty2 |= i12;
            } else {
                obj3 = $composer;
            }
        }
        i5 = 1572864;
        if (obj36 & 64 != 0) {
            $dirty2 |= i5;
        } else {
            if (i35 & i5 == 0) {
                i2 = restartGroup.changedInstance(obj6) ? 1048576 : 524288;
                $dirty2 |= i2;
            }
        }
        int i41 = 599187;
        if ($dirty2 & i41 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i35 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i19 != 0) {
                            obj = defaultsInvalid;
                        }
                        if (obj36 & 4 != 0) {
                            surface-0d7_KjU = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getSurface-0d7_KjU();
                            $dirty2 &= -897;
                        }
                        if (obj36 & 8 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(surface-0d7_KjU, obj7, restartGroup);
                            $dirty2 &= -7169;
                        }
                        if (i34 != 0) {
                            elevation2 = elevation-D9Ej5fM;
                        }
                        if (i38 != 0) {
                            skipping = 0;
                            obj3 = contentColor2;
                            f = elevation2;
                            i13 = -1389243291;
                            contentColor2 = obj;
                            elevation2 = surface-0d7_KjU;
                        } else {
                            f = elevation2;
                            skipping = obj3;
                            i13 = -1389243291;
                            elevation2 = surface-0d7_KjU;
                            obj3 = contentColor2;
                            contentColor2 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj36 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj36 & 8 != 0) {
                            $dirty2 = i18;
                            f = elevation2;
                            skipping = obj3;
                            i13 = -1389243291;
                            elevation2 = surface-0d7_KjU;
                            obj3 = contentColor2;
                            contentColor2 = obj;
                        } else {
                            f = elevation2;
                            skipping = obj3;
                            i13 = -1389243291;
                            elevation2 = surface-0d7_KjU;
                            obj3 = contentColor2;
                            contentColor2 = obj;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i13, $dirty2, -1, "androidx.compose.material.NavigationRail (NavigationRail.kt:108)");
                }
                NavigationRailKt.NavigationRail.1 anon = new NavigationRailKt.NavigationRail.1(obj4, skipping, obj6);
                SurfaceKt.Surface-F-jzlyU(contentColor2, 0, elevation2, i38, obj3, i41, 0, f, (Function2)ComposableLambdaKt.rememberComposableLambda(-245908831, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = skipping;
                i = $dirty2;
                $composer2 = contentColor2;
                $dirty = elevation2;
                l2 = obj3;
                f2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                obj2 = obj3;
                i = $dirty2;
                $dirty = surface-0d7_KjU;
                l2 = l;
                f2 = elevation2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new NavigationRailKt.NavigationRail.2(obj4, $composer2, $dirty, i3, l2, surface-0d7_KjU, f2, obj2, obj6, i35, obj36);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    public static final void NavigationRailItem-0S3VyRs(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i13) {
        Object function3;
        int i18;
        int changed;
        int skipping;
        int $dirty4;
        int $dirty;
        float navigationRailItemSize;
        int defaultsInvalid;
        int changed2;
        Function0 factory$iv$iv$iv;
        int restartGroup;
        int $dirty5;
        int $dirty2;
        boolean valueOf;
        boolean $dirty3;
        int obj;
        boolean z;
        long l;
        long copy-wmQWz5c$default;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy;
        Object obj4;
        int i5;
        Object obj5;
        boolean z3;
        int i19;
        int i8;
        int i3;
        boolean traceInProgress;
        Object obj2;
        Object l2;
        boolean modifier2;
        int i15;
        int localContentColor;
        int i6;
        boolean z2;
        long interactionSource2;
        int i10;
        int it;
        Object obj3;
        long label2;
        int i17;
        int i21;
        boolean z4;
        int i9;
        int i7;
        int i14;
        int i23;
        int i2;
        float f;
        long selectedContentColor2;
        long unbox-impl;
        int i16;
        float medium;
        int i12;
        int i25;
        int i24;
        int i;
        int i4;
        int i20;
        Function0 function0;
        int i11;
        Composer $composer2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Composer composer2;
        int i22;
        int obj40;
        Composer obj41;
        long obj42;
        androidx.compose.foundation.Indication obj43;
        Function3 obj44;
        androidx.compose.runtime.internal.ComposableLambda obj45;
        Composer obj46;
        int obj47;
        int obj48;
        BoxScopeInstance obj49;
        obj = icon;
        final int i79 = obj50;
        final int i80 = obj51;
        restartGroup = i13.startRestartGroup(-1813548445);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRailItem)P(7,6,2,5,1,4!2,8:c#ui.graphics.Color,9:c#ui.graphics.Color)210@9648L6,211@9718L7,211@9752L6,226@10550L99,230@10654L804:NavigationRail.kt#jmzs0o");
        $dirty5 = obj50;
        if (i80 & 1 != 0) {
            $dirty5 |= 6;
            z = selected;
        } else {
            if (i79 & 6 == 0) {
                i5 = restartGroup.changed(selected) ? 4 : 2;
                $dirty5 |= i5;
            } else {
                z = selected;
            }
        }
        if (i80 & 2 != 0) {
            $dirty5 |= 48;
            obj5 = onClick;
        } else {
            if (i79 & 48 == 0) {
                i19 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty5 |= i19;
            } else {
                obj5 = onClick;
            }
        }
        if (i80 & 4 != 0) {
            $dirty5 |= 384;
        } else {
            if (i79 & 384 == 0) {
                i8 = restartGroup.changedInstance(obj) ? 256 : 128;
                $dirty5 |= i8;
            }
        }
        int i61 = i80 & 8;
        if (i61 != 0) {
            $dirty5 |= 3072;
            l2 = modifier;
        } else {
            if (i79 & 3072 == 0) {
                i15 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty5 |= i15;
            } else {
                l2 = modifier;
            }
        }
        localContentColor = i80 & 16;
        if (localContentColor != 0) {
            $dirty5 |= 24576;
            z2 = enabled;
        } else {
            if (i79 & 24576 == 0) {
                i10 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty5 |= i10;
            } else {
                z2 = enabled;
            }
        }
        it = i80 & 32;
        int i76 = 196608;
        if (it != 0) {
            $dirty5 |= i76;
            obj3 = label;
        } else {
            if (i76 &= i79 == 0) {
                i17 = restartGroup.changedInstance(label) ? 131072 : 65536;
                $dirty5 |= i17;
            } else {
                obj3 = label;
            }
        }
        i21 = i80 & 64;
        int i81 = 1572864;
        if (i21 != 0) {
            $dirty5 |= i81;
            z4 = alwaysShowLabel;
        } else {
            if (i81 &= i79 == 0) {
                i9 = restartGroup.changed(alwaysShowLabel) ? 1048576 : 524288;
                $dirty5 |= i9;
            } else {
                z4 = alwaysShowLabel;
            }
        }
        int i27 = i80 & 128;
        int i83 = 12582912;
        if (i27 != 0) {
            $dirty5 |= i83;
            i14 = i27;
            function3 = interactionSource;
        } else {
            if (i79 & i83 == 0) {
                i14 = i27;
                i23 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty5 |= i23;
            } else {
                i14 = i27;
                function3 = interactionSource;
            }
        }
        if (i79 & i86 == 0) {
            if (i80 & 256 == 0) {
                function3 = restartGroup.changed(selectedContentColor) ? 67108864 : 33554432;
            } else {
                l = selectedContentColor;
            }
            $dirty5 |= function3;
        } else {
            l = selectedContentColor;
        }
        if (i28 &= i79 == 0) {
            if (i80 & 512 == 0) {
                i18 = restartGroup.changed($composer) ? 536870912 : 268435456;
            } else {
                copy-wmQWz5c$default = $composer;
            }
            $dirty5 |= i18;
        } else {
            copy-wmQWz5c$default = $composer;
        }
        obj49 = $dirty5;
        if (i29 &= $dirty5 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i87 = -234881025;
                int i88 = -1879048193;
                if (i79 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i61 != 0) {
                            l2 = defaultsInvalid;
                        }
                        if (localContentColor != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (it != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i21 != 0) {
                            z4 = defaultsInvalid;
                        }
                        $dirty = i14 != 0 ? 0 : interactionSource;
                        if (i80 & 256 != 0) {
                            selectedContentColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, 6).getPrimary-0d7_KjU();
                            i3 = obj49 & i87;
                        } else {
                            selectedContentColor2 = selectedContentColor;
                            i3 = obj49;
                        }
                        if (i80 & 512 != 0) {
                            it = 6;
                            i21 = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            copy-wmQWz5c$default = Color.copy-wmQWz5c$default((Color)restartGroup.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl(), obj23, ContentAlpha.INSTANCE.getMedium(restartGroup, 6), 0, 0, 0, 14);
                            $dirty2 = i33;
                            $dirty = obj40;
                        } else {
                            obj40 = $dirty;
                            $dirty2 = i3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty4 = i80 & 256 != 0 ? obj49 & i87 : obj49;
                        if (i80 & 512 != 0) {
                            $dirty4 &= i88;
                        }
                        selectedContentColor2 = selectedContentColor;
                        $dirty2 = $dirty4;
                        $dirty = interactionSource;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1813548445, $dirty2, -1, "androidx.compose.material.NavigationRailItem (NavigationRail.kt:212)");
                }
                if (obj3 == null) {
                    restartGroup.startReplaceGroup(1653256326);
                    restartGroup.endReplaceGroup();
                    it = 0;
                    obj48 = $dirty;
                    i7 = $dirty2;
                } else {
                    restartGroup.startReplaceGroup(1653256327);
                    ComposerKt.sourceInformation(restartGroup, "*214@9846L156");
                    Object obj7 = obj3;
                    i21 = 0;
                    traceInProgress = new NavigationRailKt.NavigationRailItem.styledLabel.1.1(obj3);
                    obj48 = $dirty;
                    i7 = $dirty2;
                    it = $dirty;
                    restartGroup.endReplaceGroup();
                }
                navigationRailItemSize = obj3 == null ? NavigationRailKt.NavigationRailItemCompactSize : NavigationRailKt.NavigationRailItemSize;
                obj44 = restartGroup;
                valueOf = obj44;
                obj42 = obj48;
                obj43 = rippleOrFallbackImplementation-9IZ8Weo;
                obj44 = z2;
                Modifier size-3ABfNKs = SizeKt.size-3ABfNKs(SelectableKt.selectable-O2vRcR0(l2, selected, obj42, obj43, obj44, Role.box-impl(Role.Companion.getTab-o7Vup1c()), onClick), navigationRailItemSize);
                i2 = 48;
                i14 = 0;
                f = navigationRailItemSize;
                ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                int i31 = 0;
                obj42 = copy-wmQWz5c$default;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getCenter(), i31);
                unbox-impl = 0;
                obj48 = i31;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                medium = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf, size-3ABfNKs);
                i25 = size-3ABfNKs;
                int i89 = 6;
                Function0 function02 = constructor;
                i12 = 0;
                i4 = indication;
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
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, valueOf.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i91 = 0;
                obj41 = constructor-impl;
                int i93 = 0;
                if (!obj41.getInserting()) {
                    $composer2 = valueOf;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(obj41.rememberedValue(), Integer.valueOf(medium))) {
                        obj41.updateRememberedValue(Integer.valueOf(medium));
                        constructor-impl.apply(Integer.valueOf(medium), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj41;
                    }
                } else {
                    $composer2 = valueOf;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = $composer2;
                i24 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                int i92 = 6;
                i66 |= 6;
                i20 = 0;
                obj49 = iNSTANCE;
                i11 = i37;
                ComposerKt.sourceInformationMarkerStart(composer3, 1725519044, "C247@11162L290,243@11035L417:NavigationRail.kt#jmzs0o");
                NavigationRailKt.NavigationRailItem.1.1 anon = new NavigationRailKt.NavigationRailItem.1.1(z4, obj, it);
                i22 = i54;
                NavigationRailKt.NavigationRailTransition-Klgx-Pg(selectedContentColor2, obj41, obj42, obj43, selected, (Function3)ComposableLambdaKt.rememberComposableLambda(670576792, true, anon, composer3, 54));
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i6 = i73;
                obj2 = obj3;
                z3 = i21;
                interactionSource2 = selectedContentColor2;
                label2 = skipping;
                obj4 = l2;
                modifier2 = z4;
            } else {
                restartGroup.skipToGroupEnd();
                i6 = interactionSource;
                i7 = obj49;
                $composer2 = restartGroup;
                obj2 = obj3;
                label2 = copy-wmQWz5c$default;
                z3 = z2;
                interactionSource2 = selectedContentColor;
                obj4 = l2;
                modifier2 = z4;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            skipping = new NavigationRailKt.NavigationRailItem.2(selected, onClick, icon, obj4, z3, obj2, modifier2, i6, interactionSource2, it, label2, i21, i79, i80);
            endRestartGroup.updateScope((Function2)skipping);
        }
    }

    private static final void NavigationRailItemBaselineLayout(Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, float iconPositionAnimationProgress, Composer $composer, int $changed) {
        int traceInProgress2;
        int i4;
        Integer valueOf;
        Function0 factory$iv$iv$iv2;
        Object $changed$iv2;
        Function0 factory$iv$iv$iv;
        int $dirty;
        int i6;
        int i17;
        int i13;
        boolean valueOf2;
        boolean traceInProgress;
        int i14;
        Integer valueOf3;
        boolean currentCompositionLocalMap3;
        int $changed$iv;
        Function0 factory$iv$iv;
        Composer composer5;
        int str;
        boolean currentCompositionLocalMap2;
        int materialized$iv$iv;
        Composer composer6;
        Object maybeCachedBoxMeasurePolicy2;
        int i19;
        Composer composer8;
        Object maybeCachedBoxMeasurePolicy;
        int empty;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier;
        int i3;
        Composer composer7;
        int i2;
        int i10;
        Composer composer4;
        int i8;
        int i9;
        int i20;
        int i11;
        int i18;
        int $i$f$Layout;
        Function0 function0;
        int i15;
        int i12;
        androidx.compose.ui.Modifier.Companion companion;
        Alignment alignment;
        Modifier modifier;
        int i5;
        int currentCompositeKeyHash;
        Function0 function02;
        int i7;
        Object obj;
        Object localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy2;
        Composer composer;
        BoxScopeInstance iNSTANCE;
        int i21;
        int i16;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i;
        Composer composer2;
        Modifier modifier2;
        int obj53;
        final Object obj2 = icon;
        final Object obj3 = label;
        final float f = iconPositionAnimationProgress;
        final int i22 = $changed;
        traceInProgress2 = -1903861684;
        $changed$iv2 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation($changed$iv2, "C(NavigationRailItemBaselineLayout)P(!1,2)339@14190L806,328@13870L1126:NavigationRail.kt#jmzs0o");
        if (i22 & 6 == 0) {
            i6 = $changed$iv2.changedInstance(obj2) ? 4 : 2;
            $dirty |= i6;
        }
        $changed$iv = 32;
        if (i22 & 48 == 0) {
            i17 = $changed$iv2.changedInstance(obj3) ? $changed$iv : 16;
            $dirty |= i17;
        }
        str = 256;
        if (i22 & 384 == 0) {
            i13 = $changed$iv2.changed(f) ? str : 128;
            $dirty |= i13;
        }
        if ($dirty & 147 == 146) {
            if (!$changed$iv2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.NavigationRailItemBaselineLayout (NavigationRail.kt:327)");
                }
                ComposerKt.sourceInformationMarkerStart($changed$iv2, 297377652, "CC(remember):NavigationRail.kt#9igjgp");
                int i52 = 0;
                i4 = $dirty & 112 == $changed$iv ? i14 : i52;
                if ($dirty & 896 == str) {
                } else {
                    i14 = i52;
                }
                Composer composer9 = $changed$iv2;
                int i46 = 0;
                Object rememberedValue3 = composer9.rememberedValue();
                int i61 = 0;
                if (i4 |= i14 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new NavigationRailKt.NavigationRailItemBaselineLayout.2.1(obj3, f);
                        composer9.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($changed$iv2);
                int i26 = i52;
                valueOf3 = 0;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($changed$iv2, -1323940314, str);
                androidx.compose.ui.Modifier.Companion companion10 = Modifier.Companion;
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash($changed$iv2, i52);
                i54 |= 6;
                Function0 function03 = constructor;
                i3 = 0;
                i10 = i26;
                String $changed$iv3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($changed$iv2, -692256719, $changed$iv3);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed$iv2.startReusableNode();
                if ($changed$iv2.getInserting()) {
                    $changed$iv2.createNode(function03);
                } else {
                    factory$iv$iv = function03;
                    $changed$iv2.useNode();
                }
                composer7 = $changed$iv2;
                Composer constructor-impl = Updater.constructor-impl(composer7);
                int i65 = 0;
                i20 = $dirty;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, $changed$iv2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i66 = 0;
                Composer composer11 = constructor-impl;
                int i67 = 0;
                if (!composer11.getInserting()) {
                    $i$f$Layout = valueOf3;
                    function0 = factory$iv$iv;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer11;
                    }
                } else {
                    $i$f$Layout = valueOf3;
                    function0 = factory$iv$iv;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($changed$iv2, (Modifier)companion10), ComposeUiNode.Companion.getSetModifier());
                $dirty = composer7;
                i8 = i33;
                ComposerKt.sourceInformationMarkerStart($dirty, 531590565, "C330@13900L41:NavigationRail.kt#jmzs0o");
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                i9 = 0;
                i11 = i38;
                i18 = i50;
                $changed$iv = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart($dirty, 733328855, $changed$iv);
                Alignment topStart = Alignment.Companion.getTopStart();
                i15 = i55;
                int $changed$iv$iv = 0;
                companion = companion10;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, $changed$iv$iv);
                modifier = 0;
                i5 = topStart;
                ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, str);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($dirty, 0);
                currentCompositionLocalMap3 = $dirty.getCurrentCompositionLocalMap();
                function02 = $changed$iv$iv;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($dirty, layoutId);
                obj = layoutId;
                Function0 function05 = constructor3;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -692256719, $changed$iv3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $dirty.startReusableNode();
                if ($dirty.getInserting()) {
                    $dirty.createNode(function05);
                } else {
                    factory$iv$iv$iv = function05;
                    $dirty.useNode();
                }
                localMap$iv$iv = factory$iv$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl($dirty);
                int i72 = 0;
                i21 = currentCompositeKeyHash3;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i73 = 0;
                Composer composer13 = constructor-impl2;
                int i76 = 0;
                if (!composer13.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer8 = composer13;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer10 = $dirty;
                i19 = 0;
                composer = i37;
                $changed$iv2 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, $changed$iv2);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i75 |= 6;
                i = 0;
                modifier2 = materializeModifier2;
                materialized$iv$iv = composer3;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 2021607057, "C330@13933L6:NavigationRail.kt#jmzs0o");
                obj2.invoke(materialized$iv$iv, Integer.valueOf(i20 & 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                $dirty.endNode();
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                if (obj3 != null) {
                    $dirty.startReplaceGroup(531660717);
                    ComposerKt.sourceInformation($dirty, "332@13991L168");
                    Modifier alpha = AlphaKt.alpha(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label"), f);
                    i19 = i56;
                    ComposerKt.sourceInformationMarkerStart($dirty, 733328855, $changed$iv);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i9 = i57;
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false);
                    i12 = 0;
                    alignment = topStart2;
                    ComposerKt.sourceInformationMarkerStart($dirty, -1323940314, str);
                    currentCompositionLocalMap2 = $dirty.getCurrentCompositionLocalMap();
                    obj53 = currentCompositeKeyHash2;
                    modifier = alpha;
                    Function0 function04 = constructor2;
                    i2 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -692256719, $changed$iv3);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty.startReusableNode();
                    if ($dirty.getInserting()) {
                        $dirty.createNode(function04);
                    } else {
                        factory$iv$iv$iv2 = function04;
                        $dirty.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl($dirty);
                    int i64 = 0;
                    function02 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i70 = 0;
                    Composer composer12 = constructor-impl3;
                    int i71 = 0;
                    if (!composer12.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap2;
                        measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(obj53))) {
                            composer12.updateRememberedValue(Integer.valueOf(obj53));
                            constructor-impl3.apply(Integer.valueOf(obj53), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer12;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap2;
                        measurePolicy2 = maybeCachedBoxMeasurePolicy2;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($dirty, alpha), ComposeUiNode.Companion.getSetModifier());
                    valueOf2 = $dirty;
                    str = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, -2146769399, $changed$iv2);
                    i60 |= 6;
                    composer4 = valueOf2;
                    i5 = 0;
                    i7 = i28;
                    obj = iNSTANCE2;
                    ComposerKt.sourceInformationMarkerStart(valueOf2, 2021822352, "C336@14150L7:NavigationRail.kt#jmzs0o");
                    obj3.invoke(valueOf2, Integer.valueOf(i29 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    ComposerKt.sourceInformationMarkerEnd(valueOf2);
                    $dirty.endNode();
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $dirty.endReplaceGroup();
                } else {
                    $dirty.startReplaceGroup(531852917);
                    $dirty.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $changed$iv2.skipToGroupEnd();
                composer7 = $changed$iv2;
                i20 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer7.endRestartGroup();
        if (endRestartGroup != null) {
            $changed$iv2 = new NavigationRailKt.NavigationRailItemBaselineLayout.3(obj2, obj3, f, i22);
            endRestartGroup.updateScope((Function2)$changed$iv2);
        }
    }

    private static final void NavigationRailTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function3<? super Float, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        int i3;
        int $dirty;
        int i4;
        int i7;
        int i13;
        int i9;
        boolean rememberComposableLambda;
        boolean traceInProgress;
        int i12;
        int str;
        int i11;
        int i10;
        int i6;
        int i;
        long lerp-jxsXWHM;
        int i15;
        int i14;
        int i16;
        int i17;
        int i8;
        int i5;
        int i2;
        final long l = activeColor;
        final long l2 = selected;
        final boolean z = $composer;
        final Object obj = $changed;
        final int i19 = obj33;
        traceInProgress2 = -207161906;
        final Composer restartGroup = obj32.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRailTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)296@12823L126,306@13163L42,303@13024L181:NavigationRail.kt#jmzs0o");
        i12 = 2;
        if (i19 & 6 == 0) {
            i4 = restartGroup.changed(l) ? 4 : i12;
            $dirty |= i4;
        }
        if (i19 & 48 == 0) {
            i7 = restartGroup.changed(l2) ? 32 : 16;
            $dirty |= i7;
        }
        if (i19 & 384 == 0) {
            i13 = restartGroup.changed(z) ? 256 : 128;
            $dirty |= i13;
        }
        if (i19 & 3072 == 0) {
            i9 = restartGroup.changedInstance(obj) ? 2048 : 1024;
            $dirty |= i9;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.NavigationRailTransition (NavigationRail.kt:295)");
                }
                i3 = z ? 1065353216 : 0;
                int i24 = 0;
                i = i2;
                $dirty = AnimateAsStateKt.animateFloatAsState(i3, (AnimationSpec)NavigationRailKt.NavigationRailAnimationSpec, 0, i24, 0, restartGroup, 48, 28);
                lerp-jxsXWHM = ColorKt.lerp-jxsXWHM(l2, obj4, l);
                ProvidedValue[] arr = new ProvidedValue[i12];
                arr[0] = ContentColorKt.getLocalContentColor().provides(Color.box-impl(Color.copy-wmQWz5c$default(lerp-jxsXWHM, obj18, 1065353216, 0, 0, 0, 14)));
                int i22 = 1;
                arr[i22] = ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.getAlpha-impl(lerp-jxsXWHM)));
                NavigationRailKt.NavigationRailTransition.1 anon = new NavigationRailKt.NavigationRailTransition.1(obj, $dirty);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-1688205042, i22, anon, restartGroup, 54), restartGroup, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationRailKt.NavigationRailTransition.2(l, obj2, l2, obj4, z, obj, i19);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final float NavigationRailTransition_Klgx_Pg$lambda$2(State<Float> $animationProgress$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$animationProgress$delegate.getValue().floatValue();
    }

    public static final void access$NavigationRailItemBaselineLayout(Function2 icon, Function2 label, float iconPositionAnimationProgress, Composer $composer, int $changed) {
        NavigationRailKt.NavigationRailItemBaselineLayout(icon, label, iconPositionAnimationProgress, $composer, $changed);
    }

    public static final void access$NavigationRailTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function3 content, Composer $composer, int $changed) {
        NavigationRailKt.NavigationRailTransition-Klgx-Pg(activeColor, inactiveColor, selected, content, $composer, $changed);
    }

    public static final float access$NavigationRailTransition_Klgx_Pg$lambda$2(State $animationProgress$delegate) {
        return NavigationRailKt.NavigationRailTransition_Klgx_Pg$lambda$2($animationProgress$delegate);
    }

    public static final float access$getHeaderPadding$p() {
        return NavigationRailKt.HeaderPadding;
    }

    public static final float access$getNavigationRailPadding$p() {
        return NavigationRailKt.NavigationRailPadding;
    }

    public static final MeasureResult access$placeIcon-3p2s80s(MeasureScope $receiver, Placeable iconPlaceable, long constraints) {
        return NavigationRailKt.placeIcon-3p2s80s($receiver, iconPlaceable, constraints);
    }

    public static final MeasureResult access$placeLabelAndIcon-DIyivk0(MeasureScope $receiver, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        return NavigationRailKt.placeLabelAndIcon-DIyivk0($receiver, labelPlaceable, iconPlaceable, constraints, iconPositionAnimationProgress);
    }

    private static final MeasureResult placeIcon-3p2s80s(MeasureScope $this$placeIcon_u2d3p2s80s, Placeable iconPlaceable, long constraints) {
        int i4 = 0;
        NavigationRailKt.placeIcon.1 anon = new NavigationRailKt.placeIcon.1(iconPlaceable, Math.max(i4, i /= 2), Math.max(i4, i6 /= 2));
        return MeasureScope.layout$default($this$placeIcon_u2d3p2s80s, Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), 0, (Function1)anon, 4, 0);
    }

    private static final MeasureResult placeLabelAndIcon-DIyivk0(MeasureScope $this$placeLabelAndIcon_u2dDIyivk0, Placeable labelPlaceable, Placeable iconPlaceable, long constraints, float iconPositionAnimationProgress) {
        final MeasureScope measureScope = $this$placeLabelAndIcon_u2dDIyivk0;
        Placeable placeable = labelPlaceable;
        int i13 = i - roundToPx-0680j_42;
        int i11 = i2 / 2;
        final int roundToPx-0680j_4 = measureScope.roundToPx-0680j_4(NavigationRailKt.ItemIconTopOffset);
        int roundToInt = MathKt.roundToInt(f *= i7);
        NavigationRailKt.placeLabelAndIcon.1 anon = new NavigationRailKt.placeLabelAndIcon.1(obj22, placeable, i11, i13, roundToInt, iconPlaceable, i4 / 2, roundToPx-0680j_4);
        int i15 = i11;
        final int i20 = roundToInt;
        int offset = i13;
        return MeasureScope.layout$default(measureScope, Constraints.getMaxWidth-impl(constraints), Constraints.getMaxHeight-impl(constraints), 0, (Function1)anon, 4, 0);
    }
}
