package androidx.compose.ui.hapticfeedback;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class HapticFeedbackType {

    public static final androidx.compose.ui.hapticfeedback.HapticFeedbackType.Companion Companion;
    private final int value;

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00040\nR\u0017\u0010\u0003\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00048Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000b", d2 = {"Landroidx/compose/ui/hapticfeedback/HapticFeedbackType$Companion;", "", "()V", "LongPress", "Landroidx/compose/ui/hapticfeedback/HapticFeedbackType;", "getLongPress-5zf0vsI", "()I", "TextHandleMove", "getTextHandleMove-5zf0vsI", "values", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getLongPress-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getLongPress-5zf0vsI();
        }

        public final int getTextHandleMove-5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.getTextHandleMove-5zf0vsI();
        }

        public final List<androidx.compose.ui.hapticfeedback.HapticFeedbackType> values() {
            androidx.compose.ui.hapticfeedback.HapticFeedbackType[] arr = new HapticFeedbackType[2];
            return CollectionsKt.listOf(HapticFeedbackType.box-impl(getLongPress-5zf0vsI()), HapticFeedbackType.box-impl(getTextHandleMove-5zf0vsI()));
        }
    }
    static {
        HapticFeedbackType.Companion companion = new HapticFeedbackType.Companion(0);
        HapticFeedbackType.Companion = companion;
    }

    private HapticFeedbackType(int value) {
        super();
        this.value = value;
    }

    public static final androidx.compose.ui.hapticfeedback.HapticFeedbackType box-impl(int i) {
        HapticFeedbackType hapticFeedbackType = new HapticFeedbackType(i);
        return hapticFeedbackType;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof HapticFeedbackType) {
            return i3;
        }
        if (i != (HapticFeedbackType)object2.unbox-impl()) {
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
        str = HapticFeedbackType.equals-impl0(arg0, HapticFeedbackType.Companion.getLongPress-5zf0vsI()) ? "LongPress" : equals-impl02 ? "TextHandleMove" : "Invalid";
        return str;
    }

    public boolean equals(Object object) {
        return HapticFeedbackType.equals-impl(this.value, object);
    }

    public int hashCode() {
        return HapticFeedbackType.hashCode-impl(this.value);
    }

    public String toString() {
        return HapticFeedbackType.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
