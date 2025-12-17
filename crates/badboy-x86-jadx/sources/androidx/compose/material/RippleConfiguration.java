package androidx.compose.material;

import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\t\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/material/RippleConfiguration;", "", "color", "Landroidx/compose/ui/graphics/Color;", "rippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "(JLandroidx/compose/material/ripple/RippleAlpha;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColor-0d7_KjU", "()J", "J", "getRippleAlpha", "()Landroidx/compose/material/ripple/RippleAlpha;", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RippleConfiguration {

    public static final int $stable;
    private final long color;
    private final RippleAlpha rippleAlpha;
    static {
    }

    private RippleConfiguration(long color, RippleAlpha rippleAlpha) {
        super();
        this.color = color;
        this.rippleAlpha = obj3;
    }

    public RippleConfiguration(long l, RippleAlpha rippleAlpha2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        long obj1;
        int obj3;
        if (defaultConstructorMarker4 & 1 != 0) {
            obj1 = Color.Companion.getUnspecified-0d7_KjU();
        }
        int obj5 = 0;
        obj3 = defaultConstructorMarker4 &= 2 != 0 ? obj5 : obj3;
        super(obj1, rippleAlpha2, obj3, obj5);
    }

    public RippleConfiguration(long l, RippleAlpha rippleAlpha2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, rippleAlpha2, defaultConstructorMarker3);
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof RippleConfiguration) {
            return i2;
        }
        if (!Color.equals-impl0(this.color, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.rippleAlpha, obj2.rippleAlpha)) {
            return i2;
        }
        return i;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final RippleAlpha getRippleAlpha() {
        return this.rippleAlpha;
    }

    public int hashCode() {
        int i;
        RippleAlpha rippleAlpha = this.rippleAlpha;
        if (rippleAlpha != null) {
            i = rippleAlpha.hashCode();
        } else {
            i = 0;
        }
        return i3 += i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("RippleConfiguration(color=").append(Color.toString-impl(this.color)).append(", rippleAlpha=").append(this.rippleAlpha).append(')').toString();
    }
}
