package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\u000e\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000f", d2 = {"Landroidx/compose/material/BottomSheetScaffoldDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/AnimationSpec;", "SheetElevation", "Landroidx/compose/ui/unit/Dp;", "getSheetElevation-D9Ej5fM", "()F", "F", "SheetPeekHeight", "getSheetPeekHeight-D9Ej5fM", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BottomSheetScaffoldDefaults {

    public static final int $stable = 8;
    private static final AnimationSpec<Float> AnimationSpec;
    public static final androidx.compose.material.BottomSheetScaffoldDefaults INSTANCE;
    private static final float SheetElevation;
    private static final float SheetPeekHeight;
    static {
        BottomSheetScaffoldDefaults bottomSheetScaffoldDefaults = new BottomSheetScaffoldDefaults();
        BottomSheetScaffoldDefaults.INSTANCE = bottomSheetScaffoldDefaults;
        int i4 = 0;
        BottomSheetScaffoldDefaults.SheetElevation = Dp.constructor-impl((float)i);
        int i5 = 0;
        BottomSheetScaffoldDefaults.SheetPeekHeight = Dp.constructor-impl((float)i2);
        BottomSheetScaffoldDefaults.AnimationSpec = (AnimationSpec)AnimationSpecKt.tween$default(300, 0, EasingKt.getFastOutSlowInEasing(), 2, 0);
        int i3 = 8;
    }

    public final AnimationSpec<Float> getAnimationSpec() {
        return BottomSheetScaffoldDefaults.AnimationSpec;
    }

    public final float getSheetElevation-D9Ej5fM() {
        return BottomSheetScaffoldDefaults.SheetElevation;
    }

    public final float getSheetPeekHeight-D9Ej5fM() {
        return BottomSheetScaffoldDefaults.SheetPeekHeight;
    }
}
