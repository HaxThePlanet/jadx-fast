package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a\u0015\u0010\u0008\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\u0008\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000cH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000cH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u000cH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\u0008¨\u0006\u001d", d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", "unit", "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LongSaturatedMathKt {
    private static final long checkInfiniteSumDefined-PjuGub4(long value, long duration, long durationInUnit) {
        boolean infinite-impl;
        int i;
        if (Duration.isInfinite-impl(durationInUnit)) {
            if (Long.compare(i2, i) < 0) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Summing infinities of different signs");
            throw illegalArgumentException;
        }
        return value;
    }

    private static final long infinityOfSign(long value) {
        long nEG_INFINITE-UwyO8pc$kotlin_stdlib;
        if (Long.compare(value, i) < 0) {
            nEG_INFINITE-UwyO8pc$kotlin_stdlib = Duration.Companion.getNEG_INFINITE-UwyO8pc$kotlin_stdlib();
        } else {
            nEG_INFINITE-UwyO8pc$kotlin_stdlib = Duration.Companion.getINFINITE-UwyO8pc();
        }
        return nEG_INFINITE-UwyO8pc$kotlin_stdlib;
    }

    public static final boolean isSaturated(long $this$isSaturated) {
        int i;
        final int i2 = 0;
        int i3 = 1;
        i = Long.compare(i4, l) == 0 ? 1 : 0;
        return i;
    }

    public static final long saturatingAdd-NuflL3o(long value, kotlin.time.DurationUnit unit, long duration) {
        int $this$isSaturated$iv;
        int i;
        long l;
        final Object obj = duration;
        Intrinsics.checkNotNullParameter(obj, "unit");
        long l3 = obj18;
        final long long-impl = Duration.toLong-impl(l3, obj5);
        int i11 = 1;
        l = Long.MAX_VALUE;
        final int i16 = 0;
        $this$isSaturated$iv = Long.compare(i15, l) == 0 ? i : i16;
        if ($this$isSaturated$iv != 0) {
            return LongSaturatedMathKt.checkInfiniteSumDefined-PjuGub4(value, 0, l3);
        }
        int i6 = 0;
        if (Long.compare(i10, l) == 0) {
        } else {
            i = i16;
        }
        if (i != 0) {
            return LongSaturatedMathKt.saturatingAddInHalves-NuflL3o(value, unit, duration);
        }
        int i3 = value + long-impl;
        int i13 = 0;
        if (Long.compare(i8, i13) < 0 && Long.compare(value, i13) < 0) {
            if (Long.compare(value, i13) < 0) {
                l = Long.MIN_VALUE;
            }
            return l;
        }
        return i3;
    }

    private static final long saturatingAddInHalves-NuflL3o(long value, kotlin.time.DurationUnit unit, long duration) {
        int i;
        long div-UwyO8pc = Duration.div-UwyO8pc(obj14, obj15);
        final long long-impl = Duration.toLong-impl(div-UwyO8pc, obj1);
        int i3 = 0;
        int i4 = 1;
        i = Long.compare(i5, l2) == 0 ? 1 : 0;
        if (i != 0) {
            return long-impl;
        }
        return LongSaturatedMathKt.saturatingAdd-NuflL3o(LongSaturatedMathKt.saturatingAdd-NuflL3o(value, unit, duration), obj5, duration);
    }

    public static final long saturatingDiff(long valueNs, long origin, kotlin.time.DurationUnit unit) {
        int i;
        Intrinsics.checkNotNullParameter(obj11, "unit");
        final int i3 = 0;
        int i4 = 1;
        i = Long.compare(i5, l) == 0 ? 1 : 0;
        if (i != 0) {
            return Duration.unaryMinus-UwyO8pc(LongSaturatedMathKt.infinityOfSign(unit));
        }
        return LongSaturatedMathKt.saturatingFiniteDiff(valueNs, origin, unit);
    }

    private static final long saturatingFiniteDiff(long value1, long value2, kotlin.time.DurationUnit unit) {
        final kotlin.time.DurationUnit durationUnit = obj17;
        final int i = value1 - unit;
        if (Long.compare(i3, i7) < 0 && durationUnit.compareTo((Enum)DurationUnit.MILLISECONDS) < 0) {
            if (durationUnit.compareTo((Enum)DurationUnit.MILLISECONDS) < 0) {
                long convertDurationUnit = DurationUnitKt.convertDurationUnit(1, obj4, DurationUnit.MILLISECONDS);
                kotlin.time.Duration.Companion companion = Duration.Companion;
                return Duration.plus-LRDsOJo(DurationKt.toDuration(i8 -= i10, obj6), obj10);
            }
            return Duration.unaryMinus-UwyO8pc(LongSaturatedMathKt.infinityOfSign(i));
        }
        return DurationKt.toDuration(i, obj2);
    }

    public static final long saturatingOriginsDiff(long origin1, long origin2, kotlin.time.DurationUnit unit) {
        int $i$f$isSaturated;
        int i;
        Intrinsics.checkNotNullParameter(obj17, "unit");
        int i2 = 0;
        int i5 = 1;
        final long l2 = Long.MAX_VALUE;
        final int i9 = 0;
        $i$f$isSaturated = Long.compare(i8, l2) == 0 ? i : i9;
        if ($i$f$isSaturated != 0 && Long.compare(origin1, unit) == 0) {
            if (Long.compare(origin1, unit) == 0) {
                return Duration.Companion.getZERO-UwyO8pc();
            }
            return Duration.unaryMinus-UwyO8pc(LongSaturatedMathKt.infinityOfSign(unit));
        }
        int i3 = 0;
        if (Long.compare(i6, l2) == 0) {
        } else {
            i = i9;
        }
        if (i != 0) {
            return LongSaturatedMathKt.infinityOfSign(origin1);
        }
        return LongSaturatedMathKt.saturatingFiniteDiff(origin1, origin2, unit);
    }
}
