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
        int traceInProgress2;
        Object $composer2;
        int $dirty;
        long $dirty2;
        int i12;
        Object modifier2;
        boolean traceInProgress;
        Object obj;
        long windowInsets2;
        int containerColor2;
        int containerColor3;
        Object windowInsets3;
        int i7;
        long str;
        float f2;
        int changed;
        int i10;
        Object obj3;
        boolean changed3;
        long contentColor2;
        int i4;
        float tonalElevation2;
        int i8;
        Object obj2;
        int changed2;
        int i3;
        boolean skipping;
        int defaultsInvalid;
        int i;
        float f;
        int i11;
        int i6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i2;
        int i5;
        long l;
        final Object obj5 = $changed;
        final int i33 = obj34;
        traceInProgress2 = 1596802123;
        Composer restartGroup = i9.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationBar)P(3,0:c#ui.graphics.Color,2:c#ui.graphics.Color,4:c#ui.unit.Dp,5)111@5198L14,112@5254L11,114@5412L12,122@5632L441,117@5479L594:NavigationBar.kt#uh7d8r");
        $dirty = obj34;
        i12 = obj35 & 1;
        if (i12 != 0) {
            $dirty |= 6;
            obj = modifier;
        } else {
            if (i33 & 6 == 0) {
                i7 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj = modifier;
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
                i8 = restartGroup.changed(content) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                tonalElevation2 = content;
            }
        }
        if (i33 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                changed2 = restartGroup.changed($composer) ? 16384 : 8192;
            } else {
                obj2 = $composer;
            }
            $dirty |= changed2;
        } else {
            obj2 = $composer;
        }
        int i40 = 196608;
        if (obj35 & 32 != 0) {
            $dirty |= i40;
        } else {
            if (i33 & i40 == 0) {
                i3 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
                $dirty |= i3;
            }
        }
        if (i38 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -57345;
                if (i33 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i12 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj;
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
                            f = tonalElevation2;
                            contentColor2 = modifier2;
                            tonalElevation2 = str;
                        } else {
                            skipping = contentColor2;
                            f = tonalElevation2;
                            windowInsets3 = obj2;
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
                            f = tonalElevation2;
                            contentColor2 = obj;
                            windowInsets3 = obj2;
                            tonalElevation2 = str;
                        } else {
                            skipping = contentColor2;
                            f = tonalElevation2;
                            contentColor2 = obj;
                            windowInsets3 = obj2;
                            tonalElevation2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.NavigationBar (NavigationBar.kt:116)");
                }
                NavigationBarKt.NavigationBar.1 anon = new NavigationBarKt.NavigationBar.1(windowInsets3, obj5);
                SurfaceKt.Surface-T9BRK9s(contentColor2, 0, tonalElevation2, obj2, skipping, i, f, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(105663120, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty;
                obj3 = windowInsets3;
                $composer2 = contentColor2;
                $dirty2 = tonalElevation2;
                windowInsets2 = skipping;
                f2 = f;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                obj3 = obj2;
                i4 = $dirty;
                $dirty2 = str;
                windowInsets2 = l;
                f2 = tonalElevation2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationBarKt.NavigationBar.2($composer2, $dirty2, i12, windowInsets2, str, f2, obj3, obj5, i33, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void NavigationBarItem(RowScope $this$NavigationBarItem, boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, androidx.compose.material3.NavigationBarItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        Object obj8;
        Object obj10;
        boolean traceInProgress;
        androidx.compose.material3.NavigationBarItemColors $dirty;
        boolean rememberComposableLambda;
        Function0 factory$iv$iv$iv;
        int i6;
        int defaultsInvalid;
        int $dirty3;
        int $dirty2;
        int i24;
        Object invalid$iv;
        int z5;
        int $i$a$CacheNavigationBarKt$NavigationBarItem$interactionSource$1;
        Object $i$a$CacheNavigationBarKt$NavigationBarItem$itemWidth$2;
        Integer maybeCachedBoxMeasurePolicy;
        Object it$iv;
        Object obj5;
        Object $i$a$CacheNavigationBarKt$NavigationBarItem$1;
        Composer composer4;
        Object currentCompositionLocalMap;
        boolean i18;
        boolean traceInProgress2;
        Object anon;
        int i8;
        int i26;
        Object obj4;
        Object obj9;
        int i;
        Object obj6;
        boolean colors2;
        int i2;
        Object obj2;
        int i19;
        Composer composer;
        Object empty2;
        Object modifier2;
        boolean z;
        int empty;
        int i17;
        androidx.compose.material3.NavigationBarItemColors interactionSource4;
        int interactionSource3;
        boolean z2;
        int enabled2;
        int i23;
        int str;
        int i11;
        Object obj3;
        int i35;
        Object i20;
        int i3;
        int i30;
        int i10;
        int i22;
        int changed;
        int i25;
        int i31;
        androidx.compose.runtime.internal.ComposableLambda i21;
        int companion2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i27;
        boolean z3;
        androidx.compose.material3.NavigationBarKt.NavigationBarItem.2.2.1 invalid$iv2;
        boolean z4;
        Composer composer3;
        int i4;
        Object obj7;
        Object companion;
        int i32;
        int i14;
        Function0 function0;
        int i33;
        int i34;
        int i28;
        int i9;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int interactionSource2;
        androidx.compose.animation.core.TweenSpec tweenSpec;
        int i5;
        Object obj;
        int i29;
        long l;
        int i12;
        int i16;
        int i15;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        int i7;
        Object obj52;
        int obj53;
        Alignment obj54;
        int obj55;
        int obj56;
        Modifier obj57;
        Modifier obj58;
        final int i102 = $changed;
        final int i103 = i13;
        final Composer restartGroup = $composer.startRestartGroup(-663510974);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationBarItem)P(8,7,3,6,2,5)179@8344L8,185@8576L633,215@9873L33,229@10315L24,217@9912L2687:NavigationBar.kt#uh7d8r");
        $dirty3 = $changed;
        if (i61 &= i103 != 0) {
            $dirty3 |= 6;
            obj5 = $this$NavigationBarItem;
        } else {
            if (i102 & 6 == 0) {
                i8 = restartGroup.changed($this$NavigationBarItem) ? 4 : 2;
                $dirty3 |= i8;
            } else {
                obj5 = $this$NavigationBarItem;
            }
        }
        if (i103 & 1 != 0) {
            $dirty3 |= 48;
        } else {
            if (i102 & 48 == 0) {
                i26 = restartGroup.changed(selected) ? 32 : 16;
                $dirty3 |= i26;
            }
        }
        if (i103 & 2 != 0) {
            $dirty3 |= 384;
            obj4 = onClick;
        } else {
            if (i102 & 384 == 0) {
                i = restartGroup.changedInstance(onClick) ? 256 : 128;
                $dirty3 |= i;
            } else {
                obj4 = onClick;
            }
        }
        if (i103 & 4 != 0) {
            $dirty3 |= 3072;
            obj6 = icon;
        } else {
            if (i102 & 3072 == 0) {
                i2 = restartGroup.changedInstance(icon) ? 2048 : 1024;
                $dirty3 |= i2;
            } else {
                obj6 = icon;
            }
        }
        int i88 = i103 & 8;
        if (i88 != 0) {
            $dirty3 |= 24576;
            modifier2 = modifier;
        } else {
            if (i102 & 24576 == 0) {
                i17 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty3 |= i17;
            } else {
                modifier2 = modifier;
            }
        }
        int i99 = i103 & 16;
        int i100 = 196608;
        if (i99 != 0) {
            $dirty3 |= i100;
            z2 = enabled;
        } else {
            if (i100 &= i102 == 0) {
                i23 = restartGroup.changed(enabled) ? 131072 : 65536;
                $dirty3 |= i23;
            } else {
                z2 = enabled;
            }
        }
        str = i103 & 32;
        int i106 = 1572864;
        if (str != null) {
            $dirty3 |= i106;
            obj3 = label;
        } else {
            if (i106 &= i102 == 0) {
                i35 = restartGroup.changedInstance(label) ? 1048576 : 524288;
                $dirty3 |= i35;
            } else {
                obj3 = label;
            }
        }
        i20 = i103 & 64;
        i30 = 12582912;
        if (i20 != 0) {
            $dirty3 |= i30;
            i18 = alwaysShowLabel;
        } else {
            if (i102 & i30 == 0) {
                i10 = restartGroup.changed(alwaysShowLabel) ? 8388608 : 4194304;
                $dirty3 |= i10;
            } else {
                i18 = alwaysShowLabel;
            }
        }
        if (i102 & i112 == 0) {
            if (i103 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj8 = colors;
            }
            $dirty3 |= changed;
        } else {
            obj8 = colors;
        }
        int i37 = i103 & 256;
        int i113 = 805306368;
        if (i37 != 0) {
            $dirty3 |= i113;
            i25 = i37;
            obj10 = interactionSource;
        } else {
            if (i102 & i113 == 0) {
                i25 = i37;
                i31 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty3 |= i31;
            } else {
                i25 = i37;
                obj10 = interactionSource;
            }
        }
        obj58 = $dirty3;
        if ($dirty3 & i21 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                companion2 = -234881025;
                i24 = 6;
                if (i102 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i88 != 0) {
                            modifier2 = defaultsInvalid;
                        }
                        if (i99 != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (str != null) {
                            obj3 = defaultsInvalid;
                        }
                        if (i20 != 0) {
                            i18 = defaultsInvalid;
                        }
                        if (i103 & 128 != 0) {
                            $dirty = NavigationBarItemDefaults.INSTANCE.colors(restartGroup, i24);
                            i19 = obj58 & companion2;
                        } else {
                            $dirty = colors;
                            i19 = obj58;
                        }
                        z3 = i25 != 0 ? i18 : i18;
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i103 & 128 != 0) {
                            interactionSource3 = interactionSource;
                            i19 = i39;
                            z3 = i18;
                            $dirty = colors;
                        } else {
                            $dirty = colors;
                            interactionSource3 = interactionSource;
                            i19 = obj58;
                            z3 = i18;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    i3 = i24;
                    ComposerKt.traceEventStart(-663510974, i19, -1, "androidx.compose.material3.NavigationBarItem (NavigationBar.kt:181)");
                } else {
                    i3 = i24;
                }
                restartGroup.startReplaceGroup(-103235253);
                ComposerKt.sourceInformation(restartGroup, "183@8495L39");
                String str4 = "CC(remember):NavigationBar.kt#9igjgp";
                if (interactionSource3 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -103234602, str4);
                    traceInProgress2 = 0;
                    str = restartGroup;
                    i22 = 0;
                    obj53 = $dirty;
                    $dirty = str.rememberedValue();
                    i25 = 0;
                    if ($dirty == Composer.Companion.getEmpty()) {
                        int i60 = 0;
                        str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheNavigationBarKt$NavigationBarItem$interactionSource$1 = $dirty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                } else {
                    obj53 = $dirty;
                    $i$a$CacheNavigationBarKt$NavigationBarItem$interactionSource$1 = interactionSource3;
                }
                restartGroup.endReplaceGroup();
                obj54 = selected;
                obj52 = anon2;
                super(obj53, obj54, z2, obj3, z3, obj6);
                androidx.compose.material3.NavigationBarItemColors navigationBarItemColors = obj53;
                obj54 = $i$a$CacheNavigationBarKt$NavigationBarItem$interactionSource$1;
                int interactionSource5 = 1;
                int i63 = 54;
                restartGroup.startReplaceGroup(-103209106);
                ComposerKt.sourceInformation(restartGroup, "*200@9305L535");
                if (obj3 == null) {
                    i27 = 0;
                } else {
                    i11 = obj3;
                    i22 = 0;
                    anon = new NavigationBarKt.NavigationBarItem.styledLabel.1.1(navigationBarItemColors, obj54, z2, obj3);
                    i27 = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(restartGroup, -103190512, str4);
                Composer composer7 = restartGroup;
                int i104 = 0;
                Object rememberedValue2 = composer7.rememberedValue();
                int i115 = 0;
                obj52 = i41;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i59 = 0;
                    composer7.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf(0));
                } else {
                    $i$a$CacheNavigationBarKt$NavigationBarItem$itemWidth$2 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i72 = obj54;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -103176377, str4);
                Composer composer8 = restartGroup;
                int i90 = 0;
                Object rememberedValue4 = composer8.rememberedValue();
                int i116 = 0;
                obj52 = i65;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj53 = i68;
                    $i$a$CacheNavigationBarKt$NavigationBarItem$1 = new NavigationBarKt.NavigationBarItem.1.1((MutableIntState)$i$a$CacheNavigationBarKt$NavigationBarItem$itemWidth$2);
                    composer8.updateRememberedValue((Function1)$i$a$CacheNavigationBarKt$NavigationBarItem$1);
                } else {
                    $i$a$CacheNavigationBarKt$NavigationBarItem$1 = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(RowScope.weight$default($this$NavigationBarItem, SizeKt.defaultMinSize-VpY3zN4$default(SelectableKt.selectable-O2vRcR0(modifier2, selected, obj54, 0, z2, Role.box-impl(Role.Companion.getTab-o7Vup1c()), obj4), 0, NavigationBarKt.NavigationBarHeight, 1, 0), 1065353216, false, 2, 0), (Function1)$i$a$CacheNavigationBarKt$NavigationBarItem$1);
                Alignment center = Alignment.Companion.getCenter();
                int i91 = i123;
                str = 0;
                obj53 = i77;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, i91);
                i14 = 0;
                obj54 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj56 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, onSizeChanged);
                obj57 = onSizeChanged;
                Function0 function02 = constructor;
                i33 = 0;
                i28 = i91;
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
                int i117 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i121 = 0;
                companion = constructor-impl;
                int i124 = 0;
                if (!companion.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(companion.rememberedValue(), Integer.valueOf(obj56))) {
                        companion.updateRememberedValue(Integer.valueOf(obj56));
                        constructor-impl.apply(Integer.valueOf(obj56), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = companion;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer5 = restartGroup;
                i9 = i47;
                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i15 = 0;
                boxScopeInstance = iNSTANCE;
                i7 = i67;
                Composer $i$a$LayoutBoxKt$Box$1$iv = composer10;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -1652122706, "C234@10492L157,*243@10933L7,249@11215L128,256@11558L293,264@11900L395,281@12555L27,275@12305L288:NavigationBar.kt#uh7d8r");
                i6 = selected ? 1065353216 : 0;
                Composer composer11 = $i$a$LayoutBoxKt$Box$1$iv;
                obj58 = materializeModifier;
                int $composer2 = 0;
                androidx.compose.runtime.State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i6, (AnimationSpec)AnimationSpecKt.tween$default(100, 0, $composer2, i3, $composer2), 0, 0, 0, composer11, 48, 28);
                obj5 = composer11;
                int i126 = 0;
                int i108 = 0;
                int i118 = i80;
                i5 = i95;
                ComposerKt.sourceInformationMarkerStart(obj5, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj5);
                Object this_$iv = consume;
                int roundToPx-0680j_4 = (Density)this_$iv.roundToPx-0680j_4(NavigationBarTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM());
                int i119 = i81;
                int i83 = f3 / f2;
                int i110 = roundToPx-0680j_4;
                Unit $this$NavigationBarItem_u24lambda_u249_u24lambda_u246 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(obj5, 2024938414, str4);
                empty2 = i72;
                long interactionSource6 = l;
                Composer composer9 = obj5;
                int i111 = 0;
                it$iv = composer9.rememberedValue();
                int i122 = 0;
                if (changed3 |= changed8 == 0) {
                    interactionSource2 = empty2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj7 = it$iv;
                        tweenSpec = interactionSource7;
                        obj = modifier2;
                        it$iv = new MappedInteractionSource((InteractionSource)interactionSource2, interactionSource6, i83, 0);
                        composer9.updateRememberedValue(it$iv);
                    } else {
                        obj7 = it$iv;
                        obj = modifier2;
                        composer = composer9;
                    }
                } else {
                    interactionSource2 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(obj5);
                NavigationBarKt.NavigationBarItem.2.indicatorRipple.1 anon5 = new NavigationBarKt.NavigationBarItem.2.indicatorRipple.1((MappedInteractionSource)it$iv);
                i20 = it$iv;
                i30 = interactionSource6;
                int offsetInteractionSource = 54;
                int deltaOffset = 1;
                NavigationBarKt.NavigationBarItem.2.indicator.1 anon4 = new NavigationBarKt.NavigationBarItem.2.indicator.1(animateFloatAsState, navigationBarItemColors);
                ComposerKt.sourceInformationMarkerStart(obj5, 2024981193, str4);
                boolean changed2 = obj5.changed(animateFloatAsState);
                Composer composer6 = obj5;
                i18 = 0;
                Object rememberedValue3 = composer6.rememberedValue();
                int i97 = 0;
                if (!changed2) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        z4 = changed2;
                        invalid$iv = new NavigationBarKt.NavigationBarItem.2.2.1(animateFloatAsState);
                        composer6.updateRememberedValue((Function0)invalid$iv);
                    } else {
                        z4 = changed2;
                        invalid$iv = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj5);
                NavigationBarKt.NavigationBarItemLayout((Function2)ComposableLambdaKt.rememberComposableLambda(691730997, deltaOffset, anon5, obj5, offsetInteractionSource), (Function2)ComposableLambdaKt.rememberComposableLambda(-474426875, deltaOffset, anon4, obj5, offsetInteractionSource), (Function2)ComposableLambdaKt.rememberComposableLambda(-1419576100, interactionSource5, obj52, restartGroup, i63), i27, z3, (Function0)invalid$iv, obj5, i54 |= 438);
                ComposerKt.sourceInformationMarkerEnd(obj5);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                interactionSource4 = navigationBarItemColors;
                colors2 = z2;
                enabled2 = i84;
                z = z3;
                obj9 = obj;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                interactionSource4 = colors;
                i32 = obj58;
                obj9 = modifier2;
                colors2 = z2;
                enabled2 = interactionSource;
                z = i18;
                obj2 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationBarKt.NavigationBarItem.3($this$NavigationBarItem, selected, onClick, icon, obj9, colors2, obj2, z, interactionSource4, enabled2, i102, i103);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
        int traceInProgress2;
        boolean currentCompositionLocalMap;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        Object valueOf2;
        Object materialized$iv$iv;
        boolean currentCompositionLocalMap3;
        int i;
        Object $i$a$CacheNavigationBarKt$NavigationBarItemLayout$1$2;
        Object empty;
        Object str;
        boolean topStart;
        Object valueOf3;
        Composer composer4;
        int materializeModifier;
        Composer restartGroup;
        int $dirty;
        Function0 factory$iv$iv;
        Composer composer7;
        Object maybeCachedBoxMeasurePolicy;
        int i4;
        int i5;
        int i13;
        int i6;
        int i11;
        int i12;
        boolean maybeCachedBoxMeasurePolicy2;
        boolean traceInProgress;
        String $changed$iv;
        int i19;
        int i16;
        Composer composer2;
        Integer valueOf;
        int anon;
        int empty2;
        int currentCompositionLocalMap2;
        int i22;
        int i15;
        int companion2;
        int i17;
        int currentCompositeKeyHash2;
        int i8;
        int i3;
        Composer.Companion companion;
        int i7;
        Composer composer5;
        int i29;
        int i23;
        Composer composer3;
        int i32;
        int i14;
        Function0 function02;
        int i2;
        int i27;
        Function0 function03;
        Modifier modifier2;
        int i18;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        int i30;
        int i31;
        int contentAlignment$iv;
        int i9;
        Object obj;
        int currentCompositeKeyHash;
        int i20;
        int i28;
        Modifier modifier;
        Function0 function0;
        int i21;
        int i24;
        int i26;
        int i25;
        Composer composer6;
        int i10;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        BoxScopeInstance boxScopeInstance;
        Composer composer;
        int obj62;
        materialized$iv$iv = indicatorRipple;
        str = indicator;
        valueOf3 = icon;
        final Object obj2 = label;
        final boolean z3 = alwaysShowLabel;
        final Object obj3 = animationProgress;
        materializeModifier = $changed;
        traceInProgress2 = -1427075886;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationBarItemLayout)P(4,3,2,5)532@23467L1717,517@23004L2180:NavigationBar.kt#uh7d8r");
        if (materializeModifier & 6 == 0) {
            i4 = restartGroup.changedInstance(materialized$iv$iv) ? 4 : 2;
            $dirty |= i4;
        }
        if (materializeModifier & 48 == 0) {
            i5 = restartGroup.changedInstance(str) ? 32 : 16;
            $dirty |= i5;
        }
        if (materializeModifier & 384 == 0) {
            i13 = restartGroup.changedInstance(valueOf3) ? 256 : 128;
            $dirty |= i13;
        }
        i16 = 2048;
        if (materializeModifier & 3072 == 0) {
            i6 = restartGroup.changedInstance(obj2) ? i16 : 1024;
            $dirty |= i6;
        }
        anon = 16384;
        if (materializeModifier & 24576 == 0) {
            i11 = restartGroup.changed(z3) ? anon : 8192;
            $dirty |= i11;
        }
        empty2 = 131072;
        if (i72 &= materializeModifier == 0) {
            i12 = restartGroup.changedInstance(obj3) ? empty2 : 65536;
            $dirty |= i12;
        }
        if (i73 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.NavigationBarItemLayout (NavigationBar.kt:516)");
                }
                maybeCachedBoxMeasurePolicy2 = "CC(remember):NavigationBar.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -96239762, maybeCachedBoxMeasurePolicy2);
                int i34 = 458752;
                companion2 = 1;
                int i35 = 0;
                i22 = $dirty & i34 == empty2 ? companion2 : i35;
                i19 = $dirty & 7168 == i16 ? companion2 : i35;
                int i82 = 57344;
                i15 = $dirty & i82 == anon ? companion2 : i35;
                Composer composer9 = restartGroup;
                int i91 = 0;
                Object rememberedValue5 = composer9.rememberedValue();
                i3 = 0;
                if (i77 |= i15 == 0) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon = new NavigationBarKt.NavigationBarItemLayout.2.1(obj3, obj2, z3);
                        composer9.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i79 = i35;
                valueOf = 0;
                currentCompositionLocalMap2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i35);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion);
                i23 = $dirty;
                Function0 function05 = constructor2;
                i29 = 0;
                i14 = i79;
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
                composer3 = restartGroup;
                Composer constructor-impl2 = Updater.constructor-impl(composer3);
                int i95 = 0;
                function03 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i96 = 0;
                Composer composer11 = constructor-impl2;
                i18 = 0;
                if (!composer11.getInserting()) {
                    localMap$iv = currentCompositionLocalMap;
                    i30 = valueOf;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer11;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap;
                    i30 = valueOf;
                }
                Updater.set-impl(constructor-impl2, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer3;
                i2 = i37;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -656695659, "C518@23021L17,519@23047L11,521@23068L50:NavigationBar.kt#uh7d8r");
                materialized$iv$iv.invoke(restartGroup, Integer.valueOf(i23 & 14));
                str.invoke(restartGroup, Integer.valueOf(i39 &= 14));
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                int i84 = 6;
                i27 = 0;
                str = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                modifier2 = materializeModifier3;
                int materialized$iv = 0;
                i31 = i66;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, materialized$iv);
                i9 = 0;
                obj = topStart2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                i20 = materialized$iv;
                modifier = layoutId;
                Function0 function06 = constructor3;
                i28 = 0;
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
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i100 = 0;
                Composer composer12 = constructor-impl;
                int i103 = 0;
                if (!composer12.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer12;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap3;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, layoutId), ComposeUiNode.Companion.getSetModifier());
                materialized$iv$iv = restartGroup;
                $dirty = 0;
                i24 = i44;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i102 |= 6;
                composer6 = materialized$iv$iv;
                i10 = 0;
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
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1087201972, maybeCachedBoxMeasurePolicy2);
                    i = i23 & i8 == 16384 ? companion2 : 0;
                    if (i23 & obj62 == 131072) {
                    } else {
                        companion2 = 0;
                    }
                    i |= companion2;
                    Composer composer8 = restartGroup;
                    int i68 = 0;
                    Object rememberedValue4 = composer8.rememberedValue();
                    int i86 = 0;
                    if (empty == 0) {
                        obj62 = empty;
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            companion2 = invalid$iv;
                            $i$a$CacheNavigationBarKt$NavigationBarItemLayout$1$2 = new NavigationBarKt.NavigationBarItemLayout.1.2.1(z3, obj3);
                            composer8.updateRememberedValue((Function1)$i$a$CacheNavigationBarKt$NavigationBarItemLayout$1$2);
                        } else {
                            $i$a$CacheNavigationBarKt$NavigationBarItemLayout$1$2 = rememberedValue4;
                        }
                    } else {
                        obj62 = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i69 = 0;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(GraphicsLayerModifierKt.graphicsLayer(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label"), (Function1)$i$a$CacheNavigationBarKt$NavigationBarItemLayout$1$2), Dp.constructor-impl(navigationBarItemHorizontalPadding / f), 0, 2, 0);
                    int i58 = i93;
                    materializeModifier = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, str);
                    topStart = Alignment.Companion.getTopStart();
                    companion2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                    i17 = currentCompositeKeyHash3;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, padding-VpY3zN4$default);
                    i3 = padding-VpY3zN4$default;
                    Function0 function04 = constructor;
                    i8 = 0;
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
                    function02 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i94 = 0;
                    Composer composer10 = constructor-impl3;
                    int i97 = 0;
                    if (!composer10.getInserting()) {
                        contentAlignment$iv = topStart;
                        if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(i17))) {
                            composer10.updateRememberedValue(Integer.valueOf(i17));
                            constructor-impl3.apply(Integer.valueOf(i17), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer10;
                        }
                    } else {
                        contentAlignment$iv = topStart;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    str = restartGroup;
                    valueOf3 = 0;
                    companion = i51;
                    ComposerKt.sourceInformationMarkerStart(str, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i81 |= 6;
                    composer5 = str;
                    i27 = 0;
                    i18 = iNSTANCE2;
                    i9 = materializeModifier2;
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
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer3 = restartGroup;
                i23 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationBarKt.NavigationBarItemLayout.3(indicatorRipple, indicator, icon, obj2, z3, obj3, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
