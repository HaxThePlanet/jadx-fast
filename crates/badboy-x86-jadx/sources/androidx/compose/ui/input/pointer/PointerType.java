package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/input/pointer/PointerType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class PointerType {

    public static final androidx.compose.ui.input.pointer.PointerType.Companion Companion;
    private static final int Eraser;
    private static final int Mouse;
    private static final int Stylus;
    private static final int Touch;
    private static final int Unknown;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0010", d2 = {"Landroidx/compose/ui/input/pointer/PointerType$Companion;", "", "()V", "Eraser", "Landroidx/compose/ui/input/pointer/PointerType;", "getEraser-T8wyACA", "()I", "I", "Mouse", "getMouse-T8wyACA", "Stylus", "getStylus-T8wyACA", "Touch", "getTouch-T8wyACA", "Unknown", "getUnknown-T8wyACA", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getEraser-T8wyACA() {
            return PointerType.access$getEraser$cp();
        }

        public final int getMouse-T8wyACA() {
            return PointerType.access$getMouse$cp();
        }

        public final int getStylus-T8wyACA() {
            return PointerType.access$getStylus$cp();
        }

        public final int getTouch-T8wyACA() {
            return PointerType.access$getTouch$cp();
        }

        public final int getUnknown-T8wyACA() {
            return PointerType.access$getUnknown$cp();
        }
    }
    static {
        PointerType.Companion companion = new PointerType.Companion(0);
        PointerType.Companion = companion;
        PointerType.Unknown = PointerType.constructor-impl(0);
        PointerType.Touch = PointerType.constructor-impl(1);
        PointerType.Mouse = PointerType.constructor-impl(2);
        PointerType.Stylus = PointerType.constructor-impl(3);
        PointerType.Eraser = PointerType.constructor-impl(4);
    }

    private PointerType(int value) {
        super();
        this.value = value;
    }

    public static final int access$getEraser$cp() {
        return PointerType.Eraser;
    }

    public static final int access$getMouse$cp() {
        return PointerType.Mouse;
    }

    public static final int access$getStylus$cp() {
        return PointerType.Stylus;
    }

    public static final int access$getTouch$cp() {
        return PointerType.Touch;
    }

    public static final int access$getUnknown$cp() {
        return PointerType.Unknown;
    }

    public static final androidx.compose.ui.input.pointer.PointerType box-impl(int i) {
        PointerType pointerType = new PointerType(i);
        return pointerType;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof PointerType) {
            return i3;
        }
        if (i != (PointerType)object2.unbox-impl()) {
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
        switch (arg0) {
            case 1:
                str = "Touch";
                break;
            case 2:
                str = "Mouse";
                break;
            case 3:
                str = "Stylus";
                break;
            case 4:
                str = "Eraser";
                break;
            default:
                str = "Unknown";
        }
        return str;
    }

    public boolean equals(Object object) {
        return PointerType.equals-impl(this.value, object);
    }

    public int hashCode() {
        return PointerType.hashCode-impl(this.value);
    }

    public String toString() {
        return PointerType.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
