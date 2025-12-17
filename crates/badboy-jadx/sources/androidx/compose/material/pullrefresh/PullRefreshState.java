package androidx.compose.material.pullrefresh;

import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\n\n\u0002\u0010\u000b\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008\u0007\u0018\u00002\u00020\u0001B3\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\tH\u0002J\u0008\u00108\u001a\u00020\tH\u0002J\u0015\u00109\u001a\u00020\t2\u0006\u0010:\u001a\u00020\tH\u0000¢\u0006\u0002\u0008;J\u0015\u0010<\u001a\u00020\t2\u0006\u0010=\u001a\u00020\tH\u0000¢\u0006\u0002\u0008>J\u0015\u0010?\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u0014H\u0000¢\u0006\u0002\u0008@J\u0015\u0010A\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\tH\u0000¢\u0006\u0002\u0008BJ\u0015\u0010C\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0000¢\u0006\u0002\u0008DR+\u0010\r\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011R+\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000c\u001a\u00020\u00148B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001a\u0010\u001b\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R+\u0010\u001c\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001f\u0010\u0013\u001a\u0004\u0008\u001d\u0010\u000f\"\u0004\u0008\u001e\u0010\u0011R+\u0010 \u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008#\u0010\u0013\u001a\u0004\u0008!\u0010\u000f\"\u0004\u0008\"\u0010\u0011R\u001b\u0010$\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008&\u0010'\u001a\u0004\u0008%\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010(\u001a\u00020\t2\u0006\u0010\u000c\u001a\u00020\t8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008+\u0010\u0013\u001a\u0004\u0008)\u0010\u000f\"\u0004\u0008*\u0010\u0011R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008/\u0010\u000fR\u0011\u00100\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u00081\u0010\u000fR\u0014\u00102\u001a\u00020\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00083\u0010\u0017R\u0014\u0010\n\u001a\u00020\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00084\u0010\u000f¨\u0006E", d2 = {"Landroidx/compose/material/pullrefresh/PullRefreshState;", "", "animationScope", "Lkotlinx/coroutines/CoroutineScope;", "onRefreshState", "Landroidx/compose/runtime/State;", "Lkotlin/Function0;", "", "refreshingOffset", "", "threshold", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/State;FF)V", "<set-?>", "_position", "get_position", "()F", "set_position", "(F)V", "_position$delegate", "Landroidx/compose/runtime/MutableFloatState;", "", "_refreshing", "get_refreshing", "()Z", "set_refreshing", "(Z)V", "_refreshing$delegate", "Landroidx/compose/runtime/MutableState;", "_refreshingOffset", "get_refreshingOffset", "set_refreshingOffset", "_refreshingOffset$delegate", "_threshold", "get_threshold", "set_threshold", "_threshold$delegate", "adjustedDistancePulled", "getAdjustedDistancePulled", "adjustedDistancePulled$delegate", "Landroidx/compose/runtime/State;", "distancePulled", "getDistancePulled", "setDistancePulled", "distancePulled$delegate", "mutatorMutex", "Landroidx/compose/foundation/MutatorMutex;", "position", "getPosition$material_release", "progress", "getProgress", "refreshing", "getRefreshing$material_release", "getThreshold$material_release", "animateIndicatorTo", "Lkotlinx/coroutines/Job;", "offset", "calculateIndicatorPosition", "onPull", "pullDelta", "onPull$material_release", "onRelease", "velocity", "onRelease$material_release", "setRefreshing", "setRefreshing$material_release", "setRefreshingOffset", "setRefreshingOffset$material_release", "setThreshold", "setThreshold$material_release", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PullRefreshState {

    public static final int $stable = 8;
    private final MutableFloatState _position$delegate;
    private final MutableState _refreshing$delegate;
    private final MutableFloatState _refreshingOffset$delegate;
    private final MutableFloatState _threshold$delegate;
    private final State adjustedDistancePulled$delegate;
    private final CoroutineScope animationScope;
    private final MutableFloatState distancePulled$delegate;
    private final MutatorMutex mutatorMutex;
    private final State<Function0<Unit>> onRefreshState;
    static {
        final int i = 8;
    }

    public PullRefreshState(CoroutineScope animationScope, State<? extends Function0<Unit>> onRefreshState, float refreshingOffset, float threshold) {
        super();
        this.animationScope = animationScope;
        this.onRefreshState = onRefreshState;
        PullRefreshState.adjustedDistancePulled.2 anon = new PullRefreshState.adjustedDistancePulled.2(this);
        this.adjustedDistancePulled$delegate = SnapshotStateKt.derivedStateOf((Function0)anon);
        int i3 = 0;
        this._refreshing$delegate = SnapshotStateKt.mutableStateOf$default(false, i3, 2, i3);
        int i2 = 0;
        this._position$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
        this.distancePulled$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(i2);
        this._threshold$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(threshold);
        this._refreshingOffset$delegate = PrimitiveSnapshotStateKt.mutableFloatStateOf(refreshingOffset);
        MutatorMutex mutatorMutex = new MutatorMutex();
        this.mutatorMutex = mutatorMutex;
    }

    public static final float access$getDistancePulled(androidx.compose.material.pullrefresh.PullRefreshState $this) {
        return $this.getDistancePulled();
    }

    public static final MutatorMutex access$getMutatorMutex$p(androidx.compose.material.pullrefresh.PullRefreshState $this) {
        return $this.mutatorMutex;
    }

    public static final float access$get_position(androidx.compose.material.pullrefresh.PullRefreshState $this) {
        return $this.get_position();
    }

    public static final void access$set_position(androidx.compose.material.pullrefresh.PullRefreshState $this, float <set-?>) {
        $this.set_position(<set-?>);
    }

    private final Job animateIndicatorTo(float offset) {
        final int i2 = 0;
        PullRefreshState.animateIndicatorTo.1 anon = new PullRefreshState.animateIndicatorTo.1(this, offset, i2);
        return BuildersKt.launch$default(this.animationScope, 0, i2, (Function2)anon, 3, 0);
    }

    private final float calculateIndicatorPosition() {
        int overshootPercent;
        int threshold$material_release;
        int i;
        int i2;
        int i4;
        int $this$fastCoerceAtLeast$iv$iv;
        int i3;
        int cmp;
        if (Float.compare(adjustedDistancePulled, threshold$material_release) <= 0) {
            overshootPercent = getAdjustedDistancePulled();
        } else {
            int i7 = 0;
            int i9 = 1073741824;
            int i13 = 0;
            if (Float.compare($this$fastCoerceAtLeast$iv$iv, i7) < 0) {
                $this$fastCoerceAtLeast$iv$iv = i7;
            }
            i3 = 0;
            if (Float.compare($this$fastCoerceAtLeast$iv$iv, i9) > 0) {
                $this$fastCoerceAtLeast$iv$iv = i9;
            }
            overshootPercent = i2;
        }
        return overshootPercent;
    }

    private final float getAdjustedDistancePulled() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.adjustedDistancePulled$delegate.getValue().floatValue();
    }

    private final float getDistancePulled() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this.distancePulled$delegate.getFloatValue();
    }

    private final float get_position() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this._position$delegate.getFloatValue();
    }

    private final boolean get_refreshing() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this._refreshing$delegate.getValue().booleanValue();
    }

    private final float get_refreshingOffset() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this._refreshingOffset$delegate.getFloatValue();
    }

    private final float get_threshold() {
        final int i = 0;
        final int i2 = 0;
        return (FloatState)this._threshold$delegate.getFloatValue();
    }

    private final void setDistancePulled(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.distancePulled$delegate.setFloatValue(<set-?>);
    }

    private final void set_position(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._position$delegate.setFloatValue(<set-?>);
    }

    private final void set_refreshing(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._refreshing$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void set_refreshingOffset(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._refreshingOffset$delegate.setFloatValue(<set-?>);
    }

    private final void set_threshold(float <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this._threshold$delegate.setFloatValue(<set-?>);
    }

    public final float getPosition$material_release() {
        return get_position();
    }

    public final float getProgress() {
        return adjustedDistancePulled /= threshold$material_release;
    }

    public final boolean getRefreshing$material_release() {
        return get_refreshing();
    }

    public final float getThreshold$material_release() {
        return get_threshold();
    }

    public final float onPull$material_release(float pullDelta) {
        int i2 = 0;
        if (get_refreshing()) {
            return i2;
        }
        float coerceAtLeast = RangesKt.coerceAtLeast(distancePulled += pullDelta, i2);
        setDistancePulled(coerceAtLeast);
        set_position(calculateIndicatorPosition());
        return coerceAtLeast - distancePulled2;
    }

    public final float onRelease$material_release(float velocity) {
        int value;
        int i;
        int i2;
        final int i3 = 0;
        if (getRefreshing$material_release()) {
            return i3;
        }
        if (Float.compare(adjustedDistancePulled, threshold$material_release) > 0) {
            (Function0)this.onRefreshState.getValue().invoke();
        }
        animateIndicatorTo(i3);
        i = Float.compare(distancePulled, i3) == 0 ? 1 : 0;
        i2 = i != 0 ? i3 : cmp2 < 0 ? i3 : velocity;
        setDistancePulled(i3);
        return i2;
    }

    public final void setRefreshing$material_release(boolean refreshing) {
        int z;
        set_refreshing(refreshing);
        setDistancePulled(0);
        if (get_refreshing() != refreshing && refreshing) {
            set_refreshing(refreshing);
            setDistancePulled(0);
            if (refreshing) {
                z = get_refreshingOffset();
            }
            animateIndicatorTo(z);
        }
    }

    public final void setRefreshingOffset$material_release(float refreshingOffset) {
        int refreshing$material_release;
        refreshing$material_release = Float.compare(f, refreshingOffset) == 0 ? 1 : 0;
        set_refreshingOffset(refreshingOffset);
        if (refreshing$material_release == 0 && getRefreshing$material_release()) {
            set_refreshingOffset(refreshingOffset);
            if (getRefreshing$material_release()) {
                animateIndicatorTo(refreshingOffset);
            }
        }
    }

    public final void setThreshold$material_release(float threshold) {
        set_threshold(threshold);
    }
}
