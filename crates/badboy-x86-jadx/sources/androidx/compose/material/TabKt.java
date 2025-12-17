package androidx.compose.material;

import androidx.compose.animation.ColorVectorConverterKt;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingKt;
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
@Metadata(d1 = "\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u001a\u0082\u0001\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00142\u0011\u0010\u0015\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\u0008\u00162\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\u0008\u00162\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u001a\u008a\u0001\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00142\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\u0015\u0008\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u00162\u0015\u0008\u0002\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u00162\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001eH\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$\u001az\u0010\"\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u000c\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u00142\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00122\n\u0008\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020\u001e2\u001c\u0010%\u001a\u0018\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00100&¢\u0006\u0002\u0008\u0016¢\u0006\u0002\u0008(H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a7\u0010+\u001a\u00020\u00102\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u00162\u0013\u0010\u0017\u001a\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0014¢\u0006\u0002\u0008\u0016H\u0003¢\u0006\u0002\u0010,\u001a=\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u00122\u0011\u0010%\u001a\r\u0012\u0004\u0012\u00020\u00100\u0014¢\u0006\u0002\u0008\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001aD\u00102\u001a\u00020\u0010*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u0002072\u0006\u00109\u001a\u00020\u000b2\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020\u000bH\u0002\u001a\u001c\u0010=\u001a\u00020\u0010*\u0002032\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u000bH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0008\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000e\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006?²\u0006\n\u0010@\u001a\u00020\u001eX\u008a\u0084\u0002", d2 = {"DoubleLineTextBaselineWithIcon", "Landroidx/compose/ui/unit/Dp;", "F", "HorizontalTextPadding", "IconDistanceFromBaseline", "Landroidx/compose/ui/unit/TextUnit;", "J", "LargeTabHeight", "SingleLineTextBaselineWithIcon", "SmallTabHeight", "TabFadeInAnimationDelay", "", "TabFadeInAnimationDuration", "TabFadeOutAnimationDuration", "TextDistanceFromLeadingIcon", "LeadingIconTab", "", "selected", "", "onClick", "Lkotlin/Function0;", "text", "Landroidx/compose/runtime/Composable;", "icon", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "Landroidx/compose/ui/graphics/Color;", "unselectedContentColor", "LeadingIconTab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "Tab", "Tab-0nD-MI0", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;II)V", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "Tab-EVJuX4I", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "TabBaselineLayout", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "TabTransition", "activeColor", "inactiveColor", "TabTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "placeTextAndIcon", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "density", "Landroidx/compose/ui/unit/Density;", "textPlaceable", "Landroidx/compose/ui/layout/Placeable;", "iconPlaceable", "tabWidth", "tabHeight", "firstBaseline", "lastBaseline", "placeTextOrIcon", "textOrIconPlaceable", "material_release", "color"}, k = 2, mv = {1, 8, 0}, xi = 48)
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
        int i8 = 0;
        TabKt.SmallTabHeight = Dp.constructor-impl((float)i);
        int i9 = 0;
        TabKt.LargeTabHeight = Dp.constructor-impl((float)i2);
        int i10 = 0;
        TabKt.HorizontalTextPadding = Dp.constructor-impl((float)i3);
        int i11 = 0;
        TabKt.SingleLineTextBaselineWithIcon = Dp.constructor-impl((float)i4);
        int i12 = 0;
        TabKt.DoubleLineTextBaselineWithIcon = Dp.constructor-impl((float)i5);
        TabKt.IconDistanceFromBaseline = TextUnitKt.getSp(20);
        int i13 = 0;
        TabKt.TextDistanceFromLeadingIcon = Dp.constructor-impl((float)i7);
    }

    public static final void LeadingIconTab-0nD-MI0(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i12) {
        int i19;
        int skipping;
        int defaultsInvalid;
        int localContentColor;
        Object endRestartGroup;
        int changed2;
        Composer traceInProgress2;
        int $dirty;
        long $dirty2;
        long l;
        int i5;
        boolean z2;
        int consume;
        boolean traceInProgress;
        int i9;
        Object obj8;
        int i4;
        Object obj6;
        Object obj4;
        int i6;
        Object obj7;
        boolean z4;
        int i8;
        int i;
        long l3;
        Object obj;
        Object obj2;
        long l5;
        int i17;
        int str;
        boolean z;
        long l4;
        int i2;
        int i14;
        Object obj3;
        Composer $composer2;
        int i15;
        int $dirty3;
        Object $dirty4;
        int i16;
        int changed;
        int i3;
        int unselectedContentColor2;
        long rippleOrFallbackImplementation-9IZ8Weo;
        boolean z3;
        long l2;
        Object obj9;
        long obj5;
        float medium;
        int i10;
        int i13;
        int i11;
        int i18;
        int i7;
        long obj32;
        int obj33;
        long obj34;
        Function2 obj36;
        androidx.compose.runtime.internal.ComposableLambda obj37;
        Composer obj38;
        int obj39;
        final int i52 = obj40;
        final int i53 = obj41;
        traceInProgress2 = i12.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation(traceInProgress2, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)158@6852L7,159@6944L6,164@7192L76,166@7344L859,166@7274L929:Tab.kt#jmzs0o");
        $dirty = obj40;
        if (i53 & 1 != 0) {
            $dirty |= 6;
            z2 = selected;
        } else {
            if (i52 & 6 == 0) {
                i9 = traceInProgress2.changed(selected) ? 4 : 2;
                $dirty |= i9;
            } else {
                z2 = selected;
            }
        }
        if (i53 & 2 != 0) {
            $dirty |= 48;
            obj8 = onClick;
        } else {
            if (i52 & 48 == 0) {
                i4 = traceInProgress2.changedInstance(onClick) ? 32 : 16;
                $dirty |= i4;
            } else {
                obj8 = onClick;
            }
        }
        if (i53 & 4 != 0) {
            $dirty |= 384;
            obj6 = text;
        } else {
            if (i52 & 384 == 0) {
                i6 = traceInProgress2.changedInstance(text) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj6 = text;
            }
        }
        if (i53 & 8 != 0) {
            $dirty |= 3072;
            obj7 = icon;
        } else {
            if (i52 & 3072 == 0) {
                i8 = traceInProgress2.changedInstance(icon) ? 2048 : 1024;
                $dirty |= i8;
            } else {
                obj7 = icon;
            }
        }
        i = i53 & 16;
        if (i != 0) {
            $dirty |= 24576;
            obj2 = modifier;
        } else {
            if (i52 & 24576 == 0) {
                i17 = traceInProgress2.changed(modifier) ? 16384 : 8192;
                $dirty |= i17;
            } else {
                obj2 = modifier;
            }
        }
        str = i53 & 32;
        int i49 = 196608;
        if (str != null) {
            $dirty |= i49;
            z = enabled;
        } else {
            if (i49 &= i52 == 0) {
                i2 = traceInProgress2.changed(enabled) ? 131072 : 65536;
                $dirty |= i2;
            } else {
                z = enabled;
            }
        }
        i14 = i53 & 64;
        int i54 = 1572864;
        if (i14 != 0) {
            $dirty |= i54;
            obj3 = interactionSource;
        } else {
            if (i54 &= i52 == 0) {
                i15 = traceInProgress2.changed(interactionSource) ? 1048576 : 524288;
                $dirty |= i15;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i56 &= i52 == 0) {
            if (i53 & 128 == 0) {
                obj39 = $dirty;
                i16 = traceInProgress2.changed(selectedContentColor) ? 8388608 : 4194304;
            } else {
                obj39 = $dirty;
                $dirty2 = selectedContentColor;
            }
            $dirty3 = obj39 | i16;
        } else {
            $dirty2 = selectedContentColor;
            $dirty3 = obj39;
        }
        if (i52 & i58 == 0) {
            if (i53 & 256 == 0) {
                i19 = traceInProgress2.changed($composer) ? 67108864 : 33554432;
            } else {
                l = $composer;
            }
            $dirty3 |= i19;
        } else {
            l = $composer;
        }
        if (i20 &= $dirty3 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                consume = -29360129;
                obj39 = -234881025;
                int i24 = 6;
                if (i52 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (i != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (str != null) {
                            z = defaultsInvalid;
                        }
                        if (i14 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i53 & 128 != 0) {
                            i = 6;
                            str = 0;
                            ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                            $dirty3 &= unselectedContentColor2;
                            l2 = rippleOrFallbackImplementation-9IZ8Weo;
                        } else {
                            l2 = selectedContentColor;
                        }
                        if (i53 & 256 != 0) {
                            skipping = $dirty3 & obj39;
                            $dirty4 = obj2;
                            z3 = z;
                            l3 = copy-wmQWz5c$default;
                            unselectedContentColor2 = obj3;
                        } else {
                            z3 = z;
                            unselectedContentColor2 = obj3;
                            skipping = $dirty3;
                            $dirty4 = obj2;
                            l3 = $composer;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        if (i53 & 128 != 0) {
                            $dirty3 &= consume;
                        }
                        if (i53 & 256 != 0) {
                            skipping = $dirty3 & obj39;
                            l2 = selectedContentColor;
                            $dirty4 = obj2;
                            z3 = z;
                            unselectedContentColor2 = obj3;
                            l3 = $composer;
                        } else {
                            l2 = selectedContentColor;
                            z3 = z;
                            unselectedContentColor2 = obj3;
                            skipping = $dirty3;
                            $dirty4 = obj2;
                            l3 = $composer;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, skipping, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:160)");
                }
                obj33 = i51;
                obj34 = l2;
                i5 = obj34;
                TabKt.LeadingIconTab.1 anon = new TabKt.LeadingIconTab.1($dirty4, selected, unselectedContentColor2, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, obj33, obj34, selectedContentColor, traceInProgress2, i24 |= i29), z3, obj8, obj7, obj6);
                obj38 = traceInProgress2;
                obj34 = l3;
                TabKt.TabTransition-Klgx-Pg(i5, obj33, obj34, selectedContentColor, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(866677691, true, anon, traceInProgress2, 54));
                $composer2 = obj38;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l5 = i5;
                l4 = obj8;
                obj4 = $dirty4;
                obj = unselectedContentColor2;
                z4 = z3;
                $dirty3 = skipping;
            } else {
                traceInProgress2.skipToGroupEnd();
                obj4 = obj2;
                z4 = z;
                obj = obj3;
                l5 = selectedContentColor;
                l4 = $composer;
                $composer2 = traceInProgress2;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj36 = $composer2;
            endRestartGroup = new TabKt.LeadingIconTab.2(selected, onClick, text, icon, obj4, z4, obj, l5, str, l4, i14, i52, i53);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj36 = $composer2;
        }
    }

    public static final void Tab-0nD-MI0(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i12) {
        Object obj9;
        int $dirty4;
        int $dirty2;
        boolean $dirty3;
        int defaultsInvalid;
        int interactionSource2;
        int i9;
        int $dirty7;
        Composer traceInProgress2;
        int $dirty5;
        long $dirty;
        long l2;
        int i5;
        int i14;
        int $dirty6;
        int i7;
        int i6;
        Object obj5;
        androidx.compose.material.ContentAlpha iNSTANCE;
        boolean traceInProgress;
        Object obj8;
        boolean z;
        int i19;
        Object obj6;
        int localContentColor;
        boolean z2;
        Object obj2;
        androidx.compose.runtime.internal.ComposableLambda it;
        int i10;
        int obj4;
        int i4;
        Object obj3;
        long text2;
        int i11;
        int rememberComposableLambda;
        Object obj;
        long icon2;
        int i21;
        int i13;
        boolean z3;
        Object obj7;
        int i8;
        int i20;
        int i17;
        int changed;
        int i16;
        int unselectedContentColor2;
        int selectedContentColor2;
        long l3;
        long unbox-impl;
        long l;
        long l5;
        long l4;
        Composer composer;
        float medium;
        int i18;
        int i2;
        int i;
        int i3;
        int i15;
        long l6;
        int obj43;
        final int i55 = obj44;
        final int i56 = obj45;
        traceInProgress2 = i12.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation(traceInProgress2, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)96@4342L7,97@4434L6,113@4860L65,105@4691L234:Tab.kt#jmzs0o");
        $dirty5 = obj44;
        if (i56 & 1 != 0) {
            $dirty5 |= 6;
            z3 = selected;
        } else {
            if (i55 & 6 == 0) {
                i7 = traceInProgress2.changed(selected) ? 4 : 2;
                $dirty5 |= i7;
            } else {
                z3 = selected;
            }
        }
        if (i56 & 2 != 0) {
            $dirty5 |= 48;
            obj7 = onClick;
        } else {
            if (i55 & 48 == 0) {
                i6 = traceInProgress2.changedInstance(onClick) ? 32 : 16;
                $dirty5 |= i6;
            } else {
                obj7 = onClick;
            }
        }
        int i31 = i56 & 4;
        if (i31 != 0) {
            $dirty5 |= 384;
            obj8 = modifier;
        } else {
            if (i55 & 384 == 0) {
                i19 = traceInProgress2.changed(modifier) ? 256 : 128;
                $dirty5 |= i19;
            } else {
                obj8 = modifier;
            }
        }
        localContentColor = i56 & 8;
        if (localContentColor != 0) {
            $dirty5 |= 3072;
            z2 = enabled;
        } else {
            if (i55 & 3072 == 0) {
                i10 = traceInProgress2.changed(enabled) ? 2048 : 1024;
                $dirty5 |= i10;
            } else {
                z2 = enabled;
            }
        }
        i4 = i56 & 16;
        if (i4 != 0) {
            $dirty5 |= 24576;
            obj3 = text;
        } else {
            if (i55 & 24576 == 0) {
                i11 = traceInProgress2.changedInstance(text) ? 16384 : 8192;
                $dirty5 |= i11;
            } else {
                obj3 = text;
            }
        }
        rememberComposableLambda = i56 & 32;
        int i53 = 196608;
        if (rememberComposableLambda != 0) {
            $dirty5 |= i53;
            obj = icon;
        } else {
            if (i53 &= i55 == 0) {
                i21 = traceInProgress2.changedInstance(icon) ? 131072 : 65536;
                $dirty5 |= i21;
            } else {
                obj = icon;
            }
        }
        i13 = i56 & 64;
        i8 = 1572864;
        if (i13 != 0) {
            $dirty5 |= i8;
            obj9 = interactionSource;
        } else {
            if (i55 & i8 == 0) {
                i20 = traceInProgress2.changed(interactionSource) ? 1048576 : 524288;
                $dirty5 |= i20;
            } else {
                obj9 = interactionSource;
            }
        }
        i17 = 12582912;
        if (i55 & i17 == 0) {
            if (i56 & 128 == 0) {
                $dirty4 = $dirty5;
                obj43 = i31;
                changed = traceInProgress2.changed(selectedContentColor) ? 8388608 : 4194304;
            } else {
                $dirty4 = $dirty5;
                obj43 = i31;
                $dirty = selectedContentColor;
            }
            $dirty4 |= changed;
        } else {
            $dirty2 = $dirty5;
            obj43 = i31;
            $dirty = selectedContentColor;
        }
        if (i55 & i57 == 0) {
            if (i56 & 256 == 0) {
                i9 = traceInProgress2.changed($composer) ? 67108864 : 33554432;
            } else {
                l2 = $composer;
            }
            $dirty2 = i16 | i9;
        } else {
            l2 = $composer;
            i16 = $dirty2;
        }
        selectedContentColor2 = $dirty2;
        if (selectedContentColor2 & unselectedContentColor2 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i25 = -234881025;
                int i32 = -29360129;
                if (i55 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (obj43 != null) {
                            obj8 = defaultsInvalid;
                        }
                        if (localContentColor != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (i4 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (rememberComposableLambda != 0) {
                            obj = defaultsInvalid;
                        }
                        interactionSource2 = i13 != 0 ? 0 : interactionSource;
                        if (i56 & 128 != 0) {
                            i4 = 6;
                            rememberComposableLambda = 0;
                            obj43 = i25;
                            ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                            i14 = selectedContentColor2 & i32;
                            l5 = unbox-impl;
                        } else {
                            obj43 = i25;
                            l5 = selectedContentColor;
                            i14 = selectedContentColor2;
                        }
                        if (i56 & 256 != 0) {
                            l = copy-wmQWz5c$default;
                            l3 = l6;
                            unselectedContentColor2 = interactionSource2;
                            $dirty3 = $dirty8;
                            $dirty6 = i17;
                            i17 = z2;
                        } else {
                            unselectedContentColor2 = interactionSource2;
                            $dirty3 = i14;
                            $dirty6 = i17;
                            l3 = l5;
                            l = $composer;
                            i17 = z2;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty3 = i56 & 128 != 0 ? selectedContentColor2 & i32 : selectedContentColor2;
                        if (i56 & 256 != 0) {
                            $dirty3 &= i25;
                            unselectedContentColor2 = interactionSource;
                            l3 = selectedContentColor;
                            l = $composer;
                            $dirty6 = i17;
                            i17 = z2;
                        } else {
                            unselectedContentColor2 = interactionSource;
                            l3 = selectedContentColor;
                            l = $composer;
                            $dirty6 = i17;
                            i17 = z2;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, $dirty3, -1, "androidx.compose.material.Tab (Tab.kt:98)");
                }
                int i33 = 54;
                int i45 = 1;
                if (obj3 == null) {
                    traceInProgress2.startReplaceGroup(1041201080);
                    traceInProgress2.endReplaceGroup();
                    it = 0;
                } else {
                    traceInProgress2.startReplaceGroup(1041201081);
                    ComposerKt.sourceInformation(traceInProgress2, "*100@4526L154");
                    Object obj11 = obj3;
                    i4 = 0;
                    TabKt.Tab.styledText.1.1 anon2 = new TabKt.Tab.styledText.1.1(obj3);
                    it = rememberComposableLambda;
                    traceInProgress2.endReplaceGroup();
                }
                TabKt.Tab.1 anon = new TabKt.Tab.1(it, obj);
                i8 = obj8;
                TabKt.Tab-EVJuX4I(z3, obj7, i8, i17, unselectedContentColor2, l3, unbox-impl, l, l5, (Function3)ComposableLambdaKt.rememberComposableLambda(-178151495, i45, anon, traceInProgress2, i33), traceInProgress2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = obj3;
                obj2 = obj;
                obj5 = i8;
                z = i17;
                obj4 = unselectedContentColor2;
                text2 = l3;
                icon2 = l;
                selectedContentColor2 = $dirty3;
            } else {
                traceInProgress2.skipToGroupEnd();
                obj4 = interactionSource;
                composer = traceInProgress2;
                obj5 = obj8;
                z = z2;
                obj6 = obj3;
                obj2 = obj;
                text2 = selectedContentColor;
                icon2 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty3 = new TabKt.Tab.2(selected, onClick, obj5, z, obj6, obj2, obj4, text2, rememberComposableLambda, icon2, i13, i55, i56);
            endRestartGroup.updateScope((Function2)$dirty3);
        }
    }

    public static final void Tab-EVJuX4I(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        long l2;
        int unselectedContentColor2;
        int defaultsInvalid;
        int unbox-impl;
        int $dirty;
        int consume;
        boolean traceInProgress;
        int i15;
        Object obj5;
        int i17;
        long l6;
        int i;
        Object unselectedContentColor3;
        Object i18;
        boolean z;
        boolean z2;
        Object obj;
        int i16;
        int str;
        long l7;
        boolean i9;
        long l3;
        int i2;
        int i5;
        Object obj2;
        int i14;
        long l;
        Composer composer;
        Object obj6;
        int changed2;
        int i7;
        Object obj4;
        int $dirty2;
        Object $dirty3;
        int i8;
        boolean changed;
        int i10;
        androidx.compose.foundation.Indication rippleOrFallbackImplementation-9IZ8Weo;
        boolean z3;
        Function0 function0;
        long l4;
        Object obj3;
        float medium;
        int i12;
        int i6;
        int i3;
        int i13;
        int i4;
        long l5;
        int obj32;
        int obj33;
        long obj34;
        Composer obj36;
        int obj37;
        int obj38;
        int obj40;
        final int i45 = obj41;
        final int i46 = obj42;
        final Composer restartGroup = i11.startRestartGroup(713679175);
        ComposerKt.sourceInformation(restartGroup, "C(Tab)P(5,4,3,1,2,6:c#ui.graphics.Color,7:c#ui.graphics.Color)227@9990L7,228@10082L6,234@10376L76,236@10528L548,236@10458L618:Tab.kt#jmzs0o");
        $dirty = obj41;
        if (i46 & 1 != 0) {
            $dirty |= 6;
            z2 = selected;
        } else {
            if (i45 & 6 == 0) {
                i15 = restartGroup.changed(selected) ? 4 : 2;
                $dirty |= i15;
            } else {
                z2 = selected;
            }
        }
        if (i46 & 2 != 0) {
            $dirty |= 48;
            obj5 = onClick;
        } else {
            if (i45 & 48 == 0) {
                i17 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i17;
            } else {
                obj5 = onClick;
            }
        }
        i = i46 & 4;
        if (i != 0) {
            $dirty |= 384;
            i18 = modifier;
        } else {
            if (i45 & 384 == 0) {
                i16 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i16;
            } else {
                i18 = modifier;
            }
        }
        str = i46 & 8;
        if (str != null) {
            $dirty |= 3072;
            i9 = enabled;
        } else {
            if (i45 & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i2;
            } else {
                i9 = enabled;
            }
        }
        i5 = i46 & 16;
        if (i5 != 0) {
            $dirty |= 24576;
            obj2 = interactionSource;
        } else {
            if (i45 & 24576 == 0) {
                i14 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i14;
            } else {
                obj2 = interactionSource;
            }
        }
        if (i47 &= i45 == 0) {
            if (i46 & 32 == 0) {
                changed2 = restartGroup.changed(selectedContentColor) ? 131072 : 65536;
            } else {
                l = selectedContentColor;
            }
            $dirty |= changed2;
        } else {
            l = selectedContentColor;
        }
        if (i50 &= i45 == 0) {
            if (i46 & 64 == 0) {
                obj40 = $dirty;
                i8 = restartGroup.changed(content) ? 1048576 : 524288;
            } else {
                obj40 = $dirty;
                l2 = content;
            }
            $dirty2 = obj40 | i8;
        } else {
            l2 = content;
            $dirty2 = obj40;
        }
        i10 = 12582912;
        if (i46 & 128 != 0) {
            $dirty2 |= i10;
            obj4 = $changed;
        } else {
            if (i45 & i10 == 0) {
                i10 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty2 |= i10;
            } else {
                obj4 = $changed;
            }
        }
        if ($dirty2 & rippleOrFallbackImplementation-9IZ8Weo == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i53 = -458753;
                int i54 = -3670017;
                if (i45 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i != 0) {
                            i18 = defaultsInvalid;
                        }
                        if (str != null) {
                            i9 = defaultsInvalid;
                        }
                        if (i5 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i46 & 32 != 0) {
                            i = 6;
                            str = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty2 &= i53;
                            l4 = unbox-impl;
                        } else {
                            l4 = l;
                        }
                        if (i46 & 64 != 0) {
                            obj6 = i18;
                            z3 = i9;
                            $dirty3 = obj2;
                            unselectedContentColor2 = i28;
                            l6 = l5;
                        } else {
                            obj6 = i18;
                            z3 = i9;
                            unselectedContentColor2 = $dirty2;
                            l6 = content;
                            $dirty3 = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i46 & 32 != 0) {
                            $dirty2 &= i53;
                        }
                        if (i46 & 64 != 0) {
                            unselectedContentColor2 = $dirty2 & i54;
                            z3 = i9;
                            $dirty3 = obj2;
                            l4 = l;
                            obj6 = i18;
                            l6 = content;
                        } else {
                            z3 = i9;
                            l4 = l;
                            unselectedContentColor2 = $dirty2;
                            obj6 = i18;
                            $dirty3 = obj2;
                            l6 = content;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, unselectedContentColor2, -1, "androidx.compose.material.Tab (Tab.kt:230)");
                }
                int i55 = 6;
                int i38 = 1;
                obj34 = l4;
                consume = obj34;
                TabKt.Tab.3 anon = new TabKt.Tab.3(obj6, z2, $dirty3, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(i38, 0, obj34, selectedContentColor, restartGroup, i24 |= 6), z3, onClick, obj4);
                TabKt.TabTransition-Klgx-Pg(consume, obj5, l6, i18, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-1237246709, i38, anon, restartGroup, 54));
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l7 = consume;
                l3 = l6;
                unselectedContentColor3 = obj6;
                obj = $dirty3;
                z = z3;
                $dirty2 = unselectedContentColor2;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                l7 = l5;
                unselectedContentColor3 = i18;
                z = i9;
                obj = obj2;
                l3 = content;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            unselectedContentColor2 = new TabKt.Tab.4(selected, onClick, unselectedContentColor3, z, obj, l7, restartGroup, l3, i5, $changed, i45, i46);
            endRestartGroup.updateScope((Function2)unselectedContentColor2);
        }
    }

    private static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        int traceInProgress2;
        int i21;
        Integer valueOf;
        Composer restartGroup;
        int $dirty;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        int i23;
        int i3;
        boolean materialized$iv$iv;
        boolean traceInProgress;
        int i5;
        int valueOf2;
        Composer composer7;
        int factory$iv$iv;
        boolean valueOf3;
        Integer maybeCachedBoxMeasurePolicy;
        int str3;
        int str;
        Composer composer6;
        Object currentCompositionLocalMap;
        int str2;
        Composer composer2;
        Object currentCompositionLocalMap3;
        int materializeModifier;
        androidx.compose.ui.layout.MeasurePolicy currentCompositeKeyHash;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        Modifier materializeModifier2;
        int i2;
        Composer composer4;
        int i14;
        int i11;
        int i24;
        int i25;
        int i16;
        BoxScopeInstance boxScopeInstance;
        Composer composer;
        int i7;
        int i15;
        int $dirty2;
        int i8;
        Function0 factory$iv$iv2;
        int i4;
        androidx.compose.ui.Modifier.Companion companion;
        int i;
        int i12;
        int i19;
        int i18;
        int currentCompositeKeyHash2;
        Object obj;
        int i6;
        Modifier modifier;
        Function0 $changed$iv;
        int i13;
        int i17;
        Composer composer3;
        int i22;
        int i20;
        int i9;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer5;
        int i10;
        int obj53;
        final Object obj2 = text;
        final Object obj3 = icon;
        final int i26 = $changed;
        traceInProgress2 = 1249848471;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TabBaselineLayout)P(1)314@13013L1593,303@12689L1917:Tab.kt#jmzs0o");
        factory$iv$iv = 4;
        if (i26 & 6 == 0) {
            i23 = restartGroup.changedInstance(obj2) ? factory$iv$iv : 2;
            $dirty |= i23;
        }
        str = 32;
        if (i26 & 48 == 0) {
            i3 = restartGroup.changedInstance(obj3) ? str : 16;
            $dirty |= i3;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:302)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1014675191, "CC(remember):Tab.kt#9igjgp");
                int i58 = 0;
                i21 = $dirty & 14 == factory$iv$iv ? i5 : i58;
                if ($dirty & 112 == str) {
                } else {
                    i5 = i58;
                }
                Composer composer8 = restartGroup;
                int i51 = 0;
                Object rememberedValue4 = composer8.rememberedValue();
                int i64 = 0;
                if (i21 |= i5 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        currentCompositeKeyHash = 0;
                        anon = new TabKt.TabBaselineLayout.2.1(obj2, obj3);
                        composer8.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i30 = i58;
                valueOf2 = 0;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                materializeModifier = Modifier.Companion;
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i58);
                i60 |= 6;
                Function0 function0 = constructor;
                i2 = 0;
                str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str3);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function0);
                } else {
                    factory$iv$iv = function0;
                    restartGroup.useNode();
                }
                i14 = i30;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i71 = 0;
                composer = restartGroup;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                boxScopeInstance = 0;
                Composer composer10 = constructor-impl;
                i15 = 0;
                if (!composer10.getInserting()) {
                    $dirty2 = $dirty;
                    i8 = valueOf2;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer10;
                    }
                } else {
                    $dirty2 = $dirty;
                    i8 = valueOf2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)materializeModifier), ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer;
                i16 = i32;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -238768079, "C:Tab.kt#jmzs0o");
                String str4 = "C73@3429L9:Box.kt#2w3rfo";
                materialized$iv$iv = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i7 = i36;
                if (obj2 != null) {
                    restartGroup.startReplaceGroup(-238754006);
                    ComposerKt.sourceInformation(restartGroup, "306@12755L123");
                    factory$iv$iv2 = factory$iv$iv;
                    i4 = str2;
                    companion = materializeModifier;
                    i = currentCompositeKeyHash;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "text"), TabKt.HorizontalTextPadding, 0, 2, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i67 = 0;
                    i24 = i54;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i67);
                    i19 = 0;
                    i18 = i61;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                    currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                    obj = topStart2;
                    modifier = padding-VpY3zN4$default;
                    Function0 function03 = constructor3;
                    i6 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str3);
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
                    $changed$iv = factory$iv$iv$iv;
                    Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                    int i74 = 0;
                    i22 = i67;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i77 = 0;
                    Composer composer12 = constructor-impl2;
                    int i78 = 0;
                    if (!composer12.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer12;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(restartGroup, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = restartGroup;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, str4);
                    currentCompositeKeyHash = BoxScopeInstance.INSTANCE;
                    i76 |= 6;
                    i20 = 0;
                    i9 = i46;
                    i10 = i63;
                    str2 = composer3;
                    ComposerKt.sourceInformationMarkerStart(str2, 138815969, "C308@12870L6:Tab.kt#jmzs0o");
                    obj2.invoke(str2, Integer.valueOf($dirty2 & 14));
                    ComposerKt.sourceInformationMarkerEnd(str2);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    factory$iv$iv2 = factory$iv$iv;
                    i4 = str2;
                    companion = materializeModifier;
                    i = currentCompositeKeyHash;
                    restartGroup.startReplaceGroup(-238605051);
                    restartGroup.endReplaceGroup();
                }
                if (obj3 != null) {
                    restartGroup.startReplaceGroup(-238572036);
                    ComposerKt.sourceInformation(restartGroup, "311@12941L41");
                    Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                    valueOf3 = 6;
                    str2 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i15 = 0;
                    i12 = topStart;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    obj53 = currentCompositeKeyHash3;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, layoutId);
                    i19 = layoutId;
                    Function0 function02 = constructor2;
                    i11 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str3);
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function02);
                    } else {
                        factory$iv$iv$iv2 = function02;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl3 = Updater.constructor-impl(restartGroup);
                    int i70 = 0;
                    obj = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i73 = 0;
                    Composer composer11 = constructor-impl3;
                    modifier = 0;
                    if (!composer11.getInserting()) {
                        $changed$iv = valueOf3;
                        i13 = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(obj53))) {
                            composer11.updateRememberedValue(Integer.valueOf(obj53));
                            constructor-impl3.apply(Integer.valueOf(obj53), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer6 = composer11;
                        }
                    } else {
                        $changed$iv = valueOf3;
                        i13 = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    factory$iv$iv = restartGroup;
                    str3 = 0;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv, -2146769399, str4);
                    i57 |= 6;
                    i25 = 0;
                    boxScopeInstance = iNSTANCE;
                    i18 = i41;
                    i6 = materializeModifier3;
                    materialized$iv$iv = composer4;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 138919137, "C311@12974L6:Tab.kt#jmzs0o");
                    obj3.invoke(materialized$iv$iv, Integer.valueOf(i33 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(factory$iv$iv);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-238501883);
                    restartGroup.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new TabKt.TabBaselineLayout.3(obj2, obj3, i26);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress4;
        long l5;
        int $dirty2;
        long l6;
        long l2;
        int i10;
        int i5;
        boolean z2;
        Object invoke;
        int $changed$iv$iv2;
        boolean changed;
        int i12;
        boolean traceInProgress;
        long l4;
        int i6;
        long l;
        Color box-impl;
        int i9;
        int i7;
        boolean transitionSpec$iv;
        boolean traceInProgress3;
        Composer animationSpec$iv$iv;
        long l3;
        String str;
        Composer restartGroup;
        int i;
        int i2;
        int i3;
        int i4;
        int i8;
        int $dirty;
        Transition transition;
        androidx.compose.ui.graphics.colorspace.ColorSpace $composer2;
        Object traceInProgress2;
        boolean z;
        boolean invalid$iv$iv;
        int i11;
        int $changed$iv$iv;
        boolean traceInProgress5;
        androidx.compose.material.TabKt.TabTransition.color.2 anon;
        Composer obj34;
        final Object obj2 = $changed;
        final int i34 = obj35;
        traceInProgress4 = -405571117;
        restartGroup = obj34.startRestartGroup(traceInProgress4);
        ComposerKt.sourceInformation(restartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)267@11507L26,268@11562L550,286@12117L164:Tab.kt#jmzs0o");
        i12 = 2;
        if (i34 & 6 == 0) {
            i10 = restartGroup.changed(activeColor) ? 4 : i12;
            $dirty2 |= i10;
        } else {
            l4 = activeColor;
        }
        if (i34 & 48 == 0) {
            i5 = restartGroup.changed(selected) ? 32 : 16;
            $dirty2 |= i5;
        } else {
            l = selected;
        }
        if (i34 & 384 == 0) {
            i9 = restartGroup.changed($composer) ? 256 : 128;
            $dirty2 |= i9;
        } else {
            z2 = $composer;
        }
        if (i34 & 3072 == 0) {
            i7 = restartGroup.changedInstance(obj2) ? 2048 : 1024;
            $dirty2 |= i7;
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress4, $dirty2, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
                }
                Transition transition2 = TransitionKt.updateTransition(Boolean.valueOf(z2), 0, restartGroup, i36 &= 14, i12);
                androidx.compose.material.TabKt.TabTransition.color.2 iNSTANCE = TabKt.TabTransition.color.2.INSTANCE;
                int i56 = 0;
                Transition transition5 = transition2;
                int i57 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1939694975, "CC(animateColor)P(2)68@3220L31,69@3287L70,73@3370L70:Transition.kt#xbi5r1");
                str = "ColorAnimation";
                int i58 = 0;
                Composer composer2 = obj34;
                composer2.startReplaceGroup(1445938070);
                String str3 = "C:Tab.kt#jmzs0o";
                ComposerKt.sourceInformation(composer2, str3);
                transition = transition2;
                String transition3 = "androidx.compose.material.TabTransition.<anonymous> (Tab.kt:284)";
                if (ComposerKt.isTraceInProgress()) {
                    $dirty = $dirty2;
                    ComposerKt.traceEventStart(1445938070, i51 &= 112, -1, transition3);
                } else {
                    $dirty = $dirty2;
                }
                l6 = (Boolean)transition5.getTargetState().booleanValue() ? l4 : l;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(l6);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1918408083, "CC(remember):Transition.kt#9igjgp");
                changed = restartGroup.changed(colorSpace-impl);
                Composer composer3 = restartGroup;
                int i50 = 0;
                Object rememberedValue = composer3.rememberedValue();
                int i59 = 0;
                if (!changed) {
                    invalid$iv$iv = changed;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i11 = invalid$iv$iv2;
                        composer3.updateRememberedValue((TwoWayConverter)ColorVectorConverterKt.getVectorConverter(Color.Companion).invoke(colorSpace-impl));
                    } else {
                        invoke = rememberedValue;
                    }
                } else {
                    invalid$iv$iv = changed;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i53 = 57344;
                i20 |= i45;
                Transition transition4 = transition5;
                int i60 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli");
                int i61 = 0;
                Composer composer5 = composer6;
                $composer2 = colorSpace-impl;
                int colorSpace$iv = 1445938070;
                composer5.startReplaceGroup(colorSpace$iv);
                ComposerKt.sourceInformation(composer5, str3);
                if (ComposerKt.isTraceInProgress()) {
                    $changed$iv$iv = $changed$iv$iv2;
                    ComposerKt.traceEventStart(colorSpace$iv, i46 &= 112, -1, transition3);
                } else {
                    $changed$iv$iv = $changed$iv$iv2;
                }
                l2 = (Boolean)transition4.getCurrentState().booleanValue() ? l4 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer5.endReplaceGroup();
                box-impl = Color.box-impl(l2);
                Composer composer4 = restartGroup;
                int i54 = 0;
                int it = 1445938070;
                composer4.startReplaceGroup(it);
                ComposerKt.sourceInformation(composer4, str3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(it, i21 &= 112, -1, transition3);
                }
                l5 = (Boolean)transition4.getTargetState().booleanValue() ? l4 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                Object obj3 = invoke2;
                androidx.compose.material.TabKt.TabTransition.color.2 targetValue$iv$iv = anon;
                $dirty2 = TransitionKt.createTransitionAnimation(transition4, box-impl, Color.box-impl(l5), (FiniteAnimationSpec)obj3, (TwoWayConverter)invoke, str, restartGroup, i15 | i28);
                Object obj = obj3;
                animationSpec$iv$iv = restartGroup;
                ComposerKt.sourceInformationMarkerEnd(animationSpec$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(animationSpec$iv$iv);
                ProvidedValue[] arr = new ProvidedValue[2];
                CompositionLocalKt.CompositionLocalProvider(arr, obj2, animationSpec$iv$iv, $stable |= i12);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty = $dirty2;
                animationSpec$iv$iv = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = animationSpec$iv$iv.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress4 = new TabKt.TabTransition.1(l4, z2, selected, l4, $composer, obj2, i34);
            endRestartGroup.updateScope((Function2)traceInProgress4);
        }
    }

    private static final long TabTransition_Klgx_Pg$lambda$2(State<Color> $color$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$color$delegate.getValue().unbox-impl();
    }

    public static final void access$TabBaselineLayout(Function2 text, Function2 icon, Composer $composer, int $changed) {
        TabKt.TabBaselineLayout(text, icon, $composer, $changed);
    }

    public static final void access$TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2 content, Composer $composer, int $changed) {
        TabKt.TabTransition-Klgx-Pg(activeColor, inactiveColor, selected, content, $composer, $changed);
    }

    public static final float access$getHorizontalTextPadding$p() {
        return TabKt.HorizontalTextPadding;
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
