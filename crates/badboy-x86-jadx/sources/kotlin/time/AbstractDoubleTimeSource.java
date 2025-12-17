package kotlin.time;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Deprecated(message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0002\u0008'\u0018\u00002\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000c", d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "", "DoubleTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractDoubleTimeSource implements kotlin.time.TimeSource.WithComparableMarks {

    private final kotlin.time.DurationUnit unit;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u001c", d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", "offset", "Lkotlin/time/Duration;", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class DoubleTimeMark implements kotlin.time.ComparableTimeMark {

        private final long offset;
        private final double startedAt;
        private final kotlin.time.AbstractDoubleTimeSource timeSource;
        private DoubleTimeMark(double startedAt, kotlin.time.AbstractDoubleTimeSource timeSource, long offset) {
            Intrinsics.checkNotNullParameter(offset, "timeSource");
            super();
            this.startedAt = startedAt;
            this.timeSource = offset;
            this.offset = obj5;
        }

        public DoubleTimeMark(double d, kotlin.time.AbstractDoubleTimeSource abstractDoubleTimeSource2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
            super(d, abstractDoubleTimeSource2, l3, defaultConstructorMarker4, obj5);
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
            return Duration.minus-LRDsOJo(DurationKt.toDuration(read -= startedAt, obj1), obj1);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object other) {
            int i;
            boolean equal;
            kotlin.time.AbstractDoubleTimeSource timeSource;
            long zERO-UwyO8pc;
            timeSource = obj2.timeSource;
            if (other instanceof AbstractDoubleTimeSource.DoubleTimeMark && Intrinsics.areEqual(this.timeSource, timeSource) && Duration.equals-impl0(minus-UwyO8pc((ComparableTimeMark)other), timeSource)) {
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
            return Duration.hashCode-impl(Duration.plus-LRDsOJo(DurationKt.toDuration(this.startedAt, obj1), obj1));
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
            boolean infinite-impl;
            kotlin.time.AbstractDoubleTimeSource timeSource;
            long plus-LRDsOJo;
            Intrinsics.checkNotNullParameter(other, "other");
            if (!other instanceof AbstractDoubleTimeSource.DoubleTimeMark) {
            } else {
                timeSource = obj.timeSource;
                if (!Intrinsics.areEqual(this.timeSource, timeSource)) {
                } else {
                    if (Duration.equals-impl0(this.offset, timeSource) && Duration.isInfinite-impl(this.offset)) {
                        if (Duration.isInfinite-impl(this.offset)) {
                            return Duration.Companion.getZERO-UwyO8pc();
                        }
                    }
                    long minus-LRDsOJo = Duration.minus-LRDsOJo(this.offset, timeSource);
                    long duration = DurationKt.toDuration(startedAt -= startedAt2, obj3);
                    if (Duration.equals-impl0(duration, obj3)) {
                        plus-LRDsOJo = Duration.Companion.getZERO-UwyO8pc();
                    } else {
                        plus-LRDsOJo = Duration.plus-LRDsOJo(duration, obj3);
                    }
                    return plus-LRDsOJo;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException offsetDiff = new IllegalArgumentException(stringBuilder.append("Subtracting or comparing time marks from different time sources is not possible: ").append(this).append(" and ").append(other).toString());
            throw offsetDiff;
        }

        @Override // kotlin.time.ComparableTimeMark
        public kotlin.time.ComparableTimeMark plus-LRDsOJo(long duration) {
            AbstractDoubleTimeSource.DoubleTimeMark doubleTimeMark = new AbstractDoubleTimeSource.DoubleTimeMark(this.startedAt, obj2, this.timeSource, Duration.plus-LRDsOJo(this.offset, obj5), obj5, 0);
            return (ComparableTimeMark)doubleTimeMark;
        }

        @Override // kotlin.time.ComparableTimeMark
        public kotlin.time.TimeMark plus-LRDsOJo(long duration) {
            return (TimeMark)plus-LRDsOJo(duration);
        }

        @Override // kotlin.time.ComparableTimeMark
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("DoubleTimeMark(").append(this.startedAt).append(DurationUnitKt.shortName(this.timeSource.getUnit())).append(" + ").append(Duration.toString-impl(this.offset)).append(", ").append(this.timeSource).append(')').toString();
        }
    }
    public AbstractDoubleTimeSource(kotlin.time.DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        super();
        this.unit = unit;
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    protected final kotlin.time.DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public kotlin.time.ComparableTimeMark markNow() {
        AbstractDoubleTimeSource.DoubleTimeMark doubleTimeMark = new AbstractDoubleTimeSource.DoubleTimeMark(read(), obj2, this, Duration.Companion.getZERO-UwyO8pc(), obj5, 0);
        return (ComparableTimeMark)doubleTimeMark;
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public kotlin.time.TimeMark markNow() {
        return (TimeMark)markNow();
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    protected abstract double read();
}
