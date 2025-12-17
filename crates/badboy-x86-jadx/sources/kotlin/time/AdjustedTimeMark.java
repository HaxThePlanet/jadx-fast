package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\u0007J\u0018\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0004H\u0096\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0008\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0004\n\u0002\u0008!¨\u0006\u0011", d2 = {"Lkotlin/time/AdjustedTimeMark;", "Lkotlin/time/TimeMark;", "mark", "adjustment", "Lkotlin/time/Duration;", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAdjustment-UwyO8pc", "()J", "J", "getMark", "()Lkotlin/time/TimeMark;", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class AdjustedTimeMark implements kotlin.time.TimeMark {

    private final long adjustment;
    private final kotlin.time.TimeMark mark;
    private AdjustedTimeMark(kotlin.time.TimeMark mark, long adjustment) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        super();
        this.mark = mark;
        this.adjustment = adjustment;
    }

    public AdjustedTimeMark(kotlin.time.TimeMark timeMark, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(timeMark, l2, defaultConstructorMarker3);
    }

    @Override // kotlin.time.TimeMark
    public long elapsedNow-UwyO8pc() {
        return Duration.minus-LRDsOJo(this.mark.elapsedNow-UwyO8pc(), obj1);
    }

    @Override // kotlin.time.TimeMark
    public final long getAdjustment-UwyO8pc() {
        return this.adjustment;
    }

    @Override // kotlin.time.TimeMark
    public final kotlin.time.TimeMark getMark() {
        return this.mark;
    }

    @Override // kotlin.time.TimeMark
    public boolean hasNotPassedNow() {
        return TimeMark.DefaultImpls.hasNotPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    public boolean hasPassedNow() {
        return TimeMark.DefaultImpls.hasPassedNow(this);
    }

    @Override // kotlin.time.TimeMark
    public kotlin.time.TimeMark minus-LRDsOJo(long duration) {
        return TimeMark.DefaultImpls.minus-LRDsOJo(this, duration);
    }

    @Override // kotlin.time.TimeMark
    public kotlin.time.TimeMark plus-LRDsOJo(long duration) {
        AdjustedTimeMark adjustedTimeMark = new AdjustedTimeMark(this.mark, Duration.plus-LRDsOJo(this.adjustment, obj3), obj3, 0);
        return (TimeMark)adjustedTimeMark;
    }
}
