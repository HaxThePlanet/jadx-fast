package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u0004HÂ\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\tJ\u001d\u0010\u000c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001ø\u0001\u0000¢\u0006\u0004\u0008\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0008\u0010\u001d\u001a\u00020\u001eH\u0016R\u0016\u0010\u0003\u001a\u00020\u0004X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00048VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/foundation/shape/DpCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "Landroidx/compose/ui/unit/Dp;", "(FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "F", "valueOverride", "getValueOverride-D9Ej5fM", "()F", "component1", "component1-D9Ej5fM", "copy", "copy-0680j_4", "(F)Landroidx/compose/foundation/shape/DpCornerSize;", "equals", "", "other", "", "hashCode", "", "toPx", "", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DpCornerSize implements androidx.compose.foundation.shape.CornerSize, InspectableValue {

    private final float size;
    private DpCornerSize(float size) {
        super();
        this.size = size;
    }

    public DpCornerSize(float f, DefaultConstructorMarker defaultConstructorMarker2) {
        super(f);
    }

    private final float component1-D9Ej5fM() {
        return this.size;
    }

    public static androidx.compose.foundation.shape.DpCornerSize copy-0680j_4$default(androidx.compose.foundation.shape.DpCornerSize dpCornerSize, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = dpCornerSize.size;
        }
        return dpCornerSize.copy-0680j_4(obj1);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public final androidx.compose.foundation.shape.DpCornerSize copy-0680j_4(float f) {
        DpCornerSize dpCornerSize = new DpCornerSize(f, 0);
        return dpCornerSize;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DpCornerSize) {
            return i2;
        }
        if (!Dp.equals-impl0(this.size, obj.size)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public Object getValueOverride() {
        return Dp.box-impl(getValueOverride-D9Ej5fM());
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public float getValueOverride-D9Ej5fM() {
        return this.size;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public int hashCode() {
        return Dp.hashCode-impl(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public float toPx-TmRCtEA(long shapeSize, Density density) {
        final int i = 0;
        return obj6.toPx-0680j_4(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CornerSize(size = ").append(this.size).append(".dp)").toString();
    }
}
