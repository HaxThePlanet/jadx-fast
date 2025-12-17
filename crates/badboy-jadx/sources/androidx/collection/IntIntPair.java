package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u0019\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006B\u0011\u0008\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0004\u0008\u0005\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\u0008\u0010\u0010\u000bJ\u0010\u0010\u0011\u001a\u00020\u0003H\u0086\n¢\u0006\u0004\u0008\u0012\u0010\u000bJ\u001a\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u0019\u0010\u000bJ\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\u0008\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\u00088\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0004\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000b\u0088\u0001\u0007\u0092\u0001\u00020\u0008¨\u0006\u001e", d2 = {"Landroidx/collection/IntIntPair;", "", "first", "", "second", "constructor-impl", "(II)J", "packedValue", "", "(J)J", "getFirst-impl", "(J)I", "getPackedValue$annotations", "()V", "getSecond-impl", "component1", "component1-impl", "component2", "component2-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class IntIntPair {

    public final long packedValue;
    private IntIntPair(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final androidx.collection.IntIntPair box-impl(long l) {
        IntIntPair intIntPair = new IntIntPair(l, obj2);
        return intIntPair;
    }

    public static final int component1-impl(long arg0) {
        final int i = 0;
        return (int)i3;
    }

    public static final int component2-impl(long arg0) {
        final int i = 0;
        return (int)i2;
    }

    public static long constructor-impl(int first, int second) {
        int i = 0;
        l <<= i3;
        return IntIntPair.constructor-impl(i2 | i4);
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof IntIntPair) {
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

    public static final int getFirst-impl(long arg0) {
        return (int)i2;
    }

    public static void getPackedValue$annotations() {
    }

    public static final int getSecond-impl(long arg0) {
        return (int)i;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long arg0) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append('(').append(IntIntPair.getFirst-impl(arg0)).append(", ").append(IntIntPair.getSecond-impl(arg0)).append(')').toString();
    }

    public boolean equals(Object object) {
        return IntIntPair.equals-impl(this.packedValue, obj1);
    }

    public int hashCode() {
        return IntIntPair.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return IntIntPair.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
