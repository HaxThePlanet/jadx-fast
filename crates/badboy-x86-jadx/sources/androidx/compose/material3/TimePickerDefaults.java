package androidx.compose.material3;

import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0008\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\tJ\u009e\u0001\u0010\u0008\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u000bH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u001cH\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eR\u0018\u0010\u0003\u001a\u00020\u0004*\u00020\u00058@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/material3/TimePickerDefaults;", "", "()V", "defaultTimePickerColors", "Landroidx/compose/material3/TimePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultTimePickerColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/TimePickerColors;", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TimePickerColors;", "clockDialColor", "Landroidx/compose/ui/graphics/Color;", "clockDialSelectedContentColor", "clockDialUnselectedContentColor", "selectorColor", "containerColor", "periodSelectorBorderColor", "periodSelectorSelectedContainerColor", "periodSelectorUnselectedContainerColor", "periodSelectorSelectedContentColor", "periodSelectorUnselectedContentColor", "timeSelectorSelectedContainerColor", "timeSelectorUnselectedContainerColor", "timeSelectorSelectedContentColor", "timeSelectorUnselectedContentColor", "colors-u3YEpmA", "(JJJJJJJJJJJJJJLandroidx/compose/runtime/Composer;III)Landroidx/compose/material3/TimePickerColors;", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "layoutType-sDNSZnc", "(Landroidx/compose/runtime/Composer;I)I", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TimePickerDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.TimePickerDefaults INSTANCE;
    static {
        TimePickerDefaults timePickerDefaults = new TimePickerDefaults();
        TimePickerDefaults.INSTANCE = timePickerDefaults;
    }

    public final androidx.compose.material3.TimePickerColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2085808058;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)270@13292L11:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:270)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultTimePickerColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.TimePickerColors colors-u3YEpmA(long clockDialColor, long clockDialSelectedContentColor, long clockDialUnselectedContentColor, long selectorColor, long containerColor, long periodSelectorBorderColor, long periodSelectorSelectedContainerColor, long periodSelectorUnselectedContainerColor, long periodSelectorSelectedContentColor, long periodSelectorUnselectedContentColor, long timeSelectorSelectedContainerColor, long timeSelectorUnselectedContainerColor, long timeSelectorSelectedContentColor, long timeSelectorUnselectedContentColor, Composer $composer, int $changed, int $changed1, int i18) {
        Color.Companion companion;
        boolean traceInProgress;
        int unspecified-0d7_KjU8;
        int unspecified-0d7_KjU13;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU12;
        int unspecified-0d7_KjU9;
        int unspecified-0d7_KjU7;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU10;
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU6;
        long unspecified-0d7_KjU5;
        int i;
        int i2;
        long l6;
        long l7;
        long l;
        long l12;
        long l10;
        long l3;
        long l13;
        long l11;
        long l9;
        long l2;
        long l4;
        long l14;
        long l5;
        long l8;
        final Composer composer = obj63;
        int i3 = obj66;
        int i4 = -646352288;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(colors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,5:c#ui.graphics.Color,7:c#ui.graphics.Color,6:c#ui.graphics.Color,8:c#ui.graphics.Color,10:c#ui.graphics.Color,12:c#ui.graphics.Color,11:c#ui.graphics.Color,13:c#ui.graphics.Color)317@16058L11:TimePicker.kt#uh7d8r");
        if (i3 & 1 != 0) {
            l6 = unspecified-0d7_KjU8;
        } else {
            l6 = clockDialColor;
        }
        if (i3 & 2 != 0) {
            l10 = unspecified-0d7_KjU13;
        } else {
            l10 = clockDialUnselectedContentColor;
        }
        if (i3 & 4 != 0) {
            l3 = unspecified-0d7_KjU11;
        } else {
            l3 = containerColor;
        }
        if (i3 & 8 != 0) {
            l7 = unspecified-0d7_KjU;
        } else {
            l7 = periodSelectorSelectedContainerColor;
        }
        if (i3 & 16 != 0) {
            l = unspecified-0d7_KjU12;
        } else {
            l = periodSelectorSelectedContentColor;
        }
        if (i3 & 32 != 0) {
            l12 = unspecified-0d7_KjU9;
        } else {
            l12 = timeSelectorSelectedContainerColor;
        }
        if (i3 & 64 != 0) {
            l13 = unspecified-0d7_KjU7;
        } else {
            l13 = timeSelectorSelectedContentColor;
        }
        if (i3 & 128 != 0) {
            l11 = unspecified-0d7_KjU3;
        } else {
            l11 = $composer;
        }
        if (i3 & 256 != 0) {
            l9 = unspecified-0d7_KjU2;
        } else {
            l9 = $changed1;
        }
        if (i3 & 512 != 0) {
            l2 = unspecified-0d7_KjU10;
        } else {
            l2 = obj53;
        }
        if (i3 & 1024 != 0) {
            l4 = unspecified-0d7_KjU4;
        } else {
            l4 = obj55;
        }
        if (i3 & 2048 != 0) {
            l14 = unspecified-0d7_KjU6;
        } else {
            l14 = obj57;
        }
        if (i3 & 4096 != 0) {
            l5 = unspecified-0d7_KjU5;
        } else {
            l5 = obj59;
        }
        if (i3 &= 8192 != 0) {
            l8 = unspecified-0d7_KjU5;
        } else {
            l8 = obj61;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, obj64, obj65, "androidx.compose.material3.TimePickerDefaults.colors (TimePicker.kt:317)");
        } else {
            i = obj64;
            i2 = obj65;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultTimePickerColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-dVHXu7A(l6, obj7, l7, obj9, l, obj11, l12, obj13, l10, obj15, l3, obj17, l13, obj19);
    }

    public final androidx.compose.material3.TimePickerColors getDefaultTimePickerColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultTimePickerColors) {
        androidx.compose.material3.TimePickerColors defaultTimePickerColorsCached$material3_release;
        androidx.compose.material3.TimePickerColors timePickerColors;
        int i2;
        long token9;
        long token10;
        long token8;
        long token3;
        long token5;
        long token6;
        long transparent-0d7_KjU;
        long token12;
        long token11;
        long token2;
        long token;
        long token4;
        long token7;
        int i;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultTimePickerColors;
        if (colorScheme.getDefaultTimePickerColorsCached$material3_release() == null) {
            timePickerColors = new TimePickerColors(ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getClockDialColor()), obj4, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getClockDialSelectorHandleContainerColor()), obj6, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getContainerColor()), obj8, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getPeriodSelectorOutlineColor()), obj10, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getClockDialSelectedLabelTextColor()), obj12, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getClockDialUnselectedLabelTextColor()), obj14, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getPeriodSelectorSelectedContainerColor()), obj16, Color.Companion.getTransparent-0d7_KjU(), obj18, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getPeriodSelectorSelectedLabelTextColor()), obj20, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getPeriodSelectorUnselectedLabelTextColor()), obj22, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getTimeSelectorSelectedContainerColor()), obj24, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getTimeSelectorUnselectedContainerColor()), obj26, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getTimeSelectorSelectedLabelTextColor()), obj28, ColorSchemeKt.fromToken(colorScheme, TimePickerTokens.INSTANCE.getTimeSelectorUnselectedLabelTextColor()), obj30, 0);
            i2 = 0;
            colorScheme.setDefaultTimePickerColorsCached$material3_release(timePickerColors);
        }
        return defaultTimePickerColorsCached$material3_release;
    }

    public final int layoutType-sDNSZnc(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 517161502;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(layoutType)367@19209L27:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.TimePickerDefaults.layoutType (TimePicker.kt:367)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return TimePicker_androidKt.getDefaultTimePickerLayoutType($composer, 0);
    }
}
