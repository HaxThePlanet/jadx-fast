package androidx.compose.material;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u000c\u001a\u00020\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0014", d2 = {"Landroidx/compose/material/ResistanceConfig;", "", "basis", "", "factorAtMin", "factorAtMax", "(FFF)V", "getBasis", "()F", "getFactorAtMax", "getFactorAtMin", "computeResistance", "overflow", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResistanceConfig {

    public static final int $stable;
    private final float basis;
    private final float factorAtMax;
    private final float factorAtMin;
    static {
    }

    public ResistanceConfig(float basis, float factorAtMin, float factorAtMax) {
        super();
        this.basis = basis;
        this.factorAtMin = factorAtMin;
        this.factorAtMax = factorAtMax;
    }

    public ResistanceConfig(float f, float f2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        int obj3;
        int obj4;
        final int i = 1092616192;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(f, obj3, obj4);
    }

    public final float computeResistance(float overflow) {
        float factorAtMax;
        int i;
        int $this$fastCoerceAtMost$iv$iv;
        int i2 = 0;
        factorAtMax = Float.compare(overflow, i2) < 0 ? this.factorAtMin : this.factorAtMax;
        i = Float.compare(factorAtMax, i2) == 0 ? 1 : 0;
        if (i != 0) {
            return i2;
        }
        int i6 = -1082130432;
        int i10 = 1065353216;
        final int i12 = 0;
        int i13 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i6) < 0) {
            $this$fastCoerceAtMost$iv$iv = i6;
        }
        int i14 = 0;
        if (Float.compare($this$fastCoerceAtMost$iv$iv, i10) > 0) {
            $this$fastCoerceAtMost$iv$iv = i10;
        }
        float f2 = (float)i11;
        return i4 *= f;
    }

    public boolean equals(Object other) {
        int i2;
        int i;
        int i3;
        final int i4 = 1;
        if (this == other) {
            return i4;
        }
        final int i5 = 0;
        if (!other instanceof ResistanceConfig) {
            return i5;
        }
        i2 = Float.compare(basis, basis2) == 0 ? i4 : i5;
        if (i2 == 0) {
            return i5;
        }
        i = Float.compare(factorAtMin, factorAtMin2) == 0 ? i4 : i5;
        if (i == 0) {
            return i5;
        }
        i3 = Float.compare(factorAtMax, factorAtMax2) == 0 ? i4 : i5;
        if (i3 == 0) {
            return i5;
        }
        return i4;
    }

    public final float getBasis() {
        return this.basis;
    }

    public final float getFactorAtMax() {
        return this.factorAtMax;
    }

    public final float getFactorAtMin() {
        return this.factorAtMin;
    }

    public int hashCode() {
        return result += i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ResistanceConfig(basis=").append(this.basis).append(", factorAtMin=").append(this.factorAtMin).append(", factorAtMax=").append(this.factorAtMax).append(')').toString();
    }
}
