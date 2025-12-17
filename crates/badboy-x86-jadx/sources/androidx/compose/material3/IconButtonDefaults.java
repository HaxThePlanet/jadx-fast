package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.FilledIconButtonTokens;
import androidx.compose.material3.tokens.FilledTonalIconButtonTokens;
import androidx.compose.material3.tokens.IconButtonTokens;
import androidx.compose.material3.tokens.OutlinedIconButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0014\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0016\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010\u0016\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010\u001f\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010!\u001a\u00020\u00192\u0008\u0008\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008#\u0010$J\r\u0010%\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010%\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010\u001eJ\r\u0010'\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010'\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010!\u001a\u00020\u00192\u0008\u0008\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008(\u0010$J\r\u0010)\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u0010)\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010\u001eJ\r\u0010+\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u0010+\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010!\u001a\u00020\u00192\u0008\u0008\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008,\u0010$J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101J\r\u00102\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u0017J:\u00102\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u0010\u001eJ\u001f\u00104\u001a\u0004\u0018\u00010.2\u0006\u0010/\u001a\u0002002\u0006\u00105\u001a\u000200H\u0007¢\u0006\u0002\u00106J\r\u00107\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010 JN\u00107\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010!\u001a\u00020\u00192\u0008\u0008\u0002\u0010\"\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u0010$J\u001e\u00109\u001a\u00020\n*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<J\u001e\u0010=\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\u0008>\u0010?J\u001e\u0010@\u001a\u00020\n*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\u0008A\u0010<J\u001e\u0010B\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010:\u001a\u00020\u0019H\u0000ø\u0001\u0000¢\u0006\u0004\u0008C\u0010?R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006R\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\rR\u0018\u0010\u0014\u001a\u00020\u000f*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0011\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006D", d2 = {"Landroidx/compose/material3/IconButtonDefaults;", "", "()V", "filledShape", "Landroidx/compose/ui/graphics/Shape;", "getFilledShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "defaultFilledIconButtonColors", "Landroidx/compose/material3/IconButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultFilledIconButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconButtonColors;", "defaultFilledIconToggleButtonColors", "Landroidx/compose/material3/IconToggleButtonColors;", "getDefaultFilledIconToggleButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/IconToggleButtonColors;", "defaultFilledTonalIconButtonColors", "getDefaultFilledTonalIconButtonColors$material3_release", "defaultFilledTonalIconToggleButtonColors", "getDefaultFilledTonalIconToggleButtonColors$material3_release", "filledIconButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "filledIconButtonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconButtonColors;", "filledIconToggleButtonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/IconToggleButtonColors;", "checkedContainerColor", "checkedContentColor", "filledIconToggleButtonColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/IconToggleButtonColors;", "filledTonalIconButtonColors", "filledTonalIconButtonColors-ro_MJ88", "filledTonalIconToggleButtonColors", "filledTonalIconToggleButtonColors-5tl4gsc", "iconButtonColors", "iconButtonColors-ro_MJ88", "iconToggleButtonColors", "iconToggleButtonColors-5tl4gsc", "outlinedIconButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconButtonColors", "outlinedIconButtonColors-ro_MJ88", "outlinedIconToggleButtonBorder", "checked", "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedIconToggleButtonColors", "outlinedIconToggleButtonColors-5tl4gsc", "defaultIconButtonColors", "localContentColor", "defaultIconButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconButtonColors;", "defaultIconToggleButtonColors", "defaultIconToggleButtonColors-4WTKRHQ$material3_release", "(Landroidx/compose/material3/ColorScheme;J)Landroidx/compose/material3/IconToggleButtonColors;", "defaultOutlinedIconButtonColors", "defaultOutlinedIconButtonColors-4WTKRHQ$material3_release", "defaultOutlinedIconToggleButtonColors", "defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IconButtonDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.IconButtonDefaults INSTANCE;
    static {
        IconButtonDefaults iconButtonDefaults = new IconButtonDefaults();
        IconButtonDefaults.INSTANCE = iconButtonDefaults;
    }

    public final androidx.compose.material3.IconButtonColors defaultIconButtonColors-4WTKRHQ$material3_release(androidx.compose.material3.ColorScheme $this$defaultIconButtonColors_u2d4WTKRHQ, long localContentColor) {
        androidx.compose.material3.IconButtonColors $this$defaultIconButtonColors_4WTKRHQ_u24lambda_u241;
        int i6;
        androidx.compose.material3.IconButtonColors iconButtonColors;
        androidx.compose.material3.IconButtonColors iconButtonColors2;
        long l3;
        long l;
        long transparent-0d7_KjU;
        long l2;
        int i7;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if ($this$defaultIconButtonColors_u2d4WTKRHQ.getDefaultIconButtonColorsCached$material3_release() == null) {
            i6 = 0;
            iconButtonColors = new IconButtonColors(Color.Companion.getTransparent-0d7_KjU(), obj4, localContentColor, obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, Color.copy-wmQWz5c$default(localContentColor, obj10, 1052938076, 0, 0, 0, 14), obj10, 0);
            l3 = 0;
            $this$defaultIconButtonColors_u2d4WTKRHQ.setDefaultIconButtonColorsCached$material3_release(iconButtonColors);
            $this$defaultIconButtonColors_4WTKRHQ_u24lambda_u241 = iconButtonColors;
        }
        return $this$defaultIconButtonColors_4WTKRHQ_u24lambda_u241;
    }

    public final androidx.compose.material3.IconToggleButtonColors defaultIconToggleButtonColors-4WTKRHQ$material3_release(androidx.compose.material3.ColorScheme $this$defaultIconToggleButtonColors_u2d4WTKRHQ, long localContentColor) {
        androidx.compose.material3.IconToggleButtonColors $this$defaultIconToggleButtonColors_4WTKRHQ_u24lambda_u243;
        int i2;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors2;
        long l;
        long l2;
        long transparent-0d7_KjU2;
        long l3;
        long transparent-0d7_KjU;
        int i;
        long token;
        int i4;
        int i3;
        int i5;
        if ($this$defaultIconToggleButtonColors_u2d4WTKRHQ.getDefaultIconToggleButtonColorsCached$material3_release() == null) {
            androidx.compose.material3.ColorScheme colorScheme = $this$defaultIconToggleButtonColors_u2d4WTKRHQ;
            i2 = 0;
            i = 0;
            i4 = 0;
            iconToggleButtonColors = new IconToggleButtonColors(Color.Companion.getTransparent-0d7_KjU(), obj4, localContentColor, obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, Color.copy-wmQWz5c$default(localContentColor, obj10, 1052938076, i, 0, i4, 14), obj10, Color.Companion.getTransparent-0d7_KjU(), i, ColorSchemeKt.fromToken(colorScheme, IconButtonTokens.INSTANCE.getSelectedIconColor()), i4, 0);
            l = 0;
            colorScheme.setDefaultIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
            $this$defaultIconToggleButtonColors_4WTKRHQ_u24lambda_u243 = iconToggleButtonColors;
        }
        return $this$defaultIconToggleButtonColors_4WTKRHQ_u24lambda_u243;
    }

    public final androidx.compose.material3.IconButtonColors defaultOutlinedIconButtonColors-4WTKRHQ$material3_release(androidx.compose.material3.ColorScheme $this$defaultOutlinedIconButtonColors_u2d4WTKRHQ, long localContentColor) {
        androidx.compose.material3.IconButtonColors $this$defaultOutlinedIconButtonColors_4WTKRHQ_u24lambda_u249;
        int i3;
        androidx.compose.material3.IconButtonColors iconButtonColors;
        androidx.compose.material3.IconButtonColors iconButtonColors2;
        long l2;
        long l;
        long transparent-0d7_KjU;
        long l3;
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        if ($this$defaultOutlinedIconButtonColors_u2d4WTKRHQ.getDefaultOutlinedIconButtonColorsCached$material3_release() == null) {
            i3 = 0;
            iconButtonColors = new IconButtonColors(Color.Companion.getTransparent-0d7_KjU(), obj4, localContentColor, obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, Color.copy-wmQWz5c$default(localContentColor, obj10, 1052938076, 0, 0, 0, 14), obj10, 0);
            l2 = 0;
            $this$defaultOutlinedIconButtonColors_u2d4WTKRHQ.setDefaultOutlinedIconButtonColorsCached$material3_release(iconButtonColors);
            $this$defaultOutlinedIconButtonColors_4WTKRHQ_u24lambda_u249 = iconButtonColors;
        }
        return $this$defaultOutlinedIconButtonColors_4WTKRHQ_u24lambda_u249;
    }

    public final androidx.compose.material3.IconToggleButtonColors defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release(androidx.compose.material3.ColorScheme $this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ, long localContentColor) {
        androidx.compose.material3.IconToggleButtonColors $this$defaultOutlinedIconToggleButtonColors_4WTKRHQ_u24lambda_u2411;
        int i5;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors2;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors;
        long l3;
        long l2;
        long transparent-0d7_KjU;
        long l;
        long token;
        int i;
        long contentColorFor-4WTKRHQ;
        int i2;
        int i3;
        int i4;
        if ($this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ.getDefaultIconToggleButtonColorsCached$material3_release() == null) {
            androidx.compose.material3.ColorScheme colorScheme = $this$defaultOutlinedIconToggleButtonColors_u2d4WTKRHQ;
            i5 = 0;
            i = 0;
            i2 = 0;
            iconToggleButtonColors2 = new IconToggleButtonColors(Color.Companion.getTransparent-0d7_KjU(), obj4, localContentColor, obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, Color.copy-wmQWz5c$default(localContentColor, obj10, 1052938076, i, 0, i2, 14), obj10, ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor()), i, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedIconButtonTokens.INSTANCE.getSelectedContainerColor())), i2, 0);
            l3 = 0;
            colorScheme.setDefaultOutlinedIconToggleButtonColorsCached$material3_release(iconToggleButtonColors2);
            $this$defaultOutlinedIconToggleButtonColors_4WTKRHQ_u24lambda_u2411 = iconToggleButtonColors2;
        }
        return $this$defaultOutlinedIconToggleButtonColors_4WTKRHQ_u24lambda_u2411;
    }

    public final androidx.compose.material3.IconButtonColors filledIconButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1857395287;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(filledIconButtonColors)719@33486L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:719)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultFilledIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.IconButtonColors filledIconButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU3;
        long contentColorFor-ek8zF_U;
        long unspecified-0d7_KjU2;
        int unspecified-0d7_KjU;
        boolean traceInProgress;
        String str;
        long l;
        long l2;
        long l3;
        long l4;
        final Composer composer = obj23;
        final int i = obj24;
        int i2 = -669858473;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(filledIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)732@34130L31,736@34326L11:IconButton.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = containerColor;
        }
        if (obj25 & 2 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l3 = unspecified-0d7_KjU2;
        } else {
            l3 = $composer;
        }
        if (obj25 & 8 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconButtonColors (IconButton.kt:736)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultFilledIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l, obj7, l2, obj9);
    }

    public final androidx.compose.material3.IconToggleButtonColors filledIconToggleButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1554706367;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(filledIconToggleButtonColors)766@35781L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:766)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultFilledIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.IconToggleButtonColors filledIconToggleButtonColors-5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU2;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU4;
        int contentColorFor-ek8zF_U;
        boolean traceInProgress;
        String str;
        long l;
        long l6;
        long l2;
        long l3;
        long l5;
        long l4;
        final Composer composer = obj31;
        final int i = obj32;
        int i2 = 1887173701;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(filledIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)788@36995L38,790@37088L11:IconButton.kt#uh7d8r");
        if (obj33 & 1 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = containerColor;
        }
        if (obj33 & 2 != 0) {
            l6 = unspecified-0d7_KjU;
        } else {
            l6 = disabledContainerColor;
        }
        if (obj33 & 4 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = checkedContainerColor;
        }
        if (obj33 & 8 != 0) {
            l3 = unspecified-0d7_KjU5;
        } else {
            l3 = $composer;
        }
        if (obj33 & 16 != 0) {
            l5 = unspecified-0d7_KjU4;
        } else {
            l5 = i9;
        }
        if (obj33 & 32 != 0) {
            l4 = contentColorFor-ek8zF_U;
        } else {
            l4 = obj29;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.material3.IconButtonDefaults.filledIconToggleButtonColors (IconButton.kt:790)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultFilledIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-tNS2XkQ(l, obj7, l6, obj9, l2, obj11);
    }

    public final androidx.compose.material3.IconButtonColors filledTonalIconButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1099140437;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(filledTonalIconButtonColors)830@39188L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:830)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultFilledTonalIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.IconButtonColors filledTonalIconButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU2;
        long contentColorFor-ek8zF_U;
        long unspecified-0d7_KjU;
        int unspecified-0d7_KjU3;
        boolean traceInProgress;
        String str;
        long l2;
        long l3;
        long l4;
        long l;
        final Composer composer = obj23;
        final int i = obj24;
        int i2 = -18532843;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(filledTonalIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)844@39854L31,848@40050L11:IconButton.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = containerColor;
        }
        if (obj25 & 2 != 0) {
            l3 = contentColorFor-ek8zF_U;
        } else {
            l3 = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = $composer;
        }
        if (obj25 & 8 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconButtonColors (IconButton.kt:848)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultFilledTonalIconButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l2, obj7, l3, obj9);
    }

    public final androidx.compose.material3.IconToggleButtonColors filledTonalIconToggleButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 434219587;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(filledTonalIconToggleButtonColors)878@41565L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:878)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultFilledTonalIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.IconToggleButtonColors filledTonalIconToggleButtonColors-5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU4;
        long contentColorFor-ek8zF_U;
        long unspecified-0d7_KjU;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU3;
        boolean traceInProgress;
        String str;
        long l;
        long l2;
        long l3;
        long l4;
        long l5;
        long l6;
        final Composer composer = obj31;
        final int i = obj32;
        int i2 = -19426557;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(filledTonalIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)894@42431L31,900@42747L11:IconButton.kt#uh7d8r");
        if (obj33 & 1 != 0) {
            l = unspecified-0d7_KjU4;
        } else {
            l = containerColor;
        }
        if (obj33 & 2 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = disabledContainerColor;
        }
        if (obj33 & 4 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = checkedContainerColor;
        }
        if (obj33 & 8 != 0) {
            l4 = unspecified-0d7_KjU2;
        } else {
            l4 = $composer;
        }
        if (obj33 & 16 != 0) {
            l5 = unspecified-0d7_KjU5;
        } else {
            l5 = i9;
        }
        if (obj33 & 32 != 0) {
            l6 = unspecified-0d7_KjU3;
        } else {
            l6 = obj29;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i, -1, "androidx.compose.material3.IconButtonDefaults.filledTonalIconToggleButtonColors (IconButton.kt:900)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultFilledTonalIconToggleButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-tNS2XkQ(l, obj7, l2, obj9, l3, obj11);
    }

    public final androidx.compose.material3.IconButtonColors getDefaultFilledIconButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultFilledIconButtonColors) {
        androidx.compose.material3.IconButtonColors defaultFilledIconButtonColorsCached$material3_release;
        androidx.compose.material3.IconButtonColors iconButtonColors;
        int i7;
        long contentColorFor-4WTKRHQ;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i8;
        int i;
        int i2;
        int i6;
        int i3;
        int i4;
        int i5;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultFilledIconButtonColors;
        if (colorScheme.getDefaultFilledIconButtonColorsCached$material3_release() == null) {
            i8 = 0;
            i2 = 0;
            iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getContainerColor())), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), i8, 0, i2, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), i8, FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), i2, 0, 0, 14), i8, 0);
            i7 = 0;
            colorScheme.setDefaultFilledIconButtonColorsCached$material3_release(iconButtonColors);
        }
        return defaultFilledIconButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.IconToggleButtonColors getDefaultFilledIconToggleButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultFilledIconToggleButtonColors) {
        androidx.compose.material3.IconToggleButtonColors defaultFilledIconToggleButtonColorsCached$material3_release;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors;
        int i5;
        long token;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i;
        long token2;
        int i4;
        long contentColorFor-4WTKRHQ;
        int i6;
        int i2;
        int i3;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultFilledIconToggleButtonColors;
        if (colorScheme.getDefaultFilledIconToggleButtonColorsCached$material3_release() == null) {
            i = 0;
            i4 = 0;
            i6 = 0;
            iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getUnselectedContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getToggleUnselectedColor()), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, FilledIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), i, 0, i4, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getDisabledColor()), i, FilledIconButtonTokens.INSTANCE.getDisabledOpacity(), i4, 0, i6, 14), i, ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor()), i4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledIconButtonTokens.INSTANCE.getSelectedContainerColor())), i6, 0);
            i5 = 0;
            colorScheme.setDefaultFilledIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
        }
        return defaultFilledIconToggleButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.IconButtonColors getDefaultFilledTonalIconButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultFilledTonalIconButtonColors) {
        androidx.compose.material3.IconButtonColors defaultFilledTonalIconButtonColorsCached$material3_release;
        androidx.compose.material3.IconButtonColors iconButtonColors;
        int i;
        long contentColorFor-4WTKRHQ;
        long copy-wmQWz5c$default2;
        long copy-wmQWz5c$default;
        int i8;
        int i2;
        int i7;
        int i3;
        int i4;
        int i5;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultFilledTonalIconButtonColors;
        if (colorScheme.getDefaultFilledTonalIconButtonColorsCached$material3_release() == null) {
            i8 = 0;
            i7 = 0;
            iconButtonColors = new IconButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getContainerColor())), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), i8, 0, i7, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), i8, FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), i7, 0, 0, 14), i8, 0);
            i = 0;
            colorScheme.setDefaultFilledTonalIconButtonColorsCached$material3_release(iconButtonColors);
        }
        return defaultFilledTonalIconButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.IconToggleButtonColors getDefaultFilledTonalIconToggleButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultFilledTonalIconToggleButtonColors) {
        androidx.compose.material3.IconToggleButtonColors defaultFilledTonalIconToggleButtonColorsCached$material3_release;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors;
        int i2;
        long contentColorFor-4WTKRHQ;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i;
        long token;
        int i5;
        long token2;
        int i3;
        int i6;
        int i4;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultFilledTonalIconToggleButtonColors;
        if (colorScheme.getDefaultFilledTonalIconToggleButtonColorsCached$material3_release() == null) {
            i = 0;
            i5 = 0;
            i3 = 0;
            iconToggleButtonColors = new IconToggleButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor()), obj4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getUnselectedContainerColor())), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, FilledTonalIconButtonTokens.INSTANCE.getDisabledContainerOpacity(), i, 0, i5, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getDisabledColor()), i, FilledTonalIconButtonTokens.INSTANCE.getDisabledOpacity(), i5, 0, i3, 14), i, ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getSelectedContainerColor()), i5, ColorSchemeKt.fromToken(colorScheme, FilledTonalIconButtonTokens.INSTANCE.getToggleSelectedColor()), i3, 0);
            i2 = 0;
            colorScheme.setDefaultFilledTonalIconToggleButtonColorsCached$material3_release(iconToggleButtonColors);
        }
        return defaultFilledTonalIconToggleButtonColorsCached$material3_release;
    }

    public final Shape getFilledShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1265841879;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C584@27553L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.<get-filledShape> (IconButton.kt:584)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FilledIconButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1327125527;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C588@27711L5:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.<get-outlinedShape> (IconButton.kt:588)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(OutlinedIconButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final androidx.compose.material3.IconButtonColors iconButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i;
        final Composer composer = $composer;
        int i2 = -1519621781;
        composer.startReplaceGroup(i2);
        ComposerKt.sourceInformation(composer, "C(iconButtonColors)593@27925L7,594@27968L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:592)");
        } else {
            i = $changed;
        }
        int i3 = 6;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        long unbox-impl = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        androidx.compose.material3.IconButtonColors defaultIconButtonColors-4WTKRHQ$material3_release = this.defaultIconButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), unbox-impl);
        if (Color.equals-impl0(defaultIconButtonColors-4WTKRHQ$material3_release.getContentColor-0d7_KjU(), obj9) && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultIconButtonColors-4WTKRHQ$material3_release;
        }
        final int i13 = 14;
        int i8 = 1052938076;
        final int i10 = 0;
        long l = unbox-impl;
        androidx.compose.material3.IconButtonColors iconButtonColors2 = defaultIconButtonColors-4WTKRHQ$material3_release;
        androidx.compose.material3.IconButtonColors iconButtonColors = iconButtonColors2;
        long colors = l;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return IconButtonColors.copy-jRlVdoo$default(iconButtonColors2, 0, i8, l, i10, 0, i13);
    }

    public final androidx.compose.material3.IconButtonColors iconButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU;
        androidx.compose.runtime.ProvidableCompositionLocal localContentColor;
        Color.Companion companion;
        boolean traceInProgress;
        long l;
        long contentColor2;
        int i8;
        Object unspecified-0d7_KjU2;
        long contentColor3;
        long l3;
        int i5;
        int i3;
        int i4;
        int i2;
        int i6;
        int i;
        long l2;
        final Composer composer = obj28;
        int i9 = 999008085;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(iconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)617@28950L7,622@29180L11,623@29247L7:IconButton.kt#uh7d8r");
        if (obj30 & 1 != 0) {
            l = unspecified-0d7_KjU;
        } else {
            l = containerColor;
        }
        String str2 = "CC:CompositionLocal.kt#9igjgp";
        int i12 = 2023513938;
        if (obj30 & 2 != 0) {
            int i14 = 6;
            i8 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i12, str2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            contentColor2 = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        } else {
            contentColor2 = disabledContainerColor;
        }
        if (obj30 & 4 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = $composer;
        }
        if (obj30 & 8 != 0) {
            l3 = contentColor2;
        } else {
            contentColor3 = contentColor2;
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, obj29, -1, "androidx.compose.material3.IconButtonDefaults.iconButtonColors (IconButton.kt:622)");
        } else {
            i4 = obj29;
        }
        int i13 = 6;
        ComposerKt.sourceInformationMarkerStart(composer, i12, str2);
        Object consume = composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long l5 = contentColor3;
        long contentColor4 = l2;
        long l4 = contentColor4;
        long disabledContainerColor2 = l5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.defaultIconButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), (Color)consume.unbox-impl()).copy-jRlVdoo(l, obj6, l5, 0);
    }

    public final androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i;
        final Composer composer = $composer;
        int i2 = -589987581;
        composer.startReplaceGroup(i2);
        ComposerKt.sourceInformation(composer, "C(iconToggleButtonColors)651@30397L7,652@30440L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:650)");
        } else {
            i = $changed;
        }
        int i3 = 6;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        long unbox-impl = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        androidx.compose.material3.IconToggleButtonColors defaultIconToggleButtonColors-4WTKRHQ$material3_release = this.defaultIconToggleButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), unbox-impl);
        if (Color.equals-impl0(defaultIconToggleButtonColors-4WTKRHQ$material3_release.getContentColor-0d7_KjU(), obj9) && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultIconToggleButtonColors-4WTKRHQ$material3_release;
        }
        final int i13 = 14;
        int i8 = 1052938076;
        final int i10 = 0;
        long l = unbox-impl;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors2 = defaultIconToggleButtonColors-4WTKRHQ$material3_release;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors = iconToggleButtonColors2;
        long colors = l;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return IconToggleButtonColors.copy-tNS2XkQ$default(iconToggleButtonColors2, 0, i8, l, i10, 0, i13, Color.copy-wmQWz5c$default(unbox-impl, obj7, i8, 0, i10, 0, i13), obj14);
    }

    public final androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors-5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU;
        androidx.compose.runtime.ProvidableCompositionLocal localContentColor;
        Color.Companion companion;
        int companion3;
        int companion2;
        boolean traceInProgress;
        long l4;
        long contentColor3;
        int i3;
        int i6;
        Object unspecified-0d7_KjU2;
        long contentColor2;
        long l3;
        int i2;
        int i;
        long l;
        int i4;
        int i5;
        long l5;
        int i7;
        long l2;
        final Composer composer = obj33;
        int i8 = -2020719549;
        ComposerKt.sourceInformationMarkerStart(composer, i8, "C(iconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)678@31629L7,685@31979L11,686@32052L7:IconButton.kt#uh7d8r");
        if (obj35 & 1 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = containerColor;
        }
        String str2 = "CC:CompositionLocal.kt#9igjgp";
        int i12 = 2023513938;
        if (obj35 & 2 != 0) {
            int i14 = 6;
            i3 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i12, str2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            contentColor3 = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        } else {
            contentColor3 = disabledContainerColor;
        }
        if (obj35 & 4 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = checkedContainerColor;
        }
        if (obj35 & 8 != 0) {
            l3 = contentColor3;
        } else {
            contentColor2 = contentColor3;
            l3 = $composer;
        }
        if (obj35 & 16 != 0) {
            l = contentColor3;
        } else {
            l = i9;
        }
        if (obj35 & 32 != 0) {
            l5 = contentColor3;
        } else {
            l5 = obj31;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, obj34, -1, "androidx.compose.material3.IconButtonDefaults.iconToggleButtonColors (IconButton.kt:685)");
        } else {
            i6 = obj34;
        }
        int i13 = 6;
        final int i16 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i12, str2);
        Object consume = composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long l7 = contentColor2;
        long contentColor4 = l2;
        long l6 = contentColor4;
        long disabledContainerColor2 = l7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.defaultIconToggleButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), (Color)consume.unbox-impl()).copy-tNS2XkQ(l4, obj6, l7, i6, contentColor4, obj10);
    }

    public final BorderStroke outlinedIconButtonBorder(boolean enabled, Composer $composer, int $changed) {
        long copy-wmQWz5c$default;
        boolean traceInProgress;
        int unbox-impl;
        String str;
        androidx.compose.runtime.ProvidableCompositionLocal localContentColor;
        int i2;
        int i4;
        int i;
        int i3;
        int empty;
        Object $i$a$CacheIconButtonDefaults$outlinedIconButtonBorder$1;
        int unselectedOutlineWidth-D9Ej5fM;
        int i5 = -511461558;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(outlinedIconButtonBorder)1100@51643L108:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonBorder (IconButton.kt:1091)");
        }
        String str2 = "CC:CompositionLocal.kt#9igjgp";
        unbox-impl = 2023513938;
        if (enabled) {
            $composer.startReplaceGroup(1186104514);
            ComposerKt.sourceInformation($composer, "1094@51433L7");
            i2 = 6;
            i4 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, unbox-impl, str2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            copy-wmQWz5c$default = (Color)$composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(1186170420);
            ComposerKt.sourceInformation($composer, "1096@51496L7");
            localContentColor = ContentColorKt.getLocalContentColor();
            int i9 = 6;
            int i11 = 0;
            ComposerKt.sourceInformationMarkerStart($composer, unbox-impl, str2);
            ComposerKt.sourceInformationMarkerEnd($composer);
            copy-wmQWz5c$default = Color.copy-wmQWz5c$default((Color)$composer.consume((CompositionLocal)localContentColor).unbox-impl(), localContentColor, 1039516303, 0, 0, 0, 14);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart($composer, 176816691, "CC(remember):IconButton.kt#9igjgp");
        Composer composer = $composer;
        int i10 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i12 = 0;
        if (!$composer.changed(copy-wmQWz5c$default)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i13 = 0;
                composer.updateRememberedValue(BorderStrokeKt.BorderStroke-cXLIe8U(OutlinedIconButtonTokens.INSTANCE.getUnselectedOutlineWidth-D9Ej5fM(), copy-wmQWz5c$default));
            } else {
                $i$a$CacheIconButtonDefaults$outlinedIconButtonBorder$1 = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (BorderStroke)$i$a$CacheIconButtonDefaults$outlinedIconButtonBorder$1;
    }

    public final androidx.compose.material3.IconButtonColors outlinedIconButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i;
        final Composer composer = $composer;
        int i2 = 389287465;
        composer.startReplaceGroup(i2);
        ComposerKt.sourceInformation(composer, "C(outlinedIconButtonColors)940@44790L11,940@44852L7,941@44906L7:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:938)");
        } else {
            i = $changed;
        }
        int i7 = 0;
        int i8 = 2023513938;
        final String str3 = "CC:CompositionLocal.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd(composer);
        androidx.compose.material3.IconButtonColors iconButtonColors = defaultOutlinedIconButtonColors-4WTKRHQ$material3_release;
        int i6 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, i8, str3);
        ComposerKt.sourceInformationMarkerEnd(composer);
        long unbox-impl2 = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        if (Color.equals-impl0(iconButtonColors.getContentColor-0d7_KjU(), 6) && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return iconButtonColors;
        }
        final int i15 = 0;
        final int i10 = 0;
        final int i13 = 0;
        long l2 = unbox-impl2;
        long l = l2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return IconButtonColors.copy-jRlVdoo$default(iconButtonColors, 0, obj10, l2, i10, 0, i13);
    }

    public final androidx.compose.material3.IconButtonColors outlinedIconButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU2;
        androidx.compose.runtime.ProvidableCompositionLocal localContentColor;
        Color.Companion companion;
        boolean traceInProgress;
        long l2;
        long contentColor3;
        int i5;
        Object unspecified-0d7_KjU;
        long contentColor2;
        long l3;
        int i4;
        int i6;
        int i;
        int i3;
        int i8;
        int i2;
        long l;
        final Composer composer = obj28;
        int i9 = -1030517545;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(outlinedIconButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)965@45873L7,970@46107L11,971@46182L7:IconButton.kt#uh7d8r");
        if (obj30 & 1 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = containerColor;
        }
        String str2 = "CC:CompositionLocal.kt#9igjgp";
        int i12 = 2023513938;
        if (obj30 & 2 != 0) {
            int i14 = 6;
            i5 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i12, str2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            contentColor3 = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        } else {
            contentColor3 = disabledContainerColor;
        }
        if (obj30 & 4 != 0) {
            l = unspecified-0d7_KjU;
        } else {
            l = $composer;
        }
        if (obj30 & 8 != 0) {
            l3 = contentColor3;
        } else {
            contentColor2 = contentColor3;
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, obj29, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors (IconButton.kt:970)");
        } else {
            i = obj29;
        }
        int i13 = 6;
        ComposerKt.sourceInformationMarkerStart(composer, i12, str2);
        Object consume = composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long l5 = contentColor2;
        long contentColor4 = l;
        long l4 = contentColor4;
        long disabledContainerColor2 = l5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.defaultOutlinedIconButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), (Color)consume.unbox-impl()).copy-jRlVdoo(l2, obj6, l5, 0);
    }

    public final BorderStroke outlinedIconToggleButtonBorder(boolean enabled, boolean checked, Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1244729690;
        $composer.startReplaceGroup(i);
        ComposerKt.sourceInformation($composer, "C(outlinedIconToggleButtonBorder)P(1)1082@51041L33:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonBorder (IconButton.kt:1078)");
        }
        if (checked && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceGroup();
            return null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return outlinedIconButtonBorder(enabled, $composer, i3 |= i6);
    }

    public final androidx.compose.material3.IconToggleButtonColors outlinedIconToggleButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i;
        final Composer composer = $composer;
        int i2 = -779749183;
        composer.startReplaceGroup(i2);
        ComposerKt.sourceInformation(composer, "C(outlinedIconToggleButtonColors)1001@47390L7,1002@47433L11:IconButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:1000)");
        } else {
            i = $changed;
        }
        int i3 = 6;
        int i5 = 0;
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd(composer);
        long unbox-impl = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        androidx.compose.material3.IconToggleButtonColors defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release = this.defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), unbox-impl);
        if (Color.equals-impl0(defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release.getContentColor-0d7_KjU(), obj9) && ComposerKt.isTraceInProgress()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            composer.endReplaceGroup();
            return defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release;
        }
        final int i13 = 14;
        int i8 = 1052938076;
        final int i10 = 0;
        long l = unbox-impl;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors2 = defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release;
        androidx.compose.material3.IconToggleButtonColors iconToggleButtonColors = iconToggleButtonColors2;
        long colors = l;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return IconToggleButtonColors.copy-tNS2XkQ$default(iconToggleButtonColors2, 0, i8, l, i10, 0, i13, Color.copy-wmQWz5c$default(unbox-impl, obj7, i8, 0, i10, 0, i13), obj14);
    }

    public final androidx.compose.material3.IconToggleButtonColors outlinedIconToggleButtonColors-5tl4gsc(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, long checkedContainerColor, long checkedContentColor, Composer $composer, int $changed, int i9) {
        long unspecified-0d7_KjU2;
        androidx.compose.runtime.ProvidableCompositionLocal localContentColor;
        Color.Companion companion;
        int companion2;
        int i4;
        boolean traceInProgress;
        long l5;
        long contentColor3;
        int i;
        Object unspecified-0d7_KjU;
        long contentColor2;
        long l4;
        int i7;
        int i6;
        long l;
        int i2;
        int i3;
        long l2;
        int i5;
        long l3;
        final Composer composer = obj33;
        final int i8 = obj34;
        int i10 = 2130592709;
        ComposerKt.sourceInformationMarkerStart(composer, i10, "C(outlinedIconToggleButtonColors)P(2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,0:c#ui.graphics.Color,1:c#ui.graphics.Color)1028@48650L7,1033@48932L38,1035@49025L11,1036@49106L7:IconButton.kt#uh7d8r");
        if (obj35 & 1 != 0) {
            l5 = unspecified-0d7_KjU2;
        } else {
            l5 = containerColor;
        }
        String str2 = "CC:CompositionLocal.kt#9igjgp";
        int i14 = 2023513938;
        if (obj35 & 2 != 0) {
            int i16 = 6;
            i = 0;
            ComposerKt.sourceInformationMarkerStart(composer, i14, str2);
            ComposerKt.sourceInformationMarkerEnd(composer);
            contentColor3 = (Color)composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor()).unbox-impl();
        } else {
            contentColor3 = disabledContainerColor;
        }
        if (obj35 & 4 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = checkedContainerColor;
        }
        if (obj35 & 8 != 0) {
            l4 = contentColor3;
        } else {
            contentColor2 = contentColor3;
            l4 = $composer;
        }
        if (obj35 & 16 != 0) {
            l = contentColor3;
        } else {
            l = i9;
        }
        if (obj35 & 32 != 0) {
            l2 = contentColor3;
        } else {
            l2 = obj31;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i10, i8, -1, "androidx.compose.material3.IconButtonDefaults.outlinedIconToggleButtonColors (IconButton.kt:1035)");
        }
        int i15 = 6;
        ComposerKt.sourceInformationMarkerStart(composer, i14, str2);
        Object consume = composer.consume((CompositionLocal)ContentColorKt.getLocalContentColor());
        ComposerKt.sourceInformationMarkerEnd(composer);
        long l7 = contentColor2;
        long contentColor4 = l3;
        long l6 = contentColor4;
        long disabledContainerColor2 = l7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.defaultOutlinedIconToggleButtonColors-4WTKRHQ$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6), (Color)consume.unbox-impl()).copy-tNS2XkQ(l5, obj7, l7, 0, contentColor4, obj11);
    }
}
