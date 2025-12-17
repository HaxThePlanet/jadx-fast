package androidx.compose.ui.input.nestedscroll;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class NestedScrollSource {

    public static final androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion Companion;
    private static final int Drag;
    private static final int Fling;
    private static final int Relocate;
    private static final int SideEffect;
    private static final int UserInput;
    private static final int Wheel;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0012\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007R$\u0010\t\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\n\u0010\u0002\u001a\u0004\u0008\u000b\u0010\u0007R$\u0010\u000c\u001a\u00020\u00048GX\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\r\u0010\u0002\u001a\u0004\u0008\u000e\u0010\u0007R\u0019\u0010\u000f\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0010\u0010\u0007R\u0019\u0010\u0011\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0012\u0010\u0007R$\u0010\u0013\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0014\u0010\u0002\u001a\u0004\u0008\u0015\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollSource$Companion;", "", "()V", "Drag", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "getDrag-WNlRxjI$annotations", "getDrag-WNlRxjI", "()I", "I", "Fling", "getFling-WNlRxjI$annotations", "getFling-WNlRxjI", "Relocate", "getRelocate-WNlRxjI$annotations", "getRelocate-WNlRxjI", "SideEffect", "getSideEffect-WNlRxjI", "UserInput", "getUserInput-WNlRxjI", "Wheel", "getWheel-WNlRxjI$annotations", "getWheel-WNlRxjI", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        @Deprecated(message = "This has been replaced by UserInput.", replaceWith = @ReplaceWith(...))
        public static void getDrag-WNlRxjI$annotations() {
        }

        @Deprecated(message = "This has been replaced by SideEffect.", replaceWith = @ReplaceWith(...))
        public static void getFling-WNlRxjI$annotations() {
        }

        @Deprecated(message = "Do not use. Will be removed in the future.")
        public static void getRelocate-WNlRxjI$annotations() {
        }

        @Deprecated(message = "This has been replaced by UserInput.", replaceWith = @ReplaceWith(...))
        public static void getWheel-WNlRxjI$annotations() {
        }

        public final int getDrag-WNlRxjI() {
            return NestedScrollSource.access$getDrag$cp();
        }

        public final int getFling-WNlRxjI() {
            return NestedScrollSource.access$getFling$cp();
        }

        public final int getRelocate-WNlRxjI() {
            return NestedScrollSource.access$getRelocate$cp();
        }

        public final int getSideEffect-WNlRxjI() {
            return NestedScrollSource.access$getSideEffect$cp();
        }

        public final int getUserInput-WNlRxjI() {
            return NestedScrollSource.access$getUserInput$cp();
        }

        public final int getWheel-WNlRxjI() {
            return NestedScrollSource.access$getWheel$cp();
        }
    }
    static {
        NestedScrollSource.Companion companion = new NestedScrollSource.Companion(0);
        NestedScrollSource.Companion = companion;
        NestedScrollSource.UserInput = NestedScrollSource.constructor-impl(1);
        NestedScrollSource.SideEffect = NestedScrollSource.constructor-impl(2);
        NestedScrollSource.Drag = NestedScrollSource.UserInput;
        NestedScrollSource.Fling = NestedScrollSource.SideEffect;
        NestedScrollSource.Relocate = NestedScrollSource.constructor-impl(3);
        NestedScrollSource.Wheel = NestedScrollSource.UserInput;
    }

    private NestedScrollSource(int value) {
        super();
        this.value = value;
    }

    public static final int access$getDrag$cp() {
        return NestedScrollSource.Drag;
    }

    public static final int access$getFling$cp() {
        return NestedScrollSource.Fling;
    }

    public static final int access$getRelocate$cp() {
        return NestedScrollSource.Relocate;
    }

    public static final int access$getSideEffect$cp() {
        return NestedScrollSource.SideEffect;
    }

    public static final int access$getUserInput$cp() {
        return NestedScrollSource.UserInput;
    }

    public static final int access$getWheel$cp() {
        return NestedScrollSource.Wheel;
    }

    public static final androidx.compose.ui.input.nestedscroll.NestedScrollSource box-impl(int i) {
        NestedScrollSource nestedScrollSource = new NestedScrollSource(i);
        return nestedScrollSource;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof NestedScrollSource) {
            return i3;
        }
        if (i != (NestedScrollSource)object2.unbox-impl()) {
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
        str = NestedScrollSource.equals-impl0(arg0, NestedScrollSource.UserInput) ? "UserInput" : equals-impl02 ? "SideEffect" : equals-impl03 ? "Relocate" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return NestedScrollSource.equals-impl(this.value, object);
    }

    public int hashCode() {
        return NestedScrollSource.hashCode-impl(this.value);
    }

    public String toString() {
        return NestedScrollSource.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
