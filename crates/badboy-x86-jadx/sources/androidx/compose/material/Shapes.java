package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J$\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0013", d2 = {"Landroidx/compose/material/Shapes;", "", "small", "Landroidx/compose/foundation/shape/CornerBasedShape;", "medium", "large", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Shapes {

    public static final int $stable;
    private final CornerBasedShape large;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;
    static {
    }

    public Shapes() {
        super(0, 0, 0, 7, 0);
    }

    public Shapes(CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large) {
        super();
        this.small = small;
        this.medium = medium;
        this.large = large;
    }

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        float f;
        androidx.compose.foundation.shape.RoundedCornerShape obj2;
        androidx.compose.foundation.shape.RoundedCornerShape obj3;
        androidx.compose.foundation.shape.RoundedCornerShape obj4;
        int obj5;
        int obj6;
        if (i4 & 1 != 0) {
            obj6 = 0;
            obj2 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)obj2));
        }
        if (i4 & 2 != 0) {
            obj6 = 0;
            obj3 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)obj3));
        }
        if (i4 &= 4 != 0) {
            obj5 = 0;
            obj4 = RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl((float)obj4));
        }
        super(obj2, obj3, obj4);
    }

    public static androidx.compose.material.Shapes copy$default(androidx.compose.material.Shapes shapes, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, int i5, Object object6) {
        CornerBasedShape obj1;
        CornerBasedShape obj2;
        CornerBasedShape obj3;
        if (i5 & 1 != 0) {
            obj1 = shapes.small;
        }
        if (i5 & 2 != 0) {
            obj2 = shapes.medium;
        }
        if (i5 &= 4 != 0) {
            obj3 = shapes.large;
        }
        return shapes.copy(obj1, obj2, obj3);
    }

    public final androidx.compose.material.Shapes copy(CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large) {
        Shapes shapes = new Shapes(small, medium, large);
        return shapes;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof Shapes) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.small, obj.small)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.medium, obj2.medium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.large, obj3.large)) {
            return i2;
        }
        return i;
    }

    public final CornerBasedShape getLarge() {
        return this.large;
    }

    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public int hashCode() {
        return result += i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Shapes(small=").append(this.small).append(", medium=").append(this.medium).append(", large=").append(this.large).append(')').toString();
    }
}
