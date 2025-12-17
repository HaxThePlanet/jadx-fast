package androidx.compose.material3;

import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.tokens.ColorSchemeKeyTokens;
import androidx.compose.material3.tokens.ShapeKeyTokens;
import androidx.compose.material3.tokens.TypographyKeyTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u001aW\u0010 \u001a\u00020!2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010&\u001a\u00020%2\u0008\u0008\u0002\u0010'\u001a\u00020(2\u0008\u0008\u0002\u0010)\u001a\u00020*2\u0011\u0010+\u001a\r\u0012\u0004\u0012\u00020!0,¢\u0006\u0002\u0008-H\u0001ø\u0001\u0000¢\u0006\u0004\u0008.\u0010/\u001a\u009d\u0001\u00100\u001a\u00020!2\u0006\u00101\u001a\u0002022\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020!0,2\u0011\u00104\u001a\r\u0012\u0004\u0012\u00020!0,¢\u0006\u0002\u0008-2\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u00105\u001a\u0002022\u0015\u0008\u0002\u00106\u001a\u000f\u0012\u0004\u0012\u00020!\u0018\u00010,¢\u0006\u0002\u0008-2\u0015\u0008\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020!\u0018\u00010,¢\u0006\u0002\u0008-2\u0008\u0008\u0002\u00108\u001a\u0002092\u0008\u0008\u0002\u0010:\u001a\u00020;2\n\u0008\u0002\u0010<\u001a\u0004\u0018\u00010=H\u0001ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?\u001a\u0018\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020AH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u000cX\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\r\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u0016\u0010\u000e\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u0016\u0010\u0014\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0015\u0010\u0010\"\u0016\u0010\u0016\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0017\u0010\u0010\"\u0016\u0010\u0018\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0019\u0010\u0010\"\u0016\u0010\u001a\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u001b\u0010\u0010\"\u0010\u0010\u001c\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u0010\u0010\u001d\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\"\u0016\u0010\u001e\u001a\u00020\u0007X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u001f\u0010\u0010\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006D", d2 = {"ActiveIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "ActiveIndicatorColor", "ActiveIndicatorShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "ActiveLabelTextColor", "IconSize", "Landroidx/compose/ui/unit/Dp;", "F", "InactiveIconColor", "InactiveLabelTextColor", "LabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "NavigationBarHeight", "StartIconIndicatorHorizontalPadding", "getStartIconIndicatorHorizontalPadding", "()F", "StartIconIndicatorVerticalPadding", "getStartIconIndicatorVerticalPadding", "StartIconItemActiveIndicatorHeight", "StartIconToLabelPadding", "getStartIconToLabelPadding", "TopIconIndicatorHorizontalPadding", "getTopIconIndicatorHorizontalPadding", "TopIconIndicatorToLabelPadding", "getTopIconIndicatorToLabelPadding", "TopIconIndicatorVerticalPadding", "getTopIconIndicatorVerticalPadding", "TopIconItemActiveIndicatorHeight", "TopIconItemActiveIndicatorWidth", "TopIconItemVerticalPadding", "getTopIconItemVerticalPadding", "ExpressiveNavigationBar", "", "modifier", "Landroidx/compose/ui/Modifier;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "windowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "arrangement", "Landroidx/compose/material3/NavigationBarArrangement;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "ExpressiveNavigationBar-NiJtXQ4", "(Landroidx/compose/ui/Modifier;JJLandroidx/compose/foundation/layout/WindowInsets;ILkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ExpressiveNavigationBarItem", "selected", "", "onClick", "icon", "enabled", "label", "badge", "iconPosition", "Landroidx/compose/material3/NavigationItemIconPosition;", "colors", "Landroidx/compose/material3/NavigationItemColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "ExpressiveNavigationBarItem-pli-t6k", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/NavigationItemColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "calculateCenteredContentHorizontalPadding", "", "itemsCount", "barWidth", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ExpressiveNavigationBarKt {

    private static final ColorSchemeKeyTokens ActiveIconColor;
    private static final ColorSchemeKeyTokens ActiveIndicatorColor;
    private static final ShapeKeyTokens ActiveIndicatorShape;
    private static final ColorSchemeKeyTokens ActiveLabelTextColor;
    private static final float IconSize;
    private static final ColorSchemeKeyTokens InactiveIconColor;
    private static final ColorSchemeKeyTokens InactiveLabelTextColor;
    private static final TypographyKeyTokens LabelTextFont;
    private static final float NavigationBarHeight;
    private static final float StartIconIndicatorHorizontalPadding;
    private static final float StartIconIndicatorVerticalPadding;
    private static final float StartIconItemActiveIndicatorHeight;
    private static final float StartIconToLabelPadding;
    private static final float TopIconIndicatorHorizontalPadding;
    private static final float TopIconIndicatorToLabelPadding;
    private static final float TopIconIndicatorVerticalPadding;
    private static final float TopIconItemActiveIndicatorHeight;
    private static final float TopIconItemActiveIndicatorWidth;
    private static final float TopIconItemVerticalPadding;
    static {
        int i17 = 0;
        ExpressiveNavigationBarKt.IconSize = Dp.constructor-impl((float)l);
        int i9 = 0;
        ExpressiveNavigationBarKt.TopIconItemActiveIndicatorWidth = Dp.constructor-impl((float)i);
        int i10 = 0;
        ExpressiveNavigationBarKt.TopIconItemActiveIndicatorHeight = Dp.constructor-impl((float)i2);
        int i11 = 0;
        ExpressiveNavigationBarKt.StartIconItemActiveIndicatorHeight = Dp.constructor-impl((float)i3);
        ExpressiveNavigationBarKt.LabelTextFont = TypographyKeyTokens.LabelMedium;
        ExpressiveNavigationBarKt.ActiveIndicatorShape = ShapeKeyTokens.CornerFull;
        ExpressiveNavigationBarKt.ActiveIconColor = ColorSchemeKeyTokens.Secondary;
        ExpressiveNavigationBarKt.ActiveLabelTextColor = ColorSchemeKeyTokens.Secondary;
        ExpressiveNavigationBarKt.ActiveIndicatorColor = ColorSchemeKeyTokens.SecondaryContainer;
        ExpressiveNavigationBarKt.InactiveIconColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        ExpressiveNavigationBarKt.InactiveLabelTextColor = ColorSchemeKeyTokens.OnSurfaceVariant;
        int i12 = 0;
        ExpressiveNavigationBarKt.NavigationBarHeight = Dp.constructor-impl((float)i4);
        int i13 = 0;
        ExpressiveNavigationBarKt.TopIconItemVerticalPadding = Dp.constructor-impl((float)i5);
        int i18 = 0;
        int i19 = 0;
        ExpressiveNavigationBarKt.TopIconIndicatorVerticalPadding = Dp.constructor-impl(arg0$iv / f10);
        int i20 = 0;
        int i21 = 0;
        ExpressiveNavigationBarKt.TopIconIndicatorHorizontalPadding = Dp.constructor-impl(arg0$iv3 / f11);
        int i22 = 0;
        int i23 = 0;
        ExpressiveNavigationBarKt.StartIconIndicatorVerticalPadding = Dp.constructor-impl(arg0$iv5 / f12);
        int i14 = 0;
        ExpressiveNavigationBarKt.TopIconIndicatorToLabelPadding = Dp.constructor-impl((float)i6);
        int i15 = 0;
        ExpressiveNavigationBarKt.StartIconIndicatorHorizontalPadding = Dp.constructor-impl((float)i7);
        int i16 = 0;
        ExpressiveNavigationBarKt.StartIconToLabelPadding = Dp.constructor-impl((float)i8);
    }

    public static final void ExpressiveNavigationBar-NiJtXQ4(Modifier modifier, long containerColor, long contentColor, WindowInsets windowInsets, int arrangement, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i9) {
        int traceInProgress;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int modifier2;
        Object obj2;
        long arrangement2;
        int arrangement-Ebr7WPU;
        int containerColor2;
        int containerColor3;
        int windowInsets2;
        int i3;
        long l2;
        boolean traceInProgress2;
        Object obj;
        String str;
        int changed3;
        int i11;
        Object obj3;
        int windowInsets3;
        boolean changed4;
        long contentColor2;
        int i4;
        int changed;
        int i10;
        int changed2;
        int i6;
        boolean defaultsInvalid;
        int i5;
        int i2;
        int i8;
        int i12;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i7;
        int i;
        long l;
        final Object obj5 = $changed;
        final int i29 = obj34;
        traceInProgress = -1171105467;
        Composer restartGroup = i9.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ExpressiveNavigationBar)P(4,1:c#ui.graphics.Color,3:c#ui.graphics.Color,5,0:c#material3.NavigationBarArrangement)83@3944L14,84@4018L12,85@4097L12,92@4328L779,89@4244L863:ExpressiveNavigationBar.kt#uh7d8r");
        $dirty2 = obj34;
        modifier2 = obj35 & 1;
        if (modifier2 != 0) {
            $dirty2 |= 6;
            obj2 = modifier;
        } else {
            if (i29 & 6 == 0) {
                i3 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj2 = modifier;
            }
        }
        if (i29 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed3 = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                l2 = containerColor;
            }
            $dirty2 |= changed3;
        } else {
            l2 = containerColor;
        }
        if (i29 & 384 == 0) {
            if (obj35 & 4 == 0) {
                i11 = restartGroup.changed(windowInsets) ? 256 : 128;
            } else {
                contentColor2 = windowInsets;
            }
            $dirty2 |= i11;
        } else {
            contentColor2 = windowInsets;
        }
        if (i29 & 3072 == 0) {
            if (obj35 & 8 == 0) {
                changed = restartGroup.changed(content) ? 2048 : 1024;
            } else {
                obj3 = content;
            }
            $dirty2 |= changed;
        } else {
            obj3 = content;
        }
        if (i29 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                changed2 = restartGroup.changed($composer) ? 16384 : 8192;
            } else {
                i10 = $composer;
            }
            $dirty2 |= changed2;
        } else {
            i10 = $composer;
        }
        int i35 = 196608;
        if (obj35 & 32 != 0) {
            $dirty2 |= i35;
        } else {
            if (i29 & i35 == 0) {
                i6 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
                $dirty2 |= i6;
            }
        }
        if (i34 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i36 = -57345;
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (modifier2 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        defaultsInvalid = 6;
                        if (obj35 & 2 != 0) {
                            $dirty2 &= -113;
                            l2 = containerColor2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColor2 = ExpressiveNavigationBarDefaults.INSTANCE.getContentColor(restartGroup, defaultsInvalid);
                            $dirty2 &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj3 = windowInsets2;
                        }
                        if (obj35 & 16 != 0) {
                            arrangement-Ebr7WPU = ExpressiveNavigationBarDefaults.INSTANCE.getArrangement-Ebr7WPU();
                            $dirty2 &= i36;
                            i10 = l2;
                            i5 = contentColor2;
                        } else {
                            i5 = contentColor2;
                            arrangement-Ebr7WPU = i10;
                            i10 = l2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj35 & 2 != 0) {
                            $dirty2 &= -113;
                        }
                        if (obj35 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (obj35 & 16 != 0) {
                            $dirty2 &= i36;
                        }
                        modifier2 = obj2;
                        i5 = contentColor2;
                        arrangement-Ebr7WPU = i10;
                        i10 = l2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material3.ExpressiveNavigationBar (ExpressiveNavigationBar.kt:88)");
                }
                ExpressiveNavigationBarKt.ExpressiveNavigationBar.1 anon = new ExpressiveNavigationBarKt.ExpressiveNavigationBar.1(modifier2, obj3, arrangement-Ebr7WPU, obj5);
                SurfaceKt.Surface-T9BRK9s(0, 0, i10, defaultsInvalid, i5, obj15, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1573697866, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i4 = $dirty2;
                $composer2 = modifier2;
                obj = obj3;
                $dirty = i10;
                windowInsets3 = arrangement-Ebr7WPU;
                arrangement2 = i5;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj2;
                i4 = $dirty2;
                $dirty = l2;
                obj = obj3;
                arrangement2 = l;
                windowInsets3 = i10;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ExpressiveNavigationBarKt.ExpressiveNavigationBar.2($composer2, $dirty, modifier2, arrangement2, l2, obj, windowInsets3, obj5, i29, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void ExpressiveNavigationBarItem-pli-t6k(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> badge, int iconPosition, androidx.compose.material3.NavigationItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        int i14;
        Object obj7;
        Object obj2;
        boolean traceInProgress2;
        int $dirty3;
        int defaultsInvalid;
        Composer restartGroup;
        int $dirty;
        int $dirty4;
        int i16;
        int i8;
        Object obj;
        int i6;
        Object obj4;
        int colors2;
        boolean traceInProgress;
        int str2;
        Object str;
        boolean z;
        float startIconIndicatorHorizontalPadding;
        float startIconIndicatorVerticalPadding;
        int i17;
        Object $dirty2;
        int i12;
        boolean z3;
        Object obj12;
        int i18;
        int interactionSource3;
        int interactionSource2;
        Object rememberedValue;
        androidx.compose.material3.NavigationItemColors navigationItemColors;
        int i3;
        int i2;
        int i15;
        boolean z4;
        int i10;
        Object obj9;
        Object obj8;
        int value2;
        int value;
        int i9;
        int changed;
        int topIconItemActiveIndicatorWidth;
        int i11;
        float i5;
        float f;
        float topIconIndicatorToLabelPadding;
        float startIconToLabelPadding;
        float topIconItemVerticalPadding;
        Object obj11;
        Object obj3;
        boolean z2;
        Object obj6;
        Object obj10;
        int i4;
        Object obj5;
        Composer composer;
        int i7;
        int i;
        final int i62 = $changed;
        final int i63 = i13;
        restartGroup = $composer.startRestartGroup(1250474866);
        ComposerKt.sourceInformation(restartGroup, "C(ExpressiveNavigationBarItem)P(9,8,3,7,2,6!1,4:c#material3.NavigationItemIconPosition)195@8610L8,219@9391L5,220@9444L5,215@9259L800:ExpressiveNavigationBar.kt#uh7d8r");
        $dirty = $changed;
        if (i63 & 1 != 0) {
            $dirty |= 6;
            z4 = selected;
        } else {
            if (i62 & 6 == 0) {
                i16 = restartGroup.changed(selected) ? 4 : 2;
                $dirty |= i16;
            } else {
                z4 = selected;
            }
        }
        if (i63 & 2 != 0) {
            $dirty |= 48;
            obj9 = onClick;
        } else {
            if (i62 & 48 == 0) {
                i8 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj9 = onClick;
            }
        }
        if (i63 & 4 != 0) {
            $dirty |= 384;
            obj = icon;
        } else {
            if (i62 & 384 == 0) {
                i6 = restartGroup.changedInstance(icon) ? 256 : 128;
                $dirty |= i6;
            } else {
                obj = icon;
            }
        }
        colors2 = i63 & 8;
        if (colors2 != 0) {
            $dirty |= 3072;
            str = modifier;
        } else {
            if (i62 & 3072 == 0) {
                i17 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty |= i17;
            } else {
                str = modifier;
            }
        }
        int i51 = i63 & 16;
        if (i51 != 0) {
            $dirty |= 24576;
            z3 = enabled;
        } else {
            if (i62 & 24576 == 0) {
                i18 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty |= i18;
            } else {
                z3 = enabled;
            }
        }
        int i59 = i63 & 32;
        int i60 = 196608;
        if (i59 != 0) {
            $dirty |= i60;
            rememberedValue = label;
        } else {
            if (i60 &= i62 == 0) {
                i3 = restartGroup.changedInstance(label) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                rememberedValue = label;
            }
        }
        i15 = i63 & 64;
        int i64 = 1572864;
        if (i15 != 0) {
            $dirty |= i64;
            obj8 = badge;
        } else {
            if (i64 &= i62 == 0) {
                value2 = restartGroup.changedInstance(badge) ? 1048576 : 524288;
                $dirty |= value2;
            } else {
                obj8 = badge;
            }
        }
        int i20 = i63 & 128;
        int i67 = 12582912;
        if (i20 != 0) {
            $dirty |= i67;
            value = i20;
            i14 = iconPosition;
        } else {
            if (i62 & i67 == 0) {
                value = i20;
                i9 = restartGroup.changed(iconPosition) ? 8388608 : 4194304;
                $dirty |= i9;
            } else {
                value = i20;
                i14 = iconPosition;
            }
        }
        if (i62 & i69 == 0) {
            if (i63 & 256 == 0) {
                changed = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj7 = colors;
            }
            $dirty |= changed;
        } else {
            obj7 = colors;
        }
        int i21 = i63 & 512;
        int i70 = 805306368;
        if (i21 != 0) {
            $dirty |= i70;
            topIconItemActiveIndicatorWidth = i21;
            obj2 = interactionSource;
        } else {
            if (i62 & i70 == 0) {
                topIconItemActiveIndicatorWidth = i21;
                i11 = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty |= i11;
            } else {
                topIconItemActiveIndicatorWidth = i21;
                obj2 = interactionSource;
            }
        }
        final int obj44 = $dirty;
        if ($dirty & i5 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -234881025;
                int i25 = 6;
                if (i62 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (colors2 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i51 != 0) {
                            z3 = defaultsInvalid;
                        }
                        if (i59 != 0) {
                            rememberedValue = defaultsInvalid;
                        }
                        if (i15 != 0) {
                            obj8 = defaultsInvalid;
                        }
                        if (value != null) {
                            $dirty3 = NavigationItemIconPosition.Companion.getTop--xw1Ddg();
                        } else {
                            $dirty3 = iconPosition;
                        }
                        if (i63 & 256 != 0) {
                            colors2 = ExpressiveNavigationBarItemDefaults.INSTANCE.colors(restartGroup, i25);
                            i12 = obj44 & i72;
                        } else {
                            colors2 = colors;
                            i12 = obj44;
                        }
                        if (topIconItemActiveIndicatorWidth != 0) {
                            interactionSource2 = 0;
                            obj11 = colors2;
                            obj3 = str;
                            z2 = z3;
                            obj6 = rememberedValue;
                            obj10 = obj8;
                        } else {
                            interactionSource2 = interactionSource;
                            obj11 = colors2;
                            obj3 = str;
                            z2 = z3;
                            obj6 = rememberedValue;
                            obj10 = obj8;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i63 & 256 != 0) {
                            obj11 = colors;
                            interactionSource2 = interactionSource;
                            i12 = i23;
                            obj3 = str;
                            z2 = z3;
                            obj6 = rememberedValue;
                            obj10 = obj8;
                            $dirty3 = iconPosition;
                        } else {
                            $dirty3 = iconPosition;
                            obj11 = colors;
                            interactionSource2 = interactionSource;
                            i12 = obj44;
                            obj3 = str;
                            z2 = z3;
                            obj6 = rememberedValue;
                            obj10 = obj8;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1250474866, i12, -1, "androidx.compose.material3.ExpressiveNavigationBarItem (ExpressiveNavigationBar.kt:197)");
                }
                restartGroup.startReplaceGroup(-986536477);
                ComposerKt.sourceInformation(restartGroup, "199@8762L39");
                if (interactionSource2 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -986535826, "CC(remember):ExpressiveNavigationBar.kt#9igjgp");
                    str2 = 0;
                    str = restartGroup;
                    z3 = 0;
                    rememberedValue = str.rememberedValue();
                    i15 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i66 = 0;
                        str.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        obj8 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj5 = obj8;
                } else {
                    obj5 = interactionSource2;
                }
                restartGroup.endReplaceGroup();
                boolean equals-impl0 = NavigationItemIconPosition.equals-impl0($dirty3, NavigationItemIconPosition.Companion.getTop--xw1Ddg());
                i5 = equals-impl0 ? startIconIndicatorHorizontalPadding : startIconIndicatorHorizontalPadding;
                f = equals-impl0 ? startIconIndicatorVerticalPadding : startIconIndicatorVerticalPadding;
                i4 = $dirty3;
                NavigationItemKt.NavigationItem-SHbi2eg(z4, obj9, obj, TypographyKt.getValue(ExpressiveNavigationBarKt.LabelTextFont, restartGroup, i25), ShapesKt.getValue(ExpressiveNavigationBarKt.ActiveIndicatorShape, restartGroup, i25), ExpressiveNavigationBarKt.TopIconItemActiveIndicatorWidth, i5, f, ExpressiveNavigationBarKt.TopIconIndicatorToLabelPadding, ExpressiveNavigationBarKt.StartIconToLabelPadding, ExpressiveNavigationBarKt.TopIconItemVerticalPadding, obj11, obj3, z2, obj6, obj10, i4, obj5, restartGroup, i37 | i55, $dirty4 | i49);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i10 = i12;
                i2 = interactionSource2;
                navigationItemColors = obj11;
                obj4 = obj3;
                z = z2;
                $dirty2 = obj6;
                obj12 = obj10;
                interactionSource3 = i4;
            } else {
                restartGroup.skipToGroupEnd();
                interactionSource3 = iconPosition;
                i2 = interactionSource;
                i10 = obj44;
                composer = restartGroup;
                obj4 = str;
                z = z3;
                $dirty2 = rememberedValue;
                obj12 = obj8;
                navigationItemColors = colors;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ExpressiveNavigationBarKt.ExpressiveNavigationBarItem.1(selected, onClick, icon, obj4, z, $dirty2, obj12, interactionSource3, navigationItemColors, i2, i62, i63);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final int access$calculateCenteredContentHorizontalPadding(int itemsCount, int barWidth) {
        return ExpressiveNavigationBarKt.calculateCenteredContentHorizontalPadding(itemsCount, barWidth);
    }

    public static final ColorSchemeKeyTokens access$getActiveIconColor$p() {
        return ExpressiveNavigationBarKt.ActiveIconColor;
    }

    public static final ColorSchemeKeyTokens access$getActiveIndicatorColor$p() {
        return ExpressiveNavigationBarKt.ActiveIndicatorColor;
    }

    public static final ColorSchemeKeyTokens access$getActiveLabelTextColor$p() {
        return ExpressiveNavigationBarKt.ActiveLabelTextColor;
    }

    public static final ColorSchemeKeyTokens access$getInactiveIconColor$p() {
        return ExpressiveNavigationBarKt.InactiveIconColor;
    }

    public static final ColorSchemeKeyTokens access$getInactiveLabelTextColor$p() {
        return ExpressiveNavigationBarKt.InactiveLabelTextColor;
    }

    public static final float access$getNavigationBarHeight$p() {
        return ExpressiveNavigationBarKt.NavigationBarHeight;
    }

    private static final int calculateCenteredContentHorizontalPadding(int itemsCount, int barWidth) {
        if (itemsCount > 6) {
            return 0;
        }
        return MathKt.roundToInt(f3 *= i7);
    }

    public static final float getStartIconIndicatorHorizontalPadding() {
        return ExpressiveNavigationBarKt.StartIconIndicatorHorizontalPadding;
    }

    public static final float getStartIconIndicatorVerticalPadding() {
        return ExpressiveNavigationBarKt.StartIconIndicatorVerticalPadding;
    }

    public static final float getStartIconToLabelPadding() {
        return ExpressiveNavigationBarKt.StartIconToLabelPadding;
    }

    public static final float getTopIconIndicatorHorizontalPadding() {
        return ExpressiveNavigationBarKt.TopIconIndicatorHorizontalPadding;
    }

    public static final float getTopIconIndicatorToLabelPadding() {
        return ExpressiveNavigationBarKt.TopIconIndicatorToLabelPadding;
    }

    public static final float getTopIconIndicatorVerticalPadding() {
        return ExpressiveNavigationBarKt.TopIconIndicatorVerticalPadding;
    }

    public static final float getTopIconItemVerticalPadding() {
        return ExpressiveNavigationBarKt.TopIconItemVerticalPadding;
    }
}
