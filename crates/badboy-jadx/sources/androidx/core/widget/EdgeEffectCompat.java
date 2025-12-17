package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.EdgeEffect;

/* loaded from: classes5.dex */
public final class EdgeEffectCompat {

    private final EdgeEffect mEdgeEffect;

    static class Api21Impl {
        static void onPull(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
            edgeEffect.onPull(deltaDistance, displacement);
        }
    }

    private static class Api31Impl {
        public static EdgeEffect create(Context context, AttributeSet attrs) {
            try {
                EdgeEffect edgeEffect = new EdgeEffect(context, attrs);
                return edgeEffect;
                EdgeEffect edgeEffect2 = new EdgeEffect(context);
                return edgeEffect2;
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
                return 0;
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
            try {
                return edgeEffect.onPullDistance(deltaDistance, displacement);
                edgeEffect.onPull(deltaDistance, displacement);
                return 0;
            }
        }
    }
    @Deprecated
    public EdgeEffectCompat(Context context) {
        super();
        EdgeEffect edgeEffect = new EdgeEffect(context);
        this.mEdgeEffect = edgeEffect;
    }

    public static EdgeEffect create(Context context, AttributeSet attrs) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat.Api31Impl.create(context, attrs);
        }
        EdgeEffect edgeEffect = new EdgeEffect(context);
        return edgeEffect;
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat.Api31Impl.getDistance(edgeEffect);
        }
        return 0;
    }

    public static void onPull(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
        EdgeEffectCompat.Api21Impl.onPull(edgeEffect, deltaDistance, displacement);
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float deltaDistance, float displacement) {
        if (Build.VERSION.SDK_INT >= 31) {
            return EdgeEffectCompat.Api31Impl.onPullDistance(edgeEffect, deltaDistance, displacement);
        }
        EdgeEffectCompat.onPull(edgeEffect, deltaDistance, displacement);
        return deltaDistance;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int velocity) {
        this.mEdgeEffect.onAbsorb(velocity);
        return 1;
    }

    @Deprecated
    public boolean onPull(float deltaDistance) {
        this.mEdgeEffect.onPull(deltaDistance);
        return 1;
    }

    @Deprecated
    public boolean onPull(float deltaDistance, float displacement) {
        EdgeEffectCompat.onPull(this.mEdgeEffect, deltaDistance, displacement);
        return 1;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int width, int height) {
        this.mEdgeEffect.setSize(width, height);
    }
}
