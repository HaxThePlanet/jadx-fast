package androidx.compose.material3;

import androidx.compose.material3.tokens.PlainTooltipTokens;
import androidx.compose.material3.tokens.RichTooltipTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.window.PopupPositionProvider;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0019\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u001c\u0010\u001f\u001a\u00020\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001cH\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010\u001eJ\r\u0010!\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\"J:\u0010!\u001a\u00020\u00152\u0008\u0008\u0002\u0010#\u001a\u00020\t2\u0008\u0008\u0002\u0010$\u001a\u00020\t2\u0008\u0008\u0002\u0010%\u001a\u00020\t2\u0008\u0008\u0002\u0010&\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0008\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000bR\u0011\u0010\u0012\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000fR\u0018\u0010\u0014\u001a\u00020\u0015*\u00020\u00168@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006)", d2 = {"Landroidx/compose/material3/TooltipDefaults;", "", "()V", "caretSize", "Landroidx/compose/ui/unit/DpSize;", "getCaretSize-MYxV2XQ", "()J", "J", "plainTooltipContainerColor", "Landroidx/compose/ui/graphics/Color;", "getPlainTooltipContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "plainTooltipContainerShape", "Landroidx/compose/ui/graphics/Shape;", "getPlainTooltipContainerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "plainTooltipContentColor", "getPlainTooltipContentColor", "richTooltipContainerShape", "getRichTooltipContainerShape", "defaultRichTooltipColors", "Landroidx/compose/material3/RichTooltipColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultRichTooltipColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/RichTooltipColors;", "rememberPlainTooltipPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "spacingBetweenTooltipAndAnchor", "Landroidx/compose/ui/unit/Dp;", "rememberPlainTooltipPositionProvider-kHDZbjc", "(FLandroidx/compose/runtime/Composer;II)Landroidx/compose/ui/window/PopupPositionProvider;", "rememberRichTooltipPositionProvider", "rememberRichTooltipPositionProvider-kHDZbjc", "richTooltipColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/RichTooltipColors;", "containerColor", "contentColor", "titleContentColor", "actionContentColor", "richTooltipColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/RichTooltipColors;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TooltipDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.TooltipDefaults INSTANCE;
    private static final long caretSize;
    static {
        TooltipDefaults tooltipDefaults = new TooltipDefaults();
        TooltipDefaults.INSTANCE = tooltipDefaults;
        int i2 = 0;
        int i3 = 0;
        TooltipDefaults.caretSize = DpKt.DpSize-YgX7TsA(Dp.constructor-impl((float)i), Dp.constructor-impl((float)$i$f$getDp));
    }

    public final long getCaretSize-MYxV2XQ() {
        return TooltipDefaults.caretSize;
    }

    public final androidx.compose.material3.RichTooltipColors getDefaultRichTooltipColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultRichTooltipColors) {
        androidx.compose.material3.RichTooltipColors defaultRichTooltipColorsCached$material3_release;
        androidx.compose.material3.RichTooltipColors richTooltipColors;
        int i2;
        long token;
        long token2;
        long token3;
        int i;
        if ($this$defaultRichTooltipColors.getDefaultRichTooltipColorsCached$material3_release() == null) {
            richTooltipColors = new RichTooltipColors(ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getContainerColor()), obj3, ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getSupportingTextColor()), obj5, ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getSubheadColor()), obj7, ColorSchemeKt.fromToken($this$defaultRichTooltipColors, RichTooltipTokens.INSTANCE.getActionLabelTextColor()), obj9, 0);
            i2 = 0;
            $this$defaultRichTooltipColors.setDefaultRichTooltipColorsCached$material3_release(richTooltipColors);
        }
        return defaultRichTooltipColorsCached$material3_release;
    }

    public final long getPlainTooltipContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 102696215;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C244@10694L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerColor> (Tooltip.kt:244)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final Shape getPlainTooltipContainerShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 49570325;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C240@10518L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContainerShape> (Tooltip.kt:240)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(PlainTooltipTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final long getPlainTooltipContentColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1982928937;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C248@10882L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-plainTooltipContentColor> (Tooltip.kt:248)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(PlainTooltipTokens.INSTANCE.getSupportingTextColor(), $composer, 6);
    }

    public final Shape getRichTooltipContainerShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1138709783;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C252@11055L5:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.<get-richTooltipContainerShape> (Tooltip.kt:252)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(RichTooltipTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final PopupPositionProvider rememberPlainTooltipPositionProvider-kHDZbjc(float spacingBetweenTooltipAndAnchor, Composer $composer, int $changed, int i4) {
        String str;
        Object empty;
        Object anon;
        float obj8;
        boolean obj11;
        int i = 1047866909;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberPlainTooltipPositionProvider)P(0:c#ui.unit.Dp)*304@13227L7,305@13298L897:Tooltip.kt#uh7d8r");
        if (i4 &= 1 != 0) {
            obj8 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.rememberPlainTooltipPositionProvider (Tooltip.kt:302)");
        }
        int i2 = 0;
        int i6 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i3 = 0;
        obj11 = (Density)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).roundToPx-0680j_4(obj8);
        ComposerKt.sourceInformationMarkerStart($composer, 1994502237, "CC(remember):Tooltip.kt#9igjgp");
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (!$composer.changed(obj11)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new TooltipDefaults.rememberPlainTooltipPositionProvider.1.1(obj11);
                composer.updateRememberedValue(anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (PopupPositionProvider)(TooltipDefaults.rememberPlainTooltipPositionProvider.1.1)anon;
    }

    public final PopupPositionProvider rememberRichTooltipPositionProvider-kHDZbjc(float spacingBetweenTooltipAndAnchor, Composer $composer, int $changed, int i4) {
        String str;
        Object empty;
        Object anon;
        float obj8;
        boolean obj11;
        int i = -1538806795;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberRichTooltipPositionProvider)P(0:c#ui.unit.Dp)*337@14707L7,338@14778L1457:Tooltip.kt#uh7d8r");
        if (i4 &= 1 != 0) {
            obj8 = TooltipKt.getSpacingBetweenTooltipAndAnchor();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.rememberRichTooltipPositionProvider (Tooltip.kt:335)");
        }
        int i2 = 0;
        int i6 = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i3 = 0;
        obj11 = (Density)$composer.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).roundToPx-0680j_4(obj8);
        ComposerKt.sourceInformationMarkerStart($composer, -1778011319, "CC(remember):Tooltip.kt#9igjgp");
        Composer composer = $composer;
        int i8 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (!$composer.changed(obj11)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new TooltipDefaults.rememberRichTooltipPositionProvider.1.1(obj11);
                composer.updateRememberedValue(anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (PopupPositionProvider)(TooltipDefaults.rememberRichTooltipPositionProvider.1.1)anon;
    }

    public final androidx.compose.material3.RichTooltipColors richTooltipColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1622312141;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(richTooltipColors)261@11362L11:Tooltip.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:261)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultRichTooltipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.RichTooltipColors richTooltipColors-ro_MJ88(long containerColor, long contentColor, long titleContentColor, long actionContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU;
        int unspecified-0d7_KjU3;
        boolean traceInProgress;
        String str;
        long l;
        long l2;
        long l4;
        long l3;
        int i;
        final Composer composer = obj23;
        int i2 = 1498555081;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(richTooltipColors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,0:c#ui.graphics.Color)274@11844L11:Tooltip.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l = unspecified-0d7_KjU2;
        } else {
            l = containerColor;
        }
        if (obj25 & 2 != 0) {
            l2 = unspecified-0d7_KjU4;
        } else {
            l2 = titleContentColor;
        }
        if (obj25 & 4 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = $composer;
        }
        if (obj25 & 8 != 0) {
            l3 = unspecified-0d7_KjU3;
        } else {
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.TooltipDefaults.richTooltipColors (Tooltip.kt:274)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultRichTooltipColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l, obj6, l2, obj8);
    }
}
