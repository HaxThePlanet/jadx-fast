package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
import androidx.compose.material3.tokens.NavigationRailTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
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
@Metadata(d1 = "\u0000\u0084\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u000c\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\u001az\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u001b2 \u0008\u0002\u0010\u001d\u001a\u001a\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001e¢\u0006\u0002\u0008 ¢\u0006\u0002\u0008!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u00170\u001e¢\u0006\u0002\u0008 ¢\u0006\u0002\u0008!H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a\u0081\u0001\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020)2\u000c\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00170+2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\u0008 2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010-\u001a\u00020)2\u0015\u0008\u0002\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\u0008 2\u0008\u0008\u0002\u0010/\u001a\u00020)2\u0008\u0008\u0002\u00100\u001a\u0002012\n\u0008\u0002\u00102\u001a\u0004\u0018\u000103H\u0007¢\u0006\u0002\u00104\u001aq\u00105\u001a\u00020\u00172\u0011\u00106\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\u0008 2\u0011\u00107\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\u0008 2\u0011\u0010,\u001a\r\u0012\u0004\u0012\u00020\u00170+¢\u0006\u0002\u0008 2\u0013\u0010.\u001a\u000f\u0012\u0004\u0012\u00020\u0017\u0018\u00010+¢\u0006\u0002\u0008 2\u0006\u0010/\u001a\u00020)2\u000c\u00108\u001a\u0008\u0012\u0004\u0012\u0002090+H\u0003¢\u0006\u0002\u0010:\u001a8\u0010;\u001a\u00020<*\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0008\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\u0008D\u0010E\u001aP\u0010F\u001a\u00020<*\u00020=2\u0006\u0010G\u001a\u00020?2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020?2\u0008\u0010A\u001a\u0004\u0018\u00010?2\u0006\u0010B\u001a\u00020C2\u0006\u0010/\u001a\u00020)2\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\u0008H\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000c\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\r\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u000e\u0010\u000f\"\u0016\u0010\u0010\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0011\u0010\u000f\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0013\u0010\u000f\"\u0016\u0010\u0014\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0015\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006J²\u0006\n\u0010K\u001a\u00020\u001bX\u008a\u0084\u0002²\u0006\n\u0010L\u001a\u00020\u001bX\u008a\u0084\u0002", d2 = {"IconLayoutIdTag", "", "IndicatorHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalPaddingNoLabel", "IndicatorVerticalPaddingWithLabel", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationRailHeaderPadding", "NavigationRailItemHeight", "getNavigationRailItemHeight", "()F", "NavigationRailItemVerticalPadding", "getNavigationRailItemVerticalPadding", "NavigationRailItemWidth", "getNavigationRailItemWidth", "NavigationRailVerticalPadding", "getNavigationRailVerticalPadding", "NavigationRail", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "header", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "content", "NavigationRail-qi6gXK8", "(Landroidx/compose/ui/Modifier;JJLkotlin/jvm/functions/Function3;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItem", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "enabled", "label", "alwaysShowLabel", "colors", "Landroidx/compose/material3/NavigationRailItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/NavigationRailItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationRailItemLayout", "indicatorRipple", "indicator", "animationProgress", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-zUg2_y0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JZF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "iconColor", "textColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavigationRailKt {

    private static final String IconLayoutIdTag = "icon";
    private static final float IndicatorHorizontalPadding = 0f;
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalPaddingNoLabel = 0f;
    private static final float IndicatorVerticalPaddingWithLabel = 0f;
    private static final int ItemAnimationDurationMillis = 150;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationRailHeaderPadding;
    private static final float NavigationRailItemHeight;
    private static final float NavigationRailItemVerticalPadding;
    private static final float NavigationRailItemWidth;
    private static final float NavigationRailVerticalPadding;
    static {
        int i4 = 0;
        NavigationRailKt.NavigationRailVerticalPadding = Dp.constructor-impl((float)i);
        int i5 = 0;
        NavigationRailKt.NavigationRailHeaderPadding = Dp.constructor-impl((float)i2);
        NavigationRailKt.NavigationRailItemWidth = NavigationRailTokens.INSTANCE.getContainerWidth-D9Ej5fM();
        NavigationRailKt.NavigationRailItemHeight = NavigationRailTokens.INSTANCE.getNoLabelActiveIndicatorHeight-D9Ej5fM();
        int i6 = 0;
        NavigationRailKt.NavigationRailItemVerticalPadding = Dp.constructor-impl((float)i3);
        int i7 = 0;
        int i8 = 0;
        NavigationRailKt.IndicatorHorizontalPadding = Dp.constructor-impl(arg0$iv / f4);
        int i9 = 0;
        int i10 = 0;
        NavigationRailKt.IndicatorVerticalPaddingWithLabel = Dp.constructor-impl(arg0$iv3 / f5);
        int i11 = 0;
        int i12 = 0;
        NavigationRailKt.IndicatorVerticalPaddingNoLabel = Dp.constructor-impl(arg0$iv5 / f6);
    }

    public static final void NavigationRail-qi6gXK8(Modifier modifier, long containerColor, long contentColor, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> header, WindowInsets windowInsets, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress2;
        Object $composer2;
        int $dirty2;
        long $dirty;
        Object $dirty3;
        int modifier3;
        Object modifier2;
        Object obj3;
        long windowInsets3;
        int containerColor2;
        int containerColor3;
        Object windowInsets2;
        int i2;
        long l;
        boolean traceInProgress;
        Object obj4;
        long str;
        int changed;
        int i5;
        Object obj2;
        boolean changed3;
        long contentColor2;
        int i10;
        Object header2;
        int i7;
        Object obj;
        int changed2;
        int i11;
        boolean skipping;
        int defaultsInvalid;
        int i12;
        int i;
        int i3;
        int i6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i8;
        int i4;
        long l2;
        final Object obj6 = $changed;
        final int i32 = obj34;
        traceInProgress2 = 118552648;
        Composer restartGroup = i9.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)113@5242L14,114@5284L31,116@5431L12,123@5614L618,119@5501L731:NavigationRail.kt#uh7d8r");
        $dirty2 = obj34;
        modifier3 = obj35 & 1;
        if (modifier3 != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i32 & 6 == 0) {
                i2 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i2;
            } else {
                obj3 = modifier;
            }
        }
        if (i32 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                l = containerColor;
            }
            $dirty2 |= changed;
        } else {
            l = containerColor;
        }
        if (i32 & 384 == 0) {
            if (obj35 & 4 == 0) {
                i5 = restartGroup.changed(header) ? 256 : 128;
            } else {
                contentColor2 = header;
            }
            $dirty2 |= i5;
        } else {
            contentColor2 = header;
        }
        int i30 = obj35 & 8;
        if (i30 != 0) {
            $dirty2 |= 3072;
            header2 = content;
        } else {
            if (i32 & 3072 == 0) {
                i7 = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty2 |= i7;
            } else {
                header2 = content;
            }
        }
        if (i32 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                changed2 = restartGroup.changed($composer) ? 16384 : 8192;
            } else {
                obj = $composer;
            }
            $dirty2 |= changed2;
        } else {
            obj = $composer;
        }
        int i39 = 196608;
        if (obj35 & 32 != 0) {
            $dirty2 |= i39;
        } else {
            if (i32 & i39 == 0) {
                i11 = restartGroup.changedInstance(obj6) ? 131072 : 65536;
                $dirty2 |= i11;
            }
        }
        if (i37 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i12 = -57345;
                if (i32 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (modifier3 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        int i38 = 6;
                        if (obj35 & 2 != 0) {
                            $dirty2 &= -113;
                            l = containerColor2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColor2 = ColorSchemeKt.contentColorFor-ek8zF_U(l, obj6, restartGroup);
                            $dirty2 &= -897;
                        }
                        if (i30 != 0) {
                            header2 = containerColor3;
                        }
                        if (obj35 & 16 != 0) {
                            windowInsets2 = NavigationRailDefaults.INSTANCE.getWindowInsets(restartGroup, i38);
                            skipping = contentColor2;
                            contentColor2 = modifier2;
                            modifier3 = $dirty4;
                            $dirty3 = header2;
                            header2 = l;
                        } else {
                            skipping = contentColor2;
                            windowInsets2 = obj;
                            contentColor2 = modifier2;
                            modifier3 = $dirty2;
                            $dirty3 = header2;
                            header2 = l;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj35 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj35 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj35 & 16 != 0) {
                            modifier3 = $dirty5;
                            skipping = contentColor2;
                            $dirty3 = header2;
                            contentColor2 = obj3;
                            windowInsets2 = obj;
                            header2 = l;
                        } else {
                            modifier3 = $dirty2;
                            skipping = contentColor2;
                            $dirty3 = header2;
                            contentColor2 = obj3;
                            windowInsets2 = obj;
                            header2 = l;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, modifier3, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:118)");
                }
                NavigationRailKt.NavigationRail.1 anon = new NavigationRailKt.NavigationRail.1(windowInsets2, $dirty3, obj6);
                SurfaceKt.Surface-T9BRK9s(contentColor2, 0, header2, obj, skipping, i12, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-2092683357, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = $dirty3;
                i10 = modifier3;
                obj2 = windowInsets2;
                $composer2 = contentColor2;
                $dirty = header2;
                windowInsets3 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj3;
                obj2 = obj;
                i10 = $dirty2;
                $dirty = l;
                windowInsets3 = l2;
                obj4 = header2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationRailKt.NavigationRail.2($composer2, $dirty, modifier3, windowInsets3, l, obj4, obj2, obj6, i32, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void NavigationRailItem(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, androidx.compose.material3.NavigationRailItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        Object alignment;
        Object obj2;
        boolean traceInProgress2;
        Object colors3;
        Object colors2;
        int $this$NavigationRailItem_u24lambda_u245;
        int defaultsInvalid;
        int i30;
        Object rememberedValue;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        Object anon3;
        boolean changed;
        int $dirty;
        boolean maybeCachedBoxMeasurePolicy;
        int i23;
        Object value;
        Object empty;
        Composer composer;
        boolean z5;
        Object obj4;
        boolean traceInProgress;
        int i28;
        Object obj;
        boolean z3;
        Object anon;
        Composer composer5;
        Object currentCompositionLocalMap;
        int i7;
        Object obj6;
        int interactionSource2;
        Object modifier2;
        boolean z4;
        int i16;
        int i8;
        androidx.compose.material3.NavigationRailItemColors navigationRailItemColors;
        int str;
        boolean z;
        int enabled2;
        int i27;
        int i;
        int i9;
        Object i20;
        Object obj3;
        int i25;
        int i2;
        int i21;
        int i19;
        int i15;
        int changed2;
        int i33;
        int i6;
        androidx.compose.runtime.internal.ComposableLambda companion3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        boolean z2;
        androidx.compose.material3.NavigationRailKt.NavigationRailItem.1.2.1 anon2;
        int companion2;
        Composer composer4;
        Object companion;
        Object obj7;
        int i24;
        int i10;
        int i32;
        int i17;
        Modifier modifier3;
        Function0 function0;
        int i31;
        int i5;
        int i4;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier4;
        int i22;
        int i18;
        Object interactionSource3;
        Object obj5;
        int i34;
        int i29;
        Composer composer2;
        int i3;
        int i11;
        int i26;
        BoxScopeInstance boxScopeInstance;
        int i13;
        Composer composer3;
        int i14;
        boolean obj52;
        int obj53;
        MappedInteractionSource obj54;
        int obj55;
        Alignment obj56;
        int obj57;
        int obj58;
        final int i85 = $changed;
        final int i86 = i12;
        final Composer restartGroup = $composer.startRestartGroup(-1533971045);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRailItem)P(8,7,3,6,2,5)179@8055L8,185@8288L633,215@9569L2776:NavigationRail.kt#uh7d8r");
        $dirty = $changed;
        if (i86 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i85 & 6 == 0) {
                i23 = restartGroup.changed(selected) ? 4 : 2;
                $dirty |= i23;
            }
        }
        if (i86 & 2 != 0) {
            $dirty |= 48;
            value = onClick;
        } else {
            if (i85 & 48 == 0) {
                i28 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i28;
            } else {
                value = onClick;
            }
        }
        if (i86 & 4 != 0) {
            $dirty |= 384;
            obj = icon;
        } else {
            if (i85 & 384 == 0) {
                i7 = restartGroup.changedInstance(icon) ? 256 : 128;
                $dirty |= i7;
            } else {
                obj = icon;
            }
        }
        int i74 = i86 & 8;
        if (i74 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else {
            if (i85 & 3072 == 0) {
                i8 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                modifier2 = modifier;
            }
        }
        str = i86 & 16;
        if (str != null) {
            $dirty |= 24576;
            z = enabled;
        } else {
            if (i85 & 24576 == 0) {
                i27 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty |= i27;
            } else {
                z = enabled;
            }
        }
        i9 = i86 & 32;
        int i91 = 196608;
        if (i9 != 0) {
            $dirty |= i91;
            obj3 = label;
        } else {
            if (i91 &= i85 == 0) {
                i25 = restartGroup.changedInstance(label) ? 131072 : 65536;
                $dirty |= i25;
            } else {
                obj3 = label;
            }
        }
        i2 = i86 & 64;
        i21 = 1572864;
        if (i2 != 0) {
            $dirty |= i21;
            z5 = alwaysShowLabel;
        } else {
            if (i85 & i21 == 0) {
                i19 = restartGroup.changed(alwaysShowLabel) ? 1048576 : 524288;
                $dirty |= i19;
            } else {
                z5 = alwaysShowLabel;
            }
        }
        if (i85 & i97 == 0) {
            if (i86 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                alignment = colors;
            }
            $dirty |= changed2;
        } else {
            alignment = colors;
        }
        int i37 = i86 & 256;
        int i98 = 100663296;
        if (i37 != 0) {
            $dirty |= i98;
            i33 = i37;
            obj2 = interactionSource;
        } else {
            if (i85 & i98 == 0) {
                i33 = i37;
                i6 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i6;
            } else {
                i33 = i37;
                obj2 = interactionSource;
            }
        }
        if ($dirty & companion3 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                obj58 = -29360129;
                rememberedValue = 6;
                if (i85 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i74 != 0) {
                            modifier2 = defaultsInvalid;
                        }
                        if (str != null) {
                            z = defaultsInvalid;
                        }
                        if (i9 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i2 != 0) {
                            z5 = defaultsInvalid;
                        }
                        if (i86 & 128 != 0) {
                            colors3 = NavigationRailItemDefaults.INSTANCE.colors(restartGroup, rememberedValue);
                            $dirty &= obj58;
                        } else {
                            colors3 = colors;
                        }
                        z2 = i33 != 0 ? z5 : z5;
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i86 & 128 != 0) {
                            $dirty &= obj58;
                        }
                        colors3 = colors;
                        interactionSource2 = interactionSource;
                        z2 = z5;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1533971045, $dirty, -1, "androidx.compose.material3.NavigationRailItem (NavigationRail.kt:181)");
                }
                restartGroup.startReplaceGroup(-782588008);
                ComposerKt.sourceInformation(restartGroup, "183@8207L39");
                String str6 = "CC(remember):NavigationRail.kt#9igjgp";
                if (interactionSource2 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -782587357, str6);
                    str = 0;
                    i9 = restartGroup;
                    i2 = 0;
                    i15 = rememberedValue;
                    rememberedValue = i9.rememberedValue();
                    i33 = 0;
                    obj53 = colors3;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i38 = 0;
                        i9.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        colors2 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                } else {
                    obj53 = colors3;
                    i15 = rememberedValue;
                    colors2 = interactionSource2;
                }
                restartGroup.endReplaceGroup();
                obj54 = selected;
                obj52 = anon4;
                super(obj53, obj54, z, obj3, z2, obj);
                navigationRailItemColors = obj53;
                int i93 = 1;
                obj54 = colors2;
                int interactionSource4 = 54;
                restartGroup.startReplaceGroup(-782561860);
                ComposerKt.sourceInformation(restartGroup, "*200@9017L536");
                if (obj3 == null) {
                    composableLambda = 0;
                } else {
                    i20 = obj3;
                    i33 = 0;
                    anon = new NavigationRailKt.NavigationRailItem.styledLabel.1.1(navigationRailItemColors, obj54, z, obj3);
                    composableLambda = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                empty = obj54;
                int i87 = 0;
                int i39 = 0;
                obj53 = i93;
                Modifier widthIn-VpY3zN4$default = SizeKt.widthIn-VpY3zN4$default(SizeKt.defaultMinSize-VpY3zN4$default(SelectableKt.selectable-O2vRcR0(modifier2, selected, obj54, 0, z, Role.box-impl(Role.Companion.getTab-o7Vup1c()), value), i87, NavigationRailKt.NavigationRailItemHeight, i93, i39), NavigationRailKt.NavigationRailItemWidth, i87, 2, i39);
                Alignment center = Alignment.Companion.getCenter();
                int i67 = 432;
                i32 = 0;
                obj55 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, obj53);
                i17 = 0;
                obj56 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj58 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, widthIn-VpY3zN4$default);
                modifier3 = widthIn-VpY3zN4$default;
                Function0 function02 = constructor;
                i31 = 0;
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
                int i99 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i103 = 0;
                companion = constructor-impl;
                int i105 = 0;
                if (!companion.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(companion.rememberedValue(), Integer.valueOf(obj58))) {
                        companion.updateRememberedValue(Integer.valueOf(obj58));
                        constructor-impl.apply(Integer.valueOf(obj58), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = companion;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = restartGroup;
                modifier4 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer8 = composer6;
                i26 = 0;
                boxScopeInstance = iNSTANCE;
                i13 = i47;
                ComposerKt.sourceInformationMarkerStart(composer6, 584386773, "C231@10130L157,*240@10571L7,246@10874L128,260@11450L261,268@11760L280,282@12301L27,276@12050L289:NavigationRail.kt#uh7d8r");
                i18 = selected ? $this$NavigationRailItem_u24lambda_u245 : 0;
                Composer composer9 = composer6;
                i14 = i68;
                int $composer2 = 0;
                androidx.compose.runtime.State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i18, (AnimationSpec)AnimationSpecKt.tween$default(150, 0, $composer2, i15, $composer2), 0, 0, 0, composer9, 48, 28);
                $dirty = composer9;
                int i104 = 0;
                int i100 = 0;
                int i106 = i70;
                i22 = i78;
                ComposerKt.sourceInformationMarkerStart($dirty, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd($dirty);
                Object this_$iv = consume;
                int roundToPx-0680j_42 = (Density)this_$iv.roundToPx-0680j_4(NavigationRailKt.NavigationRailItemWidth);
                i10 = i71;
                int roundToPx-0680j_4 = this_$iv.roundToPx-0680j_4(NavigationRailTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM());
                Object obj10 = this_$iv;
                int i95 = roundToPx-0680j_4;
                obj54 = roundToPx-0680j_42;
                long l = OffsetKt.Offset(f3 / f2, 0);
                Unit iNSTANCE3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($dirty, -119672869, str6);
                obj54 = $dirty;
                int i96 = 0;
                it$iv = obj54.rememberedValue();
                companion2 = 0;
                if (changed3 |= changed7 == 0) {
                    interactionSource3 = empty;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj7 = it$iv;
                        i10 = interactionSource5;
                        obj5 = modifier2;
                        it$iv = new MappedInteractionSource((InteractionSource)interactionSource3, l, roundToPx-0680j_42, 0);
                        obj54.updateRememberedValue(it$iv);
                    } else {
                        composer = obj54;
                        obj7 = it$iv;
                        obj5 = modifier2;
                    }
                } else {
                    interactionSource3 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd($dirty);
                if (obj3 != null) {
                    $dirty.startReplaceGroup(585295320);
                    ComposerKt.sourceInformation($dirty, "252@11124L5");
                    value = ShapesKt.getValue(NavigationRailTokens.INSTANCE.getActiveIndicatorShape(), $dirty, 6);
                    $dirty.endReplaceGroup();
                } else {
                    $dirty.startReplaceGroup(585379857);
                    ComposerKt.sourceInformation($dirty, "254@11216L5");
                    value = ShapesKt.getValue(NavigationRailTokens.INSTANCE.getNoLabelActiveIndicatorShape(), $dirty, 6);
                    $dirty.endReplaceGroup();
                }
                NavigationRailKt.NavigationRailItem.1.indicatorRipple.1 anon7 = new NavigationRailKt.NavigationRailItem.1.indicatorRipple.1(value, (MappedInteractionSource)it$iv);
                obj54 = it$iv;
                i21 = l;
                int deltaOffset = 54;
                int i79 = obj53;
                NavigationRailKt.NavigationRailItem.1.indicator.1 anon5 = new NavigationRailKt.NavigationRailItem.1.indicator.1(animateFloatAsState, navigationRailItemColors, value);
                ComposerKt.sourceInformationMarkerStart($dirty, -119627306, str6);
                changed = $dirty.changed(animateFloatAsState);
                Composer composer7 = $dirty;
                int i72 = 0;
                Object rememberedValue3 = composer7.rememberedValue();
                int i82 = 0;
                if (!changed) {
                    obj52 = changed;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj53 = invalid$iv;
                        anon3 = new NavigationRailKt.NavigationRailItem.1.2.1(animateFloatAsState);
                        composer7.updateRememberedValue((Function0)anon3);
                    } else {
                        anon3 = rememberedValue3;
                    }
                } else {
                    obj52 = changed;
                }
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer4 = $dirty;
                NavigationRailKt.NavigationRailItemLayout((Function2)ComposableLambdaKt.rememberComposableLambda(211026382, i79, anon7, $dirty, deltaOffset), (Function2)ComposableLambdaKt.rememberComposableLambda(-1862011490, i79, anon5, $dirty, deltaOffset), (Function2)ComposableLambdaKt.rememberComposableLambda(-1023357515, i93, obj52, restartGroup, interactionSource4), composableLambda, z2, (Function0)anon3, composer4, i55 |= 438);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = obj55;
                z3 = z;
                z4 = z2;
                enabled2 = i4;
                obj4 = obj5;
                obj6 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                z4 = z5;
                obj4 = obj9;
                navigationRailItemColors = colors;
                i = $dirty;
                z3 = z;
                enabled2 = interactionSource;
                obj6 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationRailKt.NavigationRailItem.2(selected, onClick, icon, obj4, z3, obj6, z4, navigationRailItemColors, enabled2, i85, i86);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void NavigationRailItemLayout(Function2<? super Composer, ? super Integer, Unit> indicatorRipple, Function2<? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, Function0<Float> animationProgress, Composer $composer, int $changed) {
        int traceInProgress;
        boolean currentCompositionLocalMap2;
        Function0 factory$iv$iv$iv2;
        Object $changed$iv4;
        Object $changed$iv3;
        boolean currentCompositionLocalMap;
        Function0 factory$iv$iv$iv;
        Object materialized$iv$iv2;
        Object empty;
        Object anon;
        int valueOf3;
        boolean valueOf2;
        Composer composer;
        int materialized$iv$iv;
        int i;
        Composer restartGroup;
        int $dirty;
        Function0 factory$iv$iv;
        Composer composer3;
        Object maybeCachedBoxMeasurePolicy;
        int i26;
        int i27;
        int i8;
        int i9;
        int i6;
        int i12;
        boolean maybeCachedBoxMeasurePolicy2;
        boolean traceInProgress2;
        int $changed$iv;
        int i10;
        int i23;
        Object valueOf;
        Composer composer7;
        int empty2;
        int str;
        int i31;
        Object currentCompositionLocalMap3;
        int i11;
        int i32;
        int i5;
        int currentCompositeKeyHash;
        int companion;
        int i2;
        Object companion2;
        Composer composer5;
        int i28;
        int i16;
        int i29;
        Composer composer4;
        int i3;
        int i30;
        int i14;
        int i20;
        int i24;
        Function0 function0;
        Modifier modifier;
        int i7;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        androidx.compose.material3.NavigationRailKt.NavigationRailItemLayout.2.1 anon2;
        int i17;
        int i25;
        int $changed$iv2;
        Object obj;
        int currentCompositeKeyHash2;
        int i15;
        int i4;
        Modifier modifier3;
        Function0 function02;
        int i18;
        int i21;
        BoxScopeInstance iNSTANCE;
        int i22;
        int i19;
        Composer composer6;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i13;
        Composer composer2;
        Modifier modifier2;
        int obj62;
        $changed$iv3 = indicatorRipple;
        materialized$iv$iv2 = indicator;
        empty = icon;
        final Object obj2 = label;
        valueOf2 = alwaysShowLabel;
        final Object obj3 = animationProgress;
        materialized$iv$iv = $changed;
        traceInProgress = 1498399348;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRailItemLayout)P(4,3,2,5)530@23300L1924,515@22904L2320:NavigationRail.kt#uh7d8r");
        if (materialized$iv$iv & 6 == 0) {
            i26 = restartGroup.changedInstance($changed$iv3) ? 4 : 2;
            $dirty |= i26;
        }
        if (materialized$iv$iv & 48 == 0) {
            i27 = restartGroup.changedInstance(materialized$iv$iv2) ? 32 : 16;
            $dirty |= i27;
        }
        if (materialized$iv$iv & 384 == 0) {
            i8 = restartGroup.changedInstance(empty) ? 256 : 128;
            $dirty |= i8;
        }
        $changed$iv = 2048;
        if (materialized$iv$iv & 3072 == 0) {
            i9 = restartGroup.changedInstance(obj2) ? $changed$iv : 1024;
            $dirty |= i9;
        }
        i23 = 16384;
        if (materialized$iv$iv & 24576 == 0) {
            i6 = restartGroup.changed(valueOf2) ? i23 : 8192;
            $dirty |= i6;
        }
        empty2 = 131072;
        if (i68 &= materialized$iv$iv == 0) {
            i12 = restartGroup.changedInstance(obj3) ? empty2 : 65536;
            $dirty |= i12;
        }
        if (i69 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:514)");
                }
                maybeCachedBoxMeasurePolicy2 = "CC(remember):NavigationRail.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1881815062, maybeCachedBoxMeasurePolicy2);
                int i34 = 458752;
                int i35 = 0;
                i31 = $dirty & i34 == empty2 ? 1 : i35;
                i10 = $dirty & 7168 == $changed$iv ? 1 : i35;
                int i83 = 57344;
                i11 = $dirty & i83 == i23 ? 1 : i35;
                Composer composer10 = restartGroup;
                int i88 = 0;
                Object rememberedValue5 = composer10.rememberedValue();
                i2 = 0;
                if (i72 |= i11 == 0) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        valueOf = new NavigationRailKt.NavigationRailItemLayout.2.1(obj3, obj2, valueOf2);
                        composer10.updateRememberedValue((MeasurePolicy)valueOf);
                    } else {
                        valueOf = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i74 = i35;
                empty2 = 0;
                currentCompositionLocalMap3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap3);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i35);
                currentCompositionLocalMap2 = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, (Modifier)Modifier.Companion);
                i29 = $dirty;
                Function0 function04 = constructor2;
                i16 = 0;
                i30 = i74;
                $changed$iv = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function04);
                } else {
                    factory$iv$iv = function04;
                    restartGroup.useNode();
                }
                composer4 = restartGroup;
                Composer constructor-impl2 = Updater.constructor-impl(composer4);
                int i92 = 0;
                function0 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)valueOf, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i93 = 0;
                Composer composer11 = constructor-impl2;
                i7 = 0;
                if (!composer11.getInserting()) {
                    localMap$iv = currentCompositionLocalMap2;
                    anon2 = valueOf;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer11;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap2;
                    anon2 = valueOf;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer4;
                i20 = i37;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2082816907, "C516@22921L17,517@22947L11,519@22968L50:NavigationRail.kt#uh7d8r");
                $changed$iv3.invoke(restartGroup, Integer.valueOf(i29 & 14));
                materialized$iv$iv2.invoke(restartGroup, Integer.valueOf(i39 &= 14));
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                int i79 = 6;
                i24 = 0;
                materialized$iv$iv2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv2);
                Alignment topStart = Alignment.Companion.getTopStart();
                modifier = materializeModifier2;
                int materialized$iv = 0;
                i17 = i64;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, materialized$iv);
                $changed$iv2 = 0;
                obj = topStart;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap3);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                i15 = materialized$iv;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, layoutId);
                modifier3 = layoutId;
                Function0 function05 = constructor3;
                i4 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function05);
                } else {
                    factory$iv$iv$iv2 = function05;
                    restartGroup.useNode();
                }
                function02 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i96 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i97 = 0;
                Composer composer13 = constructor-impl;
                int i100 = 0;
                if (!composer13.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer13.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer13.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer13;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = restartGroup;
                $dirty = 0;
                i21 = i44;
                $changed$iv4 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv4);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i99 |= 6;
                i13 = 0;
                modifier2 = materializeModifier3;
                materialized$iv$iv = composer6;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 402566553, "C519@23010L6:NavigationRail.kt#uh7d8r");
                empty.invoke(materialized$iv$iv, Integer.valueOf(i49 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(2145400941);
                ComposerKt.sourceInformation(restartGroup, "523@23132L96,522@23061L221");
                if (obj2 != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2145404101, maybeCachedBoxMeasurePolicy2);
                    i = i29 & companion == 16384 ? 1 : 0;
                    i5 = i29 & obj62 == 131072 ? 1 : 0;
                    Composer composer9 = restartGroup;
                    int i71 = 0;
                    Object rememberedValue4 = composer9.rememberedValue();
                    int i87 = 0;
                    if (i |= i5 == 0) {
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            obj62 = i57;
                            anon = new NavigationRailKt.NavigationRailItemLayout.1.2.1(valueOf2, obj3);
                            composer9.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue4;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label"), (Function1)anon);
                    valueOf3 = i90;
                    materialized$iv$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv2);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i32 = 0;
                    obj62 = topStart2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap3);
                    companion = currentCompositeKeyHash3;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, graphicsLayer);
                    companion2 = graphicsLayer;
                    Function0 function03 = constructor;
                    i2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function03);
                    } else {
                        factory$iv$iv$iv = function03;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                    int i89 = 0;
                    i24 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i91 = 0;
                    Composer composer12 = constructor-impl3;
                    int i95 = 0;
                    if (!composer12.getInserting()) {
                        $changed$iv2 = valueOf3;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(companion))) {
                            composer12.updateRememberedValue(Integer.valueOf(companion));
                            constructor-impl3.apply(Integer.valueOf(companion), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer12;
                        }
                    } else {
                        $changed$iv2 = valueOf3;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    empty = restartGroup;
                    valueOf2 = 0;
                    ComposerKt.sourceInformationMarkerStart(empty, -2146769399, $changed$iv4);
                    i77 |= 6;
                    i14 = 0;
                    i7 = iNSTANCE2;
                    i25 = i55;
                    obj = materializeModifier;
                    materialized$iv$iv2 = composer5;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 402815576, "C527@23261L7:NavigationRail.kt#uh7d8r");
                    obj2.invoke(materialized$iv$iv2, Integer.valueOf(i45 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                    ComposerKt.sourceInformationMarkerEnd(empty);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer4 = restartGroup;
                i29 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationRailKt.NavigationRailItemLayout.3(indicatorRipple, indicator, icon, obj2, alwaysShowLabel, obj3, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$NavigationRailItemLayout(Function2 indicatorRipple, Function2 indicator, Function2 icon, Function2 label, boolean alwaysShowLabel, Function0 animationProgress, Composer $composer, int $changed) {
        NavigationRailKt.NavigationRailItemLayout(indicatorRipple, indicator, icon, label, alwaysShowLabel, animationProgress, $composer, $changed);
    }

    public static final float access$getIndicatorHorizontalPadding$p() {
        return NavigationRailKt.IndicatorHorizontalPadding;
    }

    public static final float access$getIndicatorVerticalPaddingNoLabel$p() {
        return NavigationRailKt.IndicatorVerticalPaddingNoLabel;
    }

    public static final float access$getIndicatorVerticalPaddingWithLabel$p() {
        return NavigationRailKt.IndicatorVerticalPaddingWithLabel;
    }

    public static final float access$getNavigationRailHeaderPadding$p() {
        return NavigationRailKt.NavigationRailHeaderPadding;
    }

    public static final MeasureResult access$placeIcon-X9ElhV4(MeasureScope $receiver, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        return NavigationRailKt.placeIcon-X9ElhV4($receiver, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
    }

    public static final MeasureResult access$placeLabelAndIcon-zUg2_y0(MeasureScope $receiver, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        return NavigationRailKt.placeLabelAndIcon-zUg2_y0($receiver, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, alwaysShowLabel, animationProgress);
    }

    public static final float getNavigationRailItemHeight() {
        return NavigationRailKt.NavigationRailItemHeight;
    }

    public static final float getNavigationRailItemVerticalPadding() {
        return NavigationRailKt.NavigationRailItemVerticalPadding;
    }

    public static final float getNavigationRailItemWidth() {
        return NavigationRailKt.NavigationRailItemWidth;
    }

    public static final float getNavigationRailVerticalPadding() {
        return NavigationRailKt.NavigationRailVerticalPadding;
    }

    private static final MeasureResult placeIcon-X9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        int width;
        final Object obj = constraints;
        if (indicatorPlaceable != null) {
            width = indicatorPlaceable.getWidth();
        } else {
            width = 0;
        }
        final int i17 = constrainWidth-K40F9xA;
        final MeasureScope measureScope2 = $this$placeIcon_u2dX9ElhV4;
        final int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(obj, obj1);
        int i10 = i2 / 2;
        int i12 = i3 / 2;
        int i14 = i4 / 2;
        int i16 = i5 / 2;
        NavigationRailKt.placeIcon.1 anon = new NavigationRailKt.placeIcon.1(indicatorPlaceable, iconPlaceable, i10, i12, indicatorRipplePlaceable, i14, i16, i17, constrainHeight-K40F9xA);
        int i6 = i10;
        final int i18 = i14;
        final int i19 = i16;
        int rippleY = i12;
        return MeasureScope.layout$default(measureScope2, i17, constrainHeight-K40F9xA, 0, (Function1)anon, 4, 0);
    }

    private static final MeasureResult placeLabelAndIcon-zUg2_y0(MeasureScope $this$placeLabelAndIcon_u2dzUg2_y0, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, boolean alwaysShowLabel, float animationProgress) {
        float f;
        int width;
        final MeasureScope measureScope2 = $this$placeLabelAndIcon_u2dzUg2_y0;
        final int i32 = i3;
        float f8 = (float)i16;
        final float f10 = coerceAtLeast;
        final int i33 = i32 + i6;
        final float f9 = f10;
        if (animationProgress) {
            f = f9;
        } else {
            i15 /= f8;
        }
        int i24 = i10 + px-0680j_45;
        if (indicatorPlaceable != null) {
            width = indicatorPlaceable.getWidth();
        } else {
            width = 0;
        }
        final int constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(constraints, width);
        int i22 = i12 / 2;
        int i28 = i13 / 2;
        NavigationRailKt.placeLabelAndIcon.1 anon = new NavigationRailKt.placeLabelAndIcon.1(indicatorPlaceable, animationProgress, obj30, labelPlaceable, i22, i24, i34 * i8, iconPlaceable, i28, f9, indicatorRipplePlaceable, i14 / 2, f9 - px-0680j_4, constrainWidth-K40F9xA, measureScope2);
        int i27 = i24;
        int i29 = i28;
        int iconX = i22;
        return MeasureScope.layout$default($this$placeLabelAndIcon_u2dzUg2_y0, constrainWidth-K40F9xA, MathKt.roundToInt(i33), 0, (Function1)anon, 4, 0);
    }
}
