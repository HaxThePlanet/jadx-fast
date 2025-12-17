package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/graphics/TileMode;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class TileMode {

    private static final int Clamp;
    public static final androidx.compose.ui.graphics.TileMode.Companion Companion;
    private static final int Decal;
    private static final int Mirror;
    private static final int Repeated;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000e", d2 = {"Landroidx/compose/ui/graphics/TileMode$Companion;", "", "()V", "Clamp", "Landroidx/compose/ui/graphics/TileMode;", "getClamp-3opZhB0", "()I", "I", "Decal", "getDecal-3opZhB0", "Mirror", "getMirror-3opZhB0", "Repeated", "getRepeated-3opZhB0", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getClamp-3opZhB0() {
            return TileMode.access$getClamp$cp();
        }

        public final int getDecal-3opZhB0() {
            return TileMode.access$getDecal$cp();
        }

        public final int getMirror-3opZhB0() {
            return TileMode.access$getMirror$cp();
        }

        public final int getRepeated-3opZhB0() {
            return TileMode.access$getRepeated$cp();
        }
    }
    static {
        TileMode.Companion companion = new TileMode.Companion(0);
        TileMode.Companion = companion;
        TileMode.Clamp = TileMode.constructor-impl(0);
        TileMode.Repeated = TileMode.constructor-impl(1);
        TileMode.Mirror = TileMode.constructor-impl(2);
        TileMode.Decal = TileMode.constructor-impl(3);
    }

    private TileMode(int value) {
        super();
        this.value = value;
    }

    public static final int access$getClamp$cp() {
        return TileMode.Clamp;
    }

    public static final int access$getDecal$cp() {
        return TileMode.Decal;
    }

    public static final int access$getMirror$cp() {
        return TileMode.Mirror;
    }

    public static final int access$getRepeated$cp() {
        return TileMode.Repeated;
    }

    public static final androidx.compose.ui.graphics.TileMode box-impl(int i) {
        TileMode tileMode = new TileMode(i);
        return tileMode;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof TileMode) {
            return i3;
        }
        if (i != (TileMode)object2.unbox-impl()) {
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
        str = TileMode.equals-impl0(arg0, TileMode.Clamp) ? "Clamp" : equals-impl02 ? "Repeated" : equals-impl03 ? "Mirror" : equals-impl04 ? "Decal" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return TileMode.equals-impl(this.value, object);
    }

    public int hashCode() {
        return TileMode.hashCode-impl(this.value);
    }

    public String toString() {
        return TileMode.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
