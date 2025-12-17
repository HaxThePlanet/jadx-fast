package androidx.compose.material;

import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0003HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001d\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u001c\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015H\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/material/FixedThreshold;", "Landroidx/compose/material/ThresholdConfig;", "offset", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "component1", "component1-D9Ej5fM", "()F", "copy", "copy-0680j_4", "(F)Landroidx/compose/material/FixedThreshold;", "equals", "", "other", "", "hashCode", "", "toString", "", "computeThreshold", "", "Landroidx/compose/ui/unit/Density;", "fromValue", "toValue", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FixedThreshold implements androidx.compose.material.ThresholdConfig {

    public static final int $stable;
    private final float offset;
    static {
    }

    private FixedThreshold(float offset) {
        super();
        this.offset = offset;
    }

    public FixedThreshold(float f, DefaultConstructorMarker defaultConstructorMarker2) {
        super(f);
    }

    private final float component1-D9Ej5fM() {
        return this.offset;
    }

    public static androidx.compose.material.FixedThreshold copy-0680j_4$default(androidx.compose.material.FixedThreshold fixedThreshold, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = fixedThreshold.offset;
        }
        return fixedThreshold.copy-0680j_4(obj1);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public float computeThreshold(Density $this$computeThreshold, float fromValue, float toValue) {
        return i += fromValue;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public final androidx.compose.material.FixedThreshold copy-0680j_4(float f) {
        FixedThreshold fixedThreshold = new FixedThreshold(f, 0);
        return fixedThreshold;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FixedThreshold) {
            return i2;
        }
        if (!Dp.equals-impl0(this.offset, obj.offset)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.material.ThresholdConfig
    public int hashCode() {
        return Dp.hashCode-impl(this.offset);
    }

    @Override // androidx.compose.material.ThresholdConfig
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FixedThreshold(offset=").append(Dp.toString-impl(this.offset)).append(')').toString();
    }
}
