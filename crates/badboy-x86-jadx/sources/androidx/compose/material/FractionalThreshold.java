package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Deprecated;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u001c\u0010\u000f\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Landroidx/compose/material/FractionalThreshold;", "Landroidx/compose/material/ThresholdConfig;", "fraction", "", "(F)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "computeThreshold", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FractionalThreshold implements androidx.compose.material.ThresholdConfig {

    public static final int $stable;
    private final float fraction;
    static {
    }

    public FractionalThreshold(float fraction) {
        super();
        this.fraction = fraction;
    }

    private final float component1() {
        return this.fraction;
    }

    public static androidx.compose.material.FractionalThreshold copy$default(androidx.compose.material.FractionalThreshold fractionalThreshold, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = fractionalThreshold.fraction;
        }
        return fractionalThreshold.copy(obj1);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(Density $this$computeThreshold, float fromValue, float toValue) {
        return MathHelpersKt.lerp(fromValue, toValue, this.fraction);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public final androidx.compose.material.FractionalThreshold copy(float f) {
        FractionalThreshold fractionalThreshold = new FractionalThreshold(f);
        return fractionalThreshold;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FractionalThreshold) {
            return i2;
        }
        if (Float.compare(this.fraction, obj.fraction) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public int hashCode() {
        return Float.hashCode(this.fraction);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FractionalThreshold(fraction=").append(this.fraction).append(')').toString();
    }
}
