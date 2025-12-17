package androidx.compose.animation.core;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a*\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a,\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a@\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0007\"\u0004\u0008\u0000\u0010\u00022\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u001a3\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0011\"\u0004\u0008\u0000\u0010\u00022\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\u0008\u0016H\u0007\u001a3\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\u0008\u0000\u0010\u00022\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\u0008\u0016H\u0007\u001a=\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0018\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0001\u0010\u001a\u001a\u00020\u001b2\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00020\u0019\u0012\u0004\u0012\u00020\u00150\u0013¢\u0006\u0002\u0008\u0016H\u0007\u001a4\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001aH\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u001d\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008 \u0010!\u001a\u001e\u0010\"\u001a\u0008\u0012\u0004\u0012\u0002H\u00020#\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0002\u0010$\u001a\u00020\u001fH\u0007\u001a9\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H\u00020&\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0002\u0010'\u001a\u00020\u001b2\u0008\u0008\u0002\u0010(\u001a\u00020\u001b2\n\u0008\u0002\u0010)\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010*\u001a2\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\u00020,\"\u0004\u0008\u0000\u0010\u00022\u0008\u0008\u0002\u0010-\u001a\u00020\u001f2\u0008\u0008\u0002\u0010$\u001a\u00020\u001f2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007\u001a9\u00100\u001a\u0004\u0018\u0001H1\"\u0004\u0008\u0000\u0010\u0002\"\u0008\u0008\u0001\u00101*\u000202*\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H1032\u0008\u00104\u001a\u0004\u0018\u0001H\u0002H\u0002¢\u0006\u0002\u00105\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00066", d2 = {"delayed", "Landroidx/compose/animation/core/AnimationSpec;", "T", "animationSpec", "startDelayNanos", "", "infiniteRepeatable", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "animation", "Landroidx/compose/animation/core/DurationBasedAnimationSpec;", "repeatMode", "Landroidx/compose/animation/core/RepeatMode;", "initialStartOffset", "Landroidx/compose/animation/core/StartOffset;", "infiniteRepeatable-9IiC70o", "(Landroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "keyframes", "Landroidx/compose/animation/core/KeyframesSpec;", "init", "Lkotlin/Function1;", "Landroidx/compose/animation/core/KeyframesSpec$KeyframesSpecConfig;", "", "Lkotlin/ExtensionFunctionType;", "keyframesWithSpline", "Landroidx/compose/animation/core/KeyframesWithSplineSpec;", "Landroidx/compose/animation/core/KeyframesWithSplineSpec$KeyframesWithSplineSpecConfig;", "periodicBias", "", "repeatable", "Landroidx/compose/animation/core/RepeatableSpec;", "iterations", "", "repeatable-91I0pcU", "(ILandroidx/compose/animation/core/DurationBasedAnimationSpec;Landroidx/compose/animation/core/RepeatMode;J)Landroidx/compose/animation/core/RepeatableSpec;", "snap", "Landroidx/compose/animation/core/SnapSpec;", "delayMillis", "spring", "Landroidx/compose/animation/core/SpringSpec;", "dampingRatio", "stiffness", "visibilityThreshold", "(FFLjava/lang/Object;)Landroidx/compose/animation/core/SpringSpec;", "tween", "Landroidx/compose/animation/core/TweenSpec;", "durationMillis", "easing", "Landroidx/compose/animation/core/Easing;", "convert", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/TwoWayConverter;", "data", "(Landroidx/compose/animation/core/TwoWayConverter;Ljava/lang/Object;)Landroidx/compose/animation/core/AnimationVector;", "animation-core_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AnimationSpecKt {
    public static final androidx.compose.animation.core.AnimationVector access$convert(androidx.compose.animation.core.TwoWayConverter $receiver, Object data) {
        return AnimationSpecKt.convert($receiver, data);
    }

    private static final <T, V extends androidx.compose.animation.core.AnimationVector> V convert(androidx.compose.animation.core.TwoWayConverter<T, V> $this$convert, T data) {
        if (data == null) {
            return 0;
        }
        return (AnimationVector)$this$convert.getConvertToVector().invoke(data);
    }

    public static final <T> androidx.compose.animation.core.AnimationSpec<T> delayed(androidx.compose.animation.core.AnimationSpec<T> animationSpec, long startDelayNanos) {
        StartDelayAnimationSpec startDelayAnimationSpec = new StartDelayAnimationSpec(animationSpec, startDelayNanos, obj3);
        return (AnimationSpec)startDelayAnimationSpec;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the infinite repeatable function that accepts start offset.")
    public static final androidx.compose.animation.core.InfiniteRepeatableSpec infiniteRepeatable(androidx.compose.animation.core.DurationBasedAnimationSpec animation, androidx.compose.animation.core.RepeatMode repeatMode) {
        int i3 = 0;
        InfiniteRepeatableSpec infiniteRepeatableSpec = new InfiniteRepeatableSpec(animation, repeatMode, StartOffset.constructor-impl$default(i3, i3, 2, 0), obj4, 0);
        return infiniteRepeatableSpec;
    }

    public static androidx.compose.animation.core.InfiniteRepeatableSpec infiniteRepeatable$default(androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, int i3, Object object4) {
        androidx.compose.animation.core.RepeatMode obj1;
        if (i3 &= 2 != 0) {
            obj1 = RepeatMode.Restart;
        }
        return AnimationSpecKt.infiniteRepeatable(durationBasedAnimationSpec, obj1);
    }

    public static final <T> androidx.compose.animation.core.InfiniteRepeatableSpec<T> infiniteRepeatable-9IiC70o(androidx.compose.animation.core.DurationBasedAnimationSpec<T> animation, androidx.compose.animation.core.RepeatMode repeatMode, long initialStartOffset) {
        InfiniteRepeatableSpec infiniteRepeatableSpec = new InfiniteRepeatableSpec(animation, repeatMode, initialStartOffset, obj4, 0);
        return infiniteRepeatableSpec;
    }

    public static androidx.compose.animation.core.InfiniteRepeatableSpec infiniteRepeatable-9IiC70o$default(androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec, androidx.compose.animation.core.RepeatMode repeatMode2, long l3, int i4, Object object5) {
        androidx.compose.animation.core.RepeatMode obj1;
        long obj2;
        int obj3;
        int obj4;
        if (object5 & 2 != 0) {
            obj1 = RepeatMode.Restart;
        }
        if (object5 &= 4 != 0) {
            obj3 = 0;
            obj2 = StartOffset.constructor-impl$default(obj3, obj3, 2, 0);
        }
        return AnimationSpecKt.infiniteRepeatable-9IiC70o(durationBasedAnimationSpec, obj1, obj2);
    }

    public static final <T> androidx.compose.animation.core.KeyframesSpec<T> keyframes(Function1<? super androidx.compose.animation.core.KeyframesSpec.KeyframesSpecConfig<T>, Unit> init) {
        KeyframesSpec.KeyframesSpecConfig keyframesSpecConfig = new KeyframesSpec.KeyframesSpecConfig();
        init.invoke(keyframesSpecConfig);
        KeyframesSpec keyframesSpec = new KeyframesSpec(keyframesSpecConfig);
        return keyframesSpec;
    }

    public static final <T> androidx.compose.animation.core.KeyframesWithSplineSpec<T> keyframesWithSpline(float periodicBias, Function1<? super androidx.compose.animation.core.KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T>, Unit> init) {
        KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig keyframesWithSplineSpecConfig = new KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig();
        init.invoke(keyframesWithSplineSpecConfig);
        KeyframesWithSplineSpec keyframesWithSplineSpec = new KeyframesWithSplineSpec(keyframesWithSplineSpecConfig, periodicBias);
        return keyframesWithSplineSpec;
    }

    public static final <T> androidx.compose.animation.core.KeyframesWithSplineSpec<T> keyframesWithSpline(Function1<? super androidx.compose.animation.core.KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig<T>, Unit> init) {
        KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig keyframesWithSplineSpecConfig = new KeyframesWithSplineSpec.KeyframesWithSplineSpecConfig();
        init.invoke(keyframesWithSplineSpecConfig);
        KeyframesWithSplineSpec keyframesWithSplineSpec = new KeyframesWithSplineSpec(keyframesWithSplineSpecConfig);
        return keyframesWithSplineSpec;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This method has been deprecated in favor of the repeatable function that accepts start offset.")
    public static final androidx.compose.animation.core.RepeatableSpec repeatable(int iterations, androidx.compose.animation.core.DurationBasedAnimationSpec animation, androidx.compose.animation.core.RepeatMode repeatMode) {
        int i4 = 0;
        RepeatableSpec repeatableSpec = new RepeatableSpec(iterations, animation, repeatMode, StartOffset.constructor-impl$default(i4, i4, 2, 0), obj5, 0);
        return repeatableSpec;
    }

    public static androidx.compose.animation.core.RepeatableSpec repeatable$default(int i, androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, int i4, Object object5) {
        androidx.compose.animation.core.RepeatMode obj2;
        if (i4 &= 4 != 0) {
            obj2 = RepeatMode.Restart;
        }
        return AnimationSpecKt.repeatable(i, durationBasedAnimationSpec2, obj2);
    }

    public static final <T> androidx.compose.animation.core.RepeatableSpec<T> repeatable-91I0pcU(int iterations, androidx.compose.animation.core.DurationBasedAnimationSpec<T> animation, androidx.compose.animation.core.RepeatMode repeatMode, long initialStartOffset) {
        RepeatableSpec repeatableSpec = new RepeatableSpec(iterations, animation, repeatMode, initialStartOffset, obj5, 0);
        return repeatableSpec;
    }

    public static androidx.compose.animation.core.RepeatableSpec repeatable-91I0pcU$default(int i, androidx.compose.animation.core.DurationBasedAnimationSpec durationBasedAnimationSpec2, androidx.compose.animation.core.RepeatMode repeatMode3, long l4, int i5, Object object6) {
        androidx.compose.animation.core.RepeatMode obj2;
        long obj3;
        int obj4;
        int obj5;
        if (object6 & 4 != 0) {
            obj2 = RepeatMode.Restart;
        }
        if (object6 &= 8 != 0) {
            obj5 = 0;
            obj3 = StartOffset.constructor-impl$default(obj5, obj5, 2, 0);
        }
        return AnimationSpecKt.repeatable-91I0pcU(i, durationBasedAnimationSpec2, obj2, obj3);
    }

    public static final <T> androidx.compose.animation.core.SnapSpec<T> snap(int delayMillis) {
        SnapSpec snapSpec = new SnapSpec(delayMillis);
        return snapSpec;
    }

    public static androidx.compose.animation.core.SnapSpec snap$default(int i, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return AnimationSpecKt.snap(obj0);
    }

    public static final <T> androidx.compose.animation.core.SpringSpec<T> spring(float dampingRatio, float stiffness, T visibilityThreshold) {
        SpringSpec springSpec = new SpringSpec(dampingRatio, stiffness, visibilityThreshold);
        return springSpec;
    }

    public static androidx.compose.animation.core.SpringSpec spring$default(float f, float f2, Object object3, int i4, Object object5) {
        int obj0;
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj0 = 1065353216;
        }
        if (i4 & 2 != 0) {
            obj1 = 1153138688;
        }
        if (i4 &= 4 != 0) {
            obj2 = 0;
        }
        return AnimationSpecKt.spring(obj0, obj1, obj2);
    }

    public static final <T> androidx.compose.animation.core.TweenSpec<T> tween(int durationMillis, int delayMillis, androidx.compose.animation.core.Easing easing) {
        TweenSpec tweenSpec = new TweenSpec(durationMillis, delayMillis, easing);
        return tweenSpec;
    }

    public static androidx.compose.animation.core.TweenSpec tween$default(int i, int i2, androidx.compose.animation.core.Easing easing3, int i4, Object object5) {
        int obj0;
        int obj1;
        androidx.compose.animation.core.Easing obj2;
        if (i4 & 1 != 0) {
            obj0 = 300;
        }
        if (i4 & 2 != 0) {
            obj1 = 0;
        }
        if (i4 &= 4 != 0) {
            obj2 = EasingKt.getFastOutSlowInEasing();
        }
        return AnimationSpecKt.tween(obj0, obj1, obj2);
    }
}
