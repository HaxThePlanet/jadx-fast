package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008g\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00000\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0008H¦\u0002J\u0008\u0010\t\u001a\u00020\u0004H&J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0000H¦\u0002ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ\u0018\u0010\n\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bH¦\u0002¢\u0006\u0004\u0008\u0012\u0010\u0010\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u0013", d2 = {"Lkotlin/time/ComparableTimeMark;", "Lkotlin/time/TimeMark;", "", "compareTo", "", "other", "equals", "", "", "hashCode", "minus", "Lkotlin/time/Duration;", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface ComparableTimeMark extends kotlin.time.TimeMark, Comparable<kotlin.time.ComparableTimeMark> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static int compareTo(kotlin.time.ComparableTimeMark $this, kotlin.time.ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return Duration.compareTo-LRDsOJo($this.minus-UwyO8pc(other), obj1);
        }

        public static boolean hasNotPassedNow(kotlin.time.ComparableTimeMark $this) {
            return TimeMark.DefaultImpls.hasNotPassedNow((TimeMark)$this);
        }

        public static boolean hasPassedNow(kotlin.time.ComparableTimeMark $this) {
            return TimeMark.DefaultImpls.hasPassedNow((TimeMark)$this);
        }

        public static kotlin.time.ComparableTimeMark minus-LRDsOJo(kotlin.time.ComparableTimeMark $this, long duration) {
            return $this.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(duration));
        }
    }
    @Override // kotlin.time.TimeMark
    public abstract int compareTo(kotlin.time.ComparableTimeMark comparableTimeMark);

    @Override // kotlin.time.TimeMark
    public abstract boolean equals(Object object);

    @Override // kotlin.time.TimeMark
    public abstract int hashCode();

    @Override // kotlin.time.TimeMark
    public abstract kotlin.time.ComparableTimeMark minus-LRDsOJo(long l);

    @Override // kotlin.time.TimeMark
    public abstract long minus-UwyO8pc(kotlin.time.ComparableTimeMark comparableTimeMark);

    @Override // kotlin.time.TimeMark
    public abstract kotlin.time.ComparableTimeMark plus-LRDsOJo(long l);
}
