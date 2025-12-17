package androidx.compose.ui.input.pointer;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class PointerEventType {

    public static final androidx.compose.ui.input.pointer.PointerEventType.Companion Companion;
    private static final int Enter;
    private static final int Exit;
    private static final int Move;
    private static final int Press;
    private static final int Release;
    private static final int Scroll;
    private static final int Unknown;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0014", d2 = {"Landroidx/compose/ui/input/pointer/PointerEventType$Companion;", "", "()V", "Enter", "Landroidx/compose/ui/input/pointer/PointerEventType;", "getEnter-7fucELk", "()I", "I", "Exit", "getExit-7fucELk", "Move", "getMove-7fucELk", "Press", "getPress-7fucELk", "Release", "getRelease-7fucELk", "Scroll", "getScroll-7fucELk", "Unknown", "getUnknown-7fucELk", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getEnter-7fucELk() {
            return PointerEventType.access$getEnter$cp();
        }

        public final int getExit-7fucELk() {
            return PointerEventType.access$getExit$cp();
        }

        public final int getMove-7fucELk() {
            return PointerEventType.access$getMove$cp();
        }

        public final int getPress-7fucELk() {
            return PointerEventType.access$getPress$cp();
        }

        public final int getRelease-7fucELk() {
            return PointerEventType.access$getRelease$cp();
        }

        public final int getScroll-7fucELk() {
            return PointerEventType.access$getScroll$cp();
        }

        public final int getUnknown-7fucELk() {
            return PointerEventType.access$getUnknown$cp();
        }
    }
    static {
        PointerEventType.Companion companion = new PointerEventType.Companion(0);
        PointerEventType.Companion = companion;
        PointerEventType.Unknown = PointerEventType.constructor-impl(0);
        PointerEventType.Press = PointerEventType.constructor-impl(1);
        PointerEventType.Release = PointerEventType.constructor-impl(2);
        PointerEventType.Move = PointerEventType.constructor-impl(3);
        PointerEventType.Enter = PointerEventType.constructor-impl(4);
        PointerEventType.Exit = PointerEventType.constructor-impl(5);
        PointerEventType.Scroll = PointerEventType.constructor-impl(6);
    }

    private PointerEventType(int value) {
        super();
        this.value = value;
    }

    public static final int access$getEnter$cp() {
        return PointerEventType.Enter;
    }

    public static final int access$getExit$cp() {
        return PointerEventType.Exit;
    }

    public static final int access$getMove$cp() {
        return PointerEventType.Move;
    }

    public static final int access$getPress$cp() {
        return PointerEventType.Press;
    }

    public static final int access$getRelease$cp() {
        return PointerEventType.Release;
    }

    public static final int access$getScroll$cp() {
        return PointerEventType.Scroll;
    }

    public static final int access$getUnknown$cp() {
        return PointerEventType.Unknown;
    }

    public static final androidx.compose.ui.input.pointer.PointerEventType box-impl(int i) {
        PointerEventType pointerEventType = new PointerEventType(i);
        return pointerEventType;
    }

    private static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof PointerEventType) {
            return i3;
        }
        if (i != (PointerEventType)object2.unbox-impl()) {
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
        str = PointerEventType.equals-impl0(arg0, PointerEventType.Press) ? "Press" : equals-impl02 ? "Release" : equals-impl03 ? "Move" : equals-impl04 ? "Enter" : equals-impl05 ? "Exit" : equals-impl06 ? "Scroll" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return PointerEventType.equals-impl(this.value, object);
    }

    public int hashCode() {
        return PointerEventType.hashCode-impl(this.value);
    }

    public String toString() {
        return PointerEventType.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
