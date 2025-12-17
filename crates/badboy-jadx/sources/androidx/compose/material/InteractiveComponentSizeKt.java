package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\n\u001a\u00020\r*\u00020\r\"\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\"\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0008\u0010\u0004\u001a\u0004\u0008\t\u0010\u0006\"\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000c¨\u0006\u000e", d2 = {"LocalMinimumInteractiveComponentEnforcement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalMinimumInteractiveComponentEnforcement$annotations", "()V", "getLocalMinimumInteractiveComponentEnforcement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalMinimumTouchTargetEnforcement", "getLocalMinimumTouchTargetEnforcement$annotations", "getLocalMinimumTouchTargetEnforcement", "minimumInteractiveComponentSize", "Landroidx/compose/ui/unit/DpSize;", "J", "Landroidx/compose/ui/Modifier;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InteractiveComponentSizeKt {

    private static final ProvidableCompositionLocal<Boolean> LocalMinimumInteractiveComponentEnforcement;
    private static final ProvidableCompositionLocal<Boolean> LocalMinimumTouchTargetEnforcement;
    private static final long minimumInteractiveComponentSize;
    static {
        InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement = CompositionLocalKt.staticCompositionLocalOf((Function0)InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement.1.INSTANCE);
        InteractiveComponentSizeKt.LocalMinimumTouchTargetEnforcement = InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement;
        int i2 = 0;
        int i3 = 0;
        InteractiveComponentSizeKt.minimumInteractiveComponentSize = DpKt.DpSize-YgX7TsA(Dp.constructor-impl((float)i), Dp.constructor-impl((float)$i$f$getDp));
    }

    public static final long access$getMinimumInteractiveComponentSize$p() {
        return InteractiveComponentSizeKt.minimumInteractiveComponentSize;
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumInteractiveComponentEnforcement() {
        return InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement;
    }

    public static void getLocalMinimumInteractiveComponentEnforcement$annotations() {
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumTouchTargetEnforcement() {
        return InteractiveComponentSizeKt.LocalMinimumTouchTargetEnforcement;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use LocalMinimumInteractiveComponentEnforcement instead.", replaceWith = @ReplaceWith(...))
    public static void getLocalMinimumTouchTargetEnforcement$annotations() {
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier $this$minimumInteractiveComponentSize) {
        return $this$minimumInteractiveComponentSize.then((Modifier)MinimumInteractiveModifier.INSTANCE);
    }
}
