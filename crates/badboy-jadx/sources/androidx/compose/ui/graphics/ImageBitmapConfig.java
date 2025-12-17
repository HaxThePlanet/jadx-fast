package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0014", d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ImageBitmapConfig {

    private static final int Alpha8;
    private static final int Argb8888;
    public static final androidx.compose.ui.graphics.ImageBitmapConfig.Companion Companion;
    private static final int F16;
    private static final int Gpu;
    private static final int Rgb565;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0010", d2 = {"Landroidx/compose/ui/graphics/ImageBitmapConfig$Companion;", "", "()V", "Alpha8", "Landroidx/compose/ui/graphics/ImageBitmapConfig;", "getAlpha8-_sVssgQ", "()I", "I", "Argb8888", "getArgb8888-_sVssgQ", "F16", "getF16-_sVssgQ", "Gpu", "getGpu-_sVssgQ", "Rgb565", "getRgb565-_sVssgQ", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getAlpha8-_sVssgQ() {
            return ImageBitmapConfig.access$getAlpha8$cp();
        }

        public final int getArgb8888-_sVssgQ() {
            return ImageBitmapConfig.access$getArgb8888$cp();
        }

        public final int getF16-_sVssgQ() {
            return ImageBitmapConfig.access$getF16$cp();
        }

        public final int getGpu-_sVssgQ() {
            return ImageBitmapConfig.access$getGpu$cp();
        }

        public final int getRgb565-_sVssgQ() {
            return ImageBitmapConfig.access$getRgb565$cp();
        }
    }
    static {
        ImageBitmapConfig.Companion companion = new ImageBitmapConfig.Companion(0);
        ImageBitmapConfig.Companion = companion;
        ImageBitmapConfig.Argb8888 = ImageBitmapConfig.constructor-impl(0);
        ImageBitmapConfig.Alpha8 = ImageBitmapConfig.constructor-impl(1);
        ImageBitmapConfig.Rgb565 = ImageBitmapConfig.constructor-impl(2);
        ImageBitmapConfig.F16 = ImageBitmapConfig.constructor-impl(3);
        ImageBitmapConfig.Gpu = ImageBitmapConfig.constructor-impl(4);
    }

    private ImageBitmapConfig(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAlpha8$cp() {
        return ImageBitmapConfig.Alpha8;
    }

    public static final int access$getArgb8888$cp() {
        return ImageBitmapConfig.Argb8888;
    }

    public static final int access$getF16$cp() {
        return ImageBitmapConfig.F16;
    }

    public static final int access$getGpu$cp() {
        return ImageBitmapConfig.Gpu;
    }

    public static final int access$getRgb565$cp() {
        return ImageBitmapConfig.Rgb565;
    }

    public static final androidx.compose.ui.graphics.ImageBitmapConfig box-impl(int i) {
        ImageBitmapConfig imageBitmapConfig = new ImageBitmapConfig(i);
        return imageBitmapConfig;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof ImageBitmapConfig) {
            return i3;
        }
        if (i != (ImageBitmapConfig)object2.unbox-impl()) {
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
        str = ImageBitmapConfig.equals-impl0(arg0, ImageBitmapConfig.Argb8888) ? "Argb8888" : equals-impl02 ? "Alpha8" : equals-impl03 ? "Rgb565" : equals-impl04 ? "F16" : equals-impl05 ? "Gpu" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return ImageBitmapConfig.equals-impl(this.value, object);
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return ImageBitmapConfig.hashCode-impl(this.value);
    }

    public String toString() {
        return ImageBitmapConfig.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
