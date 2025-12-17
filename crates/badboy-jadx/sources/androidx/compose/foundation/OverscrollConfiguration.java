package androidx.compose.foundation;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0019\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0013", d2 = {"Landroidx/compose/foundation/OverscrollConfiguration;", "", "glowColor", "Landroidx/compose/ui/graphics/Color;", "drawPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "(JLandroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDrawPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "getGlowColor-0d7_KjU", "()J", "J", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class OverscrollConfiguration {

    public static final int $stable;
    private final PaddingValues drawPadding;
    private final long glowColor;
    static {
    }

    private OverscrollConfiguration(long glowColor, PaddingValues drawPadding) {
        super();
        this.glowColor = glowColor;
        this.drawPadding = obj3;
    }

    public OverscrollConfiguration(long l, PaddingValues paddingValues2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        long obj1;
        PaddingValues obj3;
        int obj4;
        if (defaultConstructorMarker4 & 1 != 0) {
            obj1 = ColorKt.Color(4284900966L);
        }
        int obj5 = 0;
        if (defaultConstructorMarker4 &= 2 != 0) {
            obj4 = 0;
            obj3 = PaddingKt.PaddingValues-YgX7TsA$default(obj4, obj4, 3, obj5);
        }
        super(obj1, paddingValues2, obj3, obj5);
    }

    public OverscrollConfiguration(long l, PaddingValues paddingValues2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(l, paddingValues2, defaultConstructorMarker3);
    }

    public boolean equals(Object other) {
        Class class;
        final int i = 1;
        if (this == other) {
            return i;
        }
        if (other != null) {
            class = other.getClass();
        } else {
            class = 0;
        }
        int i2 = 0;
        if (!Intrinsics.areEqual(getClass(), class)) {
            return i2;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type androidx.compose.foundation.OverscrollConfiguration");
        Object obj = other;
        if (!Color.equals-impl0(this.glowColor, obj4)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.drawPadding, obj3.drawPadding)) {
            return i2;
        }
        return i;
    }

    public final PaddingValues getDrawPadding() {
        return this.drawPadding;
    }

    public final long getGlowColor-0d7_KjU() {
        return this.glowColor;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("OverscrollConfiguration(glowColor=").append(Color.toString-impl(this.glowColor)).append(", drawPadding=").append(this.drawPadding).append(')').toString();
    }
}
