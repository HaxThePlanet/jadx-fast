package kotlin.time;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000e\n\u0000\u0008Á\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0004\u0008\n\u0010\u000bJ\u001d\u0010\u000c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\u0008\u000f\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u0006H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0008\u0010\u0016\u001a\u00020\u0004H\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u0019", d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "()V", "zero", "", "adjustReading", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "timeMark", "duration", "Lkotlin/time/Duration;", "adjustReading-6QKq23U", "(JJ)J", "differenceBetween", "one", "another", "differenceBetween-fRLX17w", "elapsedFrom", "elapsedFrom-6eNON_k", "(J)J", "markNow", "markNow-z9LOYto", "()J", "read", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class MonotonicTimeSource implements kotlin.time.TimeSource.WithComparableMarks {

    public static final kotlin.time.MonotonicTimeSource INSTANCE;
    private static final long zero;
    static {
        MonotonicTimeSource monotonicTimeSource = new MonotonicTimeSource();
        MonotonicTimeSource.INSTANCE = monotonicTimeSource;
        MonotonicTimeSource.zero = System.nanoTime();
    }

    private final long read() {
        return nanoTime -= zero;
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public final long adjustReading-6QKq23U(long timeMark, long duration) {
        return TimeSource.Monotonic.ValueTimeMark.constructor-impl(LongSaturatedMathKt.saturatingAdd-NuflL3o(timeMark, duration, DurationUnit.NANOSECONDS));
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public final long differenceBetween-fRLX17w(long one, long another) {
        return LongSaturatedMathKt.saturatingOriginsDiff(one, another, obj5);
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public final long elapsedFrom-6eNON_k(long timeMark) {
        return LongSaturatedMathKt.saturatingDiff(read(), obj1, timeMark);
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public kotlin.time.ComparableTimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.box-impl(markNow-z9LOYto());
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public kotlin.time.TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.box-impl(markNow-z9LOYto());
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public long markNow-z9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.constructor-impl(read());
    }

    @Override // kotlin.time.TimeSource$WithComparableMarks
    public String toString() {
        return "TimeSource(System.nanoTime())";
    }
}
