package kotlin.time;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0086\u0002¢\u0006\u0004\u0008\u000c\u0010\nJ\u0008\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TestTimeSource extends kotlin.time.AbstractLongTimeSource {

    private long reading;
    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    private final void overflow-LRDsOJo(long duration) {
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("TestTimeSource will overflow if its reading ").append(this.reading).append(DurationUnitKt.shortName(getUnit())).append(" is advanced by ").append(Duration.toString-impl(duration)).append('.').toString());
        throw illegalStateException;
    }

    @Override // kotlin.time.AbstractLongTimeSource
    public final void plusAssign-LRDsOJo(long duration) {
        int $i$f$isSaturated;
        int cmp;
        int div-UwyO8pc;
        int reading;
        int minus-LRDsOJo;
        int i2;
        long long-impl;
        int i;
        final Object obj = this;
        final long l = duration;
        final long long-impl2 = Duration.toLong-impl(l, obj3);
        int i3 = 0;
        int i5 = 1;
        final long l3 = Long.MAX_VALUE;
        final int i9 = 0;
        $i$f$isSaturated = Long.compare(i8, l3) == 0 ? i2 : i9;
        if ($i$f$isSaturated == 0) {
            reading2 += long-impl2;
            minus-LRDsOJo = 0;
            if (Long.compare(reading, minus-LRDsOJo) >= 0 && Long.compare(reading, minus-LRDsOJo) < 0) {
                if (Long.compare(reading, minus-LRDsOJo) < 0) {
                    overflow-LRDsOJo(duration);
                }
            }
            obj.reading = div-UwyO8pc;
        } else {
            div-UwyO8pc = Duration.div-UwyO8pc(l, obj3);
            cmp = 0;
            if (Long.compare(i6, l3) == 0) {
            } else {
                i2 = i9;
            }
            if (i2 == 0) {
                reading = obj.reading;
                obj.plusAssign-LRDsOJo(div-UwyO8pc);
                obj.plusAssign-LRDsOJo(Duration.minus-LRDsOJo(l, obj3));
            } else {
                overflow-LRDsOJo(duration);
            }
        }
    }

    @Override // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }
}
