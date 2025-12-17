package androidx.compose.material;

import androidx.compose.animation.core.SpringSpec;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/material/AnchoredDraggableDefaults;", "", "()V", "AnimationSpec", "Landroidx/compose/animation/core/SpringSpec;", "", "getAnimationSpec$annotations", "getAnimationSpec", "()Landroidx/compose/animation/core/SpringSpec;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnchoredDraggableDefaults {

    public static final int $stable;
    private static final SpringSpec<Float> AnimationSpec;
    public static final androidx.compose.material.AnchoredDraggableDefaults INSTANCE;
    static {
        AnchoredDraggableDefaults anchoredDraggableDefaults = new AnchoredDraggableDefaults();
        AnchoredDraggableDefaults.INSTANCE = anchoredDraggableDefaults;
        SpringSpec springSpec = new SpringSpec(0, 0, 0, 7, 0);
        AnchoredDraggableDefaults.AnimationSpec = springSpec;
    }

    public static void getAnimationSpec$annotations() {
    }

    public final SpringSpec<Float> getAnimationSpec() {
        return AnchoredDraggableDefaults.AnimationSpec;
    }
}
