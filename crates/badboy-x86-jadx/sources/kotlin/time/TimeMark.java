package kotlin.time;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\u0008g\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\u0008\u001a\u00020\u0007H\u0016J\u0018\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\u0008\u000e\u0010\u000c\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u000f", d2 = {"Lkotlin/time/TimeMark;", "", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "()J", "hasNotPassedNow", "", "hasPassedNow", "minus", "duration", "minus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "plus", "plus-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeMark {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasNotPassedNow(kotlin.time.TimeMark $this) {
            return Duration.isNegative-impl($this.elapsedNow-UwyO8pc());
        }

        public static boolean hasPassedNow(kotlin.time.TimeMark $this) {
            return negative-impl ^= 1;
        }

        public static kotlin.time.TimeMark minus-LRDsOJo(kotlin.time.TimeMark $this, long duration) {
            return $this.plus-LRDsOJo(Duration.unaryMinus-UwyO8pc(duration));
        }

        public static kotlin.time.TimeMark plus-LRDsOJo(kotlin.time.TimeMark $this, long duration) {
            AdjustedTimeMark adjustedTimeMark = new AdjustedTimeMark($this, duration, obj4, 0);
            return (TimeMark)adjustedTimeMark;
        }
    }
    public abstract long elapsedNow-UwyO8pc();

    public abstract boolean hasNotPassedNow();

    public abstract boolean hasPassedNow();

    public abstract kotlin.time.TimeMark minus-LRDsOJo(long l);

    public abstract kotlin.time.TimeMark plus-LRDsOJo(long l);
}
