package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/focus/FocusDirection;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FocusDirection {

    public static final androidx.compose.ui.focus.FocusDirection.Companion Companion;
    private static final int Down;
    private static final int Enter;
    private static final int Exit;
    private static final int Left;
    private static final int Next;
    private static final int Previous;
    private static final int Right;
    private static final int Up;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0014\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R$\u0010\u0008\u001a\u00020\u00048GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\u0008\t\u0010\u0002\u001a\u0004\u0008\n\u0010\u0006R$\u0010\u000b\u001a\u00020\u00048GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0007\u0012\u0004\u0008\u000c\u0010\u0002\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0011\u0010\u0006R\u0019\u0010\u0012\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0013\u0010\u0006R\u0019\u0010\u0014\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0015\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0017\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0018", d2 = {"Landroidx/compose/ui/focus/FocusDirection$Companion;", "", "()V", "Down", "Landroidx/compose/ui/focus/FocusDirection;", "getDown-dhqQ-8s", "()I", "I", "Enter", "getEnter-dhqQ-8s$annotations", "getEnter-dhqQ-8s", "Exit", "getExit-dhqQ-8s$annotations", "getExit-dhqQ-8s", "Left", "getLeft-dhqQ-8s", "Next", "getNext-dhqQ-8s", "Previous", "getPrevious-dhqQ-8s", "Right", "getRight-dhqQ-8s", "Up", "getUp-dhqQ-8s", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getEnter-dhqQ-8s$annotations() {
        }

        public static void getExit-dhqQ-8s$annotations() {
        }

        public final int getDown-dhqQ-8s() {
            return FocusDirection.access$getDown$cp();
        }

        public final int getEnter-dhqQ-8s() {
            return FocusDirection.access$getEnter$cp();
        }

        public final int getExit-dhqQ-8s() {
            return FocusDirection.access$getExit$cp();
        }

        public final int getLeft-dhqQ-8s() {
            return FocusDirection.access$getLeft$cp();
        }

        public final int getNext-dhqQ-8s() {
            return FocusDirection.access$getNext$cp();
        }

        public final int getPrevious-dhqQ-8s() {
            return FocusDirection.access$getPrevious$cp();
        }

        public final int getRight-dhqQ-8s() {
            return FocusDirection.access$getRight$cp();
        }

        public final int getUp-dhqQ-8s() {
            return FocusDirection.access$getUp$cp();
        }
    }
    static {
        FocusDirection.Companion companion = new FocusDirection.Companion(0);
        FocusDirection.Companion = companion;
        FocusDirection.Next = FocusDirection.constructor-impl(1);
        FocusDirection.Previous = FocusDirection.constructor-impl(2);
        FocusDirection.Left = FocusDirection.constructor-impl(3);
        FocusDirection.Right = FocusDirection.constructor-impl(4);
        FocusDirection.Up = FocusDirection.constructor-impl(5);
        FocusDirection.Down = FocusDirection.constructor-impl(6);
        FocusDirection.Enter = FocusDirection.constructor-impl(7);
        FocusDirection.Exit = FocusDirection.constructor-impl(8);
    }

    private FocusDirection(int value) {
        super();
        this.value = value;
    }

    public static final int access$getDown$cp() {
        return FocusDirection.Down;
    }

    public static final int access$getEnter$cp() {
        return FocusDirection.Enter;
    }

    public static final int access$getExit$cp() {
        return FocusDirection.Exit;
    }

    public static final int access$getLeft$cp() {
        return FocusDirection.Left;
    }

    public static final int access$getNext$cp() {
        return FocusDirection.Next;
    }

    public static final int access$getPrevious$cp() {
        return FocusDirection.Previous;
    }

    public static final int access$getRight$cp() {
        return FocusDirection.Right;
    }

    public static final int access$getUp$cp() {
        return FocusDirection.Up;
    }

    public static final androidx.compose.ui.focus.FocusDirection box-impl(int i) {
        FocusDirection focusDirection = new FocusDirection(i);
        return focusDirection;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof FocusDirection) {
            return i3;
        }
        if (i != (FocusDirection)object2.unbox-impl()) {
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
        str = FocusDirection.equals-impl0(arg0, FocusDirection.Next) ? "Next" : equals-impl02 ? "Previous" : equals-impl03 ? "Left" : equals-impl04 ? "Right" : equals-impl05 ? "Up" : equals-impl06 ? "Down" : equals-impl07 ? "Enter" : equals-impl08 ? "Exit" : "Invalid FocusDirection";
        return str;
    }

    public boolean equals(Object object) {
        return FocusDirection.equals-impl(this.value, object);
    }

    public int hashCode() {
        return FocusDirection.hashCode-impl(this.value);
    }

    public String toString() {
        return FocusDirection.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
