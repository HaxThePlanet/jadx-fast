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
        int traceInProgress2;
        Object $composer2;
        int $dirty2;
        long $dirty;
        int modifier2;
        Object obj;
        long arrangement2;
        int arrangement-Ebr7WPU;
        int containerColor2;
        int containerColor3;
        int windowInsets3;
        int i11;
        long l;
        boolean traceInProgress;
        Object obj2;
        String str;
        int changed;
        int i;
        Object obj3;
        int windowInsets2;
        boolean changed3;
        long contentColor2;
        int i6;
        int changed2;
        int i2;
        int changed4;
        int i10;
        boolean defaultsInvalid;
        int i5;
        int i4;
        int i3;
        int i7;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer;
        int i12;
        int i8;
        long l2;
        final Object obj5 = $changed;
        final int i29 = obj34;
        traceInProgress2 = -1171105467;
        Composer restartGroup = i9.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ExpressiveNavigationBar)P(4,1:c#ui.graphics.Color,3:c#ui.graphics.Color,5,0:c#material3.NavigationBarArrangement)83@3944L14,84@4018L12,85@4097L12,92@4328L779,89@4244L863:ExpressiveNavigationBar.kt#uh7d8r");
        $dirty2 = obj34;
        modifier2 = obj35 & 1;
        if (modifier2 != 0) {
            $dirty2 |= 6;
            obj = modifier;
        } else {
            if (i29 & 6 == 0) {
                i11 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i11;
            } else {
                obj = modifier;
            }
        }
        if (i29 & 48 == 0) {
            if (obj35 & 2 == 0) {
                changed = restartGroup.changed(containerColor) ? 32 : 16;
            } else {
                l = containerColor;
            }
            $dirty2 |= changed;
        } else {
            l = containerColor;
        }
        if (i29 & 384 == 0) {
            if (obj35 & 4 == 0) {
                i = restartGroup.changed(windowInsets) ? 256 : 128;
            } else {
                contentColor2 = windowInsets;
            }
            $dirty2 |= i;
        } else {
            contentColor2 = windowInsets;
        }
        if (i29 & 3072 == 0) {
            if (obj35 & 8 == 0) {
                changed2 = restartGroup.changed(content) ? 2048 : 1024;
            } else {
                obj3 = content;
            }
            $dirty2 |= changed2;
        } else {
            obj3 = content;
        }
        if (i29 & 24576 == 0) {
            if (obj35 & 16 == 0) {
                changed4 = restartGroup.changed($composer) ? 16384 : 8192;
            } else {
                i2 = $composer;
            }
            $dirty2 |= changed4;
        } else {
            i2 = $composer;
        }
        int i35 = 196608;
        if (obj35 & 32 != 0) {
            $dirty2 |= i35;
        } else {
            if (i29 & i35 == 0) {
                i10 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
                $dirty2 |= i10;
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
                            modifier2 = obj;
                        }
                        defaultsInvalid = 6;
                        if (obj35 & 2 != 0) {
                            $dirty2 &= -113;
                            l = containerColor2;
                        }
                        if (obj35 & 4 != 0) {
                            contentColor2 = ExpressiveNavigationBarDefaults.INSTANCE.getContentColor(restartGroup, defaultsInvalid);
                            $dirty2 &= -897;
                        }
                        if (obj35 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj3 = windowInsets3;
                        }
                        if (obj35 & 16 != 0) {
                            arrangement-Ebr7WPU = ExpressiveNavigationBarDefaults.INSTANCE.getArrangement-Ebr7WPU();
                            $dirty2 &= i36;
                            i2 = l;
                            i5 = contentColor2;
                        } else {
                            i5 = contentColor2;
                            arrangement-Ebr7WPU = i2;
                            i2 = l;
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
                        modifier2 = obj;
                        i5 = contentColor2;
                        arrangement-Ebr7WPU = i2;
                        i2 = l;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.ExpressiveNavigationBar (ExpressiveNavigationBar.kt:88)");
                }
                ExpressiveNavigationBarKt.ExpressiveNavigationBar.1 anon = new ExpressiveNavigationBarKt.ExpressiveNavigationBar.1(modifier2, obj3, arrangement-Ebr7WPU, obj5);
                SurfaceKt.Surface-T9BRK9s(0, 0, i2, defaultsInvalid, i5, obj15, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(1573697866, true, anon, restartGroup, 54), restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i6 = $dirty2;
                $composer2 = modifier2;
                obj2 = obj3;
                $dirty = i2;
                windowInsets2 = arrangement-Ebr7WPU;
                arrangement2 = i5;
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                $composer2 = obj;
                i6 = $dirty2;
                $dirty = l;
                obj2 = obj3;
                arrangement2 = l2;
                windowInsets2 = i2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new ExpressiveNavigationBarKt.ExpressiveNavigationBar.2($composer2, $dirty, modifier2, arrangement2, l, obj2, windowInsets2, obj5, i29, obj35);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void ExpressiveNavigationBarItem-pli-t6k(boolean selected, Function0<Unit> onClick, Function2<? super Composer, ? super Integer, Unit> icon, Modifier modifier, boolean enabled, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> badge, int iconPosition, androidx.compose.material3.NavigationItemColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i13) {
        int i6;
        Object obj11;
        Object obj9;
        boolean traceInProgress;
        int $dirty3;
        int defaultsInvalid;
        Composer restartGroup;
        int $dirty4;
        int $dirty2;
        int i8;
        int i18;
        Object obj7;
        int i5;
        Object obj2;
        int colors2;
        boolean traceInProgress2;
        int str;
        Object str2;
        boolean z4;
        float startIconIndicatorHorizontalPadding;
        float startIconIndicatorVerticalPadding;
        int i14;
        Object $dirty;
        int i11;
        boolean z3;
        Object obj;
        int i17;
        int interactionSource2;
        int interactionSource3;
        Object rememberedValue;
        androidx.compose.material3.NavigationItemColors navigationItemColors;
        int i2;
        int i12;
        int i3;
        boolean z2;
        int i9;
        Object obj5;
        Object $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
        int value2;
        int value;
        int i4;
        int changed;
        int topIconItemActiveIndicatorWidth;
        int i;
        float i16;
        float f;
        float topIconIndicatorToLabelPadding;
        float startIconToLabelPadding;
        float topIconItemVerticalPadding;
        Object obj6;
        Object obj3;
        boolean z;
        Object obj10;
        Object obj8;
        int i7;
        Object obj4;
        Composer composer;
        int i15;
        int i10;
        final int i62 = $changed;
        final int i63 = i13;
        restartGroup = $composer.startRestartGroup(1250474866);
        ComposerKt.sourceInformation(restartGroup, "C(ExpressiveNavigationBarItem)P(9,8,3,7,2,6!1,4:c#material3.NavigationItemIconPosition)195@8610L8,219@9391L5,220@9444L5,215@9259L800:ExpressiveNavigationBar.kt#uh7d8r");
        $dirty4 = $changed;
        if (i63 & 1 != 0) {
            $dirty4 |= 6;
            z2 = selected;
        } else {
            if (i62 & 6 == 0) {
                i8 = restartGroup.changed(selected) ? 4 : 2;
                $dirty4 |= i8;
            } else {
                z2 = selected;
            }
        }
        if (i63 & 2 != 0) {
            $dirty4 |= 48;
            obj5 = onClick;
        } else {
            if (i62 & 48 == 0) {
                i18 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty4 |= i18;
            } else {
                obj5 = onClick;
            }
        }
        if (i63 & 4 != 0) {
            $dirty4 |= 384;
            obj7 = icon;
        } else {
            if (i62 & 384 == 0) {
                i5 = restartGroup.changedInstance(icon) ? 256 : 128;
                $dirty4 |= i5;
            } else {
                obj7 = icon;
            }
        }
        colors2 = i63 & 8;
        if (colors2 != 0) {
            $dirty4 |= 3072;
            str2 = modifier;
        } else {
            if (i62 & 3072 == 0) {
                i14 = restartGroup.changed(modifier) ? 2048 : 1024;
                $dirty4 |= i14;
            } else {
                str2 = modifier;
            }
        }
        int i51 = i63 & 16;
        if (i51 != 0) {
            $dirty4 |= 24576;
            z3 = enabled;
        } else {
            if (i62 & 24576 == 0) {
                i17 = restartGroup.changed(enabled) ? 16384 : 8192;
                $dirty4 |= i17;
            } else {
                z3 = enabled;
            }
        }
        int i59 = i63 & 32;
        int i60 = 196608;
        if (i59 != 0) {
            $dirty4 |= i60;
            rememberedValue = label;
        } else {
            if (i60 &= i62 == 0) {
                i2 = restartGroup.changedInstance(label) ? 131072 : 65536;
                $dirty4 |= i2;
            } else {
                rememberedValue = label;
            }
        }
        i3 = i63 & 64;
        int i64 = 1572864;
        if (i3 != 0) {
            $dirty4 |= i64;
            $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1 = badge;
        } else {
            if (i64 &= i62 == 0) {
                value2 = restartGroup.changedInstance(badge) ? 1048576 : 524288;
                $dirty4 |= value2;
            } else {
                $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1 = badge;
            }
        }
        int i20 = i63 & 128;
        int i67 = 12582912;
        if (i20 != 0) {
            $dirty4 |= i67;
            value = i20;
            i6 = iconPosition;
        } else {
            if (i62 & i67 == 0) {
                value = i20;
                i4 = restartGroup.changed(iconPosition) ? 8388608 : 4194304;
                $dirty4 |= i4;
            } else {
                value = i20;
                i6 = iconPosition;
            }
        }
        if (i62 & i69 == 0) {
            if (i63 & 256 == 0) {
                changed = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj11 = colors;
            }
            $dirty4 |= changed;
        } else {
            obj11 = colors;
        }
        int i21 = i63 & 512;
        int i70 = 805306368;
        if (i21 != 0) {
            $dirty4 |= i70;
            topIconItemActiveIndicatorWidth = i21;
            obj9 = interactionSource;
        } else {
            if (i62 & i70 == 0) {
                topIconItemActiveIndicatorWidth = i21;
                i = restartGroup.changed(interactionSource) ? 536870912 : 268435456;
                $dirty4 |= i;
            } else {
                topIconItemActiveIndicatorWidth = i21;
                obj9 = interactionSource;
            }
        }
        final int obj44 = $dirty4;
        if ($dirty4 & i16 == 306783378) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i72 = -234881025;
                int i25 = 6;
                if (i62 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (colors2 != 0) {
                            str2 = defaultsInvalid;
                        }
                        if (i51 != 0) {
                            z3 = defaultsInvalid;
                        }
                        if (i59 != 0) {
                            rememberedValue = defaultsInvalid;
                        }
                        if (i3 != 0) {
                            $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1 = defaultsInvalid;
                        }
                        if (value != null) {
                            $dirty3 = NavigationItemIconPosition.Companion.getTop--xw1Ddg();
                        } else {
                            $dirty3 = iconPosition;
                        }
                        if (i63 & 256 != 0) {
                            colors2 = ExpressiveNavigationBarItemDefaults.INSTANCE.colors(restartGroup, i25);
                            i11 = obj44 & i72;
                        } else {
                            colors2 = colors;
                            i11 = obj44;
                        }
                        if (topIconItemActiveIndicatorWidth != 0) {
                            interactionSource3 = 0;
                            obj6 = colors2;
                            obj3 = str2;
                            z = z3;
                            obj10 = rememberedValue;
                            obj8 = $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
                        } else {
                            interactionSource3 = interactionSource;
                            obj6 = colors2;
                            obj3 = str2;
                            z = z3;
                            obj10 = rememberedValue;
                            obj8 = $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i63 & 256 != 0) {
                            obj6 = colors;
                            interactionSource3 = interactionSource;
                            i11 = i23;
                            obj3 = str2;
                            z = z3;
                            obj10 = rememberedValue;
                            obj8 = $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
                            $dirty3 = iconPosition;
                        } else {
                            $dirty3 = iconPosition;
                            obj6 = colors;
                            interactionSource3 = interactionSource;
                            i11 = obj44;
                            obj3 = str2;
                            z = z3;
                            obj10 = rememberedValue;
                            obj8 = $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1250474866, i11, -1, "androidx.compose.material3.ExpressiveNavigationBarItem (ExpressiveNavigationBar.kt:197)");
                }
                restartGroup.startReplaceGroup(-986536477);
                ComposerKt.sourceInformation(restartGroup, "199@8762L39");
                if (interactionSource3 == 0) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -986535826, "CC(remember):ExpressiveNavigationBar.kt#9igjgp");
                    str = 0;
                    str2 = restartGroup;
                    z3 = 0;
                    rememberedValue = str2.rememberedValue();
                    i3 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i66 = 0;
                        str2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj4 = $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
                } else {
                    obj4 = interactionSource3;
                }
                restartGroup.endReplaceGroup();
                boolean equals-impl0 = NavigationItemIconPosition.equals-impl0($dirty3, NavigationItemIconPosition.Companion.getTop--xw1Ddg());
                i16 = equals-impl0 ? startIconIndicatorHorizontalPadding : startIconIndicatorHorizontalPadding;
                f = equals-impl0 ? startIconIndicatorVerticalPadding : startIconIndicatorVerticalPadding;
                i7 = $dirty3;
                NavigationItemKt.NavigationItem-SHbi2eg(z2, obj5, obj7, TypographyKt.getValue(ExpressiveNavigationBarKt.LabelTextFont, restartGroup, i25), ShapesKt.getValue(ExpressiveNavigationBarKt.ActiveIndicatorShape, restartGroup, i25), ExpressiveNavigationBarKt.TopIconItemActiveIndicatorWidth, i16, f, ExpressiveNavigationBarKt.TopIconIndicatorToLabelPadding, ExpressiveNavigationBarKt.StartIconToLabelPadding, ExpressiveNavigationBarKt.TopIconItemVerticalPadding, obj6, obj3, z, obj10, obj8, i7, obj4, restartGroup, i37 | i55, $dirty2 | i49);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i9 = i11;
                i12 = interactionSource3;
                navigationItemColors = obj6;
                obj2 = obj3;
                z4 = z;
                $dirty = obj10;
                obj = obj8;
                interactionSource2 = i7;
            } else {
                restartGroup.skipToGroupEnd();
                interactionSource2 = iconPosition;
                i12 = interactionSource;
                i9 = obj44;
                composer = restartGroup;
                obj2 = str2;
                z4 = z3;
                $dirty = rememberedValue;
                obj = $i$a$CacheExpressiveNavigationBarKt$ExpressiveNavigationBarItem$interactionSource$1;
                navigationItemColors = colors;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new ExpressiveNavigationBarKt.ExpressiveNavigationBarItem.1(selected, onClick, icon, obj2, z4, $dirty, obj, interactionSource2, navigationItemColors, i12, i62, i63);
            endRestartGroup.updateScope((Function2)traceInProgress);
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
