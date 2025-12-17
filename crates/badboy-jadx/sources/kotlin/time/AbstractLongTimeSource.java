package kotlin.time;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\r\u001a\u00020\u0008H\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0008H$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\u00088BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000b\u0010\u000c\u001a\u0004\u0008\t\u0010\n¨\u0006\u0012", d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements kotlin.time.TimeSource.WithComparableMarks {

    private final kotlin.time.DurationUnit unit;
    private final Lazy zero$delegate;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001c", d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class LongTimeMark implements kotlin.time.ComparableTimeMark {

        private final long offset;
        private final long startedAt;
        private final kotlin.time.AbstractLongTimeSource timeSource;
        private LongTimeMark(long startedAt, kotlin.time.AbstractLongTimeSource timeSource, long offset) {
            Intrinsics.checkNotNullParameter(offset, "timeSource");
            super();
            this.startedAt = startedAt;
            this.timeSource = offset;
            this.offset = obj5;
        }

        public LongTimeMark(long l, kotlin.time.AbstractLongTimeSource abstractLongTimeSource2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
            super(l, abstractLongTimeSource2, l3, defaultConstructorMarker4, obj5);
        }

        @Override // kotlin.time.ComparableTimeMark
        public int compareTo(Object other) {
            return compareTo((ComparableTimeMark)other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public int compareTo(kotlin.time.ComparableTimeMark other) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public long elapsedNow-UwyO8pc() {
            return Duration.minus-LRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), obj1, this.startedAt), obj1);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object other) {
            int i;
            boolean equal;
            kotlin.time.AbstractLongTimeSource timeSource;
            long zERO-UwyO8pc;
            timeSource = obj2.timeSource;
            if (other instanceof AbstractLongTimeSource.LongTimeMark && Intrinsics.areEqual(this.timeSource, timeSource) && Duration.equals-impl0(minus-UwyO8pc((ComparableTimeMark)other), timeSource)) {
                timeSource = obj2.timeSource;
                if (Intrinsics.areEqual(this.timeSource, timeSource)) {
                    i = Duration.equals-impl0(minus-UwyO8pc((ComparableTimeMark)other), timeSource) ? 1 : 0;
                } else {
                }
            } else {
            }
            return i;
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return i2 += i4;
        }

        @Override // kotlin.time.ComparableTimeMark
        public kotlin.time.ComparableTimeMark minus-LRDsOJo(long duration) {
            return ComparableTimeMark.DefaultImpls.minus-LRDsOJo(this, duration);
        }

        @Override // kotlin.time.ComparableTimeMark
        public kotlin.time.TimeMark minus-LRDsOJo(long duration) {
            return (TimeMark)minus-LRDsOJo(duration);
        }

        @Override // kotlin.time.ComparableTimeMark
        public long minus-UwyO8pc(kotlin.time.ComparableTimeMark other) {
            boolean equal;
            kotlin.time.AbstractLongTimeSource timeSource;
            Intrinsics.checkNotNullParameter(other, "other");
            if (!other instanceof AbstractLongTimeSource.LongTimeMark) {
            } else {
                timeSource = obj.timeSource;
                if (!Intrinsics.areEqual(this.timeSource, timeSource)) {
                } else {
                    return Duration.plus-LRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, timeSource, obj2.startedAt), timeSource);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException startedAtDiff = new IllegalArgumentException(stringBuilder.append("Subtracting or comparing time marks from different time sources is not possible: ").append(this).append(" and ").append(other).toString());
            throw startedAtDiff;
        }

        @Override // kotlin.time.ComparableTimeMark
        public kotlin.time.ComparableTimeMark plus-LRDsOJo(long duration) {
            long duration2;
            long zERO-UwyO8pc;
            long sum;
            long restUnderUnit;
            int cmp2;
            int cmp;
            int i;
            long l;
            final Object obj = this;
            duration2 = duration;
            kotlin.time.DurationUnit unit = obj.timeSource.getUnit();
            if (Duration.isInfinite-impl(duration2)) {
                AbstractLongTimeSource.LongTimeMark longTimeMark = new AbstractLongTimeSource.LongTimeMark(LongSaturatedMathKt.saturatingAdd-NuflL3o(obj.startedAt, obj5, unit), obj8, obj.timeSource, Duration.Companion.getZERO-UwyO8pc(), obj11, 0);
                return (ComparableTimeMark)longTimeMark;
            }
            long truncateTo-UwyO8pc$kotlin_stdlib = Duration.truncateTo-UwyO8pc$kotlin_stdlib(duration2, obj2);
            long plus-LRDsOJo = Duration.plus-LRDsOJo(Duration.minus-LRDsOJo(duration2, obj2), obj7);
            long truncateTo-UwyO8pc$kotlin_stdlib2 = Duration.truncateTo-UwyO8pc$kotlin_stdlib(plus-LRDsOJo, obj7);
            sum = LongSaturatedMathKt.saturatingAdd-NuflL3o(LongSaturatedMathKt.saturatingAdd-NuflL3o(obj.startedAt, obj9, unit), obj9, unit);
            restUnderUnit = Duration.minus-LRDsOJo(plus-LRDsOJo, obj7);
            final long inWholeNanoseconds-impl = Duration.getInWholeNanoseconds-impl(restUnderUnit);
            cmp2 = 0;
            if (Long.compare(sum, cmp2) != 0 && Long.compare(inWholeNanoseconds-impl, cmp2) != 0 && Long.compare(cmp, cmp2) < 0) {
                if (Long.compare(inWholeNanoseconds-impl, cmp2) != 0) {
                    if (Long.compare(cmp, cmp2) < 0) {
                        duration2 = DurationKt.toDuration(MathKt.getSign(inWholeNanoseconds-impl), unit);
                        sum = LongSaturatedMathKt.saturatingAdd-NuflL3o(sum, obj9, unit);
                        restUnderUnit = Duration.minus-LRDsOJo(restUnderUnit, obj13);
                    }
                }
            }
            final long l2 = sum;
            int i3 = 0;
            int i4 = 1;
            long l3 = Long.MAX_VALUE;
            i = Long.compare(i5, l3) == 0 ? 1 : 0;
            if (i != 0) {
                l = zERO-UwyO8pc;
            } else {
                l = restUnderUnit;
            }
            AbstractLongTimeSource.LongTimeMark longTimeMark2 = new AbstractLongTimeSource.LongTimeMark(l2, cmp, obj.timeSource, l, l3, 0);
            return (ComparableTimeMark)longTimeMark2;
        }

        @Override // kotlin.time.ComparableTimeMark
        public kotlin.time.TimeMark plus-LRDsOJo(long duration) {
            return (TimeMark)plus-LRDsOJo(duration);
        }

        @Override // kotlin.time.ComparableTimeMark
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("LongTimeMark(").append(this.startedAt).append(DurationUnitKt.shortName(this.timeSource.getUnit())).append(" + ").append(Duration.toString-impl(this.offset)).append(", ").append(this.timeSource).append(')').toString();
        }
    }
    public AbstractLongTimeSource(kotlin.time.DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        super();
        this.unit = unit;
        AbstractLongTimeSource.zero.2 anon = new AbstractLongTimeSource.zero.2(this);
        this.zero$delegate = LazyKt.lazy((Function0)anon);
    }

    public static final long access$adjustedRead(kotlin.time.AbstractLongTimeSource $this) {
        return $this.adjustedRead();
    }

    private final long adjustedRead() {
        return read -= zero;
    }

    private final long getZero() {
        return (Number)this.zero$delegate.getValue().longValue();
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    protected final kotlin.time.DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public kotlin.time.ComparableTimeMark markNow() {
        AbstractLongTimeSource.LongTimeMark longTimeMark = new AbstractLongTimeSource.LongTimeMark(adjustedRead(), obj2, this, Duration.Companion.getZERO-UwyO8pc(), obj5, 0);
        return (ComparableTimeMark)longTimeMark;
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public kotlin.time.TimeMark markNow() {
        return (TimeMark)markNow();
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    protected abstract long read();
}
