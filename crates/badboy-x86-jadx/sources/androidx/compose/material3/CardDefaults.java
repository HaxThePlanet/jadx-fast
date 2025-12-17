package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.material3.tokens.ElevatedCardTokens;
import androidx.compose.material3.tokens.FilledCardTokens;
import androidx.compose.material3.tokens.OutlinedCardTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0014\u001a\u00020\u000cH\u0007¢\u0006\u0002\u0010\u0015J:\u0010\u0014\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJN\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020 2\u0008\u0008\u0002\u0010\"\u001a\u00020 2\u0008\u0008\u0002\u0010#\u001a\u00020 2\u0008\u0008\u0002\u0010$\u001a\u00020 2\u0008\u0008\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'J\r\u0010(\u001a\u00020\u000cH\u0007¢\u0006\u0002\u0010\u0015J:\u0010(\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u0008)\u0010\u001cJN\u0010*\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020 2\u0008\u0008\u0002\u0010\"\u001a\u00020 2\u0008\u0008\u0002\u0010#\u001a\u00020 2\u0008\u0008\u0002\u0010$\u001a\u00020 2\u0008\u0008\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\u0008+\u0010'J\u0017\u0010,\u001a\u00020-2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000cH\u0007¢\u0006\u0002\u0010\u0015J:\u00101\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\u00082\u0010\u001cJN\u00103\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020 2\u0008\u0008\u0002\u0010\"\u001a\u00020 2\u0008\u0008\u0002\u0010#\u001a\u00020 2\u0008\u0008\u0002\u0010$\u001a\u00020 2\u0008\u0008\u0002\u0010%\u001a\u00020 H\u0007ø\u0001\u0000¢\u0006\u0004\u00084\u0010'R\u0011\u0010\u0003\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006R\u0018\u0010\u000b\u001a\u00020\u000c*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0018\u0010\u0010\u001a\u00020\u000c*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0018\u0010\u0012\u001a\u00020\u000c*\u00020\r8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000f\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00065", d2 = {"Landroidx/compose/material3/CardDefaults;", "", "()V", "elevatedShape", "Landroidx/compose/ui/graphics/Shape;", "getElevatedShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "outlinedShape", "getOutlinedShape", "shape", "getShape", "defaultCardColors", "Landroidx/compose/material3/CardColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultCardColors$material3_release", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/CardColors;", "defaultElevatedCardColors", "getDefaultElevatedCardColors$material3_release", "defaultOutlinedCardColors", "getDefaultOutlinedCardColors$material3_release", "cardColors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/CardColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "disabledContainerColor", "disabledContentColor", "cardColors-ro_MJ88", "(JJJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardColors;", "cardElevation", "Landroidx/compose/material3/CardElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "focusedElevation", "hoveredElevation", "draggedElevation", "disabledElevation", "cardElevation-aqJV_2Y", "(FFFFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/CardElevation;", "elevatedCardColors", "elevatedCardColors-ro_MJ88", "elevatedCardElevation", "elevatedCardElevation-aqJV_2Y", "outlinedCardBorder", "Landroidx/compose/foundation/BorderStroke;", "enabled", "", "(ZLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/BorderStroke;", "outlinedCardColors", "outlinedCardColors-ro_MJ88", "outlinedCardElevation", "outlinedCardElevation-aqJV_2Y", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CardDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.CardDefaults INSTANCE;
    static {
        CardDefaults cardDefaults = new CardDefaults();
        CardDefaults.INSTANCE = cardDefaults;
    }

    public final androidx.compose.material3.CardColors cardColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1876034303;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(cardColors)476@21292L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:476)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.CardColors cardColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU;
        long contentColorFor-ek8zF_U;
        long disabledContainerColor2;
        boolean traceInProgress;
        long l3;
        long l;
        long copy-wmQWz5c$default;
        int i;
        long l2;
        int i4;
        int i2;
        int i3;
        final Composer composer = obj25;
        final int i5 = obj26;
        int i6 = -1589582123;
        ComposerKt.sourceInformationMarkerStart(composer, i6, "C(cardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)490@21903L31,494@22109L11:Card.kt#uh7d8r");
        if (obj27 & 1 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = containerColor;
        }
        if (obj27 & 2 != 0) {
            l = contentColorFor-ek8zF_U;
        } else {
            l = disabledContainerColor;
        }
        if (obj27 & 4 != 0) {
            disabledContainerColor2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            disabledContainerColor2 = $composer;
        }
        if (obj27 & 8 != 0) {
            l2 = copy-wmQWz5c$default;
        } else {
            l2 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, i5, -1, "androidx.compose.material3.CardDefaults.cardColors (Card.kt:494)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l3, obj7, l, obj9);
    }

    public final androidx.compose.material3.CardElevation cardElevation-aqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        FilledCardTokens iNSTANCE;
        float f5;
        float f6;
        float f4;
        float f;
        float f2;
        float f3;
        float obj12;
        float obj13;
        float obj14;
        final int i = -574898487;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(cardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f5 = obj12;
        } else {
            f5 = defaultElevation;
        }
        if (i9 & 2 != 0) {
            f6 = obj13;
        } else {
            f6 = pressedElevation;
        }
        if (i9 & 4 != 0) {
            f4 = obj14;
        } else {
            f4 = focusedElevation;
        }
        if (i9 & 8 != 0) {
            f = obj12;
        } else {
            f = hoveredElevation;
        }
        if (i9 & 16 != 0) {
            f2 = obj12;
        } else {
            f2 = draggedElevation;
        }
        if (i9 & 32 != 0) {
            f3 = obj12;
        } else {
            f3 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.cardElevation (Card.kt:405)");
        } else {
            obj14 = $changed;
        }
        CardElevation cardElevation = new CardElevation(f5, f6, f4, f, f2, f3, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardElevation;
    }

    public final androidx.compose.material3.CardColors elevatedCardColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1610137975;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(elevatedCardColors)522@23477L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:522)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.CardColors elevatedCardColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU;
        long contentColorFor-ek8zF_U;
        long disabledContainerColor2;
        boolean traceInProgress;
        long l3;
        long l2;
        long copy-wmQWz5c$default;
        int i3;
        long l;
        int i4;
        int i;
        int i2;
        final Composer composer = obj25;
        final int i5 = obj26;
        int i6 = 139558303;
        ComposerKt.sourceInformationMarkerStart(composer, i6, "C(elevatedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)536@24145L31,540@24351L11:Card.kt#uh7d8r");
        if (obj27 & 1 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = containerColor;
        }
        if (obj27 & 2 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = disabledContainerColor;
        }
        if (obj27 & 4 != 0) {
            disabledContainerColor2 = Color.Companion.getUnspecified-0d7_KjU();
        } else {
            disabledContainerColor2 = $composer;
        }
        if (obj27 & 8 != 0) {
            l = copy-wmQWz5c$default;
        } else {
            l = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, i5, -1, "androidx.compose.material3.CardDefaults.elevatedCardColors (Card.kt:540)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultElevatedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l3, obj7, l2, obj9);
    }

    public final androidx.compose.material3.CardElevation elevatedCardElevation-aqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        ElevatedCardTokens iNSTANCE;
        float f4;
        float f5;
        float f3;
        float f;
        float f6;
        float f2;
        float obj12;
        float obj13;
        float obj14;
        final int i = 1154241939;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(elevatedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f4 = obj12;
        } else {
            f4 = defaultElevation;
        }
        if (i9 & 2 != 0) {
            f5 = obj13;
        } else {
            f5 = pressedElevation;
        }
        if (i9 & 4 != 0) {
            f3 = obj14;
        } else {
            f3 = focusedElevation;
        }
        if (i9 & 8 != 0) {
            f = obj12;
        } else {
            f = hoveredElevation;
        }
        if (i9 & 16 != 0) {
            f6 = obj12;
        } else {
            f6 = draggedElevation;
        }
        if (i9 & 32 != 0) {
            f2 = obj12;
        } else {
            f2 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.elevatedCardElevation (Card.kt:434)");
        } else {
            obj14 = $changed;
        }
        CardElevation cardElevation = new CardElevation(f4, f5, f3, f, f6, f2, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardElevation;
    }

    public final androidx.compose.material3.CardColors getDefaultCardColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultCardColors) {
        androidx.compose.material3.CardColors defaultCardColorsCached$material3_release;
        androidx.compose.material3.CardColors cardColors;
        int i6;
        long contentColorFor-4WTKRHQ;
        long compositeOver--OWjLjI;
        long copy-wmQWz5c$default;
        int i2;
        int i7;
        int i8;
        int i5;
        int i10;
        int i3;
        int i;
        int i4;
        int i9;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultCardColors;
        if (colorScheme.getDefaultCardColorsCached$material3_release() == null) {
            i2 = 0;
            i8 = 0;
            cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), obj6, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getDisabledContainerColor()), obj8, FilledCardTokens.INSTANCE.getDisabledContainerOpacity(), i2, 0, i8, 14), obj8), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, FilledCardTokens.INSTANCE.getContainerColor())), i8, 1052938076, 0, 0, 0, 14), i2, 0);
            i6 = 0;
            colorScheme.setDefaultCardColorsCached$material3_release(cardColors);
        }
        return defaultCardColorsCached$material3_release;
    }

    public final androidx.compose.material3.CardColors getDefaultElevatedCardColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultElevatedCardColors) {
        androidx.compose.material3.CardColors defaultElevatedCardColorsCached$material3_release;
        androidx.compose.material3.CardColors cardColors;
        int i2;
        long contentColorFor-4WTKRHQ;
        long compositeOver--OWjLjI;
        long copy-wmQWz5c$default;
        int i10;
        int i4;
        int i9;
        int i7;
        int i3;
        int i8;
        int i5;
        int i;
        int i6;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultElevatedCardColors;
        if (colorScheme.getDefaultElevatedCardColorsCached$material3_release() == null) {
            i10 = 0;
            i9 = 0;
            cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor())), obj6, ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getDisabledContainerColor()), obj8, ElevatedCardTokens.INSTANCE.getDisabledContainerOpacity(), i10, 0, i9, 14), obj8), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, ElevatedCardTokens.INSTANCE.getContainerColor())), i9, 1052938076, 0, 0, 0, 14), i10, 0);
            i2 = 0;
            colorScheme.setDefaultElevatedCardColorsCached$material3_release(cardColors);
        }
        return defaultElevatedCardColorsCached$material3_release;
    }

    public final androidx.compose.material3.CardColors getDefaultOutlinedCardColors$material3_release(androidx.compose.material3.ColorScheme $this$defaultOutlinedCardColors) {
        androidx.compose.material3.CardColors defaultOutlinedCardColorsCached$material3_release;
        androidx.compose.material3.CardColors cardColors;
        int i5;
        long contentColorFor-4WTKRHQ;
        long token;
        long copy-wmQWz5c$default;
        int i4;
        int i;
        int i6;
        int i3;
        int i7;
        int i8;
        int i2;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultOutlinedCardColors;
        if (colorScheme.getDefaultOutlinedCardColorsCached$material3_release() == null) {
            cardColors = new CardColors(ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor()), obj4, ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor())), obj6, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor()), obj8, Color.copy-wmQWz5c$default(ColorSchemeKt.contentColorFor-4WTKRHQ(colorScheme, ColorSchemeKt.fromToken(colorScheme, OutlinedCardTokens.INSTANCE.getContainerColor())), obj12, 1052938076, 0, 0, 0, 14), obj10, 0);
            i5 = 0;
            colorScheme.setDefaultOutlinedCardColorsCached$material3_release(cardColors);
        }
        return defaultOutlinedCardColorsCached$material3_release;
    }

    public final Shape getElevatedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -133496185;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C380@16675L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.<get-elevatedShape> (Card.kt:380)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(ElevatedCardTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getOutlinedShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1095404023;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C384@16820L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.<get-outlinedShape> (Card.kt:384)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(OutlinedCardTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1266660211;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C376@16530L5:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.<get-shape> (Card.kt:376)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FilledCardTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final BorderStroke outlinedCardBorder(boolean enabled, Composer $composer, int $changed, int i4) {
        long compositeOver--OWjLjI;
        String value2;
        long value;
        int i2;
        int i5;
        int i3;
        int empty;
        Object borderStroke;
        int outlineWidth-D9Ej5fM;
        int i;
        int obj10;
        boolean obj13;
        int i6 = -392936593;
        ComposerKt.sourceInformationMarkerStart($composer, i6, "C(outlinedCardBorder)626@28402L72:Card.kt#uh7d8r");
        if (i4 &= 1 != 0) {
            obj10 = 1;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, $changed, -1, "androidx.compose.material3.CardDefaults.outlinedCardBorder (Card.kt:617)");
        }
        obj13 = 6;
        if (obj10 != null) {
            $composer.startReplaceGroup(-134409770);
            ComposerKt.sourceInformation($composer, "620@28131L5");
            compositeOver--OWjLjI = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getOutlineColor(), $composer, obj13);
            $composer.endReplaceGroup();
        } else {
            $composer.startReplaceGroup(-134330379);
            ComposerKt.sourceInformation($composer, "622@28214L5,624@28366L5");
            value2 = ColorSchemeKt.getValue(OutlinedCardTokens.INSTANCE.getDisabledOutlineColor(), $composer, obj13);
            i2 = 1039516303;
            compositeOver--OWjLjI = ColorKt.compositeOver--OWjLjI(Color.copy-wmQWz5c$default(value2, obj2, i2, 0, 0, 0, 14), value2);
            $composer.endReplaceGroup();
        }
        ComposerKt.sourceInformationMarkerStart($composer, -974156849, "CC(remember):Card.kt#9igjgp");
        Composer composer = $composer;
        int i9 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i10 = 0;
        if (!$composer.changed(compositeOver--OWjLjI)) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                int i11 = 0;
                composer.updateRememberedValue(BorderStrokeKt.BorderStroke-cXLIe8U(OutlinedCardTokens.INSTANCE.getOutlineWidth-D9Ej5fM(), compositeOver--OWjLjI));
            } else {
                borderStroke = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (BorderStroke)borderStroke;
    }

    public final androidx.compose.material3.CardColors outlinedCardColors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1204388929;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(outlinedCardColors)571@25869L11:Card.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:571)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme($composer, 6));
    }

    public final androidx.compose.material3.CardColors outlinedCardColors-ro_MJ88(long containerColor, long contentColor, long disabledContainerColor, long disabledContentColor, Composer $composer, int $changed, int i7) {
        long unspecified-0d7_KjU2;
        long contentColorFor-ek8zF_U;
        long unspecified-0d7_KjU;
        int copy-wmQWz5c$default;
        boolean traceInProgress;
        String str;
        long l;
        long l2;
        long l3;
        long l4;
        int i4;
        int i3;
        int i5;
        int i;
        int i2;
        int i6;
        final Composer composer = obj29;
        final int i8 = obj30;
        int i9 = -1112362409;
        ComposerKt.sourceInformationMarkerStart(composer, i9, "C(outlinedCardColors)P(0:c#ui.graphics.Color,1:c#ui.graphics.Color,2:c#ui.graphics.Color,3:c#ui.graphics.Color)585@26537L31,587@26667L31,589@26762L11:Card.kt#uh7d8r");
        if (obj31 & 1 != 0) {
            l = unspecified-0d7_KjU2;
        } else {
            l = containerColor;
        }
        if (obj31 & 2 != 0) {
            l2 = contentColorFor-ek8zF_U;
        } else {
            l2 = disabledContainerColor;
        }
        if (obj31 & 4 != 0) {
            l3 = unspecified-0d7_KjU;
        } else {
            l3 = $composer;
        }
        if (obj31 & 8 != 0) {
            l4 = copy-wmQWz5c$default;
        } else {
            l4 = i7;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i9, i8, -1, "androidx.compose.material3.CardDefaults.outlinedCardColors (Card.kt:589)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultOutlinedCardColors$material3_release(MaterialTheme.INSTANCE.getColorScheme(composer, 6)).copy-jRlVdoo(l, obj7, l2, obj9);
    }

    public final androidx.compose.material3.CardElevation outlinedCardElevation-aqJV_2Y(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, float draggedElevation, float disabledElevation, Composer $composer, int $changed, int i9) {
        OutlinedCardTokens iNSTANCE;
        float f4;
        float f6;
        float f;
        float f2;
        float f3;
        float f5;
        float obj12;
        float obj13;
        float obj14;
        final int i = -97678773;
        final Composer composer = $composer;
        ComposerKt.sourceInformationMarkerStart(composer, i, "C(outlinedCardElevation)P(0:c#ui.unit.Dp,5:c#ui.unit.Dp,3:c#ui.unit.Dp,4:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp):Card.kt#uh7d8r");
        if (i9 & 1 != 0) {
            f4 = obj12;
        } else {
            f4 = defaultElevation;
        }
        f6 = i9 & 2 != 0 ? obj13 : pressedElevation;
        f = i9 & 4 != 0 ? obj14 : focusedElevation;
        f2 = i9 & 8 != 0 ? obj12 : hoveredElevation;
        if (i9 & 16 != 0) {
            f3 = obj12;
        } else {
            f3 = draggedElevation;
        }
        if (i9 & 32 != 0) {
            f5 = obj12;
        } else {
            f5 = disabledElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.CardDefaults.outlinedCardElevation (Card.kt:463)");
        } else {
            obj14 = $changed;
        }
        CardElevation cardElevation = new CardElevation(f4, f6, f, f2, f3, f5, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return cardElevation;
    }
}
