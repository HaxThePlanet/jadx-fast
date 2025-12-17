package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\u000e8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0011", d2 = {"Landroidx/compose/material/ModalBottomSheetDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "scrimColor", "Landroidx/compose/ui/graphics/Color;", "getScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ModalBottomSheetDefaults {

    public static final int $stable = 8;
    private static final AnimationSpec<Float> AnimationSpec;
    private static final float Elevation;
    public static final androidx.compose.material.ModalBottomSheetDefaults INSTANCE;
    static {
        ModalBottomSheetDefaults modalBottomSheetDefaults = new ModalBottomSheetDefaults();
        ModalBottomSheetDefaults.INSTANCE = modalBottomSheetDefaults;
        int i3 = 0;
        ModalBottomSheetDefaults.Elevation = Dp.constructor-impl((float)i);
        ModalBottomSheetDefaults.AnimationSpec = (AnimationSpec)AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
        int i2 = 8;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return ModalBottomSheetDefaults.AnimationSpec;
    }

    public final float getElevation-D9Ej5fM() {
        return ModalBottomSheetDefaults.Elevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -112572414;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C538@21662L6:ModalBottomSheet.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.ModalBottomSheetDefaults.<get-scrimColor> (ModalBottomSheet.kt:538)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, 6).getOnSurface-0d7_KjU(), str, 1050924810, 0, 0, 0, 14);
    }
}
