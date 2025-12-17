package androidx.compose.animation.core;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u0001*\u0008\u0008\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B!\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0010", d2 = {"Landroidx/compose/animation/core/AnimationResult;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "endState", "Landroidx/compose/animation/core/AnimationState;", "endReason", "Landroidx/compose/animation/core/AnimationEndReason;", "(Landroidx/compose/animation/core/AnimationState;Landroidx/compose/animation/core/AnimationEndReason;)V", "getEndReason", "()Landroidx/compose/animation/core/AnimationEndReason;", "getEndState", "()Landroidx/compose/animation/core/AnimationState;", "toString", "", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AnimationResult<T, V extends androidx.compose.animation.core.AnimationVector>  {

    public static final int $stable;
    private final androidx.compose.animation.core.AnimationEndReason endReason;
    private final androidx.compose.animation.core.AnimationState<T, V> endState;
    static {
    }

    public AnimationResult(androidx.compose.animation.core.AnimationState<T, V> endState, androidx.compose.animation.core.AnimationEndReason endReason) {
        super();
        this.endState = endState;
        this.endReason = endReason;
    }

    public final androidx.compose.animation.core.AnimationEndReason getEndReason() {
        return this.endReason;
    }

    public final androidx.compose.animation.core.AnimationState<T, V> getEndState() {
        return this.endState;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("AnimationResult(endReason=").append(this.endReason).append(", endState=").append(this.endState).append(')').toString();
    }
}
