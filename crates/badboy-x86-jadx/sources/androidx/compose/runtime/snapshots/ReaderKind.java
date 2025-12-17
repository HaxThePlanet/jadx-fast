package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0007\u0008\u0081@\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u001b\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/snapshots/ReaderKind;", "", "mask", "", "constructor-impl", "(I)I", "getMask", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "isReadIn", "reader", "isReadIn-h_f27i8", "(II)Z", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "withReadIn", "withReadIn-3QSx2Dw", "(II)I", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ReaderKind {

    public static final androidx.compose.runtime.snapshots.ReaderKind.Companion Companion;
    private final int mask;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006R\u0018\u0010\t\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/snapshots/ReaderKind$Companion;", "", "()V", "Composition", "Landroidx/compose/runtime/snapshots/ReaderKind;", "getComposition-6f8NoZ8", "()I", "SnapshotFlow", "getSnapshotFlow-6f8NoZ8", "SnapshotStateObserver", "getSnapshotStateObserver-6f8NoZ8", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final int getComposition-6f8NoZ8() {
            final int i = 0;
            return ReaderKind.constructor-impl(1);
        }

        public final int getSnapshotFlow-6f8NoZ8() {
            final int i = 0;
            return ReaderKind.constructor-impl(4);
        }

        public final int getSnapshotStateObserver-6f8NoZ8() {
            final int i = 0;
            return ReaderKind.constructor-impl(2);
        }
    }
    static {
        ReaderKind.Companion companion = new ReaderKind.Companion(0);
        ReaderKind.Companion = companion;
    }

    private ReaderKind(int mask) {
        super();
        this.mask = mask;
    }

    public static final androidx.compose.runtime.snapshots.ReaderKind box-impl(int i) {
        ReaderKind readerKind = new ReaderKind(i);
        return readerKind;
    }

    public static int constructor-impl(int i) {
        return i;
    }

    public static int constructor-impl$default(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return ReaderKind.constructor-impl(obj0);
    }

    public static boolean equals-impl(int i, Object object2) {
        final int i3 = 0;
        if (!object2 instanceof ReaderKind) {
            return i3;
        }
        if (i != (ReaderKind)object2.unbox-impl()) {
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

    public static final boolean isReadIn-h_f27i8(int arg0, int reader) {
        int i;
        final int i2 = 0;
        i = arg0 & reader != 0 ? 1 : 0;
        return i;
    }

    public static String toString-impl(int i) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ReaderKind(mask=").append(i).append(')').toString();
    }

    public static final int withReadIn-3QSx2Dw(int arg0, int reader) {
        final int i = 0;
        return ReaderKind.constructor-impl(arg0 | reader);
    }

    public boolean equals(Object object) {
        return ReaderKind.equals-impl(this.mask, object);
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return ReaderKind.hashCode-impl(this.mask);
    }

    public String toString() {
        return ReaderKind.toString-impl(this.mask);
    }

    public final int unbox-impl() {
        return this.mask;
    }
}
