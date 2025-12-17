package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0014H\u0016¢\u0006\u0004\u0008\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u00020\u00078GX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0018", d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel;", "", "packedValue", "", "constructor-impl", "(J)J", "componentCount", "", "getComponentCount$annotations", "()V", "getComponentCount-impl", "(J)I", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ColorModel {

    private static final long Cmyk;
    public static final androidx.compose.ui.graphics.colorspace.ColorModel.Companion Companion;
    private static final long Lab;
    private static final long Rgb;
    private static final long Xyz;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/colorspace/ColorModel$Companion;", "", "()V", "Cmyk", "Landroidx/compose/ui/graphics/colorspace/ColorModel;", "getCmyk-xdoWZVw", "()J", "J", "Lab", "getLab-xdoWZVw", "Rgb", "getRgb-xdoWZVw", "Xyz", "getXyz-xdoWZVw", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final long getCmyk-xdoWZVw() {
            return ColorModel.access$getCmyk$cp();
        }

        public final long getLab-xdoWZVw() {
            return ColorModel.access$getLab$cp();
        }

        public final long getRgb-xdoWZVw() {
            return ColorModel.access$getRgb$cp();
        }

        public final long getXyz-xdoWZVw() {
            return ColorModel.access$getXyz$cp();
        }
    }
    static {
        ColorModel.Companion companion = new ColorModel.Companion(0);
        ColorModel.Companion = companion;
        int i6 = 0;
        int i10 = 0;
        int i18 = 32;
        final long l9 = 4294967295L;
        ColorModel.Rgb = ColorModel.constructor-impl(i14 | i20);
        int i7 = 1;
        int i11 = 0;
        ColorModel.Xyz = ColorModel.constructor-impl(i15 | i21);
        int i8 = 2;
        int i12 = 0;
        ColorModel.Lab = ColorModel.constructor-impl(i16 | i22);
        int i9 = 3;
        int i13 = 0;
        ColorModel.Cmyk = ColorModel.constructor-impl(i17 | i19);
    }

    private ColorModel(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getCmyk$cp() {
        return ColorModel.Cmyk;
    }

    public static final long access$getLab$cp() {
        return ColorModel.Lab;
    }

    public static final long access$getRgb$cp() {
        return ColorModel.Rgb;
    }

    public static final long access$getXyz$cp() {
        return ColorModel.Xyz;
    }

    public static final androidx.compose.ui.graphics.colorspace.ColorModel box-impl(long l) {
        ColorModel colorModel = new ColorModel(l, obj2);
        return colorModel;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof ColorModel) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        int i;
        i = Long.compare(l, obj3) == 0 ? 1 : 0;
        return i;
    }

    public static void getComponentCount$annotations() {
    }

    public static final int getComponentCount-impl(long arg0) {
        final int i2 = 0;
        return (int)i4;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long arg0) {
        String str;
        str = ColorModel.equals-impl0(arg0, obj3) ? "Rgb" : equals-impl02 ? "Xyz" : equals-impl03 ? "Lab" : equals-impl04 ? "Cmyk" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return ColorModel.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return ColorModel.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return ColorModel.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
