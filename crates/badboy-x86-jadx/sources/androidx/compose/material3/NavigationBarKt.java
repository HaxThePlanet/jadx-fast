package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.tokens.NavigationBarTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
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
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u001ab\u0010\u0013\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00140\u001e¢\u0006\u0002\u0008 ¢\u0006\u0002\u0008!H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001aq\u0010$\u001a\u00020\u00142\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\u0008 2\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\u0008 2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\u0008 2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\u0008 2\u0006\u0010*\u001a\u00020+2\u000c\u0010,\u001a\u0008\u0012\u0004\u0012\u00020-0&H\u0003¢\u0006\u0002\u0010.\u001a\u0085\u0001\u0010/\u001a\u00020\u0014*\u00020\u001f2\u0006\u00100\u001a\u00020+2\u000c\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u00140&2\u0011\u0010(\u001a\r\u0012\u0004\u0012\u00020\u00140&¢\u0006\u0002\u0008 2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u00102\u001a\u00020+2\u0015\u0008\u0002\u0010)\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u00010&¢\u0006\u0002\u0008 2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u00103\u001a\u0002042\n\u0008\u0002\u00105\u001a\u0004\u0018\u000106H\u0007¢\u0006\u0002\u00107\u001a8\u00108\u001a\u000209*\u00020:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0008\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@H\u0002ø\u0001\u0000¢\u0006\u0004\u0008A\u0010B\u001aP\u0010C\u001a\u000209*\u00020:2\u0006\u0010D\u001a\u00020<2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<2\u0008\u0010>\u001a\u0004\u0018\u00010<2\u0006\u0010?\u001a\u00020@2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0004\u0008E\u0010F\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0008\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u000cX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0010\u0010\n\"\u0016\u0010\u0011\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0012\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006G²\u0006\n\u0010H\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010I\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010J\u001a\u00020\u000cX\u008a\u008e\u0002", d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "IndicatorVerticalPadding", "getIndicatorVerticalPadding", "()F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationBarHeight", "NavigationBarIndicatorToLabelPadding", "getNavigationBarIndicatorToLabelPadding", "NavigationBarItemHorizontalPadding", "getNavigationBarItemHorizontalPadding", "NavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "tonalElevation", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "NavigationBar-HsRjFd4", "(Landroidx/compose/ui/Modifier;JJFLandroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationBarItemLayout", "indicatorRipple", "Lkotlin/Function0;", "indicator", "icon", "label", "alwaysShowLabel", "", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NavigationBarItem", "selected", "onClick", "enabled", "colors", "Landroidx/compose/material3/NavigationBarItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationBarItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavigationBarKt {

    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding = 0f;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = 0f;
    private static final float IndicatorVerticalPadding = 0f;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationBarHeight;
    private static final float NavigationBarIndicatorToLabelPadding;
    private static final float NavigationBarItemHorizontalPadding;
    static {
        NavigationBarKt.NavigationBarHeight = NavigationBarTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        int i4 = 0;
        NavigationBarKt.NavigationBarItemHorizontalPadding = Dp.constructor-impl((float)i);
        int i5 = 0;
        NavigationBarKt.NavigationBarIndicatorToLabelPadding = Dp.constructor-impl((float)i2);
        int i7 = 0;
        int i8 = 0;
        NavigationBarKt.IndicatorHorizontalPadding = Dp.constructor-impl(arg0$iv / f4);
        int i9 = 0;
        int i10 = 0;
        NavigationBarKt.IndicatorVerticalPadding = Dp.constructor-impl(arg0$iv3 / f5);
        int i6 = 0;
        NavigationBarKt.IndicatorVerticalOffset = Dp.constructor-impl((float)i3);
    }

    public static final void NavigationBar-HsRjFd4(Modifier modifier, long containerColor, long contentColor, float tonalElevation, WindowInsets windowInsets, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Object $composer2;
        int $dirty;
        long $dirty2;
        int i6;
        Object modifier2;
        boolean traceInProgress2;
        Object obj2;
        long windowInsets2;
        int containerColor2;
        int containerColor3;
        Object windowInsets3;
        int i12;
        long str;
        float f;
        int changed;
        int i10;
        Object obj3;
        boolean changed3;
        long contentColor2;
        int i7;
        float tonalElevation2;
        int i5;
        Object obj;
        int changed2;
        int i11;
        boolean skipping;
        int defaultsInvalid;
        int i;
        float f2;
        int i3;
        int i4;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i8;
        int i2;
        long l;
        final Object obj5 = $changed;
        final int i33 = obj34;
        traceInProgress = 1596802123;
        Composer restartGroup = i9.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)111@5198L14,112@5254L11,114@5412L12,122@5632L441,117@5479L594:NavigationBar.kt#uh7d8r");
        $dirty = obj34;
        i6 = obj35 & 1;
        if (i6 != 0) {
            $dirty |= 6;
            obj2 = modifier;
        } else {
            if (i33 & 6 == 0) {
                i12 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i12;
            } else {
                obj2 = modifier;
            }
        }
        if (i33 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                str = containerColor;
            }
            $dirty |= changed;
        } else {
            str = containerColor;
        }
        if (i33 & 384 == 0) {
            if (obj35 & 4 == 0) {
                i10 = restartGroup.changed(tonalElevation) ? 256 : 128;
            } else {
                contentColor2 = tonalElevation;
            }
            $dirty |= i10;
        } else {
            contentColor2 = tonalElevation;
        }
        int i32 = obj35 & 8;
        if (i32 != 0) {
            $dirty |= 3072;
            tonalElevation2 = content;
        } else {
            if (i33 & 3072 == 0) {
                i5 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty |= i5;
            } else {
                tonalElevation2 = content;
            }
        }
        if (i33 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                changed2 = restartGroup.changed($composer) ? 16384 : 8192;
            } else {
                obj = $composer;
            }
            $dirty |= changed2;
        } else {
            obj = $composer;
        }
        int i40 = 196608;
        if (obj35 & 32 != 0) {
            $dirty |= i40;
        } else {
            if (i33 & i40 == 0) {
                i11 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
                $dirty |= i11;
            }
        }
        if (i38 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -57345;
                if (i33 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        int i39 = 6;
                        if (obj35 & 2 != 0) {
                            $dirty &= -113;
                            str = containerColor2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColor2 = ColorSchemeKt.contentColorFor-4WTKRHQ(MaterialTheme.INSTANCE.getColorScheme(restartGroup, i39), str);
                            $dirty &= -897;
                        }
                        if (i32 != 0) {
                            tonalElevation2 = containerColor3;
                        }
                        if (obj35 & 16 != 0) {
                            windowInsets3 = NavigationBarDefaults.INSTANCE.getWindowInsets(restartGroup, i39);
                            $dirty &= i;
                            skipping = contentColor2;
                            f2 = tonalElevation2;
                            contentColor2 = modifier2;
                            tonalElevation2 = str;
                        } else {
                            skipping = contentColor2;
                            f2 = tonalElevation2;
                            windowInsets3 = obj;
                            contentColor2 = modifier2;
                            tonalElevation2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj35 & 2 != 0) {
                            $dirty &= -113;
                        }
                        if (obj35 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (obj35 & 16 != 0) {
                            $dirty &= i;
                            skipping = contentColor2;
                            f2 = tonalElevation2;
                            contentColor2 = obj2;
                            windowInsets3 = obj;
                            tonalElevation2 = str;
                        } else {
                            skipping = contentColor2;
                            f2 = tonalElevation2;
                            contentColor2 = obj2;
                            windowInsets3 = obj;
                            tonalElevation2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:116)");
                }
                NavigationBarKt.NavigationBar.1 anon = new NavigationBarKt.NavigationBar.1(windowInsets3, obj5);
                SurfaceKt.Surface-T9BRK9s(contentColor2, 0, tonalElevation2, obj, skipping, i, f2, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(105663120, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i7 = $dirty;
                obj3 = windowInsets3;
                $composer2 = contentColor2;
                $dirty2 = tonalElevation2;
                windowInsets2 = skipping;
                f = f2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj2;
                obj3 = obj;
                i7 = $dirty;
                $dirty2 = str;
                windowInsets2 = l;
                f = tonalElevation2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationBarKt.NavigationBar.2($composer2, $dirty2, i6, windowInsets2, str, f, obj3, obj5, i33, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void NavigationBarItem(RowScope $this$NavigationBarItem, boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, androidx.compose.material3.NavigationBarItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        Object obj8;
        Object obj2;
        boolean traceInProgress2;
        androidx.compose.material3.NavigationBarItemColors $dirty3;
        boolean rememberComposableLambda;
        Function0 factory$iv$iv$iv;
        int i36;
        int defaultsInvalid;
        int $dirty2;
        int $dirty;
        int i33;
        Object invalid$iv;
        int z3;
        int i4;
        Object mutableIntStateOf;
        Integer maybeCachedBoxMeasurePolicy;
        Object it$iv;
        Object obj3;
        Object anon2;
        Composer composer;
        Object currentCompositionLocalMap;
        boolean i34;
        boolean traceInProgress;
        Object anon;
        int i28;
        int i5;
        Object obj;
        Object obj7;
        int i17;
        Object obj10;
        boolean colors2;
        int i18;
        Object obj4;
        int i10;
        Composer composer2;
        Object empty;
        Object modifier2;
        boolean z4;
        int empty2;
        int i8;
        androidx.compose.material3.NavigationBarItemColors interactionSource2;
        int interactionSource4;
        boolean z2;
        int enabled2;
        int i27;
        int str;
        int i3;
        Object obj6;
        int i9;
        Object i16;
        int i2;
        int i20;
        int i14;
        int i26;
        int changed;
        int i7;
        int i11;
        androidx.compose.runtime.internal.ComposableLambda i19;
        int companion;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i35;
        boolean z5;
        androidx.compose.material3.NavigationBarKt.NavigationBarItem.2.2.1 invalid$iv2;
        boolean z;
        Composer composer3;
        int i12;
        Object obj9;
        Object companion2;
        int i21;
        int i24;
        Function0 function0;
        int i;
        int i25;
        int i29;
        int i22;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int interactionSource3;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i23;
        Object obj5;
        int i6;
        long l;
        int i15;
        int i30;
        int i31;
        BoxScopeInstance boxScopeInstance;
        Composer composer4;
        int i32;
        Object obj52;
        int obj53;
        Alignment obj54;
        int obj55;
        int obj56;
        Modifier obj57;
        Modifier obj58;
        final int i105 = $changed;
        final int i106 = i13;
        final Composer restartGroup = $composer.startRestartGroup(-663510974);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationBarItem)P(8,7,3,6,2,5)179@8344L8,185@8576L633,215@9873L33,229@10315L24,217@9912L2687:NavigationBar.kt#uh7d8r");
        $dirty2 = $changed;
        if (i62 &= i106 != 0) {
            $dirty2 |= 6;
            obj3 = $this$NavigationBarItem;
        } else {
            if (i105 & 6 == 0) {
                i28 = restartGroup.changed($this$NavigationBarItem) ? 4 : 2;
                $dirty2 |= i28;
            } else {
                obj3 = $this$NavigationBarItem;
            }
        }
        if (i106 & 1 != 0) {
            $dirty2 |= 48;
        } else {
            if (i105 & 48 == 0) {
                i5 = restartGroup.changed(selected) ? 32 : 16;
                $dirty2 |= i5;
            }
        }
        if (i106 & 2 != 0) {
            $dirty2 |= 384;
            obj = onClick;
        } else {
            if (i105 & 384 == 0) {
                i17 = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty2 |= i17;
            } else {
                obj = onClick;
            }
        }
        if (i106 & 4 != 0) {
            $dirty2 |= 3072;
            obj10 = icon;
        } else {
            if (i105 & 3072 == 0) {
                i18 = restartGroup.changedInstance(icon) ? 2048 : 1024;
                $dirty2 |= i18;
            } else {
                obj10 = icon;
            }
        }
        int i90 = i106 & 8;
        if (i90 != 0) {
            $dirty2 |= 24576;
            modifier2 = modifier;
        } else {
            if (i105 & 24576 == 0) {
                i8 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                modifier2 = modifier;
            }
        }
        int i102 = i106 & 16;
        int i103 = 196608;
        if (i102 != 0) {
            $dirty2 |= i103;
            z2 = enabled;
        } else {
            if (i103 &= i105 == 0) {
                i27 = restartGroup.changed(enabled) ? 131072 : 65536;
                $dirty2 |= i27;
            } else {
                z2 = enabled;
            }
        }
        str = i106 & 32;
        int i109 = 1572864;
        if (str != null) {
            $dirty2 |= i109;
            obj6 = label;
        } else {
            if (i109 &= i105 == 0) {
                i9 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                obj6 = label;
            }
        }
        i16 = i106 & 64;
        i20 = 12582912;
        if (i16 != 0) {
            $dirty2 |= i20;
            i34 = alwaysShowLabel;
        } else {
            if (i105 & i20 == 0) {
                i14 = restartGroup.changed(alwaysShowLabel) ? 8388608 : 4194304;
                $dirty2 |= i14;
            } else {
                i34 = alwaysShowLabel;
            }
        }
        if (i105 & i115 == 0) {
            if (i106 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj8 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj8 = colors;
        }
        int i38 = i106 & 256;
        int i116 = 805306368;
        if (i38 != 0) {
            $dirty2 |= i116;
            i7 = i38;
            obj2 = interactionSource;
        } else {
            if (i105 & i116 == 0) {
                i7 = i38;
                i11 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty2 |= i11;
            } else {
                i7 = i38;
                obj2 = interactionSource;
            }
        }
        obj58 = $dirty2;
        if ($dirty2 & i19 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                companion = -234881025;
                i33 = 6;
                if (i105 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i90 != 0) {
                            modifier2 = defaultsInvalid;
                        }
                        if (i102 != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj6 = defaultsInvalid;
                        }
                        if (i16 != 0) {
                            i34 = defaultsInvalid;
                        }
                        if (i106 & 128 != 0) {
                            $dirty3 = NavigationBarItemDefaults.INSTANCE.colors(restartGroup, i33);
                            i10 = obj58 & companion;
                        } else {
                            $dirty3 = colors;
                            i10 = obj58;
                        }
                        z5 = i7 != 0 ? i34 : i34;
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i106 & 128 != 0) {
                            interactionSource4 = interactionSource;
                            i10 = i40;
                            z5 = i34;
                            $dirty3 = colors;
                        } else {
                            $dirty3 = colors;
                            interactionSource4 = interactionSource;
                            i10 = obj58;
                            z5 = i34;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i2 = i33;
                    ComposerKt.traceEventStart(-663510974, i10, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:181)");
                } else {
                    i2 = i33;
                }
                restartGroup.startReplaceGroup(-103235253);
                ComposerKt.sourceInformation(restartGroup, "183@8495L39");
                String str4 = "CC(remember):NavigationBar.kt#9igjgp";
                if (interactionSource4 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -103234602, str4);
                    traceInProgress = 0;
                    str = restartGroup;
                    i26 = 0;
                    obj53 = $dirty3;
                    $dirty3 = str.rememberedValue();
                    i7 = 0;
                    if ($dirty3 == Composer.Companion.getEmpty()) {
                        int i61 = 0;
                        str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        i4 = $dirty3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                } else {
                    obj53 = $dirty3;
                    i4 = interactionSource4;
                }
                restartGroup.endReplaceGroup();
                obj54 = selected;
                obj52 = anon3;
                super(obj53, obj54, z2, obj6, z5, obj10);
                androidx.compose.material3.NavigationBarItemColors navigationBarItemColors = obj53;
                obj54 = i4;
                int interactionSource5 = 1;
                int i64 = 54;
                restartGroup.startReplaceGroup(-103209106);
                ComposerKt.sourceInformation(restartGroup, "*200@9305L535");
                if (obj6 == null) {
                    i35 = 0;
                } else {
                    i3 = obj6;
                    i26 = 0;
                    anon = new NavigationBarKt.NavigationBarItem.styledLabel.1.1(navigationBarItemColors, obj54, z2, obj6);
                    i35 = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(restartGroup, -103190512, str4);
                Composer composer8 = restartGroup;
                int i107 = 0;
                Object rememberedValue2 = composer8.rememberedValue();
                int i118 = 0;
                obj52 = i42;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i60 = 0;
                    composer8.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(0));
                } else {
                    mutableIntStateOf = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i73 = obj54;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -103176377, str4);
                Composer composer9 = restartGroup;
                int i92 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i119 = 0;
                obj52 = i66;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj53 = i69;
                    anon2 = new NavigationBarKt.NavigationBarItem.1.1((MutableIntState)mutableIntStateOf);
                    composer9.updateRememberedValue((Function1)anon2);
                } else {
                    anon2 = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(RowScope.weight$default($this$NavigationBarItem, SizeKt.defaultMinSize-VpY3zN4$default(SelectableKt.selectable-O2vRcR0(modifier2, selected, obj54, 0, z2, Role.box-impl(Role.Companion.getTab-o7Vup1c()), obj), 0, NavigationBarKt.NavigationBarHeight, 1, 0), 1065353216, false, 2, 0), (Function1)anon2);
                Alignment center = Alignment.Companion.getCenter();
                int i93 = i126;
                str = 0;
                obj53 = i78;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, i93);
                i24 = 0;
                obj54 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj56 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, onSizeChanged);
                obj57 = onSizeChanged;
                Function0 function02 = constructor;
                i = 0;
                i29 = i93;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i120 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i124 = 0;
                companion2 = constructor-impl;
                int i127 = 0;
                if (!companion2.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(companion2.rememberedValue(), Integer.valueOf(obj56))) {
                        companion2.updateRememberedValue(Integer.valueOf(obj56));
                        constructor-impl.apply(Integer.valueOf(obj56), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = companion2;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer5 = restartGroup;
                i22 = i48;
                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i31 = 0;
                boxScopeInstance = iNSTANCE;
                i32 = i68;
                Composer composer7 = composer11;
                ComposerKt.sourceInformationMarkerStart(composer7, -1652122706, "C234@10492L157,*243@10933L7,249@11215L128,256@11558L293,264@11900L395,281@12555L27,275@12305L288:NavigationBar.kt#uh7d8r");
                i36 = selected ? 1065353216 : 0;
                Composer composer12 = composer7;
                obj58 = materializeModifier;
                int $composer2 = 0;
                androidx.compose.runtime.State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i36, (AnimationSpec)AnimationSpecKt.tween$default(100, 0, $composer2, i2, $composer2), 0, 0, 0, composer12, 48, 28);
                obj3 = composer12;
                int i129 = 0;
                int i111 = 0;
                int i121 = i81;
                i23 = i97;
                ComposerKt.sourceInformationMarkerStart(obj3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj3);
                Object this_$iv = consume;
                int roundToPx-0680j_4 = (Density)this_$iv.roundToPx-0680j_4(NavigationBarTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM());
                int i122 = i82;
                int i85 = f3 / f2;
                int i113 = roundToPx-0680j_4;
                Unit $this$NavigationBarItem_u24lambda_u249_u24lambda_u246 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(obj3, 2024938414, str4);
                empty = i73;
                long interactionSource6 = l;
                Composer composer10 = obj3;
                int i114 = 0;
                it$iv = composer10.rememberedValue();
                int i125 = 0;
                if (changed3 |= changed8 == 0) {
                    interactionSource3 = empty;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj9 = it$iv;
                        tweenSpec = interactionSource7;
                        obj5 = modifier2;
                        it$iv = new MappedInteractionSource((InteractionSource)interactionSource3, interactionSource6, i85, 0);
                        composer10.updateRememberedValue(it$iv);
                    } else {
                        obj9 = it$iv;
                        obj5 = modifier2;
                        composer2 = composer10;
                    }
                } else {
                    interactionSource3 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(obj3);
                NavigationBarKt.NavigationBarItem.2.indicatorRipple.1 anon6 = new NavigationBarKt.NavigationBarItem.2.indicatorRipple.1((MappedInteractionSource)it$iv);
                i16 = it$iv;
                i20 = interactionSource6;
                int offsetInteractionSource = 54;
                int deltaOffset = 1;
                NavigationBarKt.NavigationBarItem.2.indicator.1 anon5 = new NavigationBarKt.NavigationBarItem.2.indicator.1(animateFloatAsState, navigationBarItemColors);
                ComposerKt.sourceInformationMarkerStart(obj3, 2024981193, str4);
                boolean changed2 = obj3.changed(animateFloatAsState);
                Composer composer6 = obj3;
                i34 = 0;
                Object rememberedValue3 = composer6.rememberedValue();
                int i99 = 0;
                if (!changed2) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        z = changed2;
                        invalid$iv = new NavigationBarKt.NavigationBarItem.2.2.1(animateFloatAsState);
                        composer6.updateRememberedValue((Function0)invalid$iv);
                    } else {
                        z = changed2;
                        invalid$iv = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj3);
                NavigationBarKt.NavigationBarItemLayout((Function2)ComposableLambdaKt.rememberComposableLambda(691730997, deltaOffset, anon6, obj3, offsetInteractionSource), (Function2)ComposableLambdaKt.rememberComposableLambda(-474426875, deltaOffset, anon5, obj3, offsetInteractionSource), (Function2)ComposableLambdaKt.rememberComposableLambda(-1419576100, interactionSource5, obj52, restartGroup, i64), i35, z5, (Function0)invalid$iv, obj3, i55 |= 438);
                ComposerKt.sourceInformationMarkerEnd(obj3);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interactionSource2 = navigationBarItemColors;
                colors2 = z2;
                enabled2 = i86;
                z4 = z5;
                obj7 = obj5;
                obj4 = obj6;
            } else {
                restartGroup.skipToGroupEnd();
                interactionSource2 = colors;
                i21 = obj58;
                obj7 = modifier2;
                colors2 = z2;
                enabled2 = interactionSource;
                z4 = i34;
                obj4 = obj6;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationBarKt.NavigationBarItem.3($this$NavigationBarItem, selected, onClick, icon, obj7, colors2, obj4, z4, interactionSource2, enabled2, i105, i106);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final int NavigationBarItem$lambda$3(MutableIntState $itemWidth$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntState)$itemWidth$delegate.getIntValue();
    }

    private static final void NavigationBarItem$lambda$4(MutableIntState $itemWidth$delegate, int value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $itemWidth$delegate.setIntValue(value);
    }

    private static final void NavigationBarItemLayout(Function2<? super Composer, ? super Integer, Unit> indicatorRipple, Function2<? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, Function0<Float> animationProgress, Composer $composer, int $changed) {
        int traceInProgress;
        boolean currentCompositionLocalMap;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        Object valueOf;
        Object materialized$iv$iv;
        boolean currentCompositionLocalMap3;
        int i30;
        Object anon;
        Object empty;
        Object str;
        boolean topStart;
        Object valueOf3;
        Composer composer4;
        int materializeModifier;
        Composer restartGroup;
        int $dirty;
        Function0 factory$iv$iv;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy2;
        int i29;
        int i2;
        int i14;
        int i5;
        int i15;
        int i22;
        boolean maybeCachedBoxMeasurePolicy;
        boolean traceInProgress2;
        String $changed$iv;
        int i13;
        int i8;
        Composer composer7;
        Integer valueOf2;
        int anon2;
        int empty2;
        int currentCompositionLocalMap2;
        int i20;
        int i16;
        int companion;
        int i9;
        int currentCompositeKeyHash;
        int i21;
        int i17;
        Composer.Companion companion2;
        int i;
        Composer composer6;
        int i18;
        int i24;
        Composer composer5;
        int i19;
        int i31;
        Function0 function03;
        int i27;
        int i3;
        Function0 function02;
        Modifier modifier2;
        int i26;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        int i32;
        int i4;
        int contentAlignment$iv;
        int i25;
        Object obj;
        int currentCompositeKeyHash2;
        int i10;
        int i6;
        Modifier modifier;
        Function0 function0;
        int i7;
        int i23;
        int i11;
        int i12;
        Composer composer2;
        int i28;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        BoxScopeInstance boxScopeInstance;
        Composer composer3;
        int obj62;
        materialized$iv$iv = indicatorRipple;
        str = indicator;
        valueOf3 = icon;
        final Object obj2 = label;
        final boolean z3 = alwaysShowLabel;
        final Object obj3 = animationProgress;
        materializeModifier = $changed;
        traceInProgress = -1427075886;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationBarItemLayout)P(4,3,2,5)532@23467L1717,517@23004L2180:NavigationBar.kt#uh7d8r");
        if (materializeModifier & 6 == 0) {
            i29 = restartGroup.changedInstance(materialized$iv$iv) ? 4 : 2;
            $dirty |= i29;
        }
        if (materializeModifier & 48 == 0) {
            i2 = restartGroup.changedInstance(str) ? 32 : 16;
            $dirty |= i2;
        }
        if (materializeModifier & 384 == 0) {
            i14 = restartGroup.changedInstance(valueOf3) ? 256 : 128;
            $dirty |= i14;
        }
        i8 = 2048;
        if (materializeModifier & 3072 == 0) {
            i5 = restartGroup.changedInstance(obj2) ? i8 : 1024;
            $dirty |= i5;
        }
        anon2 = 16384;
        if (materializeModifier & 24576 == 0) {
            i15 = restartGroup.changed(z3) ? anon2 : 8192;
            $dirty |= i15;
        }
        empty2 = 131072;
        if (i72 &= materializeModifier == 0) {
            i22 = restartGroup.changedInstance(obj3) ? empty2 : 65536;
            $dirty |= i22;
        }
        if (i73 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:516)");
                }
                maybeCachedBoxMeasurePolicy = "CC(remember):NavigationBar.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -96239762, maybeCachedBoxMeasurePolicy);
                int i34 = 458752;
                companion = 1;
                int i35 = 0;
                i20 = $dirty & i34 == empty2 ? companion : i35;
                i13 = $dirty & 7168 == i8 ? companion : i35;
                int i82 = 57344;
                i16 = $dirty & i82 == anon2 ? companion : i35;
                Composer composer9 = restartGroup;
                int i91 = 0;
                Object rememberedValue5 = composer9.rememberedValue();
                i17 = 0;
                if (i77 |= i16 == 0) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon2 = new NavigationBarKt.NavigationBarItemLayout.2.1(obj3, obj2, z3);
                        composer9.updateRememberedValue((MeasurePolicy)anon2);
                    } else {
                        anon2 = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i79 = i35;
                valueOf2 = 0;
                currentCompositionLocalMap2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i35);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion);
                i24 = $dirty;
                Function0 function05 = constructor2;
                i18 = 0;
                i31 = i79;
                $changed$iv = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function05);
                } else {
                    factory$iv$iv = function05;
                    restartGroup.useNode();
                }
                composer5 = restartGroup;
                Composer constructor-impl2 = Updater.constructor-impl(composer5);
                int i95 = 0;
                function02 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)anon2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i96 = 0;
                Composer composer11 = constructor-impl2;
                i26 = 0;
                if (!composer11.getInserting()) {
                    localMap$iv = currentCompositionLocalMap;
                    i32 = valueOf2;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer11;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap;
                    i32 = valueOf2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer5;
                i27 = i37;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -656695659, "C518@23021L17,519@23047L11,521@23068L50:NavigationBar.kt#uh7d8r");
                materialized$iv$iv.invoke(restartGroup, Integer.valueOf(i24 & 14));
                str.invoke(restartGroup, Integer.valueOf(i39 &= 14));
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                int i84 = 6;
                i3 = 0;
                str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                modifier2 = materializeModifier3;
                int materialized$iv = 0;
                i4 = i66;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, materialized$iv);
                i25 = 0;
                obj = topStart2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                i10 = materialized$iv;
                modifier = layoutId;
                Function0 function06 = constructor3;
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function06);
                } else {
                    factory$iv$iv$iv2 = function06;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i99 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i100 = 0;
                Composer composer12 = constructor-impl;
                int i103 = 0;
                if (!composer12.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer12;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, layoutId), ComposeUiNode.Companion.getSetModifier());
                materialized$iv$iv = restartGroup;
                $dirty = 0;
                i23 = i44;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i102 |= 6;
                composer2 = materialized$iv$iv;
                i28 = 0;
                boxScopeInstance = iNSTANCE;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -2034219770, "C521@23110L6:NavigationBar.kt#uh7d8r");
                valueOf3.invoke(materialized$iv$iv, Integer.valueOf(i45 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(1087198243);
                ComposerKt.sourceInformation(restartGroup, "526@23253L60,524@23161L288");
                if (obj2 != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1087201972, maybeCachedBoxMeasurePolicy);
                    i30 = i24 & i21 == 16384 ? companion : 0;
                    if (i24 & obj62 == 131072) {
                    } else {
                        companion = 0;
                    }
                    i30 |= companion;
                    Composer composer8 = restartGroup;
                    int i68 = 0;
                    Object rememberedValue4 = composer8.rememberedValue();
                    int i86 = 0;
                    if (empty == 0) {
                        obj62 = empty;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            companion = invalid$iv;
                            anon = new NavigationBarKt.NavigationBarItemLayout.1.2.1(z3, obj3);
                            composer8.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue4;
                        }
                    } else {
                        obj62 = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i69 = 0;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label"), (Function1)anon), Dp.constructor-impl(navigationBarItemHorizontalPadding / f), 0, 2, 0);
                    int i58 = i93;
                    materializeModifier = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str);
                    topStart = Alignment.Companion.getTopStart();
                    companion = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                    i9 = currentCompositeKeyHash3;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, padding-VpY3zN4$default);
                    i17 = padding-VpY3zN4$default;
                    Function0 function04 = constructor;
                    i21 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function04);
                    } else {
                        factory$iv$iv$iv = function04;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                    int i92 = 0;
                    function03 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i94 = 0;
                    Composer composer10 = constructor-impl3;
                    int i97 = 0;
                    if (!composer10.getInserting()) {
                        contentAlignment$iv = topStart;
                        if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(i9))) {
                            composer10.updateRememberedValue(Integer.valueOf(i9));
                            constructor-impl3.apply(Integer.valueOf(i9), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer10;
                        }
                    } else {
                        contentAlignment$iv = topStart;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    str = restartGroup;
                    valueOf3 = 0;
                    companion2 = i51;
                    ComposerKt.sourceInformationMarkerStart(str, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i81 |= 6;
                    composer6 = str;
                    i3 = 0;
                    i26 = iNSTANCE2;
                    i25 = materializeModifier2;
                    ComposerKt.sourceInformationMarkerStart(str, -2033904283, "C529@23428L7:NavigationBar.kt#uh7d8r");
                    obj2.invoke(str, Integer.valueOf(i52 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(str);
                    ComposerKt.sourceInformationMarkerEnd(str);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer5 = restartGroup;
                i24 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer5.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationBarKt.NavigationBarItemLayout.3(indicatorRipple, indicator, icon, obj2, z3, obj3, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$NavigationBarItem$lambda$4(MutableIntState $itemWidth$delegate, int value) {
        NavigationBarKt.NavigationBarItem$lambda$4($itemWidth$delegate, value);
    }

    public static final void access$NavigationBarItemLayout(Function2 indicatorRipple, Function2 indicator, Function2 icon, Function2 label, boolean alwaysShowLabel, Function0 animationProgress, Composer $composer, int $changed) {
        NavigationBarKt.NavigationBarItemLayout(indicatorRipple, indicator, icon, label, alwaysShowLabel, animationProgress, $composer, $changed);
    }

    public static final float access$getIndicatorHorizontalPadding$p() {
        return NavigationBarKt.IndicatorHorizontalPadding;
    }

    public static final float access$getNavigationBarHeight$p() {
        return NavigationBarKt.NavigationBarHeight;
    }

    public static final MeasureResult access$placeIcon-X9ElhV4(MeasureScope $receiver, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        return NavigationBarKt.placeIcon-X9ElhV4($receiver, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
    }

    public static final MeasureResult access$placeLabelAndIcon-zUg2_y0(MeasureScope $receiver, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        return NavigationBarKt.placeLabelAndIcon-zUg2_y0($receiver, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, alwaysShowLabel, animationProgress);
    }

    public static final float getIndicatorVerticalPadding() {
        return NavigationBarKt.IndicatorVerticalPadding;
    }

    public static final float getNavigationBarIndicatorToLabelPadding() {
        return NavigationBarKt.NavigationBarIndicatorToLabelPadding;
    }

    public static final float getNavigationBarItemHorizontalPadding() {
        return NavigationBarKt.NavigationBarItemHorizontalPadding;
    }

    private static final MeasureResult placeIcon-X9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        int maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
        int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(constraints, obj11);
        int i7 = i / 2;
        int i9 = i2 / 2;
        int i11 = i3 / 2;
        int i13 = i4 / 2;
        int i14 = maxWidth-impl;
        int i15 = constrainHeight-K40F9xA;
        NavigationBarKt.placeIcon.1 anon = new NavigationBarKt.placeIcon.1(indicatorPlaceable, iconPlaceable, i7, i9, indicatorRipplePlaceable, i11, i13, i14, i15);
        final int i16 = i13;
        int rippleY = i7;
        int width4 = i9;
        int height4 = i11;
        return MeasureScope.layout$default($this$placeIcon_u2dX9ElhV4, i14, i15, 0, (Function1)anon, 4, 0);
    }

    private static final MeasureResult placeLabelAndIcon-zUg2_y0(MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        float f;
        final MeasureScope measureScope2 = $this$placeLabelAndIcon_u2dzUg2_y0;
        final int i30 = i3;
        float f8 = (float)i15;
        final float f10 = coerceAtLeast;
        final int i31 = i30 + i6;
        final float f9 = f10;
        if (animationProgress) {
            f = f9;
        } else {
            i14 /= f8;
        }
        int i22 = i10 + px-0680j_45;
        final int maxWidth-impl = Constraints.getMaxWidth-impl(constraints);
        int i20 = i11 / 2;
        int i26 = i12 / 2;
        NavigationBarKt.placeLabelAndIcon.1 anon = new NavigationBarKt.placeLabelAndIcon.1(indicatorPlaceable, animationProgress, obj30, labelPlaceable, i20, i22, i32 * i8, iconPlaceable, i26, f9, indicatorRipplePlaceable, i13 / 2, f9 - px-0680j_4, maxWidth-impl, measureScope2);
        int i25 = i22;
        int i27 = i26;
        int iconX = i20;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, maxWidth-impl, MathKt.roundToInt(i31), 0, (Function1)anon, 4, 0);
    }
}
