package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u001a\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a\u0088\u0001\u0010\r\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001b\u001a\u0088\u0001\u0010\u001c\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001b\u001a\u001c\u0010\t\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020!*\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0000\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Colors;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "primarySurface", "Landroidx/compose/ui/graphics/Color;", "getPrimarySurface", "(Landroidx/compose/material/Colors;)J", "contentColorFor", "backgroundColor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "darkColors", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "darkColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "lightColors-2qZNXz8", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "updateColorsFrom", "", "other", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ColorsKt {

    private static final ProvidableCompositionLocal<androidx.compose.material.Colors> LocalColors;
    static {
        ColorsKt.LocalColors = CompositionLocalKt.staticCompositionLocalOf((Function0)ColorsKt.LocalColors.1.INSTANCE);
    }

    public static final long contentColorFor-4WTKRHQ(androidx.compose.material.Colors $this$contentColorFor_u2d4WTKRHQ, long backgroundColor) {
        long onBackground-0d7_KjU;
        if (Color.equals-impl0(backgroundColor, obj4)) {
            onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnPrimary-0d7_KjU();
        } else {
            if (Color.equals-impl0(backgroundColor, obj4)) {
                onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnPrimary-0d7_KjU();
            } else {
                if (Color.equals-impl0(backgroundColor, obj4)) {
                    onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSecondary-0d7_KjU();
                } else {
                    if (Color.equals-impl0(backgroundColor, obj4)) {
                        onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSecondary-0d7_KjU();
                    } else {
                        if (Color.equals-impl0(backgroundColor, obj4)) {
                            onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnBackground-0d7_KjU();
                        } else {
                            if (Color.equals-impl0(backgroundColor, obj4)) {
                                onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnSurface-0d7_KjU();
                            } else {
                                if (Color.equals-impl0(backgroundColor, obj4)) {
                                    onBackground-0d7_KjU = $this$contentColorFor_u2d4WTKRHQ.getOnError-0d7_KjU();
                                } else {
                                    onBackground-0d7_KjU = Color.Companion.getUnspecified-0d7_KjU();
                                }
                            }
                        }
                    }
                }
            }
        }
        return onBackground-0d7_KjU;
    }

    public static final long contentColorFor-ek8zF_U(long backgroundColor, Composer $composer, int $changed) {
        long $this$takeOrElse_u2dDxMtmZc$iv;
        boolean traceInProgress;
        String str;
        long $i$a$TakeOrElseDxMtmZcColorsKt$contentColorFor$1;
        ProvidableCompositionLocal localContentColor;
        int i;
        int i2;
        Object consume;
        String str2;
        int i3 = 441849991;
        ComposerKt.sourceInformationMarkerStart($changed, i3, "C(contentColorFor)P(0:c#ui.graphics.Color):Colors.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, obj12, -1, "androidx.compose.material.contentColorFor (Colors.kt:296)");
        }
        $changed.startReplaceGroup(-702395103);
        ComposerKt.sourceInformation($changed, "*296@11462L6,296@11533L7");
        int i6 = 0;
        i = 0;
        i2 = Long.compare($i$a$TakeOrElseDxMtmZcColorsKt$contentColorFor$1, i8) != 0 ? 1 : 0;
        if (i2 != 0) {
        } else {
            int i7 = 0;
            i = 6;
            i2 = 0;
            ComposerKt.sourceInformationMarkerStart($changed, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd($changed);
            $this$takeOrElse_u2dDxMtmZc$iv = $i$a$TakeOrElseDxMtmZcColorsKt$contentColorFor$1;
        }
        $changed.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($changed);
        return $this$takeOrElse_u2dDxMtmZc$iv;
    }

    public static final androidx.compose.material.Colors darkColors-2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        Colors colors = new Colors(primary, obj2, secondary, obj4, background, obj6, error, obj8, onSecondary, obj10, onSurface, obj12, obj39, obj14, obj41, obj16, obj43, obj18, obj45, obj20, obj47, obj22, obj49, obj24, 0, 0);
        return colors;
    }

    public static androidx.compose.material.Colors darkColors-2qZNXz8$default(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, int i13, Object object14) {
        Color.Companion companion;
        long l14;
        long l15;
        long l18;
        long l16;
        long l13;
        Color.Companion companion5;
        Color.Companion companion4;
        Color.Companion companion2;
        Color.Companion companion3;
        long l19;
        long l17;
        long black-0d7_KjU2;
        long black-0d7_KjU3;
        long white-0d7_KjU;
        long white-0d7_KjU2;
        long black-0d7_KjU;
        int i = obj50;
        if (i & 1 != 0) {
            l14 = ColorKt.Color(4290479868L);
        } else {
            l14 = l;
        }
        if (i & 2 != 0) {
            l15 = ColorKt.Color(4281794739L);
        } else {
            l15 = l3;
        }
        if (i & 4 != 0) {
            l18 = ColorKt.Color(4278442694L);
        } else {
            l18 = l5;
        }
        l16 = i & 8 != 0 ? l18 : l7;
        final long l23 = 4279374354L;
        if (i & 16 != 0) {
            l19 = ColorKt.Color(l23);
        } else {
            l19 = l9;
        }
        if (i & 32 != 0) {
            l13 = ColorKt.Color(l23);
        } else {
            l13 = l11;
        }
        if (i & 64 != 0) {
            l17 = ColorKt.Color(4291782265L);
        } else {
            l17 = i13;
        }
        if (i & 128 != 0) {
            black-0d7_KjU2 = Color.Companion.getBlack-0d7_KjU();
        } else {
            black-0d7_KjU2 = obj40;
        }
        if (i & 256 != 0) {
            black-0d7_KjU3 = Color.Companion.getBlack-0d7_KjU();
        } else {
            black-0d7_KjU3 = obj42;
        }
        if (i & 512 != 0) {
            white-0d7_KjU = Color.Companion.getWhite-0d7_KjU();
        } else {
            white-0d7_KjU = obj44;
        }
        if (i & 1024 != 0) {
            white-0d7_KjU2 = Color.Companion.getWhite-0d7_KjU();
        } else {
            white-0d7_KjU2 = obj46;
        }
        if (i &= 2048 != 0) {
            black-0d7_KjU = Color.Companion.getBlack-0d7_KjU();
        } else {
            black-0d7_KjU = obj48;
        }
        return ColorsKt.darkColors-2qZNXz8(l14, l2, l15, l4, l18, l6, l16, l8, l19, l10, l13, l12);
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.Colors> getLocalColors() {
        return ColorsKt.LocalColors;
    }

    public static final long getPrimarySurface(androidx.compose.material.Colors $this$primarySurface) {
        long primary-0d7_KjU;
        if ($this$primarySurface.isLight()) {
            primary-0d7_KjU = $this$primarySurface.getPrimary-0d7_KjU();
        } else {
            primary-0d7_KjU = $this$primarySurface.getSurface-0d7_KjU();
        }
        return primary-0d7_KjU;
    }

    public static final androidx.compose.material.Colors lightColors-2qZNXz8(long primary, long primaryVariant, long secondary, long secondaryVariant, long background, long surface, long error, long onPrimary, long onSecondary, long onBackground, long onSurface, long onError) {
        Colors colors = new Colors(primary, obj2, secondary, obj4, background, obj6, error, obj8, onSecondary, obj10, onSurface, obj12, obj39, obj14, obj41, obj16, obj43, obj18, obj45, obj20, obj47, obj22, obj49, obj24, 1, 0);
        return colors;
    }

    public static androidx.compose.material.Colors lightColors-2qZNXz8$default(long l, long l2, long l3, long l4, long l5, long l6, long l7, long l8, long l9, long l10, long l11, long l12, int i13, Object object14) {
        Color.Companion companion;
        long l16;
        long black-0d7_KjU3;
        long black-0d7_KjU;
        long black-0d7_KjU2;
        long l17;
        long l15;
        long l14;
        long white-0d7_KjU2;
        long white-0d7_KjU3;
        long l13;
        long white-0d7_KjU;
        long white-0d7_KjU4;
        int i = obj43;
        if (i & 1 != 0) {
            l16 = ColorKt.Color(4284612846L);
        } else {
            l16 = l;
        }
        if (i & 2 != 0) {
            l17 = ColorKt.Color(4281794739L);
        } else {
            l17 = l3;
        }
        if (i & 4 != 0) {
            l15 = ColorKt.Color(4278442694L);
        } else {
            l15 = l5;
        }
        if (i & 8 != 0) {
            l14 = ColorKt.Color(4278290310L);
        } else {
            l14 = l7;
        }
        if (i & 16 != 0) {
            white-0d7_KjU2 = Color.Companion.getWhite-0d7_KjU();
        } else {
            white-0d7_KjU2 = l9;
        }
        if (i & 32 != 0) {
            white-0d7_KjU3 = Color.Companion.getWhite-0d7_KjU();
        } else {
            white-0d7_KjU3 = l11;
        }
        if (i & 64 != 0) {
            l13 = ColorKt.Color(4289724448L);
        } else {
            l13 = i13;
        }
        if (i & 128 != 0) {
            white-0d7_KjU = Color.Companion.getWhite-0d7_KjU();
        } else {
            white-0d7_KjU = obj33;
        }
        if (i & 256 != 0) {
            black-0d7_KjU3 = Color.Companion.getBlack-0d7_KjU();
        } else {
            black-0d7_KjU3 = obj35;
        }
        if (i & 512 != 0) {
            black-0d7_KjU = Color.Companion.getBlack-0d7_KjU();
        } else {
            black-0d7_KjU = obj37;
        }
        if (i & 1024 != 0) {
            black-0d7_KjU2 = Color.Companion.getBlack-0d7_KjU();
        } else {
            black-0d7_KjU2 = obj39;
        }
        if (i &= 2048 != 0) {
            white-0d7_KjU4 = Color.Companion.getWhite-0d7_KjU();
        } else {
            white-0d7_KjU4 = obj41;
        }
        return ColorsKt.lightColors-2qZNXz8(l16, l2, l17, l4, l15, l6, l14, l8, white-0d7_KjU2, l10, white-0d7_KjU3, l12);
    }

    public static final void updateColorsFrom(androidx.compose.material.Colors $this$updateColorsFrom, androidx.compose.material.Colors other) {
        $this$updateColorsFrom.setPrimary-8_81llA$material_release(other.getPrimary-0d7_KjU());
        $this$updateColorsFrom.setPrimaryVariant-8_81llA$material_release(other.getPrimaryVariant-0d7_KjU());
        $this$updateColorsFrom.setSecondary-8_81llA$material_release(other.getSecondary-0d7_KjU());
        $this$updateColorsFrom.setSecondaryVariant-8_81llA$material_release(other.getSecondaryVariant-0d7_KjU());
        $this$updateColorsFrom.setBackground-8_81llA$material_release(other.getBackground-0d7_KjU());
        $this$updateColorsFrom.setSurface-8_81llA$material_release(other.getSurface-0d7_KjU());
        $this$updateColorsFrom.setError-8_81llA$material_release(other.getError-0d7_KjU());
        $this$updateColorsFrom.setOnPrimary-8_81llA$material_release(other.getOnPrimary-0d7_KjU());
        $this$updateColorsFrom.setOnSecondary-8_81llA$material_release(other.getOnSecondary-0d7_KjU());
        $this$updateColorsFrom.setOnBackground-8_81llA$material_release(other.getOnBackground-0d7_KjU());
        $this$updateColorsFrom.setOnSurface-8_81llA$material_release(other.getOnSurface-0d7_KjU());
        $this$updateColorsFrom.setOnError-8_81llA$material_release(other.getOnError-0d7_KjU());
        $this$updateColorsFrom.setLight$material_release(other.isLight());
    }
}
