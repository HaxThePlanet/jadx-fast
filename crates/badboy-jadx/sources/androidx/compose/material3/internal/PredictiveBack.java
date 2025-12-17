package androidx.compose.material3.internal;

import androidx.compose.animation.core.Easing;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008À\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0002\u0008\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/material3/internal/PredictiveBack;", "", "()V", "transform", "", "progress", "transform$material3_release", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PredictiveBack {

    public static final int $stable;
    public static final androidx.compose.material3.internal.PredictiveBack INSTANCE;
    static {
        PredictiveBack predictiveBack = new PredictiveBack();
        PredictiveBack.INSTANCE = predictiveBack;
    }

    public final float transform$material3_release(float progress) {
        return PredictiveBack_androidKt.access$getPredictiveBackEasing$p().transform(progress);
    }
}
