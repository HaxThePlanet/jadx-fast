package androidx.compose.foundation.gestures.snapping;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0081@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class FinalSnappingItem {

    private static final int ClosestItem;
    public static final androidx.compose.foundation.gestures.snapping.FinalSnappingItem.Companion Companion;
    private static final int NextItem;
    private static final int PreviousItem;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000c", d2 = {"Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem$Companion;", "", "()V", "ClosestItem", "Landroidx/compose/foundation/gestures/snapping/FinalSnappingItem;", "getClosestItem-bbeMdSM", "()I", "I", "NextItem", "getNextItem-bbeMdSM", "PreviousItem", "getPreviousItem-bbeMdSM", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getClosestItem-bbeMdSM() {
            return FinalSnappingItem.access$getClosestItem$cp();
        }

        public final int getNextItem-bbeMdSM() {
            return FinalSnappingItem.access$getNextItem$cp();
        }

        public final int getPreviousItem-bbeMdSM() {
            return FinalSnappingItem.access$getPreviousItem$cp();
        }
    }
    static {
        FinalSnappingItem.Companion companion = new FinalSnappingItem.Companion(0);
        FinalSnappingItem.Companion = companion;
        FinalSnappingItem.ClosestItem = FinalSnappingItem.constructor-impl(0);
        FinalSnappingItem.NextItem = FinalSnappingItem.constructor-impl(1);
        FinalSnappingItem.PreviousItem = FinalSnappingItem.constructor-impl(2);
    }

    private FinalSnappingItem(int value) {
        super();
        this.value = value;
    }

    public static final int access$getClosestItem$cp() {
        return FinalSnappingItem.ClosestItem;
    }

    public static final int access$getNextItem$cp() {
        return FinalSnappingItem.NextItem;
    }

    public static final int access$getPreviousItem$cp() {
        return FinalSnappingItem.PreviousItem;
    }

    public static final androidx.compose.foundation.gestures.snapping.FinalSnappingItem box-impl(int i) {
        FinalSnappingItem finalSnappingItem = new FinalSnappingItem(i);
        return finalSnappingItem;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof FinalSnappingItem) {
            return i3;
        }
        if (i != (FinalSnappingItem)object2.unbox-impl()) {
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

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FinalSnappingItem(value=").append(i).append(')').toString();
    }

    public boolean equals(Object object) {
        return FinalSnappingItem.equals-impl(this.value, object);
    }

    public int hashCode() {
        return FinalSnappingItem.hashCode-impl(this.value);
    }

    public String toString() {
        return FinalSnappingItem.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
