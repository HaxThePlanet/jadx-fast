package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/FilterQuality;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FilterQuality {

    public static final androidx.compose.ui.graphics.FilterQuality.Companion Companion;
    private static final int High;
    private static final int Low;
    private static final int Medium;
    private static final int None;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/FilterQuality$Companion;", "", "()V", "High", "Landroidx/compose/ui/graphics/FilterQuality;", "getHigh-f-v9h1I", "()I", "I", "Low", "getLow-f-v9h1I", "Medium", "getMedium-f-v9h1I", "None", "getNone-f-v9h1I", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getHigh-f-v9h1I() {
            return FilterQuality.access$getHigh$cp();
        }

        public final int getLow-f-v9h1I() {
            return FilterQuality.access$getLow$cp();
        }

        public final int getMedium-f-v9h1I() {
            return FilterQuality.access$getMedium$cp();
        }

        public final int getNone-f-v9h1I() {
            return FilterQuality.access$getNone$cp();
        }
    }
    static {
        FilterQuality.Companion companion = new FilterQuality.Companion(0);
        FilterQuality.Companion = companion;
        FilterQuality.None = FilterQuality.constructor-impl(0);
        FilterQuality.Low = FilterQuality.constructor-impl(1);
        FilterQuality.Medium = FilterQuality.constructor-impl(2);
        FilterQuality.High = FilterQuality.constructor-impl(3);
    }

    private FilterQuality(int value) {
        super();
        this.value = value;
    }

    public static final int access$getHigh$cp() {
        return FilterQuality.High;
    }

    public static final int access$getLow$cp() {
        return FilterQuality.Low;
    }

    public static final int access$getMedium$cp() {
        return FilterQuality.Medium;
    }

    public static final int access$getNone$cp() {
        return FilterQuality.None;
    }

    public static final androidx.compose.ui.graphics.FilterQuality box-impl(int i) {
        FilterQuality filterQuality = new FilterQuality(i);
        return filterQuality;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof FilterQuality) {
            return i3;
        }
        if (i != (FilterQuality)object2.unbox-impl()) {
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

    public static String toString-impl(int arg0) {
        String str;
        str = FilterQuality.equals-impl0(arg0, FilterQuality.None) ? "None" : equals-impl02 ? "Low" : equals-impl03 ? "Medium" : equals-impl04 ? "High" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return FilterQuality.equals-impl(this.value, object);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return FilterQuality.hashCode-impl(this.value);
    }

    public String toString() {
        return FilterQuality.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
