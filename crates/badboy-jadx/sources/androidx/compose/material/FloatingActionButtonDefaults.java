package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\tJ:\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\n\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", "", "()V", "elevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "defaultElevation", "Landroidx/compose/ui/unit/Dp;", "pressedElevation", "elevation-ixp7dh8", "(FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "hoveredElevation", "focusedElevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FloatingActionButtonDefaults {

    public static final int $stable;
    public static final androidx.compose.material.FloatingActionButtonDefaults INSTANCE;
    static {
        FloatingActionButtonDefaults floatingActionButtonDefaults = new FloatingActionButtonDefaults();
        FloatingActionButtonDefaults.INSTANCE = floatingActionButtonDefaults;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use another overload of elevation")
    public final androidx.compose.material.FloatingActionButtonElevation elevation-ixp7dh8(float defaultElevation, float pressedElevation, Composer $composer, int $changed, int i5) {
        int i;
        float $i$f$getDp;
        float f2;
        float f;
        float obj10;
        float obj11;
        int obj14;
        final int i2 = -654132828;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(elevation)P(0:c#ui.unit.Dp,1:c#ui.unit.Dp)222@9683L134:FloatingActionButton.kt#jmzs0o");
        if (i5 & 1 != 0) {
            int i3 = 0;
            $i$f$getDp = obj10;
        } else {
            $i$f$getDp = defaultElevation;
        }
        if (i5 & 2 != 0) {
            obj14 = 0;
            f = obj11;
        } else {
            f = pressedElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:222)");
        }
        obj11 = 0;
        obj11 = 0;
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.elevation-xZ9-QkE($i$f$getDp, f, Dp.constructor-impl((float)obj10), Dp.constructor-impl((float)obj10), composer, obj10 | obj11, 0);
    }

    public final androidx.compose.material.FloatingActionButtonElevation elevation-xZ9-QkE(float defaultElevation, float pressedElevation, float hoveredElevation, float focusedElevation, Composer $composer, int $changed, int i7) {
        int empty;
        int i;
        Object defaultFloatingActionButtonElevation;
        float $i$f$getDp;
        float f2;
        float f4;
        float f3;
        float f;
        int i2;
        float obj8;
        float obj9;
        float obj10;
        float obj11;
        empty = 380403812;
        ComposerKt.sourceInformationMarkerStart($composer, empty, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,2:c#ui.unit.Dp,1:c#ui.unit.Dp)249@10645L367:FloatingActionButton.kt#jmzs0o");
        if (i7 & 1 != 0) {
            int i3 = 0;
            $i$f$getDp = obj8;
        } else {
            $i$f$getDp = defaultElevation;
        }
        if (i7 & 2 != 0) {
            i = 0;
            f4 = obj9;
        } else {
            f4 = pressedElevation;
        }
        if (i7 & 4 != 0) {
            obj9 = 0;
            f3 = obj10;
        } else {
            f3 = hoveredElevation;
        }
        if (i7 & 8 != 0) {
            obj9 = 0;
            f = obj11;
        } else {
            f = focusedElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(empty, $changed, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:248)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1100369724, "CC(remember):FloatingActionButton.kt#9igjgp");
        obj9 = 4;
        obj10 = 0;
        obj11 = 1;
        if (obj8 ^= 6 > obj9) {
            if (!$composer.changed($i$f$getDp)) {
                obj8 = $changed & 6 == obj9 ? obj11 : obj10;
            } else {
            }
        } else {
        }
        int obj14 = 32;
        if (obj9 ^= 48 > obj14) {
            if (!$composer.changed(f4)) {
                obj9 = $changed & 48 == obj14 ? obj11 : obj10;
            } else {
            }
        } else {
        }
        obj14 = 256;
        if (obj9 ^= 384 > obj14) {
            if (!$composer.changed(f3)) {
                obj9 = $changed & 384 == obj14 ? obj11 : obj10;
            } else {
            }
        } else {
        }
        obj14 = 2048;
        if (obj9 ^= 3072 > obj14) {
            if (!$composer.changed(f)) {
                if ($changed & 3072 == obj14) {
                    obj10 = obj11;
                }
            } else {
            }
        } else {
        }
        obj9 = $composer;
        obj10 = 0;
        obj11 = obj9.rememberedValue();
        obj14 = 0;
        if (obj8 |= obj10 == 0) {
            if (obj11 == Composer.Companion.getEmpty()) {
                empty = 0;
                defaultFloatingActionButtonElevation = new DefaultFloatingActionButtonElevation($i$f$getDp, f4, f3, f, 0);
                obj9.updateRememberedValue(defaultFloatingActionButtonElevation);
            } else {
                defaultFloatingActionButtonElevation = obj11;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (FloatingActionButtonElevation)(DefaultFloatingActionButtonElevation)defaultFloatingActionButtonElevation;
    }
}
