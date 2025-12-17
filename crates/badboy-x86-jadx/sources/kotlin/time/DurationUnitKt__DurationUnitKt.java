package kotlin.time;

import android.app.Notification.Action;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0008H\u0001\u001a\u000c\u0010\u0007\u001a\u00020\u0008*\u00020\u0001H\u0001¨\u0006\t", d2 = {"durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends kotlin.time.DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal5;
            int ordinal4;
            int ordinal6;
            int ordinal7;
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[DurationUnit.NANOSECONDS.ordinal()] = 1;
            iArr[DurationUnit.MICROSECONDS.ordinal()] = 2;
            iArr[DurationUnit.MILLISECONDS.ordinal()] = 3;
            iArr[DurationUnit.SECONDS.ordinal()] = 4;
            iArr[DurationUnit.MINUTES.ordinal()] = 5;
            iArr[DurationUnit.HOURS.ordinal()] = 6;
            iArr[DurationUnit.DAYS.ordinal()] = 7;
            DurationUnitKt__DurationUnitKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final kotlin.time.DurationUnit durationUnitByIsoChar(char isoChar, boolean isTimeComponent) {
        kotlin.time.DurationUnit mINUTES;
        if (!isTimeComponent) {
            if (isoChar != 68) {
            } else {
                mINUTES = DurationUnit.DAYS;
                return mINUTES;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid or unsupported duration ISO non-time unit: ").append(isoChar).toString());
            throw illegalArgumentException;
        }
        switch (isoChar) {
            case 72:
                mINUTES = DurationUnit.HOURS;
                break;
            case 77:
                mINUTES = DurationUnit.MINUTES;
                break;
            case 83:
                mINUTES = DurationUnit.SECONDS;
                break;
            default:
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("Invalid duration ISO time unit: ").append(isoChar).toString());
                throw illegalArgumentException2;
        }
    }

    public static final kotlin.time.DurationUnit durationUnitByShortName(String shortName) {
        int equals;
        kotlin.time.DurationUnit mILLISECONDS;
        Intrinsics.checkNotNullParameter(shortName, "shortName");
        switch (shortName) {
            case "d":
                mILLISECONDS = DurationUnit.DAYS;
                return mILLISECONDS;
            case "h":
                mILLISECONDS = DurationUnit.HOURS;
                return mILLISECONDS;
            case "m":
                mILLISECONDS = DurationUnit.MINUTES;
                return mILLISECONDS;
            case "s":
                mILLISECONDS = DurationUnit.SECONDS;
                return mILLISECONDS;
            case "ms":
                mILLISECONDS = DurationUnit.MILLISECONDS;
                return mILLISECONDS;
            case "ns":
                mILLISECONDS = DurationUnit.NANOSECONDS;
                return mILLISECONDS;
            case "us":
                mILLISECONDS = DurationUnit.MICROSECONDS;
                return mILLISECONDS;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unknown duration unit short name: ").append(shortName).toString());
        throw illegalArgumentException;
    }

    public static final String shortName(kotlin.time.DurationUnit $this$shortName) {
        String str;
        Intrinsics.checkNotNullParameter($this$shortName, "<this>");
        switch (i) {
            case 1:
                str = "ns";
                break;
            case 2:
                str = "us";
                break;
            case 3:
                str = "ms";
                break;
            case 4:
                str = "s";
                break;
            case 5:
                str = "m";
                break;
            case 6:
                str = "h";
                break;
            case 7:
                str = "d";
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Unknown unit: ").append($this$shortName).toString().toString());
                throw illegalStateException;
        }
        return str;
    }
}
