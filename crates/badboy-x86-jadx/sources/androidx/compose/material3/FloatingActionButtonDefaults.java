package androidx.compose.material3;

import androidx.compose.material3.tokens.ExtendedFabPrimaryTokens;
import androidx.compose.material3.tokens.FabPrimaryLargeTokens;
import androidx.compose.material3.tokens.FabPrimarySmallTokens;
import androidx.compose.material3.tokens.FabPrimaryTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0016\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001dJ:\u0010\u001e\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J:\u0010!\u001a\u00020\u00172\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008\"\u0010 R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0008\u001a\u00020\t8Gø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u000c\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006#", d2 = {"Landroidx/compose/material3/FloatingActionButtonDefaults;", "", "()V", "LargeIconSize", "Landroidx/compose/ui/unit/Dp;", "getLargeIconSize-D9Ej5fM", "()F", "F", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "extendedFabShape", "Landroidx/compose/ui/graphics/Shape;", "getExtendedFabShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "largeShape", "getLargeShape", "shape", "getShape", "smallShape", "getSmallShape", "bottomAppBarFabElevation", "Landroidx/compose/material3/FloatingActionButtonElevation;", "defaultElevation", "pressedElevation", "focusedElevation", "hoveredElevation", "bottomAppBarFabElevation-a9UjIt4", "(FFFF)Landroidx/compose/material3/FloatingActionButtonElevation;", "elevation", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/FloatingActionButtonElevation;", "loweredElevation", "loweredElevation-xZ9-QkE", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FloatingActionButtonDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.FloatingActionButtonDefaults INSTANCE;
    private static final float LargeIconSize;
    static {
        FloatingActionButtonDefaults floatingActionButtonDefaults = new FloatingActionButtonDefaults();
        FloatingActionButtonDefaults.INSTANCE = floatingActionButtonDefaults;
        FloatingActionButtonDefaults.LargeIconSize = FabPrimaryLargeTokens.INSTANCE.getIconSize-D9Ej5fM();
    }

    public static androidx.compose.material3.FloatingActionButtonElevation bottomAppBarFabElevation-a9UjIt4$default(androidx.compose.material3.FloatingActionButtonDefaults floatingActionButtonDefaults, float f2, float f3, float f4, float f5, int i6, Object object7) {
        float f;
        float obj2;
        float obj3;
        float obj4;
        float obj5;
        int obj6;
        int obj7;
        if (i6 & 1 != 0) {
            obj7 = 0;
            obj2 = Dp.constructor-impl((float)obj2);
        }
        if (i6 & 2 != 0) {
            obj7 = 0;
            obj3 = Dp.constructor-impl((float)obj3);
        }
        if (i6 & 4 != 0) {
            obj7 = 0;
            obj4 = Dp.constructor-impl((float)obj4);
        }
        if (i6 &= 8 != 0) {
            obj6 = 0;
            obj5 = Dp.constructor-impl((float)obj5);
        }
        return floatingActionButtonDefaults.bottomAppBarFabElevation-a9UjIt4(obj2, obj3, obj4, obj5);
    }

    public final androidx.compose.material3.FloatingActionButtonElevation bottomAppBarFabElevation-a9UjIt4(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation) {
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(defaultElevation, pressedElevation, focusedElevation, hoveredElevation, 0);
        return floatingActionButtonElevation;
    }

    public final androidx.compose.material3.FloatingActionButtonElevation elevation-xZ9-QkE(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, Composer $composer, int $changed, int i7) {
        FabPrimaryTokens iNSTANCE;
        float f3;
        float f2;
        float f;
        float f4;
        float obj8;
        float obj9;
        float obj10;
        float obj11;
        final int i = -241106249;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(elevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp,2:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if (i7 & 1 != 0) {
            f3 = obj8;
        } else {
            f3 = defaultElevation;
        }
        if (i7 & 2 != 0) {
            f2 = obj9;
        } else {
            f2 = pressedElevation;
        }
        if (i7 & 4 != 0) {
            f = obj10;
        } else {
            f = focusedElevation;
        }
        if (i7 & 8 != 0) {
            f4 = obj11;
        } else {
            f4 = hoveredElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:446)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f3, f2, f, f4, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return floatingActionButtonElevation;
    }

    public final long getContainerColor(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 1855656391;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C426@19954L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-containerColor> (FloatingActionButton.kt:426)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ColorSchemeKt.getValue(FabPrimaryTokens.INSTANCE.getContainerColor(), $composer, 6);
    }

    public final Shape getExtendedFabShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -536021915;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C422@19792L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-extendedFabShape> (FloatingActionButton.kt:422)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(ExtendedFabPrimaryTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getLargeIconSize-D9Ej5fM() {
        return FloatingActionButtonDefaults.LargeIconSize;
    }

    public final Shape getLargeShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -1835912187;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C418@19620L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-largeShape> (FloatingActionButton.kt:418)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FabPrimaryLargeTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -53247565;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C410@19302L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-shape> (FloatingActionButton.kt:410)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FabPrimaryTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final Shape getSmallShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 394933381;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C414@19461L5:FloatingActionButton.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.<get-smallShape> (FloatingActionButton.kt:414)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(FabPrimarySmallTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final androidx.compose.material3.FloatingActionButtonElevation loweredElevation-xZ9-QkE(float defaultElevation, float pressedElevation, float focusedElevation, float hoveredElevation, Composer $composer, int $changed, int i7) {
        FabPrimaryTokens iNSTANCE;
        float f2;
        float f3;
        float f4;
        float f;
        float obj8;
        float obj9;
        float obj10;
        float obj11;
        final int i = -285065125;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(loweredElevation)P(0:c#ui.unit.Dp,3:c#ui.unit.Dp,1:c#ui.unit.Dp,2:c#ui.unit.Dp):FloatingActionButton.kt#uh7d8r");
        if (i7 & 1 != 0) {
            f2 = obj8;
        } else {
            f2 = defaultElevation;
        }
        if (i7 & 2 != 0) {
            f3 = obj9;
        } else {
            f3 = pressedElevation;
        }
        if (i7 & 4 != 0) {
            f4 = obj10;
        } else {
            f4 = focusedElevation;
        }
        if (i7 & 8 != 0) {
            f = obj11;
        } else {
            f = hoveredElevation;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.FloatingActionButtonDefaults.loweredElevation (FloatingActionButton.kt:470)");
        }
        FloatingActionButtonElevation floatingActionButtonElevation = new FloatingActionButtonElevation(f2, f3, f4, f, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return floatingActionButtonElevation;
    }
}
