package androidx.compose.ui.unit;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005", d2 = {"Density", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DensityKt {
    public static final androidx.compose.ui.unit.Density Density(float density, float fontScale) {
        DensityImpl densityImpl = new DensityImpl(density, fontScale);
        return (Density)densityImpl;
    }

    public static androidx.compose.ui.unit.Density Density$default(float f, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 1065353216;
        }
        return DensityKt.Density(f, obj1);
    }
}
