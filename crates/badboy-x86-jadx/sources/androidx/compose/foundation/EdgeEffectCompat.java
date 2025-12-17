package androidx.compose.foundation;

import android.content.Context;
import android.os.Build.VERSION;
import android.widget.EdgeEffect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ\u0012\u0010\u000b\u001a\u00020\u000c*\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004J\u0012\u0010\u0012\u001a\u00020\u000c*\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0004R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0014", d2 = {"Landroidx/compose/foundation/EdgeEffectCompat;", "", "()V", "distanceCompat", "", "Landroid/widget/EdgeEffect;", "getDistanceCompat", "(Landroid/widget/EdgeEffect;)F", "create", "context", "Landroid/content/Context;", "onAbsorbCompat", "", "velocity", "", "onPullDistanceCompat", "deltaDistance", "displacement", "onReleaseWithOppositeDelta", "delta", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class EdgeEffectCompat {

    public static final int $stable;
    public static final androidx.compose.foundation.EdgeEffectCompat INSTANCE;
    static {
        EdgeEffectCompat edgeEffectCompat = new EdgeEffectCompat();
        EdgeEffectCompat.INSTANCE = edgeEffectCompat;
    }

    public final EdgeEffect create(Context context) {
        EdgeEffect glowEdgeEffectCompat;
        int i;
        if (Build.VERSION.SDK_INT >= 31) {
            glowEdgeEffectCompat = Api31Impl.INSTANCE.create(context, 0);
        } else {
            glowEdgeEffectCompat = new GlowEdgeEffectCompat(context);
        }
        return glowEdgeEffectCompat;
    }

    public final float getDistanceCompat(EdgeEffect $this$distanceCompat) {
        float distance;
        if (Build.VERSION.SDK_INT >= 31) {
            distance = Api31Impl.INSTANCE.getDistance($this$distanceCompat);
        } else {
            distance = 0;
        }
        return distance;
    }

    public final void onAbsorbCompat(EdgeEffect $this$onAbsorbCompat, int velocity) {
        if (Build.VERSION.SDK_INT >= 31) {
            $this$onAbsorbCompat.onAbsorb(velocity);
        }
        if ($this$onAbsorbCompat.isFinished()) {
            $this$onAbsorbCompat.onAbsorb(velocity);
        }
    }

    public final float onPullDistanceCompat(EdgeEffect $this$onPullDistanceCompat, float deltaDistance, float displacement) {
        if (Build.VERSION.SDK_INT >= 31) {
            return Api31Impl.INSTANCE.onPullDistance($this$onPullDistanceCompat, deltaDistance, displacement);
        }
        $this$onPullDistanceCompat.onPull(deltaDistance, displacement);
        return deltaDistance;
    }

    public final void onReleaseWithOppositeDelta(EdgeEffect $this$onReleaseWithOppositeDelta, float delta) {
        Object obj;
        if ($this$onReleaseWithOppositeDelta instanceof GlowEdgeEffectCompat) {
            (GlowEdgeEffectCompat)$this$onReleaseWithOppositeDelta.releaseWithOppositeDelta(delta);
        } else {
            $this$onReleaseWithOppositeDelta.onRelease();
        }
    }
}
