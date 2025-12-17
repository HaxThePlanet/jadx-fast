package androidx.compose.ui.unit;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008!\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0087@\u0018\u0000 02\u00020\u0001:\u00010B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J;\u0010#\u001a\u00020\u00002\u0008\u0008\u0002\u0010 \u001a\u00020\u00072\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008$\u0010%J\u001a\u0010&\u001a\u00020\u000b2\u0008\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008(\u0010)J\u0010\u0010*\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\u0008+\u0010\tJ\u000f\u0010,\u001a\u00020-H\u0016¢\u0006\u0004\u0008.\u0010/R\u0015\u0010\u0006\u001a\u00020\u00078Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\rR\u001a\u0010\u0010\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0011\u0010\u0012\u001a\u0004\u0008\u0013\u0010\rR\u001a\u0010\u0014\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\u0012\u001a\u0004\u0008\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\u0012\u001a\u0004\u0008\u0019\u0010\rR\u0011\u0010\u001a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\tR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\tR\u0011\u0010\u001e\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u001f\u0010\tR\u0011\u0010 \u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008!\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\"\u0010\u0012\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u00061", d2 = {"Landroidx/compose/ui/unit/Constraints;", "", "value", "", "constructor-impl", "(J)J", "focusIndex", "", "getFocusIndex-impl", "(J)I", "hasBoundedHeight", "", "getHasBoundedHeight-impl", "(J)Z", "hasBoundedWidth", "getHasBoundedWidth-impl", "hasFixedHeight", "getHasFixedHeight$annotations", "()V", "getHasFixedHeight-impl", "hasFixedWidth", "getHasFixedWidth$annotations", "getHasFixedWidth-impl", "isZero", "isZero$annotations", "isZero-impl", "maxHeight", "getMaxHeight-impl", "maxWidth", "getMaxWidth-impl", "minHeight", "getMinHeight-impl", "minWidth", "getMinWidth-impl", "getValue$annotations", "copy", "copy-Zbe2FdA", "(JIIII)J", "equals", "other", "equals-impl", "(JLjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "Companion", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class Constraints {

    public static final androidx.compose.ui.unit.Constraints.Companion Companion = null;
    public static final int Infinity = Integer.MAX_VALUE;
    private final long value;

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000b\u0010\u000cJ5\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u000e\u0010\u000cJ%\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0004H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0018\u0010\u0016J?\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001bH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001e", d2 = {"Landroidx/compose/ui/unit/Constraints$Companion;", "", "()V", "Infinity", "", "fitPrioritizingHeight", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "fitPrioritizingHeight-Zbe2FdA", "(IIII)J", "fitPrioritizingWidth", "fitPrioritizingWidth-Zbe2FdA", "fixed", "width", "height", "fixed-JhjzzOo", "(II)J", "fixedHeight", "fixedHeight-OenEA2s", "(I)J", "fixedWidth", "fixedWidth-OenEA2s", "restrictConstraints", "prioritizeWidth", "", "restrictConstraints-xF2OJ5Q", "(IIIIZ)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static long restrictConstraints-xF2OJ5Q$default(androidx.compose.ui.unit.Constraints.Companion constraints$Companion, int i2, int i3, int i4, int i5, boolean z6, int i7, Object object8) {
            int i;
            int obj11;
            i = i7 &= 16 != 0 ? obj11 : z6;
            return companion.restrictConstraints-xF2OJ5Q(i2, i3, i4, i5, i);
        }

        public final long fitPrioritizingHeight-Zbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int i2;
            int i;
            int i3;
            int i4 = 262142;
            final int i5 = Math.min(minHeight, i4);
            i = Integer.MAX_VALUE;
            if (maxHeight == i) {
                i2 = i;
            } else {
                i2 = Math.min(maxHeight, i4);
            }
            i3 = i2 == i ? i5 : i2;
            final int i6 = ConstraintsKt.access$maxAllowedForSize(i3);
            if (maxWidth == i) {
            } else {
                i = Math.min(i6, maxWidth);
            }
            return ConstraintsKt.Constraints(Math.min(i6, minWidth), i, i5, i2);
        }

        public final long fitPrioritizingWidth-Zbe2FdA(int minWidth, int maxWidth, int minHeight, int maxHeight) {
            int i;
            int i2;
            int i3;
            int i4 = 262142;
            final int i5 = Math.min(minWidth, i4);
            i2 = Integer.MAX_VALUE;
            if (maxWidth == i2) {
                i = i2;
            } else {
                i = Math.min(maxWidth, i4);
            }
            i3 = i == i2 ? i5 : i;
            final int i6 = ConstraintsKt.access$maxAllowedForSize(i3);
            if (maxHeight == i2) {
            } else {
                i2 = Math.min(i6, maxHeight);
            }
            return ConstraintsKt.Constraints(i5, i, Math.min(i6, minHeight), i2);
        }

        public final long fixed-JhjzzOo(int width, int height) {
            int i;
            String $i$a$RequirePreconditionConstraints$Companion$fixed$1;
            StringBuilder append;
            String str;
            if (width >= 0 && height >= 0) {
                i = height >= 0 ? 1 : 0;
            } else {
            }
            final int i2 = 0;
            if (i == 0) {
                int i3 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("width(").append(width).append(") and height(").append(height).append(") must be >= 0").toString());
            }
            return ConstraintsKt.createConstraints(width, width, height, height);
        }

        public final long fixedHeight-OenEA2s(int height) {
            int i;
            String $i$a$RequirePreconditionConstraints$Companion$fixedHeight$1;
            StringBuilder append;
            String str;
            int i2 = 0;
            i = height >= 0 ? 1 : i2;
            final int i4 = 0;
            if (i == 0) {
                int i5 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("height(").append(height).append(") must be >= 0").toString());
            }
            return ConstraintsKt.createConstraints(i2, Integer.MAX_VALUE, height, height);
        }

        public final long fixedWidth-OenEA2s(int width) {
            int i;
            String $i$a$RequirePreconditionConstraints$Companion$fixedWidth$1;
            StringBuilder append;
            String str;
            int i2 = 0;
            i = width >= 0 ? 1 : i2;
            final int i4 = 0;
            if (i == 0) {
                int i5 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("width(").append(width).append(") must be >= 0").toString());
            }
            return ConstraintsKt.createConstraints(width, width, i2, Integer.MAX_VALUE);
        }

        @Deprecated(message = "Replace with fitPrioritizingWidth", replaceWith = @ReplaceWith(...))
        public final long restrictConstraints-xF2OJ5Q(int minWidth, int maxWidth, int minHeight, int maxHeight, boolean prioritizeWidth) {
            long fitPrioritizingWidth-Zbe2FdA;
            if (prioritizeWidth) {
                fitPrioritizingWidth-Zbe2FdA = fitPrioritizingWidth-Zbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
            } else {
                fitPrioritizingWidth-Zbe2FdA = fitPrioritizingHeight-Zbe2FdA(minWidth, maxWidth, minHeight, maxHeight);
            }
            return fitPrioritizingWidth-Zbe2FdA;
        }
    }
    static {
        Constraints.Companion companion = new Constraints.Companion(0);
        Constraints.Companion = companion;
    }

    private Constraints(long value) {
        super();
        this.value = value;
    }

    public static final androidx.compose.ui.unit.Constraints box-impl(long l) {
        Constraints constraints = new Constraints(l, obj2);
        return constraints;
    }

    public static long constructor-impl(long l) {
        return l;
    }

    public static final long copy-Zbe2FdA(long arg0, int minWidth, int maxWidth, int minHeight, int maxHeight) {
        int i2;
        int i;
        int $i$a$RequirePreconditionConstraints$copy$3;
        int append;
        String $i$a$RequirePreconditionConstraints$copy$1;
        StringBuilder $i$a$RequirePreconditionConstraints$copy$2;
        String append2;
        String str;
        i2 = 1;
        int i3 = 0;
        if (maxHeight >= 0 && maxWidth >= 0) {
            i = maxWidth >= 0 ? i2 : i3;
        } else {
        }
        int i6 = 0;
        if (i == 0) {
            int i8 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder2.append("minHeight(").append(maxHeight).append(") and minWidth(").append(maxWidth).append(") must be >= 0").toString());
        }
        $i$a$RequirePreconditionConstraints$copy$3 = minHeight >= maxWidth ? i2 : i3;
        append = 0;
        int i7 = 41;
        if ($i$a$RequirePreconditionConstraints$copy$3 == 0) {
            int i9 = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder3.append("maxWidth(").append(minHeight).append(") must be >= minWidth(").append(maxWidth).append(i7).toString());
        }
        if (obj13 >= maxHeight) {
        } else {
            i2 = i3;
        }
        int i4 = 0;
        if (i2 == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("maxHeight(").append(obj13).append(") must be >= minHeight(").append(maxHeight).append(i7).toString());
        }
        return ConstraintsKt.createConstraints(maxWidth, minHeight, maxHeight, obj13);
    }

    public static long copy-Zbe2FdA$default(long l, int i2, int i3, int i4, int i5, int i6, Object object7) {
        int i8;
        int i7;
        int i;
        int i9;
        int obj8;
        int obj9;
        int obj10;
        int obj11;
        if (object7 & 1 != 0) {
            i8 = obj8;
        } else {
            i8 = i3;
        }
        if (object7 & 2 != 0) {
            i7 = obj9;
        } else {
            i7 = i4;
        }
        if (object7 & 4 != 0) {
            i = obj10;
        } else {
            i = i5;
        }
        if (object7 & 8 != 0) {
            i9 = obj11;
        } else {
            i9 = i6;
        }
        return Constraints.copy-Zbe2FdA(l, obj1, i8, i7, i);
    }

    public static boolean equals-impl(long l, Object object2) {
        final int i2 = 0;
        if (!obj6 instanceof Constraints) {
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

    private static final int getFocusIndex-impl(long arg0) {
        final int i = 0;
        return (int)i3;
    }

    public static final boolean getHasBoundedHeight-impl(long arg0) {
        int i;
        int i2 = 0;
        int $i$f$getFocusIndexImpl = (int)i6;
        int i7 = 0;
        i = 1;
        i12 += i16;
        int i3 = 0;
        int i4 = 0;
        if (i18 &= i10 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public static final boolean getHasBoundedWidth-impl(long arg0) {
        int i;
        int i2 = 0;
        int $i$f$getFocusIndexImpl = (int)i8;
        int i9 = 0;
        i = 1;
        int i3 = 0;
        if (i5 &= i12 != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public static void getHasFixedHeight$annotations() {
    }

    public static final boolean getHasFixedHeight-impl(long arg0) {
        int i;
        int i2;
        int i3 = 0;
        int $i$f$getFocusIndexImpl = (int)i7;
        int i8 = 0;
        i = 1;
        i13 += i17;
        int i4 = 0;
        i10 -= i;
        int i5 = 0;
        int $i$f$minHeightOffsets = i14 + 15;
        i23 &= i11;
        final int i25 = 0;
        i2 = i24 == 0 ? 0x7fffffff /* Unknown resource */ : i24 + -1;
        if (i19 &= i11 == i2) {
        } else {
            i = 0;
        }
        return i;
    }

    public static void getHasFixedWidth$annotations() {
    }

    public static final boolean getHasFixedWidth-impl(long arg0) {
        int i2;
        int i;
        int i3 = 0;
        int $i$f$getFocusIndexImpl = (int)i9;
        int i10 = 0;
        i2 = 1;
        int i4 = 0;
        i12 -= i2;
        i18 &= i13;
        int i25 = 0;
        i = i19 == 0 ? 0x7fffffff /* Unknown resource */ : i19 + -1;
        if (i6 &= i13 == i) {
        } else {
            i2 = 0;
        }
        return i2;
    }

    public static final int getMaxHeight-impl(long arg0) {
        int i;
        int i2 = 0;
        int $i$f$getFocusIndexImpl = (int)i6;
        int i7 = 0;
        int i14 = 1;
        i12 += i20;
        int i3 = 0;
        int i4 = 0;
        i16 &= i10;
        i = i17 == 0 ? 0x7fffffff /* Unknown resource */ : i17 + -1;
        return i;
    }

    public static final int getMaxWidth-impl(long arg0) {
        int i;
        int i2 = 0;
        int $i$f$getFocusIndexImpl = (int)i8;
        int i9 = 0;
        final int i17 = 1;
        int i3 = 0;
        i5 &= i12;
        i = i6 == 0 ? 0x7fffffff /* Unknown resource */ : i6 + -1;
        return i;
    }

    public static final int getMinHeight-impl(long arg0) {
        int i = 0;
        int $i$f$getFocusIndexImpl = (int)i5;
        int i6 = 0;
        int i13 = 1;
        i11 += i19;
        int i2 = 0;
        int i3 = 0;
        return i15 &= i9;
    }

    public static final int getMinWidth-impl(long arg0) {
        int i = 0;
        int $i$f$getFocusIndexImpl = (int)i7;
        int i8 = 0;
        final int i16 = 1;
        int i2 = 0;
        return i4 &= i11;
    }

    public static void getValue$annotations() {
    }

    public static int hashCode-impl(long l) {
        return Long.hashCode(l);
    }

    public static void isZero$annotations() {
    }

    public static final boolean isZero-impl(long arg0) {
        int i;
        int i2 = 0;
        int $i$f$getFocusIndexImpl = (int)i9;
        int i10 = 0;
        i = 1;
        i14 += i18;
        int i11 = 0;
        if (i6 -= i == 0) {
            return i;
        }
        int i12 = 0;
        final int i26 = 0;
        if (i24 -= i == 0) {
        } else {
            i = 0;
        }
        return i;
    }

    public static String toString-impl(long arg0) {
        String valueOf;
        String valueOf2;
        final int maxWidth-impl = Constraints.getMaxWidth-impl(arg0);
        int i = Integer.MAX_VALUE;
        if (maxWidth-impl == i) {
            valueOf2 = valueOf;
        } else {
            valueOf2 = String.valueOf(maxWidth-impl);
        }
        final int maxHeight-impl = Constraints.getMaxHeight-impl(arg0);
        if (maxHeight-impl == i) {
        } else {
            valueOf = String.valueOf(maxHeight-impl);
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("Constraints(minWidth = ").append(Constraints.getMinWidth-impl(arg0)).append(", maxWidth = ").append(valueOf2).append(", minHeight = ").append(Constraints.getMinHeight-impl(arg0)).append(", maxHeight = ").append(valueOf).append(')').toString();
    }

    public boolean equals(Object object) {
        return Constraints.equals-impl(this.value, obj1);
    }

    public int hashCode() {
        return Constraints.hashCode-impl(this.value);
    }

    public String toString() {
        return Constraints.toString-impl(this.value);
    }

    public final long unbox-impl() {
        return this.value;
    }
}
