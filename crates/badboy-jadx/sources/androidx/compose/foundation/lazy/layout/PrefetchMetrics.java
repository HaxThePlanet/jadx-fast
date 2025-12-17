package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectLongMap;
import androidx.collection.ObjectLongMapKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J&\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0017H\u0080\u0008¢\u0006\u0002\u0008\u0018J&\u0010\u0019\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00012\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00140\u0017H\u0080\u0008¢\u0006\u0002\u0008\u001bR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001e\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0007R\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u000b¨\u0006\u001c", d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "", "()V", "<set-?>", "", "averageCompositionTimeNanos", "getAverageCompositionTimeNanos", "()J", "averageCompositionTimeNanosByContentType", "Landroidx/collection/MutableObjectLongMap;", "getAverageCompositionTimeNanosByContentType", "()Landroidx/collection/MutableObjectLongMap;", "averageMeasureTimeNanos", "getAverageMeasureTimeNanos", "averageMeasureTimeNanosByContentType", "getAverageMeasureTimeNanosByContentType", "calculateAverageTime", "new", "current", "recordCompositionTiming", "", "contentType", "doComposition", "Lkotlin/Function0;", "recordCompositionTiming$foundation_release", "recordMeasureTiming", "doMeasure", "recordMeasureTiming$foundation_release", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PrefetchMetrics {

    public static final int $stable = 8;
    private long averageCompositionTimeNanos;
    private final MutableObjectLongMap<Object> averageCompositionTimeNanosByContentType;
    private long averageMeasureTimeNanos;
    private final MutableObjectLongMap<Object> averageMeasureTimeNanosByContentType;
    static {
        final int i = 8;
    }

    public PrefetchMetrics() {
        super();
        this.averageCompositionTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();
        this.averageMeasureTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();
    }

    public static final long access$calculateAverageTime(androidx.compose.foundation.lazy.layout.PrefetchMetrics $this, long new, long current) {
        return $this.calculateAverageTime(new, current);
    }

    public static final void access$setAverageCompositionTimeNanos$p(androidx.compose.foundation.lazy.layout.PrefetchMetrics $this, long <set-?>) {
        $this.averageCompositionTimeNanos = <set-?>;
    }

    public static final void access$setAverageMeasureTimeNanos$p(androidx.compose.foundation.lazy.layout.PrefetchMetrics $this, long <set-?>) {
        $this.averageMeasureTimeNanos = <set-?>;
    }

    private final long calculateAverageTime(long new, long current) {
        int cmp;
        int i;
        long l;
        if (Long.compare(obj9, i2) == 0) {
            i = new;
        } else {
            long l2 = (long)i3;
            i5 += cmp;
        }
        return i;
    }

    public final long getAverageCompositionTimeNanos() {
        return this.averageCompositionTimeNanos;
    }

    public final MutableObjectLongMap<Object> getAverageCompositionTimeNanosByContentType() {
        return this.averageCompositionTimeNanosByContentType;
    }

    public final long getAverageMeasureTimeNanos() {
        return this.averageMeasureTimeNanos;
    }

    public final MutableObjectLongMap<Object> getAverageMeasureTimeNanosByContentType() {
        return this.averageMeasureTimeNanosByContentType;
    }

    public final void recordCompositionTiming$foundation_release(Object contentType, Function0<Unit> doComposition) {
        int i;
        long nanoTime;
        MutableObjectLongMap averageCompositionTimeNanosByContentType;
        long orDefault;
        long l;
        final int i2 = 0;
        i = 0;
        doComposition.invoke();
        nanoTime2 -= nanoTime;
        if (contentType != null) {
            i = contentType;
            nanoTime = 0;
            getAverageCompositionTimeNanosByContentType().set(contentType, PrefetchMetrics.access$calculateAverageTime(this, i3, obj5));
        }
        PrefetchMetrics.access$setAverageCompositionTimeNanos$p(this, PrefetchMetrics.access$calculateAverageTime(this, i3, obj5));
    }

    public final void recordMeasureTiming$foundation_release(Object contentType, Function0<Unit> doMeasure) {
        int i;
        long nanoTime;
        MutableObjectLongMap averageMeasureTimeNanosByContentType;
        long orDefault;
        long l;
        final int i2 = 0;
        i = 0;
        doMeasure.invoke();
        nanoTime2 -= nanoTime;
        if (contentType != null) {
            i = contentType;
            nanoTime = 0;
            getAverageMeasureTimeNanosByContentType().set(contentType, PrefetchMetrics.access$calculateAverageTime(this, i3, obj5));
        }
        PrefetchMetrics.access$setAverageMeasureTimeNanos$p(this, PrefetchMetrics.access$calculateAverageTime(this, i3, obj5));
    }
}
