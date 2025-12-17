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
        Object obj2;
        boolean skipping;
        Object endRestartGroup;
        int i4;
        boolean traceInProgress2;
        int defaultsInvalid;
        int localContentColor;
        Object rememberComposableLambda;
        int $dirty2;
        long $dirty4;
        int unbox-impl;
        boolean str2;
        int i;
        Object traceInProgress;
        int i6;
        Object obj4;
        Object obj6;
        int i9;
        Object obj9;
        boolean z;
        int i2;
        long l3;
        long l4;
        int i8;
        Object obj5;
        int i3;
        long l;
        int str;
        boolean z2;
        int i7;
        int i11;
        int $dirty3;
        int $dirty;
        int i5;
        int changed;
        boolean changed2;
        long unselectedContentColor2;
        Composer $composer2;
        int modifier2;
        Object obj3;
        boolean z3;
        int i13;
        int i10;
        int rippleOrFallbackImplementation-9IZ8Weo;
        boolean z4;
        Object obj8;
        Object obj7;
        Object obj;
        long l2;
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
        $dirty2 = obj37;
        if (i50 & 1 != 0) {
            $dirty2 |= 6;
            str2 = selected;
        } else {
            if (i49 & 6 == 0) {
                i = rememberComposableLambda.changed(selected) ? 4 : 2;
                $dirty2 |= i;
            } else {
                str2 = selected;
            }
        }
        if (i50 & 2 != 0) {
            $dirty2 |= 48;
            traceInProgress = onClick;
        } else {
            if (i49 & 48 == 0) {
                i6 = rememberComposableLambda.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                traceInProgress = onClick;
            }
        }
        if (i50 & 4 != 0) {
            $dirty2 |= 384;
            obj4 = text;
        } else {
            if (i49 & 384 == 0) {
                i9 = rememberComposableLambda.changedInstance(text) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj4 = text;
            }
        }
        if (i50 & 8 != 0) {
            $dirty2 |= 3072;
            obj9 = icon;
        } else {
            if (i49 & 3072 == 0) {
                i2 = rememberComposableLambda.changedInstance(icon) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                obj9 = icon;
            }
        }
        i8 = i50 & 16;
        if (i8 != 0) {
            $dirty2 |= 24576;
            obj5 = modifier;
        } else {
            if (i49 & 24576 == 0) {
                i3 = rememberComposableLambda.changed(modifier) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                obj5 = modifier;
            }
        }
        str = i50 & 32;
        int i44 = 196608;
        if (str != null) {
            $dirty2 |= i44;
            z2 = enabled;
        } else {
            if (i44 &= i49 == 0) {
                i7 = rememberComposableLambda.changed(enabled) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                z2 = enabled;
            }
        }
        if (i46 &= i49 == 0) {
            if (i50 & 64 == 0) {
                i11 = rememberComposableLambda.changed(selectedContentColor) ? 1048576 : 524288;
            } else {
                unselectedContentColor2 = selectedContentColor;
            }
            $dirty2 |= i11;
        } else {
            unselectedContentColor2 = selectedContentColor;
        }
        if (i47 &= i49 == 0) {
            if (i50 & 128 == 0) {
                obj36 = $dirty2;
                i5 = rememberComposableLambda.changed(interactionSource) ? 8388608 : 4194304;
            } else {
                obj36 = $dirty2;
                $dirty4 = interactionSource;
            }
            $dirty3 = obj36 | i5;
        } else {
            $dirty4 = interactionSource;
            $dirty3 = obj36;
        }
        int i15 = i50 & 256;
        int i52 = 100663296;
        if (i15 != 0) {
            $dirty3 |= i52;
            i13 = i15;
            obj2 = $changed;
        } else {
            if (i49 & i52 == 0) {
                i13 = i15;
                i10 = rememberComposableLambda.changed($changed) ? 67108864 : 33554432;
                $dirty3 |= i10;
            } else {
                i13 = i15;
                obj2 = $changed;
            }
        }
        if ($dirty3 & rippleOrFallbackImplementation-9IZ8Weo == 38347922) {
            if (!rememberComposableLambda.getSkipping()) {
                rememberComposableLambda.startDefaults();
                int i21 = -29360129;
                str2 = -3670017;
                if (i49 & 1 != 0) {
                    if (rememberComposableLambda.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (str != null) {
                            z2 = defaultsInvalid;
                        }
                        if (i50 & 64 != 0) {
                            i8 = 6;
                            str = 0;
                            obj36 = i21;
                            ComposerKt.sourceInformationMarkerStart(rememberComposableLambda, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(rememberComposableLambda);
                            unbox-impl = (Color)rememberComposableLambda.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
                            $dirty3 &= rippleOrFallbackImplementation-9IZ8Weo;
                        } else {
                            obj36 = i21;
                            unbox-impl = unselectedContentColor2;
                        }
                        if (i50 & 128 != 0) {
                            unselectedContentColor2 = unbox-impl;
                            $dirty3 &= obj36;
                        } else {
                            unselectedContentColor2 = interactionSource;
                        }
                        if (i13 != 0) {
                            obj3 = obj5;
                            l4 = l2;
                            i13 = i4;
                            z4 = z2;
                        } else {
                            obj3 = obj5;
                            l4 = l2;
                            i13 = $changed;
                            z4 = z2;
                        }
                    } else {
                        rememberComposableLambda.skipToGroupEnd();
                        if (i50 & 64 != 0) {
                            $dirty3 &= str2;
                        }
                        if (i50 & 128 != 0) {
                            i13 = $changed;
                            $dirty3 = i4;
                            z4 = z2;
                            unbox-impl = unselectedContentColor2;
                            obj3 = obj5;
                            l4 = interactionSource;
                        } else {
                            i13 = $changed;
                            z4 = z2;
                            unbox-impl = unselectedContentColor2;
                            obj3 = obj5;
                            l4 = interactionSource;
                        }
                    }
                } else {
                }
                rememberComposableLambda.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777316544, $dirty3, -1, "androidx.compose.material3.LeadingIconTab (Tab.kt:167)");
                }
                obj33 = rememberComposableLambda;
                obj30 = i51;
                Composer composer = obj33;
                TabKt.LeadingIconTab.1 anon = new TabKt.LeadingIconTab.1(obj3, selected, i13, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, obj30, unbox-impl, unselectedContentColor, obj33, i17 |= 6), z4, traceInProgress, obj9, obj4);
                obj35 = composer;
                obj31 = l4;
                TabKt.TabTransition-Klgx-Pg(unbox-impl, obj30, obj31, unselectedContentColor, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-429037564, true, anon, composer, 54));
                $composer2 = obj35;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l = skipping;
                l3 = unbox-impl;
                obj6 = obj3;
                z = z4;
                modifier2 = $dirty3;
                $dirty = i13;
            } else {
                rememberComposableLambda.skipToGroupEnd();
                obj6 = obj5;
                z = z2;
                l3 = unselectedContentColor2;
                l = interactionSource;
                $composer2 = rememberComposableLambda;
                modifier2 = $dirty3;
                $dirty = $changed;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj33 = $composer2;
            endRestartGroup = new TabKt.LeadingIconTab.2(selected, onClick, text, icon, obj6, z, l3, obj5, l, z2, $dirty, i49, i50);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj33 = $composer2;
        }
    }

    public static final void Tab-bogVsAg(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        Object i6;
        Object obj;
        int $dirty;
        int defaultsInvalid;
        int unbox-impl;
        int $dirty2;
        long $dirty4;
        int $dirty3;
        int i7;
        Object obj3;
        int i12;
        Object unselectedContentColor2;
        int i;
        long l4;
        Object i9;
        boolean z2;
        boolean z3;
        long l2;
        int i5;
        androidx.compose.runtime.internal.ComposableLambda i4;
        int i15;
        long $composer2;
        boolean i2;
        boolean traceInProgress;
        int i10;
        long str;
        int i13;
        int i8;
        int changed;
        long l;
        Composer composer;
        int modifier2;
        Object obj2;
        int changed2;
        boolean i18;
        int i17;
        int i3;
        int i14;
        androidx.compose.foundation.Indication rippleOrFallbackImplementation-9IZ8Weo;
        boolean z;
        int i16;
        Function0 function0;
        Function3 function3;
        long l3;
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
            z3 = selected;
        } else {
            if (i50 & 6 == 0) {
                i7 = restartGroup.changed(selected) ? 4 : 2;
                $dirty2 |= i7;
            } else {
                z3 = selected;
            }
        }
        if (i51 & 2 != 0) {
            $dirty2 |= 48;
            obj3 = onClick;
        } else {
            if (i50 & 48 == 0) {
                i12 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i12;
            } else {
                obj3 = onClick;
            }
        }
        i = i51 & 4;
        if (i != 0) {
            $dirty2 |= 384;
            i9 = modifier;
        } else {
            if (i50 & 384 == 0) {
                i5 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i5;
            } else {
                i9 = modifier;
            }
        }
        i4 = i51 & 8;
        if (i4 != 0) {
            $dirty2 |= 3072;
            i2 = enabled;
        } else {
            if (i50 & 3072 == 0) {
                i10 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i10;
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
        i18 = i51 & 64;
        i17 = 1572864;
        if (i18 != 0) {
            $dirty2 |= i17;
            i6 = $composer;
        } else {
            if (i50 & i17 == 0) {
                i3 = restartGroup.changed($composer) ? 1048576 : 524288;
                $dirty2 |= i3;
            } else {
                i6 = $composer;
            }
        }
        i14 = 12582912;
        if (i51 & 128 != 0) {
            $dirty2 |= i14;
            obj = $changed;
        } else {
            if (i50 & i14 == 0) {
                i14 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i14;
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
                        if (i != 0) {
                            i9 = defaultsInvalid;
                        }
                        if (i4 != 0) {
                            i2 = defaultsInvalid;
                        }
                        if (i51 & 16 != 0) {
                            i = 6;
                            i4 = 0;
                            i16 = i25;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            str = unbox-impl;
                            $dirty3 = obj3;
                        } else {
                            i16 = i25;
                            $dirty3 = obj33;
                        }
                        if (i51 & 32 != 0) {
                            $dirty3 &= i16;
                            l = obj3;
                        }
                        if (i18 != 0) {
                            obj2 = i9;
                            l4 = l3;
                            i17 = i24;
                            $dirty = $dirty3;
                            z = i2;
                            $dirty4 = str;
                            i15 = -202735880;
                        } else {
                            obj2 = i9;
                            l4 = l3;
                            i17 = $composer;
                            $dirty = $dirty3;
                            z = i2;
                            $dirty4 = str;
                            i15 = -202735880;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty = i51 & 16 != 0 ? obj33 & i55 : obj33;
                        if (i51 & 32 != 0) {
                            $dirty &= i25;
                        }
                        obj2 = i9;
                        l4 = l5;
                        i17 = $composer;
                        z = i2;
                        $dirty4 = str;
                        i15 = -202735880;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i15, $dirty, -1, "androidx.compose.material3.Tab (Tab.kt:242)");
                }
                TabKt.Tab.3 anon = new TabKt.Tab.3(obj2, z3, i17, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, 0, $dirty4, unselectedContentColor, restartGroup, i37 |= 6), z, onClick, $changed);
                TabKt.TabTransition-Klgx-Pg($dirty4, obj3, l4, i9, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-551896140, true, anon, restartGroup, 54));
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l2 = $dirty4;
                $composer2 = l4;
                unselectedContentColor2 = obj2;
                i13 = i17;
                z2 = z;
                modifier2 = $dirty;
            } else {
                restartGroup.skipToGroupEnd();
                unselectedContentColor2 = i9;
                z2 = i2;
                l2 = str;
                i13 = $composer;
                modifier2 = obj33;
                composer = restartGroup;
                $composer2 = l3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new TabKt.Tab.4(selected, onClick, unselectedContentColor2, z2, l2, i4, $composer2, i2, i13, $changed, i50, i51);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final void Tab-wqdebIU(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, long selectedContentColor, long unselectedContentColor, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        int i6;
        Object obj2;
        boolean traceInProgress;
        int defaultsInvalid;
        int localContentColor;
        int i;
        int changed2;
        Composer restartGroup;
        int $dirty3;
        long $dirty4;
        long l2;
        int i13;
        int unselectedContentColor2;
        boolean traceInProgress2;
        int i4;
        int i11;
        Object obj;
        int str;
        androidx.compose.runtime.internal.ComposableLambda it;
        Object obj5;
        boolean z2;
        int i9;
        Object obj3;
        int i7;
        boolean rememberComposableLambda;
        Object obj7;
        int i5;
        long l;
        int i14;
        Object obj4;
        int i10;
        long l3;
        int i19;
        Object obj6;
        int i20;
        int $dirty;
        int $dirty2;
        int $dirty5;
        boolean z;
        int i17;
        Object obj8;
        int changed;
        int i15;
        int i21;
        int i8;
        int i16;
        int unbox-impl;
        long l4;
        int i3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i2;
        int i18;
        int obj38;
        final int i59 = obj39;
        final int i60 = obj40;
        restartGroup = i12.startRestartGroup(-350627181);
        ComposerKt.sourceInformation(restartGroup, "C(Tab)P(5,4,3!1,7!1,6:c#ui.graphics.Color,8:c#ui.graphics.Color)99@4483L7,121@5133L65,113@4964L234:Tab.kt#uh7d8r");
        $dirty3 = obj39;
        if (i60 & 1 != 0) {
            $dirty3 |= 6;
            z = selected;
        } else {
            if (i59 & 6 == 0) {
                i4 = restartGroup.changed(selected) ? 4 : 2;
                $dirty3 |= i4;
            } else {
                z = selected;
            }
        }
        if (i60 & 2 != 0) {
            $dirty3 |= 48;
            obj8 = onClick;
        } else {
            if (i59 & 48 == 0) {
                i11 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty3 |= i11;
            } else {
                obj8 = onClick;
            }
        }
        int i46 = i60 & 4;
        if (i46 != 0) {
            $dirty3 |= 384;
            obj5 = modifier;
        } else {
            if (i59 & 384 == 0) {
                i9 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i9;
            } else {
                obj5 = modifier;
            }
        }
        i7 = i60 & 8;
        if (i7 != 0) {
            $dirty3 |= 3072;
            rememberComposableLambda = enabled;
        } else {
            if (i59 & 3072 == 0) {
                i5 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty3 |= i5;
            } else {
                rememberComposableLambda = enabled;
            }
        }
        i14 = i60 & 16;
        if (i14 != 0) {
            $dirty3 |= 24576;
            obj4 = text;
        } else {
            if (i59 & 24576 == 0) {
                i10 = restartGroup.changedInstance(text) ? 16384 : 8192;
                $dirty3 |= i10;
            } else {
                obj4 = text;
            }
        }
        i19 = i60 & 32;
        int i54 = 196608;
        if (i19 != 0) {
            $dirty3 |= i54;
            obj6 = icon;
        } else {
            if (i54 &= i59 == 0) {
                i20 = restartGroup.changedInstance(icon) ? 131072 : 65536;
                $dirty3 |= i20;
            } else {
                obj6 = icon;
            }
        }
        if (i56 &= i59 == 0) {
            if (i60 & 64 == 0) {
                $dirty5 = $dirty3;
                obj38 = i46;
                changed = restartGroup.changed(selectedContentColor) ? 1048576 : 524288;
            } else {
                $dirty5 = $dirty3;
                obj38 = i46;
                $dirty4 = selectedContentColor;
            }
            $dirty5 |= changed;
        } else {
            $dirty = $dirty3;
            obj38 = i46;
            $dirty4 = selectedContentColor;
        }
        i15 = 12582912;
        if (i59 & i15 == 0) {
            if (i60 & 128 == 0) {
                i6 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
            } else {
                l2 = interactionSource;
            }
            $dirty |= i6;
        } else {
            l2 = interactionSource;
        }
        int i22 = i60 & 256;
        int i61 = 100663296;
        if (i22 != 0) {
            $dirty |= i61;
            i8 = i22;
            obj2 = $changed;
        } else {
            if (i59 & i61 == 0) {
                i8 = i22;
                i16 = restartGroup.changed($changed) ? 67108864 : 33554432;
                $dirty |= i16;
            } else {
                i8 = i22;
                obj2 = $changed;
            }
        }
        if ($dirty & unbox-impl == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                unselectedContentColor2 = -29360129;
                str = -3670017;
                if (i59 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (obj38 != null) {
                            obj5 = defaultsInvalid;
                        }
                        if (i7 != 0) {
                            rememberComposableLambda = defaultsInvalid;
                        }
                        if (i14 != 0) {
                            obj4 = defaultsInvalid;
                        }
                        if (i19 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (i60 & 64 != 0) {
                            i7 = 6;
                            i14 = 0;
                            obj38 = unselectedContentColor2;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            unbox-impl = (Color)restartGroup.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
                            $dirty &= str;
                        } else {
                            obj38 = unselectedContentColor2;
                            unbox-impl = selectedContentColor;
                        }
                        if (i60 & 128 != 0) {
                            unselectedContentColor2 = unbox-impl;
                            $dirty &= obj38;
                        } else {
                            unselectedContentColor2 = interactionSource;
                        }
                        if (i8 != 0) {
                            i3 = i24;
                            i21 = rememberComposableLambda;
                            i8 = unbox-impl;
                            i = -350627181;
                            l4 = unselectedContentColor2;
                        } else {
                            i3 = $changed;
                            i21 = rememberComposableLambda;
                            i8 = unbox-impl;
                            i = -350627181;
                            l4 = unselectedContentColor2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i60 & 64 != 0) {
                            $dirty &= str;
                        }
                        if (i60 & 128 != 0) {
                            i8 = selectedContentColor;
                            l4 = interactionSource;
                            i3 = $changed;
                            $dirty = i27;
                            i21 = rememberComposableLambda;
                            i = -350627181;
                        } else {
                            i8 = selectedContentColor;
                            l4 = interactionSource;
                            i3 = $changed;
                            i21 = rememberComposableLambda;
                            i = -350627181;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i, $dirty, -1, "androidx.compose.material3.Tab (Tab.kt:102)");
                }
                restartGroup.startReplaceGroup(79583089);
                ComposerKt.sourceInformation(restartGroup, "*105@4702L247");
                int i29 = 54;
                int i37 = 1;
                if (obj4 == null) {
                    it = 0;
                } else {
                    Object obj10 = obj4;
                    i7 = 0;
                    TabKt.Tab.styledText.1.1 anon2 = new TabKt.Tab.styledText.1.1(obj4);
                    it = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                TabKt.Tab.1 anon = new TabKt.Tab.1(it, obj6);
                i15 = obj5;
                TabKt.Tab-bogVsAg(z, obj8, i15, i21, i8, unbox-impl, l4, obj21, i3, (Function3)ComposableLambdaKt.rememberComposableLambda(1540996038, i37, anon, restartGroup, i29), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj4;
                obj7 = obj6;
                i17 = $dirty;
                obj = i15;
                z2 = i21;
                l = i8;
                l3 = l4;
                $dirty2 = i3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                obj = obj5;
                z2 = rememberComposableLambda;
                obj3 = obj4;
                obj7 = obj6;
                i17 = $dirty;
                l = selectedContentColor;
                l3 = interactionSource;
                $dirty2 = $changed;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TabKt.Tab.2(selected, onClick, obj, z2, obj3, obj7, l, obj4, l3, obj6, $dirty2, i59, i60);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        int traceInProgress;
        int i2;
        Object valueOf;
        Object $changed$iv;
        int $dirty;
        Integer valueOf3;
        Function0 factory$iv$iv$iv;
        Function0 factory$iv$iv$iv3;
        int i15;
        int i7;
        boolean materializeModifier3;
        boolean traceInProgress2;
        int i12;
        int valueOf2;
        Composer composer3;
        int factory$iv$iv;
        Composer composer7;
        int valueOf4;
        Integer maybeCachedBoxMeasurePolicy;
        int str2;
        int currentCompositionLocalMap2;
        int str;
        Composer composer5;
        Object currentCompositionLocalMap;
        int materializeModifier2;
        androidx.compose.ui.layout.MeasurePolicy currentCompositeKeyHash2;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3;
        Modifier materializeModifier;
        int i3;
        int i;
        int i23;
        int i11;
        Composer composer4;
        int i25;
        int i14;
        Composer composer;
        int i13;
        Function0 factory$iv$iv2;
        int $dirty2;
        int i16;
        int i22;
        int i9;
        androidx.compose.ui.Modifier.Companion companion;
        int i10;
        int i4;
        int i8;
        int i19;
        int currentCompositeKeyHash;
        Object $composer2;
        int i21;
        Object obj;
        Function0 factory$iv$iv$iv2;
        int i17;
        int i5;
        Composer composer6;
        int i20;
        int i6;
        int i24;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer2;
        int i18;
        int obj52;
        final Object obj2 = text;
        final Object obj3 = icon;
        final int i26 = $changed;
        traceInProgress = 514131524;
        $changed$iv = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($changed$iv, "C(TabBaselineLayout)P(1)314@13233L2042,307@12989L2286:Tab.kt#uh7d8r");
        factory$iv$iv = 4;
        if (i26 & 6 == 0) {
            i15 = $changed$iv.changedInstance(obj2) ? factory$iv$iv : 2;
            $dirty |= i15;
        }
        currentCompositionLocalMap2 = 32;
        if (i26 & 48 == 0) {
            i7 = $changed$iv.changedInstance(obj3) ? currentCompositionLocalMap2 : 16;
            $dirty |= i7;
        }
        if ($dirty & 19 == 18) {
            if (!$changed$iv.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.TabBaselineLayout (Tab.kt:306)");
                }
                ComposerKt.sourceInformationMarkerStart($changed$iv, 370960155, "CC(remember):Tab.kt#9igjgp");
                int i57 = 0;
                i2 = $dirty & 14 == factory$iv$iv ? i12 : i57;
                if ($dirty & 112 == currentCompositionLocalMap2) {
                } else {
                    i12 = i57;
                }
                Composer composer8 = $changed$iv;
                int i50 = 0;
                Object rememberedValue4 = composer8.rememberedValue();
                int i63 = 0;
                if (i2 |= i12 == 0) {
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
                valueOf2 = 0;
                currentCompositionLocalMap2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, currentCompositionLocalMap2);
                materializeModifier2 = Modifier.Companion;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash($changed$iv, i57);
                i59 |= 6;
                Function0 function0 = constructor;
                i3 = 0;
                str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, str2);
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
                i = i30;
                Composer constructor-impl = Updater.constructor-impl($changed$iv);
                int i70 = 0;
                composer = $changed$iv;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, $changed$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i14 = 0;
                Composer composer10 = constructor-impl;
                int i71 = 0;
                if (!composer10.getInserting()) {
                    $dirty2 = $dirty;
                    i16 = valueOf2;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer10;
                    }
                } else {
                    $dirty2 = $dirty;
                    i16 = valueOf2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier($changed$iv, (Modifier)materializeModifier2), ComposeUiNode.Companion.getSetModifier());
                $changed$iv = composer;
                i25 = i32;
                ComposerKt.sourceInformationMarkerStart($changed$iv, 1248753480, "C:Tab.kt#uh7d8r");
                $changed$iv.startReplaceGroup(871566271);
                ComposerKt.sourceInformation($changed$iv, "309@13038L85");
                valueOf = "C73@3429L9:Box.kt#2w3rfo";
                materializeModifier3 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i13 = valueOf3;
                if (obj2 != null) {
                    factory$iv$iv2 = factory$iv$iv;
                    i9 = str;
                    companion = materializeModifier2;
                    i10 = currentCompositeKeyHash2;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "text"), TabKt.HorizontalTextPadding, 0, 2, 0);
                    ComposerKt.sourceInformationMarkerStart($changed$iv, 733328855, materializeModifier3);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i66 = 0;
                    i11 = i53;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i66);
                    i8 = 0;
                    i19 = i60;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, currentCompositionLocalMap2);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($changed$iv, 0);
                    currentCompositionLocalMap = $changed$iv.getCurrentCompositionLocalMap();
                    $composer2 = topStart2;
                    obj = padding-VpY3zN4$default;
                    Function0 function03 = constructor3;
                    i21 = 0;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, str2);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $changed$iv.startReusableNode();
                    if ($changed$iv.getInserting()) {
                        $changed$iv.createNode(function03);
                    } else {
                        factory$iv$iv$iv3 = function03;
                        $changed$iv.useNode();
                    }
                    factory$iv$iv$iv2 = factory$iv$iv$iv3;
                    Composer constructor-impl2 = Updater.constructor-impl($changed$iv);
                    int i75 = 0;
                    i20 = i66;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i78 = 0;
                    Composer composer12 = constructor-impl2;
                    int i79 = 0;
                    if (!composer12.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer5 = composer12;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier($changed$iv, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = $changed$iv;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, valueOf);
                    currentCompositeKeyHash2 = BoxScopeInstance.INSTANCE;
                    i77 |= 6;
                    i6 = 0;
                    i24 = i45;
                    i18 = i62;
                    str = composer6;
                    ComposerKt.sourceInformationMarkerStart(str, 719667646, "C309@13115L6:Tab.kt#uh7d8r");
                    obj2.invoke(str, Integer.valueOf($dirty2 & 14));
                    ComposerKt.sourceInformationMarkerEnd(str);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    $changed$iv.endNode();
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                } else {
                    factory$iv$iv2 = factory$iv$iv;
                    i9 = str;
                    companion = materializeModifier2;
                    i10 = currentCompositeKeyHash2;
                }
                $changed$iv.endReplaceGroup();
                $changed$iv.startReplaceGroup(871570579);
                ComposerKt.sourceInformation($changed$iv, "312@13174L41");
                if (obj3 != null) {
                    Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                    valueOf4 = 6;
                    str = 0;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, 733328855, materializeModifier3);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i22 = 0;
                    i4 = topStart;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -1323940314, currentCompositionLocalMap2);
                    obj52 = currentCompositeKeyHash3;
                    i8 = layoutId;
                    Function0 function02 = constructor2;
                    i23 = 0;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -692256719, str2);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $changed$iv.startReusableNode();
                    if ($changed$iv.getInserting()) {
                        $changed$iv.createNode(function02);
                    } else {
                        factory$iv$iv$iv = function02;
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
                        factory$iv$iv$iv2 = factory$iv$iv$iv;
                        i17 = valueOf4;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(obj52))) {
                            composer11.updateRememberedValue(Integer.valueOf(obj52));
                            constructor-impl3.apply(Integer.valueOf(obj52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer7 = composer11;
                        }
                    } else {
                        factory$iv$iv$iv2 = factory$iv$iv$iv;
                        i17 = valueOf4;
                    }
                    Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier($changed$iv, layoutId), ComposeUiNode.Companion.getSetModifier());
                    $dirty = $composer2;
                    factory$iv$iv = 0;
                    ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, valueOf);
                    i56 |= 6;
                    composer4 = $dirty;
                    i14 = 0;
                    i19 = iNSTANCE;
                    i21 = i38;
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
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $changed$iv.skipToGroupEnd();
                composer = $changed$iv;
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $changed$iv = new TabKt.TabBaselineLayout.3(obj2, obj3, i26);
            endRestartGroup.updateScope((Function2)$changed$iv);
        }
    }

    private static final void TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int transitionAnimation;
        long l2;
        int $dirty2;
        long l5;
        long l;
        int i5;
        int i6;
        boolean z2;
        Object invoke;
        int $changed$iv$iv2;
        boolean changed;
        int i;
        long l3;
        int i9;
        long l4;
        Color box-impl;
        int i8;
        int i2;
        boolean skipping;
        boolean traceInProgress5;
        int i4;
        boolean traceInProgress;
        Object $i$f$cache;
        String str;
        int i7;
        int i11;
        Transition transition2;
        int i3;
        int i10;
        boolean traceInProgress4;
        int $dirty;
        Transition transition;
        androidx.compose.ui.graphics.colorspace.ColorSpace $composer2;
        Object traceInProgress3;
        boolean z;
        boolean invalid$iv$iv;
        int i12;
        int $changed$iv$iv;
        boolean traceInProgress2;
        final Object obj2 = $changed;
        final int i30 = obj35;
        transitionAnimation = 735731848;
        final Composer restartGroup = obj34.startRestartGroup(transitionAnimation);
        ComposerKt.sourceInformation(restartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)280@11898L26,282@11961L548,297@12514L77:Tab.kt#uh7d8r");
        i = 2;
        if (i30 & 6 == 0) {
            i5 = restartGroup.changed(activeColor) ? 4 : i;
            $dirty2 |= i5;
        } else {
            l3 = activeColor;
        }
        if (i30 & 48 == 0) {
            i6 = restartGroup.changed(selected) ? 32 : 16;
            $dirty2 |= i6;
        } else {
            l4 = selected;
        }
        if (i30 & 384 == 0) {
            i8 = restartGroup.changed($composer) ? 256 : 128;
            $dirty2 |= i8;
        } else {
            z2 = $composer;
        }
        if (i30 & 3072 == 0) {
            i2 = restartGroup.changedInstance(obj2) ? 2048 : 1024;
            $dirty2 |= i2;
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(transitionAnimation, $dirty2, -1, "androidx.compose.material3.TabTransition (Tab.kt:279)");
                }
                Transition transition3 = TransitionKt.updateTransition(Boolean.valueOf(z2), 0, restartGroup, i32 &= 14, i);
                androidx.compose.material3.TabKt.TabTransition.color.2 iNSTANCE = TabKt.TabTransition.color.2.INSTANCE;
                i11 = 0;
                transition2 = transition3;
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                Composer composer3 = restartGroup;
                int i51 = 0;
                composer3.startReplaceGroup(-1997025499);
                String str5 = "C:Tab.kt#uh7d8r";
                ComposerKt.sourceInformation(composer3, str5);
                transition = transition3;
                String transition4 = "androidx.compose.material3.TabTransition.<anonymous> (Tab.kt:295)";
                if (ComposerKt.isTraceInProgress()) {
                    $dirty = $dirty2;
                    ComposerKt.traceEventStart(-1997025499, i46 &= 112, -1, transition4);
                } else {
                    $dirty = $dirty2;
                }
                l5 = (Boolean)transition2.getTargetState().booleanValue() ? l3 : l4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceGroup();
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(l5);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1918408083, "CC(remember):Transition.kt#9igjgp");
                changed = restartGroup.changed(colorSpace-impl);
                Composer composer = restartGroup;
                int i48 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i52 = 0;
                if (!changed) {
                    invalid$iv$iv = changed;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i12 = invalid$iv$iv2;
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
                l4 = transition2;
                i10 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                int i53 = 0;
                Composer composer4 = composer5;
                $composer2 = colorSpace-impl;
                int colorSpace$iv = -1997025499;
                composer4.startReplaceGroup(colorSpace$iv);
                ComposerKt.sourceInformation(composer4, str5);
                if (ComposerKt.isTraceInProgress()) {
                    $changed$iv$iv = $changed$iv$iv2;
                    ComposerKt.traceEventStart(colorSpace$iv, i41 &= 112, -1, transition4);
                } else {
                    $changed$iv$iv = $changed$iv$iv2;
                }
                l = (Boolean)l4.getCurrentState().booleanValue() ? l3 : selected;
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
                l2 = (Boolean)l4.getTargetState().booleanValue() ? l3 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.box-impl(TabKt.TabTransition_Klgx_Pg$lambda$2(TransitionKt.createTransitionAnimation(l4, Color.box-impl(l), Color.box-impl(l2), (FiniteAnimationSpec)(Function3)iNSTANCE.invoke(l4.getSegment(), restartGroup, Integer.valueOf(i15 &= 112)), (TwoWayConverter)invoke, "ColorAnimation", restartGroup, i14 | i20)))), obj2, restartGroup, $stable |= i);
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
            transitionAnimation = new TabKt.TabTransition.1(l3, z2, selected, l3, $composer, obj2, i30);
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
