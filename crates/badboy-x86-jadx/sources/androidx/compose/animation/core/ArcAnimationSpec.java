package androidx.compose.animation.core;

import androidx.collection.IntListKt;
import androidx.collection.IntObjectMapKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B-\u0012\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\u0008\u0010\u0016\u001a\u00020\u0006H\u0016J,\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0008\u0008\u0001\u0010\u0019*\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\u00190\u001cH\u0016R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000cR\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\u0008\u0010\u0010\u000c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001d", d2 = {"Landroidx/compose/animation/core/ArcAnimationSpec;", "T", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "mode", "Landroidx/compose/animation/core/ArcMode;", "durationMillis", "", "delayMillis", "easing", "Landroidx/compose/animation/core/Easing;", "(IIILandroidx/compose/animation/core/Easing;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDelayMillis", "()I", "getDurationMillis", "getEasing", "()Landroidx/compose/animation/core/Easing;", "getMode--9T-Mq4", "I", "equals", "", "other", "", "hashCode", "vectorize", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "converter", "Landroidx/compose/animation/core/TwoWayConverter;", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ArcAnimationSpec<T>  implements androidx.compose.animation.core.DurationBasedAnimationSpec<T> {

    public static final int $stable;
    private final int delayMillis;
    private final int durationMillis;
    private final androidx.compose.animation.core.Easing easing;
    private final int mode;
    static {
    }

    private ArcAnimationSpec(int mode, int durationMillis, int delayMillis, androidx.compose.animation.core.Easing easing) {
        super();
        this.mode = mode;
        this.durationMillis = durationMillis;
        this.delayMillis = delayMillis;
        this.easing = easing;
    }

    public ArcAnimationSpec(int i, int i2, int i3, androidx.compose.animation.core.Easing easing4, int i5, DefaultConstructorMarker defaultConstructorMarker6) {
        int i6;
        int i7;
        int i4;
        androidx.compose.animation.core.Easing easing;
        int obj7;
        int obj8;
        int obj9;
        androidx.compose.animation.core.Easing obj10;
        if (i5 & 1 != 0) {
            i6 = obj7;
        } else {
            i6 = i;
        }
        i7 = i5 & 2 != 0 ? obj8 : i2;
        i4 = i5 & 4 != 0 ? obj9 : i3;
        if (i5 & 8 != 0) {
            easing = obj10;
        } else {
            easing = easing4;
        }
        super(i6, i7, i4, easing, 0);
    }

    public ArcAnimationSpec(int i, int i2, int i3, androidx.compose.animation.core.Easing easing4, DefaultConstructorMarker defaultConstructorMarker5) {
        super(i, i2, i3, easing4);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public boolean equals(Object other) {
        if (this == other) {
            return 1;
        }
        int i2 = 0;
        if (!other instanceof ArcAnimationSpec) {
            return i2;
        }
        if (!ArcMode.equals-impl0(this.mode, obj2.mode)) {
            return i2;
        }
        if (this.durationMillis != obj3.durationMillis) {
            return i2;
        }
        if (this.delayMillis != obj4.delayMillis) {
            return i2;
        }
        return Intrinsics.areEqual(this.easing, obj.easing);
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final int getDurationMillis() {
        return this.durationMillis;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final androidx.compose.animation.core.Easing getEasing() {
        return this.easing;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public final int getMode--9T-Mq4() {
        return this.mode;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public int hashCode() {
        return result2 += i6;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedAnimationSpec)vectorize(converter);
    }

    public <V extends androidx.compose.animation.core.AnimationVector> androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> vectorize(androidx.compose.animation.core.TwoWayConverter<T, V> converter) {
        VectorizedKeyframesSpec vectorizedKeyframesSpec = new VectorizedKeyframesSpec(IntListKt.intListOf(0, this.durationMillis), IntObjectMapKt.emptyIntObjectMap(), this.durationMillis, this.delayMillis, this.easing, this.mode, 0);
        return (VectorizedDurationBasedAnimationSpec)vectorizedKeyframesSpec;
    }

    @Override // androidx.compose.animation.core.DurationBasedAnimationSpec
    public androidx.compose.animation.core.VectorizedFiniteAnimationSpec vectorize(androidx.compose.animation.core.TwoWayConverter converter) {
        return (VectorizedFiniteAnimationSpec)vectorize(converter);
    }
}
