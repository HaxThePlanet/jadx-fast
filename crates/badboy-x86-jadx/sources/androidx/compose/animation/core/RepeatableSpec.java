package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0008\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u0004H\u0016J,\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u001d0\u001c\"\u0008\u0008\u0001\u0010\u001d*\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u001d0 H\u0016R\u0017\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0019\u0010\n\u001a\u00020\u000bø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006!", d2 = {"Landroidx/compose/animation/core/RepeatableSpec;", "T", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "iterations", "", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "getIterations", "()I", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class RepeatableSpec<T>  implements androidx.compose.animation.core.FiniteAnimationSpec<T> {

    public static final int $stable;
    private final androidx.compose.animation.core.DurationBasedAnimationSpec<T> animation;
    private final long initialStartOffset;
    private final int iterations;
    private final androidx.compose.animation.core.RepeatMode repeatMode;
    static {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This constructor has been deprecated")
    public RepeatableSpec(int iterations, androidx.compose.animation.core.DurationBasedAnimationSpec animation, androidx.compose.animation.core.RepeatMode repeatMode) {
        final int i3 = 0;
        super(iterations, animation, repeatMode, StartOffset.constructor-impl$default(i3, i3, 2, 0), obj8, 0);
    }

    public RepeatableSpec(int i, androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.compose.animation.core.RepeatMode obj3;
        obj3 = i4 &= 4 != 0 ? RepeatMode.Restart : obj3;
        super(i, durationBasedAnimationSpec2, obj3);
    }

    private RepeatableSpec(int iterations, androidx.compose.animation.core.DurationBasedAnimationSpec<T> animation, androidx.compose.animation.core.RepeatMode repeatMode, long initialStartOffset) {
        super();
        this.iterations = iterations;
        this.animation = animation;
        this.repeatMode = repeatMode;
        this.initialStartOffset = initialStartOffset;
    }

    public RepeatableSpec(int i, androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, long l4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        androidx.compose.animation.core.RepeatMode repeatMode;
        long l;
        androidx.compose.animation.core.RepeatMode obj10;
        long obj11;
        int obj12;
        repeatMode = defaultConstructorMarker6 & 4 != 0 ? obj10 : repeatMode3;
        if (defaultConstructorMarker6 & 8 != 0) {
            obj12 = 0;
            l = obj11;
        } else {
            l = l4;
        }
        super(i, durationBasedAnimationSpec2, repeatMode, l, obj5, 0);
    }

    public RepeatableSpec(int i, androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, long l4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, durationBasedAnimationSpec2, repeatMode3, l4, defaultConstructorMarker5);
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public boolean equals(Object other) {
        int repeatMode;
        int i;
        int initialStartOffset2;
        long initialStartOffset;
        i = 0;
        if (other instanceof RepeatableSpec) {
            if (obj.iterations == this.iterations && Intrinsics.areEqual(obj2.animation, this.animation) && obj3.repeatMode == this.repeatMode && StartOffset.equals-impl0(obj4.initialStartOffset, obj3)) {
                if (Intrinsics.areEqual(obj2.animation, this.animation)) {
                    if (obj3.repeatMode == this.repeatMode) {
                        if (StartOffset.equals-impl0(obj4.initialStartOffset, obj3)) {
                            i = 1;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public final androidx.compose.animation.core.DurationBasedAnimationSpec<T> getAnimation() {
        return this.animation;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public final long getInitialStartOffset-Rmkjzm4() {
        return this.initialStartOffset;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public final int getIterations() {
        return this.iterations;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public final androidx.compose.animation.core.RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public int hashCode() {
        return i5 += i9;
    }

    @Override // androidx.compose.animation.core.FiniteAnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedFiniteAnimationSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        VectorizedRepeatableSpec vectorizedRepeatableSpec = new VectorizedRepeatableSpec(this.iterations, this.animation.vectorize(converter), this.repeatMode, this.initialStartOffset, obj5, 0);
        return (VectorizedFiniteAnimationSpec)vectorizedRepeatableSpec;
    }
}
