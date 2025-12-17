package androidx.compose.foundation.layout;

import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0002\u0008\u000f\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0081@\u0018\u00002\u00020\u0001B)\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\u0008\u0007\u0010\u0008B\u0019\u0008\u0016\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0004\u0008\u0007\u0010\rB\u0011\u0008\u0002\u0012\u0006\u0010\u000e\u001a\u00020\n¢\u0006\u0004\u0008\u0007\u0010\u000fJ;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001a\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u001f\u0010\u0011J\u0015\u0010 \u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0004\u0008!\u0010\"J\u0015\u0010#\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0004\u0008$\u0010\"J\u0013\u0010%\u001a\u00020\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008&\u0010\u000fJ\u001b\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\u0008(\u0010\rJ\u0010\u0010)\u001a\u00020*HÖ\u0001¢\u0006\u0004\u0008+\u0010,R\u0012\u0010\u0006\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0012\u0010\u0005\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0011R\u0012\u0010\u0004\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0011R\u0012\u0010\u0002\u001a\u00020\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\u0008\u0014\u0010\u0011R\u0016\u0010\u000e\u001a\u00020\nX\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\u0015\u0088\u0001\u000e\u0092\u0001\u00020\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006-", d2 = {"Landroidx/compose/foundation/layout/OrientationIndependentConstraints;", "", "mainAxisMin", "", "mainAxisMax", "crossAxisMin", "crossAxisMax", "constructor-impl", "(IIII)J", "c", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)J", "value", "(J)J", "getCrossAxisMax-impl", "(J)I", "getCrossAxisMin-impl", "getMainAxisMax-impl", "getMainAxisMin-impl", "J", "copy", "copy-yUG9Ft0", "(JIIII)J", "equals", "", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "maxHeight", "maxHeight-impl", "(JLandroidx/compose/foundation/layout/LayoutOrientation;)I", "maxWidth", "maxWidth-impl", "stretchCrossAxis", "stretchCrossAxis-q4ezo7Y", "toBoxConstraints", "toBoxConstraints-OenEA2s", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class OrientationIndependentConstraints {

    private final long value;
    private OrientationIndependentConstraints(long value) {
        super();
        this.value = value;
    }

    public static final androidx.compose.foundation.layout.OrientationIndependentConstraints box-impl(long l) {
        OrientationIndependentConstraints orientationIndependentConstraints = new OrientationIndependentConstraints(l, obj2);
        return orientationIndependentConstraints;
    }

    public static long constructor-impl(int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return OrientationIndependentConstraints.constructor-impl(ConstraintsKt.Constraints(mainAxisMin, mainAxisMax, crossAxisMin, crossAxisMax));
    }

    private static long constructor-impl(long l) {
        return l;
    }

    public static long constructor-impl(long c, androidx.compose.foundation.layout.LayoutOrientation orientation) {
        int minHeight-impl;
        int maxHeight-impl;
        int minHeight-impl2;
        int maxHeight-impl2;
        if (obj6 == LayoutOrientation.Horizontal) {
            minHeight-impl = Constraints.getMinWidth-impl(c);
        } else {
            minHeight-impl = Constraints.getMinHeight-impl(c);
        }
        if (obj6 == LayoutOrientation.Horizontal) {
            maxHeight-impl = Constraints.getMaxWidth-impl(c);
        } else {
            maxHeight-impl = Constraints.getMaxHeight-impl(c);
        }
        if (obj6 == LayoutOrientation.Horizontal) {
            minHeight-impl2 = Constraints.getMinHeight-impl(c);
        } else {
            minHeight-impl2 = Constraints.getMinWidth-impl(c);
        }
        if (obj6 == LayoutOrientation.Horizontal) {
            maxHeight-impl2 = Constraints.getMaxHeight-impl(c);
        } else {
            maxHeight-impl2 = Constraints.getMaxWidth-impl(c);
        }
        return OrientationIndependentConstraints.constructor-impl(minHeight-impl, maxHeight-impl, minHeight-impl2, maxHeight-impl2);
    }

    public static final long copy-yUG9Ft0(long arg0, int mainAxisMin, int mainAxisMax, int crossAxisMin, int crossAxisMax) {
        return OrientationIndependentConstraints.constructor-impl(mainAxisMax, crossAxisMin, crossAxisMax, obj7);
    }

    public static long copy-yUG9Ft0$default(long l, int i2, int i3, int i4, int i5, int i6, Object object7) {
        int i9;
        int i7;
        int i8;
        int i;
        int obj8;
        int obj9;
        int obj10;
        int obj11;
        if (object7 & 1 != 0) {
            obj8 = 0;
            i9 = obj8;
        } else {
            i9 = i3;
        }
        if (object7 & 2 != 0) {
            obj8 = 0;
            i7 = obj9;
        } else {
            i7 = i4;
        }
        if (object7 & 4 != 0) {
            obj8 = 0;
            i8 = obj10;
        } else {
            i8 = i5;
        }
        if (object7 & 8 != 0) {
            obj8 = 0;
            i = obj11;
        } else {
            i = i6;
        }
        return OrientationIndependentConstraints.copy-yUG9Ft0(l, obj1, i9, i7, i8);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof OrientationIndependentConstraints) {
            return i2;
        }
        if (!Constraints.equals-impl0(l, object2)) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(long l, long l2) {
        return Constraints.equals-impl0(l, l2);
    }

    public static final int getCrossAxisMax-impl(long arg0) {
        final int i = 0;
        return Constraints.getMaxHeight-impl(arg0);
    }

    public static final int getCrossAxisMin-impl(long arg0) {
        final int i = 0;
        return Constraints.getMinHeight-impl(arg0);
    }

    public static final int getMainAxisMax-impl(long arg0) {
        final int i = 0;
        return Constraints.getMaxWidth-impl(arg0);
    }

    public static final int getMainAxisMin-impl(long arg0) {
        final int i = 0;
        return Constraints.getMinWidth-impl(arg0);
    }

    public static int hashCode-impl(long l) {
        return Constraints.hashCode-impl(l);
    }

    public static final int maxHeight-impl(long arg0, androidx.compose.foundation.layout.LayoutOrientation orientation) {
        int $i$f$getCrossAxisMaxImpl;
        int maxWidth-impl;
        if (obj4 == LayoutOrientation.Horizontal) {
            int i = 0;
            $i$f$getCrossAxisMaxImpl = Constraints.getMaxHeight-impl(arg0);
        } else {
            int i2 = 0;
            $i$f$getCrossAxisMaxImpl = maxWidth-impl;
        }
        return $i$f$getCrossAxisMaxImpl;
    }

    public static final int maxWidth-impl(long arg0, androidx.compose.foundation.layout.LayoutOrientation orientation) {
        int $i$f$getMainAxisMaxImpl;
        int maxHeight-impl;
        if (obj4 == LayoutOrientation.Horizontal) {
            int i = 0;
            $i$f$getMainAxisMaxImpl = Constraints.getMaxWidth-impl(arg0);
        } else {
            int i2 = 0;
            $i$f$getMainAxisMaxImpl = maxHeight-impl;
        }
        return $i$f$getMainAxisMaxImpl;
    }

    public static final long stretchCrossAxis-q4ezo7Y(long arg0) {
        int $i$f$getCrossAxisMaxImpl;
        int minHeight-impl;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        if (Constraints.getMaxHeight-impl(arg0) != Integer.MAX_VALUE) {
            int i4 = 0;
            $i$f$getCrossAxisMaxImpl = Constraints.getMaxHeight-impl(arg0);
        } else {
            int i5 = 0;
            $i$f$getCrossAxisMaxImpl = minHeight-impl;
        }
        int i6 = 0;
        return OrientationIndependentConstraints.constructor-impl(Constraints.getMinWidth-impl(arg0), Constraints.getMaxWidth-impl(arg0), $i$f$getCrossAxisMaxImpl, Constraints.getMaxHeight-impl(arg0));
    }

    public static final long toBoxConstraints-OenEA2s(long arg0, androidx.compose.foundation.layout.LayoutOrientation orientation) {
        long l;
        int $i$f$getMainAxisMaxImpl;
        int $i$f$getCrossAxisMinImpl;
        int $i$f$getCrossAxisMaxImpl;
        if (obj6 == LayoutOrientation.Horizontal) {
            int i = 0;
            int i3 = 0;
            int i5 = 0;
            int i7 = 0;
            l = ConstraintsKt.Constraints(Constraints.getMinWidth-impl(arg0), Constraints.getMaxWidth-impl(arg0), Constraints.getMinHeight-impl(arg0), Constraints.getMaxHeight-impl(arg0));
        } else {
            int i2 = 0;
            int i4 = 0;
            int i6 = 0;
            int i8 = 0;
            l = ConstraintsKt.Constraints(Constraints.getMinHeight-impl(arg0), Constraints.getMaxHeight-impl(arg0), Constraints.getMinWidth-impl(arg0), Constraints.getMaxWidth-impl(arg0));
        }
        return l;
    }

    public static String toString-impl(long l) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("OrientationIndependentConstraints(value=").append(Constraints.toString-impl(l)).append(')').toString();
    }

    public boolean equals(Object object) {
        return OrientationIndependentConstraints.equals-impl(this.value, obj1);
    }

    public int hashCode() {
        return OrientationIndependentConstraints.hashCode-impl(this.value);
    }

    public String toString() {
        return OrientationIndependentConstraints.toString-impl(this.value);
    }

    public final long unbox-impl() {
        return this.value;
    }
}
