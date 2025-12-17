package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001a\u0087\u0001\u0010\u0000\u001a\u00020\u00012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016\u001ac\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000b2\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0008\u0014H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Card", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "border", "Landroidx/compose/foundation/BorderStroke;", "elevation", "Landroidx/compose/ui/unit/Dp;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "content", "Landroidx/compose/runtime/Composable;", "Card-LPr_se0", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Card-F-jzlyU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;JJLandroidx/compose/foundation/BorderStroke;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CardKt {
    public static final void Card-F-jzlyU(Modifier modifier, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int companion;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        long backgroundColor2;
        long contentColor2;
        int i;
        float $i$f$getDp;
        float str;
        androidx.compose.ui.Modifier.Companion obj13;
        androidx.compose.foundation.shape.CornerBasedShape obj14;
        final Composer composer2 = i10;
        final int i18 = obj23;
        int i2 = 1956755640;
        ComposerKt.sourceInformationMarkerStart(composer2, i2, "C(Card)P(5,6,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp)56@2436L6,57@2494L6,58@2536L32,63@2674L218:Card.kt#jmzs0o");
        if (obj24 & 1 != 0) {
            obj13 = companion;
        }
        int i14 = 6;
        if (obj24 & 2 != 0) {
            cornerBasedShape = obj14;
        } else {
            cornerBasedShape = shape;
        }
        if (obj24 & 4 != 0) {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors(composer2, i14).getSurface-0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (obj24 & 8 != 0) {
            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor2, obj3, composer2);
        } else {
            contentColor2 = border;
        }
        i = obj24 & 16 != 0 ? obj14 : content;
        if (obj24 & 32 != 0) {
            int i15 = 0;
            $i$f$getDp = obj14;
        } else {
            $i$f$getDp = $composer;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, i18, -1, "androidx.compose.material.Card (Card.kt:62)");
        }
        SurfaceKt.Surface-F-jzlyU(obj13, cornerBasedShape, backgroundColor2, obj3, contentColor2, obj5, i, $i$f$getDp, $changed, composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(i10);
    }

    public static final void Card-LPr_se0(Function0<Unit> onClick, Modifier modifier, boolean enabled, Shape shape, long backgroundColor, long contentColor, BorderStroke border, float elevation, MutableInteractionSource interactionSource, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i13) {
        int interactionSource2;
        androidx.compose.ui.Modifier.Companion modifier2;
        int enabled2;
        androidx.compose.foundation.shape.CornerBasedShape shape2;
        long backgroundColor2;
        int iNSTANCE;
        long contentColor2;
        int border2;
        float elevation2;
        int i;
        boolean traceInProgress;
        float str;
        final Composer composer2 = i13;
        final int i43 = obj29;
        int i2 = obj30;
        int i4 = 778538979;
        ComposerKt.sourceInformationMarkerStart(composer2, i4, "C(Card)P(8,7,5,9,0:c#ui.graphics.Color,3:c#ui.graphics.Color!1,4:c#ui.unit.Dp,6)107@4567L6,108@4625L6,109@4667L32,115@4862L319:Card.kt#jmzs0o");
        if (i2 & 2 != 0) {
            modifier2 = Modifier.Companion;
        } else {
            modifier2 = modifier;
        }
        enabled2 = i2 & 4 != 0 ? 1 : enabled;
        int i18 = 6;
        if (i2 & 8 != 0) {
            shape2 = MaterialTheme.INSTANCE.getShapes(composer2, i18).getMedium();
        } else {
            shape2 = shape;
        }
        if (i2 & 16 != 0) {
            backgroundColor2 = MaterialTheme.INSTANCE.getColors(composer2, i18).getSurface-0d7_KjU();
        } else {
            backgroundColor2 = backgroundColor;
        }
        if (i2 & 32 != 0) {
            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor2, iNSTANCE, composer2);
        } else {
            contentColor2 = border;
        }
        border2 = i2 & 64 != 0 ? 0 : interactionSource;
        if (i2 & 128 != 0) {
            i = 0;
            elevation2 = Dp.constructor-impl((float)i25);
        } else {
            elevation2 = content;
        }
        interactionSource2 = i2 &= 256 != 0 ? 0 : $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, i43, -1, "androidx.compose.material.Card (Card.kt:114)");
        }
        SurfaceKt.Surface-LPr_se0(onClick, modifier2, enabled2, shape2, backgroundColor2, backgroundColor2, contentColor2, contentColor2, border2, elevation2, interactionSource2, $changed, composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(i13);
    }
}
