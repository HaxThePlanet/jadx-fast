package androidx.compose.ui.graphics.colorspace;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class RenderIntent {

    private static final int Absolute;
    public static final androidx.compose.ui.graphics.colorspace.RenderIntent.Companion Companion;
    private static final int Perceptual;
    private static final int Relative;
    private static final int Saturation;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/colorspace/RenderIntent$Companion;", "", "()V", "Absolute", "Landroidx/compose/ui/graphics/colorspace/RenderIntent;", "getAbsolute-uksYyKA", "()I", "I", "Perceptual", "getPerceptual-uksYyKA", "Relative", "getRelative-uksYyKA", "Saturation", "getSaturation-uksYyKA", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getAbsolute-uksYyKA() {
            return RenderIntent.access$getAbsolute$cp();
        }

        public final int getPerceptual-uksYyKA() {
            return RenderIntent.access$getPerceptual$cp();
        }

        public final int getRelative-uksYyKA() {
            return RenderIntent.access$getRelative$cp();
        }

        public final int getSaturation-uksYyKA() {
            return RenderIntent.access$getSaturation$cp();
        }
    }
    static {
        RenderIntent.Companion companion = new RenderIntent.Companion(0);
        RenderIntent.Companion = companion;
        RenderIntent.Perceptual = RenderIntent.constructor-impl(0);
        RenderIntent.Relative = RenderIntent.constructor-impl(1);
        RenderIntent.Saturation = RenderIntent.constructor-impl(2);
        RenderIntent.Absolute = RenderIntent.constructor-impl(3);
    }

    private RenderIntent(int value) {
        super();
        this.value = value;
    }

    public static final int access$getAbsolute$cp() {
        return RenderIntent.Absolute;
    }

    public static final int access$getPerceptual$cp() {
        return RenderIntent.Perceptual;
    }

    public static final int access$getRelative$cp() {
        return RenderIntent.Relative;
    }

    public static final int access$getSaturation$cp() {
        return RenderIntent.Saturation;
    }

    public static final androidx.compose.ui.graphics.colorspace.RenderIntent box-impl(int i) {
        RenderIntent renderIntent = new RenderIntent(i);
        return renderIntent;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (object2 instanceof RenderIntent == null) {
            return i3;
        }
        if (i != (RenderIntent)object2.unbox-impl()) {
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
        str = RenderIntent.equals-impl0(arg0, RenderIntent.Perceptual) ? "Perceptual" : equals-impl02 ? "Relative" : equals-impl03 ? "Saturation" : equals-impl04 ? "Absolute" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return RenderIntent.equals-impl(this.value, object);
    }

    public int hashCode() {
        return RenderIntent.hashCode-impl(this.value);
    }

    public String toString() {
        return RenderIntent.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
