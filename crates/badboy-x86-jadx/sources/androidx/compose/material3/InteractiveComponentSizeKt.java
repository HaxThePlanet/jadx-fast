package androidx.compose.material3;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000c\u0010\n\u001a\u00020\u000b*\u00020\u000bH\u0007\"\"\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00018GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u0017\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0006¨\u0006\u000c", d2 = {"LocalMinimumInteractiveComponentEnforcement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalMinimumInteractiveComponentEnforcement$annotations", "()V", "getLocalMinimumInteractiveComponentEnforcement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalMinimumInteractiveComponentSize", "Landroidx/compose/ui/unit/Dp;", "getLocalMinimumInteractiveComponentSize", "minimumInteractiveComponentSize", "Landroidx/compose/ui/Modifier;", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class InteractiveComponentSizeKt {

    private static final ProvidableCompositionLocal<Boolean> LocalMinimumInteractiveComponentEnforcement;
    private static final ProvidableCompositionLocal<Dp> LocalMinimumInteractiveComponentSize;
    static {
        InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement = CompositionLocalKt.staticCompositionLocalOf((Function0)InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement.1.INSTANCE);
        InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize = CompositionLocalKt.staticCompositionLocalOf((Function0)InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize.1.INSTANCE);
    }

    public static final ProvidableCompositionLocal<Boolean> getLocalMinimumInteractiveComponentEnforcement() {
        return InteractiveComponentSizeKt.LocalMinimumInteractiveComponentEnforcement;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use LocalMinimumInteractiveComponentSize with Dp.Unspecified to turn off enforcement instead.", replaceWith = @ReplaceWith(...))
    public static void getLocalMinimumInteractiveComponentEnforcement$annotations() {
    }

    public static final ProvidableCompositionLocal<Dp> getLocalMinimumInteractiveComponentSize() {
        return InteractiveComponentSizeKt.LocalMinimumInteractiveComponentSize;
    }

    public static final Modifier minimumInteractiveComponentSize(Modifier $this$minimumInteractiveComponentSize) {
        return $this$minimumInteractiveComponentSize.then((Modifier)MinimumInteractiveModifier.INSTANCE);
    }
}
