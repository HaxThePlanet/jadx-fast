package androidx.compose.material3;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0081@\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0016¢\u0006\u0004\u0008\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00078FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u000f\u0010\t\u001a\u0004\u0008\u0010\u0010\u000b\u0088\u0001\u0002¨\u0006\u001f", d2 = {"Landroidx/compose/material3/SliderRange;", "", "packedValue", "", "constructor-impl", "(J)J", "endInclusive", "", "getEndInclusive$annotations", "()V", "getEndInclusive-impl", "(J)F", "getPackedValue", "()J", "start", "getStart$annotations", "getStart-impl", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(J)I", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class SliderRange {

    public static final androidx.compose.material3.SliderRange.Companion Companion;
    private static final long Unspecified;
    private final long packedValue;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0008\u0012\u0004\u0008\u0005\u0010\u0002\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\t", d2 = {"Landroidx/compose/material3/SliderRange$Companion;", "", "()V", "Unspecified", "Landroidx/compose/material3/SliderRange;", "getUnspecified-FYbKRX4$annotations", "getUnspecified-FYbKRX4", "()J", "J", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getUnspecified-FYbKRX4$annotations() {
        }

        public final long getUnspecified-FYbKRX4() {
            return SliderRange.access$getUnspecified$cp();
        }
    }
    static {
        SliderRange.Companion companion = new SliderRange.Companion(0);
        SliderRange.Companion = companion;
        int i = 2143289344;
        SliderRange.Unspecified = SliderKt.SliderRange(i, i);
    }

    private SliderRange(long packedValue) {
        super();
        this.packedValue = packedValue;
    }

    public static final long access$getUnspecified$cp() {
        return SliderRange.Unspecified;
    }

    public static final androidx.compose.material3.SliderRange box-impl(long l) {
        SliderRange sliderRange = new SliderRange(l, obj2);
        return sliderRange;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof SliderRange) {
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

    public static void getEndInclusive$annotations() {
    }

    public static final float getEndInclusive-impl(long arg0) {
        int i;
        i = Long.compare(arg0, unspecified) != 0 ? 1 : 0;
        if (i == 0) {
        } else {
            final int i3 = 0;
            final int i6 = 0;
            return Float.intBitsToFloat((int)i4);
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("SliderRange is unspecified".toString());
        throw illegalStateException;
    }

    public static void getStart$annotations() {
    }

    public static final float getStart-impl(long arg0) {
        int i;
        i = Long.compare(arg0, unspecified) != 0 ? 1 : 0;
        if (i == 0) {
        } else {
            final int i3 = 0;
            final int i7 = 0;
            return Float.intBitsToFloat((int)i5);
        }
        int i2 = 0;
        IllegalStateException illegalStateException = new IllegalStateException("SliderRange is unspecified".toString());
        throw illegalStateException;
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static String toString-impl(long arg0) {
        String string;
        float endInclusive-impl;
        if (SliderKt.isSpecified-If1S1O4(arg0)) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append(SliderRange.getStart-impl(arg0)).append("..").append(SliderRange.getEndInclusive-impl(arg0)).toString();
        } else {
            string = "FloatRange.Unspecified";
        }
        return string;
    }

    public boolean equals(Object object) {
        return SliderRange.equals-impl(this.packedValue, obj1);
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    public int hashCode() {
        return SliderRange.hashCode-impl(this.packedValue);
    }

    public String toString() {
        return SliderRange.toString-impl(this.packedValue);
    }

    public final long unbox-impl() {
        return this.packedValue;
    }
}
