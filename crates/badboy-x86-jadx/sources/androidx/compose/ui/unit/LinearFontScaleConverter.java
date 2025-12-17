package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H\u0016J\u0013\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/ui/unit/LinearFontScaleConverter;", "Landroidx/compose/ui/unit/fontscaling/FontScaleConverter;", "fontScale", "", "(F)V", "component1", "convertDpToSp", "dp", "convertSpToDp", "sp", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class LinearFontScaleConverter implements FontScaleConverter {

    private final float fontScale;
    public LinearFontScaleConverter(float fontScale) {
        super();
        this.fontScale = fontScale;
    }

    private final float component1() {
        return this.fontScale;
    }

    public static androidx.compose.ui.unit.LinearFontScaleConverter copy$default(androidx.compose.ui.unit.LinearFontScaleConverter linearFontScaleConverter, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = linearFontScaleConverter.fontScale;
        }
        return linearFontScaleConverter.copy(obj1);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertDpToSp(float dp) {
        return dp / fontScale;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public float convertSpToDp(float sp) {
        return fontScale *= sp;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public final androidx.compose.ui.unit.LinearFontScaleConverter copy(float f) {
        LinearFontScaleConverter linearFontScaleConverter = new LinearFontScaleConverter(f);
        return linearFontScaleConverter;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof LinearFontScaleConverter) {
            return i2;
        }
        if (Float.compare(this.fontScale, obj.fontScale) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public int hashCode() {
        return Float.hashCode(this.fontScale);
    }

    @Override // androidx.compose.ui.unit.fontscaling.FontScaleConverter
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("LinearFontScaleConverter(fontScale=").append(this.fontScale).append(')').toString();
    }
}
