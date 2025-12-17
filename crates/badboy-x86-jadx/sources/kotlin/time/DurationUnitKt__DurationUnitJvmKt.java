package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\u000c\u0010\u0008\u001a\u00020\u0004*\u00020\tH\u0007\u001a\u000c\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¨\u0006\u000b", d2 = {"convertDurationUnit", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "toDurationUnit", "Ljava/util/concurrent/TimeUnit;", "toTimeUnit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal7;
            int ordinal2;
            int ordinal4;
            int ordinal6;
            int ordinal3;
            int ordinal;
            int ordinal5;
            int[] iArr = new int[values.length];
            iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            iArr[TimeUnit.MICROSECONDS.ordinal()] = 2;
            iArr[TimeUnit.MILLISECONDS.ordinal()] = 3;
            iArr[TimeUnit.SECONDS.ordinal()] = 4;
            iArr[TimeUnit.MINUTES.ordinal()] = 5;
            iArr[TimeUnit.HOURS.ordinal()] = 6;
            iArr[TimeUnit.DAYS.ordinal()] = 7;
            DurationUnitKt__DurationUnitJvmKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final double convertDurationUnit(double value, kotlin.time.DurationUnit sourceUnit, kotlin.time.DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(targetUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(obj9, "targetUnit");
        int i = 1;
        long convert = obj9.getTimeUnit$kotlin_stdlib().convert(i, obj3);
        if (Long.compare(convert, i3) > 0) {
            return d *= value;
        }
        return value / d2;
    }

    public static final long convertDurationUnit(long value, kotlin.time.DurationUnit sourceUnit, kotlin.time.DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(targetUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(obj5, "targetUnit");
        return obj5.getTimeUnit$kotlin_stdlib().convert(value, sourceUnit);
    }

    public static final long convertDurationUnitOverflow(long value, kotlin.time.DurationUnit sourceUnit, kotlin.time.DurationUnit targetUnit) {
        Intrinsics.checkNotNullParameter(targetUnit, "sourceUnit");
        Intrinsics.checkNotNullParameter(obj5, "targetUnit");
        return obj5.getTimeUnit$kotlin_stdlib().convert(value, sourceUnit);
    }

    public static final kotlin.time.DurationUnit toDurationUnit(TimeUnit $this$toDurationUnit) {
        kotlin.time.DurationUnit mICROSECONDS;
        Intrinsics.checkNotNullParameter($this$toDurationUnit, "<this>");
        switch (i) {
            case 1:
                mICROSECONDS = DurationUnit.NANOSECONDS;
                break;
            case 2:
                mICROSECONDS = DurationUnit.MICROSECONDS;
                break;
            case 3:
                mICROSECONDS = DurationUnit.MILLISECONDS;
                break;
            case 4:
                mICROSECONDS = DurationUnit.SECONDS;
                break;
            case 5:
                mICROSECONDS = DurationUnit.MINUTES;
                break;
            case 6:
                mICROSECONDS = DurationUnit.HOURS;
                break;
            case 7:
                mICROSECONDS = DurationUnit.DAYS;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return mICROSECONDS;
    }

    public static final TimeUnit toTimeUnit(kotlin.time.DurationUnit $this$toTimeUnit) {
        Intrinsics.checkNotNullParameter($this$toTimeUnit, "<this>");
        return $this$toTimeUnit.getTimeUnit$kotlin_stdlib();
    }
}
