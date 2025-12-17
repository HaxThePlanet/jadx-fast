package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u001a\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0003\u0010\u0004¨\u0006\u0005", d2 = {"LocalShapes", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Shapes;", "getLocalShapes", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ShapesKt {

    private static final ProvidableCompositionLocal<androidx.compose.material.Shapes> LocalShapes;
    static {
        ShapesKt.LocalShapes = CompositionLocalKt.staticCompositionLocalOf((Function0)ShapesKt.LocalShapes.1.INSTANCE);
    }

    public static final ProvidableCompositionLocal<androidx.compose.material.Shapes> getLocalShapes() {
        return ShapesKt.LocalShapes;
    }
}
