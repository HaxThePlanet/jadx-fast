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
        int i3;
        int skipping;
        int defaultsInvalid;
        int localContentColor;
        Object endRestartGroup;
        int changed2;
        Composer traceInProgress;
        int $dirty4;
        long $dirty2;
        long l3;
        int i8;
        boolean z4;
        int consume;
        boolean traceInProgress2;
        int i5;
        Object obj6;
        int i11;
        Object obj9;
        Object obj;
        int i18;
        Object obj3;
        boolean z;
        int i19;
        int i13;
        long l;
        Object obj8;
        Object obj5;
        long l5;
        int i14;
        int str;
        boolean z2;
        long l2;
        int i4;
        int i2;
        Object obj2;
        Composer $composer2;
        int i;
        int $dirty3;
        Object $dirty;
        int i15;
        int changed;
        int i17;
        int unselectedContentColor2;
        long rippleOrFallbackImplementation-9IZ8Weo;
        boolean z3;
        long l4;
        Object obj4;
        long obj7;
        float medium;
        int i9;
        int i6;
        int i16;
        int i10;
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
        traceInProgress = i12.startRestartGroup(-1499861761);
        ComposerKt.sourceInformation(traceInProgress, "C(LeadingIconTab)P(5,4,7,1,3!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)158@6852L7,159@6944L6,164@7192L76,166@7344L859,166@7274L929:Tab.kt#jmzs0o");
        $dirty4 = obj40;
        if (i53 & 1 != 0) {
            $dirty4 |= 6;
            z4 = selected;
        } else {
            if (i52 & 6 == 0) {
                i5 = traceInProgress.changed(selected) ? 4 : 2;
                $dirty4 |= i5;
            } else {
                z4 = selected;
            }
        }
        if (i53 & 2 != 0) {
            $dirty4 |= 48;
            obj6 = onClick;
        } else {
            if (i52 & 48 == 0) {
                i11 = traceInProgress.changedInstance(onClick) ? 32 : 16;
                $dirty4 |= i11;
            } else {
                obj6 = onClick;
            }
        }
        if (i53 & 4 != 0) {
            $dirty4 |= 384;
            obj9 = text;
        } else {
            if (i52 & 384 == 0) {
                i18 = traceInProgress.changedInstance(text) ? 256 : 128;
                $dirty4 |= i18;
            } else {
                obj9 = text;
            }
        }
        if (i53 & 8 != 0) {
            $dirty4 |= 3072;
            obj3 = icon;
        } else {
            if (i52 & 3072 == 0) {
                i19 = traceInProgress.changedInstance(icon) ? 2048 : 1024;
                $dirty4 |= i19;
            } else {
                obj3 = icon;
            }
        }
        i13 = i53 & 16;
        if (i13 != 0) {
            $dirty4 |= 24576;
            obj5 = modifier;
        } else {
            if (i52 & 24576 == 0) {
                i14 = traceInProgress.changed(modifier) ? 16384 : 8192;
                $dirty4 |= i14;
            } else {
                obj5 = modifier;
            }
        }
        str = i53 & 32;
        int i49 = 196608;
        if (str != null) {
            $dirty4 |= i49;
            z2 = enabled;
        } else {
            if (i49 &= i52 == 0) {
                i4 = traceInProgress.changed(enabled) ? 131072 : 65536;
                $dirty4 |= i4;
            } else {
                z2 = enabled;
            }
        }
        i2 = i53 & 64;
        int i54 = 1572864;
        if (i2 != 0) {
            $dirty4 |= i54;
            obj2 = interactionSource;
        } else {
            if (i54 &= i52 == 0) {
                i = traceInProgress.changed(interactionSource) ? 1048576 : 524288;
                $dirty4 |= i;
            } else {
                obj2 = interactionSource;
            }
        }
        if (i56 &= i52 == 0) {
            if (i53 & 128 == 0) {
                obj39 = $dirty4;
                i15 = traceInProgress.changed(selectedContentColor) ? 8388608 : 4194304;
            } else {
                obj39 = $dirty4;
                $dirty2 = selectedContentColor;
            }
            $dirty3 = obj39 | i15;
        } else {
            $dirty2 = selectedContentColor;
            $dirty3 = obj39;
        }
        if (i52 & i58 == 0) {
            if (i53 & 256 == 0) {
                i3 = traceInProgress.changed($composer) ? 67108864 : 33554432;
            } else {
                l3 = $composer;
            }
            $dirty3 |= i3;
        } else {
            l3 = $composer;
        }
        if (i20 &= $dirty3 == 38347922) {
            if (!traceInProgress.getSkipping()) {
                traceInProgress.startDefaults();
                consume = -29360129;
                obj39 = -234881025;
                int i24 = 6;
                if (i52 & 1 != 0) {
                    if (traceInProgress.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (str != null) {
                            z2 = defaultsInvalid;
                        }
                        if (i2 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i53 & 128 != 0) {
                            i13 = 6;
                            str = 0;
                            ComposerKt.sourceInformationMarkerStart(traceInProgress, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(traceInProgress);
                            $dirty3 &= unselectedContentColor2;
                            l4 = rippleOrFallbackImplementation-9IZ8Weo;
                        } else {
                            l4 = selectedContentColor;
                        }
                        if (i53 & 256 != 0) {
                            skipping = $dirty3 & obj39;
                            $dirty = obj5;
                            z3 = z2;
                            l = copy-wmQWz5c$default;
                            unselectedContentColor2 = obj2;
                        } else {
                            z3 = z2;
                            unselectedContentColor2 = obj2;
                            skipping = $dirty3;
                            $dirty = obj5;
                            l = $composer;
                        }
                    } else {
                        traceInProgress.skipToGroupEnd();
                        if (i53 & 128 != 0) {
                            $dirty3 &= consume;
                        }
                        if (i53 & 256 != 0) {
                            skipping = $dirty3 & obj39;
                            l4 = selectedContentColor;
                            $dirty = obj5;
                            z3 = z2;
                            unselectedContentColor2 = obj2;
                            l = $composer;
                        } else {
                            l4 = selectedContentColor;
                            z3 = z2;
                            unselectedContentColor2 = obj2;
                            skipping = $dirty3;
                            $dirty = obj5;
                            l = $composer;
                        }
                    }
                } else {
                }
                traceInProgress.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1499861761, skipping, -1, "androidx.compose.material.LeadingIconTab (Tab.kt:160)");
                }
                obj33 = i51;
                obj34 = l4;
                i8 = obj34;
                TabKt.LeadingIconTab.1 anon = new TabKt.LeadingIconTab.1($dirty, selected, unselectedContentColor2, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(true, obj33, obj34, selectedContentColor, traceInProgress, i24 |= i29), z3, obj6, obj3, obj9);
                obj38 = traceInProgress;
                obj34 = l;
                TabKt.TabTransition-Klgx-Pg(i8, obj33, obj34, selectedContentColor, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(866677691, true, anon, traceInProgress, 54));
                $composer2 = obj38;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l5 = i8;
                l2 = obj6;
                obj = $dirty;
                obj8 = unselectedContentColor2;
                z = z3;
                $dirty3 = skipping;
            } else {
                traceInProgress.skipToGroupEnd();
                obj = obj5;
                z = z2;
                obj8 = obj2;
                l5 = selectedContentColor;
                l2 = $composer;
                $composer2 = traceInProgress;
            }
        } else {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            obj36 = $composer2;
            endRestartGroup = new TabKt.LeadingIconTab.2(selected, onClick, text, icon, obj, z, obj8, l5, str, l2, i2, i52, i53);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj36 = $composer2;
        }
    }

    public static final void Tab-0nD-MI0(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Composer $composer, int $changed, int i12) {
        Object obj9;
        int $dirty6;
        int $dirty7;
        boolean $dirty5;
        int defaultsInvalid;
        int interactionSource2;
        int i8;
        int $dirty3;
        Composer traceInProgress2;
        int $dirty4;
        long $dirty2;
        long l3;
        int i10;
        int i16;
        int $dirty;
        int i6;
        int i7;
        Object obj4;
        androidx.compose.material.ContentAlpha iNSTANCE;
        boolean traceInProgress;
        Object obj5;
        boolean z2;
        int i21;
        Object obj2;
        int localContentColor;
        boolean z;
        Object obj6;
        androidx.compose.runtime.internal.ComposableLambda it;
        int i11;
        int obj7;
        int i13;
        Object obj8;
        long text2;
        int i9;
        int rememberComposableLambda;
        Object obj3;
        long icon2;
        int i4;
        int i14;
        boolean z3;
        Object obj;
        int i20;
        int i2;
        int i19;
        int changed;
        int i;
        int unselectedContentColor2;
        int selectedContentColor2;
        long l;
        long unbox-impl;
        long l2;
        long l4;
        long l5;
        Composer composer;
        float medium;
        int i18;
        int i5;
        int i3;
        int i17;
        int i15;
        long l6;
        int obj43;
        final int i55 = obj44;
        final int i56 = obj45;
        traceInProgress2 = i12.startRestartGroup(-1486097588);
        ComposerKt.sourceInformation(traceInProgress2, "C(Tab)P(5,4,3!1,7!2,6:c#ui.graphics.Color,8:c#ui.graphics.Color)96@4342L7,97@4434L6,113@4860L65,105@4691L234:Tab.kt#jmzs0o");
        $dirty4 = obj44;
        if (i56 & 1 != 0) {
            $dirty4 |= 6;
            z3 = selected;
        } else {
            if (i55 & 6 == 0) {
                i6 = traceInProgress2.changed(selected) ? 4 : 2;
                $dirty4 |= i6;
            } else {
                z3 = selected;
            }
        }
        if (i56 & 2 != 0) {
            $dirty4 |= 48;
            obj = onClick;
        } else {
            if (i55 & 48 == 0) {
                i7 = traceInProgress2.changedInstance(onClick) ? 32 : 16;
                $dirty4 |= i7;
            } else {
                obj = onClick;
            }
        }
        int i31 = i56 & 4;
        if (i31 != 0) {
            $dirty4 |= 384;
            obj5 = modifier;
        } else {
            if (i55 & 384 == 0) {
                i21 = traceInProgress2.changed(modifier) ? 256 : 128;
                $dirty4 |= i21;
            } else {
                obj5 = modifier;
            }
        }
        localContentColor = i56 & 8;
        if (localContentColor != 0) {
            $dirty4 |= 3072;
            z = enabled;
        } else {
            if (i55 & 3072 == 0) {
                i11 = traceInProgress2.changed(enabled) ? 2048 : 1024;
                $dirty4 |= i11;
            } else {
                z = enabled;
            }
        }
        i13 = i56 & 16;
        if (i13 != 0) {
            $dirty4 |= 24576;
            obj8 = text;
        } else {
            if (i55 & 24576 == 0) {
                i9 = traceInProgress2.changedInstance(text) ? 16384 : 8192;
                $dirty4 |= i9;
            } else {
                obj8 = text;
            }
        }
        rememberComposableLambda = i56 & 32;
        int i53 = 196608;
        if (rememberComposableLambda != 0) {
            $dirty4 |= i53;
            obj3 = icon;
        } else {
            if (i53 &= i55 == 0) {
                i4 = traceInProgress2.changedInstance(icon) ? 131072 : 65536;
                $dirty4 |= i4;
            } else {
                obj3 = icon;
            }
        }
        i14 = i56 & 64;
        i20 = 1572864;
        if (i14 != 0) {
            $dirty4 |= i20;
            obj9 = interactionSource;
        } else {
            if (i55 & i20 == 0) {
                i2 = traceInProgress2.changed(interactionSource) ? 1048576 : 524288;
                $dirty4 |= i2;
            } else {
                obj9 = interactionSource;
            }
        }
        i19 = 12582912;
        if (i55 & i19 == 0) {
            if (i56 & 128 == 0) {
                $dirty6 = $dirty4;
                obj43 = i31;
                changed = traceInProgress2.changed(selectedContentColor) ? 8388608 : 4194304;
            } else {
                $dirty6 = $dirty4;
                obj43 = i31;
                $dirty2 = selectedContentColor;
            }
            $dirty6 |= changed;
        } else {
            $dirty7 = $dirty4;
            obj43 = i31;
            $dirty2 = selectedContentColor;
        }
        if (i55 & i57 == 0) {
            if (i56 & 256 == 0) {
                i8 = traceInProgress2.changed($composer) ? 67108864 : 33554432;
            } else {
                l3 = $composer;
            }
            $dirty7 = i | i8;
        } else {
            l3 = $composer;
            i = $dirty7;
        }
        selectedContentColor2 = $dirty7;
        if (selectedContentColor2 & unselectedContentColor2 == 38347922) {
            if (!traceInProgress2.getSkipping()) {
                traceInProgress2.startDefaults();
                int i25 = -234881025;
                int i32 = -29360129;
                if (i55 & 1 != 0) {
                    if (traceInProgress2.getDefaultsInvalid()) {
                        if (obj43 != null) {
                            obj5 = defaultsInvalid;
                        }
                        if (localContentColor != 0) {
                            z = defaultsInvalid;
                        }
                        if (i13 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (rememberComposableLambda != 0) {
                            obj3 = defaultsInvalid;
                        }
                        interactionSource2 = i14 != 0 ? 0 : interactionSource;
                        if (i56 & 128 != 0) {
                            i13 = 6;
                            rememberComposableLambda = 0;
                            obj43 = i25;
                            ComposerKt.sourceInformationMarkerStart(traceInProgress2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(traceInProgress2);
                            i16 = selectedContentColor2 & i32;
                            l4 = unbox-impl;
                        } else {
                            obj43 = i25;
                            l4 = selectedContentColor;
                            i16 = selectedContentColor2;
                        }
                        if (i56 & 256 != 0) {
                            l2 = copy-wmQWz5c$default;
                            l = l6;
                            unselectedContentColor2 = interactionSource2;
                            $dirty5 = $dirty8;
                            $dirty = i19;
                            i19 = z;
                        } else {
                            unselectedContentColor2 = interactionSource2;
                            $dirty5 = i16;
                            $dirty = i19;
                            l = l4;
                            l2 = $composer;
                            i19 = z;
                        }
                    } else {
                        traceInProgress2.skipToGroupEnd();
                        $dirty5 = i56 & 128 != 0 ? selectedContentColor2 & i32 : selectedContentColor2;
                        if (i56 & 256 != 0) {
                            $dirty5 &= i25;
                            unselectedContentColor2 = interactionSource;
                            l = selectedContentColor;
                            l2 = $composer;
                            $dirty = i19;
                            i19 = z;
                        } else {
                            unselectedContentColor2 = interactionSource;
                            l = selectedContentColor;
                            l2 = $composer;
                            $dirty = i19;
                            i19 = z;
                        }
                    }
                } else {
                }
                traceInProgress2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1486097588, $dirty5, -1, "androidx.compose.material.Tab (Tab.kt:98)");
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
                    i13 = 0;
                    TabKt.Tab.styledText.1.1 anon2 = new TabKt.Tab.styledText.1.1(obj8);
                    it = rememberComposableLambda;
                    traceInProgress2.endReplaceGroup();
                }
                TabKt.Tab.1 anon = new TabKt.Tab.1(it, obj3);
                i20 = obj5;
                TabKt.Tab-EVJuX4I(z3, obj, i20, i19, unselectedContentColor2, l, unbox-impl, l2, l4, (Function3)ComposableLambdaKt.rememberComposableLambda(-178151495, i45, anon, traceInProgress2, i33), traceInProgress2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj2 = obj8;
                obj6 = obj3;
                obj4 = i20;
                z2 = i19;
                obj7 = unselectedContentColor2;
                text2 = l;
                icon2 = l2;
                selectedContentColor2 = $dirty5;
            } else {
                traceInProgress2.skipToGroupEnd();
                obj7 = interactionSource;
                composer = traceInProgress2;
                obj4 = obj5;
                z2 = z;
                obj2 = obj8;
                obj6 = obj3;
                text2 = selectedContentColor;
                icon2 = $composer;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty5 = new TabKt.Tab.2(selected, onClick, obj4, z2, obj2, obj6, obj7, text2, rememberComposableLambda, icon2, i14, i55, i56);
            endRestartGroup.updateScope((Function2)$dirty5);
        }
    }

    public static final void Tab-EVJuX4I(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, long selectedContentColor, long unselectedContentColor, Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i11) {
        long l3;
        int unselectedContentColor3;
        int defaultsInvalid;
        int unbox-impl;
        int $dirty3;
        int consume;
        boolean traceInProgress;
        int i6;
        Object obj6;
        int i13;
        long l2;
        int i;
        Object unselectedContentColor2;
        Object i16;
        boolean z3;
        boolean z;
        Object obj4;
        int i4;
        int str;
        long l;
        boolean i2;
        long l6;
        int i3;
        int i14;
        Object obj3;
        int i18;
        long l7;
        Composer composer;
        Object obj;
        int changed;
        int i10;
        Object obj5;
        int $dirty;
        Object $dirty2;
        int i15;
        boolean changed2;
        int i5;
        androidx.compose.foundation.Indication rippleOrFallbackImplementation-9IZ8Weo;
        boolean z2;
        Function0 function0;
        long l4;
        Object obj2;
        float medium;
        int i9;
        int i7;
        int i12;
        int i8;
        int i17;
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
        $dirty3 = obj41;
        if (i46 & 1 != 0) {
            $dirty3 |= 6;
            z = selected;
        } else {
            if (i45 & 6 == 0) {
                i6 = restartGroup.changed(selected) ? 4 : 2;
                $dirty3 |= i6;
            } else {
                z = selected;
            }
        }
        if (i46 & 2 != 0) {
            $dirty3 |= 48;
            obj6 = onClick;
        } else {
            if (i45 & 48 == 0) {
                i13 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty3 |= i13;
            } else {
                obj6 = onClick;
            }
        }
        i = i46 & 4;
        if (i != 0) {
            $dirty3 |= 384;
            i16 = modifier;
        } else {
            if (i45 & 384 == 0) {
                i4 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty3 |= i4;
            } else {
                i16 = modifier;
            }
        }
        str = i46 & 8;
        if (str != null) {
            $dirty3 |= 3072;
            i2 = enabled;
        } else {
            if (i45 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty3 |= i3;
            } else {
                i2 = enabled;
            }
        }
        i14 = i46 & 16;
        if (i14 != 0) {
            $dirty3 |= 24576;
            obj3 = interactionSource;
        } else {
            if (i45 & 24576 == 0) {
                i18 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty3 |= i18;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i47 &= i45 == 0) {
            if (i46 & 32 == 0) {
                changed = restartGroup.changed(selectedContentColor) ? 131072 : 65536;
            } else {
                l7 = selectedContentColor;
            }
            $dirty3 |= changed;
        } else {
            l7 = selectedContentColor;
        }
        if (i50 &= i45 == 0) {
            if (i46 & 64 == 0) {
                obj40 = $dirty3;
                i15 = restartGroup.changed(content) ? 1048576 : 524288;
            } else {
                obj40 = $dirty3;
                l3 = content;
            }
            $dirty = obj40 | i15;
        } else {
            l3 = content;
            $dirty = obj40;
        }
        i5 = 12582912;
        if (i46 & 128 != 0) {
            $dirty |= i5;
            obj5 = $changed;
        } else {
            if (i45 & i5 == 0) {
                i5 = restartGroup.changedInstance($changed) ? 8388608 : 4194304;
                $dirty |= i5;
            } else {
                obj5 = $changed;
            }
        }
        if ($dirty & rippleOrFallbackImplementation-9IZ8Weo == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i53 = -458753;
                int i54 = -3670017;
                if (i45 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i != 0) {
                            i16 = defaultsInvalid;
                        }
                        if (str != null) {
                            i2 = defaultsInvalid;
                        }
                        if (i14 != 0) {
                            obj3 = defaultsInvalid;
                        }
                        if (i46 & 32 != 0) {
                            i = 6;
                            str = 0;
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty &= i53;
                            l4 = unbox-impl;
                        } else {
                            l4 = l7;
                        }
                        if (i46 & 64 != 0) {
                            obj = i16;
                            z2 = i2;
                            $dirty2 = obj3;
                            unselectedContentColor3 = i28;
                            l2 = l5;
                        } else {
                            obj = i16;
                            z2 = i2;
                            unselectedContentColor3 = $dirty;
                            l2 = content;
                            $dirty2 = obj3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i46 & 32 != 0) {
                            $dirty &= i53;
                        }
                        if (i46 & 64 != 0) {
                            unselectedContentColor3 = $dirty & i54;
                            z2 = i2;
                            $dirty2 = obj3;
                            l4 = l7;
                            obj = i16;
                            l2 = content;
                        } else {
                            z2 = i2;
                            l4 = l7;
                            unselectedContentColor3 = $dirty;
                            obj = i16;
                            $dirty2 = obj3;
                            l2 = content;
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
                obj34 = l4;
                consume = obj34;
                TabKt.Tab.3 anon = new TabKt.Tab.3(obj, z, $dirty2, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(i38, 0, obj34, selectedContentColor, restartGroup, i24 |= 6), z2, onClick, obj5);
                TabKt.TabTransition-Klgx-Pg(consume, obj6, l2, i16, selected, (Function2)ComposableLambdaKt.rememberComposableLambda(-1237246709, i38, anon, restartGroup, 54));
                composer = restartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                l = consume;
                l6 = l2;
                unselectedContentColor2 = obj;
                obj4 = $dirty2;
                z3 = z2;
                $dirty = unselectedContentColor3;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                l = l5;
                unselectedContentColor2 = i16;
                z3 = i2;
                obj4 = obj3;
                l6 = content;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            unselectedContentColor3 = new TabKt.Tab.4(selected, onClick, unselectedContentColor2, z3, obj4, l, restartGroup, l6, i14, $changed, i45, i46);
            endRestartGroup.updateScope((Function2)unselectedContentColor3);
        }
    }

    private static final void TabBaselineLayout(Function2<? super Composer, ? super Integer, Unit> text, Function2<? super Composer, ? super Integer, Unit> icon, Composer $composer, int $changed) {
        int traceInProgress2;
        int i21;
        Integer valueOf2;
        Composer restartGroup;
        int $dirty;
        Function0 factory$iv$iv$iv2;
        Function0 factory$iv$iv$iv;
        int i7;
        int i18;
        boolean materialized$iv$iv;
        boolean traceInProgress;
        int i;
        int valueOf;
        Composer composer5;
        int factory$iv$iv2;
        boolean valueOf3;
        Integer maybeCachedBoxMeasurePolicy;
        int str;
        int str2;
        Composer composer2;
        Object currentCompositionLocalMap3;
        int $i$a$LayoutBoxKt$Box$1$iv;
        Composer composer6;
        Object currentCompositionLocalMap;
        int materializeModifier2;
        androidx.compose.ui.layout.MeasurePolicy currentCompositeKeyHash2;
        Object anon;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        Modifier materializeModifier;
        int i12;
        Composer composer3;
        int i3;
        int i5;
        int i14;
        int i13;
        int i17;
        BoxScopeInstance boxScopeInstance;
        Composer composer4;
        int i19;
        int i6;
        int $dirty2;
        int i16;
        Function0 factory$iv$iv;
        int i9;
        androidx.compose.ui.Modifier.Companion companion;
        int i4;
        int i10;
        int i22;
        int i23;
        int currentCompositeKeyHash;
        Object obj;
        int i8;
        Modifier modifier;
        Function0 $changed$iv;
        int i11;
        int i2;
        Composer composer7;
        int i20;
        int i24;
        int i15;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Composer composer;
        int i25;
        int obj53;
        final Object obj2 = text;
        final Object obj3 = icon;
        final int i26 = $changed;
        traceInProgress2 = 1249848471;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TabBaselineLayout)P(1)314@13013L1593,303@12689L1917:Tab.kt#jmzs0o");
        factory$iv$iv2 = 4;
        if (i26 & 6 == 0) {
            i7 = restartGroup.changedInstance(obj2) ? factory$iv$iv2 : 2;
            $dirty |= i7;
        }
        str2 = 32;
        if (i26 & 48 == 0) {
            i18 = restartGroup.changedInstance(obj3) ? str2 : 16;
            $dirty |= i18;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material.TabBaselineLayout (Tab.kt:302)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1014675191, "CC(remember):Tab.kt#9igjgp");
                int i58 = 0;
                i21 = $dirty & 14 == factory$iv$iv2 ? i : i58;
                if ($dirty & 112 == str2) {
                } else {
                    i = i58;
                }
                Composer composer8 = restartGroup;
                int i51 = 0;
                Object rememberedValue4 = composer8.rememberedValue();
                int i64 = 0;
                if (i21 |= i == 0) {
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
                str2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str2);
                materializeModifier2 = Modifier.Companion;
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i58);
                i60 |= 6;
                Function0 function0 = constructor;
                i12 = 0;
                str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
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
                i3 = i30;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i71 = 0;
                composer4 = restartGroup;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                boxScopeInstance = 0;
                Composer composer10 = constructor-impl;
                i6 = 0;
                if (!composer10.getInserting()) {
                    $dirty2 = $dirty;
                    i16 = valueOf;
                    if (!Intrinsics.areEqual(composer10.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer10.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer10;
                    }
                } else {
                    $dirty2 = $dirty;
                    i16 = valueOf;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)materializeModifier2), ComposeUiNode.Companion.getSetModifier());
                restartGroup = composer4;
                i17 = i32;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -238768079, "C:Tab.kt#jmzs0o");
                String str3 = "C73@3429L9:Box.kt#2w3rfo";
                materialized$iv$iv = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                i19 = i36;
                if (obj2 != null) {
                    restartGroup.startReplaceGroup(-238754006);
                    ComposerKt.sourceInformation(restartGroup, "306@12755L123");
                    factory$iv$iv = factory$iv$iv2;
                    i9 = $i$a$LayoutBoxKt$Box$1$iv;
                    companion = materializeModifier2;
                    i4 = currentCompositeKeyHash2;
                    Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "text"), TabKt.HorizontalTextPadding, 0, 2, 0);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart2 = Alignment.Companion.getTopStart();
                    int i67 = 0;
                    i14 = i54;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, i67);
                    i22 = 0;
                    i23 = i61;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str2);
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    obj = topStart2;
                    modifier = padding-VpY3zN4$default;
                    Function0 function03 = constructor3;
                    i8 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
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
                    i20 = i67;
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
                            composer6 = composer12;
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
                    i24 = 0;
                    i15 = i46;
                    i25 = i63;
                    $i$a$LayoutBoxKt$Box$1$iv = composer7;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 138815969, "C308@12870L6:Tab.kt#jmzs0o");
                    obj2.invoke($i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf($dirty2 & 14));
                    ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer9);
                    restartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    factory$iv$iv = factory$iv$iv2;
                    i9 = $i$a$LayoutBoxKt$Box$1$iv;
                    companion = materializeModifier2;
                    i4 = currentCompositeKeyHash2;
                    restartGroup.startReplaceGroup(-238605051);
                    restartGroup.endReplaceGroup();
                }
                if (obj3 != null) {
                    restartGroup.startReplaceGroup(-238572036);
                    ComposerKt.sourceInformation(restartGroup, "311@12941L41");
                    Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, "icon");
                    valueOf3 = 6;
                    $i$a$LayoutBoxKt$Box$1$iv = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, materialized$iv$iv);
                    Alignment topStart = Alignment.Companion.getTopStart();
                    i6 = 0;
                    i10 = topStart;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str2);
                    currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                    obj53 = currentCompositeKeyHash3;
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(restartGroup, layoutId);
                    i22 = layoutId;
                    Function0 function02 = constructor2;
                    i5 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str);
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
                        $changed$iv = valueOf3;
                        i11 = currentCompositionLocalMap3;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(obj53))) {
                            composer11.updateRememberedValue(Integer.valueOf(obj53));
                            constructor-impl3.apply(Integer.valueOf(obj53), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = composer11;
                        }
                    } else {
                        $changed$iv = valueOf3;
                        i11 = currentCompositionLocalMap3;
                    }
                    Updater.set-impl(constructor-impl3, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                    factory$iv$iv2 = restartGroup;
                    str = 0;
                    ComposerKt.sourceInformationMarkerStart(factory$iv$iv2, -2146769399, str3);
                    i57 |= 6;
                    i13 = 0;
                    boxScopeInstance = iNSTANCE;
                    i23 = i41;
                    i8 = materializeModifier3;
                    materialized$iv$iv = composer3;
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
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer4 = restartGroup;
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new TabKt.TabBaselineLayout.3(obj2, obj3, i26);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void TabTransition-Klgx-Pg(long activeColor, long inactiveColor, boolean selected, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress4;
        long l6;
        int $dirty2;
        long l2;
        long l4;
        int i3;
        int i8;
        boolean z2;
        Object invoke;
        int $changed$iv$iv;
        boolean changed;
        int i9;
        boolean traceInProgress;
        long l;
        int i12;
        long l5;
        Color box-impl;
        int i10;
        int i;
        boolean transitionSpec$iv;
        boolean traceInProgress2;
        Composer animationSpec$iv$iv;
        long l3;
        String str;
        Composer restartGroup;
        int i11;
        int i2;
        int i4;
        int i5;
        int i6;
        int $dirty;
        Transition transition;
        androidx.compose.ui.graphics.colorspace.ColorSpace $composer2;
        Object traceInProgress5;
        boolean z;
        boolean invalid$iv$iv;
        int i7;
        int $changed$iv$iv2;
        boolean traceInProgress3;
        androidx.compose.material.TabKt.TabTransition.color.2 anon;
        Composer obj34;
        final Object obj2 = $changed;
        final int i34 = obj35;
        traceInProgress4 = -405571117;
        restartGroup = obj34.startRestartGroup(traceInProgress4);
        ComposerKt.sourceInformation(restartGroup, "C(TabTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)267@11507L26,268@11562L550,286@12117L164:Tab.kt#jmzs0o");
        i9 = 2;
        if (i34 & 6 == 0) {
            i3 = restartGroup.changed(activeColor) ? 4 : i9;
            $dirty2 |= i3;
        } else {
            l = activeColor;
        }
        if (i34 & 48 == 0) {
            i8 = restartGroup.changed(selected) ? 32 : 16;
            $dirty2 |= i8;
        } else {
            l5 = selected;
        }
        if (i34 & 384 == 0) {
            i10 = restartGroup.changed($composer) ? 256 : 128;
            $dirty2 |= i10;
        } else {
            z2 = $composer;
        }
        if (i34 & 3072 == 0) {
            i = restartGroup.changedInstance(obj2) ? 2048 : 1024;
            $dirty2 |= i;
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress4, $dirty2, -1, "androidx.compose.material.TabTransition (Tab.kt:266)");
                }
                Transition transition2 = TransitionKt.updateTransition(Boolean.valueOf(z2), 0, restartGroup, i36 &= 14, i9);
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
                l2 = (Boolean)transition5.getTargetState().booleanValue() ? l : l5;
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
                        i7 = invalid$iv$iv2;
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
                    $changed$iv$iv2 = $changed$iv$iv;
                    ComposerKt.traceEventStart(colorSpace$iv, i46 &= 112, -1, transition3);
                } else {
                    $changed$iv$iv2 = $changed$iv$iv;
                }
                l4 = (Boolean)transition4.getCurrentState().booleanValue() ? l : selected;
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
                l6 = (Boolean)transition4.getTargetState().booleanValue() ? l : selected;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                Object obj3 = invoke2;
                androidx.compose.material.TabKt.TabTransition.color.2 targetValue$iv$iv = anon;
                $dirty2 = TransitionKt.createTransitionAnimation(transition4, box-impl, Color.box-impl(l6), (FiniteAnimationSpec)obj3, (TwoWayConverter)invoke, str, restartGroup, i15 | i28);
                Object obj = obj3;
                animationSpec$iv$iv = restartGroup;
                ComposerKt.sourceInformationMarkerEnd(animationSpec$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(animationSpec$iv$iv);
                ProvidedValue[] arr = new ProvidedValue[2];
                CompositionLocalKt.CompositionLocalProvider(arr, obj2, animationSpec$iv$iv, $stable |= i9);
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
            traceInProgress4 = new TabKt.TabTransition.1(l, z2, selected, l, $composer, obj2, i34);
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
