package kotlin.time;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008*\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000c\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u001d\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010&\u001a\u0015\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\u0010\u001a\u0010\u0010/\u001a\u00020\u00012\u0006\u0010*\u001a\u00020\u0001H\u0002\u001a\u0010\u00100\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u0001H\u0002\u001a\u001d\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002¢\u0006\u0002\u00106\u001a\u0010\u00107\u001a\u00020\u00012\u0006\u00102\u001a\u000203H\u0002\u001a)\u00108\u001a\u00020\u0005*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\u0008\u001a)\u0010=\u001a\u000203*\u0002032\u0006\u00109\u001a\u00020\u00052\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002050;H\u0082\u0008\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00082\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008@\u0010A\u001a\u001c\u0010>\u001a\u00020\u0007*\u00020\u00052\u0006\u0010?\u001a\u00020\u0007H\u0087\n¢\u0006\u0004\u0008B\u0010C\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00082\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010G\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00052\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010H\u001a\u0019\u0010D\u001a\u00020\u0007*\u00020\u00012\u0006\u0010E\u001a\u00020FH\u0007¢\u0006\u0002\u0010I\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u000b\u0010\u000c\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\r\u001a\u0004\u0008\u000b\u0010\u000e\"\u001e\u0010\u0006\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\t\u0010\u000f\u001a\u0004\u0008\u000b\u0010\u0010\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\n\u001a\u0004\u0008\u0013\u0010\u000c\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\r\u001a\u0004\u0008\u0013\u0010\u000e\"\u001e\u0010\u0011\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u000f\u001a\u0004\u0008\u0013\u0010\u0010\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\n\u001a\u0004\u0008\u0016\u0010\u000c\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\r\u001a\u0004\u0008\u0016\u0010\u000e\"\u001e\u0010\u0014\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0015\u0010\u000f\u001a\u0004\u0008\u0016\u0010\u0010\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\n\u001a\u0004\u0008\u0019\u0010\u000c\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\r\u001a\u0004\u0008\u0019\u0010\u000e\"\u001e\u0010\u0017\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0018\u0010\u000f\u001a\u0004\u0008\u0019\u0010\u0010\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\n\u001a\u0004\u0008\u001c\u0010\u000c\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\r\u001a\u0004\u0008\u001c\u0010\u000e\"\u001e\u0010\u001a\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u000f\u001a\u0004\u0008\u001c\u0010\u0010\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001e\u0010\n\u001a\u0004\u0008\u001f\u0010\u000c\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001e\u0010\r\u001a\u0004\u0008\u001f\u0010\u000e\"\u001e\u0010\u001d\u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u001e\u0010\u000f\u001a\u0004\u0008\u001f\u0010\u0010\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00088FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\n\u001a\u0004\u0008\"\u0010\u000c\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00058FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\r\u001a\u0004\u0008\"\u0010\u000e\"\u001e\u0010 \u001a\u00020\u0007*\u00020\u00018FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\u000f\u001a\u0004\u0008\"\u0010\u0010¨\u0006J", d2 = {"MAX_MILLIS", "", "MAX_NANOS", "MAX_NANOS_IN_MILLIS", "NANOS_IN_MILLIS", "", "days", "Lkotlin/time/Duration;", "", "getDays$annotations", "(D)V", "getDays", "(D)J", "(I)V", "(I)J", "(J)V", "(J)J", "hours", "getHours$annotations", "getHours", "microseconds", "getMicroseconds$annotations", "getMicroseconds", "milliseconds", "getMilliseconds$annotations", "getMilliseconds", "minutes", "getMinutes$annotations", "getMinutes", "nanoseconds", "getNanoseconds$annotations", "getNanoseconds", "seconds", "getSeconds$annotations", "getSeconds", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfMillis", "normalMillis", "durationOfMillisNormalized", "millis", "durationOfNanos", "normalNanos", "durationOfNanosNormalized", "nanos", "millisToNanos", "nanosToMillis", "parseDuration", "value", "", "strictIso", "", "(Ljava/lang/String;Z)J", "parseOverLongIsoComponent", "skipWhile", "startIndex", "predicate", "Lkotlin/Function1;", "", "substringWhile", "times", "duration", "times-kIfJnKk", "(DJ)J", "times-mvk6XK0", "(IJ)J", "toDuration", "unit", "Lkotlin/time/DurationUnit;", "(DLkotlin/time/DurationUnit;)J", "(ILkotlin/time/DurationUnit;)J", "(JLkotlin/time/DurationUnit;)J", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DurationKt {

    public static final long MAX_MILLIS = 4611686018427387903L;
    public static final long MAX_NANOS = 4611686018426999999L;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final int NANOS_IN_MILLIS = 1000000;
    public static final long access$durationOf(long normalValue, int unitDiscriminator) {
        return DurationKt.durationOf(normalValue, unitDiscriminator);
    }

    public static final long access$durationOfMillis(long normalMillis) {
        return DurationKt.durationOfMillis(normalMillis);
    }

    public static final long access$durationOfMillisNormalized(long millis) {
        return DurationKt.durationOfMillisNormalized(millis);
    }

    public static final long access$durationOfNanos(long normalNanos) {
        return DurationKt.durationOfNanos(normalNanos);
    }

    public static final long access$durationOfNanosNormalized(long nanos) {
        return DurationKt.durationOfNanosNormalized(nanos);
    }

    public static final long access$millisToNanos(long millis) {
        return DurationKt.millisToNanos(millis);
    }

    public static final long access$nanosToMillis(long nanos) {
        return DurationKt.nanosToMillis(nanos);
    }

    public static final long access$parseDuration(String value, boolean strictIso) {
        return DurationKt.parseDuration(value, strictIso);
    }

    private static final long durationOf(long normalValue, int unitDiscriminator) {
        return Duration.constructor-impl(i2 += l);
    }

    private static final long durationOfMillis(long normalMillis) {
        return Duration.constructor-impl(i2 += i4);
    }

    private static final long durationOfMillisNormalized(long millis) {
        int cmp;
        long durationOfMillis;
        int i;
        long l;
        long l2;
        long l4;
        long l3;
        long obj8;
        i = 0;
        if (Long.compare(l5, millis) <= 0 && Long.compare(millis, l) < 0) {
            if (Long.compare(millis, l) < 0) {
                i = 1;
            }
        }
        if (i != 0) {
            durationOfMillis = DurationKt.durationOfNanos(DurationKt.millisToNanos(millis));
            l2 = millis;
        } else {
            durationOfMillis = DurationKt.durationOfMillis(RangesKt.coerceIn(millis, obj3, -4611686018427387903L));
        }
        return durationOfMillis;
    }

    private static final long durationOfNanos(long normalNanos) {
        return Duration.constructor-impl(normalNanos << i);
    }

    private static final long durationOfNanosNormalized(long nanos) {
        int cmp;
        long durationOfMillis;
        int i;
        long l;
        i = 0;
        if (Long.compare(l2, nanos) <= 0 && Long.compare(nanos, l) < 0) {
            if (Long.compare(nanos, l) < 0) {
                i = 1;
            }
        }
        if (i != 0) {
            durationOfMillis = DurationKt.durationOfNanos(nanos);
        } else {
            durationOfMillis = DurationKt.durationOfMillis(DurationKt.nanosToMillis(nanos));
        }
        return durationOfMillis;
    }

    public static final long getDays(double $this$days) {
        return DurationKt.toDuration($this$days, obj3);
    }

    public static final long getDays(int $this$days) {
        return DurationKt.toDuration($this$days, DurationUnit.DAYS);
    }

    public static final long getDays(long $this$days) {
        return DurationKt.toDuration($this$days, obj3);
    }

    @Deprecated(message = "Use 'Double.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getDays$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getDays$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.days' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getDays$annotations(long l) {
    }

    public static final long getHours(double $this$hours) {
        return DurationKt.toDuration($this$hours, obj3);
    }

    public static final long getHours(int $this$hours) {
        return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
    }

    public static final long getHours(long $this$hours) {
        return DurationKt.toDuration($this$hours, obj3);
    }

    @Deprecated(message = "Use 'Double.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getHours$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getHours$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.hours' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getHours$annotations(long l) {
    }

    public static final long getMicroseconds(double $this$microseconds) {
        return DurationKt.toDuration($this$microseconds, obj3);
    }

    public static final long getMicroseconds(int $this$microseconds) {
        return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
    }

    public static final long getMicroseconds(long $this$microseconds) {
        return DurationKt.toDuration($this$microseconds, obj3);
    }

    @Deprecated(message = "Use 'Double.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMicroseconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMicroseconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.microseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMicroseconds$annotations(long l) {
    }

    public static final long getMilliseconds(double $this$milliseconds) {
        return DurationKt.toDuration($this$milliseconds, obj3);
    }

    public static final long getMilliseconds(int $this$milliseconds) {
        return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
    }

    public static final long getMilliseconds(long $this$milliseconds) {
        return DurationKt.toDuration($this$milliseconds, obj3);
    }

    @Deprecated(message = "Use 'Double.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMilliseconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMilliseconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.milliseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMilliseconds$annotations(long l) {
    }

    public static final long getMinutes(double $this$minutes) {
        return DurationKt.toDuration($this$minutes, obj3);
    }

    public static final long getMinutes(int $this$minutes) {
        return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
    }

    public static final long getMinutes(long $this$minutes) {
        return DurationKt.toDuration($this$minutes, obj3);
    }

    @Deprecated(message = "Use 'Double.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMinutes$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMinutes$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.minutes' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getMinutes$annotations(long l) {
    }

    public static final long getNanoseconds(double $this$nanoseconds) {
        return DurationKt.toDuration($this$nanoseconds, obj3);
    }

    public static final long getNanoseconds(int $this$nanoseconds) {
        return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
    }

    public static final long getNanoseconds(long $this$nanoseconds) {
        return DurationKt.toDuration($this$nanoseconds, obj3);
    }

    @Deprecated(message = "Use 'Double.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getNanoseconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getNanoseconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.nanoseconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getNanoseconds$annotations(long l) {
    }

    public static final long getSeconds(double $this$seconds) {
        return DurationKt.toDuration($this$seconds, obj3);
    }

    public static final long getSeconds(int $this$seconds) {
        return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
    }

    public static final long getSeconds(long $this$seconds) {
        return DurationKt.toDuration($this$seconds, obj3);
    }

    @Deprecated(message = "Use 'Double.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getSeconds$annotations(double d) {
    }

    @Deprecated(message = "Use 'Int.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getSeconds$annotations(int i) {
    }

    @Deprecated(message = "Use 'Long.seconds' extension property from Duration.Companion instead.", replaceWith = @ReplaceWith(...))
    @DeprecatedSinceKotlin(errorSince = "1.8", hiddenSince = "1.9", warningSince = "1.5")
    public static void getSeconds$annotations(long l) {
    }

    private static final long millisToNanos(long millis) {
        return l *= millis;
    }

    private static final long nanosToMillis(long nanos) {
        return nanos / l;
    }

    private static final long parseDuration(String value, boolean strictIso) {
        String it2;
        int i20;
        int i$iv$iv2;
        int index;
        int index2;
        String component;
        long unaryMinus-UwyO8pc;
        int infinityString2;
        int length2;
        int i22;
        int contains$default;
        int $this$skipWhile$iv$iv;
        int i18;
        int prevUnit;
        int i17;
        Object length;
        int unitName;
        int afterFirst;
        int it;
        int i11;
        int it3;
        int i3;
        int length4;
        boolean startsWith$default;
        int whole;
        int i$iv;
        int i2;
        String $this$skipWhile$iv$iv2;
        int length5;
        long result;
        String charAt;
        int i6;
        int $i$f$substringWhile2;
        int allowSpaces;
        int i10;
        String isTimeComponent;
        int i$iv$iv;
        int i8;
        int i14;
        int i7;
        int i15;
        int index3;
        Object nonDigitSymbols;
        int $i$f$substringWhile;
        String infinityString;
        String str;
        int i21;
        String $this$skipWhile$iv$iv3;
        int i5;
        int i4;
        int length3;
        int i13;
        int i;
        int i12;
        int i16;
        int i9;
        int i19;
        it2 = value;
        whole = it2.length();
        if (whole == 0) {
        } else {
            if (/* condition */) {
                index++;
            } else {
            }
            int i30 = 0;
            i18 = index > 0 ? 1 : i30;
            allowSpaces = i18;
            if (allowSpaces != 0 && StringsKt.startsWith$default((CharSequence)it2, '-', i30, 2, 0)) {
                i3 = StringsKt.startsWith$default((CharSequence)it2, '-', i30, i27, prevUnit) ? 1 : i30;
            } else {
            }
            isTimeComponent = "No components";
            if (whole <= index) {
            } else {
                final String str14 = "Unexpected order of duration components";
                unitName = "substring(...)";
                String str11 = "null cannot be cast to non-null type java.lang.String";
                if (it2.charAt(index) == 80) {
                    if (index++ == whole) {
                    } else {
                        length4 = "+-.";
                        isTimeComponent = 0;
                        i$iv$iv = 0;
                        while (index < whole) {
                            length = value;
                            i6 = 0;
                            nonDigitSymbols = length;
                            $i$f$substringWhile = 0;
                            i$iv$iv2 = i21;
                            i21 = component;
                            while (i$iv$iv2 < nonDigitSymbols.length()) {
                                Object obj2 = nonDigitSymbols;
                                index3 = length4;
                                length4 = obj2.charAt(i$iv$iv2);
                                $this$skipWhile$iv$iv3 = 0;
                                if (48 <= length4 && length4 < 58) {
                                } else {
                                }
                                contains$default = 0;
                                if (contains$default == 0) {
                                } else {
                                }
                                length3 = whole;
                                i8 = i6;
                                i7 = allowSpaces;
                                length5 = 0;
                                $i$f$substringWhile2 = 2;
                                length2 = 1;
                                if (length2 != 0) {
                                    break loop_22;
                                }
                                i$iv$iv2++;
                                i6 = i8;
                                allowSpaces = i7;
                                length4 = index3;
                                component = i21;
                                nonDigitSymbols = i5;
                                whole = length3;
                                i21 = component;
                                length3 = whole;
                                i8 = i6;
                                i7 = allowSpaces;
                                if (StringsKt.contains$default((CharSequence)index3, length4, false, 2, 0)) {
                                } else {
                                }
                                length2 = 0;
                                if (length4 < 58) {
                                } else {
                                }
                                contains$default = 1;
                            }
                            length3 = whole;
                            i8 = i6;
                            i7 = allowSpaces;
                            i5 = nonDigitSymbols;
                            length5 = 0;
                            $i$f$substringWhile2 = 2;
                            index3 = length4;
                            Intrinsics.checkNotNull(length, str11);
                            String substring = length.substring(index, i$iv$iv2);
                            Intrinsics.checkNotNullExpressionValue(substring, unitName);
                            if ((CharSequence)substring.length() == 0) {
                            } else {
                            }
                            i22 = 0;
                            index += length11;
                            String str7 = value;
                            if (index5 >= 0 && index5 < (CharSequence)str7.length()) {
                            } else {
                            }
                            i17 = 0;
                            index5++;
                            prevUnit = DurationUnitKt.durationUnitByIsoChar(str7.charAt(index5), isTimeComponent);
                            i$iv$iv = prevUnit;
                            int indexOf$default = StringsKt.indexOf$default((CharSequence)substring, '.', 0, false, 6, 0);
                            kotlin.time.DurationUnit sECONDS = DurationUnit.SECONDS;
                            if (prevUnit == sECONDS && indexOf$default > 0) {
                            } else {
                            }
                            result = Duration.plus-LRDsOJo(result, obj8);
                            it2 = value;
                            allowSpaces = i7;
                            length4 = index3;
                            component = i21;
                            whole = length3;
                            if (indexOf$default > 0) {
                            } else {
                            }
                            Intrinsics.checkNotNull(substring, str11);
                            int i31 = 0;
                            String substring4 = substring.substring(i31, indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring4, unitName);
                            Intrinsics.checkNotNull(substring, str11);
                            String substring5 = substring.substring(indexOf$default);
                            Intrinsics.checkNotNullExpressionValue(substring5, unitName);
                            result = Duration.plus-LRDsOJo(Duration.plus-LRDsOJo(result, obj8), obj8);
                            it2 = value;
                            allowSpaces = i7;
                            length4 = index3;
                            component = i21;
                            whole = length3;
                            if (index5 < str7.length()) {
                            } else {
                            }
                            i17 = 1;
                            i22 = 1;
                            obj2 = nonDigitSymbols;
                            index3 = length4;
                            length4 = obj2.charAt(i$iv$iv2);
                            $this$skipWhile$iv$iv3 = 0;
                            if (48 <= length4 && length4 < 58) {
                            } else {
                            }
                            contains$default = 0;
                            if (contains$default == 0) {
                            } else {
                            }
                            length3 = whole;
                            i8 = i6;
                            i7 = allowSpaces;
                            length5 = 0;
                            $i$f$substringWhile2 = 2;
                            length2 = 1;
                            if (length2 != 0) {
                            }
                            i$iv$iv2++;
                            i6 = i8;
                            allowSpaces = i7;
                            length4 = index3;
                            component = i21;
                            nonDigitSymbols = i5;
                            whole = length3;
                            length3 = whole;
                            i8 = i6;
                            i7 = allowSpaces;
                            if (StringsKt.contains$default((CharSequence)index3, length4, false, 2, 0)) {
                            } else {
                            }
                            length2 = 0;
                            if (length4 < 58) {
                            } else {
                            }
                            contains$default = 1;
                            isTimeComponent = 1;
                        }
                        infinityString = component;
                        index3 = length4;
                        i4 = whole;
                        i14 = allowSpaces;
                        if (i3 != 0) {
                            unaryMinus-UwyO8pc = Duration.unaryMinus-UwyO8pc(result);
                        } else {
                            unaryMinus-UwyO8pc = result;
                        }
                        return unaryMinus-UwyO8pc;
                    }
                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException();
                    throw illegalArgumentException4;
                }
                str = component;
                i4 = whole;
                i14 = allowSpaces;
                if (strictIso) {
                } else {
                    charAt = unitName;
                    component = str;
                    i$iv = 48;
                    it2 = value;
                    if (StringsKt.regionMatches(it2, index, component, 0, Math.max(i4 - index, str.length()), true)) {
                        result = Duration.Companion.getINFINITE-UwyO8pc();
                        infinityString = component;
                        whole = i4;
                    } else {
                        prevUnit = 0;
                        unitName = 0;
                        allowSpaces = i14 == 0 ? 1 : 0;
                        if (i14 != 0 && it2.charAt(index) == 40 && StringsKt.last((CharSequence)it2) == 41) {
                            if (it2.charAt(index) == 40) {
                                if (StringsKt.last((CharSequence)it2) == 41) {
                                    allowSpaces = 1;
                                    if (index++ == i4 + -1) {
                                    } else {
                                        while (index < length4) {
                                            if (unitName != 0 && allowSpaces != 0) {
                                            } else {
                                            }
                                            index2 = index3;
                                            afterFirst = 1;
                                            String str2 = value;
                                            i2 = 0;
                                            String str13 = str2;
                                            int i35 = 0;
                                            str = component;
                                            infinityString2 = i8;
                                            i8 = afterFirst;
                                            while (infinityString2 < str13.length()) {
                                                char charAt6 = str13.charAt(infinityString2);
                                                index3 = 0;
                                                if (48 <= charAt6) {
                                                } else {
                                                }
                                                i2 = 58;
                                                i15 = 0;
                                                if (i15 == 0) {
                                                } else {
                                                }
                                                it = 1;
                                                if (it != 0) {
                                                    break loop_84;
                                                }
                                                infinityString2++;
                                                afterFirst = i8;
                                                i2 = $i$f$substringWhile;
                                                i8 = afterFirst;
                                                if (charAt6 == 46) {
                                                } else {
                                                }
                                                it = 0;
                                                if (charAt6 < 58) {
                                                } else {
                                                }
                                                i15 = 1;
                                            }
                                            $i$f$substringWhile = i2;
                                            Intrinsics.checkNotNull(str2, str11);
                                            String substring2 = str2.substring(index2, infinityString2);
                                            Intrinsics.checkNotNullExpressionValue(substring2, charAt);
                                            if ((CharSequence)substring2.length() == 0) {
                                            } else {
                                            }
                                            i20 = 0;
                                            index2 += length8;
                                            String str4 = value;
                                            i11 = 0;
                                            $this$skipWhile$iv$iv2 = str4;
                                            int i33 = 0;
                                            i$iv$iv = index4;
                                            while (i$iv$iv < $this$skipWhile$iv$iv2.length()) {
                                                char charAt5 = $this$skipWhile$iv$iv2.charAt(i$iv$iv);
                                                $i$f$substringWhile = 0;
                                                if (97 <= charAt5 && charAt5 < 123) {
                                                } else {
                                                }
                                                it3 = 0;
                                                if (it3 != 0) {
                                                    break loop_103;
                                                }
                                                i$iv$iv++;
                                                i11 = index3;
                                                $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv3;
                                                if (charAt5 < 123) {
                                                } else {
                                                }
                                                it3 = 1;
                                            }
                                            $this$skipWhile$iv$iv3 = $this$skipWhile$iv$iv2;
                                            Intrinsics.checkNotNull(str4, str11);
                                            String substring3 = str4.substring(index4, i$iv$iv);
                                            Intrinsics.checkNotNullExpressionValue(substring3, charAt);
                                            kotlin.time.DurationUnit durationUnitByShortName = DurationUnitKt.durationUnitByShortName(substring3);
                                            prevUnit = durationUnitByShortName;
                                            int indexOf$default2 = StringsKt.indexOf$default((CharSequence)substring2, '.', 0, false, 6, 0);
                                            result = Duration.plus-LRDsOJo(result, obj8);
                                            i$iv = 48;
                                            it2 = value;
                                            unitName = i8;
                                            component = str;
                                            Intrinsics.checkNotNull(substring2, str11);
                                            i$iv$iv = substring2.substring(0, indexOf$default2);
                                            Intrinsics.checkNotNullExpressionValue(i$iv$iv, charAt);
                                            Intrinsics.checkNotNull(substring2, str11);
                                            String substring6 = substring2.substring(indexOf$default2);
                                            Intrinsics.checkNotNullExpressionValue(substring6, charAt);
                                            result = Duration.plus-LRDsOJo(Duration.plus-LRDsOJo(result, obj8), obj8);
                                            i$iv = 48;
                                            it2 = value;
                                            unitName = i8;
                                            component = str;
                                            charAt5 = $this$skipWhile$iv$iv2.charAt(i$iv$iv);
                                            $i$f$substringWhile = 0;
                                            if (97 <= charAt5 && charAt5 < 123) {
                                            } else {
                                            }
                                            it3 = 0;
                                            if (it3 != 0) {
                                            }
                                            i$iv$iv++;
                                            i11 = index3;
                                            $this$skipWhile$iv$iv2 = $this$skipWhile$iv$iv3;
                                            if (charAt5 < 123) {
                                            } else {
                                            }
                                            it3 = 1;
                                            i20 = 1;
                                            charAt6 = str13.charAt(infinityString2);
                                            index3 = 0;
                                            if (48 <= charAt6) {
                                            } else {
                                            }
                                            i2 = 58;
                                            i15 = 0;
                                            if (i15 == 0) {
                                            } else {
                                            }
                                            it = 1;
                                            if (it != 0) {
                                            }
                                            infinityString2++;
                                            afterFirst = i8;
                                            i2 = $i$f$substringWhile;
                                            if (charAt6 == 46) {
                                            } else {
                                            }
                                            it = 0;
                                            if (charAt6 < 58) {
                                            } else {
                                            }
                                            i15 = 1;
                                            if (allowSpaces != 0) {
                                            } else {
                                            }
                                            isTimeComponent = value;
                                            i$iv$iv = 0;
                                            i$iv = i8;
                                            while (i$iv < isTimeComponent.length()) {
                                                i8 = 0;
                                                if (isTimeComponent.charAt(i$iv) == 32) {
                                                } else {
                                                }
                                                it2 = 0;
                                                if (it2 != 0) {
                                                    break loop_74;
                                                }
                                                i$iv++;
                                                it2 = value;
                                                index = index3;
                                                it2 = 1;
                                            }
                                            index3 = index;
                                            index2 = i$iv;
                                            i8 = 0;
                                            if (isTimeComponent.charAt(i$iv) == 32) {
                                            } else {
                                            }
                                            it2 = 0;
                                            if (it2 != 0) {
                                            }
                                            i$iv++;
                                            it2 = value;
                                            index = index3;
                                            it2 = 1;
                                        }
                                        index3 = index;
                                        infinityString = component;
                                        whole = length4;
                                    }
                                    IllegalArgumentException illegalArgumentException10 = new IllegalArgumentException(isTimeComponent);
                                    throw illegalArgumentException10;
                                }
                            }
                        }
                        length4 = i4;
                    }
                }
                IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException();
                throw illegalArgumentException3;
            }
            IllegalArgumentException illegalArgumentException5 = new IllegalArgumentException(isTimeComponent);
            throw illegalArgumentException5;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The string is empty");
        throw illegalArgumentException;
    }

    private static final long parseOverLongIsoComponent(String value) {
        int startIndex;
        long l;
        long long;
        boolean contains$default;
        int $this$all$iv;
        char charAt2;
        int i;
        boolean iterator;
        int nextInt;
        int it;
        int i2;
        char charAt;
        int i3;
        final int length = value.length();
        int i4 = 0;
        int i5 = 2;
        final int i7 = 0;
        if (length > 0 && StringsKt.contains$default((CharSequence)"+-", value.charAt(i7), i7, i5, i4)) {
            if (StringsKt.contains$default((CharSequence)"+-", value.charAt(i7), i7, i5, i4)) {
                startIndex++;
            }
        }
        final int i8 = 1;
        if (length - startIndex > 16) {
            IntRange intRange = new IntRange(startIndex, StringsKt.getLastIndex((CharSequence)value));
            i = 0;
            if (intRange instanceof Collection != null && (Collection)(Iterable)intRange.isEmpty()) {
                if ((Collection)intRange.isEmpty()) {
                    $this$all$iv = i8;
                } else {
                    iterator = intRange.iterator();
                    while (iterator.hasNext()) {
                        i2 = 0;
                        charAt = value.charAt((IntIterator)iterator.nextInt());
                        if (48 <= charAt && charAt < 58) {
                        } else {
                        }
                        it = i7;
                        if (charAt < 58) {
                        } else {
                        }
                        it = i8;
                    }
                    $this$all$iv = i8;
                }
            } else {
            }
            if ($this$all$iv != 0) {
                l = value.charAt(i7) == 45 ? -9223372036854775808L : 9223372036854775807L;
                return l;
            }
        }
        if (StringsKt.startsWith$default(value, "+", i7, i5, i4)) {
            long = Long.parseLong(StringsKt.drop(value, i8));
        } else {
            long = Long.parseLong(value);
        }
        return long;
    }

    private static final int skipWhile(String $this$skipWhile, int startIndex, Function1<? super Character, Boolean> predicate) {
        int i;
        boolean booleanValue;
        final int i2 = 0;
        i = startIndex;
        while (i < $this$skipWhile.length()) {
            if ((Boolean)predicate.invoke(Character.valueOf($this$skipWhile.charAt(i))).booleanValue()) {
            }
            i++;
        }
        return i;
    }

    private static final String substringWhile(String $this$substringWhile, int startIndex, Function1<? super Character, Boolean> predicate) {
        int i$iv;
        boolean booleanValue;
        final int i = 0;
        Object obj = $this$substringWhile;
        int i2 = 0;
        i$iv = startIndex;
        while (i$iv < obj.length()) {
            if ((Boolean)predicate.invoke(Character.valueOf(obj.charAt(i$iv))).booleanValue()) {
            }
            i$iv++;
        }
        Intrinsics.checkNotNull($this$substringWhile, "null cannot be cast to non-null type java.lang.String");
        String substring = $this$substringWhile.substring(startIndex, i$iv);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return substring;
    }

    private static final long times-kIfJnKk(double $this$times_u2dkIfJnKk, long duration) {
        return Duration.times-UwyO8pc(obj4, obj5);
    }

    private static final long times-mvk6XK0(int $this$times_u2dmvk6XK0, long duration) {
        return Duration.times-UwyO8pc(duration, obj4);
    }

    public static final long toDuration(double $this$toDuration, kotlin.time.DurationUnit unit) {
        int cmp;
        long millis;
        int i;
        long durationOfMillisNormalized;
        Intrinsics.checkNotNullParameter(obj10, "unit");
        double convertDurationUnit = DurationUnitKt.convertDurationUnit($this$toDuration, unit, obj10);
        if (Double.isNaN(convertDurationUnit)) {
        } else {
            long roundToLong = MathKt.roundToLong(convertDurationUnit);
            i = 0;
            if (Long.compare(l, roundToLong) <= 0 && Long.compare(roundToLong, durationOfMillisNormalized) < 0) {
                if (Long.compare(roundToLong, durationOfMillisNormalized) < 0) {
                    i = 1;
                }
            }
            if (i != 0) {
                millis = DurationKt.durationOfNanos(roundToLong);
            } else {
                millis = durationOfMillisNormalized;
            }
            return millis;
        }
        int nanos = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Duration value cannot be NaN.".toString());
        throw illegalArgumentException;
    }

    public static final long toDuration(int $this$toDuration, kotlin.time.DurationUnit unit) {
        long durationOfNanos;
        kotlin.time.DurationUnit nANOSECONDS;
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit.compareTo((Enum)DurationUnit.SECONDS) <= 0) {
            durationOfNanos = DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow((long)$this$toDuration, obj1, unit));
        } else {
            durationOfNanos = DurationKt.toDuration((long)$this$toDuration, obj1);
        }
        return durationOfNanos;
    }

    public static final long toDuration(long $this$toDuration, kotlin.time.DurationUnit unit) {
        int cmp;
        int i;
        Intrinsics.checkNotNullParameter(obj11, "unit");
        long convertDurationUnitOverflow = DurationUnitKt.convertDurationUnitOverflow(4611686018426999999L, obj1, DurationUnit.NANOSECONDS);
        i = 0;
        if (Long.compare(i2, $this$toDuration) <= 0 && Long.compare($this$toDuration, convertDurationUnitOverflow) <= 0) {
            if (Long.compare($this$toDuration, convertDurationUnitOverflow) <= 0) {
                i = 1;
            }
        }
        if (i != 0) {
            return DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow($this$toDuration, unit, obj11));
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit($this$toDuration, unit, obj11), obj4, -4611686018427387903L));
    }
}
