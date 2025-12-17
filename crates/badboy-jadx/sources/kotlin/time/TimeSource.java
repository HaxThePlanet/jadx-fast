package kotlin.time;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008g\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007", d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeSource {

    public static final kotlin.time.TimeSource.Companion Companion;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008g\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004", d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface WithComparableMarks extends kotlin.time.TimeSource {
        @Override // kotlin.time.TimeSource
        public abstract kotlin.time.ComparableTimeMark markNow();
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        static final kotlin.time.TimeSource.Companion $$INSTANCE;
        static {
            TimeSource.Companion companion = new TimeSource.Companion();
            TimeSource.Companion.$$INSTANCE = companion;
        }
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\n", d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Monotonic implements kotlin.time.TimeSource.WithComparableMarks {

        public static final kotlin.time.TimeSource.Monotonic INSTANCE;
        static {
            TimeSource.Monotonic monotonic = new TimeSource.Monotonic();
            TimeSource.Monotonic.INSTANCE = monotonic;
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
            return MonotonicTimeSource.INSTANCE.markNow-z9LOYto();
        }

        @Override // kotlin.time.TimeSource$WithComparableMarks
        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }
    }
    static {
        TimeSource.Companion = TimeSource.Companion.$$INSTANCE;
    }

    public abstract kotlin.time.TimeMark markNow();
}
