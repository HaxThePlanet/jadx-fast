package androidx.compose.material3;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Placeable.PlacementScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0082\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\u0008\u00182\u0011\u0010\u0019\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001e2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010#\u001a\u008a\u0001\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00162\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00142\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\u0008\u00182\u0015\u0008\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\u0008\u00182\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001e2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001az\u0010$\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u00162\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00142\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001e2\n\u0008\u0002\u0010 \u001a\u0004\u0018\u00010!2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00120(¢\u0006\u0002\u0008\u0018¢\u0006\u0002\u0008*H\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010,\u001a7\u0010-\u001a\u00020\u00122\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\u0008\u00182\u0013\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0016¢\u0006\u0002\u0008\u0018H\u0003¢\u0006\u0002\u0010.\u001a=\u0010/\u001a\u00020\u00122\u0006\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u00142\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020\u00120\u0016¢\u0006\u0002\u0008\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\u00082\u00103\u001aD\u00104\u001a\u00020\u0012*\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u0002092\u0006\u0010;\u001a\u00020\r2\u0006\u0010<\u001a\u00020\r2\u0006\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020\rH\u0002\u001a\u001c\u0010?\u001a\u00020\u0012*\u0002052\u0006\u0010@\u001a\u0002092\u0006\u0010<\u001a\u00020\rH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\u0008\u0004\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000c\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006A²\u0006\n\u0010B\u001a\u00020\u001eX\u008a\u0084\u0002", d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "getHorizontalTextPadding", "()F", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "LeadingIconTab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "Tab", "Tab-wqdebIU", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;JJLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-bogVsAg", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZJJLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material3_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TabKt {

    private static final float DoubleLineTextBaselineWithIcon = 0f;
    private static final float HorizontalTextPadding = 0f;
    private static final long IconDistanceFromBaseline = 0L;
    private static final float LargeTabHeight = 0f;
    private static final float SingleLineTextBaselineWithIcon = 0f;
    private static final float SmallTabHeight = 0f;
    private static final int TabFadeInAnimationDelay = 100;
    private static final int TabFadeInAnimationDuration = 150;
    private static final int TabFadeOutAnimationDuration = 100;
    private static final float TextDistanceFromLeadingIcon;
    static {
        TabKt.SmallTabHeight = PrimaryNavigationTabTokens.INSTANCE.getContainerHeight-D9Ej5fM();
        int i7 = 0;
        TabKt.LargeTabHeight = Dp.constructor-impl((float)i);
        int i8 = 0;
        TabKt.HorizontalTextPadding = Dp.constructor-impl((float)i2);
        int i9 = 0;
        TabKt.SingleLineTextBaselineWithIcon = Dp.constructor-impl((float)i3);
        int i10 = 0;
        TabKt.DoubleLineTextBaselineWithIcon = Dp.constructor-impl((float)i4);
        TabKt.IconDistanceFromBaseline = TextUnitKt.getSp(20);
        int i11 = 0;
        TabKt.TextDistanceFromLeadingIcon = Dp.constructor-impl((float)i6);
    }

    public static final void LeadingIconTab-wqdebIU(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        Object obj;
        boolean skipping;
        Object endRestartGroup;
        int i5;
        boolean traceInProgress2;
        int defaultsInvalid;
        int localContentColor;
        Object rememberComposableLambda;
        int $dirty;
        long $dirty4;
        int unbox-impl;
        boolean str2;
        int i2;
        Object traceInProgress;
        int i7;
        Object obj7;
        Object obj9;
        int i6;
        Object obj5;
        boolean z3;
        int i11;
        long l3;
        long l4;
        int i8;
        Object obj8;
        int i3;
        long l2;
        int str;
        boolean z;
        int i10;
        int i13;
        int $dirty2;
        int $dirty3;
        int i9;
        int changed2;
        boolean changed;
        long unselectedContentColor2;
        Composer $composer2;
        int modifier2;
        Object obj6;
        boolean z4;
        int i;
        int i4;
        int rippleOrFallbackImplementation-9IZ8Weo;
        boolean z2;
        Object obj2;
        Object obj3;
        Object obj4;
        long l;
        long obj29;
        int obj30;
        long obj31;
        Function2 obj33;
        androidx.compose.runtime.internal.ComposableLambda obj34;
        Object obj35;
        int obj36;
        final int i49 = obj37;
        final int i50 = obj38;
        rememberComposableLambda = i12.startRestartGroup(-777316544);
        ComposerKt.sourceInformation(rememberComposableLambda, "C(LeadingIconTab)P(5,4,7,1,3!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)164@7036L7,171@7399L76,173@7551L950,173@7481L1020:Tab.kt#uh7d8r");
        $dirty = obj37;
        if (i50 & 1 != 0) {
            $dirty |= 6;
            str2 = selected;
        } else {
            if (i49 & 6 == 0) {
                i2 = rememberComposableLambda.changed(selected) ? 4 : 2;
                $dirty |= i2;
            } else {
                str2 = selected;
            }
        }
        if (i50 & 2 != 0) {
            $dirty |= 48;
            traceInProgress = onClick;
        } else {
            if (i49 & 48 == 0) {
                i7 = rememberComposableLambda.changedInstance(onClick) ? 32 : 16;
                $dirty |= i7;
            } else {
                traceInProgress = onClick;
            }
        }
        if (i50 & 4 != 0) {
            $dirty |= 384;
            obj7 = text;
        } else {
            if (i49 & 384 == 0) {
                i6 = rememberComposableLambda.changedInstance(text) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj7 = text;
            }
        }
        if (i50 & 8 != 0) {
            $dirty |= 3072;
            obj5 = icon;
        } else {
            if (i49 & 3072 == 0) {
                i11 = rememberComposableLambda.changedInstance(icon) ? 2048 : 1024;
                $dirty |= i11;
            } else {
                obj5 = icon;
            }
        }
        i8 = i50 & 16;
        if (i8 != 0) {
            $dirty |= 24576;
            obj8 = modifier;
        } else {
            if (i49 & 24576 == 0) {
                i3 = rememberComposableLambda.changed(modifier) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                obj8 = modifier;
            }
        }
        str = i50 & 32;
        int i44 = 196608;
        if (str != null) {
            $dirty |= i44;
            z = enabled;
        } else {
            if (i44 &= i49 == 0) {
                i10 = rememberComposableLambda.changed(enabled) ? 131072 : 65536;
                $dirty |= i10;
            } else {
                z = enabled;
            }
        }
        if (i46 &= i49 == 0) {
            if (i50 & 64 == 0) {
                i13 = rememberComposableLambda.changed(selectedContentColor) ? 1048576 : 524288;
            } else {
                unselectedContentColor2 = selectedContentColor;
            }
            $dirty |= i13;
        } else {
            unselectedContentColor2 = selectedContentColor;
        }
        if (i47 &= i49 == 0) {
            if (i50 & 128 == 0) {
                obj36 = $dirty;
                i9 = rememberComposableLambda.changed(interactionSource) ? 8388608 : 4194304;
            } else {
                obj36 = $dirty;
                $dirty4 = interactionSource;
            }
            $dirty2 = obj36 | i9;
        } else {
            $dirty4 = interactionSource;
            $dirty2 = obj36;
        }
        int i15 = i50 & 256;
        int i52 = 100663296;
        if (i15 != 0) {
            $dirty2 |= i52;
            i = i15;
            obj = $changed;
        } else {
            if (i49 & i52 == 0) {
                i = i15;
                i4 = rememberComposableLambda.changed($changed) ? 67108864 : 33554432;
                $dirty2 |= i4;
            } else {
                i = i15;
                obj = $changed;
            }
        }
        if ($dirty2 & rippleOrFallbackImplementation-9IZ8Weo == 38347922) {
            if (!rememberComposableLambda.getSkipping()) {
                rememberComposableLambda.startDefaults();
                int i21 = -29360129;
                str2 = -3670017;
                if (i49 & 1 != 0) {
                    if (rememberComposableLambda.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (str != null) {
                            z = defaultsInvalid;
                        }
                        if (i50 & 64 != 0) {
                            i8 = 6;
                            str = 0;
                            obj36 = i21;
                            ComposerKt.sourceInformationMarkerStart(rememberComposableLambda, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(rememberComposableLambda);
                            unbox-impl = (Color)rememberComposableLambda.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
                            $dirty2 &= rippleOrFallbackImplementation-9IZ8Weo;
                        } else {
                            obj36 = i21;
                            unbox-impl = unselectedContentColor2;
                        }
                        if (i50 & 128 != 0) {
                            unselectedContentColor2 = unbox-impl;
                            $dirty2 &= obj36;
                        } else {
                            unselectedContentColor2 = interactionSource;
                        }
                        if (i != 0) {
                            obj6 = obj8;
                            l4 = l;
                            i = i5;
                            z2 = z;
                        } else {
                            obj6 = obj8;
                            l4 = l;
                            i = $changed;
                            z2 = z;
                        }
                    } else {
                        rememberComposableLambda.skipToGroupEnd();
                        if (i50 & 64 != 0) {
                            $dirty2 &= str2;
                        }
                        if (i50 & 128 != 0) {
                            i = $changed;
                            $dirty2 = i5;
                            z2 = z;
                            unbox-impl = unselectedContentColor2;
                            obj6 = obj8;
                            l4 = interactionSource;
                        } else {
                            i = $changed;
                            z2 = z;
                            unbox-impl = unselectedContentColor2;
                            obj6 = obj8;
                            l4 = interactionSource;
                        }
                    }
                } else {
                }
                rememberComposableLambda.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777316544, $dirty2, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:167)");
                }
                obj33 = rememberComposableLambda;
                obj30 = i51;
                Composer composer = obj33;
                TabKt.LeadingIconTab.1 anon = new TabKt.LeadingIconTab.1(obj6, selected, i, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, obj30, unbox-impl, unselectedContentColor, obj33, i17 |= 6), z2, traceInProgress, obj5, obj7);
                obj35 = composer;
                obj31 = l4;
                TabKt.TabTransition-Klgx-Pg(unbox-impl, obj30, obj31, unselectedContentColor, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-429037564, true, anon, composer, 54));
                $composer2 = obj35;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = skipping;
                l3 = unbox-impl;
                obj9 = obj6;
                z3 = z2;
                modifier2 = $dirty2;
                $dirty3 = i;
            } else {
                rememberComposableLambda.skipToGroupEnd();
                obj9 = obj8;
                z3 = z;
                l3 = unselectedContentColor2;
                l2 = interactionSource;
                $composer2 = rememberComposableLambda;
                modifier2 = $dirty2;
                $dirty3 = $changed;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj33 = $composer2;
            endRestartGroup = new TabKt.LeadingIconTab.2(selected, onClick, text, icon, obj9, z3, l3, obj8, l2, z, $dirty3, i49, i50);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj33 = $composer2;
        }
    }

    public static final void Tab-bogVsAg(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object i3;
        Object obj;
        int $dirty4;
        int defaultsInvalid;
        int unbox-impl;
        int $dirty2;
        long $dirty;
        int $dirty3;
        int i10;
        Object obj2;
        int i;
        Object unselectedContentColor2;
        int i8;
        long l4;
        Object i15;
        boolean z2;
        boolean z;
        long l3;
        int i16;
        androidx.compose.runtime.internal.ComposableLambda i14;
        int i12;
        long $composer2;
        boolean i2;
        boolean traceInProgress;
        int i6;
        long str;
        int i13;
        int i9;
        int changed;
        long l;
        Composer composer;
        int modifier2;
        Object obj3;
        int changed2;
        boolean i7;
        int i4;
        int i5;
        int i17;
        androidx.compose.foundation.Indication rippleOrFallbackImplementation-9IZ8Weo;
        boolean z3;
        int i18;
        Function0 function0;
        Function3 function3;
        long l2;
        int obj25;
        int obj26;
        long obj27;
        Composer obj29;
        int obj30;
        int obj31;
        final int i50 = obj34;
        final int i51 = obj35;
        Composer restartGroup = i11.startRestartGroup(-202735880);
        ComposerKt.sourceInformation(restartGroup, "C(Tab)P(5,4,3,1,6:c#ui.graphics.Color,7:c#ui.graphics.Color,2)238@10306L7,246@10715L76,248@10867L600,248@10797L670:Tab.kt#uh7d8r");
        $dirty2 = obj34;
        if (i51 & 1 != 0) {
            $dirty2 |= 6;
            z = selected;
        } else {
            if (i50 & 6 == 0) {
                i10 = restartGroup.changed(selected) ? 4 : 2;
                $dirty2 |= i10;
            } else {
                z = selected;
            }
        }
        if (i51 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = onClick;
        } else {
            if (i50 & 48 == 0) {
                i = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i;
            } else {
                obj2 = onClick;
            }
        }
        i8 = i51 & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            i15 = modifier;
        } else {
            if (i50 & 384 == 0) {
                i16 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i16;
            } else {
                i15 = modifier;
            }
        }
        i14 = i51 & 8;
        if (i14 != 0) {
            $dirty2 |= 3072;
            i2 = enabled;
        } else {
            if (i50 & 3072 == 0) {
                i6 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                i2 = enabled;
            }
        }
        if (i50 & 24576 == 0) {
            if (i51 & 16 == 0) {
                changed = restartGroup.changed(selectedContentColor) ? 16384 : 8192;
            } else {
                str = selectedContentColor;
            }
            $dirty2 |= changed;
        } else {
            str = selectedContentColor;
        }
        if (i52 &= i50 == 0) {
            if (i51 & 32 == 0) {
                changed2 = restartGroup.changed(interactionSource) ? 131072 : 65536;
            } else {
                l = interactionSource;
            }
            $dirty2 |= changed2;
        } else {
            l = interactionSource;
        }
        i7 = i51 & 64;
        i4 = 1572864;
        if (i7 != 0) {
            $dirty2 |= i4;
            i3 = $composer;
        } else {
            if (i50 & i4 == 0) {
                i5 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                i3 = $composer;
            }
        }
        i17 = 12582912;
        if (i51 & 128 != 0) {
            $dirty2 |= i17;
            obj = $changed;
        } else {
            if (i50 & i17 == 0) {
                i17 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i17;
            } else {
                obj = $changed;
            }
        }
        final int obj33 = $dirty2;
        if ($dirty2 & rippleOrFallbackImplementation-9IZ8Weo == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i25 = -458753;
                int i55 = -57345;
                if (i50 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            i15 = defaultsInvalid;
                        }
                        if (i14 != 0) {
                            i2 = defaultsInvalid;
                        }
                        if (i51 & 16 != 0) {
                            i8 = 6;
                            i14 = 0;
                            i18 = i25;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            str = unbox-impl;
                            $dirty3 = obj2;
                        } else {
                            i18 = i25;
                            $dirty3 = obj33;
                        }
                        if (i51 & 32 != 0) {
                            $dirty3 &= i18;
                            l = obj2;
                        }
                        if (i7 != 0) {
                            obj3 = i15;
                            l4 = l2;
                            i4 = i24;
                            $dirty4 = $dirty3;
                            z3 = i2;
                            $dirty = str;
                            i12 = -202735880;
                        } else {
                            obj3 = i15;
                            l4 = l2;
                            i4 = $composer;
                            $dirty4 = $dirty3;
                            z3 = i2;
                            $dirty = str;
                            i12 = -202735880;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty4 = i51 & 16 != 0 ? obj33 & i55 : obj33;
                        if (i51 & 32 != 0) {
                            $dirty4 &= i25;
                        }
                        obj3 = i15;
                        l4 = l5;
                        i4 = $composer;
                        z3 = i2;
                        $dirty = str;
                        i12 = -202735880;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i12, $dirty4, -1, "androidx.compose.material3.Tab (Tab.kt:242)");
                }
                TabKt.Tab.3 anon = new TabKt.Tab.3(obj3, z, i4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, 0, $dirty, unselectedContentColor, restartGroup, i37 |= 6), z3, onClick, $changed);
                TabKt.TabTransition-Klgx-Pg($dirty, obj2, l4, i15, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-551896140, true, anon, restartGroup, 54));
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l3 = $dirty;
                $composer2 = l4;
                unselectedContentColor2 = obj3;
                i13 = i4;
                z2 = z3;
                modifier2 = $dirty4;
            } else {
                restartGroup.skipToGroupEnd();
                unselectedContentColor2 = i15;
                z2 = i2;
                l3 = str;
                i13 = $composer;
                modifier2 = obj33;
                composer = restartGroup;
                $composer2 = l2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = new TabKt.Tab.4(selected, onClick, unselectedContentColor2, z2, l3, i14, $composer2, i2, i13, $changed, i50, i51);
            endRestartGroup.updateScope((Function2)$dirty4);
        }
    }

    public static final void Tab-wqdebIU(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        int i3;
        Object obj5;
        boolean traceInProgress;
        int defaultsInvalid;
        int localContentColor;
        int i;
        int changed2;
        Composer restartGroup;
        int $dirty;
        long $dirty2;
        long l4;
        int i6;
        int unselectedContentColor2;
        boolean traceInProgress2;
        int i21;
        int i20;
        Object obj7;
        int str;
        androidx.compose.runtime.internal.ComposableLambda it;
        Object obj;
        boolean z2;
        int i14;
        Object obj2;
        int i16;
        boolean rememberComposableLambda;
        Object obj3;
        int i17;
        long l2;
        int i15;
        Object obj6;
        int i2;
        long l;
        int i11;
        Object obj8;
        int i4;
        int $dirty5;
        int $dirty4;
        int $dirty3;
        boolean z;
        int i18;
        Object obj4;
        int changed;
        int i19;
        int i5;
        int i13;
        int i8;
        int unbox-impl;
        long l3;
        int i7;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i9;
        int i10;
        int obj38;
        final int i59 = obj39;
        final int i60 = obj40;
        restartGroup = i12.startRestartGroup(-350627181);
        ComposerKt.sourceInformation(restartGroup, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)99@4483L7,121@5133L65,113@4964L234:Tab.kt#uh7d8r");
        $dirty = obj39;
        if (i60 & 1 != 0) {
            $dirty |= 6;
            z = selected;
        } else {
            if (i59 & 6 == 0) {
                i21 = restartGroup.changed(selected) ? 4 : 2;
                $dirty |= i21;
            } else {
                z = selected;
            }
        }
        if (i60 & 2 != 0) {
            $dirty |= 48;
            obj4 = onClick;
        } else {
            if (i59 & 48 == 0) {
                i20 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i20;
            } else {
                obj4 = onClick;
            }
        }
        int i46 = i60 & 4;
        if (i46 != 0) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i59 & 384 == 0) {
                i14 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i14;
            } else {
                obj = modifier;
            }
        }
        i16 = i60 & 8;
        if (i16 != 0) {
            $dirty |= 3072;
            rememberComposableLambda = enabled;
        } else {
            if (i59 & 3072 == 0) {
                i17 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i17;
            } else {
                rememberComposableLambda = enabled;
            }
        }
        i15 = i60 & 16;
        if (i15 != 0) {
            $dirty |= 24576;
            obj6 = text;
        } else {
            if (i59 & 24576 == 0) {
                i2 = restartGroup.changedInstance(text) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                obj6 = text;
            }
        }
        i11 = i60 & 32;
        int i54 = 196608;
        if (i11 != 0) {
            $dirty |= i54;
            obj8 = icon;
        } else {
            if (i54 &= i59 == 0) {
                i4 = restartGroup.changedInstance(icon) ? 131072 : 65536;
                $dirty |= i4;
            } else {
                obj8 = icon;
            }
        }
        if (i56 &= i59 == 0) {
            if (i60 & 64 == 0) {
                $dirty3 = $dirty;
                obj38 = i46;
                changed = restartGroup.changed(selectedContentColor) ? 1048576 : 524288;
            } else {
                $dirty3 = $dirty;
                obj38 = i46;
                $dirty2 = selectedContentColor;
            }
            $dirty3 |= changed;
        } else {
            $dirty5 = $dirty;
            obj38 = i46;
            $dirty2 = selectedContentColor;
        }
        i19 = 12582912;
        if (i59 & i19 == 0) {
            if (i60 & 128 == 0) {
                i3 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
            } else {
                l4 = interactionSource;
            }
            $dirty5 |= i3;
        } else {
            l4 = interactionSource;
        }
        int i22 = i60 & 256;
        int i61 = 100663296;
        if (i22 != 0) {
            $dirty5 |= i61;
            i13 = i22;
            obj5 = $changed;
        } else {
            if (i59 & i61 == 0) {
                i13 = i22;
                i8 = restartGroup.changed($changed) ? 67108864 : 33554432;
                $dirty5 |= i8;
            } else {
                i13 = i22;
                obj5 = $changed;
            }
        }
        if ($dirty5 & unbox-impl == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                unselectedContentColor2 = -29360129;
                str = -3670017;
                if (i59 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj38 != null) {
                            obj = defaultsInvalid;
                        }
                        if (i16 != 0) {
                            rememberComposableLambda = defaultsInvalid;
                        }
                        if (i15 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (i11 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (i60 & 64 != 0) {
                            i16 = 6;
                            i15 = 0;
                            obj38 = unselectedContentColor2;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            unbox-impl = (Color)restartGroup.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
                            $dirty5 &= str;
                        } else {
                            obj38 = unselectedContentColor2;
                            unbox-impl = selectedContentColor;
                        }
                        if (i60 & 128 != 0) {
                            unselectedContentColor2 = unbox-impl;
                            $dirty5 &= obj38;
                        } else {
                            unselectedContentColor2 = interactionSource;
                        }
                        if (i13 != 0) {
                            i7 = i24;
                            i5 = rememberComposableLambda;
                            i13 = unbox-impl;
                            i = -350627181;
                            l3 = unselectedContentColor2;
                        } else {
                            i7 = $changed;
                            i5 = rememberComposableLambda;
                            i13 = unbox-impl;
                            i = -350627181;
                            l3 = unselectedContentColor2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i60 & 64 != 0) {
                            $dirty5 &= str;
                        }
                        if (i60 & 128 != 0) {
                            i13 = selectedContentColor;
                            l3 = interactionSource;
                            i7 = $changed;
                            $dirty5 = i27;
                            i5 = rememberComposableLambda;
                            i = -350627181;
                        } else {
                            i13 = selectedContentColor;
                            l3 = interactionSource;
                            i7 = $changed;
                            i5 = rememberComposableLambda;
                            i = -350627181;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i, $dirty5, -1, "androidx.compose.material3.Tab (Tab.kt:102)");
                }
                restartGroup.startReplaceGroup(79583089);
                ComposerKt.sourceInformation(restartGroup, "*105@4702L247");
                int i29 = 54;
                int i37 = 1;
                if (obj6 == null) {
                    it = 0;
                } else {
                    Object obj10 = obj6;
                    i16 = 0;
                    TabKt.Tab.styledText.1.1 anon2 = new TabKt.Tab.styledText.1.1(obj6);
                    it = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                TabKt.Tab.1 anon = new TabKt.Tab.1(it, obj8);
                i19 = obj;
                TabKt.Tab-bogVsAg(z, obj4, i19, i5, i13, unbox-impl, l3, obj21, i7, (Function3)ComposableLambdaKt.rememberComposableLambda(1540996038, i37, anon, restartGroup, i29), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj6;
                obj3 = obj8;
                i18 = $dirty5;
                obj7 = i19;
                z2 = i5;
                l2 = i13;
                l = l3;
                $dirty4 = i7;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj7 = obj;
                z2 = rememberComposableLambda;
                obj2 = obj6;
                obj3 = obj8;
                i18 = $dirty5;
                l2 = selectedContentColor;
                l = interactionSource;
                $dirty4 = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TabKt.Tab.2(selected, onClick, obj7, z2, obj2, obj3, l2, obj6, l, obj8, $dirty4, i59, i60);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        int traceInProgress2;
        int i10;
        Object valueOf;
        Object $changed$iv;
        int $dirty;
        Integer valueOf2;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv;
        int i16;
        int i7;
        boolean materializeModifier2;
        boolean traceInProgress;
        int i21;
        int valueOf3;
        Composer composer3;
        int factory$iv$iv;
        Composer composer2;
        int valueOf4;
        Integer maybeCachedBoxMeasurePolicy;
        int str;
        int currentCompositionLocalMap3;
        int $i$a$LayoutBoxKt$Box$1$iv;
        Composer composer;
        Object currentCompositionLocalMap2;
        int materializeModifier;
        androidx.compose.ui.layout.MeasurePolicy currentCompositeKeyHash2;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Modifier materializeModifier3;
        int i15;
        int i6;
        int i18;
        int i20;
        Composer composer7;
        int i25;
        int i;
        Composer composer4;
        int i19;
        Function0 factory$iv$iv2;
        int $dirty2;
        int i11;
        int i23;
        int i5;
        androidx.compose.ui.Modifier.Companion companion;
        int i4;
        int i17;
        int i13;
        int i3;
        int currentCompositeKeyHash;
        Object $composer2;
        int i9;
        Object obj;
        Function0 factory$iv$iv$iv2;
        int i12;
        int i14;
        Composer composer5;
        int i22;
        int i8;
        int i24;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer6;
        int i2;
        int obj52;
        final Object obj2 = text;
        final Object obj3 = icon;
        final int i26 = $changed;
        traceInProgress2 = 514131524;
        $changed$iv = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation($changed$iv, "C(TabBaselineLayout)P(1)314@13233L2042,307@12989L2286:Tab.kt#uh7d8r");
        factory$iv$iv = 4;
        if (i26 & 6 == 0) {
            i16 = $changed$iv.changedInstance(obj2) ? factory$iv$iv : 2;
            $dirty |= i16;
        }
        currentCompositionLocalMap3 = 32;
        if (i26 & 48 == 0) {
            i7 = $changed$iv.changedInstance(obj3) ? currentCompositionLocalMap3 : 16;
            $dirty |= i7;
        }
        if ($dirty & 19 == 18) {
            if (!$changed$iv.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:306)");
                }
                ComposerKt.sourceInformationMarkerStart($changed$iv, 370960155, "CC(remember):Tab.kt#9igjgp");
                int i57 = 0;
                i10 = $dirty & 14 == factory$iv$iv ? i21 : i57;
                if ($dirty & 112 == currentCompositionLocalMap3) {
                } else {
                    i21 = i57;
                }
                Composer composer8 = $changed$iv;
                int i50 = 0;
                Object rememberedValue4 = composer8.rememberedValue();
                int i63 = 0;
                if (i10 |= i21 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        currentCompositeKeyHash2 = 0;
                        anon = new TabKt.TabBaselineLayout.2.1(obj2, obj3);
                        composer8.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($changed$iv);
                int i30 = i57;
                valueOf3 = 0;
                currentCompositionLocalMap3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, currentCompositionLocalMap3);
                materializeModifier = Modifier.Companion;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($changed$iv, i57);
                i59 |= 6;
                Function0 function0 = constructor;
                i15 = 0;
                str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, str);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $changed$iv.startReusableNode();
                if ($changed$iv.getInserting()) {
                    $changed$iv.createNode(function0);
                } else {
                    factory$iv$iv = function0;
                    $changed$iv.useNode();
                }
                i6 = i30;
                Composer constructor-impl = Updater.constructor-impl($changed$iv);
                int i70 = 0;
                composer4 = $changed$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, $changed$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i = 0;
                Composer composer10 = constructor-impl;
                int i71 = 0;
                if (!composer10.getInserting()) {
                    $dirty2 = $dirty;
                    i11 = valueOf3;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer10;
                    }
                } else {
                    $dirty2 = $dirty;
                    i11 = valueOf3;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($changed$iv, (Modifier)materializeModifier), ComposeUiNode.Companion.getSetModifier());
                $changed$iv = composer4;
                i25 = i32;
                ComposerKt.sourceInformationMarkerStart($changed$iv, 1248753480, "C:Tab.kt#uh7d8r");
                $changed$iv.startReplaceGroup(871566271);
                ComposerKt.sourceInformation($changed$iv, "309@13038L85");
                valueOf = "C73@3429L9:Box.kt#2w3rfo";
                materializeModifier2 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i19 = valueOf2;
                if (obj2 != null) {
                    factory$iv$iv2 = factory$iv$iv;
                    i5 = $i$a$LayoutBoxKt$Box$1$iv;
                    companion = materializeModifier;
                    i4 = currentCompositeKeyHash2;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "text"), TabKt.HorizontalTextPadding, 0, 2, 0);
                    ComposerKt.sourceInformationMarkerStart($changed$iv, 733328855, materializeModifier2);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i66 = 0;
                    i20 = i53;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i66);
                    i13 = 0;
                    i3 = i60;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, currentCompositionLocalMap3);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($changed$iv, 0);
                    currentCompositionLocalMap2 = $changed$iv.getCurrentCompositionLocalMap();
                    $composer2 = topStart2;
                    obj = padding-VpY3zN4$default;
                    Function0 function03 = constructor3;
                    i9 = 0;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, str);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $changed$iv.startReusableNode();
                    if ($changed$iv.getInserting()) {
                        $changed$iv.createNode(function03);
                    } else {
                        factory$iv$iv$iv = function03;
                        $changed$iv.useNode();
                    }
                    factory$iv$iv$iv2 = factory$iv$iv$iv;
                    Composer constructor-impl2 = Updater.constructor-impl($changed$iv);
                    int i75 = 0;
                    i22 = i66;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i78 = 0;
                    Composer composer12 = constructor-impl2;
                    int i79 = 0;
                    if (!composer12.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap2;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer12;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap2;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier($changed$iv, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = $changed$iv;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, valueOf);
                    currentCompositeKeyHash2 = BoxScopeInstance.INSTANCE;
                    i77 |= 6;
                    i8 = 0;
                    i24 = i45;
                    i2 = i62;
                    $i$a$LayoutBoxKt$Box$1$iv = composer5;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 719667646, "C309@13115L6:Tab.kt#uh7d8r");
                    obj2.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf($dirty2 & 14));
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    $changed$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                } else {
                    factory$iv$iv2 = factory$iv$iv;
                    i5 = $i$a$LayoutBoxKt$Box$1$iv;
                    companion = materializeModifier;
                    i4 = currentCompositeKeyHash2;
                }
                $changed$iv.endReplaceGroup();
                $changed$iv.startReplaceGroup(871570579);
                ComposerKt.sourceInformation($changed$iv, "312@13174L41");
                if (obj3 != null) {
                    Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                    valueOf4 = 6;
                    $i$a$LayoutBoxKt$Box$1$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, 733328855, materializeModifier2);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i23 = 0;
                    i17 = topStart;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, currentCompositionLocalMap3);
                    obj52 = currentCompositeKeyHash3;
                    i13 = layoutId;
                    Function0 function02 = constructor2;
                    i18 = 0;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, str);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $changed$iv.startReusableNode();
                    if ($changed$iv.getInserting()) {
                        $changed$iv.createNode(function02);
                    } else {
                        factory$iv$iv$iv3 = function02;
                        $changed$iv.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl($changed$iv);
                    int i69 = 0;
                    $composer2 = $changed$iv;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, $changed$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i73 = 0;
                    Composer composer11 = constructor-impl3;
                    int i74 = 0;
                    if (!composer11.getInserting()) {
                        factory$iv$iv$iv2 = factory$iv$iv$iv3;
                        i12 = valueOf4;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(obj52))) {
                            composer11.updateRememberedValue(Integer.valueOf(obj52));
                            constructor-impl3.apply(Integer.valueOf(obj52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer11;
                        }
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv3;
                        i12 = valueOf4;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($changed$iv, layoutId), ComposeUiNode.Companion.getSetModifier());
                    $dirty = $composer2;
                    factory$iv$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, valueOf);
                    i56 |= 6;
                    composer7 = $dirty;
                    i = 0;
                    i3 = iNSTANCE;
                    i9 = i38;
                    ComposerKt.sourceInformationMarkerStart($dirty, 719758910, "C312@13207L6:Tab.kt#uh7d8r");
                    obj3.invoke($dirty, Integer.valueOf(i34 &= 14));
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    $composer2 = $changed$iv;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $changed$iv.skipToGroupEnd();
                composer4 = $changed$iv;
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            $changed$iv = new TabKt.TabBaselineLayout.3(obj2, obj3, i26);
            endRestartGroup.updateScope((Function2)$changed$iv);
        }
    }

    private static final void TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int transitionAnimation;
        long l4;
        int $dirty2;
        long l3;
        long l2;
        int i3;
        int i11;
        boolean z2;
        Object invoke;
        int $changed$iv$iv;
        boolean changed;
        int i;
        long l5;
        int i4;
        long l;
        Color box-impl;
        int i6;
        int i7;
        boolean skipping;
        boolean traceInProgress5;
        int i8;
        boolean traceInProgress3;
        Object $i$f$cache;
        String str;
        int i9;
        int i10;
        Transition transition;
        int i2;
        int i12;
        boolean traceInProgress2;
        int $dirty;
        Transition transition2;
        androidx.compose.ui.graphics.colorspace.ColorSpace $composer2;
        Object traceInProgress4;
        boolean z;
        boolean invalid$iv$iv;
        int i5;
        int $changed$iv$iv2;
        boolean traceInProgress;
        final Object obj2 = $changed;
        final int i30 = obj35;
        transitionAnimation = 735731848;
        final Composer restartGroup = obj34.startRestartGroup(transitionAnimation);
        ComposerKt.sourceInformation(restartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)280@11898L26,282@11961L548,297@12514L77:Tab.kt#uh7d8r");
        i = 2;
        if (i30 & 6 == 0) {
            i3 = restartGroup.changed(activeColor) ? 4 : i;
            $dirty2 |= i3;
        } else {
            l5 = activeColor;
        }
        if (i30 & 48 == 0) {
            i11 = restartGroup.changed(selected) ? 32 : 16;
            $dirty2 |= i11;
        } else {
            l = selected;
        }
        if (i30 & 384 == 0) {
            i6 = restartGroup.changed($composer) ? 256 : 128;
            $dirty2 |= i6;
        } else {
            z2 = $composer;
        }
        if (i30 & 3072 == 0) {
            i7 = restartGroup.changedInstance(obj2) ? 2048 : 1024;
            $dirty2 |= i7;
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(transitionAnimation, $dirty2, -1, "androidx.compose.material3.TabTransition (Tab.kt:279)");
                }
                Transition transition3 = TransitionKt.updateTransition(Boolean.valueOf(z2), 0, restartGroup, i32 &= 14, i);
                androidx.compose.material3.TabKt.TabTransition.color.2 iNSTANCE = TabKt.TabTransition.color.2.INSTANCE;
                i10 = 0;
                transition = transition3;
                i2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                Composer composer3 = restartGroup;
                int i51 = 0;
                composer3.startReplaceGroup(-1997025499);
                String str5 = "C:Tab.kt#uh7d8r";
                ComposerKt.sourceInformation(composer3, str5);
                transition2 = transition3;
                String transition4 = "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)";
                if (ComposerKt.isTraceInProgress()) {
                    $dirty = $dirty2;
                    ComposerKt.traceEventStart(-1997025499, i46 &= 112, -1, transition4);
                } else {
                    $dirty = $dirty2;
                }
                l3 = (Boolean)transition.getTargetState().booleanValue() ? l5 : l;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceGroup();
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(l3);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1918408083, "CC(remember):Transition.kt#9igjgp");
                changed = restartGroup.changed(colorSpace-impl);
                Composer composer = restartGroup;
                int i48 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i52 = 0;
                if (!changed) {
                    invalid$iv$iv = changed;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i5 = invalid$iv$iv2;
                        composer.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl));
                    } else {
                        invoke = rememberedValue;
                    }
                } else {
                    invalid$iv$iv = changed;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i49 = 57344;
                i25 |= i40;
                l = transition;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                int i53 = 0;
                Composer composer4 = composer5;
                $composer2 = colorSpace-impl;
                int colorSpace$iv = -1997025499;
                composer4.startReplaceGroup(colorSpace$iv);
                ComposerKt.sourceInformation(composer4, str5);
                if (ComposerKt.isTraceInProgress()) {
                    $changed$iv$iv2 = $changed$iv$iv;
                    ComposerKt.traceEventStart(colorSpace$iv, i41 &= 112, -1, transition4);
                } else {
                    $changed$iv$iv2 = $changed$iv$iv;
                }
                l2 = (Boolean)l.getCurrentState().booleanValue() ? l5 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                Composer composer2 = restartGroup;
                int i50 = 0;
                int it = -1997025499;
                composer2.startReplaceGroup(it);
                ComposerKt.sourceInformation(composer2, str5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(it, i26 &= 112, -1, transition4);
                }
                l4 = (Boolean)l.getTargetState().booleanValue() ? l5 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(TabKt.TabTransition_Klgx_Pg$lambda$2(TransitionKt.createTransitionAnimation(l, Color.box-impl(l2), Color.box-impl(l4), (FiniteAnimationSpec)(Function3)iNSTANCE.invoke(l.getSegment(), restartGroup, Integer.valueOf(i15 &= 112)), (TwoWayConverter)invoke, "ColorAnimation", restartGroup, i14 | i20)))), obj2, restartGroup, $stable |= i);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            transitionAnimation = new TabKt.TabTransition.1(l5, z2, selected, l5, $composer, obj2, i30);
            endRestartGroup.updateScope((Function2)transitionAnimation);
        }
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> $color$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (Color)$color$delegate.getValue().unbox-impl();
    }

    public static final void access$TabBaselineLayout(Function2 text, Function2 icon, Composer $composer, int $changed) {
        TabKt.TabBaselineLayout(text, icon, $composer, $changed);
    }

    public static final void access$TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2 content, Composer $composer, int $changed) {
        TabKt.TabTransition-Klgx-Pg(activeColor, inactiveColor, selected, content, $composer, $changed);
    }

    public static final long access$getIconDistanceFromBaseline$p() {
        return TabKt.IconDistanceFromBaseline;
    }

    public static final float access$getLargeTabHeight$p() {
        return TabKt.LargeTabHeight;
    }

    public static final float access$getSmallTabHeight$p() {
        return TabKt.SmallTabHeight;
    }

    public static final float access$getTextDistanceFromLeadingIcon$p() {
        return TabKt.TextDistanceFromLeadingIcon;
    }

    public static final void access$placeTextAndIcon(Placeable.PlacementScope $receiver, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        TabKt.placeTextAndIcon($receiver, density, textPlaceable, iconPlaceable, tabWidth, tabHeight, firstBaseline, lastBaseline);
    }

    public static final void access$placeTextOrIcon(Placeable.PlacementScope $receiver, Placeable textOrIconPlaceable, int tabHeight) {
        TabKt.placeTextOrIcon($receiver, textOrIconPlaceable, tabHeight);
    }

    public static final float getHorizontalTextPadding() {
        return TabKt.HorizontalTextPadding;
    }

    private static final void placeTextAndIcon(Placeable.PlacementScope $this$placeTextAndIcon, Density density, Placeable textPlaceable, Placeable iconPlaceable, int tabWidth, int tabHeight, int firstBaseline, int lastBaseline) {
        float singleLineTextBaselineWithIcon;
        final int i = firstBaseline;
        final int i2 = lastBaseline;
        singleLineTextBaselineWithIcon = i == i2 ? TabKt.SingleLineTextBaselineWithIcon : TabKt.DoubleLineTextBaselineWithIcon;
        Object obj = density;
        int i6 = 0;
        int i7 = 0;
        final int i12 = i4 - i8;
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, textPlaceable, i3 / 2, i12, 0, 4, 0);
        Placeable.PlacementScope.placeRelative$default($this$placeTextAndIcon, iconPlaceable, i5 / 2, i12 - i10, 0, 4, 0);
    }

    private static final void placeTextOrIcon(Placeable.PlacementScope $this$placeTextOrIcon, Placeable textOrIconPlaceable, int tabHeight) {
        Placeable.PlacementScope.placeRelative$default($this$placeTextOrIcon, textOrIconPlaceable, 0, i / 2, 0, 4, 0);
    }
}
