package androidx.compose.material3;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0086\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u00182\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00042\u0008\u0010%\u001a\u0004\u0018\u00010&2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00140(¢\u0006\u0002\u0008*¢\u0006\u0002\u0008+H\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\u001a\u0082\u0001\u0010.\u001a\u00020\u00142\u0011\u0010/\u001a\r\u0012\u0004\u0012\u00020\u001400¢\u0006\u0002\u0008*2\u000c\u00101\u001a\u0008\u0012\u0004\u0012\u00020\u0014002\u0006\u0010\u0015\u001a\u00020\u00162\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u000100¢\u0006\u0002\u0008*2\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\u0014\u0018\u000100¢\u0006\u0002\u0008*2\u0006\u00104\u001a\u00020\u00192\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0008\u00109\u001a\u0004\u0018\u00010:H\u0001¢\u0006\u0002\u0010;\u001a\u001d\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020>H\u0000¢\u0006\u0002\u0010@\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0008\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0010\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0011\u0010\n\"\u000e\u0010\u0012\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u0001X\u008a\u0084\u0002²\u0006\n\u0010C\u001a\u00020\u0001X\u008a\u0084\u0002", d2 = {"ClosedAlphaTarget", "", "ClosedScaleTarget", "DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "ExpandedAlphaTarget", "ExpandedScaleTarget", "InTransitionDuration", "", "MenuListItemContainerHeight", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "modifier", "Landroidx/compose/ui/Modifier;", "expandedState", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "tonalElevation", "shadowElevation", "border", "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenuContent-Qj0Zi0g", "(Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/graphics/Shape;JFFLandroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "DropdownMenuItemContent", "text", "Lkotlin/Function0;", "onClick", "leadingIcon", "trailingIcon", "enabled", "colors", "Landroidx/compose/material3/MenuItemColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/MenuItemColors;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;I)V", "calculateTransformOrigin", "anchorBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material3_release", "scale", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MenuKt {

    public static final float ClosedAlphaTarget = 0f;
    public static final float ClosedScaleTarget = 0.8f;
    private static final float DropdownMenuItemDefaultMaxWidth = 0f;
    private static final float DropdownMenuItemDefaultMinWidth = 0f;
    private static final float DropdownMenuItemHorizontalPadding = 0f;
    private static final float DropdownMenuVerticalPadding = 0f;
    public static final float ExpandedAlphaTarget = 1f;
    public static final float ExpandedScaleTarget = 1f;
    public static final int InTransitionDuration = 120;
    private static final float MenuListItemContainerHeight = 0f;
    private static final float MenuVerticalMargin = 0f;
    public static final int OutTransitionDuration = 75;
    static {
        int i7 = 0;
        MenuKt.MenuVerticalMargin = Dp.constructor-impl((float)i);
        int i8 = 0;
        MenuKt.MenuListItemContainerHeight = Dp.constructor-impl((float)i2);
        int i9 = 0;
        MenuKt.DropdownMenuItemHorizontalPadding = Dp.constructor-impl((float)i3);
        int i10 = 0;
        MenuKt.DropdownMenuVerticalPadding = Dp.constructor-impl((float)i4);
        int i11 = 0;
        MenuKt.DropdownMenuItemDefaultMinWidth = Dp.constructor-impl((float)i5);
        int i12 = 0;
        MenuKt.DropdownMenuItemDefaultMaxWidth = Dp.constructor-impl((float)i6);
    }

    public static final void DropdownMenuContent-Qj0Zi0g(Modifier modifier, MutableTransitionState<Boolean> expandedState, MutableState<TransformOrigin> transformOriginState, ScrollState scrollState, Shape shape, long containerColor, float tonalElevation, float shadowElevation, BorderStroke border, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        Object anon;
        boolean traceInProgress2;
        boolean traceInProgress3;
        Object isInspecting;
        Composer scale$delegate;
        Object obj;
        int $dirty;
        int i13;
        boolean changedInstance2;
        int i19;
        Object it$iv;
        boolean traceInProgress;
        int i3;
        int transitionAnimation;
        Object $i$f$animateValue;
        Object $composer2;
        int i20;
        Object obj2;
        int i23;
        Object $changed$iv;
        int i17;
        boolean expanded2;
        int i14;
        int i18;
        Object obj3;
        Transition $this$animateFloat$iv;
        int i11;
        int i10;
        float f;
        int changedInstance;
        int i9;
        long graphicsLayer;
        int empty;
        Modifier modifier2;
        int i5;
        float f2;
        int i;
        int i4;
        int i21;
        int i12;
        Composer $composer5;
        int i15;
        Object obj4;
        Object vectorConverter;
        String str;
        Composer composer2;
        Composer $composer3;
        boolean expanded;
        BorderStroke borderStroke;
        int i25;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i8;
        int i7;
        Transition transition2;
        int i26;
        int i24;
        int i22;
        int i2;
        int i16;
        int i6;
        Transition transition;
        Composer $composer4;
        final Object obj5 = modifier;
        obj = expandedState;
        anon = scrollState;
        final Object obj7 = $composer;
        final int i100 = obj46;
        scale$delegate = $changed.startRestartGroup(-151448888);
        ComposerKt.sourceInformation(scale$delegate, "C(DropdownMenuContent)P(4,3,9,5,7,1:c#ui.graphics.Color,8:c#ui.unit.Dp,6:c#ui.unit.Dp)376@17481L47,379@17566L531,394@18135L460,408@18640L7,411@18715L587,428@19474L276,409@18652L1098:Menu.kt#uh7d8r");
        if (i100 & 6 == 0) {
            i13 = scale$delegate.changed(obj5) ? 4 : 2;
            $dirty |= i13;
        }
        if (i100 & 48 == 0) {
            if (i100 & 64 == 0) {
                changedInstance2 = scale$delegate.changed(obj);
            } else {
                changedInstance2 = scale$delegate.changedInstance(obj);
            }
            i19 = changedInstance2 ? 32 : 16;
            $dirty |= i19;
        }
        if (i100 & 384 == 0) {
            i14 = scale$delegate.changed(transformOriginState) ? 256 : 128;
            $dirty |= i14;
        } else {
            it$iv = transformOriginState;
        }
        if (i100 & 3072 == 0) {
            i18 = scale$delegate.changed(anon) ? 2048 : 1024;
            $dirty |= i18;
        }
        if (i100 & 24576 == 0) {
            i11 = scale$delegate.changed(shape) ? 16384 : 8192;
            $dirty |= i11;
        } else {
            obj3 = shape;
        }
        if (i93 &= i100 == 0) {
            i10 = scale$delegate.changed(containerColor) ? 131072 : 65536;
            $dirty |= i10;
        } else {
            graphicsLayer = containerColor;
        }
        if (i94 &= i100 == 0) {
            i5 = scale$delegate.changed(shadowElevation) ? 1048576 : 524288;
            $dirty |= i5;
        } else {
            f = shadowElevation;
        }
        i25 = 12582912;
        if (i100 & i25 == 0) {
            i = scale$delegate.changed(border) ? 8388608 : 4194304;
            $dirty |= i;
        } else {
            f2 = border;
        }
        if (i100 & i122 == 0) {
            i4 = scale$delegate.changed(content) ? 67108864 : 33554432;
            $dirty |= i4;
        } else {
            obj2 = content;
        }
        if (i100 & i123 == 0) {
            i21 = scale$delegate.changedInstance(obj7) ? 536870912 : 268435456;
            $dirty |= i21;
        }
        if ($dirty & i12 == 306783378) {
            if (!scale$delegate.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-151448888, $dirty, -1, "androidx.compose.material3.DropdownMenuContent (Menu.kt:374)");
                }
                transition2 = TransitionKt.updateTransition(obj, "DropDownMenu", scale$delegate, i28 |= i48, 0);
                int i131 = 0;
                int i133 = i49;
                ComposerKt.sourceInformationMarkerStart(scale$delegate, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                i16 = 57344;
                Transition transition3 = transition5;
                int i134 = i53;
                ComposerKt.sourceInformationMarkerStart(scale$delegate, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                int i125 = 0;
                int i135 = i71;
                $i$f$animateValue = composer5;
                $i$f$animateValue.startReplaceGroup(2139028452);
                String str4 = "C:Menu.kt#uh7d8r";
                ComposerKt.sourceInformation($i$f$animateValue, str4);
                if (ComposerKt.isTraceInProgress()) {
                    $composer4 = $i$f$animateValue;
                    ComposerKt.traceEventStart(2139028452, i105 &= 112, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
                } else {
                    $composer4 = $i$f$animateValue;
                }
                i23 = (Boolean)transition3.getCurrentState().booleanValue() ? 1065353216 : 1061997773;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer4.endReplaceGroup();
                int i127 = 0;
                $composer2 = composer7;
                int expanded4 = 2139028452;
                $composer2.startReplaceGroup(expanded4);
                ComposerKt.sourceInformation($composer2, str4);
                if (ComposerKt.isTraceInProgress()) {
                    $composer3 = $composer2;
                    ComposerKt.traceEventStart(expanded4, i82 &= 112, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:390)");
                } else {
                    $composer3 = $composer2;
                }
                i20 = (Boolean)transition3.getTargetState().booleanValue() ? 1065353216 : 1061997773;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer3.endReplaceGroup();
                int i96 = 458752;
                Composer composer8 = scale$delegate;
                State transitionAnimation2 = TransitionKt.createTransitionAnimation(transition3, Float.valueOf(i23), Float.valueOf(i20), (FiniteAnimationSpec)(Function3)MenuKt.DropdownMenuContent.scale.2.INSTANCE.invoke(transition3.getSegment(), scale$delegate, Integer.valueOf(i84 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), "FloatAnimation", composer8, i73 | i89);
                Composer composer3 = composer8;
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                int i74 = 0;
                $this$animateFloat$iv = transition2;
                int i130 = 0;
                ComposerKt.sourceInformationMarkerStart(composer3, -1338768149, "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli");
                str = "FloatAnimation";
                int i132 = i103 | i113;
                Transition transition4 = $this$animateFloat$iv;
                i22 = 0;
                ComposerKt.sourceInformationMarkerStart(composer3, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                int i126 = 0;
                i2 = i96;
                int i97 = -249413128;
                i6 = i74;
                $changed$iv = composer6;
                $changed$iv.startReplaceGroup(i97);
                ComposerKt.sourceInformation($changed$iv, str4);
                if (ComposerKt.isTraceInProgress()) {
                    $composer5 = $changed$iv;
                    transition = $this$animateFloat$iv;
                    ComposerKt.traceEventStart(i97, i119 &= 112, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
                } else {
                    $composer5 = $changed$iv;
                    transition = $this$animateFloat$iv;
                }
                i17 = (Boolean)transition4.getCurrentState().booleanValue() ? 1065353216 : 0;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer5.endReplaceGroup();
                expanded2 = (Boolean)transition4.getTargetState().booleanValue();
                Composer composer4 = composer3;
                int i124 = 0;
                composer4.startReplaceGroup(i97);
                ComposerKt.sourceInformation(composer4, str4);
                if (ComposerKt.isTraceInProgress()) {
                    expanded = expanded2;
                    ComposerKt.traceEventStart(i97, i90 &= 112, -1, "androidx.compose.material3.DropdownMenuContent.<anonymous> (Menu.kt:405)");
                } else {
                    expanded = expanded2;
                }
                i3 = expanded ? 1065353216 : 0;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                Composer composer9 = composer3;
                transitionAnimation = TransitionKt.createTransitionAnimation(transition4, Float.valueOf(i17), Float.valueOf(i3), (FiniteAnimationSpec)(Function3)MenuKt.DropdownMenuContent.alpha.2.INSTANCE.invoke(transition4.getSegment(), composer3, Integer.valueOf(i75 &= 112)), VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), str, composer9, i55 | i80);
                obj2 = composer9;
                ComposerKt.sourceInformationMarkerEnd(obj2);
                ComposerKt.sourceInformationMarkerEnd(obj2);
                int i56 = 0;
                int i92 = 0;
                ComposerKt.sourceInformationMarkerStart(obj2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj2);
                boolean booleanValue = (Boolean)obj2.consume((CompositionLocal)InspectionModeKt.getLocalInspectionMode()).booleanValue();
                ComposerKt.sourceInformationMarkerStart(obj2, 526637745, "CC(remember):Menu.kt#9igjgp");
                if ($dirty & 112 != 32) {
                    if ($dirty & 64 != 0 && obj2.changedInstance(obj)) {
                        if (obj2.changedInstance(obj)) {
                            i9 = 1;
                        } else {
                            i9 = 0;
                        }
                    } else {
                    }
                } else {
                }
                i24 = $dirty & 896 == 256 ? 1 : 0;
                f = obj2;
                int i121 = 0;
                Object rememberedValue = f.rememberedValue();
                if (i60 |= i24 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj4 = rememberedValue;
                        i26 = $dirty;
                        isInspecting = new MenuKt.DropdownMenuContent.1.1(booleanValue, obj, transformOriginState, transitionAnimation2, transitionAnimation);
                        f.updateRememberedValue((Function1)isInspecting);
                    } else {
                        i26 = $dirty;
                        it$iv = transitionAnimation2;
                        scale$delegate = booleanValue;
                        isInspecting = obj4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj2);
                MenuKt.DropdownMenuContent.2 anon2 = new MenuKt.DropdownMenuContent.2(obj5, anon, obj7);
                composer = obj2;
                SurfaceKt.Surface-T9BRK9s(GraphicsLayerModifierKt.graphicsLayer((Modifier)Modifier.Companion, (Function1)isInspecting), shape, containerColor, 0, 0, str, shadowElevation, border, content, (Function2)ComposableLambdaKt.rememberComposableLambda(1573559053, true, anon2, obj2, 54), composer);
                composer2 = composer;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                scale$delegate.skipToGroupEnd();
                composer2 = scale$delegate;
                i26 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new MenuKt.DropdownMenuContent.3(obj5, expandedState, transformOriginState, scrollState, shape, containerColor, transitionAnimation, shadowElevation, border, content, obj7, i100);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$1(State<Float> $scale$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (Number)$scale$delegate.getValue().floatValue();
    }

    private static final float DropdownMenuContent_Qj0Zi0g$lambda$3(State<Float> $alpha$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (Number)$alpha$delegate.getValue().floatValue();
    }

    public static final void DropdownMenuItemContent(Function2<? super Composer, ? super Integer, Unit> text, Function0<Unit> onClick, Modifier modifier, Function2<? super Composer, ? super Integer, Unit> leadingIcon, Function2<? super Composer, ? super Integer, Unit> trailingIcon, boolean enabled, androidx.compose.material3.MenuItemColors colors, PaddingValues contentPadding, MutableInteractionSource interactionSource, Composer $composer, int $changed) {
        int traceInProgress;
        Modifier valueOf;
        int $dirty;
        Object valueOf2;
        Composer composer2;
        int i9;
        int i6;
        int i3;
        int i12;
        int i11;
        int i2;
        Object centerVertically;
        int i17;
        int i14;
        Object obj5;
        int i10;
        boolean skipping;
        boolean traceInProgress2;
        Composer restartGroup;
        int start;
        androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy;
        Object obj;
        Object rememberComposableLambda;
        Object obj3;
        Object obj4;
        Object obj2;
        boolean localMap$iv$iv;
        RowScopeInstance rowScopeInstance;
        Object obj6;
        int i15;
        int i5;
        int i4;
        int currentCompositeKeyHash;
        int i13;
        int i7;
        int i8;
        int i16;
        Modifier modifier$iv;
        Composer composer3;
        int i;
        Modifier modifier2;
        Function0 function0;
        Composer composer;
        final Object obj8 = contentPadding;
        final int i38 = $changed;
        traceInProgress = -1564716777;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(DropdownMenuItemContent)P(7,6,5,4,8,2)459@20361L36,452@20118L2520:Menu.kt#uh7d8r");
        if (i38 & 6 == 0) {
            i9 = restartGroup.changedInstance(text) ? 4 : 2;
            $dirty |= i9;
        } else {
            obj = text;
        }
        if (i38 & 48 == 0) {
            i6 = restartGroup.changedInstance(onClick) ? 32 : 16;
            $dirty |= i6;
        } else {
            rememberComposableLambda = onClick;
        }
        if (i38 & 384 == 0) {
            i3 = restartGroup.changed(modifier) ? 256 : 128;
            $dirty |= i3;
        } else {
            obj3 = modifier;
        }
        if (i38 & 3072 == 0) {
            i12 = restartGroup.changedInstance(leadingIcon) ? 2048 : 1024;
            $dirty |= i12;
        } else {
            obj4 = leadingIcon;
        }
        if (i38 & 24576 == 0) {
            i11 = restartGroup.changedInstance(trailingIcon) ? 16384 : 8192;
            $dirty |= i11;
        } else {
            obj2 = trailingIcon;
        }
        if (i21 &= i38 == 0) {
            i2 = restartGroup.changed(enabled) ? 131072 : 65536;
            $dirty |= i2;
        } else {
            localMap$iv$iv = enabled;
        }
        if (i22 &= i38 == 0) {
            i17 = restartGroup.changed(colors) ? 1048576 : 524288;
            $dirty |= i17;
        } else {
            centerVertically = colors;
        }
        if (i25 &= i38 == 0) {
            i14 = restartGroup.changed(obj8) ? 8388608 : 4194304;
            $dirty |= i14;
        }
        if (i26 &= i38 == 0) {
            i10 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
            $dirty |= i10;
        } else {
            obj5 = interactionSource;
        }
        if (i30 &= $dirty == 38347922) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.DropdownMenuItemContent (Menu.kt:451)");
                }
                int i24 = 0;
                i4 = i18;
                valueOf2 = restartGroup;
                valueOf = PaddingKt.padding(SizeKt.sizeIn-qDBjuR0$default(SizeKt.fillMaxWidth$default(ClickableKt.clickable-O2vRcR0$default(obj3, interactionSource, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, i24, 0, traceInProgress2, restartGroup, 6), enabled, 0, 0, rememberComposableLambda, 24, 0), i24, 1, 0), MenuKt.DropdownMenuItemDefaultMinWidth, MenuKt.MenuListItemContainerHeight, MenuKt.DropdownMenuItemDefaultMaxWidth, 0, 8, 0), obj8);
                obj5 = 384;
                restartGroup = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = valueOf2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(valueOf2, valueOf);
                Function0 constructor = ComposeUiNode.Companion.getConstructor();
                int i54 = 6;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf2.startReusableNode();
                if (valueOf2.getInserting()) {
                    valueOf2.createNode(constructor);
                } else {
                    valueOf2.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(valueOf2);
                int i50 = 0;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getCenterVertically(), valueOf2, i36 |= i40), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i61 = 0;
                Composer composer5 = constructor-impl;
                int i66 = 0;
                if (!composer5.getInserting()) {
                    modifier$iv = valueOf;
                    composer3 = valueOf2;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    modifier$iv = valueOf;
                    composer3 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                $dirty = composer3;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart($dirty, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i8 = i56 | 6;
                Composer composer4 = $dirty;
                i16 = 0;
                i = i20;
                ComposerKt.sourceInformationMarkerStart(composer4, 1949444430, "C472@20996L10,472@21019L1613,472@20965L1667:Menu.kt#uh7d8r");
                modifier2 = materializeModifier;
                function0 = constructor;
                obj = map;
                MenuKt.DropdownMenuItemContent.1.1 localMap$iv$iv2 = new MenuKt.DropdownMenuItemContent.1.1(leadingIcon, colors, enabled, trailingIcon, (RowScope)RowScopeInstance.INSTANCE, obj);
                TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer4, i54).getLabelLarge(), (Function2)ComposableLambdaKt.rememberComposableLambda(1065051884, true, localMap$iv$iv2, $dirty, 54), $dirty, 48);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                ComposerKt.sourceInformationMarkerEnd($dirty);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i4 = $dirty;
                composer3 = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new MenuKt.DropdownMenuItemContent.2(text, onClick, modifier, leadingIcon, trailingIcon, enabled, colors, obj8, interactionSource, i38);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final float access$DropdownMenuContent_Qj0Zi0g$lambda$1(State $scale$delegate) {
        return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$1($scale$delegate);
    }

    public static final float access$DropdownMenuContent_Qj0Zi0g$lambda$3(State $alpha$delegate) {
        return MenuKt.DropdownMenuContent_Qj0Zi0g$lambda$3($alpha$delegate);
    }

    public static final float access$getDropdownMenuItemHorizontalPadding$p() {
        return MenuKt.DropdownMenuItemHorizontalPadding;
    }

    public static final long calculateTransformOrigin(IntRect anchorBounds, IntRect menuBounds) {
        int right;
        int bottom;
        int i3;
        int i;
        int i2;
        float f;
        int bottom2;
        i2 = 0;
        if (menuBounds.getLeft() >= anchorBounds.getRight()) {
            i3 = i2;
        } else {
            if (menuBounds.getRight() <= anchorBounds.getLeft()) {
                i3 = i;
            } else {
                if (menuBounds.getWidth() == 0) {
                    i3 = i2;
                } else {
                    f2 /= f;
                }
            }
        }
        if (menuBounds.getTop() >= anchorBounds.getBottom()) {
            i = i2;
        } else {
            if (menuBounds.getBottom() <= anchorBounds.getTop()) {
            } else {
                if (menuBounds.getHeight() == 0) {
                    i = i2;
                } else {
                    f3 /= i2;
                }
            }
        }
        return TransformOriginKt.TransformOrigin(i3, i);
    }

    public static final float getDropdownMenuVerticalPadding() {
        return MenuKt.DropdownMenuVerticalPadding;
    }

    public static final float getMenuVerticalMargin() {
        return MenuKt.MenuVerticalMargin;
    }
}
