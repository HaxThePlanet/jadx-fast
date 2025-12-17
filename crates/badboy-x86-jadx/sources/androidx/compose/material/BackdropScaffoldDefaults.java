package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000e\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u0010\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00128Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168G¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/material/BackdropScaffoldDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "FrontLayerElevation", "Landroidx/compose/ui/unit/Dp;", "getFrontLayerElevation-D9Ej5fM", "()F", "F", "HeaderHeight", "getHeaderHeight-D9Ej5fM", "PeekHeight", "getPeekHeight-D9Ej5fM", "frontLayerScrimColor", "Landroidx/compose/ui/graphics/Color;", "getFrontLayerScrimColor", "(Landroidx/compose/runtime/Composer;I)J", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "getFrontLayerShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BackdropScaffoldDefaults {

    public static final int $stable = 8;
    private static final AnimationSpec<Float> AnimationSpec;
    private static final float FrontLayerElevation;
    private static final float HeaderHeight;
    public static final androidx.compose.material.BackdropScaffoldDefaults INSTANCE;
    private static final float PeekHeight;
    static {
        BackdropScaffoldDefaults backdropScaffoldDefaults = new BackdropScaffoldDefaults();
        BackdropScaffoldDefaults.INSTANCE = backdropScaffoldDefaults;
        int i5 = 0;
        BackdropScaffoldDefaults.PeekHeight = Dp.constructor-impl((float)i);
        int i6 = 0;
        BackdropScaffoldDefaults.HeaderHeight = Dp.constructor-impl((float)i2);
        int i7 = 0;
        BackdropScaffoldDefaults.FrontLayerElevation = Dp.constructor-impl((float)i3);
        BackdropScaffoldDefaults.AnimationSpec = (AnimationSpec)AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
        int i4 = 8;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return BackdropScaffoldDefaults.AnimationSpec;
    }

    public final float getFrontLayerElevation-D9Ej5fM() {
        return BackdropScaffoldDefaults.FrontLayerElevation;
    }

    public final long getFrontLayerScrimColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1806270648;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C662@26677L6:BackdropScaffold.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.BackdropScaffoldDefaults.<get-frontLayerScrimColor> (BackdropScaffold.kt:662)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, 6).getSurface-0d7_KjU(), str, 1058642330, 0, 0, 0, 14);
    }

    public final Shape getFrontLayerShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1580588700;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C650@26326L6:BackdropScaffold.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.BackdropScaffoldDefaults.<get-frontLayerShape> (BackdropScaffold.kt:650)");
        }
        int i5 = 0;
        int i6 = 0;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Shape)CornerBasedShape.copy$default(MaterialTheme.INSTANCE.getShapes($composer, 6).getLarge(), CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i2)), CornerSizeKt.CornerSize-0680j_4(Dp.constructor-impl((float)i3)), 0, 0, 12, 0);
    }

    public final float getHeaderHeight-D9Ej5fM() {
        return BackdropScaffoldDefaults.HeaderHeight;
    }

    public final float getPeekHeight-D9Ej5fM() {
        return BackdropScaffoldDefaults.PeekHeight;
    }
}
