package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0001\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u001b\u0008\u0002\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0011\u001a\u00020\u000fH\u0096@¢\u0006\u0002\u0010\u0010J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0014R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\r¨\u0006\u0016", d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "()V", "anim", "Landroidx/compose/animation/core/Animatable;", "", "Landroidx/compose/animation/core/AnimationVector1D;", "(Landroidx/compose/animation/core/Animatable;)V", "distanceFraction", "getDistanceFraction", "()F", "isAnimating", "", "()Z", "animateToHidden", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "animateToThreshold", "snapTo", "targetValue", "(FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PullToRefreshStateImpl implements androidx.compose.material3.pulltorefresh.PullToRefreshState {

    public static final int $stable;
    public static final androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl.Companion Companion;
    private static final Saver<androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl, Float> Saver;
    private final Animatable<Float, AnimationVector1D> anim;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl$Companion;", "", "()V", "Saver", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/material3/pulltorefresh/PullToRefreshStateImpl;", "", "getSaver", "()Landroidx/compose/runtime/saveable/Saver;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final Saver<androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl, Float> getSaver() {
            return PullToRefreshStateImpl.access$getSaver$cp();
        }
    }
    static {
        PullToRefreshStateImpl.Companion companion = new PullToRefreshStateImpl.Companion(0);
        PullToRefreshStateImpl.Companion = companion;
        PullToRefreshStateImpl.Saver = SaverKt.Saver((Function2)PullToRefreshStateImpl.Companion.Saver.1.INSTANCE, (Function1)PullToRefreshStateImpl.Companion.Saver.2.INSTANCE);
    }

    public PullToRefreshStateImpl() {
        Animatable animatable = new Animatable(0f, VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), 0, 0, 12, 0);
        super(animatable);
    }

    private PullToRefreshStateImpl(Animatable<Float, AnimationVector1D> anim) {
        super();
        this.anim = anim;
    }

    public PullToRefreshStateImpl(Animatable animatable, DefaultConstructorMarker defaultConstructorMarker2) {
        super(animatable);
    }

    public static final Animatable access$getAnim$p(androidx.compose.material3.pulltorefresh.PullToRefreshStateImpl $this) {
        return $this.anim;
    }

    public static final Saver access$getSaver$cp() {
        return PullToRefreshStateImpl.Saver;
    }

    public Object animateToHidden(Continuation<? super Unit> $completion) {
        Object obj9 = Animatable.animateTo$default(this.anim, Boxing.boxFloat(0), 0, 0, 0, $completion, 14, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    public Object animateToThreshold(Continuation<? super Unit> $completion) {
        Object obj9 = Animatable.animateTo$default(this.anim, Boxing.boxFloat(1065353216), 0, 0, 0, $completion, 14, 0);
        if (obj9 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj9;
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public float getDistanceFraction() {
        return (Number)this.anim.getValue().floatValue();
    }

    @Override // androidx.compose.material3.pulltorefresh.PullToRefreshState
    public boolean isAnimating() {
        return this.anim.isRunning();
    }

    public Object snapTo(float targetValue, Continuation<? super Unit> $completion) {
        Object snapTo = this.anim.snapTo(Boxing.boxFloat(targetValue), $completion);
        if (snapTo == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return snapTo;
        }
        return Unit.INSTANCE;
    }
}
