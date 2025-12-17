package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J.\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u001cH\u0016R\u001c\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000cR$\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\u0008\r\u0010\n\u001a\u0004\u0008\u000e\u0010\u000fR$\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0010\u0012\u0004\u0008\u0011\u0010\n\u001a\u0004\u0008\u0012\u0010\u000f\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/ui/graphics/Shadow;", "", "color", "Landroidx/compose/ui/graphics/Color;", "offset", "Landroidx/compose/ui/geometry/Offset;", "blurRadius", "", "(JJFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBlurRadius$annotations", "()V", "getBlurRadius", "()F", "getColor-0d7_KjU$annotations", "getColor-0d7_KjU", "()J", "J", "getOffset-F1C5BW0$annotations", "getOffset-F1C5BW0", "copy", "copy-qcb84PM", "(JJF)Landroidx/compose/ui/graphics/Shadow;", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Shadow {

    public static final androidx.compose.ui.graphics.Shadow.Companion Companion;
    private static final androidx.compose.ui.graphics.Shadow None;
    private final float blurRadius;
    private final long color;
    private final long offset;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/ui/graphics/Shadow$Companion;", "", "()V", "None", "Landroidx/compose/ui/graphics/Shadow;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/graphics/Shadow;", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getNone$annotations() {
        }

        public final androidx.compose.ui.graphics.Shadow getNone() {
            return Shadow.access$getNone$cp();
        }
    }
    static {
        Shadow.Companion companion = new Shadow.Companion(0);
        Shadow.Companion = companion;
        Shadow shadow = new Shadow(0, obj4, 0, obj6, 0, 7, 0);
        Shadow.None = shadow;
    }

    private Shadow(long color, long offset, float blurRadius) {
        super();
        this.color = color;
        this.offset = blurRadius;
        this.blurRadius = obj5;
    }

    public Shadow(long l, long l2, float f3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        long l3;
        long l4;
        int i;
        long obj8;
        long obj10;
        int obj12;
        if (obj13 & 1 != 0) {
            l3 = obj8;
        } else {
            l3 = l;
        }
        if (obj13 & 2 != 0) {
            l4 = obj10;
        } else {
            l4 = f3;
        }
        i = obj13 & 4 != 0 ? obj12 : defaultConstructorMarker5;
        super(l3, obj2, l4, obj4, i, 0);
    }

    public Shadow(long l, long l2, float f3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(l, l2, f3, defaultConstructorMarker4, obj5);
    }

    public static final androidx.compose.ui.graphics.Shadow access$getNone$cp() {
        return Shadow.None;
    }

    public static androidx.compose.ui.graphics.Shadow copy-qcb84PM$default(androidx.compose.ui.graphics.Shadow shadow, long l2, long l3, float f4, int i5, Object object6) {
        long l4;
        long l;
        float f;
        long obj7;
        long obj9;
        float obj11;
        l4 = obj12 & 1 != 0 ? obj7 : l2;
        l = obj12 & 2 != 0 ? obj9 : f4;
        f = obj12 & 4 != 0 ? obj11 : object6;
        return shadow.copy-qcb84PM(l4, obj2, l);
    }

    public static void getBlurRadius$annotations() {
    }

    public static void getColor-0d7_KjU$annotations() {
    }

    public static void getOffset-F1C5BW0$annotations() {
    }

    public final androidx.compose.ui.graphics.Shadow copy-qcb84PM(long color, long offset, float blurRadius) {
        Shadow shadow = new Shadow(color, obj2, blurRadius, obj4, obj12, 0);
        return shadow;
    }

    public boolean equals(Object other) {
        int i;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        final int i3 = 0;
        if (!other instanceof Shadow) {
            return i3;
        }
        if (!Color.equals-impl0(this.color, obj4)) {
            return i3;
        }
        if (!Offset.equals-impl0(this.offset, obj4)) {
            return i3;
        }
        i = Float.compare(blurRadius, blurRadius2) == 0 ? i2 : i3;
        if (i == 0) {
            return i3;
        }
        return i2;
    }

    public final float getBlurRadius() {
        return this.blurRadius;
    }

    public final long getColor-0d7_KjU() {
        return this.color;
    }

    public final long getOffset-F1C5BW0() {
        return this.offset;
    }

    public int hashCode() {
        return result += i6;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Shadow(color=").append(Color.toString-impl(this.color)).append(", offset=").append(Offset.toString-impl(this.offset)).append(", blurRadius=").append(this.blurRadius).append(')').toString();
    }
}
