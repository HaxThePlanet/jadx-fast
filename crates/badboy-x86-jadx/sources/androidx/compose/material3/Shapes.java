package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B7\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\u0008J8\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\n¨\u0006\u0017", d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", "medium", "large", "extraLarge", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getExtraSmall", "getLarge", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Shapes {

    public static final int $stable;
    private final CornerBasedShape extraLarge;
    private final CornerBasedShape extraSmall;
    private final CornerBasedShape large;
    private final CornerBasedShape medium;
    private final CornerBasedShape small;
    static {
    }

    public Shapes() {
        super(0, 0, 0, 0, 0, 31, 0);
    }

    public Shapes(CornerBasedShape extraSmall, CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large, CornerBasedShape extraLarge) {
        super();
        this.extraSmall = extraSmall;
        this.small = small;
        this.medium = medium;
        this.large = large;
        this.extraLarge = extraLarge;
    }

    public Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        CornerBasedShape obj1;
        CornerBasedShape obj2;
        CornerBasedShape obj3;
        CornerBasedShape obj4;
        CornerBasedShape obj5;
        CornerBasedShape obj7;
        if (i6 & 1 != 0) {
            obj1 = ShapeDefaults.INSTANCE.getExtraSmall();
        }
        if (i6 & 2 != 0) {
            obj2 = ShapeDefaults.INSTANCE.getSmall();
        }
        if (i6 & 4 != 0) {
            obj3 = ShapeDefaults.INSTANCE.getMedium();
        }
        if (i6 & 8 != 0) {
            obj4 = ShapeDefaults.INSTANCE.getLarge();
        }
        if (i6 &= 16 != 0) {
            obj7 = obj5;
        } else {
            obj7 = cornerBasedShape5;
        }
        super(obj1, obj2, obj3, obj4, obj7);
    }

    public static androidx.compose.material3.Shapes copy$default(androidx.compose.material3.Shapes shapes, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, CornerBasedShape cornerBasedShape6, int i7, Object object8) {
        CornerBasedShape obj1;
        CornerBasedShape obj2;
        CornerBasedShape obj3;
        CornerBasedShape obj4;
        CornerBasedShape obj5;
        CornerBasedShape obj7;
        if (i7 & 1 != 0) {
            obj1 = shapes.extraSmall;
        }
        if (i7 & 2 != 0) {
            obj2 = shapes.small;
        }
        if (i7 & 4 != 0) {
            obj3 = shapes.medium;
        }
        if (i7 & 8 != 0) {
            obj4 = shapes.large;
        }
        obj7 = i7 &= 16 != 0 ? obj5 : cornerBasedShape6;
        return shapes.copy(obj1, obj2, obj3, obj4, obj7);
    }

    public final androidx.compose.material3.Shapes copy(CornerBasedShape extraSmall, CornerBasedShape small, CornerBasedShape medium, CornerBasedShape large, CornerBasedShape extraLarge) {
        Shapes shapes = new Shapes(extraSmall, small, medium, large, extraLarge);
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
        if (!Intrinsics.areEqual(this.extraSmall, obj.extraSmall)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.small, obj2.small)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.medium, obj3.medium)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.large, obj4.large)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.extraLarge, obj5.extraLarge)) {
            return i2;
        }
        return i;
    }

    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
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
        return result2 += i10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Shapes(extraSmall=").append(this.extraSmall).append(", small=").append(this.small).append(", medium=").append(this.medium).append(", large=").append(this.large).append(", extraLarge=").append(this.extraLarge).append(')').toString();
    }
}
