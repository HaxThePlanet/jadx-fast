package androidx.compose.material3.carousel;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/material3/carousel/CarouselAlignment;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class CarouselAlignment {

    private static final int Center;
    public static final androidx.compose.material3.carousel.CarouselAlignment.Companion Companion;
    private static final int End;
    private static final int Start;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/material3/carousel/CarouselAlignment$Companion;", "", "()V", "Center", "Landroidx/compose/material3/carousel/CarouselAlignment;", "getCenter-NUL3oTo", "()I", "I", "End", "getEnd-NUL3oTo", "Start", "getStart-NUL3oTo", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getCenter-NUL3oTo() {
            return CarouselAlignment.access$getCenter$cp();
        }

        public final int getEnd-NUL3oTo() {
            return CarouselAlignment.access$getEnd$cp();
        }

        public final int getStart-NUL3oTo() {
            return CarouselAlignment.access$getStart$cp();
        }
    }
    static {
        CarouselAlignment.Companion companion = new CarouselAlignment.Companion(0);
        CarouselAlignment.Companion = companion;
        CarouselAlignment.Start = CarouselAlignment.constructor-impl(-1);
        CarouselAlignment.Center = CarouselAlignment.constructor-impl(0);
        CarouselAlignment.End = CarouselAlignment.constructor-impl(1);
    }

    private CarouselAlignment(int value) {
        super();
        this.value = value;
    }

    public static final int access$getCenter$cp() {
        return CarouselAlignment.Center;
    }

    public static final int access$getEnd$cp() {
        return CarouselAlignment.End;
    }

    public static final int access$getStart$cp() {
        return CarouselAlignment.Start;
    }

    public static final androidx.compose.material3.carousel.CarouselAlignment box-impl(int i) {
        CarouselAlignment carouselAlignment = new CarouselAlignment(i);
        return carouselAlignment;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof CarouselAlignment) {
            return i3;
        }
        if (i != (CarouselAlignment)object2.unbox-impl()) {
            return i3;
        }
        return 1;
    }

    public static final boolean equals-impl0(int i, int i2) {
        int i3;
        i3 = i == i2 ? 1 : 0;
        return i3;
    }

    public static int hashCode-impl(int i) {
        return Integer.hashCode(i);
    }

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CarouselAlignment(value=").append(i).append(')').toString();
    }

    public boolean equals(Object object) {
        return CarouselAlignment.equals-impl(this.value, object);
    }

    public int hashCode() {
        return CarouselAlignment.hashCode-impl(this.value);
    }

    public String toString() {
        return CarouselAlignment.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
