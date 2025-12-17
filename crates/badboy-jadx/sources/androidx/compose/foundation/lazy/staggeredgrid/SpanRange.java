package androidx.compose.foundation.lazy.staggeredgrid;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0081@\u0018\u00002\u00020\u0001B\u0019\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\tJ\u001a\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0019\u0010\u000cJ\u0010\u0010\u001a\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0012\u0010\n\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u000cR\u0012\u0010\u0011\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u000c\u0088\u0001\u0007¨\u0006\u001e", d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "", "lane", "", "span", "constructor-impl", "(II)J", "packedValue", "", "(J)J", "end", "getEnd-impl", "(J)I", "getPackedValue", "()J", "size", "getSize-impl", "start", "getStart-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class SpanRange {

    private final long packedValue;
    private SpanRange(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final androidx.compose.foundation.lazy.staggeredgrid.SpanRange box-impl(long l) {
        SpanRange spanRange = new SpanRange(l, obj2);
        return spanRange;
    }

    public static long constructor-impl(int lane, int span) {
        return SpanRange.constructor-impl(i3 | i5);
    }

    private static long constructor-impl(long l) {
        return l;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof SpanRange) {
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

    public static final int getEnd-impl(long arg0) {
        final int i = 0;
        final int i2 = 0;
        return (int)i3;
    }

    public static final int getSize-impl(long arg0) {
        final int i = 0;
        int i2 = 0;
        final int i6 = 0;
        int $i$f$getEndImpl = 0;
        int i8 = 0;
        return value$iv$iv -= value$iv$iv2;
    }

    public static final int getStart-impl(long arg0) {
        final int i = 0;
        final int i3 = 0;
        return (int)i5;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SpanRange(packedValue=").append(l).append(')').toString();
    }

    public boolean equals(Object object) {
        return SpanRange.equals-impl(this.packedValue, obj1);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return SpanRange.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return SpanRange.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
