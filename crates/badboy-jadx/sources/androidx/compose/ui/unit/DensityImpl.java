package androidx.compose.ui.unit;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/ui/unit/DensityImpl;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "(FF)V", "getDensity", "()F", "getFontScale", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DensityImpl implements androidx.compose.ui.unit.Density {

    private final float density;
    private final float fontScale;
    public DensityImpl(float density, float fontScale) {
        super();
        this.density = density;
        this.fontScale = fontScale;
    }

    public static androidx.compose.ui.unit.DensityImpl copy$default(androidx.compose.ui.unit.DensityImpl densityImpl, float f2, float f3, int i4, Object object5) {
        float obj1;
        float obj2;
        if (i4 & 1 != 0) {
            obj1 = densityImpl.density;
        }
        if (i4 &= 2 != 0) {
            obj2 = densityImpl.fontScale;
        }
        return densityImpl.copy(obj1, obj2);
    }

    @Override // androidx.compose.ui.unit.Density
    public final float component1() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.Density
    public final float component2() {
        return this.fontScale;
    }

    @Override // androidx.compose.ui.unit.Density
    public final androidx.compose.ui.unit.DensityImpl copy(float f, float f2) {
        DensityImpl densityImpl = new DensityImpl(f, f2);
        return densityImpl;
    }

    @Override // androidx.compose.ui.unit.Density
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DensityImpl) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.density, obj.density) != 0) {
            return i2;
        }
        if (Float.compare(this.fontScale, obj.fontScale) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.fontScale;
    }

    @Override // androidx.compose.ui.unit.Density
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.ui.unit.Density
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DensityImpl(density=").append(this.density).append(", fontScale=").append(this.fontScale).append(')').toString();
    }
}
