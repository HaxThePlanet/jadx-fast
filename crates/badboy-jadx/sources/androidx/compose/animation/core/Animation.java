package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008f\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J\u0015\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00020\u0006H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068fX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0012\u0010\t\u001a\u00020\nX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000bR\u0012\u0010\u000c\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000eR\u001e\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0019À\u0006\u0003", d2 = {"Landroidx/compose/animation/core/Animation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "durationNanos", "", "getDurationNanos", "()J", "isInfinite", "", "()Z", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "isFinishedFromNanos", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface Animation<T, V extends androidx.compose.animation.core.AnimationVector>  {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T, V extends androidx.compose.animation.core.AnimationVector> boolean isFinishedFromNanos(androidx.compose.animation.core.Animation<T, V> $this, long playTimeNanos) {
            return Animation.access$isFinishedFromNanos$jd($this, playTimeNanos);
        }
    }
    public static boolean access$isFinishedFromNanos$jd(androidx.compose.animation.core.Animation $this, long playTimeNanos) {
        return super.isFinishedFromNanos(playTimeNanos);
    }

    public abstract long getDurationNanos();

    public abstract T getTargetValue();

    public abstract androidx.compose.animation.core.TwoWayConverter<T, V> getTypeConverter();

    public abstract T getValueFromNanos(long l);

    public abstract V getVelocityVectorFromNanos(long l);

    public boolean isFinishedFromNanos(long playTimeNanos) {
        int i;
        i = Long.compare(playTimeNanos, durationNanos) >= 0 ? 1 : 0;
        return i;
    }

    public abstract boolean isInfinite();
}
