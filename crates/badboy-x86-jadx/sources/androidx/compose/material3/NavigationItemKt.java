package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.internal.MappedInteractionSource;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008a\u0001\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u001aÍ\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\u0008\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00122\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u00162\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u00162\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\u001a\u0090\u0001\u0010.\u001a\u00020\u00102\u0006\u0010*\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0019\u001a\u00020\u001a2\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\u0008\u00162\u0006\u0010(\u001a\u00020)2\u0013\u0010&\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u00162\u000c\u00102\u001a\u0008\u0012\u0004\u0012\u0002030\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0003ø\u0001\u0000¢\u0006\u0004\u00084\u00105\u001a6\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@\u001aF\u0010A\u001a\u000207*\u0002082\u0006\u0010B\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\u0008C\u0010D\u001aV\u0010E\u001a\u000207*\u0002082\u0006\u0010B\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002ø\u0001\u0000¢\u0006\u0004\u0008F\u0010G\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\n\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u000b\u0010\u000c\"\u0016\u0010\r\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\u0008\u000e\u0010\u000c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006H²\u0006\n\u0010I\u001a\u00020\u0008X\u008a\u008e\u0002", d2 = {"IconLayoutIdTag", "", "IndicatorLayoutIdTag", "IndicatorRippleLayoutIdTag", "IndicatorVerticalOffset", "Landroidx/compose/ui/unit/Dp;", "F", "ItemAnimationDurationMillis", "", "LabelLayoutIdTag", "NavigationItemMinHeight", "getNavigationItemMinHeight", "()F", "NavigationItemMinWidth", "getNavigationItemMinWidth", "NavigationItem", "", "selected", "", "onClick", "Lkotlin/Function0;", "icon", "Landroidx/compose/runtime/Composable;", "labelTextStyle", "Landroidx/compose/ui/text/TextStyle;", "indicatorShape", "Landroidx/compose/ui/graphics/Shape;", "indicatorWidth", "indicatorHorizontalPadding", "indicatorVerticalPadding", "indicatorToLabelVerticalPadding", "startIconToLabelHorizontalPadding", "topIconItemVerticalPadding", "colors", "Landroidx/compose/material3/NavigationItemColors;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "label", "badge", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "NavigationItem-SHbi2eg", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;FFFFFFLandroidx/compose/material3/NavigationItemColors;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "NavigationItemLayout", "Landroidx/compose/foundation/interaction/InteractionSource;", "indicatorColor", "Landroidx/compose/ui/graphics/Color;", "animationProgress", "", "NavigationItemLayout-KmRX-Dg", "(Landroidx/compose/foundation/interaction/InteractionSource;JLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function2;ILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;FFFFFLandroidx/compose/runtime/Composer;II)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "indicatorRipplePlaceable", "indicatorPlaceable", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-X9ElhV4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndStartIcon", "labelPlaceable", "placeLabelAndStartIcon-nru01g4", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndTopIcon", "placeLabelAndTopIcon-qoqLrGI", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JFFF)Landroidx/compose/ui/layout/MeasureResult;", "material3_release", "itemWidth"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavigationItemKt {

    private static final String IconLayoutIdTag = "icon";
    private static final String IndicatorLayoutIdTag = "indicator";
    private static final String IndicatorRippleLayoutIdTag = "indicatorRipple";
    private static final float IndicatorVerticalOffset = 0f;
    private static final int ItemAnimationDurationMillis = 100;
    private static final String LabelLayoutIdTag = "label";
    private static final float NavigationItemMinHeight;
    private static final float NavigationItemMinWidth;
    static {
        NavigationItemKt.NavigationItemMinWidth = NavigationRailKt.getNavigationRailItemWidth();
        NavigationItemKt.NavigationItemMinHeight = NavigationRailKt.getNavigationRailItemHeight();
        final int i2 = 0;
        NavigationItemKt.IndicatorVerticalOffset = Dp.constructor-impl((float)i);
    }

    public static final void NavigationItem-SHbi2eg(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, TextStyle labelTextStyle, Shape indicatorShape, float indicatorWidth, float indicatorHorizontalPadding, float indicatorVerticalPadding, float indicatorToLabelVerticalPadding, float startIconToLabelHorizontalPadding, float topIconItemVerticalPadding, androidx.compose.material3.NavigationItemColors colors, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> badge, int iconPosition, MutableInteractionSource interactionSource, Composer $composer, int $changed, int $changed1) {
        float f6;
        Object obj8;
        Object obj5;
        boolean z;
        int i10;
        int i37;
        int i11;
        int i14;
        boolean traceInProgress;
        Object endRestartGroup;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        Function0 factory$iv$iv$iv;
        int i44;
        Object skipping;
        boolean traceInProgress2;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda2;
        androidx.compose.runtime.internal.ComposableLambda i5;
        Object invalid$iv;
        boolean currentCompositionLocalMap;
        Object deltaOffset;
        Object it$iv2;
        int $dirty;
        boolean i12;
        int $composer2;
        Object empty2;
        int $dirty1;
        Composer i19;
        boolean $dirty12;
        int i7;
        Object obj9;
        Object obj;
        Composer composer4;
        Object it$iv;
        Integer valueOf;
        Object obj2;
        Composer maybeCachedBoxMeasurePolicy;
        int obj10;
        Object empty;
        int $changed$iv$iv;
        float f4;
        int obj6;
        float f;
        float f2;
        float f5;
        float f3;
        long selectedIndicatorColor-0d7_KjU;
        Composer restartGroup;
        Object obj7;
        Object styledLabel;
        int i33;
        Object itemWidth$delegate;
        Object $i$a$CacheNavigationItemKt$NavigationItem$itemWidth$2;
        int iconWithBadge;
        int i41;
        int i40;
        Object offsetInteractionSource;
        float i34;
        int invalid$iv2;
        int i27;
        int companion;
        Object obj4;
        int i20;
        int i9;
        Object obj3;
        int i21;
        int i22;
        int companion2;
        int i32;
        Composer i8;
        int composer2;
        int i38;
        int i3;
        int i23;
        int i42;
        int i13;
        int i31;
        int i43;
        int i2;
        int i35;
        int changed;
        int i15;
        int i24;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i16;
        int i25;
        Alignment alignment;
        int i26;
        int i39;
        Modifier modifier2;
        int i;
        Function0 function0;
        int i36;
        int i28;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        int i6;
        int i29;
        Composer composer3;
        int $changed2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        int i4;
        long l;
        Composer composer;
        int i17;
        int i30;
        int i18;
        BoxScopeInstance boxScopeInstance;
        Composer composer5;
        Modifier modifier3;
        ScopeUpdateScope scopeUpdateScope;
        Object obj72;
        f4 = indicatorWidth;
        itemWidth$delegate = label;
        obj6 = badge;
        i33 = iconPosition;
        obj10 = interactionSource;
        int i113 = $changed;
        selectedIndicatorColor-0d7_KjU = $changed1;
        restartGroup = $composer.startRestartGroup(547979956);
        ComposerKt.sourceInformation(restartGroup, "C(NavigationItem)P(15,14,3,12,6,9:c#ui.unit.Dp,5:c#ui.unit.Dp,8:c#ui.unit.Dp,7:c#ui.unit.Dp,16:c#ui.unit.Dp,17:c#ui.unit.Dp,1,13,2,11!1,4:c#material3.NavigationItemIconPosition)254@10949L438,281@11981L33,294@12438L24,283@12020L2390:NavigationItem.kt#uh7d8r");
        if (i113 & 6 == 0) {
            i7 = restartGroup.changed(selected) ? 4 : 2;
            $dirty |= i7;
        }
        if (i113 & 48 == 0) {
            i41 = restartGroup.changedInstance(onClick) ? 32 : iconWithBadge;
            $dirty |= i41;
        } else {
            obj9 = onClick;
        }
        i34 = 128;
        if (i113 & 384 == 0) {
            i20 = restartGroup.changedInstance(icon) ? i40 : i34;
            $dirty |= i20;
        } else {
            obj2 = icon;
        }
        if (i113 & 3072 == 0) {
            companion2 = restartGroup.changed(labelTextStyle) ? 2048 : i21;
            $dirty |= companion2;
        } else {
            styledLabel = labelTextStyle;
        }
        if (i113 & 24576 == 0) {
            i32 = restartGroup.changed(indicatorShape) ? 16384 : 8192;
            $dirty |= i32;
        } else {
            obj7 = indicatorShape;
        }
        i8 = 196608;
        if (i113 & i8 == 0) {
            i38 = restartGroup.changed(f4) ? 131072 : 65536;
            $dirty |= i38;
        }
        if (i113 & i124 == 0) {
            i42 = restartGroup.changed(indicatorHorizontalPadding) ? 1048576 : 524288;
            $dirty |= i42;
        } else {
            f6 = indicatorHorizontalPadding;
        }
        if (i113 & i125 == 0) {
            i31 = restartGroup.changed(indicatorVerticalPadding) ? 8388608 : 4194304;
            $dirty |= i31;
        } else {
            f = indicatorVerticalPadding;
        }
        if ($changed & i126 == 0) {
            i43 = restartGroup.changed(indicatorToLabelVerticalPadding) ? 67108864 : 33554432;
            $dirty |= i43;
        } else {
            f2 = indicatorToLabelVerticalPadding;
        }
        if ($changed & i127 == 0) {
            i2 = restartGroup.changed(startIconToLabelHorizontalPadding) ? 536870912 : 268435456;
            $dirty |= i2;
        } else {
            f5 = startIconToLabelHorizontalPadding;
        }
        if (selectedIndicatorColor-0d7_KjU & 6 == 0) {
            i35 = restartGroup.changed(topIconItemVerticalPadding) ? 4 : 2;
            $dirty1 |= i35;
        } else {
            f3 = topIconItemVerticalPadding;
        }
        if (selectedIndicatorColor-0d7_KjU & 48 == 0) {
            if (restartGroup.changed(colors)) {
                iconWithBadge = 32;
            }
            $dirty1 |= iconWithBadge;
        } else {
            obj8 = colors;
        }
        if (selectedIndicatorColor-0d7_KjU & 384 == 0) {
            if (restartGroup.changed(modifier)) {
            } else {
                i40 = i34;
            }
            $dirty1 |= i40;
        } else {
            obj5 = modifier;
        }
        if (selectedIndicatorColor-0d7_KjU & 3072 == 0) {
            if (restartGroup.changed(enabled)) {
                i21 = 2048;
            }
            $dirty1 |= i21;
        } else {
            z = enabled;
        }
        if (selectedIndicatorColor-0d7_KjU & 24576 == 0) {
            i10 = restartGroup.changedInstance(itemWidth$delegate) ? 16384 : 8192;
            $dirty1 |= i10;
        }
        if (selectedIndicatorColor-0d7_KjU & i8 == 0) {
            i37 = restartGroup.changedInstance(obj6) ? 131072 : 65536;
            $dirty1 |= i37;
        }
        if (i48 &= selectedIndicatorColor-0d7_KjU == 0) {
            i11 = restartGroup.changed(i33) ? 1048576 : 524288;
            $dirty1 |= i11;
        }
        if (i49 &= selectedIndicatorColor-0d7_KjU == 0) {
            i14 = restartGroup.changed(obj10) ? 8388608 : 4194304;
            $dirty1 |= i14;
        }
        traceInProgress = $dirty1;
        if ($dirty14 &= $dirty == 306783378 && i71 &= traceInProgress == 4793490) {
            if (i71 &= traceInProgress == 4793490) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(547979956, $dirty, traceInProgress, "androidx.compose.material3.NavigationItem (NavigationItem.kt:252)");
                    }
                    i24 = $dirty;
                    i15 = i81;
                    NavigationItemKt.NavigationItem.styledIcon.1 $dirty13 = new NavigationItemKt.NavigationItem.styledIcon.1(colors, selected, enabled, itemWidth$delegate, obj2);
                    int i116 = 1;
                    i12 = 54;
                    rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-44329638, i116, $dirty13, restartGroup, i12);
                    restartGroup.startReplaceGroup(-1735402128);
                    ComposerKt.sourceInformation(restartGroup, "264@11453L51");
                    if (obj6 != null) {
                        NavigationItemKt.NavigationItem.iconWithBadge.1 anon = new NavigationItemKt.NavigationItem.iconWithBadge.1(obj6, (Function2)rememberComposableLambda);
                        rememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(1836184859, i116, anon, restartGroup, i12);
                    } else {
                        rememberComposableLambda2 = rememberComposableLambda;
                    }
                    restartGroup.endReplaceGroup();
                    restartGroup.startReplaceGroup(-1735395524);
                    ComposerKt.sourceInformation(restartGroup, "*271@11650L298");
                    i5 = 0;
                    if (label == null) {
                        composableLambda = rememberComposableLambda;
                    } else {
                        i40 = label;
                        i34 = 0;
                        composableLambda = composableLambda2;
                        NavigationItemKt.NavigationItem.styledLabel.1.1 styledIcon = new NavigationItemKt.NavigationItem.styledLabel.1.1(colors, selected, enabled, styledLabel, label);
                        i5 = rememberComposableLambda;
                    }
                    restartGroup.endReplaceGroup();
                    String str3 = "CC(remember):NavigationItem.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1735384277, str3);
                    int i51 = 0;
                    Composer composer7 = restartGroup;
                    Object rememberedValue2 = composer7.rememberedValue();
                    int i96 = 0;
                    obj72 = i116;
                    int i118 = i82;
                    int $i$f$cache = 0;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int i117 = 0;
                        composer7.updateRememberedValue(SnapshotIntStateKt.mutableIntStateOf($i$f$cache));
                    } else {
                        $i$a$CacheNavigationItemKt$NavigationItem$itemWidth$2 = rememberedValue2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i52 = $i$f$cache;
                    String str7 = str3;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1735369662, str7);
                    int i63 = 0;
                    Composer composer8 = restartGroup;
                    int i84 = 0;
                    Object rememberedValue3 = composer8.rememberedValue();
                    int i97 = 0;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        invalid$iv2 = i63;
                        invalid$iv = new NavigationItemKt.NavigationItem.1.1((MutableIntState)$i$a$CacheNavigationItemKt$NavigationItem$itemWidth$2);
                        composer8.updateRememberedValue((Function1)invalid$iv);
                    } else {
                        invalid$iv2 = i63;
                        invalid$iv = rememberedValue3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(SizeKt.defaultMinSize-VpY3zN4(SelectableKt.selectable-O2vRcR0(modifier, selected, obj10, 0, enabled, Role.box-impl(Role.Companion.getTab-o7Vup1c()), onClick), NavigationItemKt.NavigationItemMinWidth, NavigationItemKt.NavigationItemMinHeight), (Function1)invalid$iv);
                    Alignment center = Alignment.Companion.getCenter();
                    int i72 = obj72;
                    int i85 = 432;
                    valueOf = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, i72);
                    i109 &= 112;
                    i25 = 0;
                    alignment = center;
                    i26 = i72;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    i39 = currentCompositeKeyHash;
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, onSizeChanged);
                    modifier2 = onSizeChanged;
                    Function0 function03 = constructor;
                    i36 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function03);
                    } else {
                        factory$iv$iv$iv = function03;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl = Updater.constructor-impl(restartGroup);
                    i9 = 0;
                    function0 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    i22 = 0;
                    composer2 = constructor-impl;
                    i23 = 0;
                    if (!composer2.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        i6 = valueOf;
                        if (!Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(i39))) {
                            composer2.updateRememberedValue(Integer.valueOf(i39));
                            constructor-impl.apply(Integer.valueOf(i39), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer4 = composer2;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        i6 = valueOf;
                    }
                    Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    Composer composer6 = restartGroup;
                    i29 = i57;
                    ComposerKt.sourceInformationMarkerStart(composer6, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i90 |= 6;
                    i18 = 0;
                    boxScopeInstance = iNSTANCE;
                    modifier3 = materializeModifier;
                    Composer materialized$iv$iv = composer10;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 872931531, "C299@12615L157,330@14002L27,323@13657L747:NavigationItem.kt#uh7d8r");
                    i44 = selected ? 1065353216 : 0;
                    Composer composer11 = materialized$iv$iv;
                    i16 = i86;
                    $composer2 = 0;
                    androidx.compose.runtime.State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(i44, (AnimationSpec)AnimationSpecKt.tween$default(100, 0, $composer2, 6, $composer2), 0, 0, 0, composer11, 48, 28);
                    i19 = composer11;
                    i19.startReplaceGroup(-1634400795);
                    ComposerKt.sourceInformation(i19, "*310@13207L7,318@13501L136");
                    if (NavigationItemIconPosition.equals-impl0(i33, NavigationItemIconPosition.Companion.getTop--xw1Ddg())) {
                        int i122 = 0;
                        int i123 = 0;
                        i23 = 0;
                        $changed2 = it$iv;
                        ComposerKt.sourceInformationMarkerStart(i19, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                        ComposerKt.sourceInformationMarkerEnd(i19);
                        Object this_$iv = consume;
                        composer2 = i74;
                        Unit $this$NavigationItem_SHbi2eg_u24lambda_u248_u24lambda_u245 = Unit.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(i19, -1634380655, str7);
                        $composer2 = 8388608;
                        i27 = i15 & i68 == $composer2 ? obj72 : 0;
                        long l2 = l;
                        obj72 = i19;
                        companion = 0;
                        it$iv = obj72.rememberedValue();
                        i22 = 0;
                        if (i27 | changed4 == 0) {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                            if (it$iv == Composer.Companion.getEmpty()) {
                                companion2 = it$iv;
                                composer2 = measurePolicy$iv2;
                                i4 = $changed$iv$iv;
                                it$iv = new MappedInteractionSource((InteractionSource)interactionSource, l2, $composer2, 0);
                                obj72.updateRememberedValue(it$iv);
                            } else {
                                maybeCachedBoxMeasurePolicy = obj72;
                                companion2 = it$iv;
                                i4 = $changed$iv$iv;
                            }
                        } else {
                            measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        }
                        ComposerKt.sourceInformationMarkerEnd(i19);
                        deltaOffset = offsetInteractionSource;
                    } else {
                        $changed2 = it$iv;
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        i4 = $changed$iv$iv;
                        deltaOffset = offsetInteractionSource;
                    }
                    i19.endReplaceGroup();
                    if (deltaOffset != null) {
                        empty2 = deltaOffset;
                    } else {
                        empty2 = interactionSource;
                    }
                    ComposerKt.sourceInformationMarkerStart(i19, -1634364732, str7);
                    Composer composer9 = i19;
                    obj6 = 0;
                    obj72 = deltaOffset;
                    it$iv2 = composer9.rememberedValue();
                    int i119 = 0;
                    if (!i19.changed(animateFloatAsState)) {
                        obj3 = empty2;
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            obj4 = it$iv2;
                            it$iv2 = new NavigationItemKt.NavigationItem.2.3.1(animateFloatAsState);
                            composer9.updateRememberedValue((Function0)it$iv2);
                        } else {
                            obj4 = it$iv2;
                        }
                    } else {
                        obj3 = empty2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(i19);
                    skipping = $i$a$CacheNavigationItemKt$NavigationItem$itemWidth$2;
                    i8 = i19;
                    composer3 = obj9;
                    NavigationItemKt.NavigationItemLayout-KmRX-Dg(obj3, colors.getSelectedIndicatorColor-0d7_KjU(), restartGroup, obj7, rememberComposableLambda2, i33, i5, (Function0)it$iv2, indicatorHorizontalPadding, indicatorVerticalPadding, indicatorToLabelVerticalPadding, startIconToLabelHorizontalPadding, f3, i8, i79 | i107);
                    ComposerKt.sourceInformationMarkerEnd(i8);
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    composer3.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    i15 = traceInProgress;
                    i24 = $dirty;
                    composer3 = restartGroup;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new NavigationItemKt.NavigationItem.3(selected, onClick, icon, labelTextStyle, indicatorShape, f4, indicatorHorizontalPadding, indicatorVerticalPadding, indicatorToLabelVerticalPadding, startIconToLabelHorizontalPadding, topIconItemVerticalPadding, colors, modifier, enabled, label, badge, iconPosition, interactionSource, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    private static final void NavigationItemLayout-KmRX-Dg(InteractionSource interactionSource, long indicatorColor, Shape indicatorShape, Function2<? super Composer, ? super Integer, Unit> icon, int iconPosition, Function2<? super Composer, ? super Integer, Unit> label, Function0<Float> animationProgress, float indicatorHorizontalPadding, float indicatorVerticalPadding, float indicatorToLabelVerticalPadding, float startIconToLabelHorizontalPadding, float topIconItemVerticalPadding, Composer $composer, int $changed, int $changed1) {
        int traceInProgress2;
        boolean traceInProgress;
        Composer composer3;
        Function0 factory$iv$iv$iv2;
        Object $changed$iv3;
        int i33;
        Object endRestartGroup;
        int i20;
        Object it$iv;
        String $changed$iv4;
        Integer currentCompositionLocalMap;
        Function0 factory$iv$iv$iv;
        Object $changed$iv2;
        Composer composer;
        Integer valueOf2;
        Composer $i$a$LayoutBoxKt$Box$1$iv;
        Object maybeCachedBoxMeasurePolicy2;
        Composer composer7;
        int valueOf3;
        Modifier materializeModifier2;
        int i17;
        Function0 factory$iv$iv;
        int i35;
        int i3;
        Object obj2;
        float maybeCachedBoxMeasurePolicy;
        Object valueOf4;
        int $i$a$LayoutNavigationItemKt$NavigationItemLayout$12;
        int i5;
        int $dirty;
        float $dirty2;
        int $dirty12;
        float $dirty1;
        Composer composer2;
        Integer valueOf;
        int i;
        int i21;
        int i15;
        int i13;
        int i31;
        int i18;
        int i34;
        float materializeModifier;
        float f2;
        float f;
        float currentCompositionLocalMap3;
        int i32;
        Composer $composer3;
        float currentCompositionLocalMap2;
        int i12;
        int i7;
        int i23;
        int i27;
        int i14;
        boolean changed2;
        int i8;
        int currentCompositeKeyHash2;
        int i25;
        int i19;
        boolean changed;
        int i24;
        Composer composer8;
        int i6;
        int i9;
        Composer composer4;
        int i4;
        int i16;
        Function0 function02;
        Object companion;
        Object obj;
        int i29;
        int $i$a$LayoutNavigationItemKt$NavigationItemLayout$1;
        androidx.compose.material3.StartIconMeasurePolicy measurePolicy$iv;
        int i26;
        int i11;
        int currentCompositeKeyHash;
        int i22;
        Object modifier;
        Object function0;
        Composer $composer2;
        int $changed$iv;
        int i30;
        BoxScopeInstance iNSTANCE;
        int i36;
        int i10;
        Composer composer5;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i2;
        Composer composer6;
        int i28;
        ScopeUpdateScope scopeUpdateScope;
        int obj64;
        $changed$iv4 = interactionSource;
        $changed$iv2 = indicatorColor;
        materializeModifier2 = icon;
        final Object obj3 = iconPosition;
        i35 = label;
        final Object obj4 = animationProgress;
        int i37 = $changed1;
        $composer3 = $changed.startRestartGroup(1757687417);
        ComposerKt.sourceInformation($composer3, "C(NavigationItemLayout)P(8,3:c#ui.graphics.Color,5,1,2:c#material3.NavigationItemIconPosition,9!1,4:c#ui.unit.Dp,7:c#ui.unit.Dp,6:c#ui.unit.Dp,10:c#ui.unit.Dp,11:c#ui.unit.Dp)356@14947L1719:NavigationItem.kt#uh7d8r");
        if (i37 & 6 == 0) {
            i = $composer3.changed($changed$iv4) ? 4 : 2;
            $dirty |= i;
        }
        int i87 = 16;
        if (i37 & 48 == 0) {
            i21 = $composer3.changed($changed$iv2) ? i12 : i87;
            $dirty |= i21;
        }
        if (i37 & 384 == 0) {
            i15 = $composer3.changed(materializeModifier2) ? 256 : 128;
            $dirty |= i15;
        }
        if (i37 & 3072 == 0) {
            i13 = $composer3.changedInstance(obj3) ? 2048 : 1024;
            $dirty |= i13;
        }
        if (i37 & 24576 == 0) {
            i31 = $composer3.changed(i35) ? 16384 : 8192;
            $dirty |= i31;
        }
        if (i80 &= i37 == 0) {
            i18 = $composer3.changedInstance(obj4) ? 131072 : 65536;
            $dirty |= i18;
        }
        if (i81 &= i37 == 0) {
            i34 = $composer3.changedInstance(indicatorHorizontalPadding) ? 1048576 : 524288;
            $dirty |= i34;
        }
        if (i82 &= i37 == 0) {
            i27 = $composer3.changed(indicatorVerticalPadding) ? 8388608 : 4194304;
            $dirty |= i27;
        } else {
            materializeModifier = indicatorVerticalPadding;
        }
        if (i37 & i88 == 0) {
            i8 = $composer3.changed(indicatorToLabelVerticalPadding) ? 67108864 : 33554432;
            $dirty |= i8;
        } else {
            f = indicatorToLabelVerticalPadding;
        }
        if (i37 & i89 == 0) {
            i25 = $composer3.changed(startIconToLabelHorizontalPadding) ? 536870912 : 268435456;
            $dirty |= i25;
        } else {
            currentCompositionLocalMap2 = startIconToLabelHorizontalPadding;
        }
        if (obj66 & 6 == 0) {
            i14 = $composer3.changed(topIconItemVerticalPadding) ? 4 : 2;
            $dirty12 |= i14;
        } else {
            maybeCachedBoxMeasurePolicy = topIconItemVerticalPadding;
        }
        if (obj66 & 48 == 0) {
            if ($composer3.changed($composer)) {
            } else {
                i12 = i87;
            }
            $dirty12 |= i12;
        } else {
            currentCompositionLocalMap3 = $composer;
        }
        if ($dirty & i86 == 306783378 && $dirty12 & 19 == 18) {
            if ($dirty12 & 19 == 18) {
                if (!$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1757687417, $dirty, $dirty12, "androidx.compose.material3.NavigationItemLayout (NavigationItem.kt:355)");
                    }
                    int i71 = 0;
                    if (obj4 != null) {
                        if (NavigationItemIconPosition.equals-impl0(i35, NavigationItemIconPosition.Companion.getTop--xw1Ddg())) {
                            i33 = i71;
                            i23 = $dirty;
                            i7 = $dirty12;
                            i5 = obj4 != null ? 1 : i33;
                            $dirty2 = indicatorHorizontalPadding;
                            changed2 = i33;
                            composer3 = $composer3;
                            i17 = 1048576;
                            TopIconOrIconOnlyMeasurePolicy topIconOrIconOnlyMeasurePolicy = new TopIconOrIconOnlyMeasurePolicy(i5, $dirty2, indicatorVerticalPadding, indicatorToLabelVerticalPadding, startIconToLabelHorizontalPadding, $composer, 0);
                            valueOf4 = topIconOrIconOnlyMeasurePolicy;
                            obj2 = $dirty2;
                        } else {
                            i23 = $dirty;
                            i7 = $dirty12;
                            StartIconMeasurePolicy startIconMeasurePolicy = new StartIconMeasurePolicy(indicatorHorizontalPadding, materializeModifier, indicatorToLabelVerticalPadding, maybeCachedBoxMeasurePolicy, 0);
                            changed2 = i38;
                            valueOf4 = startIconMeasurePolicy;
                            composer3 = $composer3;
                            i17 = 1048576;
                            obj2 = indicatorHorizontalPadding;
                        }
                    } else {
                        i33 = i71;
                        i23 = $dirty;
                        i7 = $dirty12;
                    }
                    int i75 = changed2;
                    valueOf = 0;
                    currentCompositionLocalMap3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                    ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, currentCompositionLocalMap3);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, changed2);
                    Function0 function04 = constructor2;
                    changed = 0;
                    i9 = i75;
                    $dirty = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composer3, -692256719, $dirty);
                    if (!applier3 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    composer3.startReusableNode();
                    if (composer3.getInserting()) {
                        composer3.createNode(function04);
                    } else {
                        factory$iv$iv = function04;
                        composer3.useNode();
                    }
                    composer8 = composer3;
                    Composer constructor-impl = Updater.constructor-impl(composer8);
                    int i94 = 0;
                    function02 = factory$iv$iv;
                    Updater.set-impl(constructor-impl, valueOf4, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, composer3.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i95 = 0;
                    companion = constructor-impl;
                    int i96 = 0;
                    if (!companion.getInserting()) {
                        measurePolicy$iv = valueOf4;
                        i26 = valueOf;
                        if (!Intrinsics.areEqual(companion.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            companion.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = companion;
                        }
                    } else {
                        measurePolicy$iv = valueOf4;
                        i26 = valueOf;
                    }
                    Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(composer3, (Modifier)Modifier.Companion), ComposeUiNode.Companion.getSetModifier());
                    Composer composer10 = composer8;
                    $i$a$LayoutNavigationItemKt$NavigationItemLayout$12 = 0;
                    i4 = i40;
                    ComposerKt.sourceInformationMarkerStart(composer10, 1690051920, "C362@15191L32,359@15031L207,369@15552L31,367@15456L292,375@15761L50:NavigationItem.kt#uh7d8r");
                    Composer composer13 = composer10;
                    $dirty12 = composer13;
                    BoxKt.Box(IndicationKt.indication(ClipKt.clip(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "indicatorRipple"), materializeModifier2), $changed$iv4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, 0, 0, obj37, composer13, 0)), $dirty12, 0);
                    ComposerKt.sourceInformationMarkerStart($dirty12, -776750382, "CC(remember):NavigationItem.kt#9igjgp");
                    i20 = i23 & i47 == 1048576 ? 1 : 0;
                    Composer composer11 = $dirty12;
                    int i90 = 0;
                    it$iv = composer11.rememberedValue();
                    i16 = 0;
                    if (i20 == 0) {
                        $i$a$LayoutNavigationItemKt$NavigationItemLayout$1 = $i$a$LayoutNavigationItemKt$NavigationItemLayout$12;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $i$a$LayoutNavigationItemKt$NavigationItemLayout$12 = 0;
                            obj = it$iv;
                            it$iv = new NavigationItemKt.NavigationItemLayout.1.1.1(obj2);
                            composer11.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj = it$iv;
                        }
                    } else {
                        $i$a$LayoutNavigationItemKt$NavigationItemLayout$1 = $i$a$LayoutNavigationItemKt$NavigationItemLayout$12;
                    }
                    ComposerKt.sourceInformationMarkerEnd($dirty12);
                    BoxKt.Box(BackgroundKt.background-bw27NRU(GraphicsLayerModifierKt.graphicsLayer(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "indicator"), (Function1)it$iv), $changed$iv2, obj3), $dirty12, 0);
                    Modifier layoutId3 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                    obj64 = i49;
                    $changed$iv4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart($dirty12, 733328855, $changed$iv4);
                    int i51 = 0;
                    maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), i51);
                    i29 = 0;
                    i11 = i51;
                    ComposerKt.sourceInformationMarkerStart($dirty12, -1323940314, currentCompositionLocalMap3);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($dirty12, 0);
                    currentCompositionLocalMap = $dirty12.getCurrentCompositionLocalMap();
                    modifier = layoutId3;
                    Function0 function06 = constructor3;
                    i22 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty12, -692256719, $dirty);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $dirty12.startReusableNode();
                    if ($dirty12.getInserting()) {
                        $dirty12.createNode(function06);
                    } else {
                        factory$iv$iv$iv2 = function06;
                        $dirty12.useNode();
                    }
                    function0 = factory$iv$iv$iv2;
                    Composer constructor-impl2 = Updater.constructor-impl($dirty12);
                    int i104 = 0;
                    i36 = i68;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i105 = 0;
                    Composer composer14 = constructor-impl2;
                    int i108 = 0;
                    if (!composer14.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy2;
                        if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer14;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        measurePolicy = maybeCachedBoxMeasurePolicy2;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier($dirty12, layoutId3), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = $dirty12;
                    i30 = i44;
                    $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, $changed$iv3);
                    iNSTANCE = BoxScopeInstance.INSTANCE;
                    i107 |= 6;
                    i2 = 0;
                    i28 = i60;
                    $i$a$LayoutBoxKt$Box$1$iv = composer5;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 14502763, "C375@15803L6:NavigationItem.kt#uh7d8r");
                    obj3.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i53 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    $dirty12.endNode();
                    ComposerKt.sourceInformationMarkerEnd($dirty12);
                    ComposerKt.sourceInformationMarkerEnd($dirty12);
                    ComposerKt.sourceInformationMarkerEnd($dirty12);
                    $dirty12.startReplaceGroup(-776741606);
                    ComposerKt.sourceInformation($dirty12, "377@15861L52");
                    Modifier layoutId4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label");
                    valueOf2 = 6;
                    valueOf3 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty12, 733328855, $changed$iv4);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i16 = 0;
                    obj64 = topStart;
                    ComposerKt.sourceInformationMarkerStart($dirty12, -1323940314, currentCompositionLocalMap3);
                    changed2 = currentCompositeKeyHash3;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($dirty12, layoutId4);
                    i29 = layoutId4;
                    Function0 function05 = constructor;
                    i19 = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty12, -692256719, $dirty);
                    if (obj4 != null && !applier2 instanceof Applier) {
                        layoutId4 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "label");
                        valueOf2 = 6;
                        valueOf3 = 0;
                        ComposerKt.sourceInformationMarkerStart($dirty12, 733328855, $changed$iv4);
                        topStart = Alignment.Companion.getTopStart();
                        i16 = 0;
                        obj64 = topStart;
                        ComposerKt.sourceInformationMarkerStart($dirty12, -1323940314, currentCompositionLocalMap3);
                        changed2 = currentCompositeKeyHash3;
                        materializeModifier3 = ComposedModifierKt.materializeModifier($dirty12, layoutId4);
                        i29 = layoutId4;
                        function05 = constructor;
                        i19 = 0;
                        ComposerKt.sourceInformationMarkerStart($dirty12, -692256719, $dirty);
                        if (!applier2 instanceof Applier) {
                            ComposablesKt.invalidApplier();
                        }
                        $dirty12.startReusableNode();
                        if ($dirty12.getInserting()) {
                            $dirty12.createNode(function05);
                        } else {
                            factory$iv$iv$iv = function05;
                            $dirty12.useNode();
                        }
                        Composer constructor-impl3 = Updater.constructor-impl($dirty12);
                        int i93 = 0;
                        i22 = factory$iv$iv$iv;
                        Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                        Updater.set-impl(constructor-impl3, $dirty12.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                        int i98 = 0;
                        Composer composer12 = constructor-impl3;
                        int i101 = 0;
                        if (!composer12.getInserting()) {
                            $changed$iv = valueOf2;
                            i30 = valueOf3;
                            if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(changed2))) {
                                composer12.updateRememberedValue(Integer.valueOf(changed2));
                                constructor-impl3.apply(Integer.valueOf(changed2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                            } else {
                                composer7 = composer12;
                            }
                        } else {
                            $changed$iv = valueOf2;
                            i30 = valueOf3;
                        }
                        Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                        $i$a$LayoutBoxKt$Box$1$iv = $dirty12;
                        materializeModifier2 = 0;
                        ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -2146769399, $changed$iv3);
                        i78 |= 6;
                        i11 = 0;
                        modifier = iNSTANCE2;
                        function0 = materializeModifier3;
                        iNSTANCE = i59;
                        $changed$iv2 = composer4;
                        ComposerKt.sourceInformationMarkerStart($changed$iv2, 14602986, "C377@15904L7:NavigationItem.kt#uh7d8r");
                        obj4.invoke($changed$iv2, Integer.valueOf(i45 &= 14));
                        ComposerKt.sourceInformationMarkerEnd($changed$iv2);
                        ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                        $dirty12.endNode();
                        ComposerKt.sourceInformationMarkerEnd($dirty12);
                        ComposerKt.sourceInformationMarkerEnd($dirty12);
                        ComposerKt.sourceInformationMarkerEnd($dirty12);
                    }
                    $dirty12.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd($dirty12);
                    composer8.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    ComposerKt.sourceInformationMarkerEnd(composer8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    $composer3.skipToGroupEnd();
                    obj2 = indicatorHorizontalPadding;
                    i23 = $dirty;
                    i7 = $dirty12;
                    composer8 = $composer3;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer8.endRestartGroup();
        if (endRestartGroup != null) {
            $composer2 = composer8;
            endRestartGroup = new NavigationItemKt.NavigationItemLayout.2(interactionSource, indicatorColor, $i$a$LayoutBoxKt$Box$1$iv, icon, obj3, label, obj4, obj2, indicatorVerticalPadding, indicatorToLabelVerticalPadding, startIconToLabelHorizontalPadding, topIconItemVerticalPadding, $composer, $changed1, obj66);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            $composer2 = composer8;
        }
    }

    private static final int NavigationItem_SHbi2eg$lambda$2(MutableIntState $itemWidth$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntState)$itemWidth$delegate.getIntValue();
    }

    private static final void NavigationItem_SHbi2eg$lambda$3(MutableIntState $itemWidth$delegate, int value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $itemWidth$delegate.setIntValue(value);
    }

    public static final void access$NavigationItemLayout-KmRX-Dg(InteractionSource interactionSource, long indicatorColor, Shape indicatorShape, Function2 icon, int iconPosition, Function2 label, Function0 animationProgress, float indicatorHorizontalPadding, float indicatorVerticalPadding, float indicatorToLabelVerticalPadding, float startIconToLabelHorizontalPadding, float topIconItemVerticalPadding, Composer $composer, int $changed, int $changed1) {
        NavigationItemKt.NavigationItemLayout-KmRX-Dg(interactionSource, indicatorColor, indicatorShape, icon, iconPosition, label, animationProgress, indicatorHorizontalPadding, indicatorVerticalPadding, indicatorToLabelVerticalPadding, startIconToLabelHorizontalPadding, topIconItemVerticalPadding, $composer, $changed, $changed1);
    }

    public static final void access$NavigationItem_SHbi2eg$lambda$3(MutableIntState $itemWidth$delegate, int value) {
        NavigationItemKt.NavigationItem_SHbi2eg$lambda$3($itemWidth$delegate, value);
    }

    public static final MeasureResult access$placeIcon-X9ElhV4(MeasureScope $receiver, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        return NavigationItemKt.placeIcon-X9ElhV4($receiver, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints);
    }

    public static final MeasureResult access$placeLabelAndStartIcon-nru01g4(MeasureScope $receiver, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, float startIconToLabelHorizontalPadding) {
        return NavigationItemKt.placeLabelAndStartIcon-nru01g4($receiver, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, startIconToLabelHorizontalPadding);
    }

    public static final MeasureResult access$placeLabelAndTopIcon-qoqLrGI(MeasureScope $receiver, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, float indicatorToLabelVerticalPadding, float indicatorVerticalPadding, float topIconItemVerticalPadding) {
        return NavigationItemKt.placeLabelAndTopIcon-qoqLrGI($receiver, labelPlaceable, iconPlaceable, indicatorRipplePlaceable, indicatorPlaceable, constraints, indicatorToLabelVerticalPadding, indicatorVerticalPadding, topIconItemVerticalPadding);
    }

    public static final float getNavigationItemMinHeight() {
        return NavigationItemKt.NavigationItemMinHeight;
    }

    public static final float getNavigationItemMinWidth() {
        return NavigationItemKt.NavigationItemMinWidth;
    }

    private static final MeasureResult placeIcon-X9ElhV4(MeasureScope $this$placeIcon_u2dX9ElhV4, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints) {
        final Object obj = constraints;
        final int constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(obj, obj1);
        final int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(obj, obj1);
        int i9 = i / 2;
        int i11 = i2 / 2;
        NavigationItemKt.placeIcon.1 anon = new NavigationItemKt.placeIcon.1(indicatorPlaceable, i9, i11, iconPlaceable, i3 / 2, i4 / 2, indicatorRipplePlaceable, i5 / 2, i6 / 2);
        int i7 = i9;
        int i13 = i11;
        return MeasureScope.layout$default($this$placeIcon_u2dX9ElhV4, constrainWidth-K40F9xA, constrainHeight-K40F9xA, 0, (Function1)anon, 4, 0);
    }

    private static final MeasureResult placeLabelAndStartIcon-nru01g4(MeasureScope $this$placeLabelAndStartIcon_u2dnru01g4, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, float startIconToLabelHorizontalPadding) {
        final MeasureScope measureScope = $this$placeLabelAndStartIcon_u2dnru01g4;
        final Object obj = constraints;
        final float f = obj31;
        int constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(obj, obj8);
        int constrainHeight-K40F9xA = ConstraintsKt.constrainHeight-K40F9xA(obj, obj8);
        final int i18 = i7 / 2;
        NavigationItemKt.placeLabelAndStartIcon.1 anon2 = new NavigationItemKt.placeLabelAndStartIcon.1(indicatorPlaceable, i / 2, i2 / 2, labelPlaceable, i8 + roundToPx-0680j_42, i4 / 2, iconPlaceable, i18, i3 / 2, indicatorRipplePlaceable, i9 / 2, i10 / 2);
        return MeasureScope.layout$default(measureScope, constrainWidth-K40F9xA, constrainHeight-K40F9xA, 0, (Function1)anon2, 4, 0);
    }

    private static final MeasureResult placeLabelAndTopIcon-qoqLrGI(MeasureScope $this$placeLabelAndTopIcon_u2dqoqLrGI, Placeable labelPlaceable, Placeable iconPlaceable, Placeable indicatorRipplePlaceable, Placeable indicatorPlaceable, long constraints, float indicatorToLabelVerticalPadding, float indicatorVerticalPadding, float topIconItemVerticalPadding) {
        final MeasureScope measureScope = $this$placeLabelAndTopIcon_u2dqoqLrGI;
        final Object obj = constraints;
        final float f4 = indicatorVerticalPadding;
        final int i19 = topIconItemVerticalPadding;
        final float f5 = obj35;
        int constrainWidth-K40F9xA = ConstraintsKt.constrainWidth-K40F9xA(obj, obj8);
        int i8 = 0;
        final int roundToPx-0680j_43 = measureScope.roundToPx-0680j_4(Dp.constructor-impl(f5 + i19));
        final int i27 = roundToPx-0680j_43 - roundToPx-0680j_4;
        int i15 = 0;
        NavigationItemKt.placeLabelAndTopIcon.1 anon2 = new NavigationItemKt.placeLabelAndTopIcon.1(indicatorPlaceable, i10 / 2, i27, labelPlaceable, i11 / 2, i12 + roundToPx-0680j_42, iconPlaceable, i9 / 2, roundToPx-0680j_43, indicatorRipplePlaceable, i13 / 2, i27);
        return MeasureScope.layout$default(measureScope, constrainWidth-K40F9xA, ConstraintsKt.constrainHeight-K40F9xA(obj, obj8), 0, (Function1)anon2, 4, 0);
    }
}
