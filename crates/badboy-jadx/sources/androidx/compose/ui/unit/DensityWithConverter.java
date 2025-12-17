package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÂ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\u0019*\u00020\u0018H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001f", d2 = {"Landroidx/compose/ui/unit/DensityWithConverter;", "Landroidx/compose/ui/unit/Density;", "density", "", "fontScale", "converter", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "(FFLandroidx/compose/ui/unit/fontscaling/FontScaleConverter;)V", "getDensity", "()F", "getFontScale", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "toDp", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toSp", "toSp-0xMU5do", "(F)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DensityWithConverter implements androidx.compose.ui.unit.Density {

    private final FontScaleConverter converter;
    private final float density;
    private final float fontScale;
    public DensityWithConverter(float density, float fontScale, FontScaleConverter converter) {
        super();
        this.density = density;
        this.fontScale = fontScale;
        this.converter = converter;
    }

    private final FontScaleConverter component3() {
        return this.converter;
    }

    public static androidx.compose.ui.unit.DensityWithConverter copy$default(androidx.compose.ui.unit.DensityWithConverter densityWithConverter, float f2, float f3, FontScaleConverter fontScaleConverter4, int i5, Object object6) {
        float obj1;
        float obj2;
        FontScaleConverter obj3;
        if (i5 & 1 != 0) {
            obj1 = densityWithConverter.density;
        }
        if (i5 & 2 != 0) {
            obj2 = densityWithConverter.fontScale;
        }
        if (i5 &= 4 != 0) {
            obj3 = densityWithConverter.converter;
        }
        return densityWithConverter.copy(obj1, obj2, obj3);
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
    public final androidx.compose.ui.unit.DensityWithConverter copy(float f, float f2, FontScaleConverter fontScaleConverter3) {
        DensityWithConverter densityWithConverter = new DensityWithConverter(f, f2, fontScaleConverter3);
        return densityWithConverter;
    }

    @Override // androidx.compose.ui.unit.Density
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DensityWithConverter) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.density, obj.density) != 0) {
            return i2;
        }
        if (Float.compare(this.fontScale, obj.fontScale) != 0) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.converter, obj.converter)) {
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
        return i2 += i7;
    }

    @Override // androidx.compose.ui.unit.Density
    public float toDp-GaN1DYA(long $this$toDp_u2dGaN1DYA) {
        if (!TextUnitType.equals-impl0(TextUnit.getType-UIouoOA($this$toDp_u2dGaN1DYA), obj1)) {
        } else {
            return Dp.constructor-impl(this.converter.convertSpToDp(TextUnit.getValue-impl($this$toDp_u2dGaN1DYA)));
        }
        int i = 0;
        IllegalStateException $i$a$CheckDensityWithConverter$toDp$1 = new IllegalStateException("Only Sp can convert to Px".toString());
        throw $i$a$CheckDensityWithConverter$toDp$1;
    }

    @Override // androidx.compose.ui.unit.Density
    public long toSp-0xMU5do(float $this$toSp_u2d0xMU5do) {
        return TextUnitKt.getSp(this.converter.convertDpToSp($this$toSp_u2d0xMU5do));
    }

    @Override // androidx.compose.ui.unit.Density
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DensityWithConverter(density=").append(this.density).append(", fontScale=").append(this.fontScale).append(", converter=").append(this.converter).append(')').toString();
    }
}
