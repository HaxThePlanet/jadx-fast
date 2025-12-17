package androidx.compose.ui.graphics;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0011\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000c\u0010\u0005J\u000f\u0010\r\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0012", d2 = {"Landroidx/compose/ui/graphics/PathOperation;", "", "value", "", "constructor-impl", "(I)I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "Companion", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class PathOperation {

    public static final androidx.compose.ui.graphics.PathOperation.Companion Companion;
    private static final int Difference;
    private static final int Intersect;
    private static final int ReverseDifference;
    private static final int Union;
    private static final int Xor;
    private final int value;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\t\u0010\u0006R\u0019\u0010\n\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0006R\u0019\u0010\u000c\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\r\u0010\u0006R\u0019\u0010\u000e\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0010", d2 = {"Landroidx/compose/ui/graphics/PathOperation$Companion;", "", "()V", "Difference", "Landroidx/compose/ui/graphics/PathOperation;", "getDifference-b3I0S0c", "()I", "I", "Intersect", "getIntersect-b3I0S0c", "ReverseDifference", "getReverseDifference-b3I0S0c", "Union", "getUnion-b3I0S0c", "Xor", "getXor-b3I0S0c", "ui-graphics_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getDifference-b3I0S0c() {
            return PathOperation.access$getDifference$cp();
        }

        public final int getIntersect-b3I0S0c() {
            return PathOperation.access$getIntersect$cp();
        }

        public final int getReverseDifference-b3I0S0c() {
            return PathOperation.access$getReverseDifference$cp();
        }

        public final int getUnion-b3I0S0c() {
            return PathOperation.access$getUnion$cp();
        }

        public final int getXor-b3I0S0c() {
            return PathOperation.access$getXor$cp();
        }
    }
    static {
        PathOperation.Companion companion = new PathOperation.Companion(0);
        PathOperation.Companion = companion;
        PathOperation.Difference = PathOperation.constructor-impl(0);
        PathOperation.Intersect = PathOperation.constructor-impl(1);
        PathOperation.Union = PathOperation.constructor-impl(2);
        PathOperation.Xor = PathOperation.constructor-impl(3);
        PathOperation.ReverseDifference = PathOperation.constructor-impl(4);
    }

    private PathOperation(int value) {
        super();
        this.value = value;
    }

    public static final int access$getDifference$cp() {
        return PathOperation.Difference;
    }

    public static final int access$getIntersect$cp() {
        return PathOperation.Intersect;
    }

    public static final int access$getReverseDifference$cp() {
        return PathOperation.ReverseDifference;
    }

    public static final int access$getUnion$cp() {
        return PathOperation.Union;
    }

    public static final int access$getXor$cp() {
        return PathOperation.Xor;
    }

    public static final androidx.compose.ui.graphics.PathOperation box-impl(int i) {
        PathOperation pathOperation = new PathOperation(i);
        return pathOperation;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof PathOperation) {
            return i3;
        }
        if (i != (PathOperation)object2.unbox-impl()) {
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
        str = PathOperation.equals-impl0(arg0, PathOperation.Difference) ? "Difference" : equals-impl02 ? "Intersect" : equals-impl03 ? "Union" : equals-impl04 ? "Xor" : equals-impl05 ? "ReverseDifference" : "Unknown";
        return str;
    }

    public boolean equals(Object object) {
        return PathOperation.equals-impl(this.value, object);
    }

    public int hashCode() {
        return PathOperation.hashCode-impl(this.value);
    }

    public String toString() {
        return PathOperation.toString-impl(this.value);
    }

    public final int unbox-impl() {
        return this.value;
    }
}
