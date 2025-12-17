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
        int i8;
        int skipping;
        int defaultsInvalid;
        int localContentColor;
        Object endRestartGroup;
        int changed;
        Composer traceInProgress;
        int $dirty;
        long $dirty2;
        long l5;
        int i16;
        boolean z4;
        int consume;
        boolean traceInProgress2;
        int i3;
        Object obj5;
        int i18;
        Object obj7;
        Object obj3;
        int i7;
        Object obj;
        boolean z;
        int i17;
        int i11;
        long l3;
        Object obj8;
        Object obj2;
        long l4;
        int i2;
        int str;
        boolean z2;
        long l;
        int i14;
        int i5;
        Object obj6;
        Composer $composer2;
        int i19;
        int $dirty3;
        Object $dirty4;
        int i6;
        int changed2;
        int i15;
        int unselectedContentColor2;
        long rippleOrFallbackImplementation-9IZ8Weo;
        boolean z3;
        long l2;
        Object obj9;
        long obj4;
        float medium;
        int i13;
        int i10;
        int i4;
        int i9;
        int i;
        long obj32;
        int obj33;
        long obj34;
        Function2 obj36;
        androidx.compose.runtime.internal.ComposableLambda obj37;
        Composer obj38;
        int obj39;
        final int i52 = obj40;
        final int i53 = obj41;
        traceInProgress = i12.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation(traceInProgress, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)158@6852L7,159@6944L6,164@7192L76,166@7344L859,166@7274L929:Tab.kt#jmzs0o");
        $dirty = obj40;
        if (i53 & 1 != 0) {
            $dirty |= 6;
            z4 = selected;
        } else {
            if (i52 & 6 == 0) {
                i3 = traceInProgress.changed(selected) ? 4 : 2;
                $dirty |= i3;
            } else {
                z4 = selected;
            }
        }
        if (i53 & 2 != 0) {
            $dirty |= 48;
            obj5 = onClick;
        } else {
            if (i52 & 48 == 0) {
                i18 = traceInProgress.changedInstance(onClick) ? 32 : 16;
                $dirty |= i18;
            } else {
                obj5 = onClick;
            }
        }
        if (i53 & 4 != 0) {
            $dirty |= 384;
            obj7 = text;
        } else {
            if (i52 & 384 == 0) {
                i7 = traceInProgress.changedInstance(text) ? 256 : 128;
                $dirty |= i7;
            } else {
                obj7 = text;
            }
        }
        if (i53 & 8 != 0) {
            $dirty |= 3072;
            obj = icon;
        } else {
            if (i52 & 3072 == 0) {
                i17 = traceInProgress.changedInstance(icon) ? 2048 : 1024;
                $dirty |= i17;
            } else {
                obj = icon;
            }
        }
        i11 = i53 & 16;
        if (i11 != 0) {
            $dirty |= 24576;
            obj2 = modifier;
        } else {
            if (i52 & 24576 == 0) {
                i2 = traceInProgress.changed(modifier) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                obj2 = modifier;
            }
        }
        str = i53 & 32;
        int i49 = 196608;
        if (str != null) {
            $dirty |= i49;
            z2 = enabled;
        } else {
            if (i49 &= i52 == 0) {
                i14 = traceInProgress.changed(enabled) ? 131072 : 65536;
                $dirty |= i14;
            } else {
                z2 = enabled;
            }
        }
        i5 = i53 & 64;
        int i54 = 1572864;
        if (i5 != 0) {
            $dirty |= i54;
            obj6 = interactionSource;
        } else {
            if (i54 &= i52 == 0) {
                i19 = traceInProgress.changed(interactionSource) ? 1048576 : 524288;
                $dirty |= i19;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i56 &= i52 == 0) {
            if (i53 & 128 == 0) {
                obj39 = $dirty;
                i6 = traceInProgress.changed(selectedContentColor) ? 8388608 : 4194304;
            } else {
                obj39 = $dirty;
                $dirty2 = selectedContentColor;
            }
            $dirty3 = obj39 | i6;
        } else {
            $dirty2 = selectedContentColor;
            $dirty3 = obj39;
        }
        if (i52 & i58 == 0) {
            if (i53 & 256 == 0) {
                i8 = traceInProgress.changed($composer) ? 67108864 : 33554432;
            } else {
                l5 = $composer;
            }
            $dirty3 |= i8;
        } else {
            l5 = $composer;
        }
        if (i20 &= $dirty3 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                consume = -29360129;
                obj39 = -234881025;
                int i24 = 6;
                if (i52 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (str != null) {
                            z2 = defaultsInvalid;
                        }
                        if (i5 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (i53 & 128 != 0) {
                            i11 = 6;
                            str = 0;
                            ComposerKt.sourceInformationMarkerStart(traceInProgress, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                            $dirty3 &= unselectedContentColor2;
                            l2 = rippleOrFallbackImplementation-9IZ8Weo;
                        } else {
                            l2 = selectedContentColor;
                        }
                        if (i53 & 256 != 0) {
                            skipping = $dirty3 & obj39;
                            $dirty4 = obj2;
                            z3 = z2;
                            l3 = copy-wmQWz5c$default;
                            unselectedContentColor2 = obj6;
                        } else {
                            z3 = z2;
                            unselectedContentColor2 = obj6;
                            skipping = $dirty3;
                            $dirty4 = obj2;
                            l3 = $composer;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i53 & 128 != 0) {
                            $dirty3 &= consume;
                        }
                        if (i53 & 256 != 0) {
                            skipping = $dirty3 & obj39;
                            l2 = selectedContentColor;
                            $dirty4 = obj2;
                            z3 = z2;
                            unselectedContentColor2 = obj6;
                            l3 = $composer;
                        } else {
                            l2 = selectedContentColor;
                            z3 = z2;
                            unselectedContentColor2 = obj6;
                            skipping = $dirty3;
                            $dirty4 = obj2;
                            l3 = $composer;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, skipping, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:160)");
                }
                obj33 = i51;
                obj34 = l2;
                i16 = obj34;
                TabKt.LeadingIconTab.1 anon = new TabKt.LeadingIconTab.1($dirty4, selected, unselectedContentColor2, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, obj33, obj34, selectedContentColor, traceInProgress, i24 |= i29), z3, obj5, obj, obj7);
                obj38 = traceInProgress;
                obj34 = l3;
                TabKt.TabTransition-Klgx-Pg(i16, obj33, obj34, selectedContentColor, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(866677691, true, anon, traceInProgress, 54));
                $composer2 = obj38;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l4 = i16;
                l = obj5;
                obj3 = $dirty4;
                obj8 = unselectedContentColor2;
                z = z3;
                $dirty3 = skipping;
            } else {
                traceInProgress.skipToGroupEnd();
                obj3 = obj2;
                z = z2;
                obj8 = obj6;
                l4 = selectedContentColor;
                l = $composer;
                $composer2 = traceInProgress;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj36 = $composer2;
            endRestartGroup = new TabKt.LeadingIconTab.2(selected, onClick, text, icon, obj3, z, obj8, l4, str, l, i5, i52, i53);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj36 = $composer2;
        }
    }

    public static final void Tab-0nD-MI0(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i12) {
        Object obj;
        int $dirty6;
        int $dirty3;
        boolean $dirty4;
        int defaultsInvalid;
        int interactionSource2;
        int i8;
        int $dirty5;
        Composer traceInProgress2;
        int $dirty2;
        long $dirty;
        long l4;
        int i;
        int i21;
        int $dirty7;
        int i13;
        int i14;
        Object obj2;
        androidx.compose.material.ContentAlpha iNSTANCE;
        boolean traceInProgress;
        Object obj6;
        boolean z3;
        int i9;
        Object obj3;
        int localContentColor;
        boolean z2;
        Object obj7;
        androidx.compose.runtime.internal.ComposableLambda it;
        int i20;
        int obj4;
        int i15;
        Object obj8;
        long text2;
        int i7;
        int rememberComposableLambda;
        Object obj9;
        long icon2;
        int i18;
        int i19;
        boolean z;
        Object obj5;
        int i10;
        int i5;
        int i6;
        int changed;
        int i17;
        int unselectedContentColor2;
        int selectedContentColor2;
        long l6;
        long unbox-impl;
        long l2;
        long l5;
        long l3;
        Composer composer;
        float medium;
        int i11;
        int i16;
        int i3;
        int i4;
        int i2;
        long l;
        int obj43;
        final int i55 = obj44;
        final int i56 = obj45;
        traceInProgress2 = i12.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation(traceInProgress2, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)96@4342L7,97@4434L6,113@4860L65,105@4691L234:Tab.kt#jmzs0o");
        $dirty2 = obj44;
        if (i56 & 1 != 0) {
            $dirty2 |= 6;
            z = selected;
        } else {
            if (i55 & 6 == 0) {
                i13 = traceInProgress2.changed(selected) ? 4 : 2;
                $dirty2 |= i13;
            } else {
                z = selected;
            }
        }
        if (i56 & 2 != 0) {
            $dirty2 |= 48;
            obj5 = onClick;
        } else {
            if (i55 & 48 == 0) {
                i14 = traceInProgress2.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i14;
            } else {
                obj5 = onClick;
            }
        }
        int i31 = i56 & 4;
        if (i31 != 0) {
            $dirty2 |= 384;
            obj6 = modifier;
        } else {
            if (i55 & 384 == 0) {
                i9 = traceInProgress2.changed(modifier) ? 256 : 128;
                $dirty2 |= i9;
            } else {
                obj6 = modifier;
            }
        }
        localContentColor = i56 & 8;
        if (localContentColor != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (i55 & 3072 == 0) {
                i20 = traceInProgress2.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i20;
            } else {
                z2 = enabled;
            }
        }
        i15 = i56 & 16;
        if (i15 != 0) {
            $dirty2 |= 24576;
            obj8 = text;
        } else {
            if (i55 & 24576 == 0) {
                i7 = traceInProgress2.changedInstance(text) ? 16384 : 8192;
                $dirty2 |= i7;
            } else {
                obj8 = text;
            }
        }
        rememberComposableLambda = i56 & 32;
        int i53 = 196608;
        if (rememberComposableLambda != 0) {
            $dirty2 |= i53;
            obj9 = icon;
        } else {
            if (i53 &= i55 == 0) {
                i18 = traceInProgress2.changedInstance(icon) ? 131072 : 65536;
                $dirty2 |= i18;
            } else {
                obj9 = icon;
            }
        }
        i19 = i56 & 64;
        i10 = 1572864;
        if (i19 != 0) {
            $dirty2 |= i10;
            obj = interactionSource;
        } else {
            if (i55 & i10 == 0) {
                i5 = traceInProgress2.changed(interactionSource) ? 1048576 : 524288;
                $dirty2 |= i5;
            } else {
                obj = interactionSource;
            }
        }
        i6 = 12582912;
        if (i55 & i6 == 0) {
            if (i56 & 128 == 0) {
                $dirty6 = $dirty2;
                obj43 = i31;
                changed = traceInProgress2.changed(selectedContentColor) ? 8388608 : 4194304;
            } else {
                $dirty6 = $dirty2;
                obj43 = i31;
                $dirty = selectedContentColor;
            }
            $dirty6 |= changed;
        } else {
            $dirty3 = $dirty2;
            obj43 = i31;
            $dirty = selectedContentColor;
        }
        if (i55 & i57 == 0) {
            if (i56 & 256 == 0) {
                i8 = traceInProgress2.changed($composer) ? 67108864 : 33554432;
            } else {
                l4 = $composer;
            }
            $dirty3 = i17 | i8;
        } else {
            l4 = $composer;
            i17 = $dirty3;
        }
        selectedContentColor2 = $dirty3;
        if (selectedContentColor2 & unselectedContentColor2 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i25 = -234881025;
                int i32 = -29360129;
                if (i55 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (obj43 != null) {
                            obj6 = defaultsInvalid;
                        }
                        if (localContentColor != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (i15 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (rememberComposableLambda != 0) {
                            obj9 = defaultsInvalid;
                        }
                        interactionSource2 = i19 != 0 ? 0 : interactionSource;
                        if (i56 & 128 != 0) {
                            i15 = 6;
                            rememberComposableLambda = 0;
                            obj43 = i25;
                            ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                            i21 = selectedContentColor2 & i32;
                            l5 = unbox-impl;
                        } else {
                            obj43 = i25;
                            l5 = selectedContentColor;
                            i21 = selectedContentColor2;
                        }
                        if (i56 & 256 != 0) {
                            l2 = copy-wmQWz5c$default;
                            l6 = l;
                            unselectedContentColor2 = interactionSource2;
                            $dirty4 = $dirty8;
                            $dirty7 = i6;
                            i6 = z2;
                        } else {
                            unselectedContentColor2 = interactionSource2;
                            $dirty4 = i21;
                            $dirty7 = i6;
                            l6 = l5;
                            l2 = $composer;
                            i6 = z2;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty4 = i56 & 128 != 0 ? selectedContentColor2 & i32 : selectedContentColor2;
                        if (i56 & 256 != 0) {
                            $dirty4 &= i25;
                            unselectedContentColor2 = interactionSource;
                            l6 = selectedContentColor;
                            l2 = $composer;
                            $dirty7 = i6;
                            i6 = z2;
                        } else {
                            unselectedContentColor2 = interactionSource;
                            l6 = selectedContentColor;
                            l2 = $composer;
                            $dirty7 = i6;
                            i6 = z2;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, $dirty4, -1, "androidx.compose.material.Tab (Tab.kt:98)");
                }
                int i33 = 54;
                int i45 = 1;
                if (obj8 == null) {
                    traceInProgress2.startReplaceGroup(1041201080);
                    traceInProgress2.endReplaceGroup();
                    it = 0;
                } else {
                    traceInProgress2.startReplaceGroup(1041201081);
                    ComposerKt.sourceInformation(traceInProgress2, "*100@4526L154");
                    Object obj11 = obj8;
                    i15 = 0;
                    TabKt.Tab.styledText.1.1 anon2 = new TabKt.Tab.styledText.1.1(obj8);
                    it = rememberComposableLambda;
                    traceInProgress2.endReplaceGroup();
                }
                TabKt.Tab.1 anon = new TabKt.Tab.1(it, obj9);
                i10 = obj6;
                TabKt.Tab-EVJuX4I(z, obj5, i10, i6, unselectedContentColor2, l6, unbox-impl, l2, l5, (Function3)ComposableLambdaKt.rememberComposableLambda(-178151495, i45, anon, traceInProgress2, i33), traceInProgress2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj3 = obj8;
                obj7 = obj9;
                obj2 = i10;
                z3 = i6;
                obj4 = unselectedContentColor2;
                text2 = l6;
                icon2 = l2;
                selectedContentColor2 = $dirty4;
            } else {
                traceInProgress2.skipToGroupEnd();
                obj4 = interactionSource;
                composer = traceInProgress2;
                obj2 = obj6;
                z3 = z2;
                obj3 = obj8;
                obj7 = obj9;
                text2 = selectedContentColor;
                icon2 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = new TabKt.Tab.2(selected, onClick, obj2, z3, obj3, obj7, obj4, text2, rememberComposableLambda, icon2, i19, i55, i56);
            endRestartGroup.updateScope((Function2)$dirty4);
        }
    }

    public static final void Tab-EVJuX4I(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        long l5;
        int unselectedContentColor3;
        int defaultsInvalid;
        int unbox-impl;
        int $dirty2;
        int consume;
        boolean traceInProgress;
        int i17;
        Object obj;
        int i5;
        long l7;
        int i8;
        Object unselectedContentColor2;
        Object i4;
        boolean z2;
        boolean z3;
        Object obj3;
        int i15;
        int str;
        long l6;
        boolean i10;
        long l4;
        int i2;
        int i7;
        Object obj6;
        int i;
        long l2;
        Composer composer;
        Object obj4;
        int changed;
        int i6;
        Object obj2;
        int $dirty3;
        Object $dirty;
        int i14;
        boolean changed2;
        int i3;
        androidx.compose.foundation.Indication rippleOrFallbackImplementation-9IZ8Weo;
        boolean z;
        Function0 function0;
        long l3;
        Object obj5;
        float medium;
        int i12;
        int i16;
        int i9;
        int i13;
        int i18;
        long l;
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
        $dirty2 = obj41;
        if (i46 & 1 != 0) {
            $dirty2 |= 6;
            z3 = selected;
        } else {
            if (i45 & 6 == 0) {
                i17 = restartGroup.changed(selected) ? 4 : 2;
                $dirty2 |= i17;
            } else {
                z3 = selected;
            }
        }
        if (i46 & 2 != 0) {
            $dirty2 |= 48;
            obj = onClick;
        } else {
            if (i45 & 48 == 0) {
                i5 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                obj = onClick;
            }
        }
        i8 = i46 & 4;
        if (i8 != 0) {
            $dirty2 |= 384;
            i4 = modifier;
        } else {
            if (i45 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                i4 = modifier;
            }
        }
        str = i46 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            i10 = enabled;
        } else {
            if (i45 & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                i10 = enabled;
            }
        }
        i7 = i46 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            obj6 = interactionSource;
        } else {
            if (i45 & 24576 == 0) {
                i = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i;
            } else {
                obj6 = interactionSource;
            }
        }
        if (i47 &= i45 == 0) {
            if (i46 & 32 == 0) {
                changed = restartGroup.changed(selectedContentColor) ? 131072 : 65536;
            } else {
                l2 = selectedContentColor;
            }
            $dirty2 |= changed;
        } else {
            l2 = selectedContentColor;
        }
        if (i50 &= i45 == 0) {
            if (i46 & 64 == 0) {
                obj40 = $dirty2;
                i14 = restartGroup.changed(content) ? 1048576 : 524288;
            } else {
                obj40 = $dirty2;
                l5 = content;
            }
            $dirty3 = obj40 | i14;
        } else {
            l5 = content;
            $dirty3 = obj40;
        }
        i3 = 12582912;
        if (i46 & 128 != 0) {
            $dirty3 |= i3;
            obj2 = $changed;
        } else {
            if (i45 & i3 == 0) {
                i3 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty3 |= i3;
            } else {
                obj2 = $changed;
            }
        }
        if ($dirty3 & rippleOrFallbackImplementation-9IZ8Weo == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i53 = -458753;
                int i54 = -3670017;
                if (i45 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i8 != 0) {
                            i4 = defaultsInvalid;
                        }
                        if (str != null) {
                            i10 = defaultsInvalid;
                        }
                        if (i7 != 0) {
                            obj6 = defaultsInvalid;
                        }
                        if (i46 & 32 != 0) {
                            i8 = 6;
                            str = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty3 &= i53;
                            l3 = unbox-impl;
                        } else {
                            l3 = l2;
                        }
                        if (i46 & 64 != 0) {
                            obj4 = i4;
                            z = i10;
                            $dirty = obj6;
                            unselectedContentColor3 = i28;
                            l7 = l;
                        } else {
                            obj4 = i4;
                            z = i10;
                            unselectedContentColor3 = $dirty3;
                            l7 = content;
                            $dirty = obj6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i46 & 32 != 0) {
                            $dirty3 &= i53;
                        }
                        if (i46 & 64 != 0) {
                            unselectedContentColor3 = $dirty3 & i54;
                            z = i10;
                            $dirty = obj6;
                            l3 = l2;
                            obj4 = i4;
                            l7 = content;
                        } else {
                            z = i10;
                            l3 = l2;
                            unselectedContentColor3 = $dirty3;
                            obj4 = i4;
                            $dirty = obj6;
                            l7 = content;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(713679175, unselectedContentColor3, -1, "androidx.compose.material.Tab (Tab.kt:230)");
                }
                int i55 = 6;
                int i38 = 1;
                obj34 = l3;
                consume = obj34;
                TabKt.Tab.3 anon = new TabKt.Tab.3(obj4, z3, $dirty, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(i38, 0, obj34, selectedContentColor, restartGroup, i24 |= 6), z, onClick, obj2);
                TabKt.TabTransition-Klgx-Pg(consume, obj, l7, i4, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-1237246709, i38, anon, restartGroup, 54));
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l6 = consume;
                l4 = l7;
                unselectedContentColor2 = obj4;
                obj3 = $dirty;
                z2 = z;
                $dirty3 = unselectedContentColor3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                l6 = l;
                unselectedContentColor2 = i4;
                z2 = i10;
                obj3 = obj6;
                l4 = content;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            unselectedContentColor3 = new TabKt.Tab.4(selected, onClick, unselectedContentColor2, z2, obj3, l6, restartGroup, l4, i7, $changed, i45, i46);
            endRestartGroup.updateScope((Function2)unselectedContentColor3);
        }
    }

    private static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        int traceInProgress;
        int i6;
        Integer valueOf3;
        Composer restartGroup;
        int $dirty2;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        int i10;
        int i2;
        boolean materialized$iv$iv;
        boolean traceInProgress2;
        int i16;
        int valueOf;
        Composer composer5;
        int factory$iv$iv2;
        boolean valueOf2;
        Integer maybeCachedBoxMeasurePolicy;
        int str2;
        int str;
        Composer composer;
        Object currentCompositionLocalMap3;
        int $i$a$LayoutBoxKt$Box$1$iv;
        Composer composer3;
        Object currentCompositionLocalMap;
        int materializeModifier;
        androidx.compose.ui.layout.MeasurePolicy currentCompositeKeyHash2;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        Modifier materializeModifier2;
        int i24;
        Composer composer6;
        int i23;
        int i8;
        int i15;
        int i12;
        int i11;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        int i7;
        int i20;
        int $dirty;
        int i21;
        Function0 factory$iv$iv;
        int i4;
        androidx.compose.ui.Modifier.Companion companion;
        int i14;
        int i;
        int i17;
        int i5;
        int currentCompositeKeyHash;
        Object obj;
        int i19;
        Modifier modifier;
        Function0 $changed$iv;
        int i3;
        int i25;
        Composer composer7;
        int i13;
        int i9;
        int i22;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer4;
        int i18;
        int obj53;
        final Object obj2 = text;
        final Object obj3 = icon;
        final int i26 = $changed;
        traceInProgress = 1249848471;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TabBaselineLayout)P(1)314@13013L1593,303@12689L1917:Tab.kt#jmzs0o");
        factory$iv$iv2 = 4;
        if (i26 & 6 == 0) {
            i10 = restartGroup.changedInstance(obj2) ? factory$iv$iv2 : 2;
            $dirty2 |= i10;
        }
        str = 32;
        if (i26 & 48 == 0) {
            i2 = restartGroup.changedInstance(obj3) ? str : 16;
            $dirty2 |= i2;
        }
        if ($dirty2 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:302)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1014675191, "CC(remember):Tab.kt#9igjgp");
                int i58 = 0;
                i6 = $dirty2 & 14 == factory$iv$iv2 ? i16 : i58;
                if ($dirty2 & 112 == str) {
                } else {
                    i16 = i58;
                }
                Composer composer8 = restartGroup;
                int i51 = 0;
                Object rememberedValue4 = composer8.rememberedValue();
                int i64 = 0;
                if (i6 |= i16 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        currentCompositeKeyHash2 = 0;
                        anon = new TabKt.TabBaselineLayout.2.1(obj2, obj3);
                        composer8.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i30 = i58;
                valueOf = 0;
                str = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                materializeModifier = Modifier.Companion;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i58);
                i60 |= 6;
                Function0 function0 = constructor;
                i24 = 0;
                str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str2);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function0);
                } else {
                    factory$iv$iv2 = function0;
                    restartGroup.useNode();
                }
                i23 = i30;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i71 = 0;
                composer2 = restartGroup;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                boxScopeInstance = 0;
                Composer composer10 = constructor-impl;
                i20 = 0;
                if (!composer10.getInserting()) {
                    $dirty = $dirty2;
                    i21 = valueOf;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer10;
                    }
                } else {
                    $dirty = $dirty2;
                    i21 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)materializeModifier), ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer2;
                i11 = i32;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -238768079, "C:Tab.kt#jmzs0o");
                String str3 = "C73@3429L9:Box.kt#2w3rfo";
                materialized$iv$iv = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i7 = i36;
                if (obj2 != null) {
                    restartGroup.startReplaceGroup(-238754006);
                    ComposerKt.sourceInformation(restartGroup, "306@12755L123");
                    factory$iv$iv = factory$iv$iv2;
                    i4 = $i$a$LayoutBoxKt$Box$1$iv;
                    companion = materializeModifier;
                    i14 = currentCompositeKeyHash2;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "text"), TabKt.HorizontalTextPadding, 0, 2, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i67 = 0;
                    i15 = i54;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i67);
                    i17 = 0;
                    i5 = i61;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    obj = topStart2;
                    modifier = padding-VpY3zN4$default;
                    Function0 function03 = constructor3;
                    i19 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str2);
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
                    i13 = i67;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i77 = 0;
                    Composer composer12 = constructor-impl2;
                    int i78 = 0;
                    if (!composer12.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(composer12.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer12.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer12;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        map = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(restartGroup, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                    Composer composer9 = restartGroup;
                    ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, str3);
                    currentCompositeKeyHash2 = BoxScopeInstance.INSTANCE;
                    i76 |= 6;
                    i9 = 0;
                    i22 = i46;
                    i18 = i63;
                    $i$a$LayoutBoxKt$Box$1$iv = composer7;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 138815969, "C308@12870L6:Tab.kt#jmzs0o");
                    obj2.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf($dirty & 14));
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    i4 = $i$a$LayoutBoxKt$Box$1$iv;
                    companion = materializeModifier;
                    i14 = currentCompositeKeyHash2;
                    restartGroup.startReplaceGroup(-238605051);
                    restartGroup.endReplaceGroup();
                }
                if (obj3 != null) {
                    restartGroup.startReplaceGroup(-238572036);
                    ComposerKt.sourceInformation(restartGroup, "311@12941L41");
                    Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                    valueOf2 = 6;
                    $i$a$LayoutBoxKt$Box$1$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i20 = 0;
                    i = topStart;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str);
                    currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                    obj53 = currentCompositeKeyHash3;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, layoutId);
                    i17 = layoutId;
                    Function0 function02 = constructor2;
                    i8 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str2);
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
                    Updater.set-impl(constructor-impl3, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i73 = 0;
                    Composer composer11 = constructor-impl3;
                    modifier = 0;
                    if (!composer11.getInserting()) {
                        $changed$iv = valueOf2;
                        i3 = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(obj53))) {
                            composer11.updateRememberedValue(Integer.valueOf(obj53));
                            constructor-impl3.apply(Integer.valueOf(obj53), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer11;
                        }
                    } else {
                        $changed$iv = valueOf2;
                        i3 = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    factory$iv$iv2 = restartGroup;
                    str2 = 0;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv2, -2146769399, str3);
                    i57 |= 6;
                    i12 = 0;
                    boxScopeInstance = iNSTANCE;
                    i5 = i41;
                    i19 = materializeModifier3;
                    materialized$iv$iv = composer6;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 138919137, "C311@12974L6:Tab.kt#jmzs0o");
                    obj3.invoke(materialized$iv$iv, Integer.valueOf(i33 &= 14));
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                    ComposerKt.sourceInformationMarkerEnd(factory$iv$iv2);
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
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                $dirty = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new TabKt.TabBaselineLayout.3(obj2, obj3, i26);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress3;
        long l;
        int $dirty;
        long l2;
        long l4;
        int i;
        int i6;
        boolean z;
        Object invoke;
        int $changed$iv$iv2;
        boolean changed;
        int i4;
        boolean traceInProgress5;
        long l5;
        int i5;
        long l3;
        Color box-impl;
        int i3;
        int i12;
        boolean transitionSpec$iv;
        boolean traceInProgress;
        Composer animationSpec$iv$iv;
        long l6;
        String str;
        Composer restartGroup;
        int i10;
        int i8;
        int i2;
        int i7;
        int i9;
        int $dirty2;
        Transition transition;
        androidx.compose.ui.graphics.colorspace.ColorSpace $composer2;
        Object traceInProgress2;
        boolean z2;
        boolean invalid$iv$iv;
        int i11;
        int $changed$iv$iv;
        boolean traceInProgress4;
        androidx.compose.material.TabKt.TabTransition.color.2 anon;
        Composer obj34;
        final Object obj2 = $changed;
        final int i34 = obj35;
        traceInProgress3 = -405571117;
        restartGroup = obj34.startRestartGroup(traceInProgress3);
        ComposerKt.sourceInformation(restartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)267@11507L26,268@11562L550,286@12117L164:Tab.kt#jmzs0o");
        i4 = 2;
        if (i34 & 6 == 0) {
            i = restartGroup.changed(activeColor) ? 4 : i4;
            $dirty |= i;
        } else {
            l5 = activeColor;
        }
        if (i34 & 48 == 0) {
            i6 = restartGroup.changed(selected) ? 32 : 16;
            $dirty |= i6;
        } else {
            l3 = selected;
        }
        if (i34 & 384 == 0) {
            i3 = restartGroup.changed($composer) ? 256 : 128;
            $dirty |= i3;
        } else {
            z = $composer;
        }
        if (i34 & 3072 == 0) {
            i12 = restartGroup.changedInstance(obj2) ? 2048 : 1024;
            $dirty |= i12;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress3, $dirty, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
                }
                Transition transition2 = TransitionKt.updateTransition(Boolean.valueOf(z), 0, restartGroup, i36 &= 14, i4);
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
                    $dirty2 = $dirty;
                    ComposerKt.traceEventStart(1445938070, i51 &= 112, -1, transition3);
                } else {
                    $dirty2 = $dirty;
                }
                l2 = (Boolean)transition5.getTargetState().booleanValue() ? l5 : l3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer2.endReplaceGroup();
                androidx.compose.ui.graphics.colorspace.ColorSpace colorSpace-impl = Color.getColorSpace-impl(l2);
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
                l4 = (Boolean)transition4.getCurrentState().booleanValue() ? l5 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer5.endReplaceGroup();
                box-impl = Color.box-impl(l4);
                Composer composer4 = restartGroup;
                int i54 = 0;
                int it = 1445938070;
                composer4.startReplaceGroup(it);
                ComposerKt.sourceInformation(composer4, str3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(it, i21 &= 112, -1, transition3);
                }
                l = (Boolean)transition4.getTargetState().booleanValue() ? l5 : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                Object obj3 = invoke2;
                androidx.compose.material.TabKt.TabTransition.color.2 targetValue$iv$iv = anon;
                $dirty = TransitionKt.createTransitionAnimation(transition4, box-impl, Color.box-impl(l), (FiniteAnimationSpec)obj3, (TwoWayConverter)invoke, str, restartGroup, i15 | i28);
                Object obj = obj3;
                animationSpec$iv$iv = restartGroup;
                ComposerKt.sourceInformationMarkerEnd(animationSpec$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(animationSpec$iv$iv);
                ProvidedValue[] arr = new ProvidedValue[2];
                CompositionLocalKt.CompositionLocalProvider(arr, obj2, animationSpec$iv$iv, $stable |= i4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = $dirty;
                animationSpec$iv$iv = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = animationSpec$iv$iv.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress3 = new TabKt.TabTransition.1(l5, z, selected, l5, $composer, obj2, i34);
            endRestartGroup.updateScope((Function2)traceInProgress3);
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
