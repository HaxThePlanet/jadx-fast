package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002JN\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 Jl\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010#\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00192\u0008\u0008\u0002\u0010$\u001a\u00020\u00192\u0008\u0008\u0002\u0010%\u001a\u00020\u00192\u0008\u0008\u0002\u0010&\u001a\u00020\u00192\u0008\u0008\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008(\u0010)JN\u0010*\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010 Jl\u0010,\u001a\u00020\"2\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00192\u0008\u0008\u0002\u0010#\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00192\u0008\u0008\u0002\u0010$\u001a\u00020\u00192\u0008\u0008\u0002\u0010%\u001a\u00020\u00192\u0008\u0008\u0002\u0010&\u001a\u00020\u00192\u0008\u0008\u0002\u0010'\u001a\u00020\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008-\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0008\u0010\tR\u0019\u0010\u000b\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000c\u0010\tR\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u000f\u0010\tR\u0019\u0010\u0010\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\n\u001a\u0004\u0008\u0011\u0010\tR\u0011\u0010\u0012\u001a\u00020\u00138G¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006.", d2 = {"Landroidx/compose/material/ChipDefaults;", "", "()V", "ContentOpacity", "", "LeadingIconOpacity", "LeadingIconSize", "Landroidx/compose/ui/unit/Dp;", "getLeadingIconSize-D9Ej5fM", "()F", "F", "MinHeight", "getMinHeight-D9Ej5fM", "OutlinedBorderOpacity", "OutlinedBorderSize", "getOutlinedBorderSize-D9Ej5fM", "SelectedIconSize", "getSelectedIconSize-D9Ej5fM", "outlinedBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "chipColors", "Landroidx/compose/material/ChipColors;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "leadingIconContentColor", "disabledBackgroundColor", "disabledContentColor", "disabledLeadingIconContentColor", "chipColors-5tl4gsc", "(JJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/ChipColors;", "filterChipColors", "Landroidx/compose/material/SelectableChipColors;", "leadingIconColor", "disabledLeadingIconColor", "selectedBackgroundColor", "selectedContentColor", "selectedLeadingIconColor", "filterChipColors-J08w3-E", "(JJJJJJJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/SelectableChipColors;", "outlinedChipColors", "outlinedChipColors-5tl4gsc", "outlinedFilterChipColors", "outlinedFilterChipColors-J08w3-E", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChipDefaults {

    public static final int $stable = 0;
    public static final float ContentOpacity = 0.87f;
    public static final androidx.compose.material.ChipDefaults INSTANCE = null;
    public static final float LeadingIconOpacity = 0.54f;
    private static final float LeadingIconSize = 0f;
    private static final float MinHeight = 0f;
    public static final float OutlinedBorderOpacity = 0.12f;
    private static final float OutlinedBorderSize;
    private static final float SelectedIconSize;
    static {
        ChipDefaults chipDefaults = new ChipDefaults();
        ChipDefaults.INSTANCE = chipDefaults;
        int i5 = 0;
        ChipDefaults.MinHeight = Dp.constructor-impl((float)i);
        int i6 = 0;
        ChipDefaults.OutlinedBorderSize = Dp.constructor-impl((float)i2);
        int i7 = 0;
        ChipDefaults.LeadingIconSize = Dp.constructor-impl((float)i3);
        int i8 = 0;
        ChipDefaults.SelectedIconSize = Dp.constructor-impl((float)i4);
    }

    public final androidx.compose.material.ChipColors chipColors-5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i9) {
        androidx.compose.material.Colors colors2;
        androidx.compose.material.Colors colors3;
        int colors;
        int i15;
        int copy-wmQWz5c$default2;
        boolean traceInProgress;
        int str;
        long copy-wmQWz5c$default;
        int i2;
        long l7;
        long surface-0d7_KjU;
        long l;
        int i14;
        int i12;
        long l6;
        int i6;
        int i3;
        long l3;
        int i7;
        int i;
        long l5;
        int i8;
        int i13;
        long l2;
        int i10;
        int i4;
        long l4;
        int i11;
        int i5;
        int i16;
        long obj22;
        int obj24;
        int obj25;
        int obj26;
        int obj27;
        int obj28;
        int obj29;
        final Composer composer = obj34;
        int i17 = 1838505436;
        ComposerKt.sourceInformationMarkerStart(composer, i17, "C(chipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)392@17154L6,393@17248L6,394@17309L6,397@17511L6,398@17571L8,399@17646L6,401@17753L8,404@17901L8:Chip.kt#jmzs0o");
        str = 6;
        if (obj36 & 1 != 0) {
            int i25 = 0;
            l = copy-wmQWz5c$default;
        } else {
            l = backgroundColor;
        }
        if (obj36 & 2 != 0) {
            l6 = copy-wmQWz5c$default;
        } else {
            l6 = leadingIconContentColor;
        }
        if (obj36 & 4 != 0) {
            l3 = copy-wmQWz5c$default;
        } else {
            l3 = disabledContentColor;
        }
        if (obj36 & 8 != 0) {
            l5 = copy-wmQWz5c$default;
        } else {
            l5 = $composer;
        }
        if (obj36 & 16 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = i9;
        }
        if (obj36 & 32 != 0) {
            l4 = copy-wmQWz5c$default2;
        } else {
            l4 = obj32;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i17, obj35, -1, "androidx.compose.material.ChipDefaults.chipColors (Chip.kt:405)");
        } else {
            i2 = obj35;
        }
        DefaultChipColors defaultChipColors = new DefaultChipColors(l, i14, l6, i6, l3, i7, l5, i8, l2, i10, l4, i11, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (ChipColors)defaultChipColors;
    }

    public final androidx.compose.material.SelectableChipColors filterChipColors-J08w3-E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i12) {
        int i9;
        int traceInProgress;
        int colors;
        int colors2;
        int colors3;
        int i22;
        int i13;
        int i21;
        int compositeOver--OWjLjI;
        int i19;
        long compositeOver--OWjLjI2;
        long l5;
        long surface-0d7_KjU;
        long l3;
        int i2;
        int i18;
        long l6;
        int i8;
        int i5;
        long l2;
        int i10;
        int i;
        long l9;
        int i16;
        int i3;
        long l8;
        int i11;
        int i14;
        long l4;
        int i23;
        int i20;
        long l7;
        int i6;
        int i7;
        long l;
        int i17;
        int i4;
        long l10;
        int i15;
        long obj28;
        int obj30;
        int obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        final Composer composer = obj46;
        int i24 = obj48;
        final int i25 = 830140629;
        ComposerKt.sourceInformationMarkerStart(composer, i25, "C(filterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)462@20979L6,463@21073L6,464@21134L6,467@21321L6,468@21381L8,469@21456L6,471@21563L8,474@21698L8,476@21794L6,479@21953L6,482@22114L6:Chip.kt#jmzs0o");
        int i27 = 6;
        if (i24 & 1 != 0) {
            int i34 = 0;
            l3 = compositeOver--OWjLjI2;
        } else {
            l3 = backgroundColor;
        }
        if (i24 & 2 != 0) {
            l6 = compositeOver--OWjLjI2;
        } else {
            l6 = leadingIconColor;
        }
        if (i24 & 4 != 0) {
            l2 = compositeOver--OWjLjI2;
        } else {
            l2 = disabledContentColor;
        }
        if (i24 & 8 != 0) {
            l9 = compositeOver--OWjLjI2;
        } else {
            l9 = selectedBackgroundColor;
        }
        if (i24 & 16 != 0) {
            l8 = compositeOver--OWjLjI2;
        } else {
            l8 = selectedLeadingIconColor;
        }
        if (i24 & 32 != 0) {
            l4 = compositeOver--OWjLjI2;
        } else {
            l4 = $changed;
        }
        if (i24 & 64 != 0) {
            l7 = compositeOver--OWjLjI2;
        } else {
            l7 = obj40;
        }
        if (i24 & 128 != 0) {
            l = compositeOver--OWjLjI2;
        } else {
            l = obj42;
        }
        if (i24 &= 256 != 0) {
            l10 = compositeOver--OWjLjI;
        } else {
            l10 = obj44;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i25, obj47, -1, "androidx.compose.material.ChipDefaults.filterChipColors (Chip.kt:485)");
        } else {
            i19 = obj47;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(l3, i2, l6, i8, l2, i10, l9, i16, l8, i11, l4, i23, l7, i6, l, i17, l10, i15, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (SelectableChipColors)defaultSelectableChipColors;
    }

    public final float getLeadingIconSize-D9Ej5fM() {
        return ChipDefaults.LeadingIconSize;
    }

    public final float getMinHeight-D9Ej5fM() {
        return ChipDefaults.MinHeight;
    }

    public final BorderStroke getOutlinedBorder(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1650225597;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C550@25483L6:Chip.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ChipDefaults.<get-outlinedBorder> (Chip.kt:549)");
        }
        long onSurface-0d7_KjU = MaterialTheme.INSTANCE.getColors($composer, 6).getOnSurface-0d7_KjU();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(ChipDefaults.OutlinedBorderSize, Color.copy-wmQWz5c$default(onSurface-0d7_KjU, obj3, 1039516303, 0, 0, 0, 14));
    }

    public final float getOutlinedBorderSize-D9Ej5fM() {
        return ChipDefaults.OutlinedBorderSize;
    }

    public final float getSelectedIconSize-D9Ej5fM() {
        return ChipDefaults.SelectedIconSize;
    }

    public final androidx.compose.material.ChipColors outlinedChipColors-5tl4gsc(long backgroundColor, long contentColor, long leadingIconContentColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconContentColor, Composer $composer, int $changed, int i9) {
        androidx.compose.material.Colors colors;
        androidx.compose.material.Colors colors2;
        int i14;
        int copy-wmQWz5c$default2;
        boolean traceInProgress;
        int str;
        long backgroundColor2;
        long copy-wmQWz5c$default;
        long leadingIconContentColor2;
        int i12;
        long disabledBackgroundColor2;
        int i3;
        int i8;
        long disabledContentColor2;
        int i4;
        int i2;
        long l;
        int i6;
        long l2;
        int i7;
        int i11;
        int i5;
        int i;
        int i13;
        int i10;
        long obj24;
        int obj26;
        int obj27;
        int obj28;
        int obj29;
        int obj30;
        int obj31;
        final Composer composer = obj36;
        final int i15 = obj37;
        int i16 = -1763922662;
        ComposerKt.sourceInformationMarkerStart(composer, i16, "C(outlinedChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color)428@19097L6,429@19157L6,433@19440L8,436@19588L8,437@19640L342:Chip.kt#jmzs0o");
        str = 6;
        if (obj38 & 1 != 0) {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors(composer, str).getSurface-0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (obj38 & 2 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = leadingIconContentColor;
        }
        if (obj38 & 4 != 0) {
            leadingIconContentColor2 = Color.copy-wmQWz5c$default(l2, obj16, 1057635697, 0, 0, 0, 14);
        } else {
            leadingIconContentColor2 = disabledContentColor;
        }
        disabledBackgroundColor2 = obj38 & 8 != 0 ? backgroundColor2 : $composer;
        if (obj38 & 16 != 0) {
            disabledContentColor2 = Color.copy-wmQWz5c$default(l2, contentColor, disabled2 *= i37, 0, 0, 0, 14);
        } else {
            disabledContentColor2 = i9;
        }
        if (obj38 & 32 != 0) {
            l = copy-wmQWz5c$default2;
        } else {
            l = obj34;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i16, i15, -1, "androidx.compose.material.ChipDefaults.outlinedChipColors (Chip.kt:437)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(obj36);
        return this.chipColors-5tl4gsc(backgroundColor2, str, l2, obj5, leadingIconContentColor2, obj7, disabledBackgroundColor2, i3, disabledContentColor2);
    }

    public final androidx.compose.material.SelectableChipColors outlinedFilterChipColors-J08w3-E(long backgroundColor, long contentColor, long leadingIconColor, long disabledBackgroundColor, long disabledContentColor, long disabledLeadingIconColor, long selectedBackgroundColor, long selectedContentColor, long selectedLeadingIconColor, Composer $composer, int $changed, int i12) {
        int i5;
        int traceInProgress;
        int colors2;
        int colors;
        int i19;
        int i20;
        int i18;
        int compositeOver--OWjLjI2;
        int i13;
        long compositeOver--OWjLjI;
        int i6;
        int i14;
        long l3;
        long l4;
        int i7;
        long l2;
        int i11;
        int i;
        long l9;
        int i15;
        int i16;
        long l6;
        int i8;
        long l5;
        int i10;
        long l8;
        int i9;
        int i4;
        long l7;
        int i3;
        int i2;
        long l;
        int i17;
        long obj28;
        int obj30;
        int obj31;
        int obj32;
        int obj33;
        int obj34;
        int obj35;
        final Composer composer = obj46;
        int i21 = obj48;
        final int i22 = 346878099;
        ComposerKt.sourceInformationMarkerStart(composer, i22, "C(outlinedFilterChipColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,5:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color,4:c#ui.graphics.Color,6:c#ui.graphics.Color,7:c#ui.graphics.Color,8:c#ui.graphics.Color)513@23764L6,514@23824L6,518@24084L8,521@24219L8,523@24315L6,526@24475L6,529@24636L6:Chip.kt#jmzs0o");
        int i25 = 6;
        if (i21 & 1 != 0) {
            l3 = compositeOver--OWjLjI;
        } else {
            l3 = backgroundColor;
        }
        if (i21 & 2 != 0) {
            l4 = compositeOver--OWjLjI;
        } else {
            l4 = leadingIconColor;
        }
        if (i21 & 4 != 0) {
            l2 = compositeOver--OWjLjI;
        } else {
            l2 = disabledContentColor;
        }
        l9 = i21 & 8 != 0 ? compositeOver--OWjLjI : selectedBackgroundColor;
        if (i21 & 16 != 0) {
            l6 = compositeOver--OWjLjI;
        } else {
            l6 = selectedLeadingIconColor;
        }
        if (i21 & 32 != 0) {
            l5 = compositeOver--OWjLjI;
        } else {
            l5 = $changed;
        }
        if (i21 & 64 != 0) {
            l8 = compositeOver--OWjLjI;
        } else {
            l8 = obj40;
        }
        if (i21 & 128 != 0) {
            l7 = compositeOver--OWjLjI;
        } else {
            l7 = obj42;
        }
        if (i21 &= 256 != 0) {
            l = compositeOver--OWjLjI2;
        } else {
            l = obj44;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i22, obj47, -1, "androidx.compose.material.ChipDefaults.outlinedFilterChipColors (Chip.kt:532)");
        } else {
            i13 = obj47;
        }
        DefaultSelectableChipColors defaultSelectableChipColors = new DefaultSelectableChipColors(l3, obj9, l4, obj11, l2, i11, l9, i15, l6, i8, l5, i10, l8, i9, l7, i3, l, i17, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (SelectableChipColors)defaultSelectableChipColors;
    }
}
