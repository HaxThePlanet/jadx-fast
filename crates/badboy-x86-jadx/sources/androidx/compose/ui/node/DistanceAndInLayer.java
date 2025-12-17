package androidx.compose.ui.node;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001b\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u000b2\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\u0008\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\u0088\u0001\u0002\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001f", d2 = {"Landroidx/compose/ui/node/DistanceAndInLayer;", "", "packedValue", "", "constructor-impl", "(J)J", "distance", "", "getDistance-impl", "(J)F", "isInLayer", "", "isInLayer-impl", "(J)Z", "getPackedValue", "()J", "compareTo", "", "other", "compareTo-S_HNhKs", "(JJ)I", "equals", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
final class DistanceAndInLayer {

    private final long packedValue;
    private DistanceAndInLayer(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final androidx.compose.ui.node.DistanceAndInLayer box-impl(long l) {
        DistanceAndInLayer distanceAndInLayer = new DistanceAndInLayer(l, obj2);
        return distanceAndInLayer;
    }

    public static final int compareTo-S_HNhKs(long arg0, long other) {
        int i;
        final boolean inLayer-impl = DistanceAndInLayer.isInLayer-impl(arg0);
        if (inLayer-impl != DistanceAndInLayer.isInLayer-impl(obj6)) {
            i = inLayer-impl ? -1 : 1;
            return i;
        }
        return (int)signum;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof DistanceAndInLayer) {
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

    public static final float getDistance-impl(long arg0) {
        final int i2 = 0;
        final int i6 = 0;
        return Float.intBitsToFloat((int)i4);
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static final boolean isInLayer-impl(long arg0) {
        int i;
        final int i2 = 0;
        i = (int)i3 != 0 ? 1 : 0;
        return i;
    }

    public static String toString-impl(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DistanceAndInLayer(packedValue=").append(l).append(')').toString();
    }

    public boolean equals(Object object) {
        return DistanceAndInLayer.equals-impl(this.packedValue, obj1);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return DistanceAndInLayer.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return DistanceAndInLayer.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
