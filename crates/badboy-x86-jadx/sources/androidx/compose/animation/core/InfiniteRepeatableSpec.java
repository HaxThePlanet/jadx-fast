package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0008\u0017\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B'\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J,\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0008\u0008\u0001\u0010\u001a*\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u001a0\u001dH\u0016R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\u0008\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "T", "Landroidx/compose/animation/core/AnimationSpec;", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;)V", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAnimation", "()Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "getInitialStartOffset-Rmkjzm4", "()J", "J", "getRepeatMode", "()Landroidx/compose/animation/core/RepeatMode;", "equals", "", "other", "", "hashCode", "", "vectorize", "Landroidx/compose/animation/core/VectorizedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class InfiniteRepeatableSpec<T>  implements androidx.compose.animation.core.AnimationSpec<T> {

    public static final int $stable = 8;
    private final androidx.compose.animation.core.DurationBasedAnimationSpec<T> animation;
    private final long initialStartOffset;
    private final androidx.compose.animation.core.RepeatMode repeatMode;
    static {
        final int i = 8;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This constructor has been deprecated")
    public InfiniteRepeatableSpec(androidx.compose.animation.core.DurationBasedAnimationSpec animation, androidx.compose.animation.core.RepeatMode repeatMode) {
        final int i3 = 0;
        super(animation, repeatMode, StartOffset.constructor-impl$default(i3, i3, 2, 0), obj7, 0);
    }

    public InfiniteRepeatableSpec(androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        androidx.compose.animation.core.RepeatMode obj2;
        obj2 = i3 &= 2 != 0 ? RepeatMode.Restart : obj2;
        super(durationBasedAnimationSpec, obj2);
    }

    private InfiniteRepeatableSpec(androidx.compose.animation.core.DurationBasedAnimationSpec<T> animation, androidx.compose.animation.core.RepeatMode repeatMode, long initialStartOffset) {
        super();
        this.animation = animation;
        this.repeatMode = repeatMode;
        this.initialStartOffset = initialStartOffset;
    }

    public InfiniteRepeatableSpec(androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, long l3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        androidx.compose.animation.core.RepeatMode repeatMode;
        long l;
        androidx.compose.animation.core.RepeatMode obj8;
        long obj9;
        int obj10;
        repeatMode = defaultConstructorMarker5 & 2 != 0 ? obj8 : repeatMode2;
        if (defaultConstructorMarker5 & 4 != 0) {
            obj9 = 0;
            l = obj9;
        } else {
            l = l3;
        }
        super(durationBasedAnimationSpec, repeatMode, l, obj4, 0);
    }

    public InfiniteRepeatableSpec(androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, long l3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(durationBasedAnimationSpec, repeatMode2, l3, defaultConstructorMarker4);
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public boolean equals(Object other) {
        boolean repeatMode;
        int i;
        long initialStartOffset2;
        long initialStartOffset;
        i = 0;
        if (other instanceof InfiniteRepeatableSpec) {
            if (Intrinsics.areEqual(obj.animation, this.animation) && obj2.repeatMode == this.repeatMode && StartOffset.equals-impl0(obj3.initialStartOffset, obj3)) {
                if (obj2.repeatMode == this.repeatMode) {
                    if (StartOffset.equals-impl0(obj3.initialStartOffset, obj3)) {
                        i = 1;
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

    @Override // androidx.compose.animation.core.AnimationSpec
    public final long getInitialStartOffset-Rmkjzm4() {
        return this.initialStartOffset;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public final androidx.compose.animation.core.RepeatMode getRepeatMode() {
        return this.repeatMode;
    }

    @Override // androidx.compose.animation.core.AnimationSpec
    public int hashCode() {
        return i4 += i7;
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedAnimationSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        VectorizedInfiniteRepeatableSpec vectorizedInfiniteRepeatableSpec = new VectorizedInfiniteRepeatableSpec(this.animation.vectorize(converter), this.repeatMode, this.initialStartOffset, obj4, 0);
        return (VectorizedAnimationSpec)vectorizedInfiniteRepeatableSpec;
    }
}
