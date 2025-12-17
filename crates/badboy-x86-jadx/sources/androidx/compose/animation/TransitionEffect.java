package androidx.compose.animation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001B\u0007\u0008\u0004¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X \u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0001\u0001\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/animation/TransitionEffect;", "", "()V", "key", "Landroidx/compose/animation/TransitionEffectKey;", "getKey$animation_release", "()Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/ContentScaleTransitionEffect;", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class TransitionEffect {

    public static final int $stable;
    static {
    }

    public TransitionEffect(DefaultConstructorMarker defaultConstructorMarker) {
        super();
    }

    public abstract androidx.compose.animation.TransitionEffectKey<?> getKey$animation_release();
}
