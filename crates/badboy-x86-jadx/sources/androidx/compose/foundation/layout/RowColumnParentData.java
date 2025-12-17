package androidx.compose.foundation.layout;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B1\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\tHÆ\u0003J5\u0010\u001f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0008\u0002\u0010\u0008\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010 \u001a\u00020\u00052\u0008\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006&", d2 = {"Landroidx/compose/foundation/layout/RowColumnParentData;", "", "weight", "", "fill", "", "crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "flowLayoutData", "Landroidx/compose/foundation/layout/FlowLayoutData;", "(FZLandroidx/compose/foundation/layout/CrossAxisAlignment;Landroidx/compose/foundation/layout/FlowLayoutData;)V", "getCrossAxisAlignment", "()Landroidx/compose/foundation/layout/CrossAxisAlignment;", "setCrossAxisAlignment", "(Landroidx/compose/foundation/layout/CrossAxisAlignment;)V", "getFill", "()Z", "setFill", "(Z)V", "getFlowLayoutData", "()Landroidx/compose/foundation/layout/FlowLayoutData;", "setFlowLayoutData", "(Landroidx/compose/foundation/layout/FlowLayoutData;)V", "getWeight", "()F", "setWeight", "(F)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RowColumnParentData {

    public static final int $stable = 8;
    private androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment;
    private boolean fill;
    private androidx.compose.foundation.layout.FlowLayoutData flowLayoutData;
    private float weight;
    static {
        final int i = 8;
    }

    public RowColumnParentData() {
        super(0, 0, 0, 0, 15, 0);
    }

    public RowColumnParentData(float weight, boolean fill, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment, androidx.compose.foundation.layout.FlowLayoutData flowLayoutData) {
        super();
        this.weight = weight;
        this.fill = fill;
        this.crossAxisAlignment = crossAxisAlignment;
        this.flowLayoutData = flowLayoutData;
    }

    public RowColumnParentData(float f, boolean z2, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment3, androidx.compose.foundation.layout.FlowLayoutData flowLayoutData4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        obj2 = i5 & 1 != 0 ? 0 : obj2;
        obj3 = i5 & 2 != 0 ? 1 : obj3;
        final int i = 0;
        obj4 = i5 & 4 != 0 ? i : obj4;
        obj5 = i5 &= 8 != 0 ? i : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public static androidx.compose.foundation.layout.RowColumnParentData copy$default(androidx.compose.foundation.layout.RowColumnParentData rowColumnParentData, float f2, boolean z3, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment4, androidx.compose.foundation.layout.FlowLayoutData flowLayoutData5, int i6, Object object7) {
        float obj1;
        boolean obj2;
        androidx.compose.foundation.layout.CrossAxisAlignment obj3;
        androidx.compose.foundation.layout.FlowLayoutData obj4;
        if (i6 & 1 != 0) {
            obj1 = rowColumnParentData.weight;
        }
        if (i6 & 2 != 0) {
            obj2 = rowColumnParentData.fill;
        }
        if (i6 & 4 != 0) {
            obj3 = rowColumnParentData.crossAxisAlignment;
        }
        if (i6 &= 8 != 0) {
            obj4 = rowColumnParentData.flowLayoutData;
        }
        return rowColumnParentData.copy(obj1, obj2, obj3, obj4);
    }

    public final float component1() {
        return this.weight;
    }

    public final boolean component2() {
        return this.fill;
    }

    public final androidx.compose.foundation.layout.CrossAxisAlignment component3() {
        return this.crossAxisAlignment;
    }

    public final androidx.compose.foundation.layout.FlowLayoutData component4() {
        return this.flowLayoutData;
    }

    public final androidx.compose.foundation.layout.RowColumnParentData copy(float f, boolean z2, androidx.compose.foundation.layout.CrossAxisAlignment crossAxisAlignment3, androidx.compose.foundation.layout.FlowLayoutData flowLayoutData4) {
        RowColumnParentData rowColumnParentData = new RowColumnParentData(f, z2, crossAxisAlignment3, flowLayoutData4);
        return rowColumnParentData;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object instanceof RowColumnParentData == null) {
            return i2;
        }
        Object obj = object;
        if (Float.compare(this.weight, obj.weight) != 0) {
            return i2;
        }
        if (this.fill != obj.fill) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.crossAxisAlignment, obj.crossAxisAlignment)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.flowLayoutData, obj.flowLayoutData)) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.foundation.layout.CrossAxisAlignment getCrossAxisAlignment() {
        return this.crossAxisAlignment;
    }

    public final boolean getFill() {
        return this.fill;
    }

    public final androidx.compose.foundation.layout.FlowLayoutData getFlowLayoutData() {
        return this.flowLayoutData;
    }

    public final float getWeight() {
        return this.weight;
    }

    public int hashCode() {
        int i;
        androidx.compose.foundation.layout.FlowLayoutData flowLayoutData;
        int i2;
        if (this.crossAxisAlignment == null) {
            i = i2;
        } else {
            i = this.crossAxisAlignment.hashCode();
        }
        if (this.flowLayoutData == null) {
        } else {
            i2 = this.flowLayoutData.hashCode();
        }
        return i8 += i2;
    }

    public final void setCrossAxisAlignment(androidx.compose.foundation.layout.CrossAxisAlignment <set-?>) {
        this.crossAxisAlignment = <set-?>;
    }

    public final void setFill(boolean <set-?>) {
        this.fill = <set-?>;
    }

    public final void setFlowLayoutData(androidx.compose.foundation.layout.FlowLayoutData <set-?>) {
        this.flowLayoutData = <set-?>;
    }

    public final void setWeight(float <set-?>) {
        this.weight = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RowColumnParentData(weight=").append(this.weight).append(", fill=").append(this.fill).append(", crossAxisAlignment=").append(this.crossAxisAlignment).append(", flowLayoutData=").append(this.flowLayoutData).append(')').toString();
    }
}
