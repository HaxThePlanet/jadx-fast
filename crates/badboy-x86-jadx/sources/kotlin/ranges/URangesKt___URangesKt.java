package kotlin.ranges;

import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.random.URandomKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0010\t\n\u0002\u0008\n\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0005H\u0007¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a\u001b\u0010\u0000\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\t\u0010\n\u001a\u001b\u0010\u0000\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000bH\u0007¢\u0006\u0004\u0008\u000c\u0010\r\u001a\u001b\u0010\u000e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\u0008\u0010\u0010\u0004\u001a\u001b\u0010\u000e\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\u0008\u0011\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u0012\u0010\n\u001a\u001b\u0010\u000e\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\u0008\u0013\u0010\r\u001a#\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0007¢\u0006\u0004\u0008\u0015\u0010\u0016\u001a#\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0004\u0008\u0017\u0010\u0018\u001a!\u0010\u0014\u001a\u00020\u0005*\u00020\u00052\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u001aH\u0007¢\u0006\u0004\u0008\u001b\u0010\u001c\u001a#\u0010\u0014\u001a\u00020\u0008*\u00020\u00082\u0006\u0010\u0002\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u001d\u0010\u001e\u001a!\u0010\u0014\u001a\u00020\u0008*\u00020\u00082\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u001aH\u0007¢\u0006\u0004\u0008\u001f\u0010 \u001a#\u0010\u0014\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0007¢\u0006\u0004\u0008!\u0010\"\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\u0008'\u0010(\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0008\u0010)\u001a\u0004\u0018\u00010\u0005H\u0087\n¢\u0006\u0002\u0008*\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u0008H\u0087\u0002¢\u0006\u0004\u0008+\u0010,\u001a\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\u0008-\u0010.\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0001H\u0087\u0002¢\u0006\u0004\u00080\u00101\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u0005H\u0087\u0002¢\u0006\u0004\u00082\u00103\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0008\u0010)\u001a\u0004\u0018\u00010\u0008H\u0087\n¢\u0006\u0002\u00084\u001a\u001c\u0010#\u001a\u00020$*\u00020/2\u0006\u0010&\u001a\u00020\u000bH\u0087\u0002¢\u0006\u0004\u00085\u00106\u001a\u001c\u00107\u001a\u000208*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\u0008:\u0010;\u001a\u001c\u00107\u001a\u000208*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004¢\u0006\u0004\u0008<\u0010=\u001a\u001c\u00107\u001a\u00020>*\u00020\u00082\u0006\u00109\u001a\u00020\u0008H\u0087\u0004¢\u0006\u0004\u0008?\u0010@\u001a\u001c\u00107\u001a\u000208*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004¢\u0006\u0004\u0008A\u0010B\u001a\u0011\u0010C\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010C\u001a\u00020\u0008*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010F\u001a\u0004\u0018\u00010\u0008*\u00020>H\u0007\u001a\u0011\u0010G\u001a\u00020\u0005*\u000208H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010G\u001a\u00020\u0008*\u00020>H\u0007¢\u0006\u0002\u0010E\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\u0005*\u000208H\u0007\u001a\u000e\u0010H\u001a\u0004\u0018\u00010\u0008*\u00020>H\u0007\u001a\u0012\u0010I\u001a\u00020\u0005*\u00020%H\u0087\u0008¢\u0006\u0002\u0010J\u001a\u0019\u0010I\u001a\u00020\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010L\u001a\u0012\u0010I\u001a\u00020\u0008*\u00020/H\u0087\u0008¢\u0006\u0002\u0010M\u001a\u0019\u0010I\u001a\u00020\u0008*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007¢\u0006\u0002\u0010N\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%H\u0087\u0008\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\u0005*\u00020%2\u0006\u0010I\u001a\u00020KH\u0007\u001a\u000f\u0010O\u001a\u0004\u0018\u00010\u0008*\u00020/H\u0087\u0008\u001a\u0016\u0010O\u001a\u0004\u0018\u00010\u0008*\u00020/2\u0006\u0010I\u001a\u00020KH\u0007\u001a\u000c\u0010P\u001a\u000208*\u000208H\u0007\u001a\u000c\u0010P\u001a\u00020>*\u00020>H\u0007\u001a\u0015\u0010Q\u001a\u000208*\u0002082\u0006\u0010Q\u001a\u00020RH\u0087\u0004\u001a\u0015\u0010Q\u001a\u00020>*\u00020>2\u0006\u0010Q\u001a\u00020SH\u0087\u0004\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00012\u0006\u00109\u001a\u00020\u0001H\u0087\u0004¢\u0006\u0004\u0008U\u0010V\u001a\u001c\u0010T\u001a\u00020%*\u00020\u00052\u0006\u00109\u001a\u00020\u0005H\u0087\u0004¢\u0006\u0004\u0008W\u0010X\u001a\u001c\u0010T\u001a\u00020/*\u00020\u00082\u0006\u00109\u001a\u00020\u0008H\u0087\u0004¢\u0006\u0004\u0008Y\u0010Z\u001a\u001c\u0010T\u001a\u00020%*\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0087\u0004¢\u0006\u0004\u0008[\u0010\\¨\u0006]", d2 = {"coerceAtLeast", "Lkotlin/UByte;", "minimumValue", "coerceAtLeast-Kr8caGY", "(BB)B", "Lkotlin/UInt;", "coerceAtLeast-J1ME1BU", "(II)I", "Lkotlin/ULong;", "coerceAtLeast-eb3DHEI", "(JJ)J", "Lkotlin/UShort;", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-Kr8caGY", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-WZ9TVnA", "(III)I", "range", "Lkotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "coerceIn-VKSA0NQ", "(SSS)S", "contains", "", "Lkotlin/ranges/UIntRange;", "value", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "element", "contains-biwQdVI", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "Lkotlin/ranges/ULongRange;", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-GYNo2lE", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "Lkotlin/ranges/UIntProgression;", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ULongProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "first", "(Lkotlin/ranges/UIntProgression;)I", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "(Lkotlin/ranges/UIntRange;)I", "Lkotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;)J", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "reversed", "step", "", "", "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/ranges/URangesKt")
class URangesKt___URangesKt {
    public static final short coerceAtLeast-5PvTz6A(short $this$coerceAtLeast_u2d5PvTz6A, short minimumValue) {
        int i;
        int i2 = 65535;
        i = Intrinsics.compare($this$coerceAtLeast_u2d5PvTz6A & i2, i2 &= minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2d5PvTz6A;
        return i;
    }

    public static final int coerceAtLeast-J1ME1BU(int $this$coerceAtLeast_u2dJ1ME1BU, int minimumValue) {
        int i;
        i = Integer.compareUnsigned($this$coerceAtLeast_u2dJ1ME1BU, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2dJ1ME1BU;
        return i;
    }

    public static final byte coerceAtLeast-Kr8caGY(byte $this$coerceAtLeast_u2dKr8caGY, byte minimumValue) {
        int i;
        i = Intrinsics.compare($this$coerceAtLeast_u2dKr8caGY & 255, minimumValue & 255) < 0 ? minimumValue : $this$coerceAtLeast_u2dKr8caGY;
        return i;
    }

    public static final long coerceAtLeast-eb3DHEI(long $this$coerceAtLeast_u2deb3DHEI, long minimumValue) {
        long l;
        l = Long.compareUnsigned($this$coerceAtLeast_u2deb3DHEI, minimumValue) < 0 ? obj4 : $this$coerceAtLeast_u2deb3DHEI;
        return l;
    }

    public static final short coerceAtMost-5PvTz6A(short $this$coerceAtMost_u2d5PvTz6A, short maximumValue) {
        int i;
        int i2 = 65535;
        i = Intrinsics.compare($this$coerceAtMost_u2d5PvTz6A & i2, i2 &= maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2d5PvTz6A;
        return i;
    }

    public static final int coerceAtMost-J1ME1BU(int $this$coerceAtMost_u2dJ1ME1BU, int maximumValue) {
        int i;
        i = Integer.compareUnsigned($this$coerceAtMost_u2dJ1ME1BU, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2dJ1ME1BU;
        return i;
    }

    public static final byte coerceAtMost-Kr8caGY(byte $this$coerceAtMost_u2dKr8caGY, byte maximumValue) {
        int i;
        i = Intrinsics.compare($this$coerceAtMost_u2dKr8caGY & 255, maximumValue & 255) > 0 ? maximumValue : $this$coerceAtMost_u2dKr8caGY;
        return i;
    }

    public static final long coerceAtMost-eb3DHEI(long $this$coerceAtMost_u2deb3DHEI, long maximumValue) {
        long l;
        l = Long.compareUnsigned($this$coerceAtMost_u2deb3DHEI, maximumValue) > 0 ? obj4 : $this$coerceAtMost_u2deb3DHEI;
        return l;
    }

    public static final long coerceIn-JPwROB0(long $this$coerceIn_u2dJPwROB0, kotlin.ranges.ClosedRange<ULong> range) {
        long unbox-impl;
        Intrinsics.checkNotNullParameter(obj5, "range");
        if (obj5 instanceof ClosedFloatingPointRange) {
            return (ULong)RangesKt.coerceIn(ULong.box-impl($this$coerceIn_u2dJPwROB0), (ClosedFloatingPointRange)obj5).unbox-impl();
        }
        if (obj5.isEmpty()) {
        } else {
            if (Long.compareUnsigned($this$coerceIn_u2dJPwROB0, range) < 0) {
                unbox-impl = (ULong)obj5.getStart().unbox-impl();
            } else {
                if (Long.compareUnsigned($this$coerceIn_u2dJPwROB0, range) > 0) {
                    unbox-impl = (ULong)obj5.getEndInclusive().unbox-impl();
                } else {
                    unbox-impl = $this$coerceIn_u2dJPwROB0;
                }
            }
            return unbox-impl;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: ").append(obj5).append('.').toString());
        throw illegalArgumentException;
    }

    public static final short coerceIn-VKSA0NQ(short $this$coerceIn_u2dVKSA0NQ, short minimumValue, short maximumValue) {
        int i = 65535;
        if (Intrinsics.compare(minimumValue & i, maximumValue & i) > 0) {
        } else {
            if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & i, minimumValue & i) < 0) {
                return minimumValue;
            }
            if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & i, i &= maximumValue) > 0) {
                return maximumValue;
            }
            return $this$coerceIn_u2dVKSA0NQ;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(UShort.toString-impl(maximumValue)).append(" is less than minimum ").append(UShort.toString-impl(minimumValue)).append('.').toString());
        throw illegalArgumentException;
    }

    public static final int coerceIn-WZ9TVnA(int $this$coerceIn_u2dWZ9TVnA, int minimumValue, int maximumValue) {
        if (Integer.compareUnsigned(minimumValue, maximumValue) > 0) {
        } else {
            if (Integer.compareUnsigned($this$coerceIn_u2dWZ9TVnA, minimumValue) < 0) {
                return minimumValue;
            }
            if (Integer.compareUnsigned($this$coerceIn_u2dWZ9TVnA, maximumValue) > 0) {
                return maximumValue;
            }
            return $this$coerceIn_u2dWZ9TVnA;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(UInt.toString-impl(maximumValue)).append(" is less than minimum ").append(UInt.toString-impl(minimumValue)).append('.').toString());
        throw illegalArgumentException;
    }

    public static final byte coerceIn-b33U2AM(byte $this$coerceIn_u2db33U2AM, byte minimumValue, byte maximumValue) {
        if (Intrinsics.compare(minimumValue & 255, maximumValue & 255) > 0) {
        } else {
            if (Intrinsics.compare($this$coerceIn_u2db33U2AM & 255, minimumValue & 255) < 0) {
                return minimumValue;
            }
            if (Intrinsics.compare($this$coerceIn_u2db33U2AM & 255, maximumValue & 255) > 0) {
                return maximumValue;
            }
            return $this$coerceIn_u2db33U2AM;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(UByte.toString-impl(maximumValue)).append(" is less than minimum ").append(UByte.toString-impl(minimumValue)).append('.').toString());
        throw illegalArgumentException;
    }

    public static final long coerceIn-sambcqE(long $this$coerceIn_u2dsambcqE, long minimumValue, long maximumValue) {
        if (Long.compareUnsigned(maximumValue, obj6) > 0) {
        } else {
            if (Long.compareUnsigned($this$coerceIn_u2dsambcqE, minimumValue) < 0) {
                return maximumValue;
            }
            if (Long.compareUnsigned($this$coerceIn_u2dsambcqE, minimumValue) > 0) {
                return obj7;
            }
            return $this$coerceIn_u2dsambcqE;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: maximum ").append(ULong.toString-impl(obj7)).append(" is less than minimum ").append(ULong.toString-impl(maximumValue)).append('.').toString());
        throw illegalArgumentException;
    }

    public static final int coerceIn-wuiCnnA(int $this$coerceIn_u2dwuiCnnA, kotlin.ranges.ClosedRange<UInt> range) {
        int unbox-impl;
        Intrinsics.checkNotNullParameter(range, "range");
        if (range instanceof ClosedFloatingPointRange) {
            return (UInt)RangesKt.coerceIn(UInt.box-impl($this$coerceIn_u2dwuiCnnA), (ClosedFloatingPointRange)range).unbox-impl();
        }
        if (range.isEmpty()) {
        } else {
            if (Integer.compareUnsigned($this$coerceIn_u2dwuiCnnA, (UInt)range.getStart().unbox-impl()) < 0) {
                unbox-impl = (UInt)range.getStart().unbox-impl();
            } else {
                if (Integer.compareUnsigned($this$coerceIn_u2dwuiCnnA, (UInt)range.getEndInclusive().unbox-impl()) > 0) {
                    unbox-impl = (UInt)range.getEndInclusive().unbox-impl();
                } else {
                    unbox-impl = $this$coerceIn_u2dwuiCnnA;
                }
            }
            return unbox-impl;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Cannot coerce value to an empty range: ").append(range).append('.').toString());
        throw illegalArgumentException;
    }

    public static final boolean contains-68kG9v0(kotlin.ranges.UIntRange $this$contains_u2d68kG9v0, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2d68kG9v0, "$this$contains");
        return $this$contains_u2d68kG9v0.contains-WZ4Q5Ns(UInt.constructor-impl(value & 255));
    }

    private static final boolean contains-GYNo2lE(kotlin.ranges.ULongRange $this$contains_u2dGYNo2lE, ULong element) {
        String contains-VKZWuLQ;
        int i;
        Intrinsics.checkNotNullParameter($this$contains_u2dGYNo2lE, "$this$contains");
        if (element != null && $this$contains_u2dGYNo2lE.contains-VKZWuLQ(element.unbox-impl())) {
            i = $this$contains_u2dGYNo2lE.contains-VKZWuLQ(element.unbox-impl()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean contains-Gab390E(kotlin.ranges.ULongRange $this$contains_u2dGab390E, int value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGab390E, "$this$contains");
        return $this$contains_u2dGab390E.contains-VKZWuLQ(ULong.constructor-impl(l &= l2));
    }

    public static final boolean contains-ULb-yJY(kotlin.ranges.ULongRange $this$contains_u2dULb_u2dyJY, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dULb_u2dyJY, "$this$contains");
        return $this$contains_u2dULb_u2dyJY.contains-VKZWuLQ(ULong.constructor-impl(l &= i2));
    }

    public static final boolean contains-ZsK3CEQ(kotlin.ranges.UIntRange $this$contains_u2dZsK3CEQ, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dZsK3CEQ, "$this$contains");
        return $this$contains_u2dZsK3CEQ.contains-WZ4Q5Ns(UInt.constructor-impl(i &= value));
    }

    private static final boolean contains-biwQdVI(kotlin.ranges.UIntRange $this$contains_u2dbiwQdVI, UInt element) {
        String contains-WZ4Q5Ns;
        int i;
        Intrinsics.checkNotNullParameter($this$contains_u2dbiwQdVI, "$this$contains");
        if (element != null && $this$contains_u2dbiwQdVI.contains-WZ4Q5Ns(element.unbox-impl())) {
            i = $this$contains_u2dbiwQdVI.contains-WZ4Q5Ns(element.unbox-impl()) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean contains-fz5IDCE(kotlin.ranges.UIntRange $this$contains_u2dfz5IDCE, long value) {
        int contains-WZ4Q5Ns;
        int i;
        Intrinsics.checkNotNullParameter($this$contains_u2dfz5IDCE, "$this$contains");
        if (Long.compare(constructor-impl, i5) == 0 && $this$contains_u2dfz5IDCE.contains-WZ4Q5Ns(UInt.constructor-impl((int)value))) {
            i = $this$contains_u2dfz5IDCE.contains-WZ4Q5Ns(UInt.constructor-impl((int)value)) ? 1 : 0;
        } else {
        }
        return i;
    }

    public static final boolean contains-uhHAxoY(kotlin.ranges.ULongRange $this$contains_u2duhHAxoY, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2duhHAxoY, "$this$contains");
        return $this$contains_u2duhHAxoY.contains-VKZWuLQ(ULong.constructor-impl(l &= i2));
    }

    public static final kotlin.ranges.UIntProgression downTo-5PvTz6A(short $this$downTo_u2d5PvTz6A, short to) {
        int i = 65535;
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl($this$downTo_u2d5PvTz6A & i), UInt.constructor-impl(i &= to), -1);
    }

    public static final kotlin.ranges.UIntProgression downTo-J1ME1BU(int $this$downTo_u2dJ1ME1BU, int to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$downTo_u2dJ1ME1BU, to, -1);
    }

    public static final kotlin.ranges.UIntProgression downTo-Kr8caGY(byte $this$downTo_u2dKr8caGY, byte to) {
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs(UInt.constructor-impl($this$downTo_u2dKr8caGY & 255), UInt.constructor-impl(to & 255), -1);
    }

    public static final kotlin.ranges.ULongProgression downTo-eb3DHEI(long $this$downTo_u2deb3DHEI, long to) {
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$downTo_u2deb3DHEI, obj2, obj9);
    }

    public static final int first(kotlin.ranges.UIntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
        } else {
            return $this$first.getFirst-pVg5ArA();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$first).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final long first(kotlin.ranges.ULongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
        } else {
            return $this$first.getFirst-s-VKNKU();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$first).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final UInt firstOrNull(kotlin.ranges.UIntProgression $this$firstOrNull) {
        int box-impl;
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            box-impl = 0;
        } else {
            box-impl = UInt.box-impl($this$firstOrNull.getFirst-pVg5ArA());
        }
        return box-impl;
    }

    public static final ULong firstOrNull(kotlin.ranges.ULongProgression $this$firstOrNull) {
        int box-impl;
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            box-impl = 0;
        } else {
            box-impl = ULong.box-impl($this$firstOrNull.getFirst-s-VKNKU());
        }
        return box-impl;
    }

    public static final int last(kotlin.ranges.UIntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
        } else {
            return $this$last.getLast-pVg5ArA();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$last).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final long last(kotlin.ranges.ULongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
        } else {
            return $this$last.getLast-s-VKNKU();
        }
        StringBuilder stringBuilder = new StringBuilder();
        NoSuchElementException noSuchElementException = new NoSuchElementException(stringBuilder.append("Progression ").append($this$last).append(" is empty.").toString());
        throw noSuchElementException;
    }

    public static final UInt lastOrNull(kotlin.ranges.UIntProgression $this$lastOrNull) {
        int box-impl;
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            box-impl = 0;
        } else {
            box-impl = UInt.box-impl($this$lastOrNull.getLast-pVg5ArA());
        }
        return box-impl;
    }

    public static final ULong lastOrNull(kotlin.ranges.ULongProgression $this$lastOrNull) {
        int box-impl;
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            box-impl = 0;
        } else {
            box-impl = ULong.box-impl($this$lastOrNull.getLast-s-VKNKU());
        }
        return box-impl;
    }

    private static final int random(kotlin.ranges.UIntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return URangesKt.random($this$random, (Random)Random.Default);
    }

    public static final int random(kotlin.ranges.UIntRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return URandomKt.nextUInt(random, $this$random);
    }

    private static final long random(kotlin.ranges.ULongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return URangesKt.random($this$random, (Random)Random.Default);
    }

    public static final long random(kotlin.ranges.ULongRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return URandomKt.nextULong(random, $this$random);
    }

    private static final UInt randomOrNull(kotlin.ranges.UIntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return URangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    public static final UInt randomOrNull(kotlin.ranges.UIntRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.box-impl(URandomKt.nextUInt(random, $this$randomOrNull));
    }

    private static final ULong randomOrNull(kotlin.ranges.ULongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return URangesKt.randomOrNull($this$randomOrNull, (Random)Random.Default);
    }

    public static final ULong randomOrNull(kotlin.ranges.ULongRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.box-impl(URandomKt.nextULong(random, $this$randomOrNull));
    }

    public static final kotlin.ranges.UIntProgression reversed(kotlin.ranges.UIntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$reversed.getLast-pVg5ArA(), $this$reversed.getFirst-pVg5ArA(), -step);
    }

    public static final kotlin.ranges.ULongProgression reversed(kotlin.ranges.ULongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$reversed.getLast-s-VKNKU(), obj3, $this$reversed.getFirst-s-VKNKU());
    }

    public static final kotlin.ranges.UIntProgression step(kotlin.ranges.UIntProgression $this$step, int step) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        i = step > 0 ? 1 : 0;
        RangesKt.checkStepIsPositive(i, (Number)Integer.valueOf(step));
        i2 = $this$step.getStep() > 0 ? step : -step;
        return UIntProgression.Companion.fromClosedRange-Nkh28Cs($this$step.getFirst-pVg5ArA(), $this$step.getLast-pVg5ArA(), i2);
    }

    public static final kotlin.ranges.ULongProgression step(kotlin.ranges.ULongProgression $this$step, long step) {
        int cmp;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        int i3 = 0;
        i2 = Long.compare(step, i3) > 0 ? 1 : 0;
        RangesKt.checkStepIsPositive(i2, (Number)Long.valueOf(step));
        i = Long.compare(step2, i3) > 0 ? step : cmp;
        return ULongProgression.Companion.fromClosedRange-7ftBX0g($this$step.getFirst-s-VKNKU(), obj6, $this$step.getLast-s-VKNKU());
    }

    public static final kotlin.ranges.UIntRange until-5PvTz6A(short $this$until_u2d5PvTz6A, short to) {
        int i = 65535;
        if (Intrinsics.compare(to & i, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        UIntRange uIntRange = new UIntRange(UInt.constructor-impl($this$until_u2d5PvTz6A & i), UInt.constructor-impl(constructor-impl--), 0);
        return uIntRange;
    }

    public static final kotlin.ranges.UIntRange until-J1ME1BU(int $this$until_u2dJ1ME1BU, int to) {
        if (Integer.compareUnsigned(to, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        UIntRange uIntRange = new UIntRange($this$until_u2dJ1ME1BU, UInt.constructor-impl(to + -1), 0);
        return uIntRange;
    }

    public static final kotlin.ranges.UIntRange until-Kr8caGY(byte $this$until_u2dKr8caGY, byte to) {
        if (Intrinsics.compare(to & 255, 0) <= 0) {
            return UIntRange.Companion.getEMPTY();
        }
        UIntRange uIntRange = new UIntRange(UInt.constructor-impl($this$until_u2dKr8caGY & 255), UInt.constructor-impl(constructor-impl2--), 0);
        return uIntRange;
    }

    public static final kotlin.ranges.ULongRange until-eb3DHEI(long $this$until_u2deb3DHEI, long to) {
        if (Long.compareUnsigned(obj10, obj11) <= 0) {
            return ULongRange.Companion.getEMPTY();
        }
        ULongRange uLongRange = new ULongRange($this$until_u2deb3DHEI, obj4, ULong.constructor-impl(obj10 - constructor-impl), obj6, 0);
        return uLongRange;
    }
}
