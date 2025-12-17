package androidx.compose.foundation.shape;

import androidx.compose.ui.platform.InspectableValue;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0082\u0008\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\n\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0008\u0010\u0019\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001a", d2 = {"Landroidx/compose/foundation/shape/PxCornerSize;", "Landroidx/compose/foundation/shape/CornerSize;", "Landroidx/compose/ui/platform/InspectableValue;", "size", "", "(F)V", "valueOverride", "", "getValueOverride", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toPx", "shapeSize", "Landroidx/compose/ui/geometry/Size;", "density", "Landroidx/compose/ui/unit/Density;", "toPx-TmRCtEA", "(JLandroidx/compose/ui/unit/Density;)F", "toString", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PxCornerSize implements androidx.compose.foundation.shape.CornerSize, InspectableValue {

    private final float size;
    public PxCornerSize(float size) {
        super();
        this.size = size;
    }

    private final float component1() {
        return this.size;
    }

    public static androidx.compose.foundation.shape.PxCornerSize copy$default(androidx.compose.foundation.shape.PxCornerSize pxCornerSize, float f2, int i3, Object object4) {
        float obj1;
        if (i3 &= 1 != 0) {
            obj1 = pxCornerSize.size;
        }
        return pxCornerSize.copy(obj1);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public final androidx.compose.foundation.shape.PxCornerSize copy(float f) {
        PxCornerSize pxCornerSize = new PxCornerSize(f);
        return pxCornerSize;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof PxCornerSize) {
            return i2;
        }
        if (Float.compare(this.size, obj.size) != 0) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public Object getValueOverride() {
        return getValueOverride();
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public String getValueOverride() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.size).append("px").toString();
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public int hashCode() {
        return Float.hashCode(this.size);
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public float toPx-TmRCtEA(long shapeSize, Density density) {
        return this.size;
    }

    @Override // androidx.compose.foundation.shape.CornerSize
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CornerSize(size = ").append(this.size).append(".px)").toString();
    }
}
