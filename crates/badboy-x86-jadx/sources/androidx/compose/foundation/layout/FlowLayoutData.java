package androidx.compose.foundation.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0008\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/layout/FlowLayoutData;", "", "fillCrossAxisFraction", "", "(F)V", "getFillCrossAxisFraction", "()F", "setFillCrossAxisFraction", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FlowLayoutData {

    public static final int $stable = 8;
    private float fillCrossAxisFraction;
    static {
        final int i = 8;
    }

    public FlowLayoutData(float fillCrossAxisFraction) {
        super();
        this.fillCrossAxisFraction = fillCrossAxisFraction;
    }

    public static androidx.compose.foundation.layout.FlowLayoutData copy$default(androidx.compose.foundation.layout.FlowLayoutData flowLayoutData, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = flowLayoutData.fillCrossAxisFraction;
        }
        return flowLayoutData.copy(obj1);
    }

    public final float component1() {
        return this.fillCrossAxisFraction;
    }

    public final androidx.compose.foundation.layout.FlowLayoutData copy(float f) {
        FlowLayoutData flowLayoutData = new FlowLayoutData(f);
        return flowLayoutData;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof FlowLayoutData == null) {
            return i2;
        }
        if (Float.compare(this.fillCrossAxisFraction, obj.fillCrossAxisFraction) != 0) {
            return i2;
        }
        return i;
    }

    public final float getFillCrossAxisFraction() {
        return this.fillCrossAxisFraction;
    }

    public int hashCode() {
        return Float.hashCode(this.fillCrossAxisFraction);
    }

    public final void setFillCrossAxisFraction(float <set-?>) {
        this.fillCrossAxisFraction = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FlowLayoutData(fillCrossAxisFraction=").append(this.fillCrossAxisFraction).append(')').toString();
    }
}
