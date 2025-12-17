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
        int traceInProgress;
        Object $composer2;
        int $dirty2;
        long $dirty3;
        Object $dirty;
        int modifier2;
        Object modifier3;
        Object obj3;
        long windowInsets3;
        int containerColor2;
        int containerColor3;
        Object windowInsets2;
        int i11;
        long l2;
        boolean traceInProgress2;
        Object obj2;
        long str;
        int changed;
        int i3;
        Object obj;
        boolean changed2;
        long contentColor2;
        int i5;
        Object header2;
        int i8;
        Object obj4;
        int changed3;
        int i6;
        boolean skipping;
        int defaultsInvalid;
        int i12;
        int i10;
        int i2;
        int i7;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i;
        int i4;
        long l;
        final Object obj6 = $changed;
        final int i32 = obj34;
        traceInProgress = 118552648;
        Composer restartGroup = i9.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRail)P(4,0:c#ui.graphics.Color,2:c#ui.graphics.Color,3,5)113@5242L14,114@5284L31,116@5431L12,123@5614L618,119@5501L731:NavigationRail.kt#uh7d8r");
        $dirty2 = obj34;
        modifier2 = obj35 & 1;
        if (modifier2 != 0) {
            $dirty2 |= 6;
            obj3 = modifier;
        } else {
            if (i32 & 6 == 0) {
                i11 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i11;
            } else {
                obj3 = modifier;
            }
        }
        if (i32 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                l2 = containerColor;
            }
            $dirty2 |= changed;
        } else {
            l2 = containerColor;
        }
        if (i32 & 384 == 0) {
            if (obj35 & 4 == 0) {
                i3 = restartGroup.changed(header) ? 256 : 128;
            } else {
                contentColor2 = header;
            }
            $dirty2 |= i3;
        } else {
            contentColor2 = header;
        }
        int i30 = obj35 & 8;
        if (i30 != 0) {
            $dirty2 |= 3072;
            header2 = content;
        } else {
            if (i32 & 3072 == 0) {
                i8 = restartGroup.changedInstance(content) ? 2048 : 1024;
                $dirty2 |= i8;
            } else {
                header2 = content;
            }
        }
        if (i32 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                changed3 = restartGroup.changed($composer) ? 16384 : 8192;
            } else {
                obj4 = $composer;
            }
            $dirty2 |= changed3;
        } else {
            obj4 = $composer;
        }
        int i39 = 196608;
        if (obj35 & 32 != 0) {
            $dirty2 |= i39;
        } else {
            if (i32 & i39 == 0) {
                i6 = restartGroup.changedInstance(obj6) ? 131072 : 65536;
                $dirty2 |= i6;
            }
        }
        if (i37 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i12 = -57345;
                if (i32 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (modifier2 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj3;
                        }
                        int i38 = 6;
                        if (obj35 & 2 != 0) {
                            $dirty2 &= -113;
                            l2 = containerColor2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColor2 = ColorSchemeKt.contentColorFor-ek8zF_U(l2, obj6, restartGroup);
                            $dirty2 &= -897;
                        }
                        if (i30 != 0) {
                            header2 = containerColor3;
                        }
                        if (obj35 & 16 != 0) {
                            windowInsets2 = NavigationRailDefaults.INSTANCE.getWindowInsets(restartGroup, i38);
                            skipping = contentColor2;
                            contentColor2 = modifier3;
                            modifier2 = $dirty4;
                            $dirty = header2;
                            header2 = l2;
                        } else {
                            skipping = contentColor2;
                            windowInsets2 = obj4;
                            contentColor2 = modifier3;
                            modifier2 = $dirty2;
                            $dirty = header2;
                            header2 = l2;
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
                            modifier2 = $dirty5;
                            skipping = contentColor2;
                            $dirty = header2;
                            contentColor2 = obj3;
                            windowInsets2 = obj4;
                            header2 = l2;
                        } else {
                            modifier2 = $dirty2;
                            skipping = contentColor2;
                            $dirty = header2;
                            contentColor2 = obj3;
                            windowInsets2 = obj4;
                            header2 = l2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, modifier2, -1, "androidx.compose.material3.NavigationRail (NavigationRail.kt:118)");
                }
                NavigationRailKt.NavigationRail.1 anon = new NavigationRailKt.NavigationRail.1(windowInsets2, $dirty, obj6);
                SurfaceKt.Surface-T9BRK9s(contentColor2, 0, header2, obj4, skipping, i12, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-2092683357, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = $dirty;
                i5 = modifier2;
                obj = windowInsets2;
                $composer2 = contentColor2;
                $dirty3 = header2;
                windowInsets3 = skipping;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj3;
                obj = obj4;
                i5 = $dirty2;
                $dirty3 = l2;
                windowInsets3 = l;
                obj2 = header2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new NavigationRailKt.NavigationRail.2($composer2, $dirty3, modifier2, windowInsets3, l2, obj2, obj, obj6, i32, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void NavigationRailItem(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, androidx.compose.material3.NavigationRailItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        Object alignment;
        Object obj6;
        boolean traceInProgress2;
        Object colors2;
        Object $i$a$CacheNavigationRailKt$NavigationRailItem$interactionSource$1;
        int $this$NavigationRailItem_u24lambda_u245;
        int defaultsInvalid;
        int i;
        Object rememberedValue;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        Function0 factory$iv$iv$iv;
        Object it$iv;
        Object $i$a$CacheNavigationRailKt$NavigationRailItem$1$2;
        boolean changed;
        int $dirty;
        boolean maybeCachedBoxMeasurePolicy;
        int i19;
        Object value;
        Object empty;
        Composer composer3;
        boolean z2;
        Object obj3;
        boolean traceInProgress;
        int i10;
        Object obj4;
        boolean z;
        Object anon;
        Composer composer;
        Object currentCompositionLocalMap;
        int i30;
        Object obj5;
        int interactionSource3;
        Object modifier2;
        boolean z3;
        int i7;
        int i13;
        androidx.compose.material3.NavigationRailItemColors navigationRailItemColors;
        int str;
        boolean z5;
        int enabled2;
        int i25;
        int i14;
        int i2;
        Object i28;
        Object obj7;
        int i6;
        int i16;
        int i23;
        int i18;
        int i31;
        int changed2;
        int i27;
        int i17;
        androidx.compose.runtime.internal.ComposableLambda companion2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        boolean z4;
        androidx.compose.material3.NavigationRailKt.NavigationRailItem.1.2.1 anon2;
        int companion3;
        Composer composer5;
        Object companion;
        Object obj;
        int i20;
        int i34;
        int i21;
        int i24;
        Modifier modifier4;
        Function0 function0;
        int i33;
        int i26;
        int i3;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier3;
        int i29;
        int i32;
        Object interactionSource2;
        Object obj2;
        int i11;
        int i5;
        Composer composer4;
        int i15;
        int i4;
        int i22;
        BoxScopeInstance boxScopeInstance;
        int i9;
        Composer composer2;
        int i8;
        boolean obj52;
        int obj53;
        MappedInteractionSource obj54;
        int obj55;
        Alignment obj56;
        int obj57;
        int obj58;
        final int i84 = $changed;
        final int i85 = i12;
        final Composer restartGroup = $composer.startRestartGroup(-1533971045);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRailItem)P(8,7,3,6,2,5)179@8055L8,185@8288L633,215@9569L2776:NavigationRail.kt#uh7d8r");
        $dirty = $changed;
        if (i85 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i84 & 6 == 0) {
                i19 = restartGroup.changed(selected) ? 4 : 2;
                $dirty |= i19;
            }
        }
        if (i85 & 2 != 0) {
            $dirty |= 48;
            value = onClick;
        } else {
            if (i84 & 48 == 0) {
                i10 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i10;
            } else {
                value = onClick;
            }
        }
        if (i85 & 4 != 0) {
            $dirty |= 384;
            obj4 = icon;
        } else {
            if (i84 & 384 == 0) {
                i30 = restartGroup.changedInstance(icon) ? 256 : 128;
                $dirty |= i30;
            } else {
                obj4 = icon;
            }
        }
        int i73 = i85 & 8;
        if (i73 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else {
            if (i84 & 3072 == 0) {
                i13 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i13;
            } else {
                modifier2 = modifier;
            }
        }
        str = i85 & 16;
        if (str != null) {
            $dirty |= 24576;
            z5 = enabled;
        } else {
            if (i84 & 24576 == 0) {
                i25 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty |= i25;
            } else {
                z5 = enabled;
            }
        }
        i2 = i85 & 32;
        int i90 = 196608;
        if (i2 != 0) {
            $dirty |= i90;
            obj7 = label;
        } else {
            if (i90 &= i84 == 0) {
                i6 = restartGroup.changedInstance(label) ? 131072 : 65536;
                $dirty |= i6;
            } else {
                obj7 = label;
            }
        }
        i16 = i85 & 64;
        i23 = 1572864;
        if (i16 != 0) {
            $dirty |= i23;
            z2 = alwaysShowLabel;
        } else {
            if (i84 & i23 == 0) {
                i18 = restartGroup.changed(alwaysShowLabel) ? 1048576 : 524288;
                $dirty |= i18;
            } else {
                z2 = alwaysShowLabel;
            }
        }
        if (i84 & i96 == 0) {
            if (i85 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                alignment = colors;
            }
            $dirty |= changed2;
        } else {
            alignment = colors;
        }
        int i37 = i85 & 256;
        int i97 = 100663296;
        if (i37 != 0) {
            $dirty |= i97;
            i27 = i37;
            obj6 = interactionSource;
        } else {
            if (i84 & i97 == 0) {
                i27 = i37;
                i17 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty |= i17;
            } else {
                i27 = i37;
                obj6 = interactionSource;
            }
        }
        if ($dirty & companion2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                obj58 = -29360129;
                rememberedValue = 6;
                if (i84 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i73 != 0) {
                            modifier2 = defaultsInvalid;
                        }
                        if (str != null) {
                            z5 = defaultsInvalid;
                        }
                        if (i2 != 0) {
                            obj7 = defaultsInvalid;
                        }
                        if (i16 != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (i85 & 128 != 0) {
                            colors2 = NavigationRailItemDefaults.INSTANCE.colors(restartGroup, rememberedValue);
                            $dirty &= obj58;
                        } else {
                            colors2 = colors;
                        }
                        z4 = i27 != 0 ? z2 : z2;
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i85 & 128 != 0) {
                            $dirty &= obj58;
                        }
                        colors2 = colors;
                        interactionSource3 = interactionSource;
                        z4 = z2;
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
                if (interactionSource3 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -782587357, str6);
                    str = 0;
                    i2 = restartGroup;
                    i16 = 0;
                    i31 = rememberedValue;
                    rememberedValue = i2.rememberedValue();
                    i27 = 0;
                    obj53 = colors2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i38 = 0;
                        i2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheNavigationRailKt$NavigationRailItem$interactionSource$1 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                } else {
                    obj53 = colors2;
                    i31 = rememberedValue;
                    $i$a$CacheNavigationRailKt$NavigationRailItem$interactionSource$1 = interactionSource3;
                }
                restartGroup.endReplaceGroup();
                obj54 = selected;
                obj52 = anon3;
                super(obj53, obj54, z5, obj7, z4, obj4);
                navigationRailItemColors = obj53;
                int i92 = 1;
                obj54 = $i$a$CacheNavigationRailKt$NavigationRailItem$interactionSource$1;
                int interactionSource4 = 54;
                restartGroup.startReplaceGroup(-782561860);
                ComposerKt.sourceInformation(restartGroup, "*200@9017L536");
                if (obj7 == null) {
                    composableLambda = 0;
                } else {
                    i28 = obj7;
                    i27 = 0;
                    anon = new NavigationRailKt.NavigationRailItem.styledLabel.1.1(navigationRailItemColors, obj54, z5, obj7);
                    composableLambda = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                empty = obj54;
                int i86 = 0;
                int i39 = 0;
                obj53 = i92;
                Modifier widthIn-VpY3zN4$default = SizeKt.widthIn-VpY3zN4$default(SizeKt.defaultMinSize-VpY3zN4$default(SelectableKt.selectable-O2vRcR0(modifier2, selected, obj54, 0, z5, Role.box-impl(Role.Companion.getTab-o7Vup1c()), value), i86, NavigationRailKt.NavigationRailItemHeight, i92, i39), NavigationRailKt.NavigationRailItemWidth, i86, 2, i39);
                Alignment center = Alignment.Companion.getCenter();
                int i67 = 432;
                i21 = 0;
                obj55 = $dirty;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, obj53);
                i24 = 0;
                obj56 = center;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                obj58 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, widthIn-VpY3zN4$default);
                modifier4 = widthIn-VpY3zN4$default;
                Function0 function02 = constructor;
                i33 = 0;
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
                int i98 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i102 = 0;
                companion = constructor-impl;
                int i104 = 0;
                if (!companion.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(companion.rememberedValue(), Integer.valueOf(obj58))) {
                        companion.updateRememberedValue(Integer.valueOf(obj58));
                        constructor-impl.apply(Integer.valueOf(obj58), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = companion;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = restartGroup;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer8 = composer6;
                i22 = 0;
                boxScopeInstance = iNSTANCE;
                i9 = i47;
                ComposerKt.sourceInformationMarkerStart(composer6, 584386773, "C231@10130L157,*240@10571L7,246@10874L128,260@11450L261,268@11760L280,282@12301L27,276@12050L289:NavigationRail.kt#uh7d8r");
                i32 = selected ? $this$NavigationRailItem_u24lambda_u245 : 0;
                Composer composer9 = composer6;
                i8 = i68;
                int $composer2 = 0;
                androidx.compose.runtime.State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i32, (AnimationSpec)AnimationSpecKt.tween$default(150, 0, $composer2, i31, $composer2), 0, 0, 0, composer9, 48, 28);
                $dirty = composer9;
                int i103 = 0;
                int i99 = 0;
                int i105 = i69;
                i29 = i77;
                ComposerKt.sourceInformationMarkerStart($dirty, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd($dirty);
                Object this_$iv = consume;
                int roundToPx-0680j_42 = (Density)this_$iv.roundToPx-0680j_4(NavigationRailKt.NavigationRailItemWidth);
                i34 = i70;
                int roundToPx-0680j_4 = this_$iv.roundToPx-0680j_4(NavigationRailTokens.INSTANCE.getActiveIndicatorWidth-D9Ej5fM());
                Object obj9 = this_$iv;
                int i94 = roundToPx-0680j_4;
                obj54 = roundToPx-0680j_42;
                long l = OffsetKt.Offset(f3 / f2, 0);
                Unit iNSTANCE3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($dirty, -119672869, str6);
                obj54 = $dirty;
                int i95 = 0;
                it$iv = obj54.rememberedValue();
                companion3 = 0;
                if (changed3 |= changed7 == 0) {
                    interactionSource2 = empty;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj = it$iv;
                        i34 = interactionSource5;
                        obj2 = modifier2;
                        it$iv = new MappedInteractionSource((InteractionSource)interactionSource2, l, roundToPx-0680j_42, 0);
                        obj54.updateRememberedValue(it$iv);
                    } else {
                        composer3 = obj54;
                        obj = it$iv;
                        obj2 = modifier2;
                    }
                } else {
                    interactionSource2 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd($dirty);
                if (obj7 != null) {
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
                NavigationRailKt.NavigationRailItem.1.indicatorRipple.1 anon6 = new NavigationRailKt.NavigationRailItem.1.indicatorRipple.1(value, (MappedInteractionSource)it$iv);
                obj54 = it$iv;
                i23 = l;
                int deltaOffset = 54;
                int i78 = obj53;
                NavigationRailKt.NavigationRailItem.1.indicator.1 anon4 = new NavigationRailKt.NavigationRailItem.1.indicator.1(animateFloatAsState, navigationRailItemColors, value);
                ComposerKt.sourceInformationMarkerStart($dirty, -119627306, str6);
                changed = $dirty.changed(animateFloatAsState);
                Composer composer7 = $dirty;
                int i71 = 0;
                Object rememberedValue3 = composer7.rememberedValue();
                int i81 = 0;
                if (!changed) {
                    obj52 = changed;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        obj53 = invalid$iv;
                        $i$a$CacheNavigationRailKt$NavigationRailItem$1$2 = new NavigationRailKt.NavigationRailItem.1.2.1(animateFloatAsState);
                        composer7.updateRememberedValue((Function0)$i$a$CacheNavigationRailKt$NavigationRailItem$1$2);
                    } else {
                        $i$a$CacheNavigationRailKt$NavigationRailItem$1$2 = rememberedValue3;
                    }
                } else {
                    obj52 = changed;
                }
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer5 = $dirty;
                NavigationRailKt.NavigationRailItemLayout((Function2)ComposableLambdaKt.rememberComposableLambda(211026382, i78, anon6, $dirty, deltaOffset), (Function2)ComposableLambdaKt.rememberComposableLambda(-1862011490, i78, anon4, $dirty, deltaOffset), (Function2)ComposableLambdaKt.rememberComposableLambda(-1023357515, i92, obj52, restartGroup, interactionSource4), composableLambda, z4, (Function0)$i$a$CacheNavigationRailKt$NavigationRailItem$1$2, composer5, i55 |= 438);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i14 = obj55;
                z = z5;
                z3 = z4;
                enabled2 = i3;
                obj3 = obj2;
                obj5 = obj7;
            } else {
                restartGroup.skipToGroupEnd();
                z3 = z2;
                obj3 = obj8;
                navigationRailItemColors = colors;
                i14 = $dirty;
                z = z5;
                enabled2 = interactionSource;
                obj5 = obj7;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationRailKt.NavigationRailItem.2(selected, onClick, icon, obj3, z, obj5, z3, navigationRailItemColors, enabled2, i84, i85);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void NavigationRailItemLayout(Function2<? super Composer, ? super Integer, Unit> indicatorRipple, Function2<? super Composer, ? super Integer, Unit> indicator, Function2<? super Composer, ? super Integer, Unit> icon, Function2<? super Composer, ? super Integer, Unit> label, boolean alwaysShowLabel, Function0<Float> animationProgress, Composer $composer, int $changed) {
        int traceInProgress2;
        boolean currentCompositionLocalMap2;
        Function0 factory$iv$iv$iv2;
        Object $changed$iv2;
        Object $changed$iv3;
        boolean currentCompositionLocalMap;
        Function0 factory$iv$iv$iv;
        Object materialized$iv$iv;
        Object empty;
        Object $i$a$CacheNavigationRailKt$NavigationRailItemLayout$1$2;
        int valueOf;
        boolean valueOf3;
        Composer composer6;
        int materialized$iv$iv2;
        int i17;
        Composer restartGroup;
        int $dirty;
        Function0 factory$iv$iv;
        Composer composer5;
        Object maybeCachedBoxMeasurePolicy;
        int i18;
        int i11;
        int i25;
        int i20;
        int i15;
        int i30;
        boolean maybeCachedBoxMeasurePolicy2;
        boolean traceInProgress;
        int $changed$iv;
        int i27;
        int i2;
        Object valueOf2;
        Composer composer4;
        int empty2;
        int str;
        int i10;
        Object currentCompositionLocalMap3;
        int i22;
        int i3;
        int i21;
        int currentCompositeKeyHash;
        int companion;
        int i23;
        Object companion2;
        Composer composer;
        int i7;
        int i;
        int i16;
        Composer composer7;
        int i13;
        int i8;
        int i24;
        int i4;
        int i29;
        Function0 function02;
        Modifier modifier;
        int i32;
        androidx.compose.runtime.CompositionLocalMap localMap$iv;
        androidx.compose.material3.NavigationRailKt.NavigationRailItemLayout.2.1 anon;
        int i9;
        int i28;
        int $changed$iv4;
        Object obj;
        int currentCompositeKeyHash2;
        int i12;
        int i5;
        Modifier modifier2;
        Function0 function0;
        int i26;
        int i6;
        BoxScopeInstance iNSTANCE;
        int i14;
        int i19;
        Composer composer3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i31;
        Composer composer2;
        Modifier modifier3;
        int obj62;
        $changed$iv3 = indicatorRipple;
        materialized$iv$iv = indicator;
        empty = icon;
        final Object obj2 = label;
        valueOf3 = alwaysShowLabel;
        final Object obj3 = animationProgress;
        materialized$iv$iv2 = $changed;
        traceInProgress2 = 1498399348;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationRailItemLayout)P(4,3,2,5)530@23300L1924,515@22904L2320:NavigationRail.kt#uh7d8r");
        if (materialized$iv$iv2 & 6 == 0) {
            i18 = restartGroup.changedInstance($changed$iv3) ? 4 : 2;
            $dirty |= i18;
        }
        if (materialized$iv$iv2 & 48 == 0) {
            i11 = restartGroup.changedInstance(materialized$iv$iv) ? 32 : 16;
            $dirty |= i11;
        }
        if (materialized$iv$iv2 & 384 == 0) {
            i25 = restartGroup.changedInstance(empty) ? 256 : 128;
            $dirty |= i25;
        }
        $changed$iv = 2048;
        if (materialized$iv$iv2 & 3072 == 0) {
            i20 = restartGroup.changedInstance(obj2) ? $changed$iv : 1024;
            $dirty |= i20;
        }
        i2 = 16384;
        if (materialized$iv$iv2 & 24576 == 0) {
            i15 = restartGroup.changed(valueOf3) ? i2 : 8192;
            $dirty |= i15;
        }
        empty2 = 131072;
        if (i68 &= materialized$iv$iv2 == 0) {
            i30 = restartGroup.changedInstance(obj3) ? empty2 : 65536;
            $dirty |= i30;
        }
        if (i69 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.NavigationRailItemLayout (NavigationRail.kt:514)");
                }
                maybeCachedBoxMeasurePolicy2 = "CC(remember):NavigationRail.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1881815062, maybeCachedBoxMeasurePolicy2);
                int i34 = 458752;
                int i35 = 0;
                i10 = $dirty & i34 == empty2 ? 1 : i35;
                i27 = $dirty & 7168 == $changed$iv ? 1 : i35;
                int i83 = 57344;
                i22 = $dirty & i83 == i2 ? 1 : i35;
                Composer composer10 = restartGroup;
                int i88 = 0;
                Object rememberedValue5 = composer10.rememberedValue();
                i23 = 0;
                if (i72 |= i22 == 0) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        valueOf2 = new NavigationRailKt.NavigationRailItemLayout.2.1(obj3, obj2, valueOf3);
                        composer10.updateRememberedValue((MeasurePolicy)valueOf2);
                    } else {
                        valueOf2 = rememberedValue5;
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
                i16 = $dirty;
                Function0 function04 = constructor2;
                i = 0;
                i8 = i74;
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
                composer7 = restartGroup;
                Composer constructor-impl2 = Updater.constructor-impl(composer7);
                int i92 = 0;
                function02 = factory$iv$iv;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)valueOf2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i93 = 0;
                Composer composer11 = constructor-impl2;
                i32 = 0;
                if (!composer11.getInserting()) {
                    localMap$iv = currentCompositionLocalMap2;
                    anon = valueOf2;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer11.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer11;
                    }
                } else {
                    localMap$iv = currentCompositionLocalMap2;
                    anon = valueOf2;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer7;
                i4 = i37;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2082816907, "C516@22921L17,517@22947L11,519@22968L50:NavigationRail.kt#uh7d8r");
                $changed$iv3.invoke(restartGroup, Integer.valueOf(i16 & 14));
                materialized$iv$iv.invoke(restartGroup, Integer.valueOf(i39 &= 14));
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                int i79 = 6;
                i29 = 0;
                materialized$iv$iv = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                Alignment topStart = Alignment.Companion.getTopStart();
                modifier = materializeModifier2;
                int materialized$iv = 0;
                i9 = i64;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, materialized$iv);
                $changed$iv4 = 0;
                obj = topStart;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap3);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                i12 = materialized$iv;
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, layoutId);
                modifier2 = layoutId;
                Function0 function05 = constructor3;
                i5 = 0;
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
                function0 = factory$iv$iv$iv2;
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
                        composer5 = composer13;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = restartGroup;
                $dirty = 0;
                i6 = i44;
                $changed$iv2 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer8, -2146769399, $changed$iv2);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i99 |= 6;
                i31 = 0;
                modifier3 = materializeModifier3;
                materialized$iv$iv2 = composer3;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 402566553, "C519@23010L6:NavigationRail.kt#uh7d8r");
                empty.invoke(materialized$iv$iv2, Integer.valueOf(i49 &= 14));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer8);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(2145400941);
                ComposerKt.sourceInformation(restartGroup, "523@23132L96,522@23061L221");
                if (obj2 != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 2145404101, maybeCachedBoxMeasurePolicy2);
                    i17 = i16 & companion == 16384 ? 1 : 0;
                    i21 = i16 & obj62 == 131072 ? 1 : 0;
                    Composer composer9 = restartGroup;
                    int i71 = 0;
                    Object rememberedValue4 = composer9.rememberedValue();
                    int i87 = 0;
                    if (i17 |= i21 == 0) {
                        if (rememberedValue4 == Composer.Companion.getEmpty()) {
                            obj62 = i57;
                            $i$a$CacheNavigationRailKt$NavigationRailItemLayout$1$2 = new NavigationRailKt.NavigationRailItemLayout.1.2.1(valueOf3, obj3);
                            composer9.updateRememberedValue((Function1)$i$a$CacheNavigationRailKt$NavigationRailItemLayout$1$2);
                        } else {
                            $i$a$CacheNavigationRailKt$NavigationRailItemLayout$1$2 = rememberedValue4;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label"), (Function1)$i$a$CacheNavigationRailKt$NavigationRailItemLayout$1$2);
                    valueOf = i90;
                    materialized$iv$iv2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    i3 = 0;
                    obj62 = topStart2;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap3);
                    companion = currentCompositeKeyHash3;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, graphicsLayer);
                    companion2 = graphicsLayer;
                    Function0 function03 = constructor;
                    i23 = 0;
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
                    i29 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart2, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i91 = 0;
                    Composer composer12 = constructor-impl3;
                    int i95 = 0;
                    if (!composer12.getInserting()) {
                        $changed$iv4 = valueOf;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(companion))) {
                            composer12.updateRememberedValue(Integer.valueOf(companion));
                            constructor-impl3.apply(Integer.valueOf(companion), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer12;
                        }
                    } else {
                        $changed$iv4 = valueOf;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    empty = restartGroup;
                    valueOf3 = 0;
                    ComposerKt.sourceInformationMarkerStart(empty, -2146769399, $changed$iv2);
                    i77 |= 6;
                    i24 = 0;
                    i32 = iNSTANCE2;
                    i28 = i55;
                    obj = materializeModifier;
                    materialized$iv$iv = composer;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 402815576, "C527@23261L7:NavigationRail.kt#uh7d8r");
                    obj2.invoke(materialized$iv$iv, Integer.valueOf(i45 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(empty);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                }
                restartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                composer7.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer7);
                ComposerKt.sourceInformationMarkerEnd(composer7);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer7 = restartGroup;
                i16 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer7.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new NavigationRailKt.NavigationRailItemLayout.3(indicatorRipple, indicator, icon, obj2, alwaysShowLabel, obj3, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
