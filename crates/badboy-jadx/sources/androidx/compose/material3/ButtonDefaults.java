package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.tokens.ElevatedButtonTokens;
import androidx.compose.material3.tokens.FilledButtonTokens;
import androidx.compose.material3.tokens.FilledTonalButtonTokens;
import androidx.compose.material3.tokens.OutlinedButtonTokens;
import androidx.compose.material3.tokens.TextButtonTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0015\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010:\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010:\u001a\u00020.2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008A\u0010BJD\u0010C\u001a\u00020D2\u0008\u0008\u0002\u0010E\u001a\u00020\u00042\u0008\u0008\u0002\u0010F\u001a\u00020\u00042\u0008\u0008\u0002\u0010G\u001a\u00020\u00042\u0008\u0008\u0002\u0010H\u001a\u00020\u00042\u0008\u0008\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008J\u0010KJ\r\u0010L\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010L\u001a\u00020.2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008M\u0010BJD\u0010N\u001a\u00020D2\u0008\u0008\u0002\u0010E\u001a\u00020\u00042\u0008\u0008\u0002\u0010F\u001a\u00020\u00042\u0008\u0008\u0002\u0010G\u001a\u00020\u00042\u0008\u0008\u0002\u0010H\u001a\u00020\u00042\u0008\u0008\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008O\u0010KJ\r\u0010P\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010P\u001a\u00020.2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008Q\u0010BJD\u0010R\u001a\u00020D2\u0008\u0008\u0002\u0010E\u001a\u00020\u00042\u0008\u0008\u0002\u0010F\u001a\u00020\u00042\u0008\u0008\u0002\u0010G\u001a\u00020\u00042\u0008\u0008\u0002\u0010H\u001a\u00020\u00042\u0008\u0008\u0002\u0010I\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008S\u0010KJ\u0017\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010T\u001a\u00020UH\u0007¢\u0006\u0002\u0010VJ\r\u0010W\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010W\u001a\u00020.2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008X\u0010BJ\r\u0010Y\u001a\u00020.H\u0007¢\u0006\u0002\u0010;J:\u0010Y\u001a\u00020.2\u0008\u0008\u0002\u0010<\u001a\u00020=2\u0008\u0008\u0002\u0010>\u001a\u00020=2\u0008\u0008\u0002\u0010?\u001a\u00020=2\u0008\u0008\u0002\u0010@\u001a\u00020=H\u0007ø\u0001\u0000¢\u0006\u0004\u0008Z\u0010BR\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u000c\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u000f\u0010\u0010R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0012\u0010\u0010R\u0019\u0010\u0013\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0014\u0010\u0010R\u0019\u0010\u0015\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0016\u0010\u0010R\u0011\u0010\u0017\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\nR\u0016\u0010\u0019\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001a\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\nR\u0016\u0010\u001c\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005R\u0011\u0010\u001d\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010 R\u0011\u0010!\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\u0008\"\u0010 R\u0011\u0010#\u001a\u00020$8G¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0011\u0010'\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\u0008(\u0010 R\u0011\u0010)\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\u0008*\u0010 R\u0011\u0010+\u001a\u00020\u001e8G¢\u0006\u0006\u001a\u0004\u0008,\u0010 R\u0018\u0010-\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R\u0018\u00102\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00083\u00101R\u0018\u00104\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00085\u00101R\u0018\u00106\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00087\u00101R\u0018\u00108\u001a\u00020.*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u00101\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006[", d2 = {"Landroidx/compose/material3/ButtonDefaults;", "", "()V", "ButtonHorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "ButtonVerticalPadding", "ButtonWithIconContentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getButtonWithIconContentPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "ButtonWithIconHorizontalStartPadding", "ContentPadding", "getContentPadding", "IconSize", "getIconSize-D9Ej5fM", "()F", "IconSpacing", "getIconSpacing-D9Ej5fM", "MinHeight", "getMinHeight-D9Ej5fM", "MinWidth", "getMinWidth-D9Ej5fM", "TextButtonContentPadding", "getTextButtonContentPadding", "TextButtonHorizontalPadding", "TextButtonWithIconContentPadding", "getTextButtonWithIconContentPadding", "TextButtonWithIconHorizontalEndPadding", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "filledTonalShape", "getFilledTonalShape", "outlinedButtonBorder", "Landroidx/compose/foundation/BorderStroke;", "getOutlinedButtonBorder", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/BorderStroke;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "textShape", "getTextShape", "defaultButtonColors", "Landroidx/compose/material3/ButtonColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultButtonColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/ButtonColors;", "defaultElevatedButtonColors", "getDefaultElevatedButtonColors$material3_release", "defaultFilledTonalButtonColors", "getDefaultFilledTonalButtonColors$material3_release", "defaultOutlinedButtonColors", "getDefaultOutlinedButtonColors$material3_release", "defaultTextButtonColors", "getDefaultTextButtonColors$material3_release", "buttonColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/ButtonColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "buttonColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonColors;", "buttonElevation", "Landroidx/compose/material3/ButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "disabledElevation", "buttonElevation-R_JCAzs", "(FFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/ButtonElevation;", "elevatedButtonColors", "elevatedButtonColors-ro_MJ88", "elevatedButtonElevation", "elevatedButtonElevation-R_JCAzs", "filledTonalButtonColors", "filledTonalButtonColors-ro_MJ88", "filledTonalButtonElevation", "filledTonalButtonElevation-R_JCAzs", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedButtonColors", "outlinedButtonColors-ro_MJ88", "textButtonColors", "textButtonColors-ro_MJ88", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ButtonDefaults {

    public static final int $stable;
    private static final float ButtonHorizontalPadding;
    private static final float ButtonVerticalPadding;
    private static final PaddingValues ButtonWithIconContentPadding;
    private static final float ButtonWithIconHorizontalStartPadding;
    private static final PaddingValues ContentPadding;
    public static final androidx.compose.material3.ButtonDefaults INSTANCE;
    private static final float IconSize;
    private static final float IconSpacing;
    private static final float MinHeight;
    private static final float MinWidth;
    private static final PaddingValues TextButtonContentPadding;
    private static final float TextButtonHorizontalPadding;
    private static final PaddingValues TextButtonWithIconContentPadding;
    private static final float TextButtonWithIconHorizontalEndPadding;
    static {
        ButtonDefaults buttonDefaults = new ButtonDefaults();
        ButtonDefaults.INSTANCE = buttonDefaults;
        int i9 = 0;
        ButtonDefaults.ButtonHorizontalPadding = Dp.constructor-impl((float)i);
        int i10 = 0;
        ButtonDefaults.ButtonVerticalPadding = Dp.constructor-impl((float)i2);
        ButtonDefaults.ContentPadding = PaddingKt.PaddingValues-a9UjIt4(ButtonDefaults.ButtonHorizontalPadding, ButtonDefaults.ButtonVerticalPadding, ButtonDefaults.ButtonHorizontalPadding, ButtonDefaults.ButtonVerticalPadding);
        int i11 = 0;
        ButtonDefaults.ButtonWithIconHorizontalStartPadding = Dp.constructor-impl((float)i3);
        ButtonDefaults.ButtonWithIconContentPadding = PaddingKt.PaddingValues-a9UjIt4(ButtonDefaults.ButtonWithIconHorizontalStartPadding, ButtonDefaults.ButtonVerticalPadding, ButtonDefaults.ButtonHorizontalPadding, ButtonDefaults.ButtonVerticalPadding);
        int i12 = 0;
        ButtonDefaults.TextButtonHorizontalPadding = Dp.constructor-impl((float)i4);
        ButtonDefaults.TextButtonContentPadding = PaddingKt.PaddingValues-a9UjIt4(ButtonDefaults.TextButtonHorizontalPadding, ButtonDefaults.ContentPadding.calculateTopPadding-D9Ej5fM(), ButtonDefaults.TextButtonHorizontalPadding, ButtonDefaults.ContentPadding.calculateBottomPadding-D9Ej5fM());
        int i13 = 0;
        ButtonDefaults.TextButtonWithIconHorizontalEndPadding = Dp.constructor-impl((float)i5);
        ButtonDefaults.TextButtonWithIconContentPadding = PaddingKt.PaddingValues-a9UjIt4(ButtonDefaults.TextButtonHorizontalPadding, ButtonDefaults.ContentPadding.calculateTopPadding-D9Ej5fM(), ButtonDefaults.TextButtonWithIconHorizontalEndPadding, ButtonDefaults.ContentPadding.calculateBottomPadding-D9Ej5fM());
        int i14 = 0;
        ButtonDefaults.MinWidth = Dp.constructor-impl((float)i6);
        int i15 = 0;
        ButtonDefaults.MinHeight = Dp.constructor-impl((float)i7);
        ButtonDefaults.IconSize = FilledButtonTokens.INSTANCE.getIconSize-D9Ej5fM();
        int i16 = 0;
        ButtonDefaults.IconSpacing = Dp.constructor-impl((float)i8);
    }

    public final androidx.compose.material3.ButtonColors buttonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1449248637;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(buttonColors)564@26242L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:564)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ButtonColors buttonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU3;
        int unspecified-0d7_KjU4;
        boolean traceInProgress;
        String str;
        long l2;
        long l;
        long l3;
        long l4;
        int i;
        final Composer composer = obj23;
        int i2 = -339300779;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(buttonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)582@27048L11:Button.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l2 = unspecified-0d7_KjU;
        } else {
            l2 = containerColor;
        }
        if (obj25 & 2 != 0) {
            l = unspecified-0d7_KjU2;
        } else {
            l = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l3 = unspecified-0d7_KjU3;
        } else {
            l3 = $composer;
        }
        if (obj25 & 8 != 0) {
            l4 = unspecified-0d7_KjU4;
        } else {
            l4 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.ButtonDefaults.buttonColors (Button.kt:582)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l2, obj6, l, obj8);
    }

    public final androidx.compose.material3.ButtonElevation buttonElevation-R_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i8) {
        FilledButtonTokens iNSTANCE;
        float f;
        float f5;
        float f3;
        float f4;
        float f2;
        float obj11;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1827791191;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(buttonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        if (i8 & 1 != 0) {
            f = obj11;
        } else {
            f = defaultElevation;
        }
        if (i8 & 2 != 0) {
            f5 = obj12;
        } else {
            f5 = pressedElevation;
        }
        if (i8 & 4 != 0) {
            f3 = obj13;
        } else {
            f3 = focusedElevation;
        }
        if (i8 & 8 != 0) {
            f4 = obj14;
        } else {
            f4 = hoveredElevation;
        }
        if (i8 & 16 != 0) {
            f2 = obj11;
        } else {
            f2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.buttonElevation (Button.kt:802)");
        } else {
            obj13 = $changed;
        }
        ButtonElevation buttonElevation = new ButtonElevation(f, f5, f3, f4, f2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    public final androidx.compose.material3.ButtonColors elevatedButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 2025043443;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(elevatedButtonColors)609@28364L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:609)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultElevatedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ButtonColors elevatedButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU4;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU2;
        int unspecified-0d7_KjU;
        boolean traceInProgress;
        String str;
        long l2;
        long l;
        long l4;
        long l3;
        int i;
        final Composer composer = obj23;
        int i2 = 1507908383;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(elevatedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)627@29223L11:Button.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l2 = unspecified-0d7_KjU4;
        } else {
            l2 = containerColor;
        }
        if (obj25 & 2 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l4 = unspecified-0d7_KjU2;
        } else {
            l4 = $composer;
        }
        if (obj25 & 8 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonColors (Button.kt:627)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultElevatedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l2, obj6, l, obj8);
    }

    public final androidx.compose.material3.ButtonElevation elevatedButtonElevation-R_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i8) {
        ElevatedButtonTokens iNSTANCE;
        float f5;
        float f2;
        float f3;
        float f;
        float f4;
        float obj11;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1065482445;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(elevatedButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        if (i8 & 1 != 0) {
            f5 = obj11;
        } else {
            f5 = defaultElevation;
        }
        if (i8 & 2 != 0) {
            f2 = obj12;
        } else {
            f2 = pressedElevation;
        }
        if (i8 & 4 != 0) {
            f3 = obj13;
        } else {
            f3 = focusedElevation;
        }
        if (i8 & 8 != 0) {
            f = obj14;
        } else {
            f = hoveredElevation;
        }
        if (i8 & 16 != 0) {
            f4 = obj11;
        } else {
            f4 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.elevatedButtonElevation (Button.kt:829)");
        } else {
            obj13 = $changed;
        }
        ButtonElevation buttonElevation = new ButtonElevation(f5, f2, f3, f, f4, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    public final androidx.compose.material3.ButtonColors filledTonalButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 824987837;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(filledTonalButtonColors)655@30593L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:655)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultFilledTonalButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ButtonColors filledTonalButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU4;
        int unspecified-0d7_KjU2;
        boolean traceInProgress;
        String str;
        long l2;
        long l4;
        long l;
        long l3;
        int i;
        final Composer composer = obj23;
        int i2 = 1670757653;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(filledTonalButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)674@31482L11:Button.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l2 = unspecified-0d7_KjU;
        } else {
            l2 = containerColor;
        }
        if (obj25 & 2 != 0) {
            l4 = unspecified-0d7_KjU3;
        } else {
            l4 = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l = unspecified-0d7_KjU4;
        } else {
            l = $composer;
        }
        if (obj25 & 8 != 0) {
            l3 = unspecified-0d7_KjU2;
        } else {
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonColors (Button.kt:674)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultFilledTonalButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l2, obj6, l4, obj8);
    }

    public final androidx.compose.material3.ButtonElevation filledTonalButtonElevation-R_JCAzs(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float disabledElevation, Composer $composer, int $changed, int i8) {
        FilledTonalButtonTokens iNSTANCE;
        float f;
        float f4;
        float f5;
        float f2;
        float f3;
        float obj11;
        float obj12;
        float obj13;
        float obj14;
        final int i = 5982871;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(filledTonalButtonElevation)P(0:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp):Button.kt#uh7d8r");
        if (i8 & 1 != 0) {
            f = obj11;
        } else {
            f = defaultElevation;
        }
        if (i8 & 2 != 0) {
            f4 = obj12;
        } else {
            f4 = pressedElevation;
        }
        if (i8 & 4 != 0) {
            f5 = obj13;
        } else {
            f5 = focusedElevation;
        }
        if (i8 & 8 != 0) {
            f2 = obj14;
        } else {
            f2 = hoveredElevation;
        }
        if (i8 & 16 != 0) {
            obj12 = 0;
            f3 = obj11;
        } else {
            f3 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.filledTonalButtonElevation (Button.kt:859)");
        } else {
            obj13 = $changed;
        }
        ButtonElevation buttonElevation = new ButtonElevation(f, f4, f5, f2, f3, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return buttonElevation;
    }

    public final PaddingValues getButtonWithIconContentPadding() {
        return ButtonDefaults.ButtonWithIconContentPadding;
    }

    public final PaddingValues getContentPadding() {
        return ButtonDefaults.ContentPadding;
    }

    public final androidx.compose.material3.ButtonColors getDefaultButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultButtonColors) {
        androidx.compose.material3.ButtonColors defaultButtonColorsCached$material3_release;
        androidx.compose.material3.ButtonColors buttonColors;
        int i6;
        long token;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i8;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i7;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultButtonColors;
        if (colorScheme.getDefaultButtonColorsCached$material3_release() == null) {
            i8 = 0;
            i2 = 0;
            buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getLabelTextColor()), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, 1039516303, i8, 0, i2, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledButtonTokens.INSTANCE.getDisabledLabelTextColor()), i8, 1052938076, i2, 0, 0, 14), i8, 0);
            i6 = 0;
            colorScheme.setDefaultButtonColorsCached$material3_release(buttonColors);
        }
        return defaultButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.ButtonColors getDefaultElevatedButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultElevatedButtonColors) {
        androidx.compose.material3.ButtonColors defaultElevatedButtonColorsCached$material3_release;
        androidx.compose.material3.ButtonColors buttonColors;
        int i7;
        long token;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i8;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultElevatedButtonColors;
        if (colorScheme.getDefaultElevatedButtonColorsCached$material3_release() == null) {
            i8 = 0;
            i2 = 0;
            buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getLabelTextColor()), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, ElevatedButtonTokens.INSTANCE.getDisabledContainerOpacity(), i8, 0, i2, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextColor()), i8, ElevatedButtonTokens.INSTANCE.getDisabledLabelTextOpacity(), i2, 0, 0, 14), i8, 0);
            i7 = 0;
            colorScheme.setDefaultElevatedButtonColorsCached$material3_release(buttonColors);
        }
        return defaultElevatedButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.ButtonColors getDefaultFilledTonalButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultFilledTonalButtonColors) {
        androidx.compose.material3.ButtonColors defaultFilledTonalButtonColorsCached$material3_release;
        androidx.compose.material3.ButtonColors buttonColors;
        int i;
        long token;
        long copy-wmQWz5c$default;
        long copy-wmQWz5c$default2;
        int i3;
        int i7;
        int i2;
        int i5;
        int i4;
        int i6;
        int i8;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultFilledTonalButtonColors;
        if (colorScheme.getDefaultFilledTonalButtonColorsCached$material3_release() == null) {
            i3 = 0;
            i2 = 0;
            buttonColors = new ButtonColors(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getLabelTextColor()), obj6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getDisabledContainerColor()), obj8, 1039516303, i3, 0, i2, 14), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledTonalButtonTokens.INSTANCE.getDisabledLabelTextColor()), i3, 1052938076, i2, 0, 0, 14), i3, 0);
            i = 0;
            colorScheme.setDefaultFilledTonalButtonColorsCached$material3_release(buttonColors);
        }
        return defaultFilledTonalButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.ButtonColors getDefaultOutlinedButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultOutlinedButtonColors) {
        androidx.compose.material3.ButtonColors defaultOutlinedButtonColorsCached$material3_release;
        androidx.compose.material3.ButtonColors buttonColors;
        int i5;
        long token;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default;
        int i2;
        int i;
        int i3;
        int i6;
        int i7;
        int i4;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultOutlinedButtonColors;
        if (colorScheme.getDefaultOutlinedButtonColorsCached$material3_release() == null) {
            buttonColors = new ButtonColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getLabelTextColor()), obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, OutlinedButtonTokens.INSTANCE.getDisabledLabelTextColor()), obj10, 1052938076, 0, 0, 0, 14), obj10, 0);
            i5 = 0;
            colorScheme.setDefaultOutlinedButtonColorsCached$material3_release(buttonColors);
        }
        return defaultOutlinedButtonColorsCached$material3_release;
    }

    public final androidx.compose.material3.ButtonColors getDefaultTextButtonColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultTextButtonColors) {
        androidx.compose.material3.ButtonColors defaultTextButtonColorsCached$material3_release;
        androidx.compose.material3.ButtonColors buttonColors;
        int i7;
        long token;
        long transparent-0d7_KjU;
        long copy-wmQWz5c$default;
        int i6;
        int i;
        int i4;
        int i2;
        int i3;
        int i5;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultTextButtonColors;
        if (colorScheme.getDefaultTextButtonColorsCached$material3_release() == null) {
            buttonColors = new ButtonColors(Color.Companion.getTransparent-0d7_KjU(), obj4, ColorSchemeKt.fromToken(colorScheme, TextButtonTokens.INSTANCE.getLabelTextColor()), obj6, Color.Companion.getTransparent-0d7_KjU(), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, TextButtonTokens.INSTANCE.getDisabledLabelTextColor()), obj10, 1052938076, 0, 0, 0, 14), obj10, 0);
            i7 = 0;
            colorScheme.setDefaultTextButtonColorsCached$material3_release(buttonColors);
        }
        return defaultTextButtonColorsCached$material3_release;
    }

    public final Shape getElevatedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 2143958791;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C546@25609L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-elevatedShape> (Button.kt:546)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(ElevatedButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getFilledTonalShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -886584987;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C550@25767L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-filledTonalShape> (Button.kt:550)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FilledTonalButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getIconSize-D9Ej5fM() {
        return ButtonDefaults.IconSize;
    }

    public final float getIconSpacing-D9Ej5fM() {
        return ButtonDefaults.IconSpacing;
    }

    public final float getMinHeight-D9Ej5fM() {
        return ButtonDefaults.MinHeight;
    }

    public final float getMinWidth-D9Ej5fM() {
        return ButtonDefaults.MinWidth;
    }

    @Deprecated(message = "Please use the version that takes an `enabled` param to get the `BorderStroke` with the correct opacity", replaceWith = @ReplaceWith(...))
    public final BorderStroke getOutlinedButtonBorder(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -563957672;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C879@41501L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedButtonBorder> (Button.kt:877)");
        }
        int i2 = 6;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(OutlinedButtonTokens.INSTANCE.getOutlineWidth-D9Ej5fM(), ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), $composer, i2));
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -2045213065;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C554@25916L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-outlinedShape> (Button.kt:554)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(OutlinedButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1234923021;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C542@25460L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-shape> (Button.kt:542)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FilledButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final PaddingValues getTextButtonContentPadding() {
        return ButtonDefaults.TextButtonContentPadding;
    }

    public final PaddingValues getTextButtonWithIconContentPadding() {
        return ButtonDefaults.TextButtonWithIconContentPadding;
    }

    public final Shape getTextShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -349121587;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C558@26052L5:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.<get-textShape> (Button.kt:558)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(TextButtonTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final BorderStroke outlinedButtonBorder(boolean enabled, Composer $composer, int $changed, int i4) {
        long copy-wmQWz5c$default;
        String str;
        androidx.compose.material3.tokens.ColorSchemeKeyTokens outlineColor;
        long value;
        int i2;
        int i;
        int i7;
        int i3;
        int i6;
        int i5;
        int obj11;
        boolean obj14;
        int i8 = -626854767;
        ComposerKt.sourceInformationMarkerStart($composer, i8, "C(outlinedButtonBorder):Button.kt#uh7d8r");
        if (i4 &= 1 != 0) {
            obj11 = 1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i8, $changed, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonBorder (Button.kt:889)");
        }
        int i9 = 6;
        if (obj11 != null) {
            $composer.startReplaceGroup(-855870548);
            ComposerKt.sourceInformation($composer, "893@41926L5");
            copy-wmQWz5c$default = ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), $composer, i9);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-855783004);
            ComposerKt.sourceInformation($composer, "895@42011L5");
            copy-wmQWz5c$default = Color.copy-wmQWz5c$default(ColorSchemeKt.getValue(OutlinedButtonTokens.INSTANCE.getOutlineColor(), $composer, i9), obj3, 1039516303, 0, 0, 0, 14);
            $composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return BorderStrokeKt.BorderStroke-cXLIe8U(OutlinedButtonTokens.INSTANCE.getOutlineWidth-D9Ej5fM(), copy-wmQWz5c$default);
    }

    public final androidx.compose.material3.ButtonColors outlinedButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1344886725;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(outlinedButtonColors)701@32872L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:701)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultOutlinedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ButtonColors outlinedButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU2;
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU4;
        int unspecified-0d7_KjU3;
        boolean traceInProgress;
        String str;
        long l2;
        long l4;
        long l;
        long l3;
        int i;
        final Composer composer = obj23;
        int i2 = -1778526249;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(outlinedButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)719@33731L11:Button.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = containerColor;
        }
        if (obj25 & 2 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l = unspecified-0d7_KjU4;
        } else {
            l = $composer;
        }
        if (obj25 & 8 != 0) {
            l3 = unspecified-0d7_KjU3;
        } else {
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.ButtonDefaults.outlinedButtonColors (Button.kt:719)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultOutlinedButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l2, obj6, l4, obj8);
    }

    public final androidx.compose.material3.ButtonColors textButtonColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1880341584;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(textButtonColors)744@34895L11:Button.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:744)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.ButtonColors textButtonColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU;
        long unspecified-0d7_KjU3;
        long unspecified-0d7_KjU2;
        int unspecified-0d7_KjU4;
        boolean traceInProgress;
        String str;
        long l4;
        long l;
        long l2;
        long l3;
        int i;
        final Composer composer = obj23;
        int i2 = -1402274782;
        ComposerKt.sourceInformationMarkerStart(composer, i2, "C(textButtonColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)762@35725L11:Button.kt#uh7d8r");
        if (obj25 & 1 != 0) {
            l4 = unspecified-0d7_KjU;
        } else {
            l4 = containerColor;
        }
        if (obj25 & 2 != 0) {
            l = unspecified-0d7_KjU3;
        } else {
            l = disabledContainerColor;
        }
        if (obj25 & 4 != 0) {
            l2 = unspecified-0d7_KjU2;
        } else {
            l2 = $composer;
        }
        if (obj25 & 8 != 0) {
            l3 = unspecified-0d7_KjU4;
        } else {
            l3 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, obj24, -1, "androidx.compose.material3.ButtonDefaults.textButtonColors (Button.kt:762)");
        } else {
            i = obj24;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return getDefaultTextButtonColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l4, obj6, l, obj8);
    }
}
