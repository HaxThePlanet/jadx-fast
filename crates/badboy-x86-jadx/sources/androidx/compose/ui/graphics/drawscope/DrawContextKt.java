package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003¨\u0006\u0004", d2 = {"DefaultDensity", "Landroidx/compose/ui/unit/Density;", "getDefaultDensity", "()Landroidx/compose/ui/unit/Density;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DrawContextKt {

    private static final Density DefaultDensity;
    static {
        int i = 1065353216;
        DrawContextKt.DefaultDensity = DensityKt.Density(i, i);
    }

    public static final Density getDefaultDensity() {
        return DrawContextKt.DefaultDensity;
    }
}
