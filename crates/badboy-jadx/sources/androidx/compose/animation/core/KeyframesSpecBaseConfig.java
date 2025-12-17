package androidx.compose.animation.core;

import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u000e\u0008\u0001\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u0004B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0014\u001a\u00028\u00012\u0006\u0010\u0015\u001a\u00028\u0000H ¢\u0006\u0004\u0008\u0016\u0010\u0017J\u001c\u0010\u0018\u001a\u00028\u0001*\u00028\u00002\u0008\u0008\u0001\u0010\u0019\u001a\u00020\u0007H\u0096\u0004¢\u0006\u0002\u0010\u001aJ\u001c\u0010\u001b\u001a\u00028\u0001*\u00028\u00002\u0008\u0008\u0001\u0010\u001c\u001a\u00020\u001dH\u0096\u0004¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00028\u0001*\u00028\u00012\u0006\u0010 \u001a\u00020!H\u0086\u0004¢\u0006\u0002\u0010\"R(\u0010\u0008\u001a\u00020\u00072\u0008\u0008\u0001\u0010\u0006\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR(\u0010\r\u001a\u00020\u00072\u0008\u0008\u0001\u0010\u0006\u001a\u00020\u00078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\n\"\u0004\u0008\u000f\u0010\u000cR\u001a\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00010\u0011X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\u0082\u0001\u0002#$¨\u0006%", d2 = {"Landroidx/compose/animation/core/KeyframesSpecBaseConfig;", "T", "E", "Landroidx/compose/animation/core/KeyframeBaseEntity;", "", "()V", "<set-?>", "", "delayMillis", "getDelayMillis", "()I", "setDelayMillis", "(I)V", "durationMillis", "getDurationMillis", "setDurationMillis", "keyframes", "Landroidx/collection/MutableIntObjectMap;", "getKeyframes$animation_core_release", "()Landroidx/collection/MutableIntObjectMap;", "createEntityFor", "value", "createEntityFor$animation_core_release", "(Ljava/lang/Object;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "at", "timeStamp", "(Ljava/lang/Object;I)Landroidx/compose/animation/core/KeyframeBaseEntity;", "atFraction", "fraction", "", "(Ljava/lang/Object;F)Landroidx/compose/animation/core/KeyframeBaseEntity;", "using", "easing", "Landroidx/compose/animation/core/Easing;", "(Landroidx/compose/animation/core/KeyframeBaseEntity;Landroidx/compose/animation/core/Easing;)Landroidx/compose/animation/core/KeyframeBaseEntity;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class KeyframesSpecBaseConfig<T, E extends androidx.compose.animation.core.KeyframeBaseEntity<T>>  {

    public static final int $stable = 8;
    private int delayMillis;
    private int durationMillis;
    private final MutableIntObjectMap<E> keyframes;
    static {
        final int i = 8;
    }

    private KeyframesSpecBaseConfig() {
        super();
        this.durationMillis = 300;
        this.keyframes = IntObjectMapKt.mutableIntObjectMapOf();
    }

    public KeyframesSpecBaseConfig(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public E at(T $this$at, int timeStamp) {
        final androidx.compose.animation.core.KeyframeBaseEntity entityFor$animation_core_release = createEntityFor$animation_core_release($this$at);
        this.keyframes.set(timeStamp, entityFor$animation_core_release);
        return entityFor$animation_core_release;
    }

    public E atFraction(T $this$atFraction, float fraction) {
        final int i2 = 0;
        return at($this$atFraction, Math.round(f *= fraction));
    }

    public abstract E createEntityFor$animation_core_release(T t);

    public final int getDelayMillis() {
        return this.delayMillis;
    }

    public final int getDurationMillis() {
        return this.durationMillis;
    }

    public final MutableIntObjectMap<E> getKeyframes$animation_core_release() {
        return this.keyframes;
    }

    public final void setDelayMillis(int <set-?>) {
        this.delayMillis = <set-?>;
    }

    public final void setDurationMillis(int <set-?>) {
        this.durationMillis = <set-?>;
    }

    public final E using(E $this$using, androidx.compose.animation.core.Easing easing) {
        $this$using.setEasing$animation_core_release(easing);
        return $this$using;
    }
}
