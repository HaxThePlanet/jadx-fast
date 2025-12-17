package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.Dp;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0005R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u000e\u0010\u0008\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\u0008\u000c\u0010\r\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/material/SwipeableDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "StandardResistanceFactor", "StiffResistanceFactor", "VelocityThreshold", "Landroidx/compose/ui/unit/Dp;", "getVelocityThreshold-D9Ej5fM", "()F", "F", "resistanceConfig", "Landroidx/compose/material/ResistanceConfig;", "anchors", "", "factorAtMin", "factorAtMax", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeableDefaults {

    public static final int $stable = 0;
    private static final SpringSpec<Float> AnimationSpec = null;
    public static final androidx.compose.material.SwipeableDefaults INSTANCE = null;
    public static final float StandardResistanceFactor = 10f;
    public static final float StiffResistanceFactor = 20f;
    private static final float VelocityThreshold;
    static {
        SwipeableDefaults swipeableDefaults = new SwipeableDefaults();
        SwipeableDefaults.INSTANCE = swipeableDefaults;
        SpringSpec springSpec = new SpringSpec(0, 0, 0, 7, 0);
        SwipeableDefaults.AnimationSpec = springSpec;
        int i2 = 0;
        SwipeableDefaults.VelocityThreshold = Dp.constructor-impl((float)i);
    }

    public static androidx.compose.material.ResistanceConfig resistanceConfig$default(androidx.compose.material.SwipeableDefaults swipeableDefaults, Set set2, float f3, float f4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 1092616192;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return swipeableDefaults.resistanceConfig(set2, obj3, obj4);
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return SwipeableDefaults.AnimationSpec;
    }

    public final float getVelocityThreshold-D9Ej5fM() {
        return SwipeableDefaults.VelocityThreshold;
    }

    public final androidx.compose.material.ResistanceConfig resistanceConfig(Set<Float> anchors, float factorAtMin, float factorAtMax) {
        int basis;
        int resistanceConfig;
        if (anchors.size() <= 1) {
            basis = 0;
        } else {
            Float maxOrNull = CollectionsKt.maxOrNull((Iterable)anchors);
            Intrinsics.checkNotNull(maxOrNull);
            Float minOrNull = CollectionsKt.minOrNull((Iterable)anchors);
            Intrinsics.checkNotNull(minOrNull);
            resistanceConfig = new ResistanceConfig(floatValue -= floatValue2, factorAtMin, factorAtMax);
            basis = resistanceConfig;
        }
        return basis;
    }
}
