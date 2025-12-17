package androidx.compose.ui.unit;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0001\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u001a5\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0018\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0019\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001a\u001a\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a-\u0010 \u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003H\u0000¢\u0006\u0002\u0010\u001a\u001a\u0011\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\u0008\u001a\u0011\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\u0008\u001a\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0002\u001a\u0010\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0010\u0010+\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003H\u0002\u001a\u0011\u0010,\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\u0008\u001a\u0011\u0010-\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003H\u0082\u0008\u001a\u001c\u0010.\u001a\u00020\u0015*\u00020\u00152\u0006\u0010/\u001a\u00020\u0015ø\u0001\u0000¢\u0006\u0004\u00080\u00101\u001a\u001e\u0010.\u001a\u000202*\u00020\u00152\u0006\u0010\u001f\u001a\u000202H\u0007ø\u0001\u0000¢\u0006\u0004\u00083\u00101\u001a\u001e\u00104\u001a\u00020\u0003*\u00020\u00152\u0006\u00105\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u00086\u00107\u001a\u001e\u00108\u001a\u00020\u0003*\u00020\u00152\u0006\u00109\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008:\u00107\u001a\u001e\u0010;\u001a\u00020<*\u00020\u00152\u0006\u0010\u001f\u001a\u000202H\u0007ø\u0001\u0000¢\u0006\u0004\u0008=\u0010>\u001a*\u0010?\u001a\u00020\u0015*\u00020\u00152\u0008\u0008\u0002\u0010@\u001a\u00020\u00032\u0008\u0008\u0002\u0010A\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\u0008B\u0010C\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0008\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006D", d2 = {"FocusMask", "", "Infinity", "", "MaxAllowedForMaxFocusBits", "MaxAllowedForMaxNonFocusBits", "MaxAllowedForMinFocusBits", "MaxAllowedForMinNonFocusBits", "MaxFocusBits", "MaxFocusHeight", "MaxFocusMask", "MaxFocusWidth", "MaxNonFocusBits", "MaxNonFocusMask", "MinFocusBits", "MinFocusHeight", "MinFocusMask", "MinFocusWidth", "MinNonFocusBits", "MinNonFocusMask", "Constraints", "Landroidx/compose/ui/unit/Constraints;", "minWidth", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", "max", "value", "bitsNeedForSizeUnchecked", "size", "createConstraints", "heightMask", "bitOffset", "indexToBitOffset", "index", "invalidConstraint", "", "widthVal", "heightVal", "invalidSize", "", "maxAllowedForSize", "minHeightOffsets", "widthMask", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConstraintsKt {

    private static final long FocusMask = 3L;
    private static final int Infinity = Integer.MAX_VALUE;
    private static final int MaxAllowedForMaxFocusBits = 8190;
    private static final int MaxAllowedForMaxNonFocusBits = 262142;
    private static final int MaxAllowedForMinFocusBits = 32766;
    private static final int MaxAllowedForMinNonFocusBits = 65534;
    private static final int MaxFocusBits = 18;
    private static final int MaxFocusHeight = 0;
    private static final int MaxFocusMask = 262143;
    private static final int MaxFocusWidth = 3;
    private static final int MaxNonFocusBits = 13;
    private static final int MaxNonFocusMask = 8191;
    private static final int MinFocusBits = 16;
    private static final int MinFocusHeight = 1;
    private static final int MinFocusMask = 65535;
    private static final int MinFocusWidth = 2;
    private static final int MinNonFocusBits = 15;
    private static final int MinNonFocusMask = 32767;
    public static final long Constraints(int minWidth, int maxWidth, int minHeight, int maxHeight) {
        int i;
        int i2;
        int $i$a$RequirePreconditionConstraintsKt$Constraints$3;
        int append;
        int string;
        String $i$a$RequirePreconditionConstraintsKt$Constraints$1;
        StringBuilder append2;
        String str;
        i = 1;
        int i3 = 0;
        i2 = maxWidth >= minWidth ? i : i3;
        int i6 = 0;
        string = 41;
        if (i2 == 0) {
            int i7 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder2.append("maxWidth(").append(maxWidth).append(") must be >= than minWidth(").append(minWidth).append(string).toString());
        }
        $i$a$RequirePreconditionConstraintsKt$Constraints$3 = maxHeight >= minHeight ? i : i3;
        append = 0;
        if ($i$a$RequirePreconditionConstraintsKt$Constraints$3 == 0) {
            $i$a$RequirePreconditionConstraintsKt$Constraints$1 = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder3.append("maxHeight(").append(maxHeight).append(") must be >= than minHeight(").append(minHeight).append(string).toString());
        }
        if (minWidth >= 0 && minHeight >= 0) {
            if (minHeight >= 0) {
            } else {
                i = i3;
            }
        } else {
        }
        int i4 = 0;
        if (i == 0) {
            int i5 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            InlineClassHelperKt.throwIllegalArgumentException(stringBuilder.append("minWidth(").append(minWidth).append(") and minHeight(").append(minHeight).append(") must be >= 0").toString());
        }
        return ConstraintsKt.createConstraints(minWidth, maxWidth, minHeight, maxHeight);
    }

    public static long Constraints$default(int i, int i2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        int obj4;
        int obj5;
        final int i6 = 0;
        if (i5 & 1 != 0) {
            obj2 = i6;
        }
        final int i7 = Integer.MAX_VALUE;
        if (i5 & 2 != 0) {
            obj3 = i7;
        }
        if (i5 & 4 != 0) {
            obj4 = i6;
        }
        if (i5 &= 8 != 0) {
            obj5 = i7;
        }
        return ConstraintsKt.Constraints(obj2, obj3, obj4, obj5);
    }

    public static final int access$maxAllowedForSize(int size) {
        return ConstraintsKt.maxAllowedForSize(size);
    }

    private static final int addMaxWithMinimum(int max, int value) {
        int coerceAtLeast;
        int i;
        if (max == Integer.MAX_VALUE) {
            coerceAtLeast = max;
        } else {
            coerceAtLeast = RangesKt.coerceAtLeast(max + value, 0);
        }
        return coerceAtLeast;
    }

    private static final int bitsNeedForSizeUnchecked(int size) {
        int i;
        i = size < 8191 ? 13 : size < i3 ? 15 : size < i4 ? 16 : size < i5 ? 18 : 255;
        return i;
    }

    public static final long constrain-4WqzIAM(long $this$constrain_u2d4WqzIAM, long size) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.getWidth-impl(obj6), Constraints.getMinWidth-impl($this$constrain_u2d4WqzIAM), Constraints.getMaxWidth-impl($this$constrain_u2d4WqzIAM)), RangesKt.coerceIn(IntSize.getHeight-impl(obj6), Constraints.getMinHeight-impl($this$constrain_u2d4WqzIAM), Constraints.getMaxHeight-impl($this$constrain_u2d4WqzIAM)));
    }

    public static final long constrain-N9IONVI(long $this$constrain_u2dN9IONVI, long otherConstraints) {
        return ConstraintsKt.Constraints(RangesKt.coerceIn(Constraints.getMinWidth-impl(obj8), Constraints.getMinWidth-impl($this$constrain_u2dN9IONVI), Constraints.getMaxWidth-impl($this$constrain_u2dN9IONVI)), RangesKt.coerceIn(Constraints.getMaxWidth-impl(obj8), Constraints.getMinWidth-impl($this$constrain_u2dN9IONVI), Constraints.getMaxWidth-impl($this$constrain_u2dN9IONVI)), RangesKt.coerceIn(Constraints.getMinHeight-impl(obj8), Constraints.getMinHeight-impl($this$constrain_u2dN9IONVI), Constraints.getMaxHeight-impl($this$constrain_u2dN9IONVI)), RangesKt.coerceIn(Constraints.getMaxHeight-impl(obj8), Constraints.getMinHeight-impl($this$constrain_u2dN9IONVI), Constraints.getMaxHeight-impl($this$constrain_u2dN9IONVI)));
    }

    public static final int constrainHeight-K40F9xA(long $this$constrainHeight_u2dK40F9xA, int height) {
        return RangesKt.coerceIn(obj4, Constraints.getMinHeight-impl($this$constrainHeight_u2dK40F9xA), Constraints.getMaxHeight-impl($this$constrainHeight_u2dK40F9xA));
    }

    public static final int constrainWidth-K40F9xA(long $this$constrainWidth_u2dK40F9xA, int width) {
        return RangesKt.coerceIn(obj4, Constraints.getMinWidth-impl($this$constrainWidth_u2dK40F9xA), Constraints.getMaxWidth-impl($this$constrainWidth_u2dK40F9xA));
    }

    public static final long createConstraints(int minWidth, int maxWidth, int minHeight, int maxHeight) {
        int i3;
        int i;
        int i2;
        int i4 = maxWidth;
        final int i9 = maxHeight;
        int i10 = Integer.MAX_VALUE;
        i = i9 == i10 ? minHeight : i9;
        i3 = i4 == i10 ? minWidth : i4;
        final int bitsNeedForSizeUnchecked2 = ConstraintsKt.bitsNeedForSizeUnchecked(i3);
        if (bitsNeedForSizeUnchecked2 + bitsNeedForSizeUnchecked > 31) {
            ConstraintsKt.invalidConstraint(i3, i);
        }
        int i12 = i4 + 1;
        int i16 = i9 + 1;
        int i19 = 3;
        i2 = 0;
        int i25 = 1;
        switch (bitsNeedForSizeUnchecked2) {
            case 13:
                break;
            case 14:
                break;
            case 15:
                i2 = i25;
                break;
            case 16:
                i2 = 2;
                break;
            default:
                i2 = i19;
        }
        int i30 = 0;
        int i20 = 0;
        i34 += 15;
        return Constraints.constructor-impl(i7 |= i29);
    }

    private static final int heightMask(int bitOffset) {
        final int i = 0;
        final int i5 = 1;
        return i3 -= i5;
    }

    private static final int indexToBitOffset(int index) {
        final int i = 0;
        return i3 += i7;
    }

    private static final void invalidConstraint(int widthVal, int heightVal) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Can't represent a width of ").append(widthVal).append(" and height of ").append(heightVal).append(" in Constraints").toString());
        throw illegalArgumentException;
    }

    private static final Void invalidSize(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Can't represent a size of ").append(size).append(" in Constraints").toString());
        throw illegalArgumentException;
    }

    public static final boolean isSatisfiedBy-4WqzIAM(long $this$isSatisfiedBy_u2d4WqzIAM, long size) {
        int i;
        int maxHeight-impl;
        int height-impl;
        int i2;
        height-impl = IntSize.getWidth-impl(obj7);
        i2 = 1;
        final int i3 = 0;
        if (Constraints.getMinWidth-impl($this$isSatisfiedBy_u2d4WqzIAM) <= height-impl && height-impl <= Constraints.getMaxWidth-impl($this$isSatisfiedBy_u2d4WqzIAM)) {
            i = height-impl <= Constraints.getMaxWidth-impl($this$isSatisfiedBy_u2d4WqzIAM) ? i2 : i3;
        } else {
        }
        if (i != 0) {
            height-impl = IntSize.getHeight-impl(obj7);
            if (Constraints.getMinHeight-impl($this$isSatisfiedBy_u2d4WqzIAM) <= height-impl && height-impl <= Constraints.getMaxHeight-impl($this$isSatisfiedBy_u2d4WqzIAM)) {
                i = height-impl <= Constraints.getMaxHeight-impl($this$isSatisfiedBy_u2d4WqzIAM) ? i2 : i3;
            } else {
            }
            if (i != 0) {
            } else {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }

    private static final int maxAllowedForSize(int size) {
        int i;
        if (size < 8191) {
            i = 262142;
            return i;
        } else {
            if (size < 32767) {
                i = 65534;
            } else {
                if (size < 65535) {
                    i = 32766;
                } else {
                    if (size >= 262143) {
                    } else {
                        i = 8190;
                    }
                }
            }
        }
        ConstraintsKt.invalidSize(size);
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    private static final int minHeightOffsets(int bitOffset) {
        final int i = 0;
        return bitOffset + 15;
    }

    public static final long offset-NN6Ew-U(long $this$offset_u2dNN6Ew_u2dU, int horizontal, int vertical) {
        int i2 = 0;
        return ConstraintsKt.Constraints(RangesKt.coerceAtLeast(minWidth-impl += vertical, i2), ConstraintsKt.addMaxWithMinimum(Constraints.getMaxWidth-impl($this$offset_u2dNN6Ew_u2dU), vertical), RangesKt.coerceAtLeast(minHeight-impl += obj7, i2), ConstraintsKt.addMaxWithMinimum(Constraints.getMaxHeight-impl($this$offset_u2dNN6Ew_u2dU), obj7));
    }

    public static long offset-NN6Ew-U$default(long l, int i2, int i3, int i4, Object object5) {
        int obj3;
        int obj4;
        final int i = 0;
        if (object5 & 1 != 0) {
            obj3 = i;
        }
        if (object5 &= 2 != 0) {
            obj4 = i;
        }
        return ConstraintsKt.offset-NN6Ew-U(l, i2, obj3);
    }

    private static final int widthMask(int bitOffset) {
        final int i = 0;
        final int i5 = 1;
        return i3 -= i5;
    }
}
