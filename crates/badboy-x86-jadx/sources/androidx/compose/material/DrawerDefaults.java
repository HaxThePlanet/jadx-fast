package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u000f8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/material/DrawerDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/TweenSpec;", "Elevation", "Landroidx/compose/ui/unit/Dp;", "getElevation-D9Ej5fM", "()F", "F", "ScrimOpacity", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "getBackgroundColor", "(Landroidx/compose/runtime/Composer;I)J", "scrimColor", "getScrimColor", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DrawerDefaults {

    public static final int $stable = 0;
    private static final TweenSpec<Float> AnimationSpec = null;
    private static final float Elevation = 0f;
    public static final androidx.compose.material.DrawerDefaults INSTANCE = null;
    public static final float ScrimOpacity = 0.32f;
    static {
        DrawerDefaults drawerDefaults = new DrawerDefaults();
        DrawerDefaults.INSTANCE = drawerDefaults;
        TweenSpec tweenSpec = new TweenSpec(256, 0, 0, 6, 0);
        DrawerDefaults.AnimationSpec = tweenSpec;
        int i2 = 0;
        DrawerDefaults.Elevation = Dp.constructor-impl((float)i);
    }

    public final TweenSpec<Float> getAnimationSpec() {
        return DrawerDefaults.AnimationSpec;
    }

    public final long getBackgroundColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -788676020;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C757@29247L6:Drawer.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DrawerDefaults.<get-backgroundColor> (Drawer.kt:757)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return MaterialTheme.INSTANCE.getColors($composer, 6).getSurface-0d7_KjU();
    }

    public final float getElevation-D9Ej5fM() {
        return DrawerDefaults.Elevation;
    }

    public final long getScrimColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 617225966;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C776@29691L6:Drawer.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DrawerDefaults.<get-scrimColor> (Drawer.kt:776)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color.copy-wmQWz5c$default(MaterialTheme.INSTANCE.getColors($composer, 6).getOnSurface-0d7_KjU(), str, 1050924810, 0, 0, 0, 14);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 2041803618;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C769@29505L6:Drawer.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material.DrawerDefaults.<get-shape> (Drawer.kt:769)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Shape)MaterialTheme.INSTANCE.getShapes($composer, 6).getLarge();
    }
}
