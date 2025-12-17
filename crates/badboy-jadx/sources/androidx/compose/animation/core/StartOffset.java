package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u001b\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007B\u0011\u0008\u0002\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\u0006\u0010\nJ\u001a\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0014\u0010\u000cJ\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0017\u0010\u0004\u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000cR\u000e\u0010\u0008\u001a\u00020\tX\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0008\u0092\u0001\u00020\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/animation/core/StartOffset;", "", "offsetMillis", "", "offsetType", "Landroidx/compose/animation/core/StartOffsetType;", "constructor-impl", "(II)J", "value", "", "(J)J", "getOffsetMillis-impl", "(J)I", "getOffsetType-Eo1U57Q", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class StartOffset {

    private final long value;
    private StartOffset(long value) {
        super();
        this.value = value;
    }

    public static final androidx.compose.animation.core.StartOffset box-impl(long l) {
        StartOffset startOffset = new StartOffset(l, obj2);
        return startOffset;
    }

    public static long constructor-impl(int offsetMillis, int offsetType) {
        return StartOffset.constructor-impl((long)i);
    }

    private static long constructor-impl(long l) {
        return l;
    }

    public static long constructor-impl$default(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = StartOffsetType.Companion.getDelay-Eo1U57Q();
        }
        return StartOffset.constructor-impl(i, obj1);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (obj6 instanceof StartOffset == null) {
            return i2;
        }
        if (Long.compare(l, unbox-impl) != 0) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        int i;
        i = Long.compare(l, obj3) == 0 ? 1 : 0;
        return i;
    }

    public static final int getOffsetMillis-impl(long arg0) {
        return Math.abs((int)arg0);
    }

    public static final int getOffsetType-Eo1U57Q(long arg0) {
        int i;
        int fastForward-Eo1U57Q;
        final int i3 = 1;
        i = Long.compare(arg0, i2) > 0 ? i3 : 0;
        if (i == i3) {
            fastForward-Eo1U57Q = StartOffsetType.Companion.getFastForward-Eo1U57Q();
            return fastForward-Eo1U57Q;
        } else {
            if (i != 0) {
            } else {
                fastForward-Eo1U57Q = StartOffsetType.Companion.getDelay-Eo1U57Q();
            }
        }
        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
        throw noWhenBranchMatchedException;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("StartOffset(value=").append(l).append(')').toString();
    }

    public boolean equals(Object object) {
        return StartOffset.equals-impl(this.value, obj1);
    }

    public int hashCode() {
        return StartOffset.hashCode-impl(this.value);
    }

    public String toString() {
        return StartOffset.toString-impl(this.value);
    }

    public final long unbox-impl() {
        return this.value;
    }
}
