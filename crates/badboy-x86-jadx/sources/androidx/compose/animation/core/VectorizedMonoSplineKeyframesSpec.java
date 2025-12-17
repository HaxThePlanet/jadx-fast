package androidx.compose.animation.core;

import androidx.collection.IntList;
import androidx.collection.IntObjectMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\t\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0001\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B?\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0018\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\u000bH\u0002J-\u0010$\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J-\u0010+\u001a\u00028\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010*J%\u0010,\u001a\u00020-2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010(\u001a\u00028\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010.R\u0014\u0010\u000c\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0014\u0010\n\u001a\u00020\u000bX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R \u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u0012\u0010\u0015\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0014R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0014R\u0016\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001cX\u0082.¢\u0006\u0004\n\u0002\u0010\u001dR\u0010\u0010\u001e\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006/", d2 = {"Landroidx/compose/animation/core/VectorizedMonoSplineKeyframesSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDurationBasedAnimationSpec;", "timestamps", "Landroidx/collection/IntList;", "keyframes", "Landroidx/collection/IntObjectMap;", "Lkotlin/Pair;", "Landroidx/compose/animation/core/Easing;", "durationMillis", "", "delayMillis", "periodicBias", "", "(Landroidx/collection/IntList;Landroidx/collection/IntObjectMap;IIF)V", "getDelayMillis", "()I", "getDurationMillis", "lastInitialValue", "Landroidx/compose/animation/core/AnimationVector;", "lastTargetValue", "monoSpline", "Landroidx/compose/animation/core/MonoSpline;", "times", "", "valueVector", "values", "", "[[F", "velocityVector", "findEntryForTimeMillis", "timeMillis", "getEasedTimeFromIndex", "index", "getEasing", "getValueFromNanos", "playTimeNanos", "", "initialValue", "targetValue", "initialVelocity", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "init", "", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)V", "animation-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class VectorizedMonoSplineKeyframesSpec<V extends androidx.compose.animation.core.AnimationVector>  implements androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec<V> {

    public static final int $stable = 8;
    private final int delayMillis;
    private final int durationMillis;
    private final IntObjectMap<Pair<V, androidx.compose.animation.core.Easing>> keyframes;
    private V lastInitialValue;
    private V lastTargetValue;
    private androidx.compose.animation.core.MonoSpline monoSpline;
    private final float periodicBias;
    private float[] times;
    private final IntList timestamps;
    private V valueVector;
    private float[][] values;
    private V velocityVector;
    static {
        final int i = 8;
    }

    public VectorizedMonoSplineKeyframesSpec(IntList timestamps, IntObjectMap<Pair<V, androidx.compose.animation.core.Easing>> keyframes, int durationMillis, int delayMillis, float periodicBias) {
        super();
        this.timestamps = timestamps;
        this.keyframes = keyframes;
        this.durationMillis = durationMillis;
        this.delayMillis = delayMillis;
        this.periodicBias = periodicBias;
    }

    private final int findEntryForTimeMillis(int timeMillis) {
        int i;
        final int obj7 = IntListExtensionKt.binarySearch$default(this.timestamps, timeMillis, 0, 0, 6, 0);
        i = obj7 < -1 ? -i3 : obj7;
        return i;
    }

    private final float getEasedTimeFromIndex(int index, int timeMillis) {
        final int i = 0;
        int this_$iv = 1000;
        if (index >= _size--) {
            return f4 /= f;
        }
        int i4 = this.timestamps.get(index);
        if (timeMillis == i4) {
            return f5 /= f2;
        }
        int i8 = i5 - i4;
        return i12 /= f3;
    }

    private final androidx.compose.animation.core.Easing getEasing(int index) {
        Object linearEasing;
        linearEasing = this.keyframes.get(this.timestamps.get(index));
        if ((Pair)linearEasing != null) {
            if ((Easing)(Pair)linearEasing.getSecond() == null) {
                linearEasing = EasingKt.getLinearEasing();
            }
        } else {
        }
        return linearEasing;
    }

    private final void init(V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.AnimationVector valueVector;
        androidx.compose.animation.core.MonoSpline monoSpline;
        int monoSpline2;
        float[] fArr3;
        int size$animation_core_release;
        int times;
        int contains;
        float periodicBias;
        float[][] i3;
        float[][] binarySearch$default;
        int fArr2;
        int i;
        float[] fArr;
        int first;
        int i2;
        float f;
        final Object obj = this;
        final androidx.compose.animation.core.AnimationVector animationVector = initialValue;
        final Object obj2 = targetValue;
        monoSpline2 = 0;
        if (obj.valueVector == null) {
            obj.valueVector = AnimationVectorsKt.newInstance(animationVector);
            obj.velocityVector = AnimationVectorsKt.newInstance(initialVelocity);
            valueVector = obj.timestamps.getSize();
            fArr3 = new float[valueVector];
            size$animation_core_release = monoSpline2;
            while (size$animation_core_release < valueVector) {
                fArr3[size$animation_core_release] = f2 /= periodicBias;
                size$animation_core_release++;
            }
            obj.times = fArr3;
        }
        if (obj.monoSpline != null && Intrinsics.areEqual(obj.lastInitialValue, animationVector)) {
            if (Intrinsics.areEqual(obj.lastInitialValue, animationVector)) {
                if (!Intrinsics.areEqual(obj.lastTargetValue, obj2)) {
                    obj.lastInitialValue = animationVector;
                    obj.lastTargetValue = obj2;
                    size$animation_core_release = animationVector.getSize$animation_core_release();
                    String str2 = "values";
                    i3 = 0;
                    if (obj.values == null) {
                        contains = obj.timestamps.getSize();
                        binarySearch$default = new float[contains];
                        fArr2 = monoSpline2;
                        while (fArr2 < contains) {
                            i = obj.timestamps.get(fArr2);
                            if (i == 0) {
                            } else {
                            }
                            if (i == obj.getDurationMillis()) {
                            } else {
                            }
                            Object obj4 = obj.keyframes.get(i);
                            Intrinsics.checkNotNull(obj4);
                            i2 = monoSpline2;
                            while (i2 < size$animation_core_release) {
                                new float[size$animation_core_release][i2] = (AnimationVector)(Pair)obj4.getFirst().get$animation_core_release(i2);
                                i2++;
                            }
                            binarySearch$default[fArr2] = fArr;
                            fArr2++;
                            fArr[i2] = first.get$animation_core_release(i2);
                            i2++;
                            if (!obj.keyframes.contains(i)) {
                            } else {
                            }
                            Object obj5 = obj.keyframes.get(i);
                            Intrinsics.checkNotNull(obj5);
                            i2 = monoSpline2;
                            while (i2 < size$animation_core_release) {
                                new float[size$animation_core_release][i2] = (AnimationVector)(Pair)obj5.getFirst().get$animation_core_release(i2);
                                i2++;
                            }
                            fArr[i2] = first.get$animation_core_release(i2);
                            i2++;
                            first = monoSpline2;
                            while (first < size$animation_core_release) {
                                new float[size$animation_core_release][first] = obj2.get$animation_core_release(first);
                                first++;
                            }
                            fArr[first] = obj2.get$animation_core_release(first);
                            first++;
                            if (!obj.keyframes.contains(i)) {
                            } else {
                            }
                            Object obj3 = obj.keyframes.get(i);
                            Intrinsics.checkNotNull(obj3);
                            i2 = monoSpline2;
                            while (i2 < size$animation_core_release) {
                                new float[size$animation_core_release][i2] = (AnimationVector)(Pair)obj3.getFirst().get$animation_core_release(i2);
                                i2++;
                            }
                            fArr[i2] = first.get$animation_core_release(i2);
                            i2++;
                            first = monoSpline2;
                            while (first < size$animation_core_release) {
                                new float[size$animation_core_release][first] = animationVector.get$animation_core_release(first);
                                first++;
                            }
                            fArr[first] = animationVector.get$animation_core_release(first);
                            first++;
                        }
                        obj.values = binarySearch$default;
                    } else {
                        if (equal ^= 1 != 0 && !obj.keyframes.contains(monoSpline2) && obj.values == null) {
                            if (!obj.keyframes.contains(monoSpline2)) {
                                if (obj.values == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                                    contains = i3;
                                }
                                fArr2 = new float[size$animation_core_release];
                                i = monoSpline2;
                                while (i < size$animation_core_release) {
                                    fArr2[i] = animationVector.get$animation_core_release(i);
                                    i++;
                                }
                                contains[IntListExtensionKt.binarySearch$default(obj.timestamps, 0, 0, 0, 6, 0)] = fArr2;
                            }
                        }
                        if (equal2 ^= 1 != 0 && !obj.keyframes.contains(obj.getDurationMillis()) && obj.values == null) {
                            if (!obj.keyframes.contains(obj.getDurationMillis())) {
                                if (obj.values == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException(str2);
                                    contains = i3;
                                }
                                fArr2 = new float[size$animation_core_release];
                                while (monoSpline2 < size$animation_core_release) {
                                    fArr2[monoSpline2] = obj2.get$animation_core_release(monoSpline2);
                                    monoSpline2++;
                                }
                                contains[IntListExtensionKt.binarySearch$default(obj.timestamps, obj.getDurationMillis(), 0, 0, 6, 0)] = fArr2;
                            }
                        }
                    }
                    if (obj.times == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("times");
                        times = i3;
                    }
                    binarySearch$default = obj.values;
                    if (binarySearch$default == null) {
                        Intrinsics.throwUninitializedPropertyAccessException(str2);
                    } else {
                        i3 = binarySearch$default;
                    }
                    monoSpline2 = new MonoSpline(times, i3, obj.periodicBias);
                    obj.monoSpline = monoSpline2;
                }
            } else {
            }
        } else {
        }
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDelayMillis() {
        return this.delayMillis;
    }

    @Override // androidx.compose.animation.core.VectorizedDurationBasedAnimationSpec
    public int getDurationMillis() {
        return this.durationMillis;
    }

    public V getValueFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.MonoSpline monoSpline;
        int i;
        androidx.compose.animation.core.AnimationVector valueVector;
        int i4 = (int)clampPlayTime;
        if (this.keyframes.containsKey(i4)) {
            Object obj2 = this.keyframes.get(i4);
            Intrinsics.checkNotNull(obj2);
            return (AnimationVector)(Pair)obj2.getFirst();
        }
        if (i4 >= getDurationMillis()) {
            return initialVelocity;
        }
        if (i4 <= 0) {
            return targetValue;
        }
        init(targetValue, initialVelocity, obj14);
        int entryForTimeMillis = findEntryForTimeMillis(i4);
        i = 0;
        if (this.monoSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
            monoSpline = i;
        }
        final String str2 = "valueVector";
        if (this.valueVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            valueVector = i;
        }
        monoSpline.getPos(getEasedTimeFromIndex(entryForTimeMillis, i4), valueVector, entryForTimeMillis);
        androidx.compose.animation.core.AnimationVector valueVector2 = this.valueVector;
        if (valueVector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        } else {
            i = valueVector2;
        }
        return i;
    }

    public V getVelocityFromNanos(long playTimeNanos, V initialValue, V targetValue, V initialVelocity) {
        androidx.compose.animation.core.MonoSpline monoSpline;
        int i;
        androidx.compose.animation.core.AnimationVector velocityVector;
        int i4 = (int)clampPlayTime;
        if (i4 < 0) {
            return obj14;
        }
        init(targetValue, initialVelocity, obj14);
        final int entryForTimeMillis = findEntryForTimeMillis(i4);
        i = 0;
        if (this.monoSpline == null) {
            Intrinsics.throwUninitializedPropertyAccessException("monoSpline");
            monoSpline = i;
        }
        final String str2 = "velocityVector";
        if (this.velocityVector == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
            velocityVector = i;
        }
        monoSpline.getSlope(getEasedTimeFromIndex(entryForTimeMillis, i4), velocityVector, entryForTimeMillis);
        androidx.compose.animation.core.AnimationVector velocityVector2 = this.velocityVector;
        if (velocityVector2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str2);
        } else {
            i = velocityVector2;
        }
        return i;
    }
}
